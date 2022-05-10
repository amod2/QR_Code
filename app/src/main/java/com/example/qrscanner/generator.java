package com.example.qrscanner;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class generator extends AppCompatActivity  {
EditText inputContent;
Button generate;
ImageView QR;
    String input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);
       inputContent=findViewById(R.id.txt);
       generate=findViewById(R.id.gen);
       QR=findViewById(R.id.scannerImg);
       generate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               input=inputContent.getText().toString().trim();
               MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
               try {
                   BitMatrix matrix=multiFormatWriter.encode(input,BarcodeFormat.QR_CODE,350,350);
                   BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
                   Bitmap bitmap=barcodeEncoder.createBitmap(matrix);
                   QR.setImageBitmap(bitmap);
                   InputMethodManager  manager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                   manager.hideSoftInputFromWindow(inputContent.getWindowToken(),0);

               } catch (WriterException e) {
                   e.printStackTrace();
               }


           }
       });


    }
}