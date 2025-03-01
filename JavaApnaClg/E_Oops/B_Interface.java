package E_Oops;
// we know that class is a blueprint of object and interface is a blueprint of class
// i.e it tells what should class do while being implemented by it
// i.e which methods should be implemented by class (mandatory)
// the variables in interface are by default public static final
// the methods in interface are by default public abstract
// (abstract means) i have been just declared here, you have to implement me in class
// class can implement multiple interfaces (Multiple inheritance)
public class B_Interface {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.move();// all directions
        System.out.println("chessPiece.totalPieces "+chessPiece.totalPieces);// 32
        System.out.println("q.totalPieces "+q.totalPieces);
        //q.totalPieces = 33;// error as it is final by default
    }

}

interface chessPiece {
    int totalPieces = 32;// public static final is added by default
    void move();
}

class Queen implements chessPiece {
    public void move() {// public is necessary as it is implented by interface
        System.out.println("all directions");
    }
    public static void testVariable(){
        System.out.println(totalPieces);
        //totalPieces = 33;// error as it is final
    }
}
