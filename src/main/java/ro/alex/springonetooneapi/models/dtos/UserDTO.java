package ro.alex.springonetooneapi.models.dtos;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private Long id;

    @NotEmpty(message = "first_name cannot be empty")
    private String firstName;

    @NotEmpty(message = "last_name cannot be empty")
    private String lastName;

    @NotNull(message = "age cannot null")
    private int age;

    private String email;


}
