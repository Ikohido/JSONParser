package org.mangalib;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        String resourceName = "/anime.json";
        InputStream is = Main.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }
        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);
        System.out.println("Id  : " + object.getJSONObject("items"));
        System.out.println("Id  : " + object.getJSONObject("items").getJSONArray("data"));
        JSONArray arr = object.getJSONObject("items").getJSONArray("data");
        for (int i = 0; i < arr.length(); i++) {
            arr.getJSONObject(i);
            System.out.println("ID : "+arr.getJSONObject(i).getInt("id"));
            System.out.println("Японское название : "+arr.getJSONObject(i).getString("name"));
            System.out.println("Английское название : "+arr.getJSONObject(i).getString("eng_name"));
            System.out.println("Название на русском : "+arr.getJSONObject(i).getString("rus_name"));
            System.out.println("Добавлен на сайт : "+arr.getJSONObject(i).getString("created_at"));
            System.out.println("Последний раз обновлен : "+arr.getJSONObject(i).getString("updated_at"));
            System.out.println("Ссылка на произведение : "+arr.getJSONObject(i).getString("href"));
            System.out.println("Ссылка на обложку: "+arr.getJSONObject(i).getString("coverImage"));
        }


    }
}