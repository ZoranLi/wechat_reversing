package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class JsApiChooseImage extends a {
    public static final int CTRL_INDEX = 29;
    public static final String NAME = "chooseImage";
    public static volatile boolean iLp = false;

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
        boolean iLr;
        boolean iLs;
        boolean iLt;
        boolean iLu;

        protected final Class<? extends AppBrandProxyUIProcessTask> SI() {
            return a.class;
        }

        protected final void h(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.appId = parcel.readString();
            this.count = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.iLr = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.iLs = z;
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
            parcel.writeInt(this.count);
            if (this.iLr) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.iLs) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
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

        protected final String SH() {
            return "GalleryChooseImage";
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
        ArrayList<AppBrandLocalMediaObject> iLv;

        protected final void h(Parcel parcel) {
            this.aMA = parcel.readInt();
            this.iLv = parcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.aMA);
            parcel.writeTypedList(this.iLv);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            super(parcel);
        }
    }

    private static final class a extends AppBrandProxyUIProcessTask {
        private OnCancelListener iLA;
        ChooseRequest iLw;
        ChooseResult iLx = new ChooseResult();
        int iLy;
        private p iLz;

        private a() {
        }

        static /* synthetic */ void a(a aVar, String str, String str2, Intent intent) {
            aVar.SD().uSV = aVar;
            d.b(aVar.SD(), str, str2, intent, 3);
        }

        protected final void a(ProcessRequest processRequest) {
            boolean z;
            this.iLw = (ChooseRequest) processRequest;
            this.iLw.count = Math.max(1, Math.min(9, this.iLw.count));
            this.iLy = (this.iLw.iLt & this.iLw.iLu) != 0 ? 8 : 7;
            if (bg.en(SD()) > 200) {
                int i = 1;
            } else {
                z = false;
            }
            if (i == 0) {
                s.makeText(SD(), ab.getResources().getString(R.l.fmx), 1).show();
            }
            SD().uSV = this;
            Intent intent = new Intent();
            String str = "key_send_raw_image";
            if (this.iLw.iLt) {
                z = false;
            } else {
                z = true;
            }
            intent.putExtra(str, z);
            intent.putExtra("query_media_type", 1);
            if (this.iLw.iLr && this.iLw.iLs) {
                k.a(SD(), 1, this.iLw.count, this.iLy, intent);
            } else if (this.iLw.iLs) {
                intent.putExtra("show_header_view", false);
                k.a(SD(), 1, this.iLw.count, this.iLy, intent);
            } else if (this.iLw.iLr) {
                k.c(SD(), e.gSz, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
            } else {
                w.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
                this.iLx.aMA = -2;
                a(this.iLx);
            }
        }

        private void hJ(int i) {
            this.iLA = new OnCancelListener(this) {
                final /* synthetic */ a iLB;

                {
                    this.iLB = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.iLB.iLx.aMA = 0;
                    this.iLB.a(this.iLB.iLx);
                }
            };
            Context SD = SD();
            ab.getResources().getString(R.l.dIO);
            this.iLz = g.a(SD, ab.getResources().getString(i), true, this.iLA);
        }

        public static String pf(String str) {
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            if (orientationInDegree == 0) {
                return str;
            }
            orientationInDegree %= 360;
            try {
                Options options = new Options();
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options, 0);
                if (decodeFile == null) {
                    w.e("MicroMsg.JsApiChooseImage", "rotate image, get null bmp");
                    return str;
                }
                Bitmap b = com.tencent.mm.sdk.platformtools.d.b(decodeFile, (float) orientationInDegree);
                String str2 = e.gSz + "microMsg." + System.currentTimeMillis() + ".jpg";
                try {
                    com.tencent.mm.sdk.platformtools.d.a(b, 100, b.a(options) ? CompressFormat.JPEG : CompressFormat.PNG, str2, true);
                    return str2;
                } catch (Exception e) {
                    w.e("MicroMsg.JsApiChooseImage", "rotate image, exception occurred when saving | %s", new Object[]{e});
                    return str;
                }
            } catch (OutOfMemoryError e2) {
                return str;
            } catch (NullPointerException e3) {
                return str;
            }
        }

        public static String pg(String str) {
            Bitmap decodeFile;
            String str2 = e.gSz + "microMsg." + System.currentTimeMillis() + ".jpg";
            try {
                decodeFile = MMBitmapFactory.decodeFile(str, 0);
            } catch (OutOfMemoryError e) {
                w.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom");
                try {
                    decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                } catch (OutOfMemoryError e2) {
                    w.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, oom again");
                    decodeFile = null;
                } catch (Exception e3) {
                    w.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, e " + e3);
                    decodeFile = null;
                }
            } catch (NullPointerException e4) {
                try {
                    decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                } catch (Exception e32) {
                    w.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp npe retry, e " + e32);
                    decodeFile = null;
                }
            } catch (Exception e322) {
                w.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp e " + e322);
                decodeFile = null;
            }
            if (decodeFile == null) {
                w.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp return null");
                return null;
            }
            long Nz = bg.Nz();
            w.i("MicroMsg.JsApiChooseImage", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[]{Boolean.valueOf(b.bk(str2, str)), Long.valueOf(bg.Nz() - Nz), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length())});
            return b.bk(str2, str) ? str2 : str;
        }

        protected final void SF() {
            super.SF();
            if (this.iLz != null) {
                this.iLz.dismiss();
                this.iLz = null;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r12, int r13, android.content.Intent r14) {
            /*
            r11 = this;
            r3 = -2;
            r5 = 1;
            r1 = 0;
            if (r13 != 0) goto L_0x000f;
        L_0x0005:
            r0 = r11.iLx;
            r0.aMA = r1;
            r0 = r11.iLx;
            r11.a(r0);
        L_0x000e:
            return;
        L_0x000f:
            switch(r12) {
                case 1: goto L_0x001c;
                case 2: goto L_0x00e7;
                case 3: goto L_0x001c;
                default: goto L_0x0012;
            };
        L_0x0012:
            r0 = r11.iLx;
            r0.aMA = r3;
            r0 = r11.iLx;
            r11.a(r0);
            goto L_0x000e;
        L_0x001c:
            if (r14 != 0) goto L_0x0028;
        L_0x001e:
            r0 = r11.iLx;
            r0.aMA = r1;
            r0 = r11.iLx;
            r11.a(r0);
            goto L_0x000e;
        L_0x0028:
            r0 = "CropImage_OutputPath_List";
            r2 = r14.getStringArrayListExtra(r0);
            r0 = "CropImage_Compress_Img";
            r6 = r14.getBooleanExtra(r0, r1);
            r0 = r11.iLw;
            r3 = r0.iLt;
            r0 = r11.iLw;
            r0 = r0.iLu;
            if (r0 != 0) goto L_0x00db;
        L_0x0040:
            r0 = r5;
        L_0x0041:
            r0 = r0 & r3;
            if (r0 != 0) goto L_0x0050;
        L_0x0044:
            r0 = r11.iLw;
            r0 = r0.iLt;
            r3 = r11.iLw;
            r3 = r3.iLu;
            r0 = r0 & r3;
            r0 = r0 & r6;
            if (r0 == 0) goto L_0x00de;
        L_0x0050:
            r4 = r5;
        L_0x0051:
            r0 = "isTakePhoto";
            r0 = r14.getBooleanExtra(r0, r1);
            if (r0 != 0) goto L_0x0063;
        L_0x005a:
            r0 = "isPreviewPhoto";
            r0 = r14.getBooleanExtra(r0, r1);
            if (r0 == 0) goto L_0x00e1;
        L_0x0063:
            r3 = r5;
        L_0x0064:
            r0 = "MicroMsg.JsApiChooseImage";
            r7 = "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b";
            r8 = 5;
            r8 = new java.lang.Object[r8];
            r9 = java.lang.Boolean.valueOf(r3);
            r8[r1] = r9;
            r9 = r11.iLw;
            r9 = r9.iLt;
            r9 = java.lang.Boolean.valueOf(r9);
            r8[r5] = r9;
            r9 = 2;
            r10 = r11.iLw;
            r10 = r10.iLu;
            r10 = java.lang.Boolean.valueOf(r10);
            r8[r9] = r10;
            r9 = 3;
            r6 = java.lang.Boolean.valueOf(r6);
            r8[r9] = r6;
            r6 = 4;
            r9 = java.lang.Boolean.valueOf(r4);
            r8[r6] = r9;
            com.tencent.mm.sdk.platformtools.w.d(r0, r7, r8);
            if (r4 == 0) goto L_0x00a0;
        L_0x009b:
            r0 = com.tencent.mm.R.l.fmk;
            r11.hJ(r0);
        L_0x00a0:
            if (r4 != 0) goto L_0x00e5;
        L_0x00a2:
            r0 = com.tencent.mm.sdk.platformtools.bg.bV(r2);
            if (r0 != 0) goto L_0x00e3;
        L_0x00a8:
            r6 = r2.iterator();
        L_0x00ac:
            r0 = r6.hasNext();
            if (r0 == 0) goto L_0x00e3;
        L_0x00b2:
            r0 = r6.next();
            r0 = (java.lang.String) r0;
            r0 = com.tencent.mm.compatible.util.Exif.fromFile(r0);
            r0 = r0.getOrientationInDegree();
            if (r0 == 0) goto L_0x00ac;
        L_0x00c2:
            r0 = r5;
        L_0x00c3:
            if (r0 == 0) goto L_0x00e5;
        L_0x00c5:
            if (r5 == 0) goto L_0x00cc;
        L_0x00c7:
            r0 = com.tencent.mm.R.l.dEF;
            r11.hJ(r0);
        L_0x00cc:
            r6 = com.tencent.mm.plugin.appbrand.m.d.vL();
            r0 = new com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage$a$2;
            r1 = r11;
            r0.<init>(r1, r2, r3, r4, r5);
            r6.D(r0);
            goto L_0x000e;
        L_0x00db:
            r0 = r1;
            goto L_0x0041;
        L_0x00de:
            r4 = r1;
            goto L_0x0051;
        L_0x00e1:
            r3 = r1;
            goto L_0x0064;
        L_0x00e3:
            r0 = r1;
            goto L_0x00c3;
        L_0x00e5:
            r5 = r1;
            goto L_0x00c5;
        L_0x00e7:
            r0 = r11.SD();
            r0 = r0.getApplicationContext();
            r2 = com.tencent.mm.compatible.util.e.gSz;
            r0 = com.tencent.mm.pluginsdk.ui.tools.k.b(r0, r14, r2);
            r2 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r2 == 0) goto L_0x010f;
        L_0x00fb:
            r0 = "MicroMsg.JsApiChooseImage";
            r1 = "take photo, but result is null";
            com.tencent.mm.sdk.platformtools.w.w(r0, r1);
            r0 = r11.iLx;
            r0.aMA = r3;
            r0 = r11.iLx;
            r11.a(r0);
            goto L_0x000e;
        L_0x010f:
            r2 = "MicroMsg.JsApiChooseImage";
            r3 = "take photo, result[%s]";
            r4 = new java.lang.Object[r5];
            r4[r1] = r0;
            com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
            r1 = new com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage$a$3;
            r1.<init>(r11, r0);
            com.tencent.mm.sdk.platformtools.af.v(r1);
            goto L_0x000e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage.a.a(int, int, android.content.Intent):void");
        }
    }

    JsApiChooseImage() {
    }

    public final void a(final m mVar, final JSONObject jSONObject, final int i) {
        int i2 = 0;
        if (iLp) {
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
        String optString = jSONObject.optString("sizeType");
        w.i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", new Object[]{optJSONArray, optString, jSONObject.optString("count")});
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.iLr = true;
            chooseRequest.iLs = true;
        } else {
            chooseRequest.iLr = optJSONArray.toString().contains("camera");
            chooseRequest.iLs = optJSONArray.toString().contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
        }
        if (chooseRequest.iLr) {
            com.tencent.mm.plugin.appbrand.b.a(mVar.ivH, new android.support.v4.app.a.a(this) {
                final /* synthetic */ JsApiChooseImage iLq;

                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    if (i == 113) {
                        if (iArr[0] == 0) {
                            this.iLq.a(mVar, jSONObject, i);
                        } else {
                            mVar.x(i, this.iLq.d("fail:system permission denied", null));
                        }
                    }
                }
            });
            Activity a2 = a(mVar);
            if (a2 == null) {
                mVar.x(i, d("fail", null));
            } else {
                i2 = com.tencent.mm.pluginsdk.i.a.a(a2, "android.permission.CAMERA", 113, "", "");
                if (i2 != 0) {
                    com.tencent.mm.plugin.appbrand.b.mX(mVar.ivH);
                }
            }
            if (i2 == 0) {
                return;
            }
        }
        iLp = true;
        com.tencent.mm.plugin.appbrand.e.a(mVar.ivH, new com.tencent.mm.plugin.appbrand.e.b(this) {
            final /* synthetic */ JsApiChooseImage iLq;

            public final void onResume() {
                JsApiChooseImage.iLp = false;
                com.tencent.mm.plugin.appbrand.e.b(mVar.ivH, this);
            }
        });
        if (bg.mA(optString)) {
            optString = "compressed";
        }
        chooseRequest.iLt = optString.contains("compressed");
        chooseRequest.iLu = optString.contains("original");
        chooseRequest.count = bg.getInt(r5, 9);
        chooseRequest.appId = mVar.ivH;
        com.tencent.mm.plugin.appbrand.ipc.a.b(a, chooseRequest, new AppBrandProxyUIProcessTask.b<ChooseResult>(this) {
            final /* synthetic */ JsApiChooseImage iLq;

            public final /* synthetic */ void c(ProcessResult processResult) {
                ChooseResult chooseResult = (ChooseResult) processResult;
                if (chooseResult != null) {
                    switch (chooseResult.aMA) {
                        case -1:
                            ArrayList arrayList = chooseResult.iLv;
                            if (bg.bV(arrayList)) {
                                w.e("MicroMsg.JsApiChooseImage", "onActivityResult, result list is null or nil");
                                break;
                            }
                            ArrayList arrayList2 = new ArrayList(arrayList.size());
                            ArrayList arrayList3 = new ArrayList(arrayList.size());
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                AppBrandLocalMediaObject appBrandLocalMediaObject = (AppBrandLocalMediaObject) it.next();
                                if (!(appBrandLocalMediaObject == null || bg.mA(appBrandLocalMediaObject.fJz))) {
                                    arrayList2.add(appBrandLocalMediaObject.fJz);
                                    arrayList3.add(Long.valueOf(appBrandLocalMediaObject.ilG));
                                }
                            }
                            w.i("MicroMsg.JsApiChooseImage", "onActivityResult, localIds json list string = %s", new Object[]{JsApiChooseImage.i(arrayList2)});
                            Map hashMap = new HashMap(1);
                            hashMap.put("tempFilePaths", JsApiChooseImage.j(arrayList2));
                            hashMap.put("tempFileSizes", JsApiChooseImage.j(arrayList3));
                            mVar.x(i, this.iLq.d("ok", hashMap));
                            return;
                        case 0:
                            mVar.x(i, this.iLq.d("cancel", null));
                            return;
                    }
                }
                mVar.x(i, this.iLq.d("fail", null));
            }
        });
    }

    public static <T> String i(ArrayList<T> arrayList) {
        if (arrayList.size() == 0) {
            w.e("MicroMsg.JsApiChooseImage", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(arrayList.get(i));
        }
        return jSONArray.toString();
    }

    public static <T> JSONArray j(ArrayList<T> arrayList) {
        if (arrayList.size() == 0) {
            w.e("MicroMsg.JsApiChooseImage", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(arrayList.get(i));
        }
        return jSONArray;
    }
}
