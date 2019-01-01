package anyvisioninternal.com.anyvision.challengo;

public class GameModel {
    private String prize;
    private int image;

    public GameModel(String prize, int image) {
        this.prize = prize;
        this.image = image;
    }

    public String getPrize() {
        return prize;
    }

    public int getImage() {
        return image;
    }
}
