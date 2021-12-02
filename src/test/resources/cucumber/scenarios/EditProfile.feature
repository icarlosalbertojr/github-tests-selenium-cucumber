# language: pt
  Funcionalidade: Editar perfil do usuário

    Cenario: Editar o nome do perfil com sucesso
      Dado que o usuário esteja logado
      E na página do perfil
      Quando o usuário clicar no botão com o texto "Edit profile"
      E inserir o nome no campo com a label "Name"
      E clicar no botão com o texto "Save"
      Então o nome do perfil deverá ser alterado com sucesso

    Cenario: Editar a bio do perfil com sucesso
      Dado que o usuário esteja logado
      E na página do perfil
      Quando o usuário clicar no botão com o texto "Edit profile"
      E inserir a bio no campo com a label "Bio"
      E clicar no botão com o texto "Save"
      Então a bio do perfil deverá ser alterado com sucesso