package xyz.lnews.s3ops.config;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;


import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

public class BucketConfig {

    public static String CONFIG_PROPERTIES = "src/main/resources/config.properties";
    public static String COMMA = "\\,";
    public static String BUCKET_NAMES_TO_CREATE="bucket.names.create";
    public static String BUCKET_NAMES_TO_DELETE="bucket.names.delete";

    public static AmazonS3 createS3Client(Regions clientRegion) {
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider())
                .withRegion(clientRegion)
                .build();
    }

    public static String[] getBucketNames(String keyName) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(CONFIG_PROPERTIES));
        return properties.getProperty(keyName).split(COMMA);
    }
}
