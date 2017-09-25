package com.tencent.mm.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class k<T> extends BaseAdapter implements com.tencent.mm.sdk.e.j.a, b {
    public Context context;
    public int count;
    private ae oPe = new ae(Looper.getMainLooper());
    private Cursor uMf = null;
    public T uSL;
    public Map<Integer, T> uSM = null;
    public a uSN;
    private int uSO = 0;
    private int uSP = 0;
    private int uSQ = 0;
    private Runnable uSR = new Runnable(this) {
        final /* synthetic */ k uSS;

        {
            this.uSS = r1;
        }

        public final void run() {
            if (this.uSS.uSO != 0) {
                w.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", Integer.valueOf(this.uSS.uSO), Integer.valueOf(k.b(this.uSS)));
                this.uSS.oPe.removeCallbacks(this.uSS.uSR);
                if (20 > this.uSS.uSQ) {
                    this.uSS.oPe.postDelayed(this.uSS.uSR, 100);
                    return;
                } else {
                    w.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", Integer.valueOf(this.uSS.uSO), Integer.valueOf(this.uSS.uSQ));
                }
            }
            w.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
            this.uSS.uSQ = 0;
            this.uSS.bPN();
        }
    };

    public interface a {
        void OH();

        void OI();
    }

    public abstract void OK();

    public abstract void OL();

    public abstract T a(T t, Cursor cursor);

    static /* synthetic */ int b(k kVar) {
        int i = kVar.uSQ + 1;
        kVar.uSQ = i;
        return i;
    }

    public k(Context context, T t) {
        this.uSL = t;
        this.context = context;
        this.count = -1;
    }

    public final Cursor getCursor() {
        if (this.uMf == null || this.uMf.isClosed()) {
            OL();
            Assert.assertNotNull(this.uMf);
        }
        return this.uMf;
    }

    public final void setCursor(Cursor cursor) {
        this.uMf = cursor;
        this.count = -1;
    }

    public final void ko(boolean z) {
        if (z) {
            if (this.uSM == null) {
                this.uSM = new HashMap();
            }
        } else if (this.uSM != null) {
            this.uSM.clear();
            this.uSM = null;
        }
    }

    public void aEW() {
        if (this.uSM != null) {
            this.uSM.clear();
        }
        if (this.uMf != null) {
            this.uMf.close();
        }
        this.count = -1;
    }

    public int getCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count + aBV();
    }

    public final int ano() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count;
    }

    public long getItemId(int i) {
        return 0;
    }

    public void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            w.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        a((String) obj, null);
    }

    public void a(String str, l lVar) {
        bPN();
    }

    private void bPN() {
        w.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
        if (this.uSN != null) {
            this.uSN.OI();
        }
        aEW();
        OK();
        if (this.uSN != null) {
            this.uSN.OH();
        }
    }

    public T getItem(int i) {
        if (nJ(i)) {
            return aBW();
        }
        T t;
        if (this.uSM != null) {
            t = this.uSM.get(Integer.valueOf(i));
            if (t != null) {
                return t;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        if (this.uSM == null) {
            return a(this.uSL, getCursor());
        }
        t = a(null, getCursor());
        this.uSM.put(Integer.valueOf(i), t);
        return t;
    }

    public boolean nJ(int i) {
        return i >= this.count && i < this.count + aBV();
    }

    public int aBV() {
        return 0;
    }

    public T aBW() {
        return this.uSL;
    }
}
