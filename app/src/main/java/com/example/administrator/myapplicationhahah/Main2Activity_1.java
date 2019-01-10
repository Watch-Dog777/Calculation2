package com.example.administrator.myapplicationhahah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity_1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0,bp,bpp;
    EditText editTextMain,editText1_1,editText1_2;
    double ChinaInt = 0;
    double   AmeriInt = 0;
    double Chinafloat = 0;
    double Amerfloat=0;
    String cityName;
    int tempa;
    private Spinner spDown;
    private List<String> list;
    private ArrayAdapter<String> adapter;
    String showString = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_1);


        b0 = (Button) findViewById(R.id.button1_0);
        b1 = (Button) findViewById(R.id.button1_1);
        b2 = (Button) findViewById(R.id.button1_2);
        b3 = (Button) findViewById(R.id.button1_3);
        b4 = (Button) findViewById(R.id.button1_4);
        b5 = (Button) findViewById(R.id.button1_5);
        b6 = (Button) findViewById(R.id.button1_6);
        b7 = (Button) findViewById(R.id.button1_7);
        b8 = (Button) findViewById(R.id.button1_8);
        b9 = (Button) findViewById(R.id.button1_9);
        bp = (Button) findViewById(R.id.button1_p);
        bpp = (Button) findViewById(R.id.button1_pp);
        editTextMain = (EditText) findViewById(R.id.editText1_2);
        editText1_1 = (EditText) findViewById(R.id.editText1_3);
        editText1_2 = (EditText) findViewById(R.id.editText1_4);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bp.setOnClickListener(this);
        bpp.setOnClickListener(this);

        spDown=(Spinner) findViewById(R.id.spinner_1_1);

        /*设置数据源*/
        list=new ArrayList<String>();
        list.add("人民币");
        list.add("美元");
        list.add("欧元");
        list.add("日元");
        list.add("韩元");
        list.add("英镑");
        list.add("泰铢");
        list.add("新台币");

        /*新建适配器*/
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);

        /*adapter设置一个下拉列表样式，参数为系统子布局*/
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        /*spDown加载适配器*/
        spDown.setAdapter(adapter);

        /*soDown的监听器*/
        spDown.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       cityName=adapter.getItem(position);   //获取选中的那一项
        whereis(position);
    }

        public void whereis(int position){
            switch (position){
                case 0:
                    Chinafloat = 1;
                    Amerfloat = 0.1474;
                    break;
                case 1:
                    Chinafloat = 6.7824;
                    Amerfloat = 1;
                    break;
                case 2:
                    Chinafloat = 7.825;
                    Amerfloat = 1.1528;
                    break;
                case 3:
                    Chinafloat = 0.0628;
                    Amerfloat = 0.0092;
                    break;
                case 4:
                    Chinafloat = 0.0061;
                    Amerfloat = 0.0009;
                    break;
                case 5:
                    Chinafloat = 8.6587;
                    Amerfloat = 1.2751;
                    break;
                case 6:
                    Chinafloat = 0.2126;
                    Amerfloat = 0.0313;
                    break;
                case 7:
                    Chinafloat = 0.2203;
                    Amerfloat = 0.0325;
                    break;
                default:
                    break;

            }
        }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1_0:
                showString += "0";
                break;
            case R.id.button1_1:
                showString += "1";
                break;
            case R.id.button1_2:
                showString += "2";
                break;
            case R.id.button1_3:
                showString += "3";
                break;
            case R.id.button1_4:
                showString += "4";
                break;
            case R.id.button1_5:
                showString += "5";
                break;
            case R.id.button1_6:
                showString += "6";
                break;
            case R.id.button1_7:
                showString += "7";
                break;
            case R.id.button1_8:
                showString += "8";
                break;
            case R.id.button1_9:
                showString += "9";
                break;
            case R.id.button1_p:
                tempa = Integer.parseInt(showString) /10;
                showString = Integer.toString(tempa);
                break;
            case R.id.button1_pp:
                showString = "";
                break;
            default:
                break;
        }

        if (showString.equals("")) {
            editTextMain.setText(showString);
            editText1_1.setText(showString);
            editText1_2.setText(showString);
        }
        else{
            editTextMain.setText(showString);
            ChinaInt = Integer.parseInt(showString)* Chinafloat;
            AmeriInt = Integer.parseInt(showString)* Amerfloat;
            editText1_1.setText(Double.toString(ChinaInt));
            editText1_2.setText(Double.toString(AmeriInt));
        }

    }
}
