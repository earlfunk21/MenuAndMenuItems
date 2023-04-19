package com.example.menuandmenuitems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;

public class MainActivity2_Register extends AppCompatActivity {

    private EditText txtFirstName;
    private EditText txtLastName;
    private RadioGroup radioGender;
    private RadioButton radioSelectedGender;
    private Button txtBirthDate;
    private EditText txtPhoneNumber;
    private EditText txtEmailAddress;

    private DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_register);
        setTitle("Register Page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // handle date selection here
                        String date = getMonthFormat(month) + " " + dayOfMonth + ", " + year;
                        txtBirthDate.setText(date);
                    }
                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );

        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        radioGender = findViewById(R.id.radioGender);
        txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
        txtBirthDate = findViewById(R.id.txtBirthDate);
        txtEmailAddress = findViewById(R.id.txtEmailAddress);
    }
    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.register_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clearFields(View view) {
    }

    public void submitFields(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity3_ListDisplay.class);
        String firstName = txtFirstName.getText().toString();
        String lastName = txtLastName.getText().toString();
        int radioGenderID = radioGender.getCheckedRadioButtonId();
        radioSelectedGender = findViewById(radioGenderID);
        String selectedGender = radioSelectedGender.getText().toString();
        String birthDate = txtBirthDate.getText().toString();
        String phoneNumber = txtPhoneNumber.getText().toString();
        String emailAddress = txtEmailAddress.getText().toString();
        intent.putExtra("firstName", firstName);
        intent.putExtra("lastName", lastName);
        intent.putExtra("gender", selectedGender);
        intent.putExtra("birthDate", birthDate);
        intent.putExtra("phoneNumber", phoneNumber);
        intent.putExtra("emailAddress", emailAddress);
        startActivity(intent);
    }

    public void showCalendar(View view) {

        datePickerDialog.show();
    }
}