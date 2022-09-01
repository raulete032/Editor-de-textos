package practica_27;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;

public class Vista27 extends JPanel {
	
	private static final long serialVersionUID = 8079635819265176546L;
	
	
	
	//Variables de instancia
	private JButton bNuevo, bAbrir, bGuardar, bGuardarComo;
	private JButton bCortar, bCopiar, bPegar;
	private JButton bNegrita, bCursiva, bAumentar, bDisminuir;
	private JButton baMayus, baMinus, bColorF, bColorT;
	private JButton bBuscar, bLimpiar;
	private JComboBox<String> fuente;
	private JComboBox<Byte> tama�o;
	private JTextArea areaTexto;
	private JTextField buscarTF;
	private JMenuBar barraMenu;
	private JMenuItem nuevo, abrir, guardar, guardarComo, salir;
	private JMenuItem cortar, copiar, pegar;
	private JMenuItem tipoNormal, cursiva, negrita, muyPeque�o, peque�o, normal, grande, muyGrande, aMayus, aMinus;
	
	
	/**
	 * Constructor
	 */
	public Vista27() {
		
		JPanel pPrincipal = new JPanel(new BorderLayout());
		barraMenu();
		
		//**************
		//ZONA NORTE
		//**************
		
		JToolBar pNorte = preparaPanelNorte();
		
		
		//*************
		//ZONA CENTRO
		//*************
		
		JPanel pCentro = preparaPanelCentro();
		
		
		//***********
		//ZONA SUR
		//**********
		
		JPanel pSur = preparaPanelSur();	
		
		pPrincipal.add(pNorte, BorderLayout.NORTH);
		pPrincipal.add(pCentro, BorderLayout.CENTER);
		pPrincipal.add(pSur, BorderLayout.SOUTH);
		
		
		this.add(pPrincipal);
		
		
		
	}//end Constructor
	
	
	//GETTERS
	public JButton getbNuevo() {return bNuevo;}
	public JButton getbAbrir() {return bAbrir;}
	public JButton getbGuardar() {return bGuardar;}
	public JButton getbGuardarComo() {return bGuardarComo;}
	public JButton getbCortar() {return bCortar;}
	public JButton getbCopiar() {return bCopiar;}
	public JButton getbPegar() {return bPegar;}
	public JButton getbNegrita() {return bNegrita;}
	public JButton getbCursiva() {return bCursiva;}
	public JButton getbAumentar() {return bAumentar;}
	public JButton getbDisminuir() {return bDisminuir;}
	public JButton getBaMayus() {return baMayus;}
	public JButton getBaMinus() {return baMinus;}
	public JButton getbColorF() {return bColorF;}
	public JButton getbColorT() {return bColorT;}
	public JButton getbBuscar() {return bBuscar;}
	public JButton getbLimpiar() {return bLimpiar;}
	public JComboBox<String> getFuente() {return fuente;}
	public JComboBox<Byte> getTama�o() {return tama�o;}
	public JTextArea getAreaTexto() {return areaTexto;}
	public JTextField getBuscarTF() {return buscarTF;}
	public JMenuBar getBarraMenu() {return barraMenu;}
	public JMenuItem getNuevo() {return nuevo;}
	public JMenuItem getAbrir() {return abrir;}
	public JMenuItem getGuardar() {return guardar;}
	public JMenuItem getGuardarComo() {return guardarComo;}
	public JMenuItem getSalir() {return salir;}
	public JMenuItem getCortar() {return cortar;}
	public JMenuItem getCopiar() {return copiar;}
	public JMenuItem getPegar() {return pegar;}
	public JMenuItem getTipoNormal() {return tipoNormal;}
	public JMenuItem getCursiva() {return cursiva;}
	public JMenuItem getNegrita() {return negrita;}
	public JMenuItem getMuyPeque�o() {return muyPeque�o;}
	public JMenuItem getPeque�o() {return peque�o;}
	public JMenuItem getNormal() {return normal;}
	public JMenuItem getGrande() {return grande;}
	public JMenuItem getMuyGrande() {return muyGrande;}
	public JMenuItem getaMayus() {return aMayus;}
	public JMenuItem getaMinus() {return aMinus;}


	
	
	
	
	
	/**
	 * M�todo que preapra el panel del Norte
	 * @return
	 */
	private JToolBar preparaPanelNorte() {
		
		
		JToolBar barraHerra = new JToolBar();				
		
		barraHerra.add(this.bNuevo = new JButton(new ImageIcon("imagenes/nuevo.png")));
		barraHerra.add(this.bAbrir = new JButton(new ImageIcon("imagenes/abrir.png")));
		barraHerra.add(this.bGuardar = new JButton(new ImageIcon("imagenes/guardar.png")));
		barraHerra.add(this.bGuardarComo = new JButton(new ImageIcon("imagenes/guardarComo.png")));
		barraHerra.addSeparator();
		barraHerra.add(this.bCortar = new JButton(new ImageIcon("imagenes/cortar.png")));
		barraHerra.add(this.bCopiar = new JButton(new ImageIcon("imagenes/copiar.png")));
		barraHerra.add(this.bPegar = new JButton(new ImageIcon("imagenes/pegar.png")));
		barraHerra.addSeparator();
		barraHerra.add(this.bNegrita = new JButton(new ImageIcon("imagenes/negrita.jpg")));
		barraHerra.add(this.bCursiva = new JButton(new ImageIcon("imagenes/cursiva.jpg")));
		barraHerra.add(this.bAumentar = new JButton(new ImageIcon("imagenes/aumentar.png")));
		barraHerra.add(this.bDisminuir = new JButton(new ImageIcon("imagenes/disminuir.png")));
		barraHerra.addSeparator();
		barraHerra.add(this.baMayus = new JButton(new ImageIcon("imagenes/aMayuscula.png")));
		barraHerra.add(this.baMinus = new JButton(new ImageIcon("imagenes/aMinuscula.png")));
		barraHerra.addSeparator();
		barraHerra.add(this.bColorF = new JButton(new ImageIcon("imagenes/colorFondo.jpg")));
		barraHerra.add(this.bColorT = new JButton(new ImageIcon("imagenes/colorTexto.jpg")));
		barraHerra.addSeparator();
		
		
		this.fuente = new JComboBox<String>();
		
		String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for(int i=0; i<fontNames.length; i++) {
			
			fuente.addItem(fontNames[i]);			
		}
		
		
		this.tama�o = new JComboBox<Byte>();		
		
		for(byte i=8; i<=12; i++) {			
			tama�o.addItem(i);
		}
				
		for(byte i=14; i<=28; i=(byte)(i+2)) {			
			tama�o.addItem(i);			
		}
		
		tama�o.addItem((byte)36);
		tama�o.addItem((byte)48);
		tama�o.addItem((byte)72);		
		
		barraHerra.add(fuente);
		barraHerra.addSeparator();
		barraHerra.add(tama�o);		
	
		
		asignaAliasBotones();
		toolTip();
		
		return barraHerra;
		
				
	}
	
