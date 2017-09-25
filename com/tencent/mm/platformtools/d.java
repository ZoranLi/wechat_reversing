package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public final class d {
    public static boolean a(String str, Context context, int i) {
        if (!o.Pj(str)) {
            return a(str, context, true, i);
        }
        if (!bg.mA(str)) {
            String mr = mr("gif");
            e.aU(mr);
            if (FileOp.p(str, mr) >= 0) {
                b(mr, context);
                Toast.makeText(context, context.getString(i, new Object[]{Nk()}), 1).show();
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r9, android.content.Context r10, boolean r11, int r12) {
        /*
        r1 = 1;
        r0 = 0;
        if (r9 == 0) goto L_0x0021;
    L_0x0004:
        r2 = "";
        r2 = r9.equals(r2);
        if (r2 != 0) goto L_0x0021;
    L_0x000d:
        r2 = "jpg";
        r5 = mr(r2);
        com.tencent.mm.a.e.aU(r5);
        r2 = com.tencent.mm.modelsfs.FileOp.p(r9, r5);
        r6 = 0;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x0022;
    L_0x0021:
        return r0;
    L_0x0022:
        r2 = com.tencent.mm.sdk.platformtools.MMNativeJpeg.isProgressive(r5);
        if (r2 == 0) goto L_0x004a;
    L_0x0028:
        r2 = 0;
        r4 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.Pc(r5);	 Catch:{ Exception -> 0x0073, all -> 0x0080 }
        r3 = com.tencent.mm.sdk.platformtools.MMNativeJpeg.decodeAsBitmap(r5);	 Catch:{ Exception -> 0x0073, all -> 0x0080 }
        if (r3 == 0) goto L_0x0094;
    L_0x0033:
        r4 = (float) r4;
        r3 = com.tencent.mm.sdk.platformtools.d.b(r3, r4);	 Catch:{ Exception -> 0x0064, all -> 0x0080 }
        r4 = r3;
    L_0x0039:
        r6 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ Exception -> 0x0073, all -> 0x0080 }
        r7 = 80;
        r3 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0073, all -> 0x0080 }
        r3.<init>(r5);	 Catch:{ Exception -> 0x0073, all -> 0x0080 }
        r4.compress(r6, r7, r3);	 Catch:{ Exception -> 0x0091, all -> 0x008b }
    L_0x0045:
        if (r3 == 0) goto L_0x004a;
    L_0x0047:
        r3.close();	 Catch:{ Exception -> 0x0087 }
    L_0x004a:
        b(r5, r10);
        if (r11 == 0) goto L_0x0062;
    L_0x004f:
        r2 = new java.lang.Object[r1];
        r3 = Nk();
        r2[r0] = r3;
        r0 = r10.getString(r12, r2);
        r0 = android.widget.Toast.makeText(r10, r0, r1);
        r0.show();
    L_0x0062:
        r0 = r1;
        goto L_0x0021;
    L_0x0064:
        r4 = move-exception;
        r6 = "MicroMsg.ExportImgUtil";
        r7 = "rotate img failed.";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0073, all -> 0x0080 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r6, r4, r7, r8);	 Catch:{ Exception -> 0x0073, all -> 0x0080 }
        r4 = r3;
        goto L_0x0039;
    L_0x0073:
        r1 = move-exception;
        r1 = r2;
    L_0x0075:
        com.tencent.mm.modelsfs.FileOp.deleteFile(r5);	 Catch:{ all -> 0x008e }
        if (r1 == 0) goto L_0x0021;
    L_0x007a:
        r1.close();	 Catch:{ Exception -> 0x007e }
        goto L_0x0021;
    L_0x007e:
        r1 = move-exception;
        goto L_0x0021;
    L_0x0080:
        r0 = move-exception;
    L_0x0081:
        if (r2 == 0) goto L_0x0086;
    L_0x0083:
        r2.close();	 Catch:{ Exception -> 0x0089 }
    L_0x0086:
        throw r0;
    L_0x0087:
        r2 = move-exception;
        goto L_0x004a;
    L_0x0089:
        r1 = move-exception;
        goto L_0x0086;
    L_0x008b:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0081;
    L_0x008e:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0081;
    L_0x0091:
        r1 = move-exception;
        r1 = r3;
        goto L_0x0075;
    L_0x0094:
        r3 = r2;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.d.a(java.lang.String, android.content.Context, boolean, int):boolean");
    }

    public static String mr(String str) {
        return com.tencent.mm.compatible.util.e.gSz + String.format("%s%d.%s", new Object[]{"mmexport", Long.valueOf(System.currentTimeMillis()), str});
    }

    public static void b(String str, Context context) {
        if (!bg.mA(str)) {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str))));
            w.i("MicroMsg.ExportImgUtil", "refreshing media scanner on path=%s", str);
        }
    }

    public static String Nk() {
        String str = com.tencent.mm.compatible.util.e.gSz;
        return str.substring(str.indexOf("tencent/MicroMsg"));
    }
}
