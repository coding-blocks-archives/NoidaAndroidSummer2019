package com.codingblocks.buttonslayouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4;
    TextView tv;
    EditText ed1,ed2;
    int a = 10,b = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        btn1 = findViewById(R.id.multiplyBtn);
        btn2 = findViewById(R.id.subtractBtn);
        btn3 = findViewById(R.id.additionBtn);
        btn4 = findViewById(R.id.divideBtn);
        tv = findViewById(R.id.resultTv);
        ed1 = findViewById(R.id.editText2);
        ed2 = findViewById(R.id.editText1);
       ed1.setText(ed1.getText().toString().substring(0,ed1.length()-1));






//        View.OnClickListener abc = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(MainActivity.this, "Button 2 click", Toast.LENGTH_SHORT).show();
////
////            }
////        };

        btn1.hasFocus()
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn4.getText()

    }

    public void button2Click(View view) {
    }



    @Override
    public void onClick(View v) {
        if(ed1.hasFocus())
        if (!ed1.getText().toString().equals("") && !ed2.getText().toString().equals("")) {
            a = Integer.parseInt(ed1.getText().toString());
            b = Integer.parseInt(ed2.getText().toString());
        }else{
            Toast.makeText(this, "Number must not be empty", Toast.LENGTH_SHORT).show();
        }


        if(v.getId() == R.id.additionBtn)
            tv.setText(a+b+"");
        if(v.getId() == R.id.subtractBtn)
            tv.setText(a-b+"");
        if(v.getId() == R.id.multiplyBtn)
            tv.setText(a*b+"");
        if(v.getId() == R.id.divideBtn)
            tv.setText(a/b+"");

    }
}
