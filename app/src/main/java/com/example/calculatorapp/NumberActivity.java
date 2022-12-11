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

public class NumberActivity extends AppCompatActivity {
    private String binary = "";
    private String octal = "";
    private String decimal = "";
    private String hex = "";

    private EditText binaryBox;
    private EditText octalBox;
    private EditText decimalBox;
    private EditText hexBox;
    private Button binaryButton;
    private Button octalButton;
    private Button decimalButton;
    private Button hexButton;
    private Button resetButton;
    private TextView status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_number);

            binaryBox = (EditText) findViewById(R.id.binary_box);
            octalBox = (EditText) findViewById(R.id. octal_box);
            decimalBox = (EditText) findViewById(R.id.decimal_box);
            hexBox = (EditText) findViewById(R.id.hex_box);
            binaryButton = (Button) findViewById(R.id.binary_button);
            octalButton = (Button) findViewById(R.id.octal_button);
            decimalButton = (Button) findViewById(R.id.decimal_button);
            hexButton = (Button) findViewById(R.id.hex_button);
            resetButton = (Button) findViewById(R.id.reset);
            status = (TextView) findViewById(R.id.status);


            binaryButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    binaryConvertion();
                }
            });

            octalButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    octalConvertion();
                }
            });

            decimalButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    decimalConvertion();
                }
            });

            hexButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    hexConvertion();
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
            binaryBox.setText("");
            octalBox.setText("");
            decimalBox.setText("");
            hexBox.setText("");
            status.setText("Status : OK");
        }

        private void binaryConvertion()
        {
            try
            {
                binary = binaryBox.getText().toString().toLowerCase();
                /*Octal*/
                octalBox.setText(Integer.toOctalString(Integer.parseInt(String.valueOf(binary),2)));
                /*decimal*/
                decimalBox.setText(Integer.toString(Integer.parseInt(String.valueOf(binary),2)));
                /*hex*/
                hexBox.setText(Integer.toHexString(Integer.parseInt(String.valueOf(binary),2)).toUpperCase());
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

        private void octalConvertion()
        {
            try
            {
                octal = octalBox.getText().toString().toLowerCase();
                /*binary*/
                binaryBox.setText(Integer.toBinaryString(Integer.parseInt(String.valueOf(octal),8)));
                /*decimal*/
                decimalBox.setText(Integer.toString(Integer.parseInt(String.valueOf(octal),8)));
                /*hex*/
                hexBox.setText(Integer.toHexString(Integer.parseInt(String.valueOf(octal),8)).toUpperCase());
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

        private void decimalConvertion()
        {
            try
            {
                decimal = decimalBox.getText().toString().toLowerCase();
                /*binary*/
                binaryBox.setText(Integer.toBinaryString(Integer.parseInt(decimal)));
                /*octal*/
                octalBox.setText(Integer.toOctalString(Integer.parseInt(decimal)));
                /*hex*/
                hexBox.setText(Integer.toHexString(Integer.parseInt(decimal)).toUpperCase());
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

        private void hexConvertion()
        {
            try
            {
                hex = hexBox.getText().toString().toLowerCase();
                /*binary*/
                binaryBox.setText(Integer.toBinaryString(Integer.parseInt(String.valueOf(hex),16)));
                /*octal*/
                octalBox.setText(Integer.toOctalString(Integer.parseInt(String.valueOf(hex),16)));
                /*decimal*/
                decimalBox.setText(Integer.toString(Integer.parseInt(String.valueOf(hex),16)));
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
            startActivity(new Intent(NumberActivity.this, MainActivity.class));
            return true;
        }
        if (id == R.id.action_scientific) {
            startActivity(new Intent(NumberActivity.this, ScientificActivity.class));
            return true;
        }
        if(id== R.id.action_longeur) {
            startActivity(new Intent(NumberActivity.this, LengthActivity.class));
            return true;
        }
        if(id== R.id.action_nombre) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }