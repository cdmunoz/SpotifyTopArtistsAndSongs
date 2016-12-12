package co.cmunoz.myspotifycontents.topTenSongs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import co.cmunoz.myspotifycontents.R;
import co.cmunoz.myspotifycontents.model.SpotifyTrack;
import co.cmunoz.myspotifycontents.utils.Constants;
import java.util.List;

/**
 * Activity for artist detail
 *
 * User: cmunoz
 * Date: 12/10/16
 * Time: 12:11 PM
 */
public class TopTenSongsActivity extends AppCompatActivity implements TopTenSongsView {

  ProgressBar progressBar;
  SwipeRefreshLayout refreshLayout;
  RecyclerView topSongsList;

  private TopTenSongsPresenter presenter;
  private boolean swipeRefresh;

  public static Intent getIntent(Context context, String artistId){
    Intent intent = new Intent(context, TopTenSongsActivity.class);
    intent.putExtra(Constants.EXTRA_PARAM_ARTIST, artistId);
    return intent;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_top_ten_songs);

    progressBar = (ProgressBar) findViewById(R.id.top_ten_songs_progressBar);
    refreshLayout = (SwipeRefreshLayout) findViewById(R.id.top_ten_songs_list_swipe);
    topSongsList = (RecyclerView) findViewById(R.id.top_ten_songs_list_container);

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    topSongsList.setLayoutManager(linearLayoutManager);

    presenter = new TopTenSongsPresenterImpl(this);
    presenter.getTopTenSongs(getIntent().getStringExtra(Constants.EXTRA_PARAM_ARTIST));

    refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh() {
        swipeRefresh = true;
        presenter.getTopTenSongs(getIntent().getStringExtra(Constants.EXTRA_PARAM_ARTIST));
      }
    });
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
    SpotifySongsAdapter adapter = new SpotifySongsAdapter(this, tracks);
    topSongsList.setAdapter(adapter);
    adapter.notifyDataSetChanged();
    if(swipeRefresh) refreshLayout.setRefreshing(false);
  }
}
