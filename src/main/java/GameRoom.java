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
        toysGenerator.createRoom(visitorPrice);
        boolean exit = false;

        do {
            int pos = 0;
            int price = 0;

            menu.mainManu();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            try {
                switch (pos = Integer.parseInt(in.readLine())) {
                    case 1:
                        toysGenerator.showAllToys();
                        break;
                    case 2:
                        menu.sizeShow();
                        pos = Integer.parseInt(in.readLine());
                        toysGenerator.sortBySize(pos);
                        break;
                    case 3:
                        toysGenerator.sortByPrice();
                        break;
                    case 4:
                        menu.sizeShow();
                        pos = Integer.parseInt(in.readLine());
                        menu.priceEnter();
                        price = Integer.parseInt(in.readLine());
                        toysGenerator.findBySize(pos, price);
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
