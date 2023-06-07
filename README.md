# Funções
* Gerenciar produtos/estoque
- criar e apagar produtos
- mudar qtde no estoque de um produto
- alterar produto
> mudar nome e preço

* Gerenciar pedidos
- abrir pedido
> definir produtos e quantidades
> mostrar o preço total
- apagar pedido
- alterar pedido
> adicionar e remover produtos
> alterar qtde de um produto
- listar pedidos


* Gerenciar descontos
- criar e apagar descontos

* Gerenciar cliente
- cadastrar e remover cliente

* Gerenciar funcionários
- cadastrar e remover funcionário


[EXTRA_INFO]

* Códigos - Produtos
- vetor de String, com os códigos
- base códigos: BANDACOR## <KISSP01>

* Códigos - Pedidos
- #numero e só ir add os nmr

# ------------------------------ COMO FAZER CADA COISA ------------------------------ #

* Gerenciar produtos/estoque

- criar produtos
`método construtor: precisa colocar: banda, cor e nome // um outro q pode por tbm qtde`
- apagar produtos
`precisa apresentar o código pra apagar: loop pra procurar no vetor o código, setar o cod pra 0 e apagar os dados (cpa substituir cm novos os q tão cm zero)`
- mudar qtde no estoque de um produto
`default: mudar de todos // param Sz --> escolher tam p mudar`
`remove/add --> roda no pedidos`
- alterar produto
`parametro: String/double (nome ou preço)`

> em uma classe Estoque:
- estática
- quando add/remove produto novo -> ter método que muda valores no vetor de lá 

* Gerenciar pedidos

- abrir pedido
``
> definir produtos e quantidades
> mostrar o preço total

- apagar pedido
`setar cod pra 0`
- alterar pedido
> adicionar e remover produtos
> alterar qtde de um produto
`parâmetro doq editar`
- listar pedidos
`for loop (length)`



* Gerenciar descontos

- criar descontos
`parametro: valor`
- apagar descontos
`parametro: código`



* Gerenciar cliente

- cadastrarr cliente
`parametros: nome, cpf`
- remover cliente
`parametro: código`


* Gerenciar funcionários

- cadastrarr funcionário
`parametros: nome, cpf`
- remover funcionário
`parametro: código`




BASE DE CRIAÇÃO DE TODAS AS CLASSES:
     /* --------- ATRIBUTOS --------- */

     /* ------- MÉTODOS CONSTRUTORES ------- */

     /* -------- OUTROS MÉTODOS -------- */