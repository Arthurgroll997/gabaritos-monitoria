package com.arthurgroll.lista4.exercicio1;

public class Main
{
    public static void main(String[] args)
    {
        // Aqui chamaremos o nosso método calcularSoma com o intervalo definido
        // pelo exercício (de 200 a 400)
        System.out.println("A soma de 200 a 400 é: " + calcularSoma(200, 400));
        
        // Também é possível fazer essa soma de outra maneira mais eficiente,
        // utilizando o método de Gauss
        System.out.println("A soma de 200 a 400 é: " + somaGauss(200, 400));
    }
    
    // Criamos um método que usaremos na main para calcular a soma do intervalo
    private static int calcularSoma(int inicioIntervalo, int fimIntervalo)
    {
        // Inicializaremos com zero a variável que iremos utilizar para guardar
        // a soma dos números do intervalo especificado
        int somaIntervalo = 0;
        
        // Aqui definimos i como o valor inicial do intervalo mais 1 (nesse caso 201),
        // e continuaremos a somar até que i seja igual ao último número do intervalo (nesse caso 399, pois queremos um intervalo exclusivo, não incluindo nem 200 nem 400)
        for (int i = inicioIntervalo + 1; i < fimIntervalo; i++)
        {
            // Somamos o valor atual de contador com i, assim sempre que ocorrer
            // uma interação no laço iremos somar i, ao fim obtendo a soma total do intervalo especificado
            somaIntervalo += i;
        }
        
        // Por fim, retornamos a soma
        return somaIntervalo;
    }
    
    private static int somaGauss(int inicioIntervalo, int fimIntervalo)
    {
        // Aqui utilizamos o princípio da soma da progressão aritmética, que tem como fórmula
        // (a1 + an) * n / 2. Nesse caso podemos considerar o início do intervalo + 1 como a1, e
        // o fim do intervalo - 1 como an. O número de termos seria fimIntervalo - inicioIntervalo.
        // Podemos então simplificar 1 - 1 e ficamos com fimIntervalo - inicioIntervalo.
        // Para n, temos que de 200 a 400 existem 200 números, mas como desejamos apenas de 201 à 399,
        // teremos 199 números, que é o equivalente a fimIntervalo - inicioIntervalo - 1.
        return (inicioIntervalo + fimIntervalo) * (fimIntervalo - inicioIntervalo - 1) / 2;
    }
}
