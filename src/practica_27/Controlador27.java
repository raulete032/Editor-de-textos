package practica_27;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class Controlador27 implements ActionListener,
										ItemListener,
										KeyListener{
	
	//VÍDEO EN EL MINUTO 14:53
	
	
	
	//Variables de instancia
	private Vista27 miVista;
	
	private byte tamañoFuente = 12;
	private String tipoFuente = "Arial";
	private boolean fuenteCursiva = false;
	private boolean fuenteNegrita = false;
	private String rutaArchivo = ""; //me sirve para guardar la última ruta de acceso

	/**
	 * Constructor
	 */
	public Controlador27(Vista27 v) {
		
		this.miVista = v;
		cambiaEstiloLetra();
		
	}


	
	
	//*******************************
	//ACTION LISTENER
	//*******************************
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getActionCommand().equals("Negrita")) { //se pulsa Negrita
			fuenteNegrita = !fuenteNegrita;
			cambiaEstiloLetra();
		}
		
		
		if(arg0.getActionCommand().equals("Cursiva")) { //se pulsa Cursiva
			fuenteCursiva = !fuenteCursiva;
			cambiaEstiloLetra();
		}
		
		
		if(arg0.getActionCommand().equals("Abrir"))//se pulsa Abrir
			abrirArchivo();			
	
				
		if(arg0.getActionCommand().equals("Guardar como")) //se pulsa Guardar como...
			guardarComoArchivo();
		
		
		if(arg0.getActionCommand().equals("Guardar")) { //se pulsa Guardar			
		
			if(!this.rutaArchivo.equals("")) //si es distinto de vacío (ya está guardado)
				guardarArchivo();
			else //si aún no ha guardado, salta el Guardar como...
				guardarComoArchivo();			
		}
		
		
		if(arg0.getActionCommand().equals("Nuevo"))//se pulsa Nuevo
			nuevoArchivo();			
		
		
		if(arg0.getActionCommand().equals("Cortar")) //se pulsa Cortar
			cortarTexto();
	
		
		if(arg0.getActionCommand().equals("Copiar")) //se pulsa Copiar
			copiarTexto();
		
		
		if(arg0.getActionCommand().equals("Pegar")) //se pulsa Pegar
			pegarTexto();
		
		
		if(arg0.getSource() == this.miVista.getbColorF())  //se pulsa Color Fondo
			cambiarColorFondo();			
		
		
		if(arg0.getSource() == this.miVista.getbColorT())  //se pulsa Color Texto
			cambiaColorTexto();
		
		
		if(arg0.getActionCommand().equals("A mayúsculas")) //se pulsa A Mayúsculas
			cambiarMayusMinus();
		
		
		if(arg0.getActionCommand().equals("A minúsculas")) //se pulsa A Minúscula
			cambiarMinusMayus();
		
		
		if(arg0.getActionCommand().equals("Aumentar")) { // se pulsa Aumentar
						
			if(this.tamañoFuente<=52) {
				this.tamañoFuente = (byte)(this.tamañoFuente + 4);
				cambiaTamaño(tamañoFuente);
			}			
		}
			
		if(arg0.getActionCommand().equals("Disminuir")) { //se pulsa Disminuir
			
			if(this.tamañoFuente>=7) {
				this.tamañoFuente = (byte)(this.tamañoFuente - 4);
				cambiaTamaño(tamañoFuente);				
			}
		}
		
		
		if(arg0.getSource() == this.miVista.getbBuscar()) //se pulsa Buscar
			 buscarTexto();
			
		
		if(arg0.getSource() == this.miVista.getbLimpiar()) //se pulsa Limpiar
			limpiarBusqueda();
		
		
		if(arg0.getSource() == this.miVista.getMuyPequeño()) //se pulsa Muy Pequeño en el Menu	
			cambiaTamaño((byte)4);
	
		
		if(arg0.getSource() == this.miVista.getPequeño()) //se pulsa Pequeño en el Menu
			cambiaTamaño((byte)8);
		
		
		if(arg0.getSource() == this.miVista.getNormal()) //se pulsa Normal en el Menu
			cambiaTamaño((byte)12);
		
		
		if(arg0.getSource() == this.miVista.getGrande()) //se pulsa Grande en el Menu
			cambiaTamaño((byte)30);
		
		
		if(arg0.getSource() == this.miVista.getMuyGrande()) //se pulsa Muy Grande en el Menu
			cambiaTamaño((byte)72);
		
		
		
		
	}//end actionPerformed




	//*******************************
	//ITEM LISTENER
	//*******************************
	@Override
	public void itemStateChanged(ItemEvent arg0) {

		if(arg0.getSource() == this.miVista.getFuente()) { // es el ComboBox de la Fuente
			
			String fuente = (String)this.miVista.getFuente().getSelectedItem(); //obtengo la Fuente seleccionada
			cambiaFuente(fuente);
			
		}
		
		if(arg0.getSource() == this.miVista.getTamaño()) {
			
			Byte tamaño = (Byte)this.miVista.getTamaño().getSelectedItem();
			
			cambiaTamaño(tamaño);
		}
		
		
		
	}



	//*******************************
	//KEY LISTENER
	//*******************************
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	//******************************************
	//MÉTODO PARA LAS ACCIONES
	//******************************************
	
	/**
	 * Métood que cambia el estilo de la letra
	 */
	private void cambiaEstiloLetra() {		
		int tipoFont;
		
		if(this.fuenteNegrita) //es negrita?
			if(this.fuenteCursiva) //es cursiva?	
				tipoFont =Font.BOLD|Font.ITALIC; //entonces las dos a la vez		
			else //sino... es cursiva, entonces solo Negrita
				tipoFont= Font.BOLD;
			
		else // no es negrita
			if(this.fuenteCursiva) //es cursiva?
				tipoFont=Font.ITALIC; 
			
			else //tampoco es cursiva, entonces es texto plano
				tipoFont= Font.PLAIN;
		
		this.miVista.getAreaTexto().setFont(new Font(this.tipoFuente, tipoFont, this.tamañoFuente));		
	}
	
	
	/**
	 * Método que permite ABRIR un archivo y mostrar su contenido
	 */
	private void abrirArchivo() {		
		
		if(this.rutaArchivo.equals("")) //si es cadean vacía pone la raíz
			this.rutaArchivo = "C:\\";		
		
		JFileChooser chooser = new JFileChooser(this.rutaArchivo); //Creo el Componente del típico cuadro de diálogo de Abrir/Guardar
		
		chooser.showOpenDialog(this.miVista); //la asocio a miVista
		chooser.setVisible(true); //lo hago visible
		
		if(chooser.getSelectedFile()!=null) {
		
			File f = chooser.getSelectedFile(); //eso me devuelve la ruta completa
			
	//		Scanner sc = null;
			String lineas = "";
			
			try (Scanner sc = new Scanner(f)) {
	//			sc = new Scanner(f); //al objeto Scanner le paso el File			
				while(sc.hasNextLine()) { //mientras haya línas por leer
					
					lineas = lineas + sc.nextLine()+"\n"; //guardo en línea las líneas que vayan saliendo
				}
				
				this.rutaArchivo = f.getPath(); //obtengo la ruta del archivo abierto
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}	
			catch(NullPointerException e2) {
				e2.printStackTrace();
			}
			this.miVista.getAreaTexto().setText(lineas); //le paso al JTextArea las líneas
		}
		else
			this.rutaArchivo="";
	}//end abrirArchivo
	
	
	/**
	 * Método que permite GUARDAR COMO... un archivo 
	 */
	private void guardarComoArchivo() {
		
		if(this.rutaArchivo.equals("")) //si es cadena vacía pone la raíz
			this.rutaArchivo = "C:\\";	
		
		JFileChooser chooser = new JFileChooser(this.rutaArchivo); //Creo el Componente del típico cuadro de diálogo de Abrir/Guardar
		
		chooser.showSaveDialog(this.miVista);
		chooser.setVisible(true);
		
		if(chooser.getSelectedFile()!=null) {		
			File f = chooser.getSelectedFile(); //me devuelve la ruta donde se guardará		
					
	//		FileWriter file = null; // creo objeto FileWriter
			
			String texto = this.miVista.getAreaTexto().getText(); //guardo todo el texto en la variable texto
			
			try (FileWriter file = new FileWriter(f)) {
				
	//			file = new FileWriter(f);
				
				for(int i=0; i<texto.length(); i++) {
					file.write((byte)texto.charAt(i));
				}
				
				this.rutaArchivo = f.getPath(); //obtengo la ruta del archivo guardado
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			catch(NullPointerException e2) {
				e2.printStackTrace();
			}
		}
		else
			this.rutaArchivo="";
	}
	
	
	/**
	 * Método que permite GUARDAR un archivo sobreescibiéndolo
	 */
	private void guardarArchivo() {		
		
		String texto = this.miVista.getAreaTexto().getText(); //guardo el texto en la variable
		
		try(FileWriter file = new FileWriter(this.rutaArchivo)) { //sobreescribo el archivo
			
			for(int i=0; i<texto.length(); i++) 
				file.write((byte)texto.charAt(i));
	
		}
		catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	/**
	 * Método que permite iniciar un NUEVO archivo
	 */
	private void nuevoArchivo() {
		
		this.tamañoFuente = 12;
		this.tipoFuente = "Arial";
		this.fuenteCursiva = false;
		this.fuenteNegrita = false;	
		this.rutaArchivo = "";
		this.miVista.getAreaTexto().setText("");
	}
	
	
	/**
	 * Método que permite CORTAR el texto seleccionado
	 */
	private void cortarTexto() {		
		this.miVista.getAreaTexto().cut();		
	}
	
	
	/**
	 * Método que permite COPIAR el texto seleccionado
	 */
	private void copiarTexto() {
		this.miVista.getAreaTexto().copy();
	}
	
	
	/**
	 * Método que permite PEGAR el texto copiado o cortado
	 */
	private void pegarTexto() {
		
		this.miVista.getAreaTexto().paste();
	}
	
	
	/**
	 * Método que permite cambiar el COLOR del FONDO
	 */
	private void cambiarColorFondo() {
		
		Color colorFondo = JColorChooser.showDialog(this.miVista.getAreaTexto(),"Elija un color", Color.WHITE);
		
		if(colorFondo!=null)
			this.miVista.getAreaTexto().setBackground(colorFondo);		
	}
	
	
	/**
	 * Método que premite cambiar el COLOR del TEXTO
	 */
	private void cambiaColorTexto() {
		
		Color colorTexto = JColorChooser.showDialog(this.miVista.getAreaTexto(), "Elija un color", Color.BLACK);
		
		if(colorTexto!=null)
			this.miVista.getAreaTexto().setForeground(colorTexto);
	}
	

	/**
	 * Método que permite cambiar el TIPO de FUENTE
	 */
	private void cambiaFuente(String fuente) {
		
		int negritaCursiva;
		
		if(this.fuenteNegrita)
			if(this.fuenteCursiva)
				negritaCursiva = Font.BOLD|Font.ITALIC;
			else
				negritaCursiva = Font.BOLD;
		else
			if(this.fuenteCursiva)
				negritaCursiva = Font.ITALIC;
			else
				negritaCursiva = Font.PLAIN;
		
		Font f = new Font(fuente, negritaCursiva, this.tamañoFuente);
		
		this.miVista.getAreaTexto().setFont(f);
		
		this.tipoFuente = fuente;
		
	}
	
	
	/**
	 * Método que permtie cambiar el TAMAÑO del TEXTO
	 * @param tamaño
	 */
	private void cambiaTamaño(byte tamaño) {
		
		int negritaCursiva;
		
		if(this.fuenteNegrita)
			if(this.fuenteCursiva)
				negritaCursiva = Font.BOLD|Font.ITALIC;
			else
				negritaCursiva = Font.BOLD;
		else
			if(this.fuenteCursiva)
				negritaCursiva = Font.ITALIC;
			else
				negritaCursiva = Font.PLAIN;
		
		Font f = new Font(this.tipoFuente, negritaCursiva, tamaño);
		
		this.miVista.getAreaTexto().setFont(f);
		
		this.tamañoFuente = tamaño;
		
		
	}
	
	
	/**
	 * Método que permite cambiar de MAYÚSCULAS a MINÚSCULAS
	 */
	private void cambiarMayusMinus() {
		
		String textoMayus= this.miVista.getAreaTexto().getText().toUpperCase();
		
		this.miVista.getAreaTexto().setText(textoMayus);
		
	}
	
		
	/**
	 * Método que permite cambiar de MINÚSCULAS a MAYÚSCULAS
	 */
	private void cambiarMinusMayus() {
	
		String textoMinus = this.miVista.getAreaTexto().getText().toLowerCase();
		
		this.miVista.getAreaTexto().setText(textoMinus);
	}
	
	
	/**
	 * Método que permite BUSCAR texto en el JTextArea
	 */
	private void buscarTexto() {
		
		JTextArea area = miVista.getAreaTexto();
		
		String textoBuscado = miVista.getBuscarTF().getText();
		
		if (textoBuscado.length() >= 1) {
			// Highlighter --> Esta clase nos ayuda a resaltar texto
			
			DefaultHighlighter.DefaultHighlightPainter highlightPainter =
					new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);
			
			Highlighter h = area.getHighlighter();
	//		h.removeAllHighlights(); // Borrar lo que hubiese resaltado
			
			// Creamos un objeto correspondiente a un determinado patrón (expresión regular)
			// que queremos utilizar en la búsqueda
			Pattern patron = Pattern.compile(textoBuscado);
			// La clase Matcher nos permite comprobar si una determinada cadena de texto
			// cumple con la expresión regular
			Matcher m = patron.matcher(area.getText());
			while (m.find()) { // Vamos iterando por el objeto Matcher, buscando la
				// la expresión regular (texto buscado en este caso), y
				// resaltándolo con start() y end()
				try {
					h.addHighlight(m.start(), m.end(), highlightPainter);
				}
				catch (BadLocationException ex) {
					Logger.getLogger(Color.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(area, "Indique el texto a buscar");
		}
	}
		
		
	/**
	 * Método que permite LIMPIAR lo buscado
	 */
	private void limpiarBusqueda() {
		
		JTextArea area = miVista.getAreaTexto();
		
		Highlighter h = area.getHighlighter();
		
		this.miVista.getBuscarTF().setText("");
		
		h.removeAllHighlights();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// end Controlador27
