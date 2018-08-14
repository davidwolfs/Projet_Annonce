package com.example.davidwolfs.projet_annonce;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by David Wolfs on 11-08-18.
 */

public class AfficherArticleParPrixActivity extends AppCompatActivity implements AsyncResponse
{
    private Button btnRetour;
    private ListView listView;
    private String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_article_par_prix);


        String[] result = null;

        this.btnRetour=(Button)findViewById(R.id.btnRetour);
        this.listView = (ListView) findViewById(R.id.listView);
        double prixMin= Double.parseDouble(getIntent().getStringExtra("PRIXMIN"));
        double prixMax = Double.parseDouble(getIntent().getStringExtra("PRIXMAX"));
        RechercherArticlePrix rechercherArticlePrix = new RechercherArticlePrix(prixMin, prixMax);
        rechercherArticlePrix.delegate = this;

        List<Article> listArticle = new ArrayList<>();
        try {
            String resultGet = (String) rechercherArticlePrix.execute().get();
            resultGet = resultGet.substring(0, resultGet.length()-1);
            System.out.println("toto" + resultGet);
            String[] split = resultGet.split("-");
            System.out.println("|| : " + split[0]);
            result = new String[split.length];
            System.out.println("Longueur de split : " + split.length);
            for(int i = 0 ; i < split.length ; i++)
            {
                String[] split2 = split[i].split(";");
                Article article = new Article(split2[1], split2[2], Double.parseDouble(split2[3]), split2[4], split2[5], split2[6]);
                result[i] = split2[1] + " " + split2[3];
                System.out.println("RESULT [i] : " + result[i]);
                listArticle.add(article);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("RESULT GET : " + listArticle.size());
        for(int i=0;i<result.length;i++)
        {
            System.out.println("RESULT : " + result[i]);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(listView.getContext(), android.R.layout.simple_list_item_1, result);
        listView.setAdapter(adapter);


        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
            }
        });
    }

    @Override
    public void processFinish(String output) {
        res = output;
    }
}
