package me.yuugiri.authlib.bootstrap.agent;

import me.yuugiri.authlib.transformer.TransformerManager;

import java.lang.instrument.Instrumentation;

public class AgentBootstrap {

    public static void premain(String str, Instrumentation instrumentation) {
        TransformerManager dummy = TransformerManager.INSTANCE;

        instrumentation.addTransformer(new AgentTransformerCompat());
    }
}
