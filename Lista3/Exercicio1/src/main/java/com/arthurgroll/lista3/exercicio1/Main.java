package com.arthurgroll.lista3.exercicio1;

import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Observação importante: você deverá utilizar "." para números decimais (float/double), porque o Locale foi setado para tal.
        Locale.setDefault(Locale.US);
        
        Scanner scanner = new Scanner(System.in);   // Criamos a instância de scanner para obter os números
        float numero1, numero2;                     // Definimos os números que iremos obter
        
        System.out.println("Digite um número: ");
        numero1 = scanner.nextFloat();              // Obtemos o primeiro número
        
        System.out.println("Digite outro número: ");
        numero2 = scanner.nextFloat();              // Obtemos o segundo número
        
        // Aqui realizaremos a comparação com um operador ternário: se o numero1 for maior que numero2, imprimiremos numero2, porque ele é maior, senão, imprimimos numero1
        // Vale lembrar que caso os números forem iguais ele irá imprimir o primeiro número. Logo, não existe mensagem caso os números sejam iguais, mas você pode fazer utilizando if/else se quiser.
        System.out.println("O menor número é: " + ((numero1 > numero2) ? numero2 : numero1));
        
        // Caso você quisesse fazer a comparação para números iguais, uma das soluçõe seria a descrita abaixo:
        /*
            if (numero1 != numero2)
            {
                System.out.println("O menor número é: " + ((numero1 > numero2) ? numero2 : numero1));
            }
            else
            {
                System.out.println("Os números são iguais!");
            }
        */
    }
}
