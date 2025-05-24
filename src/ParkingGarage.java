import java.util.*;


public class ParkingGarage {
    private List<Slots> slots;
    private Map<String , ParkingTicket> activeTickets;
    private List<ParkingTicket> CompletedTickets;
    private IParkingStrategy strategy;
    private double totalIncome;
    private int totalVehiclesCount;

    //constructor
    public ParkingGarage(List<Slots> slots , IParkingStrategy strategy) {
        this.slots = slots;
        this.strategy = strategy;
        this.activeTickets = new HashMap<>();
        this.CompletedTickets = new ArrayList<>();
    }

    public  void setStrategy(IParkingStrategy strategy) {
        this.strategy = strategy;
    }

    // park in function
    public void parkIn(Vehicle vehicle) {
        if( activeTickets.containsKey(vehicle.getId())) {
            System.out.println("error vehicle is already parked");
            return;
        }

        Slots selectedSlot = strategy.selectSlot(slots , vehicle);
        if (selectedSlot == null) {
            System.out.println("error selecting slot");
            return;
        }

        selectedSlot.assignVehicle(vehicle);
        ParkingTicket ticket = new ParkingTicket(vehicle , selectedSlot);
        activeTickets.put(vehicle.getId() , ticket);
        totalVehiclesCount++;

        System.out.println("Vehicle parked in slot " + selectedSlot.getSlotID() + " at " + ticket.getEntryTime());
    }

    // park out function
    public void parkOut(String vehicleID) {
        ParkingTicket ticket = activeTickets.get(vehicleID);
        if (ticket == null) {
            System.out.println("error vehicle is already parked");
            return;
        }

        ticket.markExitTime();
        ticket.getSlot().removeVehicle();


        activeTickets.remove(vehicleID);
        CompletedTickets.add(ticket);
        totalIncome += ticket.getFee();

        System.out.println("Vehicle parked out FEE: " + ticket.getFee() + "EGP. TIME OUT: " + ticket.getExitTime());
    }

    // DIPLAY empty slots
    public  void displayAvailableSlots(){
        System.out.println("Available slots:");
        for (Slots slot : slots) {
            if(!slot.isOccupied()){
                System.out.println("SLOT " + slot.getSlotID() + " [" + slot.getWidth() + " x " + slot.getDepth() + " ]");
            }
        }
    }

    public double getTotalIncome() {
        return totalIncome;
    }
    public int getTotalVehiclesCount() {
        return totalVehiclesCount;
    }

    public void showStats() {
        System.out.println("Total income: " + totalIncome + " EGP");
        System.out.println("Total vehicles parked: " + totalVehiclesCount);
    }

}
