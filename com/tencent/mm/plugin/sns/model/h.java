package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.ae;
import junit.framework.Assert;

public abstract class h<Params, Progress, Result> {
    private boolean fOV = false;
    public ae handler = ae.ayz();

    public abstract ae bec();

    public abstract Result bed();

    public final boolean l(final Params... paramsArr) {
        if (this.fOV) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.fOV = true;
        ae bec = bec();
        if (bec == null) {
            return false;
        }
        bec.post(new Runnable(this) {
            final /* synthetic */ h pTD;

            public final void run() {
                final Object bed = this.pTD.bed();
                this.pTD.handler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 pTF;

                    public final void run() {
                        this.pTF.pTD.onPostExecute(bed);
                    }
                });
            }
        });
        return true;
    }

    public void onPostExecute(Result result) {
    }
}
