package com.example.taskscheduler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

// TODO Delete this
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mItemNames = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mItemNames) {
        this.mItemNames = mItemNames;
        this.mContext = mContext;
    }

    @NonNull @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        viewHolder.listItem.setText(mItemNames.get(position));
        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(TAG, "onClick: clicked on" + mItemNames.get(position));
                Toast.makeText(mContext, mItemNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Return the size of the data set (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mItemNames.size();
    }

    // Provide a reference to the views for each data item
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView listItem;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listItem = itemView.findViewById(R.id.text_view_title);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
