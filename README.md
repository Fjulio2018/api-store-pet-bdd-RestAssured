# Pet Store API TESTING

Teste API usando:
- Rest Assured ( 'io.rest-assured:rest-assured:4.3.1')
- Cucumber ( 'io.cucumber:cucumber-java:6.2.2')
- Java (java version "21" 2023-09-19 LTS)
- Junit ( 'io.cucumber:cucumber-junit:6.2.2')

- BDDs:


# language: pt
Funcionalidade: Criacao e Exibicao de Usuario


Esquema do Cenario: Criacao e Exibicao de Usuario

    Dado que envio dados para a criacao do usuario
      | id   | username   | password   | firstName   | lastName   | email   | phone   | userStatus   | HttpStatus   | MSG   |
      | <id> | <username> | <password> | <firstName> | <lastName> | <email> | <phone> | <userStatus> | <HttpStatus> | <MSG> |

    Quando preformo a criacao dos usuarios
    Entao valido os dados dos usuarios criados

    Exemplos: Criacao e Exibicao de Usuario com sucesso
      | id   | username | password | firstName | lastName  | email             | phone       | userStatus | HttpStatus | MSG  |
      | 3766 | Akiles   | Aki31@32 | Antonio   | Akino     | Aki@mailnator.com | 19994334200 | 1          | 200        | xpto |
      | 0007 | Jupiter  | @JP@32   | João      | Pitolomeu | Jup@mailnator.com | 19994334333 | 1          | 200        | xpto |


Esquema do Cenario: Validação de retorno de erros da API de usuarios

    Dado que envio dados para a criacao do usuario
      | id   | username   | password   | firstName   | lastName   | email   | phone   | userStatus   | HttpStatus   | MSG   |
      | <id> | <username> | <password> | <firstName> | <lastName> | <email> | <phone> | <userStatus> | <HttpStatus> | <MSG> |

    Quando preformo a criacao dos usuarios
    Entao valido retornos e mensagens de erro


    Exemplos: Criacao e Exibicao de Usuario sem sucesso
      | id   | username      | password | firstName | lastName | email               | phone        | userStatus | HttpStatus | MSG                                                                      |
      | 7733 | SemUserStatus | Aki31@32 | Not       | StatuId  | NoSId@mailnator.com | 1999435463   |            | 400        | Input error: unable to convert input to io.swagger.petstore.model.User |
      |      | CaraSemID     | 822626   | Não       | ID       | NoId@mailnator.com  | 199943383763 |    1        | 400        | Input error: unable to convert input to io.swagger.petstore.model.User |


# language: pt


Funcionalidade: Criar e visualizar pedido


     Cenario: Listar pedido com sucesso

       Dado que tenha pedidos feitos
       Quando procurar por id do pedidos
       Entao o pedido com status placed sera apresentado



# language: pt


Funcionalidade:  Criacao e Exibicao de Animais


     Esquema do Cenario: Lista de animais pelo status

       Dado que tenha animais criados
       Quando a pesquiso animais com status <estado>
       Entao os <quantidade> animais com status <estado> sao listados

       Exemplos: Animais que podem ser listados
         | estado    | quantidade |
         | available | 7          |
         | pending   | 2          |
         | sold      | 1          |


     Esquema do Cenario: Criar  animais

       Dado que tenha os dados dos animais
         | id   | nome   | ctgId   | ctgNome   | photoUrls   | tagId   | tagNome   | AnimalStatus   | HttpStatus   | MSG   |
         | <id> | <nome> | <ctgId> | <ctgNome> | <photoUrls> | <tagId> | <tagNome> | <AnimalStatus> | <HttpStatus> | <MSG> |

       Quando performar a criacao
       Entao validomos a criacao

       Exemplos: Criacao e Exibicao de Usuario com sucesso
         | id   | nome   | ctgId | ctgNome | photoUrls | tagId | tagNome      | AnimalStatus | HttpStatus | MSG |
         | 2024 | Nikita | 24    | Cao     | xpto      | 20    | #MinhaNikita | available    | 200        |     |










