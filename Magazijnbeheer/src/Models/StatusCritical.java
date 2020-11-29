package Models;
import Enum.StatusEnum;

public class StatusCritical implements Status {

    @Override
    public String getStatus() {
        return StatusEnum.Critical.toString();
    }

    @Override
    public String toString() {
        return "Stock status: " + StatusEnum.Critical.toString() + ", extra productie dringend aangevraagd";
    }
}
