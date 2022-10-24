/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.Cliente;
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
public class MdCliente {
    
    private DbData dbData;

    public MdCliente() {
        this.dbData = new DbData();
    }
    
    public boolean crearCliente(Cliente c) {
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String query = "INSERT INTO Cliente (identificacion,nombres,apellidos,direccion,telefono) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, c.getIdentificacion());
            statement.setString(2, c.getNombres());
            statement.setString(3, c.getApellidos());
            statement.setString(4, c.getDireccion());
            statement.setString(5, c.getTelefono());
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                return true;
            }
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    
    public Cliente buscarCliente(String identificacion) {
        Cliente c = null;
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())){
            String consulta = "SELECT * FROM Cliente WHERE identificacion = ?";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, identificacion);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String id = result.getString(2);
                String nombre = result.getString(3);
                String apellido = result.getString(4);
                String direccion = result.getString(5);
                String telefono = result.getString(6);
                c = new Cliente(id, nombre, apellido, direccion, telefono);
            }
            return c;
        } catch (Exception e) {
            return c;
        }
    }
    
    public boolean actualizarCliente(Cliente c) {
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())){
            String consulta = "UPDATE Cliente SET nombres = ?, apellidos = ?, direccion = ?, telefono = ? WHERE identificacion = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, c.getNombres());
            statement.setString(2, c.getApellidos());
            statement.setString(3, c.getDireccion());
            statement.setString(4, c.getTelefono());
            statement.setString(5, c.getIdentificacion());
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
    
    public boolean borrarCliente(String id) {
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())){
            String consulta = "DELETE FROM Cliente WHERE identificacion = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, id);
            int filasborradas = statement.executeUpdate();
            if (filasborradas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    public LinkedList<Cliente> buscarTodosLosClientes() {
        LinkedList<Cliente> listaCl = new LinkedList<>();
        
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())){
            String consulta = "SELECT * FROM Cliente";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                int idPk = result.getInt(1);
                String identificacion = result.getString(2);
                String nombres = result.getString(3);
                String apellidos = result.getString(4);
                String direccion = result.getString(5);
                String telefono = result.getString(6);
                
                Cliente c = new Cliente (identificacion, nombres, apellidos, direccion, telefono);
                c.setIdPk(idPk);
                
                listaCl.add(c);
            }
            return listaCl;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaCl;
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
