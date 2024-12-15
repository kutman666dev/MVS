package com.example.demo.model.controller;

import com.example.demo.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    // Показать список задач
    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", tasks);
        return "task-list";
    }

    // Добавить новую задачу
    @PostMapping
    public String addTask(@RequestParam String title) {
        Task task = new Task(nextId++, title, false);
        tasks.add(task);
        return "redirect:/tasks";
    }

    // Показать форму редактирования задачи
    @GetMapping("/{id}/edit")
    public String editTask(@PathVariable int id, Model model) {
        Task task = findTaskById(id);
        if (task != null) {
            model.addAttribute("task", task);
            return "task-edit";
        }
        return "redirect:/tasks";
    }

    // Обновить задачу
    @PostMapping("/{id}/edit")
    public String updateTask(@PathVariable int id, @RequestParam String title) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setTitle(title);
        }
        return "redirect:/tasks";
    }

    // Удалить задачу
    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable int id) {
        tasks.removeIf(task -> task.getId() == id);
        return "redirect:/tasks";
    }

    // Найти задачу по ID
    private Task findTaskById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
