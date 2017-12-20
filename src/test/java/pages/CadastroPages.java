package pages;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
//import tests.dropdown;

public class CadastroPages {
	
private WebDriver driver;
	
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	  

	public CadastroPages(WebDriver driver) {

		this.driver = driver;
	}

	//------------------------ACAO DO LOGIN --------------------
	
	public void login() {

		WebElement login = driver.findElement(By.id("username"));
		login.sendKeys("anderson.rolim");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("jamworks");

		WebElement entrar = driver.findElement(By.id("_submit"));
		entrar.submit();

	}

	public void acaoLogout() throws InterruptedException {

		// Efetuar logout do Sistema

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("i.icon-chevron-down.icon-white")).click();
		driver.findElement(By.id("cloud_accout_logout")).click();

	}

	//------------------------MODULO MASTER --------------------
	
	// Busca a conta no ambiente Master
	public void buscaContaMaster() {

		// Busca da conta 31
		WebElement campoBusca = driver.findElement(By.id("master_account_search_text"));
		campoBusca.sendKeys("31");

		WebElement buscar = driver.findElement(By.id("master_accont_search"));
		buscar.submit();

	}

	public void seletorDeConta() throws InterruptedException {
		// Administrar Conta
		Thread.sleep(1000);
		WebElement admConta = driver.findElement(By.cssSelector("i.icon-administration"));
		admConta.click();

		Thread.sleep(1000);

		// Entrar no Grupo da Conta
		WebElement entrar = driver.findElement(By.id("master_accont_admin"));
		entrar.submit();

	}

	
	//------------------------MODULO TRACKS --------------------

	public void acessandoModuloTracks() throws InterruptedException {
		// Acessando Modulo Tracks
		WebElement moduloTracks = driver.findElement(By.linkText("Tracks"));
		moduloTracks.click();
		Thread.sleep(1000);
	}


	//------------------------ACAO DO MODULO TRACKS --------------------

	public void buscaDeProcessoAutomatizado() throws InterruptedException {
		// Fazendo a busca.
		Thread.sleep(1000);

		WebElement limpaBusca = driver.findElement(By.id("admin_user_serach_input"));
		limpaBusca.clear();

		WebElement escreverBusca = driver.findElement(By.id("admin_user_serach_input"));
		escreverBusca.sendKeys("Teste Automatizado.");

		WebElement fazerBusca = driver.findElement(By.id("admin_user_serach-btn"));
		fazerBusca.click();
	}

	public void buscaDeAtividadeDoProcessoAutomatizado() throws InterruptedException {
		Thread.sleep(500);

		// Fazendo a Busca por tipo da atividade (Principal)

		WebElement limpaBusca = driver.findElement(By.id("admin_user_serach_input"));
		limpaBusca.clear();

		WebElement escreverBusca = driver.findElement(By.id("admin_user_serach_input"));
		escreverBusca.sendKeys("Principal");

		WebElement fazerBusca = driver.findElement(By.id("admin_user_serach-btn"));
		fazerBusca.click();
	}

	public void acoesDoProcesso() throws InterruptedException {
		//Thread.sleep(2000);
		// Editar nome de Processo
		acaoEditarProcesso();
		Thread.sleep(2000);

		// Escrever comentario
		acaoComentarioProcesso();
		Thread.sleep(1000);

		// Renomear
		acaoRenomearProcesso();

	}

	// Remover processo
	public void acaoRemoverProcesso() throws InterruptedException {

		Thread.sleep(1000);
		
		WebElement acaoRemoverDadosProcesso = driver.findElement(By.cssSelector("i.icon-remove"));
		acaoRemoverDadosProcesso.click();

		Thread.sleep(4000);
		WebElement limpar = driver.findElement(By.id("comentario_texto"));
		limpar.clear();
		WebElement editarProcesso = driver.findElement(By.id("comentario_texto"));
		editarProcesso.sendKeys("Exclusão de processo da Automação de Teste.");

		WebElement btnRemoverDadosProcesso = driver.findElement(By.id("tracker_ations_cancel_process_save"));
		btnRemoverDadosProcesso.click();

		Thread.sleep(1000);
	}

	// Editar dados do processo
	public void acaoEditarProcesso() throws InterruptedException {
		//Thread.sleep(4000);
		WebElement editarDadosProcesso = driver.findElement(By.cssSelector("i.icon-pencil"));
		editarDadosProcesso.click();

		Thread.sleep(4000);
		WebElement limpar = driver.findElement(By.id("processo_title"));
		limpar.clear();
		WebElement editarProcesso = driver.findElement(By.id("processo_title"));
		editarProcesso.sendKeys("Teste Automatizado");

		WebElement acaoEditarProcessoTracks = driver.findElement(By.id("tracker_actions_edit_process"));
		acaoEditarProcessoTracks.click();
		
		Thread.sleep(1000);

	}

	// Inserir Comentario do processo
	public void acaoComentarioProcesso() throws InterruptedException {

		WebElement comentario = driver.findElement(By.cssSelector("i.icon-comment"));
		comentario.click();
		Thread.sleep(4000);

		WebElement limpar = driver.findElement(By.id("comentario_texto"));
		limpar.clear();

		WebElement escreverComentario = driver.findElement(By.id("comentario_texto"));
		escreverComentario.sendKeys(
				"Teste automatizado de comentário para homologação.\nTexto automatizado\n----------------------\n Uma pessoa gosta do país em que vive e não há nada a fazer. "
				+ "Parece-me assim essencial que o país se submeta a segunda volta contra o doutor Mário Soares e que o Professor Doutor Aníbal Cavaco Silva ganhe. Assim como na "
						+ "direita há demasiado medo da segunda volta, na esquerda existem demasiadas esperanças. "
						+ "egoísmo, a ganância, a ambição, finalmente, do sentido a dar à Justiça.");

		WebElement acaoEscrever = driver.findElement(By.id("tracker_actions_comment_save"));
		acaoEscrever.click();
		Thread.sleep(1000);

	}

	// Renomear peca do processo
	public void acaoRenomearProcesso() throws InterruptedException {

		WebElement renomear = driver.findElement(By.cssSelector("i.icon-rename"));
		renomear.click();

		Thread.sleep(4000);

		WebElement limpar = driver.findElement(By.id("peca_name"));
		limpar.clear();

		WebElement renomearPeca = driver.findElement(By.id("peca_name"));
		renomearPeca.sendKeys("Teste Automatizado.");

		WebElement acaoRenomearProcessoTracks = driver.findElement(By.id("tracker_action_rename_submit"));
		acaoRenomearProcessoTracks.click();

	}

	// Validando mensagem com sucesso
	public String validarMensagem() {

		return driver.findElement(By.cssSelector("div.alert.alert-success")).getText();

	}
	// Validando mensagem com sucesso
	public String validarMensagemNome() {

		return driver.findElement(By.cssSelector("#cloud_account_dropdown")).getText();

	}

	
	
	
	
	
	// Novo Processo
	public void novoProcesso() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.linkText("Tracks")).click();
		driver.findElement(By.id("new-process-instance")).click();
		// Achando Elemento (Processo) 
		//Estava invisivel;

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		WebElement invisibleelement = driver.findElement(By.id("tracks_process_6"));

		executor.executeScript("arguments[0].click();", invisibleelement);

		 formularioPeca();
		 preencherCampos();

	}

	// Formulario da Peca
	public void formularioPeca() throws InterruptedException {
		Thread.sleep(1000);

		WebElement limparCampoTitulo = driver.findElement(By.id("form_2_field_1"));
		limparCampoTitulo.clear();
		
		WebElement CampoTitulo = driver.findElement(By.id("form_2_field_1"));
		CampoTitulo.sendKeys("Teste Automatizado");

		Thread.sleep(1000);
		WebElement agencia = driver.findElement(By.xpath(".//*[@id='form_2_field_3']/option[3]"));
		agencia.click();
		//*[@id="form_2_field_3"]/option[3]

		Thread.sleep(2000);
		WebElement anunciante = driver.findElement(By.xpath(".//*[@id='form_2_field_4']/option[3]"));
		anunciante.click();
		
		//*[@id="form_2_field_4"]/option[3]

		Thread.sleep(1000);
		WebElement produto = driver.findElement(By.xpath(".//*[@id='form_2_field_5']/option[2]"));
		produto.click();
		
		//*[@id="form_2_field_5"]/option[2]

	}

	// Formulario do processo
	public void preencherCampos() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.id("tracker_form_peca_save")).click();

		campoTituloDaAtividadeDoProcesso();
		campoEmailDaAtividadeDoProcesso();

		WebElement comboRelacionamento = driver.findElement(By.xpath(".//*[@id='form_1_field_1038']/option[2]"));
		comboRelacionamento.click();

		campoTextoGrandeDaAtividadeDoProcesso();
		campoWidgetDeTabelaDaAtividadeDoProcesso();

		driver.findElement(By.name("btn")).click();
	}

	// Entrando na atividade
	public void entrandoNaAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(500);
		WebElement entrandoNaAtividadePricnipal = driver.findElement(By.id("tracker_list_activity_1"));
		entrandoNaAtividadePricnipal.click();

	}

	// Campo Titulo
	public void campoTituloDaAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(1000);
		WebElement campoTitulo = driver.findElement(By.id("form_1_field_1037"));
		campoTitulo.clear();
		campoTitulo.sendKeys("Teste Automatizado no Jamworks");
	}

	// Campo Email
	public void campoEmailDaAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(1000);
		WebElement campoEmail = driver.findElement(By.id("form_1_field_1036"));
		campoEmail.clear();
		campoEmail.sendKeys("teste@teste.com.br");
		campoEmail.clear();
		campoEmail.sendKeys("anderson.rolim@casavaticano.com.br");

	}

	// Campo Texto Grande
	public void campoTextoGrandeDaAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(1000);
		WebElement campoTextoGrande = driver.findElement(By.id("form_1_field_1039"));
		campoTextoGrande.clear();
		campoTextoGrande.sendKeys("teste");
		campoTextoGrande.clear();
		campoTextoGrande.sendKeys(
				"Uma pessoa gosta do país em que vive e não há nada a fazer. "
				+ "e que o Professor Doutor Aníbal Cavaco Silva ganhe. Assim como na direita há demasiado medo da"
				+ " segunda volta, na esquerda existem demasiadas esperanças. "
				+ "agora).");

	}

	public void campoWidgetDeTabelaDaAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(1000);
		// Widget de tabela
		driver.findElement(By.id("form_table_form_1_field_1041_row1_cel1]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row1_cel1]")).sendKeys("121244556613");
		driver.findElement(By.id("form_table_form_1_field_1041_row1_cel2]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row1_cel2]")).sendKeys("Camisa - Vermelha Teste");
		driver.findElement(By.id("form_table_form_1_field_1041_row1_cel3]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row1_cel3]")).sendKeys("GG");
		driver.findElement(By.id("form_table_form_1_field_1041_row2_cel1]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row2_cel1]")).sendKeys("121244556614");
		driver.findElement(By.id("form_table_form_1_field_1041_row2_cel2]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row2_cel2]")).sendKeys("Camisa - Azul Teste");


	}

	public void acaoSalvarAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(500);
		// Botão Salvar
		WebElement salvar = driver.findElement(By.id("tracker_form_activity_save"));
		salvar.click();
	}

	public void editandoAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(500);

		entrandoNaAtividadeDoProcesso();
		campoTituloDaAtividadeDoProcesso();
		campoEmailDaAtividadeDoProcesso();
		campoTextoGrandeDaAtividadeDoProcesso();
		campoWidgetDeTabelaDaAtividadeDoProcesso();
		acaoSalvarAtividadeDoProcesso();

	}
	
	//------------------------MODULO DAM --------------------

	public void acessandoModuloDAM() throws InterruptedException {
		// Acessando Modulo Tracks
		WebElement moduloDAM = driver.findElement(By.linkText("DAM"));
		moduloDAM.click();
		Thread.sleep(1000);
	}
	
	
	//------------------------ACAO DO MODULO DAM --------------------
	
	
	public void estruturaPasta()  throws InterruptedException{


		driver.findElement(By.id("dam_index_folder_1")).click();
		driver.findElement(By.id("dam_index_folder_4")).click();
		driver.findElement(By.id("dam_index_folder_1")).click();

	}
	
	public void PrimeiraPasta()  throws InterruptedException{

		driver.findElement(By.id("dam_index_folder_1")).click();
		
		WebElement pastaColecao = driver.findElement(By.linkText("Colecao"));
		pastaColecao.click();
		Thread.sleep(1000);
	
	}
	public void acaoCriarDiretorioDAM()  throws InterruptedException{


		String x = " A14488";
		driver.findElement(By.id("dam_index_upload_new")).click(); 
		driver.findElement(By.id("dam_index_upload_dir")).click();
		Thread.sleep(800);
		driver.findElement(By.id("diretorio_nome")).clear();
		driver.findElement(By.id("diretorio_nome")).sendKeys(x);
		Thread.sleep(800);
		driver.findElement(By.id("dam_action_new_dir_submit")).click();
		Thread.sleep(800);

	}
	
	
	
	public void acaoCompartilhamentoDAM() throws InterruptedException{

	
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		WebElement seletorDeacao = driver.findElement(By.xpath(".//*[@id='dam_acao_compartilhar_diretorio_1']/i"));
		executor.executeScript("arguments[0].click();", seletorDeacao);

		
		
		Thread.sleep(1000);
	    
		WebElement limparCampoTitulo = driver.findElement(By.id("shared_link_titulo"));
		limparCampoTitulo.clear();
	    
		WebElement campoTitulo             = driver.findElement(By.id("shared_link_titulo"));
		campoTitulo.sendKeys("Email Automatizado");
		
		WebElement receberCopia            = driver.findElement(By.id("shared_link_cc"));
		receberCopia.click();
		
		WebElement limparCampoEmails       = driver.findElement(By.id("shared_link_emails"));
		limparCampoEmails.clear();
		
		WebElement campoEmails             = driver.findElement(By.id("shared_link_emails"));
		campoEmails.sendKeys("anderson.rolim@casavaticano.com.br");
		
		WebElement limparCampoObservacoess = driver.findElement(By.id("shared_link_obs"));
		limparCampoObservacoess.clear();
		
		WebElement campoObservacoess       = driver.findElement(By.id("shared_link_obs"));
		campoObservacoess.sendKeys("O que é Lorem Ipsum? "
	    		+ "Lorem Ipsum é simplesmente uma simulação de texto da indústria "
	    		+ "tipográfica e de impressos, e vem sendo utilizado desde o "
	    		+ "século XVI, quando um impressor desconhecido pegou uma bandeja "
	    		+ "de tipos e os embaralhou para fazer um livro de modelos de tipos. "
	    		+ "Lorem Ipsum sobreviveu não só a cinco séculos, como também ao "
	    		+ "editoração eletrônica como Aldus PageMaker.");
		WebElement btnEnviar                = driver.findElement(By.id("dam_shared_button_submit"));
		btnEnviar.click();
  
    	//Email enviado com sucesso
		Assert.assertEquals(validarMensagem(), "×" + "\n" + "Email enviado com sucesso.");	
		Thread.sleep(1000);
	    
		
	}	  

	public void acaoExcluirDAM() throws InterruptedException{

		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		WebElement acaoRemover = driver.findElement(By.xpath(".//*[@id='dam_acao_remover_diretorio_1']/i"));
		executor.executeScript("arguments[0].click();", acaoRemover);
		
		WebElement excluirPasta = driver.findElement(By.xpath(".//*[@id='dam_action_remove_submit']"));
		executor.executeScript("arguments[0].click();", excluirPasta);
		
	}	  
	
	public void acaoRenomearDAM() throws InterruptedException{

		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		WebElement acaoRenomear = driver.findElement(By.xpath(".//*[@id='dam_acao_renomear_diretorio_1']/i"));
		executor.executeScript("arguments[0].click();", acaoRenomear);

		
		WebElement limparCampo = driver.findElement(By.id("arquivo_nome"));
		limparCampo.clear();	
		
		WebElement preencherCampo = driver.findElement(By.id("arquivo_nome"));
		preencherCampo.sendKeys("A14488-Automatizado");
		
		WebElement submeterForm = driver.findElement(By.id("dam_action_rename_submit"));
		submeterForm.click();

		Thread.sleep(1000);
		Assert.assertEquals(validarMensagem(), "×" + "\n" + "Pasta renomeada com sucesso.");	
	
	
		//------------------------------
		
		WebElement acaoRenomearOriginal = driver.findElement(By.xpath(".//*[@id='dam_acao_renomear_diretorio_1']/i"));
		executor.executeScript("arguments[0].click();", acaoRenomearOriginal);
		
		driver.findElement(By.id("arquivo_nome")).clear();
	    driver.findElement(By.id("arquivo_nome")).sendKeys("A14488");
	    driver.findElement(By.id("dam_action_rename_submit")).click();

		Thread.sleep(1000);
		Assert.assertEquals(validarMensagem(), "×" + "\n" + "Pasta renomeada com sucesso.");	

		
		
	}	 

	public void acaoFavoritoDAM() throws InterruptedException{

		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		WebElement acaoAddArquivo = driver.findElement(By.xpath(".//*[@id='dam_acao_favorito_folder_add_1']/i"));
		executor.executeScript("arguments[0].click();", acaoAddArquivo);
		
		Assert.assertEquals(validarMensagem(), "×" + "\n" + "Favorito adicionado com sucesso.");	
				
		//Acessando a acao do favorito
		Thread.sleep(800);
		WebElement acessandoFavorito = driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div[2]/div/a/i"));
		executor.executeScript("arguments[0].click();", acessandoFavorito);
				
		Thread.sleep(1000);
		WebElement retirarDoFavorito = driver.findElement(By.xpath(".//*[@id='user_favor_remove1']/i"));
		executor.executeScript("arguments[0].click();", retirarDoFavorito);

		Thread.sleep(1000);
		Assert.assertEquals(validarMensagem(), "×" + "\n" + "Favorito removido com sucesso.");	
			
		
	}	  
	
	public void AcaoBuscarDAM() throws InterruptedException{
		Thread.sleep(1000);
		//Fazer busca por diretório
		driver.findElement(By.id("dam_navegation_index_search_input")).clear();
		driver.findElement(By.id("dam_navegation_index_search_input")).sendKeys(" A14488");
		driver.findElement(By.cssSelector("button")).click();

	}
	
	public void basketArquvivoCompartilharDAM() throws InterruptedException{
		Thread.sleep(1000);
		//Compartilhar arquivo na Basket do DAM
		
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		WebElement marcarCheckbox = driver.findElement(By.xpath(".//*[@id='dam_box_checkbox_1457858']"));
		executor.executeScript("arguments[0].click();", marcarCheckbox);

			
        driver.findElement(By.cssSelector("i.icon-shopping-cart.icon-white")).click();
	   
	    driver.findElement(By.id("folder-selected_share")).click();
	    Thread.sleep(1000);

	    
	    
	    driver.findElement(By.id("shared_link_titulo")).clear();
	    driver.findElement(By.id("shared_link_titulo")).sendKeys("Teste de envio de Arquivo Automatizado");
	    driver.findElement(By.id("shared_link_cc")).click();
	    driver.findElement(By.id("shared_link_emails")).clear();
	    driver.findElement(By.id("shared_link_emails")).sendKeys("anderson.rolim@casavaticano.com.br");
	    driver.findElement(By.id("shared_link_obs")).clear();
	    driver.findElement(By.id("shared_link_obs")).sendKeys("Teste automatizado envio de e-mail.");

		Thread.sleep(1000);
		
		driver.findElement(By.id("dam_shared_button_submit")).click();
		
		Assert.assertEquals(validarMensagem(), "×" + "\n" + "Email enviado com sucesso.");	
		
		
		driver.findElement(By.id("dam_box_checkbox_1457858")).click();
	    

	}	
	
	public void basketArquvivoDRMDAM() throws InterruptedException{
		Thread.sleep(1000);
		//Compartilhar arquivo na Basket do DAM
		
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		WebElement marcarCheckbox = driver.findElement(By.xpath(".//*[@id='dam_box_checkbox_1457858']"));
		executor.executeScript("arguments[0].click();", marcarCheckbox);
			
        driver.findElement(By.cssSelector("i.icon-shopping-cart.icon-white")).click();

        Thread.sleep(1000);
        
	    driver.findElement(By.id("applyCopyrightToFiles")).click();
	    Thread.sleep(1000);

		WebElement marcarCheckboxDRM = driver.findElement(By.xpath(".//*[@id='artbuyer_checkbox_78']"));
		executor.executeScript("arguments[0].click();", marcarCheckboxDRM);

		Thread.sleep(1000);
	    driver.findElement(By.id("artbuyer_widget_submit")).click();
  
		Thread.sleep(1000);
	
		driver.findElement(By.id("dam_box_checkbox_1457858")).click();

		WebElement acaoInfo = driver.findElement(By.xpath(".//*[@id='dam_acao_info_arquivo_1']/i"));
		executor.executeScript("arguments[0].click();", acaoInfo);
		
		Thread.sleep(1000);
		
	    driver.findElement(By.id("menu_clouddambundle_info_info_direitos de uso")).click();

		Thread.sleep(800);
		
		WebElement excluirDRM = driver.findElement(By.xpath(".//*[@id='dam_acao_remover_vinculo_direito_uso_78']/i"));
		executor.executeScript("arguments[0].click();", excluirDRM);
	    
		Thread.sleep(1000);
		
		driver.findElement(By.id("btn_remove_link_artbuyer")).click();
		
		WebElement historicoDRM = driver.findElement(By.xpath(".//*[@id='menu_clouddambundle_info_artbuyer_histórico']"));
		executor.executeScript("arguments[0].click();", historicoDRM);
			
		Thread.sleep(1000);
			
		WebElement informacaoDRM = driver.findElement(By.xpath(".//*[@id='menu_clouddambundle_info_artbuyer_informações']"));
		executor.executeScript("arguments[0].click();", informacaoDRM);
		
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Imagens_Au...")).click();
		

	}	
	
	
	// ---------------------- Manipulacao de Arquivo ---------------------
	
	
	
		public void acaoCompartilhamentoDeArquivoNoDAM() throws InterruptedException{

	
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		WebElement seletorDeacao = driver.findElement(By.xpath(".//*[@id='dam_acao_compartilhar_arquivo_1']/i"));
		executor.executeScript("arguments[0].click();", seletorDeacao);
			
		Thread.sleep(1000);
	    
		WebElement limparCampoTitulo = driver.findElement(By.id("shared_link_titulo"));
		limparCampoTitulo.clear();
	    
		WebElement campoTitulo             = driver.findElement(By.id("shared_link_titulo"));
		campoTitulo.sendKeys("Email Automatizado");
		
		WebElement receberCopia            = driver.findElement(By.id("shared_link_cc"));
		receberCopia.click();
		
		WebElement limparCampoEmails       = driver.findElement(By.id("shared_link_emails"));
		limparCampoEmails.clear();
		
		WebElement campoEmails             = driver.findElement(By.id("shared_link_emails"));
		campoEmails.sendKeys("anderson.rolim@casavaticano.com.br");
		
		WebElement limparCampoObservacoess = driver.findElement(By.id("shared_link_obs"));
		limparCampoObservacoess.clear();
		
		WebElement campoObservacoess       = driver.findElement(By.id("shared_link_obs"));
		campoObservacoess.sendKeys("O que é Lorem Ipsum? "
	    		+ "Lorem Ipsum é simplesmente uma simulação de texto da indústria "
	    		+ "tipográfica e de impressos, e vem sendo utilizado desde o "
	    		+ "século XVI, quando um impressor desconhecido pegou uma bandeja "
	    		+ "de tipos e os embaralhou para fazer um livro de modelos de tipos. "
	    		+ "recentemente quando passou a ser integrado a softwares de "
	    		+ "editoração eletrônica como Aldus PageMaker.");
		WebElement btnEnviar                = driver.findElement(By.id("dam_shared_button_submit"));
		btnEnviar.click();
  
    	//Email enviado com sucesso
		Assert.assertEquals(validarMensagem(), "×" + "\n" + "Email enviado com sucesso.");	
		Thread.sleep(1000);
	    
		
	}	  
	
	public void acaoRenomearArquivoNoDAM() throws InterruptedException{

		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		WebElement acaoRenomear = driver.findElement(By.xpath(".//*[@id='dam_acao_renomear_arquivo_1']/i"));
		executor.executeScript("arguments[0].click();", acaoRenomear);

		
		WebElement limparCampo = driver.findElement(By.id("arquivo_nome"));
		limparCampo.clear();	
		
		WebElement preencherCampo = driver.findElement(By.id("arquivo_nome"));
		preencherCampo.sendKeys("A14488-Arquivo_Automatizado");
		
		WebElement submeterForm = driver.findElement(By.id("dam_action_rename_submit"));
		submeterForm.click();

		Thread.sleep(1000);
		Assert.assertEquals(validarMensagem(), "×" + "\n" + "Arquivo renomeado com sucesso.");	
	
	
		//Desfazer trazendo para o nome orginal
		
		WebElement acaoRenomearOriginal = driver.findElement(By.xpath(".//*[@id='dam_acao_renomear_arquivo_1']/i"));
		executor.executeScript("arguments[0].click();", acaoRenomearOriginal);
		
		driver.findElement(By.id("arquivo_nome")).clear();
	    driver.findElement(By.id("arquivo_nome")).sendKeys("Lata de Milho");
	    driver.findElement(By.id("dam_action_rename_submit")).click();

		Thread.sleep(1000);
		Assert.assertEquals(validarMensagem(), "×" + "\n" + "Arquivo renomeado com sucesso.");	
			
	}	 

	public void acaoFavoritoDeArquivoNoDAM() throws InterruptedException{

		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		WebElement acaoAddArquivo = driver.findElement(By.xpath(".//*[@id='dam_acao_favorito_file_add_1']/i"));
		executor.executeScript("arguments[0].click();", acaoAddArquivo);
		
		Assert.assertEquals(validarMensagem(), "×" + "\n" + "Favorito adicionado com sucesso.");	
				
		//Acessando a acao do favorito
		Thread.sleep(800);
		WebElement acessandoFavorito = driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div[2]/div/a/i"));
		executor.executeScript("arguments[0].click();", acessandoFavorito);
				
		Thread.sleep(1000);
		WebElement retirarDoFavorito = driver.findElement(By.xpath(".//*[@id='user_favor_remove1']/i"));
		executor.executeScript("arguments[0].click();", retirarDoFavorito);

		Thread.sleep(1000);
		Assert.assertEquals(validarMensagem(), "×" + "\n" + "Favorito removido com sucesso.");	
			
		
	}	  
	
	public void AcaoBuscarPastaDeImagemNoDAM() throws InterruptedException{
		Thread.sleep(4000);
		//Fazer busca por diretório
		driver.findElement(By.id("dam_navegation_index_search_input")).clear();
		driver.findElement(By.id("dam_navegation_index_search_input")).sendKeys("Imagens_Automacao");
		driver.findElement(By.cssSelector("button")).click();
		
		//Clica na pasta de imagens
		driver.findElement(By.id("dam_index_folder_1")).click();

	}
	
	

	public void acaoCriarDiretorioDeMovimentacaoDeArquivoDAM()  throws InterruptedException{


		String x = " pasta-movimento";
		driver.findElement(By.id("dam_index_upload_new")).click(); 
		driver.findElement(By.id("dam_index_upload_dir")).click();
		Thread.sleep(800);
		driver.findElement(By.id("diretorio_nome")).clear();
		driver.findElement(By.id("diretorio_nome")).sendKeys(x);
		Thread.sleep(800);
		driver.findElement(By.id("dam_action_new_dir_submit")).click();
		Thread.sleep(800);
		//Assert.assertEquals(validarMensagem(), "×" + "\n" + "Pasta criada com sucesso.");
		//Thread.sleep(1000);
		
	}
	
	public void acaoMoverArquivoParaPastaDestinoDAM()  throws InterruptedException{

		Thread.sleep(1000);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		WebElement acaoMoverArquivo = driver.findElement(By.xpath(".//*[@id='dam_acao_mover_arquivo_1']/i"));
		executor.executeScript("arguments[0].click();", acaoMoverArquivo);
		
		Thread.sleep(800);

		WebElement acaoArvoreHomologacao_01 = driver.findElement(By.xpath("//li[@id='1449459']/a"));
		acaoArvoreHomologacao_01.click();	
		
		Thread.sleep(800);

		WebElement acaoArvoreHomologacao_02 = driver.findElement(By.xpath("//li[@id='1449459']/ins"));
		acaoArvoreHomologacao_02.click();
		
		Thread.sleep(800);

		WebElement acaoArvoreHomologacaoAgencia = driver.findElement(By.linkText("Homologacao-Agencia"));
		acaoArvoreHomologacaoAgencia.click();
		
		Thread.sleep(800);

		WebElement acaoArvoreHomologacaoAgencia_01 = driver.findElement(By.xpath("//li[@id='1449461']/ins"));
		acaoArvoreHomologacaoAgencia_01.click();
		
		Thread.sleep(800);

		WebElement acaoArvoreHomologacaoAgencia_02 = driver.findElement(By.xpath("//li[@id='1449462']/a"));
		acaoArvoreHomologacaoAgencia_02.click();
		
		Thread.sleep(800);

		WebElement acaoArvoreHomologacaoAgencia_03 = driver.findElement(By.xpath("//li[@id='1449462']/ins"));
		acaoArvoreHomologacaoAgencia_03.click();
				
		Thread.sleep(800);

		WebElement acaoArvoreHomologacaoAgenciaImagens_Automacao_Teste = driver.findElement(By.linkText("Imagens_Automacao_Teste"));
		acaoArvoreHomologacaoAgenciaImagens_Automacao_Teste.click();
		
		Thread.sleep(2000);

		WebElement acaoArvoreHomologacaoAgenciaImagens_Automacao_Teste_01 = driver.findElement(By.xpath("//li[@id='1457846']/ins"));
		acaoArvoreHomologacaoAgenciaImagens_Automacao_Teste_01.click();
		
		Thread.sleep(800);

		WebElement acaoArvoreHomologacaoAgenciaImagens_Automacao_TestePasta_movimento = driver.findElement(By.linkText("pasta-movimento"));
		acaoArvoreHomologacaoAgenciaImagens_Automacao_TestePasta_movimento.click();

		Thread.sleep(2000);

		WebElement acaoArvoreHomologacaoAgenciaImagens_Automacao_TestePasta_movimentoSubmit = driver.findElement(By.id("dam_action_move_submit"));
		acaoArvoreHomologacaoAgenciaImagens_Automacao_TestePasta_movimentoSubmit.click();

		//Assert.assertEquals(validarMensagem(), "×" + "\n" + "Arquivo movido com sucesso.");
		
		//Thread.sleep(1000);

	}
	
	public void acaoMoverArquivoParaPastaOrigeDAM()  throws InterruptedException{

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		
		driver.findElement(By.id("dam_index_folder_1")).click();
		
		WebElement acaoMoverArquivo = driver.findElement(By.xpath(".//*[@id='dam_acao_mover_arquivo_1']/i"));
		executor.executeScript("arguments[0].click();", acaoMoverArquivo);
		
		Thread.sleep(800);

		WebElement acaoArvoreHomologacao_01 = driver.findElement(By.xpath("//li[@id='1449459']/a"));
		acaoArvoreHomologacao_01.click();	
		
		Thread.sleep(800);

		WebElement acaoArvoreHomologacao_02 = driver.findElement(By.xpath("//li[@id='1449459']/ins"));
		acaoArvoreHomologacao_02.click();
		
		Thread.sleep(800);

		WebElement acaoArvoreHomologacaoAgencia = driver.findElement(By.linkText("Homologacao-Agencia"));
		acaoArvoreHomologacaoAgencia.click();
		
		Thread.sleep(800);

		WebElement acaoArvoreHomologacaoAgencia_01 = driver.findElement(By.xpath("//li[@id='1449461']/ins"));
		acaoArvoreHomologacaoAgencia_01.click();
		
		Thread.sleep(800);

		WebElement acaoArvoreHomologacaoAgencia_02 = driver.findElement(By.xpath("//li[@id='1449462']/a"));
		acaoArvoreHomologacaoAgencia_02.click();
		
		Thread.sleep(800);

		WebElement acaoArvoreHomologacaoAgencia_03 = driver.findElement(By.xpath("//li[@id='1449462']/ins"));
		acaoArvoreHomologacaoAgencia_03.click();
				
		Thread.sleep(800);

		WebElement acaoArvoreHomologacaoAgenciaImagens_Automacao_Teste = driver.findElement(By.linkText("Imagens_Automacao_Teste"));
		acaoArvoreHomologacaoAgenciaImagens_Automacao_Teste.click();
		
		Thread.sleep(1500);

		WebElement acaoArvoreHomologacaoAgenciaImagens_Automacao_TestePasta_movimentoSubmit = driver.findElement(By.id("dam_action_move_submit"));
		acaoArvoreHomologacaoAgenciaImagens_Automacao_TestePasta_movimentoSubmit.click();
				
		Thread.sleep(800);
		
		//Assert.assertEquals(validarMensagem(), "×" + "\n" + "Arquivo movido com sucesso.");
		
	}	
	
	

	public void acaoSairDaPastaDAM()  throws InterruptedException{

		Thread.sleep(2000);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
	//	driver.findElement(By.id("dam_index_folder_1")).click();
		
		Thread.sleep(800);
		
		WebElement acaoLinkDaPastaImagens_Automacao_Teste =  driver.findElement(By.xpath("html/body/div[2]/div[1]/div[1]/div/a[1]/i"));
		executor.executeScript("arguments[0].click();", acaoLinkDaPastaImagens_Automacao_Teste);
		
		//driver.findElement(By.xpath("//a[@href='http://homologacao.casavaticano.com.br/dam/1457846']")).click();
				
		Thread.sleep(800);
		

	}	

	public void acaoExcluirPastaEspecificaPasta_movimentoDAM() throws InterruptedException{

		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		WebElement acaoRemover = driver.findElement(By.xpath(".//*[@id='dam_acao_remover_diretorio_2']/i"));
		executor.executeScript("arguments[0].click();", acaoRemover);
		
		WebElement excluirPasta = driver.findElement(By.xpath(".//*[@id='dam_action_remove_submit']"));
		executor.executeScript("arguments[0].click();", excluirPasta);
		
	}	
	
	
	
	
	
	
	//------------------------MODULO DRM --------------------

	public void acessandoModuloDRM() throws InterruptedException {
		Thread.sleep(1000);
		// Acessando Modulo Tracks
		WebElement moduloDRM = driver.findElement(By.linkText("DRM"));
		moduloDRM.click();
		Thread.sleep(1000);	
		
	}
	
	
	//------------------------ACAO DO MODULO DRM --------------------
	
	
	public void drmArquivoDiretorio() throws InterruptedException{
	
		Thread.sleep(1000);
		ordenacaoDRM();
		AcaoCriarDireitoDeUsoArquivo();
		Assert.assertEquals(validarMensagem(), "×" + "\n" + "Direito de uso editado com sucesso.");
		ordenacaoDRM();
		AcaoCriarDireitoDeUsoPasta();

	}
	
	
	  public void AcaoCriarDireitoDeUsoArquivo() throws InterruptedException{

		  WebElement novoFormDRM = driver.findElement(By.id("new-process-instance"));
		  novoFormDRM.click();
		  
		  WebElement novoDRMparaArquivo = driver.findElement(By.cssSelector("#direito_uso_novo_arquivo_link > i"));
		  novoDRMparaArquivo.click();
		
		  Thread.sleep(800);
		  WebElement agencia = driver.findElement(By.xpath(".//*[@id='form_727_field_806']/option[3]"));
		  agencia.click();
			
		  Thread.sleep(800);
		  WebElement anunciante = driver.findElement(By.xpath(".//*[@id='form_727_field_807']/option[3]"));
		  anunciante.click();
			
		  Thread.sleep(800);
		  WebElement CampoTipo = driver.findElement(By.xpath(".//*[@id='form_727_field_801']/option[3]"));
		  CampoTipo.click();
		  
		  WebElement limparCampoCodigo = driver.findElement(By.id("form_727_field_799"));
		  limparCampoCodigo.clear();
		  
		  WebElement CampoCodigo = driver.findElement(By.id("form_727_field_799"));
		  CampoCodigo.sendKeys("121241-Arquivo");
		  
		  WebElement limparCampoTitulo = driver.findElement(By.id("form_727_field_800"));
		  limparCampoTitulo.clear();
		  
		  WebElement CampoTitulo = driver.findElement(By.id("form_727_field_800"));
		  CampoTitulo.sendKeys("DRM-Automatizado-Arquivo");
		    
		  Thread.sleep(800);
		    
		  WebElement campoDataDeInicio = driver.findElement(By.id("form_727_field_802"));
		  campoDataDeInicio.click();
		  Thread.sleep(800);
		    
		  WebElement selectDayInicio =   driver.findElement(By.linkText("1"));
		  selectDayInicio.click();
		    
		  Thread.sleep(800);
		    
		  WebElement submeterDayInicio =driver.findElement(By.id("form_727_field_803"));
		  submeterDayInicio.click();
		    
		  Thread.sleep(800);
		    
		  WebElement campoDataDeTermino = driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e"));
		  campoDataDeTermino.click();

		  WebElement selectDayFim = driver.findElement(By.linkText("31"));
		  selectDayFim.click();
		    
		  WebElement limparCampoDescricao = driver.findElement(By.id("form_727_field_804"));
		  limparCampoDescricao.clear();
		  
		  WebElement campoDescricao = driver.findElement(By.id("form_727_field_804"));
		  campoDescricao.sendKeys("O que é Lorem Ipsum? "
		    		+ "Lorem Ipsum é simplesmente uma simulação de texto da indústria "
		    		+ "tipográfica e de impressos, e vem sendo utilizado desde o "
		    		+ "século XVI, quando um impressor desconhecido pegou uma bandeja "
		    		+ "recentemente quando passou a ser integrado a softwares de "
		    		+ "editoração eletrônica como Aldus PageMaker.");
		    
		  WebElement submeterFormDrm =driver.findElement(By.name("btn"));
		  submeterFormDrm.click();
		    		  
	}	 
	
	  public void AcaoCriarDireitoDeUsoPasta() throws InterruptedException{

		  WebElement novoFormDRM = driver.findElement(By.id("new-process-instance"));
		  novoFormDRM.click();
		  
		  WebElement novoDRMparaArquivo = driver.findElement(By.cssSelector("#direito_uso_novo_diretório_link > i"));
		  novoDRMparaArquivo.click();
		
		  Thread.sleep(800);
		  WebElement agencia = driver.findElement(By.xpath(".//*[@id='form_727_field_806']/option[3]"));
		  agencia.click();
			
		  Thread.sleep(800);
		  WebElement anunciante = driver.findElement(By.xpath(".//*[@id='form_727_field_807']/option[3]"));
		  anunciante.click();
			
		  Thread.sleep(800);
		  WebElement CampoTipo = driver.findElement(By.xpath(".//*[@id='form_727_field_801']/option[3]"));
		  CampoTipo.click();
		  WebElement limparCampoCodigo = driver.findElement(By.id("form_727_field_799"));
		  limparCampoCodigo.clear();
		  
		  int x=25101983;
		  WebElement CampoCodigo = driver.findElement(By.id("form_727_field_799"));
		  CampoCodigo.sendKeys("121245-Pasta-"+x+"-Pasta");
		  
		  WebElement limparCampoTitulo = driver.findElement(By.id("form_727_field_800"));
		  limparCampoTitulo.clear();
		  WebElement CampoTitulo = driver.findElement(By.id("form_727_field_800"));
		  CampoTitulo.sendKeys("DRM-Automatizado-Arquivo");
		    
		  Thread.sleep(800);
		    
		  WebElement campoDataDeInicio = driver.findElement(By.id("form_727_field_802"));
		  campoDataDeInicio.click();
		  Thread.sleep(800);
		    
		  WebElement selectDayInicio =   driver.findElement(By.linkText("1"));
		  selectDayInicio.click();
		    
		  Thread.sleep(800);
		    
		  WebElement submeterDayInicio =driver.findElement(By.id("form_727_field_803"));
		  submeterDayInicio.click();
		    
		  Thread.sleep(800);
		    
		  WebElement campoDataDeTermino = driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e"));
		  campoDataDeTermino.click();

		  WebElement selectDayFim = driver.findElement(By.linkText("31"));
		  selectDayFim.click();
		    
		  WebElement limparCampoDescricao = driver.findElement(By.id("form_727_field_804"));
		  limparCampoDescricao.clear();
	
		  
		  WebElement campoDescricao = driver.findElement(By.id("form_727_field_804"));
		  campoDescricao.sendKeys("Lorem ipsum dolor sit amet, amet auctor et elementum "
		    		+ "eget, nam imperdiet eros lorem dui ad, lectus vel vehicula, leo leo ipsum quam, erat et tristique magna "
		    		+ "mauris. Quisque sodales erat, porttitor quisque tellus scelerisque, elit vel, pharetra integer minim "
		    		+ "auctor aenean enim. In purus pharetra, congue in leo. Ea feugiat sed, arcu urna a morbi at arcu convallis, "
		    		+ "imperdiet donec. Felis sed parturient sed nunc, sollicitudin ac, arcu a tortor mi tristique erat. "
		    		+ "Vestibulum mattis lacinia, morbi in, bibendum libero ante libero hendrerit, urna et eget eget. "
		    		+ "Vel montes vitae porttitor.");
		    
		  WebElement submeterFormDrm =driver.findElement(By.name("btn"));
		  submeterFormDrm.click();
		    	  
	}	 

		public void buscaDRM() throws InterruptedException{
			
			Thread.sleep(1000);
		    driver.findElement(By.cssSelector("i.icon-filter")).click();
		    driver.findElement(By.id("tipo_controlado")).click();
		    driver.findElement(By.id("excludeOverdue")).click();
		    driver.findElement(By.id("add-advanced-search")).click();
		    Thread.sleep(800);

		}
		
		public void ordenacaoDRM() throws InterruptedException{
			
			Thread.sleep(1000);

			WebElement colunaTipo = driver.findElement(By.xpath("//a[contains(text(),'Tipo')]"));
			colunaTipo.click();
			WebElement colunaVigencia = driver.findElement(By.xpath("//a[contains(text(),'Vigência')]"));
			colunaVigencia.click();
			WebElement colunaTitulo = driver.findElement(By.xpath("//a[contains(text(),'Título')]"));
			colunaTitulo.click();
			WebElement colunaCodigo = driver.findElement(By.xpath("//a[contains(text(),'Código')]"));
			colunaCodigo.click();
			WebElement colunaDataVencimento = driver.findElement(By.xpath("//a[contains(text(),'Data vencimento')]"));
			colunaDataVencimento.click();
			WebElement colunaDataInicial = driver.findElement(By.xpath("//a[contains(text(),'Data inicial')]"));
			colunaDataInicial.click();
			WebElement colunaAnunciante = driver.findElement(By.xpath("//a[contains(text(),'Anunciante')]"));
			colunaAnunciante.click();
			WebElement colunaAgencia = driver.findElement(By.xpath("//a[contains(text(),'Agência')]"));
			colunaAgencia.click();
	    		

		}

}
