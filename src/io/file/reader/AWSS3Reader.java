package io.file.reader;

import java.io.InputStream;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import ca.allyengine.relmanager.config.Config;

public class AWSS3Reader implements IReader{

	public AWSS3Reader() {
		
	}
	
	@Override
	public InputStream read(String filePath) {
		S3Object object = null ;
    	AmazonS3 s3Client = null ;
    	InputStream streamObjectData = null ;
    	String bucketName = Config.AWSS3BUCKETNAME;
    	
    	try {	
	        s3Client = new AmazonS3Client();        
	        object = s3Client.getObject(new GetObjectRequest(bucketName, filePath));
	        streamObjectData = object.getObjectContent();
	        
	        return streamObjectData;
    	} catch(Exception ex) {
    		System.out.println("EXCEPTION in AWSS3Reader.read()");
    		ex.printStackTrace();
    		return null;
    	} 
	}
}
