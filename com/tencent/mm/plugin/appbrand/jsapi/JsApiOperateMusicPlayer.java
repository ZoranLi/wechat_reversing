package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiOperateMusicPlayer extends a {
    public static final int CTRL_INDEX = 47;
    public static final String NAME = "operateMusicPlayer";
    public OperateMusicPlayer iOV;

    private static class OperateMusicPlayer extends MainProcessTask {
        public static final Creator<OperateMusicPlayer> CREATOR = new Creator<OperateMusicPlayer>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OperateMusicPlayer(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateMusicPlayer[i];
            }
        };
        public int action;
        public String errorMsg;
        public String fQC;
        public String fTO;
        com.tencent.mm.u.q.b iHR;
        private d iMF;
        private m iMG;
        public int iMH;
        public boolean iMS = false;
        com.tencent.mm.plugin.appbrand.ui.banner.c iOP;
        com.tencent.mm.plugin.appbrand.e.b iOQ;
        public String iOS;
        public final com.tencent.mm.sdk.b.c iOT = new com.tencent.mm.sdk.b.c<jc>(this) {
            final /* synthetic */ OperateMusicPlayer iPd;

            {
                this.iPd = r2;
                this.usg = jc.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                jc jcVar = (jc) bVar;
                w.i("MicroMsg.JsApiOperateMusicPlayer", "callback in(action : %s)", new Object[]{Integer.valueOf(jcVar.fPc.action)});
                anf com_tencent_mm_protocal_c_anf = jcVar.fPc.fOY;
                if (com_tencent_mm_protocal_c_anf != null) {
                    String str = com_tencent_mm_protocal_c_anf.tRN;
                    Map hashMap = new HashMap();
                    hashMap.put("dataUrl", str);
                    this.iPd.iOS = new JSONObject(hashMap).toString();
                    this.iPd.action = jcVar.fPc.action;
                    this.iPd.SL();
                }
                return false;
            }
        };

        public OperateMusicPlayer(d dVar, m mVar, int i) {
            this.iMF = dVar;
            this.iMG = mVar;
            this.iMH = i;
        }

        public OperateMusicPlayer(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            try {
                JSONObject jSONObject = new JSONObject(this.fQC);
                String optString = jSONObject.optString("operationType");
                final String optString2 = jSONObject.optString("dataUrl");
                if (bg.mA(optString)) {
                    this.action = -1;
                    this.iMS = true;
                    this.errorMsg = "operationType is null or nil";
                    SL();
                } else if (a.iwi.ay(this.fTO, optString)) {
                    if (com.tencent.mm.am.b.HK() && !com.tencent.mm.am.b.HJ() && optString.equalsIgnoreCase("play")) {
                        anf HL = com.tencent.mm.am.b.HL();
                        if (HL == null || !(bg.mA(optString2) || optString2.equals(HL.tRN))) {
                            w.i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
                        } else if (a.iwi.ay(this.fTO, "resume")) {
                            w.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", new Object[]{this.fTO});
                            optString = "resume";
                        } else {
                            w.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
                        }
                    }
                    if (optString.equalsIgnoreCase("play")) {
                        final String optString3 = jSONObject.optString("title");
                        final String optString4 = jSONObject.optString("singer");
                        final String optString5 = jSONObject.optString("epname");
                        final String optString6 = jSONObject.optString("coverImgUrl");
                        if (bg.mA(optString2)) {
                            this.action = -1;
                            this.iMS = true;
                            this.errorMsg = "dataUrl is null or nil";
                            SL();
                            return;
                        }
                        w.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", new Object[]{optString3, optString4, optString5, optString6, optString2, optString2, optString2});
                        com.tencent.mm.am.b.HH();
                        optString = a.iwi.iwg;
                        if (!bg.mA(optString)) {
                            w.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[]{optString, this.fTO});
                            a.iwi.nm(optString);
                        }
                        final String str = optString2;
                        final String str2 = optString2;
                        af.f(new Runnable(this) {
                            final /* synthetic */ OperateMusicPlayer iPd;

                            public final void run() {
                                String str = (this.iPd.fTO + optString2 + optString6).hashCode();
                                com.tencent.mm.am.a.a aVar = (com.tencent.mm.am.a.a) h.h(com.tencent.mm.am.a.a.class);
                                String str2 = optString6;
                                String str3 = optString6;
                                String str4 = optString3;
                                String str5 = optString4;
                                String str6 = str;
                                String str7 = str2;
                                String str8 = optString2;
                                String str9 = e.hgu;
                                StringBuilder stringBuilder = new StringBuilder();
                                ap.yY();
                                anf a = aVar.a(str2, str3, str4, str5, str6, str7, str8, str, str9, stringBuilder.append(com.tencent.mm.u.c.xb()).append(optString6.hashCode()).toString(), optString5, "");
                                a.tSa = true;
                                com.tencent.mm.am.b.b(a);
                                a.iwi.a(this.iPd.iOT, this.iPd.fTO);
                                a.iwi.iwg = this.iPd.fTO;
                                a.iwi.iwh = a.tqY;
                                w.i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
                                this.iPd.action = -1;
                                this.iPd.errorMsg = "";
                                this.iPd.iMS = false;
                                this.iPd.SL();
                            }
                        }, 500);
                    } else if (optString.equalsIgnoreCase("resume")) {
                        optString = a.iwi.iwg;
                        if (!bg.mA(optString)) {
                            w.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[]{optString, this.fTO});
                            a.iwi.nm(optString);
                        }
                        a.iwi.a(this.iOT, this.fTO);
                        a.iwi.iwg = this.fTO;
                        anf HL2 = com.tencent.mm.am.b.HL();
                        if (HL2 != null) {
                            a.iwi.iwh = HL2.tqY;
                        }
                        if (com.tencent.mm.am.c.HN()) {
                            af.f(new Runnable(this) {
                                final /* synthetic */ OperateMusicPlayer iPd;

                                {
                                    this.iPd = r1;
                                }

                                public final void run() {
                                    w.i("MicroMsg.JsApiOperateMusicPlayer", "resume ok");
                                    this.iPd.action = -1;
                                    this.iPd.errorMsg = "";
                                    this.iPd.iMS = false;
                                    this.iPd.SL();
                                }
                            }, 500);
                            return;
                        }
                        w.i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
                        this.action = -1;
                        this.iMS = true;
                        this.errorMsg = "resume play fail";
                        SL();
                    } else if (optString.equalsIgnoreCase("pause")) {
                        if (com.tencent.mm.am.c.HO()) {
                            af.f(new Runnable(this) {
                                final /* synthetic */ OperateMusicPlayer iPd;

                                {
                                    this.iPd = r1;
                                }

                                public final void run() {
                                    w.i("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
                                    this.iPd.action = -1;
                                    this.iPd.iMS = false;
                                    this.iPd.errorMsg = "";
                                    this.iPd.SL();
                                }
                            }, 500);
                            return;
                        }
                        w.i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
                        this.action = -1;
                        this.iMS = true;
                        this.errorMsg = "pause play fail";
                        SL();
                    } else if (optString.equalsIgnoreCase("seek")) {
                        if (com.tencent.mm.am.b.gi(bg.getInt(bg.bw(jSONObject.optString("position")), -1) * 1000)) {
                            af.f(new Runnable(this) {
                                final /* synthetic */ OperateMusicPlayer iPd;

                                {
                                    this.iPd = r1;
                                }

                                public final void run() {
                                    w.i("MicroMsg.JsApiOperateMusicPlayer", "seek ok");
                                    this.iPd.action = -1;
                                    this.iPd.iMS = false;
                                    this.iPd.errorMsg = "";
                                    this.iPd.SL();
                                }
                            }, 500);
                            return;
                        }
                        w.i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
                        this.action = -1;
                        this.iMS = true;
                        this.errorMsg = "seek fail";
                        SL();
                    } else if (!optString.equalsIgnoreCase("stop")) {
                        this.action = -1;
                        this.iMS = true;
                        SL();
                    } else if (com.tencent.mm.am.c.HP()) {
                        af.f(new Runnable(this) {
                            final /* synthetic */ OperateMusicPlayer iPd;

                            {
                                this.iPd = r1;
                            }

                            public final void run() {
                                w.i("MicroMsg.JsApiOperateMusicPlayer", "stop ok");
                                this.iPd.action = -1;
                                this.iPd.iMS = false;
                                this.iPd.errorMsg = "";
                                this.iPd.SL();
                            }
                        }, 500);
                    } else {
                        w.i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
                        this.action = -1;
                        this.iMS = false;
                        this.errorMsg = "stop play fail";
                        SL();
                    }
                } else {
                    w.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
                    this.action = -1;
                    this.iMS = true;
                    this.errorMsg = "appid not match cannot operate";
                    SL();
                }
            } catch (Exception e) {
                w.e("MicroMsg.JsApiOperateMusicPlayer", e.toString());
                this.action = -1;
                this.iMS = true;
                this.errorMsg = "data is null";
                SL();
            }
        }

        public final void SK() {
            String str;
            w.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", new Object[]{Integer.valueOf(this.action)});
            m mVar = this.iMG;
            int i = this.iMH;
            d dVar = this.iMF;
            if (this.iMS) {
                str = "fail" + (TextUtils.isEmpty(this.errorMsg) ? "" : ":" + this.errorMsg);
            } else {
                str = "ok";
            }
            mVar.x(i, dVar.d(str, null));
            e a;
            switch (this.action) {
                case 0:
                    w.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
                    a = new c().a(this.iMG);
                    a.mData = this.iOS;
                    a.SR();
                    this.iHR.l("Music#isPlaying", Boolean.valueOf(true));
                    com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.b(this.iOP);
                    com.tencent.mm.plugin.appbrand.e.a(this.iMG.ivH, this.iOQ);
                    return;
                case 1:
                    w.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
                    this.iHR.l("Music#isPlaying", Boolean.valueOf(true));
                    com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.b(this.iOP);
                    com.tencent.mm.plugin.appbrand.e.a(this.iMG.ivH, this.iOQ);
                    return;
                case 2:
                    w.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
                    a = new a().a(this.iMG);
                    a.mData = this.iOS;
                    a.SR();
                    break;
                case 3:
                    w.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
                    a = new b().a(this.iMG);
                    a.mData = this.iOS;
                    a.SR();
                    this.iHR.l("Music#isPlaying", Boolean.valueOf(false));
                    com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.a(this.iOP);
                    com.tencent.mm.plugin.appbrand.e.b(this.iMG.ivH, this.iOQ);
                    return;
                case 4:
                    w.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
                    this.iMG.f("onMusicError", this.iOS, 0);
                    this.iHR.l("Music#isPlaying", Boolean.valueOf(false));
                    com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.a(this.iOP);
                    com.tencent.mm.plugin.appbrand.e.b(this.iMG.ivH, this.iOQ);
                    return;
                case 7:
                    break;
                default:
                    return;
            }
            w.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
            this.iHR.l("Music#isPlaying", Boolean.valueOf(false));
            com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.a(this.iOP);
            com.tencent.mm.plugin.appbrand.e.b(this.iMG.ivH, this.iOQ);
        }

        public final void f(Parcel parcel) {
            this.fQC = parcel.readString();
            this.fTO = parcel.readString();
            this.iMS = parcel.readByte() != (byte) 0;
            this.iOS = parcel.readString();
            this.action = parcel.readInt();
            this.errorMsg = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.fQC);
            parcel.writeString(this.fTO);
            parcel.writeByte(this.iMS ? (byte) 1 : (byte) 0);
            parcel.writeString(this.iOS);
            parcel.writeInt(this.action);
            parcel.writeString(this.errorMsg);
        }
    }

    private static final class a extends e {
        private static final int CTRL_INDEX = 82;
        private static final String NAME = "onMusicEnd";
    }

    private static final class b extends e {
        private static final int CTRL_INDEX = 81;
        private static final String NAME = "onMusicPause";
    }

    private static final class c extends e {
        private static final int CTRL_INDEX = 80;
        private static final String NAME = "onMusicPlay";
    }

    public final void a(final m mVar, JSONObject jSONObject, int i) {
        this.iOV = new OperateMusicPlayer(this, mVar, i);
        final com.tencent.mm.u.q.b n = q.yC().n(q.fQ("AppBrandService#" + mVar.hashCode()), true);
        synchronized (n) {
            com.tencent.mm.plugin.appbrand.ui.banner.c cVar;
            com.tencent.mm.plugin.appbrand.ui.banner.c cVar2 = (com.tencent.mm.plugin.appbrand.ui.banner.c) n.fS("StickyBannerChangeListener");
            if (cVar2 == null) {
                AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.ui.banner.c(this) {
                    final /* synthetic */ JsApiOperateMusicPlayer iOW;

                    public final void S(String str, int i) {
                        String string = n.getString("appId", "");
                        int i2 = n.getInt("pkgType", 0);
                        if ((!string.equals(str) || i2 != i) && n.fR("Music#isPlaying") && com.tencent.mm.plugin.appbrand.e.nl(string) != com.tencent.mm.plugin.appbrand.e.a.ON_RESUME) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "pause");
                            } catch (JSONException e) {
                            }
                            MainProcessTask operateMusicPlayer = new OperateMusicPlayer(this.iOW, mVar, this.iOW.iOV.iMH);
                            operateMusicPlayer.fQC = jSONObject.toString();
                            operateMusicPlayer.fTO = string;
                            operateMusicPlayer.iHR = n;
                            AppBrandMainProcessService.a(operateMusicPlayer);
                        }
                    }
                };
                AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH);
                if (mY != null) {
                    n.l("pkgType", Integer.valueOf(mY.iFk.izV));
                }
                n.l("StickyBannerChangeListener", anonymousClass1);
                n.l("appId", mVar.ivH);
                cVar = anonymousClass1;
            } else {
                cVar = cVar2;
            }
            if (((com.tencent.mm.plugin.appbrand.e.b) n.fS("AppBrandLifeCycle.Listener")) == null) {
                com.tencent.mm.plugin.appbrand.e.b anonymousClass2 = new com.tencent.mm.plugin.appbrand.e.b(this) {
                    final /* synthetic */ JsApiOperateMusicPlayer iOW;

                    public final void a(com.tencent.mm.plugin.appbrand.e.c cVar) {
                        String string = n.getString("appId", "");
                        int i = n.getInt("pkgType", 0);
                        switch (cVar) {
                            case BACK:
                            case CLOSE:
                                int i2 = com.tencent.mm.plugin.appbrand.b.mZ(string).scene;
                                if (!com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.ap(string, i) && i2 != 1023) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("operationType", "pause");
                                    } catch (JSONException e) {
                                    }
                                    MainProcessTask operateMusicPlayer = new OperateMusicPlayer(this.iOW, mVar, this.iOW.iOV.iMH);
                                    operateMusicPlayer.fQC = jSONObject.toString();
                                    operateMusicPlayer.fTO = string;
                                    operateMusicPlayer.iHR = n;
                                    AppBrandMainProcessService.a(operateMusicPlayer);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }

                    public final void onDestroy() {
                        w.d("MicroMsg.JsApiOperateMusicPlayer", "onDestroy");
                        String string = n.getString("appId", "");
                        n.getInt("pkgType", 0);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("operationType", "stop");
                        } catch (JSONException e) {
                        }
                        MainProcessTask operateMusicPlayer = new OperateMusicPlayer(this.iOW, mVar, this.iOW.iOV.iMH);
                        operateMusicPlayer.fQC = jSONObject.toString();
                        operateMusicPlayer.fTO = string;
                        operateMusicPlayer.action = -1;
                        operateMusicPlayer.iHR = n;
                        AppBrandMainProcessService.b(operateMusicPlayer);
                    }
                };
                n.l("AppBrandLifeCycle.Listener", anonymousClass2);
                this.iOV.iOQ = anonymousClass2;
            }
            this.iOV.iOP = cVar;
            this.iOV.iHR = n;
        }
        this.iOV.fQC = jSONObject.toString();
        this.iOV.fTO = mVar.ivH;
        AppBrandMainProcessService.a(this.iOV);
    }
}
