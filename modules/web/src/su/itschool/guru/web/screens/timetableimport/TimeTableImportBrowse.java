package su.itschool.guru.web.screens.timetableimport;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.app.core.file.FileUploadDialog;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import su.itschool.guru.entity.TimeTableImport;

import javax.inject.Inject;
import java.io.File;
import com.haulmont.cuba.core.entity.FileDescriptor;
import java.util.UUID;

@UiController("guru_TimeTableImport.browse")
@UiDescriptor("time-table-import-browse.xml")
@LookupComponent("timeTableImportsTable")
@LoadDataBeforeShow
public class TimeTableImportBrowse extends StandardLookup<TimeTableImport> {
    @Inject
    private Screens screens;
    @Inject
    private DataManager dataManager;
    @Inject
    private FileUploadingAPI fileUploadingAPI;

    @Subscribe("uploadFileBtn")
    public void onUploadFileBtnClick(Button.ClickEvent event) {

        FileUploadDialog dialog = (FileUploadDialog) screens.create("fileUploadDialog", OpenMode.DIALOG);

        //TODO
        dialog.addCloseWithCommitListener(() -> {
            UUID fileId = dialog.getFileId();
            String fileName = dialog.getFileName();

            File file = fileUploadingAPI.getFile(fileId);
         //   file.
           // file.

          /*  FileDescriptor fileDescriptor = fileUploadingAPI.getFileDescriptor(fileId, fileName);
            try {
                fileUploadingAPI.putFileIntoStorage(fileId, fileDescriptor);
                dataManager.commit(fileDescriptor);
            } catch (FileStorageException e) {
                throw new RuntimeException(e);
            }*/
        });
        screens.show(dialog);

    }
}