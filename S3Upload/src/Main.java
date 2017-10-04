import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Upload\\Java";
		
		System.out.println("Monitoring directory: " + path);
		
		File directory = new File(path);
		File[] files = directory.listFiles();

		if (files != null) {
			AmazonS3Uploader amazonS3Uploader = new AmazonS3Uploader();
			
		    for (File file : files) {
		    	System.out.println("Uploading files: " + file.getName());
		    	
		    	amazonS3Uploader.UploadFile(file);
		    }
		}
		
		System.in.read();
	}
}
