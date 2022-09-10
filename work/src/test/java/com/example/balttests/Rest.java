package com.example.balttests;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Rest {



        public static void main(String[] args) throws Exception {
        URL url = new URL("https://devops-testvm40.bb-webapps.com:4443/");
        URLConnection connection = url.openConnection();

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream())))
        {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
