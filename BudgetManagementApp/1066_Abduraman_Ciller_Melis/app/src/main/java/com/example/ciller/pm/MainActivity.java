package com.example.ciller.pm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences shared = getSharedPreferences("login", Context.MODE_PRIVATE);
        ((EditText)findViewById(R.id.editTextMain1)).setText(shared.getString("username", ""));
        ((EditText)findViewById(R.id.editText2)).setText(shared.getString("password", ""));


    }

    protected  void spreOperations(View v)
    {
        EditText user = (EditText)findViewById(R.id.editTextMain1);
        EditText password = (EditText)findViewById(R.id.editText2);
        if(user.getText().toString().equals("Ciller12") && password.getText().toString().equals("parola")) {
            SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("username", user.getText().toString());
            editor.putString("password", password.getText().toString());
            editor.commit();
            Intent it = new Intent(getApplicationContext(), MenuOperations.class);
            
            startActivity(it);
        }


        }


    protected void metodaSignUp(View view)
    {
        Intent it = new Intent(getApplicationContext(),Register.class);
        startActivity(it);

    }


}
