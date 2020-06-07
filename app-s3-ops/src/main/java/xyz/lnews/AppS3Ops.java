package xyz.lnews;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

public class AppS3Ops {

    public void deleteBucket() {
        Regions clientRegion = Regions.US_EAST_1;
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));

            String[] bucketNames = properties.getProperty("bucket.names").split("\\,");

            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new ProfileCredentialsProvider())
                    .withRegion(clientRegion)
                    .build();
            for (String bucketName : bucketNames) {
                ObjectListing objectListing = s3Client.listObjects(bucketName);
                while (true) {
                    Iterator<S3ObjectSummary> objIter = objectListing.getObjectSummaries().iterator();
                    while (objIter.hasNext()) {
                        s3Client.deleteObject(bucketName, objIter.next().getKey());
                    }

                    if (objectListing.isTruncated()) {
                        objectListing = s3Client.listNextBatchOfObjects(objectListing);
                    } else {
                        break;
                    }
                }
                s3Client.deleteBucket(bucketName);
                System.out.println("All objects as well as Bucket " + bucketName + " have been deleted...");
            }
        } catch (AmazonServiceException e){
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

