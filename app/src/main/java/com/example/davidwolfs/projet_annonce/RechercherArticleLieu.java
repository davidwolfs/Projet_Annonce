package com.example.davidwolfs.projet_annonce;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Wolfs on 07-08-18.
 */

public class RechercherArticleLieu extends AppCompatActivity {
    private String lieu;

    public RechercherArticleLieu(String lieu) {
        this.lieu = lieu;
        RechercherArticleLieu_AsyncTask rechercherArticleLieu_AsyncTask = new RechercherArticleLieu_AsyncTask();
        rechercherArticleLieu_AsyncTask.execute();
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu)
    {
        this.lieu = lieu;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_article_par_prix);

        /*this.tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        this.tableRow = (TableRow) findViewById(R.id.tableRow);*/


        String[] prenoms = new String[]{
                "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
                "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
                "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
                "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
                "Yann", "Zoé"
        };

       /* RechercherArticlePrix_AsyncTask rechercherArticlePrix_AsyncTask = new RechercherArticlePrix_AsyncTask();
        rechercherArticlePrix_AsyncTask.execute();*/
    }

    class RechercherArticleLieu_AsyncTask extends AsyncTask
    {
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Object doInBackground(Object[] objects) {
            {
           /* try{
                String link = "http://localhost/annonce/connectToDB.php";

                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(response.getEntity().getContent()));

                StringBuffer sb = new StringBuffer("");
                String line="";

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }

                in.close();
                return sb.toString();
            } catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }*/
                try {
                    String link = "http://192.168.1.44:80/annonce/rechercherArticleLieu.php";
                    String data = URLEncoder.encode("lieu", "UTF-8") + "=" +
                            URLEncoder.encode(lieu + "", "UTF-8");

                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                 /*   wr.write( data );
                    wr.flush();*/

                    BufferedReader reader = new BufferedReader(new
                            InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }
                    System.out.println("Resultat requete Rechercher article prix : "+sb.toString());
                    String result = sb.toString();
                    // System.out.println(result);

                    JSONArray ja = new JSONArray(result);
                    JSONObject jo = null;
                    // data = new String[ja.length()];

                    for (int i = 0; i < ja.length(); i++) {
                        jo = ja.getJSONObject(i);
                        System.out.println(jo);
                        //data[i] = jo.getString("Name");
                    }
                    result = sb.toString();
                    System.out.println(result);

                    return sb.toString();
                } catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
                    return new String("Exception: " + e.getMessage());
                }
            }
        }

        protected void onProgressUpdate(String... values) {

        }


        protected void onPostExecute(String result) {
            //Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            System.out.println("RESULTAT  : " + result);
        }
    }
}

