package com.arthurgroll.calculadora;

import java.util.Locale;

/***************************************************************************************************
 *   AVISO: Não foi definida a quantidade de operações necessárias, portanto o                     *
 *   gabarito irá conter cinco operações: soma, subtração, multiplicação, divisão e potenciação.   *
 *   Sinta-se livre para fazer mais ou menos operações.                                            *
 ***************************************************************************************************/

// Classe principal
public class Main
{
    // Método main
    public static void main(String[] args)
    {
        Locale.setDefault(new Locale("en", "US")); // Setamos o Locale para en-US, para utilizarmos ponto ao invés de vírgula com números decimais
        new Calculadora(); // Criamos o objeto da calculadora, que será a nossa janela
    }
}
