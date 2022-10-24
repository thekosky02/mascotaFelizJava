/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Familia
 */
public class MascotasPorEspecie {
    private String especie;
    private int cantidadEspecie;

    public MascotasPorEspecie(String especie, int cantidadEspecie) {
        this.especie = especie;
        this.cantidadEspecie = cantidadEspecie;
    }

    /**
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return the cantidadEspecie
     */
    public int getCantidadEspecie() {
        return cantidadEspecie;
    }

    /**
     * @param cantidadEspecie the cantidadEspecie to set
     */
    public void setCantidadEspecie(int cantidadEspecie) {
        this.cantidadEspecie = cantidadEspecie;
    }
    
    
}
