package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.R;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.media.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class JsApiStartRecordVoice extends a {
    public static final int CTRL_INDEX = 31;
    public static final String NAME = "startRecord";
    static volatile String iQb = null;
    public m iPV;
    private StartRecordVoice iQc;

    private static class StartRecordVoice extends MainProcessTask {
        public static final Creator<StartRecordVoice> CREATOR = new Creator<StartRecordVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StartRecordVoice(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartRecordVoice[i];
            }
        };
        private String appId;
        public int duration;
        public String filePath;
        private com.tencent.mm.plugin.appbrand.m iMG;
        private int iMH;
        private JsApiStartRecordVoice iQe;
        public boolean iQf = false;
        public int result;

        StartRecordVoice(JsApiStartRecordVoice jsApiStartRecordVoice, com.tencent.mm.plugin.appbrand.m mVar, int i, int i2) {
            this.iQe = jsApiStartRecordVoice;
            this.iMG = mVar;
            this.duration = i;
            this.iMH = i2;
            this.appId = mVar.ivH;
            this.filePath = c.aC(this.appId, u.mf(this.appId));
        }

        StartRecordVoice(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            d.vL().D(new Runnable(this) {
                final /* synthetic */ StartRecordVoice iQg;

                {
                    this.iQg = r1;
                }

                public final void run() {
                    this.iQg.iQf = a.a(this.iQg.filePath, new a.a(this) {
                        final /* synthetic */ AnonymousClass1 iQh;

                        {
                            this.iQh = r1;
                        }

                        public final void hL(int i) {
                            this.iQh.iQg.result = i;
                            this.iQh.iQg.SL();
                        }
                    }, this.iQg.duration * 1000);
                    if (!this.iQg.iQf) {
                        this.iQg.SL();
                    }
                }
            });
        }

        public final void SK() {
            if (this.result == -1) {
                w.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
                this.iMG.x(this.iMH, this.iQe.d("fail:record_error", null));
                return;
            }
            if (this.iQf) {
                AppBrandLocalMediaObject b = c.b(this.iMG.ivH, this.filePath, "silk", true);
                if (b != null) {
                    Map hashMap = new HashMap(1);
                    hashMap.put("tempFilePath", b.fJz);
                    this.iMG.x(this.iMH, this.iQe.d("ok", hashMap));
                    w.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[]{this.appId, Boolean.valueOf(this.iQf)});
                    this.iQe.bL(false);
                }
            }
            this.iMG.x(this.iMH, this.iQe.d("fail", null));
            w.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[]{this.appId, Boolean.valueOf(this.iQf)});
            this.iQe.bL(false);
        }

        public final void f(Parcel parcel) {
            this.iMH = parcel.readInt();
            this.appId = parcel.readString();
            this.filePath = parcel.readString();
            this.iQf = parcel.readByte() != (byte) 0;
            this.duration = parcel.readInt();
            this.result = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.iMH);
            parcel.writeString(this.appId);
            parcel.writeString(this.filePath);
            parcel.writeByte(this.iQf ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.duration);
            parcel.writeInt(this.result);
        }
    }

    JsApiStartRecordVoice() {
    }

    public final void a(final com.tencent.mm.plugin.appbrand.m mVar, final JSONObject jSONObject, final int i) {
        boolean z;
        int i2 = 60;
        int i3 = 600;
        b.a(mVar.ivH, new android.support.v4.app.a.a(this) {
            final /* synthetic */ JsApiStartRecordVoice iQd;

            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                if (i == 116) {
                    if (iArr[0] == 0) {
                        this.iQd.a(mVar, jSONObject, i);
                    } else {
                        mVar.x(i, this.iQd.d("fail:system permission denied", null));
                    }
                }
            }
        });
        Activity a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            z = false;
        } else {
            z = com.tencent.mm.pluginsdk.i.a.a(a, "android.permission.RECORD_AUDIO", 116, "", "");
            if (z) {
                b.mX(mVar.ivH);
            }
        }
        if (z) {
            this.iPV = d.b(mVar);
            if (this.iPV == null) {
                mVar.x(i, d("fail", null));
                return;
            }
            int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 60);
            if (optInt <= 0) {
                w.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
            } else {
                i2 = optInt;
            }
            if (i2 > 600) {
                w.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", new Object[]{Integer.valueOf(600)});
            } else {
                i3 = i2;
            }
            this.iPV.a(new m.b(this) {
                final /* synthetic */ JsApiStartRecordVoice iQd;

                {
                    this.iQd = r1;
                }

                public final void SY() {
                    this.iQd.iPV.qq("");
                    if (!bg.mA(JsApiStartRecordVoice.iQb)) {
                        AppBrandMainProcessService.a(new StopRecordVoice());
                        JsApiStartRecordVoice.iQb = null;
                    }
                    this.iQd.iPV.b((m.b) this);
                }
            });
            this.iQc = new StartRecordVoice(this, mVar, i3, i);
            iQb = this.iQc.filePath;
            AppBrandMainProcessService.a(this.iQc);
            bL(true);
        }
    }

    public final void bL(boolean z) {
        if (this.iPV != null) {
            if (z) {
                this.iPV.qq(ab.getContext().getString(R.l.dEH));
                this.iPV.VS();
                return;
            }
            this.iPV.qq(null);
        }
    }
}
