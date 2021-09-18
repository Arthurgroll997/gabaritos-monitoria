package com.arthurgroll.lista2.exercicio2_encapsulamento;

import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);               // Definimos o locale para US (devemos utilizar ponto ao invés de vírgula quando precisarmos usar números decimais (float/double))
        Scanner scanner = new Scanner(System.in);   // Definimos uma instância da classe Scanner, para obtermos input do usuário
        Cliente cliente1 = new Cliente();           // Criamos uma instância da classe Cliente
        
        System.out.println("Digite o nome do cliente: ");
        cliente1.setNome(scanner.nextLine());             // Aqui definimos o nome de cliente1
        
        System.out.println("Digite o total de despesas de " + cliente1.getNome());
        cliente1.setTotalDespesas(scanner.nextFloat());         // Aqui definimos o total de despesas de cliente1
    
        // Abaixo mostraremos com o locale PT-BR o nome do cliente e a gorjeta que ele deve pagar.
        System.out.printf(new Locale("pt", "br"), "%s deve pagar em gorjeta R$ %.2f",
                cliente1.getNome(), cliente1.getGorjeta());
    }
}
