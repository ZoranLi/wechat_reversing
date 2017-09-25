package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.e.a.dh;
import com.tencent.mm.e.a.di;
import com.tencent.mm.e.a.dj;
import com.tencent.mm.e.a.dk;
import com.tencent.mm.e.a.dn;
import com.tencent.mm.e.a.dr;
import com.tencent.mm.e.a.ei;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a implements com.tencent.mm.pluginsdk.ui.tools.r.a {
    public static String DEVICE_TYPE = "lan";
    private static a sgh;
    public String fGs;
    public boolean hasInit = false;
    public a sgg;
    public byte[] sgi = null;
    private int sgj = -1;
    public boolean sgk = false;

    public static class a {
        private String fGs = "";
        private e rXh = null;
        public c sgl = new c<dn>(this) {
            final /* synthetic */ a sgq;

            {
                this.sgq = r2;
                this.usg = dn.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                return this.sgq.h((dn) bVar);
            }
        };
        public c sgm = new c<dh>(this) {
            final /* synthetic */ a sgq;

            {
                this.sgq = r2;
                this.usg = dh.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                return this.sgq.h((dh) bVar);
            }
        };
        public c sgn = new c<di>(this) {
            final /* synthetic */ a sgq;

            {
                this.sgq = r2;
                this.usg = di.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                return this.sgq.h((di) bVar);
            }
        };
        public c sgo = new c<dj>(this) {
            final /* synthetic */ a sgq;

            {
                this.sgq = r2;
                this.usg = dj.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                return this.sgq.h((dj) bVar);
            }
        };
        public c sgp = new c<dk>(this) {
            final /* synthetic */ a sgq;

            {
                this.sgq = r2;
                this.usg = dk.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                return this.sgq.h((dk) bVar);
            }
        };

        public a(e eVar, String str) {
            this.rXh = eVar;
            this.fGs = str;
        }

        public final boolean h(b bVar) {
            if (bVar == null) {
                return false;
            }
            if (this.rXh == null) {
                w.e("MicroMsg.webview.WebViewExDeviceLanMgr", "callbacker is null");
                return false;
            }
            try {
                Bundle bundle;
                if (bVar instanceof dn) {
                    w.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                    dn dnVar = (dn) bVar;
                    if (bg.mA(dnVar.fHw.fwJ)) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", dnVar.fHw.fwJ);
                    bundle.putBoolean("exdevice_is_bound", dnVar.fHw.fGp);
                    this.rXh.m(17, bundle);
                } else if (bVar instanceof dh) {
                    w.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
                    dh dhVar = (dh) bVar;
                    if (bg.mA(dhVar.fHl.fwJ) || !this.fGs.equals(dhVar.fHl.fGs)) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", dhVar.fHl.fwJ);
                    bundle.putInt("exdevice_on_state_change_state", dhVar.fHl.fHm);
                    bundle.putString("exdevice_device_type", a.DEVICE_TYPE);
                    this.rXh.m(MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED, bundle);
                } else if (bVar instanceof di) {
                    w.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
                    di diVar = (di) bVar;
                    if (bg.mA(diVar.fHn.fwJ) || bg.mA(diVar.fHn.fGs) || diVar.fHn.data == null) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", diVar.fHn.fwJ);
                    bundle.putByteArray("exdevice_data", diVar.fHn.data);
                    bundle.putString("exdevice_brand_name", diVar.fHn.fGs);
                    bundle.putString("exdevice_device_type", a.DEVICE_TYPE);
                    this.rXh.m(16, bundle);
                } else if (bVar instanceof dj) {
                    w.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
                    dj djVar = (dj) bVar;
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", djVar.fHo.fwJ);
                    bundle.putByteArray("exdevice_broadcast_data", djVar.fHo.fHp);
                    bundle.putBoolean("exdevice_is_complete", djVar.fHo.fHq);
                    bundle.putBoolean("exdevice_is_lan_device", true);
                    bundle.putString("exdevice_device_type", a.DEVICE_TYPE);
                    this.rXh.m(15, bundle);
                } else if (bVar instanceof dk) {
                    w.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
                    dk dkVar = (dk) bVar;
                    bundle = new Bundle();
                    if (dkVar.fHr.fHs) {
                        bundle.putBoolean("exdevice_lan_state", true);
                    } else {
                        bundle.putBoolean("exdevice_lan_state", false);
                    }
                    this.rXh.m(47, bundle);
                }
            } catch (Exception e) {
                w.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", new Object[]{e.getMessage()});
            }
            return true;
        }
    }

    private a() {
    }

    public static a byJ() {
        if (sgh == null) {
            sgh = new a();
        }
        return sgh;
    }

    public final String getName() {
        return "WebViewExDeviceLanMgr";
    }

    public final void byK() {
        b eiVar;
        w.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", new Object[]{Boolean.valueOf(this.sgk)});
        if (this.sgk) {
            eiVar = new ei();
            eiVar.fIk.fGt = false;
            com.tencent.mm.sdk.b.a.urY.m(eiVar);
            this.sgk = false;
        }
        this.hasInit = false;
        if (this.sgg != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.sgg.sgl);
            com.tencent.mm.sdk.b.a.urY.c(this.sgg.sgm);
            com.tencent.mm.sdk.b.a.urY.c(this.sgg.sgo);
            com.tencent.mm.sdk.b.a.urY.c(this.sgg.sgn);
            com.tencent.mm.sdk.b.a.urY.c(this.sgg.sgp);
            this.sgg = null;
        }
        this.sgi = null;
        eiVar = new dr();
        eiVar.fHA.fGt = false;
        com.tencent.mm.sdk.b.a.urY.m(eiVar);
    }

    public final void dd(Context context) {
    }

    public final void byL() {
    }
}
