/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava;

import models.Materiels;
import services.ServiceMateriel;
import tools.DataSource;

/**
 *
 * @author HP
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataSource ds = DataSource.getInstance();
        
        Materiels m2=new Materiels(2,"asb566a69", "assba69", "asssba");
        ServiceMateriel sm=new ServiceMateriel();
        sm.update(m2);
       
    }
    
}
