import java.io.*;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class AmazonS3Uploader {

	public void UploadFile(File file) {
		BasicAWSCredentials credentials = new BasicAWSCredentials("MY ACCESS KEY", "MY SECRET ACCESS KEY");
		
		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
									.withCredentials(new AWSStaticCredentialsProvider(credentials))
					                .withRegion(Regions.US_EAST_1)
					                .build();
		
		PutObjectRequest request = new PutObjectRequest("s3uploadjava", file.getName(), file)
										.withCannedAcl(CannedAccessControlList.PublicRead);
		
		s3client.putObject(request);
	}
	
}
