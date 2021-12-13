package com.arthurgroll.tarefa_io.exercicio2;

public class Usuario
{
    private int id;
    private String nome;
    private String observacao;
    
    public Usuario()
    {
        this.id = 0;
        this.nome = null;
        this.observacao = null;
    }
    
    public Usuario(int id, String nome, String observacao)
    {
        this.id = id;
        this.nome = nome;
        this.observacao = observacao;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getObservacao()
    {
        return observacao;
    }

    public void setObservacao(String observacao)
    {
        this.observacao = observacao;
    }
    
    // Aqui o método toString foi modificado para deixar mais fácil a escrita e leitura no arquivo de texto.
    @Override
    public String toString()
    {
        return this.id + "\\" +
                this.nome + "\\" +
                this.observacao + "\n";
    }
}
