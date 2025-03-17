package eu.calendrify.calendrifyback.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MoodState {
    UNSELECTED("U"),
    SAD("S"),
    NEUTRAL("N"),
    HAPPY("H");

    private final String code;
}