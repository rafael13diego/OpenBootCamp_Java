package com.example;

public class GestorFacturas {

    //1.Atributos
    Calculadora calculadora;
    String nombre;

    //2.Constructores
    public GestorFacturas(Calculadora calculadora, String nombre){
        System.out.println("Soy el constructor de GestorFacturas");
        this.calculadora = calculadora;
        this.nombre = nombre;
    }

    //3.Métodos
}
