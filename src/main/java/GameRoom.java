
public class GameRoom {

    public static void main(String[] args)
    {
        ToysGenerator toysGenerator = new ToysGenerator();

       // toysGenerator.setVisitorMoney(400);

        toysGenerator.createRoom(400);
       // toysGenerator.showAllRoom();
        toysGenerator.sortBySize(1);
        toysGenerator.sortBySize(2);
        toysGenerator.sortBySize(3);
        for (int i = 0; i < 5; i++){
            ///System.out.println(toysGenerator.generateToyNames());
        }
    }
}
