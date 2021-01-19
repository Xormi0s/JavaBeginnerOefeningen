package dummy.test;


import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class SampleProperties {
    private Properties p = null;

    public SampleProperties(File f) throws IOException {
        p = new Properties();
        p.load(new FileInputStream(f));
    }

    public String getProperty(String key) {
        return p.getProperty(key);
    }

    public void setProperty(String key, String value) {
        p.setProperty(key, value);
    }

    public void list(PrintStream s) {
        p.list(s);
    }

    public void listWeb(PrintWriter s) {
        p.list(s);
    }

    public Enumeration elements() {
        return p.elements();
    }

    public Enumeration keys() {
        return p.keys();
    }

    public static SampleProperties getPropertiesFile(String file) {
        SampleProperties sp = null;
        try {
            File f = new File(file);
            if (f.exists()) {
                sp = new SampleProperties(f);
            } else {
                System.out.println("File " + f + " does not exist!");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return sp;

    }

    private static void showRates(SampleProperties sp) {
        System.out.println("All known currencies:\n=====================");
        sp.list(System.out);
        System.out.println("\nFor 3 Euro, you get " + 3
                * Float.parseFloat(sp.getProperty("currency.rate.euro2dollar"))
                + " dollars");

    }

    public static void main(String[] args) {
        try {
            SampleProperties sp;
            if (args.length == 1) {
                sp = getPropertiesFile(args[0]);

            } else {

                sp = getPropertiesFile("rates.properties");
            }
            showRates(sp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}