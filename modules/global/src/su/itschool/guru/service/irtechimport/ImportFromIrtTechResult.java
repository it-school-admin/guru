package su.itschool.guru.service.irtechimport;

import java.util.List;

public interface ImportFromIrtTechResult {
    void addResult(ImportResult importResult);

    String getResultText();
}
