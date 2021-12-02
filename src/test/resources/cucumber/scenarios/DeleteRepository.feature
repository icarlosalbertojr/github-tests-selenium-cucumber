# language: pt
  Funcionalidade: Apagar repositório
    Cenario: Apagando repositório com sucesso
      Dado que o usuário esteja logado
      E que o repositório exista
      Quando o usuário estiver na página de configurações
      E clicar no botao "Delete this repository" para abrir o modal
      E inserir o texto no formato usuario/repositorio no campo do modal de confirmação
      E clicar no botao "I understand the consequences, delete this repository"
      Então o repositório deverá ser apagado com sucesso