import java.util.Random;

public class ToyItem {

   public enum ToySize{
        SMALL, MID, LARGE;

        public static ToySize getRandomSize() {
               Random random = new Random();
               return values()[random.nextInt(values().length)];
       }
    }

    private String toyName;
    private int price = 0;

    public ToyItem() {
    }

    public ToyItem(String toyName, int price, ToySize size) {
        this.toyName = toyName;
        this.price = price;
        this.toySize = size;
    }

    private ToySize toySize;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(toySize == ToySize.MID){
            this.price = price * 2;
        }else if(toySize == ToySize.LARGE){
            this.price = price * 3;
        }else{
            this.price = price;
        }
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public ToySize getToySize() {
        return toySize;
    }

    public void setToySize(ToySize input) {
        toySize = input;
    }
}
