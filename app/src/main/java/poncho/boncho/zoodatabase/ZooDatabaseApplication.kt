package poncho.boncho.zoodatabase

import android.app.Application
import poncho.boncho.zoodatabase.data.ItemRoomDatabase

class ZooDatabaseApplication : Application() {
    val database: ItemRoomDatabase by lazy { ItemRoomDatabase.getDatabase(this) }
}