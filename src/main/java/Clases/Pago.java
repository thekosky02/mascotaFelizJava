/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Familia
 */
public class Pago {
    private int idPk;
    private String fechaPago;
    private int nCuotas;
    private int idMtc;
    private int idPl;

    public Pago(String fechaPago, int nCuotas, int idMtc, int idPl) {
        this.fechaPago = fechaPago;
        this.nCuotas = nCuotas;
        this.idMtc = idMtc;
        this.idPl = idPl;
    }

    /**
     * @return the fechaPago
     */
    public String getFechaPago() {
        return fechaPago;
    }

    /**
     * @param fechaPago the fechaPago to set
     */
    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * @return the nCuotas
     */
    public int getnCuotas() {
        return nCuotas;
    }

    /**
     * @param nCuotas the nCuotas to set
     */
    public void setnCuotas(int nCuotas) {
        this.nCuotas = nCuotas;
    }

    /**
     * @return the idPk
     */
    public int getIdPk() {
        return idPk;
    }

    /**
     * @param idPk the idPk to set
     */
    public void setIdPk(int idPk) {
        this.idPk = idPk;
    }

    /**
     * @return the idMtc
     */
    public int getIdMtc() {
        return idMtc;
    }

    /**
     * @param idMtc the idMtc to set
     */
    public void setIdMtc(int idMtc) {
        this.idMtc = idMtc;
    }

    /**
     * @return the idPl
     */
    public int getIdPl() {
        return idPl;
    }

    /**
     * @param idPl the idPl to set
     */
    public void setIdPl(int idPl) {
        this.idPl = idPl;
    }
}
