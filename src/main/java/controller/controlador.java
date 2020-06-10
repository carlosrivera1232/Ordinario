/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Excepciones.AlumnoExistenteException;
import Excepciones.AlumnoInexistenteException;
import java.util.ArrayList;
import objects.Alumnos;

/**
 *
 * @author under
 */
public class controlador {
    
    private ArrayList<Alumnos> alumnos;
    
    public controlador(){
        
        alumnos = new ArrayList<>();
    }
    public void addAlumno (Alumnos alumno) throws AlumnoExistenteException{
        if(alumnos.contains(alumnos)){
            throw new AlumnoExistenteException();
        }
        alumnos.add(alumno);
    }
    public ArrayList<Alumnos> getAlumnos(){
        return alumnos;
    }
    public Alumnos getAlumno(String matricula) throws AlumnoInexistenteException{
        int index = alumnos.indexOf(new Alumnos(matricula));
        if(index<0){
            throw new AlumnoInexistenteException();
        }
        return alumnos.get(index);
    }
    public Alumnos getAlumno(int index){
        return alumnos.get(index);
    }
    
    public int getAlumnoscount(){
        return alumnos.size();
    }

}
