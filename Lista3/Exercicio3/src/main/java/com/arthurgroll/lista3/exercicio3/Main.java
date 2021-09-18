package com.arthurgroll.lista3.exercicio3;

import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US); // Definindo a locale para US (lembrar de digitar números decimais (float/double) com "." para a parte decimal, e não vírgula)
        Scanner scanner = new Scanner(System.in); // Criamos uma instância da classe Scanner para pegarmos input do usuário
        float numero1, numero2; // Números que leremos
        int operacao; // Operação escolhida pelo usuário
        
        System.out.println("Digite um número: ");
        numero1 = scanner.nextFloat(); // Lemos o primeiro número
        
        System.out.println("Digite outro número: ");
        numero2 = scanner.nextFloat(); // Lemos o segundo número
        
        System.out.println("Digite a operação que você deseja realizar:\n" +
                "1 - Média entre os números digitados\n" +
                "2 - Diferença do maior pelo menor\n" +
                "3 - Produto entre os números digitados\nEscolha:");
        operacao = scanner.nextInt(); // Obtemos a operação requisitada pelo usuário
        
        switch (operacao) { // Filtramos a operação e imprimimos a saída correspondente
            case 1:
                System.out.println("A média dos números é: " + ((numero1 + numero2)/2.f));
                break;
            case 2:
                System.out.println("A diferença do maior pelo menor é: " + ((numero1 > numero2) ? numero1 - numero2 : numero2 - numero1)); // Poderia ser também Math.abs(numero1 - numero2), vai da preferência de cada um.
                break;
            case 3:
                System.out.println("O produto entre os números é: " + (numero1 * numero2));
                break;
            default:
                System.out.println("Operação inválida!"); // Lembrar que não é necessário o break no default se não existir nenhuma cláusula case depois dele
        }
    }
}
