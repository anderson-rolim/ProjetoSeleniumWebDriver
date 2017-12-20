package tests;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import suporte.Generator;
import suporte.Screenshot;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "CriacaoDeProcessoTest.csv")

public class LoginTest {

	private WebDriver navegador;
	
	@Rule
	public TestName test = new TestName();
	
	@Before //Para acessar o nosso o site
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver","/Users/andersonrolim/drivers/chromedriver");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//navegador.get("https://homologacao.casavaticano.com.br/login");
		navegador.get("http://homologacao.casavaticano.com.br/tracker/process/activity/form/321880");
		
	}
	

	
	@Test
	public void testAdicionarUmProcessoNaPautaDoTracks(@Param(name="usuario") String usuario, @Param(name="senha")String senha)
	{
		
		WebElement FormularioDeLogin = navegador.findElement(By.id("username"));
		FormularioDeLogin.sendKeys(usuario);

		FormularioDeLogin = navegador.findElement(By.id("password"));
		FormularioDeLogin.sendKeys(senha);

		FormularioDeLogin = navegador.findElement(By.id("_submit"));
		FormularioDeLogin.submit();
		
		
		//clicar no elemento novo
		/*
		navegador.findElement(By.xpath("//div[@class=\"buttons btn-group\"]/a[@id=\"new-process-instance\"]")).click();
		navegador.findElement(By.xpath("//a[@id=\"tracks_process_1\"]")).click();
		
		
		navegador.findElement(By.xpath("//*[@id=\"form_2_field_1\"]")).sendKeys("Campo de automação de Teste");
			
		WebElement campoAgencia = navegador.findElement(By.name("form_2[field_3]"));
		new Select(campoAgencia).selectByValue("196");
		
		WebElement campoAnunciante = navegador.findElement(By.name("form_2[field_4]"));
		new Select(campoAnunciante).selectByValue("8883");
		
		WebElement campoProduto = navegador.findElement(By.name("form_2[field_5]"));
		new Select(campoProduto).selectByValue("24890");
	
		navegador.findElement(By.id("tracker_form_peca_save")).click();
		*/
		/*
		WebElement Formulario = navegador.findElement(By.xpath("//div[@class=\"form-content\"]"));
		
		Formulario.findElement(By.xpath("//*[@id=\"form_1_field_1037\"]")).sendKeys("Processo de automação de Teste");
		Formulario.findElement(By.xpath("//*[@id=\"form_1_field_1036\"]")).sendKeys("software@casavaticano.com.br");
		
		WebElement Relacionamento = Formulario.findElement(By.name("form_1[field_1038]"));
		new Select(Relacionamento).selectByValue("1345");
		
		Formulario.findElement(By.xpath("//*[@id=\"form_1_field_1039\"]")).sendKeys("Texto para automação de teste");

		//widget de tabela
		Formulario.findElement(By.xpath("//*[@id=\"form_table_form_1_field_1041_row1_cel1]\"]")).sendKeys("121244");
		Formulario.findElement(By.xpath("//*[@id=\"form_table_form_1_field_1041_row1_cel2]\"]")).sendKeys("Produto de Teste para que seja inserido na tabela");
		Formulario.findElement(By.xpath("//*[@id=\"form_table_form_1_field_1041_row1_cel3]\"]")).sendKeys("12 Miligramagen");
		*/
		
		
		//widget de Material
		
	
		/*Adicionar Materiais
		JavascriptExecutor executor = (JavascriptExecutor) navegador;
		WebElement widgetMaterial = navegador.findElement(By.xpath("//a[@id=\"form_table_material_vinc\"]"));
		executor.executeScript("arguments[0].click();", widgetMaterial);
		
		WebElement widgetModalAddMaterial = navegador.findElement(By.id("material_checkbox_88"));
		executor.executeScript("arguments[0].click();", widgetModalAddMaterial);
		
		widgetModalAddMaterial.findElement(By.xpath("//input[@id='material_input_qty_88']")).sendKeys("45");    
		widgetModalAddMaterial.findElement(By.xpath("//input[@id='material_input_88']")).sendKeys("Teste de funcionalidade");
		navegador.findElement(By.id("material_widget_submit")).click();
	
		
		//Removendo
		
		//clicar no link que contenha class dialog-request
		WebElement btnremover = navegador.findElement(By.id("form-widget-material-action-remove-1"));
		btnremover.click();
		
		WebElement ModalRemoverMaterial = navegador.findElement(By.xpath("//div[@class=\"modal modal-request fade opened-modal in\"]"));
		ModalRemoverMaterial.findElement(By.xpath("//button[@id=\"btn_remove_widget_material\"]")).click();
		*/
		
		
		
		WebElement pedidoMaterial = navegador.findElement(By.xpath("//div[@class=\"table-actions-pm actions-tab-large\"]//i[@class=\"icon-plus-sign\"]"));
		
		//div[@class="table-actions-pm actions-tab-large"]//i[@class="icon-plus-sign"]
		
		
		
				//navegador.findElement(By.cssSelector("i.icon-plus-sign"));
		pedidoMaterial.click();
	   
		WebElement WidgetModalAddEmissora = navegador.findElement(By.id("pesquisa-veiculos-pedido-material"));
		WidgetModalAddEmissora.clear();
	   
		
		WidgetModalAddEmissora.findElement(By.id("pesquisa-veiculos-pedido-material")).clear();
		WidgetModalAddEmissora.findElement(By.id("pesquisa-veiculos-pedido-material")).sendKeys("Globo sp");
	   
		navegador.findElement(By.cssSelector("i.icon-search")).click();
		
		navegador.findElement(By.cssSelector("a.inserirVeiculo > i.icon-plus")).click();
		navegador.findElement(By.xpath("(//button[@type='submit'])[6]")).click();
		
		
		
		String CaminhoDoScreenshot = "/Users/andersonrolim/drivers/screenshot/"+ Generator.dataHoraParaArquivo()+test.getMethodName()+".png";
		
		Screenshot.tirar(navegador,CaminhoDoScreenshot);
		
	}
	
	@After
	public void fecharPagina() {
		//navegador.quit();
		
	}
	

}
