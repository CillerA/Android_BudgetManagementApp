package com.example.ciller.pm;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Receivables extends AppCompatActivity {
    DatabaseHelper myDatabase;
    EditText etName, etAmount, etId;
    Spinner spinnerUnit;
    Button addReceivButton;
    Button deleteReceivButton;
    Button viewReceivButton;

    Button viewUpdatesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receivables);
        myDatabase = new DatabaseHelper(this);

        etName = (EditText) findViewById(R.id.etNameReceivables);
        etAmount = (EditText) findViewById(R.id.etAmountReceivables);
        spinnerUnit = (Spinner) findViewById(R.id.spinnerUnitReceiv);
        etId = (EditText) findViewById(R.id.etIdReceivables);

        addReceivButton = (Button) findViewById(R.id.addReceivableButton);
        deleteReceivButton = (Button) findViewById(R.id.deleteReceivablesButton);
        viewReceivButton = (Button) findViewById(R.id.viewAllReceiv);
        viewUpdatesButton = (Button) findViewById(R.id.updateReceivablesButton);

        addReceivable();
        viewAllReceivables();
        updateReceivable();
        deleteReceivable();
    }

    public void addReceivable() {
        addReceivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean aFostAdaugat = myDatabase.insertReceivable(etName.getText().toString(), etAmount.getText().toString(),
                        spinnerUnit.getSelectedItem().toString());

                if (aFostAdaugat == true)
                    Toast.makeText(Receivables.this, "A receivable was inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Receivables.this, "Error", Toast.LENGTH_LONG).show();
            }
        }
        );

    }

    public void showMessage(String t,String mesaj){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(t);
        builder.setMessage(mesaj);
        builder.show();
    }

    public void viewAllReceivables(){
        viewReceivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor r = myDatabase.getReceivables();
                if(r.getCount() == 0)
                {
                    showMessage("Error", "No receivables found");
                    return;

                }

                StringBuffer b = new StringBuffer();
                while(r.moveToNext())
                {
                    b.append("Id :" + r.getString(0)+ "\n");
                    b.append("Name :" + r.getString(1)+ "\n");
                    b.append("Amount :"+r.getString(2)+ "\n");
                    b.append("Unit: "+r.getString(3)+ "\n");
                }

                showMessage("Receivables", b.toString());

            }
        });

    }

    public void updateReceivable()
    {
        viewUpdatesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean updateReusit = myDatabase.updateReceivable(etId.getText().toString(),
                        etName.getText().toString(), etAmount.getText().toString(),
                        spinnerUnit.getSelectedItem().toString());
                if(updateReusit == true)
                    Toast.makeText(Receivables.this, "Update OK", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Receivables.this, "Error", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void deleteReceivable()
    {
        deleteReceivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer randuriSterse = myDatabase.deleteReceivable(etId.getText().toString());
                if (randuriSterse > 0)
                    Toast.makeText(Receivables.this, "Receivable removed", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Receivables.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}
