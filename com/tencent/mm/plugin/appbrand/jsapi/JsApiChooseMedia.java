package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONStringer;

final class JsApiChooseMedia extends a {
    public static final int CTRL_INDEX = 193;
    public static final String NAME = "chooseMedia";
    public static volatile boolean iLK = false;

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
        int count;
        boolean iLM;
        boolean iLN;
        boolean iLO;
        boolean iLP;
        boolean iLQ;
        int iLR;
        boolean iLt;
        boolean iLu;

        protected final Class<? extends AppBrandProxyUIProcessTask> SI() {
            return a.class;
        }

        protected final String SH() {
            return "GalleryChooseMedia";
        }

        protected final void h(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.appId = parcel.readString();
            this.iLM = parcel.readByte() != (byte) 0;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.iLN = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.iLO = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.iLP = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.iLQ = z;
            this.iLR = parcel.readInt();
            this.count = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.iLt = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.iLu = z2;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            parcel.writeString(this.appId);
            parcel.writeByte(this.iLM ? (byte) 1 : (byte) 0);
            if (this.iLN) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.iLO) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.iLP) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.iLQ) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            parcel.writeInt(this.iLR);
            parcel.writeInt(this.count);
            if (this.iLt) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.iLu) {
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
        String iLS;
        String type;

        protected final void h(Parcel parcel) {
            this.aMA = parcel.readInt();
            this.type = parcel.readString();
            this.iLS = parcel.readString();
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.aMA);
            parcel.writeString(this.type);
            parcel.writeString(this.iLS);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            h(parcel);
        }
    }

    private static final class a extends AppBrandProxyUIProcessTask {
        private OnCancelListener iLA;
        public ChooseResult iLT = new ChooseResult();
        public ChooseRequest iLU;
        public String iLV;
        private String iLW;
        private l iLX;
        int iLy;
        private p iLz;

        private a() {
        }

        protected final void a(ProcessRequest processRequest) {
            this.iLU = (ChooseRequest) processRequest;
            this.iLy = (this.iLU.iLt & this.iLU.iLu) != 0 ? 8 : 7;
            if ((bg.en(SD()) > 200 ? 1 : 0) == 0) {
                w.e("MicroMsg.JsApiChooseMedia", "memory is not enough!");
                s.makeText(SD(), ab.getResources().getString(R.l.fmx), 1).show();
            }
            w.i("MicroMsg.JsApiChooseMedia", "goVideo");
            SD().uSV = this;
            if (this.iLU.iLM && this.iLU.iLN) {
                this.iLX = new l(SD());
                this.iLX.b(null, new OnCreateContextMenuListener(this) {
                    final /* synthetic */ a iLY;

                    {
                        this.iLY = r1;
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 1, 0, this.iLY.SD().getString(R.l.dHa));
                        contextMenu.add(0, 2, 1, this.iLY.SD().getString(R.l.dHe));
                    }
                }, new d(this) {
                    final /* synthetic */ a iLY;

                    {
                        this.iLY = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                this.iLY.SS();
                                return;
                            case 2:
                                this.iLY.ST();
                                return;
                            default:
                                return;
                        }
                    }
                });
                this.iLX.e(new OnCancelListener(this) {
                    final /* synthetic */ a iLY;

                    {
                        this.iLY = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        w.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
                        this.iLY.iLT.aMA = 0;
                        this.iLY.a(this.iLY.iLT);
                    }
                });
                this.iLX.blb();
            } else if (this.iLU.iLM) {
                ST();
            } else if (this.iLU.iLN) {
                SS();
            } else {
                this.iLT.aMA = -2;
                w.e("MicroMsg.JsApiChooseMedia", "parameter is invalid, fail and finish process");
                a(this.iLT);
            }
        }

        protected final void SF() {
            super.SF();
            if (this.iLz != null) {
                this.iLz.dismiss();
                this.iLz = null;
            }
            if (this.iLX != null) {
                this.iLX.dismiss();
                this.iLX = null;
            }
        }

        public final void SS() {
            int i;
            int i2;
            w.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
            if (this.iLU.iLP && this.iLU.iLO) {
                i = 0;
            } else if (this.iLU.iLP) {
                i = 1;
            } else if (this.iLU.iLO) {
                i = 2;
            } else {
                i = 0;
            }
            Intent intent = new Intent();
            String str = "KEY_SIGHT_PARAMS";
            String str2 = "microMsg_" + System.currentTimeMillis();
            this.iLV = e.gSz + "microMsg." + str2 + ".mp4";
            this.iLW = e.gSz + "microMsg." + str2 + ".jpeg";
            int i3 = this.iLU.iLR;
            Parcelable sightParams = new SightParams(3, 1);
            if (this.iLU.iLQ) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            sightParams.nAD = i2;
            sightParams.mode = i;
            if (sightParams.nAE == null) {
                sightParams.nAE = new VideoTransPara();
            }
            sightParams.nAE.duration = i3;
            sightParams.h(str2, this.iLV, this.iLW, e.gSz + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
            intent.putExtra(str, sightParams);
            k.a(SD(), 7, intent, 3, i);
        }

        public final void ST() {
            int i = 3;
            boolean z = true;
            w.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
            if (!(this.iLU.iLO && this.iLU.iLP)) {
                if (this.iLU.iLO) {
                    i = 1;
                } else if (this.iLU.iLP) {
                    i = 2;
                }
            }
            Intent intent = new Intent();
            intent.putExtra("key_can_select_video_and_pic", true);
            String str = "key_send_raw_image";
            if (this.iLU.iLt) {
                z = false;
            }
            intent.putExtra(str, z);
            k.a(SD(), 8, this.iLU.count, this.iLy, i, false, intent);
        }

        public final void a(int i, int i2, Intent intent) {
            if (i2 == 0) {
                w.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is canceled");
                this.iLT.aMA = 0;
                a(this.iLT);
            } else if (-1 != i2) {
                w.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is not RESULT_OK");
                this.iLT.aMA = -2;
                a(this.iLT);
            } else {
                boolean booleanExtra;
                boolean z;
                switch (i) {
                    case 7:
                        w.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                        if (intent == null) {
                            w.e("MicroMsg.JsApiChooseMedia", "data is null!");
                            break;
                        }
                        w.i("MicroMsg.JsApiChooseMedia", "data is valid!");
                        SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                        if (sightCaptureResult == null) {
                            w.e("MicroMsg.JsApiChooseMedia", "sight capture result is null!");
                            this.iLT.aMA = -2;
                            a(this.iLT);
                            return;
                        } else if (sightCaptureResult.nAu) {
                            final String str = sightCaptureResult.nAC;
                            if (bg.mA(str)) {
                                w.e("MicroMsg.JsApiChooseMedia", "picture_picturePath file is not exist! path:%s", new Object[]{str});
                                this.iLT.aMA = -2;
                                a(this.iLT);
                                return;
                            }
                            booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                            if (((!this.iLU.iLu ? 1 : 0) & this.iLU.iLt) == 0 && ((this.iLU.iLt & this.iLU.iLu) & booleanExtra) == 0) {
                                z = false;
                            } else {
                                z = true;
                            }
                            w.d("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[]{Boolean.valueOf(true), Boolean.valueOf(this.iLU.iLt), Boolean.valueOf(this.iLU.iLu), Boolean.valueOf(booleanExtra), Boolean.valueOf(z)});
                            if (z) {
                                SU();
                            }
                            com.tencent.mm.plugin.appbrand.m.d.vL().D(new Runnable(this) {
                                final /* synthetic */ a iLY;

                                public final void run() {
                                    String pg = z ? a.pg(str) : str;
                                    final ArrayList arrayList = new ArrayList();
                                    final ArrayList arrayList2 = new ArrayList();
                                    AppBrandLocalMediaObject c = c.c(this.iLY.iLU.appId, pg, z | 1);
                                    if (c != null) {
                                        arrayList.add(Long.valueOf(c.ilG));
                                        arrayList2.add(c.fJz);
                                        af.v(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass6 iMd;

                                            public final void run() {
                                                w.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                                                this.iMd.iLY.iLT.aMA = -1;
                                                this.iMd.iLY.iLT.type = SlookAirButtonRecentMediaAdapter.IMAGE_TYPE;
                                                this.iMd.iLY.iLT.iLS = a.b(arrayList2, arrayList);
                                                this.iMd.iLY.a(this.iMd.iLY.iLT);
                                            }
                                        });
                                        return;
                                    }
                                    w.e("MicroMsg.JsApiChooseMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[]{str});
                                    this.iLY.iLT.aMA = -2;
                                    this.iLY.a(this.iLY.iLT);
                                }
                            });
                            return;
                        } else {
                            this.iLV = sightCaptureResult.nAw;
                            if (bg.mA(this.iLV)) {
                                w.e("MicroMsg.JsApiChooseMedia", "mVideoFilePath is null");
                                break;
                            }
                            w.i("MicroMsg.JsApiChooseMedia", "mVideoFilePath:%s", new Object[]{this.iLV});
                            if (!pj(this.iLW) && pj(sightCaptureResult.nAx)) {
                                this.iLW = sightCaptureResult.nAx;
                            }
                            SU();
                            com.tencent.mm.plugin.appbrand.m.d.vL().D(new Runnable(this) {
                                final /* synthetic */ a iLY;

                                {
                                    this.iLY = r1;
                                }

                                public final void run() {
                                    if (new File(this.iLY.iLV).exists()) {
                                        w.i("MicroMsg.JsApiChooseMedia", "take media camera, the mVideoFilePath file exist, success");
                                        this.iLY.iLT.aMA = -1;
                                        this.iLY.iLT.type = SlookAirButtonRecentMediaAdapter.VIDEO_TYPE;
                                        AppBrandLocalVideoObject ph = this.iLY.ph(this.iLY.iLV);
                                        this.iLY.pi(this.iLY.iLV);
                                        String SV = this.iLY.SV();
                                        this.iLY.iLT.iLS = a.a(ph.fJz, SV, ph.duration, ph.height, ph.width, ph.size);
                                        this.iLY.a(this.iLY.iLT);
                                        return;
                                    }
                                    w.e("MicroMsg.JsApiChooseMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[]{this.iLY.iLV});
                                    this.iLY.iLT.aMA = -2;
                                    this.iLY.a(this.iLY.iLT);
                                }
                            });
                            return;
                        }
                    case 8:
                        w.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
                        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                            final List stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                            if (stringArrayListExtra2 == null || stringArrayListExtra2.size() == 0) {
                                w.e("MicroMsg.JsApiChooseMedia", "chosen is null,  fail");
                                this.iLT.aMA = -2;
                                a(this.iLT);
                                return;
                            }
                            booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                            if (((!this.iLU.iLu ? 1 : 0) & this.iLU.iLt) == 0 && ((this.iLU.iLt & this.iLU.iLu) & booleanExtra) == 0) {
                                z = false;
                            } else {
                                z = true;
                            }
                            w.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[]{Boolean.valueOf(false), Boolean.valueOf(this.iLU.iLt), Boolean.valueOf(this.iLU.iLu), Boolean.valueOf(booleanExtra), Boolean.valueOf(z)});
                            if (z) {
                                SU();
                            }
                            com.tencent.mm.plugin.appbrand.m.d.vL().D(new Runnable(this) {
                                final /* synthetic */ a iLY;

                                public final void run() {
                                    final ArrayList arrayList = new ArrayList(stringArrayListExtra2.size());
                                    final ArrayList arrayList2 = new ArrayList(stringArrayListExtra2.size());
                                    for (String str : stringArrayListExtra2) {
                                        String str2;
                                        if (z) {
                                            str2 = a.pg(str2);
                                        }
                                        AppBrandLocalMediaObject c = c.c(this.iLY.iLU.appId, str2, z | 0);
                                        if (c != null) {
                                            arrayList.add(Long.valueOf(c.ilG));
                                            arrayList2.add(c.fJz);
                                        } else {
                                            w.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", new Object[]{str2});
                                        }
                                    }
                                    if (arrayList2.size() == 0) {
                                        w.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                                        this.iLY.iLT.aMA = -2;
                                        this.iLY.a(this.iLY.iLT);
                                        return;
                                    }
                                    af.v(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass5 iMb;

                                        public final void run() {
                                            w.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                                            this.iMb.iLY.iLT.aMA = -1;
                                            this.iMb.iLY.iLT.type = SlookAirButtonRecentMediaAdapter.IMAGE_TYPE;
                                            this.iMb.iLY.iLT.iLS = a.b(arrayList2, arrayList);
                                            this.iMb.iLY.a(this.iMb.iLY.iLT);
                                        }
                                    });
                                }
                            });
                            return;
                        }
                        this.iLV = (String) stringArrayListExtra.get(0);
                        if (bg.mA(this.iLV)) {
                            w.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is  null, fail");
                            break;
                        }
                        SU();
                        com.tencent.mm.plugin.appbrand.m.d.vL().D(new Runnable(this) {
                            final /* synthetic */ a iLY;

                            {
                                this.iLY = r1;
                            }

                            public final void run() {
                                if (new File(this.iLY.iLV).exists()) {
                                    w.i("MicroMsg.JsApiChooseMedia", "take media local, the mVideoFilePath file exist, success");
                                    this.iLY.iLT.aMA = -1;
                                    this.iLY.iLT.type = SlookAirButtonRecentMediaAdapter.VIDEO_TYPE;
                                    AppBrandLocalVideoObject ph = this.iLY.ph(this.iLY.iLV);
                                    this.iLY.pi(this.iLY.iLV);
                                    String SV = this.iLY.SV();
                                    this.iLY.iLT.iLS = a.a(ph.fJz, SV, ph.duration, ph.height, ph.width, ph.size);
                                    this.iLY.a(this.iLY.iLT);
                                    return;
                                }
                                w.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is %s, the file not exist, fail", new Object[]{this.iLY.iLV});
                                this.iLY.iLT.aMA = -2;
                                this.iLY.a(this.iLY.iLT);
                            }
                        });
                        return;
                }
                this.iLT.aMA = -2;
                a(this.iLT);
            }
        }

        private void SU() {
            this.iLA = new OnCancelListener(this) {
                final /* synthetic */ a iLY;

                {
                    this.iLY = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    w.e("MicroMsg.JsApiChooseMedia", "cancel show the progress dialog and finish progress");
                    this.iLY.iLT.aMA = 0;
                    this.iLY.a(this.iLY.iLT);
                }
            };
            Context SD = SD();
            ab.getResources().getString(R.l.dIO);
            this.iLz = g.a(SD, ab.getResources().getString(R.l.fmk), true, this.iLA);
        }

        public static String pg(String str) {
            String str2 = e.gSz + "microMsg." + System.currentTimeMillis() + ".jpg";
            try {
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, 0);
                if (decodeFile == null) {
                    w.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp return null");
                    return null;
                }
                long Nz = bg.Nz();
                w.i("MicroMsg.JsApiChooseMedia", "doCompressImage, ret = %d, cost = %d, %s (%d) -> %s (%d)", new Object[]{Integer.valueOf(n.a(decodeFile, 70, str2)), Long.valueOf(bg.Nz() - Nz), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length())});
                return n.a(decodeFile, 70, str2) == 1 ? str2 : str;
            } catch (OutOfMemoryError e) {
                w.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp oom");
                return null;
            }
        }

        public final AppBrandLocalVideoObject ph(String str) {
            MediaMetadataRetriever mediaMetadataRetriever;
            try {
                boolean mD = com.tencent.mm.plugin.a.c.mD(str);
                w.i("MicroMsg.JsApiChooseMedia", "checkRemux, isMp4 = %b", new Object[]{Boolean.valueOf(mD)});
                int i = -10000;
                if (mD) {
                    i = SightVideoJNI.shouldRemuxing(str, 660, 500, 20971520, 300000.0d, Constants.MAX_BUFFER_SIZE);
                    w.i("MicroMsg.JsApiChooseMedia", "checkRemux, ret = %d", new Object[]{Integer.valueOf(i)});
                }
                if (i == -1 || !mD) {
                    w.i("MicroMsg.JsApiChooseMedia", "fileLength = %d", new Object[]{Integer.valueOf(com.tencent.mm.a.e.aN(str))});
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
                        w.e("MicroMsg.JsApiChooseMedia", "unknown check type");
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
                    w.i("MicroMsg.JsApiChooseMedia", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                    str = str2;
                }
            } catch (Throwable e) {
                w.e("MicroMsg.JsApiChooseMedia", "addVideoItem, remux failed, exp = %s", new Object[]{bg.g(e)});
            }
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
            } catch (Exception e2) {
                w.e("MicroMsg.JsApiChooseMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[]{e2});
                mediaMetadataRetriever = null;
            }
            if (mediaMetadataRetriever == null) {
                w.e("MicroMsg.JsApiChooseMedia", "addVideoItem, null meta data");
                return null;
            }
            int i4 = bg.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            i2 = bg.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            i3 = bg.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
            AppBrandLocalVideoObject aE = c.aE(this.iLU.appId, str);
            aE.duration = (i3 + 500) / 1000;
            aE.width = i4;
            aE.height = i2;
            aE.size = com.tencent.mm.a.e.aN(str);
            w.i("MicroMsg.JsApiChooseMedia", "addVideoItem, return %s", new Object[]{aE});
            return aE;
        }

        public final String SV() {
            if (TextUtils.isEmpty(this.iLW)) {
                return "";
            }
            AppBrandLocalMediaObject c = c.c(this.iLU.appId, this.iLW, true);
            if (c.fJz != null) {
                return c.fJz;
            }
            w.e("MicroMsg.JsApiChooseMedia", "addThumbItem error, localId is null");
            return "";
        }

        public final void pi(String str) {
            File file;
            String str2 = null;
            if (TextUtils.isEmpty(this.iLW)) {
                w.e("MicroMsg.JsApiChooseMedia", "mThumbFilePath is empty!");
                file = null;
            } else {
                file = new File(this.iLW);
            }
            if (file == null || !file.exists()) {
                w.e("MicroMsg.JsApiChooseMedia", "file == null or file not exist for path:%s!", new Object[]{this.iLW});
                String name = new File(str).getName();
                if (!TextUtils.isEmpty(name) && name.contains(".")) {
                    str2 = name.substring(0, name.lastIndexOf("."));
                }
                if (TextUtils.isEmpty(str2)) {
                    this.iLW = e.gSz + ("microMsg_" + System.currentTimeMillis()) + ".jpeg";
                } else if (e.gSz == null || !e.gSz.endsWith("/")) {
                    this.iLW = e.gSz + "/" + str2 + ".jpeg";
                } else {
                    this.iLW = e.gSz + str2 + ".jpeg";
                }
                if (new File(this.iLW).exists()) {
                    w.i("MicroMsg.JsApiChooseMedia", "file is exist for path:%s!", new Object[]{this.iLW});
                    return;
                }
                w.i("MicroMsg.JsApiChooseMedia", "file not exist for path:%s!", new Object[]{this.iLW});
                w.i("MicroMsg.JsApiChooseMedia", "create new thumb path:%s!", new Object[]{this.iLW});
                Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
                if (createVideoThumbnail == null) {
                    w.e("MicroMsg.JsApiChooseMedia", "createVideoThumbnail bitmap fail for path:%s!", new Object[]{this.iLW});
                    return;
                }
                try {
                    com.tencent.mm.sdk.platformtools.d.a(ThumbnailUtils.extractThumbnail(createVideoThumbnail, 690, 400, 2), 30, CompressFormat.JPEG, this.iLW, true);
                    return;
                } catch (IOException e) {
                    w.e("MicroMsg.JsApiChooseMedia", "saveBitmapToImage exist IOException:" + e.getMessage());
                    return;
                }
            }
            w.i("MicroMsg.JsApiChooseMedia", "file is exist!, path:%s", new Object[]{this.iLW});
        }

        private static boolean pj(String str) {
            if (TextUtils.isEmpty(str)) {
                w.e("MicroMsg.JsApiChooseMedia", "video thumb file path is null");
                return false;
            }
            File file = new File(str);
            w.i("MicroMsg.JsApiChooseMedia", "thumbFilePath:%s", new Object[]{str});
            if (file.exists()) {
                w.i("MicroMsg.JsApiChooseMedia", "video thumb file is exist");
                return true;
            }
            w.e("MicroMsg.JsApiChooseMedia", "video thumb file is not exist");
            return false;
        }

        public static String b(ArrayList<String> arrayList, ArrayList<Long> arrayList2) {
            if (arrayList == null || arrayList.size() == 0) {
                w.e("MicroMsg.JsApiChooseMedia", "parseImageItemToJson localIds is null");
                return "";
            }
            w.i("MicroMsg.JsApiChooseMedia", "parseImageItemToJson()");
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.array();
                for (int i = 0; i < arrayList.size(); i++) {
                    jSONStringer.object();
                    String str = (String) arrayList.get(i);
                    Long l = (Long) arrayList2.get(i);
                    jSONStringer.key("tempFilePath");
                    jSONStringer.value(str);
                    jSONStringer.key("size");
                    jSONStringer.value(String.valueOf(l.longValue()));
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                return jSONStringer.toString();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.JsApiChooseMedia", e, "", new Object[0]);
                return "";
            }
        }

        public static String a(String str, String str2, int i, int i2, int i3, int i4) {
            if (bg.mA(str)) {
                w.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
                return "";
            }
            w.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.array();
                jSONStringer.object();
                jSONStringer.key("tempFilePath");
                jSONStringer.value(str);
                jSONStringer.key("thumbTempFilePath");
                jSONStringer.value(str2);
                jSONStringer.key(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                jSONStringer.value(String.valueOf(i));
                jSONStringer.key("height");
                jSONStringer.value(String.valueOf(i2));
                jSONStringer.key("width");
                jSONStringer.value(String.valueOf(i3));
                jSONStringer.key("size");
                jSONStringer.value(String.valueOf(i4));
                jSONStringer.endObject();
                jSONStringer.endArray();
                return jSONStringer.toString();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.JsApiChooseMedia", e, "", new Object[0]);
                return "";
            }
        }
    }

    JsApiChooseMedia() {
    }

    public final void a(final m mVar, final JSONObject jSONObject, final int i) {
        if (iLK) {
            w.e("MicroMsg.JsApiChooseMedia", "chooseMedia sChoosingMedia is true, do not again");
            mVar.x(i, d("cancel", null));
            return;
        }
        Context a = a(mVar);
        if (a == null) {
            w.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  pageContext is null");
            mVar.x(i, d("fail:page context is null", null));
        } else if (jSONObject == null) {
            w.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  data is null");
            mVar.x(i, d("fail:data is null", null));
        } else {
            boolean z;
            w.i("MicroMsg.JsApiChooseMedia", "chooseMedia data:" + jSONObject.toString());
            String str = "";
            if (jSONObject.optJSONArray("sourceType") == null || jSONObject.optJSONArray("sourceType").length() <= 0) {
                w.e("MicroMsg.JsApiChooseMedia", "sourceType is invalid param");
            } else {
                str = jSONObject.optJSONArray("sourceType").toString();
            }
            if (bg.mA(str)) {
                str = "camera|album";
            }
            String str2 = "";
            if (jSONObject.optJSONArray("mediaType") == null || jSONObject.optJSONArray("mediaType").length() <= 0) {
                w.e("MicroMsg.JsApiChooseMedia", "mediaType is invalid param");
            } else {
                str2 = jSONObject.optJSONArray("mediaType").toString();
            }
            if (bg.mA(str2)) {
                str2 = "video|image";
            }
            int min = Math.min(jSONObject.optInt("maxDuration", 10), 10);
            if (min < 3 || min > 10) {
                w.e("MicroMsg.JsApiChooseMedia", "maxDuration is invalid");
                min = 10;
            }
            String optString = jSONObject.optString("camera");
            if (bg.mA(optString)) {
                optString = "back";
            }
            int min2 = Math.min(jSONObject.optInt("count", 9), 9);
            String str3 = "";
            if (jSONObject.optJSONArray("sizeType") == null || jSONObject.optJSONArray("sizeType").length() <= 0) {
                w.e("MicroMsg.JsApiChooseMedia", "sizeType is invalid param");
            } else {
                str3 = jSONObject.optJSONArray("sizeType").toString();
            }
            if (bg.mA(str3)) {
                str3 = "original|compressed";
            }
            w.i("MicroMsg.JsApiChooseMedia", "chooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[]{str, str2, Integer.valueOf(min), optString, Integer.valueOf(min2), str3});
            com.tencent.mm.plugin.appbrand.b.a(mVar.ivH, new android.support.v4.app.a.a(this) {
                final /* synthetic */ JsApiChooseMedia iLL;

                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    if (i != 120) {
                        w.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission requestCode is not for choose media");
                    } else if (iArr[0] == 0) {
                        w.i("MicroMsg.JsApiChooseMedia", "requestAudioPermission permission is grant for choose media");
                        this.iLL.a(mVar, jSONObject, i);
                    } else {
                        w.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission sys perm denied for choose media");
                        mVar.x(i, this.iLL.d("fail:system permission denied", null));
                    }
                }
            });
            Activity a2 = a(mVar);
            if (a2 == null) {
                w.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestAudioPermission pageContext is null");
                mVar.x(i, d("fail", null));
                z = false;
            } else {
                z = com.tencent.mm.pluginsdk.i.a.a(a2, "android.permission.RECORD_AUDIO", 120, "", "");
                if (z) {
                    com.tencent.mm.plugin.appbrand.b.mX(mVar.ivH);
                }
            }
            if (z) {
                com.tencent.mm.plugin.appbrand.b.a(mVar.ivH, new android.support.v4.app.a.a(this) {
                    final /* synthetic */ JsApiChooseMedia iLL;

                    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                        if (i != 119) {
                            w.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission requestCode is not for choose media");
                        } else if (iArr[0] == 0) {
                            w.i("MicroMsg.JsApiChooseMedia", "requestCameraPermission permission is grant for choose media");
                            this.iLL.a(mVar, jSONObject, i);
                        } else {
                            w.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission sys perm denied for choose media");
                            mVar.x(i, this.iLL.d("fail:system permission denied", null));
                        }
                    }
                });
                a2 = a(mVar);
                if (a2 == null) {
                    w.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestCameraPermission pageContext is null");
                    mVar.x(i, d("fail", null));
                    z = false;
                } else {
                    z = com.tencent.mm.pluginsdk.i.a.a(a2, "android.permission.CAMERA", 119, "", "");
                    if (z) {
                        com.tencent.mm.plugin.appbrand.b.mX(mVar.ivH);
                    }
                }
                if (z) {
                    w.i("MicroMsg.JsApiChooseMedia", "do chooseMedia");
                    iLK = true;
                    com.tencent.mm.plugin.appbrand.e.a(mVar.ivH, new com.tencent.mm.plugin.appbrand.e.b(this) {
                        final /* synthetic */ JsApiChooseMedia iLL;

                        public final void onResume() {
                            w.i("MicroMsg.JsApiChooseMedia", "chooseMedia, onResume, remove listener");
                            JsApiChooseMedia.iLK = false;
                            com.tencent.mm.plugin.appbrand.e.b(mVar.ivH, this);
                        }
                    });
                    ProcessRequest chooseRequest = new ChooseRequest();
                    chooseRequest.appId = mVar.ivH;
                    chooseRequest.iLM = str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                    chooseRequest.iLN = str.contains("camera");
                    chooseRequest.iLO = str2.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE);
                    chooseRequest.iLP = str2.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE);
                    if (optString.contains("back") || !optString.contains("front")) {
                        chooseRequest.iLQ = false;
                    } else {
                        chooseRequest.iLQ = true;
                    }
                    chooseRequest.iLR = min;
                    chooseRequest.count = min2;
                    chooseRequest.iLt = str3.contains("compressed");
                    chooseRequest.iLu = str3.contains("original");
                    com.tencent.mm.plugin.appbrand.ipc.a.a(a, chooseRequest, new AppBrandProxyUIProcessTask.b<ChooseResult>(this) {
                        final /* synthetic */ JsApiChooseMedia iLL;

                        public final /* synthetic */ void c(ProcessResult processResult) {
                            ChooseResult chooseResult = (ChooseResult) processResult;
                            JsApiChooseMedia.iLK = false;
                            if (chooseResult == null) {
                                w.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult result is null");
                                mVar.x(i, this.iLL.d("fail", null));
                                return;
                            }
                            switch (chooseResult.aMA) {
                                case -1:
                                    String str = chooseResult.type;
                                    String str2 = chooseResult.iLS;
                                    if (bg.mA(str2)) {
                                        w.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult localIds is null");
                                        mVar.x(i, this.iLL.d("fail", null));
                                        return;
                                    }
                                    Map hashMap = new HashMap();
                                    hashMap.put(Columns.TYPE, str);
                                    hashMap.put("tempFiles", str2);
                                    w.i("MicroMsg.JsApiChooseMedia", "chooseMedia ok, type:%s, localIds:%s", new Object[]{str, str2});
                                    mVar.x(i, this.iLL.d("ok", hashMap));
                                    return;
                                case 0:
                                    w.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult user cancel");
                                    mVar.x(i, this.iLL.d("fail:cancel", null));
                                    return;
                                default:
                                    w.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult");
                                    mVar.x(i, this.iLL.d("fail", null));
                                    return;
                            }
                        }
                    });
                    return;
                }
                w.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestCameraPermission is fail");
                return;
            }
            w.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestAudioPermission is fail");
        }
    }
}
