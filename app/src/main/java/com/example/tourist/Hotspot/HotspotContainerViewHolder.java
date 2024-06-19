package com.example.tourist.Hotspot;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourist.R;

public class HotspotContainerViewHolder extends RecyclerView.ViewHolder {
    ImageView pic;
    TextView name, place;


    public HotspotContainerViewHolder(@NonNull View itemView) {
        super(itemView);
        pic = itemView.findViewById(R.id.hotspot_container_pic);
        name = itemView.findViewById(R.id.hotspot_container_name);
        place = itemView.findViewById(R.id.hotspot_container_place);
    }

    public ImageView getPic() {
        return pic;
    }

    public void setPic(ImageView pic) {
        this.pic = pic;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getPlace() {
        return place;
    }

    public void setPlace(TextView place) {
        this.place = place;
    }
}
