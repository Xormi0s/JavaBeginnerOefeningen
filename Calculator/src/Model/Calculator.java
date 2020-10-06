package Model;

import javax.swing.*;

public class Calculator {
    double input1;
    double input2;
    double uitkomst;

    public Calculator(double input1, double input2) {
        this.input1 = input1;
        this.input2 = input2;
    }

    public Calculator() {

    }

    public double addition(){
        uitkomst = input1 + input2;
        return uitkomst;
    }

    public double subtraction(){
        uitkomst = input1 - input2;
        return uitkomst;
    }

    public double multiplication(){
        uitkomst = input1 * input2;
        return uitkomst;
    }

    public double divide() throws ArithmeticException{
        if(input2 == 0){
            throw new ArithmeticException();
        } else {
            uitkomst = input1 / input2;
        }
        return uitkomst;
    }

    public double modulus(){
        uitkomst = input1 % input2;
        return uitkomst;
    }

    public double exponentiation(){
        uitkomst = Math.pow(input1, input2);
        return uitkomst;
    }

    public double getInput1() {
        return input1;
    }

    public void setInput1(double input1) {
        this.input1 = input1;
    }

    public double getInput2() {
        return input2;
    }

    public void setInput2(double input2) {
        this.input2 = input2;
    }

    public double getUitkomst() {
        return uitkomst;
    }

    public void setUitkomst(double uitkomst) {
        this.uitkomst = uitkomst;
    }

    public static char getUserAnswer(){
        String temp = JOptionPane.showInputDialog("Nog een berekening ? J/N");
        char output = Character.toUpperCase(temp.charAt(0));
        return output;
    }

    public void writeToFile() throws Exception{
        java.io.File file = new java.io.File("result.txt");
        if (file.exists()) {
            System.out.println("File already exists");
        }
        try (java.io.PrintWriter output = new java.io.PrintWriter(file)) {
            output.print(uitkomst);
        }
    }
}
