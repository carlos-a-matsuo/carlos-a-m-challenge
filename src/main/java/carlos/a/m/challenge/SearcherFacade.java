/*
 * Carlos Atsuchi Matsuo
 * 
 * Challenge
 * 
 */
package carlos.a.m.challenge;

import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class SearcherFacade.
 */
public class SearcherFacade {

	/**
	 * Buscar titulos.
	 *
	 * @param serie the serie
	 * @param tipoBusca the tipo busca
	 * @param port the port
	 * @return the boolean
	 */
	public Boolean buscarTitulos(String serie, SearchType tipoBusca, Integer port) {

		Searcher searcher = new Searcher();

		List<Map<String, String>> results = searcher.search(serie, tipoBusca, port);

		if (results == null || results.isEmpty()) {
			return Boolean.FALSE;
		}

		for (int i = 0; i < results.size(); i++) {
			System.out.println("Número #" + String.valueOf(i + 1) + " ----------------------------------------");
			System.out.println("ID....: " + results.get(i).get("id"));
			System.out.println("Nome.......: " + results.get(i).get("name"));
		}

		return Boolean.TRUE;
	}

}
