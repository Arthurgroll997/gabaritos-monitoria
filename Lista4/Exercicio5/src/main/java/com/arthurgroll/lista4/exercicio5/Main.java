package com.arthurgroll.lista4.exercicio5;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


class Intervalo
{
    private String intervaloString;
    private int inicio;
    private int fim;
    
    public Intervalo(String intervalo)
    {
        this.intervaloString = intervalo;
        // Esse padrão é o que irá retirar a e b de [a, b], utilizando expressões regulares.
        Matcher matcher = Pattern.compile("[(\\d{1, 15}), (\\d{1, 15})]").matcher(this.intervaloString);
        if(matcher.find())
        {
            this.inicio = Integer.parseInt(matcher.group(0));
            this.fim = Integer.parseInt(matcher.group(1));
        }
    }
    
    public int getInicio()
    {
        return this.inicio;
    }
    
    public int getFim()
    {
        return this.fim;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        Intervalo intervalo = new Intervalo(teclado.nextLine());
        
        System.out.println("Início: " + intervalo.getInicio());
        System.out.println("Fim: " + intervalo.getFim());
        
        // Assim como no primeiro algoritmo, podemos calcular a soma 
        
    }
    
    
}
