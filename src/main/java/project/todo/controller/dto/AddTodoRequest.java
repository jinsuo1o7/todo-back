package project.todo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class AddTodoRequest {
    @NotBlank
    private String name;

    public AddTodoRequest() {
    }
}
