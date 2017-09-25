package com.tencent.mm.plugin.fps_lighter.a;

import android.util.SparseArray;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.fps_lighter.b.c;
import com.tencent.mm.plugin.fps_lighter.b.g;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class b implements c {
    public c lPk;
    private long lPo = System.currentTimeMillis();
    public long[] lPp = new long[7200];
    public int lPq = 0;
    public int lPr = 0;
    SparseArray<ArrayList<a>> lPs = new SparseArray();

    class a {
        final /* synthetic */ b lPt;
        com.tencent.mm.plugin.fps_lighter.e.a.a lPu = com.tencent.mm.plugin.fps_lighter.e.a.mE(this.lPw);
        long lPv;
        int lPw;
        int scene;

        a(b bVar, int i, Long l) {
            this.lPt = bVar;
            this.scene = i;
            this.lPv = l.longValue();
            this.lPw = com.tencent.mm.plugin.fps_lighter.e.a.b(l.longValue(), bVar.lPk.lPH);
        }

        public final String toString() {
            return "scene:" + this.scene + ",durtime:" + this.lPv + ",answer:" + this.lPu.toString();
        }
    }

    public b(c cVar) {
        this.lPk = cVar;
    }

    public final void a(int i, long j, long j2, int i2, int i3, boolean z, long j3, boolean z2) {
        if ((System.currentTimeMillis() - this.lPo > c.avF() ? 1 : null) != null) {
            g.avJ();
            g.MM().post(new Runnable(this) {
                final /* synthetic */ b lPt;

                {
                    this.lPt = r1;
                }

                public final void run() {
                    if (this.lPt.lPq != this.lPt.lPr) {
                        b bVar = this.lPt;
                        long[] jArr = this.lPt.lPp;
                        int i = this.lPt.lPq;
                        if (jArr == null) {
                            w.w("MicroMsg.FrameReportCallback", "null == datas");
                            return;
                        }
                        int length;
                        Object obj;
                        long j;
                        int i2;
                        int i3;
                        int[] iArr = new int[5];
                        int[] iArr2 = new int[5];
                        if (bVar.lPr >= i) {
                            length = jArr.length;
                            obj = 1;
                            w.d("MicroMsg.FrameReportCallback", "isSpecial:%s mLastIndex:%s mNowIndex:%s", new Object[]{Boolean.valueOf(true), Integer.valueOf(bVar.lPr), Integer.valueOf(i)});
                        } else {
                            obj = null;
                            length = i;
                        }
                        int i4 = length;
                        length = bVar.lPr;
                        Object obj2 = obj;
                        while (length < i4 && jArr[length] != 0) {
                            Object obj3;
                            j = jArr[length];
                            long j2 = j >> 58;
                            a aVar = new a(bVar, (int) j2, Long.valueOf(j & 288230376151711743L));
                            ArrayList arrayList = (ArrayList) bVar.lPs.get((int) j2);
                            if (arrayList == null) {
                                arrayList = new ArrayList(7800);
                                arrayList.add(aVar);
                                bVar.lPs.append((int) j2, arrayList);
                            } else {
                                arrayList.add(aVar);
                            }
                            if (length != i4 - 1 || obj2 == null) {
                                i2 = length;
                                obj3 = obj2;
                                i3 = i4;
                            } else {
                                i2 = -1;
                                obj3 = null;
                                i3 = i;
                            }
                            bVar.lPr = i2 + 1;
                            i4 = i3;
                            obj2 = obj3;
                            length = i2 + 1;
                        }
                        List list = null;
                        int[] iArr3 = iArr2;
                        int[] iArr4 = iArr;
                        int i5 = 0;
                        while (i5 < bVar.lPs.size()) {
                            List arrayList2;
                            j = 0;
                            for (i2 = 0; i2 < 5; i2++) {
                                iArr4[i2] = 0;
                                iArr3[i2] = 0;
                            }
                            i2 = bVar.lPs.keyAt(i5);
                            ArrayList arrayList3 = (ArrayList) bVar.lPs.get(i2);
                            w.i("MicroMsg.FrameReportCallback", "scene:%s size:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(arrayList3.size())});
                            int i6 = 0;
                            int i7 = -1;
                            int[] iArr5 = iArr4;
                            while (i6 < arrayList3.size()) {
                                int[] iArr6;
                                long j3;
                                a aVar2 = (a) arrayList3.get(i6);
                                if (aVar2.lPv <= 0) {
                                    w.e("MicroMsg.FrameReportCallback", "[reportSample] %s", new Object[]{aVar2});
                                }
                                long j4 = aVar2.lPv + j;
                                if (aVar2.lPu == com.tencent.mm.plugin.fps_lighter.e.a.a.BAD) {
                                    iArr5[0] = iArr5[0] + 1;
                                    iArr3[0] = aVar2.lPw + iArr3[0];
                                } else if (aVar2.lPu == com.tencent.mm.plugin.fps_lighter.e.a.a.MEDIUM) {
                                    iArr5[1] = iArr5[1] + 1;
                                    iArr3[1] = aVar2.lPw + iArr3[1];
                                } else if (aVar2.lPu == com.tencent.mm.plugin.fps_lighter.e.a.a.SLIGHT) {
                                    iArr5[2] = iArr5[2] + 1;
                                    iArr3[2] = aVar2.lPw + iArr3[2];
                                } else if (aVar2.lPu == com.tencent.mm.plugin.fps_lighter.e.a.a.GOOD) {
                                    iArr5[3] = iArr5[3] + 1;
                                    iArr3[3] = aVar2.lPw + iArr3[3];
                                } else if (aVar2.lPu == com.tencent.mm.plugin.fps_lighter.e.a.a.BEST) {
                                    iArr5[4] = iArr5[4] + 1;
                                    iArr3[4] = iArr3[4] + 0;
                                }
                                if (j4 >= c.avG()) {
                                    bVar.a(i2, iArr5, iArr3, j4);
                                    iArr6 = new int[5];
                                    iArr = new int[5];
                                    j3 = 0;
                                    i4 = i6;
                                } else {
                                    iArr = iArr3;
                                    iArr6 = iArr5;
                                    j3 = j4;
                                    i4 = i7;
                                }
                                i6++;
                                i7 = i4;
                                long j5 = j3;
                                iArr3 = iArr;
                                iArr5 = iArr6;
                                j = j5;
                            }
                            if (-1 != i7) {
                                arrayList2 = list == null ? new ArrayList(arrayList3.size() - i7) : list;
                                for (i3 = i7 + 1; i3 < arrayList3.size(); i3++) {
                                    arrayList2.add(arrayList3.get(i3));
                                }
                                arrayList3.clear();
                                for (i3 = 0; i3 < arrayList2.size(); i3++) {
                                    arrayList3.add(arrayList2.get(i3));
                                }
                                arrayList2.clear();
                            } else {
                                arrayList2 = list;
                            }
                            list = arrayList2;
                            i5++;
                            iArr4 = iArr5;
                        }
                    }
                }
            });
            this.lPo = System.currentTimeMillis();
        } else if (i != -1) {
            this.lPp[this.lPq] = ((0 | ((long) i)) << 58) | TimeUnit.NANOSECONDS.convert(j2 - j, TimeUnit.MILLISECONDS);
            this.lPq++;
            if (this.lPq == this.lPp.length) {
                this.lPq = 0;
            }
        }
    }

    public final void H(int i, boolean z) {
    }

    final void a(int i, int[] iArr, int[] iArr2, long j) {
        if (this.lPk == null) {
            w.d("MicroMsg.FrameReportCallback", "it maybe was stopped!");
            return;
        }
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (i2 = 0; i2 < 5; i2++) {
            double d;
            if (iArr[i2] == 0) {
                d = 0.0d;
            } else {
                d = (double) ((((((float) iArr2[i2]) * 1.0f) / ((float) j)) * ((float) c.avG())) / ((float) iArr[i2]));
            }
            w.i("MicroMsg.FrameReportCallback", "scene:%s  DeviceLevel:%s frame state[index:%s],count:%s avery dropcount:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(this.lPk.lPN), Integer.valueOf(i2), Integer.valueOf(iArr[i2]), Double.valueOf(d)});
            i3 += iArr[i2];
            if (i3 > 1800) {
                w.e("MicroMsg.FrameReportCallback", "frame rate is not normal! %s", new Object[]{Integer.valueOf(i3)});
            }
            w.i("MicroMsg.FrameReportCallback", "scene:%s index:%s metrics[index]:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(iArr[i2])});
            IDKey iDKey = new IDKey();
            IDKey iDKey2 = new IDKey();
            IDKey iDKey3 = new IDKey();
            switch (i) {
                case 0:
                    iDKey.SetID(349);
                    iDKey2.SetID(349);
                    iDKey3.SetID(349);
                    break;
                case 1:
                    iDKey.SetID(350);
                    iDKey2.SetID(350);
                    iDKey3.SetID(350);
                    break;
                case 2:
                    iDKey.SetID(351);
                    iDKey2.SetID(351);
                    iDKey3.SetID(351);
                    break;
                case 3:
                    iDKey.SetID(352);
                    iDKey2.SetID(352);
                    iDKey3.SetID(352);
                    break;
                case 4:
                    iDKey.SetID(353);
                    iDKey2.SetID(353);
                    iDKey3.SetID(353);
                    break;
                case 5:
                    iDKey.SetID(364);
                    iDKey2.SetID(364);
                    iDKey3.SetID(364);
                    break;
            }
            iDKey.SetKey(((i2 * 4) + 24) + this.lPk.lPN);
            iDKey.SetValue((int) Math.round(d));
            iDKey2.SetKey((this.lPk.lPN * 5) + i2);
            iDKey2.SetValue(iArr[i2]);
            iDKey3.SetKey(((i2 * 4) + m.CTRL_INDEX) + this.lPk.lPN);
            if (d > 0.0d) {
                iDKey3.SetValue(1);
            }
            if (iDKey.GetValue() > 0) {
                arrayList.add(iDKey);
            }
            if (iDKey2.GetValue() > 0) {
                arrayList.add(iDKey2);
            }
            if (iDKey3.GetValue() > 0) {
                arrayList.add(iDKey3);
            }
        }
        IDKey iDKey4 = new IDKey();
        IDKey iDKey5 = new IDKey();
        switch (i) {
            case 0:
                iDKey4.SetID(349);
                iDKey5.SetID(349);
                break;
            case 1:
                iDKey4.SetID(350);
                iDKey5.SetID(350);
                break;
            case 2:
                iDKey4.SetID(351);
                iDKey5.SetID(351);
                break;
            case 3:
                iDKey4.SetID(352);
                iDKey5.SetID(352);
                break;
            case 4:
                iDKey4.SetID(353);
                iDKey5.SetID(353);
                break;
            case 5:
                iDKey4.SetID(364);
                iDKey5.SetID(364);
                break;
        }
        iDKey4.SetKey(this.lPk.lPN + 20);
        w.i("MicroMsg.FrameReportCallback", "level:%s %s", new Object[]{Integer.valueOf(this.lPk.lPN), Integer.valueOf(Math.round((((float) i3) * 1.0f) / ((float) TimeUnit.SECONDS.convert(j, TimeUnit.NANOSECONDS))))});
        iDKey4.SetValue(i2);
        iDKey5.SetKey(this.lPk.lPN + 100);
        iDKey5.SetValue(1);
        if (iDKey4.GetValue() > 0) {
            arrayList.add(iDKey4);
        }
        if (iDKey5.GetValue() > 0) {
            arrayList.add(iDKey5);
        }
        com.tencent.mm.plugin.report.service.g.oUh.b(arrayList, true);
    }

    public final String toString() {
        return "MicroMsg.FrameReportCallback";
    }
}
