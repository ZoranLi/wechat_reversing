package com.tencent.mm.y;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class n implements e {
    private static n hsY = null;
    private static int htj = 1;
    public boolean foreground = false;
    public final ae handler = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ n htk;

        public final void handleMessage(Message message) {
            this.htk.a((k) message.obj, 0);
        }
    };
    public e hsZ;
    public af hta = null;
    public Vector<k> htb = new Vector();
    public Vector<k> htc = new Vector();
    public final Map<Integer, Set<e>> htd = new HashMap();
    private Boolean hte = null;
    public final a htf;
    private long htg = 21600000;
    public boolean hth = false;
    private aj hti = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ n htk;

        {
            this.htk = r1;
        }

        public final boolean oQ() {
            boolean z = false;
            if (this.htk.htf == null) {
                return false;
            }
            w.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", Integer.valueOf(this.htk.htb.size()), Integer.valueOf(this.htk.htc.size()), Boolean.valueOf(this.htk.foreground));
            a aVar = this.htk.htf;
            n nVar = this.htk;
            if (this.htk.hth && this.htk.htb.isEmpty() && this.htk.htc.isEmpty()) {
                z = true;
            }
            aVar.a(nVar, z);
            return true;
        }
    }, true);
    public final Object lock = new Object();

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ n htk;
        final /* synthetic */ int htl;

        public AnonymousClass4(n nVar, int i) {
            this.htk = nVar;
            this.htl = i;
        }

        public final void run() {
            n nVar = this.htk;
            int i = this.htl;
            synchronized (nVar.lock) {
                Iterator it = nVar.htb.iterator();
                while (it.hasNext()) {
                    k kVar = (k) it.next();
                    if (!(kVar == null || kVar.hashCode() != i || kVar == null)) {
                        w.j("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(kVar.hashCode()));
                        kVar.cancel();
                        it.remove();
                    }
                }
                Iterator it2 = nVar.htc.iterator();
                while (it2.hasNext()) {
                    kVar = (k) it2.next();
                    if (!(kVar == null || kVar.hashCode() != i || kVar == null)) {
                        w.j("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(kVar.hashCode()));
                        kVar.cancel();
                        it2.remove();
                    }
                }
            }
        }

        public final String toString() {
            return super.toString() + "|cancelImp_" + this.htl;
        }
    }

    public interface a {
        void a(n nVar);

        void a(n nVar, boolean z);
    }

    public final void aW(boolean z) {
        this.hth = z;
        if (this.hth) {
            w.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
            aj ajVar = this.hti;
            long j = this.htg;
            ajVar.v(j, j);
            return;
        }
        this.hti.KH();
    }

    public final void a(int i, String str, int i2, boolean z) {
        if (this.hsZ == null) {
            w.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
        } else {
            this.hsZ.a(i, str, i2, z);
        }
    }

    public final void aX(boolean z) {
        this.foreground = z;
        this.hte = Boolean.valueOf(z);
        b.aX(z);
        if (this.hsZ == null) {
            w.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
        } else {
            this.hsZ.aZ(z);
        }
    }

    public final int BR() {
        try {
            if (this.hsZ != null && this.hsZ.Cd() != null) {
                return this.hsZ.Cd().Ms();
            }
            w.e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
            if (am.isConnected(ab.getContext())) {
                return 6;
            }
            return 0;
        } catch (Throwable e) {
            w.e("MicroMsg.NetSceneQueue", "exception:%s", bg.g(e));
        }
    }

    public final boolean BS() {
        if (this.hsZ != null) {
            return this.hsZ.BS();
        }
        return true;
    }

    public final String getNetworkServerIp() {
        if (this.hsZ != null) {
            return this.hsZ.getNetworkServerIp();
        }
        return "unknown";
    }

    private n(a aVar) {
        this.htf = aVar;
    }

    public final void d(e eVar) {
        this.hsZ = eVar;
        eVar.aZ(this.foreground);
        BV();
    }

    public static n a(a aVar) {
        if (hsY == null) {
            hsY = new n(aVar);
        }
        return hsY;
    }

    public final void a(int i, e eVar) {
        synchronized (this.htd) {
            if (!this.htd.containsKey(Integer.valueOf(i))) {
                this.htd.put(Integer.valueOf(i), new HashSet());
            }
            if (!((Set) this.htd.get(Integer.valueOf(i))).contains(eVar)) {
                ((Set) this.htd.get(Integer.valueOf(i))).add(eVar);
            }
        }
    }

    public final void b(int i, e eVar) {
        synchronized (this.htd) {
            try {
                if (this.htd.get(Integer.valueOf(i)) != null) {
                    ((Set) this.htd.get(Integer.valueOf(i))).remove(eVar);
                }
            } catch (Exception e) {
            }
        }
    }

    public final void reset() {
        if (this.hsZ != null) {
            this.hsZ.reset();
        }
        BT();
        List<k> list = this.htc;
        this.htc = new Vector();
        for (k kVar : list) {
            w.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + kVar.getType());
            kVar.cancel();
            c(3, -1, "doScene failed clearWaitingQueue", kVar);
        }
        list.clear();
    }

    public final void BT() {
        List<k> list = this.htb;
        this.htb = new Vector();
        for (k kVar : list) {
            w.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + kVar.getType());
            kVar.cancel();
            c(3, -1, "doScene failed clearRunningQueue", kVar);
        }
        list.clear();
    }

    public final void BU() {
        w.i("MicroMsg.NetSceneQueue", "resetDispatcher");
        if (this.hsZ != null) {
            this.hsZ.reset();
            this.hsZ = null;
        }
    }

    public final e vh() {
        return this.hsZ;
    }

    public final void cancel(final int i) {
        w.j("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(i));
        this.hta.D(new Runnable(this) {
            final /* synthetic */ n htk;

            public final void run() {
                n nVar = this.htk;
                int i = i;
                synchronized (nVar.lock) {
                    Iterator it = nVar.htb.iterator();
                    while (it.hasNext()) {
                        k kVar = (k) it.next();
                        if (kVar != null && kVar.hashCode() == i) {
                            nVar.c(kVar);
                            return;
                        }
                    }
                    it = nVar.htc.iterator();
                    while (it.hasNext()) {
                        kVar = (k) it.next();
                        if (kVar != null && kVar.hashCode() == i) {
                            nVar.c(kVar);
                            return;
                        }
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|cancelImp_" + i;
            }
        });
    }

    public final void c(k kVar) {
        if (kVar != null) {
            w.j("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(kVar.hashCode()));
            kVar.cancel();
            synchronized (this.lock) {
                this.htc.remove(kVar);
                this.htb.remove(kVar);
            }
        }
    }

    public final boolean d(k kVar) {
        return a(kVar, 0);
    }

    public final boolean a(k kVar, int i) {
        boolean z = kVar != null || i >= 0;
        Assert.assertTrue(z);
        String str = "worker thread has not been set";
        if (this.hta != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        if (!e(kVar)) {
            return false;
        }
        b(kVar, i);
        return true;
    }

    private void b(final k kVar, int i) {
        boolean BW = BW();
        int size = this.htb.size();
        String str = "MicroMsg.NetSceneQueue";
        String str2 = "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d";
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(kVar.getType());
        objArr[1] = Integer.valueOf(kVar.hashCode());
        objArr[2] = Integer.valueOf(kVar.BM());
        objArr[3] = Integer.valueOf(size);
        objArr[4] = Integer.valueOf(this.htc.size());
        objArr[5] = Integer.valueOf(i);
        objArr[6] = Boolean.valueOf(BW);
        objArr[7] = Integer.valueOf(this.hsZ == null ? 0 : this.hsZ.hashCode());
        w.i(str, str2, objArr);
        if (i == 0 && BW && this.hsZ != null) {
            synchronized (this.lock) {
                this.htb.add(kVar);
                if (size == this.htb.size()) {
                    w.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", Integer.valueOf(kVar.getType()), Integer.valueOf(kVar.hashCode()), Integer.valueOf(size), Integer.valueOf(this.htb.size()), Integer.valueOf(this.htc.size()));
                }
            }
            this.hta.D(new Runnable(this) {
                final /* synthetic */ n htk;

                public final void run() {
                    int i;
                    String str;
                    String str2;
                    Object[] objArr;
                    int i2 = 0;
                    kVar.hsI = this.htk;
                    if (kVar.hsG || this.htk.hsZ == null) {
                        i = 0;
                    } else {
                        i = kVar.a(this.htk.hsZ, this.htk);
                        if (i >= 0) {
                            str = "MicroMsg.NetSceneQueue";
                            str2 = "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d";
                            objArr = new Object[7];
                            objArr[0] = Integer.valueOf(kVar.getType());
                            objArr[1] = Integer.valueOf(kVar.hashCode());
                            objArr[2] = Integer.valueOf(kVar.BM());
                            objArr[3] = Integer.valueOf(this.htk.htb.size());
                            objArr[4] = Integer.valueOf(this.htk.htc.size());
                            objArr[5] = Integer.valueOf(i);
                            if (this.htk.hsZ == null) {
                                i = 0;
                            } else {
                                i = this.htk.hsZ.hashCode();
                            }
                            objArr[6] = Integer.valueOf(i);
                            w.i(str, str2, objArr);
                            kVar.hsJ = false;
                            return;
                        }
                    }
                    str = "MicroMsg.NetSceneQueue";
                    str2 = "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d";
                    objArr = new Object[8];
                    objArr[0] = Integer.valueOf(kVar.getType());
                    objArr[1] = Integer.valueOf(kVar.hashCode());
                    objArr[2] = Integer.valueOf(kVar.BM());
                    objArr[3] = Boolean.valueOf(kVar.hsG);
                    objArr[4] = Integer.valueOf(this.htk.htb.size());
                    objArr[5] = Integer.valueOf(this.htk.htc.size());
                    objArr[6] = Integer.valueOf(i);
                    if (this.htk.hsZ != null) {
                        i2 = this.htk.hsZ.hashCode();
                    }
                    objArr[7] = Integer.valueOf(i2);
                    w.w(str, str2, objArr);
                    kVar.hsI = null;
                    synchronized (this.htk.lock) {
                        this.htk.htb.remove(kVar);
                    }
                    if (!kVar.hsG) {
                        this.htk.handler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 htm;

                            {
                                this.htm = r1;
                            }

                            public final void run() {
                                this.htm.htk.a(3, -1, "doScene failed", kVar);
                            }
                        });
                    }
                }

                public final String toString() {
                    return super.toString() + "|doSceneImp_" + kVar + "_type=" + kVar.getType();
                }
            });
        } else if (i > 0) {
            Message obtain = Message.obtain();
            obtain.obj = kVar;
            this.handler.sendMessageDelayed(obtain, (long) i);
            w.i("MicroMsg.NetSceneQueue", "timed: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_after_sec=" + i);
        } else {
            w.i("MicroMsg.NetSceneQueue", "waited: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_waiting_cnt=" + this.htc.size());
            synchronized (this.lock) {
                this.htc.add(kVar);
            }
            w.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.htc.size());
        }
        if (this.hsZ != null) {
            htj = 1;
        } else if (this.htf == null) {
            w.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", this.htf);
        } else {
            this.htf.a(this);
            aj ajVar = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ n htk;
                private long hto = 10;

                {
                    this.htk = r3;
                }

                public final boolean oQ() {
                    if (this.htk.hsZ == null) {
                        long j = this.hto;
                        this.hto = j - 1;
                        if (j > 0) {
                            return true;
                        }
                    }
                    this.htk.BV();
                    return false;
                }
            }, true);
            long j = (long) (htj * 100);
            ajVar.v(j, j);
            if (htj < 512) {
                htj *= 2;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        kVar.hsJ = true;
        synchronized (this.lock) {
            this.htb.remove(kVar);
        }
        String str2 = "MicroMsg.NetSceneQueue";
        String str3 = "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(kVar.getType());
        objArr[1] = Integer.valueOf(kVar.hashCode());
        objArr[2] = Integer.valueOf(kVar.BM());
        objArr[3] = Integer.valueOf(this.htb.size());
        objArr[4] = Integer.valueOf(this.htc.size());
        if (this.hsZ != null) {
            i3 = this.hsZ.hashCode();
        }
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(i);
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = str;
        w.i(str2, str3, objArr);
        BV();
        c(i, i2, str, kVar);
        if (this.hth && this.htb.isEmpty() && this.htc.isEmpty()) {
            aj ajVar = this.hti;
            long j = this.htg;
            ajVar.v(j, j);
        }
    }

    private void c(int i, int i2, String str, k kVar) {
        final k kVar2 = kVar;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        this.handler.post(new Runnable(this) {
            final /* synthetic */ n htk;

            public final void run() {
                Set set = (Set) this.htk.htd.get(Integer.valueOf(kVar2.getType()));
                if (set != null && set.size() > 0) {
                    Set<e> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (e eVar : hashSet) {
                        if (eVar != null && set.contains(eVar)) {
                            eVar.a(i3, i4, str2, kVar2);
                        }
                    }
                }
                set = (Set) this.htk.htd.get(Integer.valueOf(-1));
                if (set != null && set.size() > 0) {
                    hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (e eVar2 : hashSet) {
                        if (eVar2 != null && set.contains(eVar2)) {
                            eVar2.a(i3, i4, str2, kVar2);
                        }
                    }
                }
            }
        });
    }

    public final void BV() {
        synchronized (this.lock) {
            if (this.htc.size() > 0) {
                k kVar = (k) this.htc.get(0);
                int i = 1;
                int i2 = kVar.priority;
                k kVar2 = kVar;
                while (i < this.htc.size()) {
                    k kVar3;
                    int i3;
                    if (((k) this.htc.get(i)).priority > i2) {
                        this.htc.get(i);
                        if (BW()) {
                            kVar = (k) this.htc.get(i);
                            kVar3 = kVar;
                            i3 = kVar.priority;
                            i++;
                            kVar2 = kVar3;
                            i2 = i3;
                        }
                    }
                    i3 = i2;
                    kVar3 = kVar2;
                    i++;
                    kVar2 = kVar3;
                    i2 = i3;
                }
                this.htc.remove(kVar2);
                w.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.htc.size());
                b(kVar2, 0);
            }
        }
    }

    private boolean BW() {
        if (this.htb.size() >= 50) {
            return false;
        }
        return true;
    }

    private boolean e(k kVar) {
        int type = kVar.getType();
        if (kVar.BI()) {
            synchronized (this.lock) {
                k kVar2;
                Iterator it = this.htb.iterator();
                while (it.hasNext()) {
                    kVar2 = (k) it.next();
                    if (kVar2.getType() == type) {
                        w.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_running_cnt=" + this.htb.size());
                        if (kVar.b(kVar2)) {
                            return true;
                        } else if (kVar.a(kVar2)) {
                            w.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_running_cnt=" + this.htb.size() + " ---" + kVar2.hashCode());
                            if (!this.foreground) {
                                w.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + kVar.getType() + "acinfo[" + kVar2.getInfo() + "] scinfo[" + kVar.getInfo() + "]");
                                w.bIP();
                                Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + kVar.getType(), false);
                            }
                            c(kVar2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                it = this.htc.iterator();
                while (it.hasNext()) {
                    kVar2 = (k) it.next();
                    if (kVar2.getType() == type) {
                        w.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_waiting_cnt=" + this.htc.size());
                        if (kVar.b(kVar2)) {
                            return true;
                        } else if (kVar.a(kVar2)) {
                            w.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_waiting_cnt=" + this.htc.size() + " ---" + kVar2.hashCode());
                            if (!this.foreground) {
                                w.bIP();
                                Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + kVar.getType(), false);
                            }
                            c(kVar2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
