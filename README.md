# poo-pbl-grupo-marcos

Projeto Prático Integrador - Orientação a Objetos
Tema 10: Aplicativo de Finanças Coletivas para Repúblicas ou Grupos de Viagem

## Descrição
Sistema para divisão de despesas entre membros de um grupo, calculando quem deve quanto para quem de forma justa.

## Tecnologias
- Java 17
- Maven
- JUnit 5
- GitHub Actions (CI/CD)

## Como rodar os testes
```bash
mvn clean test
```

## Estrutura do Projeto
```
src/
├── domain/
│   ├── valueobjects/   <- Value Objects (ex: Dinheiro)
│   ├── entities/       <- Entidades (ex: Membro, Despesa)
│   └── aggregates/     <- Aggregate Root (ex: Grupo)
├── application/        <- Casos de uso
├── infrastructure/     <- Repositórios
└── presentation/       <- Interface gráfica
tests/                  <- Testes unitários (TDD)
```
