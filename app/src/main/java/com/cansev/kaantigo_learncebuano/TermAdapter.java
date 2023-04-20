package com.cansev.kaantigo_learncebuano;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.ViewHolder> {

    Context context;
    ArrayList<Term> termList;
    RecyclerView rvTerms;
    final View.OnClickListener onClickListener = new MyOnClickListener();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTerm, tvTermDef;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTerm = itemView.findViewById(R.id.tvTerm);
            tvTermDef = itemView.findViewById(R.id.tvTermDef);
        }
    }

    public TermAdapter(Context context, ArrayList<Term> termList, RecyclerView rvTerms) {
        this.context = context;
        this.termList = termList;
        this.rvTerms = rvTerms;
    }

    @NonNull
    @Override
    public TermAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.term_item, parent, false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.ViewHolder holder, int position) {
        Term term = termList.get(position);
        holder.tvTerm.setText(term.getWritten_form());
        holder.tvTermDef.setText(term.getWord_ceb());
    }

    @Override
    public int getItemCount() {
        return termList.size();
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int itemPosition = rvTerms.getChildLayoutPosition(view);
            Term termSelected = termList.get(itemPosition);

        }
    }
}
