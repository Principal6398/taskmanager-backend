package com.taskmanager.taskmanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.taskmanager.taskmanager.entity.Task;
import com.taskmanager.taskmanager.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskRepository repo;

    @PostMapping
    public Task create(@RequestBody Task task){
        task.setStatus("PENDING");
        return repo.save(task);
    }

    @GetMapping
    public List<Task> getAll(){
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id){
        Task t = repo.findById(id).get();
        t.setStatus("DONE");
        return repo.save(t);
    }
}
