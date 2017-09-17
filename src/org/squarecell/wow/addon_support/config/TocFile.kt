package org.squarecell.wow.addon_support.config

object TocFile {
    fun interfaceNumber(value: String = "7.3"): String =
            "## Interface: " + when (value) {
                "7.3" -> "70300"
                else  -> "70300"
            }

    fun title(value: String): String =
            "## Title: $value"

    fun author(value: String): String =
            "## Author: $value"

    fun version(value: String): String =
            "## Version: $value"

    fun fromMap(settings: Map<String, String>): String =
            interfaceNumber(settings[ProjectSettingsKeys.WowVersion]!!) + "\n" +
            title(settings[ProjectSettingsKeys.AddOnTitle]!!) + "\n" +
            author(settings[ProjectSettingsKeys.AddOnAuthor]!!) + "\n" +
            version(settings[ProjectSettingsKeys.AddOnVersion]!!) + "\n" + "\n" +
            "embeds.xml" + "\n" + "\n" +
            settings[ProjectSettingsKeys.AddOnMainFileName] +
            if (ProjectSettingsKeys.AddOnMainFileName.endsWith(".lua")) "\n" else ".lua\n"

}
