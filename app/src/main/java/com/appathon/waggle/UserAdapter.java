package com.appathon.waggle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;
    private Context context;
    private OnUserClickListener userClickListener;

    // Interface for click listener
    public interface OnUserClickListener {
        void onUserClick(User user);
    }

    // Constructor updated to accept Context and OnUserClickListener
    public UserAdapter(Context context, List<User> userList, OnUserClickListener listener) {
        this.context = context;
        this.userList = userList;
        this.userClickListener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }



    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, phoneTextView, addressTextView;
        TextView costTextView;

        public UserViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            addressTextView = itemView.findViewById(R.id.addressTextView);
            costTextView = itemView.findViewById(R.id.costTextView);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.nameTextView.setText(user.getName());
        holder.phoneTextView.setText(user.getPhone());
        holder.addressTextView.setText(user.getAddress());
        holder.costTextView.setText(String.valueOf(user.getCost()));

        // Set OnClickListener for the item view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(context, TimePlaceSelectionActivity.class);
                // Optionally pass any necessary data
                intent.putExtra("USER_NAME", user.getName());
                context.startActivity(intent);
            }
        });
    }


}
