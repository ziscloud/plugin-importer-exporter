package com.github.shiraji.pluginimporterexporter.config;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;

import org.jetbrains.annotations.Nullable;

import java.io.File;

@State(
        name = "PluginImporterExporterConfig",
        storages = {
                @Storage(value = "plugin-importer-exporter.xml")
        }
)
public class PluginImporterExporterConfig implements PersistentStateComponent<PluginImporterExporterConfig> {
    public static final String DEFAULT_FILE_NAME = "plugins.json";
    public static final String DEFAULT_FILE_PATH = System.getProperty("user" +
            ".home") + File.separator + DEFAULT_FILE_NAME;

    private String mPluginSettingFilePath = DEFAULT_FILE_PATH;

    private boolean mIsSaveDisablePlugin;

    @Nullable
    public static PluginImporterExporterConfig getInstance() {
        return ServiceManager.getService(PluginImporterExporterConfig.class);
    }

    @Nullable
    @Override
    public PluginImporterExporterConfig getState() {
        return this;
    }

    @Override
    public void loadState(PluginImporterExporterConfig pluginImporterExporterConfig) {
        XmlSerializerUtil.copyBean(pluginImporterExporterConfig, this);
    }

    public String getPluginSettingFilePath() {
        return mPluginSettingFilePath;
    }

    public void setPluginSettingFilePath(String pluginSettingFilePath) {
        mPluginSettingFilePath = pluginSettingFilePath;
    }

    public boolean isSaveDisablePlugin() {
        return mIsSaveDisablePlugin;
    }

    public void setIsSaveDisablePlugin(boolean isSaveDisablePlugin) {
        this.mIsSaveDisablePlugin = isSaveDisablePlugin;
    }
}
