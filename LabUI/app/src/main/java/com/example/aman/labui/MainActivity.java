package com.example.aman.labui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button save= findViewById(R.id.save);
        save.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View V){
                        display("save");
                    }
                }
        );

        Button open= findViewById(R.id.open);
        open.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View V){
                        display("open");
                    }
                }
        );

        ImageButton imageB= findViewById(R.id.imageButton);
        imageB.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View V){
                        display("ImageButton");
                    }
                }
        );

        CheckBox checkBox= findViewById(R.id.checkBox);
        checkBox.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View V){
                        display("autosave checkbox");
                    }
                }
        );

        CheckBox star= findViewById(R.id.star);
        star.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View V){
                        display("star checkbox");
                    }
                }
        );

        RadioGroup radio= findViewById(R.id.radio);
        radio.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener(){
                    public void onCheckedChanged(RadioGroup group, int checkedId){
                        if (checkedId==R.id.radio1)
                        {
                            display("option1");
                        }
                        else if(checkedId==R.id.radio2){
                            display("option2");
                        }
                    }
                }
        );

        ToggleButton toggle= findViewById(R.id.toggleButton);
        toggle.setOnClickListener(
                new ToggleButton.OnClickListener(){
                    public void onClick(View V){
                        display("Toggle Buttonx");
                    }
                }
        );

    }
    private void display(String msg)
    {
        Toast.makeText(getBaseContext(),msg,10).show();
    }
}
