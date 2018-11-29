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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
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
		sheetMaquina = workbook.createSheet("Componentes do" + nomeMaquina);
		this.chaveMaquina = chaveMaquina;
		sistema = new Sistema();
		try {
			gerarPlanilha();
			for(int i = 0; i <= 21; i++)
				sheetMaquina.autoSizeColumn(i);

			salvarArquivo();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha na Conexão com o Banco de Dados!");

		}

	}

	private CellStyle getBackgroundStyle() {
		CellStyle backgroundStyle = workbook.createCellStyle();

		backgroundStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		backgroundStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		backgroundStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());

		return backgroundStyle;
	}
	
	

	private void gerarPlanilha() throws SQLException {

		int rowNumSub = 0;

		Row rowHeader = sheetMaquina.createRow(rowNumSub++);

		// Headers

		Cell subsistemaIdHeader = rowHeader.createCell(0);
		subsistemaIdHeader.setCellStyle(getBackgroundStyle());
		subsistemaIdHeader.setCellValue("ID");

		Cell subsistemaHeader = rowHeader.createCell(1);
		subsistemaHeader.setCellStyle(getBackgroundStyle());
		subsistemaHeader.setCellValue("SUBSISTEMA");

		ArrayList<DataComponentes> data = getData();

		for (DataComponentes dataC : data) {

			Subsistema subsistema = dataC.getSubsistema();

			if (sheetMaquina.getLastRowNum() < rowNumSub)
				rowHeader = sheetMaquina.createRow(rowNumSub++);
			else
				rowHeader = sheetMaquina.getRow(rowNumSub++);

			Cell subsistemaId = rowHeader.createCell(0);

			subsistemaId.setCellValue(subsistema.getChave());

			Cell subsistemaCell = rowHeader.createCell(1);

			subsistemaCell.setCellValue(subsistema.getNome());

		}

		int rowNumComponentes = 0;
		rowHeader = sheetMaquina.getRow(rowNumComponentes++);

		Cell componenteIdSubHeader = rowHeader.createCell(3);
		componenteIdSubHeader.setCellValue("ID SUBSISTEMA");
		componenteIdSubHeader.setCellStyle(getBackgroundStyle());

		Cell componenteIdHeader = rowHeader.createCell(4);
		componenteIdHeader.setCellValue("ID");
		componenteIdHeader.setCellStyle(getBackgroundStyle());

		Cell componenteHeader = rowHeader.createCell(5);
		componenteHeader.setCellStyle(getBackgroundStyle());
		componenteHeader.setCellValue("COMPONENTE");

		for (DataComponentes dataC : data) {

			Subsistema subsistema = dataC.getSubsistema();

			for (Componente componente : dataC.getComponentes()) {
				if (sheetMaquina.getLastRowNum() < rowNumComponentes)
					rowHeader = sheetMaquina.createRow(rowNumComponentes++);
				else
					rowHeader = sheetMaquina.getRow(rowNumComponentes++);

				Cell componenteIdSubCell = rowHeader.createCell(3);
				componenteIdSubCell.setCellValue(subsistema.getChave());

				Cell componenteIdCell = rowHeader.createCell(4);
				componenteIdCell.setCellValue(componente.getChave());

				Cell componenteCell = rowHeader.createCell(5);
				componenteCell.setCellValue(componente.getNome());

			}

		}

		int rowNumFail = 0;

		rowHeader = sheetMaquina.getRow(rowNumFail++);

		Cell falhaIdCompHeader = rowHeader.createCell(7);
		falhaIdCompHeader.setCellValue("ID COMPONENTE");
		falhaIdCompHeader.setCellStyle(getBackgroundStyle());

		Cell falhaIdHeader = rowHeader.createCell(8);
		falhaIdHeader.setCellValue("ID");
		falhaIdHeader.setCellStyle(getBackgroundStyle());

		Cell falhaHeader = rowHeader.createCell(9);
		falhaHeader.setCellStyle(getBackgroundStyle());
		falhaHeader.setCellValue("FALHA");

		for (DataComponentes dataC : data) {

			for (Componente componente : dataC.getComponentes()) {
				for (Falha falha : componente.getFalhas()) {
					if (sheetMaquina.getLastRowNum() < rowNumFail)
						rowHeader = sheetMaquina.createRow(rowNumFail++);
					else
						rowHeader = sheetMaquina.getRow(rowNumFail++);

					Cell falhaIdCompCell = rowHeader.createCell(7);
					falhaIdCompCell.setCellValue(componente.getChave());

					Cell falhaIdCell = rowHeader.createCell(8);
					falhaIdCell.setCellValue(falha.getChave());

					Cell falhaCell = rowHeader.createCell(9);
					falhaCell.setCellValue(falha.getNome());
				}

			}

		}

		int rowNumModoFalha = 0;

		rowHeader = sheetMaquina.getRow(rowNumModoFalha++);

		Cell modoFalhaIdFalhaHeader = rowHeader.createCell(11);
		modoFalhaIdFalhaHeader.setCellValue("ID FALHA");
		modoFalhaIdFalhaHeader.setCellStyle(getBackgroundStyle());

		Cell modoFalhaIdHeader = rowHeader.createCell(12);
		modoFalhaIdHeader.setCellValue("ID");
		modoFalhaIdHeader.setCellStyle(getBackgroundStyle());

		Cell modoFalhaHeader = rowHeader.createCell(13);
		modoFalhaHeader.setCellStyle(getBackgroundStyle());
		modoFalhaHeader.setCellValue("MODO DE FALHA");

		for (DataComponentes dataC : data) {

			for (Componente componente : dataC.getComponentes()) {
				for (Falha falha : componente.getFalhas()) {

					for (ModoFalha modoFalha : falha.getModoFalha()) {

						if (sheetMaquina.getLastRowNum() < rowNumModoFalha)
							rowHeader = sheetMaquina.createRow(rowNumModoFalha++);

						else
							rowHeader = sheetMaquina.getRow(rowNumModoFalha++);

						Cell modoFalhaIdFalhaCell = rowHeader.createCell(11);
						modoFalhaIdFalhaCell.setCellValue(falha.getChave());

						Cell modoFalhaIdCell = rowHeader.createCell(12);
						modoFalhaIdCell.setCellValue(modoFalha.getChave());

						Cell modoFalhaCell = rowHeader.createCell(13);
						modoFalhaCell.setCellValue(modoFalha.getNome());
					}

				}

			}

		}

		int rowNumEfeito = 0;

		rowHeader = sheetMaquina.getRow(rowNumEfeito++);

		Cell efeitoIdModoFalhaHeader = rowHeader.createCell(15);
		efeitoIdModoFalhaHeader.setCellValue("ID MODO DE FALHA");
		efeitoIdModoFalhaHeader.setCellStyle(getBackgroundStyle());

		Cell efeitoIdHeader = rowHeader.createCell(16);
		efeitoIdHeader.setCellValue("ID");
		efeitoIdHeader.setCellStyle(getBackgroundStyle());

		Cell efeitoHeader = rowHeader.createCell(17);
		efeitoHeader.setCellStyle(getBackgroundStyle());
		efeitoHeader.setCellValue("EFEITO");

		for (DataComponentes dataC : data) {

			for (Componente componente : dataC.getComponentes()) {
				for (Falha falha : componente.getFalhas()) {

					for (ModoFalha modoFalha : falha.getModoFalha()) {

						for (Efeito efeito : modoFalha.getEfeitos()) {

							if (sheetMaquina.getLastRowNum() < rowNumEfeito)
								rowHeader = sheetMaquina.createRow(rowNumEfeito++);

							else
								rowHeader = sheetMaquina.getRow(rowNumEfeito++);

							Cell efeitoIdModoFalhaCell = rowHeader.createCell(15);
							efeitoIdModoFalhaCell.setCellValue(modoFalha.getChave());

							Cell efeitoIdCell = rowHeader.createCell(16);
							efeitoIdCell.setCellValue(efeito.getChave());

							Cell efeitoCell = rowHeader.createCell(17);
							efeitoCell.setCellValue(efeito.getNome());
						}
					}

				}

			}

		}

		int rowNumCausaPotencial = 0;

		rowHeader = sheetMaquina.getRow(rowNumCausaPotencial++);

		Cell causaIdModoFalhaHeader = rowHeader.createCell(15);
		causaIdModoFalhaHeader.setCellValue("ID MODO DE FALHA");
		causaIdModoFalhaHeader.setCellStyle(getBackgroundStyle());

		Cell causaIdHeader = rowHeader.createCell(16);
		causaIdHeader.setCellValue("ID");
		causaIdHeader.setCellStyle(getBackgroundStyle());

		Cell causaHeader = rowHeader.createCell(17);
		causaHeader.setCellStyle(getBackgroundStyle());
		causaHeader.setCellValue("CAUSA POTENCIAL");

		for (DataComponentes dataC : data) {

			for (Componente componente : dataC.getComponentes()) {
				for (Falha falha : componente.getFalhas()) {

					for (ModoFalha modoFalha : falha.getModoFalha()) {

						for (CausaPotencial causaPotencial : modoFalha.getCausasPotencias()) {

							if (sheetMaquina.getLastRowNum() < rowNumCausaPotencial)
								rowHeader = sheetMaquina.createRow(rowNumCausaPotencial++);

							else
								rowHeader = sheetMaquina.getRow(rowNumCausaPotencial++);

							Cell causaIdModoFalhaCell = rowHeader.createCell(15);
							causaIdModoFalhaCell.setCellValue(modoFalha.getChave());

							Cell causaIdCell = rowHeader.createCell(16);
							causaIdCell.setCellValue(causaPotencial.getChave());

							Cell causaCell = rowHeader.createCell(17);
							causaCell.setCellValue(causaPotencial.getNome());
						}
					}

				}

			}

		}

		int rowNumOrigem = 0;

		rowHeader = sheetMaquina.getRow(rowNumOrigem++);

		Cell origemIdCausaHeader = rowHeader.createCell(19);
		origemIdCausaHeader.setCellValue("ID CAUSA POTENCIAL");
		origemIdCausaHeader.setCellStyle(getBackgroundStyle());

		Cell origemIdHeader = rowHeader.createCell(20);
		origemIdHeader.setCellValue("ID");
		origemIdHeader.setCellStyle(getBackgroundStyle());

		Cell origemHeader = rowHeader.createCell(21);
		origemHeader.setCellStyle(getBackgroundStyle());
		origemHeader.setCellValue("ORIGEM DE CAUSA POTENCIAL");

		for (DataComponentes dataC : data) {

			for (Componente componente : dataC.getComponentes()) {
				for (Falha falha : componente.getFalhas()) {
					for (ModoFalha modoFalha : falha.getModoFalha()) {
						for (CausaPotencial causaPotencial : modoFalha.getCausasPotencias()) {
							for (Origem origem : causaPotencial.getOrigens()) {
								if (sheetMaquina.getLastRowNum() < rowNumOrigem)
									rowHeader = sheetMaquina.createRow(rowNumOrigem++);
								else
									rowHeader = sheetMaquina.getRow(rowNumOrigem++);

								Cell origemIdCausaCell = rowHeader.createCell(19);
								origemIdCausaCell.setCellValue(causaPotencial.getChave());
								Cell origemIdCell = rowHeader.createCell(20);
								origemIdCell.setCellValue(origem.getChave());
								Cell origemCell = rowHeader.createCell(21);
								origemCell.setCellValue(origem.getNome());
							}
						}
					}

				}

			}

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
