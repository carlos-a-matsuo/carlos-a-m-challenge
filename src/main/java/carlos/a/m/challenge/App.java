/*
 * Carlos Atsuchi Matsuo
 * 
 * Challenge
 * 
 */
package carlos.a.m.challenge;


// TODO: Auto-generated Javadoc
/**
 * The Class App.
 */
public class App 
{
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main( String[] args )
    {
    	
    	Integer port = 80;
    	SearcherFacade facade = new SearcherFacade();
    	facade.buscarTitulos("Simpsons", SearchType.TITLE, port);
    }
    
}
