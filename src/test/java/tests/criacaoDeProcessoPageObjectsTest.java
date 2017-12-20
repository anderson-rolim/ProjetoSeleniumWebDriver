package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
//@DataLoader(filePaths = "testAdicionarUmProcessoNaPautaDoTracks.csv")
@DataLoader(filePaths = "criacaoDeProcessoPageObjectsTest.csv")

public class criacaoDeProcessoPageObjectsTest {
	
	private WebDriver navegador;
	@Before
	public void setUp() {
		navegador = Web.createBrowserStack();
	}
	
	@Test
	public void testAddUmProcessoNaPautaDoTracks(
			@Param(name="login")String login,
			@Param(name="password")String password, 
			@Param(name="addInformacaoPeca")String addInformacaoPeca,
			@Param(name="titulo")String titulo,
			@Param(name="email")String email, 
			@Param(name="textoParaOProcesso")String textoParaOProcesso
			) {
		
		new LoginPage(navegador)
			.fazerLogin(login, password)
			.irParaFormDePeca()
			.addInformacaoNoFormularioDePeca(addInformacaoPeca) 
			.digiteTitulo(titulo)
			.digiteEmail(email)
			.selecioneUmRelacionamento()
			.digiteUmTextoParaAutomacao(textoParaOProcesso)
			.submeterFormulario();
		
	
	}

	
	/*@Test
	public void testAddUmProcessoNaPautaDoTracks() {
		new LoginPage(navegador)
			.fazerLogin("automacao", "jamworks")
			.irParaFormDePeca()
			.addInformacaoNoFormularioDePeca("Formulario de Teste para Automacao de Teste") 
			.digiteTitulo("Automacao de Teste")
			.digiteEmail("anderson.rolim@casavaticano.com.br")
			.selecioneUmRelacionamento()
			.digiteUmTextoParaAutomacao("Texto Qualquer para Automacao de Teste")
			.submeterFormulario();
		
	
	}
	*/
	
//	@Test
	public void testAddNoPedidoDeMaterialNoProcessoDaPautaDoTracks() {
		new LoginPage(navegador)
			.fazerLogin("automacao", "jamworks")
			.irParaFormDePeca()
			.addInformacaoNoFormularioDePeca("PedidoDeMaterial - Formulario de Teste para Automacao de Teste") 
			.digiteTitulo("Automacao de Teste")
			.digiteEmail("anderson.rolim@casavaticano.com.br")
			.digiteUmTextoParaAutomacao("Texto Qualquer para Automacao de Teste")
			.widgetPedidoMaterial("Globo RS")
			.selecioneUmRelacionamento()
			.submeterFormulario();
	}	
	
//	@Test
	public void testAddNoWidgetDeTabelaNoProcessoDaPautaDoTracks() {
		new LoginPage(navegador)
		.fazerLogin("automacao", "jamworks")
		.irParaFormDePeca()
		.addInformacaoNoFormularioDePeca("WidgetDeTabela - Formulario de Teste para Automacao de Teste") 
		.digiteTitulo("Automacao de Teste")
		.digiteEmail("anderson.rolim@casavaticano.com.br")
		.widgetDeTabela("1234", "Laranja UVA", "4 Miligrama")
		.selecioneUmRelacionamento()
		.submeterFormulario();

	}	

//	@Test
	public void testAddNoWidgetMaterialNoProcessoDaPautaDoTracks() {
		new LoginPage(navegador)
		.fazerLogin("automacao", "jamworks")
		.irParaFormDePeca()
		.addInformacaoNoFormularioDePeca("Formulario de Teste para Automacao de Teste") 
		.digiteTitulo("Automacao de Teste")
		.digiteEmail("anderson.rolim@casavaticano.com.br")
		.widgetMaterial("100", "Revista ROLIM")
		.selecioneUmRelacionamento()
		.submeterFormulario();

	}	
	@After
	public void tearDown() {
		navegador.quit();
	}

}
