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
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiGetMusicPlayerState extends a {
    public static final int CTRL_INDEX = 46;
    public static final String NAME = "getMusicPlayerState";
    private GetMusicPlayerState iNr;

    private static class GetMusicPlayerState extends MainProcessTask {
        public static final Creator<GetMusicPlayerState> CREATOR = new Creator<GetMusicPlayerState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetMusicPlayerState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetMusicPlayerState[i];
            }
        };
        private d iMF;
        private m iMG;
        private int iMH;
        public boolean iMS = false;
        public String iMT;
        public String iNs;
        public int iNt;
        public String iNu;
        public int kC;
        public int ls;
        public int mStatus;

        public GetMusicPlayerState(d dVar, m mVar, int i) {
            this.iMF = dVar;
            this.iMG = mVar;
            this.iMH = i;
        }

        public GetMusicPlayerState(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            int i = -1;
            String str = a.iwi.iwg;
            if (bg.mA(str) || str.equals(this.iNs)) {
                anf HL = b.HL();
                if (HL != null) {
                    int i2;
                    d HM = b.HM();
                    if (HM != null) {
                        i2 = HM.ls;
                        i = HM.kC;
                        this.mStatus = HM.mStatus;
                        this.iNt = HM.hMV;
                    } else {
                        i2 = -1;
                    }
                    this.ls = i2 / 1000;
                    this.kC = i / 1000;
                    this.iNu = HL.tRN;
                    this.iMT = "";
                    this.iMS = false;
                } else {
                    this.mStatus = 2;
                    this.iMT = "";
                    this.iMS = false;
                }
                w.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", new Object[]{Integer.valueOf(this.ls), Integer.valueOf(this.kC), Integer.valueOf(this.mStatus), Integer.valueOf(this.iNt), this.iNu});
                SL();
                return;
            }
            w.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
            this.iMS = true;
            this.iMT = "appid not match cannot operate";
            SL();
        }

        public final void SK() {
            String str;
            Map hashMap = new HashMap();
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.ls));
            hashMap.put("currentPosition", Integer.valueOf(this.kC));
            hashMap.put(DownloadInfo.STATUS, Integer.valueOf(this.mStatus));
            hashMap.put("downloadPercent", Integer.valueOf(this.iNt));
            hashMap.put("dataUrl", this.iNu);
            m mVar = this.iMG;
            int i = this.iMH;
            d dVar = this.iMF;
            if (this.iMS) {
                str = "fail" + (TextUtils.isEmpty(this.iMT) ? "" : ":" + this.iMT);
            } else {
                str = "ok";
            }
            mVar.x(i, dVar.d(str, hashMap));
        }

        public final void f(Parcel parcel) {
            this.iNs = parcel.readString();
            this.iMS = parcel.readByte() != (byte) 0;
            this.ls = parcel.readInt();
            this.kC = parcel.readInt();
            this.mStatus = parcel.readInt();
            this.iNt = parcel.readInt();
            this.iNu = parcel.readString();
            this.iMT = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.iNs);
            parcel.writeByte(this.iMS ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.ls);
            parcel.writeInt(this.kC);
            parcel.writeInt(this.mStatus);
            parcel.writeInt(this.iNt);
            parcel.writeString(this.iNu);
            parcel.writeString(this.iMT);
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        this.iNr = new GetMusicPlayerState(this, mVar, i);
        this.iNr.iNs = mVar.ivH;
        AppBrandMainProcessService.a(this.iNr);
    }
}
