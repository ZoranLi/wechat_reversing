package com.tencent.mm.y;

import com.tencent.mm.network.c;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class o implements c {
    private final d htp;

    public o(d dVar) {
        this.htp = dVar;
    }

    public final byte[] BX() {
        try {
            return this.htp.BX();
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "exception:%s", bg.g(e));
            return null;
        }
    }

    public final byte[] vc() {
        try {
            return this.htp.vc();
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "exception:%s", bg.g(e));
            return null;
        }
    }

    public final int uH() {
        int i = 0;
        try {
            i = this.htp.uH();
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "exception:%s", bg.g(e));
        }
        return i;
    }

    private String getUsername() {
        try {
            return this.htp.getUsername();
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "exception:%s", bg.g(e));
            return null;
        }
    }

    public final boolean BY() {
        boolean z = false;
        try {
            z = this.htp.BY();
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "exception:%s", bg.g(e));
        }
        return z;
    }

    public final void setUsername(String str) {
        try {
            this.htp.setUsername(str);
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "exception:%s", bg.g(e));
        }
    }

    public final void i(byte[] bArr, int i) {
        try {
            this.htp.i(bArr, i);
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "exception:%s", bg.g(e));
        }
    }

    public final void reset() {
        try {
            this.htp.reset();
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "exception:%s", bg.g(e));
        }
    }

    public final String toString() {
        return (((("RAccInfo:\n" + "|-uin     =" + uH() + "\n") + "|-user    =" + getUsername() + "\n") + "|-session =" + vc() + "\n") + "|-ecdhkey =" + bg.bl(BZ()) + "\n") + "`-cookie  =" + bg.bl(BX());
    }

    public final void h(String str, byte[] bArr) {
        try {
            this.htp.h(str, bArr);
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "exception:%s", bg.g(e));
        }
    }

    public final byte[] hu(String str) {
        try {
            return this.htp.hu(str);
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "exception:%s", bg.g(e));
            return null;
        }
    }

    public final byte[] BZ() {
        try {
            return this.htp.BZ();
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "exception:%s", bg.g(e));
            return null;
        }
    }

    public final void aY(boolean z) {
        try {
            this.htp.aY(z);
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "exception:%s", bg.g(e));
        }
    }

    public final boolean Ca() {
        boolean z = true;
        try {
            z = this.htp.Ca();
        } catch (Throwable e) {
            Object[] objArr = new Object[z];
            objArr[0] = bg.g(e);
            w.e("MicroMsg.RAccInfo", "exception:%s", objArr);
        }
        return z;
    }

    public final byte[] Cb() {
        try {
            return this.htp.Cb();
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", bg.g(e));
            return null;
        }
    }

    public final int A(byte[] bArr) {
        try {
            return this.htp.A(bArr);
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", bg.g(e));
            return -6;
        }
    }

    public final void dj(int i) {
        try {
            this.htp.dj(i);
        } catch (Throwable e) {
            w.e("MicroMsg.RAccInfo", "exception:%s", bg.g(e));
        }
    }
}
