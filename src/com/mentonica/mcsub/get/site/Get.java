package com.mentonica.mcsub.get.site;

import com.mentonica.mcsub.get.data.Variables;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Get extends JavaPlugin {

    public static void getUsers() throws Exception {
        if (Variables.isAble()) {
            URL url;
            String content = null;
            try {
                String URL_LOCATION = "http://mentonica.com/dev/dutchrastacraft/api/get.php?key=" + Variables.getServerKey();

                url = new URL(URL_LOCATION);

                URLConnection conn = url.openConnection();

                BufferedReader br = new BufferedReader(

                        new InputStreamReader(conn.getInputStream()));

                String inputLine;

                while ((inputLine = br.readLine()) != null) {
                    content = inputLine;
                }
                br.close();
                Variables.setUrlContent(content);

                String t = "No results found.";
                if (Variables.getUrlContent().toString().equals(t)) {
                    System.out.println("Able set to false");
                    Variables.setAble(false);
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
