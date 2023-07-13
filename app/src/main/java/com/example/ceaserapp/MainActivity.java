package com.example.ceaserapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,no;
    int k;
    Button b1,b2;
    String inputStr;
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.et1);
        e2=(EditText) findViewById(R.id.et2);
        no=(EditText) findViewById(R.id.no);
        b1=(Button) findViewById(R.id.e1);
        b2=(Button) findViewById(R.id.d1);
    }

    public void onEncrypt(View v)
    {
        k=Integer.parseInt(no.getText().toString());
        String str1=e1.getText().toString();
        str1=str1.replaceAll("\\s", "");
        String encryptStr="";
        if(str1.isEmpty()|| str1.length()==0)
        {
            Toast.makeText(this, "Enter the sentence to be encrypted",Toast.LENGTH_SHORT).show();
            return;
        }
        if(no.getText().toString().isEmpty() || k>25)
        {
            Toast.makeText(this, "Enter any number less than 26",Toast.LENGTH_SHORT).show();
            return;
        }
        inputStr = str1.toLowerCase();
        for(int i=0;i<str1.length();i++)
        {
            int pos = ALPHABET.indexOf(inputStr.charAt(i));
            int encryptPos = (k+pos) % 26;
            char encryptChar = ALPHABET.charAt(encryptPos);
            encryptStr += String.valueOf(encryptChar);
        }
        e2.setText(encryptStr);
    }
    public void onDecrypt(View v)
    {
        k=Integer.parseInt(no.getText().toString());
        String str1=e2.getText().toString();
        str1=str1.replaceAll("\\s", "");
        String decryptStr="";
        if(str1.isEmpty()|| str1.length()==0)
        {
            Toast.makeText(this, "Enter the sentence to be encrypted",Toast.LENGTH_SHORT).show();

        }
        if(TextUtils.isEmpty(no.getText().toString()) ||k>25)
        {
            Toast.makeText(this, "Enter any number less than 26",Toast.LENGTH_SHORT).show();

        }
        inputStr = str1.toLowerCase();
        for(int i=0;i<str1.length();i++)
        {
            int pos = ALPHABET.indexOf(inputStr.charAt(i));
            int decryptPos = (pos-k) % 26;
            if (decryptPos < 0){
                decryptPos = ALPHABET.length() + decryptPos;
            }
            char decryptChar = ALPHABET.charAt(decryptPos);



            decryptStr += String.valueOf(decryptChar);
        }
        e1.setText(decryptStr);
    }
}