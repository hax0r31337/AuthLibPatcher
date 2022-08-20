package me.yuugiri.authlib.bootstrap.agent;

import me.yuugiri.authlib.transformer.TransformerManager;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class AgentTransformerCompat implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader classLoader, String name, Class<?> aClass, ProtectionDomain protectionDomain, byte[] bytes) {
        name = name.replaceAll("/", ".");
        return TransformerManager.INSTANCE.callTransform(name, bytes);
    }
}
