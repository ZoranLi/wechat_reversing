package com.tencent.mm.q;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

public final class b {
    SparseArray<a> gUW = new SparseArray();
    HashMap<com.tencent.mm.storage.w.a, a> gUX = new HashMap();
    SparseArray<b> gUY = new SparseArray();
    HashMap<com.tencent.mm.storage.w.a, b> gUZ = new HashMap();
    private Random gVa = new Random();
    t gVb = null;

    public class a {
        String fGV;
        int gUS;
        com.tencent.mm.storage.w.a gUT;
        final /* synthetic */ b gVc;
        int type;
        public String value;

        public a(b bVar) {
            this.gVc = bVar;
        }
    }

    public class b {
        com.tencent.mm.storage.w.a gUV;
        final /* synthetic */ b gVc;
        int gVd;
        SparseArray<String> gVe = new SparseArray();
        HashMap<String, String> gVf = new HashMap();

        public b(b bVar) {
            this.gVc = bVar;
        }
    }

    private static String dP(String str) {
        return str.replaceAll("\\|", "%7C");
    }

    private static String unescape(String str) {
        return str.replaceAll("%7C", "|");
    }

    final void a(a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(aVar.type);
        stringBuffer.append("|");
        stringBuffer.append(dP(aVar.value));
        stringBuffer.append("|");
        stringBuffer.append(dP(aVar.fGV));
        if (aVar.gUT != null) {
            this.gVb.a(aVar.gUT, stringBuffer.toString());
        } else {
            this.gVb.set(aVar.gUS, stringBuffer.toString());
        }
    }

    final void a(b bVar) {
        StringBuffer stringBuffer = new StringBuffer();
        int i;
        if (bVar.gUV != null) {
            i = 0;
            for (Entry entry : bVar.gVf.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (i != 0) {
                    stringBuffer.append("|");
                }
                stringBuffer.append(str);
                stringBuffer.append("|");
                stringBuffer.append(dP(str2));
                i++;
            }
            this.gVb.a(bVar.gUV, stringBuffer.toString());
            return;
        }
        for (int i2 = 0; i2 < bVar.gVe.size(); i2++) {
            i = bVar.gVe.keyAt(i2);
            str2 = (String) bVar.gVe.get(i);
            if (i2 != 0) {
                stringBuffer.append("|");
            }
            stringBuffer.append(i);
            stringBuffer.append("|");
            stringBuffer.append(dP(str2));
        }
        this.gVb.set(bVar.gVd, stringBuffer.toString());
    }

    private a eG(int i) {
        String str = (String) this.gVb.get(i, null);
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            w.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", str);
            return null;
        }
        try {
            return a(i, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
        } catch (Throwable e) {
            w.e("MicroMsg.NewBadgeDecoder", "exception:%s", bg.g(e));
            w.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", str);
            return null;
        }
    }

    private a b(com.tencent.mm.storage.w.a aVar) {
        String str = (String) this.gVb.get(aVar, null);
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            w.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", str);
            return null;
        }
        try {
            return a(aVar, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
        } catch (Throwable e) {
            w.e("MicroMsg.NewBadgeDecoder", "exception:%s", bg.g(e));
            w.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", str);
            return null;
        }
    }

    private b eH(int i) {
        String str = (String) this.gVb.get(i, null);
        if (str == null) {
            return eI(i);
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            w.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            return null;
        }
        try {
            b eI = eI(i);
            for (int i2 = 0; i2 < split.length; i2 += 2) {
                eI.gVe.put(Integer.valueOf(split[i2]).intValue(), unescape(split[i2 + 1]));
            }
            return eI;
        } catch (Throwable e) {
            w.e("MicroMsg.NewBadgeDecoder", "exception:%s", bg.g(e));
            w.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", str);
            return null;
        }
    }

