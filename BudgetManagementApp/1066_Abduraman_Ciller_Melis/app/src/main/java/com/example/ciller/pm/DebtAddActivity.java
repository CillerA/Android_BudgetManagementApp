package com.example.ciller.pm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class DebtAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt_add);
        final EditText nameET = (EditText)findViewById(R.id.editTextAdd3);

        Button btn = (Button)findViewById(R.id.adaugaBtn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(nameET.getText() == null || nameET.getText().toString().trim().isEmpty())
                    Toast.makeText(getApplicationContext(), "Please complete all the fields!", Toast.LENGTH_LONG).show();
                Spinner categorySpinner = (Spinner)findViewById(R.id.spinnerCategory);
                EditText amountET = (EditText)findViewById(R.id.editTextAdd4);
                if(nameET.getText() == null || nameET.getText().toString().trim().isEmpty() || (amountET.getText()==null
                || amountET.getText().toString().trim().isEmpty()))
                    Toast.makeText(getApplicationContext(), "Please complete all the fields!", Toast.LENGTH_LONG).show();
                Spinner unitSpinner = (Spinner)findViewById(R.id.spinnerUnit);
                DatePicker createdDP = (DatePicker)findViewById(R.id.dp_created);
              //  int day = createdDP.getDayOfMonth();
               // int month = createdDP.getMonth() + 1;
               // int year = createdDP.getYear();
                DatePicker dueDP = (DatePicker)findViewById(R.id.dp_dueDate);

                RadioGroup paymentRG = (RadioGroup) findViewById(R.id.radioGroupPayment);
                int idRadioButton = paymentRG.getCheckedRadioButtonId();
                RadioButton paymentRB = (RadioButton) findViewById(idRadioButton);

                EditText descriptionET = (EditText)findViewById(R.id.editTextAdd5);
                Switch reminderSwitch = (Switch)findViewById(R.id.switchReminder);


                DebtDetails dd = new DebtDetails(nameET.getText().toString(), categorySpinner.getSelectedItem().toString(), amountET.getText().toString(), unitSpinner.getSelectedItem().toString(),
                        createdDP.getDayOfMonth(), createdDP.getMonth()+1, createdDP.getYear(), dueDP.getDayOfMonth(), dueDP.getMonth()+1, dueDP.getYear(), paymentRB.getText().toString(), descriptionET.getText().toString(), reminderSwitch.isChecked());

                AllDebtsList.datorii.add(dd);

                Toast.makeText(getApplicationContext(), "A new debt was added!",
                        Toast.LENGTH_LONG).show();

            }


        });
    }
}
