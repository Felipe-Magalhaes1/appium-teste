package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObjects extends PageObjectBase{

    private MobileElement botaoCadastro;
    private MobileElement input_idUsuario;
    private MobileElement login_senha;
    private MobileElement botao_login;
    private MobileElement produtos;
    private MobileElement msgErro;

    private final By usuario_id;
    private final By usuario_senha;
    private final By botaoLogin;
    private final By lista_produtos;
    private final By msg_erro;

    public LoginPageObjects(AppiumDriver driver){
        super(driver);
        usuario_id = By.id("br.com.alura.aluraesporte:id/input_usuario");
        usuario_senha = By.id("br.com.alura.aluraesporte:id/input_senha");
        botaoLogin = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
        lista_produtos = By.id("br.com.alura.aluraesporte:id/lista_produtos_recyclerview");
        msg_erro = By.id("br.com.alura.aluraesporte:id/mensagem_erro_login");

    }
    @Override
    public void BuscarElementos(){
        botaoCadastro = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");

    }
    public void BuscarElementosLogin(){
        input_idUsuario = (MobileElement) driver.findElement(usuario_id);
        login_senha = (MobileElement) driver.findElement(usuario_senha);
        botao_login = (MobileElement) driver.findElement(botaoLogin);
    }




    public void BuscarElementoProdutos(){
        produtos = (MobileElement) driver.findElement(lista_produtos);
    }

    public void PreencherLogin(String usuario, String senha) {
        input_idUsuario.sendKeys(usuario);
        login_senha.sendKeys(senha);
    }

    public CadastroPageObjects IrParaTelaDeCadastro() {
        botaoCadastro.click();
        return new CadastroPageObjects(this.driver);
    }

    public CadastroPageObjects ClicarBotaoLogin() {
        botao_login.click();
        return new CadastroPageObjects(this.driver);
    }


    public String MensagemErro(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(msg_erro));

        msgErro = (MobileElement) driver.findElement(msg_erro);
        return msgErro.getText();
    }
}
