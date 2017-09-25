package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.e.a.iu;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import java.util.HashMap;

public class n implements am {
    public HashMap<String, a> hZB = new HashMap();
    private c<iu> hZC = new c<iu>(this) {
        final /* synthetic */ n hZE;

        {
            this.hZE = r2;
            this.usg = iu.class.getName().hashCode();
        }

        private boolean a(iu iuVar) {
            w.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
            if (iuVar == null) {
                return false;
            }
            String str;
            String str2 = iuVar.fOt.path;
            try {
                if (str2.endsWith(".tmp")) {
                    str2 = str2.substring(0, str2.lastIndexOf(".tmp"));
                    w.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", str2, iuVar.fOt.path);
                }
                str = str2;
            } catch (Exception e) {
                str = str2;
            }
            n nVar = this.hZE;
            String str3 = iuVar.fOt.fOu;
            String str4 = iuVar.fOt.fOv;
            int i = iuVar.fOt.fOw;
            String str5 = iuVar.fOt.fOx;
            String str6 = iuVar.fOt.fOz;
            long j = iuVar.fOt.startTime;
            long j2 = iuVar.fOt.endTime;
            h.vL().D(new AnonymousClass2(nVar, str, iuVar.fOt.fOy, str3, str4, i, str5, str6, j, j2, iuVar.fOt.fOA, iuVar.fOt.fOB));
            return false;
        }
    };

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ long hGe;
        final /* synthetic */ n hZE;
        final /* synthetic */ String hZF;
        final /* synthetic */ String[] hZG;
        final /* synthetic */ String hZH;
        final /* synthetic */ int hZI;
        final /* synthetic */ String hZJ;
        final /* synthetic */ String hZK;
        final /* synthetic */ long hZL;
        final /* synthetic */ int hZM;
        final /* synthetic */ int hZN;
        final /* synthetic */ String hld;

        AnonymousClass2(n nVar, String str, String[] strArr, String str2, String str3, int i, String str4, String str5, long j, long j2, int i2, int i3) {
            this.hZE = nVar;
            this.hZF = str;
            this.hZG = strArr;
            this.hld = str2;
            this.hZH = str3;
            this.hZI = i;
            this.hZJ = str4;
            this.hZK = str5;
            this.hGe = j;
            this.hZL = j2;
            this.hZM = i2;
            this.hZN = i3;
        }