	/**
	 * M�todo que prepara el panel del Centro
	 * @return
	 */
	private JPanel preparaPanelCentro() {
		
		JPanel p = new JPanel();		
		
		this.areaTexto = new JTextArea(20, 92);
		
		JScrollPane scrollPane = new JScrollPane(areaTexto);
		
		p.add(scrollPane);
		
		
		return p;
	}
	
	
	
	/**
	 * M�todo que prepara el panel del Sur
	 * @return
	 */
	private JPanel preparaPanelSur() {
		
		JPanel p = new JPanel();
		
		JLabel etiqueta = new JLabel("Texto a buscar: ");
		
		this.buscarTF = new JTextField(40);
		this.bBuscar = new JButton("Buscar");
		this.bLimpiar = new JButton("Limpiar");
		
		
		p.add(etiqueta);
		p.add(buscarTF);
		p.add(bBuscar);
		p.add(bLimpiar);
		
		p.setBorder(new TitledBorder("Buscar texto"));
		
		return p;		
	}
		
	
	
	/**
	 * M�todo que prepara la barra de Men� y la devuelve
	 * @return
	 */
	public void barraMenu() {
		
		this.barraMenu = new JMenuBar();
		
		JMenu archivo = new JMenu("Archivo");
		this.nuevo = new JMenuItem("Nuevo");
		this.abrir = new JMenuItem("Abrir");
		this.guardar = new JMenuItem("Guardar");
		this.guardarComo = new JMenuItem("Guardar como");
		this.salir = new JMenuItem("Salir");
				
			archivo.add(this.nuevo);
			archivo.add(this.abrir);
			archivo.add(this.guardar);
			archivo.add(this.guardarComo);
			archivo.add(this.salir);
			
		JMenu edicion = new JMenu("Edici�n");
		this.cortar = new JMenuItem("Cortar");
		this.copiar = new JMenuItem("Copiar");
		this.pegar = new JMenuItem("Pegar");
		
			edicion.add(this.cortar);
			cortar.setAccelerator(
					KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
			edicion.add(this.copiar);
			copiar.setAccelerator(
					KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
			edicion.add(this.pegar);
			pegar.setAccelerator(
					KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		
		JMenu apariencia = new JMenu("Apariencia");
		this.tipoNormal = new JMenuItem("Tipo normal");
		this.cursiva = new JMenuItem("Cursiva");
		this.negrita = new JMenuItem("Negrita");
			
			apariencia.add(this.tipoNormal);
			apariencia.add(this.cursiva);
			apariencia.add(this.negrita);
			
		JMenu tama�o = new JMenu("Tama�o");	
			apariencia.add(tama�o);
			
		this.muyPeque�o = new JMenuItem("Muy peque�o");
		this.peque�o = new JMenuItem("Peque�o");
		this.normal = new JMenuItem("Normal");
		this.grande = new JMenuItem("Grande");
		this.muyGrande = new JMenuItem("Muy grande");
			
				tama�o.add(this.muyPeque�o);
				tama�o.add(this.peque�o);
				tama�o.add(this.normal);
				tama�o.add(this.grande);
				tama�o.add(this.muyGrande);
		
		JMenu herramientas = new JMenu("Herramientas");
		this.aMayus = new JMenuItem("A may�sculas");
		this.aMinus = new JMenuItem("A min�sculas");
		
			herramientas.add(this.aMayus);
			herramientas.add(this.aMinus);			
			
		barraMenu.add(archivo);
		barraMenu.add(edicion);
		barraMenu.add(apariencia);
		barraMenu.add(herramientas);	
		
		asignaAliasMenu();
		
	}
	
	
	/**
	 * M�todo que asigna un alias a los botones
	 */
	private void asignaAliasBotones() {
		
		//Alias a los botones
		this.bNuevo.setActionCommand("Nuevo");
		this.bAbrir.setActionCommand("Abrir");
		this.bGuardar.setActionCommand("Guardar");
		this.bGuardarComo.setActionCommand("Guardar como");
		
		this.bCortar.setActionCommand("Cortar");
		this.bCopiar.setActionCommand("Copiar");
		this.bPegar.setActionCommand("Pegar");
		
		this.bNegrita.setActionCommand("Negrita");
		this.bCursiva.setActionCommand("Cursiva");
		this.bAumentar.setActionCommand("Aumentar");
		this.bDisminuir.setActionCommand("Disminuir");
		
		this.baMayus.setActionCommand("A may�sculas");
		this.baMinus.setActionCommand("A min�sculas");		
	}
	
	/**
	 * M�todo que asigna alias a los menus
	 */
	private void asignaAliasMenu() {
		
		//Alias a los JMenuItem
		this.nuevo.setActionCommand("Nuevo");
		this.abrir.setActionCommand("Abrir");
		this.guardar.setActionCommand("Guardar");
		this.guardarComo.setActionCommand("Guardar como");
		this.salir.setActionCommand("Salir");

		this.cortar.setActionCommand("Cortar");
		this.copiar.setActionCommand("Copiar");
		this.pegar.setActionCommand("Pegar");

		this.negrita.setActionCommand("Negrita");
		this.cursiva.setActionCommand("Cursiva");


		this.guardarComo.setActionCommand("A may�sculas");
		this.guardarComo.setActionCommand("A min�sculas");

	}
	
	
	
	
	/**
	 * M�todo que le pone el toolTip a los botones
	 */
	private void toolTip() {		
		
		this.bNuevo.setToolTipText("Nuevo documento");
		this.bAbrir.setToolTipText("Abrir documento");
		this.bGuardar.setToolTipText("Guardar documento");
		this.bGuardarComo.setToolTipText("Guardar como...");
		this.bCortar.setToolTipText("Cortar");
		this.bCopiar.setToolTipText("Copiar");
		this.bPegar.setToolTipText("Pegar");
		this.bNegrita.setToolTipText("Negrita");
		this.bCursiva.setToolTipText("Cursia");
		this.bAumentar.setToolTipText("Aumentar tama�o letra");
		this.bDisminuir.setToolTipText("Disminuye tama�o letra");
		this.baMayus.setToolTipText("Pasa de may�scula a min�scula");
		this.baMinus.setToolTipText("Pasa de min�scula a may�scula");
		this.bColorF.setToolTipText("Cambiar color fondo");
		this.bColorT.setToolTipText("Cambia color del texto");
		
	}
	
	
	/**
	 * M�todo que a�ade control a los componentes
	 * @param ctr
	 */
	public void a�adeControl(Controlador27 ctr) {
		
		
		//Control al men�
		this.nuevo.addActionListener(ctr);
		this.abrir.addActionListener(ctr);
		this.guardar.addActionListener(ctr);
		this.guardarComo.addActionListener(ctr);
		this.salir.addActionListener(ctr);

		this.cortar.addActionListener(ctr);
		this.copiar.addActionListener(ctr);
		this.pegar.addActionListener(ctr);

		this.tipoNormal.addActionListener(ctr);
		this.cursiva.addActionListener(ctr);
		this.negrita.addActionListener(ctr);

		this.muyPeque�o.addActionListener(ctr);
		this.peque�o.addActionListener(ctr);
		this.normal.addActionListener(ctr);
		this.grande.addActionListener(ctr);
		this.muyGrande.addActionListener(ctr);
		this.aMayus.addActionListener(ctr);
		this.aMinus.addActionListener(ctr);		
			
		
		//Control Barra de herramientas	
		this.bNuevo.addActionListener(ctr);
		this.bAbrir.addActionListener(ctr);
		this.bGuardar.addActionListener(ctr);
		this.bGuardarComo.addActionListener(ctr);
		
		this.bCortar.addActionListener(ctr);
		this.bCopiar.addActionListener(ctr);
		this.bPegar.addActionListener(ctr);
		
		this.bNegrita.addActionListener(ctr);
		this.bCursiva.addActionListener(ctr);
		this.bAumentar.addActionListener(ctr);
		this.bDisminuir.addActionListener(ctr);
		
		this.baMayus.addActionListener(ctr);
		this.baMinus.addActionListener(ctr);
		
		this.bColorF.addActionListener(ctr);
		this.bColorT.addActionListener(ctr);	
		
		this.fuente.addItemListener(ctr);
		this.tama�o.addItemListener(ctr);	
		

		
		

		//Control zona Sur
		this.buscarTF.addKeyListener(ctr);
		this.bBuscar.addActionListener(ctr);
		this.bLimpiar.addActionListener(ctr);	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

} //end Vista27
