package eu.calendrify.calendrifyback.controller.personalgoal;

import eu.calendrify.calendrifyback.controller.personalgoal.dto.NewPersonalGoalTemplate;
import eu.calendrify.calendrifyback.controller.personalgoal.dto.PersonalGoalTemplateInfo;
import eu.calendrify.calendrifyback.service.personalgoal.PersonalGoalTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonalGoalTemplateController {

    private final PersonalGoalTemplateService personalGoalTemplateService;

    @PostMapping("/settings-personal-goal")
    @Operation(summary = "Lisab uue PersonalGoalTemplate-i välja")
    public void addNewPersonalGoalTemplate(@RequestBody NewPersonalGoalTemplate newPersonalGoalTemplate, @RequestParam Integer userId) {
        personalGoalTemplateService.addNewPersonalGoalTemplate(newPersonalGoalTemplate, userId);
    }

    @GetMapping("/settings-personal-goal")
    @Operation(summary = "Tagastab PersonalGoalTemplate listi andmed")
    public List<PersonalGoalTemplateInfo> findPersonalGoalTemplateInfos(Integer userId) {
        return personalGoalTemplateService.findPersonalGoalTemplateInfos(userId);
    }

    @DeleteMapping("/settings-personal-goal")
    @Operation(summary = "Kustutab PersonalGoalTemplate-i välja")
    public void deletePersonalGoalTemplate(Integer personalGoalTemplateId) {
        personalGoalTemplateService.deletePersonalGoalTemplate(personalGoalTemplateId);
    }

}