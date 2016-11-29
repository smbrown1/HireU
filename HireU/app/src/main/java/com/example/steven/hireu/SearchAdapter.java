package com.example.steven.hireu;

/**
 * Created by Steven on 4/5/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.steven.hireu.Model.Tutor;
import com.example.steven.hireu.Model.UserManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private ArrayList<Tutor> tutorSet;
    private Context context;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        Tutor tutor;
        Context context;
        TextView person;
        TextView major;
        public ViewHolder(View v) {
            super(v);
            person = (TextView)v.findViewById(R.id.searchText);
            major = (TextView)v.findViewById(R.id.searchSubText);
            Button button = (Button) v.findViewById(R.id.searchPersonButton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UserManager.getInstance().setCurrentUser(ViewHolder.this.tutor);
                    Intent i = new Intent(ViewHolder.this.context,ProfileActivity.class);
                    ViewHolder.this.context.startActivity(i);
                }
            });
        }
        public void setTutor(Tutor tutor)
        {
            this.tutor = tutor;
            String p = "Person: "+tutor.getName();
            String m = "Major: "+tutor.getMajor();
            person.setText(p);
            major.setText(m);
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SearchAdapter(String constraint, Context context)
    {
        this.context = context;
        tutorSet = new ArrayList<>();
        Collection<Tutor> t = UserManager.getInstance().getTutorList().values();
        for(Tutor tutor:t)
        {
            if(tutor.toString().toLowerCase().contains(constraint.toLowerCase()))
            {
                tutorSet.add(tutor);
            }
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        //...
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.context=context;
        holder.setTutor(tutorSet.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return tutorSet.size();
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
