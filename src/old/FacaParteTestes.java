package old;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class FacaParteTestes {

	private AppiumDriver<WebElement> driver;

	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void setUp() throws MalformedURLException {
		File diretorioApp = new File("D:\\versoes-facaparte");
		File arquivoApp = new File(diretorioApp, "android-debug.apk");
		DesiredCapabilities capacidade = new DesiredCapabilities();
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capacidade.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
		capacidade.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		capacidade.setCapability(MobileCapabilityType.APP, arquivoApp.getAbsolutePath());
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "ce031603b8cc041603");
		capacidade.setCapability("deviceName", "Android");
	//	capacidade.setCapability("newCommandTimeout", 120);
	//  capacidade.setCapability("recreateChromeDriverSessions", true);

	}



	
	public void webView() throws InterruptedException {
		//WebElement button = (WebElement) driver.findElementsByClassName("btn-avanco button-transition");
		//button.click();
		driver.findElement(By.className("btn-avanco button-transition")).click();	
		System.out.println("passou aqui");
		Thread.sleep(6000);
		System.out.println("aqui tbm");
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName);
			if (contextName.contains("WEBVIEW")) {
				driver.context(contextName);
				System.out.println("contem webview");
			} else {
				System.out.println("não contem webview");
			}
		}

	
	MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Image");
	el1.click();
	MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[5]/android.view.View");
	el2.click();
	MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[5]/android.view.View/android.widget.Image");
	el3.click();
	MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[5]/android.view.View/android.widget.Image");
	el4.click();

	}
	
}
