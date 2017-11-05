package co.medellinandroid.spotifyartists.topTenArtists

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import co.medellinandroid.spotifyartists.R
import co.medellinandroid.spotifyartists.model.SpotifyArtistsItems
import co.medellinandroid.spotifyartists.topTenSongs.TopTenSongsActivity
import com.squareup.picasso.Picasso
import java.util.ArrayList

class SpotifyArtistsAdapter(private val activity: Activity,
    artists: List<SpotifyArtistsItems>) : RecyclerView.Adapter<SpotifyArtistsAdapter.SpotifyArtistViewHolder>() {

  private val artists = ArrayList<SpotifyArtistsItems>()

  init {
    this.artists.addAll(artists)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotifyArtistViewHolder {
    val itemView = LayoutInflater.from(parent.context)
        .inflate(R.layout.cardview_top_ten_artists, parent, false)
    return SpotifyArtistViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: SpotifyArtistViewHolder, position: Int) {
    val spotifyArtist = artists[position]
    holder.spotifyArtist(spotifyArtist, activity)
  }

  override fun getItemCount(): Int = artists.size

  class SpotifyArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val cardTitle = itemView.findViewById(R.id.card_view_song_title) as TextView
    val cardImage = itemView.findViewById(R.id.card_view_img) as ImageView

    fun spotifyArtist(spotifyArtist: SpotifyArtistsItems, activity: Activity) {
      cardTitle.text = spotifyArtist.name
      Picasso.with(cardImage.context)
          .load(spotifyArtist.images[0].url)
          .into(cardImage)
      itemView.setOnClickListener {
        val intent = TopTenSongsActivity.getIntent(activity, spotifyArtist.id!!,
            spotifyArtist.name!!)
        activity.startActivity(intent)
      }
    }
  }
}
