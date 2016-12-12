package co.cmunoz.myspotifycontents.topTenSongs;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import co.cmunoz.myspotifycontents.R;
import co.cmunoz.myspotifycontents.model.SpotifyTrack;
import java.util.List;

/**
 * Adapter for top ten songs list
 *
 * User: cmunoz
 * Date: 12/10/16
 * Time: 2:26 PM
 */

public class SpotifySongsAdapter extends RecyclerView.Adapter<SpotifySongsAdapter.SpotifySongsViewHolder> {

  private Activity activity;
  private List<SpotifyTrack> songs;

  public SpotifySongsAdapter(Activity activity, List<SpotifyTrack> songs) {
    this.activity = activity;
    this.songs = songs;
  }

  @Override public SpotifySongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_top_ten_songs, parent, false);
    return new SpotifySongsViewHolder(itemView);
  }

  @Override public void onBindViewHolder(SpotifySongsViewHolder holder, int position) {
    final SpotifyTrack song = songs.get(position);
    holder.songName.setText(song.getName());
  }

  @Override public int getItemCount() {
    return songs.size();
  }

  public class SpotifySongsViewHolder extends RecyclerView.ViewHolder {

    TextView songName;

    public SpotifySongsViewHolder(View itemView) {
      super(itemView);
      songName = (TextView) itemView.findViewById(R.id.card_view_title);
    }
  }
}
