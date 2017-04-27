package com.example.georgihristov.colleaguedatabase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;



public class ColleagueAdapter extends RecyclerView.Adapter<ColleagueAdapter.ListViewHolder> {


    private List<Colleague> colleagueList;

    public ColleagueAdapter(List<Colleague> colleagueList) {

        this.colleagueList = colleagueList;
    }
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.colleague_item,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        Colleague colleague = colleagueList.get(position);
        holder.nameTextView.setText(colleague.getColleagueName());
        holder.titleTextView.setText(colleague.getColleagueTitle());
        holder.phoneTextView.setText(colleague.getColleaguePhoneNumber());
        holder.skypeTextView.setText(colleague.getColleagueSkypeName());
        holder.emailTextView.setText(colleague.getColleagueEmailAddress());
        Picasso.with(holder.avatarImageView.getContext()).load(colleague.getColleaguePicture()).into(holder.avatarImageView);


    }

    @Override
    public int getItemCount() {
        return colleagueList.size();
    }
    public static class ListViewHolder extends RecyclerView.ViewHolder{

        public ImageView avatarImageView;
        public TextView nameTextView;
        public TextView titleTextView;
        public TextView phoneTextView;
        public TextView skypeTextView;
        public TextView emailTextView;


        ListViewHolder(View view) {
            super(view);
            avatarImageView = (ImageView)view.findViewById(R.id.avatarImageView);
            titleTextView = (TextView)view.findViewById(R.id.titleTextView);
            phoneTextView = (TextView)view.findViewById(R.id.phoneTextView);
            skypeTextView = (TextView)view.findViewById(R.id.skypeTextView);
            nameTextView = (TextView)view.findViewById(R.id.nameTextView);
            emailTextView = (TextView)view.findViewById(R.id.emailTextView);
        }
    }
}
