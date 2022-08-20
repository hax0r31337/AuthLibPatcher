package me.yuugiri.authlib.bootstrap.fml;

import me.yuugiri.authlib.transformer.TransformerManager;
import net.minecraft.launchwrapper.IClassTransformer;

public class FMLTransformerCompat implements IClassTransformer {

    @Override
    public byte[] transform(final String name, final String transformedName, final byte[] basicClass) {
        return TransformerManager.INSTANCE.callTransform(name, basicClass);
    }
}
