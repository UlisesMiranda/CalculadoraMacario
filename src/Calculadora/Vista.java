
package Calculadora;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vista extends JFrame 
{
        // El objeto calculadora es el que realmente realiza las operaciones
    	private final Calculadora calculator = new Calculadora();
        private final JTextField display = new JTextField();

        private final JButton b0 = new JButton("0");
	private final JButton b1 = new JButton("1");
	private final JButton b2 = new JButton("2");
	private final JButton b3 = new JButton("3");
	private final JButton b4 = new JButton("4");
	private final JButton b5 = new JButton("5");
	private final JButton b6 = new JButton("6");
	private final JButton b7 = new JButton("7");
	private final JButton b8 = new JButton("8");
	private final JButton b9 = new JButton("9");
	private final JButton mas= new JButton("+");
	private final JButton menos=new JButton("-");
	private final JButton igual=new JButton("=");
        private final JButton cE   = new JButton("CE");
        
        // Bandera lógica para para indicar el inicio de una nueva cifra
        private boolean nuevo=true;

	public Vista()
	{
		initComponents();
		this.setTitle("Calculadora");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.setBounds(100,100,270,400);

		this.setVisible(true);

	}

	public void initComponents()
	{
            // Diseña el menu
            JMenuBar barraMenus = new JMenuBar();
            JMenu archivo       = new JMenu("Archivo");
            JMenuItem salir     = new JMenuItem("Salir");
            this.setJMenuBar(barraMenus);
            
            barraMenus.add(archivo);
            archivo.add(salir);

		// Al desabilitar el LayoutManager, el programador tiene
		// la responsabilidad de situar los componentes
            this.setLayout(null); // Se deshabilita el Gestor de Distribución
            display.setBounds(10,5,220,40);
            b1.setBounds(10,50,50,50);
            b2.setBounds(70,50,50,50);
            b3.setBounds(130,50,50,50);
            mas.setBounds(190,50,50,50);

            b4.setBounds(10,110,50,50);
            b5.setBounds(70,110,50,50);
            b6.setBounds(130,110,50,50);
            menos.setBounds(190,110,50,50);

            b7.setBounds(10,170,50,50);
            b8.setBounds(70,170,50,50);
            b9.setBounds(130,170,50,50);
            b0.setBounds(70,230,50,50);
            igual.setBounds(190,170,50,50);
            cE.setBounds(10,230,50,50);

            display.setBackground(Color.black);
            display.setForeground(Color.orange);
            display.setFont(new Font("Consolas",Font.BOLD, 26));
            display.setHorizontalAlignment(JTextField.RIGHT);
            display.setEditable(false);

            // Agrega los elementos al JFrame
            this.add(display);
            this.add(b1);
            this.add(b2);
            this.add(b3);
            this.add(b4);
            this.add(b5);
            this.add(b6);
            this.add(b7);
            this.add(b8);
            this.add(b9);
            this.add(b0);
            this.add(mas);
            this.add(menos);
            this.add(igual);
            this.add(cE);

            // Para la gestión de los eventos de Calculadora
            
            b0.addActionListener(evt -> gestionarBotones(evt));
            b1.addActionListener(evt -> gestionarBotones(evt));
            b2.addActionListener(evt -> gestionarBotones(evt));
            b3.addActionListener(evt -> gestionarBotones(evt));
            b4.addActionListener(evt -> gestionarBotones(evt));         
            b5.addActionListener(evt -> gestionarBotones(evt));
            b6.addActionListener(evt -> gestionarBotones(evt));
            b7.addActionListener(evt -> gestionarBotones(evt));
            b8.addActionListener(evt -> gestionarBotones(evt));
            b9.addActionListener(evt -> gestionarBotones(evt));
            mas.addActionListener(evt -> gestionarBotones(evt));
            menos.addActionListener(evt -> gestionarBotones(evt));               
            igual.addActionListener(evt -> gestionarBotones(evt));

           
            // Al ser una tecla con dos símbolos en la cara le asignamos
            // un Listener diferente
                
            cE.addActionListener(evt -> gestionarCE(evt));
                
            // Gestión de menú
            salir.addActionListener(evt -> gestionarSalir(evt));
        
            // Salida 
            class MyWindowAdapter extends WindowAdapter
            {
                @Override
                public void windowClosing(WindowEvent e)
		{
                    exit();
		}
            }
            addWindowListener(new MyWindowAdapter());

	}
               
        // Métodos para gestión de eventos
        
        public void gestionarSalir(java.awt.event.ActionEvent evt)
        {
            exit();
        }
        
        public void exit()
        {
            int respuesta = JOptionPane.showConfirmDialog(rootPane, "Desea salir?","Federación deportiva",JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION) System.exit(0);
        }

        // Gestión para botones numéricos y símbolos de operación
        public void gestionarBotones(java.awt.event.ActionEvent evt)
        {

            String textoBoton = evt.getActionCommand();

            // Cada botón tiene un simbolo numérico o operador en la cara del botón
            // Se obtiene con charAt
            
            char simbolo = textoBoton.charAt(0);
                
            if(simbolo=='C') 
            {    
                calculator.clearANS();
                display.setText("");
            }
            else if( (simbolo >= '0' && simbolo <= '9') || simbolo == '.') // En caso de número
            {
                if(nuevo) display.setText(""); // Si es una nueva cifra se borra el diaplay
                    display.setText(display.getText()+ simbolo);
		nuevo = false; // Se pone en falso cuando se pone el primer dígito de una cifra
            }
            else  // En caso de operador
            {
		double numero = Double.parseDouble(display.getText());

		calculator.operacion(numero,simbolo);         // Invoca la funcionalidad de la calculadora

		display.setText(""+calculator.getANS());  // Obtiene el estado de la memoria de la calculadora

		nuevo = true;
            }
            
        }
            
        // Gestiona botón CE
        public void gestionarCE(java.awt.event.ActionEvent evt)
        {
            // Codigo para procesar CE
            display.setText("");
            nuevo=true;
        } 
        
        public int idOperaciones (simbolo) { 
            int operador;
            switch(simbolo)
		{
                    case '+': operador = 1;break;
                    case '-': operador = 2; break;
                    case '+': operador = 3;break;
                    case '-': operador = 4; break;
                    case '+': operador = 5;break;
                    case '-': operador = 6; break;
                    case '+': operador = 7;break;
                    case '-': operador = 8; break;
                    case '+': operador = 9;break;
                    case '-': operador = 10; break;
                    case '+': operador = 11;break;
                    
		}
        }
}
