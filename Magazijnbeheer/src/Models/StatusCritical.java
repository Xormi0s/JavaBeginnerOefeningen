package Models;
import Enum.StatusEnum;

public class StatusCritical implements Status {

    @Override
    public String getStatus() {
        return StatusEnum.critical.toString();
    }

    @Override
    public String toString() {
        return "Stock status: " + StatusEnum.critical.toString() + ", extra productie dringend aangevraagd";
    }
}
