package eu.calendrify.calendrifyback.controller.water.dto;

import eu.calendrify.calendrifyback.persistence.water.Water;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Water}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterInfo implements Serializable {

    private Integer waterId;
    private Integer count;
}