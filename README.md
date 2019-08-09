## Estrutura do projeto

Projeto utilizando Java, Maven, Junit, Selenium e Jayway Rest Assured.

- src/main/java : contém o código com a aplicação que cadastra os filmes.
- src/main/resources : onde serão salvos os registros da aplicação no arquivo diretores.csv
- src/test/java : contém os testes de UI com selenium e API com jayway. Ambos executados pelo Junit.
- src/test/resources : Após a execução dos testes de UI o resultado da busca será salvo no arquivo Resultado.txt

## Configuração necessária

Instalar na máquina:
- [Java JDK 8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) - Configurar suas variáveis de ambiente
- [Maven](https://maven.apache.org/download.cgi)  - Configurar suas variáveis de ambiente
- Chrome (Versão 76) - O driver do chrome versão 76 está dentro da pasta 'Resources', talvez seja necessário atualizar seu navegador.

Após clonar o projeto, acessar a pasta e executar o comando: ``` mvn install -DskipTests ```

## Aplicação - Cadastro de filmes

A aplicação cadastra o nome do diretor, data de nascimento, filme e ano de lançamento. Após a inclusão do ano de lançamento o usuário tem a opção de digitar "sair" para encerrar a aplicação, ou digitar enter e cadastrar um novo registro com estes dados. Após o termino, os dados ficam salvos no arquivo *src/main/resources/diretores.csv*, que por sua vez servirá como entrada de dados para o teste de UI.

### Executar a aplicação

*Acesse a raiz do projeto via Prompt de comando: e use o comando:* ``` mvn exec:java -Dexec.mainClass=br.com.automacao.Filmes ``` 

## Testes - Busca de filmes

O teste de UI lê o nome e o filme cadastrado pela aplicação anterior e realiza sua busca. Após a execução, o resultado fica salvo no arquivo *src/test/resources/Resultado.txt*

### Executar o teste

*Acesse a raiz do projeto via Prompt de comando: e use o comando:* ``` mvn test -Dtest=br.com.automacao.UI.PesquisaGoogleTeste ``` 

## Teste de API - Get

Teste que realizar um get no endpoint *https://jsonplaceholder.typicode.com/todos/1* e valida se o status de retorno esta ok (200), além do texto em "title" e valor em "completed".

### Executar o teste

*Acesse a raiz do projeto via Prompt de comando: e use o comando:*  ``` mvn test -Dtest=br.com.automacao.API.ValidaMensagemGET ``` 