package xyz.lnews.s3ops.impl;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import xyz.lnews.s3ops.api.BucketOpsApi;

import java.io.IOException;
import java.util.Iterator;

import static xyz.lnews.s3ops.config.BucketConfig.*;

public class BucketOpsApiImpl implements BucketOpsApi {
    public String createBucket() {
        Regions clientRegion = Regions.US_EAST_1;
        try {
            String[] bucketNames = getBucketNames(BUCKET_NAMES_TO_CREATE);
            AmazonS3 s3Client = createS3Client(clientRegion);
            for (String bucketName : bucketNames) {
                if (!s3Client.doesBucketExistV2(bucketName)) {
                    s3Client.createBucket(new CreateBucketRequest(bucketName));
                    String bucketLocation = s3Client.getBucketLocation(new GetBucketLocationRequest(bucketName));
                    System.out.println("Bucket location: " + bucketLocation);
                }
            }
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        return "Buckets created successfully!";
    }

    public String cleanAndDeleteBucket() {
        Regions clientRegion = Regions.US_EAST_1;
        try {
            String[] bucketNames = getBucketNames(BUCKET_NAMES_TO_DELETE);
            AmazonS3 s3Client = createS3Client(clientRegion);

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
        return "Buckets cleanedup successfully!";
    }
}