    private b c(com.tencent.mm.storage.w.a aVar) {
        String str = (String) this.gVb.get(aVar, null);
        if (str == null) {
            return d(aVar);
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            w.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            return null;
        }
        try {
            b d = d(aVar);
            for (int i = 0; i < split.length; i += 2) {
                d.gVf.put(split[i], unescape(split[i + 1]));
            }
            return d;
        } catch (Throwable e) {
            w.e("MicroMsg.NewBadgeDecoder", "exception:%s", bg.g(e));
            w.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", str);
            return null;
        }
    }

    final String uj() {
        long currentTimeMillis = System.currentTimeMillis();
        int nextInt = this.gVa.nextInt(Math.abs(this.gVa.nextInt(Integer.MAX_VALUE))) % 10000;
        return String.format("%d%04d", new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(nextInt)});
    }

    final b eI(int i) {
        b bVar = new b(this);
        bVar.gVd = i;
        return bVar;
    }

    final b d(com.tencent.mm.storage.w.a aVar) {
        b bVar = new b(this);
        bVar.gUV = aVar;
        return bVar;
    }

    final a a(int i, int i2, String str, String str2) {
        a aVar = new a(this);
        aVar.gUS = i;
        aVar.type = i2;
        aVar.value = str;
        aVar.fGV = str2;
        return aVar;
    }

    final a a(com.tencent.mm.storage.w.a aVar, int i, String str, String str2) {
        a aVar2 = new a(this);
        aVar2.gUT = aVar;
        aVar2.type = i;
        aVar2.value = str;
        aVar2.fGV = str2;
        return aVar2;
    }

    public final a eJ(int i) {
        a aVar = (a) this.gUW.get(i);
        if (aVar == null) {
            aVar = eG(i);
            if (aVar != null) {
                this.gUW.put(i, aVar);
            }
        }
        return aVar;
    }

    public final a e(com.tencent.mm.storage.w.a aVar) {
        a aVar2 = (a) this.gUX.get(aVar);
        if (aVar2 == null) {
            aVar2 = b(aVar);
            if (aVar2 != null) {
                this.gUX.put(aVar, aVar2);
            }
        }
        return aVar2;
    }

    final b eK(int i) {
        b bVar = (b) this.gUY.get(i);
        if (bVar != null) {
            return bVar;
        }
        bVar = eH(i);
        if (bVar == null) {
            w.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
            return null;
        }
        this.gUY.put(i, bVar);
        return bVar;
    }

    final b f(com.tencent.mm.storage.w.a aVar) {
        b bVar = (b) this.gUZ.get(aVar);
        if (bVar != null) {
            return bVar;
        }
        bVar = c(aVar);
        if (bVar == null) {
            w.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
            return null;
        }
        this.gUZ.put(aVar, bVar);
        return bVar;
    }

    public final a p(int i, int i2, int i3) {
        w.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        a eJ = eJ(i);
        if (eJ == null) {
            w.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            return null;
        } else if ((eJ.type & i3) == 0) {
            w.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            return null;
        } else {
            b eK = eK(i2);
            if (eK != null) {
                String str = (String) eK.gVe.get(i);
                if (str != null && str.equals(eJ.fGV)) {
                    return null;
                }
                if (str == null) {
                    eK.gVe.put(i, uj());
                    a(eK);
                }
                return eJ;
            }
            w.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            return null;
        }
    }

    public final a a(com.tencent.mm.storage.w.a aVar, com.tencent.mm.storage.w.a aVar2, int i) {
        w.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", aVar, aVar2, Integer.valueOf(i));
        a e = e(aVar);
        if (e == null) {
            w.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            return null;
        } else if ((e.type & i) == 0) {
            w.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            return null;
        } else {
            b f = f(aVar2);
            if (f != null) {
                String str = (String) f.gVf.get(aVar.name());
                if (str != null && str.equals(e.fGV)) {
                    return null;
                }
                if (str == null) {
                    f.gVf.put(aVar.name(), uj());
                    a(f);
                }
                return e;
            }
            w.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            return null;
        }
    }
}
