package com.example.administrator.myapplicationhahah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0,b00, bp, bs, bm, bd, bc, be,delete;
    TextView tvShow;
    EditText show;
    String showString = "";
    String option = "";
    String tvTemp="";
    int showfirst = 0;
    String exception = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.textViewSwitch1).setOnClickListener(this);
        findViewById(R.id.textViewSwitch2).setOnClickListener(this);
        findViewById(R.id.textViewSwitch3).setOnClickListener(this);
        findViewById(R.id.textViewSwitch4).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        b00 = (Button) findViewById(R.id.bt_00);
        b0 = (Button) findViewById(R.id.bt_0);
        b1 = (Button) findViewById(R.id.bt_1);
        b2 = (Button) findViewById(R.id.bt_2);
        b3 = (Button) findViewById(R.id.bt_3);
        b4 = (Button) findViewById(R.id.bt_4);
        b5 = (Button) findViewById(R.id.bt_5);
        b6 = (Button) findViewById(R.id.bt_6);
        b7 = (Button) findViewById(R.id.bt_7);
        b8 = (Button) findViewById(R.id.bt_8);
        b9 = (Button) findViewById(R.id.bt_9);
        bp = (Button) findViewById(R.id.bt_plus);
        bs = (Button) findViewById(R.id.bt_sub);
        bm = (Button) findViewById(R.id.bt_mutilate);
        bd = (Button) findViewById(R.id.bt_div);
        bc = (Button) findViewById(R.id.bt_c);
        be = (Button) findViewById(R.id.bt_equ);
        delete = (Button) findViewById(R.id.iv_delete);
        show = (EditText) findViewById(R.id.editText);
        tvShow = (TextView) findViewById(R.id.tvShow);
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
        b00.setOnClickListener(this);
        bp.setOnClickListener(this);
        bs.setOnClickListener(this);
        bm.setOnClickListener(this);
        bd.setOnClickListener(this);
        bc.setOnClickListener(this);
        be.setOnClickListener(this);
        delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textViewSwitch1:
                Toast.makeText(MainActivity.this, "就在计算界面哦",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.textViewSwitch2:
                Intent intent=new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setClass(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.textViewSwitch3:
                Intent intent2=new Intent();
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                intent2.setClass(MainActivity.this,Main3Activity.class);
                startActivity(intent2);

                break;

            case R.id.textViewSwitch4:
                Intent intent3=new Intent();
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                intent3.setClass(MainActivity.this,Main4Activity.class);
                startActivity(intent3);

                break;
            case R.id.button4:
                startActivity(new Intent(MainActivity.this,MainActivity_help.class));
                break;
            case R.id.bt_00:
                showString += "00";
                break;
                case R.id.bt_0:
                    showString += "0";
                    break;
                case R.id.bt_1:
                    showString += "1";
                    break;
                case R.id.bt_2:
                    showString += "2";
                    break;
                case R.id.bt_3:
                    showString += "3";
                    break;
                case R.id.bt_4:
                    showString += "4";
                    break;
                case R.id.bt_5:
                    showString += "5";
                    break;
                case R.id.bt_6:
                    showString += "6";
                    break;
                case R.id.bt_7:
                    showString += "7";
                    break;
                case R.id.bt_8:
                    showString += "8";
                    break;
                case R.id.bt_9:
                    showString += "9";
                    break;
                case R.id.bt_plus:
                    if (showString.equals(""))
                        exception = "请输入数值";
                    else {
                        showfirst = Integer.parseInt(showString);
                        tvTemp =showString+ "+";
                        tvShow.setText(tvTemp);
                        showString = "";
                        option = "+";
                    }
                    break;
                case R.id.bt_sub:
                    if (showString.equals(""))
                        exception = "请输入数值";
                    else {
                        showfirst = Integer.parseInt(showString);
                        tvTemp =showString+"-";
                        tvShow.setText(tvTemp);
                        showString = "";
                        option = "-";
                    }
                    break;
                case R.id.bt_mutilate:
                    if (showString.equals(""))
                        exception = "请输入数值";
                    else {
                        showfirst = Integer.parseInt(showString);
                        tvTemp = showString+"*";
                        tvShow.setText(tvTemp);
                        showString = "";
                        option = "*";
                    }
                    break;
                case R.id.bt_div:
                    if (showString.equals(""))
                        exception = "请输入数值";
                    else {
                        showfirst = Integer.parseInt(showString);
                        tvTemp = showString+"/";
                        tvShow.setText(tvTemp);
                        showString = "";
                        option = "/";
                    }
                    break;
                case R.id.bt_equ:
                    tvTemp = tvTemp+showString+"=";
                    tvShow.setText(tvTemp);
                    if (option.equals("+"))
                        showString = showfirst + Integer.parseInt(showString) + "";
                    else if (option.equals("-")) {
                        showString = showfirst - Integer.parseInt(showString) + "";
                    } else if (option.equals("*")) {
                        showString = showfirst * Integer.parseInt(showString) + "";
                    } else if (option.equals("/")) {
                        if (showString.equals("0")) {
                            exception = "除数不能为0！";
                        } else
                            showString = showfirst / Integer.parseInt(showString) + "";
                    }
                    break;
                case R.id.bt_c:
                    showString = "";
                    break;
            case R.id.iv_delete:
                Toast.makeText(MainActivity.this, showString + "已被清空",
                        Toast.LENGTH_SHORT).show();
                showString = "";
                tvTemp="";
                break;

            default:
                    break;

            }
        if (exception.equals("")) {
            show.setText(showString);
        }else {
            show.setText(exception);
            exception = "";
        }
    }
}
