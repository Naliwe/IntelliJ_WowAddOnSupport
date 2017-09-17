package org.squarecell.wow.addon_support.config

import com.intellij.ide.util.PropertiesComponent

object MainFile {
    val initAce3AddOn = "MyAddon = LibStub(\"AceAddon-3.0\"):NewAddon" +
                        "(\"${PropertiesComponent.getInstance().getValue(
                                ProjectSettingsKeys.AddOnTitle)}\", " +
                        "\"AceConsole-3.0\")\n"
}
