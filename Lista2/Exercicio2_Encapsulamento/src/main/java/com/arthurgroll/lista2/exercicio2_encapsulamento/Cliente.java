package com.arthurgroll.lista2.exercicio2_encapsulamento;

// Aqui definimos a classe empregado
public class Cliente
{
    private String nome; // Definimos o atributo nome, com modificador privado
    private float totalDespesas; // Definimos o atributo totalDespesas
    
    public Cliente() // Criamos o construtor da classe Cliente
    {
        // Inicialmente, setaremos todos os valores como zero/null
        this.nome = null;
        this.totalDespesas = 0.f;
    }

    public float getGorjeta() // Esse método retornará o valor total a pagar de gorjeta.
    {
        return this.totalDespesas / 10.f;
    }
    
    // Getters e setters de cada atributo abaixo:
    
    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public float getTotalDespesas()
    {
        return totalDespesas;
    }

    public void setTotalDespesas(float totalDespesas)
    {
        this.totalDespesas = totalDespesas;
    }
}
