package com.example.newbee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class AvatarSpinnerAdapter extends ArrayAdapter<AvatarItem> {

    public AvatarSpinnerAdapter(Context context, ArrayList<AvatarItem> avatarList) {
        super(context, 0, avatarList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.avatar_spinner_item, parent, false
            );
        }

        ImageView imageViewAvatar = convertView.findViewById(R.id.avatar_image);
        TextView textViewName = convertView.findViewById(R.id.avatar_name);

        AvatarItem currentItem = getItem(position);

        if (currentItem != null) {
            imageViewAvatar.setImageResource(currentItem.getImageResId());
            textViewName.setText(currentItem.getName());
        }

        return convertView;
    }
}