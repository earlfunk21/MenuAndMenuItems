package com.example.menuandmenuitems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3_ListDisplay extends AppCompatActivity {
    private TextView displayFirstName;
    private TextView displayLastName;
    private TextView displayGender;
    private TextView displayBirthDate;
    private TextView displayPhoneNumber;
    private TextView displayEmailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_list_display);
        Intent intent = getIntent();
        String firstName = intent.getStringExtra("firstName");
        String lastName = intent.getStringExtra("lastName");
        String gender = intent.getStringExtra("gender");
        String phoneNumber = intent.getStringExtra("phoneNumber");
        String birthDate = intent.getStringExtra("birthDate");
        String emailAddress = intent.getStringExtra("emailAddress");

        displayFirstName = findViewById(R.id.displayFirstName);
        displayLastName = findViewById(R.id.displayLastName);
        displayGender = findViewById(R.id.displayGender);
        displayBirthDate = findViewById(R.id.displayBirthDate);
        displayPhoneNumber = findViewById(R.id.displayPhoneNumber);
        displayEmailAddress = findViewById(R.id.displayEmailAddress);

        displayFirstName.setText(firstName);
        displayLastName.setText(lastName);
        displayGender.setText(gender);
        displayPhoneNumber.setText(phoneNumber);
        displayBirthDate.setText(birthDate);
        displayEmailAddress.setText(emailAddress);
    }

    public void BackToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}