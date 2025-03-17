package eu.calendrify.calendrifyback.service.water;

import eu.calendrify.calendrifyback.controller.water.dto.WaterInfo;
import eu.calendrify.calendrifyback.infrastructure.exception.DataNotFoundException;
import eu.calendrify.calendrifyback.persistence.water.Water;
import eu.calendrify.calendrifyback.persistence.water.WaterMapper;
import eu.calendrify.calendrifyback.persistence.water.WaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static eu.calendrify.calendrifyback.infrastructure.Error.FOREIGN_KEY_NOT_FOUND;
import static eu.calendrify.calendrifyback.infrastructure.Error.PRIMARY_KEY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class WaterService {

    private final WaterRepository waterRepository;
    private final WaterMapper waterMapper;

    public void updateWater(Integer waterId, Integer count) {
        Water water = getSelectedWater(waterId);
        water.setCount(count);
        waterRepository.save(water);
    }

    private Water getSelectedWater(Integer waterId) {
        return waterRepository.findById(waterId)
                .orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode()));
    }

    public WaterInfo findWaterInfo(Integer userId, LocalDate date) {
        Water water = waterRepository.findWaterBy(userId, date).orElseThrow(() -> new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode()));

        if (water == null) {
            return null;
        }
        return waterMapper.toWaterinfo(water);

    }
}