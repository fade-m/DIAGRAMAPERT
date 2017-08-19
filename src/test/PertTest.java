package test;

import java.util.ArrayList;

import controller.OperacionesController;
import model.Actividad;
import view.Ventana;

public class PertTest {
	
	public static void main (String ... args){
		
		Ventana v = new Ventana();
		
		
		ArrayList<Actividad> actividades = new ArrayList<>();
		ArrayList<Actividad> a = new ArrayList<>();
		
		Actividad actA = new Actividad("A",null,1,3,5,4,0,0,0);
		Actividad actB = new Actividad("B",null,3,4.5,9,6,0,0,0);
		
		a = new ArrayList<>();
		a.add(actA);
		Actividad actC = new Actividad("C",a,2,3,4,4,0,0,0);
		a = new ArrayList<>();
		a.add(actB);
		Actividad actD = new Actividad("D",a,4,5.5,10,8,0,0,0);
		
		a = new ArrayList<>();
		a.add(actC);
		Actividad actE = new Actividad("E",a,4,7,16,4,0,0,0);
		
		a = new ArrayList<>();
		a.add(actD);
		Actividad actF = new Actividad("F",a,1,1.5,5,10,0,0,0);
		
		a = new ArrayList<>();
		a.add(actE);
		a.add(actF);
		Actividad actG = new Actividad("G",a,1,1.5,5,4,0,0,0);
		
		
		
		actividades.add(actA);
		actividades.add(actB);
		actividades.add(actC);
		actividades.add(actD);
		actividades.add(actE);
		actividades.add(actF);
		actividades.add(actG);

		

		OperacionesController op = new OperacionesController();
		System.out.println("Duracion estimadscaa: " + op.calcularDuracion(actividades));
		System.out.println("Ruta critljlkjica: "+ op.calcularRutaCritica(actividades));
		
		
		
		
	}
	

}
