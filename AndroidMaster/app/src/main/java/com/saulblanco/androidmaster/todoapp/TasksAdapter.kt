package com.saulblanco.androidmaster.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saulblanco.androidmaster.R

//->Unit se utiliza para indicar que es función LAMBDA // (Int) porque devuelve un int
class TasksAdapter(var tasks: List<Task>, private val onTaskSelected: (Int) -> Unit) :
    RecyclerView.Adapter<TasksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
        return TasksViewHolder(view)

    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(tasks[position])
        //Listeners que cuando se pulse un item, ejecute la función LAMBDA con la posición del item
        holder.itemView.setOnClickListener{onTaskSelected(position)}

    }

    override fun getItemCount() = tasks.size
}