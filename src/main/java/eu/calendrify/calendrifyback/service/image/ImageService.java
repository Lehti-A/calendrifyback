package eu.calendrify.calendrifyback.service.image;

import eu.calendrify.calendrifyback.controller.image.dto.ImageInfo;
import eu.calendrify.calendrifyback.controller.image.dto.NewImage;
import eu.calendrify.calendrifyback.infrastructure.Error;
import eu.calendrify.calendrifyback.infrastructure.exception.DataNotFoundException;
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
        createAndSaveImage(newImage);
    }

    public ImageInfo findImageInfo(Integer dayId) {
        List<Image> images = imageRepository.findImageBy(dayId);

        if (images.isEmpty()) {
            throw new DataNotFoundException(
                    Error.IMAGE_NOT_FOUND.getMessage() + dayId,
                    Error.IMAGE_NOT_FOUND.getErrorCode()
            );
        }

        // Return the first image found for the day
        Image image = images.get(0);
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
        try {
            Day day = dayRepository.getReferenceById(newImage.getDayId());
            Image image = imageMapper.toImage(newImage);
            image.setDay(day);
            return image;
        } catch (Exception e) {
            throw new DataNotFoundException(
                    Error.FOREIGN_KEY_NOT_FOUND.getMessage() + newImage.getDayId(),
                    Error.FOREIGN_KEY_NOT_FOUND.getErrorCode()
            );
        }
    }

    private Image getImageById(Integer imageId) {
        try {
            return imageRepository.getReferenceById(imageId);
        } catch (Exception e) {
            throw new DataNotFoundException(
                    Error.PRIMARY_KEY_NOT_FOUND.getMessage() + imageId,
                    Error.PRIMARY_KEY_NOT_FOUND.getErrorCode()
            );
        }
    }

    private void getAndDeleteImage(Integer imageId) {
        Image image = getImageById(imageId);
        imageRepository.delete(image);
    }
}