package ro.alex.springonetooneapi.models.dtos;



import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ComputerDTO implements Serializable {


    private Long id;

    @NotEmpty(message = "time_limit cannot be empty")
    private String timeLimit;

    @NotEmpty(message = "password cannot be empty")
    private String password;



}
