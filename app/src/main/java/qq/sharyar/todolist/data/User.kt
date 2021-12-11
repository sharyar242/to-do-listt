package qq.sharyar.todolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")

class User (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val missionName:String,
    val dateName:Int
        )