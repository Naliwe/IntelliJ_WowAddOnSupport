package org.squarecell.utils

import java.util.*

object LocaleStrings {
    private val bundle = ResourceBundle.getBundle("strings")

    val WOW_ADDON_CONFIG_PANEL_HEADER_TEXT = bundle.getString("Ui.WowAddOnConfigHeaderText")!!
    val WOW_VERSION_COMBOBOX_LABEL = bundle.getString("Ui.WowVersionComboBoxLabel")!!
    val WOW_ADDON_TITLE_FIELD_LABEL = bundle.getString("Ui.WowAddOnTitleFieldLabel")!!
    val WOW_ADDON_VERSION_FIELD_LABEL = bundle.getString("Ui.WowAddOnVersionFieldLabel")!!
    val WOW_ADDON_AUTHOR_FIELD_LABEL = bundle.getString("Ui.WowAddOnAuthorFieldLabel")!!
    val WOW_ADDON_MAIN_FILE_NAME_LABEL = bundle.getString("Ui.WowAddOnMainFileNameLabel")!!
}
