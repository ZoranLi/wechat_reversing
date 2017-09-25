package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;

public final class a {

    public enum c {
        ;

        public static int[] bWB() {
            return (int[]) vPQ.clone();
        }

        static {
            vPP = 1;
            vPQ = new int[]{vPP};
        }
    }

    public interface a extends com.tencent.mm.ui.chatting.c.c<b> {
        void Bh(int i);

        String Oh();

        android.support.v7.widget.RecyclerView.a ak(String str, long j);

        <T extends android.support.v7.widget.RecyclerView.a> T bWs();

        int bWt();

        void bWu();

        void bWv();

        boolean bWw();

        void bWx();

        <T extends h> T eW(Context context);

        g eX(Context context);

        void onResume();

        void r(boolean z, int i);
    }

    public interface b extends com.tencent.mm.ui.chatting.e.a<a> {
        void Bi(int i);

        void Bj(int i);

        boolean bWA();

        void bWv();

        void bWx();

        void bWy();

        void bWz();

        View getChildAt(int i);

        void lq(boolean z);

        void s(boolean z, int i);
    }
}
