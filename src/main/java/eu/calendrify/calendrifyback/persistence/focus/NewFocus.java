package eu.calendrify.calendrifyback.persistence.focus;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Focus}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewFocus implements Serializable {
    @NotNull
    private Integer userId;

    @NotNull
    @Size(max = 255)
    private String topic;

    @NotNull
    private Integer monthNumber;

    @NotNull
    private Integer year;

    @NotNull
    @Size(max = 1)
    private String type;
}