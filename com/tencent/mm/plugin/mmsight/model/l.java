package com.tencent.mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public final class l {
    public static boolean a(String str, VideoTransPara videoTransPara, aks com_tencent_mm_protocal_c_aks, d dVar) {
        try {
            if (bg.mA(str) || videoTransPara == null) {
                return false;
            }
            if (com_tencent_mm_protocal_c_aks == null) {
                com_tencent_mm_protocal_c_aks = new aks();
            }
            w.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", new Object[]{Boolean.valueOf(com_tencent_mm_protocal_c_aks.tOs), str, videoTransPara, Boolean.valueOf(com_tencent_mm_protocal_c_aks.tOw)});
            if (com_tencent_mm_protocal_c_aks.tOw) {
                w.i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", new Object[]{str});
                return false;
            } else if (!com_tencent_mm_protocal_c_aks.tOs || bg.mA(str)) {
                return false;
            } else {
                SightVideoJNI.tagMP4Dscp(str, d.Eu().getWeixinMeta());
                if (!bg.mA(com_tencent_mm_protocal_c_aks.tOv)) {
                    SightVideoJNI.tagMp4RecordInfo(str, com_tencent_mm_protocal_c_aks.tOv);
                }
                long NA = bg.NA();
                SightVideoJNI.optimizeMP4(str);
                w.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", new Object[]{Long.valueOf(bg.aB(NA))});
                dVar.aJQ();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                int i = bg.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i2 = bg.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                mediaMetadataRetriever.release();
                w.i("MicroMsg.SightSendVideoLogic", "videopath %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                int min = Math.min(i, i2);
                if (min > videoTransPara.width && (min <= videoTransPara.width || min % 16 != 0 || Math.abs(min - videoTransPara.width) >= 16)) {
                    return true;
                }
                com_tencent_mm_protocal_c_aks.tOw = true;
                return false;
            }
        } catch (Exception e) {
            w.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", new Object[]{e.getMessage(), str});
            if (com_tencent_mm_protocal_c_aks == null) {
                return false;
            }
            com_tencent_mm_protocal_c_aks.tOw = true;
            return false;
        }
    }

    public static int b(String str, VideoTransPara videoTransPara, aks com_tencent_mm_protocal_c_aks, d dVar) {
        if (com_tencent_mm_protocal_c_aks == null || !com_tencent_mm_protocal_c_aks.tOs || !FileOp.aO(str)) {
            return -1;
        }
        if (com_tencent_mm_protocal_c_aks.tOw) {
            w.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, already finish preSendProcess, videoPath: %s", new Object[]{str});
        }
        try {
            String str2;
            String substring;
            String kk = FileOp.kk(str);
            if (kk.endsWith("/")) {
                str2 = kk;
            } else {
                str2 = kk + "/";
            }
            kk = new File(str).getName();
            int lastIndexOf = kk.lastIndexOf(46);
            if (lastIndexOf > 0) {
                substring = kk.substring(0, lastIndexOf);
            } else {
                substring = kk;
            }
            kk = str2 + substring + "_hd";
            if (str.endsWith(".mp4")) {
                kk = kk + ".mp4";
            }
            String str3 = str2 + substring + "tempRemuxing.mp4";
            FileOp.p(str, kk);
            w.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", new Object[]{str2, substring, kk, str3, Integer.valueOf(com_tencent_mm_protocal_c_aks.tOt)});
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(kk);
            int i = bg.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            int i2 = bg.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            if (Math.min(i, i2) <= videoTransPara.width) {
                return 0;
            }
            int i3;
            int i4;
            if (i < i2) {
                i3 = videoTransPara.width;
                i4 = (int) (((double) i2) / ((1.0d * ((double) i)) / ((double) i3)));
            } else {
                i4 = videoTransPara.width;
                i3 = (int) (((double) i) / ((1.0d * ((double) i2)) / ((double) i4)));
            }
            w.i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), videoTransPara});
            if (i4 % 2 != 0) {
                i4++;
            }
            if (i3 % 2 != 0) {
                i3++;
            }
            long NA = bg.NA();
            w.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(SightVideoJNI.remuxing(kk, str3, i3, i4, videoTransPara.hzY, videoTransPara.hzO, 8, videoTransPara.hzN, 25.0f, 30.0f, null, 0, b.pty)), Long.valueOf(bg.aB(NA))});
            FileOp.aj(str3, str);
            long NA2 = bg.NA();
            if (com_tencent_mm_protocal_c_aks.tOs) {
                SightVideoJNI.tagMP4Dscp(str, d.Eu().getWeixinMeta());
                if (!bg.mA(com_tencent_mm_protocal_c_aks.tOv)) {
                    SightVideoJNI.tagMp4RecordInfo(str, com_tencent_mm_protocal_c_aks.tOv);
                }
                SightVideoJNI.optimizeMP4(str);
            }
            dVar.aJQ();
            w.i("MicroMsg.SightSendVideoLogic", "tagMP4Dscp used %sms", new Object[]{Long.valueOf(bg.aB(NA2))});
            return r2;
        } catch (Exception e) {
            w.e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", new Object[]{e.getMessage()});
            return -1;
        }
    }
}
