package test.bwie.com.date20170512;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/12
 */

public class Second extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);
        Intent intent = getIntent();
        ArrayList<String> list = intent.getStringArrayListExtra("list");
        TextView textview = (TextView) findViewById(R.id.text);
        textview.setText(list.toString());


    }
}
