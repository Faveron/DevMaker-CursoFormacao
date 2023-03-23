# Projeto final

## devmakers2 | Técnicas de programação I

### Operações bancárias

Este projeto simula um sistema interno para um operador do banco registrar as operações do dia a dia.

## Requisitos

- As principais funcionalidades do menu da classe `BancoController` devem ser implementadas
- Deve ser criado as classes de serviço (_service_) dos dominios
- O projeto deve gerar um arquivo para todas as contas dentro da pasta __/database/contas__ (modelo como exemplo, não precisa ser seguido a risca)
- O projeto deve gerar um arquivo de transações para cada conta dentro da pasta __/databse/transacoes__ (modelo como exemplo, não precisa ser seguido a risca)
- O projeto deve gerar um arquivo de relatorio para cada relatório solicitado dentro da pasta __/database/relatorios__ (modelo como exemplo, não precisa ser seguido a risca)

## Regras

- O titular e CPF da conta são obrigatórios;
- Um único arquivo para contas;
- Relatorios e transações: um arquivo para cada conta (nomeie o arquivo como quiser)
- Na interface `CaminhosConfig` deve conter o caminho absoluto para o seu projeto e todo o projeto deve usar essa variavel para os arquivos pois para testar vou mudar somente esse caminho e tudo deve funcionar
- No momento não precisamos de regras para SAQUE e DEPOSITO, podendo ficar com saldo negativo

### Controller

A camada de controller é o ponto de entrada da sua aplicação, ela já vem quase toda escrita, você deve usá-la para chamar o devido __Serviço__(_service_)

Toda a comunicação da Controller com o Service deve ser feita através de DTO's. Use `dto.FiltroRelatorioDTO` como exemplo.

### Dominio

As classes de dominio `Conta` e `Transacao` já estão criadas com os seguintes atributos
- A conta contem: **id**:string, **titular**:string, **cpf**:string e a **dataCriacao**:instant
- A Transacao contem: **id**:string, **tipo**:transacao.tipo, **valor**:bigdecimal e a **dataCriacao**:instant

Elas servem para definir o que será persistido nos arquivos.

### Serviço

As classes de __serviço__(_service_) devem ser utilizadas para realizar toda a lógica de negócio da aplicação, como por exemplo, validar
se o valor, informado pelo usuário, para depósito não é negativo ou letras;

Aqui também devem ser tratadas as possíveis __exceptions__ lançadas pelos repositorios.

Daí então chama as classes de __Repositorio__.

### Repositorio

As classes de __Repositorio__(_repository_) são responsáveis simplesmente por persistir os dados, no nosso caso, salvar
os dados no arquivo específico.

Você deve implementá-las, utilize as interfaces `Repository` e `RelatorioRepository` como contrato.

Tente criar um repositório para cada domínio, assim podemos seguir melhor o SOLID e deixar
nossas classes com responsábilidades únicas.

#### Como os repositórios conseguiriam seguir o contrato sendo que alguns são únicos por conta?
> Uma dica é você receber o caminho do arquivo pelo construtor do repositório, assim ele seria agnóstico a arquivo, quem definiria o arquivo seria o service

### Como gerar UUID ?

o Java possuí uma biblioteca no pacote `java.util.UUID` para auxiliar nessa tarefa;

Exemplo de código:

```java
import java.util.UUID;

UUID id = UUID.randomUUID();
```

Se quisermos esse id em __String__ podemos chamar o método `toString()`

```java
import java.util.UUID;

String id = UUID.randomUUID().toString();
```
# Entrega

> A entrega deve ser feita pelo github enviando o link na atividade que será disponibilizada no class
