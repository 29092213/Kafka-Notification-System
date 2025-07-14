# Sistema de Notificação de Chamados Assíncrono com Spring Boot e Kafka

## Este projeto implementa um sistema de registro de chamados com notificação assíncrona utilizando Spring Boot e Apache Kafka. Ao criar um novo chamado via API REST, os dados são persistidos em banco de dados e uma mensagem é enviada para o Kafka, permitindo processamento assíncrono e desacoplado.

### ✨ Funcionalidades Principais

* API REST para criação de chamados com validação de dados

* Persistência em banco de dados H2 (em memória)

* Integração com Apache Kafka para mensageria assíncrona

* Produção e consumo de eventos com desacoplamento de sistemas

* Respostas estruturadas em JSON com UUID do chamado

* Logging completo do fluxo de processamento

## 🛠️ Tecnologias Utilizadas

* Java 17+

* Spring Boot 3.1

* Spring Data JPA (persistência)

* Apache Kafka (mensageria)

* H2 Database (banco em memória)

* Maven (gerenciamento de dependências)

*Spring Validation (validação de dados)

## 📋 Estrutura do Projeto

```text
src/main/java
└── com/MessageKafka/testeKafka/
    ├── CONFIG/             # Configurações do projeto
    ├── CONTROLLER/         # Controladores REST
    │   └── ProductController.java
    ├── DTOs/               # Objetos de Transferência de Dados
    │   ├── MensagemPersonalizada.java
    │   └── ProductDto.java
    ├── MODEL/              # Entidades de domínio
    │   └── Product.java
    ├── REPOSITORIES/       # Interfaces de repositório
    │   └── ProductRepositorie.java
    ├── SERVICE/            # Lógica de negócio
    │   ├── ProductService.java
    │   └── ProductProducer.java
    └── CONSUMER/           # Consumidores Kafka
        └── ProductConsumer.java
````

## 🔌 Endpoints da API

* POST http://localhost:8080/kafka/RegisterChamado

````
Request:

json
{
  "nome": "Fulano de Tal",
  "message": "Problema no sistema de login"
}
````

* Response (201 Created):

````
json
{
  "message": "Um chamado foi criado com o id: ",
  "uuid": "a77d62e4-1478-d86a-93db-8a845deb871"
}
````

## 🚀 Como Executar o Projeto

### Pré-requisitos
 * Java 17+ SDK

* Maven

* Docker (para Kafka)

## 🚀 Passo a Passo para Iniciar o Kafka com Docker

* Navegue até o diretório do projeto
Abra o terminal e acesse a pasta onde está localizado o arquivo kafka-compose.yml:

````
bash
cd caminho/para/o/diretorio-do-projeto
````

* Inicie os containers, 
Execute o comando para subir os serviços em segundo plano:

````
bash
docker compose -f kafka-compose.yml up -d
````

* Verifique a execução, 
Aguarde a inicialização completa e verifique os containers ativos:

````
bash
docker ps
````

* Você deverá ver os containers do Kafka e Zookeeper com status Up

### Parar os serviços (quando necessário)

* Para interromper os containers e remover as instâncias:
````
bash
docker compose -f kafka-compose.yml down
````

### ⚠️ Notas Importantes:

* Verifique os logs em caso de problemas:

````
bash
docker compose -f kafka-compose.yml logs
````

# Mantenha os containers em execução enquanto a aplicação Spring Boot estiver rodando
