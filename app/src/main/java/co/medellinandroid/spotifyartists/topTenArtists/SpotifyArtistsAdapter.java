package co.medellinandroid.spotifyartists.topTenArtists;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.medellinandroid.spotifyartists.R;
import co.medellinandroid.spotifyartists.model.SpotifyArtistsItems;
import co.medellinandroid.spotifyartists.topTenSongs.TopTenSongsActivity;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

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

    @BindView(R.id.card_view_song_title) TextView cardTitle;
    @BindView(R.id.card_view_img) ImageView cardImage;

    public SpotifyArtistViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    public void spotifyArtist(final SpotifyArtistsItems spotifyArtist, final Activity activity) {
      cardTitle.setText(spotifyArtist.getName());
      Picasso.with(cardImage.getContext())
          .load(spotifyArtist.getImages().get(0).getUrl())
          .into(cardImage);
      itemView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
          Intent intent = TopTenSongsActivity.getIntent(activity, spotifyArtist.getId(),
              spotifyArtist.getName());
          activity.startActivity(intent);
        }
      });
    }
  }
}
