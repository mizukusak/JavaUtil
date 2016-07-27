public class ArrayUtil {
  /**
	 * array に 値が含まれるか検査
	 * @param list
	 * @param val
	 * @return
	 */
	public static <T> boolean in(T[] list, T val) {
		for (T v : list) {
			if (v.equals(val)) {
				return true;
			}
		}
		return false;
	}	public static boolean in(char[] list, char val) {
		for (char v : list) {
			if (v == val) {
				return true;
			}
		}
		return false;
	}
	public static boolean in(int[] list, int val) {
		for (int v : list) {
			if (v == val) {
				return true;
			}
		}
		return false;
	}
}
