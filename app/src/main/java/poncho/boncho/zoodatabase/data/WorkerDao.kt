package poncho.boncho.zoodatabase.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(worker: Worker)

    @Update
    suspend fun update(worker: Worker)

    @Delete
    suspend fun delete(worker: Worker)

    @Query("SELECT * from item WHERE id = :id")
    fun getWorker(id: Int): Flow<Worker>
}