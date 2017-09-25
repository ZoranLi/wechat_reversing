package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;

public abstract class a {
    public static final int mcC = com.tencent.mm.bg.a.T(ab.getContext(), R.f.aXI);
    public static final TextPaint mcD = new TextPaint();
    public static final int mcE = com.tencent.mm.bg.a.T(ab.getContext(), R.f.aXs);
    public static final TextPaint mcF = new TextPaint();
    public String fET;
    public String fRM;
    public x jiL;
    public boolean kap;
    public final int knu;
    public int mdf;
    public int mdk;
    public int mdl;
    public final int position;
    public int scene;
    public boolean vYg;
    public boolean vYh;
    public boolean waj;
    public boolean wak;
    public boolean wal;

    public class a {
        final /* synthetic */ a wam;

        public a(a aVar) {
            this.wam = aVar;
        }
    }

    public abstract class b {
        final /* synthetic */ a wam;

        public abstract boolean Od();

        public abstract View a(Context context, ViewGroup viewGroup);

        public abstract void a(Context context, a aVar, a aVar2, boolean z, boolean z2);

        public b(a aVar) {
            this.wam = aVar;
        }
    }

    public abstract b Ob();

    public abstract a Oc();

    public abstract void br(Context context);

    static {
        mcD.setTextSize((float) mcC);
        mcF.setTextSize((float) mcE);
    }

    public a(int i, int i2) {
        this.knu = i;
        this.position = i2;
        w.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void cc(int i, int i2) {
        this.mdk = i;
        this.mdl = i2;
    }

    public boolean ayg() {
        return false;
    }
}
