package practica_27;

import javax.swing.JFrame;

public class Main27 {

	public static void main(String[] args) {

		
		Vista27 miVista = new Vista27();
		
		Controlador27 ctr = new Controlador27(miVista);		
		
		miVista.añadeControl(ctr);
		
		JFrame ventana = new JFrame("Editor de texto");	
		
		ventana.setJMenuBar(miVista.getBarraMenu());

		ventana.setContentPane(miVista);
		ventana.setVisible(true);		
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}

}
