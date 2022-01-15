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

#### Provisionando a máquina virtual para rodar o sistema
$ vagrant up
```shell


Bringing machine 'default' up with 'virtualbox' provider...
==> default: Box 'ubuntu/bionic64' could not be found. Attempting to find and install...
default: Box Provider: virtualbox
default: Box Version: >= 0
==> default: Loading metadata for box 'ubuntu/bionic64'
default: URL: https://vagrantcloud.com/ubuntu/bionic64
==> default: Adding box 'ubuntu/bionic64' (v20220107.0.0) for provider: virtualbox
default: Downloading: https://vagrantcloud.com/ubuntu/boxes/bionic64/versions/20220107.0.0/providers/virtualbox.box
default: Progress: 16% (Rate: 3943k/s, Estimated time remaining: 0:01:33)

==> default: Clearing any previously set network interfaces...
==> default: Preparing network interfaces based on configuration...
default: Adapter 1: nat
default: Adapter 2: hostonly
==> default: You are trying to forward to privileged ports (ports <= 1024). Most
==> default: operating systems restrict this to only privileged process (typically
==> default: processes running as an administrative user). This is a warning in case
==> default: the port forwarding doesn't work. If any problems occur, please try a
==> default: port higher than 1024.
==> default: Forwarding ports...
default: 81 (guest) => 81 (host) (adapter 1)
default: 80 (guest) => 80 (host) (adapter 1)
default: 3306 (guest) => 33306 (host) (adapter 1)
default: 8080 (guest) => 38080 (host) (adapter 1)
default: 9000 (guest) => 9000 (host) (adapter 1)
default: 19999 (guest) => 19999 (host) (adapter 1)
default: 9001 (guest) => 9001 (host) (adapter 1)
default: 22 (guest) => 2222 (host) (adapter 1)
==> default: Running 'pre-boot' VM customizations...
==> default: Disk cannot be decreased in size. 30720 MB requested but disk is already 40960 MB.
==> default: Booting VM...
==> default: Waiting for machine to boot. This may take a few minutes...
default: SSH address: 127.0.0.1:2222
default: SSH username: vagrant
default: SSH auth method: private key


```


#### Verificando os provisionamentos de máquinas
+ https://stackoverflow.com/questions/10953070/how-to-debug-vagrant-cannot-forward-the-specified-ports-on-this-vm-message
$ vagrant global-status
+  vagrant global-status
   id       name    provider   state    directory
-----------------------------------------------------------------------------------------
49a5c50  default virtualbox poweroff /home/usuario/IdeaProjects/PROJETOS_LOCAIS_JAVAEE/javaee-sistema-controle-biblioteca/

$ ps -ef |grep VBox
+ usuario@computador ~/alura/CI_CD/JENKINS/1110-aula-inicial $ ps -ef |grep VBox
  root     22434     2  0 07:55 ?        00:00:00 [iprt-VBoxWQueue]
  root     22435     2  0 07:55 ?        00:00:00 [iprt-VBoxTscThr]


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

