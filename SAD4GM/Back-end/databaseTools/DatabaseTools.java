package databaseTools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * Classe de Ferramentas de Conexão com o Banco de Dados.
 * 
 * @author caiosbl
 *
 */

public abstract class DatabaseTools {

	/**
	 * Instância da Conexão com o Banco de Dados
	 */
	protected Connection con;

	/**
	 * Abre uma Conexão com o Banco de Dados, caso este não exista é chamada a
	 * função de iniciar o Banco de Dados.
	 * 
	 * @throws SQLException Lança uma SQLException caso haja alguma falha na Conexão
	 *                      com o Banco de Dados.
	 */
	protected void abrirConexao() throws SQLException {

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:Sad4gmDatabase;");
		} catch (Exception e) {
			iniciarDatabase();
		}
	}

	/**
	 * Inicia o Banco de Dados.
	 * 
	 * @throws SQLException
	 * 
	 */
	private void iniciarDatabase() throws SQLException {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:Sad4gmDatabase; create = true");

			criarSchema(con);
			criarTabelaUsuarios(con);
			inserirAdminDefault(con);
			criarTabelaMaquinas(con);
			criarTabelaSubsistema(con);
			criarTabelaComponente(con);
			criarTabelaFalha(con);
			criarTabelaModoFalha(con);
			criarTabelaCausasPotenciais(con);
			criarTabelaOrigemCausas(con);
			criarTabelaAcoesRecomendadas(con);
			criarTabelaEfeitos(con);
			carregarDados();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void carregarDados() throws SQLException, IOException {


		// Cria um lista para receber os inserts do arquivo
		String[] list = lerArquivoSQL();

		try {
			PreparedStatement stmt = null;
		
			for (String s : list) {
	
				stmt = con.prepareStatement(s);
				stmt.execute();
			}
			
			stmt.close();
			// faz o insert em lote no banco pelo método executeBatch()
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private String[] lerArquivoSQL() {
		String[] lista = {
				"INSERT INTO MAQUINAS.MAQUINA (NOME,DATA_INSERCAO,CODIGO,DESCRICAO,CHAVE_USUARIO) VALUES ('Transformador',{d '2018-12-01'},1,'Sistema Transformador',1)",
				"INSERT INTO MAQUINAS.SUBSISTEMA (NOME,CHAVE_MAQUINA) VALUES ('Parte Ativa',1)",
				"INSERT INTO MAQUINAS.SUBSISTEMA (NOME,CHAVE_MAQUINA) VALUES ('Sistema de Proteção',1)",
				"INSERT INTO MAQUINAS.COMPONENTE (NOME,CHAVE_SUBSISTEMA,FUNCAO) VALUES ('Núcleo',1,'')",
				"INSERT INTO MAQUINAS.COMPONENTE (NOME,CHAVE_SUBSISTEMA,FUNCAO) VALUES ('Sistema de Isolamento',1,'')",
				"INSERT INTO MAQUINAS.COMPONENTE (NOME,CHAVE_SUBSISTEMA,FUNCAO) VALUES ('Relé de gás (Buchholz)',2,'')",
				"INSERT INTO MAQUINAS.COMPONENTE (NOME,CHAVE_SUBSISTEMA,FUNCAO) VALUES ('Relé indicador da temperatura do óleo isolante',2,'')",
				"INSERT INTO MAQUINAS.COMPONENTE (NOME,CHAVE_SUBSISTEMA,FUNCAO) VALUES ('Relé indicador da temperatura do enrolamento',2,'')",
				"INSERT INTO MAQUINAS.COMPONENTE (NOME,CHAVE_SUBSISTEMA,FUNCAO) VALUES ('Válvula de alívio de pressão do tanque principal',2,'')",
				"INSERT INTO MAQUINAS.COMPONENTE (NOME,CHAVE_SUBSISTEMA,FUNCAO) VALUES ('Dispositivo impedidor de manobra do CDST (comutador de derivações sem tensão)',2,'')",
				"INSERT INTO MAQUINAS.COMPONENTE (NOME,CHAVE_SUBSISTEMA,FUNCAO) VALUES ('Relé de carcaça',2,'')",
				"INSERT INTO MAQUINAS.COMPONENTE (NOME,CHAVE_SUBSISTEMA,FUNCAO) VALUES ('Comutadores de Derivações em Carga (CDC)',2,'')",
				"INSERT INTO MAQUINAS.COMPONENTE (NOME,CHAVE_SUBSISTEMA,FUNCAO) VALUES ('Comutadores de Derivações sem Tensão (CDST)',2,'')",
				"INSERT INTO MAQUINAS.FALHA (NOME,DESCRICAO,CHAVE_COMPONENTE) VALUES ('Degradação da isolação (óleo e papel isolante)','Ruptura total ou redução significativa da suportabilidade da isolação',2)",
				"INSERT INTO MAQUINAS.FALHA (NOME,DESCRICAO,CHAVE_COMPONENTE) VALUES ('Falha no Relé de gás','',3)",
				"INSERT INTO MAQUINAS.FALHA (NOME,DESCRICAO,CHAVE_COMPONENTE) VALUES ('Falha no Relé indicador da temperatura do óleo isolante','',4)",
				"INSERT INTO MAQUINAS.FALHA (NOME,DESCRICAO,CHAVE_COMPONENTE) VALUES ('Falha no Relé indicador da temperatura do enrolamento','',5)",
				"INSERT INTO MAQUINAS.FALHA (NOME,DESCRICAO,CHAVE_COMPONENTE) VALUES ('Falha na Válvula de alívio de pressão do tanque principal','',6)",
				"INSERT INTO MAQUINAS.FALHA (NOME,DESCRICAO,CHAVE_COMPONENTE) VALUES ('Falha no Dispositivo impedidor de manobra do CDST','(comutador de derivações sem tensão)',7)",
				"INSERT INTO MAQUINAS.FALHA (NOME,DESCRICAO,CHAVE_COMPONENTE) VALUES ('Falha no Relé de carcaça','',8)",
				"INSERT INTO MAQUINAS.FALHA (NOME,DESCRICAO,CHAVE_COMPONENTE) VALUES ('Falha nos Comutadores de Derivações em Carga (CDC)','',9)",
				"INSERT INTO MAQUINAS.FALHA (NOME,DESCRICAO,CHAVE_COMPONENTE) VALUES ('Falhas em Comutadores de Derivações sem Tensão (CDST)','',10)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Envelhecimento natural da isolação','',1,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Sobreaquecimento do sistema de isolação','',1,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Rompimento  do dielétrico (modelo de falha cataléctica) ou degradação do dielétrico (modelo de falha de degradação)','',1,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Contaminação do sitema de isolação (óleo e papel) por umidade, oxigênio e outros poluentes','',1,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Eletrização estática do óleo','',1,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Formação de bolhas no óleo','',1,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Degradação da isolação das bobinas','',1,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Baixo isolamento contato do relé','',2,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Quebra do eixo de sustentação da bóia','',2,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Penetração de óleo isolante na bóia (oca)','',2,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Afundamento bóia (maciça)','',2,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Afundamento da bóia (oca)','',2,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Atuação indevida por compatibilidade eletromagnética','',2,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Baixo isolamento das régua terminais e fiação do relé','',2,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Atuação indevida por erro nos ajustes de atuação','',2,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Atuação indevida por vácuo no relé','',2,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Atuação indevida por falta de óleo no relé','',2,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Baixo isolamento contato do relé','',3,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Atuação indevida por impacto','',3,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Baixo isolamento das régua terminais e fiação do relé','',3,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Atuação indevida por compatibilidade eletromagnética','',3,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Atuação indevida por erro nos ajustes de atuação','',3,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Baixo isolamento contato do relé','',4,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Atuação indevida por impacto','',4,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Baixo isolamento das régua terminais e fiação do relé','',4,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Atuação indevida por compatibilidade eletromagnética','',4,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Atuação indevida por erro nos ajustes de atuação','',4,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Atuação indevida por degradação do isolamento entre os contatos da microchave','',5,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Atuação indevida por degradação do isolamento entre os contatos da microchave','',6,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Atuação indevida por curto-circuito','',7,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Falha no mecanismo de acionamento motorizado','',8,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Falha nas hastes e caixa de transmissões','',8,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Falha na chave comutadora (desviadora)','',8,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Falha no seletor e pré-seletor','',8,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.MODO_FALHA (NOME,DESCRICAO,CHAVE_FALHA,INDICE_OCORRENCIA,INDICE_DETECCAO,NUMERO_OCORRENCIAS) VALUES ('Falha no filtro absorvente','',8,1.0,1.0,0)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Causas não controláveis','',1)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Sobretensão no núcleo','',2)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Correntes harmônicas no enrolamento','',2)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Elevação da corrente de carga','',2)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Deslocamento ou deformação da geometria das bobinas do enrolamento','',2)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Temperatura ambiente elevada','',2)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Deficiências na isolação dos parafusos passantes que atravessam pelas lâminas do núcleo, ferragens e jugo','',2)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Tensão Transitória Rápida (com frente de onda muito rápida)','',2)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Sobretensões Ressonantes: tensões transitórias oriundas do sistema elétrico','',3)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Tensão Transitória Rápida (com frente de onda muito rápida)','',3)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Falha no sistema de resfriamento','',4)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Defeito das gaxetas de vedação','',4)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Corrosão do tanque principal','',4)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Corrosão do tanque auxiliar','',4)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Defeito da vedação','',4)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Defeitos em bombas do sistema de resfriamento','',4)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Ruptura das membranas dos tubos de expansão','',4)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Porosidade da borracha que compõe a membrana (ou bolsa) do sistema de preservação','',4)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Vazamento de água para o tanque principal','',4)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Desgaste das engrenagens das bombas do sistema de resfriamento','',4)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Desgastes dos contatos da chave seletora do comutador de derivações em carga','',4)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Vazamento de óleo do cilindro da chave desviadora do comutador de tape','',4)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Sobreaquecimento no sistema de isolação','',5)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Envelhecimento do óleo','',5)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Elevação do nível de gases no óleo','',6)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Sobreaquecimento do sistema de isolação','',6)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Contaminação do sistema de isolação (óleo e papel) por umidade, oxigênio e poluentes','',6)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Variações bruscas da pressão atmosférica','',6)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Vibração do núcleo','',7)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Contaminação por umidade, oxigênio e outros poluentes (animais/insetos)','',8)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Vibração excessiva na tubulação que interliga o tanque principal ao auxiliar','',9)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Falha na solda da bóia','',10)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Bóia furada pelo parafuso de fixação','',10)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Incompatibilidade do material da bóia maciça com óleo','',11)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Quebra do eixo de sustentação da bóia','',12)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Penetração de óleo isolante na bóia (oca)','',12)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Atuação indevida do contato da ampola','',12)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Vibração mecânica no relé','',13)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Curto-circuito no sistema elétrico (externo ao transformador)','',13)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Fluxo óleo p/desloc.','',13)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Degradação material isolante','',14)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Contaminação por umidade','',14)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Utilização de emendas na fiação e réguas intermediárias','',14)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Defeito de fabricação (erro de calibração)','',15)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Desajuste durante transporte/montagem do transformador','',15)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Válvula isolamento relé fechada','',16)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Falha no sistema de preservação','',16)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Quantidade insuficiente de óleo no transformador','',17)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Penetração de umidade','',18)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Penetração animais/insetos','',18)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Impacto da porta do armário no relé','',19)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Desprendimento do relé','',19)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Degradação material isolante','',20)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Penetração de umidade','',20)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Utilização de emendas na fiação e réguas intermediárias','',20)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Curto-circuito no sistema elétrico (externo ao transformador)','',21)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Defeito de fabricação (erro de calibração)','',22)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Desajuste durante transporte/montagem do transformador','',22)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Penetração de umidade','',23)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Penetração animais/insetos','',23)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Impacto da porta do armário no relé','',24)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Desprendimento do relé','',24)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Degradação material isolante','',25)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Penetração de umidade','',25)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Utilização de emendas na fiação e réguas intermediárias','',25)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Curto-circuito no sistema elétrico (externo ao transformador)','',26)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Defeito de fabricação (erro de calibração)','',27)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Desajuste durante transporte/montagem do transformador','',27)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Contaminação por umidade e outros poluentes','(poeira, chuva, animais/insetos)',28)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Vibração','',28)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Contaminação por umidade e outros poluentes','(poeira, chuva, animais/insetos)',29)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Curto-circuito dos circuitos auxiliares de alimentação','De ventiladores, das motobombas,  dos mecanismos de acionamento do comutador de tape, da resistência de aquecimento dos armários',30)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Quebra do dispositivo de disparo','',31)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Quebra/folga das engrenagens','',31)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Falha na chave auxiliar/contatores/disjuntores','',31)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Umidade excessiva nos armários (corros)','',31)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Desajuste fim de curso elétrico/mecânico','',31)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Solda fria conexão elétrica','',31)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Falha rolamento','',31)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Falha rolamento','',32)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Desacopl. hastes/caixa transmissão','',32)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Alinhamento incorreto hastes/caixa','',32)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Falta de folga longitudinal para dilatação das hastes','',32)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Lubrif. deficiente na caixa de transmissão','',32)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Conex elétricas folgadas sem travamento','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Reator/Resistor transição aberto','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Reator/Resistor transição','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Reator/Resistor transição aquecido','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Contato gasto/diferença aux/princ','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Contato desalinhado','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Contato pouca pressão','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Rompimento condutores fixos','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Falha solda contato','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Defeito na mola','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Defeito no mecanismo de transmissão','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Defeito na lâmina de amortecimento','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Falta sincron. desviadora com seletora','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Defeito na cordoalha','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Degradação da suportabilidade dielétrica','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Corpos','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Curto-circuito no resistor','',33)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Elevada tensão restabelecimento','',34)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Baixa pressão contato','',34)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Operação além fim de curso','',34)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Quebra transmissão','',34)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Desalinhamento contatos','',34)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Má conex resist. Polarização','',34)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Degradação da suportabilidade dielétrica','',34)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Inversão tubulações','',35)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Filtro saturado','',35)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Despreendimento material','',35)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Inversão sequência fase motobomba','',35)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Falha automatismo','',35)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Deficiec. drenagem ar após montag. Ou manutenção','',35)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Entrada de ar','',35)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Deformação nas hastes isolantes','',35)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Folgas excessivas nas hastes de transmissão','',35)",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS (NOME,DESCRICAO,CHAVE_MODO_FALHA) VALUES ('Fadiga molas contatos','',35)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Operação em sobrecarga',4)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Elevadas Correntes de Curto-Circuito',5)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Origem externa: descargas atomosféricas',8)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Origem interna: faltas no sistema ou operações de manobra',8)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Origem externa: descargas atomosféricas',9)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Origem interna: faltas no sistema ou operações de manobra',9)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Causas Desconhecidas',9)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Origem externa: descargas atomosféricas',10)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Origem interna: faltas no sistema ou operações de manobra',10)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Defeito das gaxetas de vedação',30)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Vibração excessiva na tubulação que interliga o tanque principal ao tanque auxiliar',35)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Vibração excessiva na tubulação que interliga o tanque principal ao tanque auxiliar',37)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Origem externa: descargas atomosféricas',39)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Origem interna: faltas no sistema ou operações de manobra',39)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Vazamento ou quantidade colocada insuficiente',48)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Defeito das gaxetas de vedação',49)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Rompimento dos amortecedores sustentação do relé',52)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Origem externa: descargas atomosféricas',56)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Origem interna: faltas no sistema ou operações de manobra',56)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Defeito das gaxetas de vedação',59)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Rompimento dos amortecedores sustentação do relé',62)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Origem externa: descargas atomosféricas',66)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Origem interna: faltas no sistema ou operações de manobra',66)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Exposição da michrochave a contaminantes',69)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Exposição da michrochave a contaminantes',71)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Umidade excessiva nos armários (corros)',75)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Defeito das gaxetas de vedação da porta',76)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Mau fechamento da porta',76)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Defeito do sistema desumidificador',76)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Torque inadequado',81)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Quebra de pino',81)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Falta de trav. Porcas',81)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Umidade excessiva ou carbonização do óleo isolante',99)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Falta ou abertura resistor. Polarização',103)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Umidade excessiva óleo',108)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Baixo isolamento hastes',108)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Aumento da temperatura do óleo isolante',116)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Vibração própria do transformador',117)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA (NOME,CHAVE_CAUSA) VALUES ('Erro operacional',118)",
				"INSERT INTO MAQUINAS.EFEITO (NOME,DESCRICAO,CHAVE_MODO_FALHA,INDICE_SEVERIDADE) VALUES ('Desligamento indevido do transformador','',8,1.0)"

		};

		return lista;
	}

	/**
	 * Cria o SCHEMA SAD4GM
	 * 
	 * @param con Conexão com o Banco de Dados.
	 * @throws SQLException Lança uma SQLException caso haja alguma falha na conexão
	 *                      com o Banco de Dados.
	 */
	private void criarSchema(Connection con) throws SQLException {
		PreparedStatement statement = con.prepareStatement("create SCHEMA sad4gm");
		PreparedStatement statement1 = con.prepareStatement("create SCHEMA maquinas");
		statement.execute();
		statement.close();
		statement1.execute();
		statement1.close();
	}

	/**
	 * Insere o Admin Default na Tabela de Usuário
	 * 
	 * @param con Conexão com o Banco de Dados.
	 * @throws UnsupportedEncodingException Lança uma UnsupportedEncodingException
	 *                                      caso haja falha na encriptação da Senha.
	 * 
	 * @throws Exception                    Lança uma Exception caso haja alguma
	 *                                      falha na inserção no Banco de Dados.
	 */
	private void inserirAdminDefault(Connection con) throws UnsupportedEncodingException, Exception {
		String senhaDefault = encriptarSenha("rootdesides");

		PreparedStatement statement = con.prepareStatement(
				"INSERT INTO sad4gm.usuario (admin,ativo,auditor,senha,id,nome) VALUES (1,1,'Default',?,'admin','Admin')");

		statement.setString(1, senhaDefault);
		statement.execute();
		statement.close();
	}

	/**
	 * Cria a Tabela de Usuários no Banco de Dados.
	 * 
	 * @param con Conexão com o Banco de Dados
	 * @throws SQLException Lança uma SQLException caso haja alguma falha na
	 *                      inserção no Banco de Dados.
	 */
	private void criarTabelaUsuarios(Connection con) throws SQLException {

		PreparedStatement statement = con
				.prepareStatement("CREATE TABLE sad4gm.usuario (\r\n" + "		nome LONG VARCHAR,\r\n"
						+ "		chave INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
						+ "		id VARCHAR(200) NOT NULL,\r\n" + "		senha VARCHAR(200),\r\n"
						+ "		auditor LONG VARCHAR,\r\n" + "		ativo INTEGER,\r\n"
						+ "		admin INTEGER DEFAULT 0,\r\n" + "		PRIMARY KEY (CHAVE))");

		statement.execute();
		statement.close();
	}

	/**
	 * Cria a Tabela de Máquinas no Banco de Dados.
	 * 
	 * @param con Conexão com o Banco de Dados
	 * @throws SQLException Lança uma SQLException caso haja alguma falha na
	 *                      inserção no Banco de Dados.
	 */
	private void criarTabelaMaquinas(Connection con) throws SQLException {

		PreparedStatement statement = con.prepareStatement("CREATE TABLE maquinas.maquina (\r\n"
				+ "					nome LONG VARCHAR,\r\n" + "					data_insercao DATE,\r\n"
				+ "					codigo INTEGER NOT NULL, \r\n" + "					descricao LONG VARCHAR, \r\n"
				+ "					chave_usuario INTEGER NOT NULL, \r\n"
				+ "					chave INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), \r\n"
				+ "				    PRIMARY KEY (chave), \r\n"
				+ "					CONSTRAINT maquina_chave_usuario_fkey \r\n"
				+ "					FOREIGN KEY (chave_usuario)  \r\n"
				+ "					REFERENCES sad4gm.usuario (chave) ON DELETE CASCADE )\r\n" + "					");

		statement.execute();
		statement.close();
	}

	private void criarTabelaSubsistema(Connection con) throws SQLException {

		PreparedStatement statement = con.prepareStatement("\r\n"
				+ "				CREATE TABLE maquinas.subsistema(\r\n" + "				nome LONG VARCHAR,\r\n"
				+ "				chave INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
				+ "				chave_maquina INTEGER NOT NULL,\r\n" + "				PRIMARY KEY (chave) ,\r\n"
				+ "				CONSTRAINT subsistema_chave_maquina_fkey FOREIGN KEY (chave_maquina) REFERENCES maquinas.maquina(chave) ON DELETE CASCADE \r\n"
				+ "				)");

		statement.execute();
		statement.close();
	}

	private void criarTabelaComponente(Connection con) throws SQLException {

		PreparedStatement statement = con.prepareStatement("CREATE TABLE maquinas.componente(\r\n"
				+ "nome LONG VARCHAR,\r\n"
				+ "chave INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
				+ "chave_subsistema INTEGER NOT NULL,\r\n" + "funcao LONG VARCHAR,\r\n" + "PRIMARY KEY (chave),"
				+ "CONSTRAINT componente_chave_subsistema_fkey FOREIGN KEY (chave_subsistema) REFERENCES maquinas.subsistema(chave) ON DELETE CASCADE\r\n"
				+ ")");

		statement.execute();
		statement.close();
	}

	private void criarTabelaFalha(Connection con) throws SQLException {

		PreparedStatement statement = con.prepareStatement("CREATE TABLE MAQUINAS.FALHA(\r\n"
				+ "				NOME LONG VARCHAR,\r\n" + "				DESCRICAO LONG VARCHAR,\r\n"
				+ "				CHAVE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
				+ "				CHAVE_COMPONENTE INTEGER NOT NULL, \r\n" + "				PRIMARY KEY (CHAVE),\r\n"
				+ "				CONSTRAINT falha_chave_componente_fkey FOREIGN KEY (CHAVE_COMPONENTE) REFERENCES maquinas.componente(CHAVE) ON DELETE CASCADE)");

		statement.execute();
		statement.close();
	}

	private void criarTabelaModoFalha(Connection con) throws SQLException {

		PreparedStatement statement = con.prepareStatement("\r\n" + "CREATE TABLE MAQUINAS.MODO_FALHA(\r\n"
				+ "NOME LONG VARCHAR, \r\n" + "DESCRICAO LONG VARCHAR,\r\n"
				+ "CHAVE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
				+ "CHAVE_FALHA INTEGER NOT NULL,\r\n" + "PRIMARY KEY(CHAVE),\r\n"
				+ "INDICE_OCORRENCIA DOUBLE PRECISION, \r\n" + "INDICE_DETECCAO DOUBLE PRECISION, \r\n"
				+ "NUMERO_OCORRENCIAS INTEGER, \r\n" 
				+ "CONSTRAINT modo_falha_chave_falha_fkey FOREIGN KEY (CHAVE_FALHA) REFERENCES MAQUINAS.FALHA(CHAVE) ON DELETE CASCADE\r\n"
				+ ")");

		statement.execute();
		statement.close();
	}

	private void criarTabelaCausasPotenciais(Connection con) throws SQLException {
		PreparedStatement statement = con.prepareStatement("CREATE TABLE MAQUINAS.CAUSAS_POTENCIAIS (\r\n"
				+ "						NOME LONG VARCHAR,\r\n"
				+ "						CHAVE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
				+ "						DESCRICAO LONG VARCHAR, \r\n"
				+ "						CHAVE_MODO_FALHA INTEGER NOT NULL,\r\n"
				+ "						PRIMARY KEY (chave),\r\n"
				+ "						CONSTRAINT causas_potenciais_chave_modo_falha_fkey FOREIGN KEY (CHAVE_MODO_FALHA)\r\n"
				+ "						REFERENCES MAQUINAS.MODO_FALHA(CHAVE) ON DELETE CASCADE\r\n"
				+ "						)");

		statement.execute();
		statement.close();
	}

	private void criarTabelaOrigemCausas(Connection con) throws SQLException {
		PreparedStatement statement = con.prepareStatement("CREATE TABLE MAQUINAS.ORIGEM_CAUSA (\r\n"
				+ "						NOME LONG VARCHAR,\r\n"
				+ "						CHAVE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
				+ "						CHAVE_CAUSA INTEGER NOT NULL,\r\n"
				+ "						PRIMARY KEY (chave),\r\n"
				+ "						CONSTRAINT causas_potenciais_chave_causa_fkey FOREIGN KEY (CHAVE_CAUSA)\r\n"
				+ "						REFERENCES MAQUINAS.CAUSAS_POTENCIAIS(CHAVE) ON DELETE CASCADE\r\n"
				+ "						)");

		statement.execute();
		statement.close();
	}

	private void criarTabelaAcoesRecomendadas(Connection con) throws SQLException {
		PreparedStatement statement = con.prepareStatement(
				"CREATE TABLE MAQUINAS.ACAO_RECOMENDADA(\r\n" + "NOME LONG VARCHAR,\r\n" + "DESCRICAO LONG VARCHAR,\r\n"
						+ "CHAVE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
						+ "CHAVE_CAUSA_POTENCIAL INTEGER NOT NULL,\r\n" + "PRIMARY KEY (CHAVE),\r\n"
						+ "CONSTRAINT ACAO_RECOMENDADA_CAUSA_POTENCIAL_FKEY FOREIGN KEY (CHAVE_CAUSA_POTENCIAL) \r\n"
						+ "REFERENCES MAQUINAS.CAUSAS_POTENCIAIS(CHAVE) ON DELETE CASCADE\r\n" + ")");

		statement.execute();
		statement.close();
	}

	private void criarTabelaEfeitos(Connection con) throws SQLException {
		PreparedStatement statement = con.prepareStatement(
				"CREATE TABLE MAQUINAS.EFEITO(\r\n" + "NOME LONG VARCHAR,\r\n" + "DESCRICAO LONG VARCHAR,\r\n"
						+ "CHAVE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
						+ "CHAVE_MODO_FALHA INTEGER NOT NULL,\r\n" + "INDICE_SEVERIDADE DOUBLE PRECISION, \r\n"
						+ "PRIMARY KEY (chave),\r\n"
						+ "CONSTRAINT efeitos_chave_modo_falha_fkey FOREIGN KEY (CHAVE_MODO_FALHA)\r\n"
						+ "REFERENCES MAQUINAS.MODO_FALHA(CHAVE) ON DELETE CASCADE\r\n" + ")");

		statement.execute();
		statement.close();
	}

	/**
	 * Criptografa uma Senha em SHA-2
	 * 
	 * @param senha Senha a ser encriptada
	 * @return Senha encriptada
	 * @throws UnsupportedEncodingException Lança a UnsupportedEncodingException
	 *                                      caso haja falha na encriptação
	 * @throws Exception                    Lança uma Exception caso haja problema
	 *                                      na instância da criptografia escolhida.
	 */
	public String encriptarSenha(String senha) throws UnsupportedEncodingException, Exception {
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String hashPassword = hexString.toString();

		return hashPassword;
	}

	/**
	 * Fecha a Conexão com o Banco de Dados.
	 */
	protected void fecharConexao() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}