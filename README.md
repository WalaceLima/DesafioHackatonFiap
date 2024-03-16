#  Desafio Hackaton

## Equipe

- WALACE LUIZ DE SOUZA LIMA
- ELISANGELA 
- ALEXANDRE



**DESAFIO**

Desenvolver um sistema, para gerenciamento de hospedagem de clientes, gestão de quartos e serviços.


## Gestão de Quartos

o módulo de Gestão de Quartos, faz a gestão (Inclusão, Atualização, Deleção,Consulta) de todos os quartos por propriedade, ou seja, caso tenhamos mais de uma localidade ou prédio,o módulo consegue diferenciar quais quartos estão em qual prédio de qual localidade. Esse módulo é
responsável por gerir cada característica dos quartos, prédios e localidades



---



## Gestão de Serviços e Opcionais 
O módulo de Gestão de Serviços e Opcionais, faz a gestão (Inclusão,
Atualização, Deleção, Consulta) todos os serviços extras que o Hotel oferece e os opcionais que podem existir.
Estes opcionais são itens ou serviços que podem ser adicionados à reserva, cada um tem seu valor
único podendo ser por pessoa e/ou quarto.

---

## Gestão de Clientes 
O módulo de Gestão de Clientes, faz a gestão (Inclusão, Atualização, Deleção,
Consulta) de dados de clientes, neste módulos teremos os seguintes dados que serão utilizados:
● ID: número único, interno ao banco de dados (obrigatório)
● País de Origem: qual o país de nascimento do cliente (obrigatório)
● CPF: documento de número único no Brasil (obrigatório de Brasileiro)
● Passaporte: documento de número único no País de Origem (obrigatório se estrangeiro)
● Nome Completo (obrigatório)
● Data de Nascimento (obrigatório)
● Endereço no País de Origem (obrigatório)
● Telefone (obrigatório)
● Email (obrigatório)

## Gestão de Reservas

o módulo de Gestão de reservas é o grande agregador, este módulo acessa fará a gestão das reservas, ou seja, que cliente, quais as datas de entrada e saída, quantas pessoas e quartos e se há disponibilidade.
Este módulo é responsável por gerir os seguintes itens:
● Gerir as Reservas (Inclusão, Atualização, Deleção, Consulta)
● Gerir as datas disponíveis por quartos o Quartos podem ser bloqueados com a reserva de um hóspede ou simplesmente ser bloqueado no módulo, tornando-o indisponível para reservas (reserva do
administrador)
● Gestão dos Serviços e Opcionais inclusos na Reserva
● Calcular o valor total da conta do cliente
● Envio de E-mails de confirmação


---
