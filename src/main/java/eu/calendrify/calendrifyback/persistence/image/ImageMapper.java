package eu.calendrify.calendrifyback.persistence.image;

import eu.calendrify.calendrifyback.controller.image.dto.ImageInfo;
import eu.calendrify.calendrifyback.controller.image.dto.NewImage;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImageMapper {



    @Mapping(source = "data" , target = "data")
    ImageInfo toImageInfo(Image image);

    List <ImageInfo> toImageInfos(List<Image> images);


    @Mapping(source = "data", target = "data")
    Image toImage(NewImage newImage);


}