package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.PageObjects.CadastroPageObjects;
import org.example.PageObjects.LoginPageObjects;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

public class FeatureCadastro {
    @Test
    public void nao_consigo_cadastrar_um_usuario_com_senhas_que_nao_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObjects telaLogin = new LoginPageObjects(driver);
        telaLogin.BuscarElementos();
        CadastroPageObjects telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Felipe", "123", "456");
        Assert.assertEquals("Senhas não conferem", telaCadastro.MensagemErro());
        driver.navigate().back();

        assertTrue(true);
    }

    @Test
    public void posso_cadastrar_usuarios_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObjects telaLogin = new LoginPageObjects(driver);
        telaLogin.BuscarElementos();
        CadastroPageObjects telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.Cadastrar("felipe", "123", "123");
        telaLogin.BuscarElementos();

    }

    @Test
    public void realizar_login_com_parametros_cadastrados_e_corretos() throws NoSuchElementException {
        posso_cadastrar_usuarios_com_senhas_que_conferem();

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObjects telaLogin = new LoginPageObjects(driver);
        telaLogin.BuscarElementosLogin();

        telaLogin.PreencherLogin("felipe", "123");

        telaLogin.ClicarBotaoLogin();

        // verificar se mudei de tela
        telaLogin.BuscarElementoProdutos();
    }

    @Test
    public void realizar_login_com_senha_errada() throws NoSuchElementException {
        // posso_cadastrar_usuarios_com_senhas_que_conferem();

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObjects telaLogin = new LoginPageObjects(driver);
        telaLogin.BuscarElementosLogin();

        telaLogin.PreencherLogin("felipe", "123456");

        telaLogin.ClicarBotaoLogin();

        // verificar se a mensagem apareceu
        telaLogin.MensagemErro();

    }

    @Test
    public void realizar_login_com_id_do_usuário_não_cadastrado() throws NoSuchElementException {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObjects telaLogin = new LoginPageObjects(driver);
        telaLogin.BuscarElementosLogin();

        telaLogin.PreencherLogin("naocadastrado", "123456");

        telaLogin.ClicarBotaoLogin();

        // verificar se a mensagem apareceu
        telaLogin.MensagemErro();

    }

    @Test
    public void realizar_login_com_campos_em_branco() throws NoSuchElementException {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObjects telaLogin = new LoginPageObjects(driver);
        telaLogin.BuscarElementosLogin();

        telaLogin.PreencherLogin("", "");

        telaLogin.ClicarBotaoLogin();

        // verificar se a mensagem de erro apareceu
        telaLogin.MensagemErro();

    }
}