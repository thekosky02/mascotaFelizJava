/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Pago;
import Modelo.MdPago;
import java.util.LinkedList;

/**
 *
 * @author Familia
 */
public class CtPago {
    private MdPago mdPago;

    public CtPago() {
        this.mdPago = new MdPago();
    }
    
    public boolean crearPago(Pago p) {
        try {
            this.getMdPago().crearPago(p);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
    public Pago buscarPago(String idPg) {
        Pago pg = null;
        try {
            pg = this.getMdPago().buscarPago(idPg);
        } catch (Exception e) {
            return pg;
        }
        return pg;
    }
    
    public boolean actualizarPago(Pago p) {
        try {
            this.getMdPago().actualizarPago(p);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean borrarPago(String idPg) {
        try {
            this.getMdPago().borrarPago(idPg);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public LinkedList<Integer> buscarTodosIdPago() {
        LinkedList<Integer> listaIdPago = new LinkedList();
        try {
            listaIdPago = this.getMdPago().buscarTodosIdPago();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaIdPago;
    }

    /**
     * @return the mdPago
     */
    public MdPago getMdPago() {
        return mdPago;
    }

    /**
     * @param mdPago the mdPago to set
     */
    public void setMdPago(MdPago mdPago) {
        this.mdPago = mdPago;
    }
}
