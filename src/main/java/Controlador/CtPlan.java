/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Plan;
import Modelo.MdPlan;
import java.util.LinkedList;

/**
 *
 * @author Familia
 */
public class CtPlan {
    
    private MdPlan mdPlan;

    public CtPlan() {
        this.mdPlan = new MdPlan();
    }
    
    public boolean crearPlan(Plan p) {
        try {
            this.getMdPlan().crearPlan(p);
        }catch(Exception e) {
            return false;
        }
        return true;
    }
    
    public Plan buscarPlan(String codigo) {
        Plan p = null;
        p = this.mdPlan.buscarPlan(codigo);
        return p;
    }
    
    public boolean actualizarPlan(Plan p) {
        try {
            this.getMdPlan().actualizarPlan(p);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean borrarPlan(String codigo) {
        try {
            this.getMdPlan().borrarPlan(codigo);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public LinkedList<Plan> buscarTodosPlanes() {
        LinkedList<Plan> listaPl = new LinkedList();
        try {
            listaPl = this.getMdPlan().buscarTodosPlanes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaPl;
    }

    /**
     * @return the mdPlan
     */
    public MdPlan getMdPlan() {
        return mdPlan;
    }

    /**
     * @param mdPlan the mdPlan to set
     */
    public void setMdPlan(MdPlan mdPlan) {
        this.mdPlan = mdPlan;
    }
    
}
