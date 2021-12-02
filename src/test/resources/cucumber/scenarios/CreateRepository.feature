# language: pt
  Funcionalidade: Criação de repositório

    Cenario: Criação de repositório com sucesso
      Dado que o usuário esteja logado
      E que o repositorio não exista
      Quando estiver na página de criação de repositório "https://github.com/new"
      E inserir o nome do repositório no campo com a label "Repository name"
      E clicar no botão para criar o repositório "Create repository"
      Entao o usuário deverá ir para a página de repositório onde a url termina com o nome do repositório criado

