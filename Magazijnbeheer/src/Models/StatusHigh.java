package Models;
import Enum.StatusEnum;

public class StatusHigh implements Status{

    @Override
    public String getStatus() {
        return StatusEnum.High.toString();
    }

    @Override
    public String toString() {
        return "Stock status: " + StatusEnum.High.toString();
    }
}
