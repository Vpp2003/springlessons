package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @PostMapping("/tasks")
    public Task create (@RequestBody Task task){
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id){
        return taskRepository.findById(id).orElse(null);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Long id){
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id){
        taskRepository.deleteById(id);

        return "Task with id " + id + " was successfully deleted.";
    }

    @PatchMapping("/tasks/{id}")
    public void patchMethod(@PathVariable Long id,
                            @RequestBody Task task){
        if(task.isDone())
            taskRepository.markAsDone(id);
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void pathMethod(@PathVariable Long id){
        taskRepository.markAsDone(id);
    }
}
