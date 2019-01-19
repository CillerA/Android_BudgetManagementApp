package com.example.ciller.pm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity{
private FirebaseAuth fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fa = FirebaseAuth.getInstance();

        final ProgressDialog pd = new ProgressDialog(this);

        final EditText firstNameET = (EditText) findViewById(R.id.editTextRegister1);
        final EditText lastNameET = (EditText) findViewById(R.id.editTextRegister2);
        final EditText emailET = (EditText) findViewById(R.id.editTextRegister3);
        final EditText usernameET = ((EditText) findViewById(R.id.editTextRegister4));
        final EditText passwordET = (EditText) findViewById(R.id.editTextRegister5);
        final EditText confirmPasswordET = (EditText) findViewById(R.id.editTextRegister6);

        Button submit = (Button) findViewById(R.id.buttonSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // boolean fieldsOK = validate(new EditText[]{firstNameET, lastNameET, emailET, usernameET, passwordET, confirmPasswordET});
               // if (fieldsOK = true) {
                if((firstNameET.getText() == null || firstNameET.getText().toString().trim().isEmpty())||
                        (lastNameET.getText() == null || lastNameET.getText().toString().trim().isEmpty()) ||
                                (emailET.getText() == null || emailET.getText().toString().trim().isEmpty()) ||
                                        (usernameET.getText() == null || usernameET.getText().toString().trim().isEmpty()) ||
                                                (passwordET.getText() == null || passwordET.getText().toString().trim().isEmpty())||
                                                (confirmPasswordET.getText() == null || confirmPasswordET.getText().toString().trim().isEmpty()))
                    Toast.makeText(getApplicationContext(), "Complete all the fields! ", Toast.LENGTH_LONG).show();
                else {
                    final String firstName = firstNameET.getText().toString();
                    if (!isValidFirstName(firstName)) {
                        firstNameET.setError("Invalid first name");
                    }

                    final String lastName = lastNameET.getText().toString();
                    if (!isValidLastName(lastName)) {
                        lastNameET.setError("Invalid last name");
                    }


                    final String email = emailET.getText().toString();
                    if (!isValidEmail(email)) {
                        emailET.setError("Invalid email address");
                    }


                    final String username = usernameET.getText().toString();
                    if (!isValidUsername(username)) {
                        usernameET.setError("Invalid username ");
                    }


                    final String password = passwordET.getText().toString();
                    if (!isValidPassword(password)) {
                        passwordET.setError("Invalid password ");
                    }


                    final String confirmPassword = confirmPasswordET.getText().toString();
                    if (!isValidConfirmPassword(confirmPassword)) {
                        confirmPasswordET.setError("Passwords not matching ");
                    }


                    RadioGroup grup = (RadioGroup) findViewById(R.id.radioGroupGender);
                    int idRadioButton = grup.getCheckedRadioButtonId();
                    RadioButton rbChecked = (RadioButton) findViewById(idRadioButton);
                    String gender = rbChecked.getText().toString();

                    Spinner spinner = (Spinner) findViewById(R.id.spinnerAge);
                    String spinnerText = spinner.getSelectedItem().toString();

                    boolean agree = ((CheckBox) findViewById(R.id.checkBoxRegister)).isChecked();


                    TextView result = (TextView) findViewById(R.id.resultTV);


                    pd.setMessage("Registering user..");
                    pd.show();

                   fa.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Register.this, "Something wrong happened.Please try again! ", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                    StringBuilder sb = new StringBuilder();
                    sb.append("V-ati creat un cont cu succes!");
                    sb.append(firstName);
                    sb.append("-");
                    sb.append(lastName);
                    sb.append("-");
                    sb.append(email);
                    sb.append("-");
                    sb.append(username);
                    sb.append("-");
                    sb.append(password);
                    sb.append("-");
                    sb.append(confirmPassword);
                    sb.append("-");
                    sb.append(gender);
                    sb.append("-");
                    sb.append(spinnerText);
                    sb.append("-");
                    sb.append(agree);
                    result.setText(sb.toString());
                }
            }

        });

    }

   private boolean isValidFirstName(String firstName)
    {
        if(firstName!= null && firstName.length() > 5){
            return true;
        }
        return false;
    }

    private boolean isValidLastName(String lastName)
    {
        if(lastName!= null && lastName.length() > 5){
            return true;
        }
        return false;
    }

    private boolean isValidEmail(String e)
    {
        if(e!= null && e.length() > 5){
            return true;
        }
        return false;
    }


    private boolean isValidUsername(String user)
    {
        if(user!= null && user.length() > 4){
            return true;
        }
        return false;
    }

    private boolean isValidPassword(String pass)
    {
        if(pass!= null && pass.length() > 4){
            return true;
        }
        return false;
    }

    private boolean isValidConfirmPassword(String confirm)
    {
        if(confirm!= null && confirm.length() > 4) {
            return true;
        }
        return false;
    }



   /* private boolean validate(EditText[] fields){
        for(int i = 0; i < fields.length; i++){
            EditText currentField = fields[i];
            if(currentField.getText().toString().length() <= 0){
                return false;
            }
        }
        return true;
    }
    */

}