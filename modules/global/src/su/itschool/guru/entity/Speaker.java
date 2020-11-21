package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_SPEAKER", indexes = {
        @Index(name = "IDX_GURU_SPEAKER_SURNAME", columnList = "SPEAKER_SURNAME")
})
@Entity(name = "guru_Speaker")
@NamePattern("%s %s|speakerName,speakerSurname")
public class Speaker extends StandardEntity {
    private static final long serialVersionUID = -4290627941617697136L;

    @NotNull
    @Column(name = "SPEAKER_NAME", nullable = false)
    private String speakerName;

    @Column(name = "SPEAKER_SURNAME")
    private String speakerSurname;

    @NotNull
    @Column(name = "SPEAKER_EMAIL", nullable = false)
    @Email(message = "Пожалуйста, введите правильный E-mail")
    private String speakerEmail;

    public String getSpeakerEmail() {
        return speakerEmail;
    }

    public void setSpeakerEmail(String speakerEmail) {
        this.speakerEmail = speakerEmail;
    }

    public String getSpeakerSurname() {
        return speakerSurname;
    }

    public void setSpeakerSurname(String speakerSurname) {
        this.speakerSurname = speakerSurname;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }
}