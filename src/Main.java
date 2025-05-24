import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterFace ui = new UserInterFace();
        ui.startGarageSetUp();

        while (true) {
            System.out.println("\n--- Parking Garage Menu ---");
            System.out.println("1 - Park In");
            System.out.println("2 - Park Out");
            System.out.println("3 - Change Configuration");
            System.out.println("4 - Display Available Slots");
            System.out.println("5 - Show Total Income");
            System.out.println("6 - Show Total Number of Vehicles");
            System.out.println("7 - Exit");
            System.out.print("Choose an operation: ");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> ui.StartParkingIn();
                case 2 -> ui.StartParkingOut();
                case 3 -> ui.changeConfiguration();
                case 4 -> ui.displaySlots();
                case 5 -> ui.printTotalIncome();
                case 6 -> ui.printTotalNoOfVehicles();
                case 7 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
