package me.yuugiri.authlib.transformer;

import me.yuugiri.authlib.transformer.impl.ResourcePropertyTransformer;
import me.yuugiri.authlib.transformer.impl.YggdrasilTransformer;

import java.util.ArrayList;

public class TransformerManager {

    public static final TransformerManager INSTANCE = new TransformerManager();

    private final ArrayList<ITransformer> transformers = new ArrayList<>();

    private TransformerManager() {
        transformers.add(new YggdrasilTransformer());
        transformers.add(new ResourcePropertyTransformer());
    }

    public byte[] callTransform(final String name, byte[] klass) {
        boolean hasModified = false;

        for (ITransformer transformer : transformers) {
            if (name.equals(transformer.targetClass())) {
                klass = transformer.transform(name, klass);
                hasModified = true;
                System.out.println("Transformed class: " + name);
            }
        }

        return klass;
    }
}
