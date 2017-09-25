package com.tencent.mm.modelfriend;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public static final HashSet<b> hAh = new HashSet();
    private static final b hAi = new b() {
        public final void bg(boolean z) {
            w.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", Boolean.valueOf(z));
            if (z) {
                System.currentTimeMillis();
                ap.vd().a(new aa(m.Fs(), m.Fr()), 0);
            }
        }
    };
    public static Thread thread = null;

    private static class a implements Runnable {
        public static boolean hAc = false;
        private static byte[] hAl = new byte[0];
        private static final ae hAr = new ae(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                if (ap.zb()) {
                    com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                    int size = a.hAh.size();
                    boolean parseBoolean = Boolean.parseBoolean(message.obj.toString());
                    Iterator it = a.hAh.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).bg(parseBoolean);
                    }
                    a.hAh.clear();
                    w.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", Integer.valueOf(size), Long.valueOf(aVar.se()));
                }
            }
        };
        private List<String[]> hAm;
        private List<String[]> hAn;
        private List<b> hAo;
        private List<b> hAp;
        private be hAq;

        private static List<b> a(List<b> list, int i, int i2) {
            List<b> linkedList = new LinkedList();
            while (i < i2) {
                linkedList.add(list.get(i));
                i++;
            }
            return linkedList;
        }

        public final void run() {
            synchronized (hAl) {
                this.hAq = new be("MicroMsg.AddrBookSyncHelper", "sync addrBook");
                this.hAq.addSplit("sync begin");
                w.d("MicroMsg.AddrBookSyncHelper", "reading email info");
                this.hAm = com.tencent.mm.pluginsdk.a.do(ab.getContext());
                if (this.hAm != null) {
                    w.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.hAm.size());
                }
                this.hAp = a(1, this.hAm);
                w.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
                this.hAn = com.tencent.mm.pluginsdk.a.dm(ab.getContext());
                if (this.hAn != null) {
                    w.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.hAn.size());
                }
                this.hAo = a(0, this.hAn);
                w.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
                if (this.hAm != null && this.hAp.size() > 0) {
                    for (int i = 0; i < this.hAp.size(); i += 100) {
                        List a;
                        w.i("MicroMsg.AddrBookSyncHelper", "sync email index: " + i);
                        if (i + 100 < this.hAp.size()) {
                            a = a(this.hAp, i, i + 100);
                        } else {
                            a = a(this.hAp, i, this.hAp.size());
                        }
                        w.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + a.size());
                        m.D(a);
                    }
                }
                if (this.hAo == null || this.hAo.size() == 0) {
                    w.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
                    Message obtainMessage = hAr.obtainMessage();
                    obtainMessage.obj = Boolean.valueOf(false);
                    hAr.sendMessage(obtainMessage);
                    return;
                }
                int i2 = 0;
                while (i2 < this.hAo.size()) {
                    w.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: " + i2);
                    if (ap.zb()) {
                        List a2;
                        if (i2 + 100 < this.hAo.size()) {
                            a2 = a(this.hAo, i2, i2 + 100);
                        } else {
                            a2 = a(this.hAo, i2, this.hAo.size());
                        }
                        w.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + a2.size());
                        m.D(a2);
                        i2 += 100;
                    } else {
                        w.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
                        obtainMessage = hAr.obtainMessage();
                        obtainMessage.obj = Boolean.valueOf(false);
                        hAr.sendMessage(obtainMessage);
                        return;
                    }
                }
                w.i("MicroMsg.AddrBookSyncHelper", "sync ok");
                if (ap.zb()) {
                    EN();
                    System.currentTimeMillis();
                    this.hAq.addSplit("sync ok");
                    this.hAq.dumpToLog();
                    obtainMessage = hAr.obtainMessage();
                    obtainMessage.obj = Boolean.valueOf(true);
                    hAr.sendMessage(obtainMessage);
                    return;
                }
                w.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
                obtainMessage = hAr.obtainMessage();
                obtainMessage.obj = Boolean.valueOf(false);
                hAr.sendMessage(obtainMessage);
            }
        }

        private static void EN() {
            be beVar = new be("MicroMsg.AddrBookSyncHelper", "delete");
            List arrayList = new ArrayList();
            List dp = com.tencent.mm.pluginsdk.a.dp(ab.getContext());
            for (String[] strArr : af.FY().Fb()) {
                String mz = bg.mz(strArr[0]);
                String mz2 = bg.mz(strArr[1]);
                if (!(mz.equals("") || dp.contains(mz))) {
                    arrayList.add(mz2);
                }
            }
            if (arrayList.size() > 0) {
                af.FY().A(arrayList);
                m.C(arrayList);
            }
            beVar.addSplit("end");
            beVar.dumpToLog();
        }

        private static List<b> a(int i, List<String[]> list) {
            if (list == null) {
                w.e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
                return new LinkedList();
            }
            List<b> arrayList = new ArrayList();
            for (String[] strArr : list) {
                if (strArr != null) {
                    String str = strArr[0];
                    String str2 = strArr[1];
                    String str3 = strArr[2];
                    String str4 = strArr[3];
                    long PZ = bg.PZ(strArr[4]);
                    if (!(str3 == null || str3.equals(""))) {
                        String str5 = "";
                        if (i == 1) {
                            str5 = g.n(str3.getBytes());
                        }
                        if (i == 0) {
                            str5 = com.tencent.mm.pluginsdk.a.Di(str3);
                            if (bg.mA(str5)) {
                                w.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
                            } else {
                                str5 = g.n(str5.getBytes());
                            }
                        }
                        b bVar = new b();
                        bVar.gTY = str2;
                        bVar.hAu = c.mq(str2);
                        bVar.hAv = c.mp(str2);
                        bVar.hAs = str;
                        bVar.hrv = str4;
                        bVar.iY(str5);
                        bVar.hAV = PZ;
                        bVar.hAB = bVar.sZ();
                        if (i == 1) {
                            bVar.gku = str3;
                        }
                        if (i == 0) {
                            bVar.hAy = str3;
                        }
                        bVar.type = i;
                        bVar.fRW = 1095798;
                        arrayList.add(bVar);
                    }
                }
            }
            return arrayList;
        }
    }

    public interface b {
        void bg(boolean z);
    }

    public static boolean EL() {
        return a(hAi);
    }

    public static boolean a(final b bVar) {
        final long id = Thread.currentThread().getId();
        if (m.Fo()) {
            af.v(new Runnable() {
                public final void run() {
                    boolean z = a.thread != null && a.thread.isAlive();
                    w.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", Boolean.valueOf(z), Integer.valueOf(a.hAh.size()), Long.valueOf(id), bVar);
                    a.hAh.add(bVar);
                    if (!z) {
                        a.thread = e.d(new a(), "AddrBookSyncHelper_addrBookRead", 1);
                        m.Fi();
                        a.thread.start();
                    }
                }
            });
            return true;
        }
        w.e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", Boolean.valueOf(m.Fo()));
        return false;
    }

    public static boolean EM() {
        return a.hAc;
    }
}
