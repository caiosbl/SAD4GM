package interfaceGrafica.utils;

import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;

import entidades.AcaoRecomendada;
import entidades.CausaPotencial;
import entidades.Componente;
import entidades.Efeito;
import entidades.Falha;
import entidades.Maquina;
import entidades.ModoFalha;
import entidades.Subsistema;
import sistema.Sistema;

public class Tree {

	public static DefaultMutableTreeNode getTree() {
		return iniciaNodeMaquinas(new Sistema());
	}

	private static DefaultMutableTreeNode iniciaNodeMaquinas(Sistema sistema) {
		DefaultMutableTreeNode maquinaNode = new DefaultMutableTreeNode("Máquinas");

		for (Maquina maquina : getMapaMaquinas(sistema).values()) {
			DefaultMutableTreeNode mNode = new DefaultMutableTreeNode(maquina);
			maquinaNode.add(mNode);
			iniciaRamoSubsistemas(mNode, maquina, sistema);
		}

		return maquinaNode;

	}

	private static void iniciaRamoSubsistemas(DefaultMutableTreeNode maquinaNode, Maquina maquina, Sistema sistema) {

		DefaultMutableTreeNode subsistemasNode = new DefaultMutableTreeNode("Subsistemas");
		maquinaNode.add(subsistemasNode);

		if (!getMapaSubsistemas(maquina.getChave(), sistema).isEmpty()) {

			for (Subsistema subsistema : getMapaSubsistemas(maquina.getChave(), sistema).values()) {
				DefaultMutableTreeNode subsNode = new DefaultMutableTreeNode(subsistema);
				subsistemasNode.add(subsNode);
				iniciaRamoComponentes(subsNode, subsistema, sistema);
			}
		}

	}

	private static void iniciaRamoComponentes(DefaultMutableTreeNode subsistemaNode, Subsistema subsistema,
			Sistema sistema) {
		DefaultMutableTreeNode componenteNode = new DefaultMutableTreeNode("Componentes");
		subsistemaNode.add(componenteNode);

		if (!getMapaComponentes(subsistema.getChave(), sistema).isEmpty()) {

			for (Componente componente : getMapaComponentes(subsistema.getChave(), sistema).values()) {
				DefaultMutableTreeNode compNode = new DefaultMutableTreeNode(componente);
				componenteNode.add(compNode);
				iniciaRamoFalha(compNode, componente, sistema);
			}
		}

	}

	private static void iniciaRamoFalha(DefaultMutableTreeNode componenteNode, Componente componente, Sistema sistema) {
		DefaultMutableTreeNode falhaNode = new DefaultMutableTreeNode("Falhas");
		componenteNode.add(falhaNode);
		if (!getFalhasMap(componente.getChave(), sistema).isEmpty()) {

			for (Falha falha : getFalhasMap(componente.getChave(), sistema).values()) {
				DefaultMutableTreeNode failNode = new DefaultMutableTreeNode(falha);
				falhaNode.add(failNode);
				iniciaRamoModoFalha(failNode, falha, sistema);
			}
		}

	}

	private static void iniciaRamoModoFalha(DefaultMutableTreeNode failNode, Falha falha, Sistema sistema) {
		DefaultMutableTreeNode modoFalhaNode = new DefaultMutableTreeNode("Modos de Falha");
		failNode.add(modoFalhaNode);
		if (!getModosFalhaMap(falha.getChave(), sistema).isEmpty()) {

			for (ModoFalha modoFalha : getModosFalhaMap(falha.getChave(), sistema).values()) {
				DefaultMutableTreeNode mFailNode = new DefaultMutableTreeNode(modoFalha);
				modoFalhaNode.add(mFailNode);
				iniciaRamoCausaPotencial(mFailNode, modoFalha, sistema);
				iniciaRamoEfeitos(mFailNode, modoFalha, sistema);
			}
		}

	}

	private static void iniciaRamoEfeitos(DefaultMutableTreeNode modoFalhaNode, ModoFalha modoFalha, Sistema sistema) {
		DefaultMutableTreeNode efeitoNode = new DefaultMutableTreeNode("Efeitos");
		modoFalhaNode.add(efeitoNode);

		if (!getEfeitosMap(modoFalha.getChave(), sistema).isEmpty()) {

			for (Efeito efeito : getEfeitosMap(modoFalha.getChave(), sistema).values()) {
				DefaultMutableTreeNode efecctNode = new DefaultMutableTreeNode(efeito);
				efeitoNode.add(efecctNode);
			}
		}

	}

	private static void iniciaRamoCausaPotencial(DefaultMutableTreeNode modoFalhaNode, ModoFalha modoFalha,
			Sistema sistema) {
		DefaultMutableTreeNode causaPotencialNode = new DefaultMutableTreeNode("Causas Potenciais");
		modoFalhaNode.add(causaPotencialNode);
		if (!getCausasPotenciaisMap(modoFalha.getChave(), sistema).isEmpty()) {

			for (CausaPotencial causaPotencial : getCausasPotenciaisMap(modoFalha.getChave(), sistema).values()) {
				DefaultMutableTreeNode cPotencialNode = new DefaultMutableTreeNode(causaPotencial);
				causaPotencialNode.add(cPotencialNode);
				iniciaRamoAcaoRecomendada(cPotencialNode, causaPotencial, sistema);
			}
		}

	}

	private static void iniciaRamoAcaoRecomendada(DefaultMutableTreeNode causaPotencialNode,
			CausaPotencial causaPotencial, Sistema sistema) {
		DefaultMutableTreeNode acoesRecomendadasNode = new DefaultMutableTreeNode("Ações Recomendadas");
		causaPotencialNode.add(acoesRecomendadasNode);
		if (!getAcoesRecomendadasMap(causaPotencial.getChave(), sistema).isEmpty()) {

			for (AcaoRecomendada acaoRecomendada : getAcoesRecomendadasMap(causaPotencial.getChave(), sistema)
					.values()) {
				DefaultMutableTreeNode cPotencialNode = new DefaultMutableTreeNode(acaoRecomendada);
				acoesRecomendadasNode.add(cPotencialNode);
			}
		}

	}

	private static Map<Integer, CausaPotencial> getCausasPotenciaisMap(int chaveModoFalha, Sistema sistema) {
		return sistema.getCausasPotenciaisMap(chaveModoFalha);

	}

	private static Map<Integer, AcaoRecomendada> getAcoesRecomendadasMap(int chaveCausaPotencial, Sistema sistema) {
		return sistema.getAcoesRecomendadasMap(chaveCausaPotencial);

	}

	private static Map<Integer, Efeito> getEfeitosMap(int chaveModoFalha, Sistema sistema) {
		return sistema.getEfeitosMap(chaveModoFalha);

	}

	private static Map<Integer, Maquina> getMapaMaquinas(Sistema sistema) {
		return sistema.getMaquinaMapa();
	}

	private static Map<Integer, Subsistema> getMapaSubsistemas(int chaveMaquina, Sistema sistema) {
		return sistema.getSubsistemasMap(chaveMaquina);
	}

	private static Map<Integer, Componente> getMapaComponentes(int chaveSubsistema, Sistema sistema) {
		return sistema.getComponentesMap(chaveSubsistema);
	}

	private static Map<Integer, Falha> getFalhasMap(int chaveComponente, Sistema sistema) {
		return sistema.getFalhasMap(chaveComponente);
	}

	private static Map<Integer, ModoFalha> getModosFalhaMap(int chaveFalha, Sistema sistema) {
		return sistema.getModosFalhaMap(chaveFalha);
	}

}
