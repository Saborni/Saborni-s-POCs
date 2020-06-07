package xyz.lnews;

public class AppS3Driver {
    public static void main(String[] args) {
        AppS3Ops ops = new AppS3Ops();
        ops.deleteBucket();
    }
}
