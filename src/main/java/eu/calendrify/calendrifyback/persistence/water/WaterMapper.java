package eu.calendrify.calendrifyback.persistence.water;

import eu.calendrify.calendrifyback.controller.day.dto.NewDay;
import eu.calendrify.calendrifyback.controller.water.dto.WaterInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface WaterMapper {
    @Mapping(source = "date", target = "date")
    @Mapping(constant = "0", target = "count")
    Water toWater(NewDay newDay);


    @Mapping(source = "id", target = "waterId")
    @Mapping(source = "count", target = "count")
    WaterInfo toWaterinfo(Water water);

}