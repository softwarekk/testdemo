package com.anshunfeng.firstmodule.adapter;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anshunfeng.firstmodule.bean.NewsData;
import com.anshunfeng.young.firstmoudle.R;
import com.anshunfeng.young.firstmoudle.databinding.TestItemLayoutBinding;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by ${Young} on 2018/12/16.
 */

public class TestAdaper extends RecyclerView.Adapter<TestAdaper.TesViewHolder> {

    List<NewsData.DataBean> testList;
    @Override
    public TesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TestItemLayoutBinding itemBinding=DataBindingUtil
                  .inflate(LayoutInflater.from(parent.getContext()), R.layout.test_item_layout,
                            parent, false);

        return new TesViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(TesViewHolder holder, int position) {
        holder.itemLayoutBinding.setTestItem(testList.get(position));
        holder.itemLayoutBinding.executePendingBindings();
    }
    @Override
    public int getItemCount() {
        return testList == null ? 0 : testList.size();
    }
    class TesViewHolder extends RecyclerView.ViewHolder{
        TestItemLayoutBinding itemLayoutBinding;
        public TesViewHolder(TestItemLayoutBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemLayoutBinding = itemBinding;
        }
    }

    public void setTestList(final List<NewsData.DataBean> list){
        if(testList == null){
            testList = list;
            notifyItemRangeInserted(0, testList.size());
        }else {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return testList.size();
                }

                @Override
                public int getNewListSize() {
                    return list.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    NewsData.DataBean oldData = testList.get(oldItemPosition);
                    NewsData.DataBean newData = list.get(newItemPosition);
                    return oldData.getId() == newData.getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    NewsData.DataBean oldData = testList.get(oldItemPosition);
                    NewsData.DataBean newData = list.get(newItemPosition);
                    return oldData.getId() == newData.getId()
                              && oldData.getName() == newData.getName()
                              && oldData.getChildren() == newData.getChildren()
                              && oldData.getOrder() == newData.getOrder()
                              && oldData.getCourseId() == newData.getCourseId();
                }
            });
            testList = list;
            diffResult.dispatchUpdatesTo(this);
        }
    }
    @BindingAdapter("image")
    public static void loadImage(SimpleDraweeView image, String uri){
        if(image!=null){
            image.setImageURI(uri);
        }
    }
}
