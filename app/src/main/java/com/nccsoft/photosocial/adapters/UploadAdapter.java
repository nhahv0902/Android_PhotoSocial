package com.nccsoft.photosocial.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.nccsoft.photosocial.R;
import com.nccsoft.photosocial.models.LocalMedia;
import com.nccsoft.photosocial.views.ImageVertical;

import java.io.File;
import java.util.List;

/**
 * Created by Nhahv on 8/3/2016.
 * <></>
 */

public class UploadAdapter extends RecyclerView.Adapter<UploadAdapter.ViewHolder> {

    private Context mContext;
    private List<LocalMedia> mListLocalMedia;
    private OnClickPreview mOnClickPreview;

    public UploadAdapter(Context context, List<LocalMedia> objects) {
        mContext = context;
        mListLocalMedia = objects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(mContext)
                .inflate(R.layout.item_upload, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        LocalMedia item = mListLocalMedia.get(position);


        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) holder.image.getLayoutParams();
        rlp.width = (int) (rlp.height / item.getRatio());
        holder.image.setLayoutParams(rlp);
        holder.image.setRatio(item.getRatio());

        Glide.with(mContext)
                .load(new File(item.getPath()))
                .placeholder(R.drawable.ic_insert_photo_black_48dp)
                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnClickPreview != null){
                    mOnClickPreview.onClickPreviews(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListLocalMedia.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageVertical image;

        ViewHolder(View itemView) {
            super(itemView);

            image = (ImageVertical) itemView.findViewById(R.id.image_upload);
        }
    }

    public void setOnClickPreview(OnClickPreview onClick) {
        mOnClickPreview = onClick;
    }

    public interface OnClickPreview {
        void onClickPreviews(int position);
    }
}
