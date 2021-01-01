package su.itschool.guru.service;

import java.io.File;
import java.io.Serializable;

public class ImportSettings implements Serializable {
    public Boolean doImport = false;
    public File importedFile;
}
