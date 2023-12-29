   # language: pt


   Funcionalidade:  Criacao e Exibicao de Animais


     Contexto:
       Dado que tenha animais criados


     Esquema do Cenario: Lista de animais pelo status

       Quando a pesquiso animais com status <estado>
       Entao os <quantidade> animais com status <estado> sao listados

     Exemplos: Animais que podem ser listados
       | estado   |quantidade|
       |available |     7    |
       | pending  |     2    |
       |  sold    |     1    |






