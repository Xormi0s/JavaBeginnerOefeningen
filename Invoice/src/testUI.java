import java.util.*;
import java.util.stream.Collectors;


public class testUI {

    public static void main(String[] args) {
        ArrayList<Invoice> invoices = InvoiceDummy.generateData();

        // Sorteren volgens Part Description
        System.out.println("-------- Oefening A");
        List<Invoice> invoiceList = invoices.stream().sorted(Comparator.comparing(Invoice::getPartDescription)).collect(Collectors.toList());
        System.out.println(invoiceList);

        // Sorteren volgens de prijs
        System.out.println("-------- Oefening B");
        invoiceList = invoices.stream().sorted(Comparator.comparing(Invoice::getPricePerItem)).collect(Collectors.toList());
        System.out.println(invoiceList);

        // Mappen op Part Description en Quantity, sorteerd volgens Quantity
        System.out.println("-------- Oefening C");
        Map<String, Integer> mapC = invoices.stream().collect(Collectors.toMap(Invoice::getPartDescription, Invoice::getQuantity, (o1, o2) -> o1, TreeMap::new));
        System.out.println(mapC.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()));

        // Mappen op Part Description en waarde (Quantity * Price) en sorteren volgens invoice waarde
        System.out.println("-------- Oefening D");
        Map<String, Double> mapD = invoices.stream().collect(Collectors.toMap(Invoice::getPartDescription, Invoice::getInvoiceAmount, (o1, o2) -> o1, TreeMap::new));
        System.out.println(mapD.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()));

        //Uitbreiding vorige oefening. Nu enkel de producten met invoice waarde tussen 200 & 500
        System.out.println("-------- Oefening E");
        mapD.values().removeIf(x -> x < 200);
        mapD.values().removeIf(x -> x > 500);
        System.out.println(mapD.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()));
    }
}