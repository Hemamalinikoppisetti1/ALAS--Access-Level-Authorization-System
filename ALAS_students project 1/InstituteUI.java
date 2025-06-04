import java.util.Scanner;

public class InstituteUI {
    private Institute institute;
    private Scanner scanner;

    public InstituteUI(Institute institute) {
        this.institute = institute;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("--- ALAS System Menu ---");
        System.out.println("1. List all rooms");
        System.out.println("2. List all permits");
        System.out.println("3. Where is a permit?");
        System.out.println("4. Try to enter a room using a door");
        System.out.println("5. Can a permit enter a room?");
        System.out.println("0. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listRooms();
                    break;
                case 2:
                    listPermits();
                    break;
                case 3:
                    whereIsPermit();
                    break;
                case 4:
                    tryEnterRoom();
                    break;
                case 5:
                    canEnterRoom();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void listRooms() {
        System.out.println("Rooms:");
        for (Room room : institute.getRooms()) {
            System.out.println(room);
        }
    }

    private void listPermits() {
        System.out.println("Permits:");
        for (Permit permit : institute.getAllPermits()) {
            System.out.println(permit);
        }
    }

    private void whereIsPermit() {
        System.out.print("Enter permit ID: ");
        int permitID = scanner.nextInt();
        String location = institute.whereIsPermit(permitID);
        System.out.println("Permit is in: " + location);
    }

    private void tryEnterRoom() {
        System.out.print("Enter permit ID: ");
        int permitID = scanner.nextInt();
        System.out.print("Enter door number: ");
        int doorIndex = scanner.nextInt();
        if (institute.useDoor(permitID, doorIndex)) {
            System.out.println("Entry successful.");
        } else {
            System.out.println("Entry failed.");
        }
    }

    private void canEnterRoom() {
        System.out.print("Enter permit ID: ");
        int permitID = scanner.nextInt();
        System.out.print("Enter room index (0-based): ");
        int roomIndex = scanner.nextInt();
        if (institute.canEnter(permitID, roomIndex)) {
            System.out.println("Can enter: true");
        } else {
            System.out.println("Can enter: false");
        }
    }

    public static void main(String[] args) {
        Institute institute = new Institute();
        InstituteUI ui = new InstituteUI(institute);
        ui.run();
    }
}
