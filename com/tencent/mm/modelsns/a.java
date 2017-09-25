package com.tencent.mm.modelsns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.ox;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.Set;

public final class a {
    public static Set<String> hTe;

    public static class a {
        public String hTf;
        public String hTg;
        public String hTh;
        public int hTi = -1;
        public int hTj = -1;
        public int hTk = -1;
        public int hTl = -1;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.tencent.mm.modelsns.a.a kF(java.lang.String r13) {
            /*
            r0 = 0;
            r2 = 0;
            r5 = new android.media.MediaExtractor;
            r5.<init>();
            r6 = new com.tencent.mm.modelsns.a$a;
            r6.<init>();
            r6.hTf = r13;
            r5.setDataSource(r13);	 Catch:{ Exception -> 0x0119 }
            r7 = r5.getTrackCount();	 Catch:{ Exception -> 0x0119 }
            r3 = r2;
            r1 = r0;
        L_0x0017:
            if (r3 >= r7) goto L_0x005a;
        L_0x0019:
            r4 = r5.getTrackFormat(r3);	 Catch:{ Exception -> 0x0119 }
            r8 = "mime";
            r8 = r4.containsKey(r8);	 Catch:{ Exception -> 0x0119 }
            if (r8 != 0) goto L_0x0032;
        L_0x0026:
            r4 = "MicroMsg.ShareSnsImpl";
            r8 = "find video mime : not found.";
            com.tencent.mm.sdk.platformtools.w.i(r4, r8);	 Catch:{ Exception -> 0x0119 }
        L_0x002f:
            r3 = r3 + 1;
            goto L_0x0017;
        L_0x0032:
            r8 = "mime";
            r8 = r4.getString(r8);	 Catch:{ Exception -> 0x0119 }
            r9 = "MicroMsg.ShareSnsImpl";
            r10 = "find video mime : %s";
            r11 = 1;
            r11 = new java.lang.Object[r11];	 Catch:{ Exception -> 0x0119 }
            r12 = 0;
            r11[r12] = r8;	 Catch:{ Exception -> 0x0119 }
            com.tencent.mm.sdk.platformtools.w.i(r9, r10, r11);	 Catch:{ Exception -> 0x0119 }
            if (r8 == 0) goto L_0x002f;
        L_0x004a:
            r9 = "video/";
            r9 = r8.startsWith(r9);	 Catch:{ Exception -> 0x0119 }
            if (r9 == 0) goto L_0x00c8;
        L_0x0053:
            if (r1 != 0) goto L_0x0056;
        L_0x0055:
            r1 = r4;
        L_0x0056:
            if (r0 == 0) goto L_0x002f;
        L_0x0058:
            if (r1 == 0) goto L_0x002f;
        L_0x005a:
            r3 = r1;
            r1 = r0;
            if (r3 == 0) goto L_0x00b4;
        L_0x005e:
            r0 = "durationUs";
            r0 = r3.containsKey(r0);	 Catch:{ Exception -> 0x0119 }
            if (r0 != 0) goto L_0x00d5;
        L_0x0067:
            r0 = r2;
        L_0x0068:
            r6.hTi = r0;	 Catch:{ Exception -> 0x0119 }
            r0 = "height";
            r0 = r3.containsKey(r0);	 Catch:{ Exception -> 0x0119 }
            if (r0 != 0) goto L_0x00e1;
        L_0x0073:
            r0 = r2;
        L_0x0074:
            r6.hTj = r0;	 Catch:{ Exception -> 0x0119 }
            r0 = "width";
            r0 = r3.containsKey(r0);	 Catch:{ Exception -> 0x0119 }
            if (r0 != 0) goto L_0x00e9;
        L_0x007f:
            r0 = r2;
        L_0x0080:
            r6.hTk = r0;	 Catch:{ Exception -> 0x0119 }
            r0 = "mime";
            r0 = r3.containsKey(r0);	 Catch:{ Exception -> 0x0119 }
            if (r0 != 0) goto L_0x00f1;
        L_0x008b:
            r0 = "";
        L_0x008e:
            r6.hTg = r0;	 Catch:{ Exception -> 0x0119 }
            r0 = "bitrate";
            r0 = r3.containsKey(r0);	 Catch:{ Exception -> 0x0119 }
            if (r0 != 0) goto L_0x00f9;
        L_0x0099:
            r0 = r2;
        L_0x009a:
            r6.videoBitRate = r0;	 Catch:{ Exception -> 0x0119 }
            r0 = "i-frame-interval";
            r0 = r3.containsKey(r0);	 Catch:{ Exception -> 0x0119 }
            if (r0 != 0) goto L_0x0101;
        L_0x00a5:
            r0 = r2;
        L_0x00a6:
            r6.hTl = r0;	 Catch:{ Exception -> 0x0119 }
            r0 = "frame-rate";
            r0 = r3.containsKey(r0);	 Catch:{ Exception -> 0x0119 }
            if (r0 != 0) goto L_0x0109;
        L_0x00b1:
            r0 = r2;
        L_0x00b2:
            r6.videoFrameRate = r0;	 Catch:{ Exception -> 0x0119 }
        L_0x00b4:
            if (r1 == 0) goto L_0x00c4;
        L_0x00b6:
            r0 = "mime";
            r0 = r1.containsKey(r0);	 Catch:{ Exception -> 0x0119 }
            if (r0 != 0) goto L_0x0111;
        L_0x00bf:
            r0 = "";
        L_0x00c2:
            r6.hTh = r0;	 Catch:{ Exception -> 0x0119 }
        L_0x00c4:
            r5.release();
        L_0x00c7:
            return r6;
        L_0x00c8:
            r9 = "audio/";
            r8 = r8.startsWith(r9);	 Catch:{ Exception -> 0x0119 }
            if (r8 == 0) goto L_0x0056;
        L_0x00d1:
            if (r0 != 0) goto L_0x0056;
        L_0x00d3:
            r0 = r4;
            goto L_0x0056;
        L_0x00d5:
            r0 = "durationUs";
            r8 = r3.getLong(r0);	 Catch:{ Exception -> 0x0119 }
            r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r8 = r8 / r10;
            r0 = (int) r8;	 Catch:{ Exception -> 0x0119 }
            goto L_0x0068;
        L_0x00e1:
            r0 = "height";
            r0 = r3.getInteger(r0);	 Catch:{ Exception -> 0x0119 }
            goto L_0x0074;
        L_0x00e9:
            r0 = "width";
            r0 = r3.getInteger(r0);	 Catch:{ Exception -> 0x0119 }
            goto L_0x0080;
        L_0x00f1:
            r0 = "mime";
            r0 = r3.getString(r0);	 Catch:{ Exception -> 0x0119 }
            goto L_0x008e;
        L_0x00f9:
            r0 = "bitrate";
            r0 = r3.getInteger(r0);	 Catch:{ Exception -> 0x0119 }
            goto L_0x009a;
        L_0x0101:
            r0 = "i-frame-interval";
            r0 = r3.getInteger(r0);	 Catch:{ Exception -> 0x0119 }
            goto L_0x00a6;
        L_0x0109:
            r0 = "frame-rate";
            r0 = r3.getInteger(r0);	 Catch:{ Exception -> 0x0119 }
            goto L_0x00b2;
        L_0x0111:
            r0 = "mime";
            r0 = r1.getString(r0);	 Catch:{ Exception -> 0x0119 }
            goto L_0x00c2;
        L_0x0119:
            r0 = move-exception;
            r1 = "MicroMsg.ShareSnsImpl";
            r2 = "Video extractor init failed. video path = [%s] e = [%s]";
            r3 = 2;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0134 }
            r4 = 0;
            r3[r4] = r13;	 Catch:{ all -> 0x0134 }
            r4 = 1;
            r0 = r0.getMessage();	 Catch:{ all -> 0x0134 }
            r3[r4] = r0;	 Catch:{ all -> 0x0134 }
            com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);	 Catch:{ all -> 0x0134 }
            r5.release();
            goto L_0x00c7;
        L_0x0134:
            r0 = move-exception;
            r5.release();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelsns.a.a.kF(java.lang.String):com.tencent.mm.modelsns.a$a");
        }
    }

    public static Intent a(WXMediaMessage wXMediaMessage, String str, String str2) {
        int i;
        w.d("MicroMsg.ShareSnsImpl", "appmsg.description " + wXMediaMessage.description);
        w.d("MicroMsg.ShareSnsImpl", "appmsg.title " + wXMediaMessage.title);
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        switch (iMediaObject.type()) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
            case 6:
                i = 3;
                break;
            case 7:
                i = 3;
                break;
            case 38:
            case 39:
                i = 15;
                break;
            default:
                i = -1;
                break;
        }
        Intent intent = new Intent();
        intent.putExtra("KThrid_app", true);
        w.d("MicroMsg.ShareSnsImpl", "TimeLineType " + i + " " + iMediaObject.type());
        intent.putExtra("Ksnsupload_appid", str);
        intent.putExtra("Ksnsupload_appname", str2);
        intent.putExtra("KSnsAction", true);
        intent.putExtra("need_result", true);
        Bundle bundle = new Bundle();
        Req req = new Req();
        req.message = wXMediaMessage;
        req.toBundle(bundle);
        intent.putExtra("Ksnsupload_timeline", bundle);
        if (i == -1) {
            w.d("MicroMsg.ShareSnsImpl", "timeLineType is invalid");
            return null;
        }
        String ap;
        String str3;
        String aV;
        StringBuilder stringBuilder;
        Bitmap kE;
        Options Pe;
        switch (iMediaObject.type()) {
            case 1:
                intent.putExtra("Kdescription", ((WXTextObject) iMediaObject).text);
                intent.putExtra("Ksnsupload_type", 8);
                return intent;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", wXImageObject.imagePath);
                return intent;
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
                ap = bg.ap(!bg.mA(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                bg.ap(!bg.mA(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                bg.ap(!bg.mA(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, "");
                intent.putExtra("Ksnsupload_link", ap);
                intent.putExtra("Ksnsupload_title", "");
                intent.putExtra("Ksnsupload_type", 2);
                intent.putExtra("ksnsis_music", true);
                return intent;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
                intent.putExtra("Ksnsupload_link", bg.ap(!bg.mA(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, ""));
                intent.putExtra("Ksnsupload_title", "");
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("ksnsis_video", true);
                return intent;
            case 5:
                intent.putExtra("Ksnsupload_link", ((WXWebpageObject) iMediaObject).webpageUrl);
                intent.putExtra("Ksnsupload_title", bg.ap(wXMediaMessage.title, ""));
                intent.putExtra("Ksnsupload_imgbuf", wXMediaMessage.thumbData);
                intent.putExtra("Ksnsupload_type", 1);
                return intent;
            case 6:
                w.e("MicroMsg.ShareSnsImpl", "file is not support!");
                return null;
            case 7:
                return null;
            case 38:
                WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 14);
                ap = wXVideoFileObject.filePath;
                str3 = "";
                aV = g.aV(ap);
                if (bg.mA(str3) || !FileOp.aO(str3)) {
                    stringBuilder = new StringBuilder();
                    ap.yY();
                    str3 = stringBuilder.append(c.getAccSnsTmpPath()).append(aV).toString();
                    try {
                        kE = kE(ap);
                        if (kE != null) {
                            w.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", Integer.valueOf(kE.getWidth()), Integer.valueOf(kE.getHeight()));
                            d.a(kE, 80, CompressFormat.JPEG, str3, true);
                            Pe = d.Pe(str3);
                            w.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", Integer.valueOf(Pe.outWidth), Integer.valueOf(Pe.outHeight));
                        } else {
                            w.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", ap);
                            return null;
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", e.getMessage());
                    }
                }
                intent.putExtra("KSightPath", ap);
                intent.putExtra("KSightThumbPath", str3);
                intent.putExtra("sight_md5", aV);
                return intent;
            case 39:
                WXGameVideoFileObject wXGameVideoFileObject = (WXGameVideoFileObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 14);
                ap = wXGameVideoFileObject.filePath;
                String str4 = "";
                w.i("MicroMsg.ShareSnsImpl", "videoPath %s,thumbPath %s,cdnUrl %s,cdnThumbUrl %s", ap, str4, wXGameVideoFileObject.videoUrl, wXGameVideoFileObject.thumbUrl);
                String aV2 = g.aV(ap);
                if (bg.mA(str4) || !FileOp.aO(str4)) {
                    stringBuilder = new StringBuilder();
                    ap.yY();
                    str3 = stringBuilder.append(c.getAccSnsTmpPath()).append(aV2).toString();
                    try {
                        kE = kE(ap);
                        if (kE != null) {
                            w.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", Integer.valueOf(kE.getWidth()), Integer.valueOf(kE.getHeight()));
                            d.a(kE, 80, CompressFormat.JPEG, str3, true);
                            Pe = d.Pe(str3);
                            w.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", Integer.valueOf(Pe.outWidth), Integer.valueOf(Pe.outHeight));
                        } else {
                            w.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", ap);
                            return null;
                        }
                    } catch (Exception e2) {
                        w.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", e2.getMessage());
                    }
                } else {
                    str3 = str4;
                }
                intent.putExtra("KSightPath", ap);
                intent.putExtra("KSightThumbPath", str3);
                intent.putExtra("sight_md5", aV2);
                intent.putExtra("KSightCdnUrl", aV);
                intent.putExtra("KSightCdnThumbUrl", r5);
                return intent;
            default:
                w.e("MicroMsg.ShareSnsImpl", "none type not support!");
                return null;
        }
    }

    private static Bitmap kE(String str) {
        b oxVar = new ox();
        oxVar.fVR.fVT = str;
        com.tencent.mm.sdk.b.a.urY.m(oxVar);
        return (Bitmap) oxVar.fVS.result;
    }
}
