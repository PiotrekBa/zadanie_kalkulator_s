package pl.piotrbartoszak.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;

@Service
public class CheckCurrencyService {

    private static final String URL = "http://api.nbp.pl/api/exchangerates/rates/A/";

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static BigDecimal getCurrencyExchangeRate(String currencySymbol) {
        try {
            if (currencySymbol.equals("PLN")) {
                return new BigDecimal(1);
            } else {
                JSONObject jsonObject = readJsonFromUrl(URL + currencySymbol + "?format=json");
                JSONArray rates = jsonObject.getJSONArray("rates");

                JSONObject j = ((JSONObject) rates.get(0));
                String mid = j.get("mid").toString();

                return new BigDecimal(mid);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
