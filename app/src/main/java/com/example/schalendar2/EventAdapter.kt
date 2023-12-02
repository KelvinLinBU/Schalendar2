import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.schalendar2.Event
import com.example.schalendar2.R


class EventAdapter(private val eventList: List<Event>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val courseTextView: TextView = itemView.findViewById(R.id.courseTextView)
        private val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
        private val priorityTextView: TextView = itemView.findViewById(R.id.priorityTextView)

        fun bind(event: Event) {
            nameTextView.text = event.name
            courseTextView.text = event.course
            timeTextView.text = event.time
            priorityTextView.text = event.priority.toString()

            val color = when (event.priority) {
                1 -> Color.GREEN
                2 -> Color.YELLOW
                3 -> Color.RED
                else -> Color.BLACK // Default color for other cases
            }
            priorityTextView.setTextColor(color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int = eventList.size
}
