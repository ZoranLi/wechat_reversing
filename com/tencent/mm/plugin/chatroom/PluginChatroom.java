package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.comm.a.a;

public class PluginChatroom extends d implements b {
    public String name() {
        return "plugin-chatroom";
    }

    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(a.class);
    }

    public void configure(e eVar) {
    }

    public void execute(e eVar) {
    }
}
