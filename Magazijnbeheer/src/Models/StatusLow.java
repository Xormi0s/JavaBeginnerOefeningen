package Models;
import Enum.StatusEnum;

public class StatusLow implements Status{

    @Override
    public String getStatus() {
        return StatusEnum.Low.toString();
    }

    @Override
    public String toString() {
        return "Stock status: " + StatusEnum.Low.toString() + ", extra levering dringend aangevraagd";
    }
}
