package service;

import entity.Todolist;
import repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService {

    private TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodolist() {
        System.out.println("TODOLIST");

        Todolist[] model = todolistRepository.getAll();

        if (model[0] == null) {
            System.out.println("Belum ada todolist, silahkan add todo.");
        } else {
            for (var i = 0; i < model.length; i++) {
                var todolist = model[i];
                var no = i + 1;

                if (todolist != null) {
                    System.out.println(no + ". " + todolist.getTodo());
                }
            }
        }
    }

    @Override
    public void addTodolist(String todo) {
        Todolist todolist = new Todolist(todo);
        todolistRepository.add(todolist);
        System.out.println("Sukses menambah todo: " + todo);
    }

    @Override
    public void removeTodolist(Integer number) {
        boolean success = todolistRepository.remove(number);
        if (success) {
            System.out.println("Sukses menghapus todo : " + number);
        } else {
            System.out.println("Gagal menghapus todo : " + number);
        }
    }
}
