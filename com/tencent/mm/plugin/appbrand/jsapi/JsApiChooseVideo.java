package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class JsApiChooseVideo extends a {
    public static final int CTRL_INDEX = 36;
    public static final String NAME = "chooseVideo";
    public static volatile boolean iMe = false;

    private static final class ChooseRequest extends ProcessRequest {
        public static final Creator<ChooseRequest> CREATOR = new Creator<ChooseRequest>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ChooseRequest(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseRequest[i];
            }
        };
        String appId;
        int iLR;
        boolean iLr;
        boolean iLs;

        protected final Class<? extends AppBrandProxyUIProcessTask> SI() {
            return a.class;
        }

        protected final String SH() {
            return "GalleryChooseVideo";
        }

        protected final void h(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.appId = parcel.readString();
            this.iLR = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.iLr = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.iLs = z2;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            parcel.writeString(this.appId);
            parcel.writeInt(this.iLR);
            if (this.iLr) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.iLs) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
        }

        protected final boolean SG() {
            return true;
        }

        ChooseRequest() {
        }

        ChooseRequest(Parcel parcel) {
            h(parcel);
        }
    }

    private static final class ChooseResult extends ProcessResult {
        public static final Creator<ChooseResult> CREATOR = new Creator<ChooseResult>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ChooseResult(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseResult[i];
            }
        };
        int aMA;
        AppBrandLocalVideoObject iMg;

        protected final void h(Parcel parcel) {
            this.aMA = parcel.readInt();
            this.iMg = (AppBrandLocalVideoObject) parcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader());
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.aMA);
            parcel.writeParcelable(this.iMg, i);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            h(parcel);
        }
    }

    private static final class a extends AppBrandProxyUIProcessTask {
        private OnCancelListener iLA;
        public String iLV;
        private p iLz;
        public ChooseResult iMh = new ChooseResult();
        private ChooseRequest iMi;

        private a() {
        }

        protected final void a(ProcessRequest processRequest) {
            boolean z;
            this.iMi = (ChooseRequest) processRequest;
            this.iMi.iLR = Math.min(Math.max(this.iMi.iLR, 60), 0);
            if (bg.en(SD()) > 200) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                s.makeText(SD(), ab.getResources().getString(R.l.fmx), 1).show();
            }
            SD().uSV = this;
            Intent intent = new Intent();
            intent.putExtra("key_send_raw_image", false);
            intent.putExtra("query_media_type", 2);
            if (this.iMi.iLr && this.iMi.iLs) {
                this.iLV = e.gSz + "microMsg." + System.currentTimeMillis() + ".mp4";
                intent.putExtra("record_video_force_sys_camera", true);
                intent.putExtra("record_video_quality", 1);
                intent.putExtra("record_video_time_limit", this.iMi.iLR);
                intent.putExtra("video_full_path", this.iLV);
                k.c(SD(), 1, 7, intent);
            } else if (this.iMi.iLr) {
                this.iLV = e.gSz + "microMsg." + System.currentTimeMillis() + ".mp4";
                k.a(SD(), this.iLV, 5, this.iMi.iLR, 1, false);
            } else if (this.iMi.iLs) {
                intent.putExtra("show_header_view", false);
                k.c(SD(), 1, 7, intent);
            } else {
                this.iMh.aMA = -2;
                a(this.iMh);
            }
        }

        protected final void SF() {
            super.SF();
            if (this.iLz != null) {
                this.iLz.dismiss();
                this.iLz = null;
            }
        }

        private void SU() {
            this.iLA = new OnCancelListener(this) {
                final /* synthetic */ a iMj;

                {
                    this.iMj = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.iMj.iMh.aMA = 0;
                    this.iMj.a(this.iMj.iMh);
                }
            };
            Context SD = SD();
            ab.getResources().getString(R.l.dIO);
            this.iLz = g.a(SD, ab.getResources().getString(R.l.fmk), true, this.iLA);
        }

        public final void a(int i, int i2, Intent intent) {
            if (i2 == 0) {
                this.iMh.aMA = 0;
                a(this.iMh);
            } else if (-1 != i2) {
                this.iMh.aMA = -2;
                a(this.iMh);
            } else {
                switch (i) {
                    case 4:
                        List stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                        if (!bg.bV(stringArrayListExtra)) {
                            final String str = (String) stringArrayListExtra.get(0);
                            final boolean booleanExtra = intent.getBooleanExtra("key_selected_video_is_from_sys_camera", false);
                            SU();
                            d.vL().D(new Runnable(this) {
                                final /* synthetic */ a iMj;

                                public final void run() {
                                    this.iMj.iMh.aMA = -1;
                                    this.iMj.iMh.iMg = this.iMj.J(str, booleanExtra);
                                    this.iMj.a(this.iMj.iMh);
                                }
                            });
                            return;
                        }
                        break;
                    case 5:
                        if (!bg.mA(this.iLV)) {
                            SU();
                            d.vL().D(new Runnable(this) {
                                final /* synthetic */ a iMj;

                                {
                                    this.iMj = r1;
                                }

                                public final void run() {
                                    if (new File(this.iMj.iLV).exists()) {
                                        this.iMj.iMh.aMA = -1;
                                        this.iMj.iMh.iMg = this.iMj.J(this.iMj.iLV, true);
                                        this.iMj.a(this.iMj.iMh);
                                        return;
                                    }
                                    this.iMj.iMh.aMA = -2;
                                    this.iMj.a(this.iMj.iMh);
                                }
                            });
                            return;
                        }
                        break;
                }
                this.iMh.aMA = -2;
                a(this.iMh);
            }
        }

        public final AppBrandLocalVideoObject J(String str, boolean z) {
            MediaMetadataRetriever mediaMetadataRetriever;
            if (z) {
                try {
                    boolean mD = c.mD(str);
                    w.i("MicroMsg.JsApiChooseVideo", "checkRemux, isMp4 = %b", new Object[]{Boolean.valueOf(mD)});
                    int i = -10000;
                    if (mD) {
                        i = SightVideoJNI.shouldRemuxing(str, 660, 500, 20971520, 300000.0d, Constants.MAX_BUFFER_SIZE);
                        w.i("MicroMsg.JsApiChooseVideo", "checkRemux, ret = %d", new Object[]{Integer.valueOf(i)});
                    }
                    if (i == -1 || !mD) {
                        w.i("MicroMsg.JsApiChooseVideo", "fileLength = %d", new Object[]{Integer.valueOf(com.tencent.mm.a.e.aN(str))});
                        i = com.tencent.mm.a.e.aN(str) > 20971520 ? -1 : 1;
                    }
                    switch (i) {
                        case -6:
                        case -5:
                        case -4:
                        case -3:
                        case -2:
                        case -1:
                            i = -50002;
                            break;
                        case 0:
                            i = -50006;
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            i = 1;
                            break;
                        default:
                            w.e("MicroMsg.JsApiChooseVideo", "unknown check type");
                            i = -50001;
                            break;
                    }
                    if (i == -50006) {
                        int[] iArr = new int[2];
                        j.b(str, iArr);
                        int i2 = iArr[0];
                        int i3 = iArr[1];
                        String str2 = e.gSz + "microMsg." + System.currentTimeMillis() + ".mp4";
                        i = SightVideoJNI.remuxing(str, str2, i2, i3, b.ptA, b.ptz, 8, 2, 25.0f, b.ptB, null, 0, b.pty);
                        w.i("MicroMsg.JsApiChooseVideo", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                        str = str2;
                    }
                } catch (Throwable e) {
                    w.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", new Object[]{bg.g(e)});
                }
            }
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
            } catch (Exception e2) {
                w.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[]{e2});
                mediaMetadataRetriever = null;
            }
            if (mediaMetadataRetriever == null) {
                w.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
                return null;
            }
            int i4 = bg.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            i2 = bg.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            i3 = bg.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
            AppBrandLocalVideoObject aE = com.tencent.mm.plugin.appbrand.appstorage.c.aE(this.iMi.appId, str);
            aE.duration = (i3 + 500) / 1000;
            aE.width = i4;
            aE.height = i2;
            aE.size = com.tencent.mm.a.e.aN(str);
            w.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", new Object[]{aE});
            return aE;
        }
    }

    JsApiChooseVideo() {
    }

    public final void a(final m mVar, final JSONObject jSONObject, final int i) {
        int i2 = 0;
        if (iMe) {
            mVar.x(i, d("cancel", null));
            return;
        }
        Context a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        ProcessRequest chooseRequest = new ChooseRequest();
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        w.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", new Object[]{optJSONArray, jSONObject.optString("maxDuration")});
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.iLr = true;
            chooseRequest.iLs = true;
        } else {
            chooseRequest.iLr = optJSONArray.toString().contains("camera");
            chooseRequest.iLs = optJSONArray.toString().contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
        }
        if (chooseRequest.iLr) {
            com.tencent.mm.plugin.appbrand.b.a(mVar.ivH, new android.support.v4.app.a.a(this) {
                final /* synthetic */ JsApiChooseVideo iMf;

                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    if (i == 115) {
                        if (iArr[0] == 0) {
                            this.iMf.a(mVar, jSONObject, i);
                        } else {
                            mVar.x(i, this.iMf.d("fail:system permission denied", null));
                        }
                    }
                }
            });
            Activity a2 = a(mVar);
            if (a2 == null) {
                mVar.x(i, d("fail", null));
            } else {
                i2 = com.tencent.mm.pluginsdk.i.a.a(a2, "android.permission.CAMERA", 115, "", "");
                if (i2 != 0) {
                    com.tencent.mm.plugin.appbrand.b.mX(mVar.ivH);
                }
            }
            if (i2 == 0) {
                return;
            }
        }
        iMe = true;
        com.tencent.mm.plugin.appbrand.e.a(mVar.ivH, new com.tencent.mm.plugin.appbrand.e.b(this) {
            final /* synthetic */ JsApiChooseVideo iMf;

            public final void onResume() {
                JsApiChooseVideo.iMe = false;
                com.tencent.mm.plugin.appbrand.e.b(mVar.ivH, this);
            }
        });
        chooseRequest.iLR = bg.getInt(r4, 60);
        chooseRequest.appId = mVar.ivH;
        com.tencent.mm.plugin.appbrand.ipc.a.b(a, chooseRequest, new AppBrandProxyUIProcessTask.b<ChooseResult>(this) {
            final /* synthetic */ JsApiChooseVideo iMf;

            public final /* synthetic */ void c(ProcessResult processResult) {
                ChooseResult chooseResult = (ChooseResult) processResult;
                if (chooseResult != null) {
                    switch (chooseResult.aMA) {
                        case -1:
                            AppBrandLocalVideoObject appBrandLocalVideoObject = chooseResult.iMg;
                            if (appBrandLocalVideoObject == null) {
                                w.e("MicroMsg.JsApiChooseVideo", "choose result code is OK but videoObj null");
                                break;
                            }
                            Map hashMap = new HashMap();
                            hashMap.put("tempFilePath", appBrandLocalVideoObject.fJz);
                            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(appBrandLocalVideoObject.duration));
                            hashMap.put("size", Integer.valueOf(appBrandLocalVideoObject.size));
                            hashMap.put("height", Integer.valueOf(appBrandLocalVideoObject.height));
                            hashMap.put("width", Integer.valueOf(appBrandLocalVideoObject.width));
                            mVar.x(i, this.iMf.d("ok", hashMap));
                            return;
                        case 0:
                            mVar.x(i, this.iMf.d("cancel", null));
                            return;
                    }
                }
                mVar.x(i, this.iMf.d("fail", null));
            }
        });
    }
}
