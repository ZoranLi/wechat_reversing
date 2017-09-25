package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;

public abstract class d<T> {
    private ae handler;
    List<Integer> qoQ;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ d qoS;
        final /* synthetic */ List qoT;
        final /* synthetic */ boolean qoU = true;

        AnonymousClass2(d dVar, List list, boolean z) {
            this.qoS = dVar;
            this.qoT = list;
        }

        public final void run() {
            this.qoS.by(this.qoT);
            com.tencent.mm.plugin.sns.model.ae.bev().post(new AnonymousClass3(this.qoS, this.qoU));
        }
    }

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ d qoS;
        final /* synthetic */ boolean qoU;

        AnonymousClass3(d dVar, boolean z) {
            this.qoS = dVar;
            this.qoU = z;
        }

        public final void run() {
            if (this.qoU) {
                d dVar = this.qoS;
                if (dVar.qoQ.size() > 1) {
                    dVar.qoQ.remove(0);
                }
            }
        }
    }

    public abstract List<T> bia();

    public abstract void by(List<T> list);

    public d() {
        this.handler = null;
        this.qoQ = new LinkedList();
        this.handler = com.tencent.mm.plugin.sns.model.ae.ayz();
        this.qoQ.clear();
    }

    protected final void fu(final boolean z) {
        int i = z ? 0 : 1;
        if (i == 1) {
            Object obj;
            for (Integer intValue : this.qoQ) {
                if (intValue.intValue() == 1) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                w.e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
                return;
            }
        }
        if (z) {
            w.d("MicroMsg.AdapterLoader", "thread load" + this.qoQ.size());
        } else {
            w.d("MicroMsg.AdapterLoader", "ui load");
        }
        if (this.qoQ.size() <= 1) {
            this.qoQ.add(Integer.valueOf(i));
            if (z) {
                com.tencent.mm.plugin.sns.model.ae.bev().post(new Runnable(this) {
                    final /* synthetic */ d qoS;

                    public final void run() {
                        this.qoS.bx(this.qoS.bia());
                    }
                });
            } else {
                bx(bia());
            }
        }
    }

    public final void bx(List<T> list) {
        this.handler.post(new AnonymousClass2(this, list, true));
    }
}
