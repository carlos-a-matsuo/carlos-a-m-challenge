/*
 * Carlos Atsuchi Matsuo
 * 
 * Challenge
 * 
 */
package carlos.a.m.challenge;

// TODO: Auto-generated Javadoc
/**
 * The Enum SearchType.
 */
public enum SearchType {
	
	/** The all. */
	ALL("all"), 
 /** The title. */
 TITLE("tt"), 
 /** The tv episode. */
 TV_EPISODE("ep"), 
 /** The name. */
 NAME("nm"), 
 /** The company. */
 COMPANY("co"), 
 /** The keyword. */
 KEYWORD("kw"), 
 /** The character. */
 CHARACTER("ch"), 
 /** The quote. */
 QUOTE("ch");

	/** The value. */
	private final String value;

	/**
	 * Instantiates a new search type.
	 *
	 * @param value the value
	 */
	SearchType(String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}
}
