package com.rationalstudio.todolist

import android.app.Application
import com.rationalstudio.todolist.Data.Database.TodoDatabase
import com.rationalstudio.todolist.Data.Repositories.ToDoRepository
import com.rationalstudio.todolist.ui.todolist.ToDoViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance

class TodoApplication:Application(),KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@TodoApplication))
        bind() from singleton { TodoDatabase(instance()) }
        bind() from singleton {
            ToDoRepository(
                instance()
            )
        }
        bind() from provider {
            ToDoViewModelFactory(
                instance()
            )
        }
    }

}