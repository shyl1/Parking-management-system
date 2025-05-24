import java.util.List;

public interface IParkingStrategy {

    Slots selectSlot(List<Slots> slots ,Vehicle vehicle);
}
