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





