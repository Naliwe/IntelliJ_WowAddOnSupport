package org.squarecell.wow.addon_support.config

import com.intellij.ide.util.PropertiesComponent

object MainFile {
    val initAce3AddOn = "MyAddon = LibStub(\"AceAddon-3.0\"):NewAddon" +
                        "(\"${PropertiesComponent.getInstance().getValue(
                                ProjectSettingsKeys.AddOnTitle)}\", " +
                        "\"AceConsole-3.0\")\n"

    val defaultInitFunc = "function MyAddon:OnInitialize()\n" +
                           "  -- Code that you want to run when the addon is first loaded goes here.\n" +
                           "end" +"\n"

    val defaultLoadFunc = "function MyAddon:OnEnable()\n" +
                          "    -- Called when the addon is enabled\n" +
                          "end" + "\n"

    val defaultUnloadFunc = "function MyAddon:OnDisable()\n" +
                            "    -- Called when the addon is disabled\n" +
                            "end" + "\n"
}
