/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Materiels;
import services.ServiceMateriel;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddMatController implements Initializable {

    @FXML
    private TextField tfNomMat;
    @FXML
    private TextField tfFournisseur;
    @FXML
    private TextField tfCategorie;
    @FXML
    private Button btnAdd;
    @FXML
    private TextField tfQuantite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addMat(ActionEvent event) {
        String nomMat = tfNomMat.getText();
        String fournisseur = tfFournisseur.getText();
        String categorie = tfCategorie.getText();
        int quant = Integer.parseInt(tfQuantite.getText());
        
        Materiels m= new Materiels(nomMat,fournisseur,categorie,quant);
        ServiceMateriel sm = new ServiceMateriel();
        sm.add(m);
    }
    
}
