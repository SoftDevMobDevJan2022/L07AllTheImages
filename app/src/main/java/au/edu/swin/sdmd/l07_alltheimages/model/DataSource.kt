package au.edu.swin.sdmd.l07_alltheimages.model

import android.content.res.Resources
import au.edu.swin.sdmd.l07_alltheimages.R

class DataSource(resources: Resources) {
  private lateinit var data: MutableList<Location>

  init {
    data = mutableListOf<Location>()
    data.add(
      Location(
        "Glenferrie Station", "Ada May Plante",
        -37.821539f, 145.036473f, image = R.drawable.station
      )
    )
    data.add(
      Location(
        "Swinburne College", "unknown",
        -37.822036f, 145.038875f, image = R.drawable.college
      )
    )
    data.add(
      Location(
        "Theatre", "unknown",
        -37.819927f, 145.035722f, image = R.drawable.theatre
      )
    )
    data.add(
      Location(
        "Catholic Church", "unknown",
        -37.822435f, 145.035231f
      )
    )
    data.add(
      Location(
        "Corner shops", "unknown",
        -37.822520f, 145.035483f
      )
    )
    data.add(
      Location(
        "Town Hall", "unknown",
        -37.822821f, 145.035992f
      )
    )
    data.add(
      Location(
        "Anglican Church", "unknown",
        -37.823361f, 145.039576f
      )
    )
    data.add(
      Location(
        "Hawthorn Hotel", "unknown",
        -37.823027f, 145.039909f
      )
    )
    data.add(
      Location(
        "House", "unknown",
        -37.823576f, 145.042800f
      )
    )
    data.add(
      Location(
        "Glenferrie Hotel ", "unknown",
        -37.822604f, 145.034480f
      )
    )
    data.add(
      Location(
        "Auburn Rd", "unknown",
        -37.823692f, 145.044769f
      )
    )
    data.add(
      Location(
        "Hawthorn Station", "unknown",
        -37.821946f, 145.023194f
      )
    )
    data.add(
      Location(
        "Office building", "unknown",
        -37.822170f, 145.029600f
      )
    )
  }

  fun getData(): MutableList<Location> {
    return data
  }
}