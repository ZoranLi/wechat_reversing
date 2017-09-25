package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.pb.common.c.d;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class e implements b {
    private static e wLe = null;
    private final Handler handler = new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ e wLh;

        public final void handleMessage(Message message) {
            this.wLh.a((d) message.obj);
        }
    };
    public Vector<d> htb = new Vector();
    public Vector<d> htc = new Vector();
    public final SparseArray<Set<b>> wLf = new SparseArray();
    private d wLg = null;

    private e() {
    }

    public static e ccQ() {
        if (wLe == null) {
            synchronized (e.class) {
                if (wLe == null) {
                    wLe = new e();
                }
            }
        }
        return wLe;
    }

    public final void a(int i, b bVar) {
        if (this.wLf.get(i) == null) {
            this.wLf.put(i, new HashSet());
        }
        if (!((Set) this.wLf.get(i)).contains(bVar)) {
            ((Set) this.wLf.get(i)).add(bVar);
        }
    }

    public final boolean a(d dVar) {
        if (!h.isNetworkConnected()) {
            int type = dVar.getType();
            if (type == 102 || type == 104 || type == 103) {
                d.k("MicroMsg.Voip", "doScene do retain mReissueNetScene");
                this.wLg = dVar;
            }
        }
        Assert.assertTrue(true);
        if (dVar == null) {
            return false;
        }
        a(dVar, 0);
        return true;
    }

    private void a(final d dVar, int i) {
        if (ccR()) {
            int i2;
            this.htb.add(dVar);
            if (dVar.wKX == null) {
                d.k("MicroMsg.Voip", dVar.wKV, "dosene reqData is null cmd=" + dVar.wKZ);
                i2 = -1;
            } else {
                dVar.wKW = this;
                i2 = f.ccT().a(null, new i(dVar), dVar.wKZ, dVar.ccP(), dVar.wKX, dVar.wLa);
                if (i2 >= 0) {
                    dVar.mHandler.postDelayed(dVar.htx, 60000);
                }
                d.d("MicroMsg.Voip", "NETTASK_SEND dosene:cmd ", dVar.ccP(), Integer.valueOf(i2));
            }
            if (i2 < 0) {
                d.k("MicroMsg.Voip", "doSceneImp do scene failed, ret %d,", Integer.valueOf(i2));
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ e wLh;

                    public final void run() {
                        this.wLh.htb.remove(dVar);
                        this.wLh.a(2, -1, "doScene failed", dVar);
                    }
                });
            }
        } else {
            this.htc.add(dVar);
        }
        BV();
    }

    public final void a(int i, int i2, String str, d dVar) {
        this.htb.remove(dVar);
        BV();
        final d dVar2 = dVar;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        this.handler.post(new Runnable(this) {
            final /* synthetic */ e wLh;

            public final void run() {
                Set set = (Set) this.wLh.wLf.get(dVar2.getType());
                if (set != null && set.size() > 0) {
                    Set<b> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (b bVar : hashSet) {
                        if (bVar != null && set.contains(bVar)) {
                            bVar.a(i3, i4, str2, dVar2);
                        }
                    }
                }
            }
        });
    }

    private void BV() {
        if (this.htc.size() > 0) {
            d dVar = (d) this.htc.get(0);
            for (int i = 1; i < this.htc.size(); i++) {
                this.htc.get(i);
            }
            if (ccR()) {
                this.htc.remove(dVar);
                a(dVar, 0);
            }
        }
    }

    private boolean ccR() {
        if (this.htb.size() >= 20) {
            return false;
        }
        return true;
    }
}
