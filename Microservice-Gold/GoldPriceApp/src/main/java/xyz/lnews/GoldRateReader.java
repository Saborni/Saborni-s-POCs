package xyz.lnews;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoldRateReader {

    public GoldRateDTO getGoldRateResponse(String karat) throws IOException {
        String url = "http://localhost:8081/rate/";
        URL urlForGetRequest = new URL(url+karat);
        String readLine = null;
        GoldRateDTO goldRateDTO;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            goldRateDTO= new Gson().fromJson(String.valueOf(response), GoldRateDTO.class);
        } else {
            goldRateDTO = new GoldRateDTO(0,0);
        }
        return goldRateDTO;
    }
}
