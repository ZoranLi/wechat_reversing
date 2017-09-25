package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.u.m;

public final class s {
    public static int ccm() {
        if (m.xY()) {
            return R.l.fjc;
        }
        return R.l.cRx;
    }

    public static String ccn() {
        if (m.xY()) {
            return "R";
        }
        if (m.xZ()) {
            return "HK$";
        }
        return "¥";
    }

    public static String fk(Context context) {
        if (m.xY()) {
            return context.getString(R.l.fkq);
        }
        return context.getString(R.l.fkp);
    }

    public static String fl(Context context) {
        if (m.xY()) {
            return context.getString(R.l.ffd);
        }
        return context.getString(R.l.ffc);
    }

    public static int cco() {
        if (m.xY()) {
            return R.i.drh;
        }
        return R.i.dqx;
    }

    public static int ccp() {
        if (m.xY()) {
            return R.l.fer;
        }
        return R.l.feq;
    }

    public static int ccq() {
        if (m.xY()) {
            return R.i.dab;
        }
        return R.i.daa;
    }
}
