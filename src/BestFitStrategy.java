import java.util.List;

public class BestFitStrategy implements  IParkingStrategy{

    @Override
    public Slots selectSlot(List<Slots> slots, Vehicle vehicle) {
        Slots bestFit = null;
        double minArea = Double.MAX_VALUE;

        for (Slots slot : slots) {
            if (slot.canOccupy(vehicle)) {
                double slotArea = slotArea(slot);
                if (slotArea < minArea) {
                    minArea = slotArea;
                    bestFit = slot;
                }
            }
        }
        return bestFit;
    }

    private double slotArea(Slots slot) {
        return slot.getWidth() * slot.getDepth();
    }
}
