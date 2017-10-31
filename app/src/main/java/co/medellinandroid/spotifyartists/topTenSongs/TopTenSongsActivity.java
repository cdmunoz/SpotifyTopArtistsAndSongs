package co.medellinandroid.spotifyartists.topTenSongs;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.medellinandroid.spotifyartists.R;
import co.medellinandroid.spotifyartists.model.SpotifyTrack;
import co.medellinandroid.spotifyartists.utils.BlurEffect;
import co.medellinandroid.spotifyartists.utils.Constants;
import com.squareup.picasso.Picasso;
import java.util.List;

public class TopTenSongsActivity extends AppCompatActivity implements TopTenSongsView {

  @BindView(R.id.top_ten_songs_progressBar) ProgressBar progressBar;
  @BindView(R.id.top_ten_songs_list_container) RecyclerView topSongsList;
  @BindView(R.id.app_bar) Toolbar topTenSongsBar;
  @BindView(R.id.app_bar_image) ImageView appBarImage;

  private TopTenSongsPresenter presenter;
  private String artistName;
  private String artistId;

  public static Intent getIntent(Context context, String artistId, String artistName) {
    Intent intent = new Intent(context, TopTenSongsActivity.class);
    intent.putExtra(Constants.EXTRA_PARAM_ARTIST_ID, artistId);
    intent.putExtra(Constants.EXTRA_PARAM_ARTIST_NAME, artistName);
    return intent;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_top_ten_songs);
    ButterKnife.bind(this);

    artistName = getIntent().getStringExtra(Constants.EXTRA_PARAM_ARTIST_NAME);
    artistId = getIntent().getStringExtra(Constants.EXTRA_PARAM_ARTIST_ID);

    initToolbar();

    initRecyclerView();

    presenter = new TopTenSongsPresenterImpl(this);
    presenter.getTopTenSongs(artistId);
  }

  private void initToolbar() {
    setSupportActionBar(topTenSongsBar);
    ActionBar actionBar = getSupportActionBar();
    if (null != actionBar) {
      actionBar.setTitle(getResources().getString(R.string.top_ten_songs_title, artistName));
      actionBar.setDisplayHomeAsUpEnabled(true);
      final Drawable backArrow = ContextCompat.getDrawable(this, R.drawable.ic_back_arrow_toolbar);
      backArrow.setColorFilter(getResources().getColor(android.R.color.white),
          PorterDuff.Mode.SRC_ATOP);
      actionBar.setHomeAsUpIndicator(backArrow);
    }
  }

  private void initRecyclerView() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    topSongsList.setLayoutManager(linearLayoutManager);
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.GONE);
  }

  @Override public void showError(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  @Override public void showSongs(List<SpotifyTrack> tracks) {
    if (null != tracks && !tracks.isEmpty()) {
      Picasso.with(appBarImage.getContext())
          .load(tracks.get(0).getAlbum().getImages().get(0).getUrl())
          .transform(new BlurEffect(this, 10))
          .into(appBarImage);
    }
    SpotifySongsAdapter adapter = new SpotifySongsAdapter(tracks);
    topSongsList.setAdapter(adapter);
    adapter.notifyDataSetChanged();
  }

  @Override protected void onDestroy() {
    presenter.destroy();
    super.onDestroy();
  }
}
