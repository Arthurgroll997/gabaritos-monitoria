package com.arthurgroll.calculadora;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.*;

// Aqui definimos a classe Calculadora, que será usada para processar os cálculos
public class Calculadora
{
    // Aqui definimos os componentes que iremos utilizar
    private JFrame janelaPrincipal;
    private JPanel painelPrincipal;
    private JLabel lblNumero1, lblNumero2, lblResultado;
    private JButton btnLimpar, btnCalcular;
    private JTextField txtNumero1, txtNumero2;
    private JComboBox cmbOperacao;
    
    public Calculadora()
    {
        // Inicializamos os componentes que configuraremos posteriormente
        this.janelaPrincipal = new JFrame("Calculadora Swing");
        this.painelPrincipal = new JPanel(new GridLayout(4, 3));
        this.btnLimpar = new JButton("Limpar");
        this.btnCalcular = new JButton("Calcular");
        this.lblNumero1 = new JLabel("<html><span style=\"color: black;\">Número 1</span></html>");
        this.lblNumero2 = new JLabel("<html><span style=\"color: black;\">Número 2</span></html>");
        this.lblResultado = new JLabel("Resultado: ");
        this.txtNumero1 = new JTextField(5);
        this.txtNumero2 = new JTextField(5);
        this.cmbOperacao = new JComboBox(new String[]{"+", "-", "*", "/", "^"});
        
        // Chamamos o método que irá configurar os componentes da forma correta
        configurarJanela();
    }
    
    public void configurarJanela()
    {
        this.janelaPrincipal.setSize(300, 210); // Setamos o tamanho da janela
        this.janelaPrincipal.setResizable(false); // Definimos a janela com um tamanho estático, removendo a possibilidade de mudar suas dimensões de largura e altura
        this.janelaPrincipal.setVisible(true); // Deixamos o JFrame (janela do aplicativo) visível
        this.janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fazemos o programa fechar quando clicarmos no X
        
        // Deixamos a label que contém o resultado da operação como não visível, para a deixarmos visível apenas quando clicarmos no botão para calcular
        this.lblResultado.setVisible(false);
        
        // Definimos um método que irá ser chamado quando clicarmos no botão "Limpar"
        this.btnLimpar.addActionListener((ActionEvent e) -> {
            this.txtNumero1.setText(""); // Limparemos o conteúdo de txtNumero1
            this.txtNumero2.setText(""); // Limparemos o conteúdo de txtNumero2
            this.cmbOperacao.setSelectedIndex(0); // Selecionamos novamente a operação de soma (a operação inicial)
            if (this.lblResultado.isVisible()) this.lblResultado.setVisible(false); // Caso a lblResultado esteja visível, a deixamos invisível
        });
        
        // Definimos um método que irá ser chamado quando clicarmos no botão "Calcular"
        this.btnCalcular.addActionListener((ActionEvent e) -> {
            String textNum1 = this.txtNumero1.getText(); // Guardamos o conteúdo digitado em txtNumero1 (teoricamente o primeiro número)
            String textNum2 = this.txtNumero2.getText(); // Guardamos o conteúdo digitado em txtNumero2 (teoricamente o segundo número)
            
            if (!textNum1.matches("[0-9]{0,}[.]{0,1}[0-9]{1,}") || !textNum2.matches("[0-9]{0,}[.]{0,1}[0-9]{1,}")) // Utilizamos expressões regulares para verificar se os dois números são válidos
            {
                // Caso algum deles não seja válido, emitimos um erro
                JOptionPane.showConfirmDialog(null, "Um ou mais números inválidos!", "Erro 0x0001", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Definimos a mensagem de resultado que será mostrada ao usuário quando ele clicar no botão "Calcular"
            String mensagemResultado = "";
            
            // Transformamos a string que contém os números para o tipo double
            double num1 = Double.parseDouble(textNum1);
            double num2 =  Double.parseDouble(textNum2);
            
            // Verificamos a operação selecionada pelo usuário
            switch (this.cmbOperacao.getSelectedIndex())
            {
                case 0: // Caso a operação selecionada seja o índice 0 (+), somamos os números
                    mensagemResultado = String.format("%.2f", (float)(num1 + num2));
                    break;
                case 1: // Caso a operação selecionada seja o índice 1 (-), subtraímos o número 2 do número 1
                    mensagemResultado = String.format("%.2f", num1 - num2);
                    break;
                case 2: // Caso a operação selecionada seja o índice 2 (*), multiplicamos os números
                    mensagemResultado = String.format("%.2f", num1 * num2);
                    break;
                case 3: // Caso a operação selecionada seja o índice 3 (/), dividimos o número 1 pelo número 2
                    mensagemResultado = String.format("%.2f", num1 / num2);
                    break;
                case 4: // Caso a operação selecionada seja o índice 4 (^), elevaremos a base número 1 ao expoente número 2
                    mensagemResultado = String.format("%.2f", Math.pow(num1, num2));
                    break;
                default: // Caso a operação não seja nenhum dos índices acima, então a operação é inválida, e emitimos esse erro
                    JOptionPane.showConfirmDialog(null, "Operação inválida!", "Erro 0x0002", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
                    return;
            }
            
            // Caso a label com o resultado ainda não esteja visível, a deixamos visível
            if (!this.lblResultado.isVisible()) this.lblResultado.setVisible(true);
            
            // Definimos o texto da lblResultado, contendo o resultado com cores formatadas utilizando HTML e CSS
            this.lblResultado.setText(String.format("<html><span style=\"color: black;\">Resultado: </span><span style=\"color: #008000\">%s</span></html>", mensagemResultado));
        });
        
        // Adicionamos os componentes que configuramos no JPanel
        this.painelPrincipal.add(this.lblNumero1);
        this.painelPrincipal.add(new JLabel()); // Adicionamos uma label sem nada para espaçar os elementos
        this.painelPrincipal.add(this.lblNumero2);
        this.painelPrincipal.add(this.txtNumero1);
        this.painelPrincipal.add(this.cmbOperacao);
        this.painelPrincipal.add(this.txtNumero2);
        this.painelPrincipal.add(this.btnLimpar);
        this.painelPrincipal.add(new JLabel()); // Adicionamos uma label sem nada para espaçar os elementos
        this.painelPrincipal.add(this.btnCalcular);
        this.painelPrincipal.add(new JLabel()); // Adicionamos uma label sem nada para espaçar os elementos
        this.painelPrincipal.add(this.lblResultado);
        this.painelPrincipal.add(new JLabel()); // Adicionamos uma label sem nada para espaçar os elementos
        
        // Por fim, adicionamos o nosso painel na janela principal
        this.janelaPrincipal.getContentPane().add(this.painelPrincipal);
    }
}
