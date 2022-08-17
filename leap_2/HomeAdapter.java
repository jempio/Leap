//package com.example.leap_2;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
//
//    // I made these properties private because objects outside of this class do
//    // not need to access them
//    private ArrayList<Goal> taskItems; // This is the array of agenda items to display
//    private LayoutInflater inflater;       // The inflater is an object used to connect
//    // your home_item.xml layout to the view holder.
//    // The view holder is the individual "cells"
//    // that the recycler view displays on screen
//
//    public HomeAdapter(Context ct, ArrayList<Goal> taskItems) {
//        inflater = LayoutInflater.from(ct);  // Get inflater object from the context
//        this.taskItems = taskItems;      // Save the list of agenda items
//    }
//
//    // onCreateViewHolder is called whenever the recycler view needs to create a new "cell" or view holder
//    @NonNull
//    @Override
//    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = inflater.inflate(R.layout.home_item, parent);  // Get the layout defined in home_item.xml
//        HomeViewHolder viewHolder = new HomeViewHolder(itemView);      // Create a view holder using the layout in home_item.xml
//        return viewHolder;
//    }
//
//    // onBindViewHolder is called whenever the recycler view needs to display a cell on screen. For
//    // the initial set of cells displayed on screen, onBindViewHolder is called immediately after onCreateViewHolder
//    // is called. However, when enough cells have been created by onCreateViewHolder, the next time a new cell
//    // needs to be displayed, Android can reuse a previously created cell (i.e. that cell has already scrolled off-screen)
//    // so it won't call onCreateViewHolder anymore, it'll just reuse that off screen cell and call onBindViewHolder on it.
//    @Override
//    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
//        // holder is the cell or view holder that we need to populate since it's about to be displayed
//        // position is the position of the view holder in the recycler view. We need this info so we
//        // know what data to use populate this view holder (i.e. position 0 corresponds to row 0, etc.)
//
//        Goal tasks = taskItems.get(position);  // Get the agenda object at the given position
//        holder.populateDisplay(tasks);             // Tell the view holder to populate its text views and other
//        // views with the contents of this agenda item
//    }
//
//    @Override
//    public int getItemCount() {
//        return (taskItems == null) ? 0 : taskItems.size();
//    }
//
//    public class HomeViewHolder extends RecyclerView.ViewHolder {
//
//        public HomeAdapter adapter;
//        public TextView agendaTitleTextView;   // This is the text view in the home_item layout that holds the agenda title
//
//        public HomeViewHolder(@NonNull View itemView) {
//            // itemView is the top level layout loaded from home_item.xml
//            super(itemView);
//            agendaTitleTextView = itemView.findViewById(R.id.home_text);
//            this.adapter = adapter;
//        }
//
//        // This method is called when we want to update this view holder to display the contents of
//        // an agenda object
//        public void populateDisplay(Goal task) {
//            if (task != null) {
//                agendaTitleTextView.setText((CharSequence) task.name);  // Update the title text view with the title of the agenda
//            }
//        }
//    }
//
//
//}
//


