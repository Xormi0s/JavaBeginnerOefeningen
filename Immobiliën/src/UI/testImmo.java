package UI;

import Models.factory.WoningFactory;
import Models.woningen.*;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class testImmo {

    public static void main(String[] args) {
        /* Aantal woningen die aangemaakt moeten worden ! */
        int aantalWoningen = 3;
        /* Aantal types van woningen we hebben. Deze kan dan bij uitbreidingen aangepast worden */
        int soortenWoningen = 4;

        Random random = new Random();
        int totaleLengte = 0;
        ArrayList<Woning> woningen = new ArrayList<Woning>();

        for(int x = 0; x < aantalWoningen; x++){
            woningen.add(WoningFactory.createWoning(random.nextInt(soortenWoningen)));
        }

        /* Lus om de totale lengte van de 2D array te bepalen voor onze tabel */
        for(Woning woning: woningen){
            Object[][] data = new Object[0][];
            if(woning instanceof Villa){
                data = (((Villa) woning).getOutput());
                totaleLengte += data.length;
            }
            if(woning instanceof Huis){
                data = (((Huis) woning).getOutput());
                totaleLengte += data.length;
            }
            if(woning instanceof Appartement){
                data = (((Appartement) woning).getOutput());
                totaleLengte += data.length;
            }
            if(woning instanceof Studio){
                data = (((Studio) woning).getOutput());
                totaleLengte += data.length;
            }
        }

        Object[][] result = new Object[totaleLengte][];

        /* int's voor tijdelijk in de lus te checken en de arraylengtes bij te houden zodat we eender hoeveelheid woningen kunnen tonen */
        int y = 0;
        int temp = 0;
        for(Woning woning: woningen){
            Object[][] data = new Object[1][];
            if(woning instanceof Villa){
                data = (((Villa) woning).getOutput());
            }
            if(woning instanceof Huis){
                data = (((Huis) woning).getOutput());
            }
            if(woning instanceof Appartement){
                data = (((Appartement) woning).getOutput());
            }
            if(woning instanceof Studio){
                data = (((Studio) woning).getOutput());
            }
            if(y == 0){
                System.arraycopy(data, 0, result, 0, data.length);
                temp += data.length;
                y = 1;
            } else {
                System.arraycopy(data, 0, result, temp, data.length);
                temp += data.length;
            }
        }

        String[] columnNames = {"Woning", "Kamer", "Aantal"};


        JTable table = new JTable(result, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);


        JOptionPane.showMessageDialog(null, scrollPane);
    }
}
