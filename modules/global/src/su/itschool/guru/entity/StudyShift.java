package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Table(name = "GURU_STUDY_SHIFT")
@Entity(name = "guru_StudyShift")
@NamePattern("%s|shiftName")
public class StudyShift extends StandardEntity {
    private static final long serialVersionUID = 1222323540514499793L;

    @NotNull
    @Column(name = "SHIFT_NUMBER", nullable = false)
    @Positive
    @Max(4)
    private Integer shiftNumber;

    @NotNull
    @OnDeleteInverse(DeletePolicy.DENY)
    @OnDelete(DeletePolicy.DENY)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MAIN_LESSONS_GRID_ID")
    private LessonsGridType mainLessonsGrid;

    @Transient
    @MetaProperty(related = "shiftNumber")
    public String getShiftName() {
        if(shiftNumber != null)
        {
            //todo localize
            return shiftNumber + " смена";
        }
        return null;
    }

    public LessonsGridType getMainLessonsGrid() {
        return mainLessonsGrid;
    }

    public void setMainLessonsGrid(LessonsGridType mainLessonsGrid) {
        this.mainLessonsGrid = mainLessonsGrid;
    }

    public Integer getShiftNumber() {
        return shiftNumber;
    }

    public void setShiftNumber(Integer shiftNumber) {
        this.shiftNumber = shiftNumber;
    }
}