package me.yuugiri.authlib.transformer.impl;

import me.yuugiri.authlib.transformer.ITransformer;
import me.yuugiri.authlib.util.ClassUtil;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.LdcInsnNode;

public class YggdrasilTransformer implements ITransformer {

    public static final String MOCK_YGGDRASIL_SERVER_ADDRESS = "http://127.0.0.1:4000/";

    @Override
    public String targetClass() {
        return "com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService";
    }

    @Override
    public byte[] transform(String name, byte[] klass) {
        final ClassNode classNode = ClassUtil.readClass(klass);

        classNode.methods.stream()
                .forEach(methodNode -> {
                    for (int i = 0; i < methodNode.instructions.size(); ++i) {
                        final AbstractInsnNode abstractInsnNode = methodNode.instructions.get(i);
                        if (abstractInsnNode instanceof LdcInsnNode) {
                            final LdcInsnNode lin = (LdcInsnNode) abstractInsnNode;
                            if (lin.cst instanceof String) {
                                lin.cst = ((String)lin.cst).replaceAll("https://sessionserver.mojang.com/", MOCK_YGGDRASIL_SERVER_ADDRESS);
                            }
                        }
                    }
                });

        return ClassUtil.writeClass(classNode);
    }
}
