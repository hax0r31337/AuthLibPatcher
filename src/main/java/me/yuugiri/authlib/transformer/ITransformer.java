package me.yuugiri.authlib.transformer;

public interface ITransformer {

    String targetClass();

    byte[] transform(final String name, final byte[] klass);
}
