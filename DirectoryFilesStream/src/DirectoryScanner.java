import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryScanner {

    public void Scan(String dir) throws IOException {
        Scanner input = new Scanner(System.in);

        Path path = Paths.get(dir);

        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                try (Stream<Path> stream = Files.list(Paths.get(dir))) {
                    Map<String, Long> fileCount = stream.filter(Files::isRegularFile).map(f -> f.getFileName().toString().toUpperCase()).map(n -> n.substring(n.lastIndexOf(".") + 1)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("Filetype");
                    model.addColumn("Aantal");

                    for (Map.Entry entry : fileCount.entrySet()) {
                        model.addRow(new Object[]{entry.getKey(), entry.getValue()});
                    }

                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);

                    JOptionPane.showMessageDialog(null, scrollPane);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Directory bestaat niet !");
        }
    }
}
