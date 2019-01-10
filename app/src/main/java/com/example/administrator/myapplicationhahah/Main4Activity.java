package com.example.administrator.myapplicationhahah;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class Main4Activity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main4);
//    }
//}

//package com.example.scien;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;

//import com.example.scien.R;


public class Main4Activity extends Activity implements OnClickListener {
    static int ERROR = -1;
    public static double pi = Math.PI;
    public static double e = Math.E;

    String[] opSet = { "+", "-", "X", "/", "^2", "√", "!", "mod", "=" ,"sin","cos","tan","log","ln","^"};
    int[] btnIdSet = { R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnsin, R.id.btncos, R.id.btntan,
            R.id.btnlog, R.id.btnln, R.id.btnexp, R.id.btnAdd, R.id.btnMinus, R.id.btnMultiply,
            R.id.btnDivide, R.id.btnEqual, R.id.btnsquare, R.id.btnsqrt, R.id.btnfact, R.id.btnMod,
            R.id.btncancel,R.id.btndot
    };

    EditText input;
    Button[] btnSet = new Button[btnIdSet.length];

    int op = -1;
    int N = 10;

    double leftNum = 0;
    double rightNum = 0;
    double res = 0;

    boolean clearFlag = false;

    String tmp = new String();
    String exp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        for (int i = 0; i < btnIdSet.length; i++) {
            btnSet[i] = (Button)findViewById(btnIdSet[i]);
            btnSet[i].setOnClickListener(this);
        }

        input = (EditText)findViewById(R.id.input);

        findViewById(R.id.textViewSwitch1).setOnClickListener(this);
        findViewById(R.id.textViewSwitch2).setOnClickListener(this);
        findViewById(R.id.textViewSwitch3).setOnClickListener(this);
        findViewById(R.id.textViewSwitch4).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        exp = input.getText().toString();

        switch (v.getId()) {

            case R.id.textViewSwitch1:
                Intent intent=new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setClass(Main4Activity.this,MainActivity.class);
                startActivity(intent);

                break;
            case R.id.textViewSwitch2:
                Intent intent2=new Intent();
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                intent2.setClass(Main4Activity.this,Main2Activity.class);
                startActivity(intent2);

                break;
            case R.id.textViewSwitch3:
                Intent intent3=new Intent();
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                intent3.setClass(Main4Activity.this,Main4Activity.class);
                startActivity(intent3);

                break;

            case R.id.textViewSwitch4:
                Toast.makeText(Main4Activity.this, "就在科学计算界面哦",
                        Toast.LENGTH_SHORT).show();

                break;



            case R.id.btn0:
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
            case R.id.btndot:
                tmp += ((Button)v).getText().toString();
                exp += ((Button)v).getText().toString();
                break;
            case R.id.btnAdd:
                processOperator(0);
                break;
            case R.id.btnMinus:
                processOperator(1);
                break;
            case R.id.btnMultiply:
                processOperator(2);
                break;
            case R.id.btnDivide:
                processOperator(3);
                break;
            case R.id.btnsquare:
                processOperator2(4);
                break;
            case R.id.btnsqrt:
                processOperator2(5);
                break;
            case R.id.btnfact:
                processOperator2(6);
                break;
            case R.id.btnMod:
                processOperator(7);
                break;
            case R.id.btnEqual:
                processOperator(8);
                break;
            case R.id.btnsin:
                processOperator2(9);
                break;
            case R.id.btncos:
                processOperator2(10);
                break;
            case R.id.btntan:
                processOperator2(11);
                break;
            case R.id.btnlog:
                processOperator2(12);
                break;
            case R.id.btnln:
                processOperator2(13);
                break;
            case R.id.btnexp:
                processOperator(14);
                break;
            case R.id.btncancel:
                leftNum = 0;
                rightNum = 0;
                tmp = "";
                exp = "";
                res = 0;
                op = -1;

        }

