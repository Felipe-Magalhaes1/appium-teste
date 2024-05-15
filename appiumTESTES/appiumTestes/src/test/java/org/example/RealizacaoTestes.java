package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.PageObjects.CadastroPageObjects;
import org.example.PageObjects.LoginPageObjects;
import org.junit.Assert;

public class RealizacaoTestes {

    private LoginPageObjects telaLogin;
    private CadastroPageObjects telaCadastro;
    private String mensagemErro;

    @Given("Estou na tela de login")
    public void estou_na_tela_de_login() {
        telaLogin = new LoginPageObjects(AppiumDriverConfig.Instance().driver);
        telaLogin.BuscarElementos();
    }

    @When("Eu clico no botão de cadastrar usuário")
    public void eu_clico_no_botao_de_cadastrar_usuario() {
        telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
    }

    @And("Preencho os campos de cadastro com usuário {string} e senhas {string} e {string}")
    public void preencho_os_campos_de_cadastro_com_usuario_e_senhas_e(String usuario, String senha1, String senha2) {
        telaCadastro.Cadastrar(usuario, senha1, senha2);
    }

    @Then("Devo ser redirecionado para a tela de login novamente")
    public void devo_ser_redirecionado_para_a_tela_de_login_novamente() {
        telaLogin = new LoginPageObjects(AppiumDriverConfig.Instance().driver);
        telaLogin.BuscarElementosLogin();
    }

    @And("Devo ser redirecionado para a tela de login novamente BASE")
    public void devo_ser_redirecionado_para_a_tela_de_login_novamentePadrao() {
        telaLogin = new LoginPageObjects(AppiumDriverConfig.Instance().driver);
        telaLogin.BuscarElementosLogin();
    }



    @Then("Devo ver a mensagem de erro")
    public void devo_ver_a_mensage_de_erro() {
        telaCadastro = new CadastroPageObjects(AppiumDriverConfig.Instance().driver);
        telaCadastro.buscarDivErro();
    }

    @When("Eu preencho o campo de usuário com {string} e o campo de senha com {string}")
    public void eu_preencho_o_campo_de_usuario_com_e_o_campo_de_senha_com(String usuario, String senha) {
        telaLogin.PreencherLogin(usuario, senha);
    }

    @When("Eu preencho o campo de usuário com {string} e o campo de senha com {string} BASE")
    public void eu_preencho_o_campo_de_usuario_com_e_o_campo_de_senha_com_base(String usuario, String senha) {
        telaLogin.PreencherLogin(usuario, senha);
    }

    @When("Eu preencho o campo de usuário com {string} e o campo de senha com {string} errado")
    public void eu_preencho_o_campo_de_usuario_com_e_o_campo_de_senha_com_base_errado(String usuario, String senha) {
        telaLogin.PreencherLogin(usuario, senha);
    }

    @And("Eu clico no botão de login")
    public void eu_clico_no_botao_de_login() {
        telaLogin.ClicarBotaoLogin();
    }

    @Then("Devo ser redirecionado para a tela de produtos")
    public void devo_ser_redirecionado_para_a_tela_de_produtos() {
        telaLogin.BuscarElementoProdutos();
    }

    @Then("Devo ver a mensagem de erro login")
    public void MensagemErro() {
        telaLogin.MensagemErro();
    }


    @When("Eu preencho o campo de usuário com {string} errado e o campo de senha com {string}")
    public void eu_preencho_o_campo_de_usuario_errado_com_e_o_campo_de_senha_com(String usuario, String senha) {
        telaLogin.PreencherLogin(usuario, senha);
    }


}
