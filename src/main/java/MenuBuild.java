import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//main text show menu class
public class MenuBuild {

    //print main text
    public void mainManu(){
        System.out.println("Menu :> ");
        System.out.println(" 1 :> Show all toys ");
        System.out.println(" 2 :> Sort by size  >>> ");
        System.out.println(" 3 :> Sort by price >>> ");
        System.out.println(" 4 :> Find toys by price and size >>> ");
        System.out.println(" 8 :> Exit ");

        System.out.println("Enter position :> ");
    }

    //print size text menu
    public void sizeShow(){
        System.out.println("Enter size:");
        System.out.println("> 1: SMALL ");
        System.out.println("> 2: MID ");
        System.out.println("> 3: LARGE ");
    }

    //print price enter text
    public void priceEnter(){
        System.out.println("Enter money digit:");
    }

    //check int input menu
    public int menuTotalPriceEnter(){
        int visitorPrice = 0;

        try {
            while (visitorPrice <= 0 ){
                System.out.println("How much money do you have (int limit digit) ? : ");
                try {
                    BufferedReader inPrice = new BufferedReader(new InputStreamReader(System.in));
                    visitorPrice = Integer.parseInt(inPrice.readLine());
                }catch (NumberFormatException c){}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visitorPrice;
    }
}