        input.setText(exp.toString());
    }

    private void processOperator2(int i) {
        if (leftNum == 0) {
            leftNum = Double.parseDouble(tmp);
            tmp = "";
        }

        leftNum = calculate(i);
        exp = String.valueOf(leftNum);
        op = -1;
    }

    private void processOperator(int i) {
        exp = input.getText().toString();
        if (leftNum == 0){
            leftNum = Double.parseDouble(tmp);
            tmp = "";
        }
        else{
            if (!tmp.equals("")) {
                rightNum = Double.parseDouble(tmp);
                tmp = "";
            } else {
                op = i;
                exp += opSet[i];
                return;
            }

        }

	/*	if (leftNum == 0) {
			leftNum = nBaseToDecimal(tmp, N);
			tmp = "";
		} else {
			rightNum = nBaseToDecimal(tmp, N);
			tmp = "";
		}
	*/
        if (i == 8) {
            if (leftNum != 0 && rightNum != 0) {
                res = calculate(op);
                exp = String.valueOf(res);
                leftNum = res;
                rightNum = 0;
                tmp = "";
                op = -1;
                return;
            }
        }
        else if (op == -1) {
            exp += opSet[i];
        } else {
            if (rightNum == 0) {
                exp = exp.substring(0, exp.length() - 1) + opSet[i];
            } else {
                System.out.println(leftNum);
                System.out.println(rightNum);
                res = calculate(op);
                exp = String.valueOf(res);
                exp += opSet[i];
                leftNum = res;
                rightNum = 0;
                tmp = "";
            }
        }
        op = i;
    }

    private double calculate(int op) {
        switch (op) {
            case 0:
                return leftNum + rightNum;
            case 1:
                return leftNum - rightNum;
            case 2:
                return leftNum * rightNum;
            case 3:
                return leftNum / rightNum;
            case 4:
                return square(leftNum);
            case 5:
                return sqrt(leftNum);
            case 6:
                return factorial(leftNum);
            case 7:
                return mod(leftNum,rightNum);
            case 9:
                return trigonometric(leftNum,"sin");
            case 10:
                return trigonometric(leftNum,"cos");
            case 11:
                return trigonometric(leftNum,"tan");
            case 12:
                return log(leftNum,false);
            case 13:
                return log(leftNum,true);
            case 14:
                return exponential(leftNum,rightNum);

        }

        return 0;
    }

    public static int nBaseToDecimal(String str, int N) {
        int num = 0;
        int r = 1;

        int t = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            t = charToInt(str.charAt(i));
            if (t >= N) {
                return ERROR;
            }
            num += r * charToInt(str.charAt(i));
            r = r * N;
        }

        return num;
    }

    public static String decimalToNBase(int num, int N) {
        Stack<Character> stack = new Stack<Character>();
        String nBaseNum = new String();

        while (num != 0) {
            stack.push(numToChar(num % N, N));
            num /= N;
        }

        while (!stack.isEmpty()) {
            nBaseNum += stack.pop();
        }
        return nBaseNum;
    }

    private static Character numToChar(int num, int N) {
        char c = ' ';
        if (num < 10) {
            c = String.valueOf(num).charAt(0);
        } else {
            switch (num) {
                case 10:
                    c = 'A';
                    break;
                case 11:
                    c = 'B';
                    break;
                case 12:
                    c = 'C';
                    break;
                case 13:
                    c = 'D';
                    break;
                case 14:
                    c = 'E';
                    break;
                case 15:
                    c = 'F';
                    break;
                default:
                    c = ' ';
                    break;
            }
        }
        return c;
    }

    private static int charToInt(char c) {
        try {
            return Integer.parseInt(String.valueOf(c));
        } catch (Exception e) {
            switch (c) {
                case 'A':
                    return 10;
                case 'B':
                    return 11;
                case 'C':
                    return 12;
                case 'D':
                    return 13;
                case 'E':
                    return 14;
                default:
                    return 0;
            }
        }
    }

    public static double square(double squ){
        double square = Math.pow(squ, 2);
        return square;
    }

    public static double sqrt(double sqr){
        double sqrt = 0;
        sqrt = Math.sqrt(sqr);
        return sqrt;
    }

    public static double n_sqrt(double sqr,int x){
        double n_sqrt = 0;
        double x1 = 1/x;
        n_sqrt = Math.pow(sqr,x1);
        return n_sqrt;
    }

    public static double log(double log,boolean ln){
        double log_10 = 0;
        double log_e = 0;
        if (log <= 0){
            System.out.println("输入非法");
        }
        else{
            log_10 = Math.log10(log);
            log_e = Math.log(log);
        }
        if (!ln){
            return log_10;}
        else{
            return log_e;
        }
    }

    public static double exponential(double x,double y){
        double exp = Math.pow(x, y);
        return exp;
    }

    public static double exp_(double x,String mode){
        double exp_ = 0;
        if (mode == "10"){
            exp_ = Math.pow(10, x);
        }
        else if (mode == "e"){
            exp_ = Math.pow(e, x);
        }
        return exp_;
    }

    public static double trigonometric(double x,String mode){
        double y = 0;
        if (mode == "sin"){
            y = Math.sin(x);
        }
        else if (mode == "cos"){
            y = Math.cos(x)	;
        }
        else if (mode == "tan"){
            if(((x/90)%2)!=0){
                System.out.println("输入非法");
            }
            else{
                y = Math.tan(x);
            }
        }
        else if (mode == "sinh"){
            y = Math.sinh(x);
        }
        else if (mode == "cosh"){
            y = Math.cosh(x);
        }
        else if (mode == "tanh"){
            y = Math.tanh(x);
        }
        return y;
    }

    public static double mod(double x,double y){
        double mod = x%y;
        return mod;
    }

    public static long factorial(double x){
        int num = (int)Math.floor(x);
        long fac = 1;
        for(int i = 1;i <= num; i++){
            fac *= i;
        }
        return fac;
    }

    public static double pi(){
        return pi;
    }

    public static double nature(){
        return e;
    }



}

