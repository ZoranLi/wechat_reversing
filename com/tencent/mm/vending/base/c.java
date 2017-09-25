package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class c {
    private Handler mVendingHandler;
    private Looper mVendingLooper;
    private Looper wCr;
    private Handler wCs;
    public byte[] wCt = new byte[0];
    public a wCu;

    public interface a {
        void cbu();

        void cbv();

        void synchronizing(int i, Object obj);
    }

    public c(Looper looper, Looper looper2) {
        this.wCr = looper;
        this.mVendingLooper = looper2;
        this.wCs = new Handler(this, this.wCr) {
            final /* synthetic */ c wCv;

            public final void handleMessage(Message message) {
                this.wCv.i(message.what, message.obj);
            }
        };
        this.mVendingHandler = new Handler(this, this.mVendingLooper) {
            final /* synthetic */ c wCv;

            public final void handleMessage(Message message) {
                synchronized (this.wCv.wCt) {
                    if (this.wCv.wCu != null) {
                        this.wCv.wCu.synchronizing(message.what, message.obj);
                    }
                    this.wCv.wCt.notify();
                }
            }
        };
    }

    public final void i(int i, Object obj) {
        if (Looper.myLooper() == this.wCr) {
            if (this.wCu == null) {
                com.tencent.mm.vending.f.a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
                return;
            }
            this.wCu.cbu();
            synchronized (this.wCt) {
                this.mVendingHandler.sendMessageAtFrontOfQueue(this.mVendingHandler.obtainMessage(i, obj));
                try {
                    this.wCt.wait();
                } catch (InterruptedException e) {
                }
            }
            this.wCu.cbv();
        } else if (Looper.myLooper() == this.mVendingLooper) {
            this.wCs.sendMessageAtFrontOfQueue(this.wCs.obtainMessage(i, obj));
        }
    }
}
