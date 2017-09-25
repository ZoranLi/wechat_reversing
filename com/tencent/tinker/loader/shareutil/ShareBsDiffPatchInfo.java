package com.tencent.tinker.loader.shareutil;

import java.util.ArrayList;

public class ShareBsDiffPatchInfo {
    public String fFW;
    public String fvo;
    public String name;
    public String path;
    public String xhz;

    private ShareBsDiffPatchInfo(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.fFW = str2;
        this.xhz = str4;
        this.fvo = str5;
        this.path = str3;
    }

    public static void j(String str, ArrayList<ShareBsDiffPatchInfo> arrayList) {
        if (str != null && str.length() != 0) {
            for (String str2 : str.split("\n")) {
                if (str2 != null && str2.length() > 0) {
                    String[] split = str2.split(",", 5);
                    if (split != null && split.length >= 5) {
                        arrayList.add(new ShareBsDiffPatchInfo(split[0].trim(), split[2].trim(), split[1].trim(), split[3].trim(), split[4].trim()));
                    }
                }
            }
        }
    }

    public static boolean a(ShareBsDiffPatchInfo shareBsDiffPatchInfo) {
        if (shareBsDiffPatchInfo == null) {
            return false;
        }
        String str = shareBsDiffPatchInfo.name;
        String str2 = shareBsDiffPatchInfo.fFW;
        if (str == null || str.length() <= 0 || str2 == null || str2.length() != 32) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.name);
        stringBuffer.append(",");
        stringBuffer.append(this.path);
        stringBuffer.append(",");
        stringBuffer.append(this.fFW);
        stringBuffer.append(",");
        stringBuffer.append(this.xhz);
        stringBuffer.append(",");
        stringBuffer.append(this.fvo);
        return stringBuffer.toString();
    }
}
