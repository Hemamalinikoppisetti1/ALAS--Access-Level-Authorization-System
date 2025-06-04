public class Permit {
    private int id;
    private String ref;
    private int protectionLevel;
    private int hours;
    private Room currentRoom;
    private int maxEntries = Integer.MAX_VALUE;
    private int entries = 0;

    public Permit(int id, String ref, int protectionLevel, int hours) {
        this.id = id;
        this.ref = ref;
        this.protectionLevel = protectionLevel;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public int getProtectionLevel() {
        return protectionLevel;
    }

    public int getHours() {
        return hours;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void setMaxEntries(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    public int getMaxEntries() {
        return maxEntries;
    }

    public int getEntryCount() {
        return entries;
    }

    public void incrementEntries() {
        entries++;
    }

    public void reduceHours(int hrs) {
        hours -= hrs;
    }

    public String toString() {
        return "Permit ID: " + id + ", Ref: " + ref + ", Protection: " + protectionLevel + ", Hours Left: " + hours;
    }
}
