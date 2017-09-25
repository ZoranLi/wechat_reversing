package com.tencent.mm.u;

import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.aih;
import com.tencent.mm.protocal.c.aii;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class bm {
    public static final int hnV;
    public static final int hnW;
    public static final int hnX = (hnV + 2);
    private static bm hoa;
    private long hnY = 0;
    private Map<Integer, a> hnZ = new HashMap();

    private abstract class a {
        final /* synthetic */ bm hob;

        public abstract boolean a(bk bkVar);

        public a(bm bmVar) {
            this.hob = bmVar;
        }

        public bk d(int i, Object... objArr) {
            int i2 = 1;
            if (objArr != null && objArr.length > 0) {
                i2 = bg.n(objArr[0], 1);
            }
            bk bkVar = new bk();
            bkVar.key = i;
            bkVar.hnS = String.valueOf(i2);
            bkVar.hnT = 0;
            return bkVar;
        }

        public void a(bk bkVar, Object... objArr) {
            int i = 1;
            if (objArr != null && objArr.length > 0) {
                i = bg.n(objArr[0], 1);
            }
            bkVar.hnS = (i + bg.getInt(bkVar.hnS, 0));
        }
    }

    static {
        int hashCode = "kv_key_start".hashCode();
        hnV = hashCode;
        hnW = hashCode + 1;
    }

    private bm() {
        this.hnZ.put(Integer.valueOf(hnW), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 3600000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(23, bkVar.hnS + "_3");
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(hnX), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 3600000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(23, bkVar.hnS + "_43");
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(24), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 3600000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(25), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final bk d(int i, Object... objArr) {
                bk bkVar = new bk();
                bkVar.key = i;
                bkVar.hnS = objArr[0];
                bkVar.hnT = 0;
                return bkVar;
            }

            public final void a(bk bkVar, Object... objArr) {
                bkVar.hnS = objArr[0];
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 3600000 || bkVar.hnS.length() <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(26), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 3600000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(10071), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 86400000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, "1");
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(10076), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 3600000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(19), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 86400000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(10112), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(10113), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(10114), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(10115), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(10240), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(10241), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(15), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(16), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(27), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(38), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(10090), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(10237), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(10238), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
        this.hnZ.put(Integer.valueOf(10239), new a(this) {
            final /* synthetic */ bm hob;

            {
                this.hob = r1;
            }

            public final boolean a(bk bkVar) {
                if (System.currentTimeMillis() - bkVar.hnT <= 1800000 || bg.getInt(bkVar.hnS, 0) <= 0) {
                    return false;
                }
                bm.n(bkVar.key, bkVar.hnS);
                bkVar.hnS = "0";
                bkVar.hnT = System.currentTimeMillis();
                return true;
            }
        });
    }

    public static bm zN() {
        if (hoa == null) {
            hoa = new bm();
        }
        return hoa;
    }

    public static void n(int i, String str) {
        LinkedList linkedList = new LinkedList();
        aih com_tencent_mm_protocal_c_aih = new aih();
        com_tencent_mm_protocal_c_aih.oTD = i;
        com_tencent_mm_protocal_c_aih.oTN = str;
        linkedList.add(com_tencent_mm_protocal_c_aih);
        a(linkedList);
    }

    public static void a(LinkedList<aih> linkedList) {
        if (h.vG().uV()) {
            h.vG();
            if (!com.tencent.mm.kernel.a.uP()) {
                com.tencent.mm.bd.a com_tencent_mm_protocal_c_aii = new aii();
                com_tencent_mm_protocal_c_aii.jNe = linkedList;
                com_tencent_mm_protocal_c_aii.jNd = linkedList.size();
                ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(36, com_tencent_mm_protocal_c_aii));
            }
        }
    }

    public final void c(int i, Object... objArr) {
        a aVar = (a) this.hnZ.get(Integer.valueOf(i));
        if (aVar != null) {
            bl zP = zP();
            for (bk bkVar : zP.hnU) {
                if (bkVar.key == i) {
                    aVar.a(bkVar, objArr);
                    break;
                }
            }
            zP.hnU.add(aVar.d(i, objArr));
            a(zP);
        }
    }

    public final void zO() {
        if (System.currentTimeMillis() - this.hnY >= 60000) {
            this.hnY = System.currentTimeMillis();
            try {
                bl zP = zP();
                int i = 0;
                for (bk bkVar : zP.hnU) {
                    int i2;
                    a aVar = (a) this.hnZ.get(Integer.valueOf(bkVar.key));
                    if (aVar == null || !aVar.a(bkVar)) {
                        i2 = i;
                    } else {
                        i2 = 1;
                    }
                    i = i2;
                }
                if (i != 0) {
                    a(zP);
                }
            } catch (Throwable e) {
                w.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", bg.g(e));
            }
        }
    }

    private static bl zP() {
        if (h.vG().uV()) {
            h.vG();
            if (!(com.tencent.mm.kernel.a.uP() || h.vI().vr() == null)) {
                byte[] PT = bg.PT((String) h.vI().vr().get(8215, null));
                if (PT.length <= 0) {
                    return new bl();
                }
                try {
                    bl blVar = new bl();
                    blVar.aD(PT);
                    return blVar;
                } catch (Throwable e) {
                    w.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", bg.g(e));
                }
            }
        }
        return new bl();
    }

    private static void a(bl blVar) {
        if (blVar != null && h.vG().uV() && h.vI().vr() != null) {
            h.vG();
            if (!com.tencent.mm.kernel.a.uP()) {
                try {
                    h.vI().vr().set(8215, bg.bo(blVar.toByteArray()));
                } catch (Throwable e) {
                    w.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", bg.g(e));
                }
            }
        }
    }
}
