# temporizadores

Este é um projeto em Spring Boot para exibir temporizadores no formato de contadores regressivos em uma página da web. 
Primeiramente se adiciona os temporizadores, configurando um nome e uma data para a contagem regressiva, caso insira uma data que já passou, vai constar com tempo expirado.
Cada temporizador é representado por um bloco na interface, mostrando dias, horas, minutos e segundos até a data específica.
É possivel adicionar até 4 temporizadores simultâneos, também pode se excluir os já criados para estar criando outros.

## Tecnologias Utilizadas

- HTML
- CSS
- JAVA
- Thymeleaf (para renderização dinâmica no lado do servidor)
- JavaScript

## Funcionalidades

- Adição de temporizadores com título e data de expiração.
- Exibição de contadores regressivos para cada temporizador com atualização automática dos contadores regressivos em tempo real usando JavaScript.
- Exclusão de temporizadores existentes.
- Limite de 4 temporizadores simultâneos.
  
## Instruções de Uso

1 - Clone o repositório para a sua máquina local.
2 - Abra o projeto em sua IDE.
3 - Execute a aplicação Spring Boot.

A aplicação estará disponível em http://localhost:8080/temporizadores/.
