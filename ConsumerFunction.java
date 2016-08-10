import java.util.function.Function;

/**
 * Stream 内での例外をラッピング(必ず Stream の外側で catch すること)
 */
@FunctionalInterface
interface ConsumerFunction<T, R> extends Function<T, R> {

    R applyOrigin(T t) throws Exception;

	@Override
	default R apply(T t) {
		try {
			return applyOrigin(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	public static <T, R> ConsumerFunction<T, R> wrapFunction(ConsumerFunction<T, R> f) {
        return f;
    }
}



