/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.Mascota;
import Clases.MascotasPorEspecie;
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
public class MdMascota {
    private DbData dbData;

    public MdMascota() {
        this.dbData = new DbData();
    }
    
    public boolean crearMascota(Mascota m) {
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String consulta = "INSERT INTO Mascota(codigo, nombre, anioNac, peso, especie, idCliente) VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getCodigo());
            statement.setString(2, m.getNombre());
            statement.setInt(3, m.getAnioNac());
            statement.setDouble(4, m.getPeso());
            statement.setString(5, m.getEspecie());
            statement.setInt(6, m.getIdCl());
            int filasIncertadas = statement.executeUpdate();
            
            if (filasIncertadas > 0) {
                return true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Mascota buscarMascota(String cod) {
        Mascota m = null;
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String consulta = "SELECT * FROM Mascota WHERE codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cod);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                String codigo = result.getString(2);
                String nombre = result.getString(3);
                int anioNac = result.getInt(4);
                float peso = result.getFloat(5);
                String especie = result.getString(6);
                int idCl = result.getInt(7);
                m = new Mascota(codigo, nombre, anioNac, peso, especie, idCl);
            }
            return m;
        } catch (Exception e) {
            return m;
        }
    }
    
    public boolean actualizarMascota(Mascota m) {
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String consulta = "UPDATE Mascota Set nombre = ?, anioNac = ?, peso = ?, especie = ?, idCliente = ? WHERE codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, m.getNombre());
            statement.setInt(2, m.getAnioNac());
            statement.setFloat(3, m.getPeso());
            statement.setString(4, m.getEspecie());
            statement.setInt(5, m.getIdCl());
            statement.setString(6, m.getCodigo());
            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean borrarMascota(String cod) {
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String consulta = "DELETE FROM Mascota WHERE codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, cod);
            int filasBorradas = statement.executeUpdate();
            if (filasBorradas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public LinkedList<Mascota> buscarTodasMascotas() {
        LinkedList<Mascota> listaMtc = new LinkedList<>();
        
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String consulta = "SELECT * FROM Mascota";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                int idPk = result.getInt(1);
                String codigo = result.getString(2);
                String nombre = result.getString(3);
                int anioNac = result.getInt(4);
                float peso = result.getFloat(5);
                String especie = result.getString(6);
                int idCl = result.getInt(7);
                
                Mascota m = new Mascota(codigo, nombre, anioNac, peso, especie, idCl);
                m.setIdPk(idPk);
                listaMtc.add(m);
            }
            return listaMtc;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaMtc;
    }
    
    public LinkedList<MascotasPorEspecie> buscarMascotasPorEspecie() {
        LinkedList<MascotasPorEspecie> listaEspecie = new LinkedList<>();
        
        try (Connection conn = DriverManager.getConnection(getDbData().getUrl(), getDbData().getUser(), getDbData().getPassword())) {
            String consulta = "SELECT especie, count(especie) FROM Mascota GROUP BY especie";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                String especie = result.getString(1);
                int cantidadEspecie = result.getInt(2);
                
                MascotasPorEspecie mtcPE = new MascotasPorEspecie(especie, cantidadEspecie);
                
                listaEspecie.add(mtcPE);
            }
            return listaEspecie;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaEspecie;
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
