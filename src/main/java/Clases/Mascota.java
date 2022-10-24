/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Familia
 */
public class Mascota {
    private int idPk;
    private String codigo;
    private String nombre;
    private int anioNac;
    private float peso;
    private String especie;
    private int idCl;
//    private Pago pg;
//    private Plan pl;

    public Mascota(String codigo, String nombre, int anioNac, float peso, String especie, int idCl/*, Pago pg, Plan pl*/) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.anioNac = anioNac;
        this.peso = peso;
        this.especie = especie;
        this.idCl = idCl;
//        this.pg = pg;
//        this.pl = pl;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the anioNac
     */
    public int getAnioNac() {
        return anioNac;
    }

    /**
     * @param anioNac the anioNac to set
     */
    public void setAnioNac(int anioNac) {
        this.anioNac = anioNac;
    }

    /**
     * @return the peso
     */
    public float getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(float peso) {
        this.peso = peso;
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

//    /**
//     * @return the pg
//     */
//    public Pago getPg() {
//        return pg;
//    }
//
//    /**
//     * @param pg the pg to set
//     */
//    public void setPg(Pago pg) {
//        this.pg = pg;
//    }
//
//    /**
//     * @return the pl
//     */
//    public Plan getPl() {
//        return pl;
//    }
//
//    /**
//     * @param pl the pl to set
//     */
//    public void setPl(Plan pl) {
//        this.pl = pl;
//    }

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
     * @return the idCl
     */
    public int getIdCl() {
        return idCl;
    }

    /**
     * @param idCl the idCl to set
     */
    public void setIdCl(int idCl) {
        this.idCl = idCl;
    }
}
