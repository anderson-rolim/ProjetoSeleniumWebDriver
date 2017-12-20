package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CadastroPages;



public class tests {



	static CadastroPages metodosUtils;
	private WebDriver driver;
	private static String baseurl = "https://homologacao.casavaticano.com.br/login";

	@Before //Para acessar o nosso o site
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver","/Users/andersonrolim/drivers/chromedriver");
		driver = new ChromeDriver();	
		//driver.get("https://homologacao.casavaticano.com.br/login");	  
		driver.navigate().to(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		metodosUtils = new CadastroPages(driver);

	}
	
	
	@Test
	public void Tes1FazerLoginTest() throws InterruptedException {
	  	    
	
		
		
		metodosUtils.login();
		Assert.assertEquals(metodosUtils.validarMensagemNome(),"anderson.rolim   ");
	    /*
	    metodosUtils.buscaContaMaster();
	    metodosUtils.seletorDeConta();
	    metodosUtils.acessandoModuloTracks(); 
	    metodosUtils.novoProcesso();
	    
	    //Menssagem de sucesso!
	    Assert.assertEquals(metodosUtils.validarMensagem(), "×" + "\n" + "Processo iniciado com sucesso.");
	    
	    metodosUtils.buscaDeProcessoAutomatizado();
	    metodosUtils.acoesDoProcesso();
	    
		Assert.assertEquals(metodosUtils.validarMensagem(), "×" + "\n" + "Peça renomeada para 'Teste Automatizado.'");
	
		metodosUtils.buscaDeAtividadeDoProcessoAutomatizado();
		metodosUtils.editandoAtividadeDoProcesso();
		
		// Mensagem da atividade salva
		Assert.assertEquals(metodosUtils.validarMensagem(), "×" + "\n" + "Atividade salva com sucesso.");
	    		
		metodosUtils.acaoRemoverProcesso();
		
		Assert.assertEquals(metodosUtils.validarMensagem(), "×" + "\n" + "Processo cancelado com sucesso.");
		
		*/
	
		
		
	   // driver.navigate().refresh();
		
	}
	
	
	
	
	@After
	public void fecharPagina() {
		driver.quit();
		
		
	}
	
	
}
