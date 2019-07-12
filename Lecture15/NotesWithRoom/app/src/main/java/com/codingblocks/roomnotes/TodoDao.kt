package com.codingblocks.roomnotes

import androidx.room.*

@Dao
interface TodoDao {

    @Insert
    fun insertRow(todo: Todo)

    @Insert
    fun insertMultiple(todolist: ArrayList<Todo>)

    @Query("Select * FROM Todo")
    fun getAllTask(): List<Todo>

    @Query("Select * FROM Todo WHERE status = :done")
    fun getAllDoneTask(done: Boolean): List<Todo>

    @Delete
    fun deleteTask(todo: Todo)

}