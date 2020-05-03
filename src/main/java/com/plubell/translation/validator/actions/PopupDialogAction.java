package com.plubell.translation.validator.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;

import org.jetbrains.annotations.NotNull;

public class PopupDialogAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull final AnActionEvent event) {
        // use the event to implement the action
        Project currentProject = event.getProject();
        StringBuilder dlgMsg = new StringBuilder(event.getPresentation().getText() + " Selected!");
        String dlgTitle = event.getPresentation().getDescription();
        Navigatable nav = event.getData(CommonDataKeys.NAVIGATABLE);
        if (nav != null) {
            dlgMsg.append(String.format("\nSelected Element: %s", nav.toString()));

        }
        Messages.showMessageDialog(currentProject, dlgMsg.toString(), dlgTitle, Messages.getInformationIcon());
    }
    @Override
    public void update(AnActionEvent event) {
        // use the event to enable or disable the action
        Project project = event.getProject();
        event.getPresentation().setEnabledAndVisible(project != null);
    }
}
