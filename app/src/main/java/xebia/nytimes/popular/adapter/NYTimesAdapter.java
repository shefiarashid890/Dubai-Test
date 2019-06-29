package xebia.nytimes.popular.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xebia.nytimes.popular.R;
import xebia.nytimes.popular.model.Result;

public class NYTimesAdapter extends RecyclerView.Adapter<NYTimesAdapter.MovieViewHolder> {

    private List<Result> nyList;
    private int rowLayout;



    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView nyTitle;
        TextView data;
        TextView description;

        public MovieViewHolder(View v) {
            super(v);
            nyTitle = v.findViewById(R.id.title);
            data =  v.findViewById(R.id.date);
            description =  v.findViewById(R.id.description);
        }
    }

    public NYTimesAdapter(List<Result> movies, int rowLayout, Context context) {
        this.nyList = movies;
        this.rowLayout = rowLayout;

    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.nyTitle.setText(nyList.get(position).getTitle());
        holder.data.setText(nyList.get(position).getPublishedDate());
        holder.description.setText(nyList.get(position).getByline());
    }

    @Override
    public int getItemCount() {
        return nyList.size();
    }
}