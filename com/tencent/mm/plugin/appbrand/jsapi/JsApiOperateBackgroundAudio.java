package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.ui.banner.c;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import com.tencent.mm.u.q.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiOperateBackgroundAudio extends a {
    public static final int CTRL_INDEX = 161;
    public static final String NAME = "operateBackgroundAudio";
    public OperateBackgroundAudioTask iOM;

    private static class OperateBackgroundAudioTask extends MainProcessTask {
        public static final Creator<OperateBackgroundAudioTask> CREATOR = new Creator<OperateBackgroundAudioTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OperateBackgroundAudioTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateBackgroundAudioTask[0];
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
            final /* synthetic */ OperateBackgroundAudioTask iOU;

            {
                this.iOU = r2;
                this.usg = jc.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                jc jcVar = (jc) bVar;
                w.i("MicroMsg.JsApiOperateBackgroundAudio", "musicPlayerListener callback action : %d", new Object[]{Integer.valueOf(jcVar.fPc.action)});
                String str = jcVar.fPc.state;
                Map hashMap = new HashMap();
                if (jcVar.fPc.action == 10) {
                    if (jcVar.fPc.appId.equals(this.iOU.appId)) {
                        w.i("MicroMsg.JsApiOperateBackgroundAudio", "appId is same, don't send ON_PREEMPTED event");
                        return false;
                    }
                    w.i("MicroMsg.JsApiOperateBackgroundAudio", "send ON_PREEMPTED event, sender appId:%s,  receive appId:%s", new Object[]{jcVar.fPc.appId, this.iOU.appId});
                    hashMap.put("state", str);
                    this.iOU.iOS = new JSONObject(hashMap).toString();
                    this.iOU.action = jcVar.fPc.action;
                    this.iOU.SL();
                    return true;
                }
                anf com_tencent_mm_protocal_c_anf = jcVar.fPc.fOY;
                if (com_tencent_mm_protocal_c_anf == null) {
                    w.e("MicroMsg.JsApiOperateBackgroundAudio", "wrapper is null");
                    return false;
                } else if (jcVar.fPc.fPe) {
                    if (this.iOU.appId.equals(a.iwi.iwg)) {
                        hashMap.put("src", com_tencent_mm_protocal_c_anf.tRN);
                        hashMap.put("state", str);
                        hashMap.put("errCode", Integer.valueOf(jcVar.fPc.errCode));
                        Object obj = "";
                        if (!TextUtils.isEmpty(jcVar.fPc.fPf)) {
                            obj = jcVar.fPc.fPf;
                        }
                        hashMap.put("errMsg", obj);
                        this.iOU.iOS = new JSONObject(hashMap).toString();
                        this.iOU.action = jcVar.fPc.action;
                        this.iOU.SL();
                        return true;
                    }
                    w.i("MicroMsg.JsApiOperateBackgroundAudio", "appId is not equals preAppId, don't send any event, appId:%s, preAppId:%s", new Object[]{this.iOU.appId, a.iwi.iwg});
                    return false;
                } else {
                    w.e("MicroMsg.JsApiOperateBackgroundAudio", "is not from QQMusicPlayer, don't callback!");
                    return false;
                }
            }
        };

        public OperateBackgroundAudioTask(a aVar, m mVar, int i) {
            this.iMF = aVar;
            this.iMG = mVar;
            this.iMH = i;
        }

        public OperateBackgroundAudioTask(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            w.i("MicroMsg.JsApiOperateBackgroundAudio", "runInMainProcess");
            String str = a.iwi.iwg;
            if (bg.mA(str) || str.equals(this.appId)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.iOR);
                    String optString = jSONObject.optString("operationType");
                    int optInt = jSONObject.optInt("currentTime", -1);
                    if (TextUtils.isEmpty(optString)) {
                        w.e("MicroMsg.JsApiOperateBackgroundAudio", "operationType is null");
                        this.iMS = true;
                        this.action = -1;
                        this.iMT = "operationType is null";
                        SL();
                        return;
                    }
                    w.i("MicroMsg.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%d", new Object[]{optString, Integer.valueOf(optInt)});
                    this.iMS = false;
                    this.action = -1;
                    if (optString.equalsIgnoreCase("play")) {
                        if (!bg.mA(str)) {
                            w.i("MicroMsg.JsApiOperateBackgroundAudio", "remove listener preAppid is %s, appid is %s", new Object[]{str, this.appId});
                            a.iwi.nm(str);
                        }
                        a.iwi.a(this.iOT, this.appId);
                        a.iwi.c(this.appId, this.fKL, this.fGs, this.fKK);
                        anf HL = com.tencent.mm.am.b.HL();
                        if (HL != null) {
                            a.iwi.iwh = HL.tqY;
                        }
                        if (com.tencent.mm.am.c.HN()) {
                            w.i("MicroMsg.JsApiOperateBackgroundAudio", "play music ok");
                        } else if (com.tencent.mm.am.b.HJ()) {
                            this.iMS = true;
                            this.iMT = "music is playing, don't play again";
                        } else {
                            this.iMS = true;
                            this.iMT = "play music fail";
                        }
                    } else if (optString.equalsIgnoreCase("pause")) {
                        if (com.tencent.mm.am.c.HO()) {
                            w.i("MicroMsg.JsApiOperateBackgroundAudio", "pause music ok");
                        } else {
                            this.iMS = true;
                            this.iMT = "pause music fail";
                        }
                    } else if (optString.equalsIgnoreCase("seek")) {
                        if (optInt < 0) {
                            w.e("MicroMsg.JsApiOperateBackgroundAudio", "currentTime is invalid!");
                            this.iMS = true;
                            this.iMT = "currentTime is invalid";
                        } else if (com.tencent.mm.am.b.gi(optInt * 1000)) {
                            w.i("MicroMsg.JsApiOperateBackgroundAudio", "seek music ok");
                        } else {
                            this.iMS = true;
                            this.iMT = "seek music fail";
                        }
                    } else if (!optString.equalsIgnoreCase("stop")) {
                        w.e("MicroMsg.JsApiOperateBackgroundAudio", "operationType is invalid");
                        this.iMS = true;
                        this.iMT = "operationType is invalid";
                    } else if (com.tencent.mm.am.c.HP()) {
                        w.i("MicroMsg.JsApiOperateBackgroundAudio", "stop music ok");
                    } else {
                        this.iMS = true;
                        this.iMT = "stop music fail";
                    }
                    if (this.iMS) {
                        w.e("MicroMsg.JsApiOperateBackgroundAudio", this.iMT);
                    }
                    SL();
                    return;
                } catch (JSONException e) {
                    w.e("MicroMsg.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", new Object[]{this.iOR});
                    this.iMS = true;
                    this.action = -1;
                    this.iMT = "parser data fail, data is invalid";
                    w.e("MicroMsg.JsApiOperateBackgroundAudio", "exception:%s" + e.getMessage());
                    SL();
                    return;
                }
            }
            w.i("MicroMsg.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[]{str, this.appId});
            this.iMS = true;
            this.iMT = "appid not match cannot operate";
            SL();
        }

        public final void SK() {
            if (this.iMG == null) {
                w.e("MicroMsg.JsApiOperateBackgroundAudio", "service is null, don't callback");
            } else if (this.action != -1) {
                switch (this.action) {
                    case 0:
                    case 1:
                        this.iHR.l("operateBackgroundAudio#isPlaying", Boolean.valueOf(true));
                        com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.b(this.iOP);
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
                        this.iHR.l("operateBackgroundAudio#isPlaying", Boolean.valueOf(false));
                        com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.a(this.iOP);
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
                w.i("MicroMsg.JsApiOperateBackgroundAudio", "operateBackgroundAudio onBackgroundAudioStateChange callback action:%d, retJson:%s, lockCount:%d", new Object[]{Integer.valueOf(this.action), this.iOS, Integer.valueOf(JsApiSetBackgroundAudioState.iPF)});
                e a = new a().a(this.iMG);
                a.mData = this.iOS;
                a.SR();
            } else if (this.iMS) {
                w.e("MicroMsg.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", new Object[]{this.iMT});
                this.iMG.x(this.iMH, this.iMF.d("fail:" + this.iMT, null));
            } else {
                w.i("MicroMsg.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
                this.iMG.x(this.iMH, this.iMF.d("ok", null));
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

    public static final class a extends e {
        private static final int CTRL_INDEX = 162;
        private static final String NAME = "onBackgroundAudioStateChange";
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            mVar.x(i, d("fail:data is null", null));
            w.e("MicroMsg.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
            return;
        }
        String str = mVar.ivH;
        w.i("MicroMsg.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", new Object[]{str});
        if (this.iOM == null) {
            this.iOM = new OperateBackgroundAudioTask(this, mVar, i);
        }
        this.iOM.iMH = i;
        this.iOM.appId = str;
        this.iOM.iOR = jSONObject.toString();
        final AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(str);
        this.iOM.fKL = mY.iFk.izV;
        this.iOM.fGs = mY.fGs;
        this.iOM.fKK = mY.fCJ;
        final b n = q.yC().n(q.fQ("AppBrandService#" + mVar.hashCode()), true);
        synchronized (n) {
            c cVar;
            c cVar2 = (c) n.fS("StickyBannerChangeListener");
            if (cVar2 == null) {
                final m mVar2 = mVar;
                final int i2 = i;
                AnonymousClass1 anonymousClass1 = new c(this) {
                    final /* synthetic */ JsApiOperateBackgroundAudio iOO;

                    public final void S(String str, int i) {
                        String string = n.getString("appId", "");
                        int i2 = n.getInt("pkgType", 0);
                        if ((!string.equals(str) || i2 != i) && n.fR("operateBackgroundAudio#isPlaying") && e.nl(string) != com.tencent.mm.plugin.appbrand.e.a.ON_RESUME) {
                            w.i("MicroMsg.JsApiOperateBackgroundAudio", "onStickyBannerChanged, pause the music");
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "pause");
                            } catch (JSONException e) {
                            }
                            if (this.iOO.iOM == null) {
                                this.iOO.iOM = new OperateBackgroundAudioTask(this.iOO, mVar2, i2);
                            }
                            this.iOO.iOM.iOR = jSONObject.toString();
                            this.iOO.iOM.appId = string;
                            this.iOO.iOM.iHR = n;
                            this.iOO.iOM.fKL = mY.iFk.izV;
                            this.iOO.iOM.fGs = mY.fGs;
                            this.iOO.iOM.fKK = mY.fCJ;
                            AppBrandMainProcessService.a(this.iOO.iOM);
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
                    final /* synthetic */ JsApiOperateBackgroundAudio iOO;

                    public final void onDestroy() {
                        w.i("MicroMsg.JsApiOperateBackgroundAudio", "onDestroy, appId:%s", new Object[]{n.getString("appId", "")});
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("operationType", "stop");
                        } catch (JSONException e) {
                        }
                        if (this.iOO.iOM == null) {
                            this.iOO.iOM = new OperateBackgroundAudioTask(this.iOO, mVar2, i2);
                        }
                        this.iOO.iOM.iOR = jSONObject.toString();
                        this.iOO.iOM.appId = r0;
                        this.iOO.iOM.action = -1;
                        this.iOO.iOM.iHR = n;
                        this.iOO.iOM.fKL = mY.iFk.izV;
                        this.iOO.iOM.fGs = mY.fGs;
                        this.iOO.iOM.fKK = mY.fCJ;
                        AppBrandMainProcessService.b(this.iOO.iOM);
                    }
                };
                n.l("AppBrandLifeCycle.Listener", anonymousClass2);
                this.iOM.iOQ = anonymousClass2;
            }
            this.iOM.iOP = cVar;
            this.iOM.iHR = n;
        }
        AppBrandMainProcessService.a(this.iOM);
    }
}
