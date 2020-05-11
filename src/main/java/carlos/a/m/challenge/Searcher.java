/*
 * Carlos Atsuchi Matsuo
 * 
 * Challenge
 * 
 */
package carlos.a.m.challenge;

import java.io.*;
import java.net.URLEncoder;

import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class Searcher.
 */
public class Searcher {

	/** The id. */
	private String id;
	
	/** The url. */
	private String url;
	
	/** The found. */
	private boolean found;

	/** The rating. */
	private float rating = 0f;
	
	/** The year. */
	private short year = 0;

	/**
	 * Instantiates a new searcher.
	 */
	public Searcher() {
		initialize();
	}

	/**
	 * Initialize.
	 */
	private void initialize() {

		found = false;
	}

	/**
	 * Search.
	 *
	 * @param query the query
	 * @param searchType the search type
	 * @param port the port
	 * @return the list
	 */
	public List<Map<String, String>> search(String query, SearchType searchType, Integer port) {
		// Regex
		final String SEARCH_ID_NAME = "\"result_text\"> <a href=\"/title/tt([0-9]*)/(.*?)\" >(.*?)</a>";

		// Variables
		Pattern pattern;
		Matcher matcher;
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map;

		// URL encode the query
		String search = null;
		try {
			search = URLEncoder.encode(query, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// https://www.imdb.com/find?s=tt&q=simpsons
		search = "https://www.imdb.com/find?q=" + search + "&s=" + searchType.getValue();

		System.out.println(search);

		String html = fetchHtml(search, port);

		// if (!(html != null && html.contains("Bad Request"))) {

		pattern = Pattern.compile(SEARCH_ID_NAME);
		matcher = pattern.matcher(html);

		while (matcher.find()) {

			String m = matcher.group(3);
			if ( m != null) {
				map = new LinkedHashMap<>();
				map.put("id", matcher.group(1));
				map.put("name", matcher.group(3));
				list.add(map);
			}
		}

		// }

		return list;
	}

	/**
	 * Fetch html.
	 *
	 * @param urlString the url string
	 * @param port the port
	 * @return the string
	 */
	private String fetchHtml(String urlString, Integer port) {

		StringBuffer html = new StringBuffer();

		try {

			Conexao.UrlConnection(html, urlString);
			Conexao.SocketConnection(html, port);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return html.toString();
	}

	/**
	 * Checks for found.
	 *
	 * @return true, if successful
	 */
	public boolean hasFound() {
		return found;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public float getRating() {
		return rating;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public short getYear() {
		return year;
	}

}