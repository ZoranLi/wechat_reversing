package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import android.widget.ListView;
import com.tencent.mm.e.a.iq;
import com.tencent.mm.e.a.lo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.LauncherUI;

public final class m implements com.tencent.mm.pluginsdk.l.m {
    public Activity fPi;
    c kJF = null;
    public IdleHandler uQB;
    Runnable vVL = new Runnable(this) {
        final /* synthetic */ m wex;

        {
            this.wex = r1;
        }

        public final void run() {
            m mVar = this.wex;
            LauncherUI launcherUI = (LauncherUI) mVar.fPi;
            if (launcherUI == null || launcherUI.uRM.lCS == 0) {
                BackwardSupportUtil.c.a(mVar.wbi);
                new ae().postDelayed(new Runnable(mVar) {
                    final /* synthetic */ m wex;

                    {
                        this.wex = r1;
                    }

                    public final void run() {
                        if (!this.wex.fPi.isFinishing()) {
                            this.wex.wbi.setSelection(0);
                        }
                    }
                }, 300);
            }
        }
    };
    public g wbL;
    public ListView wbi;
    c wev = null;
    c wew = null;

    class AnonymousClass6 extends c<lo> {
        final /* synthetic */ m wex;
        final /* synthetic */ ae wey;

        AnonymousClass6(m mVar, ae aeVar) {
            this.wex = mVar;
            this.wey = aeVar;
            this.usg = lo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.wey.sendEmptyMessage(0);
            return false;
        }
    }

    class AnonymousClass8 extends c<iq> {
        final /* synthetic */ ListView weA;
        final /* synthetic */ m wex;

        AnonymousClass8(m mVar, ListView listView) {
            this.wex = mVar;
            this.weA = listView;
            this.usg = iq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (this.weA != null) {
                this.weA.setSelection(0);
            }
            return false;
        }
    }

    public final void B(String str, String str2, String str3) {
        if (this.wbL != null) {
            this.wbL.notifyDataSetChanged();
        }
    }
}
