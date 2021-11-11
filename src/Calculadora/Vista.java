package Calculadora;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vista extends JFrame {

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
    
    private final JButton mas = new JButton("+");
    private final JButton menos = new JButton("-");
    private final JButton multi = new JButton("*");
    private final JButton div = new JButton("/");
    private final JButton inverso = new JButton("x^-1");
    private final JButton cuadrado = new JButton("x^2");
    private final JButton raiz = new JButton("raiz");
    private final JButton raizcub = new JButton("raiz 3");
    private final JButton seno = new JButton("sen");
    private final JButton coseno = new JButton("cos");
    private final JButton tangente = new JButton("tan");
    
    private final JButton e = new JButton("e");
    private final JButton pi = new JButton("pi");
    
    private final JButton igual = new JButton("=");
    private final JButton cE = new JButton("CE");

    private boolean nuevo = true;

    public Vista() {
        initComponents();
        this.setTitle("Calculadora");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.setBounds(100, 100, 500, 500);

        this.setVisible(true);

    }

    public void initComponents() {
        JMenuBar barraMenus = new JMenuBar();
        JMenu archivo = new JMenu("CALCULADORA - MIRANDA CHAVEZ - NICOLAS HERNANDEZ");
        JMenuItem salir = new JMenuItem("Salir");
        this.setJMenuBar(barraMenus);

        barraMenus.add(archivo);
        archivo.add(salir);
        
        this.setLayout(null); 
        display.setBounds(10, 5, 450, 40);
        b1.setBounds(10, 50, 50, 50);
        b2.setBounds(70, 50, 50, 50);
        b3.setBounds(130, 50, 50, 50);

        b4.setBounds(10, 110, 50, 50);
        b5.setBounds(70, 110, 50, 50);
        b6.setBounds(130, 110, 50, 50);

        b7.setBounds(10, 170, 50, 50);
        b8.setBounds(70, 170, 50, 50);
        b9.setBounds(130, 170, 50, 50);
        b0.setBounds(70, 230, 50, 50);
        
        mas.setBounds(190, 50, 50, 50);
        menos.setBounds(250, 50, 50, 50);
        multi.setBounds(190, 110, 50, 50);
        div.setBounds(250, 110, 50, 50);
        
        inverso.setBounds(310, 110, 90, 50);
        cuadrado.setBounds(310, 170, 90, 50);
        raiz.setBounds(190, 170, 90, 50);
        raizcub.setBounds(190, 230, 90, 50);
        seno.setBounds(310, 230, 90, 50);
        coseno.setBounds(190, 290, 90, 50);
        tangente.setBounds(310, 290, 90, 50);
        
        e.setBounds(310, 50, 50, 50);
        pi.setBounds(370, 50, 50,50);
        
        igual.setBounds(130, 230, 50, 50);
        cE.setBounds(10, 230, 50, 50);

        display.setBackground(Color.black);
        display.setForeground(Color.orange);
        display.setFont(new Font("Consolas", Font.BOLD, 26));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

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
        this.add(multi);
        this.add(div);
        this.add(inverso);
        this.add(cuadrado);
        this.add(raiz);
        this.add(raizcub);
        this.add(seno);
        this.add(coseno);
        this.add(tangente);
        this.add(e);
        this.add(pi);
        this.add(cE);

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
        multi.addActionListener(evt -> gestionarBotones(evt));
        div.addActionListener(evt -> gestionarBotones(evt));
        inverso.addActionListener(evt -> gestionarBotones(evt));
        cuadrado.addActionListener(evt -> gestionarBotones(evt));
        raiz.addActionListener(evt -> gestionarBotones(evt));
        raizcub.addActionListener(evt -> gestionarBotones(evt));
        seno.addActionListener(evt -> gestionarBotones(evt));
        coseno.addActionListener(evt -> gestionarBotones(evt));
        tangente.addActionListener(evt -> gestionarBotones(evt));
        
        e.addActionListener(evt -> gestionarBotones(evt));
        pi.addActionListener(evt -> gestionarBotones(evt));
        
        igual.addActionListener(evt -> gestionarBotones(evt));
        
        cE.addActionListener(evt -> gestionarCE(evt));

        salir.addActionListener(evt -> gestionarSalir(evt));

        class MyWindowAdapter extends WindowAdapter {

            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        }
        addWindowListener(new MyWindowAdapter());

    }

    public void gestionarSalir(java.awt.event.ActionEvent evt) {
        exit();
    }

    public void exit() {
        int respuesta = JOptionPane.showConfirmDialog(rootPane, "Desea salir?", "Federación deportiva", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void gestionarBotones(java.awt.event.ActionEvent evt) {

        String textoBoton = evt.getActionCommand();
        System.out.println(""+ textoBoton);

        char simbolo = textoBoton.charAt(0);

        if (simbolo == 'C') {
            calculator.clearANS();
            display.setText("");  
        } 
        
        else if ((simbolo >= '0' && simbolo <= '9') || simbolo == 'e' || simbolo == 'p') // En caso de número
        {
            if (nuevo) {
                display.setText(""); 
            }
            if (textoBoton.equals("e"))
                display.setText(display.getText() + "2.718");
            else if (textoBoton.equals("pi"))
                display.setText(display.getText() + "3.1416");
            else 
                display.setText(display.getText() + simbolo);
            
            nuevo = false; 
        } 
        
        else if(simbolo=='+'||simbolo=='-'||simbolo=='*'||simbolo=='/'||simbolo=='=' || textoBoton.equals("x^-1")
                || textoBoton.equals("x^2") || textoBoton.equals("raiz") || textoBoton.equals("raiz 3") ||
                textoBoton.equals("sen") || textoBoton.equals("cos") || textoBoton.equals("tan") ||
                textoBoton.equals("e") || textoBoton.equals("pi")) 
        {
            double numero = Double.parseDouble(display.getText());
            int operacion = idOperaciones(textoBoton);

            calculator.operacion(numero, operacion, false);
            display.setText("" + calculator.getANS()); 

            nuevo = true;
        }
    }

    public void gestionarCE(java.awt.event.ActionEvent evt) {
        display.setText("");
        nuevo = true;
    }

    public int idOperaciones(String textoBoton) {

        switch (textoBoton) {
            case "+" -> {
                return 1;
            }
            case "-" -> {
                return 2;
            }
            case "*" -> {
                return 3;
            }
            case "/" -> {
                return 4;
            }
            case "x^-1" -> {
                return 5;
            }
            case "x^2" -> {
                return 6;
            }
            case "raiz" -> {
                return 7;
            }
            case "raiz 3" -> {
                return 8;
            }
            case "sen" -> {
                return 9;
            }
            case "cos" -> {
                return 10;
            }
            case "tan" -> {
                return 11;
            }
        }
        if (textoBoton.equals("=")) {
            return 0;
        }
        return 0;
    }

}
