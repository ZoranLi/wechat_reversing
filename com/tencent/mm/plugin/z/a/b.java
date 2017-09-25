package com.tencent.mm.plugin.z.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b implements com.tencent.mm.plugin.z.a.a.a {
    public List<String> hHV = new LinkedList();
    public ae jiB = new ae(Looper.getMainLooper());
    public Map<String, List<a>> oGe = new HashMap();
    public Map<String, Set<Integer>> oGf = new HashMap();
    String oGg;
    a oGh;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String oGi;
        final /* synthetic */ a oGj;
        final /* synthetic */ b oGl;

        public AnonymousClass2(b bVar, String str, a aVar) {
            this.oGl = bVar;
            this.oGi = str;
            this.oGj = aVar;
        }

        public final void run() {
            b bVar = this.oGl;
            String str = this.oGi;
            a aVar = this.oGj;
            List<a> list = (List) bVar.oGe.get(str);
            if (list != null) {
                for (a aVar2 : list) {
                    if (aVar2 != null && aVar2 == aVar) {
                        list.remove(aVar2);
                        break;
                    }
                }
            } else {
                w.e("MicroMsg.FileScanQueueService", "removeFormCallbackList, list is null");
            }
            if (list != null && list.isEmpty()) {
                bVar.oGe.remove(str);
                bVar.hHV.remove(str);
                bVar.oGf.remove(str);
                if (bVar.oGg != null && bVar.oGg.equals(str)) {
                    a aVar3 = bVar.oGh;
                    w.i("MicroMsg.scanner.DecodeFile", "cancelled");
                    aVar3.il = true;
                    bVar.oGh = null;
                }
                bVar.aVy();
            }
        }
    }

    public interface a {
        void Dd(String str);

        void i(String str, String str2, int i, int i2);
    }

    public final void a(final String str, final a aVar, final Set<Integer> set) {
        w.i("MicroMsg.FileScanQueueService", "startDecodeBlockLoop, fileUri: %s, callback: %x", new Object[]{str, Integer.valueOf(aVar.hashCode())});
        if (bg.mA(str)) {
            w.e("MicroMsg.FileScanQueueService", "start failed, uri is null or nil");
        } else {
            this.jiB.post(new Runnable(this) {
                final /* synthetic */ b oGl;

                public final void run() {
                    b bVar = this.oGl;
                    String str = str;
                    a aVar = aVar;
                    bVar.oGf.put(str, set);
                    if (bVar.oGe.containsKey(str)) {
                        List<a> list = (List) bVar.oGe.get(str);
                        if (list != null) {
                            if (list != null) {
                                Object obj;
                                if (list != null && list.size() != 0) {
                                    for (a aVar2 : list) {
                                        if (aVar2 != null && aVar2 == aVar) {
                                            obj = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    w.e("MicroMsg.FileScanQueueService", "isCallbackInList, list is null or nil");
                                }
                                obj = null;
                                if (obj == null) {
                                    list.add(aVar);
                                }
                            }
                            w.e("MicroMsg.FileScanQueueService", "addToCallbackList, list is null or callback is already in list");
                        }
                        bVar.aVy();
                        return;
                    }
                    List linkedList = new LinkedList();
                    linkedList.add(aVar);
                    bVar.oGe.put(str, linkedList);
                    bVar.hHV.add(str);
                    bVar.aVy();
                }
            });
        }
    }

    final void aVy() {
        if (this.oGh != null) {
            w.d("MicroMsg.FileScanQueueService", "it is scanning");
        } else if (this.oGe.isEmpty()) {
            w.d("MicroMsg.FileScanQueueService", "queue is empty");
        } else {
            this.oGg = (String) this.hHV.get(0);
            this.hHV.remove(0);
            this.oGh = new a();
            this.oGh.fTc = (Set) this.oGf.get(this.oGg);
            a aVar = this.oGh;
            String str = this.oGg;
            w.i("MicroMsg.scanner.DecodeFile", "start decode file: " + str);
            aVar.oGa = this;
            af.v(new com.tencent.mm.plugin.z.a.a.AnonymousClass1(aVar, str));
        }
    }

    public final int a(final d dVar) {
        this.jiB.post(new Runnable(this) {
            final /* synthetic */ b oGl;

            public final void run() {
                b bVar = this.oGl;
                d dVar = dVar;
                w.i("MicroMsg.FileScanQueueService", "onFinishScan fileUri: %s, result: %s", new Object[]{bVar.oGg, dVar});
                List<a> list = (List) bVar.oGe.get(bVar.oGg);
                if (list != null && dVar != null) {
                    w.d("MicroMsg.FileScanQueueService", "onFinishScan, callback size: %d", new Object[]{Integer.valueOf(list.size())});
                    for (a i : list) {
                        i.i(bVar.oGg, dVar.result, dVar.fFo, dVar.fFp);
                    }
                } else if (list != null) {
                    for (a i2 : list) {
                        i2.Dd(bVar.oGg);
                    }
                }
                bVar.oGe.remove(bVar.oGg);
                bVar.oGf.remove(bVar.oGg);
                bVar.oGg = null;
                bVar.oGh = null;
                bVar.aVy();
            }
        });
        return 0;
    }
}
