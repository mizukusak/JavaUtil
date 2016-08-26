public class SMTPUtil {

	private static void addAttachment(Multipart multipart, File file, String name) throws MessagingException {
	    DataSource source = new FileDataSource(file);
	    BodyPart messageBodyPart = new MimeBodyPart();        
	    messageBodyPart.setDataHandler(new DataHandler(source));
	    messageBodyPart.setFileName(name);
	    multipart.addBodyPart(messageBodyPart);
	}
}
