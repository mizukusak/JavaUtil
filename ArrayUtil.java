public class ArrayUtil {
	/**
	 * array を List にして返す
	 * @param array
	 * @return
	 */
	public static <T> List<T> toList(T[] array) {
		return Stream.of(array).collect(Collectors.toList());
	}

	/**
	 * array を List<String> にして返す
	 * @param array
	 * @return
	 */
	public static <T> List<String> toStrList(T[] array) {
		return Stream.of(array).map(v -> v.toString()).collect(Collectors.toList());
	}

	/**
	 * array に 値が含まれるか検査
	 * @param array
	 * @param val
	 * @return
	 */
	public static <T> boolean in(T[] array, T val) {
		return Stream.of(array).anyMatch(v -> v.equals(val));
	}
	public static boolean in(char[] array, char val) {
		return IntStream.range(0, array.length).anyMatch(i -> array[i] == val);
	}
	public static boolean in(int[] array, int val) {
		return IntStream.range(0, array.length).anyMatch(i -> array[i] == val);
	}
	public static boolean in(long[] array, long val) {
		return IntStream.range(0, array.length).anyMatch(i -> array[i] == val);
	}
}
