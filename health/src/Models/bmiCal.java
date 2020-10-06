package Models;

import javax.swing.*;
import java.io.Console;

/**
 * Author: Jonas
 * BMI calculator
 */

public class bmiCal  extends  Object {

    private double lengte;
    private double gewicht;
    private double bmi;
    /* keuze tussen kg/m en pounds/inches. kg/m = 0 & pounds/inches = 1 */
    private int keuze;

    public bmiCal(double lengte, double gewicht, int keuze) {
        this.lengte = lengte;
        this.gewicht = gewicht;
        this.keuze = keuze;
    }

    public double getLengte() {
        return lengte;
    }

    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public int getKeuze() {
        return keuze;
    }

    public void setKeuze(int keuze) {
        this.keuze = keuze;
    }

    @Override
    public String toString() {
        String output = String.format("%-20s", "Lengte")
                + String.format("%-20s", "Gewicht")
                + String.format("%-20s", "BMI")
                + String.format("%-23s", "\n" + getLengte())
                + String.format("%-24s", getGewicht())
                + String.format("%-5s", String.format("%1.2f", getBmi()))
                + "\n";
        return output;
    }

    public double calculBMI() {
        double uitkomst = 0;
        switch (keuze){
            case 0:
                uitkomst = getGewicht() / Math.pow(getLengte(), 2);
                break;
            case 1:
                uitkomst = (getGewicht() * 0.45359237) / Math.pow((getLengte() * 0.0254), 2);
                break;
        }
        return uitkomst;
    }

    public static double getLengte(String message){
        String lengte = JOptionPane.showInputDialog(message);
        return Double.parseDouble(lengte);
    }

    public static double getGewicht(String message){
        String gewicht = JOptionPane.showInputDialog(message);
        return Double.parseDouble(gewicht);
    }

    public static char getUserAnswer(){
        String temp = JOptionPane.showInputDialog("Nog een berekening ? J/N");
        char output = Character.toUpperCase(temp.charAt(0));
        return output;
    }
}
