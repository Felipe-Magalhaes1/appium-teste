package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObjects extends PageObjectBase{


    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoCadastrar;
    private MobileElement mensagemErro;


    private final By erroID;
    private final By campoNomeId;
    private final By campoSenhaId;
    private final By campoConfirmacaoId;
    private final By botaoCadastrarId;

    public CadastroPageObjects(AppiumDriver driver) {
        super(driver);

        erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        campoNomeId = By.id("br.com.alura.aluraesporte:id/input_nome");
        campoSenhaId = By.id("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmacaoId = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoCadastrarId = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void BuscarElementos(){
        campoNome = (MobileElement) driver.findElement(campoNomeId);
        campoSenha = (MobileElement) driver.findElement(campoSenhaId);
        campoConfirmarSenha = (MobileElement) driver.findElement(campoConfirmacaoId);
        botaoCadastrar = (MobileElement) driver.findElement(botaoCadastrarId);
    }

    private void PreencherFormulario(String usuario, String senha, String confirmacao){
        campoNome.sendKeys(usuario);
        campoSenha.sendKeys(senha);
        campoConfirmarSenha.sendKeys(confirmacao);
    }

    public void buscarDivErro(){
        mensagemErro = (MobileElement) driver.findElement(erroID);
    }


    public LoginPageObjects Cadastrar(String usuario, String senha, String confirmacao) {
        PreencherFormulario(usuario,senha,confirmacao);
        botaoCadastrar.click();
        return new LoginPageObjects(driver);
    }

    public String MensagemErro(){

        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroID));

        mensagemErro = (MobileElement) driver.findElement(erroID);
        return mensagemErro.getText();
    }
}
