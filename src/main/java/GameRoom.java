
public class GameRoom {

    public static void main(String[] args)
    {
        ToysGenerator toysGenerator = new ToysGenerator();

       // toysGenerator.setVisitorMoney(400);

        toysGenerator.createRoom(400);
       // toysGenerator.showAllRoom();
        //toysGenerator.sortBySize(3);
        toysGenerator.sortByPrice();
        for (int i = 0; i < 5; i++){
            ///System.out.println(toysGenerator.generateToyNames());
        }
    }
}
