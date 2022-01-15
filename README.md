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

### Pipeline CI/CD

#### Vagrant
+ https://www.vagrantup.com/docs/installation
```
curl -fsSL https://apt.releases.hashicorp.com/gpg | sudo apt-key add -
sudo apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main"
sudo apt-get update && sudo apt-get install vagrant

$ sudo apt-get install vagrant
Lendo listas de pacotes... Pronto
Construindo árvore de dependências       
Lendo informação de estado... Pronto
Os seguintes pacotes foram instalados automaticamente e já não são necessários:
  gyp libaudiofile1 libhttp-parser2.7.1 libjs-async libjs-inherits libjs-node-uuid liblo7 libuv1 libuv1-dev
Utilize 'sudo apt autoremove' para os remover.
The following additional packages will be installed:
  bsdtar libarchive-tools libarchive13 libsodium-dev ruby-bcrypt-pbkdf ruby-childprocess ruby-domain-name ruby-erubis ruby-ffi ruby-http-cookie ruby-i18n ruby-listen
  ruby-log4r ruby-mime-types ruby-mime-types-data ruby-net-scp ruby-net-sftp ruby-net-ssh ruby-netrc ruby-rb-inotify ruby-rbnacl ruby-rest-client ruby-unf
  ruby-unf-ext
Pacotes sugeridos:
  lrzip publicsuffix virtualbox
Pacotes recomendados:
  ruby-sqlite3 vagrant-libvirt
Os NOVOS pacotes a seguir serão instalados:
.........
vagrant is already the newest version (2.0.2+dfsg-2ubuntu8).
Os seguintes pacotes foram instalados automaticamente e já não são necessários:
  gyp libaudiofile1 libhttp-parser2.7.1 libjs-async libjs-inherits libjs-node-uuid liblo7 libuv1 libuv1-dev

```

##### Instalação de Providers para o Vagrant

```shell
sudo apt-get install   lrzip publicsuffix virtualbox
```

##### Instalação do Plugin vagrant-disksize
```shell
$ vagrant plugin install vagrant-disksize
Installing the 'vagrant-disksize' plugin. This can take a few minutes...
Fetching: vagrant-disksize-0.1.3.gem (100%)
Installed the plugin 'vagrant-disksize (0.1.3)'!


```



#### Jenkins
```shell

wget -q -O - https://pkg.jenkins.io/debian/jenkins-ci.org.key | apt-key add - 
sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list' 
apt-get update 
apt-get install jenkins
```    





### Instalação do Container Docker para o PostgreSQL

Executar o comando a seguir na raiz do projeto
```shell
mkdir postgres-data && docker run --name javaee-sistema-controle-biblioteca -v $(pwd)/postgres-data:/var/lib/postgresql/data -d -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=javaee-sistema-controle-biblioteca postgres:latest

```
Estamos mapeando a porta 5432 da nossa máquina para 5432 do Container onde rodamos o PostgreSQL na sua porta padrão.
Estamos mapeando também o diretório /var/lib/postgresql/data para nossa pasta postgres-data, na raiz do projeto

Referência: https://qastack.com.br/programming/37694987/connecting-to-postgresql-in-a-docker-container-from-outside

