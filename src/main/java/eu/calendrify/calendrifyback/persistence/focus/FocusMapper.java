package eu.calendrify.calendrifyback.persistence.focus;

import eu.calendrify.calendrifyback.controller.focus.dto.FocusInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FocusMapper {
   //todo Focus toEntity(FocusInfo focusInfo);


    @Mapping(source = "id", target = "focusId")
    @Mapping(source = "topic", target = "topic")
    @Mapping(source = "isSelected", target = "isSelected")
    FocusInfo toFocusInfo(Focus focus);

    List<FocusInfo> toFocusInfos(List<Focus> focuses);


}