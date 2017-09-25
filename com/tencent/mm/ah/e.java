package com.tencent.mm.ah;

public final class e {
    public static d a(d dVar) {
        if (dVar == null) {
            return null;
        }
        if (!dVar.GB()) {
            return dVar;
        }
        d fT = n.GS().fT(dVar.hFi);
        if (fT != null) {
            return fT;
        }
        return dVar;
    }

    public static boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        int i = dVar.offset;
        int i2 = dVar.hrs;
        long j = dVar.fTQ;
        if (dVar.GB()) {
            d fT = n.GS().fT(dVar.hFi);
            i = fT.offset;
            i2 = fT.hrs;
            j = fT.fTQ;
        }
        if (i2 == 0) {
            return true;
        }
        if ((i != i2 || i2 == 0) && r2 == 0) {
            return false;
        }
        return true;
    }

    public static String c(d dVar) {
        if (dVar == null) {
            return "";
        }
        if (!dVar.GB()) {
            return dVar.hEZ;
        }
        d fT = n.GS().fT(dVar.hFi);
        if (fT == null) {
            return "";
        }
        return fT.hEZ;
    }
}
