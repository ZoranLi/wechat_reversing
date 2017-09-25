package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.sdk.platformtools.w;

public final class c implements a {
    static {
        b.a(new c(), "//normsg");
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        if (!com.tencent.mm.sdk.a.b.bIu()) {
            return false;
        }
        if (strArr.length < 2) {
            return false;
        }
        int intValue;
        String toLowerCase;
        long nanoTime;
        int i;
        CharSequence l;
        long nanoTime2;
        try {
            if (strArr.length >= 3) {
                intValue = Integer.valueOf(strArr[2]).intValue();
                toLowerCase = strArr[1].toLowerCase();
                nanoTime = System.nanoTime();
                i = -1;
                switch (toLowerCase.hashCode()) {
                    case -1422437344:
                        if (toLowerCase.equals("testrpp")) {
                            i = 8;
                            break;
                        }
                        break;
                    case -625689748:
                        if (toLowerCase.equals("checksofttype")) {
                            boolean z = true;
                            break;
                        }
                        break;
                    case 1078188459:
                        if (toLowerCase.equals("checkmsglevel")) {
                            i = 0;
                            break;
                        }
                        break;
                    case 2078454342:
                        if (toLowerCase.equals("checksofttype2")) {
                            i = 2;
                            break;
                        }
                        break;
                    case 2078454343:
                        if (toLowerCase.equals("checksofttype3")) {
                            i = 3;
                            break;
                        }
                        break;
                    case 2078454344:
                        if (toLowerCase.equals("checksofttype4")) {
                            i = 4;
                            break;
                        }
                        break;
                    case 2078454345:
                        if (toLowerCase.equals("checksofttype5")) {
                            i = 5;
                            break;
                        }
                        break;
                    case 2078454346:
                        if (toLowerCase.equals("checksofttype6")) {
                            i = 6;
                            break;
                        }
                        break;
                    case 2078454347:
                        if (toLowerCase.equals("checksofttype7")) {
                            i = 7;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        com.tencent.mm.plugin.normsg.a.c.nZz.qy(intValue);
                        break;
                    case 1:
                        com.tencent.mm.plugin.normsg.a.c.nZz.qz(intValue);
                        break;
                    case 2:
                        com.tencent.mm.plugin.normsg.a.c.nZz.qA(intValue);
                        break;
                    case 3:
                        com.tencent.mm.plugin.normsg.a.c.nZz.qB(intValue);
                        break;
                    case 4:
                        com.tencent.mm.plugin.normsg.a.c.nZz.qC(intValue);
                        break;
                    case 5:
                        com.tencent.mm.plugin.normsg.a.c.nZz.qD(intValue);
                        break;
                    case 6:
                        com.tencent.mm.plugin.normsg.a.c.nZz.qE(intValue);
                        break;
                    case 7:
                        com.tencent.mm.plugin.normsg.a.c.nZz.qF(intValue);
                        break;
                    case 8:
                        l = d.nZC.l(true, true);
                        com.tencent.mm.plugin.secinforeport.a.b.phI.Ea(l);
                        com.tencent.mm.plugin.secinforeport.a.b.phI.bC(l, 0);
                        com.tencent.mm.pluginsdk.j.d.a(context, "normsg", l);
                        Toast.makeText(context, "result is copied to clipboard.", 0).show();
                        break;
                    default:
                        return false;
                }
                nanoTime2 = System.nanoTime() - nanoTime;
                l = String.format("[NorMsgTest] cmd: %s, time: %d ns.", new Object[]{strArr[1], Long.valueOf(nanoTime2)});
                w.i("MicroMsg.NorMsgTest", l);
                Toast.makeText(context, l, 0).show();
                return true;
            }
        } catch (Exception e) {
        }
        intValue = 1;
        toLowerCase = strArr[1].toLowerCase();
        nanoTime = System.nanoTime();
        i = -1;
        switch (toLowerCase.hashCode()) {
            case -1422437344:
                if (toLowerCase.equals("testrpp")) {
                    i = 8;
                    break;
                }
                break;
            case -625689748:
                if (toLowerCase.equals("checksofttype")) {
                    boolean z2 = true;
                    break;
                }
                break;
            case 1078188459:
                if (toLowerCase.equals("checkmsglevel")) {
                    i = 0;
                    break;
                }
                break;
            case 2078454342:
                if (toLowerCase.equals("checksofttype2")) {
                    i = 2;
                    break;
                }
                break;
            case 2078454343:
                if (toLowerCase.equals("checksofttype3")) {
                    i = 3;
                    break;
                }
                break;
            case 2078454344:
                if (toLowerCase.equals("checksofttype4")) {
                    i = 4;
                    break;
                }
                break;
            case 2078454345:
                if (toLowerCase.equals("checksofttype5")) {
                    i = 5;
                    break;
                }
                break;
            case 2078454346:
                if (toLowerCase.equals("checksofttype6")) {
                    i = 6;
                    break;
                }
                break;
            case 2078454347:
                if (toLowerCase.equals("checksofttype7")) {
                    i = 7;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                com.tencent.mm.plugin.normsg.a.c.nZz.qy(intValue);
                break;
            case 1:
                com.tencent.mm.plugin.normsg.a.c.nZz.qz(intValue);
                break;
            case 2:
                com.tencent.mm.plugin.normsg.a.c.nZz.qA(intValue);
                break;
            case 3:
                com.tencent.mm.plugin.normsg.a.c.nZz.qB(intValue);
                break;
            case 4:
                com.tencent.mm.plugin.normsg.a.c.nZz.qC(intValue);
                break;
            case 5:
                com.tencent.mm.plugin.normsg.a.c.nZz.qD(intValue);
                break;
            case 6:
                com.tencent.mm.plugin.normsg.a.c.nZz.qE(intValue);
                break;
            case 7:
                com.tencent.mm.plugin.normsg.a.c.nZz.qF(intValue);
                break;
            case 8:
                l = d.nZC.l(true, true);
                com.tencent.mm.plugin.secinforeport.a.b.phI.Ea(l);
                com.tencent.mm.plugin.secinforeport.a.b.phI.bC(l, 0);
                com.tencent.mm.pluginsdk.j.d.a(context, "normsg", l);
                Toast.makeText(context, "result is copied to clipboard.", 0).show();
                break;
            default:
                return false;
        }
        nanoTime2 = System.nanoTime() - nanoTime;
        l = String.format("[NorMsgTest] cmd: %s, time: %d ns.", new Object[]{strArr[1], Long.valueOf(nanoTime2)});
        w.i("MicroMsg.NorMsgTest", l);
        Toast.makeText(context, l, 0).show();
        return true;
    }
}
