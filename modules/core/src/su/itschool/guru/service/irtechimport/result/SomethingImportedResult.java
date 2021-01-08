package su.itschool.guru.service.irtechimport.result;

import su.itschool.guru.service.irtechimport.ImportResult;

public class SomethingImportedResult implements ImportResult {
    static public ImportResult somethingImported(String message, String... parameters)
    {
        return new SomethingImportedResult(message, parameters);
    }
    private final String result;

    public SomethingImportedResult(String message, String... parameters)
    {
        result = parseParameters(message, parameters);
    }

    private String parseParameters(String message, String[] parameters) {

        String result = "";

        for (int i=0; i<parameters.length; i++)
        {
            result = message.replace("%"+i, parameters[i]);
        }
        return result;
    }

    @Override
    public final String getResultString()
    {
        return result;
    }

    @Override
    public Boolean isImported()
    {
        return true;
    }
}
