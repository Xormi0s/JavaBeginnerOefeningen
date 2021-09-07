import java.util.ArrayList;

public class InvoiceDummy {

    public static ArrayList<Invoice> generateData(){
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();

        Invoice invoice = new Invoice("83", "Elektrische schuurmachine", 7, 57.98);
        invoices.add(invoice);

        invoice = new Invoice("24", "Power zaag", 18, 99.99);
        invoices.add(invoice);

        invoice = new Invoice("7", "Voor hamer", 11, 21.50);
        invoices.add(invoice);

        invoice = new Invoice("77", "Hamer", 76, 11.99);
        invoices.add(invoice);

        invoice = new Invoice("39", "Gras maaier", 3, 79.50);
        invoices.add(invoice);

        invoice = new Invoice("68", "Schroevendraaier", 16, 6.99);
        invoices.add(invoice);

        invoice = new Invoice("56", "Decoupeer zaal", 21, 11.00);
        invoices.add(invoice);

        invoice = new Invoice("3", "Moersleutel", 34, 7.50);
        invoices.add(invoice);

        return invoices;
    }
}
