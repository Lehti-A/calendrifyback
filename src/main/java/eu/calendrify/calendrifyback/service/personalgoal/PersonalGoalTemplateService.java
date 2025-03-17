package eu.calendrify.calendrifyback.service.personalgoal;

import eu.calendrify.calendrifyback.controller.personalgoal.dto.NewPersonalGoalTemplate;
import eu.calendrify.calendrifyback.controller.personalgoal.dto.PersonalGoalTemplateInfo;
import eu.calendrify.calendrifyback.persistence.personalgoaltemplate.PersonalGoalTemplate;
import eu.calendrify.calendrifyback.persistence.personalgoaltemplate.PersonalGoalTemplateMapper;
import eu.calendrify.calendrifyback.persistence.personalgoaltemplate.PersonalGoalTemplateRepository;
import eu.calendrify.calendrifyback.persistence.user.User;
import eu.calendrify.calendrifyback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalGoalTemplateService {

    private final UserRepository userRepository;
    private final PersonalGoalTemplateRepository personalGoalTemplateRepository;
    private final PersonalGoalTemplateMapper personalGoalTemplateMapper;

    public void addNewPersonalGoalTemplate(NewPersonalGoalTemplate newPersonalGoalTemplate, Integer userId) {
        PersonalGoalTemplate personalGoalTemplate = createNewPersonalGoalTemplate(newPersonalGoalTemplate, userId);
        personalGoalTemplateRepository.save(personalGoalTemplate);

    }

    public List<PersonalGoalTemplateInfo> findPersonalGoalTemplateInfos(Integer userId) {
        List<PersonalGoalTemplate> personalGoalTemplates = personalGoalTemplateRepository.findPersonalGoalTemplatesBy(userId);
        return personalGoalTemplateMapper.toPersonalGoalTemplateInfos(personalGoalTemplates);
    }

    public void deletePersonalGoalTemplate(Integer personalGoalTemplateId) {
        PersonalGoalTemplate personalGoalTemplate = personalGoalTemplateRepository.getReferenceById(personalGoalTemplateId);
        personalGoalTemplateRepository.delete(personalGoalTemplate);

    }

    private PersonalGoalTemplate createNewPersonalGoalTemplate(NewPersonalGoalTemplate newPersonalGoalTemplate, Integer userId) {
        User user = userRepository.findUserById(userId);
        PersonalGoalTemplate personalGoalTemplate = personalGoalTemplateMapper.toPersonalGoalTemplate(newPersonalGoalTemplate);
        personalGoalTemplate.setUser(user);
        return personalGoalTemplate;

    }
}
