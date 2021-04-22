# Cyrela API

Esse projeto tem por objetivo fornecer contratos atráves de uma API para facilitar as interações entre os produtos  da Cyrela, com as seguintes operações:

#### Ocorrências

* Criar uma nova ocorrência | 
Link da Documentação: [Swagger - createOccurrenceUsingPOST](https://cyrela-fiap.herokuapp.com/swagger-ui.html#/occurrence-controller/createOccurrenceUsingPOST)

* Listar todas as ocorrências com a opção de filtrar pela unidade |
Link da Documentação: [Swagger - getAllOccurrenceUsingGET](https://cyrela-fiap.herokuapp.com/swagger-ui.html#/occurrence-controller/getAllOccurrenceUsingGET)

* Obter uma ocorrência pelo ID |
Link da Documentação: [Swagger - findByIdrUsingGET](https://cyrela-fiap.herokuapp.com/swagger-ui.html#/occurrence-controller/findByIdrUsingGET)

* Obter uma ocorrência pelo Ticket Number
Link da Documentação: [Swagger - findByTicketNumberUsingGET](https://cyrela-fiap.herokuapp.com/swagger-ui.html#/occurrence-controller/findByTicketNumberUsingGET)

#### Atividades da Agenda

* Criar uma nova atividade na agenda |
Link da Documentação: [Swagger - createScheduleUsingPOST](https://cyrela-fiap.herokuapp.com/swagger-ui.html#/schedule-controller/createScheduleUsingPOST)

* Listar todas as atividades da agenda com a opção de filtrar pela unidade e pelo tipo da atividade |
Link da Documentação: [Swagger - getAllScheduleUsingGET](https://cyrela-fiap.herokuapp.com/swagger-ui.html#/schedule-controller/getAllScheduleUsingGET)

* Obter uma atividade na agenda pelo ID |
Link da Documentação: [Swagger - findByIdUsingGET](https://cyrela-fiap.herokuapp.com/swagger-ui.html#/schedule-controller/findByIdUsingGET)

#### Contratos auxiliares

 * Criar um novo endereço |
 Link da Documentação: [Swagger - createAddressUsingPOST](https://cyrela-fiap.herokuapp.com/swagger-ui.html#/adrress-controller/createAddressUsingPOST)
 
 * Criar um novo usuário |
 Link da Documentação: [Swagger - createUserUsingPOST](https://cyrela-fiap.herokuapp.com/swagger-ui.html#/user-controller/createUserUsingPOST)
 
 * Criar um novo condomínio, passando o bloco e unidade |
 Link da Documentação: [Swagger - createDevelopmentUsingPOST](https://cyrela-fiap.herokuapp.com/swagger-ui.html#/development-controller/createDevelopmentUsingPOST)
 
 ## Como testar
 
 Você pode testar das seguintes maneiras:
 
 * Baixe a collection do postman presente no projeto: [Collection do Postman](https://github.com/natholiveira/cyrela/blob/master/Cyrela-fiap.postman_collection.json) lá vai ter 
 todos os contratos, importe a collection no `Postman`, basta alterar os campos como desejar e executar as chamadas.
 
 * Pela documentação feita no Swagger, basta acessar o [Swagger](https://cyrela-fiap.herokuapp.com/swagger-ui.html#) selecione o contrato que deseja executar clique em `Try it Out`,
  mude os valores como desejar e execute.
 
 ## Documentação
 
[Swagger](https://cyrela-fiap.herokuapp.com/swagger-ui.html#)
