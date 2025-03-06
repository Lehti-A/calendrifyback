package eu.calendrify.calendrifyback.service.water;

import eu.calendrify.calendrifyback.infrastructure.exception.DataNotFoundException;
import eu.calendrify.calendrifyback.persistence.water.Water;
import eu.calendrify.calendrifyback.persistence.water.WaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static eu.calendrify.calendrifyback.infrastructure.Error.PRIMARY_KEY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class WaterService {

    private final WaterRepository waterRepository;

    public void updateWater(Integer waterId, Integer count) {
        Water water = getSelectedWater(waterId);
        water.setCount(count);
        waterRepository.save(water);
    }

    private Water getSelectedWater(Integer waterId) {
        Water water = waterRepository.findById(waterId)
                .orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode()));
        return water;
    }
}
