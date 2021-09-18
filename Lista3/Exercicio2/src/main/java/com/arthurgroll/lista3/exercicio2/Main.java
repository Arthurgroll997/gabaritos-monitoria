package com.arthurgroll.lista3.exercicio2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Locale.setDefault(Locale.US);                   // Definição do Locale para US (sempre que for ler números decimais (float/double), usar "." como separador decimal)
        Scanner scanner = new Scanner(System.in);       // Criamos uma instância da classe Scanner para ler o input do usuário
        int dia;                                        // Declaramos onde vamos guardar o dia da semana recebido do usuário
        
        System.out.println("Digite um dia da semana: ");
        dia = scanner.nextInt();                        // Lemos o dia digitado pelo usuário e guardamos o valor em dia
        
        System.out.print("O dia da semana é: ");
        
        switch (dia)                                    // Aqui utilizaremos switch-case, pois o código ficará mais limpo.
        {
            case 1:                                     // Caso o dia da semana for 1, imprimiremos "Domingo" na tela.
                System.out.println("Domingo");
                break;                                  // Saímos da estrutura switch
            case 2:                                     // Seguimos a mesma lógica acima para todos os outros casos.
                System.out.println("Segunda-feira"); 
                break;
            case 3:
                System.out.println("Terça-feira");
                break;
            case 4:
                System.out.println("Quarta-feira");
                break;
            case 5:
                System.out.println("Quinta-feira");
                break;
            case 6:
                System.out.println("Sexta-feira");
                break;
            case 7:
                System.out.println("Sábado");
                break;
            default:                                    // Caso o número digitado não esteja no intervalo [1, 7], o dia digitado é inválido.
                System.out.println("Dia inválido!");    // Não é necessário botar break no default, já que não temos nenhum outro case depois dele.
        }
        
        // Outra maneira para obter o dia da semana do usuário seria o seguinte:
        /*
            DayOfWeek diaSemana = DayOfWeek.from(LocalDate.of(2021, Month.AUGUST, ((dia > 0 && dia < 8) ? dia : 1))); // Criamos uma instância da classe DayOfWeek, para guardarmos o dia da semana. Se o dia for inválido, automaticamente escolhemos 1 (Domingo).
            String diaDaSemana = diaSemana.getDisplayName(TextStyle.FULL, new Locale("pt", "br")); // Setamos o locale para pt-br, para pegar o dia da semana em português
            diaDaSemana = diaDaSemana.substring(0, 1).toUpperCase() + diaDaSemana.substring(1); // Pegamos o primeiro caracter e o botamos em maiúsculo, e adicionamos o resto dos caracteres.
            System.out.println("O dia da semana é: " + diaDaSemana);
        */
    }
}
