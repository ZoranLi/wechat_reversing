package com.tencent.mm.performance.wxperformancetool;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.performance.d.a;
import java.util.Iterator;

public final class b extends HandlerThread {
    public static int igX = 2500;
    private c igW;
    public boolean igY = false;
    public Handler mHandler;

    class AnonymousClass1 extends Handler {
        final /* synthetic */ b igZ;

        AnonymousClass1(b bVar, Looper looper) {
            this.igZ = bVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    Iterator it = this.igZ.igW.iha.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        if (aVar.Nd()) {
                            aVar.Nc();
                        }
                    }
                    if (!this.igZ.igY) {
                        this.igZ.mHandler.sendEmptyMessageDelayed(1, (long) b.igX);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public b(String str, c cVar) {
        super(str);
        this.igW = cVar;
    }
}
