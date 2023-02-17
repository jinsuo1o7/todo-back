package project.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import project.todo.controller.dto.*;
import project.todo.controller.dto.okresponse.AddTodoResponse;
import project.todo.controller.dto.okresponse.OkResponse;
import project.todo.controller.dto.okresponse.TodoResponse;
import project.todo.domain.Todo;
import project.todo.service.TodoService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public OkResponse addTodo(@Valid @RequestBody AddTodoRequest request) {
        Todo todo = new Todo(request.getName(), false);
        Long id = todoService.addTodo(todo);
        return new AddTodoResponse("Todo Added!", OK, id);
    }

    @GetMapping
    public List<TodoResponse> getTodos() {
        return todoService.getAllTodos().stream()
                .map(TodoResponse::new)
                .collect(Collectors.toList());
    }

    @PatchMapping("/{id}")
    public OkResponse updateTodo(@PathVariable Long id, @Valid @RequestBody UpdateTodoRequest request) {
        todoService.updateTodo(id, request.getName().trim(), request.isCompleted());
        return new OkResponse(request.getName() + "updated", OK);
    }

    @DeleteMapping("/{id}")
    public OkResponse deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return new OkResponse(id + "is deleted", OK);
    }
}
