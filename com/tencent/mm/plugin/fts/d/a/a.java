package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.j.c;
import com.tencent.mm.sdk.platformtools.w;

public abstract class a {
    public String fRM;
    public String info;
    public final int knu;
    public int mcx;
    public boolean mdc;
    public boolean mdd;
    public int mde;
    public int mdf;
    public int mdg;
    public String mdh;
    public long mdi;
    public boolean mdj;
    public int mdk;
    public int mdl;
    public boolean mdm;
    public final int position;

    public abstract class a {
        final /* synthetic */ a mdn;

        public a(a aVar) {
            this.mdn = aVar;
        }
    }

    public abstract class b {
        final /* synthetic */ a mdn;

        public abstract View a(Context context, ViewGroup viewGroup);

        public abstract void a(Context context, a aVar, a aVar2);

        public abstract boolean a(Context context, a aVar);

        public b(a aVar) {
            this.mdn = aVar;
        }

        public static void a(String str, i iVar) {
            ((l) h.j(l.class)).updateTopHitsRank(str, iVar, 0);
        }

        public final void ch(View view) {
            if (this.mdn.mdd) {
                view.setBackgroundResource(c.bep);
            } else {
                view.setBackgroundResource(c.beo);
            }
        }
    }

    public abstract b Sr();

    public abstract a Ss();

    public abstract void a(Context context, a aVar, Object... objArr);

    public a(int i, int i2) {
        this.knu = i;
        this.position = i2;
        w.d("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void cc(int i, int i2) {
        this.mdk = i;
        this.mdl = i2;
        this.mdm = true;
    }

    public int Su() {
        return 0;
    }

    public String St() {
        return "";
    }

    public int ayf() {
        return 0;
    }

    public boolean ayg() {
        return false;
    }
}
