package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class CenarioBasico {
 
    private AppiumDriver<WebElement> driver;
    
@BeforeTest

public void setUp() throws Exception{
    
    DesiredCapabilities capacidade = new DesiredCapabilities();
    capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
    capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
    capacidade.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
    capacidade.setCapability("appPackage", "br.com.sicoob.facaparte.app");
    capacidade.setCapability("autoGrantPermissions", "true");
    capacidade.setCapability("appActivity", "br.com.sicoob.facaparte.app.MainActivity");
    driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
}
    @Test

    public void testeCadastro() throws MalformedURLException, InterruptedException {

	WebDriverWait wait = new WebDriverWait(driver, 30);

	// Wizard: clicar nos botões "avançar"
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAvancar"))).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAvancar"))).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAvancar"))).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIniciar"))).click();

	// Tela 1: Preenche os campos da tela Dados Básicos
	driver.findElement(By.id("cpf")).sendKeys("59307188734");
	driver.findElement(By.id("data")).sendKeys("11021992");
	driver.findElement(By.id("email")).sendKeys("lais.automacao@sicoob.com");
	driver.findElement(By.id("cell_com_ddd")).sendKeys("61981890003");
	driver.findElement(By.id("cep")).sendKeys("70655659");
	driver.findElement(By.id("checkConcordo")).click();
	driver.findElement(By.id("botaoAvancar")).click();

	// Tela 2: Preenche os campos da tela Dados Complementares
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("numero"))).click();
	driver.findElement(By.xpath("//input[@placeholder='Pesquisar']")).sendKeys("DF");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ion-nav-view/ion-view[3]/ion-content/div/combo-filter/div/div/div[3]/div/ul/li"))).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("naturalidade"))).click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Pesquisar']"))).sendKeys("BRASÍLIA");
	driver.findElement(By.xpath("/html/body/ion-nav-view/ion-view[3]/ion-content/div/combo-filter/div/div/div[3]/div/ul/li")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("profissao"))).sendKeys("analista");
	driver.findElement(By.id("estado_civil")).click();
	//TODO fazer um teste para casado
	Thread.sleep(4000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Pesquisar']"))).sendKeys("SOLTEIRO");
	driver.findElement(By.xpath("/html/body/ion-nav-view/ion-view[3]/ion-content/div/combo-filter/div/div/div[3]/div/ul/li")).click();
	Thread.sleep(4000);
	recuperarBotaoAtivo("botaoAvancar", driver).click();

	// Tela 3: Preenche os dados da tela de Endereço 
	Thread.sleep(4000);
	recuperarInputAtivo("numero", driver).sendKeys("45");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("complemento"))).sendKeys("apartamento 105");
	driver.findElement(By.xpath("//*[@id=\"end-principal\"]/div/ion-item[5]/div/label")).click();
	driver.findElement(By.id("cepCorresp")).sendKeys("72669081");
	driver.findElement(By.id("endereco-adicional")).click();
	Thread.sleep(4000);
	recuperarBotaoAtivo("botaoAvancar", driver).click();
	
	// tira a foto do comprovante e da declaração de residência

	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/ion-nav-view/ion-view[5]/ion-content/div/div/div[2]/div/div/div/div[1]"))).click();
	Thread.sleep(4000);
	// driver.execute(driverCommand, parameters)
	
	driver.findElement(By.xpath("//*[@*='Obturador']")).click();
	
	

	//driver.findElement(By.id("com.sec.android.app.camera:id/okay")).click();
	//((AndroidElement) driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"))).click();
	//recuperarBotaoMobileAtivo("com.android.packageinstaller:id/permission_allow_button", driver).click();
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@*='Permitir']"))).click();
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='Permitir']"))).click();
	
	//driver.findElement(By.xpath("(//GLButton[@content-desc=\"NONE\"])[3]")).click();
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("botaoAvancar"))).click();
	
	//((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
    }
    

    // metodos auxiliares para recuperar elementos 
    public WebElement recuperarBotaoAtivo(String idBotao, AppiumDriver<WebElement> driver) {
	for (WebElement webElement : driver.findElementsById(idBotao)) {
	    if (webElement.isDisplayed()) {
		return webElement;
	    }
	}
	return null;
    }

    public WebElement recuperarInputAtivo(String idInput, AppiumDriver<WebElement> driver) {
	for (WebElement webElement : driver.findElementsById(idInput)) {
	    if (webElement.isDisplayed()) {
		return webElement;
	    }
	}
	return null;
       }
    
    
    public MobileElement recuperarBotaoMobileAtivo(String idBotaoMobile, AppiumDriver<WebElement> driver) {
	for (WebElement webElement : driver.findElementsById(idBotaoMobile)) {
	    if (webElement.isDisplayed()) {
		return (MobileElement) webElement;
	    }
	}
	return null;
    }

}
