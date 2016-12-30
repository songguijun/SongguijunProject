package com.example.dllo.evevtbusdome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by dllo on 16/12/1.
 */

public class SecondActivity extends AppCompatActivity {
    private Button btn_second;
    private EditText et_second;
    private EventBus eventBus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn_second = (Button) findViewById(R.id.btn_second);
        et_second = (EditText) findViewById(R.id.et_second);
        eventBus = EventBus.getDefault();
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = et_second.getText().toString();
                Bean bean = new Bean();
                bean.setData(data);
                eventBus.post(bean);
                finish();

            }
        });
    }
}
