/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class nuevo extends JFrame {

    Arbol arbol = new Arbol();
    JTextField ingreso_Numero = new JTextField();
    JPanel panel;
    JFrame vista = new JFrame();
    private Menu menuPrincipal;

    public nuevo(Menu menu) {
        
        this.menuPrincipal = menu;

        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLayout(null);

        ingreso_Numero.setBounds(20, 20, 150, 25);
        add(ingreso_Numero);

        JButton Agregar = new JButton("Agregar ");
        JButton Volver = new JButton("Volver ");
        Agregar.setBounds(200, 20, 150, 25);
        Volver.setBounds(380, 20, 130, 25);
        add(Volver);
        add(Agregar);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Arbol_Mostrar(g);
            }
        };
        panel.setBounds(20, 60, 550, 300);
        panel.setBackground(Color.WHITE);
        add(panel);
        Volver.addActionListener(e -> {
            vista.setVisible(false);                                                                            
              menuPrincipal.setVisible(true); 
            
        });
        Agregar.addActionListener(e -> {
            try {
                int valor_numero = Integer.parseInt(ingreso_Numero.getText());
                arbol.agregarNodo(valor_numero);
                ingreso_Numero.setText("");
                panel.repaint();
                JOptionPane.showMessageDialog(null, "Se ingreso el nodo ");
            } catch (NumberFormatException ex) {

            }
        });

    }

    private void Arbol_Mostrar(Graphics g) {
        Nodo raiz = arbol.getRaiz();

        Vista_nodo(g, raiz, 450, 60, 100, 0);
    }

    private void Vista_nodo(Graphics g, Nodo nodo, int x, int y, int distancia, int nivel) {

        if (nodo != null) {

            g.setColor(Color.BLUE);
            g.fillOval(x - 20, y - 20, 40, 40);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(nodo.valor_N), x - 10, y + 5);

            if (nodo.izquierda != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x, y, x - distancia, y + 50);
                Vista_nodo(g, nodo.izquierda, x - distancia, y + 50, distancia / 2, nivel + 1);
            }
            if (nodo.derecha != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x, y, x + distancia, y + 50);
                Vista_nodo(g, nodo.derecha, x + distancia, y + 50, distancia / 2, nivel + 1);
            }
        }
    }
}
