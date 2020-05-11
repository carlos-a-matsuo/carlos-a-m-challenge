/*
 * Carlos Atsuchi Matsuo
 * 
 * Challenge
 * 
 */
package carlos.a.m.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import javax.net.SocketFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Conexao.
 */
public class Conexao {

	/**
	 * Url connection.
	 *
	 * @param html the html
	 * @param urlString the url string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void UrlConnection(StringBuffer html, String urlString) throws IOException {

		HttpURLConnection conn = null;

		try {
			String line;
			URL url = new URL(urlString);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 "
					+ "(KHTML, like Gecko) Chrome/32.0.1700.107 Safari/537.36");
			if (conn.getResponseCode() == 200) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
				while ((line = in.readLine()) != null)
					html.append(line.trim());
				in.close();
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

	}

	/**
	 * Socket connection.
	 *
	 * @param html the html
	 * @param port the port
	 * @throws UnknownHostException the unknown host exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void SocketConnection(StringBuffer html, Integer port) throws UnknownHostException, IOException {

		String line;
		SocketFactory sf = SocketFactory.getDefault();
		Socket s = sf.createSocket("www.imdb.com", port);
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));
		PrintStream out = new PrintStream(s.getOutputStream());
		String sOut = "GET /" + "Host: " + "https://www.imdb.com/find?s=tt&q=simpsons" + " HTTP/1.1\r\n\r\n";
		sOut += "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.107 Safari/537.36";
		out.println(sOut);
		out.println();

		while ((line = in.readLine()) != null) {
			System.out.println(line);
			html.append(line.trim());
		}

		in.close();
		out.flush();
		out.close();

	}

}
