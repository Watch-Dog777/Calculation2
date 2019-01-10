package com.example.administrator.myapplicationhahah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

import static java.lang.String.*;

public class MainActivity_help extends AppCompatActivity implements View.OnClickListener {
    private WebView wvbrower;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_help);
        edit = (EditText) findViewById(R.id.editText_brower);
        wvbrower= (WebView) findViewById(R.id.wvbrower);
        wvbrower.loadUrl("http://ab126.com/");
        findViewById(R.id.btn_brower).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_brower:
                wvbrower.loadUrl(valueOf(edit.getText()));
                break;
        }
    }
}
