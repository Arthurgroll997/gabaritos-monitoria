package com.arthurgroll.lista4.exercicio3;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Definimos a variável que guardaremos o input do usuário
        int numero;
        
        // Configuramos o scanner para receber o input do usuário
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite um número: ");
        numero = teclado.nextInt(); // Recebemos o input do usuário e guardamos o resultado
        
        // Printamos o resultado do fatorial
        System.out.println("O fatorial de " + numero + " é: " + calcularFatorial(numero));
        
        // Aqui utilizamos o mesmo algoritmo acima, mas usando recursão ao invés
        // de utilizar laços de repetição
        System.out.println("O fatorial de " + numero + " é: " + calcularFatorialRecursivo(numero));
    }
    
    public static int calcularFatorial(int numero)
    {
        // Definimos o total do fatorial, que será usado para guardar o resultado
        // das multiplicações como 1, pois 1 é o elemento nêutro da multiplicação
        // (assim como no início, normalmente quando queremos uma somatória,
        // utilizamos 0, que é o elemento nêutro da soma)
        int totFatorial = 1;
        
        // Iteramos o laço enquanto o número for maior ou igual a 1,
        // iremos multiplicá-lo pelo que já tinha havia anteriormente no total,
        // assim realizando o cálculo do fatoria.
        for (int i = numero; i >= 1; i--)
        {
            totFatorial *= i;
        }
        
        // Retornamos o valor calculado
        return totFatorial;
    }
    
    public static int calcularFatorialRecursao(int numero)
    {
        // Aqui calcularemos da seguinte forma: caso o número recebido seja
        // zero, retornamos ele. Se não, chamaremos a função novamente com o número
        // recebido - 1 multiplicado por ele mesmo, que depois de todas as chamadas
        // até chegar no número 1 retornará o resultado correto para todas as chamadas
        // anteriores dessa função e, por fim, retornará o fatorial que queremos.
        if (numero == 1) return numero;
        return numero * calcularFatorialRecursao(numero - 1);
    }
}
