package com.example.quizstudio.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizstudio.R;
import com.example.quizstudio.activities.QuizShowing;
import com.example.quizstudio.models.subjectModel;

import java.util.ArrayList;

public class LifeStyleAdapter extends RecyclerView.Adapter<LifeStyleAdapter.bookViewHolder> {
    Context context;
    ArrayList<subjectModel> subjectModelArrayList;

    public LifeStyleAdapter(Context context, ArrayList<subjectModel> subjectModelArrayList) {
        this.context = context;
        this.subjectModelArrayList = subjectModelArrayList;
    }

    @NonNull
    @Override
    public LifeStyleAdapter.bookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.carditem_listlayout,viewGroup,false);
        return new bookViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull bookViewHolder bookViewholder, final int position) {
        bookViewholder.subjectName.setText(subjectModelArrayList.get(position).getSubjectName());
        bookViewholder.subjectDiscription.setText(subjectModelArrayList.get(position).getSubjectdiscription());
        bookViewholder.subjectImage.setImageResource(subjectModelArrayList.get(position).getSubjectImage());
        bookViewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, QuizShowing.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("type","" + subjectModelArrayList.get(position).getSubjectName());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return subjectModelArrayList.size();
    }

    public class bookViewHolder extends RecyclerView.ViewHolder{
        TextView subjectName;
        ImageView subjectImage;
        TextView subjectDiscription;

        public bookViewHolder(View itemView) {
            super(itemView);
            subjectName=(TextView) itemView.findViewById(R.id.subject_name);
            subjectImage=(ImageView) itemView.findViewById(R.id.subject_image);
            subjectDiscription=(TextView) itemView.findViewById(R.id.subject_disc);


        }
    }
}