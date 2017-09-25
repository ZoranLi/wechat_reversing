package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.wcdb.support.OperationCanceledException;
import java.util.List;

public abstract class e extends a {
    public f lZW;
    public int lZX;

    public abstract List<i> a(String[] strArr, f fVar);

    public e(f fVar) {
        this.lZW = fVar;
    }

    public final boolean execute() {
        final g gVar = new g(this.lZW);
        try {
            gVar.mah = this;
            gVar.mai = xb(this.lZW.fRM);
            gVar.maj = a(gVar.mai, this.lZW);
            this.lZX = gVar.maj.size();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            gVar.aMA = 0;
            if (this.lZW.handler == null) {
                this.lZW.mag.a(gVar);
            } else {
                this.lZW.handler.post(new Runnable(this) {
                    final /* synthetic */ e lZY;

                    public final void run() {
                        this.lZY.lZW.mag.a(gVar);
                    }
                });
            }
            return true;
        } catch (Exception e) {
            Exception e2 = e;
            if (e2 instanceof InterruptedException) {
                gVar.aMA = 1;
            } else if (e2 instanceof OperationCanceledException) {
                Exception interruptedException = new InterruptedException(e2.getMessage());
                gVar.aMA = 1;
                e2 = interruptedException;
            } else {
                gVar.aMA = -1;
            }
            throw e2;
        } catch (Throwable th) {
            if (this.lZW.handler == null) {
                this.lZW.mag.a(gVar);
            } else {
                this.lZW.handler.post(/* anonymous class already generated */);
            }
        }
    }

    public String[] xb(String str) {
        return a.lZD.split(SpellMap.mx(str));
    }

    public String toString() {
        return String.format("%s[%s]: %d", new Object[]{super.toString(), this.lZW.fRM, Integer.valueOf(this.lZX)});
    }
}
