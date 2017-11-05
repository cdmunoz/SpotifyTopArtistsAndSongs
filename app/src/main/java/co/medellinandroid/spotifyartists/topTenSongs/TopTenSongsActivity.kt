package co.medellinandroid.spotifyartists.topTenSongs

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import co.medellinandroid.spotifyartists.R
import co.medellinandroid.spotifyartists.di.component.ActivitiesComponent
import co.medellinandroid.spotifyartists.di.component.DaggerActivitiesComponent
import co.medellinandroid.spotifyartists.di.module.PresentersModule
import co.medellinandroid.spotifyartists.model.SpotifyTrack
import co.medellinandroid.spotifyartists.utils.BlurEffect
import co.medellinandroid.spotifyartists.utils.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_top_ten_songs.app_bar
import kotlinx.android.synthetic.main.activity_top_ten_songs.app_bar_image
import kotlinx.android.synthetic.main.activity_top_ten_songs.top_ten_songs_list_container
import kotlinx.android.synthetic.main.activity_top_ten_songs.top_ten_songs_progressBar
import javax.inject.Inject

class TopTenSongsActivity : AppCompatActivity(), TopTenSongsContract.View {

  @Inject lateinit var presenter: TopTenSongsPresenter
  private lateinit var artistName: String
  private lateinit var artistId: String

  val activitiesComponent: ActivitiesComponent by lazy {
    DaggerActivitiesComponent.builder().presentersModule(
        PresentersModule()).build()
  }

  companion object {
    fun getIntent(context: Context, artistId: String, artistName: String): Intent {
      val intent = Intent(context, TopTenSongsActivity::class.java)
      intent.putExtra(Constants.EXTRA_PARAM_ARTIST_ID, artistId)
      intent.putExtra(Constants.EXTRA_PARAM_ARTIST_NAME, artistName)
      return intent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_top_ten_songs)

    artistName = intent.getStringExtra(Constants.EXTRA_PARAM_ARTIST_NAME)
    artistId = intent.getStringExtra(Constants.EXTRA_PARAM_ARTIST_ID)

    activitiesComponent.inject(this)

    initToolbar()
    initRecyclerView()

    presenter.attachView(this)
    presenter.getTopTenSongs(artistId)
  }

  private fun initToolbar() {
    setSupportActionBar(app_bar)

    val actionBar: ActionBar? = supportActionBar
    actionBar?.title = resources.getString(R.string.top_ten_songs_title, artistName)
    actionBar?.setDisplayHomeAsUpEnabled(true)
    val backArrow = ContextCompat.getDrawable(this, R.drawable.ic_back_arrow_toolbar)
    backArrow.setColorFilter(resources.getColor(android.R.color.white),
        PorterDuff.Mode.SRC_ATOP)
    actionBar?.setHomeAsUpIndicator(backArrow)
  }

  private fun initRecyclerView() {
    val linearLayoutManager = LinearLayoutManager(this)
    linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
    top_ten_songs_list_container.layoutManager = linearLayoutManager
  }

  override fun showProgress() {
    top_ten_songs_progressBar.visibility = View.VISIBLE
  }

  override fun hideProgress() {
    top_ten_songs_progressBar.visibility = View.GONE
  }

  override fun showError(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
  }

  override fun showSongs(tracks: List<SpotifyTrack>) {
    if (!tracks.isEmpty()) {
      Picasso.with(app_bar_image.context)
          .load(tracks[0].album!!.images[0].url)
          .transform(BlurEffect(this, 10))
          .into(app_bar_image)
    }
    val adapter = SpotifySongsAdapter(tracks)
    top_ten_songs_list_container.adapter = adapter
    adapter.notifyDataSetChanged()
  }

  override fun onDestroy() {
    presenter.destroy()
    super.onDestroy()
  }
}
