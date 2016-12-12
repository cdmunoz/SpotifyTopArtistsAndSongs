package co.cmunoz.myspotifycontents.topTenArtists;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import co.cmunoz.myspotifycontents.R;
import co.cmunoz.myspotifycontents.model.SpotifyArtistsItems;
import java.util.List;

public class TopTenArtistsActivity extends AppCompatActivity implements TopTenArtistsView {

  RecyclerView topTenArtistsList;
  SwipeRefreshLayout refreshLayout;
  ProgressBar topTenArtistsProgressBar;
  private SpotifyArtistsAdapter adapter;
  private TopTenArtistsPresenter presenter;
  private List<SpotifyArtistsItems> spotifyArtists;
  private boolean swipeRefresh;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_top_ten_artists);

    refreshLayout = (SwipeRefreshLayout) findViewById(R.id.top_ten_artists_list_swipe);
    topTenArtistsList = (RecyclerView) findViewById(R.id.top_ten_artists_list_container);
    topTenArtistsProgressBar = (ProgressBar) findViewById(R.id.top_ten_artists_progressBar);

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    topTenArtistsList.setLayoutManager(linearLayoutManager);

    presenter = new TopTenArtistsPresenterImpl(this);
    presenter.getTopTenArtists();

    refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh() {
        swipeRefresh = true;
        presenter.getTopTenArtists();
      }
    });

  }

  @Override public void showProgress() {
    topTenArtistsList.setVisibility(View.GONE);
    topTenArtistsProgressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    topTenArtistsProgressBar.setVisibility(View.GONE);
    topTenArtistsList.setVisibility(View.VISIBLE);
  }

  @Override public void showError(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    refreshLayout.setRefreshing(false);
  }

  @Override public void showList(List<SpotifyArtistsItems> topTenArtists) {
    spotifyArtists = topTenArtists;
    adapter = new SpotifyArtistsAdapter(this, spotifyArtists);
    topTenArtistsList.setAdapter(adapter);
    adapter.notifyDataSetChanged();
    if(swipeRefresh) refreshLayout.setRefreshing(false);
  }

  @Override protected void onDestroy() {
    presenter.onDestroy();
    super.onDestroy();
  }
}
