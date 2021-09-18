package com.arthurgroll.lista2.exercicio1_polimorfismo;

// Aqui definimos a classe empregado
public class Empregado
{
    // Novamente, utilizamos protected com o objetivo de acessar diretamente o atributo em subclasses de Empregado
    protected String nome; // Definimos o atributo nome
    protected float salario; // Definimos o atributo salario
    
    public Empregado() // Criamos o construtor da classe Empregado
    {
        // Inicialização dos atributos
        this.nome = null;
        this.salario = 0.f;
    }

    // Acredito que tenha havido um equívoco no exercício. Para o uso de polimorfismo, necessitamos do método aumentarSalario aqui, e não nas classes especializadas
    // por isso, botem aqui o método aumentarSalario().
    // Além disso, eu defini o valor padrão de aumento de salário como 2%. Se você quiser, pode botar diferente, ou sequer botar.
    // O importante é que o método esteja declarado aqui.
    public void aumentarSalario()
    {
        this.salario += this.salario / 50.f;
    }
    
    // Método para retornar o imposto
    public float getImposto()
    {
        return this.salario / 20.f;
    }
    
    // Getters e Setters
    public String getNome()
    {
        return nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public float getSalario()
    {
        return salario;
    }

    public void setSalario(float salario)
    {
        this.salario = salario;
    }
}
