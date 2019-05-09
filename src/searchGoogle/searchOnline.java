package searchGoogle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class searchOnline {

	public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";

	public static void main(String[] args) throws Exception {
		// Taking search term input from console
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the search term.");
		String searchTerm = scanner.nextLine();
		URL encodedUrl = new URL("http://www.google.ca/search?q=" + URLEncoder.encode(searchTerm, "UTF-8"));
		System.out.println(encodedUrl);
		HttpURLConnection connection = (HttpURLConnection) encodedUrl.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("User-Agent", "Sahil");
		int status = connection.getResponseCode();
		System.out.println(status);
		System.out.println(connection);
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		connection.disconnect();
		System.out.println(content);
	}
}