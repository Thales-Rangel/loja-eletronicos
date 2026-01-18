# 👨🏾‍💻 Backend - Loja de Eletrônicos - Auratech 🗄️

## 1. Objetivo

Aqui foi desenvolvido toda a lógica de negócios da aplicação, básicamente todas as regras para interação do front end com o sistema além da lógica para a manipulação de dados no database.

## 2. Arquitetura e Stacks

A aplicação foi desenvolvida com uma arquitetura de classes [orientada a objetos](https://www.alura.com.br/artigos/poo-programacao-orientada-a-objetos), dividida em uma estrutura de camadas.

Para entender melhor sobre a estrutura de dados, siga a documentação.

### Detalhes do Stack e Integrações

- A implementação é feita em [Java](https://www.java.com/pt-BR/download/help/whatis_java.html) [21](https://docs.oracle.com/en/java/javase/21/)
- Uso do framework [Spring Boot](https://spring.io/projects/spring-boot)
- Persistência de dados feita em [MySQL](https://dev.mysql.com/doc/), acesse o modelo de dados uma visualização da estrutura de dados
- Todas as bibliotecas usadas podem ser vistas no [pom.xml](/auratech/pom.xml)

## 3. Execução

A aplicação já é carregada ao executar o projeto pelo [docker compose](../compose.yaml).

Caso deseje executar a aplicação separadamente, pode-se ser feito, também, através do `docker` pelo seguinte comando:

    docker run ...

## 4. Alterações

As regras para as alterações seguem as mesmas descritas no [README principal](../README.md) e está submetido a mesma [licença](../LICENSE).