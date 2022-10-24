/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Cliente;
import Modelo.MdCliente;
import java.util.LinkedList;

/**
 *
 * @author Familia
 */
public class CtCliente {
    
    private MdCliente mdCliente;

    public CtCliente() {
        this.mdCliente = new MdCliente();
    }
    
    public boolean crearCliente(Cliente c) {
        try {
            this.getMdCliente().crearCliente(c);
        }catch(Exception e) {
            return false;
        }
        return true;
    }
    
    public Cliente buscarCliente(String identificacion) {
        Cliente c = null;
        c = this.getMdCliente().buscarCliente(identificacion);
        return c;
    }
    
    public boolean actualizarCliente(Cliente c) {
        try {
            this.getMdCliente().actualizarCliente(c);
        }catch(Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean borrarCliente(String id) {
        try {
            this.getMdCliente().borrarCliente(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public LinkedList<Cliente> buscarTodosLosClientes() {
        LinkedList<Cliente> listaCl = new LinkedList();
        try {
            listaCl = this.getMdCliente().buscarTodosLosClientes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaCl;
    }

    /**
     * @return the mdCliente
     */
    public MdCliente getMdCliente() {
        return mdCliente;
    }

    /**
     * @param mdCliente the mdCliente to set
     */
    public void setMdCliente(MdCliente mdCliente) {
        this.mdCliente = mdCliente;
    }
}
