package com.tencent.mm.plugin.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.cm;
import com.tencent.mm.e.a.e;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public final class BKGLoaderManager implements e {
    public int hEC;
    public int kNL = 0;
    private int kNM = 0;
    public boolean kNN = false;
    public boolean kNO = false;
    public boolean kNP = false;
    public boolean kNQ = false;
    public boolean kNR = false;
    private boolean kNS = false;
    boolean kNT = false;
    boolean kNU = false;
    d kNV = null;
    private b kNW;
    public Vector<d> kNX = new Vector();
    public Vector<d> kNY = new Vector();
    public Vector<d> kNZ = new Vector();
    public Set<c> kOa = new HashSet();
    public ConnectivityReceiver kOb;
    public int kOc = -1;
    public long kOd = 0;
    public long kOe = 0;
    public aj kOf = new aj(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ BKGLoaderManager kOi;

        {
            this.kOi = r1;
        }

        public final boolean oQ() {
            if (this.kOi.kNO || this.kOi.kNP || this.kOi.kNQ) {
                long uidTxBytes = TrafficStats.getUidTxBytes(this.kOi.hEC);
                long uidRxBytes = TrafficStats.getUidRxBytes(this.kOi.hEC);
                long j = (uidTxBytes - this.kOi.kOd) + (uidRxBytes - this.kOi.kOe);
                w.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + (j / AppSupportContentFlag.MMAPP_SUPPORT_XLS));
                if (j <= 20480) {
                    this.kOi.amx();
                } else {
                    this.kOi.kOd = uidTxBytes;
                    this.kOi.kOe = uidRxBytes;
                    this.kOi.kOf.v(1000, 1000);
                }
            }
            return false;
        }
    }, false);
    public c kOg = new c<e>(this) {
        final /* synthetic */ BKGLoaderManager kOi;

        {
            this.kOi = r2;
            this.usg = e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            e eVar = (e) bVar;
            if ((eVar instanceof e) && !eVar.fCm.fCn) {
                this.kOi.amx();
            }
            return false;
        }
    };
    public c kOh = new c<cm>(this) {
        final /* synthetic */ BKGLoaderManager kOi;

        {
            this.kOi = r2;
            this.usg = cm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            cm cmVar = (cm) bVar;
            if ((cmVar instanceof cm) && !bg.mA(cmVar.fFV.fFW)) {
                this.kOi.k(cmVar.fFV.fFW, cmVar.fFV.fEG, cmVar.fFV.success);
            }
            return false;
        }
    };

    final class ConnectivityReceiver extends BroadcastReceiver {
        final /* synthetic */ BKGLoaderManager kOi;

        public ConnectivityReceiver(BKGLoaderManager bKGLoaderManager) {
            this.kOi = bKGLoaderManager;
        }

        public final void onReceive(Context context, Intent intent) {
            int netType = am.getNetType(context);
            if (this.kOi.kOc != netType) {
                w.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", new Object[]{Integer.valueOf(netType)});
                if (BKGLoaderManager.alx()) {
                    this.kOi.amy();
                } else if (BKGLoaderManager.amA()) {
                    this.kOi.amx();
                } else if (am.isConnected(ab.getContext())) {
                    this.kOi.amz();
                } else {
                    this.kOi.amy();
                }
                this.kOi.kOc = netType;
            }
        }
    }

    public BKGLoaderManager(b bVar) {
        this.kNW = bVar;
        this.hEC = Process.myUid();
        this.kOc = am.getNetType(ab.getContext());
    }

    public final void am(List<d> list) {
        if (this.kNY == null) {
            this.kNY = new Vector();
        }
        if (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) list.get(i);
                if (dVar == null || this.kNY.contains(dVar)) {
                    w.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[]{dVar.getKey()});
                } else {
                    this.kNY.add(dVar);
                }
            }
        }
    }

    public final synchronized void amx() {
        if (am.isWifi(ab.getContext()) || this.kNN) {
            if (this.kNX != null && this.kNX.size() > 0) {
                this.kNT = f.sa();
                this.kNO = true;
                this.kNP = false;
                this.kNR = false;
                this.kNQ = false;
                if (this.kNT) {
                    w.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
                } else {
                    this.kNV = (d) this.kNX.remove(0);
                    this.kNV.a(this);
                    this.kNW.kNJ.execute(this.kNV);
                    w.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", new Object[]{this.kNV.getKey(), Integer.valueOf(this.kNX.size())});
                }
                amz();
            } else if (this.kNY == null || this.kNY.size() <= 0) {
                w.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
                if (this.kNX == null || this.kNX.size() <= 0) {
                    if (this.kNO && this.kNU) {
                        this.kNR = true;
                    }
                    this.kNO = false;
                }
                if (this.kNY == null || this.kNY.size() <= 0) {
                    if (this.kNP && this.kNU) {
                        this.kNS = true;
                    }
                    this.kNP = false;
                }
                if ((this.kNX == null || this.kNX.size() <= 0) && ((this.kNY == null || this.kNY.size() <= 0) && ((this.kNO || this.kNP) && this.kNU))) {
                    this.kNP = false;
                    this.kNO = false;
                }
                this.kNN = false;
                amz();
            } else {
                this.kNP = true;
                this.kNO = false;
                this.kNS = false;
                this.kNQ = false;
                this.kNV = (d) this.kNY.remove(0);
                this.kNV.a(this);
                this.kNW.kNJ.execute(this.kNV);
                w.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", new Object[]{this.kNV.getKey(), Integer.valueOf(this.kNY.size())});
                amz();
            }
            if (!(this.kNP || this.kNO)) {
                if (this.kNZ == null || this.kNZ.size() <= 0) {
                    this.kNQ = false;
                } else {
                    this.kNQ = true;
                    this.kNV = (d) this.kNZ.remove(0);
                    this.kNV.a(this);
                    this.kNW.kNJ.execute(this.kNV);
                    w.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", new Object[]{this.kNV.getKey(), Integer.valueOf(this.kNZ.size())});
                }
            }
        } else if (alx()) {
            w.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
            this.kNO = false;
            this.kNP = false;
            this.kNR = false;
            this.kNQ = false;
            amz();
        } else {
            w.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
        }
    }

    public final void amy() {
        this.kNO = false;
        this.kNP = false;
        this.kNN = false;
        amz();
        if (this.kNV != null) {
            this.kNV.cancel();
        }
    }

    public final void amz() {
        if (this.kOa != null && this.kOa.size() > 0) {
            for (c amB : this.kOa) {
                amB.amB();
            }
        }
    }

    public final void uA(String str) {
        w.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", new Object[]{str});
    }

    public final void k(String str, int i, boolean z) {
        w.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", new Object[]{str, Boolean.valueOf(z)});
        if (this.kNV == null || bg.mA(str)) {
            w.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
            return;
        }
        if (this.kNX.contains(this.kNV)) {
            this.kNX.remove(this.kNV);
        } else if (this.kNY.contains(this.kNV)) {
            this.kNY.remove(this.kNV);
        } else if (this.kNZ.contains(this.kNV)) {
            this.kNZ.remove(this.kNV);
        }
        if (!z) {
            w.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        } else if (!(i == 2 || this.kOa == null || this.kOa.size() <= 0)) {
            for (c amC : this.kOa) {
                amC.amC();
            }
        }
        if (i == 2) {
            this.kOf.v(5000, 5000);
        } else {
            this.kOf.v(1000, 1000);
        }
    }

    public static boolean amA() {
        NetworkInfo networkInfo = ((ConnectivityManager) ab.getContext().getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    public static boolean alx() {
        return am.is3G(ab.getContext()) || am.is4G(ab.getContext()) || am.is2G(ab.getContext());
    }
}
