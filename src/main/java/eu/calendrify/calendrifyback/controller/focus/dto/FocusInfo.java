package eu.calendrify.calendrifyback.controller.focus.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FocusInfo {

    private Integer focusId;
    private String topic;
    private Boolean isSelected;

}
