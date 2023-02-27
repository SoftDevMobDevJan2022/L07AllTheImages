package au.edu.swin.sdmd.l07_alltheimages.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import au.edu.swin.sdmd.l07_alltheimages.R
import au.edu.swin.sdmd.l07_alltheimages.model.Location

class TheAdapter(private val data: List<Location>,
                 private val listener: (Location, Int) -> Unit) :
    RecyclerView.Adapter<TheAdapter.TheHolder>()  {

    /**
     * invoked by RecyclerView to create a new ViewHolder for an item
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
        TheHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.layout_row, parent, false) as View

        Log.i("RecylerView.Adapter", "new view created: $view")

        return TheHolder(view)
    }

    /**
     * Returns the number of items in the data set
     */
    override fun getItemCount() = data.size

    /**
     * invoked by RecyclerView to bind a new ViewHolder to item at the specified position
     */
    override fun onBindViewHolder(holder: TheHolder, position: Int) {
        val item = data[position]

//        Log.i("RecylerView.Adapter", "item: ${item}")

        holder.bind(item, position)
    }

    /**
     * Domain-specific ViewHolder class
     */
    inner class TheHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        private val name: TextView = v.findViewById(R.id.textView)

        fun bind(item: Location, position: Int) {
            name.text = item.name
            v.setOnClickListener { listener(item, position) }
        }
    }

}
