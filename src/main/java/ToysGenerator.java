import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class ToysGenerator {

    LinkedList finRoom = new LinkedList();

    ToyItem toyItem;
    String[] toysNames = {"Cube", "Piramid", "Car", "Track", "Doll", "Rocket", "LaserGun", "Lego", "Puzzles", "Pads"};

    Map<String, Integer> tempPrice = new HashMap<>();

    int visitorMoney = 360;

    public ToysGenerator() {
    }

    public void setVisitorMoney(int maxPrice) {
        this.visitorMoney = maxPrice;
    }

    public String generateToyNames(){
        Random ran = new Random();
        int item = ran.nextInt(toysNames.length);

        return toysNames[item];
    }

    public int generatePrice(){
        Random ran = new Random();
        int price = ran.nextInt(28) + 4;

        return price;
    }

    public void createTempBase(){
        for (int i = 0; i < toysNames.length; i++){
            tempPrice.put(toysNames[i], generatePrice());
        }

        /*for (Map.Entry<String, Integer> entry : tempPrice.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }*/
    }

    public Map<String, Integer> getTempPrice() {
        return tempPrice;
    }

    public void createRoom(int cash){
        createTempBase();

        for (int i = 0; i<=50; i++){
            toyItem = new ToyItem();
            toyItem.setToyName(generateToyNames());
            toyItem.setToySize(ToyItem.ToySize.getRandomSize());
            toyItem.setPrice(tempPrice.get(toyItem.getToyName()));

            finRoom.add(toyItem);
        }
    }
    public void showAllRoom(){
        if(!finRoom.isEmpty()){
            for(int p = 0; p < finRoom.size(); p++)
            {
                ToyItem toyItem = (ToyItem) finRoom.get(p);
                System.out.print(toyItem.getToyName() + " : ");
                System.out.print(toyItem.getToySize() + " : ");
                System.out.print(toyItem.getPrice() + " poins" +"\n");
                System.out.println("----------------------------");
            }
        }else {
            System.out.println("Your room is empty");
        }
    }
}
