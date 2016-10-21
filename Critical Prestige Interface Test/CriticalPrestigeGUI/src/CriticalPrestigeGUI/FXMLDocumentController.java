/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CriticalPrestigeGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author julianmathis
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label test_label;
    
    
    @FXML
    /**
     * Action for hit button
     */
    private void hitButtonAction(ActionEvent event) {
        System.out.println("HIT!");
        test_label.setText("testing for hit button action!");
    }
    
    @FXML
    /**
     * Action for double button
     */
    private void doubleButtonAction(ActionEvent event) {
       
        
    }
    
    @FXML
    /**
     * Action for stand button
     */
    private void standButtonAction(ActionEvent event) {
        
    }
    
    @FXML
    /**
     * Action for split button
     */
    private void splitButtonAction(ActionEvent event) {
       
        
    }
    
    @FXML
    /**
     * Action for advice button
     */
    private void adviceButtonAction(ActionEvent event) {
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
