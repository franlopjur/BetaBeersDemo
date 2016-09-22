package com.franlopez.betabeersdemo.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.franlopez.betabeersdemo.common.CustomApplication;
import com.franlopez.betabeersdemo.ModelAndroidVersion;
import com.franlopez.betabeersdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<ModelAndroidVersion> mDataset = new ArrayList<>();
    private CustomItemClickListener mCustomItemClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTVName, mTVVersionCode, mTVAPIVersion;
        public CardView mCVContainer;
        public ImageView mIVImage;

        public ViewHolder(View v) {
            super(v);
            mTVName = (TextView) itemView.findViewById(R.id.list_item__name);
            mTVVersionCode = (TextView) itemView.findViewById(R.id.list_item__version_code);
            mTVAPIVersion = (TextView) itemView.findViewById(R.id.list_item__api_version);
            mCVContainer = (CardView) itemView.findViewById(R.id.list_item__card);
            mIVImage = (ImageView) itemView.findViewById(R.id.list_item__image);
        }
    }

    public interface CustomItemClickListener {
        void onItemClicked(ModelAndroidVersion itemClicked);
    }

    public CustomAdapter(List<ModelAndroidVersion> myDataset, CustomItemClickListener listener) {
        mDataset = myDataset;
        mCustomItemClickListener = listener;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.mTVName.setText(mDataset.get(position).getName());
        holder.mTVAPIVersion.setText(mDataset.get(position).getAPIVersion());
        holder.mTVVersionCode.setText(mDataset.get(position).getVersionCode());

        Picasso.with(CustomApplication.context).load(mDataset.get(position).getUrl()).into(holder.mIVImage);

        holder.mCVContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCustomItemClickListener != null)
                    mCustomItemClickListener.onItemClicked(mDataset.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}