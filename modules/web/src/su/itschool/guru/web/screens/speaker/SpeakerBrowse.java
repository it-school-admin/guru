package su.itschool.guru.web.screens.speaker;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Speaker;

@UiController("guru_Speaker.browse")
@UiDescriptor("speaker-browse.xml")
@LookupComponent("speakersTable")
@LoadDataBeforeShow
public class SpeakerBrowse extends StandardLookup<Speaker> {
}