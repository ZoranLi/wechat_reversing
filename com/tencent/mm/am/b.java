package com.tencent.mm.am;

import com.tencent.mm.e.a.jb;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.b.a;

public final class b {
    public static final void qP() {
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = 1;
        a.urY.m(jbVar);
    }

    public static final void qQ() {
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = 2;
        a.urY.m(jbVar);
    }

    public static final void HH() {
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = -1;
        a.urY.m(jbVar);
    }

    public static final void HI() {
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = 11;
        a.urY.m(jbVar);
    }

    public static final void a(anf com_tencent_mm_protocal_c_anf) {
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = 6;
        jbVar.fOW.fOY = com_tencent_mm_protocal_c_anf;
        a.urY.m(jbVar);
    }

    public static boolean HJ() {
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = -3;
        a.urY.m(jbVar);
        return jbVar.fOX.fDU;
    }

    public static boolean HK() {
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = 9;
        a.urY.m(jbVar);
        return jbVar.fOX.fDU;
    }

    public static anf HL() {
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = -2;
        a.urY.m(jbVar);
        return jbVar.fOX.fOY;
    }

    public static void b(anf com_tencent_mm_protocal_c_anf) {
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = 0;
        jbVar.fOW.fOY = com_tencent_mm_protocal_c_anf;
        a.urY.m(jbVar);
    }

    public static void c(anf com_tencent_mm_protocal_c_anf) {
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = 3;
        jbVar.fOW.fOY = com_tencent_mm_protocal_c_anf;
        a.urY.m(jbVar);
    }

    public static boolean d(anf com_tencent_mm_protocal_c_anf) {
        if (com_tencent_mm_protocal_c_anf == null) {
            return false;
        }
        switch (com_tencent_mm_protocal_c_anf.tRH) {
            case 1:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean gi(int i) {
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = 7;
        jbVar.fOW.position = i;
        a.urY.m(jbVar);
        return jbVar.fOX.fDU;
    }

    public static d HM() {
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = 8;
        a.urY.m(jbVar);
        return jbVar.fOX.fPb;
    }
}
