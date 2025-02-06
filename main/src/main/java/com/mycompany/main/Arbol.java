/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Stack;


public class Arbol {
    private Nodo raiz;

    public Nodo getRaiz() {
        return raiz;
    }

    public Arbol() {
        raiz = null; 
    }


    public void agregarNodo(int valor_numero) {
        Nodo nuevo_Nodo = new Nodo(valor_numero); 

        
        if (raiz == null) {
            raiz = nuevo_Nodo;
        } else {
            Nodo actual = raiz; 
            while (true) { 
                if (valor_numero < actual.valor_N) { 
                    if (actual.izquierda == null) {
                        actual.izquierda = nuevo_Nodo;
                        break; 
                    } else {
                        actual = actual.izquierda; 
                    }
                } else if (valor_numero > actual.valor_N) { 
                    if (actual.derecha == null) {
                        actual.derecha = nuevo_Nodo;
                        break; 
                    } else {
                        actual = actual.derecha; 
                    }
                } else {
                   
                    System.out.println("El nodo con valor " + valor_numero + " ya existe.");
                    break;
                }
            }
        }
    }


    public void mostrar() {
    

        Nodo actual = raiz; 
        Stack<Nodo> pila = new Stack<>(); 
        while (actual != null || !pila.isEmpty()) {
        
            while (actual != null) {
                pila.push(actual);
                actual = actual.izquierda;
            }

            actual = pila.pop();
            System.out.print(actual.valor_N + " "); 

           
            actual = actual.derecha;
        }
        System.out.println(); 
    }
}