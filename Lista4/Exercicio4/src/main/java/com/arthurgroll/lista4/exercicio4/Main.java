package com.arthurgroll.lista4.exercicio4;

public class Main
{
    public static void main(String[] args)
    {
        // Assim como no primeiro exercício, obteremos o resultado da soma retornado pela função calcularSomaPares
        System.out.println("A soma dos pares de 100 a 500 é: " + calcularSomaPares(100, 500));
        
        // Também é possível fazer essa soma de outra maneira mais eficiente,
        // utilizando o método de Gauss com algumas pequenas alterações
        System.out.println("A soma dos pares de 100 a 500 é: " + calcularSomaParesRapida(100, 500));
    }
    
    // Criamos um método que usaremos na main para calcular a soma do intervalo
    private static int calcularSomaPares(int inicioIntervalo, int fimIntervalo)
    {
        // Inicializamos a variável que guardará o resultado da soma
        int somaIntervalo = 0;
        
        // Iteramos os números presentes no intervalo e, se pares (ou seja, se não
        // tiverem resto de divisão por 2), serão somados em somaIntervalo
        for (int i = inicioIntervalo + 1; i < fimIntervalo; i++)
        {
            if (i % 2 == 0) somaIntervalo += i;
        }
        
        // Por fim, retornamos somaIntervalo
        return somaIntervalo;
    }
    
    private static int calcularSomaParesRapida(int inicioIntervalo, int fimIntervalo)
    {
        
        // Utilizando a soma de Gauss, podemos considerar como os números iniciais e finais os primeiros
        // números pares no intervalo, e a quantidade de números pares seria o total dividido por dois,
        // e então só utilizamos a fórmula e obtemos o resultado da soma dos pares.
        int inicioPar = inicioIntervalo + 1 % 2 == 0 ? inicioIntervalo + 1 : inicioIntervalo + 2;
        int fimPar = fimIntervalo - 1 % 2 == 0 ? fimIntervalo - 1 : fimIntervalo - 2;
        int qntdNumerosPares = (fimPar - inicioPar) / 2 + 1;
        
        return (inicioPar + fimPar) * qntdNumerosPares / 2;
    }
}
