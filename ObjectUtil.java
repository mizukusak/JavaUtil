public class ObjectUtil {
	/**
	 * Object の property に再帰的に処理を施す
	 * @param obj
	 * @param func
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
    public static <T extends Object, U> T deepMap(T obj, Function<Object, Object> func) throws IllegalArgumentException, IllegalAccessException {
    	return _deepMap(obj, func, true);
    }

	/** {@link ObjectUtil#deepMap(T, Function)} */
    private static <T extends Object, U> T _deepMap(T obj, Function<Object, Object> func, boolean isValid) 
    		throws IllegalArgumentException, IllegalAccessException
    {
    	if (obj instanceof List<?>){
    		List<U> list = (List<U>) obj;
			int len = list.size();
    		for (int i = 0; i < len; i++) {
    			list.set(i, _deepMap(list.get(i), func, isValid));
    		}
    	}
    	else if (obj instanceof Map<?, ?>){
    		for (Entry<?, U> value : ((Map<?, U>) obj).entrySet()) {
    			value.setValue(_deepMap(value.getValue(), func, isValid));
    		}
    	}
    	else if(obj instanceof Object && isValid) {
    		Field[] fileds = obj.getClass().getDeclaredFields();
    		for (Field field : fileds) {
    			field.setAccessible(true);
    			if (Modifier.isFinal(field.getModifiers())) {
    				continue;
    			}
    			
				Object _deepMap = _deepMap(field.get(obj), func, field.getAnnotation(Valid.class) != null);
				field.set(obj, _deepMap);	
    		}
    	}
    	else {
    		return (T) func.apply(obj);
    	}
    	return obj;
    }

}

