package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.webkit.ValueCallback;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import org.json.JSONObject;

public final class JsApiOpenDocument extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 99;
    private static final String NAME = "openDocument";
    private static long iSo = -1;

    private static final class OpenRequest extends ProcessRequest {
        public static final Creator<OpenRequest> CREATOR = new Creator<OpenRequest>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OpenRequest(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OpenRequest[i];
            }
        };
        public String filePath;
        public String iAS;

        protected final Class<? extends AppBrandProxyUIProcessTask> SI() {
            return a.class;
        }

        protected final String SH() {
            return "QbDocumentReader";
        }

        protected final void h(Parcel parcel) {
            super.h(parcel);
            this.filePath = parcel.readString();
            this.iAS = parcel.readString();
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.filePath);
            parcel.writeString(this.iAS);
        }

        OpenRequest() {
        }

        OpenRequest(Parcel parcel) {
            super(parcel);
        }
    }

    private static final class OpenResult extends ProcessResult {
        public static final Creator<OpenResult> CREATOR = new Creator<OpenResult>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OpenResult(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OpenResult[i];
            }
        };
        public int ret;

        protected final void h(Parcel parcel) {
            this.ret = parcel.readInt();
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.ret);
        }

        OpenResult() {
        }

        OpenResult(Parcel parcel) {
            super(parcel);
        }
    }

    private static final class a extends AppBrandProxyUIProcessTask {
        private static final int iSq = (a.class.hashCode() & 65535);

        private a() {
        }

        static /* synthetic */ boolean a(a aVar) {
            return aVar.iKm == null ? true : aVar.iKm.SE();
        }

        protected final void a(ProcessRequest processRequest) {
            String str = ((OpenRequest) processRequest).filePath;
            String str2 = ((OpenRequest) processRequest).iAS;
            int a = r.a(SD(), str, str2, Integer.toString(SD().hashCode()), new ValueCallback<String>(this) {
                final /* synthetic */ a iSr;

                {
                    this.iSr = r1;
                }

                public final /* synthetic */ void onReceiveValue(Object obj) {
                    w.i("MicroMsg.AppBrand.JsApiOpenDocument", "QB openReadFile, receiveValue = %s", new Object[]{(String) obj});
                    if ("fileReaderClosed".equals((String) obj) && !a.a(this.iSr)) {
                        this.iSr.a(null);
                    }
                }
            });
            w.i("MicroMsg.AppBrand.JsApiOpenDocument", "QB openReadFile, ret = %d", new Object[]{Integer.valueOf(a)});
            if (a == -102) {
                try {
                    Parcelable intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(str)), str2);
                    Intent intent2 = new Intent(SD(), AppChooserUI.class);
                    intent2.putExtra(Columns.TYPE, 0);
                    intent2.putExtra("title", SD().getResources().getString(R.l.dWa));
                    intent2.putExtra("mimetype", str2);
                    intent2.putExtra("targetintent", intent);
                    int i = iSq;
                    SD().uSV = this;
                    SD().startActivityForResult(intent2, i);
                    return;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.AppBrand.JsApiOpenDocument", e, " fallback to AppChooserUI ", new Object[0]);
                }
            }
            ProcessResult openResult = new OpenResult();
            openResult.ret = a;
            if (openResult.ret != 0) {
                a(openResult);
            } else if (this.iKm != null) {
                this.iKm.b(openResult);
            }
        }

        protected final void SF() {
            super.SF();
            SD().getWindow().setBackgroundDrawableResource(R.e.transparent);
        }

        public final void a(int i, int i2, Intent intent) {
            if (iSq == i) {
                ProcessResult openResult = new OpenResult();
                if (-1 == i2) {
                    openResult.ret = 0;
                } else {
                    openResult.ret = Integer.MAX_VALUE;
                }
                a(openResult);
                return;
            }
            a(null);
        }
    }

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        super.a(mVar, jSONObject, i);
        long Nz = bg.Nz();
        if (Nz - iSo < 1000) {
            mVar.x(i, d("fail:document viewer already starting", null));
            return;
        }
        iSo = Nz;
        Context a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH);
        if (bg.mA(optString)) {
            mVar.x(i, d("fail:invalid data", null));
            return;
        }
        AppBrandLocalMediaObject aH = c.aH(mVar.ivH, optString);
        if (aH == null) {
            mVar.x(i, d("fail:file doesn't exist", null));
            return;
        }
        ProcessRequest openRequest = new OpenRequest();
        openRequest.filePath = aH.hos;
        openRequest.iAS = s.MB(aH.mimeType);
        optString = jSONObject.optString("fileType");
        if (!bg.mA(optString)) {
            openRequest.iAS = optString;
        }
        com.tencent.mm.plugin.appbrand.ipc.a.b(a, openRequest, new b<OpenResult>(this) {
            final /* synthetic */ JsApiOpenDocument iSp;

            public final /* synthetic */ void c(ProcessResult processResult) {
                OpenResult openResult = (OpenResult) processResult;
                if (mVar.aaI) {
                    String str;
                    if (openResult != null) {
                        switch (openResult.ret) {
                            case 0:
                                str = "ok";
                                break;
                            case Integer.MAX_VALUE:
                                str = "fail user cancel";
                                break;
                            default:
                                str = "fail file type not supported " + openResult.ret;
                                break;
                        }
                    }
                    str = "fail env error";
                    mVar.x(i, this.iSp.d(str, null));
                }
            }
        });
    }
}
