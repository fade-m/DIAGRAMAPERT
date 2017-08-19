package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import model.Actividad;

public class OperacionesController {
	
	public double calcularDuracion(ArrayList<Actividad> actividades) {
		
		ArrayList<Actividad> a = actividades;
		double duracion = 0;
		
		for(int x=0; x<a.size(); x++) {
			
			if(a.get(x).getAnterior() == null) {
				a.get(x).setvIda(a.get(x).gettEstimado());
			}else {
				if(a.get(x).getAnterior().size()>1) {
					double max = 0;
					 for (int i = 0; i < a.get(x).getAnterior().size(); i++) {
				            if (a.get(x).getAnterior().get(i).getvIda() > max) {
				                max = a.get(x).getAnterior().get(i).getvIda();
				            }
				        }
					 a.get(x).setvIda(a.get(x).gettEstimado() + max);
				}else {
					a.get(x).setvIda(a.get(x).gettEstimado() + 
							a.get(x).getAnterior().get(0).getvIda());
				}
			}
			
			int tam = a.size();
			duracion = a.get(tam-1).getvIda();
		}
		
		double maxi = 0;
		for(int x =0; x<a.size();x++) {
			if(a.get(x).getvIda()>maxi){
				maxi = a.get(x).getvIda();
				
			}
		}
		
		return maxi;
	}
	
	public String calcularRutaCritica(ArrayList<Actividad> actividades) {
		
		ArrayList<Actividad> a = actividades;
		
		int tam=a.size();
		double resta = 0;
		boolean bandera = true;
		String ruta = "";
		double maxis;
		
		
		
		
		for(int x = a.size()-1; x>0; x--) {
			
			if(bandera) {
			resta = (a.get(x).getvIda()) - a.get(x).gettEstimado();
			ruta= ruta + ", " + a.get(x).getNombre();
			}
			while(resta != a.get(x).getvIda()) {
				if(x>0)x--;
			}
			ruta= ruta + ", " +  a.get(x).getNombre();
			resta = (a.get(x).getvIda()) - a.get(x).gettEstimado();
			bandera = false;
		}
		
		return ruta;
	}
	
	
	public void generarTiempoEstimado(ArrayList<Actividad> actividades) {
		
		ArrayList<Actividad> a = new ArrayList<>();
		
		for(int x = 0; x<a.size(); x++) {
			a.get(x).settEstimado(((a.get(x).getA()+4*(a.get(x).getM())+a.get(x).getB())/6));
		}
	}
}
