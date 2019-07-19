package com.agiledeveloper;

import com.json.parsers.JSONParser;
import com.json.parsers.JsonParserFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

public class MovieInfo {
  public static Map<String, String> getMovieInfo(final String movieName) throws Exception {
    String queryURL = "http://www.omdbapi.com/?t=" + movieName.replaceAll(" ", "%20");
    final URL url = new URL(queryURL);
    final BufferedReader reader =
        new BufferedReader(new InputStreamReader(url.openStream()));
    
    JSONParser jsonParser = JsonParserFactory.getInstance().newJsonParser();
    String content = "";
    String line = "";
    while ((line = reader.readLine()) != null) {
      content += line;
    }
    return jsonParser.parseJson(content);
  }
}
