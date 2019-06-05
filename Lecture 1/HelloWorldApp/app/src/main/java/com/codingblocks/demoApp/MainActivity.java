package com.codingblocks.demoApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("HelloWorldApp","OnCreate");


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("HelloWorldApp ","OnResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("HelloWorldApp","OnStart");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("HelloWorldApp","onStop");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("HelloWorldApp","OnDestroy");


    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("HelloWorldApp","OnRestart");


    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("HelloWorldApp","onPause");


    }

    public void clickButton(View view) {
        Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
    }
}
