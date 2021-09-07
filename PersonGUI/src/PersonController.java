import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class PersonController {

    private Locale locale = Locale.getDefault();
    private Locale test = new Locale("nl");
    private Locale locales[] = Calendar.getAvailableLocales();
    ResourceBundle res = ResourceBundle.getBundle("MyResource", test);

    @FXML
    private Label lblVoornaam;
    @FXML
    private Label lblAchternaam;
    @FXML
    private Label lblGeboortedatum;
    @FXML
    private Label lblAdres;
    @FXML
    private Label lblPostcode;
    @FXML
    private Label lblGemeente;
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
    private ComboBox cboTaal;

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

    public void initialise(){
        for (int i = 0; i < locales.length; i++)
            cboTaal.getItems().add(locales[i].getDisplayName());
    }

    @FXML
    void changeLanguage(ActionEvent event){
        locale = locales[cboTaal.getSelectionModel().getSelectedIndex()];
        res = ResourceBundle.getBundle("MyResource", locale);

        lblVoornaam.setText(res.getString("voornaam"));
        lblAchternaam.setText(res.getString("achternaam"));
        lblAdres.setText(res.getString("adres"));
        lblGeboortedatum.setText(res.getString("geboortedatum"));
        lblGemeente.setText(res.getString("gemeente"));
        lblPostcode.setText(res.getString("postcode"));
    }
}
