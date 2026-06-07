# Sistema de Finanças Coletivas

Projeto Prático Integrador da disciplina de Orientação a Objetos.

## Tema Escolhido

**Tema 10 – Aplicativo de Finanças Coletivas para Repúblicas ou Grupos de Viagem**

O sistema permite o gerenciamento de despesas compartilhadas entre membros de um grupo, registrando gastos, participantes envolvidos e realizando o controle financeiro de forma organizada e segura.

---

## Integrante

| Nome         | GitHub    |
| ------------ | --------- |
| Marcos André | MarcosCSc |

---

## Tecnologias Utilizadas

* Java 17
* Maven
* JUnit 5
* GitHub Actions
* Git

---

## Arquitetura do Projeto

O projeto foi desenvolvido seguindo conceitos de:

* Programação Orientada a Objetos (POO)
* Domain-Driven Design (DDD)
* Test-Driven Development (TDD)
* Integração Contínua (CI/CD)

### Estrutura de Diretórios

```text
.github/
 └── workflows/
      └── ci.yml

src/
 ├── domain/
 ├── application/
 └── infrastructure/

tests/

README.md
pom.xml
project-meta.json
```

---

## Conceitos de DDD Aplicados

### Entidades

Classes que possuem identidade própria:

* Grupo
* Membro
* Despesa

### Value Object

Objeto imutável utilizado para representar valores monetários:

* Dinheiro

### Aggregate Root

Responsável por manter a consistência do domínio:

* Grupo

---

## Conceitos de Orientação a Objetos Aplicados

* Encapsulamento
* Composição
* Imutabilidade
* Alta coesão
* Separação de responsabilidades
* Regras de negócio isoladas na camada de domínio

---

## Casos de Uso Implementados

* Cadastro de membros
* Criação de grupos
* Registro de despesas
* Associação de participantes às despesas
* Controle financeiro compartilhado

---

## Testes Unitários

O projeto possui testes unitários para validar regras de negócio e cenários de erro.

Classes testadas:

* DinheiroTest
* MembroTest
* GrupoTest
* DespesaTest
* GrupoRepositorioTest
* RegistrarDespesaUseCaseTest

Para executar os testes:

```bash
mvn test
```

---

## Build do Projeto

Para compilar o projeto:

```bash
mvn clean compile
```

Para executar todos os testes:

```bash
mvn clean test
```

---

## Integração Contínua (CI/CD)

O projeto utiliza GitHub Actions para executar automaticamente:

* Build da aplicação
* Testes unitários

A execução ocorre a cada:

* Push para a branch main
* Pull Request para a branch main

Arquivo de configuração:

```text
.github/workflows/ci.yml
```

---

## Objetivo Acadêmico

Este projeto foi desenvolvido com o objetivo de aplicar, na prática, conceitos de Engenharia de Software e Orientação a Objetos, utilizando boas práticas de modelagem de domínio, testes automatizados e integração contínua.

---

## Autor

Marcos André

Curso de Ciência da Computação
Disciplina: Orientação a Objetos
