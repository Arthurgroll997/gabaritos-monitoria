package com.arthurgroll.lista2.exercicio2_heranca;

// Aqui definimos a classe Vendedor.
// Para herdarmos algo de alguma classe, sempre botamos "extends ClasseQueQueremosHerdar".
// Uma curiosidade é que só podemos herdar de uma classe, então tome cuidado para não ter problemas
// com programas grandes que possuam várias classes.
// Não confundir isso com "classes que herdam de alguma outra classe serem impossibilitadas de serem herdadas".
// Em outras palavras, é sim possível ter uma classe B que herda da classe A, e existir uma classe C que herda da classe B.
// Em miúdos, existem muitos "níveis" ou "camadas" de herança.
public class Vendedor extends Funcionario
{
    private float valorComissao; // Atributo valorComissao (note, novamente, que só poderemos acessar esse atributo dentro da classe Vendedor, independentemente de herança)
    
    public Vendedor()
    {
        // Note que chamando "super()" chamamos o construtor da classe Funcionario, ou seja, chamamos o construtor da classe mãe.
        // Isso é útil, pois não precisamos setar o nome ou o RG para null, pois isso já está no construtor da classe Funcionario.
        super();
        this.valorComissao = 0.f; // Inicializamos o atributo valorComissao
    }
    
    // Método que calculará o valor da comissão
    public float getComissao()
    {
        return this.valorComissao = this.totalVendas / 20.f; // Poderíamos usar também this.getTotalVendas() no lugar de this.totalVendas
    }
    
    // Getters e setters
    // Note também que não é necessário criar getters e setters para os atributos da classe Funcionario, pois como herdamos dela,
    // automaticamente já recebemos todos os atributos (tirando os atributos private) e métodos (também sem private), e todos estarão disponível para uso dentro dessa classe, e
    // dependendo do modificador (se for public, por exemplo) fora dela também.
    public float getValorComissao()
    {
        return valorComissao;
    }

    public void setValorComissao(float valorComissao)
    {
        this.valorComissao = valorComissao;
    }
}
