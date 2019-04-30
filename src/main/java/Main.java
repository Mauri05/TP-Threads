
import classes.Player;

public class Main {
    public static void main(String[] args){

        Thread p1 = new Player("Mauri",20);
        Thread p2 = new Player("Pepe",35);
        p1.start();
        p2.start();
    }
}
