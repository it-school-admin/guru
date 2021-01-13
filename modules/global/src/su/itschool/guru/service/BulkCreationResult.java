package su.itschool.guru.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class BulkCreationResult implements Serializable {
    private Boolean allIsOK = true;
    private Collection<String> namesWithProblems = new ArrayList();

    public Collection<String> getNamesWithProblems() {
        if (!allIsOK)
        {
            return namesWithProblems;
        }
        else
        {
            //TODO message
            throw new RuntimeException();
        }
    }

    public Boolean allIsOK() {
        return allIsOK;
    }

    public void addErrorResult(String itemName){
        allIsOK = false;
        namesWithProblems.add(itemName);
    }

}
