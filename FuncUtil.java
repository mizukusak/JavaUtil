
public class FuncUtil {
	/**
	 * Stream 内での例外をラッピング(必ず Stream の外側で catch すること(e.getCause() で取得))
	 */
	public static <T, R> FunctionWrapper<T, R> wrapFunction(FunctionWrapper<T, R> f) {
		return f;
	}	
}

/*
How to use:
Stream.concat(Stream.of(folder), Stream.of(subFolders))
	.flatMap(FunctionWrapper.wrapFunction(deleteFolder -> {
		return Stream.of(deleteFolder.getMessages());
	}));

*/

