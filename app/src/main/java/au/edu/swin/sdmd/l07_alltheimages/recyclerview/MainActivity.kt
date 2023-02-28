package au.edu.swin.sdmd.l07_alltheimages.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import au.edu.swin.sdmd.l07_alltheimages.R
import au.edu.swin.sdmd.l07_alltheimages.model.DataSource
import au.edu.swin.sdmd.l07_alltheimages.model.Location

class MainActivity : AppCompatActivity() {

  private lateinit var adapter: RecyclerListAdapter
  private lateinit var linearLayoutManager: LinearLayoutManager

  // @version 2.0: selected item
  private lateinit var data: MutableList<Location>
  private lateinit var listView: RecyclerView
  private lateinit var selected: Location
  private var index: Int? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    Log.i("MainActivity", "is running...")

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //val listView =
    /*version 2.0*/
    listView = findViewById<RecyclerView>(R.id.locationList)

    linearLayoutManager = LinearLayoutManager(this)
    listView.layoutManager = linearLayoutManager

    // val data
    /*version 2.0 */
    //data = initData()
    // version 3.0: use DataSource class
    data = DataSource(this.resources).getData()

    adapter = RecyclerListAdapter(data) { location: Location, i: Int ->
      showDetail(location, i)
    }
    listView.adapter = adapter

  }

  private fun showDetail(item: Location, index: Int) {
    /* @version 2.0 */
    selected = item;
    this.index = index

    val intent = Intent(this, DetailActivity::class.java)
    intent.putExtra("location", item)

    // startActivity(intent)

    /* @version 2.0 */
    startForResult.launch(intent)
  }

  // @version 2.0: start activity expecting a result
  // pass data back from the child activity
  val startForResult = registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
  ) { result ->
    // Handle the returned result
    // Log.i("RESULT", "returned ${result.data.toString()}")
    when (result.resultCode) {
      RESULT_OK -> {
        val dat = result.data
        val visited = dat?.getParcelableExtra<Location>("visited")
        visited?.let {
//          selected = visited
          // update data item
          index?.let {data[it] = visited}

          // update listView
          listView.adapter!!.notifyItemChanged(index!!)

          notifyUser()
        }
      }
    }
  }

  private fun notifyUser() {
    // inform
    Toast.makeText(this, "Item updated", Toast.LENGTH_SHORT).show()
  }
}