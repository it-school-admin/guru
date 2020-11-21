package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Table(name = "GURU_SESSION")
@Entity(name = "guru_Session")
@NamePattern("%s|topic")
public class Session extends StandardEntity {
    private static final long serialVersionUID = 479009085158631536L;

    @NotNull
    @Column(name = "TOPIC", nullable = false)
    private String topic;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SPEAKER_ID")
    private Speaker speaker;

    @NotNull
    @Column(name = "START_TIME", nullable = false)
    private LocalDateTime startTime;

    @NotNull
    @Column(name = "DURATION", nullable = false)
    @Positive
    private Integer duration;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Transient
    @MetaProperty(related = {"startTime", "duration"})
    public LocalDateTime getEndTime() {
        return (startTime != null && duration != null) ? startTime.plusHours(duration): null;
    }
}