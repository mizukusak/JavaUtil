public class ListUtil {
	/**
	 * 最後の要素を削除して元の List を返す
	 * @param list
	 * @return
	 */
	public static <T> List<T> pop(List<T> list) {
		list.remove(list.size() - 1);
		return list;
	}
}