        public final void run() {
            com.tencent.mm.plugin.sight.base.a Er = d.Er(this.hZF);
            if (Er == null) {
                w.w("MicroMsg.SubCoreMediaRpt", "get media info is null. %s", this.hZF);
                return;
            }
            int aN = e.aN(this.hZF);
            String str = null;
            if (this.hZG != null) {
                StringBuffer stringBuffer = new StringBuffer();
                for (String append : this.hZG) {
                    stringBuffer.append(append).append("|");
                }
                str = stringBuffer.toString();
            }
            int eg = com.tencent.mm.sdk.platformtools.am.eg(ab.getContext());
            g.Em();
            String iL = b.iL(this.hZF);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(this.hld).append(",").append(this.hZH).append(",");
            stringBuffer2.append(this.hZI).append(",").append(this.hZJ).append(",");
            stringBuffer2.append(this.hZK).append(",").append(eg).append(",");
            stringBuffer2.append(iL).append(",").append(this.hGe).append(",");
            stringBuffer2.append(this.hZL).append(",").append(aN).append(",");
            stringBuffer2.append(Er.lMh).append(",").append(Er.hzY / 1000).append(",");
            stringBuffer2.append(Er.hzL / 1000).append(",").append(Er.nFY).append(",");
            stringBuffer2.append(Er.width).append(",").append(Er.height).append(",");
            stringBuffer2.append(str).append(",").append(Er.ptw).append(",").append(this.hZM).append(",").append(this.hZN);
            w.i("MicroMsg.SubCoreMediaRpt", "download video rpt %s ", stringBuffer2.toString());
            com.tencent.mm.plugin.report.service.g.oUh.A(13795, stringBuffer2.toString());
        }
    }

    class a {
        public String fOz;
        public String gxF;
        final /* synthetic */ n hZE;
        public String hZO;
        public String hZP;
        public String hZQ;
        public int hZR;
        public int hZS;
        public keep_SceneResult hZf;
        public long startTime;
        public String toUser;

        public a(n nVar) {
            this.hZE = nVar;
        }
    }

    public n() {
        com.tencent.mm.sdk.b.a.urY.b(this.hZC);
    }

    public static n KT() {
        return (n) l.o(n.class);
    }

    public final void a(String str, String str2, String str3, String str4, String str5, int i, int i2) {
        a aVar = (a) this.hZB.get(str2);
        if (aVar == null) {
            aVar = new a(this);
        }
        aVar.hZO = str;
        aVar.hZP = str2;
        aVar.toUser = str3;
        aVar.gxF = str4;
        aVar.hZQ = str5;
        aVar.hZS = i;
        aVar.hZR = i2;
        aVar.startTime = bg.Nz();
        this.hZB.put(str2, aVar);
        w.i("MicroMsg.SubCoreMediaRpt", "note video upload path[%s, %s] toUser %s msgSource %s snsInfoId %s sendScene %d cpStatus %d", str, str2, str3, str4, str5, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void a(final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, final String str) {
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null && !bg.mA(str)) {
            h.vL().D(new Runnable(this) {
                final /* synthetic */ n hZE;

                public final void run() {
                    a aVar = (a) this.hZE.hZB.remove(str);
                    if (aVar != null) {
                        int i;
                        com.tencent.mm.plugin.sight.base.a aVar2;
                        int aN = e.aN(aVar.hZP);
                        com.tencent.mm.plugin.sight.base.a Er = d.Er(aVar.hZP);
                        if (bg.mA(aVar.hZO)) {
                            i = aN;
                            aVar2 = Er;
                        } else {
                            com.tencent.mm.plugin.sight.base.a Er2 = d.Er(aVar.hZO);
                            i = e.aN(aVar.hZO);
                            aVar2 = Er2;
                        }
                        if (aVar2 == null || Er == null) {
                            w.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", aVar.hZP);
                            return;
                        }
                        StringBuffer stringBuffer;
                        int eg = com.tencent.mm.sdk.platformtools.am.eg(ab.getContext());
                        long j = com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime != 0 ? com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime : aVar.startTime;
                        long Nz = com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime != 0 ? com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime : bg.Nz();
                        String str = null;
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_usedSvrIps != null) {
                            stringBuffer = new StringBuffer();
                            for (String append : com_tencent_mm_modelcdntran_keep_SceneResult.field_usedSvrIps) {
                                stringBuffer.append(append).append("|");
                            }
                            str = stringBuffer.toString();
                        }
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(aVar.toUser).append(",").append(aVar.gxF).append(",");
                        stringBuffer.append(eg).append(",").append(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId).append(",");
                        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_mp4identifymd5).append(",").append(aVar.hZQ).append(",");
                        stringBuffer.append(j).append(",").append(Nz).append(",");
                        stringBuffer.append(i).append(",").append(aVar2.lMh).append(",");
                        stringBuffer.append(aVar2.hzY / 1000).append(",").append(aVar2.hzL / 1000).append(",");
                        stringBuffer.append(aVar2.nFY).append(",").append(aVar2.width).append(",");
                        stringBuffer.append(aVar2.height).append(",").append(aVar.hZR).append(",");
                        stringBuffer.append(aN).append(",").append(Er.lMh).append(",");
                        stringBuffer.append(Er.hzY / 1000).append(",").append(Er.hzL / 1000).append(",");
                        stringBuffer.append(Er.nFY).append(",").append(Er.width).append(",");
                        stringBuffer.append(Er.height).append(",").append(aVar.hZS).append(",");
                        stringBuffer.append(str).append(",").append(aVar2.ptw).append(",").append(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl);
                        w.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", stringBuffer.toString());
                        com.tencent.mm.plugin.report.service.g.oUh.A(13794, stringBuffer.toString());
                        n.bc(Er.hzY, aVar.hZS);
                    }
                }
            });
        }
    }

    public static void bc(int i, int i2) {
        int i3;
        int i4;
        switch (i2) {
            case 1:
                i3 = 101;
                i4 = MMGIFException.D_GIF_ERR_WRONG_RECORD;
                break;
            case 2:
                i3 = 111;
                i4 = 117;
                break;
            case 4:
                i3 = 131;
                i4 = 137;
                break;
            case 5:
                i3 = 121;
                i4 = 127;
                break;
            default:
                return;
        }
        com.tencent.mm.plugin.report.service.g.oUh.a(422, (long) bg.f((Integer) com.tencent.mm.plugin.report.service.g.a(i / 1000, new int[]{350, 544, 800, 1200, 1600, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN}, i3, i4)), 1, false);
        w.i("MicroMsg.SubCoreMediaRpt", "rptIdkey [%d] bitrate [%d] sendScene [%d]", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
