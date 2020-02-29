package xyz.lnews;

public class GoldRateDTO {
    private int goldKarat;
    private int goldRate;

    public GoldRateDTO(int goldKarat, int goldRate) {
        this.goldKarat = goldKarat;
        this.goldRate = goldRate;
    }

    public int getGoldKarat() {
        return goldKarat;
    }

    public void setGoldKarat(int goldKarat) {
        this.goldKarat = goldKarat;
    }

    public int getGoldRate() {
        return goldRate;
    }

    public void setGoldRate(int goldRate) {
        this.goldRate = goldRate;
    }
}
