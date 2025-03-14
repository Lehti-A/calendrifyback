package eu.calendrify.calendrifyback.controller.personalgoal;

import eu.calendrify.calendrifyback.controller.personalgoal.dto.NewPersonalGoal;
import eu.calendrify.calendrifyback.controller.personalgoal.dto.PersonalGoalInfo;
import eu.calendrify.calendrifyback.service.personalgoal.PersonalGoalService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonalGoalController {

    private final PersonalGoalService personalGoalService;

    @GetMapping("/personal-goal")
    @Operation(summary = "Tagastab PersonalGoal listi andmed päeva kohta")
    public List<PersonalGoalInfo> findPersonalGoalInfos(@RequestParam Integer dayId) {
        return personalGoalService.findPersonalGoalInfos(dayId);
    }

    @PostMapping("/personal-goal")
    @Operation(summary = "Lisab uue PersonalGoali")
    public void addPersonalGoal(@RequestBody NewPersonalGoal newPersonalGoal, @RequestParam Integer dayId) {
        personalGoalService.addPersonalGoal(newPersonalGoal, dayId);
    }

    @PatchMapping("/personal-goal")
    @Operation(summary = "Märgib PersonalGoali tehtuks/mitte tehtuks")
    public void updatePersonalGoalStatus(@RequestParam Integer personalGoalId, @RequestParam Boolean isDone) {
        personalGoalService.updatePersonalGoalStatus(personalGoalId, isDone);
    }

    @DeleteMapping("/personal-goal")
    @Operation(summary = "Kustutab PersonalGoali")
    public void deletePersonalGoal(@RequestParam Integer personalGoalId) {
        personalGoalService.deletePersonalGoal(personalGoalId);
    }

}