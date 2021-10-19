package com.arthurgroll.lista4.exercicio2;

import java.util.Locale;

public class Main
{
    public static void main(String[] args)
    {
        // Mudando o locale para termos as casas decimais separadas por vírgula e não por ponto
        Locale.setDefault(new Locale("pt", "br"));
        
        // De forma semelhante ao exercício anterior, utilizaremos um método
        // para obter a média da soma do intervalo de 500 a 700 com um laço de repetição for
        System.out.printf("A média da soma dos números do intervalo de 500 a 700 é: %.2f\n", calcularMediaSomaIntervalo(500, 700));
        
        // Mais uma alternativa é adaptando o método de soma de Gauss utilizado
        // no exercício anterior:
        System.out.printf("A média da soma dos números do intervalo de 500 a 700 é: %.2f\n", mediaSomaIntervaloRapida(500, 700));
    }
    
    // Criamos um método que usaremos na main para calcular a média da soma do intervalo especificado
    private static double calcularMediaSomaIntervalo(int inicioIntervalo, int fimIntervalo)
    {
        // Inicializaremos com zero a variável que iremos utilizar para guardar
        // a soma dos números do intervalo especificado
        double somaIntervalo = 0;
        
        // Aqui definimos i como o valor inicial do intervalo mais 1 (nesse caso 201),
        // e continuaremos a somar até que i seja igual ao último número do intervalo (nesse caso 399, pois queremos um intervalo exclusivo, não incluindo nem 200 nem 400)
        for (int i = inicioIntervalo + 1; i < fimIntervalo; i++)
        {
            // Somamos o valor atual de contador com i, assim sempre que ocorrer
            // uma interação no laço iremos somar i, ao fim obtendo a soma total do intervalo especificado
            somaIntervalo += i;
        }
        
        // Por fim, retornamos a soma dividida pela quantidade de números no intervalo, que é fimIntervalo - inicioIntervalo - 1.
        return (double)somaIntervalo / (double)(fimIntervalo - inicioIntervalo - 1);
    }
    
    private static double mediaSomaIntervaloRapida(int inicioIntervalo, int fimIntervalo)
    {
        // Baseando-se na fórmula do exercício anterior, podemos ver que para obter a média simples
        // basta multiplicarmos fimIntervalo - inicioIntervalo, o que fará com que fiquemos
        // apenas com (inicioIntervalo + fimIntervalo) / 2.
        return (inicioIntervalo + fimIntervalo) / 2.0;
    }
}
