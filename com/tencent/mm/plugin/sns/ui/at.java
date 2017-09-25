package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class at extends d<m> {
    private boolean fJm = false;
    List<m> fRK = new ArrayList();
    private String lri = "";
    private Comparator<m> pSw = new Comparator<m>(this) {
        final /* synthetic */ at qFO;

        {
            this.qFO = r1;
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            m mVar = (m) obj;
            m mVar2 = (m) obj2;
            if (mVar.qnk == -1) {
                return -1;
            }
            if (mVar2.qnk == -1) {
                return 1;
            }
            if (mVar.field_head != mVar2.field_head) {
                return mVar2.field_head - mVar.field_head;
            }
            return mVar.field_createTime != mVar2.field_createTime ? mVar2.field_createTime - mVar.field_createTime : 0;
        }
    };
    private boolean qFL = false;
    private b qFM;
    private a qFN;
    private int qoX = 0;
    private int qoY = 0;
    private String userName = "";

    class a {
        final /* synthetic */ at qFO;
        public int qFP = -1;
        public int qFQ = -1;
        public boolean qFR = false;
        public int qFS = -1;
        public int qFT = 0;
        public String qFU = "";
        public String qFV = "";
        public String qFW = "";
        public int qFX = -1;
        public int qFY = 0;
        public boolean qFZ = false;
        public int qGa = -1;
        public boolean qGb = false;
        public int qGc = -1;
        public int qGd = 0;

        a(at atVar) {
            this.qFO = atVar;
        }

        public static boolean uc(int i) {
            switch (i) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 15:
                case 18:
                    return true;
                default:
                    return false;
            }
        }
    }

    public interface b {
        void a(List<m> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i, int i2);

        void bkJ();
    }

    public at(b bVar, String str, boolean z) {
        this.qFM = bVar;
        this.userName = str;
        this.fJm = z;
    }

    public final void by(List<m> list) {
        if (this.qFM != null) {
            if (list != null) {
                b(true, list);
            }
            this.qFM.bkJ();
        }
    }

    public final List<m> bia() {
        w.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", new Object[]{Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(ai.a(this.userName, this.fJm, this.lri, this.qFL).size())});
        return ai.a(this.userName, this.fJm, this.lri, this.qFL);
    }

    public final void bkK() {
        Collections.sort(this.fRK, this.pSw);
    }

    final void bkL() {
        b(false, this.fRK);
    }

    public final void e(String str, boolean z, boolean z2) {
        w.d("MicroMsg.SnsSelfHelper", "limitSeq " + str);
        this.lri = str;
        this.qFL = z;
        fu(z2);
    }

    private void b(boolean z, List<m> list) {
        this.qFN = new a(this);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Map hashMap3 = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        if (z && this.fJm) {
            m mVar = new m((byte) 0);
            mVar.field_snsId = 0;
            mVar.qnk = -1;
            mVar.fN((int) (System.currentTimeMillis() / 1000));
            list.add(0, mVar);
        }
        int size = list.size();
        w.d("MicroMsg.SnsSelfHelper", "initFixType " + size);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            int i5;
            int i6;
            a aVar = this.qFN;
            aVar.qFQ = -1;
            aVar.qGa = -1;
            aVar.qFP = -1;
            aVar.qFU = "";
            aVar.qFV = "";
            aVar.qFW = "";
            aVar.qFZ = false;
            aVar.qFR = false;
            aVar.qGb = false;
            aVar.qGc = -1;
            aVar.qFS = -1;
            aVar.qFX = -1;
            aVar.qFY = 0;
            aVar.qFT = 0;
            aVar.qGd = 0;
            if (this.fJm && i3 == 0) {
                i5 = 1;
            } else {
                bfc bhd;
                if (i3 + 1 < size) {
                    mVar = (m) list.get(i3 + 1);
                    this.qFN.qFQ = mVar.field_head;
                    bhd = mVar.bhd();
                    this.qFN.qFU = bhd.ufy;
                    this.qFN.qFR = ai.O(mVar.field_localPrivate, this.fJm);
                    this.qFN.qFS = mVar.field_type;
                    if (bhd.ufB != null) {
                        this.qFN.qFT = bhd.ufB.tsO.size();
                    } else {
                        this.qFN.qFT = 0;
                    }
                }
                if (i3 + 2 < size) {
                    mVar = (m) list.get(i3 + 2);
                    this.qFN.qGa = mVar.field_head;
                    bhd = mVar.bhd();
                    this.qFN.qFV = bhd.ufy;
                    this.qFN.qGb = ai.O(mVar.field_localPrivate, this.fJm);
                    this.qFN.qGc = mVar.field_type;
                    if (bhd.ufB != null) {
                        this.qFN.qGd = bhd.ufB.tsO.size();
                    } else {
                        this.qFN.qGd = 0;
                    }
                }
                mVar = (m) list.get(i3);
                this.qFN.qFP = mVar.field_head;
                bhd = mVar.bhd();
                this.qFN.qFW = bhd.ufy;
                this.qFN.qFX = mVar.field_type;
                this.qFN.qFZ = ai.O(mVar.field_localPrivate, this.fJm);
                if (bhd.ufB != null) {
                    this.qFN.qFY = bhd.ufB.tsO.size();
                } else {
                    this.qFN.qFY = 0;
                }
                aVar = this.qFN;
                Object obj = aVar.qFX == 2 ? 1 : aVar.qFQ == -1 ? 1 : aVar.qFX != aVar.qFS ? 1 : a.uc(aVar.qFX) ? 1 : a.uc(aVar.qFS) ? 1 : (aVar.qFY > 1 || aVar.qFT > 1) ? 1 : (aVar.qFW == null || aVar.qFW.equals("")) ? (aVar.qFU == null || aVar.qFU.equals("")) ? aVar.qFP != aVar.qFQ ? 1 : null : 1 : 1;
                if (obj != null) {
                    i5 = 1;
                } else {
                    aVar = this.qFN;
                    obj = aVar.qGa == -1 ? 1 : aVar.qFS != aVar.qGc ? 1 : a.uc(aVar.qGc) ? 1 : aVar.qGd > 1 ? 1 : (aVar.qFV == null || aVar.qFV.equals("")) ? aVar.qFQ != aVar.qGa ? 1 : null : 1;
                    i5 = obj != null ? 2 : 3;
                }
            }
            hashMap.put(Integer.valueOf(i4), Integer.valueOf(i2));
            hashMap2.put(Integer.valueOf(i4), Integer.valueOf(i5));
            i2 += i5;
            hashMap3.put(Integer.valueOf(i4), Integer.valueOf(i));
            if (this.fJm && i3 == 0) {
                i6 = 0;
            } else {
                i6 = 0;
                if (i5 > 0 && this.qFN.qFX == 1) {
                    i6 = 1;
                }
                if (i5 >= 2 && this.qFN.qFS == 1) {
                    i6++;
                }
                if (i5 >= 3 && this.qFN.qGc == 1) {
                    i6++;
                }
            }
            i += i6;
            i3 += i5;
            i4++;
        }
        this.qoX = i4;
        this.qoY = list.size();
        w.d("MicroMsg.SnsSelfHelper", "icount " + this.qoX);
        this.fRK = list;
        i.Q("SnsphotoAdapter initFixType ", currentTimeMillis);
        this.qFM.a(this.fRK, hashMap, hashMap2, hashMap3, this.qoY, this.qoX);
    }
}
