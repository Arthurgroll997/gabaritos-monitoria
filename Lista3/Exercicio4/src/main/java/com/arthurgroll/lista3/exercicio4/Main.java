package com.arthurgroll.lista3.exercicio4;

import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US); // Definindo a locale para US (lembrar de digitar números decimais (float/double) com "." para a parte decimal, e não vírgula)
        Scanner scanner = new Scanner(System.in); // Criamos uma instância da classe Scanner para pegarmos input do usuário
        float salario; // Salário do funcionário que obteremos com o Scanner
        final float aumento = 0.3f; // Criada uma constante de aumento para utilizar depois
        
        System.out.println("Digite o salário do funcionário: ");
        salario = scanner.nextFloat();
        
        // Na linha abaixo comparamos com um operador ternário se o salário do funcionário é superior ou igual à 500 reais.
        // Se for, falaremos que ele não terá seu salário aumentado. Se não, geramos uma string formatada, com o Locale
        // do Brasil, formatando o salário para duas casas decimais.
        
        System.out.println((salario >= 500.f) ?
                "O funcionário possui salário superior ao indicado para receber um aumento." :
                String.format(new Locale("pt", "br"), "O novo salário do funcionário é de R$ %.2f", salario + salario * aumento));
        
    }
}
