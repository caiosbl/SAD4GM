package interfaceGrafica.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import sistema.Sistema;

public class GerarPlanilhaComponentes {
	
	private File file;
	
	 private  HSSFWorkbook workbook;
	 private  HSSFSheet sheetMaquina;
	 private Sistema sistema;
	 private int chaveMaquina;
	
	public GerarPlanilhaComponentes(String nomeMaquina, int chaveMaquina, File file) {
		this.file = file;
		workbook = new HSSFWorkbook();
		sheetMaquina = workbook.createSheet(nomeMaquina);
		this.chaveMaquina = chaveMaquina;
		sistema = new Sistema();
		try {
			gerarPlanilha();
			sheetMaquina.autoSizeColumn(0);
			sheetMaquina.autoSizeColumn(1);
			sheetMaquina.autoSizeColumn(2);
			sheetMaquina.autoSizeColumn(3);
			
	
			salvarArquivo();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha na Conexão com o Banco de Dados!");
			
		}
		
		
	}
	
	
	private CellStyle getBackgroundStyle() {
		  CellStyle backgroundStyle = workbook.createCellStyle();

		  backgroundStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex()); 
		  backgroundStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		  backgroundStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
		    
		    return backgroundStyle;
	}
	
	
	
	private void gerarPlanilha() throws SQLException {
		
		Map<String,Integer> mapaModosFalha = sistema.getMapaModosFalhaPorMaquina(chaveMaquina);
		
		Object[] listaMaquinas =  mapaModosFalha.keySet().toArray();
		
		Arrays.sort(listaMaquinas, new Comparator<Object>() {
			@Override
			public int compare(Object b1, Object b2) {

				try {
					int rpn1 = (int) (sistema.getIndiceOcorrenciaModoFalha(mapaModosFalha.get(b1))
							* sistema.getIndiceSeveridadePorFalha(mapaModosFalha.get(b1)));
					int rpn2 = (int) (sistema.getIndiceOcorrenciaModoFalha(mapaModosFalha.get(b2))
							* sistema.getIndiceSeveridadePorFalha(mapaModosFalha.get(b2)));
					return rpn2 - rpn1;
				}

				catch (Exception e) {
					return 0;
				}

			}
		});
		
		  int rowNum = 0;
		  
	
		  
		  Row rowHeader = sheetMaquina.createRow(rowNum++);
		  
		  Cell idHeader = rowHeader.createCell(0);
		  idHeader.setCellStyle(getBackgroundStyle());
		  idHeader.setCellValue("ID");
		  
		  Cell nomeHeader = rowHeader.createCell(1);
		  nomeHeader.setCellStyle(getBackgroundStyle());
		  nomeHeader.setCellValue("Modo de Falha");
		  Cell indiceOcorrenciaHeader = rowHeader.createCell(2);
		  indiceOcorrenciaHeader.setCellStyle(getBackgroundStyle());
		  indiceOcorrenciaHeader.setCellValue("Indíce de Ocorrência");
		  
		  Cell indiceSeveridadeHeader = rowHeader.createCell(3);
		  indiceSeveridadeHeader.setCellStyle(getBackgroundStyle());
		  indiceSeveridadeHeader.setCellValue("Indíce de Severidade");
	
		  Cell rpn = rowHeader.createCell(4);
		  rpn.setCellStyle(getBackgroundStyle());
		  rpn.setCellValue("RPN");
		  
		  
		
		for (Object maquina: listaMaquinas) {
			
			 int chaveModoFalha = mapaModosFalha.get(maquina);
			 int indiceOcorrencia = (int) sistema.getIndiceOcorrenciaModoFalha(chaveModoFalha);
			 int indiceSeveridade = (int) sistema.getIndiceSeveridadePorFalha(chaveModoFalha);
			 
			  Row row = sheetMaquina.createRow(rowNum++);
			  int cellNum = 0;
			  
			  Cell cellId = row.createCell(cellNum++);
			  cellId.setCellValue(rowNum);
			  
			  Cell cellNome = row.createCell(cellNum++);
			  cellNome.setCellValue(String.valueOf(maquina));
			  
			  Cell cellIndiceOcorrencia = row.createCell(cellNum++);
			  cellIndiceOcorrencia.setCellValue(indiceOcorrencia);
			  
			  Cell cellIndiceSeveridade = row.createCell(cellNum++);
			  cellIndiceSeveridade.setCellValue(indiceSeveridade);
			  
			  Cell cellRpn = row.createCell(cellNum++);
			  cellRpn.setCellValue(indiceOcorrencia * indiceSeveridade);
			  		  
			
		}
			
	}
	
	public void salvarArquivo() {
	      
		 try {
             FileOutputStream out = 
                     new FileOutputStream(this.file);
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
