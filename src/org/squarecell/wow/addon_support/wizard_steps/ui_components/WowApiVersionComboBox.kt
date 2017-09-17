package org.squarecell.wow.addon_support.wizard_steps.ui_components

import com.intellij.openapi.ui.ComboBox
import org.squarecell.wow.addon_support.config.GlobalConstants
import javax.swing.DefaultComboBoxModel

class WowApiVersionComboBox(private val settingsKey: String) : ComboBox<String>() {
    init {
        model = DefaultComboBoxModel<String>(GlobalConstants.WowVersions)
    }

    fun result() = Pair(settingsKey, this.selectedItem as String)
}
