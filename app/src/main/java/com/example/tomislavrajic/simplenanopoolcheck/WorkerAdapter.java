package com.example.tomislavrajic.simplenanopoolcheck;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkerAdapter extends RecyclerView.Adapter<WorkerAdapter.WorkerHolder> {

    private ArrayList<ReportedHashrates> reportedHashrates;

    WorkerAdapter(ArrayList<ReportedHashrates> reportedHashrates) {
        this.reportedHashrates = reportedHashrates;
    }

    @NonNull
    @Override
    public WorkerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_view, viewGroup, false);
        return new WorkerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkerHolder workerHolder, int i) {

        workerHolder.mTextView.setText(String.valueOf(reportedHashrates.get(i).getHashrate()));
        workerHolder.mWorkerName.setText(reportedHashrates.get(i).getWorker());
    }

    @Override
    public int getItemCount() {
        return reportedHashrates.size();
    }

    class WorkerHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        private TextView mWorkerName;

        private WorkerHolder(@NonNull View itemView) {
            super(itemView);
            mWorkerName = itemView.findViewById(R.id.worker_name);
            mTextView = itemView.findViewById(R.id.worker_hashrate);
        }
    }
}
