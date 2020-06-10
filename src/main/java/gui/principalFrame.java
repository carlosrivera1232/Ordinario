/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Excepciones.AlumnoExistenteException;
import Interfacez.AlumnoListener;
import controller.controlador;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import objects.Alumnos;
import objects.Carrera;
import objects.Fecha;
/**
 *
 * @author under
 */
public class principalFrame extends JFrame{
    
    private EncabezadoPanel pnlEncabezado;
    private workPanel pnlWork;
    private busquedaPanel pnlBusqueda;
    private controlador control;
    private AlumnoDialog dlgalumno;
    
    
    public principalFrame(){
        super("control escolar");
        super.setLayout(new BorderLayout());
        super.setSize(800,500);
        super.setLocationRelativeTo(null);
        
        dlgalumno=new AlumnoDialog(this);
        dlgalumno.setListener(new AlumnoListener() {
            @Override
            public void aceptarButtonClick(Alumnos alumno) {
                try {
                    control.addAlumno(alumno);
                    dlgalumno.setVisible(false);
                } catch (AlumnoExistenteException ex) {
                    JOptionPane.showMessageDialog(principalFrame.this,"La Matricula ya ha sido insertada anteriormente",
                            "Matricula invalida",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        control = new controlador();
        cargainicial();
        
        pnlEncabezado= new EncabezadoPanel();
        pnlWork = new workPanel(control);
        pnlBusqueda = new busquedaPanel();
        
        super.setJMenuBar(createMenu());

        super.add(pnlEncabezado, BorderLayout.NORTH);
        super.add(pnlBusqueda,BorderLayout.SOUTH);
        super.add(pnlWork,BorderLayout.CENTER);
        
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }
    
    private void cargainicial(){
        Alumnos a = new Alumnos("98789","Carlos","Altamirano","Rivera",new Fecha(9, 9, 1999),Carrera.SISTEMAS);
        Alumnos b = new Alumnos("b");
        Alumnos c = new Alumnos("c");
        Alumnos d = new Alumnos("d");
        Alumnos e = new Alumnos("e");
        
        try {
            control.addAlumno(a);
            control.addAlumno(b);
            control.addAlumno(c);
            control.addAlumno(d);
            control.addAlumno(e);
        
        }catch(AlumnoExistenteException ex){
            ex.printStackTrace();
        }
    }
    
    private JMenuBar createMenu(){
        JMenuBar mbMain = new JMenuBar();
        
        JMenu mArchivo = new JMenu("Archivo");
        JMenuItem miNuevo = new JMenuItem("Nuevo Alumno");
        miNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlgalumno.setVisible(true);
                
            }
        });
        JMenuItem miSalir = new JMenuItem("Salir");
        miSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });
        mArchivo.add(miNuevo);
        mArchivo.addSeparator();
        mArchivo.add(miSalir);
        
        JMenu mmAyuda = new JMenu("Ayuda");  
        JMenuItem miAcerca= new JMenuItem("Acerca de");
        mmAyuda.add(miAcerca);
        
        
        mbMain.add(mArchivo);
        mbMain.add(mmAyuda);
        return mbMain;
    }
}
