package com.arthurgroll.lista2.exercicio2_heranca;

// Definição da classe Funcionario
public class Funcionario
{
    // Utilizando modificador protected, o que significa que as classes filhas (ou especializações,
    // em outras palavras, as "classes que forem herdar de Funcionario") terão acesso direto ao atributo.
    protected String nome; // Atributo nome
    protected String RG; // Atributo RG
    protected float totalVendas; // Atributo totalVendas
    
    // Definição do construtor padrão da classe Funcionario
    public Funcionario()
    {
        // Inicialização dos atributos
        this.nome = null;
        this.RG = null;
        this.totalVendas = 0.f;
    }
    
    // Definição dos Getters e Setters

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getRG()
    {
        return RG;
    }

    public void setRG(String RG)
    {
        this.RG = RG;
    }

    public float getTotalVendas()
    {
        return totalVendas;
    }

    public void setTotalVendas(float totalVendas)
    {
        this.totalVendas = totalVendas;
    }
}
