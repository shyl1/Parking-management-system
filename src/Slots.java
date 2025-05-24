public class Slots {

    // id of the slot
    private int slotID;

    //takes size
    private double width;
    private double depth;

    //if the slot is occupied or not
    private boolean occupied;

    // the size of the vehicle
    private Vehicle vehicle;

    //constructor
    public Slots(int slotID, double width, double depth) {
        this.slotID = slotID;
        this.width = width;
        this.depth = depth;
        this.occupied = false;
    }

    //getters
    public boolean isOccupied() {
        return occupied;
    }

    public int getSlotID() {
        return slotID;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    //see if the slot fits vehicle
    public boolean canOccupy(Vehicle v) {
        return !occupied && v.getWidth() <= width && v.getDepth() <= depth;
    }

    //change the status of the slot
    public void assignVehicle(Vehicle v) {
        this.vehicle = v;
        this.occupied = true;
    }

    // to remove vehicle from the slots and update slot status
    public void removeVehicle() {
        this.vehicle = null;
        this.occupied = false;
    }

    @Override
    public String toString() {
        return "Slot " + slotID + " (Occupied: " + occupied + ")";
    }

}
