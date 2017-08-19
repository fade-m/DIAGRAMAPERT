package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import controller.OperacionesController;
import model.Actividad;

public class Ventana extends JFrame {
	
	private JButton nuevo;
	private JButton calcular;
	private JButton reset;
	private ArrayList<Tupla> datos;
	private JLabel resultado;
	private JLabel rutaCritica;
	JPanel panelDatos = new JPanel();
	JPanel panelTextFields = new JPanel();
	String nombre;
	String anterior;
	double a;
	double m;
	double b;
	double tEsperado;		
	ArrayList<Actividad> act2 = new ArrayList<>();
	ArrayList<Actividad> act = new ArrayList<>();
	ArrayList<Actividad> actividades = new ArrayList<>();
	OperacionesController operaciones = new OperacionesController();
	
	public Ventana() {
		super.setTitle("DIAGRAMA DE PERT");

		super.setSize(1200, 600);
		
		
		super.add(crearPanelBoton(),BorderLayout.SOUTH);
		super.add(crearPanelDatos(), BorderLayout.CENTER);
		super.add(crearResultados(), BorderLayout.EAST);
		
		
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		super.setLayout(new BorderLayout());
		super.setLocationRelativeTo(null);
	}
	
	public JPanel crearPanelBoton() {
		
		JPanel panelBoton = new JPanel();
		panelBoton.setLayout(new FlowLayout(FlowLayout.LEFT));
		nuevo = new JButton("Nuevo nodo");
		calcular = new JButton("Calcular");
		reset = new JButton("RESET");
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		
		nuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JPanel j = new JPanel();
				datos.add(new Tupla());
				for(int x = 0; x<6; x++ ) {
					
					j.add(datos.get(datos.size() - 1).getDatos(x));
				}
				
				panelDatos.add(j);
				
				repaint();
				revalidate();
			}
		});
		
		calcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				for(int x = 0; x<datos.size();x++) {
					
						if(x == 0) {
							
							nombre = datos.get(x).getDatos(0).getText();
							a = Double.parseDouble(datos.get(x).getDatos(2).getText());
							m = Double.parseDouble(datos.get(x).getDatos(3).getText());
							b = Double.parseDouble(datos.get(x).getDatos(4).getText());
							tEsperado = Double.parseDouble(datos.get(x).getDatos(5).getText());
							Actividad acti = new Actividad(nombre,null,a,m,b,tEsperado,0,0,0);
							actividades.add(acti);
				
						}else {
							
							act2 = new ArrayList<>();
							nombre = datos.get(x).getDatos(0).getText();
							a = Double.parseDouble(datos.get(x).getDatos(2).getText());
							m = Double.parseDouble(datos.get(x).getDatos(3).getText());
							b = Double.parseDouble(datos.get(x).getDatos(4).getText());
							tEsperado = Double.parseDouble(datos.get(x).getDatos(5).getText());
							
							
							if( datos.get(x).getDatos(1).getText().equals("NULL") ) {
								
								Actividad acti = new Actividad(nombre,null,a,m,b,tEsperado,0,0,0);
								actividades.add(acti);
								
								
							}else {
								anterior = datos.get(x).getDatos(1).getText();
								
							}
							
							if(!datos.get(x).getDatos(1).getText().equals("NULL") && anterior.length()>1) {
								
						
								Scanner sc = new Scanner(anterior);
								sc.useDelimiter(",");
								while(sc.hasNext()) {
									String aux = sc.next();
									for(int u = 0; u <actividades.size(); u++) {
										if(aux.equals(actividades.get(u).getNombre())) {
											Actividad auxi = new Actividad();
											auxi = actividades.get(u);
											System.out.println(auxi.getNombre());
											act2.add(auxi);
										}
									}
									
								}
								sc.close();
								Actividad acti2 = new Actividad(nombre,act2,a,m,b,tEsperado,0,0,0);
								actividades.add(acti2);
							}
							else if(!datos.get(x).getDatos(1).getText().equals("NULL")  && anterior.length() == 1) {
								
								
								anterior = datos.get(x).getDatos(1).getText();
								
								
								
								for(int u = 0; u <actividades.size(); u++) {
									if(anterior.equals(actividades.get(u).getNombre())) {
										
										Actividad aux = new Actividad();
										aux = actividades.get(u);
										act2.add(aux);
										break;
									}
								}
								
								Actividad acti2 = new Actividad(nombre,act2,a,m,b,tEsperado,0,0,0);
								actividades.add(acti2);
								
								
								
							}

						}
						
					
					
				}
				
				
				resultado.setText("Duracion: "+ operaciones.calcularDuracion(actividades));
				rutaCritica.setText("RUta critica: " + operaciones.calcularRutaCritica(actividades));
				
				
			}
		});
		panelBoton.add(calcular);
		panelBoton.add(nuevo);
	
		
		return panelBoton;
	}
	
	public JPanel crearPanelDatos() {
		
		
		datos = new ArrayList<>();		
		datos.add(new Tupla());		
		panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
		
		for(int x = 0; x<6; x++ ) {
		panelTextFields.add(datos.get(0).getDatos(x));
		}
		panelDatos.add(panelTextFields);
		
				
		
		return panelDatos;
	}
	
	public JPanel crearResultados() {
		
		JPanel panelResultados = new JPanel();
		panelResultados.setLayout(new BoxLayout(panelResultados, BoxLayout.Y_AXIS));
		
		resultado = new JLabel("Resultado: ");
		rutaCritica = new JLabel("Ruta Critica: ");
		
		panelResultados.setPreferredSize(new Dimension(250, 0));
		
		panelResultados.add(resultado);
		panelResultados.add(rutaCritica);
		
		
		
		return panelResultados;
		
	}
	

	

}
