package com.example.davidwolfs.projet_annonce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

class CreerArticle extends AsyncTask
{
    private String nom;
    private String descriptif;
    private double prix;
    private String etat;
    private String ville;
    private String livraison;

    public CreerArticle(String nom, String descriptif, double prix, String etat, String ville, String livraison)
    {
        this.nom=nom;
        this.descriptif=descriptif;
        this.prix=prix;
        this.etat=etat;
        this.ville=ville;
        this.livraison=livraison;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getLivraison() {
        return livraison;
    }

    public void setLivraison(String livraison) {
        this.livraison = livraison;
    }




    @Override
    protected void onPreExecute()
    {

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
        try{
            String link = "http://192.168.1.42:80/annonce/connectToDB.php";
            String data  = URLEncoder.encode("nom", "UTF-8") + "=" +
                    URLEncoder.encode(nom, "UTF-8");
            data += "&" + URLEncoder.encode("descriptif", "UTF-8") + "=" +
                    URLEncoder.encode(descriptif, "UTF-8");
            data += "&" + URLEncoder.encode("prix", "UTF-8") + "=" +
                    URLEncoder.encode(prix+"", "UTF-8");
            data += "&" + URLEncoder.encode("etat", "UTF-8") + "=" +
                    URLEncoder.encode(etat, "UTF-8");
            data += "&" + URLEncoder.encode("ville", "UTF-8") + "=" +
                    URLEncoder.encode(ville, "UTF-8");
            data += "&" + URLEncoder.encode("livraison", "UTF-8") + "=" +
                    URLEncoder.encode(livraison, "UTF-8");

            System.out.println(link+data);
            URL url = new URL(link);
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.write( data );
            wr.flush();

            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null) {
                sb.append(line);
                break;
            }
            System.out.println("Resultat requete Creer article : "+sb.toString());
            return sb.toString();

        } catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
            return new String("Exception: " + e.getMessage());
        }
    }
}

    protected void onProgressUpdate(String... values) {

    }


    protected void onPostExecute(String result)
    {

    }

}