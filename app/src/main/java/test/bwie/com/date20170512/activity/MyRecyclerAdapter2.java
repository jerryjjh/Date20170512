package test.bwie.com.date20170512.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import test.bwie.com.date20170512.R;
import test.bwie.com.date20170512.bean.DataBean;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/12
 */

public class MyRecyclerAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {


    private MyViewHolder1 mViewHolder1;
    private MyViewHolder2 mViewHolder2;
    private MyViewHolder3 mViewHolder3;
    private MyViewHolder mViewHolder;

    @Override
    public int getItemViewType(int position) {
        int i = position % 3;
        return i;
    }

    Context context;
    ArrayList<DataBean> list;
    private OnItemClickListener mOnItemClickListener = null;

    public MyRecyclerAdapter2(Context context, ArrayList<DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
                viewHolder = new MyViewHolder1(view);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, null);
                viewHolder = new MyViewHolder2(view);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item3, null);
                viewHolder = new MyViewHolder3(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                mViewHolder1 = (MyViewHolder1) holder;
                Glide.with(context).load(list.get(position).getGoods_img()).into(mViewHolder1.image);
                mViewHolder1.textView.setText(list.get(position).getGoods_name());

                mViewHolder1.check.setChecked(list.get(position).isCheck());
                mViewHolder1.itemView.setTag(position);


                mViewHolder1.check.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean check = list.get(position).isCheck();
                        list.get(position).setCheck(!check);
                    }
                });

                break;
            case 1:
                mViewHolder2 = (MyViewHolder2) holder;
                Glide.with(context).load(list.get(position).getGoods_img()).into(mViewHolder2.image2_1);
                Glide.with(context).load(list.get(position).getGoods_img()).into(mViewHolder2.image2_2);
                ((MyViewHolder2) holder).textView2.setText(list.get(position).getGoods_name());

                ((MyViewHolder2) holder).check.setChecked(list.get(position).isCheck());
                holder.itemView.setTag(position);


                ((MyViewHolder2) holder).check.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean check = list.get(position).isCheck();
                        list.get(position).setCheck(!check);
                    }
                });
                break;
            case 2:
                mViewHolder3 = (MyViewHolder3) holder;
                Glide.with(context).load(list.get(position).getGoods_img()).into(mViewHolder3.image3);
                mViewHolder3.textView3.setText(list.get(position).getGoods_name());

                mViewHolder3.check.setChecked(list.get(position).isCheck());
                mViewHolder3.itemView.setTag(position);


                mViewHolder3.check.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean check = list.get(position).isCheck();
                        list.get(position).setCheck(!check);
                    }
                });
                break;

        }


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


        public MyViewHolder(View itemView) {
            super(itemView);

        }


    }


    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        TextView textView;
        CheckBox check;
        ImageView image;

        public MyViewHolder1(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.item_text);
            check = (CheckBox) itemView.findViewById(R.id.item_check);
            image = (ImageView) itemView.findViewById(R.id.item_image);
        }


    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView textView2;
        CheckBox check;
        ImageView image2_1;
        ImageView image2_2;

        public MyViewHolder2(View itemView) {
            super(itemView);

            textView2 = (TextView) itemView.findViewById(R.id.item2_text);
            check = (CheckBox) itemView.findViewById(R.id.item_check);
            image2_1 = (ImageView) itemView.findViewById(R.id.item2_image1);
            image2_2 = (ImageView) itemView.findViewById(R.id.item2_image2);
        }


    }

    public class MyViewHolder3 extends RecyclerView.ViewHolder {
        TextView textView3;
        CheckBox check;
        ImageView image3;

        public MyViewHolder3(View itemView) {
            super(itemView);

            textView3 = (TextView) itemView.findViewById(R.id.item3_text);
            check = (CheckBox) itemView.findViewById(R.id.item_check);
            image3 = (ImageView) itemView.findViewById(R.id.item3_image);
        }


    }

    public void SetOnItemClickListener(OnItemClickListener listener) {

        this.mOnItemClickListener = listener;

    }

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
