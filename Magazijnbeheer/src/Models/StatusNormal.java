package Models;
import Enum.StatusEnum;

public class StatusNormal implements Status{

    @Override
    public String getStatus() {
        return StatusEnum.Normal.toString();
    }

    @Override
    public String toString() {
        return "Stock status: " + StatusEnum.Normal.toString();
    }
}
