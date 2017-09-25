package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Map;
import junit.framework.Assert;

public final class h {

    public interface a {
        void bG(int i, int i2);
    }

    public static class b implements e {
        public String iconUrl = "";
        public int jUZ = -10001;
        public String jVe;
        private a jVj = null;
        public String jVk = "";
        public final f jVl = new f();

        public final boolean a(a aVar) {
            w.d("MicroMsg.PickBottle", "bottle pick:" + c.adp() + " throw:" + c.ado());
            Assert.assertTrue("renew this class", this.jVj == null);
            Assert.assertTrue("must call back onFin", true);
            if (c.adp() <= 0) {
                aVar.bG(1, 16);
                return false;
            }
            ap.vd().a(155, this);
            ap.vd().a(156, this);
            this.jVj = aVar;
            return ap.vd().a(this.jVl, 0);
        }

        public final void a(int i, int i2, String str, k kVar) {
            w.d("MicroMsg.PickBottle", "type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            if (kVar.getType() == 155) {
                f fVar = (f) kVar;
                if (fVar.jVh) {
                    ap.vd().b(155, this);
                    com.tencent.mm.plugin.bottle.a.imw.ou();
                    this.jVe = fVar.adt().tTL == null ? "" : fVar.adt().tTL;
                    this.jUZ = fVar.adt().mtd;
                    Map q = bh.q(fVar.adt().tEP == null ? "" : fVar.adt().tEP, "branduser");
                    if (q != null) {
                        this.jVk = (String) q.get(".branduser.$username");
                        this.iconUrl = (String) q.get(".branduser.$iconurl");
                        if (this.jVk != null) {
                            this.jUZ = 19990;
                            if (this.jVj != null) {
                                if (i == 0 && i2 == 0) {
                                    this.jVj.bG(i, i2);
                                } else {
                                    this.jVj.bG(i, i2);
                                }
                            }
                            this.jVj = null;
                            return;
                        }
                    }
                    ap.vd().a(new e(this.jVe, this.jUZ), 0);
                    return;
                }
                if (this.jVj != null) {
                    this.jVj.bG(i, i2);
                }
                this.jVj = null;
                ap.vd().b(155, this);
                ap.vd().b(156, this);
            } else if (kVar.getType() == 156) {
                ap.vd().b(156, this);
                if (this.jVj != null) {
                    if (i == 0 && i2 == 0) {
                        this.jVj.bG(i, i2);
                    } else {
                        this.jVj.bG(i, i2);
                    }
                }
                this.jVj = null;
            }
        }
    }

    public static class c implements e {
        private a jVj = null;
        private int jVm = 0;

        public c(String str, a aVar) {
            boolean z;
            Assert.assertTrue("emtpy input text", !bg.mA(str));
            String str2 = "must call back onFin";
            if (aVar != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(str2, z);
            if (c.ado() > 0) {
                ap.vd().a(JsApiMakeVoIPCall.CTRL_INDEX, this);
                this.jVj = aVar;
                ap.vd().a(new g(str), 0);
            } else if (aVar != null) {
                aVar.bG(1, 16);
            }
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar.getType() == JsApiMakeVoIPCall.CTRL_INDEX) {
                if (this.jVj != null) {
                    this.jVm = ((g) kVar).adu();
                    this.jVj.bG(i, i2);
                }
                this.jVj = null;
                ap.vd().b(JsApiMakeVoIPCall.CTRL_INDEX, this);
            }
        }
    }

    public static class d extends com.tencent.mm.c.b.h implements e {
        public a jVj = null;
        private int jVm = 0;

        public d(Context context, a aVar) {
            boolean z = false;
            super(context, false);
            String str = "must call back onFin";
            if (aVar != null) {
                z = true;
            }
            Assert.assertTrue(str, z);
            ap.vd().a(JsApiMakeVoIPCall.CTRL_INDEX, this);
            this.jVj = aVar;
        }

        public final boolean pd() {
            String fileName = super.getFileName();
            boolean pd = super.pd();
            super.reset();
            if (!pd) {
                ap.vd().b(JsApiMakeVoIPCall.CTRL_INDEX, this);
                this.jVj = null;
                return false;
            } else if (c.ado() > 0) {
                ap.vd().a(new g(fileName, this.fAW), 0);
                return true;
            } else {
                ap.vd().b(JsApiMakeVoIPCall.CTRL_INDEX, this);
                if (this.jVj == null) {
                    return false;
                }
                this.jVj.bG(1, 16);
                return false;
            }
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar.getType() == JsApiMakeVoIPCall.CTRL_INDEX) {
                if (this.jVj != null) {
                    this.jVm = ((g) kVar).adu();
                    this.jVj.bG(i, i2);
                }
                this.jVj = null;
                ap.vd().b(JsApiMakeVoIPCall.CTRL_INDEX, this);
            }
        }
    }
}
