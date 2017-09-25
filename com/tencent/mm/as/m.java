package com.tencent.mm.as;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class m {
    private static m hQn = new m();
    public int hQl = -1;
    public a hQm;

    private class a {
        public int hQo;
        public int hQp;
        public long hQq;
        public int hQr;
        final /* synthetic */ m hQs;

        public a(m mVar) {
            this.hQs = mVar;
        }

        public final String Ix() {
            return this.hQo + "_" + this.hQp + "_" + this.hQq + "_" + this.hQr;
        }
    }

    public static m Iw() {
        return hQn;
    }

    private m() {
        ap.yY();
        this.hQl = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_FTS_DISCOVERY_RED_ID_INT, Integer.valueOf(-1))).intValue();
        ap.yY();
        String str = (String) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_FTS_DISCOVERY_RED_XML_STRING, (Object) "");
        this.hQm = new a(this);
        a aVar = this.hQm;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("_");
            aVar.hQo = bg.PY(split[0]);
            aVar.hQp = bg.PY(split[1]);
            aVar.hQq = bg.PZ(split[2]);
            aVar.hQr = bg.PY(split[3]);
        }
    }

    public final void save() {
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.USERINFO_FTS_DISCOVERY_RED_XML_STRING, this.hQm.Ix());
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.USERINFO_FTS_DISCOVERY_RED_ID_INT, Integer.valueOf(this.hQl));
    }

    public final boolean valid() {
        if (this.hQm != null) {
            a aVar = this.hQm;
            boolean z = !(aVar.hQo == 1 && aVar.hQp == 0) && aVar.hQr <= d.hPo;
            if (z) {
                if (!(System.currentTimeMillis() > this.hQm.hQq)) {
                    return true;
                }
            }
        }
        return false;
    }
}
