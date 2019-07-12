package com.codingblocks.roomnotes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {

    @Insert
    fun insertRow(todo: Todo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMultiple(todolist: ArrayList<Todo>)

    @Query("Select * FROM Todo")
    fun getAllTask(): LiveData<List<Todo>>

    @Query("Select * FROM Todo WHERE status = :done")
    fun getAllDoneTask(done: Boolean): List<Todo>

    @Delete
    fun deleteTask(todo: Todo)

}