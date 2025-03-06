package eu.calendrify.calendrifyback.service.image;

import eu.calendrify.calendrifyback.controller.image.dto.ImageInfo;
import eu.calendrify.calendrifyback.controller.image.dto.NewImage;
import eu.calendrify.calendrifyback.persistence.day.Day;
import eu.calendrify.calendrifyback.persistence.day.DayRepository;
import eu.calendrify.calendrifyback.persistence.image.Image;
import eu.calendrify.calendrifyback.persistence.image.ImageMapper;
import eu.calendrify.calendrifyback.persistence.image.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final DayRepository dayRepository;
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    public void addNewImage(NewImage newImage) {
        Image image = createNewImage(newImage);
        imageRepository.save(image);
    }

    public List<ImageInfo> findImageInfos(Integer dayId) {
        List<Image> images = imageRepository.findImageBy(dayId);
        List<ImageInfo> imageInfos = imageMapper.toImageInfos(images);
        return imageInfos;
    }

    public void deleteImage(Integer imageId) {
        Image image = imageRepository.getReferenceById(imageId);
        imageRepository.delete(image);
    }

    private Image createNewImage(NewImage newImage) {
        Day day = dayRepository.getReferenceById(newImage.getDayId());
        Image image = imageMapper.toImage(newImage);
        image.setDay(day);
        return image;
    }

}
