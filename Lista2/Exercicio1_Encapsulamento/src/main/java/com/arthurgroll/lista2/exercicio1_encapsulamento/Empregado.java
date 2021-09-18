package com.arthurgroll.lista2.exercicio1_encapsulamento;

// Aqui definimos a classe empregado
public class Empregado
{
    private String nome; // Definimos o atributo nome, com modificador privado (só se pode acessar aqui dentro, na classe Empregado)
    private float salario; // Definimos o atributo salario, com modificador também privado
    
    public Empregado() // Criamos o construtor da classe Empregado
    {
        // Inicialmente, setaremos todos os valores como zero/null
        this.nome = null;
        this.salario = 0.f;
    }

    // Aqui criamos o método seletor (getter) do atributo nome
    public String getNome()
    {
        return nome;
    }
    
    // Aqui criamos o método modificador (algumas vezes também chamado de método mutante, que é o setter) do atributo nome
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    // Aqui criamos o método seletor de salario
    public float getSalario()
    {
        return salario;
    }

    // Aqui criamos o método modificador de salario
    public void setSalario(float salario)
    {
        this.salario = salario;
    }
    
    public float getImposto() // Nesse método retornaremos o imposto, que é 5% do salário do empregado
    {
        return this.salario / 20.f; // 5% é o mesmo que 5/100 que é o mesmo que 1/20, então podemos botar simplesmente this.salario / 20.f
    }
}
