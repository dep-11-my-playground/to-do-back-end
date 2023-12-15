package lk.ijse.dep11.todoapp.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskTO implements Serializable {

    @Null(message = "Id should be empty")
    private Integer id;
    @NotBlank(message = "Description can not be empty")
    private String description;
    @Null(message = "Status should be empty", groups = Create.class)            // Create
    @NotNull(message = "Status should not be empty", groups = Update.class)     // Update
    private Boolean status;
    @NotEmpty(message = "email can't be empty")
    @Email
    private String email;

    public interface Update extends Default {}
    public interface Create extends Default {}
}
