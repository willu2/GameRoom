import java.util.*;

/* Generate  all data class*/
public class ToysGenerator {

    private LinkedList finRoom = new LinkedList();

    private ToyItem toyItem;
    private String[] toysNames = {"Cube", "Piramid", "Car", "Track", "Doll", "Rocket", "LaserGun", "Lego", "Puzzles", "Pads"};

    private Map<String, Integer> tempPrice = new HashMap<>();

    public ToysGenerator() {
    }

    //toy name random generator
    private String generateToyNames(){
        Random ran = new Random();
        int item = ran.nextInt(toysNames.length);

        return toysNames[item];
    }

    //toy price random generator
    private int generatePrice(){
        Random ran = new Random();
        int price = ran.nextInt(15) + 4;

        return price;
    }

    private void createTempBase(){
        for (int i = 0; i < toysNames.length; i++){
            tempPrice.put(toysNames[i], generatePrice());
        }
    }

    //add all data data to room array
    public void createRoom(int visitorMoney){
        createTempBase();

        while (visitorMoney > 0){
            toyItem = new ToyItem();
            toyItem.setToyName(generateToyNames());
            toyItem.setToySize(ToyItem.ToySize.getRandomSize());
            toyItem.setPrice(tempPrice.get(toyItem.getToyName()));

            finRoom.add(toyItem);

            visitorMoney -= toyItem.getPrice();
        }
    }

    //print add data from room
    public void showAllToys(){
        if(!finRoom.isEmpty()){
            for(int p = 0; p < finRoom.size(); p++)
            {
                ToyItem toyItem = (ToyItem) finRoom.get(p);
                System.out.print(toyItem.getToyName() + " : ");
                System.out.print(toyItem.getToySize() + " : ");
                System.out.print(toyItem.getPrice() + " coins" +"\n");
                System.out.println("----------------------------");
            }
        }else {
            System.out.println("Your room is empty");
        }
    }

    //sort toys by size
    public void sortBySize(int size){
        ToyItem.ToySize type = returnSize(size);

            for(int p = 0; p < finRoom.size(); p++)
            {
                ToyItem toyItem = (ToyItem) finRoom.get(p);
                if(toyItem.getToySize() == type) {
                    System.out.print(toyItem.getToyName() + " : ");
                    System.out.print(toyItem.getToySize() + " : ");
                    System.out.print(toyItem.getPrice() + " poins" +"\n");
                    System.out.println("----------------------------");
                }

            }
        }

    //find toy by size
    public void findBySize(int size, int price){
        ToyItem.ToySize type = returnSize(size);

        for(int p = 0; p < finRoom.size(); p++)
        {
            ToyItem toyItem = (ToyItem) finRoom.get(p);
            if(toyItem.getToySize() == type && toyItem.getPrice()== price) {
                System.out.print(toyItem.getToyName() + " : ");
                System.out.print(toyItem.getToySize() + " : ");
                System.out.print(toyItem.getPrice() + " poins" +"\n");
                System.out.println("----------------------------");
            }

        }
    }

    //get toy size by toy size number
    public ToyItem.ToySize returnSize(int size) {
        ToyItem.ToySize type = ToyItem.ToySize.SMALL;
        switch (size) {
            case 1:
                type = ToyItem.ToySize.SMALL;
                break;
            case 2:
                type = ToyItem.ToySize.MID;
                break;
            case 3:
                type = ToyItem.ToySize.LARGE;
                break;
        }
        return type;
    }

    //sort toys by price
    public void sortByPrice(){

        Collections.sort(finRoom, (Comparator<ToyItem>) (o1, o2) -> o2.getPrice() - o1.getPrice());
        for(int p = finRoom.size() - 1; p >= 0; p--)
        {
            ToyItem toyItem = (ToyItem) finRoom.get(p);

                System.out.print(toyItem.getToyName() + " : ");
                System.out.print(toyItem.getToySize() + " : ");
                System.out.print(toyItem.getPrice() + " poins" +"\n");
                System.out.println("----------------------------");
            }
    }
}
