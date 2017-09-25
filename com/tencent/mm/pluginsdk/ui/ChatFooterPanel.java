package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel extends LinearLayout {
    public static int SCENE_SNS = 2;
    public static int sIB = 0;
    public static int sIC = 1;
    public static int sID = 3;
    protected int sIA;
    public a sIy;
    public f sIz;

    public interface a {
        void Zh();

        void aIN();

        void append(String str);

        void fz(boolean z);
    }

    public abstract void anM();

    public abstract void anN();

    public abstract void anO();

    public abstract void anP();

    public abstract void anS();

    public abstract void anT();

    public abstract void dA(boolean z);

    public abstract void dz(boolean z);

    public abstract void k(boolean z, boolean z2);

    public abstract void lv(int i);

    public abstract void lw(int i);

    public abstract void onPause();

    public abstract void onResume();

    public abstract void refresh();

    public abstract void uF(String str);

    public abstract void uG(String str);

    public ChatFooterPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(f fVar) {
        this.sIz = fVar;
    }

    public final void xk(int i) {
        this.sIA = i;
    }

    public void destroy() {
    }
}
