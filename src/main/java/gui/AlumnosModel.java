/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.controlador;
import javax.swing.table.TableModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.event.TableModelListener;
import objects.Alumnos;
/**
 *
 * @author under
 */
public class AlumnosModel extends AbstractTableModel{
    private controlador ocontrolador;
    public AlumnosModel(controlador control){
        ocontrolador=control;
    }

    @Override
    public int getRowCount() {
        return ocontrolador.getAlumnoscount();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumnos a= ocontrolador.getAlumno(rowIndex);
        switch(columnIndex){
            case 0:
                return a.getMatricula();
                
            case 1:
                return a.getNombre();
                
            case 2:
                return a.getPaterno();
                
            case 3:
                return a.getMaterno();
                
            case 4:
                return a.getFechadenacimiento();
                
            case 5:
                return a.getCarrera();
            default:
                throw new AssertionError();
        }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Matricula";
            case 1:
                return "Nombre";
            case 2:
                return "A.Paterno";
            case 3:
                return "A.Materno";
            case 4:
                return "Fecha de nacimiento";
            case 5:
                return "Carrera";
            
            default:
                throw new AssertionError();
        }
    }
    
    
    
}
