package eu.calendrify.calendrifyback.controller.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserPassword implements Serializable {

    @NotNull
    @Size(max = 255)
    private String password;

}
