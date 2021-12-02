# language: pt
  Funcionalidade: Login

    Cenário:  Login com sucesso
      Dado que o usuário esteja na página de login
      E insira o e-mail no campo com a label "Username or email address"
      E insira a senha no campo com a label "Password"
      Quando clicar no botão com o texto "Sign in"
      Então o usuário deverá ser redirecionado para a página principal "https://github.com/"

    Cenário: Login sem sucesso
      Dado que o usuário esteja na página de login
      E insira um e-mail não cadastrado no campo com a label "Username or email address"
      E insira a senha no campo com a label "Password"
      Quando clicar no botão com o texto "Sign in"
      Então deverá aparecer a mensagem "Incorrect username or password."

