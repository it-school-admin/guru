package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_CLASS_LETTER")
@Entity(name = "guru_ClassLetter")
@NamePattern("%s|letter")
public class ClassLetter extends StandardEntity {
    private static final long serialVersionUID = -8037808131884153448L;

    @NotNull
    @Column(name = "LETTER", nullable = false, unique = true)
    private Character letter;

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }
}