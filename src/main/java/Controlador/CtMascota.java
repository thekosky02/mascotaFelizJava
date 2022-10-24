/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Mascota;
import Clases.MascotasPorEspecie;
import Modelo.MdMascota;
import java.util.LinkedList;

/**
 *
 * @author Familia
 */
public class CtMascota {
    private MdMascota mdMascota;

    public CtMascota() {
        this.mdMascota = new MdMascota();
    }
    
    public boolean crearMascota(Mascota m) {
        try {
            this.getMdMascota().crearMascota(m);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public Mascota buscarMascota(String cod) {
        Mascota m = null;
        try {
            m = this.getMdMascota().buscarMascota(cod);
        } catch (Exception e) {
            return m;
        }
        return m;
    }
    
    public boolean actualizarMascota(Mascota m) {
        try {
            this.getMdMascota().actualizarMascota(m);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean borrarMascota(String cod) {
        try {
            this.getMdMascota().borrarMascota(cod);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public LinkedList<Mascota> buscarTodasMascotas() {
        LinkedList<Mascota> listaMtc = new LinkedList();
        try {
            listaMtc = this.getMdMascota().buscarTodasMascotas();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaMtc;
    }
    
    public LinkedList<MascotasPorEspecie> buscarMascotasPorEspecie() {
        LinkedList<MascotasPorEspecie> listaEspecie = new LinkedList();
        try {
            listaEspecie = this.mdMascota.buscarMascotasPorEspecie();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaEspecie;
    }

    /**
     * @return the mdMascota
     */
    public MdMascota getMdMascota() {
        return mdMascota;
    }

    /**
     * @param mdMascota the mdMascota to set
     */
    public void setMdMascota(MdMascota mdMascota) {
        this.mdMascota = mdMascota;
    }
}
