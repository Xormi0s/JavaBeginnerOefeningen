package UI;

import Model.Calculator;

import javax.swing.*;

public class TestCalculator {

    public static void main(String[] args) {
        double input1;
        double input2;
        int choice;
        String[] choiceOptions = {" + ", " - ", " * ", " / ", " % ", " ** "};
        Calculator calculator = new Calculator();

        do {
            input1 = Integer.parseInt(JOptionPane.showInputDialog("Geef getal 1 in"));
            choice = JOptionPane.showOptionDialog(null,"Welke bewerking wil je doen ?","CALCULATOR",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choiceOptions, choiceOptions[0]);
            input2 = Integer.parseInt(JOptionPane.showInputDialog("Geef getal 2 in"));

            calculator.setInput1(input1);
            calculator.setInput2(input2);

            switch (choice) {
                case 0:
                    JOptionPane.showMessageDialog(null, "De uitkomst is: " + calculator.addition());
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "De uitkomst is: " + calculator.subtraction());
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "De uitkomst is: " + calculator.multiplication());
                    break;
                case 3:
                    try {
                        JOptionPane.showMessageDialog(null, "De uitkomst is: " + calculator.divide());
                    } catch (ArithmeticException e){
                        System.out.println("Delen door 0 gaat niet.");
                        JOptionPane.showMessageDialog(null,"Delen door 0 is onmogelijk !");
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "De uitkomst is: " + calculator.modulus());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "De uitkomst is: " + calculator.exponentiation());
                    break;
            }
            try {
                calculator.writeToFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (Calculator.getUserAnswer() == 'J');
    }
}
