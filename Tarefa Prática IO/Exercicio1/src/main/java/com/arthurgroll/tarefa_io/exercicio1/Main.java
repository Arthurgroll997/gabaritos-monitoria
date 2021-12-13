package com.arthurgroll.tarefa_io.exercicio1;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Criamos um objeto scanner para conseguir input do usuário
        Scanner sc = new Scanner(System.in);
        
        // Inicializamos uma seção de try-catch para manipular qualquer erro que aconteça (principalmente de I/O)
        try
        {
            // Criamos o objeto dicionario para todas as ações necessárias de procura, inserção e listagem
            // de palavras, e a variável escolha, que irá guardar a opção desejada pelo usuário.
            Dicionario dicionario = new Dicionario("dicionario.txt");
            int escolha = 0;
            
            // Enquanto o usuário não desejar sair, continuamos o programa
            while (escolha != 3)
            {
                // Mostramos o menu e recebemos a escolha do usuário
                System.out.println("===== Dicionário =====");
                System.out.println("0 - Listar palavras");
                System.out.println("1 - Pesquisar palavra");
                System.out.println("2 - Inserir palavra");
                System.out.println("3 - Sair");
                System.out.println("Sua escolha: ");
                escolha = Integer.parseInt(sc.nextLine());
                
                // Filtramos a escolha
                switch (escolha)
                {
                    // Caso seja a listagem, obtemos as palavras presentes no dicionário e as ordenamos
                    // com o método sort da classe Arrays. Após isso iteramos o vetor palavras onde guardamos
                    // as palavras e o imprimimos na tela.
                    case 0:
                        {
                            System.out.println("As palavras presentes são:");
                            String[] palavras = dicionario.getPalavras();
                            Arrays.sort(palavras);

                            for (int i = 0; i < palavras.length; i++)
                                System.out.println(palavras[i]);

                            break;
                        }
                    // Caso a opção seja de pesquisa da palavra, obtemos a palavra que o usuário deseja
                    // buscar e utilizamos o método procurarPalavra, que retornará verdadeiro caso
                    // a palavra esteja presente no dicionário e falso caso contrário, e mostramos a saída
                    // correspondente para o usuário.
                    case 1:
                        {
                            System.out.println("Digite a palavra que você quer pesquisar:");
                            String palavra = sc.nextLine();

                            if (dicionario.procurarPalavra(palavra))
                                System.out.println("Esta palavra está presente no dicionário!");
                            else
                                System.out.println("Esta palavra não está no dicionário!");

                            break;
                        }
                    // Caso o usuário deseje adicionar uma nova palavra ao dicionário, obtemos essa palavra e
                    // invocamos o método inserirPalavra, que retornará verdadeiro caso a inserção ocorra de forma
                    // correta e falso caso a palavra já esteja presente no dicionário.
                    case 2:
                        {
                            System.out.println("Digite a palavra a ser adicionada:");

                            String palavra = sc.nextLine();

                            if (dicionario.inserirPalavra(palavra))
                                System.out.println("Palavra adicionada com sucesso!");
                            else
                                System.out.println("Palavra já presente no dicionário!");

                            break;
                        }
                    // Por fim, se o usuário deseja sair, salvamos as palavras no arquivo do dicionário e
                    // retornamos, finalizando o programa.
                    case 3:
                        {
                            dicionario.salvarDicionario();
                            return;
                        }
                }
                
                // Utilizamos System.in.read() para não pular diretamente para o menu, para que o usuário
                // tenha tempo de ler o que foi mostrado para ele. Após o usuário pressionar qualquer tecla
                // do sistema, o programa irá continuar normalmente.
                System.out.println("Pressione alguma tecla para continuar...");
                System.in.read();
            }
        }
        catch (Exception e)
        {
            // Caso tenha acontecido algum erro, informamos ao usuário
            System.out.println("Exceção gerada: " + e.getMessage());
        }
    }
}
