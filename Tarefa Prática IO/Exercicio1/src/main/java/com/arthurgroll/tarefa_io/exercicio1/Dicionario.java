package com.arthurgroll.tarefa_io.exercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Dicionario
{
    // Declaramos os atributos que iremos utilizar na classe Dicionario
    private String arquivo;
    private String palavras[];
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public Dicionario()
    {
        // Caso não seja fornecido o arquivo para trabalharmos, inicializamos tudo menos o vetor palavras com null,
        // pois não temos como ler ou escrever já que não temos o arquivo que iremos trabalhar.
        this.arquivo = null;
        this.reader = null;
        this.writer = null;
        
        // Aqui inicializamos palavras com um vetor sem nenhuma posição, pois um vetor nulo pode
        // causar alguns problemas ao tentar iterá-lo, o que não acontece se inicializarmos dessa forma.
        this.palavras = new String[0];
    }
    
    public Dicionario(String arquivo) throws IOException
    {
        // Caso o usuário forneça o arquivo para trabalharmos, inicializamos o writer com um
        // objeto BufferedWriter para escrever no arquivo e não deletar o conteúdo anterior (no modo append,
        // que é explicitado no segundo parâmetro do FileWriter como true) e também inicializamos o reader com
        // um objeto BufferedReader, que iremos utilizar para ler o arquivo e obter as palavras contidas anteriormente,
        // caso o arquivo contenha alguma.
        this.arquivo = arquivo;
        this.writer = new BufferedWriter(new FileWriter(this.arquivo, true));
        this.reader = new BufferedReader(new FileReader(this.arquivo));
        
        // Aqui chamamos o método obterPalavras, que irá retornar todas as palavras presentes atualmente no dicionário
        this.palavras = obterPalavras();
    }
    
    public boolean inserirPalavra(String palavra)
    {
        // Antes de inserir a palavra, procuramos ela para ver se ela já está presente. Caso esteja,
        // retornamos falso, senão continuamos o fluxo do método.
        if (procurarPalavra(palavra))
            return false;
        
        // Criamos um novo array de palavras (já que no Java o tamanho dos arrays é estático, para adicionar
        // algum elemento é preciso criar outro) com o tamanho do vetor antigo mais um, já que quando adicionarmos mais uma palavra
        // precisaremos de mais um espaço no vetor
        String newPalavras[] = new String[this.palavras.length + 1];
        
        // Iteramos o vetor de palavras anterior e passamos todo o seu conteúdo para o novo vetor
        for (int i = 0; i < this.palavras.length; i++)
            newPalavras[i] = this.palavras[i];
        
        // Atribuímos o último espaço do vetor para ficar com a nova palavra, e definimos o atributo palavras
        // da classe com o vetor que agora possui a nova palavra
        newPalavras[this.palavras.length] = palavra;
        this.palavras = newPalavras;
        
        // Por fim, retornamos verdadeiro, o que indica que tudo ocorreu como deveria
        return true;
    }
    
    public String[] obterPalavras() throws IOException
    {
        // Para obter as palavras que já estão presentes no arquivo, criamos duas strings,
        // a linha, que será usada para obter a linha atual que está sendo lida do arquivo de texto,
        // e a linhaTot, que contém todas as linhas lidas até o momento separadas por um \n.
        String linha = "", linhaTot = "";
        
        // Enquanto a linha lida não for nula (ou seja, enquanto ainda há conteúdo para ler do arquivo),
        // adicionaremos a linha que foi lida para linhaTot, separada por um \n.
        while ((linha = this.reader.readLine()) != null)
        {
            linhaTot += linha + "\n";
        }
        
        // Se linhaTot não possui ao menos um caracter, significa que o arquivo está vazio, retornamos um vetor com nenhuma
        // posição, pois retornar um vetor nulo (que seria uma opção) pode gerar alguns problemas que são evitados com um vetor inicializado dessa forma.
        if (linhaTot.length() == 0)
            return new String[0];
        
        // Como adicionamos \n ao final de toda palavra, existe um \n depois da última palavra lida também. Para removê-lo,
        // damos um substring começando da posição 0 da string (o primeiro caracter) e que cortará tudo a partir do tamanho da string - 1,
        // ou seja, ficaremos com uma nova string que removerá o último caracter (\n).
        linhaTot = linhaTot.substring(0, linhaTot.length() - 1);
        
        // Finalmente, utilizamos o método split para separar as linhas (palavras) e poder guardá-las em um vetor de strings, que
        // ordenamos logo depois.
        String[] linhas = linhaTot.split("\n");
        Arrays.sort(linhas);
        
        // Retornamos o vetor de palavras
        return linhas;
    }
    
    public boolean procurarPalavra(String palavra)
    {
        // Para procurar uma palavra iteramos o vetor de palavras e comparamos uma a uma,
        // se forem iguais, significa que a palavra está no dicionário e retornamos verdadeiro,
        // caso tenhamos iterado o vetor inteiro e não foi encontrada a palavra recebida, retornamos falso.
        for (int i = 0; i < this.palavras.length; i++)
        {
            if (this.palavras[i].equals(palavra))
                return true;
        }
        
        return false;
    }

    public void salvarDicionario() throws IOException
    {
        // Para salvar inicializamos novamente o writer, mas dessa vez sem o modo append (para removermos
        // completamente o conteúdo anterior do dicionário)
        this.writer = new BufferedWriter(new FileWriter(this.arquivo, false));
        
        // Iteramos todas as palavras e escrevemos uma a uma no arquivo do dicionário
        for (int i = 0; i < this.palavras.length; i++)
            this.writer.write(this.palavras[i] + "\n");
        
        // Fechamos o writer, o que libera o arquivo para uso por outros recursos
        // do sistema operacional e salva as alterações feitas no arquivo.
        this.writer.close();
    }

    public String getArquivo() {
        return this.arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }
    
    public BufferedReader getReader() {
        return this.reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public BufferedWriter getWriter() {
        return this.writer;
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }

    public String[] getPalavras() {
        return this.palavras;
    }

    public void setPalavras(String[] palavras) {
        this.palavras = palavras;
    }
}
