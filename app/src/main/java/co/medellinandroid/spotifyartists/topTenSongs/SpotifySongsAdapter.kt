package co.medellinandroid.spotifyartists.topTenSongs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import co.medellinandroid.spotifyartists.R
import co.medellinandroid.spotifyartists.model.SpotifyTrack
import com.squareup.picasso.Picasso
import java.util.ArrayList

class SpotifySongsAdapter(
    songs: List<SpotifyTrack>) : RecyclerView.Adapter<SpotifySongsAdapter.SpotifySongsViewHolder>() {

  private val songs = ArrayList<SpotifyTrack>()

  init {
    this.songs.addAll(songs)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotifySongsViewHolder {
    val itemView = LayoutInflater.from(parent.context)
        .inflate(R.layout.cardview_top_ten_songs, parent, false)
    return SpotifySongsViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: SpotifySongsViewHolder, position: Int) {
    val spotifyTrack = songs[position]
    holder.spotifyTrack(spotifyTrack)
  }

  override fun getItemCount(): Int = songs.size

  inner class SpotifySongsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val songCover = itemView.findViewById(R.id.card_view_song_image) as ImageView
    val songName = itemView.findViewById(R.id.card_view_song_title) as TextView
    val songAlbum = itemView.findViewById(R.id.card_view_song_album) as TextView

    fun spotifyTrack(spotifyTrack: SpotifyTrack) {
      Picasso.with(songCover.context)
          .load(spotifyTrack.album!!.images[0].url)
          .into(songCover)
      songName.text = spotifyTrack.name
      songAlbum.text = spotifyTrack.album!!.name
    }
  }
}
