package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.a.e;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.favorite.b.x.a;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.Iterator;

public final class q implements a {
    public boolean lEn = true;

    public final boolean g(j jVar) {
        if (jVar == null) {
            return true;
        }
        if (x.u(jVar)) {
            return true;
        }
        rm n;
        ru ruVar;
        switch (jVar.field_type) {
            case 1:
                return bg.mA(jVar.field_favProto.desc);
            case 2:
            case 8:
                return !new File(x.g(x.n(jVar))).exists();
            case 3:
                if (this.lEn) {
                    return true;
                }
                return false;
            case 4:
                n = x.n(jVar);
                if (new File(x.g(n)).exists()) {
                    return false;
                }
                return bg.mA(n.txp);
            case 5:
                rw rwVar = jVar.field_favProto.tzl;
                sf sfVar = jVar.field_favProto.tyy;
                String str = null;
                if (sfVar != null) {
                    str = sfVar.tzN;
                }
                if (rwVar != null && bg.mA(r0)) {
                    str = rwVar.hSX;
                }
                return bg.mA(str);
            case 6:
                return jVar.field_favProto.tyw == null;
            case 7:
                n = x.n(jVar);
                return bg.mA(n.txp) && bg.mA(n.txr) && bg.mA(n.txt) && bg.mA(n.txt);
            case 10:
                ruVar = jVar.field_favProto.tyA;
                return ruVar == null || bg.mA(ruVar.info);
            case 11:
                ruVar = jVar.field_favProto.tyA;
                return ruVar == null || bg.mA(ruVar.info);
            case 14:
            case 18:
                if (jVar.field_id <= 0) {
                    return true;
                }
                if (jVar.field_type == 18 && (jVar.field_favProto == null || jVar.field_favProto.tzn.size() <= 1)) {
                    return true;
                }
                if (jVar.field_type == 18 && (bg.mA(((rm) jVar.field_favProto.tzn.get(0)).txi) || bg.mA(((rm) jVar.field_favProto.tzn.get(0)).txk))) {
                    return true;
                }
                Iterator it = jVar.field_favProto.tzn.iterator();
                while (it.hasNext()) {
                    n = (rm) it.next();
                    if ((n.aMw == 2 || n.aMw == 8 || n.aMw == 15 || n.aMw == 4) && !e.aO(x.g(n))) {
                        return true;
                    }
                }
                return false;
            case 15:
                rz rzVar = jVar.field_favProto.tyC;
                return rzVar == null || bg.mA(rzVar.info);
            case 16:
                if (bg.PY(g.sV().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    w.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return true;
                }
                n = x.n(jVar);
                File file = new File(x.g(n));
                w.v("MicroMsg.FavSendFilter", "type size, favid %d, localid %d, path %s, exist %B", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId), file.getAbsolutePath(), Boolean.valueOf(file.exists())});
                if (!file.exists()) {
                    return true;
                }
                if (Math.abs(n.txD - file.length()) <= 16) {
                    return false;
                }
                String f = com.tencent.mm.a.g.f(file);
                w.w("MicroMsg.FavSendFilter", "it can not retransmit short video because of file was replaced. file[%d, %s], data[%d, %s]", new Object[]{Long.valueOf(r2), f, Long.valueOf(r4), n.txz});
                return true;
            default:
                return false;
        }
    }

    public static boolean b(rm rmVar) {
        if (rmVar == null) {
            return true;
        }
        switch (rmVar.aMw) {
            case 2:
            case 8:
                if (new File(x.g(rmVar)).exists()) {
                    return false;
                }
                return true;
            case 3:
                return true;
            case 4:
                if (new File(x.g(rmVar)).exists()) {
                    return false;
                }
                return bg.mA(rmVar.txp);
            case 7:
                if (bg.mA(rmVar.txp) && bg.mA(rmVar.txr) && bg.mA(rmVar.txt) && bg.mA(rmVar.txt)) {
                    return true;
                }
                return false;
            case 15:
                if (bg.PY(g.sV().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    w.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return true;
                } else if (new File(x.g(rmVar)).exists()) {
                    return false;
                } else {
                    return true;
                }
            default:
                return false;
        }
    }

    public static boolean h(j jVar) {
        if (jVar == null) {
            return false;
        }
        if (!x.s(jVar)) {
            return false;
        }
        File file = new File(x.g(x.n(jVar)));
        switch (jVar.field_type) {
            case 2:
            case 8:
                if (!file.exists()) {
                    return true;
                }
                break;
            case 4:
                if (bg.mA(x.n(jVar).txp) && !file.exists()) {
                    return true;
                }
            case 14:
            case 18:
                if (jVar.field_id > 0) {
                    if (jVar.field_favProto != null && jVar.field_favProto.tzn.size() > 1) {
                        Iterator it = jVar.field_favProto.tzn.iterator();
                        while (it.hasNext()) {
                            rm rmVar = (rm) it.next();
                            if (!bg.mA(rmVar.txi) && !bg.mA(rmVar.txk) && !e.aO(x.g(rmVar))) {
                                return true;
                            }
                        }
                        break;
                    }
                    return false;
                }
                return false;
            case 16:
                if (bg.PY(g.sV().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    w.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return false;
                } else if (!file.exists()) {
                    return true;
                }
                break;
        }
        return false;
    }
}
