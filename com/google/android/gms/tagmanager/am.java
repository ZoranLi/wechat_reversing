package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.api.Status;

final class am implements b {
    private a aFo;
    private a aFp;
    private Status aFq;
    private b aFr;
    a aFs;
    boolean aFt;
    private d aFu;

    public interface a {
        String mv();
    }

    private class b extends Handler {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Object obj = message.obj;
                    return;
                default:
                    m.lQ();
                    return;
            }
        }
    }

    public final synchronized void ao(String str) {
        if (!this.aFt) {
            this.aFo.lK().ao(str);
        }
    }

    public final Status jv() {
        return this.aFq;
    }

    final String mt() {
        if (!this.aFt) {
            return this.aFo.aDJ;
        }
        m.lQ();
        return "";
    }

    final void mu() {
        if (this.aFt) {
            m.lQ();
        }
    }

    public final synchronized void refresh() {
        if (this.aFt) {
            m.lQ();
        }
    }

    public final synchronized void release() {
        if (this.aFt) {
            m.lQ();
        } else {
            this.aFt = true;
            this.aFu.aEa.remove(this);
            this.aFo.aDK = null;
            this.aFo = null;
            this.aFp = null;
            this.aFs = null;
            this.aFr = null;
        }
    }
}
