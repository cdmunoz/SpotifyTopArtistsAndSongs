package co.cmunoz.myspotifycontents.topTenArtists;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import co.cmunoz.myspotifycontents.R;
import co.cmunoz.myspotifycontents.model.SpotifyArtistsItems;
import co.cmunoz.myspotifycontents.topTenSongs.TopTenSongsActivity;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * User: cmunoz
 * Date: 12/7/16
 * Time: 4:41 PM
 */

public class SpotifyArtistsAdapter
    extends RecyclerView.Adapter<SpotifyArtistsAdapter.SpotifyArtistViewHolder> {

  private Activity activity;
  private final List<SpotifyArtistsItems> artists = new ArrayList<>();

  public SpotifyArtistsAdapter(Activity activity, List<SpotifyArtistsItems> artists) {
    this.activity = activity;
    this.artists.addAll(artists);
  }

  @Override public SpotifyArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.cardview_top_ten_artists, parent, false);
    return new SpotifyArtistViewHolder(itemView);
  }

  @Override public void onBindViewHolder(SpotifyArtistViewHolder holder, int position) {
    final SpotifyArtistsItems spotifyArtist = artists.get(position);
    holder.spotifyArtist(spotifyArtist, activity);
  }

  @Override public int getItemCount() {
    return artists.size();
  }

  public static class SpotifyArtistViewHolder extends RecyclerView.ViewHolder {

    private TextView cardTitle;
    private ImageView cardImage;

    public SpotifyArtistViewHolder(View itemView) {
      super(itemView);
      cardTitle = (TextView) itemView.findViewById(R.id.card_view_song_title);
      cardImage = (ImageView) itemView.findViewById(R.id.card_view_img);
    }

    public void spotifyArtist(final SpotifyArtistsItems spotifyArtist, final Activity activity) {
      cardTitle.setText(spotifyArtist.getName());
      Picasso.with(cardImage.getContext())
          .load(spotifyArtist.getImages().get(0).getUrl())
          .into(cardImage);
      itemView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
          Intent intent = TopTenSongsActivity.getIntent(activity, spotifyArtist.getId());
          activity.startActivity(intent);
        }
      });
    }
  }
}
