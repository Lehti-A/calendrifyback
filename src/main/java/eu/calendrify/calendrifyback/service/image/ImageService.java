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

@Service
@RequiredArgsConstructor
public class ImageService {

    private final DayRepository dayRepository;
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    public void addNewImage(NewImage newImage) {
        createAndSaveImage(newImage);
    }

    public ImageInfo findImageInfo(Integer dayId) {
        Image image = getImageBy(dayId);
        return imageMapper.toImageInfo(image);
    }

    public void deleteImage(Integer imageId) {
        getAndDeleteImage(imageId);
    }

    private void createAndSaveImage(NewImage newImage) {
        Image image = createNewImage(newImage);
        imageRepository.save(image);
    }

    private Image createNewImage(NewImage newImage) {
        Day day = dayRepository.getReferenceById(newImage.getDayId());
        Image image = imageMapper.toImage(newImage);
        image.setDay(day);
        return image;
    }

    private Image getImageBy(Integer imageId) {
        return imageRepository.getReferenceById(imageId);
    }

    private void getAndDeleteImage(Integer imageId) {
        Image image = getImageBy(imageId);
        imageRepository.delete(image);
    }
}