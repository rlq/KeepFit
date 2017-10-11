package com.lq.ren.keepfit.motion;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.lq.ren.base.asset.FitnessType;
import com.lq.ren.keepfit.R;
import com.lq.ren.keepfit.utils.ResTransUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        Log.w("HEHE", "fitness adapter setTypeData");
        fitnessTypes.clear();
        fitnessTypes.addAll(types);
        notifyDataSetChanged();
    }

    @Override
    public FitnessTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_type, parent, false);
        final FitnessTypeViewHolder holder = new FitnessTypeViewHolder(view);
        holder.go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("HEHE", "onclick :" + view.getTag());
                listener.onClickType(fitnessTypes.get((int) view.getTag()));
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.w("HEHE", "fitness adapter :" + fitnessTypes.get(position));
        ((FitnessTypeViewHolder) holder).go.setTag(position);
        ((FitnessTypeViewHolder) holder).go.setText(ResTransUtil.mapFitnessType(fitnessTypes.get(position)));
        ((FitnessTypeViewHolder) holder).typeImage.setBackground(context.getResources().getDrawable(
                ResTransUtil.mapFitnessTypeImage(fitnessTypes.get(position))));
    }

    @Override
    public int getItemCount() {
        return fitnessTypes.size();
    }


    class FitnessTypeViewHolder extends RecyclerView.ViewHolder {

        private ImageView typeImage;
        private Button go;

        public FitnessTypeViewHolder(View itemView) {
            super(itemView);
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
