package com.arthurgroll.lista2.exercicio1_encapsulamento;

import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);               // Definimos o locale para US (devemos utilizar ponto ao invés de vírgula quando precisarmos usar números decimais (float/double))
        Scanner scanner = new Scanner(System.in);   // Definimos uma instância da classe Scanner, para obtermos input do usuário
        Empregado empregado1 = new Empregado();     // Aqui nós criamos uma instância da classe Empregado chamada empregado1
        
        System.out.println("Digite o nome do empregado: ");
        empregado1.setNome(scanner.nextLine());             // Aqui definimos o nome de empregado1 para ser o que o usuário digitar
        
        System.out.println("Digite o salário de " + empregado1.getNome());
        empregado1.setSalario(scanner.nextFloat());         // Aqui definimos o salário de empregado1 para ser o que o usuário digitar
        
        // Abaixo nós setaremos o locale para PT-BR (para podermos mostrar a entrada formatada da forma correta,
        // mostraremos o nome do usuário obtendo-o utilizando o método seletor Empregado.getNome(), e o imposto utilizando
        // o método Empregado.getImposto().
        System.out.printf(new Locale("pt", "br"), "%s deve pagar um total de R$ %.2f de imposto.",
                empregado1.getNome(), empregado1.getImposto());
    }
}
