package com.tencent.mm.plugin.mmsight.model;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class k {
    public static void aKO() {
        w.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
        g.oUh.a(440, 0, 1, false);
        int i = 36;
        if (j.nCL.gRq == 1) {
            i = 39;
        }
        if (j.nCL.nBn == 720) {
            i++;
        } else if (j.nCL.aKV()) {
            i += 2;
        }
        g.oUh.a(440, (long) i, 1, false);
    }

    public static void aKP() {
        w.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
        g.oUh.a(440, 7, 1, false);
    }

    public static void aKQ() {
        w.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
        g.oUh.a(440, 8, 1, false);
    }

    public static void aKR() {
        w.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
        g.oUh.a(440, 16, 1, false);
    }

    public static void b(boolean z, long j) {
        int i;
        w.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
        a.aKH().nBu = j;
        a aKH = a.aKH();
        d dVar = new d();
        d dVar2 = new d();
        dVar.m("model", aKH.model + ",");
        dVar.m("apiLevel", aKH.nAU + ",");
        dVar.m("memoryClass", aKH.lvH + ",");
        dVar.m("totalMemory", aKH.nAV + ",");
        dVar.m("maxCpu", aKH.nAW + ",");
        dVar.m("screenW", aKH.nAX + ",");
        dVar.m("screenH", aKH.nAY + ",");
        dVar2.m("model", aKH.model + ",");
        dVar2.m("apiLevel", aKH.nAU + ",");
        dVar2.m("memoryClass", aKH.lvH + ",");
        dVar2.m("totalMemory", aKH.nAV + ",");
        dVar2.m("maxCpu", aKH.nAW + ",");
        dVar2.m("screenW", aKH.nAX + ",");
        dVar2.m("screenH", aKH.nAY + ",");
        dVar.m("cropx", aKH.nBd + ",");
        dVar.m("cropy", aKH.nBe + ",");
        dVar.m("previewx", aKH.nBf + ",");
        dVar.m("previewy", aKH.nBg + ",");
        dVar.m("encoderx", aKH.nBh + ",");
        dVar.m("encodery", aKH.nBi + ",");
        dVar.m(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, aKH.gPG + ",");
        dVar.m("deviceoutfps", aKH.nBj + ",");
        dVar.m("recordfps", aKH.nBk + ",");
        dVar.m("recordertype", aKH.nBl + ",");
        dVar.m("videoBitrate", aKH.hzY + ",");
        dVar.m("needRotateEachFrame", aKH.gRr + ",");
        dVar.m("isNeedRealtimeScale", aKH.nBm + ",");
        dVar.m("resolutionLimit", aKH.nBn + ",");
        dVar.m("outfps", aKH.nBo + ",");
        dVar.m("recordTime", aKH.nBp + ",");
        dVar.m("avgcpu", aKH.nBq + ",");
        dVar.m("outx", aKH.nBr + ",");
        dVar.m("outy", aKH.nBs + ",");
        dVar.m("outbitrate", aKH.nBt + ",");
        dVar.m("fileSize", aKH.fileSize + ",");
        dVar.m("wait2playtime", aKH.nBu + ",");
        dVar.m("useback", aKH.nBv + ",");
        int i2 = 0;
        int i3 = 0;
        Intent registerReceiver = ab.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            i3 = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
            i3 = (i3 == 2 || i3 == 5) ? 1 : 0;
            i2 = registerReceiver.getIntExtra("level", -1);
            i = i3;
            i3 = registerReceiver.getIntExtra("scale", -1);
        } else {
            i = 0;
        }
        w.i("MicroMsg.CaptureStatistics", "battery %s %s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        dVar.m("mIsCharging", i + ",");
        dVar.m("level", i2 + ",");
        dVar.m("scale", i3 + ",");
        dVar.m("createTime", System.currentTimeMillis() + ",");
        dVar2.m("prewViewlist1", aKH.nAZ + ",");
        dVar2.m("pictureSize1", aKH.nBa + ",");
        dVar2.m("prewViewlist2", aKH.nBb + ",");
        dVar2.m("pictureSize2", aKH.nBc + ",");
        w.i("MicroMsg.CaptureStatistics", "report " + dVar.JG());
        w.v("MicroMsg.CaptureStatistics", "report " + dVar2.JG());
        g.oUh.A(13947, dVar.toString());
        g.oUh.A(13949, dVar2.toString());
        if (z) {
            g.oUh.a(440, 119, 1, false);
            g.oUh.a(440, 120, j, false);
            if (j.nCL.nBn == 720) {
                g.oUh.a(440, 122, j, false);
                return;
            } else if (j.nCL.aKV()) {
                g.oUh.a(440, 123, j, false);
                return;
            } else {
                g.oUh.a(440, 121, j, false);
                return;
            }
        }
        g.oUh.a(440, 124, 1, false);
        g.oUh.a(440, 125, j, false);
        if (j.nCL.gRq == 1) {
            g.oUh.a(440, 127, j, false);
            g.oUh.a(440, 131, j, false);
            return;
        }
        g.oUh.a(440, 126, j, false);
        g.oUh.a(440, 130, j, false);
    }
}
