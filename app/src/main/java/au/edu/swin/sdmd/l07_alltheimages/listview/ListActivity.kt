package au.edu.swin.sdmd.l07_alltheimages.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import au.edu.swin.sdmd.l07_alltheimages.R
import au.edu.swin.sdmd.l07_alltheimages.model.DataSource
import au.edu.swin.sdmd.l07_alltheimages.model.Location

class ListActivity : AppCompatActivity() {
    // can move this as a val inside onCreate()
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // create ListView
        listView = findViewById(R.id.listView)

        // populate with data
        val data: MutableList<Location> = DataSource(this.resources).getData()

        // create adapter
        val adapter = ListAdapter(this, data)
        listView.adapter = adapter
    }
}

