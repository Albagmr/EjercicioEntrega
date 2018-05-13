/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasessql;

/**
 *
 * @author Alba
 */
public class Departamento {
      private int numDepartamento;
    private String nombreDpto;
    private String loc;
//Creamos un constructor vacio y otro lleno con todos los atributos
    public Departamento() {
    }

    public Departamento(int numDepartamento, String nombreDpto, String loc) {
        this.numDepartamento = numDepartamento;
        this.nombreDpto = nombreDpto;
        this.loc = loc;
    }
//A continuación, creamos todos los getters y los setters
    public int getNumDepartamento() {
        return numDepartamento;
    }

    public void setNumDepartamento(int numDepartamento) {
        this.numDepartamento = numDepartamento;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public void setNombreDpto(String nombreDpto) {
        this.nombreDpto = nombreDpto;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
