package com.arthurgroll.lista2.exercicio2_heranca;

public class Main
{
    public static void main(String[] args)
    {
        // Novamente, não é necessário escrever nada na main, pois o objetivo é apenas criar a classe Vendedor e herdar de Funcionario.
        Vendedor v = new Vendedor();
        
        System.out.println("Classe Vendedor: " + v.getClass().toString());
    }
}
