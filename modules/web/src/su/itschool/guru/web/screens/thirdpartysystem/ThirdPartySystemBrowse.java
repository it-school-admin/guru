package su.itschool.guru.web.screens.thirdpartysystem;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.ThirdPartySystem;

@UiController("guru_ThirdPartySystem.browse")
@UiDescriptor("third-party-system-browse.xml")
@LookupComponent("thirdPartySystemsTable")
@LoadDataBeforeShow
public class ThirdPartySystemBrowse extends StandardLookup<ThirdPartySystem> {
}