public class InputStreamUtil {
  public static String toString(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (
				InputStreamReader isr = new InputStreamReader(inputStream);
				BufferedReader bis = new BufferedReader(isr);
		) {
			char[] buffer = new char[1024];
			int i = 0;
			while (-1 != (i = bis.read(buffer))) {
				sb.append(buffer, 0, i);
			}
			return sb.toString();
		}
	}

	public static byte[] toBytes(InputStream inputStream) throws IOException {
		try (
				BufferedInputStream bis = new BufferedInputStream(inputStream);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
		) {
			// write it to a byte[] using a buffer since we don't know the exact
			// image size
			byte[] buffer = new byte[1024];
			int i = 0;
			while (-1 != (i = bis.read(buffer))) {
				bos.write(buffer, 0, i);
			}
			byte[] data = bos.toByteArray();
			return data;
		}
	}
}
