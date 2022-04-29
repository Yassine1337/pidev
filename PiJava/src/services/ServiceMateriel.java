/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Materiels;
import tools.DataSource;

/**
 *
 * @author HP
 */
public class ServiceMateriel implements IServices<Materiels> {
        Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public boolean add(Materiels t) {
        String query = "INSERT INTO materiels (`NOM`, `FOURNISSEUR`,`CATEGORIE`,`QUANTITE`) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
           //  ps.setObject(1, t.getId());
            ps.setObject(1, t.getNom());
            ps.setObject(2, t.getFournisseur());
            ps.setObject(3, t.getCategorie());
            ps.setObject(4, t.getQuantite());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean update(Materiels t) {
        String query = "UPDATE materiels SET NOM=?, FOURNISSEUR=?, CATEGORIE=?, QUANTITE=?  WHERE ID =?";


        try {
            PreparedStatement ps = cnx.prepareStatement(query);
         
            ps.setObject(1, t.getNom());
            ps.setObject(2, t.getFournisseur());
            ps.setObject(3, t.getCategorie());
            ps.setObject(5, t.getId());
            ps.setObject(4, t.getQuantite());

           
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;

    }

    @Override
    public boolean delete(Materiels t) {
        String sql = "DELETE FROM materiels WHERE ID=?";

        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setObject(1, t.getId());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Materiels> getAll() {
List<Materiels> list = new ArrayList<>();
        String query = "Select * from materiels";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                Materiels m = new Materiels(rs.getObject(1),rs.getObject(2), rs.getObject(3), rs.getObject(4),rs.getObject(5));
                list.add(m);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Materiels getOne(Materiels t) {
        String query = "select * from materiels where ID=" + t.getId();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Materiels p = new Materiels(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5));
                return p;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Materiels();
        
    }

    @Override
    public Materiels getById(int id) {
        String query = "select * from materiels where ID=" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Materiels p = new Materiels(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4));
                return p;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Materiels();
    }
        
    
    

  
}
