package test.bwie.com.date20170512.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import test.bwie.com.date20170512.R;
import test.bwie.com.date20170512.bean.DataBean;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/12
 */

public class Second extends Activity {

    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);
        Intent intent = getIntent();
        ArrayList<DataBean> list = intent.getParcelableArrayListExtra("list");
        recycler = (RecyclerView) findViewById(R.id.recycler_view);
        //创建布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(this);
        //设置布局管理器，默认item方向为垂直
        recycler.setLayoutManager(manager);
        //创建适配器
        MyRecyclerAdapter2 adapter = new MyRecyclerAdapter2(this, list);
        //设置适配器
        recycler.setAdapter(adapter);


    }
}
