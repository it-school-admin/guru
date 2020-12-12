package su.itschool.guru.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table(name = "GURU_TIME_TABLE_IMPORT")
@Entity(name = "guru_TimeTableImport")
public class TimeTableImport extends StandardEntity {
    private static final long serialVersionUID = -1013166056356925690L;

    @NotNull
    @Column(name = "IMPORT_TIME", nullable = false)
    private LocalDateTime importTime;

    @NotNull
    @Lob
    @Column(name = "IMPORT_XML_DATA", nullable = false)
    private String importXMLData;

    public String getImportXMLData() {
        return importXMLData;
    }

    public void setImportXMLData(String importXMLData) {
        this.importXMLData = importXMLData;
    }

    public LocalDateTime getImportTime() {
        return importTime;
    }

    public void setImportTime(LocalDateTime importTime) {
        this.importTime = importTime;
    }
}