package com.arthurgroll.lista2.exercicio1_polimorfismo;

// Declaramos a classe Programador e herdamos de Empregado
public class Programador extends Empregado
{
    // Para fazer uso do polimorfismo (modificar um método da classe mãe (Empregado) para realizar
    // outra coisa na classe filha, usamos @Override e abaixo botamos o modificador, tipo de retorno, nome e argumentos/parâmetros (se algum)
    // do método que queremos sobrescrever. Isso fará com que sempre que chamarmos ele, o original da classe mãe será ignorado, e será chamado
    // o método modificado da classe que você chamou.
    @Override
    public void aumentarSalario()
    {
        this.salario += this.salario / 10.f;
    }
}
