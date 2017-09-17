package org.squarecell.wow.addon_support.wizard_steps.ui_components

import javax.swing.JTextField

class WowAddOnTextField(private val settingsKey: String)
    : JTextField() {
    fun result() = Pair(settingsKey, this.text)
}
