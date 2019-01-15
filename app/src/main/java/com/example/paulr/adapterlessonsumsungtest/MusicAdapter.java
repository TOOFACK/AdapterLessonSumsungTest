package com.example.paulr.adapterlessonsumsungtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicVH> {
    List<Musiv> musicList;
    private Context context;

    public MusicAdapter(List<Musiv> musicList) {
        this.musicList = musicList;
    }
    public MusicAdapter(Context context) {
        this.context = context;
    }
    public MusicAdapter( ) {

    }

    @NonNull
    @Override
    public MusicVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view = inflater.inflate(R.layout.nice_artist, viewGroup, false);

        return new MusicVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MusicVH musicVH, final int i) {
        Musiv music = musicList.get(i);
        musicVH.albumImage.setImageResource(music.getAlbunImgeId());
        musicVH.artist.setText(music.getArtist());
        musicVH.description.setText(music.getMusic());
        musicVH.artistCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                musicList.remove(i);
                notifyItemRemoved(i);
                notifyItemChanged(i);
                return false;
            }
        });
        musicVH.artistCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(musicVH.itemView.getContext(), Description.class);
            intent.putExtra("Name",musicVH.artist.getText());
            intent.putExtra("Description",musicVH.description.getText());
//                Bundle bundle = new Bundle();
//                int id = musicVH.albumImage.getId();
//                bundle.putInt("image", id);
//                intent.putExtras(bundle);
            //intent.putExtra("Image", musicVH.albumImage.getId());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }


    class MusicVH extends RecyclerView.ViewHolder{
        private ImageView albumImage;
        private TextView artist;
        private TextView description;
        private CardView artistCard;

        public MusicVH(@NonNull View itemView) {
            super(itemView);

            albumImage = itemView.findViewById(R.id.albumImage);
            artist = itemView.findViewById(R.id.artistName);
            description = itemView.findViewById(R.id.artistDescription);
            artistCard = itemView.findViewById(R.id.musicCard);

        }
    }
}
