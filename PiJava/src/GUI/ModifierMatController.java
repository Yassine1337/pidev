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
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Materiels;
import services.ServiceMateriel;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModifierMatController implements Initializable {

    @FXML
    private TextField tfNomMat;
    @FXML
    private TextField tfFournisseur;
    @FXML
    private TextField tfCategorie;
    @FXML
    private Button btnMod;
    @FXML
    private TextField tfQuantite;
    @FXML
    private Button btnGet;
    @FXML
    private TextField id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ModifierMat(ActionEvent event) {
        int Id = Integer.parseInt(id.getText());
        int Quant = Integer.parseInt(tfQuantite.getText());
        Materiels m = new Materiels(Id,tfNomMat.getText(),tfFournisseur.getText(),tfCategorie.getText(),Quant); 
        ServiceMateriel sm = new ServiceMateriel();
        System.out.println(m);
        if(sm.update(m)){
            System.out.println("updated");
}
        else
        {
            System.out.println("error");
        }
    }
    

    @FXML
    private void get(ActionEvent event) {
        Node node = (Node) event.getSource();
  Stage stage = (Stage) node.getScene().getWindow();
  // Step 2
  Materiels materiel = (Materiels) stage.getUserData();
        // TODO
        
        tfNomMat.setText(materiel.getNom());
        tfFournisseur.setText(materiel.getFournisseur());
        tfCategorie.setText(materiel.getCategorie());
        tfQuantite.setText(String.valueOf(materiel.getQuantite()));
        id.setText(String.valueOf(materiel.getId()));
    }
    
}
