package project.todo.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Todo {
    @Id @GeneratedValue
    private Long id;

    private String name;

    private boolean completed;

    public void changeName(String name) {
        this.name = name;
    }
    public void changeCompleted(boolean completed) {
        this.completed = completed;
    }

    public Todo() {
    }

    public Todo(String name) {
        this.name = name;
    }

    public Todo(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
    }
}
