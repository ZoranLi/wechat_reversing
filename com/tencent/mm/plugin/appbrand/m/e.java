package com.tencent.mm.plugin.appbrand.m;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.sdk.d.d;
import java.util.LinkedList;
import java.util.Queue;

public abstract class e<Task> extends d {
    public final b jnP = new b(this);
    private final a jnQ = new a(this);
    public final String jnR;
    public final Queue<Task> jnS = new LinkedList();

    private final class a extends c {
        final /* synthetic */ e jnT;

        public a(e eVar) {
            this.jnT = eVar;
        }

        public final boolean f(Message message) {
            if (2 != message.what) {
                return super.f(message);
            }
            this.jnT.b(this.jnT.jnP);
            return true;
        }

        public final String getName() {
            return this.jnT.jnR + "|StateExecuting";
        }
    }

    private final class b extends c {
        final /* synthetic */ e jnT;

        public b(e eVar) {
            this.jnT = eVar;
        }

        public final void enter() {
            super.enter();
            this.jnT.XK();
        }

        public final boolean f(Message message) {
            if (1 != message.what && 2 != message.what) {
                return super.f(message);
            }
            this.jnT.XK();
            return true;
        }

        public final String getName() {
            return this.jnT.jnR + "|StateIdle";
        }
    }

    public abstract boolean Tp();

    public abstract void aJ(Task task);

    public e(String str, Looper looper) {
        super(str, looper);
        this.jnR = str;
        b(this.jnP);
        b(this.jnQ);
        c(this.jnP);
        start();
    }

    protected final void XJ() {
        super.XJ();
        synchronized (this.jnS) {
            this.jnS.clear();
        }
    }

    public final void XK() {
        synchronized (this.jnS) {
            Object poll = this.jnS.poll();
        }
        if (poll != null) {
            b(this.jnQ);
            aJ(poll);
        }
    }
}
