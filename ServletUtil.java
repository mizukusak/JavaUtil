public class ServletUtil {
	/**
	 * convert MultipartFile to File 
	 * @param multipartFile
	 * @return
	 */
	public static File getTempFile(MultipartFile multipartFile) {
	    CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) multipartFile;
	    FileItem fileItem = commonsMultipartFile.getFileItem();
	    DiskFileItem diskFileItem = (DiskFileItem) fileItem;
	    String absPath = diskFileItem.getStoreLocation().getAbsolutePath();
	    return new File(absPath);
	}
}
