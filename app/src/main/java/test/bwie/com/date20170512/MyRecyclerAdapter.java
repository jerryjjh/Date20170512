package test.bwie.com.date20170512;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/12
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> implements View.OnClickListener {

    Context context;
    ArrayList<Bean> list;
    private OnItemClickListener mOnItemClickListener = null;

    public MyRecyclerAdapter(Context context, ArrayList<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.textView.setText(list.get(position).getName());
        boolean check = list.get(position).isCheck();
        holder.check.setChecked(check);
        holder.itemView.setTag(position);

        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = list.get(position).isCheck();
                list.get(position).setCheck(!check);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(view, (int) view.getTag());
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CheckBox check;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_text);
            check = (CheckBox) itemView.findViewById(R.id.item_check);
        }


    }

    public void SetOnItemClickListener(OnItemClickListener listener) {

        this.mOnItemClickListener = listener;

    }

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
