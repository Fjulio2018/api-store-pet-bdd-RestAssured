# Pet Store API TESTING

Teste API usando:
- Rest Assured ( 'io.rest-assured:rest-assured:4.3.1')
- Cucumber ( 'io.cucumber:cucumber-java:6.2.2')
- Java (java version "21" 2023-09-19 LTS)
- Junit ( 'io.cucumber:cucumber-junit:6.2.2')

- BDD:


Funcionalidade: Criacao e Exibicao de Usuario


@deleteUser
Cenario: Criar usuario eficaz


       Quando criar um usuario
       Entao valido usuario criado


Funcionalidade:  Criacao e Exibicao de Animais



@wip
Cenario: Listar todos os animais

       Dado que tenha animais criados
       Quando a requisicao e feita
       Entao os animais sao listados