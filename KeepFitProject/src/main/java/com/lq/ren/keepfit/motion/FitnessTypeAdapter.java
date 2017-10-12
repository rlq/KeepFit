package com.lq.ren.keepfit.motion;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lq.ren.base.asset.FitnessType;
import com.lq.ren.keepfit.R;
import com.lq.ren.keepfit.utils.ResTransUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Author lqren on 17/10/11.
 */

public class FitnessTypeAdapter extends RecyclerView.Adapter {

    private Context context;
    private final List<FitnessType> fitnessTypes = new ArrayList<>();
    private FitnessTypeClickListener listener;

    FitnessTypeAdapter(Context context) {
        this.context = context;
    }

    void setTypeData(List<FitnessType> types) {
        fitnessTypes.clear();
        fitnessTypes.addAll(types);
        notifyDataSetChanged();
    }

    @Override
    public FitnessTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_type_item, parent, false);
        final FitnessTypeViewHolder holder = new FitnessTypeViewHolder(view);
        holder.typeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickType(fitnessTypes.get((int) view.getTag()));
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FitnessTypeViewHolder) holder).typeView.setTag(position);
        ((FitnessTypeViewHolder) holder).go.setText(ResTransUtil.mapFitnessType(fitnessTypes.get(position)));
        ((FitnessTypeViewHolder) holder).typeImage.setBackground(context.getResources().getDrawable(
                ResTransUtil.mapFitnessTypeImage(fitnessTypes.get(position))));
    }

    @Override
    public int getItemCount() {
        return fitnessTypes.size();
    }


    class FitnessTypeViewHolder extends RecyclerView.ViewHolder {

        private View typeView;
        private ImageView typeImage;
        private TextView go;

        public FitnessTypeViewHolder(View itemView) {
            super(itemView);
            typeView = itemView.findViewById(R.id.type_view);
            typeImage = itemView.findViewById(R.id.type_image);
            go = itemView.findViewById(R.id.go_fit);
        }
    }

    public void setClickTypeListener(FitnessTypeClickListener listener) {
        this.listener = listener;
    }

    interface FitnessTypeClickListener {
        void onClickType(FitnessType type);
    }
}
