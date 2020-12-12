package su.itschool.guru.web.screens.classletter;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.ClassLetter;

@UiController("guru_ClassLetter.edit")
@UiDescriptor("class-letter-edit.xml")
@EditedEntityContainer("classLetterDc")
@LoadDataBeforeShow
public class ClassLetterEdit extends StandardEditor<ClassLetter> {
}