package eu.calendrify.calendrifyback.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type {
    PERSONAL("P"),
    WORK("W");

    private final String code;

}
