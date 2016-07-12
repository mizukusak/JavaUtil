public class ListUtil {
	/**
	 * array を List に convert して返す
	 * @param array
	 * @return
	 */
	private <T> List<T> toList(T[] array) {
		return new ArrayList<T>(Arrays.asList(array));
	}

	/**
	 * 最後の要素を削除して元の List を返す
	 * @param list
	 * @return
	 */
	private <T> List<T> pop(List<T> list) {
		list.remove(list.size() - 1);
		return list;
	}
}
