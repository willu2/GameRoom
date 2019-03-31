import java.util.*;

public class ToysGenerator {

    LinkedList finRoom = new LinkedList();

    ToyItem toyItem;
    private String[] toysNames = {"Cube", "Piramid", "Car", "Track", "Doll", "Rocket", "LaserGun", "Lego", "Puzzles", "Pads"};

    private Map<String, Integer> tempPrice = new HashMap<>();

    int visitorMoney2 = 360;

    public ToysGenerator() {
    }

    public void setVisitorMoney(int maxPrice) {
        this.visitorMoney2 = maxPrice;
    }

    public String generateToyNames(){
        Random ran = new Random();
        int item = ran.nextInt(toysNames.length);

        return toysNames[item];
    }

    public int generatePrice(){
        Random ran = new Random();
        int price = ran.nextInt(15) + 4;

        return price;
    }

    public void createTempBase(){
        for (int i = 0; i < toysNames.length; i++){
            tempPrice.put(toysNames[i], generatePrice());
        }
    }

    public Map<String, Integer> getTempPrice() {
        return tempPrice;
    }

    public void createRoom(int visitorMoney){
        createTempBase();

        while (visitorMoney > 0){
            toyItem = new ToyItem();
            toyItem.setToyName(generateToyNames());
            toyItem.setToySize(ToyItem.ToySize.getRandomSize());
            toyItem.setPrice(tempPrice.get(toyItem.getToyName()));

            finRoom.add(toyItem);

            visitorMoney -= toyItem.getPrice();
            //System.out.println(visitorMoney);
        }
    }
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
