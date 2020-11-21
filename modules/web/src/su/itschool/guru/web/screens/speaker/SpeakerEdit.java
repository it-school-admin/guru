package su.itschool.guru.web.screens.speaker;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Speaker;

@UiController("guru_Speaker.edit")
@UiDescriptor("speaker-edit.xml")
@EditedEntityContainer("speakerDc")
@LoadDataBeforeShow
public class SpeakerEdit extends StandardEditor<Speaker> {
}