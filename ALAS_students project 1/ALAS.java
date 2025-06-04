public interface ALAS {
    // Abstract methods that need to be implemented in the Institute class.
    
    // Method to list all permits
    public String listPermits();
    
    // Method to check where a specific permit is located
    public String whereIsPermit(int id);
    
    // Method to check if a permit can enter a specific room
    public boolean canEnter(int permitId, int roomIndex);
    
    // Method to use a door with a permit
    public boolean useDoor(int permitId, int doorNumber);
}
