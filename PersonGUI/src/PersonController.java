import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PersonController {

    @FXML
    private TextField voornaamTextfield;

    @FXML
    private TextField achternaamTextfield;

    @FXML
    private DatePicker GeboortedatumDatepicker;

    @FXML
    private TextField adresTextfield;

    @FXML
    private TextField postcodeTextfield;

    @FXML
    private TextField gemeenteTextfield;

    @FXML
    private Label infoLabel;

    @FXML
    void zoekButtonPressed(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(voornaamTextfield.getText().equals("") || achternaamTextfield.getText().equals("")){
            infoLabel.setText("Voornaam EN achternaam moet ingevuld zijn.");
        } else {
            infoLabel.setText("");
            Persoon output = PersionIO.getPersoon(voornaamTextfield.getText(), achternaamTextfield.getText());
            if(output != null){
                GeboortedatumDatepicker.setValue(output.getGeboortedatum().toLocalDate());
                adresTextfield.setText(output.getAdres());
                postcodeTextfield.setText(String.valueOf(output.getPostcode()));
                gemeenteTextfield.setText(output.getGemeente());
            } else {
                infoLabel.setText("Deze persoon kan niet worden gevonden.");
            }
        }
    }

    @FXML
    void toevoegenWijzigenButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(voornaamTextfield.getText().equals("") || achternaamTextfield.getText().equals("")){
            infoLabel.setText("Voornaam EN achternaam moet ingevuld zijn.");
        } else {
            infoLabel.setText("");
            Persoon output = PersionIO.getPersoon(voornaamTextfield.getText(), achternaamTextfield.getText());
            if(output == null){
                LocalDate geboortedatum = GeboortedatumDatepicker.getValue();
                PersionIO.setPersoon(voornaamTextfield.getText(), achternaamTextfield.getText(), Date.valueOf(geboortedatum), adresTextfield.getText(), Integer.parseInt(postcodeTextfield.getText()), gemeenteTextfield.getText());
                infoLabel.setText("Persoon is succesvol toegevoegd!");
            } else {
                LocalDate geboortedatum = GeboortedatumDatepicker.getValue();
                PersionIO.changePersoon(voornaamTextfield.getText(), achternaamTextfield.getText(), Date.valueOf(geboortedatum), adresTextfield.getText(), Integer.parseInt(postcodeTextfield.getText()), gemeenteTextfield.getText());
                infoLabel.setText("De gegevens voor " + voornaamTextfield.getText() + " " + achternaamTextfield.getText() + " is gewijzigd.");
            }
        }
    }

    @FXML
    void clearData(ActionEvent event){
        infoLabel.setText("");
        voornaamTextfield.setText("");
        achternaamTextfield.setText("");
        GeboortedatumDatepicker.setValue(null);
        adresTextfield.setText("");
        postcodeTextfield.setText("");
        gemeenteTextfield.setText("");
    }

}
