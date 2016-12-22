package co.cmunoz.myspotifycontents.topTenSongs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import co.cmunoz.myspotifycontents.R;
import co.cmunoz.myspotifycontents.model.SpotifyTrack;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for top ten songs list
 *
 * User: cmunoz
 * Date: 12/10/16
 * Time: 2:26 PM
 */

public class SpotifySongsAdapter
    extends RecyclerView.Adapter<SpotifySongsAdapter.SpotifySongsViewHolder> {

  private final List<SpotifyTrack> songs = new ArrayList<>();

  public SpotifySongsAdapter(List<SpotifyTrack> songs) {
    this.songs.addAll(songs);
  }

  @Override public SpotifySongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.cardview_top_ten_songs, parent, false);
    return new SpotifySongsViewHolder(itemView);
  }

  @Override public void onBindViewHolder(SpotifySongsViewHolder holder, int position) {
    final SpotifyTrack spotifyTrack = songs.get(position);
    holder.spotifyTrack(spotifyTrack);
  }

  @Override public int getItemCount() {
    return songs.size();
  }

  public class SpotifySongsViewHolder extends RecyclerView.ViewHolder {

    private ImageView songCover;
    private TextView songName;
    private TextView songAlbum;

    public SpotifySongsViewHolder(View itemView) {
      super(itemView);
      songCover = (ImageView) itemView.findViewById(R.id.card_view_song_image);
      songName = (TextView) itemView.findViewById(R.id.card_view_song_title);
      songAlbum = (TextView) itemView.findViewById(R.id.card_view_song_album);
    }

    public void spotifyTrack(SpotifyTrack spotifyTrack) {
      Picasso.with(songCover.getContext())
          .load(spotifyTrack.getAlbum().getImages().get(0).getUrl())
          .into(songCover);
      songName.setText(spotifyTrack.getName());
      songAlbum.setText(spotifyTrack.getAlbum().getName());
    }
  }
}
