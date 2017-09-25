package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.c.d.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiUploadEncryptedFileToCDN extends a {
    public static final int CTRL_INDEX = 194;
    public static final String NAME = "uploadEncryptedFileToCDN";

    public static class JsApiUploadEncryptedMediaFileTask extends MainProcessTask {
        public static final Creator<JsApiUploadEncryptedMediaFileTask> CREATOR = new Creator<JsApiUploadEncryptedMediaFileTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new JsApiUploadEncryptedMediaFileTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new JsApiUploadEncryptedMediaFileTask[i];
            }
        };
        public String appId;
        public String fJz;
        public String fOx;
        public String fileUrl;
        public String hhE;
        public Runnable iMD;
        m iMG;
        public boolean iQn;
        public int iQo = 0;
        public int iQp = 0;
        public int iQq = 0;
        MMActivity iQr;
        com.tencent.mm.plugin.appbrand.c.d.a iQs;
        b iQt;
        public ProgressDialog isv = null;
        public int iyQ;
        public String mimeType;

        public JsApiUploadEncryptedMediaFileTask(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", new Object[]{Integer.valueOf(this.iQp), Integer.valueOf(this.iQq)});
            if (this.iQp == 1) {
                w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
                c.Qc().a(this.iQs);
                c.Qc().a(this.iQt);
                c.Qc();
                com.tencent.mm.plugin.appbrand.c.b.nW(this.fJz);
                this.iQp = 0;
                this.iQq = 1;
                SL();
                return;
            }
            final AppBrandLocalMediaObject aH = com.tencent.mm.plugin.appbrand.appstorage.c.aH(this.appId, this.fJz);
            if (aH == null) {
                w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
                this.iQq = 1;
                SL();
                return;
            }
            boolean z;
            com.tencent.mm.plugin.appbrand.c.a aVar = new com.tencent.mm.plugin.appbrand.c.a();
            aVar.fJz = aH.fJz;
            aVar.iDA = aH.hos;
            aVar.ilG = aH.ilG;
            String str = this.fJz;
            aVar.mediaId = d.a("appbrandmediafile", bg.Nz(), str, str);
            c.Qb().a(aVar);
            this.iQs = new com.tencent.mm.plugin.appbrand.c.d.a(this) {
                final /* synthetic */ JsApiUploadEncryptedMediaFileTask iQu;

                {
                    this.iQu = r1;
                }

                public final void v(int i, String str) {
                    w.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", new Object[]{Integer.valueOf(i), str});
                    this.iQu.iQo = i;
                    this.iQu.iQq = 3;
                    this.iQu.SL();
                }
            };
            this.iQt = new b(this) {
                final /* synthetic */ JsApiUploadEncryptedMediaFileTask iQu;

                public final void b(boolean z, String str, String str2, String str3) {
                    w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
                    if (!bg.mA(str) && str.equals(aH.fJz)) {
                        c.Qc().a(this.iQu.iQs);
                        c.Qc().a(this.iQu.iQt);
                        c.Qc();
                        com.tencent.mm.plugin.appbrand.c.b.nW(aH.fJz);
                        if (z) {
                            this.iQu.fOx = str2;
                            w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
                        } else {
                            w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
                        }
                        com.tencent.mm.plugin.appbrand.c.c Qb = c.Qb();
                        String str4 = this.iQu.fOx;
                        if (!bg.mA(str4)) {
                            for (com.tencent.mm.plugin.appbrand.c.a aVar : Qb.iDL.values()) {
                                if (bg.mz(aVar.iDB).equals(str4)) {
                                    break;
                                }
                            }
                        }
                        w.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByServerId error, media id is null or nil");
                        com.tencent.mm.plugin.appbrand.c.a aVar2 = null;
                        if (aVar2 == null || aVar2.iDC == null) {
                            w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
                        } else {
                            w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
                            this.iQu.hhE = aVar2.iDC.field_aesKey;
                            this.iQu.fOx = aVar2.iDC.field_fileId;
                            this.iQu.fileUrl = aVar2.iDC.field_fileUrl;
                            this.iQu.iyQ = aVar2.iDC.field_fileLength;
                            w.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", new Object[]{this.iQu.hhE, Integer.valueOf(this.iQu.iyQ)});
                        }
                        this.iQu.iQq = 1;
                        this.iQu.SL();
                    }
                }
            };
            com.tencent.mm.plugin.appbrand.c.b Qc = c.Qc();
            com.tencent.mm.plugin.appbrand.c.d.a aVar2 = this.iQs;
            if (!(Qc.iDH == null || aVar2 == null || Qc.iDH.contains(aVar2))) {
                Qc.iDH.add(aVar2);
            }
            Qc = c.Qc();
            str = this.appId;
            String str2 = aH.fJz;
            int i = com.tencent.mm.modelcdntran.b.hxO;
            b bVar = this.iQt;
            com.tencent.mm.plugin.appbrand.c.a nY = c.Qb().nY(str2);
            if (nY == null) {
                w.e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str2});
                z = false;
            } else {
                nY.appId = str;
                if (!(bVar == null || Qc.iDG == null || bVar == null || Qc.iDG.contains(bVar))) {
                    Qc.iDG.add(bVar);
                }
                nY.iDD = true;
                h hVar = new h();
                hVar.hze = Qc.hGH;
                hVar.fZK = true;
                hVar.field_mediaId = nY.mediaId;
                hVar.field_fullpath = nY.iDA;
                hVar.field_fileType = i;
                hVar.field_talker = "weixin";
                hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
                if (i == com.tencent.mm.modelcdntran.b.hxO) {
                    hVar.field_needStorage = true;
                } else {
                    hVar.field_needStorage = false;
                }
                hVar.field_isStreamMedia = false;
                hVar.field_appType = 0;
                hVar.field_bzScene = 0;
                hVar.field_force_aeskeycdn = true;
                hVar.field_trysafecdn = false;
                z = g.El().b(hVar);
                w.i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[]{Boolean.valueOf(z), Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn), str2});
            }
            w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", new Object[]{Boolean.valueOf(z)});
            if (!z) {
                w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
                this.iQq = 1;
                c.Qc().a(this.iQs);
                c.Qc().a(this.iQt);
                c.Qc();
                com.tencent.mm.plugin.appbrand.c.b.nW(aH.fJz);
                SL();
            } else if (this.iQn) {
                w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
                this.iQq = 2;
                SL();
            }
        }

        public final void SK() {
            if (this.iQq == 0) {
                w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
            } else if (this.iQq == 1) {
                w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
                if (this.isv != null) {
                    this.isv.dismiss();
                    this.isv = null;
                }
                if (this.iMD != null) {
                    this.iMD.run();
                }
            } else if (this.iQq == 2) {
                w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
                Context context = this.iQr;
                this.iQr.getString(R.l.dIO);
                this.isv = com.tencent.mm.ui.base.g.a(context, this.iQr.getString(R.l.fnX), true, new OnCancelListener(this) {
                    final /* synthetic */ JsApiUploadEncryptedMediaFileTask iQu;

                    {
                        this.iQu = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel uploading the media file");
                        dialogInterface.dismiss();
                        this.iQu.iQp = 1;
                        this.iQu.iQq = 1;
                        AppBrandMainProcessService.a(this.iQu);
                    }
                });
                this.isv.setOnKeyListener(new OnKeyListener(this) {
                    final /* synthetic */ JsApiUploadEncryptedMediaFileTask iQu;

                    {
                        this.iQu = r1;
                    }

                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i != 4 || keyEvent.getAction() != 1) {
                            return false;
                        }
                        Object string;
                        if (TextUtils.isEmpty(this.iQu.mimeType) || !this.iQu.mimeType.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                            String string2 = this.iQu.iQr.getString(R.l.fmn);
                        } else {
                            string = this.iQu.iQr.getString(R.l.fmu);
                        }
                        com.tencent.mm.ui.base.g.a(this.iQu.iQr, true, this.iQu.iQr.getString(R.l.fmo, new Object[]{string}), "", this.iQu.iQr.getString(R.l.fmr), this.iQu.iQr.getString(R.l.fms), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass4 iQw;

                            {
                                this.iQw = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
                                this.iQw.iQu.isv.cancel();
                                this.iQw.iQu.iQp = 1;
                                this.iQw.iQu.iQq = 1;
                                AppBrandMainProcessService.a(this.iQw.iQu);
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass4 iQw;

                            {
                                this.iQw = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "user continue upload media file");
                            }
                        });
                        return true;
                    }
                });
            } else if (this.iQq == 3) {
                w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
                Map hashMap = new HashMap();
                hashMap.put("tempFilePath", this.fJz);
                hashMap.put("percent", Integer.valueOf(this.iQo));
                String jSONObject = new JSONObject(hashMap).toString();
                e a = new a().a(this.iMG);
                a.mData = jSONObject;
                a.SR();
            }
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.appId = parcel.readString();
            this.fJz = parcel.readString();
            this.fOx = parcel.readString();
            this.hhE = parcel.readString();
            this.fileUrl = parcel.readString();
            this.iyQ = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.iQn = z;
            this.iQo = parcel.readInt();
            this.iQq = parcel.readInt();
            this.iQp = parcel.readInt();
            this.mimeType = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.fJz);
            parcel.writeString(this.fOx);
            parcel.writeString(this.hhE);
            parcel.writeString(this.fileUrl);
            parcel.writeInt(this.iyQ);
            parcel.writeInt(this.iQn ? 1 : 0);
            parcel.writeInt(this.iQo);
            parcel.writeInt(this.iQq);
            parcel.writeInt(this.iQp);
            parcel.writeString(this.mimeType);
        }
    }

    private static final class a extends e {
        private static final int CTRL_INDEX = 196;
        private static final String NAME = "onUploadEncryptedFileToCDNProgress";
    }

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        Context a = a(mVar);
        if (a == null) {
            w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
            mVar.x(i, d("fail", null));
        } else if (jSONObject == null) {
            w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
            mVar.x(i, d("fail:data is null", null));
        } else {
            String str = mVar.ivH;
            String optString = jSONObject.optString("tempFilePath");
            boolean optBoolean = jSONObject.optBoolean("isShowProgressTips", false);
            w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "JsApiUploadEncryptedFileToCDN appId:%s, data:%s", new Object[]{str, jSONObject.toString()});
            if (bg.mA(optString)) {
                w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath is null");
                mVar.x(i, d("fail:tempFilePath is null", null));
                return;
            }
            AppBrandLocalMediaObject aH = com.tencent.mm.plugin.appbrand.appstorage.c.aH(str, optString);
            if (aH == null) {
                w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
                mVar.x(i, d("fail:file doesn't exist", null));
            } else if (TextUtils.isEmpty(aH.hos)) {
                w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
                mVar.x(i, d("fail:fileFullPath is null", null));
            } else {
                final MainProcessTask jsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask();
                jsApiUploadEncryptedMediaFileTask.appId = str;
                jsApiUploadEncryptedMediaFileTask.fJz = optString;
                jsApiUploadEncryptedMediaFileTask.iQn = optBoolean;
                jsApiUploadEncryptedMediaFileTask.iQr = a;
                jsApiUploadEncryptedMediaFileTask.iMG = mVar;
                jsApiUploadEncryptedMediaFileTask.mimeType = aH.mimeType;
                jsApiUploadEncryptedMediaFileTask.iMD = new Runnable(this) {
                    final /* synthetic */ JsApiUploadEncryptedFileToCDN iQm;

                    public final void run() {
                        Map hashMap = new HashMap();
                        hashMap.put("fileId", jsApiUploadEncryptedMediaFileTask.fOx);
                        hashMap.put("aesKey", jsApiUploadEncryptedMediaFileTask.hhE);
                        hashMap.put("fileUrl", jsApiUploadEncryptedMediaFileTask.fileUrl);
                        hashMap.put("fileLength", jsApiUploadEncryptedMediaFileTask.iyQ);
                        w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", new Object[]{jsApiUploadEncryptedMediaFileTask.fOx});
                        if (bg.mA(jsApiUploadEncryptedMediaFileTask.fOx)) {
                            w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
                            mVar.x(i, this.iQm.d("fail", null));
                        } else {
                            w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
                            mVar.x(i, this.iQm.d("ok", hashMap));
                        }
                        jsApiUploadEncryptedMediaFileTask.SN();
                    }
                };
                if (aa.bn(a)) {
                    w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
                    jsApiUploadEncryptedMediaFileTask.SM();
                    AppBrandMainProcessService.a(jsApiUploadEncryptedMediaFileTask);
                    return;
                }
                w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
                if (TextUtils.isEmpty(aH.mimeType) || !aH.mimeType.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                    str = a.getString(R.l.fmn);
                } else {
                    str = a.getString(R.l.fmu);
                }
                optString = bg.ew((long) e.aN(aH.hos));
                com.tencent.mm.ui.base.g.a(a, a.getString(R.l.fmq, new Object[]{str, optString}), a.getString(R.l.dIO), new OnClickListener(this) {
                    final /* synthetic */ JsApiUploadEncryptedFileToCDN iQm;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "do confirm upload in 2G/3G/4G network");
                        jsApiUploadEncryptedMediaFileTask.SM();
                        AppBrandMainProcessService.a(jsApiUploadEncryptedMediaFileTask);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ JsApiUploadEncryptedFileToCDN iQm;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "do cancel upload in 2G/3G/4G network");
                        mVar.x(i, this.iQm.d("cancel", null));
                        jsApiUploadEncryptedMediaFileTask.SN();
                    }
                });
            }
        }
    }
}
