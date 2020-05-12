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

		ThreadTrigger trigger = new ThreadTrigger();
		trigger.startSearcher(serie, tipoBusca, port);

		return Boolean.TRUE;
	}

}
