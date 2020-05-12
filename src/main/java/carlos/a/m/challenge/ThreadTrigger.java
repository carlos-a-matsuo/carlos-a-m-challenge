package carlos.a.m.challenge;

import java.util.List;
import java.util.Map;

/**
 * @author Carlos Atsuchi Matsuo
 *
 *         Challenge
 */
public class ThreadTrigger {

	public void startSearcher(String serie, SearchType tipoBusca, Integer port) {

		Thread t1 = new Thread(new Runnable() {

			public void run() {

				Searcher searcher = new Searcher();

				List<Map<String, String>> results = searcher.search(serie, tipoBusca, port);

				if (results == null || results.isEmpty()) {
					CallBack callBack = new CallBack();
					callBack.sendCallBackService(results);
				}

				for (int i = 0; i < results.size(); i++) {
					System.out
							.println("Número #" + String.valueOf(i + 1) + " ----------------------------------------");
					System.out.println("ID....: " + results.get(i).get("id"));
					System.out.println("Nome.......: " + results.get(i).get("name"));
				}

			}

		});

		t1.start();

	}

}
