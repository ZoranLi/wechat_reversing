package com.tencent.mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ae;
import junit.framework.Assert;

public abstract class k<Params, Progress, Result> {
    private boolean fOV = false;
    public ae handler = new ae(Looper.getMainLooper());

    public abstract ae bec();

    public abstract Result bed();

    public final boolean l(final Params... paramsArr) {
        if (this.fOV) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.fOV = true;
        m(paramsArr);
        ae bec = bec();
        if (bec == null) {
            return false;
        }
        bec.post(new Runnable(this) {
            final /* synthetic */ k sCs;

            public final void run() {
                final Object bed = this.sCs.bed();
                this.sCs.handler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 sCt;

                    public final void run() {
                        this.sCt.sCs.onPostExecute(bed);
                    }
                });
            }
        });
        return true;
    }

    public void m(Params... paramsArr) {
    }

    public void onPostExecute(Result result) {
    }
}
