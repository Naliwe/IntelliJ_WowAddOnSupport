package org.squarecell.wow.addon_support.builders

import com.intellij.ide.plugins.PluginManager
import com.intellij.ide.util.PropertiesComponent
import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleBuilderListener
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.Disposable
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.JarFileSystem
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFileManager
import org.squarecell.wow.addon_support.config.MainFile
import org.squarecell.wow.addon_support.config.ProjectSettingsKeys
import org.squarecell.wow.addon_support.modules.AddOnModuleType
import org.squarecell.wow.addon_support.wizard_steps.AddOnWizardStep
import java.io.File

class AddOnModuleBuilder : ModuleBuilder(), ModuleBuilderListener {
    init {
        addListener(this)
    }

    override fun moduleCreated(module: Module) {
        val tocFilePath = contentEntryPath + File.separator + module.name + ".toc"
        var mainFilePath = contentEntryPath + File.separator + PropertiesComponent
                .getInstance().getValue(ProjectSettingsKeys.AddOnMainFileName)

        if (!mainFilePath.endsWith(".lua"))
            mainFilePath += ".lua"

        File(tocFilePath).writeText(PropertiesComponent.getInstance().getValue("tocFile")!!)
        val file = File(mainFilePath)

        file.createNewFile()
        file.appendText(MainFile.initAce3AddOn)
        file.appendText(MainFile.defaultInitFunc)
        file.appendText(MainFile.defaultLoadFunc)
        file.appendText(MainFile.defaultUnloadFunc)
    }

    override fun setupRootModel(modifiableRootModel: ModifiableRootModel) {
        val path = contentEntryPath + File.separator + "Libs"

        File(path).mkdirs()
        val sourceRoot = LocalFileSystem.getInstance().refreshAndFindFileByPath(path)!!
        val jarUtil = JarFileSystem.getInstance()
        val desc = PluginManager.getPlugin(PluginId.getId("org.squarecell.wow.addon_support"))!!

        val pluginPath = desc.path.absolutePath
        val realPath = VfsUtil.pathToUrl(pluginPath)
        val pluginVD = VirtualFileManager.getInstance().findFileByUrl(realPath)!!
        val file = jarUtil.refreshAndFindFileByPath(pluginVD.path + "!/Wow_sdk")!!

//        val classesDir = pluginVD.findChild("classes")?: pluginVD
//        val deps = classesDir.findChild("Wow_sdk")!!

        file.children.forEach {
            VfsUtil.copy(this, it, sourceRoot)
        }

        super.doAddContentEntry(modifiableRootModel)?.addSourceFolder(sourceRoot, false)
    }

    override fun getModuleType(): ModuleType<*> {
        return AddOnModuleType.instance
    }

    override fun getCustomOptionsStep(context: WizardContext,
                                      parentDisposable: Disposable?): ModuleWizardStep? {
        return AddOnWizardStep()
    }
}
