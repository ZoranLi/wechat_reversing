package com.tencent.mm.plugin.sight.base;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public final class d {
    private static int nAo = 0;
    public static int nAp = 0;

    public static boolean bbP() {
        if (p.gRe.gRL == 0) {
            return false;
        }
        return com.tencent.mm.compatible.util.d.eo(14);
    }

    public static String Eo(String str) {
        return bg.ap(str, "") + ".thumb";
    }

    public static String Ep(String str) {
        return bg.ap(str, "") + ".soundmp4";
    }

    public static Bitmap J(String str, int i, int i2) {
        if (bg.mA(str)) {
            return null;
        }
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        if (createVideoThumbnail != null) {
            return com.tencent.mm.sdk.platformtools.d.a(createVideoThumbnail, i2, i, true, true);
        }
        w.e("MicroMsg.SightUtil", "create remux thumb bmp error, target path %s", str);
        return createVideoThumbnail;
    }

    public static boolean Eq(String str) {
        if (bg.mA(str) || !e.aO(str)) {
            return false;
        }
        long NA = bg.NA();
        c cVar = new c();
        int isSightOk = SightVideoJNI.isSightOk(str, cVar.ptH, cVar.ptI, cVar.ptJ, cVar.ptL, cVar.ptK, cVar.ptK.length);
        w.d("MicroMsg.SightUtil", "ashu::check sight use %dms", Long.valueOf(bg.aB(NA)));
        return isSightOk == 0;
    }

    public static String bbQ() {
        String format;
        StringBuilder stringBuilder = new StringBuilder(512);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = ab.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.REV);
        stringBuilderPrinter.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.TIME + ":" + com.tencent.mm.sdk.platformtools.e.HOSTNAME + ":" + f.fuV);
        stringBuilderPrinter.println("#accinfo.env=" + (b.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + b.urS);
        stringBuilderPrinter.println("#aacinfo.device_brand=" + com.tencent.mm.protocal.d.sYG);
        stringBuilderPrinter.println("#aacinfo.device_model=" + com.tencent.mm.protocal.d.sYH);
        stringBuilderPrinter.println("#aacinfo.os_type=" + com.tencent.mm.protocal.d.sYI);
        stringBuilderPrinter.println("#aacinfo.os_name=" + com.tencent.mm.protocal.d.sYJ);
        stringBuilderPrinter.println("#aacinfo.os_version=" + com.tencent.mm.protocal.d.sYK);
        stringBuilderPrinter.println("#aacinfo.device_name=" + com.tencent.mm.protocal.d.sYL);
        String str = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(com.tencent.mm.compatible.util.e.hgs);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) context.getSystemService("activity")).getMemoryClass()), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), com.tencent.mm.compatible.util.e.hgs, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            w.e("MicroMsg.SightUtil", "check data size failed :%s", e.getMessage());
            format = str;
        }
        stringBuilderPrinter.println("#accinfo.data=" + format);
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }

    public static String AN(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("extInfo: \n" + a(str, new PInt(), new PInt(), new PInt(), new PInt(), new PInt()));
        stringBuffer.append("size: " + bg.ay(FileOp.ki(str)) + ":" + str + "\n");
        String mp4RecordInfo = SightVideoJNI.getMp4RecordInfo(str);
        if (!bg.mA(mp4RecordInfo)) {
            stringBuffer.append(mp4RecordInfo);
        }
        stringBuffer.append("isH265:").append(q.lp(str));
        return stringBuffer.toString();
    }

    public static String a(String str, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            w.d("MicroMsg.SightUtil", "get simple mp4 info %s", SightVideoJNI.getSimpleMp4Info(str));
            JSONObject jSONObject = new JSONObject(r0);
            pInt.value = (int) jSONObject.getDouble("videoDuration");
            pInt2.value = jSONObject.getInt("videoWidth");
            pInt3.value = jSONObject.getInt("videoHeight");
            pInt4.value = (int) jSONObject.getDouble("videoFPS");
            pInt5.value = jSONObject.getInt("videoBitrate");
            stringBuffer.append("videoBitrate: ").append(pInt5.value).append("\n");
            stringBuffer.append("videoWidth,videoHeight: ").append(pInt2.value).append("*").append(pInt3.value);
            stringBuffer.append(" ").append(String.format("%.4f", new Object[]{Double.valueOf((((double) pInt2.value) * 1.0d) / ((double) pInt3.value))})).append("\n");
            stringBuffer.append("videoDuration: ").append(pInt.value).append("\n");
            stringBuffer.append("videoFPS: ").append(pInt4.value).append("\n");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SightUtil", e, "get media info error", new Object[0]);
        }
        return stringBuffer.toString();
    }

    public static a Er(String str) {
        a aVar = null;
        if (!bg.mA(str) && e.aO(str)) {
            aVar = new a();
            try {
                w.d("MicroMsg.SightUtil", "get simple mp4 info %s", SightVideoJNI.getSimpleMp4Info(str));
                JSONObject jSONObject = new JSONObject(r1);
                aVar.lMh = (int) jSONObject.getDouble("videoDuration");
                aVar.width = jSONObject.getInt("videoWidth");
                aVar.height = jSONObject.getInt("videoHeight");
                aVar.nFY = (int) jSONObject.getDouble("videoFPS");
                aVar.hzY = jSONObject.getInt("videoBitrate");
                aVar.hzL = jSONObject.getInt("audioBitrate");
                aVar.ptw = jSONObject.getInt("audioChannel");
            } catch (Exception e) {
                w.e("MicroMsg.SightUtil", "get media info error %s", e.toString());
            }
            w.i("MicroMsg.SightUtil", "get media %s", aVar);
        }
        return aVar;
    }
}
