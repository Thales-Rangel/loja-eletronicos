# 📱 Loja de Eletrônicos - Auratech 💻

## 1. Objetivos do projeto

O projeto foi desenvolvido com uma ideia de uma aplicação escalável para uma loja de eletrônicos que deseja oferecer seus produtos de forma online.

A aplicação deve ter um sistema de gerenciamento de produtos e usuários, além claro do procedimentos de compra e pagamento dos produtos. Essas são algumas das principais funcionalidades:

- Permitir gerenciamento de usuários
- Permitir gerenciamento de produtos
- Permitir fazer lista de produtos
- Permitir fazer pedidos de compra de produtos
- Conter formas de pagamentos

## 2. Arquitetura

A aplicação é dividida em uma aplicação [backend](/auratech/) e outra front end, cada uma terá sua documentação disponibilizada para consulta.

De forma geral, o backend foi desenvolvido usando Java 21 com Maven, Spring Boot e banco de dados MySQL, e o frontend foi baseado em React JS.

Para mais detalhes a cerca da arquitetura das aplicações, acesse a [documentação](/auratech/README.md) das aplicações.

## 3. Execução

A escalar a aplicação como um todo será necessário ter [Docker](https://www.docker.com/) instalado no ambiente, e então fazer o deploy da aplicação através do [docker compose](compose.yaml) disponibilizado, abaixo segue os comandos para a execução da aplicação:

    docker compose --project-name loja-de-eletronicos up -d

## 4. Alterações

O projeto segue a licença do [MIT](LICENSE) e está aberto para quaisquer tipo de alterações.

Recomenda-se utilizar o Git Flow definido para a adição de novas features.