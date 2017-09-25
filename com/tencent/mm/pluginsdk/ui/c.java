package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class c extends j implements com.tencent.mm.x.d.a {
    a sIj;
    int sIk;

    private static class a implements com.tencent.mm.pluginsdk.ui.j.a {
        public Bitmap kcf = null;
        private com.tencent.mm.pluginsdk.ui.j.a owB;

        public a(com.tencent.mm.pluginsdk.ui.j.a aVar) {
            this.owB = aVar;
        }

        public final Bitmap a(String str, int i, int i2, int i3) {
            if (this.owB != null) {
                return this.owB.a(str, i, i2, i3);
            }
            return null;
        }

        public final Bitmap bf(String str) {
            if (this.owB != null) {
                return this.owB.bf(str);
            }
            return null;
        }

        public final Bitmap bg(String str) {
            if (this.owB != null) {
                return this.owB.bg(str);
            }
            return null;
        }

        public final Bitmap nZ() {
            if (this.kcf != null && !this.kcf.isRecycled()) {
                return this.kcf;
            }
            if (this.owB != null) {
                return this.owB.nZ();
            }
            return null;
        }

        public final void a(j jVar) {
            if (this.owB != null) {
                this.owB.a(jVar);
            }
        }
    }

    public c(String str) {
        this(str, (byte) 0);
    }

    private c(String str, byte b) {
        super(new a(b.bEa()), str, false);
        this.sIj = (a) this.owB;
    }
}
