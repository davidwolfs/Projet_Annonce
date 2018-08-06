package com.example.davidwolfs.projet_annonce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button btnAjoutArticle;
    private Button btnRechercherArticleVille;
    private Button btnRechercherArticlePrix;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.btnAjoutArticle=(Button)findViewById(R.id.btnAjoutArticle);

        btnAjoutArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), AjouterArticleActivity.class);
                startActivity(otherActivity);
            }
        });

        this.btnRechercherArticleVille=(Button)findViewById(R.id.btnRechercherArticleVille);

        btnRechercherArticleVille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), RechercheArticleLieu.class);
                startActivity(otherActivity);
            }
        });

        this.btnRechercherArticlePrix=(Button)findViewById(R.id.btnRechercherArticlePrix);

        btnRechercherArticlePrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), RechercheArticlePrix.class);
                startActivity(otherActivity);
            }
        });

    }


}
