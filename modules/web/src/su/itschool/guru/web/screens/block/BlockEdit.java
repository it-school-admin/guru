package su.itschool.guru.web.screens.block;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Block;

@UiController("guru_Block.edit")
@UiDescriptor("block-edit.xml")
@EditedEntityContainer("blockDc")
@LoadDataBeforeShow
public class BlockEdit extends StandardEditor<Block> {
}