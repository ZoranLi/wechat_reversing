package com.tencent.mm.plugin.appbrand.dynamic.core;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.i.c;
import com.tencent.mm.plugin.appbrand.dynamic.i.c.f;
import com.tencent.mm.plugin.appbrand.dynamic.i.j;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;
import org.json.JSONObject;

public final class MiniJsApiFramework {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String fxR;
        final /* synthetic */ int hQN;
        final /* synthetic */ int iHp;
        final /* synthetic */ int iHq;
        final /* synthetic */ int iHr;
        final /* synthetic */ a iHs;
        final /* synthetic */ String iHt;
        final /* synthetic */ String uF;

        public AnonymousClass1(String str, int i, int i2, String str2, int i3, int i4, a aVar, String str3) {
            this.uF = str;
            this.iHp = i;
            this.iHq = i2;
            this.fxR = str2;
            this.iHr = i3;
            this.hQN = i4;
            this.iHs = aVar;
            this.iHt = str3;
        }

        public final void run() {
            boolean z = true;
            w.d("MicroMsg.MiniJsApiFramework", "initialize(id : %s, pkgType : %s, version : %s)", new Object[]{this.uF, Integer.valueOf(this.iHp), Integer.valueOf(this.iHq)});
            final j a = c.a(this.fxR, this.iHp, this.iHq, this.iHr, this.hQN);
            if (a == null) {
                w.e("MicroMsg.MiniJsApiFramework", "getLaunchWxaWidgetInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[]{this.uF, Integer.valueOf(this.iHp), Integer.valueOf(this.iHq)});
                if (this.iHs != null) {
                    this.iHs.a(this.uF, this.fxR, false, null);
                    return;
                }
                return;
            }
            WxaPkgWrappingInfo d = c.d(this.fxR, this.iHt, this.iHp, this.iHq);
            if (d != null) {
                MiniJsApiFwContext a2 = MiniJsApiFramework.a(this.uF, this.fxR, d, a);
                if (this.iHs != null) {
                    a aVar = this.iHs;
                    String str = this.uF;
                    String str2 = this.fxR;
                    if (a2 == null) {
                        z = false;
                    }
                    aVar.a(str, str2, z, a2);
                    return;
                }
                return;
            }
            w.e("MicroMsg.MiniJsApiFramework", "get widget PkgWrappingInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[]{this.uF, Integer.valueOf(this.iHp), Integer.valueOf(this.iHq)});
            if (this.iHs != null) {
                this.iHs.aN(this.uF, this.fxR);
            }
            String str3 = this.fxR;
            String str4 = this.iHt;
            int i = this.iHp;
            f anonymousClass1 = new f(this) {
                final /* synthetic */ AnonymousClass1 iHv;

                public final void I(String str, boolean z) {
                    boolean z2 = false;
                    MiniJsApiFwContext miniJsApiFwContext = null;
                    w.d("MicroMsg.MiniJsApiFramework", "tryToUpdate(id : %s, pkgType : %s, version : %s), callback(%s, %s).", new Object[]{this.iHv.uF, Integer.valueOf(this.iHv.iHp), Integer.valueOf(this.iHv.iHq), str, Boolean.valueOf(z)});
                    if (z) {
                        WxaPkgWrappingInfo d = c.d(str, this.iHv.iHt, this.iHv.iHp, 0);
                        if (d != null) {
                            miniJsApiFwContext = MiniJsApiFramework.a(this.iHv.uF, str, d, a);
                        } else {
                            z = false;
                        }
                    }
                    if (this.iHv.iHs != null) {
                        a aVar = this.iHv.iHs;
                        String str2 = this.iHv.uF;
                        if (z && miniJsApiFwContext != null) {
                            z2 = true;
                        }
                        aVar.a(str2, str, z2, miniJsApiFwContext);
                    }
                }
            };
            if (i != Integer.MIN_VALUE && c.d(str3, str4, i, 0) == null) {
                Parcelable bundle = new Bundle();
                bundle.putString("appId", str3);
                bundle.putInt("debugType", i);
                e.a("com.tencent.mm", bundle, e.class, new com.tencent.mm.plugin.appbrand.dynamic.i.c.AnonymousClass2(anonymousClass1));
            }
        }
    }

    public interface a {
        void a(String str, String str2, boolean z, MiniJsApiFwContext miniJsApiFwContext);

        void aN(String str, String str2);
    }

    private static class MiniJsApiFwContextImpl implements MiniJsApiFwContext {
        public static final Creator<MiniJsApiFwContextImpl> CREATOR = new Creator<MiniJsApiFwContextImpl>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new MiniJsApiFwContextImpl(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MiniJsApiFwContextImpl[i];
            }
        };
        String iDc;
        DebuggerInfo iHA;
        WidgetSysConfig iHB;
        WxaPkgWrappingInfo iHw;
        WxaPkgWrappingInfo iHx;
        byte[] iHy;
        int iHz;
        String ivH;

        public MiniJsApiFwContextImpl(Parcel parcel) {
            ClassLoader classLoader = getClass().getClassLoader();
            this.iDc = parcel.readString();
            this.ivH = parcel.readString();
            this.iHx = (WxaPkgWrappingInfo) parcel.readParcelable(classLoader);
            this.iHw = (WxaPkgWrappingInfo) parcel.readParcelable(classLoader);
            this.iHy = parcel.createByteArray();
            this.iHz = parcel.readInt();
            this.iHA = (DebuggerInfo) parcel.readParcelable(classLoader);
            this.iHB = (WidgetSysConfig) parcel.readParcelable(classLoader);
        }

        public MiniJsApiFwContextImpl(WxaPkgWrappingInfo wxaPkgWrappingInfo, WxaPkgWrappingInfo wxaPkgWrappingInfo2) {
            Assert.assertNotNull(wxaPkgWrappingInfo);
            Assert.assertNotNull(wxaPkgWrappingInfo2);
            this.iHx = wxaPkgWrappingInfo;
            this.iHw = wxaPkgWrappingInfo2;
        }

        public final WxaPkgWrappingInfo RU() {
            return this.iHw;
        }

        public final WxaPkgWrappingInfo RV() {
            return this.iHx;
        }

        public final String getId() {
            return this.iDc;
        }

        public final String getAppId() {
            return this.ivH;
        }

        public final int RW() {
            return this.iHw != null ? this.iHw.izV : 0;
        }

        public final int RX() {
            return this.iHw != null ? this.iHw.izW : 0;
        }

        public final byte[] RY() {
            return this.iHy;
        }

        public final int RZ() {
            return this.iHz;
        }

        public final DebuggerInfo Sa() {
            return this.iHA;
        }

        public final WidgetSysConfig Sb() {
            return this.iHB;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.iDc);
            parcel.writeString(this.ivH);
            parcel.writeParcelable(this.iHx, i);
            parcel.writeParcelable(this.iHw, i);
            parcel.writeByteArray(this.iHy);
            parcel.writeInt(this.iHz);
            parcel.writeParcelable(this.iHA, i);
            parcel.writeParcelable(this.iHB, i);
        }
    }

    public static MiniJsApiFwContextImpl a(String str, String str2, WxaPkgWrappingInfo wxaPkgWrappingInfo, j jVar) {
        MiniJsApiFwContextImpl miniJsApiFwContextImpl = null;
        w.i("MicroMsg.MiniJsApiFramework", "prepare(%s)", new Object[]{str});
        WxaPkgWrappingInfo wxaPkgWrappingInfo2 = (WxaPkgWrappingInfo) e.a("com.tencent.mm", null, d.class);
        if (wxaPkgWrappingInfo2 == null) {
            w.e("MicroMsg.MiniJsApiFramework", "getLibPkgInfo return null.");
        } else {
            int i;
            MiniJsApiFwContextImpl miniJsApiFwContextImpl2;
            miniJsApiFwContextImpl = new MiniJsApiFwContextImpl(wxaPkgWrappingInfo2, wxaPkgWrappingInfo);
            miniJsApiFwContextImpl.iDc = str;
            miniJsApiFwContextImpl.ivH = str2;
            miniJsApiFwContextImpl.iHA = jVar.iID;
            if (miniJsApiFwContextImpl.iHA == null) {
                miniJsApiFwContextImpl.iHA = new DebuggerInfo();
            }
            miniJsApiFwContextImpl.iHB = jVar.iIE;
            try {
                byte[] toByteArray = (jVar.iIG == null || jVar.iIG.tqU == null) ? new byte[0] : jVar.iIG.tqU.toByteArray();
                miniJsApiFwContextImpl.iHy = toByteArray;
            } catch (Throwable e) {
                w.e("MicroMsg.MiniJsApiFramework", bg.g(e));
            }
            if (miniJsApiFwContextImpl.iHA.iHK) {
                i = 2;
                miniJsApiFwContextImpl2 = miniJsApiFwContextImpl;
            } else if (jVar.iIF != null) {
                i = jVar.iIF.tcm;
                miniJsApiFwContextImpl2 = miniJsApiFwContextImpl;
            } else {
                i = 1;
                miniJsApiFwContextImpl2 = miniJsApiFwContextImpl;
            }
            miniJsApiFwContextImpl2.iHz = i;
        }
        return miniJsApiFwContextImpl;
    }

    public static String aP(String str, String str2) {
        return str + "#" + str2;
    }

    public static void b(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            w.e("MicroMsg.MiniJsApiFramework", "put env arguments error, %s", new Object[]{e});
        }
    }
}
