package com.arthurgroll.lista2.exercicio2_polimorfismo;

public class Gerente extends Empregado
{
    // Novamente, utilizaremos @Override para fazer uso do polimorfismo, como já foi explicado no exercício 1 de polimorfismo
    @Override
    public void aumentarSalario()
    {
        this.salario += this.salario * 0.15f;
    }
}
