public class Room {
    private int id;
    private String name;
    private int dangerLevel;
    private int minHours;
    private int capacity;
    private int inside;
    

    public Room(int id, String name, int dangerLevel, int minHours, int capacity) {
        this.id = id;
        this.name = name;
        this.dangerLevel = dangerLevel;
        this.minHours = minHours;
        this.capacity = capacity;
        this.inside = 0;
    }

    public String getName() {
        return name;
    }
    
     public String getRoomName() {
        return this.name;
    }
    
    public int getMinHours() {
        return minHours;
    }

    public boolean canEnter(Permit permit) {
        return (inside < capacity && permit.getHours() >= minHours);
    }

    public void enter(Permit permit) {
        if (inside < capacity && permit.getHours() >= minHours) {
            inside++;
            permit.setCurrentRoom(this);
        }
    }

    public void exit(Permit permit) {
        if (inside > 0) {
            inside--;
            permit.setCurrentRoom(null);
        }
    }

    public String toString() {
        return "Room: " + id + " - " + name + ", Danger: " + dangerLevel + ", Min Hours: " + minHours + ", Capacity: " + capacity + ", Inside: " + inside;
    }
}
