package com.example.aman.linking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int request_Code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v) {
        /* resultBack from activity
        Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(new Intent(intent),request_Code);
        */

        EditText editText= findViewById(R.id.editText2);
        Intent i=new Intent(this,Main2Activity.class);
        i.putExtra("name",editText.getText().toString());
        Bundle extras= new Bundle();
        extras.putString("str2", "another string");
        extras.putInt("age",15);
        i.putExtras(extras);
        startActivity(i);
    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data)
//    {
//        if(requestCode==request_Code){
//            if(resultCode==RESULT_OK){
//                Toast.makeText(this,data.getData().toString(),Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
}
