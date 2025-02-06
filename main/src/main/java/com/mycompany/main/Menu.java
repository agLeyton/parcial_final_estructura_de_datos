/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Menu extends JFrame {
 nuevo ventana = new nuevo(this);
       

    private Stack<Integer> pila = new Stack<>();
    private LinkedList<Integer> lista = new LinkedList<>();
    private Queue<Integer> cola = new LinkedList<>();
    private JTextArea areaTexto = new JTextArea(10, 30);

    public  Menu() {
        ventana.setSize(900, 600);
        setTitle("Estructuras de Datos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnPila = new JButton("Pila");
        JButton btnLista = new JButton("Lista");
        JButton btnCola = new JButton("Cola");
        JButton btnArbol = new JButton("Arbol");
         JButton btnEliminar = new JButton("Eliminar");

        btnPila.addActionListener(e -> Pila());
        btnLista.addActionListener(e -> Lista());
        btnCola.addActionListener(e -> Cola());
        btnArbol.addActionListener(e ->  ventana.setVisible(true));
         btnEliminar.addActionListener(e -> quitar_un_nodo());
        add(btnPila);
        add(btnLista);
        add(btnCola);
        add( btnArbol);
         add(btnEliminar);
        add(new JScrollPane(areaTexto));
    }
     private void quitar_un_nodo() {
        String tipo = JOptionPane.showInputDialog("Cual quiere modificar (Pila, Lista, Cola):");
        if (tipo == null) return;
        
        switch (tipo.toLowerCase()) {
            case "pila":
                if (!pila.isEmpty()) pila.pop();
                break;
            case "cola":
                if (!cola.isEmpty()) cola.poll();
                break;
            case "lista":
                if (!lista.isEmpty()) {
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite el número a eliminar:"));
                    lista.remove((Integer) numero);
                }
                break;
            default:
                JOptionPane.showMessageDialog(this, "Estructura no válida.");
        }
        actualizarTexto();
    }

    public void Pila() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un número:"));
        pila.push(numero);
        actualizarTexto();
    }

    public void Lista() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un número:"));
        lista.add(numero);
        actualizarTexto();
    }

    public void Cola() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un número:"));
        cola.add(numero);
        actualizarTexto();
    }

    public void actualizarTexto() {
        areaTexto.setText("Pila: " + pila + "\nLista: " + lista + "\nCola: " + cola);
    }

    
}
