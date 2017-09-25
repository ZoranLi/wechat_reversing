package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.chatting.c.c;

public final class b {

    public interface a extends c<b> {
        String Oh();

        android.support.v7.widget.RecyclerView.a TI(String str);

        g bWC();

        void bWD();

        e bWE();

        com.tencent.mm.pluginsdk.ui.tools.p.a bWF();

        String bWG();

        <T extends h> T eW(Context context);
    }

    public interface b extends com.tencent.mm.ui.chatting.e.a<a> {
        void aY(String str, boolean z);

        void bWH();

        void onFinish();

        void s(boolean z, int i);
    }
}
