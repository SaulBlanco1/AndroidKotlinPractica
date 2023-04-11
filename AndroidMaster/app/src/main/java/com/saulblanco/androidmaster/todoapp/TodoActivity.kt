package com.saulblanco.androidmaster.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.saulblanco.androidmaster.R
import com.saulblanco.androidmaster.mutableList
import com.saulblanco.androidmaster.todoapp.TaskCategory.*

class TodoActivity : AppCompatActivity() {

    //Lo que recibe aquí, es lo que pinta por pantalla
    private val categories = listOf(
        Business,
        Personal,
        Other
    )

    private val tasks= mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaPersonal", Personal),
        Task("PruebaOtros", Other)

    )


    private lateinit var rvCategories:RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks:RecyclerView
    private lateinit var tasksAdapter: TasksAdapter

    private lateinit var fabAddTask:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button =dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText =dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup =dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener{
            val currentTask=etTask.text.toString()
            if(currentTask.isNotEmpty()){
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton:RadioButton= rgCategories.findViewById(selectedId)
                val currentCategory:TaskCategory=when(selectedRadioButton.text){
                    getString(R.string.todo_dialog_category_business)->Business
                    getString(R.string.todo_dialog_category_personal)->Personal
                    else->Other
                }
                tasks.add(Task(currentTask,currentCategory))
                updateTasks()
                dialog.hide()
            }



        }

        dialog.show()
    }

    private fun initComponent() {
        rvCategories=findViewById(R.id.rvCategories)
        rvTasks=findViewById(R.id.rvTasks)
        fabAddTask=findViewById(R.id.fabAddTask)

    }


    private fun initUI() {
        categoriesAdapter=CategoriesAdapter(categories) {updateCategories(it)}
        rvCategories.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter = categoriesAdapter

        //it es el int que devuelve la función LAMBDA, en este caso la posición // Se recomienda
        //Sacar la función LAMBDA del paréntesis
        tasksAdapter = TasksAdapter(tasks) {onItemSelected(it)}
        rvTasks.layoutManager= LinearLayoutManager(this)
        rvTasks.adapter=tasksAdapter

    }

    private fun onItemSelected(position:Int){
        tasks[position].isSelected=!tasks[position].isSelected
        updateTasks()
    }

    private fun updateCategories(position:Int){
        categories[position].isSelected=!categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }


    private fun updateTasks(){
        val selectedCategories:List<TaskCategory> = categories.filter{it.isSelected}
        //filter actua como un bucle revisando todas las categorias seleccionadas
        //it.category indica la categoria de la tarea, si es una categoria seleccionada, la
        //añade al filtro("newTasks")
        val newTasks = tasks.filter{selectedCategories.contains(it.category)}
        tasksAdapter.tasks = newTasks
        tasksAdapter.notifyDataSetChanged()
    }





}