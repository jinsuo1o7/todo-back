package project.todo.controller.dto.okresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import project.todo.domain.Todo;

@Getter
@AllArgsConstructor
public class TodoResponse {
    private Long id;
    private String name;
    private boolean completed;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.name = todo.getName();
        this.completed = todo.isCompleted();
    }

    public TodoResponse() {
    }
}
