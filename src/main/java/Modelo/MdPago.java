/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.Pago;
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
public class MdPago {
    private DbData dbData;

    public MdPago() {
        this.dbData = new DbData();
    }
    
    public boolean crearPago(Pago p) {
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String consulta = "INSERT INTO Pago(fechaPago, nCuotas, idMascota, idPlan) VALUES(?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, p.getFechaPago());
            statement.setInt(2, p.getnCuotas());
            statement.setInt(3, p.getIdMtc());
            statement.setInt(4, p.getIdPl());
            
            int filasIncertadas = statement.executeUpdate();
            
            if (filasIncertadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    public Pago buscarPago(String idPg) {
        Pago pg = null;
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String consulta = "SELECT * FROM Pago WHERE idPago = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setInt(1, Integer.parseInt(idPg));
            
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                int idPk = result.getInt(1);
                String fecha = result.getString(2);
                int nCuotas = result.getInt(3);
                int idMtc = result.getInt(4);
                int idPl = result.getInt(5);
                
                pg = new Pago(fecha, nCuotas, idMtc, idPl);
                pg.setIdPk(idPk);
            }
        } catch (Exception e) {
            return pg;
        }
        return pg;
    }
    
    public boolean actualizarPago(Pago p) {
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String consulta = "UPDATE Pago SET fechaPago = ?, nCuotas = ?, idMascota = ?, idPlan = ? WHERE idPago = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            
            statement.setString(1, p.getFechaPago());
            statement.setInt(2, p.getnCuotas());
            statement.setInt(3, p.getIdMtc());
            statement.setInt(4, p.getIdPl());
            statement.setInt(5, p.getIdPk());
            
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
    
    public boolean borrarPago(String idPg) {
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String consulta = "DELETE FROM Pago WHERE idPago = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setInt(1, Integer.parseInt(idPg));
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
    
    public LinkedList<Integer> buscarTodosIdPago() {
        LinkedList<Integer> listaIdPago = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String consulta = "SELECT idPago FROM Pago";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                int idPago = result.getInt(1);
                listaIdPago.add(idPago);
            }
            return listaIdPago;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaIdPago;
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
