package test.bwie.com.date20170512;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        //设置布局管理器，默认item方向为垂直
        recyclerview.setLayoutManager(manager);
        //创建适配器

        final ArrayList<Bean> list_b = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            String name = "条目：" + (1 + i);
            list_b.add(new Bean(name, false));
        }

        final MyRecyclerAdapter adapter = new MyRecyclerAdapter(this, list_b);
        //设置适配器
        recyclerview.setAdapter(adapter);
        Button quanxuan = (Button) findViewById(R.id.quanxuan);
        Button quanbuxuan = (Button) findViewById(R.id.quanbuxuan);
        Button fanxuan = (Button) findViewById(R.id.fanxuan);

        quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < list_b.size(); i++) {
                    list_b.get(i).setCheck(true);
                }
                adapter.notifyDataSetChanged();
            }
        });
        quanbuxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < list_b.size(); i++) {
                    list_b.get(i).setCheck(false);
                }
                adapter.notifyDataSetChanged();
            }
        });
        fanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < list_b.size(); i++) {
                    boolean check = list_b.get(i).isCheck();
                    list_b.get(i).setCheck(!check);
                }
                adapter.notifyDataSetChanged();
            }
        });
        recyclerview.addItemDecoration(new RecycleViewDivider(this,
                LinearLayoutManager.VERTICAL, 30, getResources()
                .getColor(R.color.colorPrimaryDark)));

    }
}
