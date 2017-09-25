package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.w;

public abstract class a extends i {
    public boolean qeV;
    protected boolean qeW = SnsAdNativeLandingPagesUI.qyd;
    public boolean qeX;
    private BroadcastReceiver tF = new BroadcastReceiver(this) {
        final /* synthetic */ a qeY;

        {
            this.qeY = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("com.tencent.mm.adlanding.close_exposure_voice".equals(intent.getAction()) && !this.qeY.bgp().qfI.equals(intent.getStringExtra("para_id"))) {
                a aVar = this.qeY;
                if (aVar.qeX) {
                    aVar.bfN();
                }
            }
        }
    };

    public a(Context context, p pVar, ViewGroup viewGroup) {
        super(context, pVar, viewGroup);
        d.k(this.context).a(this.tF, new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice"));
        w.v("AbsVideoPlayComp", "register receiver " + this.tF);
    }

    public void bfN() {
        this.qeV = false;
    }

    public void bfO() {
        super.bfO();
        d.k(this.context).unregisterReceiver(this.tF);
        this.qeX = true;
        w.v("AbsVideoPlayComp", "unregister receiver " + this.tF);
    }

    public void bfP() {
        super.bfP();
        this.qeX = true;
    }

    public void bfQ() {
        super.bfQ();
        this.qeX = false;
    }

    public void N(int i, int i2, int i3) {
        super.N(i, i2, i3);
    }

    public void bfR() {
        this.qeV = true;
    }

    public final void bfS() {
        Intent intent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
        intent.putExtra("para_id", bgp().qfI);
        d.k(this.context).b(intent);
    }

    protected final void bfT() {
        super.bfT();
        if (this.qeW) {
            bfR();
        } else {
            bfN();
        }
    }
}
