package au.edu.swin.sdmd.l07_alltheimages.recyclerview

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import au.edu.swin.sdmd.l07_alltheimages.R
import au.edu.swin.sdmd.l07_alltheimages.model.Location

class DetailActivity : AppCompatActivity() {
    // version 2.0
    private var location: Location? = null

    private var changed: Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val vVisited = findViewById<Switch>(R.id.visited)
        changed = false

        vVisited.setOnClickListener {
            if (vVisited.isChecked != location!!.visited) {
                location!!.visited = vVisited.isChecked
                changed = true
            }
        }

        location = intent.getParcelableExtra<Location>("location")

        location?.let {

            val vName = findViewById<TextView>(R.id.name)
            vName.text = it.name

            val vAuthor = findViewById<TextView>(R.id.author)
            vAuthor.text = it.author

            val vImage = findViewById<ImageView>(R.id.imageView)
            vImage.setImageDrawable(resources.getDrawable(it.image, theme))

            vVisited.isChecked = it.visited
        }


    }

    /**
     * Handle user click on "Back": inform MainActivity with result
     * @version 2.0
     */
    override fun onBackPressed() {
        // pass result back to Main Activity
        if (changed) {
            val i = intent.apply {
                putExtra("visited", location)
            }
            setResult(Activity.RESULT_OK, i)
        }

        // called last!
        super.onBackPressed()
    }
}