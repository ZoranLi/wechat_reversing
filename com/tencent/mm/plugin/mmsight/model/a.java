package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class a {
    static a nAT;
    public long fileSize;
    public int gPG = 0;
    public int gRr;
    public int hzY;
    int lvH;
    String model = Build.MODEL;
    String nAU = (VERSION.SDK_INT);
    int nAV;
    String nAW;
    int nAX;
    int nAY;
    public String nAZ;
    public String nBa;
    public String nBb;
    public String nBc;
    public int nBd;
    public int nBe;
    public int nBf;
    public int nBg;
    public int nBh;
    public int nBi;
    public int nBj;
    public int nBk;
    public int nBl;
    public int nBm;
    public int nBn;
    public int nBo;
    public int nBp;
    int nBq;
    public int nBr;
    public int nBs;
    public int nBt;
    public long nBu;
    public int nBv;
    JSONObject nBw = null;

    public static a aKH() {
        if (nAT == null) {
            reset();
        }
        return nAT;
    }

    public static void reset() {
        a aVar = new a();
        nAT = aVar;
        aVar.lvH = ((ActivityManager) ab.getContext().getSystemService("activity")).getLargeMemoryClass();
        nAT.nAV = d.cz(ab.getContext());
        nAT.nAW = l.rm();
        Point cy = d.cy(ab.getContext());
        nAT.nAX = cy.x;
        nAT.nAY = cy.y;
    }

    public final String aKI() {
        if (this.nBw == null) {
            try {
                this.nBw = new JSONObject();
                JSONObject jSONObject = new JSONObject();
                this.nBw.put("wxcamera", jSONObject);
                jSONObject.put("model", this.model);
                jSONObject.put("apiLevel", this.nAU);
                jSONObject.put("screen", String.format("%dx%d", new Object[]{Integer.valueOf(this.nAX), Integer.valueOf(this.nAY)}));
                jSONObject.put("crop", String.format("%dx%d", new Object[]{Integer.valueOf(this.nBd), Integer.valueOf(this.nBe)}));
                jSONObject.put("preview", String.format("%dx%d", new Object[]{Integer.valueOf(this.nBf), Integer.valueOf(this.nBg)}));
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_ENCODER, String.format("%dx%d", new Object[]{Integer.valueOf(this.nBh), Integer.valueOf(this.nBi)}));
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, this.gPG);
                jSONObject.put("deviceoutfps", this.nBj);
                jSONObject.put("recordfps", this.nBk);
                jSONObject.put("recordertype", this.nBl);
                jSONObject.put("needRotateEachFrame", this.gRr);
                jSONObject.put("isNeedRealtimeScale", this.nBm);
                jSONObject.put("resolutionLimit", this.nBn);
                jSONObject.put("videoBitrate", this.hzY);
                jSONObject.put("wait2playtime", this.nBu);
                jSONObject.put("useback", this.nBv);
                jSONObject.put("presetIndex", j.nCL != null ? j.nCL.nCU : -1);
                jSONObject.put("recorderOption", p.gRj.gRx);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.CaptureStatistics", e, "buildJson error", new Object[0]);
            }
        }
        return this.nBw.toString();
    }
}
