/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * 
 * @author Rodrigo Aranda Fernandez
 */
public class Profesor {
    
    private int claveProfesor;
    private String nombreCompleto;
    private String correoElectronico;
    private String userName;

    public Profesor(int claveProfesor, String nombreCompleto, String correoElectronico, String userName) {
        this.claveProfesor = claveProfesor;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.userName = userName;
    }

    public Profesor() {
    }

    
    
    /**
     * @return the claveProfesor
     */
    public int getClaveProfesor() {
        return claveProfesor;
    }

    /**
     * @param claveProfesor the claveProfesor to set
     */
    public void setClaveProfesor(int claveProfesor) {
        this.claveProfesor = claveProfesor;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Override
    public String toString(){
        return " Codigo docente : "+claveProfesor+
                " Nombre del docente : "+nombreCompleto+
                " Correo electrónico : "+ correoElectronico+
                " Usuario : "+userName;
    }

}
