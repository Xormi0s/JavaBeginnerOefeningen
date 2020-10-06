package UI;

import Models.bmiCal;

import javax.swing.*;
import java.util.ArrayList;

public class Calculator {

    public static void main(String[] args){
        String[] opties = {"Kg/Meters", "Pound/Inches"};
        int keuze = JOptionPane.showOptionDialog(null,"BMI in kg & meters of in pounds & inches ?","BMI CALCULATOR",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opties, opties[0]);
        ArrayList<bmiCal> bmiArray = new ArrayList<bmiCal>();
        do {
            double lengte = 0;
            double gewicht = 0;

            switch (keuze){
                case 0:
                    lengte = bmiCal.getLengte("Geef de lengte in meters: ");
                    gewicht = bmiCal.getGewicht("Geef het gewicht in kg: ");
                    break;
                case 1:
                    lengte = bmiCal.getLengte("Geef de lengte in inches: ");
                    gewicht = bmiCal.getGewicht("Geef het gewicht in pounds: ");
            }
            bmiCal cal = new bmiCal(lengte, gewicht, keuze);
            /*System.out.println(cal);
            System.out.println(cal.calculBMI());*/
            cal.setBmi(cal.calculBMI());
            bmiArray.add(cal);
            JOptionPane.showMessageDialog(null, "BMI: " + String.format("%1.2f", cal.getBmi()));
        } while(bmiCal.getUserAnswer() == 'J');
        JOptionPane.showMessageDialog(null, bmiArray);
    }
}
