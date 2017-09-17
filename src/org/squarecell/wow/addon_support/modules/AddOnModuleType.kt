package org.squarecell.wow.addon_support.modules

import com.intellij.icons.AllIcons
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.module.ModuleTypeManager
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import org.squarecell.wow.addon_support.builders.AddOnModuleBuilder
import javax.swing.Icon

class AddOnModuleType : ModuleType<AddOnModuleBuilder>(ID) {
    override fun createModuleBuilder(): AddOnModuleBuilder {
        return AddOnModuleBuilder()
    }

    override fun getName(): String {
        return "Woww AddOn"
    }

    override fun getDescription(): String {
        return "World of Warcraft AddOn with Ace3 library"
    }

    override fun getNodeIcon(isOpened: Boolean): Icon {
        return AllIcons.General.Information
    }

    override fun createWizardSteps(wizardContext: WizardContext,
                                   moduleBuilder: AddOnModuleBuilder,
                                   modulesProvider: ModulesProvider): Array<ModuleWizardStep> {
        return super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider)
    }

    companion object {
        private val ID = "WowAddonModuleType"

        val instance: AddOnModuleType
            get() = ModuleTypeManager.getInstance().findByID(ID) as AddOnModuleType
    }
}
