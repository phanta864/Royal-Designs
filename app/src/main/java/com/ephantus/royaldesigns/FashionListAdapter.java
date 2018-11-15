package com.ephantus.royaldesigns;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FashionListAdapter extends RecyclerView.Adapter<FashionListAdapter.FashionViewHolder> {
    private ArrayList<Fashion> mFashions= new ArrayList<>();
    public static final int MAX_WIDTH = 600;
    public static final int MAX_HEIGHT = 700;
    private Context mContext;

    public FashionListAdapter(Context context, ArrayList<Fashion> fashions){
        mContext = context;
        mFashions= fashions;
    }

    @Override
    public FashionListAdapter.FashionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.royal_list_item, viewGroup, false);
        FashionViewHolder viewHolder= new FashionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FashionListAdapter.FashionViewHolder holder, int position) {
        holder.bindFashion(mFashions.get(position));
    }

    @Override
    public int getItemCount() {
        return mFashions.size();
    }

    public class FashionViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fashionListTextView)TextView mTextView;
        @BindView(R.id.usernameTextView) TextView mUsername;
        @BindView(R.id.locationTextView) TextView mLocation;
        @BindView(R.id.imageView) ImageView mImageView;

        private Context mContext;

        public FashionViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
            mContext= view.getContext();
        }

        public void bindFashion(Fashion fashion){
            mTextView.setText("Description \n" + fashion.getmName());
            Picasso.get().load(fashion.getmImageUrl()).into(mImageView);
            mUsername.setText("Designer \n" + fashion.getmUsername());
            mLocation.setText("Located At \n" + fashion.getmLocation());
        }

    }
}
