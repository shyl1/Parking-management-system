import java.util.List;

public class FirstComeStrategy implements IParkingStrategy {

    @Override
    public Slots selectSlot(List<Slots> slots, Vehicle vehicle) {
        for (Slots slot : slots) {
            if (slot.canOccupy(vehicle)) {
                return slot;
            }
        }
        return null; // No available slot found
    }
}
