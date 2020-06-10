/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author under
 */
public class Alumnos {
    private String matricula;
    private String nombre;
    private String paterno;
    private String materno;
    private Fecha fechadenacimiento;

    public Alumnos(String matricula, String nombre, String paterno, String materno, Fecha fechadenacimiento, Carrera carrera) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fechadenacimiento = fechadenacimiento;
        this.carrera = carrera;
    }
    private Carrera carrera;
    
    
    public Alumnos(String matricula){
        this.matricula= matricula;
    }

   
    
    

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Alumnos){
            Alumnos alumno = (Alumnos)obj;
            return this.matricula.compareTo(alumno.getMatricula())==0;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Fecha getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(Fecha fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }
    
}
