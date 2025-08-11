package E_Oops;
// we know that class is a blueprint of object and interface is a blueprint of class
// i.e it tells what should class must contain
// the variables in interface are by default public static final i.e the variables can't be changed and it belongs to class only 
// the methods in interface are by default public abstract
// (abstract means) i have been just declared here, you have to implement that method or make a body for it
// class can implement multiple interfaces (Multiple inheritance)

interface chessPiece {
    String Oath = "Defeat the opponent";// public static final is added by default
    void move();
}

class Queen implements chessPiece {
    public void move() {// declaring as public is necessary as it is said that the method was public by default
        System.out.println("all directions");
    }
    public static void testVariable(){
        System.out.println(Oath);
        //Oath = "Save the opponent";// error as it is final
    }
}

public class B_Interface {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.move();// all directions
        System.out.println("chessPiece.Oath "+chessPiece.Oath);//"chessPiece.Oath Defeat the opponent
        System.out.println("q.Oath "+q.Oath);//"q.Oath Defeat the opponentt
        //q.Oath = "save the opponent";// error as it is final by default
        Queen.testVariable();// Defeat the opponent
    }

}