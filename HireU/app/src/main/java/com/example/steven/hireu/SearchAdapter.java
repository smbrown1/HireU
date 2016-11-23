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

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private String[] relatives;
    private String[] events;
    private Context context;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public TextView mSubTextView;
        private Button button;
        private String id, type;
        public Context context;
        public ImageView imageView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.searchText);
            mSubTextView = (TextView) v.findViewById(R.id.searchSubText);
            button = (Button) v.findViewById(R.id.searchPersonButton);
            imageView = (ImageView) v.findViewById(R.id.searchImage);
            button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                   /* if(type.equals("relative"))
                    {
                        Intent intent = new Intent(context, PersonActivity.class);
                        intent.putExtra("personID",id);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                    else
                    {
                        Intent intent = new Intent(context, MapsActivity.class);
                        intent.putExtra("eventID",id);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(intent);
                    }*/
                }
            });
        }
        public void setID(String id, String type)
        {
            this.id=id;
            this.type=type;
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SearchAdapter(String[] relatives, String[] events, Context context)
    {
        this.context = context;
        this.relatives = relatives;
        this.events = events;
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
        holder.context = context;
        /*if(position < relatives.length)
        {
            holder.setID(relatives[position], "relative");

           holder.mTextView.setText(Person.SINGLETON.getFamily().get(relatives[position]).getName());
           holder.mSubTextView.setText("");
            if(Person.SINGLETON.getFamily().get(relatives[position]).getGender().toLowerCase().equals("m")) {
                holder.imageView.setImageResource(R.drawable.men_symbol);
            }
            else
            {
                holder.imageView.setImageResource(R.drawable.women_symbols);
            }
        }
        else
        {
            position -= relatives.length;
            holder.setID(events[position], "event");
            Event e = Person.SINGLETON.getSelectedEvents().get(events[position]);
            holder.mTextView.setText(e.toString());
            holder.mSubTextView.setText(
                    Person.SINGLETON.getFamily().get(
                    Person.SINGLETON.getSelectedEvents()
                            .get(events[position]).getPersonID()).toString()
            );
        }*/

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return relatives.length + events.length;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
