package com.tencent.mm.plugin.fts;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import java.util.LinkedList;

public final class b extends a implements Runnable {
    int errorCode = -2;
    public f lYe;

    public b(f fVar) {
        this.lYe = fVar;
    }

    public final boolean execute() {
        if (this.errorCode == -2 || this.errorCode == -3) {
            final g gVar = new g(this.lYe);
            gVar.mah = this;
            gVar.aMA = this.errorCode;
            gVar.maj = new LinkedList();
            gVar.mai = new String[]{this.lYe.fRM};
            if (this.lYe.handler == null) {
                this.lYe.mag.a(gVar);
            } else {
                this.lYe.handler.post(new Runnable(this) {
                    final /* synthetic */ b lYg;

                    public final void run() {
                        this.lYg.lYe.mag.a(gVar);
                    }
                });
            }
        }
        return true;
    }

    public final void run() {
        try {
            execute();
        } catch (Exception e) {
        }
    }

    public final int getPriority() {
        return 0;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final int getId() {
        return -1;
    }
}
