package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.e.a.dm;
import com.tencent.mm.e.a.dn;
import com.tencent.mm.e.a.do;
import com.tencent.mm.e.a.dp;
import com.tencent.mm.e.a.ds;
import com.tencent.mm.e.a.dy;
import com.tencent.mm.e.a.kl;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class b implements com.tencent.mm.pluginsdk.ui.tools.r.a {
    private static final byte[] ldJ = new byte[]{(byte) -2, (byte) 1, (byte) 1};
    private static b sgs;
    public String fGs;
    public boolean hasInit = false;
    public byte[] sgi = null;
    public boolean sgk = false;
    public a sgr;
    public int sgt = -1;
    public boolean sgu = false;

    public static class a {
        private String fGs = "";
        public c psI = new c<dm>(this) {
            final /* synthetic */ a sgy;

            {
                this.sgy = r2;
                this.usg = dm.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                return this.sgy.h((dm) bVar);
            }
        };
        private e rXh = null;
        public c sgl = new c<dn>(this) {
            final /* synthetic */ a sgy;

            {
                this.sgy = r2;
                this.usg = dn.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                return this.sgy.h((dn) bVar);
            }
        };
        public c sgv = new c<dp>(this) {
            final /* synthetic */ a sgy;

            {
                this.sgy = r2;
                this.usg = dp.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                return this.sgy.h((dp) bVar);
            }
        };
        public c sgw = new c<do>(this) {
            final /* synthetic */ a sgy;

            {
                this.sgy = r2;
                this.usg = do.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                return this.sgy.h((do) bVar);
            }
        };
        public c sgx = new c<kl>(this) {
            final /* synthetic */ a sgy;

            {
                this.sgy = r2;
                this.usg = kl.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                return this.sgy.h((kl) bVar);
            }
        };

        public a(e eVar, String str) {
            this.rXh = eVar;
            this.fGs = str;
        }

        public final boolean h(com.tencent.mm.sdk.b.b bVar) {
            if (bVar == null) {
                return false;
            }
            if (this.rXh == null) {
                w.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
                return false;
            }
            try {
                Bundle bundle;
                if (bVar instanceof dp) {
                    w.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
                    dp dpVar = (dp) bVar;
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", dpVar.fHy.fwJ);
                    bundle.putByteArray("exdevice_broadcast_data", dpVar.fHy.fHp);
                    bundle.putBoolean("exdevice_is_complete", dpVar.fHy.fHq);
                    this.rXh.m(15, bundle);
                } else if (bVar instanceof do) {
                    w.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
                    do doVar = (do) bVar;
                    if (bg.mA(doVar.fHx.fwJ) || bg.mA(doVar.fHx.fGs) || doVar.fHx.data == null) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", doVar.fHx.fwJ);
                    bundle.putByteArray("exdevice_data", doVar.fHx.data);
                    bundle.putString("exdevice_brand_name", doVar.fHx.fGs);
                    this.rXh.m(16, bundle);
                } else if (bVar instanceof dn) {
                    w.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                    dn dnVar = (dn) bVar;
                    if (bg.mA(dnVar.fHw.fwJ)) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", dnVar.fHw.fwJ);
                    bundle.putBoolean("exdevice_is_bound", dnVar.fHw.fGp);
                    this.rXh.m(17, bundle);
                } else if (bVar instanceof kl) {
                    kl klVar = (kl) bVar;
                    if (klVar.fQR.op != 2) {
                        return true;
                    }
                    if (bg.mA(klVar.fQR.fOo) || !this.fGs.equals(klVar.fQR.fOo)) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", klVar.fQR.fwJ);
                    bundle.putInt("exdevice_on_state_change_state", klVar.fQR.fHm);
                    this.rXh.m(MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED, bundle);
                } else if (bVar instanceof dm) {
                    dm dmVar = (dm) bVar;
                    bundle = new Bundle();
                    if (dmVar.fHu.fHv == 12) {
                        bundle.putBoolean("exdevice_bt_state", true);
                    } else {
                        bundle.putBoolean("exdevice_bt_state", false);
                    }
                    this.rXh.m(18, bundle);
                }
            } catch (Exception e) {
                w.w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", new Object[]{e.getMessage()});
            }
            return true;
        }
    }

    private b() {
    }

    public static b byM() {
        if (sgs == null) {
            sgs = new b();
        }
        return sgs;
    }

    public final String getName() {
        return "WebViewExDeviceMgr";
    }

    public final void byK() {
        com.tencent.mm.sdk.b.b dsVar;
        w.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", new Object[]{Boolean.valueOf(this.sgk)});
        if (this.sgk) {
            dsVar = new ds();
            dsVar.fHB.fGt = false;
            dsVar.fHB.fGs = this.fGs;
            com.tencent.mm.sdk.b.a.urY.m(dsVar);
            if (!dsVar.fHC.fGu) {
                w.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
            }
            this.sgk = false;
        }
        this.hasInit = false;
        if (this.sgr != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.sgr.sgv);
            com.tencent.mm.sdk.b.a.urY.c(this.sgr.sgw);
            com.tencent.mm.sdk.b.a.urY.c(this.sgr.sgx);
            com.tencent.mm.sdk.b.a.urY.c(this.sgr.sgl);
            com.tencent.mm.sdk.b.a.urY.c(this.sgr.psI);
            this.sgr = null;
        }
        this.sgi = null;
        dsVar = new dy();
        dsVar.fHS.fwJ = "";
        dsVar.fHS.direction = 0;
        dsVar.fHS.clear = true;
        com.tencent.mm.sdk.b.a.urY.m(dsVar);
        w.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", new Object[]{Boolean.valueOf(dsVar.fHT.fGu)});
    }

    public static boolean aS(byte[] bArr) {
        if (bArr != null && bArr.length >= 9 && bArr[bArr.length - 7] == (byte) 1 && bArr[bArr.length - 8] == (byte) 1 && bArr[bArr.length - 9] == (byte) -2) {
            return true;
        }
        return false;
    }

    public final void dd(Context context) {
    }

    public final void byL() {
    }
}
