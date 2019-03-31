
public class GameRoom {

    public static void main(String[] args)
    {
        ToysGenerator toysGenerator = new ToysGenerator();

        toysGenerator.createRoom(201);
        toysGenerator.showAllRoom();
        for (int i = 0; i < 5; i++){
            ///System.out.println(toysGenerator.generateToyNames());
        }
    }
}
