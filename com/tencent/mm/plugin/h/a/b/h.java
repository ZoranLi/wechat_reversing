package com.tencent.mm.plugin.h.a.b;

import java.util.HashMap;

public final class h {
    public static String jSA = "00002a9e-0000-1000-8000-00805f9b34fb";
    public static String jSB = "00002a9d-0000-1000-8000-00805f9b34fb";
    public static String jSC = "0000180d-0000-1000-8000-00805f9b34fb";
    public static String jSD = "00002a37-0000-1000-8000-00805f9b34fb";
    public static String jSE = "00002a38-0000-1000-8000-00805f9b34fb";
    public static String jSF = "00002a39-0000-1000-8000-00805f9b34fb";
    public static String jSG = "00001810-0000-1000-8000-00805f9b34fb";
    public static String jSH = "00002a35-0000-1000-8000-00805f9b34fb";
    public static String jSI = "00002a36-0000-1000-8000-00805f9b34fb";
    public static String jSJ = "00002a49-0000-1000-8000-00805f9b34fb";
    public static HashMap<String, String> jSK;
    public static String jSp = "00002902-0000-1000-8000-00805f9b34fb";
    public static String jSq = "0000fee7-0000-1000-8000-00805f9b34fb";
    public static String jSr = "0000fec7-0000-1000-8000-00805f9b34fb";
    public static String jSs = "0000fec8-0000-1000-8000-00805f9b34fb";
    public static String jSt = "0000fea1-0000-1000-8000-00805f9b34fb";
    public static String jSu = "0000fea2-0000-1000-8000-00805f9b34fb";
    public static String jSv = "0000feb1-0000-1000-8000-00805f9b34fb";
    public static String jSw = "0000feb2-0000-1000-8000-00805f9b34fb";
    public static String jSx = "0000feb3-0000-1000-8000-00805f9b34fb";
    public static String jSy = "0000feb4-0000-1000-8000-00805f9b34fb";
    public static String jSz = "0000181d-0000-1000-8000-00805f9b34fb";

    static {
        HashMap hashMap = new HashMap();
        jSK = hashMap;
        hashMap.put(jSr, "airsync send characteristic. permission: (write)");
        jSK.put(jSs, "airsync recv characteristic. permission: (indicate)");
        jSK.put(jSt, "simple step measurement characteristic. permission: ((read)(indicate|notify))");
        jSK.put(jSu, "airsync recv characteristic. permission: [(read)[write][indicate]]");
    }
}
