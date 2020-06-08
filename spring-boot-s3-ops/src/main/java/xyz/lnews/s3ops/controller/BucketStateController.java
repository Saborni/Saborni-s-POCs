package xyz.lnews.s3ops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lnews.s3ops.api.BucketOpsApi;
import xyz.lnews.s3ops.impl.BucketOpsApiImpl;

@RestController
@RequestMapping("/")
public class BucketStateController {

    private BucketOpsApiImpl bucketOpsApi = new BucketOpsApiImpl();

    @GetMapping("/s3create")
    public String createBuckets(){
        bucketOpsApi.createBucket();
        return "Buckets created successfully.";
    }

    @GetMapping("/s3delete")
    public String cleanAndDeleteBuckets(){
        bucketOpsApi.cleanAndDeleteBucket();
        return "Buckets cleaned and deleted successfully.";
    }

}
