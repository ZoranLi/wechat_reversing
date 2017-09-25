package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

public final class d {
    public static Context mContext;
    private static final HashMap<String, Integer> roP;
    public Object roQ = new Object();
    public ToneGenerator roR;
    private final int roS = 250;

    static {
        HashMap hashMap = new HashMap();
        roP = hashMap;
        hashMap.put("1", Integer.valueOf(1));
        roP.put("2", Integer.valueOf(2));
        roP.put(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, Integer.valueOf(3));
        roP.put("4", Integer.valueOf(4));
        roP.put("5", Integer.valueOf(5));
        roP.put("6", Integer.valueOf(6));
        roP.put("7", Integer.valueOf(7));
        roP.put("8", Integer.valueOf(8));
        roP.put("9", Integer.valueOf(9));
        roP.put("0", Integer.valueOf(0));
        roP.put("#", Integer.valueOf(11));
        roP.put("*", Integer.valueOf(10));
    }

    public d(Context context) {
        mContext = context;
        if (context != null) {
            try {
                synchronized (this.roQ) {
                    if (brw() && this.roR == null) {
                        this.roR = new ToneGenerator(3, 66);
                    }
                }
            } catch (Exception e) {
                w.d("MicroMsg.DTMFToneGenerator", "获取音频发生器单例失败！！！");
                w.d("MicroMsg.DTMFToneGenerator", e.getMessage());
                this.roR = null;
            }
        }
    }

    private d() {
    }

    public static boolean brw() {
        return System.getInt(mContext.getContentResolver(), "dtmf_tone", 1) == 1;
    }

    public static int HH(String str) {
        if (str == null || str.equals("") || !roP.containsKey(str)) {
            return -1;
        }
        return ((Integer) roP.get(str)).intValue();
    }
}
