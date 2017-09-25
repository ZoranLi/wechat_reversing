package com.tencent.mm.plugin.backup.f;

import android.os.Looper;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public abstract class b extends k {
    private static final ae handler = new ae(Looper.getMainLooper());
    public static final Map<Integer, Set<e>> htd = new HashMap();
    static int jBq = -1;
    public static c jHo;
    static a jHp;
    private static final Map<Integer, b> jHq = new HashMap();
    private static int jHr = new Random(System.currentTimeMillis()).nextInt(1147483648);
    private static i jHs = null;
    private static j jHt = null;
    private static b jHu = null;

    public interface a {
        void i(int i, byte[] bArr);

        int j(int i, byte[] bArr);
    }

    public interface b {
        void aaO();
    }

    public interface c {
        void a(boolean z, int i, byte[] bArr, int i2);
    }

    public abstract com.tencent.mm.bd.a abn();

    public abstract com.tencent.mm.bd.a abo();

    public abstract void abp();

    public abstract int getType();

    public static void a(c cVar) {
        jHo = cVar;
    }

    public static void a(a aVar) {
        jHp = aVar;
    }

    public static i abr() {
        return jHs;
    }

    public static void a(com.tencent.mm.plugin.backup.f.i.a aVar) {
        jHs = new i(aVar);
    }

    public static j abs() {
        return jHt;
    }

    public static void a(com.tencent.mm.plugin.backup.f.j.a aVar) {
        jHt = new j(aVar);
    }

    public static void jg(int i) {
        jBq = i;
    }

    public static int aah() {
        return jBq;
    }

    public static void clear() {
        w.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
        synchronized (jHq) {
            htd.clear();
            jHq.clear();
        }
    }

    public boolean abt() {
        return cL(false);
    }

    public final boolean cL(boolean z) {
        PByteArray pByteArray = new PByteArray();
        try {
            byte[] toByteArray = abo().toByteArray();
            synchronized (jHq) {
                com.tencent.mm.plugin.backup.e.c.a(toByteArray, jHr, (short) getType(), pByteArray, jBq);
                if (jHp != null) {
                    jHp.i(jHr, pByteArray.value);
                }
                w.i("MicroMsg.BackupBaseScene", "BackupBaseScene doscene globalSeq:%d, isDirect:%b, type:%d, len:%d", new Object[]{Integer.valueOf(jHr), Boolean.valueOf(z), Integer.valueOf(getType()), Integer.valueOf(pByteArray.value.length)});
                if (!z) {
                    jHq.put(Integer.valueOf(jHr), this);
                }
                jHr++;
            }
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public final boolean abu() {
        PByteArray pByteArray = new PByteArray();
        try {
            byte[] toByteArray = abo().toByteArray();
            synchronized (jHq) {
                com.tencent.mm.plugin.backup.e.c.a(toByteArray, jHr, (short) getType(), pByteArray, jBq);
                if (jHp != null) {
                    jHp.j(jHr, pByteArray.value);
                }
                w.i("MicroMsg.BackupBaseScene", "BackupBaseScene doscene globalSeq:%d, type:%d, len:%d", new Object[]{Integer.valueOf(jHr), Integer.valueOf(getType()), Integer.valueOf(pByteArray.value.length)});
                jHq.put(Integer.valueOf(jHr), this);
                jHr++;
            }
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public final int abv() {
        int i;
        synchronized (jHq) {
            i = jHr;
            jHq.put(Integer.valueOf(i), this);
            jHr++;
        }
        return i;
    }

    public static boolean r(byte[] bArr, int i) {
        PByteArray pByteArray = new PByteArray();
        synchronized (jHq) {
            com.tencent.mm.plugin.backup.e.c.a(bArr, jHr, (short) i, pByteArray, jBq);
            if (jHp != null) {
                jHp.i(jHr, pByteArray.value);
            }
            w.i("MicroMsg.BackupBaseScene", "BackupBaseScene sendBuf globalSeq:%d, type:%d, len:%d", new Object[]{Integer.valueOf(jHr), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length)});
            jHr++;
        }
        return true;
    }

    public static boolean d(byte[] bArr, int i, int i2) {
        PByteArray pByteArray = new PByteArray();
        com.tencent.mm.plugin.backup.e.c.a(bArr, i2, (short) i, pByteArray, jBq);
        if (jHp != null) {
            jHp.i(i2, pByteArray.value);
        }
        w.i("MicroMsg.BackupBaseScene", "BackupBaseScene sendResp globalSeq:%d, type:%d, len:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length)});
        return true;
    }

    public static void b(boolean z, int i, int i2, byte[] bArr) {
        String str = "MicroMsg.BackupBaseScene";
        String str2 = "BackupBaseScene callback isLocal: %b,  seq:%d   type:%d,  bufLen:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        w.i(str, str2, objArr);
        if (z) {
            try {
                w.w("MicroMsg.BackupBaseScene", "callback error buf content : " + new String(bArr));
            } catch (Exception e) {
            }
            b(z, i2, bArr, i);
            return;
        }
        if (jHs != null) {
            jHs.abz();
            w.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", new Object[]{Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())});
        }
        synchronized (jHq) {
            b bVar = (b) jHq.remove(Integer.valueOf(i));
        }
        if (bVar != null) {
            try {
                bVar.abn().aD(bArr);
                bVar.abp();
                return;
            } catch (Throwable e2) {
                bVar.e(3, -1, "buf to resq fail");
                w.printErrStackTrace("MicroMsg.BackupBaseScene", e2, "%s ", new Object[]{e2.toString()});
                return;
            }
        }
        w.i("MicroMsg.BackupBaseScene", "notify scene null type:%d secneMap:%d ", new Object[]{Integer.valueOf(i2), Integer.valueOf(jHq.size())});
        if (bVar == null && i2 == 16) {
            synchronized (jHq) {
                Iterator it = new HashSet(jHq.keySet()).iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    b bVar2 = (b) jHq.get(num);
                    String str3 = "MicroMsg.BackupBaseScene";
                    String str4 = "notify sceneMap seq:%d scene:%s type:%s";
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = num;
                    objArr2[1] = bVar2;
                    if (bVar2 == null) {
                        str = "null";
                    } else {
                        str = Integer.valueOf(bVar2.getType());
                    }
                    objArr2[2] = str;
                    w.d(str3, str4, objArr2);
                    if (bVar2 != null && bVar2.getType() == 15) {
                        jHq.remove(num);
                        try {
                            bVar2.abn().aD(bArr);
                            bVar2.abp();
                        } catch (Throwable e3) {
                            bVar2.e(3, -1, "buf to resp fail");
                            w.printErrStackTrace("MicroMsg.BackupBaseScene", e3, " type:%d %s ", new Object[]{Integer.valueOf(bVar2.getType()), e3.toString()});
                        }
                    }
                }
            }
            return;
        }
        w.i("MicroMsg.BackupBaseScene", "notify globalSeq:%d, type:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        b(z, i2, bArr, i);
    }

    private static void b(final boolean z, final int i, final byte[] bArr, final int i2) {
        handler.post(new Runnable() {
            public final void run() {
                if (b.jHo != null) {
                    b.jHo.a(z, i, bArr, i2);
                } else {
                    w.i("MicroMsg.BackupBaseScene", "onNotify is null");
                }
            }
        });
    }

    public static void a(int i, e eVar) {
        synchronized (htd) {
            if (!htd.containsKey(Integer.valueOf(i))) {
                htd.put(Integer.valueOf(i), new HashSet());
            }
            if (!((Set) htd.get(Integer.valueOf(i))).contains(eVar)) {
                ((Set) htd.get(Integer.valueOf(i))).add(eVar);
            }
        }
    }

    public static void b(int i, e eVar) {
        synchronized (htd) {
            try {
                if (htd.get(Integer.valueOf(i)) != null) {
                    ((Set) htd.get(Integer.valueOf(i))).remove(eVar);
                }
            } catch (Exception e) {
            }
        }
    }

    public final void e(final int i, final int i2, final String str) {
        handler.post(new Runnable(this) {
            final /* synthetic */ b jHv;

            public final void run() {
                Set set = (Set) b.htd.get(Integer.valueOf(this.jHv.getType()));
                if (set != null && set.size() > 0) {
                    Set<e> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (e eVar : hashSet) {
                        if (eVar != null && set.contains(eVar)) {
                            eVar.a(i, i2, str, this.jHv);
                        }
                    }
                }
            }
        });
    }

    public static void a(b bVar) {
        jHu = bVar;
    }

    public static void aaO() {
        if (jHu != null) {
            jHu.aaO();
        }
    }

    public static void jp(int i) {
        if (jHt != null) {
            j jVar = jHt;
            jVar.jHW = ((long) i) + jVar.jHW;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        return 0;
    }
}
