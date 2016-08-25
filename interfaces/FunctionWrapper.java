/**
 * Stream 内での例外をラッピング(必ず Stream の外側で catch すること)
 */
@FunctionalInterface
public interface FunctionWrapper<T, R> extends Function<T, R> {

	R applyOrigin(T t) throws Exception;

	@Override
	default R apply(T t) {
		try {
			return applyOrigin(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

