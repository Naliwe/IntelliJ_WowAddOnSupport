package org.squarecell.wow.addon_support.wizard_steps.ui_components

import com.intellij.ui.layout.CCFlags
import com.intellij.ui.layout.panel
import org.squarecell.utils.LocaleStrings
import org.squarecell.wow.addon_support.config.ProjectSettingsKeys
import java.awt.BorderLayout
import javax.swing.JPanel

class AddOnConfigPanel : JPanel(BorderLayout()) {
    private val wowApiVersionCombBox = WowApiVersionComboBox(
            ProjectSettingsKeys.WowVersion)
    private val wowAddOnAuthorTextField = WowAddOnTextField(
            ProjectSettingsKeys.AddOnAuthor)
    private val wowAddOnTitleTextField = WowAddOnTextField(
            ProjectSettingsKeys.AddOnTitle)
    private val wowAddOnVersionTextField = WowAddOnTextField(
            ProjectSettingsKeys.AddOnVersion)
    private val wowAddOnMainFileName = WowAddOnTextField(
            ProjectSettingsKeys.AddOnMainFileName)

    private val rootPanel = panel {
        row(LocaleStrings.WOW_VERSION_COMBOBOX_LABEL) {
            wowApiVersionCombBox(CCFlags.grow)
        }
        row(LocaleStrings.WOW_ADDON_TITLE_FIELD_LABEL) {
            wowAddOnTitleTextField(CCFlags.grow)
        }
        row(LocaleStrings.WOW_ADDON_AUTHOR_FIELD_LABEL) {
            wowAddOnAuthorTextField(CCFlags.grow)
        }
        row(LocaleStrings.WOW_ADDON_VERSION_FIELD_LABEL) {
            wowAddOnVersionTextField(CCFlags.grow)
        }
        row(LocaleStrings.WOW_ADDON_MAIN_FILE_NAME_LABEL) {
            wowAddOnMainFileName(CCFlags.grow)
        }
    }

    init {
        add(rootPanel, BorderLayout.CENTER)
    }

    fun getTocFileSettings(): Map<String, String> =
            mapOf(wowApiVersionCombBox.result(),
                  wowAddOnTitleTextField.result(),
                  wowAddOnAuthorTextField.result(),
                  wowAddOnVersionTextField.result(),
                  wowAddOnMainFileName.result())

    fun getSettings(): Map<String, String> =
            mapOf(wowAddOnMainFileName.result(),
                  wowAddOnTitleTextField.result())
}
