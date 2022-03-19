#language:pt
#coding: utf-8

@SEU_BARRIGA_APPLICATION
Funcionalidade: Validar o registro de um usuário
  Como um usuário
  Eu quero validar a inserção de um perfil de usuário

  Contexto:
    Dado que  estou na aba de formulários

  @SEU_BARRIGA_APPLICATION_CT_001
  Esquema do Cenário: Deve realizar a inserção de um usuário
    Dado que  estou na aba de formulários
#    Então finalizo a sessão
#    Dado que acesso a rota "<rota>" para o projeto "receivableUnit"
#    Quando realizo uma busca de concolidado por "<consolidado>" com filtro ano "<ano>", mes "<mes>" e dia "<dia>" para o cliente "<cliente>"
#    E valido o body da response "<body>"
#    Então é retornado para a requisição o status code "<statusCode>"

    Exemplos:
      |rota            |ano |mes|dia  |consolidado|cliente|body          |statusCode|
      |/receivable-unit|2021|04 |05   |dia        |seller |ReceivableUnit|200       |