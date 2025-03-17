package eu.calendrify.calendrifyback.controller.image;

import eu.calendrify.calendrifyback.controller.image.dto.ImageInfo;
import eu.calendrify.calendrifyback.controller.image.dto.NewImage;
import eu.calendrify.calendrifyback.service.image.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/image")
    @Operation(summary = "Lisab uue pildi andmebaasi")
    public void addNewImage(@RequestBody NewImage newImage) {
        imageService.addNewImage(newImage);
    }

    @GetMapping("/image")
    @Operation(summary = "Tagastab pildi andmed")
    public ImageInfo findImageInfo(@RequestParam Integer dayId) {
        return imageService.findImageInfo(dayId);
    }

    @DeleteMapping("/image")
    @Operation(summary = "Kustutab pildi andmebaasist")
    public void deleteImage(@RequestParam Integer imageId) {
        imageService.deleteImage(imageId);
    }
}