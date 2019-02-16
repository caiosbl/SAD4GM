package interfaceGrafica.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import entidades.CausaPotencial;
import entidades.Componente;
import entidades.Efeito;
import entidades.Falha;
import entidades.ModoFalha;
import entidades.Origem;
import entidades.Subsistema;
import sistema.Sistema;

public class GerarPlanilhaComponentes {

	private File file;

	private HSSFWorkbook workbook;
	private HSSFSheet sheetMaquina;
	private Sistema sistema;
	private int chaveMaquina;

	public GerarPlanilhaComponentes(String nomeMaquina, int chaveMaquina, File file) {
		this.file = file;
		workbook = new HSSFWorkbook();
		sheetMaquina = workbook.createSheet("Componentes do " + nomeMaquina);
		this.chaveMaquina = chaveMaquina;
		sistema = new Sistema();
		try {
			gerarPlanilha();
			for (int i = 0; i <= 100; i++)
				sheetMaquina.autoSizeColumn(i);
		
			salvarArquivo();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha na Conexão com o Banco de Dados!");

		}

	}

	private CellStyle getBackgroundHeaderStyle() {
		CellStyle backgroundStyle = workbook.createCellStyle();
		Font headFont = workbook.createFont();

		backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		backgroundStyle.setBorderLeft(BorderStyle.THIN);
		backgroundStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		backgroundStyle.setBorderRight(BorderStyle.THIN);
		backgroundStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		backgroundStyle.setBorderTop(BorderStyle.THIN);
		backgroundStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		backgroundStyle.setBorderBottom(BorderStyle.THIN);
		backgroundStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());

		headFont.setBold(true);
		headFont.setColor(IndexedColors.BLACK.getIndex());
		backgroundStyle.setFont(headFont);
		headFont.setColor(Font.COLOR_NORMAL);

		backgroundStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		return backgroundStyle;
	}

	private CellStyle getBackgroundBodyStyle() {
		CellStyle backgroundStyle = workbook.createCellStyle();


		return backgroundStyle;
	}

	private void gerarPlanilha() throws SQLException {

		int rowNum = 0;

		Row rowHeader = sheetMaquina.createRow(rowNum++);

		// Headers
		Cell idSubsistemaHeader = rowHeader.createCell(0);
		idSubsistemaHeader.setCellStyle(getBackgroundHeaderStyle());
		idSubsistemaHeader.setCellValue("ID1");

		Cell subsistemaHeader = rowHeader.createCell(1);
		subsistemaHeader.setCellStyle(getBackgroundHeaderStyle());
		subsistemaHeader.setCellValue("Subsistema");

		Cell idComponenteHeader = rowHeader.createCell(2);
		idComponenteHeader.setCellStyle(getBackgroundHeaderStyle());
		idComponenteHeader.setCellValue("ID2");

		Cell componenteHeader = rowHeader.createCell(3);
		componenteHeader.setCellStyle(getBackgroundHeaderStyle());
		componenteHeader.setCellValue("Componente");

		Cell idFalhaHeader = rowHeader.createCell(4);
		idFalhaHeader.setCellStyle(getBackgroundHeaderStyle());
		idFalhaHeader.setCellValue("ID3");

		Cell falhaHeader = rowHeader.createCell(5);
		falhaHeader.setCellStyle(getBackgroundHeaderStyle());
		falhaHeader.setCellValue("Falha");

		Cell idModoFalhaHeader = rowHeader.createCell(6);
		idModoFalhaHeader.setCellStyle(getBackgroundHeaderStyle());
		idModoFalhaHeader.setCellValue("ID4");

		Cell modoFalhaHeader = rowHeader.createCell(7);
		modoFalhaHeader.setCellStyle(getBackgroundHeaderStyle());
		modoFalhaHeader.setCellValue("Modo de Falha");
		
		Cell indiceOcorrenciaHeader = rowHeader.createCell(8);
		indiceOcorrenciaHeader.setCellStyle(getBackgroundHeaderStyle());
		indiceOcorrenciaHeader.setCellValue("Indíce de Ocorrência");
		
		Cell numeroOcorrenciasHeader = rowHeader.createCell(9);
		numeroOcorrenciasHeader.setCellStyle(getBackgroundHeaderStyle());
		numeroOcorrenciasHeader.setCellValue("Número de Ocorrências");
		
		Cell indiceSeveridadeHeader = rowHeader.createCell(10);
		indiceSeveridadeHeader.setCellStyle(getBackgroundHeaderStyle());
		indiceSeveridadeHeader.setCellValue("Indíce de Severidade");
		

		Cell rpn = rowHeader.createCell(11);
		rpn.setCellStyle(getBackgroundHeaderStyle());
		rpn.setCellValue("RPN");

		Cell idCausaPotencialHeader = rowHeader.createCell(12);
		idCausaPotencialHeader.setCellStyle(getBackgroundHeaderStyle());
		idCausaPotencialHeader.setCellValue("ID5");

		Cell causaPotencialHeader = rowHeader.createCell(13);
		causaPotencialHeader.setCellStyle(getBackgroundHeaderStyle());
		causaPotencialHeader.setCellValue("Causa Potencial");

		Cell idOrigemCausaHeader = rowHeader.createCell(14);
		idOrigemCausaHeader.setCellStyle(getBackgroundHeaderStyle());
		idOrigemCausaHeader.setCellValue("ID6");

		Cell origemCausaHeader = rowHeader.createCell(15);
		origemCausaHeader.setCellStyle(getBackgroundHeaderStyle());
		origemCausaHeader.setCellValue("Origem de Causa");

		Cell idCausaHeader = rowHeader.createCell(16);
		idCausaHeader.setCellStyle(getBackgroundHeaderStyle());
		idCausaHeader.setCellValue("ID7");

		Cell efeitoHeader = rowHeader.createCell(17);
		efeitoHeader.setCellStyle(getBackgroundHeaderStyle());
		efeitoHeader.setCellValue("Efeito de Modo de Falha");

		ArrayList<DataComponentes> data = getData();

		for (DataComponentes dataC : data) {

			int rowNumComponentes = rowNum;

			rowHeader = sheetMaquina.createRow(rowNum++);
			Subsistema subsistema = dataC.getSubsistema();
			ArrayList<Componente> componentes = dataC.getComponentes();

			Cell idSubsistema = rowHeader.createCell(0);
			idSubsistema.setCellStyle(getBackgroundBodyStyle());
			idSubsistema.setCellValue(subsistema.getChave());

			Cell subsistemaCell = rowHeader.createCell(1);
			subsistemaCell.setCellStyle(getBackgroundBodyStyle());
			subsistemaCell.setCellValue(subsistema.getNome());

			for (Componente comp : componentes) {
				if (sheetMaquina.getLastRowNum() < rowNumComponentes)
					rowHeader = sheetMaquina.createRow(rowNumComponentes++);
				else
					rowHeader = sheetMaquina.getRow(rowNumComponentes++);

				Cell idComponente = rowHeader.createCell(2);
				idComponente.setCellStyle(getBackgroundBodyStyle());
				idComponente.setCellValue(comp.getChave());

				Cell componenteCell = rowHeader.createCell(3);
				componenteCell.setCellStyle(getBackgroundBodyStyle());
				componenteCell.setCellValue(comp.getNome());

				int rowNumFalha = rowNumComponentes - 1;

				for (Falha falha : comp.getFalhas()) {

					if (sheetMaquina.getLastRowNum() < rowNumFalha) {
						rowHeader = sheetMaquina.createRow(rowNumFalha++);
						rowNumComponentes++;

					} else {
						rowHeader = sheetMaquina.getRow(rowNumFalha++);

					}

					Cell idFalha = rowHeader.createCell(4);
					idFalha.setCellStyle(getBackgroundBodyStyle());
					idFalha.setCellValue(falha.getChave());

					Cell falhaCell = rowHeader.createCell(5);
					falhaCell.setCellStyle(getBackgroundBodyStyle());
					falhaCell.setCellValue(falha.getNome());

					int rowNumModoFalha = rowNumFalha - 1;

					for (ModoFalha mFalha : falha.getModoFalha()) {

						if (sheetMaquina.getLastRowNum() < rowNumModoFalha) {
							rowHeader = sheetMaquina.createRow(rowNumModoFalha++);
							rowNumFalha++;
							rowNumComponentes++;

						} else {
							rowHeader = sheetMaquina.getRow(rowNumModoFalha++);

						}
						
						 int indiceOcorrencia = (int) sistema.getIndiceOcorrenciaModoFalha(mFalha.getChave());
						 int indiceSeveridade = (int) sistema.getIndiceSeveridadePorFalha(mFalha.getChave());
						 int numeroOcorrencias = sistema.getNumeroOcorrencias(mFalha.getChave());
						 int rpnValue = indiceOcorrencia * indiceSeveridade;

						Cell idModoFalha = rowHeader.createCell(6);
						idModoFalha.setCellStyle(getBackgroundBodyStyle());
						idModoFalha.setCellValue(mFalha.getChave());

						Cell modoFalhaCell = rowHeader.createCell(7);
						modoFalhaCell.setCellStyle(getBackgroundBodyStyle());
						modoFalhaCell.setCellValue(mFalha.getNome());
						
						Cell indiceOcorrenciaCell = rowHeader.createCell(8);
						indiceOcorrenciaCell.setCellStyle(getBackgroundBodyStyle());
						indiceOcorrenciaCell.setCellValue(indiceOcorrencia);
						
						Cell numeroOcorrenciasCell = rowHeader.createCell(9);
						numeroOcorrenciasCell.setCellStyle(getBackgroundBodyStyle());
						numeroOcorrenciasCell.setCellValue(numeroOcorrencias);
						
						Cell indiceSeveridadeCell = rowHeader.createCell(10);
						indiceSeveridadeCell.setCellStyle(getBackgroundBodyStyle());
						indiceSeveridadeCell.setCellValue(indiceSeveridade);
						
						Cell rpnCell = rowHeader.createCell(11);
						rpnCell.setCellStyle(getBackgroundBodyStyle());
						rpnCell.setCellValue(rpnValue);

						int rowNumEfeito = rowNumModoFalha - 1;
						int rowNumCausa = rowNumModoFalha - 1;

						for (CausaPotencial causa : mFalha.getCausasPotencias()) {

							if (sheetMaquina.getLastRowNum() < rowNumCausa) {
								rowHeader = sheetMaquina.createRow(rowNumCausa++);
								rowNumModoFalha++;
								rowNumFalha++;
								rowNumComponentes++;

							} else {
								rowHeader = sheetMaquina.getRow(rowNumCausa++);

							}

							Cell idCausa = rowHeader.createCell(12);
							idCausa.setCellStyle(getBackgroundBodyStyle());
							idCausa.setCellValue(causa.getChave());

							Cell causaCell = rowHeader.createCell(13);
							causaCell.setCellStyle(getBackgroundBodyStyle());
							causaCell.setCellValue(causa.getNome());

							int rowOrigens = rowNumCausa - 1;
							for (Origem origem : causa.getOrigens()) {
								if (sheetMaquina.getLastRowNum() < rowOrigens) {
									rowHeader = sheetMaquina.createRow(rowOrigens++);
									rowNumModoFalha++;
									rowNumFalha++;
									rowNumComponentes++;
									rowNumCausa++;

								} else {
									rowHeader = sheetMaquina.getRow(rowOrigens++);

								}

								Cell idOrigem = rowHeader.createCell(14);
								idOrigem.setCellStyle(getBackgroundBodyStyle());
								idOrigem.setCellValue(origem.getChave());

								Cell origemCell = rowHeader.createCell(15);
								origemCell.setCellStyle(getBackgroundBodyStyle());
								origemCell.setCellValue(origem.getNome());
							}

						}

						for (Efeito efeito : mFalha.getEfeitos()) {

							if (sheetMaquina.getLastRowNum() < rowNumEfeito) {
								rowHeader = sheetMaquina.createRow(rowNumEfeito++);
								rowNumModoFalha++;
								rowNumFalha++;
								rowNumComponentes++;

							} else {
								rowHeader = sheetMaquina.getRow(rowNumEfeito++);

							}

							Cell idEfeito = rowHeader.createCell(16);
							idEfeito.setCellStyle(getBackgroundBodyStyle());
							idEfeito.setCellValue(efeito.getChave());

							Cell efeitoCell = rowHeader.createCell(17);
							efeitoCell.setCellStyle(getBackgroundBodyStyle());
							efeitoCell.setCellValue(efeito.getNome());

						}

					}

				}

			}

			rowNum = rowNumComponentes;
		}

	}

	private ArrayList<DataComponentes> getData() throws SQLException {

		ArrayList<DataComponentes> data = new ArrayList<DataComponentes>();

		// Montando Estrtura

		Map<String, Integer> mapaSubsistemas = sistema.getMapaSubsistemas(chaveMaquina);
		Object[] listaSubsistemas = mapaSubsistemas.keySet().toArray();

		for (Object subsistema : listaSubsistemas) {

			int chaveSubsistema = mapaSubsistemas.get(subsistema);

			Subsistema subsistema_ = new Subsistema(String.valueOf(subsistema), chaveSubsistema);

			ArrayList<Componente> componentes = new ArrayList<Componente>();

			Map<String, Integer> mapaComponentes = sistema.getMapaComponentes(chaveSubsistema);
			Object[] listaComponentes = mapaComponentes.keySet().toArray();

			for (Object componente : listaComponentes) {
				int chaveComponente = mapaComponentes.get(componente);

				ArrayList<Falha> falhasList = new ArrayList<Falha>();
				Map<String, Integer> mapaFalhas = sistema.getMapaFalhas(chaveComponente);
				Object[] listaFalhas = mapaFalhas.keySet().toArray();

				for (Object falha : listaFalhas) {
					int chaveFalha = mapaFalhas.get(falha);

					ArrayList<ModoFalha> modosFalhaList = new ArrayList<ModoFalha>();
					Map<String, Integer> mapaModosFalha = sistema.getMapaModosFalha(chaveFalha);
					Object[] listaModosFalhas = mapaModosFalha.keySet().toArray();

					for (Object modoFalha : listaModosFalhas) {
						int chaveModoFalha = mapaModosFalha.get(modoFalha);

						ArrayList<CausaPotencial> causasPotenciaisList = new ArrayList<CausaPotencial>();
						Map<String, Integer> mapaCausasPotenciais = sistema.getMapaCausasPotenciais(chaveModoFalha);
						Object[] listaCausasPotenciais = mapaCausasPotenciais.keySet().toArray();

						ArrayList<Efeito> EfeitosList = new ArrayList<Efeito>();
						Map<String, Integer> mapaEfeitos = sistema.getMapaEfeitos(chaveModoFalha);
						Object[] listaEfeitos = mapaEfeitos.keySet().toArray();

						for (Object causaPotencial : listaCausasPotenciais) {
							int chaveCausaPotencial = mapaCausasPotenciais.get(causaPotencial);

							ArrayList<Origem> OrigensList = new ArrayList<Origem>();
							Map<String, Integer> mapaOrigens = sistema.getMapaOrigem(chaveCausaPotencial);
							Object[] listaOrigens = mapaOrigens.keySet().toArray();

							for (Object origem : listaOrigens) {
								int chaveOrigem = mapaOrigens.get(origem);
								OrigensList.add(new Origem(String.valueOf(origem), chaveOrigem, chaveCausaPotencial));
							}

							causasPotenciaisList.add(new CausaPotencial(String.valueOf(causaPotencial),
									chaveCausaPotencial, OrigensList));

						}

						for (Object efeito : listaEfeitos) {
							int chaveEfeito = mapaEfeitos.get(efeito);
							EfeitosList.add(new Efeito(String.valueOf(efeito), null, chaveEfeito));
						}

						modosFalhaList.add(new ModoFalha(String.valueOf(modoFalha), null, chaveModoFalha,
								causasPotenciaisList, EfeitosList));
					}

					falhasList.add(new Falha(String.valueOf(falha), chaveFalha, modosFalhaList));

				}
				componentes.add(new Componente(String.valueOf(componente), chaveComponente, falhasList));
			}

			data.add(new DataComponentes(subsistema_, componentes));

		}

		return data;

	}

	public void salvarArquivo() {

		try {
			FileOutputStream out = new FileOutputStream(this.file);
			workbook.write(out);
			out.close();
			JOptionPane.showMessageDialog(null, "Arquivo Salvo com Sucesso!");

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Falha ao Salvar, arquivo aberto em outro processo !");
		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "Falha ao Salvar, arquivo aberto em outro processo !");
		}
	}

}
