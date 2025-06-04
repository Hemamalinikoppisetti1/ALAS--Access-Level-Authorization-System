public class Door {
    private Room room1;
    private Room room2;

    /**
     * Constructs a door connecting two rooms.
     * 
     * @param r1 The first room.
     * @param r2 The second room.
     */
    public Door(Room r1, Room r2) {
        this.room1 = r1;
        this.room2 = r2;
    }

    /**
     * Determines if a permit can pass through the door into the target room.
     * 
     * @param permit The permit trying to use the door.
     * @return true if the permit is allowed to enter the connected room, false otherwise.
     */
    public boolean canEnter(Permit permit) {
        Room currentRoom = permit.getCurrentRoom();
        if (currentRoom == null) {
            return false;
        }

        Room targetRoom;
        if (currentRoom.equals(room1)) {
            targetRoom = room2;
        } else if (currentRoom.equals(room2)) {
            targetRoom = room1;
        } else {
            return false; // Permit is not in either connected room
        }

        return targetRoom.canEnter(permit);
    }

    /**
     * Attempts to use the door to move the permit to the connected room.
     * 
     * @param permit The permit attempting to pass through the door.
     * @return true if the move was successful, false otherwise.
     */
    public boolean useDoor(Permit permit) {
        if (canEnter(permit)) {
            Room currentRoom = permit.getCurrentRoom();
            Room targetRoom = currentRoom.equals(room1) ? room2 : room1;
            currentRoom.exit(permit);
            targetRoom.enter(permit);
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the door.
     * 
     * @return A string showing which rooms the door connects.
     */
    public String toString() {
        return "Door between " + room1.getName() + " and " + room2.getName();
    }

    /**
     * Returns the first room.
     */
    public Room getRoom1() {
        return room1;
    }

    /**
     * Returns the second room.
     */
    public Room getRoom2() {
        return room2;
    }
}
