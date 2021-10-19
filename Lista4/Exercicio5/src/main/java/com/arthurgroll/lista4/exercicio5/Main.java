package com.arthurgroll.lista4.exercicio5;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Utilizaremos a classe Intervalo para converter a String retornada pelo
// usuário no formato correto de intervalo
class Intervalo
{
    private String intervaloString;
    private int inicio;
    private int fim;
    
    public Intervalo(String intervalo)
    {
        this.intervaloString = intervalo;
        // Esse padrão é o que irá retirar a e b de [a, b], utilizando expressões regulares.
        Matcher matcher = Pattern.compile("(\\d{1,15})").matcher(this.intervaloString);
        matcher.find();
        this.inicio = Integer.parseInt(matcher.group());
        matcher.find();
        this.fim = Integer.parseInt(matcher.group());
    }
    
    // Utilizamos getInicio para obter o início do intervalo
    public int getInicio()
    {
        return this.inicio;
    }
    
    // Utilizamos getFim para obter o fim do intervalo
    public int getFim()
    {
        return this.fim;
    }
    
    // Utilizaremos getSoma para obter a soma dos números inteiros do intervalo,
    // da mesma maneira que fizemos no Exercício 1, só que como o intervalo é fechado
    // começamos com i = inicio e terminamos quando chegarmos no fim + 1
    public int getSoma()
    {
        int somaIntervalo = 0;
        
        for (int i = this.inicio; i < this.fim + 1; i++)
        {
            somaIntervalo += i;
        }
        
        return somaIntervalo;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escreva o intervalo utilizando o formato [a, b]: ");
        
        // Criamos o objeto intervalo da classe Intervalo, para obtermos
        // os valores de início e fim do intervalo quando necessário
        
        Intervalo intervalo = new Intervalo(teclado.nextLine());
        
        // Mostraremos o início, fim e a soma dos inteiros desse intervalo:
        System.out.println("Início: " + intervalo.getInicio());
        System.out.println("Fim: " + intervalo.getFim());
        System.out.println("Soma dos números inteiros do intervalo: " + intervalo.getSoma());
    }
}
