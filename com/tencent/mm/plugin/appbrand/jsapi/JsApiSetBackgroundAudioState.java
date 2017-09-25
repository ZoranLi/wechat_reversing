package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.banner.c;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.q;
import com.tencent.mm.u.q.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiSetBackgroundAudioState extends a {
    public static final int CTRL_INDEX = 160;
    public static final String NAME = "setBackgroundAudioState";
    public static int iPF = 0;
    public SetBackgroundAudioStateTask iPG;

    private static class SetBackgroundAudioStateTask extends MainProcessTask {
        public static final Creator<SetBackgroundAudioStateTask> CREATOR = new Creator<SetBackgroundAudioStateTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SetBackgroundAudioStateTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetBackgroundAudioStateTask[0];
            }
        };
        public int action;
        public String appId;
        public String fGs;
        public String fKK;
        public int fKL;
        b iHR;
        private d iMF;
        public m iMG;
        public int iMH;
        public boolean iMS = false;
        public String iMT = "";
        c iOP;
        e.b iOQ;
        public String iOR;
        public String iOS;
        private final com.tencent.mm.sdk.b.c iOT = new com.tencent.mm.sdk.b.c<jc>(this) {
            final /* synthetic */ SetBackgroundAudioStateTask iPI;

            {
                this.iPI = r2;
                this.usg = jc.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                jc jcVar = (jc) bVar;
                w.i("MicroMsg.JsApiSetBackgroundAudioState", "musicPlayerListener callback action : %d", new Object[]{Integer.valueOf(jcVar.fPc.action)});
                Map hashMap = new HashMap();
                String str = jcVar.fPc.state;
                if (jcVar.fPc.action == 10) {
                    if (jcVar.fPc.appId.equals(this.iPI.appId)) {
                        w.i("MicroMsg.JsApiSetBackgroundAudioState", "appId is same, don't send ON_PREEMPTED event");
                        return false;
                    }
                    w.i("MicroMsg.JsApiSetBackgroundAudioState", "send ON_PREEMPTED event, sender appId:%s,  receive appId:%s", new Object[]{jcVar.fPc.appId, this.iPI.appId});
                    hashMap.put("state", str);
                    this.iPI.iOS = new JSONObject(hashMap).toString();
                    this.iPI.action = jcVar.fPc.action;
                    this.iPI.SL();
                    return true;
                }
                anf com_tencent_mm_protocal_c_anf = jcVar.fPc.fOY;
                if (com_tencent_mm_protocal_c_anf == null) {
                    w.e("MicroMsg.JsApiSetBackgroundAudioState", "wrapper is null");
                    return false;
                } else if (jcVar.fPc.fPe) {
                    if (this.iPI.appId.equals(a.iwi.iwg)) {
                        hashMap.put("src", com_tencent_mm_protocal_c_anf.tRN);
                        hashMap.put("state", str);
                        hashMap.put("errCode", Integer.valueOf(jcVar.fPc.errCode));
                        Object obj = "";
                        if (!TextUtils.isEmpty(jcVar.fPc.fPf)) {
                            obj = jcVar.fPc.fPf;
                        }
                        hashMap.put("errMsg", obj);
                        this.iPI.iOS = new JSONObject(hashMap).toString();
                        this.iPI.action = jcVar.fPc.action;
                        this.iPI.SL();
                        return true;
                    }
                    w.i("MicroMsg.JsApiSetBackgroundAudioState", "appId is not equals preAppId, don't send any event, appId:%s, preAppId:%s", new Object[]{this.iPI.appId, a.iwi.iwg});
                    return false;
                } else {
                    w.e("MicroMsg.JsApiSetBackgroundAudioState", "is not from QQMusicPlayer, don't callback!");
                    return false;
                }
            }
        };

        public SetBackgroundAudioStateTask(a aVar, m mVar, int i) {
            this.iMF = aVar;
            this.iMG = mVar;
            this.iMH = i;
        }

        public SetBackgroundAudioStateTask(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            w.i("MicroMsg.JsApiSetBackgroundAudioState", "runInMainProcess");
            try {
                JSONObject jSONObject = new JSONObject(this.iOR);
                String optString = jSONObject.optString("src");
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("epname");
                String optString4 = jSONObject.optString("singer");
                String optString5 = jSONObject.optString("coverImgUrl");
                String optString6 = jSONObject.optString("webUrl");
                boolean optBoolean = jSONObject.optBoolean("isLive", false);
                int optInt = jSONObject.optInt("startTime", 0);
                String str = a.iwi.iwg;
                String optString7 = jSONObject.optString("operationType");
                if (!TextUtils.isEmpty(optString7)) {
                    w.i("MicroMsg.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
                    String str2 = a.iwi.iwg;
                    if (bg.mA(str2) || str2.equals(this.appId)) {
                        this.iMS = false;
                        this.action = -1;
                        if (optString7.equalsIgnoreCase("pause")) {
                            if (com.tencent.mm.am.c.HO()) {
                                w.i("MicroMsg.JsApiSetBackgroundAudioState", "pause music ok");
                                this.action = -2;
                            } else {
                                this.iMS = true;
                                this.iMT = "pause music fail";
                            }
                        } else if (optString7.equalsIgnoreCase("stop")) {
                            if (com.tencent.mm.am.c.HP()) {
                                w.i("MicroMsg.JsApiSetBackgroundAudioState", "stop music ok");
                                this.action = -2;
                            } else {
                                this.iMS = true;
                                this.iMT = "stop music fail";
                            }
                        }
                        SL();
                        return;
                    }
                    w.i("MicroMsg.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[]{str2, this.appId});
                } else if (TextUtils.isEmpty(optString)) {
                    w.e("MicroMsg.JsApiSetBackgroundAudioState", "src is null");
                    this.iMS = true;
                    this.action = -1;
                    this.iMT = "src is null";
                    SL();
                } else {
                    com.tencent.mm.sdk.b.b jcVar = new jc();
                    jcVar.fPc.action = 10;
                    jcVar.fPc.state = "preempted";
                    jcVar.fPc.appId = this.appId;
                    jcVar.fPc.fPe = true;
                    a.urY.m(jcVar);
                    w.i("MicroMsg.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, isLive:%b, webUrl:%s, startTime:%d", new Object[]{optString, optString2, optString3, optString4, optString5, Boolean.valueOf(optBoolean), optString6, Integer.valueOf(optInt)});
                    if (!bg.mA(str)) {
                        w.i("MicroMsg.JsApiSetBackgroundAudioState", "remove listener preAppid is %s, appid is %s", new Object[]{str, this.appId});
                        a.iwi.nm(str);
                    }
                    if (optString5 == null) {
                        optString5 = "";
                    }
                    String str3 = (this.appId + optString + optString5).hashCode();
                    com.tencent.mm.am.a.a aVar = (com.tencent.mm.am.a.a) h.h(com.tencent.mm.am.a.a.class);
                    String str4 = com.tencent.mm.compatible.util.e.hgu;
                    StringBuilder stringBuilder = new StringBuilder();
                    ap.yY();
                    anf a = aVar.a(11, optString5, optString2, optString4, optString6, optString, optString, str3, str4, stringBuilder.append(com.tencent.mm.u.c.xb()).append(optString5.hashCode()).toString(), optString3, "");
                    a.iMR = optInt * 1000;
                    a.iwi.a(this.iOT, this.appId);
                    a.iwi.c(this.appId, this.fKL, this.fGs, this.fKK);
                    a.iwi.iwh = a.tqY;
                    com.tencent.mm.am.b.b(a);
                    w.i("MicroMsg.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
                    w.i("MicroMsg.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                    this.iMS = false;
                    this.action = -1;
                    SL();
                }
            } catch (JSONException e) {
                w.e("MicroMsg.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
                this.iMS = true;
                this.action = -1;
                this.iMT = "parser data fail, data is invalid";
                w.e("MicroMsg.JsApiSetBackgroundAudioState", "exception:%s" + e.getMessage());
            }
        }

        public final void SK() {
            if (this.iMG == null) {
                w.e("MicroMsg.JsApiSetBackgroundAudioState", "service is null, don't callback");
            } else if (this.action == -1) {
                if (this.iMS) {
                    w.e("MicroMsg.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", new Object[]{this.iMT});
                    this.iMG.x(this.iMH, this.iMF.d("fail:" + this.iMT, null));
                    return;
                }
                w.i("MicroMsg.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                this.iMG.x(this.iMH, this.iMF.d("ok", null));
            } else if (this.action == -2) {
                w.i("MicroMsg.JsApiSetBackgroundAudioState", "NOT_CALLBACK_EVENT, do nothing");
            } else {
                switch (this.action) {
                    case 0:
                    case 1:
                        this.iHR.l("setBackgroundAudioState#isPlaying", Boolean.valueOf(true));
                        AppBrandStickyBannerLogic.a.b(this.iOP);
                        e.a(this.appId, this.iOQ);
                        AppBrandMusicClientService.jao.jap = this.appId;
                        if (JsApiSetBackgroundAudioState.iPF > 0) {
                            JsApiSetBackgroundAudioState.iPF--;
                            this.iMG.ixr.PA();
                        }
                        if (JsApiSetBackgroundAudioState.iPF == 0) {
                            JsApiSetBackgroundAudioState.iPF++;
                            this.iMG.ixr.Pz();
                            break;
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        this.iHR.l("setBackgroundAudioState#isPlaying", Boolean.valueOf(false));
                        AppBrandStickyBannerLogic.a.a(this.iOP);
                        e.b(this.appId, this.iOQ);
                        if (JsApiSetBackgroundAudioState.iPF > 0) {
                            JsApiSetBackgroundAudioState.iPF--;
                            this.iMG.ixr.PA();
                        }
                        AppBrandMusicClientService.jao.hY(this.action);
                        break;
                    case 10:
                        AppBrandMusicClientService.jao.hY(this.action);
                        break;
                }
                w.i("MicroMsg.JsApiSetBackgroundAudioState", "runInClientProcess callback action:%d, retJson:%s, lockCount:%d", new Object[]{Integer.valueOf(this.action), this.iOS, Integer.valueOf(JsApiSetBackgroundAudioState.iPF)});
                e a = new JsApiOperateBackgroundAudio.a().a(this.iMG);
                a.mData = this.iOS;
                a.SR();
            }
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.appId = parcel.readString();
            this.iOR = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.iMS = z;
            this.iMT = parcel.readString();
            this.iOS = parcel.readString();
            this.action = parcel.readInt();
            this.fKL = parcel.readInt();
            this.fGs = parcel.readString();
            this.fKK = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.iOR);
            parcel.writeInt(this.iMS ? 1 : 0);
            parcel.writeString(this.iMT);
            parcel.writeString(this.iOS);
            parcel.writeInt(this.action);
            parcel.writeInt(this.fKL);
            parcel.writeString(this.fGs);
            parcel.writeString(this.fKK);
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            mVar.x(i, d("fail:data is null", null));
            w.e("MicroMsg.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
            return;
        }
        String str = mVar.ivH;
        w.i("MicroMsg.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", new Object[]{str, jSONObject.toString()});
        if (this.iPG == null) {
            this.iPG = new SetBackgroundAudioStateTask(this, mVar, i);
        }
        this.iPG.iMH = i;
        this.iPG.appId = str;
        this.iPG.iOR = jSONObject.toString();
        final AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(str);
        this.iPG.fKL = mY.iFk.izV;
        this.iPG.fGs = mY.fGs;
        this.iPG.fKK = mY.fCJ;
        w.i("MicroMsg.JsApiSetBackgroundAudioState", "pkgType:%d, brandName:%s, appUserName", new Object[]{Integer.valueOf(this.iPG.fKL), this.iPG.fGs, this.iPG.fKK});
        final b n = q.yC().n(q.fQ("AppBrandService#" + mVar.hashCode()), true);
        synchronized (n) {
            c cVar;
            c cVar2 = (c) n.fS("StickyBannerChangeListener");
            if (cVar2 == null) {
                final m mVar2 = mVar;
                final int i2 = i;
                AnonymousClass1 anonymousClass1 = new c(this) {
                    final /* synthetic */ JsApiSetBackgroundAudioState iPH;

                    public final void S(String str, int i) {
                        String string = n.getString("appId", "");
                        int i2 = n.getInt("pkgType", 0);
                        if ((!string.equals(str) || i2 != i) && n.fR("setBackgroundAudioState#isPlaying") && e.nl(string) != e.a.ON_RESUME) {
                            w.i("MicroMsg.JsApiSetBackgroundAudioState", "onStickyBannerChanged, pause the music");
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "pause");
                            } catch (JSONException e) {
                            }
                            if (this.iPH.iPG == null) {
                                this.iPH.iPG = new SetBackgroundAudioStateTask(this.iPH, mVar2, i2);
                            }
                            this.iPH.iPG.iOR = jSONObject.toString();
                            this.iPH.iPG.appId = string;
                            this.iPH.iPG.iHR = n;
                            this.iPH.iPG.fKL = mY.iFk.izV;
                            this.iPH.iPG.fGs = mY.fGs;
                            this.iPH.iPG.fKK = mY.fCJ;
                            AppBrandMainProcessService.a(this.iPH.iPG);
                        }
                    }
                };
                AppBrandSysConfig mY2 = com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH);
                if (mY2 != null) {
                    n.l("pkgType", Integer.valueOf(mY2.iFk.izV));
                }
                n.l("StickyBannerChangeListener", anonymousClass1);
                n.l("appId", mVar.ivH);
                cVar = anonymousClass1;
            } else {
                cVar = cVar2;
            }
            if (((e.b) n.fS("AppBrandLifeCycle.Listener")) == null) {
                mVar2 = mVar;
                i2 = i;
                e.b anonymousClass2 = new e.b(this) {
                    final /* synthetic */ JsApiSetBackgroundAudioState iPH;

                    public final void onDestroy() {
                        w.i("MicroMsg.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", new Object[]{n.getString("appId", "")});
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("operationType", "stop");
                        } catch (JSONException e) {
                        }
                        if (this.iPH.iPG == null) {
                            this.iPH.iPG = new SetBackgroundAudioStateTask(this.iPH, mVar2, i2);
                        }
                        this.iPH.iPG.iOR = jSONObject.toString();
                        this.iPH.iPG.appId = r0;
                        this.iPH.iPG.action = -1;
                        this.iPH.iPG.iHR = n;
                        this.iPH.iPG.fKL = mY.iFk.izV;
                        this.iPH.iPG.fGs = mY.fGs;
                        this.iPH.iPG.fKK = mY.fCJ;
                        AppBrandMainProcessService.b(this.iPH.iPG);
                    }
                };
                n.l("AppBrandLifeCycle.Listener", anonymousClass2);
                this.iPG.iOQ = anonymousClass2;
            }
            this.iPG.iOP = cVar;
            this.iPG.iHR = n;
        }
        AppBrandMainProcessService.a(this.iPG);
    }
}
