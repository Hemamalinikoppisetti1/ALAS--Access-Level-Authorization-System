/**
 * The PermitTester class is used to test the functionality of the Permit class.
 * It creates Permit objects, modifies them, and prints their states to verify correct behavior.
 */
public class PermitTester {
    
    public static void main(String[] args) {
        Permit p = new Permit(1, "TestName", 5, 10);
        Room r = new Room(100, "Reception", 0, 0, 1);
        r.enter(p);

        System.out.println("Permit created: " + p.toString());
        System.out.println("Permit is in room: " + p.getCurrentRoom().getRoomName());
    }
}
