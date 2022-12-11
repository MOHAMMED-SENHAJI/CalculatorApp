package com.example.calculatorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LengthActivity extends AppCompatActivity {

    private double meters;
    private double kilometers;
    private double feet;
    private double miles;

    private EditText metersBox;
    private EditText kilometersBox;
    private EditText feetBox;
    private EditText milesBox;
    private Button metersButton;
    private Button kilometersButton;
    private Button feetButton;
    private Button milesButton;
    private Button resetButton;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);


        metersBox = (EditText) findViewById(R.id.meters_box);
        kilometersBox = (EditText) findViewById(R.id.kilometers_box);
        feetBox = (EditText) findViewById(R.id.feet_box);
        milesBox = (EditText) findViewById(R.id.miles_box);
        metersButton = (Button) findViewById(R.id.meters_button);
        kilometersButton = (Button) findViewById(R.id.kilometers_button);
        feetButton = (Button) findViewById(R.id.feet_button);
        milesButton = (Button) findViewById(R.id.miles_button);
        resetButton = (Button) findViewById(R.id.reset);
        status = (TextView) findViewById(R.id.status);

        metersButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                metersConvertion();
            }
        });

        kilometersButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                kilometersConvertion();
            }
        });

        feetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                feetConvertion();
            }
        });

        milesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                milesConvertion();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                reset();
            }
        });
    }

    private void reset()
    {
        metersBox.setText(" ");
        kilometersBox.setText(" ");
        feetBox.setText(" ");
        milesBox.setText(" ");
        status.setText("Status : OK");
    }

    private void metersConvertion()
    {
        try
        {
            meters = Double.parseDouble(metersBox.getText().toString());
            kilometers = meters / 1000;
            feet = meters / 0.3048;
            miles = meters / 1609.344;
            kilometersBox.setText(String.valueOf(kilometers));
            feetBox.setText(String.valueOf(feet));
            milesBox.setText(String.valueOf(miles));
            status.setText("Status : OK");
        }
        catch(NumberFormatException e)
        {
            status.setText("Status : Try again. Error -> NumberFormatException -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void kilometersConvertion()
    {
        try
        {
            kilometers = Double.parseDouble(kilometersBox.getText().toString());
            meters = kilometers * 1000;
            feet = kilometers / 0.0003048;
            miles = kilometers / 1.609344;
            metersBox.setText(String.valueOf(meters));
            feetBox.setText(String.valueOf(feet));
            milesBox.setText(String.valueOf(miles));
            status.setText("Status : OK");
        }
        catch(NumberFormatException e)
        {
            status.setText("Status : Try again. Error -> NumberFormatException -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void feetConvertion()
    {
        try
        {
            feet = Double.parseDouble(feetBox.getText().toString());
            meters = feet * 0.3048;
            kilometers = feet * 0.0003048;
            miles = feet * 0.000189393939;
            metersBox.setText(String.valueOf(meters));
            kilometersBox.setText(String.valueOf(kilometers));
            milesBox.setText(String.valueOf(miles));
            status.setText("Status : OK");
        }
        catch(NumberFormatException e)
        {
            status.setText("Status : Try again. Error -> NumberFormatException -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void milesConvertion()
    {
        try
        {
            miles = Double.parseDouble(milesBox.getText().toString());
            meters = miles * 1609.344;
            feet = miles / 0.000189393939;
            kilometers = miles * 1.609344;
            metersBox.setText(String.valueOf(meters));
            feetBox.setText(String.valueOf(feet));
            kilometersBox.setText(String.valueOf(kilometers));
            status.setText("Status : OK");
        }
        catch(NumberFormatException e)
        {
            status.setText("Status : Try again. Error -> NumberFormatException -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_normal) {
            startActivity(new Intent(LengthActivity.this, MainActivity.class));
            return true;
        }
        if (id == R.id.action_scientific) {
            startActivity(new Intent(LengthActivity.this, ScientificActivity.class));
            return true;
        }
        if(id== R.id.action_longeur) {
            return true;
        }
        if(id== R.id.action_nombre) {
            startActivity(new Intent(LengthActivity.this, NumberActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}