/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Materiels;
import services.ServiceMateriel;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ListMaterielsController implements Initializable {

    static Stage stageModifier;
    @FXML
    private TableView<Materiels> tableviewListeMateriels;
    @FXML
    private TableColumn<Materiels, String> colNom;
    @FXML
    private TableColumn<Materiels, String> colFournisseur;
    @FXML
    private TableColumn<Materiels, String> colCategorie;
    @FXML
    private TableColumn<Materiels, String> colQuantite;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnAdd;
    
    private List<Materiels> listMateriels;//retourner liste de la select
    private ObservableList<Materiels> ObservablelistMateriels;//pour la table view
    ServiceMateriel service = new ServiceMateriel();
    private Materiels materiel;
    @FXML
    private Button btnRefresh;
  
    
    
    
    
   
    

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        createMaterielview();
        // TODO
    }
    
    private void createMaterielview() {
    	colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colFournisseur.setCellValueFactory(new PropertyValueFactory<>("fournisseur"));
        colCategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        colQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        
        listMateriels = service.getAll();

        ObservablelistMateriels = FXCollections.observableArrayList(listMateriels);//convertir la liste des client en observable liste
        tableviewListeMateriels.setItems(ObservablelistMateriels);
        
        
        
    }

@FXML
    private void DeleteMat(ActionEvent event) {
    	Materiels materiel = tableviewListeMateriels.getSelectionModel().getSelectedItem();

        if (materiel != null) {

            service.delete(materiel);
            createMaterielview();
            
            

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("S'il vous plait selectionner un materiel");
            alert.show();
        }
        
        
        
    }    

    @FXML
    private void UpdateMat(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/ModifierMat.fxml"));
        Scene scene = new Scene(root);
        stageModifier = new Stage();
        stageModifier.setScene(scene);
        stageModifier.show();
        
        
        Materiels materiel = tableviewListeMateriels.getSelectionModel().getSelectedItem();

         
         
            
            stageModifier.setUserData(materiel);
        
        
    }

    @FXML
    private void btnAjouterMat(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/AddMat.fxml"));
        Scene scene = new Scene(root);
        stageModifier = new Stage();
        stageModifier.setScene(scene);
        stageModifier.show();
        
        
    }

    @FXML
    private void RefreshPage(ActionEvent event) {
        createMaterielview();
    }
    
    
    
}
