package poncho.boncho.zoodatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import poncho.boncho.zoodatabase.data.Worker
import poncho.boncho.zoodatabase.data.WorkerDao

class WorkerViewModel(private val workerDao: WorkerDao): ViewModel() {

    private fun insertWorker(worker: Worker){
        viewModelScope.launch {
            workerDao.insert(worker)
        }
    }

    private fun getNewWorkerEntry(workerName: String): Worker {
        return Worker(
            workerName= workerName,
        )
    }

    fun addNewWorker(workerName: String){
        val newWorker = getNewWorkerEntry(workerName)
        insertWorker(newWorker)
    }

    fun isEntryValid(workerName: String): Boolean {
        if (workerName.isBlank()) {
            return false
        }
        return true
    }
}

class WorkerViewModelFactory(private val workerDao: WorkerDao) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WorkerViewModel::class.java)){
            @Suppress ("UNCHECKED_CAST")
            return WorkerViewModel(workerDao) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}