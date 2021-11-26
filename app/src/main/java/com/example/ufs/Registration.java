package com.example.ufs;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ufs.data.model.UserModel;
import com.example.ufs.ui.login.LoginActivity;

public class Registration extends AppCompatActivity {

    private EditText et_fName;
    private EditText et_lName;
    private EditText et_email;
    private EditText et_password;
    private EditText et_universityID;
    private CheckBox chk_isStudent;

    private Button registerButton;
    String TAG = "==== RegistrationActivity ====";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // get data from input fields
        et_fName = (EditText) findViewById(R.id.fname_reg_input);
        et_lName = (EditText) findViewById(R.id.lname_reg_input);
        et_email = (EditText) findViewById(R.id.email_reg_input);
        et_password = (EditText) findViewById(R.id.password_reg_input);
        et_universityID = (EditText) findViewById(R.id.uni_id_reg_input);
        chk_isStudent = (CheckBox) findViewById(R.id.isstudent_checkbox);

        registerButton = findViewById(R.id.registerbutton);

        Editable fname = et_fName.getText();

        // Register handler
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i(TAG, "REGISTER BUTTON CLICKED");
                UserModel newUser;
                try {
                    // TODO: data validation


                    //newUser = new UserModel("Jon", "Doe", "jondoe@gmail.edu", "12345679", "password123", 1);
                    newUser = new UserModel(
                            et_fName.getText().toString(),
                            et_lName.getText().toString(),
                            et_email.getText().toString(),
                            et_universityID.getText().toString(),
                            et_password.getText().toString(),
                            chk_isStudent.isChecked()
                    );
                    DatabaseHelper dbo = new DatabaseHelper(Registration.this);
                    boolean u_success = dbo.addUser(newUser);
                    Toast.makeText(Registration.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                } catch(Exception e) {
                    Toast.makeText(Registration.this, "Error registering user", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}