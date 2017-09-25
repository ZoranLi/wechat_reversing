package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.util.Base64;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.protocal.c.bff;
import com.tencent.mm.protocal.c.bfg;
import com.tencent.mm.protocal.c.bfh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
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

    public b(bfh com_tencent_mm_protocal_c_bfh) {
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

    public final boolean aDo() {
        Context context = ab.getContext();
        if (!am.isConnected(context)) {
            return false;
        }
        if (this.mLN.intValue() == 1 || this.mLN.intValue() != 3) {
            return true;
        }
        return am.isWifi(context);
    }

    public final boolean aDp() {
        return this.mLK.intValue() == 2 || this.mLK.intValue() == 4;
    }

    public final boolean aDq() {
        if (this.mLL == null || this.mLL.isEmpty() || !this.mLL.containsKey(Integer.valueOf(4))) {
            return false;
        }
        return true;
    }

    private static String a(HashMap<Integer, LinkedList<anc>> hashMap, int i) {
        if (hashMap == null || hashMap.isEmpty()) {
            return "";
        }
        String str = "";
        LinkedList linkedList = (LinkedList) hashMap.get(Integer.valueOf(i));
        if (linkedList == null || linkedList.isEmpty()) {
            return str;
        }
        int size = linkedList.size();
        int i2 = 0;
        while (i2 < size) {
            String str2;
            anc com_tencent_mm_protocal_c_anc = (anc) linkedList.get(i2);
            if (com_tencent_mm_protocal_c_anc.lang.equalsIgnoreCase("default")) {
                str2 = new String(Base64.decode(com_tencent_mm_protocal_c_anc.content, 0));
            } else if (com_tencent_mm_protocal_c_anc.lang.equalsIgnoreCase(v.bIN())) {
                return new String(Base64.decode(com_tencent_mm_protocal_c_anc.content, 0));
            } else {
                str2 = str;
            }
            i2++;
            str = str2;
        }
        return str;
    }

    public final String aDr() {
        if (aDq()) {
            return a(this.mLL, 4);
        }
        return "";
    }

    public final String aDs() {
        if (aDq()) {
            return a(this.mLL, 1);
        }
        return "";
    }

    public final String aDt() {
        if (aDq()) {
            return a(this.mLL, 2);
        }
        return "";
    }

    public final String toString() {
        return "responseState:" + this.mLK + "\ncdnUrl:" + this.mLO + "\nfileMd5:" + this.mLP + "\npackageType:" + this.mLM + "\nnetworkType:" + this.mLN + "\npatchId:" + this.mLQ;
    }
}
