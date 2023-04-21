package com.cansev.kaantigo_learncebuano;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {

//    Context context;
//    ArrayList<Term> termList;
//    RecyclerView rvSearchResults;
//    final View.OnClickListener onClickListener = new SearchResultAdapter.MyOnClickListener();
    private List<Term> data;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTerm, tvTermDef;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTerm = itemView.findViewById(R.id.tvTerm);
            tvTermDef = itemView.findViewById(R.id.tvTermDef);
        }
    }

    public SearchResultAdapter() {
//        this.context = context;
//        this.termList = termList;
//        this.rvSearchResults = rvSearchResults;
    }

    public void setData(List<Term> newData) {
        data = newData;
    }

    @NonNull
    @Override
    public SearchResultAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);
//        itemView.setOnClickListener(onClickListener);
        return new SearchResultAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResultAdapter.ViewHolder holder, int position) {
        Term term = data.get(position);
        holder.tvTerm.setText(term.getWritten_form());
        holder.tvTermDef.setText(term.getWord_ceb());
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

//    private class MyOnClickListener implements View.OnClickListener {
//        @Override
//        public void onClick(View view) {
//            int itemPosition = rvTerms.getChildLayoutPosition(view);
//            Term termSelected = termList.get(itemPosition);
//
//        }
//    }
}
