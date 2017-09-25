package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.a.ev;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import com.tencent.mm.y.g;
import com.tencent.mm.y.g.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiStartPlayVoice extends a {
    public static final int CTRL_INDEX = 33;
    public static final String NAME = "playVoice";
    public static String iPW = null;
    public m iPV = null;
    private StartPlayVoice iPX;

    private static class StartPlayVoice extends MainProcessTask {
        public static final Creator<StartPlayVoice> CREATOR = new Creator<StartPlayVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StartPlayVoice(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartPlayVoice[i];
            }
        };
        public String fJz;
        public String filePath;
        public d iMF;
        public com.tencent.mm.plugin.appbrand.m iMG;
        public int iMH;
        public boolean iMS = false;

        public StartPlayVoice(d dVar, com.tencent.mm.plugin.appbrand.m mVar, int i) {
            this.iMF = dVar;
            this.iMG = mVar;
            this.iMH = i;
        }

        public StartPlayVoice(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            af.v(new Runnable(this) {
                final /* synthetic */ StartPlayVoice iPZ;

                {
                    this.iPZ = r1;
                }

                public final void run() {
                    b evVar = new ev();
                    evVar.fJa.op = 1;
                    evVar.fJa.fyF = this.iPZ.filePath;
                    evVar.fJa.fJc = true;
                    evVar.fJa.fyQ = true;
                    evVar.fJa.fJd = new a(this) {
                        final /* synthetic */ AnonymousClass1 iQa;

                        {
                            this.iQa = r1;
                        }

                        public final void oW() {
                            this.iQa.iPZ.iMS = false;
                            this.iQa.iPZ.SL();
                        }
                    };
                    evVar.fJa.fJe = new g.b(this) {
                        final /* synthetic */ AnonymousClass1 iQa;

                        {
                            this.iQa = r1;
                        }

                        public final void onError() {
                            this.iQa.iPZ.iMS = true;
                            this.iQa.iPZ.SL();
                        }
                    };
                    com.tencent.mm.sdk.b.a.urY.m(evVar);
                }
            });
        }

        public final void SK() {
            Map hashMap = new HashMap();
            hashMap.put("localId", this.fJz);
            this.iMG.x(this.iMH, this.iMF.d(this.iMS ? "fail" : "ok", hashMap));
            JsApiStartPlayVoice.iPW = null;
        }

        public final void f(Parcel parcel) {
            this.fJz = parcel.readString();
            this.filePath = parcel.readString();
            this.iMS = parcel.readByte() != (byte) 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.fJz);
            parcel.writeString(this.filePath);
            parcel.writeByte(this.iMS ? (byte) 1 : (byte) 0);
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.m mVar, JSONObject jSONObject, int i) {
        String ap = bg.ap(jSONObject.optString(DownloadInfoColumns.FILEPATH, null), jSONObject.optString("localId"));
        w.i("MicroMsg.JsApiStartPlayVoice", "doPlayVoice, appId : %s, localId : %s", new Object[]{mVar.ivH, ap});
        if (bg.mA(ap)) {
            mVar.x(i, d("fail_missing arguments", null));
            return;
        }
        AppBrandLocalMediaObject aH = c.aH(mVar.ivH, ap);
        if (aH == null || bg.mA(aH.hos) || d.b(mVar) == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        this.iPV = d.b(mVar);
        q.b n = q.yC().n("JsApi@" + this.iPV.hashCode(), true);
        m.b bVar = (m.b) n.fS("onBackgroundListener");
        if (bVar == null) {
            bVar = new m.b(this) {
                final /* synthetic */ JsApiStartPlayVoice iPY;

                {
                    this.iPY = r1;
                }

                public final void SY() {
                    JsApiStopPlayVoice.Tk();
                    this.iPY.iPV.b((m.b) this);
                }
            };
            n.l("onBackgroundListener", bVar);
        }
        this.iPV.a(bVar);
        if (((m.c) n.fS("onDestroyListener")) == null) {
            m.c anonymousClass2 = new m.c(this) {
                final /* synthetic */ JsApiStartPlayVoice iPY;

                {
                    this.iPY = r1;
                }

                public final void onDestroy() {
                    JsApiStopPlayVoice.Tk();
                    this.iPY.iPV.b((m.c) this);
                }
            };
            n.l("onDestroyListener", anonymousClass2);
            this.iPV.a(anonymousClass2);
        }
        if (this.iPX == null) {
            this.iPX = new StartPlayVoice(this, mVar, i);
        }
        if (iPW != null) {
            Map hashMap = new HashMap();
            hashMap.put("localId", this.iPX.fJz);
            mVar.x(this.iPX.iMH, d("ok", hashMap));
        }
        this.iPX.iMF = this;
        this.iPX.iMG = mVar;
        this.iPX.iMH = i;
        this.iPX.fJz = ap;
        this.iPX.filePath = aH.hos;
        AppBrandMainProcessService.a(this.iPX);
        iPW = ap;
    }
}
