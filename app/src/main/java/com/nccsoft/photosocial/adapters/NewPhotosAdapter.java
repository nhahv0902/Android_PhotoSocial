package com.nccsoft.photosocial.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.nccsoft.photosocial.R;
import com.nccsoft.photosocial.models.ImagesManager;
import com.nccsoft.photosocial.models.LocalMedia;
import com.nccsoft.photosocial.views.DynamicImageView;

import java.util.List;

/**
 * Created by Nhahv on 8/3/2016.
 * <></>
 */

public class NewPhotosAdapter extends RecyclerView.Adapter<NewPhotosAdapter.ViewHolder> {

    private Context mContext;
    private List<LocalMedia> mListLocalMedia;

    public NewPhotosAdapter(Context context, List<LocalMedia> objects) {
        mContext = context;
        mListLocalMedia = objects;
        setListLocalMedia();
    }

    private void setListLocalMedia() {
        mListLocalMedia.addAll
                (ImagesManager.loadImages
                        (mContext, ImagesManager.TYPE_ALL_IMAGE));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(mContext)
                .inflate(R.layout.item_new_photos, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LocalMedia item = mListLocalMedia.get(position);


        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) holder.image.getLayoutParams();
        float ratio = item.getHeight() / item.getWidth();
        rlp.height = (int) (rlp.width * ratio);
        holder.image.setLayoutParams(rlp);
        holder.image.setRatio(item.getRatio());

        Glide.with(mContext)
                .load(item.getPath())
                .placeholder(R.drawable.ic_insert_photo_black_48dp)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mListLocalMedia.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private DynamicImageView image;

        ViewHolder(View itemView) {
            super(itemView);

            image = (DynamicImageView) itemView.findViewById(R.id.image_camera);
        }
    }
}
