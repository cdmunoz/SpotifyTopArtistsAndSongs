package co.medellinandroid.spotifyartists.model;

import com.squareup.moshi.Json;
import java.util.ArrayList;
import java.util.List;

public class SpotifyArtists {

  @Json(name = "href") private String href;
  @Json(name = "items") private List<SpotifyArtistsItems> items = new ArrayList<>();
  @Json(name = "limit") private int limit;
  @Json(name = "next") private String next;
  @Json(name = "offset") private int offset;
  @Json(name = "previous") private String previous;
  @Json(name = "total") private int total;

  public SpotifyArtists() {
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public List<SpotifyArtistsItems> getItems() {
    return items;
  }

  public void setItems(List<SpotifyArtistsItems> items) {
    this.items = items;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public String getNext() {
    return next;
  }

  public void setNext(String next) {
    this.next = next;
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public String getPrevious() {
    return previous;
  }

  public void setPrevious(String previous) {
    this.previous = previous;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }
}
