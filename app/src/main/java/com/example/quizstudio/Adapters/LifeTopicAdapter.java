package com.example.quizstudio.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizstudio.R;
import com.example.quizstudio.activities.QuestionWithoutImageActivity;
import com.example.quizstudio.models.itemModel;

import java.util.ArrayList;

public class LifeTopicAdapter extends RecyclerView.Adapter<LifeTopicAdapter.viewHolder> {
    Context context;
    ArrayList<itemModel> itemModelArrayList;

    public LifeTopicAdapter(Context context, ArrayList<itemModel> itemModelArrayList) {
        this.context = context;
        this.itemModelArrayList = itemModelArrayList;
    }


    @NonNull
    @Override
    public LifeTopicAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.itemlist,viewGroup,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LifeTopicAdapter.viewHolder viewHolder, final int position) {
        viewHolder.iconName.setText(itemModelArrayList.get(position).getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, QuestionWithoutImageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("type","" + itemModelArrayList.get(position).getName());
                
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemModelArrayList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView iconName;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            iconName = (TextView) itemView.findViewById(R.id.icon_name);
        }
    }
}
