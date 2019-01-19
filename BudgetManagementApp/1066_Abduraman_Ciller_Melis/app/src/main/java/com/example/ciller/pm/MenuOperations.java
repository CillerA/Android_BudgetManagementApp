package com.example.ciller.pm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuOperations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_operations);

    }
        protected void spreLista(View v) {
            Intent intent = new Intent(getApplicationContext(), AllDebtsList.class);
            startActivity(intent);
        }
        protected void adaugaDatorie(View v)
        {
            Intent intent = new Intent(getApplicationContext(), DebtAddActivity.class);
            startActivity(intent);
        }

        protected void spreBooks(View v)
        {
            Intent it = new Intent(getApplicationContext(), Books_WishList.class);
            startActivity(it);

        }

    protected void spreReview(View v)
    {
        Intent it = new Intent(getApplicationContext(), Review.class);
        startActivity(it);

    }

    protected void spreReceivables(View v)
    {
        Intent it = new Intent(getApplicationContext(), Receivables.class);
        startActivity(it);

    }

}




