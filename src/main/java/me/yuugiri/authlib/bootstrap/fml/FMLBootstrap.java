package me.yuugiri.authlib.bootstrap.fml;

import me.yuugiri.authlib.transformer.TransformerManager;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

public class FMLBootstrap implements IFMLLoadingPlugin {

    @Override
    public String[] getASMTransformerClass() {
        TransformerManager dummy = TransformerManager.INSTANCE;
        return new String[]{FMLTransformerCompat.class.getName()};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
