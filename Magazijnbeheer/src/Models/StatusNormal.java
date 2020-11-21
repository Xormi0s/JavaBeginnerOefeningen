package Models;
import Enum.StatusEnum;

public class StatusNormal implements Status{

    @Override
    public String getStatus() {
        return StatusEnum.normal.toString();
    }

    @Override
    public String toString() {
        return "Stock status: " + StatusEnum.normal.toString();
    }
}
