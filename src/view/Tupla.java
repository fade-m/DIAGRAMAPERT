package view;

import javax.swing.JTextField;

public class Tupla {
	
	private final JTextField[] datos =  new JTextField[6];

	public Tupla() {
		
		for(int x = 0; x<datos.length; x++) {
			datos[x] = new JTextField(10);
		}
		
	}
	
	public JTextField getDatos(int a) {
		return datos[a];
	}
	
	
	
	

}
