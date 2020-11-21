package Models;
import Enum.StatusEnum;

public class StatusLow implements Status{

    @Override
    public String getStatus() {
        return StatusEnum.low.toString();
    }

    @Override
    public String toString() {
        return "Stock status: " + StatusEnum.low.toString();
    }
}
