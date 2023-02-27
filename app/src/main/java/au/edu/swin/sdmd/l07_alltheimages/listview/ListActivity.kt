package au.edu.swin.sdmd.l07_alltheimages.listview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import au.edu.swin.sdmd.l07_alltheimages.R
import au.edu.swin.sdmd.l07_alltheimages.model.DataSource
import au.edu.swin.sdmd.l07_alltheimages.model.Location

class ListActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listView = findViewById(R.id.listView)
        val data = DataSource(this.resources).getData()

        val adapter = ListAdapter(this, data)
        listView.adapter = adapter
    }
}

class ListAdapter(private val context: Context,
                  private val data: List<Location>) : BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        // Firstly, the default code for generating rows
        val rowView = inflater.inflate(R.layout.layout_row, parent, false)
        val name: TextView = rowView.findViewById(R.id.textView)

        val item = getItem(position) as Location
        name.text = item.name

        return rowView

        // Secondly, using ViewHolder so as to not be constantly creating new rows

        /* val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.layout_row, parent, false)

            holder = ViewHolder()
            holder.name = view.findViewById(R.id.textView) as TextView

            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
            // for education purposes only
            val example = view.findViewById<TextView>(R.id.textView)
            Log.i("CONVERT", example.text.toString())
        }

        val item = getItem(position) as Location
        holder.name.text = item.name
        return view */
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

    private class ViewHolder {
        lateinit var name: TextView
    }
}
