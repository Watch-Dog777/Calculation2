package com.example.administrator.myapplicationhahah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.textViewSwitch1).setOnClickListener(this);
        findViewById(R.id.textViewSwitch2).setOnClickListener(this);
        findViewById(R.id.textViewSwitch3).setOnClickListener(this);
        findViewById(R.id.textViewSwitch4).setOnClickListener(this);
        findViewById(R.id.imageView1).setOnClickListener(this);
        findViewById(R.id.imageView2).setOnClickListener(this);
        findViewById(R.id.imageView3).setOnClickListener(this);
        findViewById(R.id.imageView4).setOnClickListener(this);
        findViewById(R.id.imageView5).setOnClickListener(this);
        findViewById(R.id.imageView6).setOnClickListener(this);
        findViewById(R.id.imageView7).setOnClickListener(this);
        findViewById(R.id.imageView8).setOnClickListener(this);
        findViewById(R.id.imageView9).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textViewSwitch1:
                Intent intent=new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setClass(Main2Activity.this,MainActivity.class);
                startActivity(intent);

                break;
            case R.id.textViewSwitch2:
                Toast.makeText(Main2Activity.this, "就在换算界面哦",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.textViewSwitch3:
                Intent intent2=new Intent();
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                intent2.setClass(Main2Activity.this,Main3Activity.class);
                startActivity(intent2);

                break;
            case R.id.textViewSwitch4:
                Intent intent3=new Intent();
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                intent3.setClass(Main2Activity.this,Main4Activity.class);
                startActivity(intent3);

                break;
            case R.id.imageView1:
                startActivity(new Intent(Main2Activity.this,Main2Activity_1.class));
                break;
            case R.id.imageView2:
                Toast.makeText(Main2Activity.this, "仍在开发中",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView3:
                startActivity(new Intent(Main2Activity.this,Main2Activity_3.class));
                break;
            case R.id.imageView4:
                startActivity(new Intent(Main2Activity.this,Main2Activity_4.class));
                break;
            case R.id.imageView5:
                startActivity(new Intent(Main2Activity.this,Main2Activity_5.class));
                break;
            case R.id.imageView6:
                startActivity(new Intent(Main2Activity.this,Main2Activity_6.class));
                break;
            case R.id.imageView7:
                startActivity(new Intent(Main2Activity.this,Main2Activity_7.class));
                break;
            case R.id.imageView8:
                startActivity(new Intent(Main2Activity.this,Main2Activity_8.class));
                break;
            case R.id.imageView9:
                startActivity(new Intent(Main2Activity.this,Main2Activity_9.class));
                break;
        }
    }
}
