package su.itschool.guru.service;

import org.springframework.stereotype.Service;

@Service(SettingsProviderService.NAME)
public class SettingsProviderServiceBean implements SettingsProviderService {

    @Override
    public Integer getIntegerParameter(String parameterName) {
        if(parameterName.equals(FULL_TIME_LESSON_DEFAULT_DURATION))
        {
            //TODO read from database
            return 40;
        }

        if(parameterName.equals(DISTANT_LESSON_DEFAULT_DURATION))
        {
            //TODO read from database
            return 30;
        }
        //TODO
        throw new RuntimeException();
    }
}