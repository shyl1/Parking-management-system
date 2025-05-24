import java.awt.*;

public class Vehicle {
    // in this class , driver should enter vehicle info
    //Car id
    private String VehicleID;
    // model
    private String Model;
    //Year
    private int modelYear;
    //slot that the driver parked in
    private int slotID;
    // entering time
    private int arrivalTime;
    // leaving time
    private int exitingTime;
    // dim of the vehicle
    private double width;
    private double depth;

    public Vehicle(String VehicleID , String Model , int modelYear, double width, double depth) {
        this.VehicleID = VehicleID;
        this.Model = Model;
        this.modelYear = modelYear;
        this.slotID = slotID;
        this.arrivalTime = arrivalTime;
        this.exitingTime = exitingTime;
        this.width = width;
        this.depth = depth;
    }

    //getters
    public String getId(){
        return VehicleID;
    }
    public String getModel(){
        return Model;
    }
    public int getYear(){
        return modelYear;
    }
    public int getSlotID(){
        return slotID;
    }
    public int getArrivalTime(){
        return arrivalTime;
    }
    public int getExitingTime(){
        return exitingTime;
    }

    public double getWidth(){
        return width;
    }
    public double getDepth(){
        return depth;
    }

}
