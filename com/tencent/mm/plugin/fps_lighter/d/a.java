package com.tencent.mm.plugin.fps_lighter.d;

import com.tencent.gmtrace.Constants;
import com.tencent.mm.plugin.fps_lighter.c.b;
import com.tencent.mm.plugin.fps_lighter.c.c;
import com.tencent.mm.plugin.fps_lighter.c.d;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

public final class a implements Runnable {
    int lCS;
    private com.tencent.mm.plugin.fps_lighter.c.a lQH;
    private long[] lQI;
    int lQJ;
    public a lQK;

    public interface a {
        void K(LinkedList<d> linkedList);
    }

    public a(long[] jArr, int i, int i2, long j, long j2, long j3, int i3, int i4, boolean z, long j4, boolean z2) {
        this.lQI = jArr;
        this.lCS = i;
        this.lQJ = i2;
        com.tencent.mm.plugin.fps_lighter.c.a aVar = new com.tencent.mm.plugin.fps_lighter.c.a();
        aVar.scene = i4;
        aVar.lQp = j3;
        aVar.lQq = j2;
        aVar.lQr = z;
        aVar.lQt = i3;
        aVar.lQs = (int) j;
        aVar.lQv = j4;
        aVar.lQw = z2;
        w.i("MicroMsg.AsyncAnalyseTask", "[generateFpsInfoItem] %s", new Object[]{aVar.toString()});
        this.lQH = aVar;
    }

