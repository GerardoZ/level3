package com.codecube.level3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codecube.level3.R;
import com.codecube.level3.model.User;

import java.util.List;

public class UsersAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<User> users;

    public UsersAdapter(Context context, int layout, List<User> users) {
        this.context = context;
        this.layout = layout;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textViewName);
            holder.gender = (TextView) convertView.findViewById(R.id.textViewGender);
            holder.age = (TextView) convertView.findViewById(R.id.textViewAge);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.name.setText(this.users.get(position).getFirstname() + " " + this.users.get(position).getLastname());
        holder.gender.setText(this.users.get(position).getGender());
        holder.age.setText(String.valueOf(this.users.get(position).getAge()));
        return convertView;
    }

    static class ViewHolder{
        private TextView name;
        private TextView gender;
        private TextView age;
    }
}
