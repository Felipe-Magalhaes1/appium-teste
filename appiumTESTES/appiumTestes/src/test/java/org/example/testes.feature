Feature: Realização de Testes


    Scenario: Cadastro de usuários com senhas que conferem

    Given Estou na tela de login
    When Eu clico no botão de cadastrar usuário
    And Preencho os campos de cadastro com usuário "felipe" e senhas "123" e "123"
    Then Devo ser redirecionado para a tela de login novamente



    Scenario: Não consigo cadastrar um usuário com senhas que não conferem

    Given Estou na tela de login
    When Eu clico no botão de cadastrar usuário
    And Preencho os campos de cadastro com usuário "felipe" e senhas "123" e "456"
    Then Devo ver a mensagem de erro


    Scenario: Realizar login com parâmetros cadastrados e corretos

    Given Estou na tela de login
    When Eu clico no botão de cadastrar usuário
    And Preencho os campos de cadastro com usuário "felipe" e senhas "123" e "123"
    And Devo ser redirecionado para a tela de login novamente BASE
    And Eu preencho o campo de usuário com "felipe" e o campo de senha com "123" BASE
    And Eu clico no botão de login
    Then Devo ser redirecionado para a tela de produtos



    Scenario: Realizar login com a senha errada

    Given Estou na tela de login
    When Eu clico no botão de cadastrar usuário
    And Preencho os campos de cadastro com usuário "felipe" e senhas "123" e "123"
    And Devo ser redirecionado para a tela de login novamente BASE
    And Eu preencho o campo de usuário com "felipe" e o campo de senha com "123456" errado
    And Eu clico no botão de login
    Then Devo ver a mensagem de erro login



    Scenario: Realizar login com o id errado

    Given Estou na tela de login
    When Eu clico no botão de cadastrar usuário
    And Preencho os campos de cadastro com usuário "felipe" e senhas "123" e "123"
    And Devo ser redirecionado para a tela de login novamente BASE
    And Eu preencho o campo de usuário com "naocadastrado" errado e o campo de senha com "123"
    And Eu clico no botão de login
    Then Devo ver a mensagem de erro login




