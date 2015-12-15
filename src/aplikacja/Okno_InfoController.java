/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_InfoController implements Initializable {

    @FXML
    TextArea info;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        info.setText("      Założenia wypożyczalni:\n"
//                + "1. Auta mogą być wypożyczane jedynie klientom prywatnym (Baza Danych oraz program do jej zarządzania nie obsługuje  klientów biznesowych)\n"
//                + "2. Wypożyczenie auta odbywa się za pomocą formularza, na którym może znajdować się jedynie jedno auto.\n"
//                + "3. Klient może wypożyczyć więcej niż jedno auto (każde wypożyczenie odbywa się za pomocą oddzielnego formularza).\n"
//                + "4. Auto może zostać wypożyczone najkrócej na jeden dzień.(Jednostką wypożyczania są doby)\n"
//                + "5. Auto może zostać wypożyczone pod warunkiem, że nie jest ono w danej chwili wypożyczone innemu klientowi oraz jeśli nie jest oznaczone jako uszkodzone.\n"
//                + "6. Zwrot auta odbywa się za pomocą oddzielnego formularza.\n"
//                + "7. Jeśli zwrot auta opóźnił się(data rzeczywistego zwrotu auta jest późniejsza niż data zwrotu jaką zadeklarował klient podczas wypożyczenia), naliczana jest kara w wysokości 200zł za każdy dzień opóźnienia.\n"
//                + "8. Jeśli zwrócone auto zostaje zwrócone z uszkodzeniami zostaje naliczona kara w wysokości 100zł.\n"
//        );
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("src/a.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }

}
