package me.yuugiri.authlib.transformer.impl;

import me.yuugiri.authlib.transformer.ITransformer;
import me.yuugiri.authlib.util.ClassUtil;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;

public class ResourcePropertyTransformer implements ITransformer {

    @Override
    public String targetClass() {
        return "com.mojang.authlib.properties.Property";
    }

    @Override
    public byte[] transform(String name, byte[] klass) {
        final ClassNode classNode = ClassUtil.readClass(klass);

        classNode.methods.stream()
                .filter(methodNode -> methodNode.name.equals("hasSignature") || methodNode.name.equals("isSignatureValid"))
                .forEach(methodNode -> {
                    AbstractInsnNode node = methodNode.instructions.get(0);

                    methodNode.instructions.insertBefore(node, new InsnNode(Opcodes.ICONST_1));
                    methodNode.instructions.insertBefore(node, new InsnNode(Opcodes.IRETURN));
                });

        return ClassUtil.writeClass(classNode, true);
    }
}
