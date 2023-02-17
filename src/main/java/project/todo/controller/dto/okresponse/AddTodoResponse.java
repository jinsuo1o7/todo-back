package project.todo.controller.dto.okresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AddTodoResponse extends OkResponse {
    private Long id;

    public AddTodoResponse(String message, HttpStatus status, Long id) {
        super(message, status);
        this.id = id;
    }
}
