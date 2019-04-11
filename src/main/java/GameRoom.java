import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameRoom {

    public static void main(String[] args)
    {
        MenuBuild menu = new MenuBuild();
        ToysGenerator toysGenerator = new ToysGenerator();

        int visitorPrice = 0;

        visitorPrice = menu.menuTotalPriceEnter();
        toysGenerator.createRoom(visitorPrice);  // create game room by price

        boolean exit = false;

        do {
            int pos = 0;
            int price = 0;

            menu.mainManu(); //main text menu

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            //main menu block
            try {
                switch (Integer.parseInt(in.readLine())) {
                    case 1:
                        toysGenerator.showAllToys();   //show all stuffs in the room
                        break;
                    case 2:
                        menu.sizeShow();
                        pos = Integer.parseInt(in.readLine());
                        toysGenerator.sortBySize(pos);  //sort by toys size
                        break;
                    case 3:
                        toysGenerator.sortByPrice();  //sort by toys price
                        break;
                    case 4:
                        menu.sizeShow();
                        pos = Integer.parseInt(in.readLine());
                        menu.priceEnter();
                        price = Integer.parseInt(in.readLine());
                        toysGenerator.findBySize(pos, price);  //find toys by position and price
                        break;
                    case 8:
                        exit = true;
                        break;
                    default:
                        System.out.println("Try again...");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }while (!exit);
    }
}
