package eu.calendrify.calendrifyback.persistence.focus;

import eu.calendrify.calendrifyback.controller.focus.dto.FocusInfo;
import eu.calendrify.calendrifyback.controller.focus.dto.NewFocus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FocusMapper {

    @Mapping(source = "topic", target = "topic")
    @Mapping(source = "isSelected", target = "isSelected")
    FocusInfo toFocusInfo(Focus focus);

    List<FocusInfo> toFocusInfos(List<Focus> focuses);

    @Mapping(source = "topic", target = "topic")
    @Mapping(constant = "false", target = "isSelected")
    @Mapping(source = "monthNumber", target = "monthNumber")
    @Mapping(source = "year", target = "year")
    @Mapping(source = "type", target = "type")
    Focus toFocus(NewFocus newFocus);

}