package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.am.b;
import com.tencent.mm.am.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiGetBackgroundAudioState extends a {
    public static final int CTRL_INDEX = 159;
    public static final String NAME = "getBackgroundAudioState";

    private static class GetBackgroundAudioStateTask extends MainProcessTask {
        public static final Creator<GetBackgroundAudioStateTask> CREATOR = new Creator<GetBackgroundAudioStateTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetBackgroundAudioStateTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetBackgroundAudioStateTask[i];
            }
        };
        public String appId = "";
        public int duration = 0;
        private d iMF;
        public m iMG;
        public int iMH;
        public int iMI;
        public int iMJ;
        public int iMK;
        public String iML;
        public String iMM;
        public String iMN;
        public String iMO;
        public String iMP;
        public int iMQ;
        public int iMR;
        public boolean iMS = false;
        public String iMT;
        public String title;

        public GetBackgroundAudioStateTask(d dVar, m mVar, int i) {
            this.iMF = dVar;
            this.iMG = mVar;
            this.iMH = i;
        }

        public GetBackgroundAudioStateTask(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            int i = -1;
            String str = a.iwi.iwg;
            if (bg.mA(str) || str.equals(this.appId)) {
                anf HL = b.HL();
                if (HL != null) {
                    int i2;
                    d HM = b.HM();
                    if (HM != null) {
                        i2 = HM.ls;
                        i = HM.kC;
                    } else {
                        i2 = -1;
                    }
                    if (HM == null || i2 < 0 || i < 0) {
                        w.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                        this.iMS = true;
                        this.iMT = "return parameter is invalid";
                        return;
                    }
                    i2 /= 1000;
                    int i3 = i / 1000;
                    int i4 = HM.mStatus;
                    i = HM.hMV;
                    if (i2 > 0) {
                        i = (i * i2) / 100;
                    } else {
                        i = 0;
                    }
                    this.duration = i2;
                    this.iMI = i3;
                    this.iMJ = i4 == 1 ? 0 : 1;
                    this.iML = HL.tRN;
                    this.iMK = i;
                    this.title = HL.tRJ;
                    this.iMM = HL.tRL;
                    this.iMN = HL.tRK;
                    this.iMO = HL.tRM;
                    this.iMP = HL.tRP;
                    this.iMQ = 0;
                    this.iMR = HL.iMR;
                    w.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s", new Object[]{Integer.valueOf(this.duration), Integer.valueOf(this.iMI), Integer.valueOf(this.iMJ), Integer.valueOf(this.iMK), this.iML, Integer.valueOf(this.iMR), this.title, this.iMN, this.iMP, this.iMO});
                } else {
                    w.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
                    this.iMS = true;
                    this.iMT = "currentWrapper is null";
                }
                SL();
                return;
            }
            w.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", new Object[]{str, this.appId});
            this.iMS = true;
            this.iMT = "appid not match cannot get background audio state";
            SL();
        }

        public final void SK() {
            if (this.iMG == null) {
                w.e("MicroMsg.JsApiGetBackgroundAudioState", "service is null");
                return;
            }
            boolean z;
            Map hashMap = new HashMap();
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.duration));
            hashMap.put("currentTime", Integer.valueOf(this.iMI));
            hashMap.put("paused", Boolean.valueOf(this.iMJ == 1));
            hashMap.put("buffered", Integer.valueOf(this.iMK));
            hashMap.put("src", this.iML);
            hashMap.put("title", this.title);
            hashMap.put("epname", this.iMM);
            hashMap.put("singer", this.iMN);
            hashMap.put("coverImgUrl", this.iMO);
            hashMap.put("webUrl", this.iMP);
            String str = "isLive";
            if (this.iMQ == 1) {
                z = true;
            } else {
                z = false;
            }
            hashMap.put(str, Boolean.valueOf(z));
            hashMap.put("startTime", Integer.valueOf(this.iMR / 1000));
            String str2 = TextUtils.isEmpty(this.iMT) ? "" : this.iMT;
            if (this.iMS) {
                w.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", new Object[]{str2});
            } else {
                w.d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
            }
            m mVar = this.iMG;
            int i = this.iMH;
            d dVar = this.iMF;
            if (this.iMS) {
                str2 = "fail:" + str2;
            } else {
                str2 = "ok";
            }
            mVar.x(i, dVar.d(str2, hashMap));
        }

        public final void f(Parcel parcel) {
            this.appId = parcel.readString();
            this.duration = parcel.readInt();
            this.iMI = parcel.readInt();
            this.iMJ = parcel.readInt();
            this.iMK = parcel.readInt();
            this.iML = parcel.readString();
            this.title = parcel.readString();
            this.iMM = parcel.readString();
            this.iMN = parcel.readString();
            this.iMO = parcel.readString();
            this.iMP = parcel.readString();
            this.iMQ = parcel.readInt();
            this.iMR = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeInt(this.duration);
            parcel.writeInt(this.iMI);
            parcel.writeInt(this.iMJ);
            parcel.writeInt(this.iMK);
            parcel.writeString(this.iML);
            parcel.writeString(this.title);
            parcel.writeString(this.iMM);
            parcel.writeString(this.iMN);
            parcel.writeString(this.iMO);
            parcel.writeString(this.iMP);
            parcel.writeInt(this.iMQ);
            parcel.writeInt(this.iMR);
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String str = mVar.ivH;
        MainProcessTask getBackgroundAudioStateTask = new GetBackgroundAudioStateTask(this, mVar, i);
        getBackgroundAudioStateTask.appId = str;
        AppBrandMainProcessService.a(getBackgroundAudioStateTask);
    }
}