    private List<b> a(List<com.tencent.mm.plugin.fps_lighter.c.b.a> list, com.tencent.mm.plugin.fps_lighter.c.a aVar) {
        w.i("MicroMsg.AsyncAnalyseTask", "[parseTrace] size:%s fpsInfoItem:%s", new Object[]{Integer.valueOf(list.size()), aVar});
        long currentTimeMillis = System.currentTimeMillis();
        List<b> linkedList = new LinkedList();
        Stack stack = new Stack();
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        for (com.tencent.mm.plugin.fps_lighter.c.b.a aVar2 : list) {
            int i5;
            int i6;
            if (aVar2.lQA) {
                aVar2.lQz = i3;
                i5 = i4 + 1;
                i3++;
                stack.push(aVar2);
                i6 = i3;
                i4 = i2;
            } else if (stack.size() <= 0) {
                w.w("MicroMsg.AsyncAnalyseTask", "Empty stack, item:%s", new Object[]{aVar2});
            } else {
                com.tencent.mm.plugin.fps_lighter.c.b.a aVar3 = (com.tencent.mm.plugin.fps_lighter.c.b.a) stack.peek();
                if (aVar3.lQy != aVar2.lQy) {
                    w.w("MicroMsg.AsyncAnalyseTask", "No match in rawItem:%s topRawItem:%s", new Object[]{aVar2, aVar3});
                    stack.pop();
                    i4--;
                    while (stack.size() > 0) {
                        aVar3 = (com.tencent.mm.plugin.fps_lighter.c.b.a) stack.peek();
                        if (aVar2.lQy == aVar3.lQy) {
                            w.w("MicroMsg.AsyncAnalyseTask", "Find it");
                            break;
                        }
                        stack.pop();
                        i4--;
                    }
                    if (stack.size() == 0) {
                        w.w("MicroMsg.AsyncAnalyseTask", "Still can't find it, ignore this out %s", new Object[]{aVar2});
                    }
                }
                com.tencent.mm.plugin.fps_lighter.c.b.a aVar4 = aVar3;
                i5 = i4;
                com.tencent.mm.plugin.fps_lighter.c.b.a aVar5 = aVar4;
                stack.pop();
                i = i5 - 1;
                b bVar = new b();
                bVar.hKa = i;
                if (stack.size() == 0) {
                    bVar.lQx = -1;
                } else {
                    bVar.lQx = ((com.tencent.mm.plugin.fps_lighter.c.b.a) stack.peek()).lQy;
                }
                bVar.beginTime = aVar5.hTv;
                bVar.lQy = aVar5.lQy;
                bVar.jgm = aVar2.hTv - aVar5.hTv;
                bVar.lQz = aVar5.lQz;
                if (bVar.beginTime >= aVar.lQq && bVar.beginTime <= aVar.lQp) {
                    linkedList.add(bVar);
                    i6 = i3;
                    i5 = i;
                    i4 = i2;
                } else if (bVar.beginTime <= aVar.lQq) {
                    i6 = i3;
                    i5 = i;
                    i4 = i2 + 1;
                } else {
                    i6 = i3;
                    i5 = i;
                    i4 = i2;
                }
            }
            i = linkedList.size() + i4;
            i2 = i4;
            i3 = i6;
            i4 = i5;
        }
        w.i("MicroMsg.AsyncAnalyseTask", "[parseGmTraceItem] startIndex:%s endIndex:%s pre:%s cur:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(aVar.lQq), Long.valueOf(aVar.lQp)});
        Collections.sort(linkedList, new Comparator<b>(this) {
            final /* synthetic */ a lQL;

            {
                this.lQL = r1;
            }

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((b) obj).lQz - ((b) obj2).lQz;
            }
        });
        w.i("MicroMsg.AsyncAnalyseTask", "[parseTrace]result size:%s rawItemList:%s costTime:%s", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(list.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        list.clear();
        return linkedList;
    }

    private List<c> az(List<b> list) {
        long currentTimeMillis = System.currentTimeMillis();
        w.i("MicroMsg.AsyncAnalyseTask", "[sortBySameMethod] list size:%s", new Object[]{Integer.valueOf(list.size())});
        List<c> linkedList = new LinkedList();
        HashMap aA = aA(list);
        HashMap hashMap = new HashMap(600);
        for (Entry value : aA.entrySet()) {
            a(hashMap, (List) value.getValue());
        }
        for (Entry value2 : hashMap.entrySet()) {
            linkedList.add(value2.getValue());
        }
        Collections.sort(linkedList, new Comparator<c>(this) {
            final /* synthetic */ a lQL;

            {
                this.lQL = r1;
            }

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                c cVar = (c) obj;
                c cVar2 = (c) obj2;
                return cVar.hKa - cVar2.hKa == 0 ? (int) (cVar2.lQE - cVar.lQE) : cVar.hKa - cVar2.hKa;
            }
        });
        hashMap.clear();
        list.clear();
        w.i("MicroMsg.AsyncAnalyseTask", "[sortBySameMethod] cost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return linkedList;
    }

    private static void a(HashMap<String, c> hashMap, List<b> list) {
        for (b bVar : list) {
            if (hashMap.containsKey(bVar.getKey())) {
                c cVar = (c) hashMap.get(bVar.getKey());
                cVar.hXR++;
                cVar.lQC.add(bVar.jgm);
                cVar.lQD.add(bVar.beginTime);
                cVar.lQE += bVar.jgm;
            } else {
                hashMap.put(bVar.getKey(), new c(bVar));
            }
        }
    }

    private static HashMap<Integer, List<b>> aA(List<b> list) {
        HashMap<Integer, List<b>> hashMap = new HashMap();
        for (b bVar : list) {
            if (!hashMap.containsKey(Integer.valueOf(bVar.hKa))) {
                hashMap.put(Integer.valueOf(bVar.hKa), new ArrayList());
            }
            ((List) hashMap.get(Integer.valueOf(bVar.hKa))).add(bVar);
        }
        return hashMap;
    }

    private LinkedList<d> a(com.tencent.mm.plugin.fps_lighter.c.a aVar, List<c> list) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        LinkedList<d> linkedList = new LinkedList();
        for (c cVar : list) {
            d dVar = new d(aVar, cVar);
            hashMap2.put(cVar.getKey(), cVar);
            if (((float) cVar.lQE) >= ((float) aVar.avK()) * 0.4f && cVar.hKa == 0) {
                dVar.cl(cVar.lQx);
                hashMap.put(Long.valueOf(cVar.lQy), dVar);
            } else if (((float) cVar.lQE) < ((float) aVar.avK()) * 0.4f && cVar.hKa == 0 && hashMap.size() == 0) {
                if (((double) cVar.lQE) >= 16.6d && hashMap3.size() <= 6) {
                    dVar.cl(cVar.lQx);
                }
            } else if (hashMap.containsKey(Long.valueOf(cVar.lQx))) {
                dVar.a(((d) hashMap.get(Long.valueOf(cVar.lQx))).lQG);
                dVar.cl(cVar.lQx);
                if (((float) cVar.lQE) >= ((float) aVar.avK()) * 0.4f) {
                    hashMap.remove(Long.valueOf(cVar.lQx));
                    hashMap.put(Long.valueOf(cVar.lQy), dVar);
                } else {
                    if (!hashMap4.containsKey(cVar.avL())) {
                        hashMap4.put(cVar.avL(), new ArrayList());
                    }
                    List<d> list2 = (List) hashMap4.get(cVar.avL());
                    list2.add(dVar);
                    if (6 >= list2.size() && list2.size() >= 2) {
                        Collections.sort(list2, new Comparator<d>(this) {
                            final /* synthetic */ a lQL;

                            {
                                this.lQL = r1;
                            }

                            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                return (int) (((d) obj2).lQE - ((d) obj).lQE);
                            }
                        });
                        long j = 0;
                        for (d dVar2 : list2) {
                            long j2 = dVar2.lQE + j;
                            if (!hashMap2.containsKey(cVar.avL()) || ((float) j2) < ((float) ((c) hashMap2.get(cVar.avL())).lQE) * 0.8f) {
                                j = j2;
                            } else {
                                if (((float) dVar2.lQE) >= 1.0f) {
                                    if (hashMap.containsKey(Long.valueOf(cVar.lQx))) {
                                        hashMap.remove(Long.valueOf(cVar.lQx));
                                    }
                                    hashMap3.put(dVar2.lQy + ">" + dVar2.hKa, dVar2);
                                }
                                hashMap4.remove(cVar.avL());
                            }
                        }
                        hashMap4.remove(cVar.avL());
                    }
                }
            }
            if (hashMap3.containsKey(cVar.avL()) && ((float) ((d) hashMap3.get(cVar.avL())).lQE) * 0.9f <= ((float) cVar.lQE)) {
                dVar.a(((d) hashMap3.get(cVar.avL())).lQG);
                dVar.cl(cVar.lQy);
                hashMap3.remove(cVar.getKey());
                hashMap3.put(cVar.getKey(), dVar);
            }
        }
        w.i("MicroMsg.AsyncAnalyseTask", "[findEvilMethod] root size:%s", new Object[]{Integer.valueOf(hashMap.size())});
        for (Entry value : hashMap.entrySet()) {
            linkedList.add(value.getValue());
        }
        w.i("MicroMsg.AsyncAnalyseTask", "[findEvilMethod] nextHashMap size:%s", new Object[]{Integer.valueOf(hashMap3.size())});
        for (Entry value2 : hashMap3.entrySet()) {
            linkedList.add(value2.getValue());
        }
        w.i("MicroMsg.AsyncAnalyseTask", "[findEvilMethod] reportList size:%s", new Object[]{Integer.valueOf(linkedList.size())});
        hashMap.clear();
        hashMap3.clear();
        hashMap2.clear();
        return linkedList;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        long[] jArr = this.lQI;
        int i = this.lQJ;
        int i2 = this.lCS;
        w.i("MicroMsg.AsyncAnalyseTask", "[parseGmTraceRawData] start:%s, end:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        long currentTimeMillis2 = System.currentTimeMillis();
        List linkedList = new LinkedList();
        if (i2 < i) {
            i = jArr.length - i;
            w.d("MicroMsg.AsyncAnalyseTask", "end < start start:%s", new Object[]{Integer.valueOf(i)});
        }
        long j;
        com.tencent.mm.plugin.fps_lighter.c.b.a aVar;
        int i3;
        if (i < 0) {
            for (i += jArr.length; i < jArr.length; i++) {
                if (jArr[i] != 0) {
                    j = jArr[i];
                    aVar = new com.tencent.mm.plugin.fps_lighter.c.b.a();
                    aVar.lQA = ((j >> 63) & 1) == 1;
                    aVar.lQB = (j >> 46) & Constants.MAX_THREAD_ID;
                    aVar.lQy = (j >> 27) & Constants.MAX_METHOD_ID;
                    aVar.hTv = j & Constants.MAX_TIME_DIFF;
                    linkedList.add(aVar);
                }
            }
            for (i3 = 0; i3 < i2; i3++) {
                if (jArr[i3] != 0) {
                    j = jArr[i3];
                    aVar = new com.tencent.mm.plugin.fps_lighter.c.b.a();
                    aVar.lQA = ((j >> 63) & 1) == 1;
                    aVar.lQB = (j >> 46) & Constants.MAX_THREAD_ID;
                    aVar.lQy = (j >> 27) & Constants.MAX_METHOD_ID;
                    aVar.hTv = j & Constants.MAX_TIME_DIFF;
                    linkedList.add(aVar);
                }
            }
        } else {
            for (i3 = i; i3 < i2; i3++) {
                if (jArr[i3] != 0) {
                    j = jArr[i3];
                    aVar = new com.tencent.mm.plugin.fps_lighter.c.b.a();
                    aVar.lQA = ((j >> 63) & 1) == 1;
                    aVar.lQB = (j >> 46) & Constants.MAX_THREAD_ID;
                    aVar.lQy = (j >> 27) & Constants.MAX_METHOD_ID;
                    aVar.hTv = j & Constants.MAX_TIME_DIFF;
                    linkedList.add(aVar);
                }
            }
        }
        w.i("MicroMsg.AsyncAnalyseTask", "[parseGmTraceRawData] size:%s costTime:%s", new Object[]{Integer.valueOf(linkedList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        List a = a(linkedList, this.lQH);
        List az = az(a);
        LinkedList a2 = a(this.lQH, az);
        if (this.lQK != null) {
            this.lQK.K(a2);
        } else {
            w.e("MicroMsg.AsyncAnalyseTask", "mIFPSAnalyse is null!");
            a2.clear();
        }
        a.clear();
        az.clear();
        w.i("MicroMsg.AsyncAnalyseTask", "cost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
