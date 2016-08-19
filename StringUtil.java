public class StringUtil {
	public static <T> String join(String delimiter, T[] arr) {
		return String.join(delimiter, ArrayUtil.toStrList(arr));
	}
	
	/**
	 * 任意の文字を追加指定可能な trim
	 * @param val
	 * @param list
	 * @return
	 */
	public static String trim(String val, char[] list) {
		int len = val.length();
		int st = 0;

		while (st < len) {
			char c = val.charAt(st);
			if (c > ' ' && !ArrayUtil.in(list, c))
				break;
			st++;
		}
		while (st < len) {
			char c = val.charAt(len - 1);
			if (c > ' ' && !ArrayUtil.in(list, c))
				break;
			len--;
		}
		return ((st > 0) || (len < val.length())) ? val.substring(st, len) : val;
	}
}
