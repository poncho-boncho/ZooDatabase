package poncho.boncho.zoodatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import poncho.boncho.zoodatabase.databinding.WorkerItemBinding

class ItemAdapter(private val context: Context,private val dataset: List<Worker>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
       // val binding = WorkerItemBinding.bind(view)
        val textView: TextView = view.findViewById(R.id.workerName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.worker_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int{
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.toString()
    }
}