package org.squarecell.wow.addon_support.wizard_steps

import com.intellij.ide.util.PropertiesComponent
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ui.layout.CCFlags
import com.intellij.ui.layout.panel
import org.squarecell.utils.LocaleStrings
import org.squarecell.wow.addon_support.config.TocFile
import org.squarecell.wow.addon_support.wizard_steps.ui_components.AddOnConfigPanel
import javax.swing.JComponent

class AddOnWizardStep : ModuleWizardStep() {
    private var configPanel = AddOnConfigPanel()
    private val rootPanel = panel {
        noteRow(LocaleStrings.WOW_ADDON_CONFIG_PANEL_HEADER_TEXT)
        row {
            configPanel(CCFlags.grow)
        }
    }

    override fun getComponent(): JComponent {
        return rootPanel
    }

    override fun updateDataModel() {
        PropertiesComponent.getInstance()
                .setValue("tocFile", TocFile.fromMap(configPanel.getTocFileSettings()))
        configPanel.getSettings().forEach {
            PropertiesComponent.getInstance().setValue(it.key,
                                                       it.value)
        }
    }
}
