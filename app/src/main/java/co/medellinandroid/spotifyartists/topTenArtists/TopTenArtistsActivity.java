package co.medellinandroid.spotifyartists.topTenArtists;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.medellinandroid.spotifyartists.R;
import co.medellinandroid.spotifyartists.model.SpotifyArtistsItems;
import java.util.List;

public class TopTenArtistsActivity extends AppCompatActivity implements TopTenArtistsView {

  @BindView(R.id.top_ten_artists_list_container) RecyclerView topTenArtistsList;
  @BindView(R.id.top_ten_artists_list_swipe) SwipeRefreshLayout refreshLayout;
  @BindView(R.id.top_ten_artists_progressBar) ProgressBar topTenArtistsProgressBar;

  private SpotifyArtistsAdapter adapter;
  private TopTenArtistsPresenter presenter;
  private List<SpotifyArtistsItems> spotifyArtists;
  private boolean swipeRefresh;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_top_ten_artists);
    ButterKnife.bind(this);

    if (null != getSupportActionBar()) {
      getSupportActionBar().setTitle(R.string.top_ten_artists_title);
    }

    initRecyclerView();

    presenter = new TopTenArtistsPresenterImpl(this);
    presenter.getTopTenArtists();

    refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh() {
        swipeRefresh = true;
        presenter.getTopTenArtists();
      }
    });
  }

  private void initRecyclerView() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
    topTenArtistsList.setHasFixedSize(true);
    topTenArtistsList.setLayoutManager(gridLayoutManager);
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
    if (swipeRefresh) refreshLayout.setRefreshing(false);
  }

  @Override protected void onDestroy() {
    presenter.onDestroy();
    super.onDestroy();
  }
}
