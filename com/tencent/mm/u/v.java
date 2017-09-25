package com.tencent.mm.u;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.x;

public final class v {
    private c hlP;

    public v(c cVar) {
        this.hlP = cVar;
    }

    static int a(boolean z, String str, boolean z2) {
        int i = 3;
        a Rc = c.wR().Rc(str);
        if (Rc == null) {
            Rc = new x();
        }
        if (((int) Rc.gTQ) == 0) {
            Rc.setUsername(str);
            Rc.tc();
            x(Rc);
            if (z2) {
                i = 4;
            }
            Rc.dh(i);
            Rc.tl();
            c.wR().R(Rc);
            return 1;
        } else if (!z) {
            return 3;
        } else {
            Rc.tl();
            c.wR().a(str, Rc);
            return 2;
        }
    }

    public static void w(x xVar) {
        if (xVar == null) {
            xVar = new x();
        }
        if (((int) xVar.gTQ) == 0) {
            xVar.setUsername("filehelper");
            ap.yY();
            if (c.wW().Rm(xVar.field_username) == null) {
                xVar.td();
            } else {
                xVar.tc();
            }
            xVar.dh(3);
            ap.yY();
            c.wR().Q(xVar);
        }
    }

    static void x(x xVar) {
        String str = xVar.field_username;
        Context context = ab.getContext();
        if (str.equals("qqsync")) {
            xVar.bR(context.getString(R.l.erQ));
            xVar.bS(context.getString(R.l.erR));
            xVar.bT(context.getString(R.l.erS));
        }
        if (str.equals("floatbottle")) {
            xVar.bR(context.getString(R.l.eqZ));
            xVar.bS(context.getString(R.l.era));
            xVar.bT(context.getString(R.l.erb));
        }
        if (str.equals("shakeapp")) {
            xVar.bR(context.getString(R.l.erX));
            xVar.bS(context.getString(R.l.erY));
            xVar.bT(context.getString(R.l.erZ));
        }
        if (str.equals("lbsapp")) {
            xVar.bR(context.getString(R.l.err));
            xVar.bS(context.getString(R.l.ers));
            xVar.bT(context.getString(R.l.ert));
        }
        if (str.equals("medianote")) {
            xVar.bR(context.getString(R.l.erA));
            xVar.bS(context.getString(R.l.erB));
            xVar.bT(context.getString(R.l.erC));
        }
        if (str.equals("newsapp")) {
            xVar.bR(context.getString(R.l.erT));
            xVar.bS(context.getString(R.l.erU));
            xVar.bT(context.getString(R.l.erV));
        }
        if (str.equals("facebookapp")) {
            xVar.bR(context.getString(R.l.erf));
            xVar.bS(context.getString(R.l.erg));
            xVar.bT(context.getString(R.l.erh));
        }
        if (str.equals("qqfriend")) {
            xVar.bR(context.getString(R.l.erK));
            xVar.bS(context.getString(R.l.erL));
            xVar.bT(context.getString(R.l.erM));
        }
        if (str.equals("masssendapp")) {
            xVar.bR(context.getString(R.l.erx));
            xVar.bS(context.getString(R.l.ery));
            xVar.bT(context.getString(R.l.erz));
        }
        if (str.equals("feedsapp")) {
            xVar.bR(context.getString(R.l.eri));
            xVar.bS(context.getString(R.l.erj));
            xVar.bT(context.getString(R.l.erk));
        }
        if (str.equals("fmessage")) {
            xVar.bR(context.getString(R.l.erl));
            xVar.bS(context.getString(R.l.erm));
            xVar.bT(context.getString(R.l.ern));
        }
        if (str.equals("voipapp")) {
            xVar.bR(context.getString(R.l.ese));
            xVar.bS(context.getString(R.l.esf));
            xVar.bT(context.getString(R.l.esg));
        }
        if (str.equals("officialaccounts")) {
            xVar.bR(context.getString(R.l.erH));
            xVar.bS(context.getString(R.l.erI));
            xVar.bT(context.getString(R.l.erJ));
        }
        if (str.equals("helper_entry")) {
            xVar.bR(context.getString(R.l.ero));
            xVar.bS(context.getString(R.l.erp));
            xVar.bT(context.getString(R.l.erq));
        }
        if (str.equals("cardpackage")) {
            xVar.bR(context.getString(R.l.erc));
            xVar.bS(context.getString(R.l.erd));
            xVar.bT(context.getString(R.l.ere));
        }
        if (str.equals("voicevoipapp")) {
            xVar.bR(context.getString(R.l.esh));
            xVar.bS(context.getString(R.l.esi));
            xVar.bT(context.getString(R.l.esj));
        }
        if (str.equals("voiceinputapp")) {
            xVar.bR(context.getString(R.l.esb));
            xVar.bS(context.getString(R.l.esc));
            xVar.bT(context.getString(R.l.esd));
        }
        if (str.equals("qqmail")) {
            xVar.bR(context.getString(R.l.erN));
            xVar.bS(context.getString(R.l.erO));
            xVar.bT(context.getString(R.l.erP));
        }
        if (str.equals("linkedinplugin")) {
            xVar.bR(context.getString(R.l.eru));
            xVar.bS(context.getString(R.l.erv));
            xVar.bT(context.getString(R.l.erw));
        }
        if (str.equals("notifymessage")) {
            xVar.bR(context.getString(R.l.erE));
            xVar.bS(context.getString(R.l.erF));
            xVar.bT(context.getString(R.l.erG));
        }
        if (str.equals("appbrandcustomerservicemsg")) {
            xVar.bR(context.getString(R.l.eqW));
            xVar.bS(context.getString(R.l.eqX));
            xVar.bT(context.getString(R.l.eqY));
        }
    }
}
