import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingTicket {

    // track the vehicle , slot , entrytime , exit time
    private Vehicle vehicle;
    private Slots slot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double fee;

    //fixed fee per hour
    private static final double HOURLY_RATE = 5.0;

    public ParkingTicket(Vehicle vehicle, Slots slot) {
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
    }

    //calc fee
    public void calculateFee() {
        Duration duration = Duration.between(entryTime, exitTime);
        long hours = duration.toHours();
        if(duration.toMinutes() % 60 !=0){
            hours++;
        }
        this.fee = hours * HOURLY_RATE;
    }

    // exit time and calculate fee
    public void markExitTime(){
        this.exitTime = LocalDateTime.now();
        calculateFee();
    }

    public double getFee() {
        return fee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Slots getSlot() {
        return slot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }


    @Override
    public String toString() {
        return "Ticket [VehicleID=" + vehicle.getId() +
                ", SlotID=" + slot.getSlotID() +
                ", Entry=" + entryTime +
                ", Exit=" + (exitTime != null ? exitTime : "In Garage") +
                ", Fee=" + fee + " EGP]";
    }

}
