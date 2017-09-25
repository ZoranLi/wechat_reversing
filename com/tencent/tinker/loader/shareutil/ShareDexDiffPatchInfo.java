package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.util.ArrayList;

public class ShareDexDiffPatchInfo {
    public final String gTY;
    public final String path;
    public final String xhB;
    public final String xhC;
    public final String xhD;
    public final String xhE;
    public final String xhF;
    public final String xhG;
    public final String xhH;
    public final boolean xhI;

    public ShareDexDiffPatchInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.xhB = str;
        this.path = str2;
        this.xhC = str3;
        this.xhD = str4;
        this.xhG = str5;
        this.xhE = str6;
        this.xhF = str7;
        this.xhH = str8;
        if (str8.equals("jar")) {
            this.xhI = true;
            if (SharePatchFileUtil.VV(str)) {
                this.gTY = str + ".jar";
            } else {
                this.gTY = str;
            }
        } else if (str8.equals("raw")) {
            this.xhI = false;
            this.gTY = str;
        } else {
            throw new TinkerRuntimeException("can't recognize dex mode:" + str8);
        }
    }

    public static void k(String str, ArrayList<ShareDexDiffPatchInfo> arrayList) {
        if (str != null && str.length() != 0) {
            for (String str2 : str.split("\n")) {
                if (str2 != null && str2.length() > 0) {
                    String[] split = str2.split(",", 8);
                    if (split != null && split.length >= 8) {
                        arrayList.add(new ShareDexDiffPatchInfo(split[0].trim(), split[1].trim(), split[2].trim(), split[3].trim(), split[4].trim(), split[5].trim(), split[6].trim(), split[7].trim()));
                    }
                }
            }
        }
    }

    public static boolean c(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (shareDexDiffPatchInfo == null) {
            return false;
        }
        String str = shareDexDiffPatchInfo.xhB;
        String str2 = ShareTinkerInternals.cgV() ? shareDexDiffPatchInfo.xhD : shareDexDiffPatchInfo.xhC;
        if (str == null || str.length() <= 0 || str2 == null || str2.length() != 32) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.xhB);
        stringBuffer.append(",");
        stringBuffer.append(this.path);
        stringBuffer.append(",");
        stringBuffer.append(this.xhC);
        stringBuffer.append(",");
        stringBuffer.append(this.xhD);
        stringBuffer.append(",");
        stringBuffer.append(this.xhE);
        stringBuffer.append(",");
        stringBuffer.append(this.xhF);
        stringBuffer.append(",");
        stringBuffer.append(this.xhG);
        stringBuffer.append(",");
        stringBuffer.append(this.xhH);
        return stringBuffer.toString();
    }
}
