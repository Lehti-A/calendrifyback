package eu.calendrify.calendrifyback.controller.image.dto;

import eu.calendrify.calendrifyback.persistence.image.Image;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Image}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageInfo implements Serializable {

    @NotNull
    private Integer imageId;
    @NotNull
    private Integer dayId;
    @NotNull
    private byte[] data;
}