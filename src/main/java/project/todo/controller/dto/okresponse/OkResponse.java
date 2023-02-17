package project.todo.controller.dto.okresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class OkResponse {
    private String message;
    private HttpStatus status;
    public OkResponse() {
    }
}
