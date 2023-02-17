package project.todo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class UpdateTodoRequest {
    private String name;
    private boolean completed;

    public UpdateTodoRequest(String name) {
        this.name = name;
    }

    public UpdateTodoRequest(boolean completed) {
        this.completed = completed;
    }

    public UpdateTodoRequest() {
    }
}
