package su.itschool.guru.web.screens.classletter;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.ClassLetter;

@UiController("guru_ClassLetter.browse")
@UiDescriptor("class-letter-browse.xml")
@LookupComponent("classLettersTable")
@LoadDataBeforeShow
public class ClassLetterBrowse extends StandardLookup<ClassLetter> {
}