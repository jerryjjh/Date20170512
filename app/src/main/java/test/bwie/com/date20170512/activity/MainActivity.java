package test.bwie.com.date20170512.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Request;
import test.bwie.com.date20170512.R;
import test.bwie.com.date20170512.bean.DataBean;
import test.bwie.com.date20170512.bean.Goods;
import test.bwie.com.date20170512.utils.OkHttpManager;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerview;
    private ArrayList<DataBean> datas = new ArrayList<>();
    private MyRecyclerAdapter adapter;
    private ArrayList<DataBean> list_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = (RecyclerView) findViewById(R.id.recycler_view);

        getData();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        //设置布局管理器，默认item方向为垂直
        recyclerview.setLayoutManager(manager);
        //创建适配器

        list_c = new ArrayList<>();


        //设置适配器

        Button quanxuan = (Button) findViewById(R.id.quanxuan);
        Button quanbuxuan = (Button) findViewById(R.id.quanbuxuan);
        Button fanxuan = (Button) findViewById(R.id.fanxuan);
        Button queding = (Button) findViewById(R.id.queding);

        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Second.class);
                list_c.clear();
                for (int i = 0; i < datas.size(); i++) {
                    if (datas.get(i).isCheck()) {
                        list_c.add(datas.get(i));
                    }
                }
                intent.putParcelableArrayListExtra("list",list_c );
                startActivity(intent);


            }
        });
        quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < datas.size(); i++) {
                    datas.get(i).setCheck(true);
                }
                adapter.notifyDataSetChanged();
            }
        });
        quanbuxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < datas.size(); i++) {
                    datas.get(i).setCheck(false);
                }
                adapter.notifyDataSetChanged();
            }
        });
        fanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < datas.size(); i++) {
                    boolean check = datas.get(i).isCheck();
                    datas.get(i).setCheck(!check);
                }
                adapter.notifyDataSetChanged();
            }
        });
        recyclerview.addItemDecoration(new RecycleViewDivider(
                this, LinearLayoutManager.HORIZONTAL, R.drawable.devider));
        // recyclerview.startDrag(MyRecyclerAdapter.MyViewHolder);
    }

    private void getData() {

        String url = "http://m.yunifang.com/yunifang/mobile/goods/getall?random=39986&encode=2092d7eb33e8ea0a7a2113f2d9886c90&category_id=17";
        OkHttpManager.getAsync(url, new OkHttpManager.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {

                Gson gson = new Gson();
                Goods goods = gson.fromJson(result, Goods.class);
                datas = (ArrayList<DataBean>) goods.getData();
                Log.d("sss", datas.size() + "");
                adapter = new MyRecyclerAdapter(getApplicationContext(), datas);
                recyclerview.setAdapter(adapter);
            }
        });

    }
}
