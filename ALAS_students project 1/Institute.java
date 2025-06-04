import java.util.ArrayList;

public class Institute implements ALAS {
    private ArrayList<Room> rooms;
    private ArrayList<Permit> allPermits;
    private ArrayList<Door> doors;

    public Institute() {
        rooms = new ArrayList<Room>();
        allPermits = new ArrayList<Permit>();
        doors = new ArrayList<Door>();
        loadRooms();
        loadDoors();
        loadPermits();
    }

    private void loadRooms() {
        rooms.add(new Room(100, "Reception", 0, 0, 5));
        rooms.add(new Room(200, "Lab-A", 4, 3, 2));
        rooms.add(new Room(300, "Lab-B", 6, 2, 2));
        rooms.add(new Room(400, "Lab-C", 8, 3, 2));
    }

    private void loadDoors() {
        doors.add(new Door(rooms.get(0), rooms.get(1)));
        doors.add(new Door(rooms.get(1), rooms.get(2)));
        doors.add(new Door(rooms.get(2), rooms.get(3)));
        doors.add(new Door(rooms.get(1), rooms.get(3)));
        doors.add(new Door(rooms.get(3), rooms.get(0)));
    }

    private void loadPermits() {
        // Basic permits
        Permit p1 = new Permit(1, "ABC", 5, 6);
        Permit p2 = new Permit(2, "XYZ", 7, 5);
        rooms.get(0).enter(p1);
        rooms.get(0).enter(p2);
        allPermits.add(p1);
        allPermits.add(p2);

        // Subclass: TeamLeader
        TeamLeader tl = new TeamLeader(3, "TL1", 10, 8, 10000.0);
        rooms.get(0).enter(tl);
        allPermits.add(tl);

        // Subclass: Junior
        Junior jr = new Junior(4, "JR1", "Dr. Smith");
        rooms.get(0).enter(jr);
        allPermits.add(jr);

        // Subclass: SafetyOfficer
        SafetyOfficer so = new SafetyOfficer(5, "SO1", "SO-999", "Leader X", 5);
        rooms.get(0).enter(so);
        allPermits.add(so);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Permit> getAllPermits() {
        return allPermits;
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

    public String whereIsPermit(int id) {
        Permit p = getPermit(id);
        if (p == null) {
            return "Invalid permit ID.";
        }
        Room r = p.getCurrentRoom();
        if (r != null) {
            return r.getName();
        } else {
            return "Not in any room.";
        }
    }

    // ✅ FIX: Correct method signature: useDoor(int permitId, int doorNumber)
    public boolean useDoor(int permitId, int doorNumber) {
        if (permitId < 0 || permitId >= allPermits.size()) {
            System.out.println("Invalid permit ID.");
            return false;
        }
        if (doorNumber < 0 || doorNumber >= doors.size()) {
            System.out.println("Invalid door number.");
            return false;
        }
        Permit p = allPermits.get(permitId);
        Door d = doors.get(doorNumber);
        return d.useDoor(p);
    }

    // ✅ FIX: Correct method signature: return String for listPermits()
    public String listPermits() {
        StringBuilder result = new StringBuilder();
        for (Permit p : allPermits) {
            result.append(p.toString()).append("\n");
        }
        return result.toString();
    }

    public boolean canEnter(int permitId, int roomIndex) {
        if (permitId < 0 || permitId >= allPermits.size() || roomIndex < 0 || roomIndex >= rooms.size()) {
            return false;
        }
        Permit p = allPermits.get(permitId);
        Room r = rooms.get(roomIndex);
        return r.canEnter(p);
    }

    // ✅ FIX: Helper method to retrieve permit by ID
    private Permit getPermit(int id) {
        for (Permit p : allPermits) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
