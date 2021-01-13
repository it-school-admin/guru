package su.itschool.guru.web.bulkcreation;

import com.haulmont.cuba.gui.Notifications;
import su.itschool.guru.service.BulkCreationResult;

import java.util.Collection;

public class BulkCreationNotifier {
    private final Notifications notifications;

    public BulkCreationNotifier(Notifications notifications) {

        this.notifications = notifications;
    }

    public void showBulkCreationResult(BulkCreationResult result)
    {
        if(result.allIsOK())
        {
            notifications.create().withCaption("Записи созданы").show();
        }
        else {
            notifications.create()
                    .withCaption("Со следующими записями возникли проблемы:")
                    .withDescription(getMessageText(result.getNamesWithProblems()))
                    .show();

        }
    }

    private String getMessageText(Collection<String> namesWithProblems) {
        StringBuilder result = new StringBuilder();
        for (String name: namesWithProblems)
        {
            result.append(name).append("\n");
        }
        return result.toString();
    }

}
