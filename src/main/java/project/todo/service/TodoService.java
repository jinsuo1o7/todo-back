package project.todo.service;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.todo.domain.Todo;
import project.todo.exception.NotFoundTodoException;
import project.todo.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public Long addTodo(Todo todo) {
        todoRepository.save(todo);
        return todo.getId();
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    @Transactional
    public void updateTodo(Long id, String name, boolean completed) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new NotFoundTodoException("no todo"));
        if(name.equals("")){
            todo.changeCompleted(completed);
            return;
        }

        todo.changeName(name);
        todo.changeCompleted(completed);
    }

    @Transactional
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
