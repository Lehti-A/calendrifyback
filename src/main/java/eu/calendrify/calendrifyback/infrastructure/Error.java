package eu.calendrify.calendrifyback.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutaja email või parool", 111),
    // todo: kustuta NO_LOCATION_FOUND("Ei leitud ühtegi pangaautomaati", 222),
    // todo: kustuta  LOCATION_UNAVAILABLE("Sellise nimega pangaautomaadi asukoht on juba süsteemis olemas", 333),
    PRIMARY_KEY_NOT_FOUND("Ei leidnud primary keyd: ", 888),
    FOREIGN_KEY_NOT_FOUND("Ei leidnud foreign keyd: ", 999);

    private final String message;
    private final int errorCode;
}
