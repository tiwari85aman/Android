package com.example.aman.linking;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toast.makeText(this,getIntent().getStringExtra("name"),Toast.LENGTH_SHORT).show();
    }

//    public void onClick(View view){
//        Intent data = new Intent();
//        EditText editText = findViewById(R.id.editText);
//        data.setData(Uri.parse(editText.getText().toString()));
//        setResult(RESULT_OK, data);
//        finish();
//    }
}
