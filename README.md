<h3> Turma Tasima - Design patterns, smalls and Refectory </h3>

<h4>Integrantes:</h4>

<ul style="list-style-type:square">
  <li><a href="https://github.com/alexsrosa">Alex</a><br></li> 
  <li><a href="https://github.com/LucasGentile">Lucas</a></li> 
</ul>  

<h4>Tecnologias utilizadas:</h4>

<ul style="list-style-type:square">
    <li><a href="https://www.java.com/pt_BR/download/faq/java8.xml">Java 8</a></li>
    <li><a href="http://projects.spring.io/spring-framework">Spring Framework</a></li> 
    <li><a href="https://projects.spring.io/spring-boot">Spring Boot</a></li> 
    <li><a href="http://www.liquibase.org">Liquibase</a></li> 
    <li><a href="https://gradle.org">Gradle</a></li>  
    <li><a href="http://www.h2database.com/html/main.html">Base H2</a></li> 
</ul>

<h1>LIQUIBASE</h1>

<h2>Introdução</h2>

<h3>O que é?</h3>

O Liquibase é uma ferramenta para evolução do schema de banco de dados de aplicações em Java.

<h3>Para que serve?</h3>

Para facilitar o vescionamento do banco de dados utilizado pela aplicação.

<h3>Principais características:</h3>

<ul style="list-style-type:square">
    <li>Suporte a branching e merging;</li>
    <li>Suporte a múltiplos desenvolvimentos;</li>
    <li>Suporte a multiplas bases (MySQL, PostgreSQL, Oracle, Sql Server, H2, etc.);</li>
    <li>Suporte a múltiplos tipos de formatos de configuração (XML, JSON, YAML e SQL);</li>
    <li>Suporte a contextos lógicos;</li>
    <li>Gerador de documentação de banco de dados;</li>
    <li>Gerador de comparações (DIFF);</li>
    <li>Gera automáticamente código SQL para revisão;</li>
    <li>Gera automáticamente código sql para revisão;</li>
    <li>Não requer conexão com banco de dados ativa;</li>
    <li>Possui código aberto e extensível (Licença Apache 2.0);</li>
</ul>

<h2>Intruçoes de instalação</h2>

<h4>Passo 1: Configuração da dependência</h4>

<p>Para utilizar o Liquibase em seu projeto Java, deve-se incluir a dependência no Maven ou Gradle do projeto, a fim de carregar as libs necessárias para utilização. </p>

Maven:<br>
```
<!-- https://mvnrepository.com/artifact/org.liquibase/liquibase-core -->
<dependency>
    <groupId>org.liquibase</groupId>
    <artifactId>liquibase-core</artifactId>
    <version>3.5.3</version>
</dependency>
```

Gradle:<br>
```
// https://mvnrepository.com/artifact/org.liquibase/liquibase-core
compile('org.liquibase:liquibase-core')

```
No caso da utilização do Gradle, será necessário também incluir a configuração "buildscript:dependencies:classpath" e o comando "Apply plugin", conforme exemplo abaixo:

```
buildscript {
	ext {
		springBootVersion = '1.5.8.RELEASE'
	}
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        classpath("org.liquibase:liquibase-gradle-plugin:1.2.4")
	}
}

apply plugin: 'org.liquibase.gradle'
```
<h4>Passo 2: Configuração do arquivo do Changelog</h4>

O arquivo changelog do banco de dados é onde todas as mudanças no banco de dados estão listadas e inicialmente é criado vazio e preenchido conforme ocorre alterações e evoluções no banco de dados. Pode possuir o formato de XML, YAML, JSON, SQL, entre outros possíveis. Abaixo segue dois exemplos, o primeiro em XML e o segundo no formato YAML:

Formato XML:
```
<?xml version="1.0" encoding="UTF-8"?>

<databaseChangeLog
  xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
         http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.1.xsd">

</databaseChangeLog>
```

Formato YAML:
```
databaseChangeLog:
```
O arquivo "db.changelog.xml" deve ser colocado no pacote "src/main/resources/db/changelog/".

<h2>Exemplos de uso</h2>

Com o Liquibase corretamente configurado e a aplicação desenvolvida com seus dominios (@Entity) estabelecidos, é possível executar o comando de geração de mudança do banco via Maven ou Gradle. 

Para começar a usar o Liquibase no banco de dados da aplicação, execute os dois comandos a seguir:


Gradle:<br>
```
gradlew changeLogSync

gradlew changeLogSync
```

Maven:<br>

```
mvn liquibase:generateChangeLog

mvn liquibase:changeLogSync
```

generateChangeLog: Efetua a geração do log de mudanças do banco de dados.
changeLogSync: Efetua o sincronismo do log de mudanças do banco de dados.


```
mvn install -Dliquibase.dropFirst=true
```
O argumento liquibase.dropFirst=true indica ao Liquibase que ele deve apagar todo o banco e executar todos os scripts SQL novamente. Se esse argumento não for informado, ou for igual a false, o Liquibase executará apenas os scripts que ainda não foram executados, pois ele controla os changeSets que já foram executados em uma tabela própria. Outra opção para fazer o Liquibase rodar os scripts do banco é executar o comando update do próprio plugin, como demonstrado a seguir:
```
mvn liquibase:update -Dliquibase.dropFirst=true
```


<h2>Referências</h2>

http://www.baeldung.com/liquibase-refactor-schema-of-java-app <br>
https://github.com/liquibase/liquibase-gradle-plugin <br>
https://github.com/stevesaliman/liquibase-workshop <br>
https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-liquibase <br>
https://www.devmedia.com.br/liquibase-gerenciando-mudancas-no-banco-de-dados-de-projetos-java/37434
