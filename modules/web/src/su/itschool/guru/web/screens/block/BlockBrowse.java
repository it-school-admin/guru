package su.itschool.guru.web.screens.block;

import com.haulmont.cuba.gui.screen.*;
import su.itschool.guru.entity.Block;

@UiController("guru_Block.browse")
@UiDescriptor("block-browse.xml")
@LookupComponent("blocksTable")
@LoadDataBeforeShow
public class BlockBrowse extends StandardLookup<Block> {
}