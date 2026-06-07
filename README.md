# Sistema de Finanças Coletivas

Projeto Prático Integrador - Orientação a Objetos  
Tema 10: Aplicativo de Finanças Coletivas para Repúblicas ou Grupos de Viagem

## Descrição
Sistema para divisão de despesas entre membros de um grupo.
Registra gastos, calcula quem deve quanto para quem e gerencia o saldo de cada participante.

## Tecnologias
- Java 17
- Maven
- JUnit 5
- GitHub Actions (CI/CD)

## Como rodar os testes
```bash
mvn clean test
```

## Arquitetura DDD
- **Entities:** `Membro`, `Despesa`
- **Value Object:** `Dinheiro` (imutável, evita erros de arredondamento com BigDecimal)
- **Aggregate Root:** `Grupo` (controla membros e despesas)
- **Application:** Casos de uso
- **Infrastructure:** Repositórios

## Estrutura
```
src/
├── domain/
│   ├── valueobjects/   
│   ├── entities/       
│   └── aggregates/     
├── application/        
├── infrastructure/     
└── presentation/       
tests/                  
```