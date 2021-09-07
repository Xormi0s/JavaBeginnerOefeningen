import javax.swing.*;
import java.io.IOException;

public class testUI {

    public static void main(String[] args) throws IOException {
        DirectoryScanner scanner = new DirectoryScanner();
        String input  = JOptionPane.showInputDialog("Gelieve de directory in te geven");
        scanner.Scan(input);
    }
}
