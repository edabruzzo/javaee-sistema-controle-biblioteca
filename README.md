# Sistema de Controle de Bibliotecas 

## Tecnologias utilizadas

### JAVA 8
### IDE: IntelliJ Idea
### JAVA Enterprise --> JAVA EE 6
    #### JPA - JAVA PERSISTENCE API
        + https://docs.oracle.com/cd/E16439_01/doc.1013/e13981/usclient005.htm
        + https://tomee.apache.org/examples-trunk/injection-of-entitymanager/    
### Frontend -> JSF 2.1 / Primefaces 11.0
### Servidor de aplicação -> Wildfly 19.1.0.Final
### Injeção de dependência: CDI 1.2
### Banco de dados relacional -> PostgreSQL 
### Docker


### Instalação do Container Docker para o PostgreSQL

Executar o comando a seguir na raiz do projeto
```shell

mkdir postgres-data && docker run --name javaee-sistema-controle-biblioteca -v $(pwd)/postgres-data:/var/lib/postgresql/data -d -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=javaee-sistema-controle-biblioteca postgres:latest

```
Estamos mapeando a porta 5432 da nossa máquina para 5432 do Container onde rodamos o PostgreSQL na sua porta padrão.
Estamos mapeando também o diretório /var/lib/postgresql/data para nossa pasta postgres-data, na raiz do projeto

Referência: https://qastack.com.br/programming/37694987/connecting-to-postgresql-in-a-docker-container-from-outside

