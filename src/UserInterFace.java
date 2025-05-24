import java.util.*;

public class UserInterFace {
    private ParkingGarage garage;
    private final Scanner scanner;

    public UserInterFace() {
        scanner = new Scanner(System.in);
    }

    public void startGarageSetUp() {
        System.out.print("Enter number of slots: ");
        int n = scanner.nextInt();

        List<Slots> slots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Slot " + (i + 1) + ":");
            System.out.print("  Width: ");
            double width = scanner.nextDouble();
            System.out.print("  Depth: ");
            double depth = scanner.nextDouble();
            slots.add(new Slots(i + 1, width, depth));
        }

        System.out.println("Choose initial configuration:");
        System.out.println("1 - First Come First Served");
        System.out.println("2 - Best Fit");
        int config = scanner.nextInt();
        IParkingStrategy strategy = (config == 2) ? new BestFitStrategy() : new FirstComeStrategy();

        garage = new ParkingGarage(slots, strategy);
        System.out.println("Garage initialized with " + n + " slots.");
    }

    public void StartParkingIn() {
        System.out.print("Enter Model Name: ");
        String modelName = scanner.next();

        System.out.print("Enter Vehicle ID: ");
        String vehicleID = scanner.next();

        System.out.print("Enter Model Year: ");
        int year = scanner.nextInt();

        System.out.print("Enter Width: ");
        double width = scanner.nextDouble();

        System.out.print("Enter Depth: ");
        double depth = scanner.nextDouble();

        Vehicle vehicle = new Vehicle(modelName, vehicleID, year, width, depth);
        garage.parkIn(vehicle);
    }

    public void StartParkingOut() {
        System.out.print("Enter Vehicle ID: ");
        String id = scanner.next();
        garage.parkOut(id);
    }

    public void changeConfiguration() {
        System.out.println("Choose new configuration:");
        System.out.println("1 - First Come First Served");
        System.out.println("2 - Best Fit");
        int config = scanner.nextInt();
        IParkingStrategy strategy = (config == 2) ? new BestFitStrategy() : new FirstComeStrategy();
        garage.setStrategy(strategy);
        System.out.println("Configuration changed.");
    }

    public void displaySlots() {
        garage.displayAvailableSlots();
    }

    public void printTotalIncome() {
        System.out.println("Total income: " + garage.getTotalIncome() + " EGP");
    }

    public void printTotalNoOfVehicles() {
        System.out.println("Total number of vehicles: " + garage.getTotalVehiclesCount());
    }
}

