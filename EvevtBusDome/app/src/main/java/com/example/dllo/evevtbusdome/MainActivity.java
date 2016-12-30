package com.example.dllo.evevtbusdome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_main;
    private EditText et_main;

    /**
     * 使用手册
     * 1.把我们想要传的值写到一个实体类中
     * 2.在传值的类中 对EventBus进行初始化 并切 调用 post方法进行传值
     * 3.在目标类(接受值得类中){
     *     1)注册EventBus(如果在Activity中注册,则写在onCreate生命周期中 如果在Fragment 我们写在onAttch()生命周期中)
     *
     *     2)注销EventBus(注销的方法必须和注册的生命周期相互对应,也就是说Activity 中写在 onDestory 中 Fragment中写在onDetach中)
     *     3)写一个方法用来接受值 方法上面加上注解 表明线程 一班都用main
     *     !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *     大忌
     *     目标类必须已经存在
     * }
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
//        et_main = (EditText) findViewById(R.id.et_main);
//        btn_main = (Button) findViewById(R.id.btn_main);
//       btn_main.setOnClickListener(this);
        //注册
        EventBus.getDefault().register(this);
    }
    //上面写的东西叫做注解
    //这一句代表在主线程中
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void  getData(Bean bean){
        et_main.setText(bean.getData());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除注册
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent  = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}
