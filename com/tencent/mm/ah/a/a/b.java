package com.tencent.mm.ah.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.ah.a.b.c;
import com.tencent.mm.ah.a.b.d;
import com.tencent.mm.ah.a.c.e;
import com.tencent.mm.ah.a.c.f;
import com.tencent.mm.ah.a.c.h;
import com.tencent.mm.ah.a.c.j;
import com.tencent.mm.ah.a.c.k;
import com.tencent.mm.ah.a.c.l;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b {
    public static final int hIu = Runtime.getRuntime().availableProcessors();
    public final com.tencent.mm.ah.a.c.a hIA;
    public final com.tencent.mm.ah.a.c.b hIB;
    public final f hIC;
    public final j hID;
    public final k hIE;
    public final e hIF;
    public final h hIG;
    public final Executor hIH;
    public final Resources hIv;
    public final int hIw;
    public final int hIx;
    public final c hIy;
    public final l hIz;
    public final String packageName;

    public static class a {
        public Context context;
        public com.tencent.mm.ah.a.c.a hIA = null;
        public com.tencent.mm.ah.a.c.b hIB = null;
        public f hIC = null;
        public j hID = null;
        public e hIF = null;
        public h hIG = null;
        public Executor hIH;
        public k hII = null;
        public int hIw = b.hIu;
        public int hIx = 5;
        public c hIy = null;
        public l hIz = null;

        public a(Context context) {
            this.context = context.getApplicationContext();
        }

        public final b Hf() {
            if (this.hIy == null) {
                this.hIy = new com.tencent.mm.ah.a.a.c.a().Hg();
            }
            if (this.hIz == null) {
                this.hIz = new com.tencent.mm.ah.a.b.f();
            }
            if (this.hIA == null) {
                this.hIA = new com.tencent.mm.ah.a.b.a();
            }
            if (this.hIB == null) {
                this.hIB = new com.tencent.mm.ah.a.b.b();
            }
            if (this.hIC == null) {
                this.hIC = new d();
            }
            if (this.hID == null) {
                this.hID = new com.tencent.mm.ah.a.b.h();
            }
            if (this.hIG == null) {
                this.hIG = a.aN(this.hIw, this.hIx);
            }
            if (this.hIH == null) {
                this.hIH = Executors.newSingleThreadExecutor();
            }
            if (this.hII == null) {
                this.hII = new com.tencent.mm.ah.a.b.e();
            }
            if (this.hIF == null) {
                this.hIF = new c();
            }
            return new b(this);
        }
    }

    public b(a aVar) {
        this.packageName = aVar.context.getPackageName();
        this.hIv = aVar.context.getResources();
        this.hIw = aVar.hIw;
        this.hIx = aVar.hIx;
        this.hIy = aVar.hIy;
        this.hIz = aVar.hIz;
        this.hIA = aVar.hIA;
        this.hIB = aVar.hIB;
        this.hIC = aVar.hIC;
        this.hID = aVar.hID;
        this.hIG = aVar.hIG;
        this.hIH = aVar.hIH;
        this.hIE = aVar.hII;
        this.hIF = aVar.hIF;
    }

    public static b aX(Context context) {
        return new a(context).Hf();
    }
}
