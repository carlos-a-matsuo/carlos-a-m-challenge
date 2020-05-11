/*
 * Carlos Atsuchi Matsuo
 * 
 * Challenge
 * 
 */

package carlos.teste2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import carlos.a.m.challenge.SearchType;
import carlos.a.m.challenge.SearcherFacade;

// TODO: Auto-generated Javadoc
/**
 * The Class BuscadorTitulosTest.
 */
public class BuscadorTitulosTest {

	/**
	 * Buscar titulos true.
	 */
	@Test
	public void buscarTitulosTrue() {
		
		Integer port = 80;

		SearcherFacade facade = new SearcherFacade();

		Boolean val = facade.buscarTitulos("Simpsons", SearchType.TITLE, port);
		
		assertTrue(val);

	}
	
	/**
	 * Buscar titulos false.
	 */
	@Test
	public void buscarTitulosFalse() {
		
		Integer port = 80;

		SearcherFacade facade = new SearcherFacade();

		Boolean val = facade.buscarTitulos("%", SearchType.TITLE, port);
		
		assertFalse(val);

	}

}