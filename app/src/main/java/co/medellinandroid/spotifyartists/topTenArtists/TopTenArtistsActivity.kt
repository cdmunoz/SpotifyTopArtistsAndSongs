package co.medellinandroid.spotifyartists.topTenArtists

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import co.medellinandroid.spotifyartists.R
import co.medellinandroid.spotifyartists.di.component.ActivitiesComponent
import co.medellinandroid.spotifyartists.di.component.DaggerActivitiesComponent
import co.medellinandroid.spotifyartists.di.module.PresentersModule
import co.medellinandroid.spotifyartists.model.SpotifyArtistsItems
import kotlinx.android.synthetic.main.activity_top_ten_artists.top_ten_artists_list_container
import kotlinx.android.synthetic.main.activity_top_ten_artists.top_ten_artists_list_swipe
import kotlinx.android.synthetic.main.activity_top_ten_artists.top_ten_artists_progressBar
import javax.inject.Inject

class TopTenArtistsActivity : AppCompatActivity(), TopTenArtistsContract.View {

  lateinit var adapter: SpotifyArtistsAdapter
  @Inject lateinit var presenter: TopTenArtistsPresenter
  private lateinit var spotifyArtists: List<SpotifyArtistsItems>
  private var swipeRefresh: Boolean = false

  val activitiesComponent: ActivitiesComponent by lazy {
    DaggerActivitiesComponent.builder().presentersModule(
        PresentersModule()).build()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_top_ten_artists)

    activitiesComponent.inject(this)

    supportActionBar?.setTitle(R.string.top_ten_artists_title)

    initRecyclerView()

    presenter.attachView(this)
    presenter.getTopTenArtists()

    top_ten_artists_list_swipe.setOnRefreshListener {
      swipeRefresh = true
      presenter.getTopTenArtists()
    }
  }

  private fun initRecyclerView() {
    val linearLayoutManager = LinearLayoutManager(this)
    linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
    val gridLayoutManager = GridLayoutManager(this, 2)
    top_ten_artists_list_container.setHasFixedSize(true)
    top_ten_artists_list_container.layoutManager = gridLayoutManager
  }

  override fun showProgress() {
    top_ten_artists_list_container.visibility = View.GONE
    top_ten_artists_progressBar.visibility = View.VISIBLE
  }

  override fun hideProgress() {
    top_ten_artists_progressBar.visibility = View.GONE
    top_ten_artists_list_container.visibility = View.VISIBLE
  }

  override fun showError(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    top_ten_artists_list_swipe.isRefreshing = false
  }

  override fun showList(topTenArtists: List<SpotifyArtistsItems>) {
    spotifyArtists = topTenArtists
    adapter = SpotifyArtistsAdapter(this, spotifyArtists)
    top_ten_artists_list_container.adapter = adapter
    adapter.notifyDataSetChanged()
    if (swipeRefresh) top_ten_artists_list_swipe.isRefreshing = false
  }

  override fun onDestroy() {
    presenter.onDestroy()
    super.onDestroy()
  }
}
