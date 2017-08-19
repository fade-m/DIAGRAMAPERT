package model;

import java.util.ArrayList;

public class Actividad {
	
	private String nombre;
	private ArrayList<Actividad> anterior;
	private double a;
	private double m;
	private double b;
	private double tEstimado;
	private double vIda;
	private double vVuelta;
	private double varianza;
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Actividad() {
		this.anterior = null;
	}
	
	public Actividad(String nombre, ArrayList<Actividad> anterior, double tEstimado , double vIda) {
		
		this.nombre = nombre;
		this.anterior = anterior;
		this.vIda = vIda;
		this.tEstimado = tEstimado;

		
	}
	public Actividad(String nombre ,ArrayList<Actividad> anterior, double a, double m, double b, double tEstimado, double vIda, double vVuelta,double varianza) {
		super();
		this.nombre = nombre;
		this.anterior = anterior;
		this.a = a;
		this.m = m;
		this.b = b;
		this.tEstimado = tEstimado;
		this.vIda = vIda;
		this.vVuelta = vVuelta;
		this.varianza = varianza;
	}
	public ArrayList<Actividad> getAnterior() {
		return anterior;
	}
	public void setAnterior(ArrayList<Actividad> anterior) {
		this.anterior = anterior;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getM() {
		return m;
	}
	public void setM(double m) {
		this.m = m;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double gettEstimado() {
		return tEstimado;
	}
	public void settEstimado(double tEstimado) {
		this.tEstimado = tEstimado;
	}
	public double getvIda() {
		return vIda;
	}
	public void setvIda(double vIda) {
		this.vIda = vIda;
	}
	public double getvVuelta() {
		return vVuelta;
	}
	public void setvVuelta(double vVuelta) {
		this.vVuelta = vVuelta;
	}
	public double getVarianza() {
		return varianza;
	}
	public void setVarianza(double varianza) {
		this.varianza = varianza;
	}
	
	

}
