# Gabaritos de Java
Gabaritos dos exercícios de Java propostos na disciplina de Programação II do curso de Desenvolvimento de Sisitemas do IFRS - Campus Canoas no ano de 2021
# Lista de gabaritos
- Lista 2 ✓
- Lista 3 ✓
- Lista 4 ✗
## Horários de atendimento
| Dia da semana | Horário |
| ------------- | ------- |
| Terça-feira | 18:00 - 20:00 |
| Quinta-feira | 19:00 - 21:00 |
## Erros relacionados à IDE Apache NetBeans e como criar o primeiro projeto
A grande maioria de erros relacionados ao netbeans se deve ao fato de:
- Não ter o JDK instalado
- Possuir o NetBeans desatualizado com uma versão do JDK atualizada
- Possuir o JDK desatualizado com uma versão do NetBeans atualizada
- Ter instalado o JDK e instalado o Apache NetBeans logo após, sem ter reinicializado o computador
Para garantir que você tenha a versão do JDK e do Apache NetBeans compatíveis, sempre baixe a versão do JDK e do NetBeans mais atualizadas.\
No momento, a versão do NetBeans mais atualizada é a 12.4 (https://netbeans.apache.org/download/nb124/nb124.html), e a do JDK é a 16 (https://www.oracle.com/java/technologies/downloads/#java16-windows).\
Para o processo de instalação, siga os seguintes passos:
- Instale o JDK mais atualizado
- Reinicie o computador após a instalação do JDK
- Instale a versão mais atualizada do Apache NetBeans

Além disso, quando for criar um projeto, lembre-se de criar com o Maven (Java with Maven -> Java Application). Depois de escolher essa opção, você pode receberuma requisição para baixar um arquivo jar. Baixe-o e continue.\
\
Após baixar o jar (se foi necessário), você irá para uma tela que irá requisitar o nome do projeto e o local. Além disso, existirão outras opções abaixo, como Group Id, Version e Package. Você pode mudar o Group Id para algo como com.nomeesobrenome.listax (como eu, que normalmente coloco com.arthurgroll.listax). Na versão, você pode deixar a padrão (1.0-SNAPSHOT), ou pode simplesmente botar como 1.0 ou alguma versão de sua preferência, e o package você pode deixar como está. Após isso, clique em "Finish".\
\
O nome do seu projeto aparecerá no canto esquerdo. Nele, você pode clicar no "+" para expandir o seu conteúdo. Expandindo a primeira vez, aparecerão algumas opções. Expanda a opção "Source packages". Nela você encontrará o pacote mostrado antes. Clique com o botão direito nele e vá em "New" e "Java Class...".\\
Lá você podera editar coisas como o nome da classe e o seu pacote. Recomendo editar apenas o nome da classe, pode botar o nome que você achar ideal. Após isso, clique em "Finish".\
\
Se você instalou corretamente o JDK e o NetBeans, uma classe será gerada, com "package pacote;" e "public class NomeDaClasse {". Dentro dessa classe, adicione a seguinte linha de código (dentro das chaves da classe, em outras palavras, dentro do escopo da classe):
```java
public static void main(String[] args) {

}
```
É nesse método que o programa começará. Você pode criar os objetos necessários e realizar o que for necessário aí.
## Dúvidas?
Se você estiver com alguma dúvida, não hesite em me chamar no whats: +55 51 (9)9503-0893\
Caso não queira me contatar por whats, pode me chamar no discord: Wanderer#2456
