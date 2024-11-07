package E_Oops;

public class B_Interface {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.move();// all directions
    }

}

interface chessPiece {
    void move();
}

class Queen implements chessPiece {
    public void move() {// public is necessary as it is implented by interface
        System.out.println("all directions");
    }
}
