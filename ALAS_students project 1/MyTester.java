public class MyTester {
    public static void main(String[] args) {
        System.out.println("=== ALAS System Tester ===");

        // Create an instance of the Institute
        Institute inst = new Institute();

        System.out.println("\n--- All Rooms ---");
        for (Room r : inst.getRooms()) {
            System.out.println(r);
        }

        System.out.println("\n--- All Doors ---");
        int doorNumber = 0;
        for (Door d : inst.getDoors()) {
            System.out.println("Door " + doorNumber++ + ": " + d);
        }

        System.out.println("\n--- All Permits ---");
        for (Permit p : inst.getAllPermits()) {
            System.out.println(p);
        }

        System.out.println("\n--- Test WhereIsPermit ---");
        System.out.println("Permit 1 is in: " + inst.whereIsPermit(1));
        System.out.println("Permit 4 is in: " + inst.whereIsPermit(4));
        System.out.println("Invalid permit: " + inst.whereIsPermit(999));

        System.out.println("\n--- Test CanEnter Room 1 with Permit 2 ---");
        System.out.println("Can enter: " + inst.canEnter(2, 1)); // true or false

        System.out.println("\n--- Test UseDoor (Permit 1, Door 0) ---");
        boolean success = inst.useDoor(1, 0);
        System.out.println("Entry: " + (success ? "Successful" : "Failed"));
        System.out.println("Now in: " + inst.whereIsPermit(1));

        System.out.println("\n--- Subclass Testing ---");

        TeamLeader tl = new TeamLeader(10, "TL-One", 9, 6, 15000);
        System.out.println(tl);
        tl.setBudget(20000);
        tl.setTeamSize(12);
        System.out.println("Updated TL: " + tl);

        Junior jr = new Junior(11, "JR-One", "Dr. Ada");
        System.out.println(jr);
        jr.setSupervisor("Dr. Turing");
        System.out.println("Updated JR: " + jr);

        SafetyOfficer so = new SafetyOfficer(12, "SO-One", "SFT-007", "Lead-Z", 6);
        System.out.println(so);
        so.promote();
        so.promote(); // Should not exceed skill 7
        System.out.println("After promotion: " + so);

        System.out.println("\n=== End of Testing ===");
    }
}
