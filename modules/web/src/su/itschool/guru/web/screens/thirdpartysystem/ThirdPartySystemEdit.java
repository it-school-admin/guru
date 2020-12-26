package su.itschool.guru.web.screens.thirdpartysystem;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.ThirdPartySystem;

@UiController("guru_ThirdPartySystem.edit")
@UiDescriptor("third-party-system-edit.xml")
@EditedEntityContainer("thirdPartySystemDc")
@LoadDataBeforeShow
public class ThirdPartySystemEdit extends StandardEditor<ThirdPartySystem> {
}