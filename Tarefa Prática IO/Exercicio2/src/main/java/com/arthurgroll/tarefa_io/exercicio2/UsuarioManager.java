package com.arthurgroll.tarefa_io.exercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UsuarioManager
{
    // Definimos os atributos arquivo, que irá guardar o arquivo que contém os usuários, usuarios, que
    // irá guardar todos os usuários registrados, reader que usaremos para ler o arquivo que contém os
    // usuários e writer que usaremos para escrever os usuários lidos quando o programa terminar.
    private String arquivo;
    private Usuario[] usuarios;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public UsuarioManager()
    {
        // Inicializamos as variáveis reader, writer e arquivo com valores nulos, pois não temos
        // nenhum arquivo para trabalhar.
        this.arquivo = null;
        this.reader = null;
        this.writer = null;
        
        // Inicializamos usuarios com um array sem nenhuma posição de usuários, o que é praticamente o mesmo
        // que iniciar com null, porém evita possíves erros
        this.usuarios = new Usuario[0];
    }

    public UsuarioManager(String arquivo) throws IOException
    {
        // Inicializamos arquivo com o arquivo passado, reader e writer com FileReader e FileWriter abertos
        // para o arquivo informado.
        this.arquivo = arquivo;
        this.writer = new BufferedWriter(new FileWriter(this.arquivo, true));
        this.reader = new BufferedReader(new FileReader(this.arquivo));
        
        // Lemos o arquivo passado e obtemos a lista de usuários e a guardamos em usuarios.
        this.usuarios = obterUsuarios();
    }
    
    public boolean inserirUsuario(Usuario novoUsuario) throws IOException
    {
        // Para inserir um usuário, antes verificamos se ele já existe. Se existir, retornamos falso.
        // Se ele ainda não estiver presente na lista, continuamos o fluxo do método.
        for (int i = 0; i < this.usuarios.length; i++)
        {
            if (this.usuarios[i].equals(novoUsuario))
                return false;
        }
        
        // Inicializamos um vetor de usuários com o tamanho do vetor anterior com uma posição a mais,
        // pois teremos os mesmos usuários anteriores e um usuário novo passado para inserir nesse vetor
        Usuario[] newUsuarios = new Usuario[this.usuarios.length + 1];
        
        // Iteramos o vetor de usuários e atribuímos todos os usuários presentes nele para newUsuarios
        for (int i = 0; i < this.usuarios.length; i++)
            newUsuarios[i] = this.usuarios[i];
        
        // Adicionamos o usuário passado no vetor newUsuarios e atribuímos ao vetor usuarios esse novo vetor
        // contendo o novo usuário
        newUsuarios[this.usuarios.length] = novoUsuario;
        this.usuarios = newUsuarios;
        
        // Finalmente, retornamos verdadeiro, indicando que tudo ocorreu como deveria e o usuário foi adicionado com sucesso.
        return true;
    }
    
    public Usuario[] obterUsuarios() throws IOException
    {
        // Para obter os usuários do arquivo, declaramos as variáveis numLinha e linha.
        int numLinha = 0;
        String linha = "";
        
        // Primeiro obteremos o número de linhas no arquivo, para poder saber quantas posições devemos ter
        // no nosso vetor de usuários para obter as informações posteriormente. Para isso, passamos linha por linha
        // e incrementamos a variável numLinha para cada linha que passarmos.
        while (this.reader.readLine() != null)
        {
            numLinha++;
        }
        
        // Se o número de linhas for zero significa que não há nada dentro do arquivo, então retornamos um vetor com zero posições,
        // já explicado porque nos construtores.
        if (numLinha == 0)
            return new Usuario[0];
        
        // Depois que lemos todo o arquivo e passamos por todas as linhas, devemos chamar o método close para pararmos
        // de ler e abrir novamente um BufferedReader, para conseguir novamente ler do início do arquivo.
        this.reader.close();
        this.reader = new BufferedReader(new FileReader(this.arquivo));
        
        // Agora podemos criar o vetor de usuários com o número correto de posições
        Usuario[] usuarios = new Usuario[numLinha];
        
        // Resetamos numLinha para o usarmos como contador para iterar posteriormente o vetor usuarios a 
        // cada linha que vamos lendo do arquivo.
        numLinha = 0;
        
        while ((linha = this.reader.readLine()) != null)
        {
            // Aqui separamos o conteúdo da linha (que foi dividido com \ com id, nome e observação, respectivamente)
            String[] parametros = linha.split("\\\\");
            
            // Logo depois de separarmos o conteúdo da linha, criamos um usuário a partir deles e o salvamos na posição correspondente
            // do vetor e incrementamos numLinha.
            usuarios[numLinha] = new Usuario(Integer.parseInt(parametros[0]), parametros[1], parametros[2]);
            numLinha++;
        }
        
        // Por fim, retornamos o vetor de usuários com os usuários lidos do arquivo.
        return usuarios;
    }
    
    public void salvarUsuarios() throws IOException
    {
        // Inicializamos novamente o writer, mas dessa vez fora do modo append, pois iremos reescrever o
        // arquivo com o vetor de usuários atual
        this.writer = new BufferedWriter(new FileWriter(this.arquivo, false));
        
        // Iteramos o vetor de usuários e escrevemos cada usuário no arquivo alvo
        for (int i = 0; i < this.usuarios.length; i++)
        {
            this.writer.write(this.usuarios[i].toString());
        }
        
        // Fechamos o writer, liberando o arquivo para recursos do sistema operacional e salvando o arquivo
        this.writer.close();
    }

    public String getArquivo()
    {
        return arquivo;
    }

    public void setArquivo(String arquivo)
    {
        this.arquivo = arquivo;
    }
    
    public Usuario[] getUsuarios()
    {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios)
    {
        this.usuarios = usuarios;
    }

    public BufferedReader getReader()
    {
        return reader;
    }

    public void setReader(BufferedReader reader)
    {
        this.reader = reader;
    }

    public BufferedWriter getWriter()
    {
        return writer;
    }

    public void setWriter(BufferedWriter writer)
    {
        this.writer = writer;
    }
}
