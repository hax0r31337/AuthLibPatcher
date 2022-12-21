package me.yuugiri.authlib.util;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

public class ClassUtil {

    public static ClassNode readClass(final byte[] classFile) {
        final ClassReader classReader = new ClassReader(classFile);
        final ClassNode classNode = new ClassNode();
        classReader.accept(classNode, 0);
        return classNode;
    }

    public static byte[] writeClass(final ClassNode classNode, final boolean frames) {
        final ClassWriter classWriter = new ClassWriter(frames ? ClassWriter.COMPUTE_FRAMES : ClassWriter.COMPUTE_MAXS);
        classNode.accept(classWriter);
        return classWriter.toByteArray();
    }
}
