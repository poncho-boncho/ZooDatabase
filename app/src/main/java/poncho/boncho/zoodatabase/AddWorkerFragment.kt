package poncho.boncho.zoodatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import poncho.boncho.zoodatabase.databinding.FragmentAddWorkerBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddWorkerFragment : Fragment() {

    private var _binding: FragmentAddWorkerBinding? = null
    private lateinit var recyclerView: RecyclerView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var worker: Worker

    private val viewModel: WorkerViewModel by activityViewModels {
        WorkerViewModelFactory(
            (activity?.application as ZooDatabaseApplication).database
                .workerDao()
        )
    }

    fun isEntryValid(workerName: String): Boolean {
        if (workerName.isBlank()) {
            return false
        }
        return true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddWorkerBinding.inflate(inflater, container, false)
        return binding.root

    }
    private fun isEntryValid(): Boolean{
        return viewModel.isEntryValid(
            binding.workerName.text.toString()
        )
    }

    private fun addNewWorker(){
        if(isEntryValid()){
            viewModel.addNewWorker(
                binding.workerName.text.toString()
            )
        }
        val action = Add
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      //  recyclerView = binding.recyclerView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}