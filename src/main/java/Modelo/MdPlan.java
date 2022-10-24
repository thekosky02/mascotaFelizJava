/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.Plan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Familia
 */
public class MdPlan {
    
    private DbData dbData;

    public MdPlan() {
        this.dbData = new DbData();
    }
    
    public boolean crearPlan(Plan p) {
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())){
            String consulta = "INSERT INTO Plan (codigo,nombre,precio) VALUES (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getCodigo());
            statement.setString(2, p.getNombre());
            statement.setInt(3, p.getPrecio());
            int filasIncertadas = statement.executeUpdate();
            if (filasIncertadas > 0) {
                return true;
            }
            return true;
        } catch(Exception e) {
            return false;  
        }
    }
    
    public Plan buscarPlan(String codigo) {
        Plan p = null;
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())){
            String consulta = "SELECT * FROM Plan AS p WHERE p.codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                // int id = result.getInt(1);
                String cod = result.getString(2);
                String nombre = result.getString(3);
                int precio = result.getInt(4);
                p = new Plan(cod, nombre, precio);
            }
            return p;
        } catch (Exception e) {
            return p;
        }
    }
    
    public boolean actualizarPlan(Plan p) {
        try(Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String consulta = "UPDATE Plan SET nombre = ?, precio = ? WHERE codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, p.getNombre());
            statement.setInt(2, p.getPrecio());
            statement.setString(3, p.getCodigo());
            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean borrarPlan(String codigo) {
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())){
            String consulta = "DELETE FROM Plan WHERE codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, codigo);
            int filasBorradas = statement.executeUpdate();
            if (filasBorradas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    public LinkedList<Plan> buscarTodosPlanes() {
        LinkedList<Plan> listaPl = new LinkedList();
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String consulta = "SELECT * FROM Plan";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                int idPk = result.getInt(1);
                String codigo = result.getString(2);
                String nombre = result.getString(3);
                int precio = result.getInt(4);
                
                Plan p = new Plan(codigo, nombre, precio);
                p.setIdPk(idPk);
                
                listaPl.add(p);
            }
            return listaPl;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaPl;
    }

    /**
     * @return the dbData
     */
    public DbData getDbData() {
        return dbData;
    }

    /**
     * @param dbData the dbData to set
     */
    public void setDbData(DbData dbData) {
        this.dbData = dbData;
    }
}
