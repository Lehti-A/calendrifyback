package eu.calendrify.calendrifyback.persistence.image;

import eu.calendrify.calendrifyback.controller.image.dto.ImageInfo;
import eu.calendrify.calendrifyback.controller.image.dto.NewImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImageMapper {



    @Mapping(source = "id", target = "imageId")
    @Mapping(source = "day.id", target = "dayId")
    @Mapping(source = "data", target = "data")
    ImageInfo toImageInfo(Image image);

    List<ImageInfo> toImageInfos(List<Image> images);


    @Mapping(source = "data", target = "data")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "day", ignore = true)
    Image toImage(NewImage newImage);

}