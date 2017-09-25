package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.d;

public class a {
    private static a xjy = null;
    private f xjz = null;

    public static a chf() {
        if (xjy == null) {
            synchronized (a.class) {
                if (xjy == null) {
                    xjy = new a();
                }
            }
        }
        return xjy;
    }

    public static f chg() {
        a chf = chf();
        if (chf.xjz == null) {
            synchronized (a.class) {
                if (chf.xjz == null) {
                    chf.xjz = new f();
                }
            }
        }
        return chf.xjz;
    }

    public static void chh() {
        d.d("MicroMsg.Voip", "registerEvents");
        chg();
    }
}
