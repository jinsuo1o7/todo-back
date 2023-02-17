package project.todo.service;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.todo.domain.Todo;
import project.todo.repository.TodoRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
class TodoServiceTest {
    @Autowired
    TodoService todoService;
    @Autowired
    TodoRepository todoRepository;

    @Test
    void addTodo() {
        todoService.addTodo(new Todo("todo1", false));
        todoService.addTodo(new Todo("todo1", false));
        todoService.addTodo(new Todo("todo1", false));

        List<Todo> todos = todoService.getAllTodos();

        assertThat(todos.size()).isEqualTo(3);
    }

    @Test
    void updateTodo() {
        todoService.addTodo(new Todo("todo1", false));
        todoService.addTodo(new Todo("todo1", false));
        todoService.addTodo(new Todo("todo1", false));

        todoService.updateTodo(1L, "",true);
        boolean completed = todoRepository.findById(1L).get().isCompleted();
        assertThat(completed).isEqualTo(true);
    }

    @Test
    void deleteTodo() {
    }
}