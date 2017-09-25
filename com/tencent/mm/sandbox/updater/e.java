package com.tencent.mm.sandbox.updater;

import com.tencent.mm.b.i;
import com.tencent.mm.b.i.a;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.protocal.c.bff;
import com.tencent.mm.protocal.c.bfg;
import com.tencent.mm.protocal.c.bfh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
    public final int fileSize;
    public final Integer mLK;
    public HashMap<Integer, LinkedList<anc>> mLL = new HashMap();
    public final Integer mLM;
    public final Integer mLN;
    public final String mLO;
    public final String mLP;
    public final String mLQ;
    public String mLR;
    public String mLS;
    public int versionCode;

    public e(bfh com_tencent_mm_protocal_c_bfh) {
        if (com_tencent_mm_protocal_c_bfh == null) {
            this.mLK = Integer.valueOf(1);
            this.mLO = "";
            this.mLP = "";
            this.mLM = Integer.valueOf(-1);
            this.mLN = Integer.valueOf(-1);
            this.mLQ = "";
            this.fileSize = 0;
            this.mLR = "";
            this.mLS = "";
            this.versionCode = 0;
            return;
        }
        if (com_tencent_mm_protocal_c_bfh.ufR != null) {
            this.mLP = com_tencent_mm_protocal_c_bfh.ufR.tuy;
            this.mLO = com_tencent_mm_protocal_c_bfh.ufR.msN;
            this.fileSize = com_tencent_mm_protocal_c_bfh.ufR.tsR;
        } else {
            this.mLP = "";
            this.mLO = "";
            this.fileSize = 0;
        }
        this.mLK = Integer.valueOf(com_tencent_mm_protocal_c_bfh.state);
        this.mLN = Integer.valueOf(com_tencent_mm_protocal_c_bfh.ufQ);
        if (!(com_tencent_mm_protocal_c_bfh.ufO == null || com_tencent_mm_protocal_c_bfh.ufO.isEmpty())) {
            int size = com_tencent_mm_protocal_c_bfh.ufO.size();
            for (int i = 0; i < size; i++) {
                bfg com_tencent_mm_protocal_c_bfg = (bfg) com_tencent_mm_protocal_c_bfh.ufO.get(i);
                if (!(com_tencent_mm_protocal_c_bfg.ufN == null || com_tencent_mm_protocal_c_bfg.ufN.isEmpty())) {
                    this.mLL.put(Integer.valueOf(com_tencent_mm_protocal_c_bfg.type), com_tencent_mm_protocal_c_bfg.ufN);
                }
            }
        }
        this.mLM = Integer.valueOf(com_tencent_mm_protocal_c_bfh.ufP);
        this.mLQ = com_tencent_mm_protocal_c_bfh.trp;
        if (com_tencent_mm_protocal_c_bfh.ufT == null || com_tencent_mm_protocal_c_bfh.ufT.isEmpty()) {
            this.mLR = "";
            this.mLS = "";
            this.versionCode = 0;
            return;
        }
        Iterator it = com_tencent_mm_protocal_c_bfh.ufT.iterator();
        while (it.hasNext()) {
            bff com_tencent_mm_protocal_c_bff = (bff) it.next();
            if (!(com_tencent_mm_protocal_c_bff == null || bg.mA(com_tencent_mm_protocal_c_bff.arH))) {
                if (com_tencent_mm_protocal_c_bff.arH.equalsIgnoreCase("newApkMd5")) {
                    this.mLR = com_tencent_mm_protocal_c_bff.value;
                } else if (com_tencent_mm_protocal_c_bff.arH.equalsIgnoreCase("oldApkMd5")) {
                    this.mLS = com_tencent_mm_protocal_c_bff.value;
                } else if (com_tencent_mm_protocal_c_bff.arH.equalsIgnoreCase(DownloadInfoColumns.VERSIONCODE)) {
                    this.versionCode = bg.PY(com_tencent_mm_protocal_c_bff.value);
                }
            }
        }
    }

    public final String bHX() {
        String substring = this.mLO.substring(0, this.mLO.lastIndexOf(47) + 1);
        String substring2 = this.mLO.substring(this.mLO.lastIndexOf(47) + 1);
        i iVar = new i(substring, Integer.valueOf(this.versionCode).intValue());
        iVar.a(new a(this.mLS, this.mLR, this.mLP, substring2, this.fileSize));
        return iVar.nX();
    }

    public final String toString() {
        return "responseState:" + this.mLK + "\ncdnUrl:" + this.mLO + "\nfileMd5:" + this.mLP + "\npackageType:" + this.mLM + "\nnetworkType:" + this.mLN + "\npatchId:" + this.mLQ;
    }
}
