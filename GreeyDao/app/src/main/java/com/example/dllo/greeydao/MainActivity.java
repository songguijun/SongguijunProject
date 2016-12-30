package com.example.dllo.greeydao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private Button One ,Two ,Three,Four;
    private PersonDao personDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        One = (Button) findViewById(R.id.btn_one);
        Two = (Button) findViewById(R.id.btn_two);
        Three = (Button) findViewById(R.id.btn_three);
        Four = (Button) findViewById(R.id.btn_four);
        One.setOnClickListener(this);
        Two.setOnClickListener(this);
        Three.setOnClickListener(this);
        Four.setOnClickListener(this);
        //各种初始化操作
        //helper 类的初始化操作
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"MyFile.db",null);
        DaoMaster master = new DaoMaster(helper.getWritableDb());
        //session 初始化
        DaoSession session = master.newSession();
        //personDao 初始化
        //这个对象就是具体数据库
        personDao = session.getPersonDao();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_one:
                for (int i = 0; i < 30; i++) {
                    Person person = new Person(null,"阿君","男",15+i);
                    personDao.insert(person);
                }
                break;
            case R.id.btn_two:
                Person deletePerson = personDao.queryBuilder().where(PersonDao.Properties.Age.eq(18)).build().unique();
                if (deletePerson != null){
                    //通过 找到这个person 的id 然后进行删除操作
                  //  personDao.deleteByKey(deletePerson.getId());
                    personDao.delete(deletePerson);
                  //  personDao.deleteAll();
                }

                break;
            case R.id.btn_three:
                  Person updatePerson = personDao.queryBuilder().where(PersonDao.Properties.Age.eq(15  )).build().unique();
                if (updatePerson != null){
                    updatePerson.setName("贵君");
                    personDao.update(updatePerson);
                }
                break;
            case R.id.btn_four:
                List<Person> list = personDao.loadAll();
                for (Person person : list) {
                    Log.d("MainActivity", person.getName()+" "+person.getSex()+" "+ person.getAge());
                }
                break;
        }
    }
}
