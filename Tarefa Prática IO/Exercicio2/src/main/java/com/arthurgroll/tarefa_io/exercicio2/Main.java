package com.arthurgroll.tarefa_io.exercicio2;

import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        // Criamos o scanner para usarmos para obter a entrada do usuário e uma variável para
        // guardar a opção escolhida pelo usuário
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        
        // Iniciamos um try-catch para tratar quaisquer exceções que surgirem
        try
        {
            // Criamos um objeto UsuarioManager que vai ter os métodos necessários para listar e
            // inserir novos usuários
            UsuarioManager userManager = new UsuarioManager("usuarios.txt");
            
            // Enquanto o usuário não escolher sair do programa (escolher a opção 2), continuamos a execução
            // do programa
            while (escolha != 2)
            {
                // Mostramos o menu e obtemos a escolha do usuário
                System.out.println("===== Exercício 2 =====");
                System.out.println("0 - Listar todos os usuários");
                System.out.println("1 - Inserir usuário");
                System.out.println("2 - Sair");
                System.out.println("Sua escolha: ");
                escolha = Integer.parseInt(sc.nextLine());

                // Filtramos a escolha do usuário
                if (escolha == 0)
                {
                    System.out.println("Lista de usuários:");
                    
                    // Obtemos o vetor de usuários e o guardamos em usuarios.
                    Usuario[] usuarios = userManager.getUsuarios();
                    
                    // Iteramos o vetor recebido e mostramos o nome, ID e uma observação de cada usuário
                    for (int i = 0; i < usuarios.length; i++)
                    {
                        System.out.println("===== " + usuarios[i].getNome() + " =====");
                        System.out.println("ID: " + usuarios[i].getId());
                        System.out.println("Observação: " + usuarios[i].getObservacao());
                        System.out.println("\n");
                    }
                }
                else if (escolha == 1)
                {
                    // Criamos um vetor parametros que irá gardar o ID, nome e observação do usuário que
                    // será adicionado, nessa ordem.
                    String[] parametros = new String[3];

                    // Obtemos o ID do usuário
                    System.out.println("Digite o ID do usuário: ");
                    parametros[0] = sc.nextLine();

                    // Obtemos o nome do usuário
                    System.out.println("Digite o nome do usuário: ");
                    parametros[1] = sc.nextLine();

                    // Obtemos uma observação do usuário
                    System.out.println("Digite uma observação do usuário: ");
                    parametros[2] = sc.nextLine();

                    // Criamos um novo objeto Usuario passando o ID, nome e observação, respectivamente. Caso seja retornado
                    // verdadeiro, informamos que o usuário foi adicionado com sucesso, caso contrário, o usuário já está registrado.
                    if (userManager.inserirUsuario(new Usuario(Integer.parseInt(parametros[0]), parametros[1], parametros[2])))
                        System.out.println("Usuário adicionado com sucesso!");
                    else
                        System.out.println("Usuário existente!");
                }
                else if (escolha == 2)
                {
                    // Se o usuário escolheu sair, salvamos os usuários
                    userManager.salvarUsuarios();
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
            // Mostramos os detalhes da exceção gerada para o usuário
            System.out.println("Exceção gerada: " + e.getMessage());
        }
    }
}
