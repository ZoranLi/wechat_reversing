package com.tencent.mm.plugin.multitalk.ui;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ja;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.widget.c;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@a(3)
public class MultiTalkMainUI extends MMActivity implements com.tencent.mm.plugin.multitalk.a.a {
    protected ae jsW;
    private c nQG;
    private f nQH;
    private boolean nQI;
    private boolean nQJ = true;
    private boolean nQK = false;
    private Runnable nQL = new Runnable(this) {
        final /* synthetic */ MultiTalkMainUI nQO;

        {
            this.nQO = r1;
        }

        public final void run() {
            o.aNn().aMV();
        }
    };
    public boolean nQM;
    private BroadcastReceiver nQN = new BroadcastReceiver(this) {
        final /* synthetic */ MultiTalkMainUI nQO;

        {
            this.nQO = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && o.aNn().nPk == e.Inviting) {
                o.aNn().aMX();
                this.nQO.nQJ = false;
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.bQg();
        int intExtra = getIntent().getIntExtra("enterMainUiSource", 0);
        if (intExtra == 1 || intExtra == 2) {
            overridePendingTransition(R.a.aRm, R.a.aQL);
        } else {
            overridePendingTransition(R.a.aRP, R.a.aRQ);
        }
        getWindow().addFlags(6946944);
        o.aNn().aDI();
        if (o.aNn().aMM()) {
            this.nQG = new c(this);
            this.nQH = new f(this);
            o.aNn().fT(o.aNn().nPg);
            o.aNn().nPt = this;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            registerReceiver(this.nQN, intentFilter);
            this.nQK = true;
            this.jsW = new ae();
            ap.yZ().qG();
            if (!com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
                w.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
                return;
            }
            return;
        }
        finish();
        if (intExtra == 2) {
            getIntent().getStringExtra("enterMainUiWxGroupId");
        }
    }

    protected final int getLayoutId() {
        return R.i.djI;
    }

    protected void onResume() {
        super.onResume();
        switch (o.aNn().nPk) {
            case Inviting:
                this.nQH.nRF.setVisibility(8);
                this.nQG.n(o.aNn().nPl);
                if (am.is4G(this)) {
                    o.aNl().G(this);
                } else if (am.is2G(this) || am.is3G(this)) {
                    o.aNl().F(this);
                }
                if (this.nQJ) {
                    o.aNn().fU(false);
                    break;
                }
                break;
            case Starting:
            case Creating:
                this.nQG.aNs();
                this.nQH.o(o.aNn().nPl);
                if (am.is4G(this)) {
                    o.aNl().G(this);
                } else if (am.is2G(this) || am.is3G(this)) {
                    o.aNl().F(this);
                }
                o.aNn().fU(true);
                break;
            case Talking:
                this.nQG.aNs();
                this.nQH.o(o.aNn().nPl);
                break;
        }
        if (o.aNn().aMN()) {
            if (o.aNn().aMK()) {
                this.nQH.a(null, true);
            }
            this.jsW.postDelayed(this.nQL, 2000);
        }
    }

    protected void onPause() {
        PowerManager powerManager = (PowerManager) ab.getContext().getSystemService("power");
        boolean z = (hasWindowFocus() || !((KeyguardManager) ab.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) && powerManager.isScreenOn();
        this.nQI = z;
        w.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", new Object[]{Boolean.valueOf(this.nQI)});
        if (o.aNn().aMN()) {
            o.aNn().aMW();
            this.nQH.b(null, true);
        }
        super.onPause();
    }

    protected void onDestroy() {
        if (this.nQM) {
            o.aNn().fS(false);
        }
        if (this.nQK) {
            unregisterReceiver(this.nQN);
        }
        super.onDestroy();
    }

    protected void onStop() {
        if (!this.nQM && this.nQI) {
            o.aNn().fS(false);
        }
        super.onStop();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            g.a(this, R.l.eBZ, R.l.eBF, R.l.dDl, R.l.dGs, new OnClickListener(this) {
                final /* synthetic */ MultiTalkMainUI nQO;

                {
                    this.nQO = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    o.aNn().c(false, false, false);
                }
            }, null);
            return true;
        }
        if (o.aNn().nPk == e.Inviting) {
            if (i == 25 || i == 24) {
                o.aNn().aMX();
                this.nQJ = false;
                return true;
            }
        } else if (i == 25) {
            ap.yZ().ec(aEA());
            return true;
        } else if (i == 24) {
            ap.yZ().eb(aEA());
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static int aEA() {
        if (ap.yZ().qI()) {
            return ap.yZ().qU();
        }
        if (o.aNn().mNu.brA()) {
            return 0;
        }
        return 2;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + i + " resultCode " + i2);
        super.onActivityResult(i, i2, intent);
        this.nQM = false;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            w.i("MicroMsg.MT.MultiTalkMainUI", "add member " + stringExtra);
            List f = bg.f(stringExtra.split(","));
            if (f != null) {
                com.tencent.mm.plugin.multitalk.a.e aNn = o.aNn();
                if (aNn.aMM()) {
                    stringExtra = aNn.nPl.wPf;
                    if (bg.mA(stringExtra)) {
                        stringExtra = aNn.nPl.wPg;
                    }
                    o.aNm().nOT.r(stringExtra, f);
                }
            }
        }
    }

    public final void aMx() {
        switch (o.aNn().nPk) {
            case Inviting:
                this.nQG.n(o.aNn().nPl);
                return;
            case Starting:
            case Creating:
            case Talking:
                this.nQH.o(o.aNn().nPl);
                return;
            default:
                return;
        }
    }

    public final void aJN() {
        this.nQG.aNs();
        this.nQH.o(o.aNn().nPl);
    }

    public final void aDP() {
        b jaVar = new ja();
        jaVar.fOT.action = 0;
        com.tencent.mm.sdk.b.a.urY.m(jaVar);
        this.nQH.fV(true);
        o.aNn().nPt = null;
        o.aNn().aMX();
        finish();
    }

    public final void aMw() {
        ap.yZ().qH();
        com.tencent.mm.sdk.f.e.post(new Runnable(o.aNn()) {
            final /* synthetic */ e nPB;

            {
                this.nPB = r1;
            }

            public final void run() {
                this.nPB.mNu.stop();
                this.nPB.mNu.d(R.k.dyR, false, 0);
            }
        }, "MultiTalkManager_play_end_sound");
        b jaVar = new ja();
        jaVar.fOT.action = 0;
        com.tencent.mm.sdk.b.a.urY.m(jaVar);
        this.nQH.fV(false);
        o.aNn().nPt = null;
        o.aNn().aMX();
        finish();
    }

    public final void aMy() {
        w.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + o.aNn().nPj.size());
        if (o.aNn().aMN()) {
            f fVar;
            HashSet hashSet;
            if (o.aNn().nPj.size() > 0) {
                if (i.aNf()) {
                    w.i("MicroMsg.MT.MultiTalkMainUI", "2Gor3G,stop MultiTalkVideoNetworkReceiver!");
                    o.aNl().F(this);
                } else {
                    o.aNn().aMV();
                    fVar = this.nQH;
                    hashSet = new HashSet();
                    hashSet.addAll(o.aNn().nPj);
                    if (o.aNn().aML()) {
                        fVar.b(hashSet);
                    }
                }
            }
            o.aNn().aMW();
            fVar = this.nQH;
            hashSet = new HashSet();
            hashSet.addAll(o.aNn().nPj);
            if (o.aNn().aML()) {
                fVar.b(hashSet);
            }
        }
    }

    public final void fN(boolean z) {
        if (o.aNn().aMN()) {
            this.nQH.nRJ.setChecked(z);
        }
    }

    public final void fO(boolean z) {
        if (o.aNn().aMN()) {
            this.nQH.nRK.setChecked(z);
        }
    }

    public final void ct(int i, int i2) {
        if (o.aNn().aMN()) {
            f fVar = this.nQH;
            RelativeLayout Bo = fVar.Bo(m.xL());
            f.a aVar = (f.a) Bo.getTag();
            if (!i.pT(i2)) {
                if (i.pT(i)) {
                    fVar.nRI.setChecked(false);
                    aVar.nRV.aNw();
                }
                fVar.b(Bo, false);
            } else if (i.pT(i2) && !i.pT(i)) {
                fVar.nRI.setChecked(true);
                aVar.nRV.aNx();
                aVar.nRZ.setVisibility(0);
                af.f(new b(fVar, aVar), 1500);
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(o.aNn().nPj);
            if (i.pU(i2)) {
                if (i.pU(i2) && !i.pU(i)) {
                    fVar.b(hashSet);
                }
            } else if (i.pU(i)) {
                fVar.aNt();
            }
        }
    }

    public final void a(String str, int[] iArr, int i, int i2, int i3) {
        if (o.aNn().aMN()) {
            this.nQH.a(str, iArr, i, i2, 0, i3);
        }
    }

    public final void a(String str, Bitmap bitmap, int i, int i2) {
        this.nQH.a(str, bitmap, i, i2);
    }

    public final int AV(String str) {
        RelativeLayout Bo = this.nQH.Bo(str);
        return Bo == null ? -1 : ((f.a) Bo.getTag()).nRV.position;
    }

    public final void a(e eVar) {
        if (eVar == e.Talking) {
            f fVar = this.nQH;
            if (fVar.nRS > 0) {
                fVar.nRS = System.currentTimeMillis();
            }
        }
    }

    public final void a(i.a aVar) {
        if (aVar == i.a._4G) {
            o.aNl().G(this);
        } else if (aVar == i.a._3GOr_2G) {
            o.aNl().F(this);
        } else if (aVar == i.a.None) {
            com.tencent.mm.al.a.a(this, R.l.fco, null);
        }
    }

    public final void aDQ() {
        f.a aVar;
        f fVar = this.nQH;
        long j = (long) o.aNn().nPn;
        fVar.kxi.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        com.tencent.mm.plugin.multitalk.a.e aNn = o.aNn();
        String str = aNn.nPl.wPf;
        if (bg.mA(str)) {
            str = aNn.nPl.wPg;
        }
        List UX = o.aNm().nOT.UX(str);
        if (UX != null) {
            Iterator it = fVar.nRN.iterator();
            while (it.hasNext()) {
                aVar = (f.a) ((RelativeLayout) it.next()).getTag();
                if (UX.contains(aVar.nRV.username)) {
                    aVar.nRX.setVisibility(0);
                } else {
                    aVar.nRX.setVisibility(8);
                }
            }
        }
        aNn = o.aNn();
        str = aNn.nPl.wPf;
        if (bg.mA(str)) {
            str = aNn.nPl.wPg;
        }
        if (com.tencent.mm.plugin.multitalk.a.m.nQu == null) {
            com.tencent.mm.plugin.multitalk.a.m.nQu = new com.tencent.mm.plugin.multitalk.a.m();
        }
        com.tencent.mm.plugin.multitalk.a.m mVar = com.tencent.mm.plugin.multitalk.a.m.nQu;
        List arrayList = new ArrayList();
        mVar.nQv = com.tencent.wecall.talkroom.model.c.chs().Wc(str);
        if (mVar.nQv != null) {
            for (as asVar : mVar.nQv.chp()) {
                int i;
                byte[] bArr = new byte[4];
                if (o.aNm().nOT.D(bArr, asVar.mOs) < 0) {
                    w.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed");
                    i = -1;
                } else {
                    i = bg.aE(bArr);
                    w.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", new Object[]{Integer.valueOf(i)});
                }
                Object obj = (i == -1 || i >= 5) ? null : 1;
                if (obj != null) {
                    arrayList.add(asVar.wNl);
                }
            }
        }
        Iterator it2 = fVar.nRN.iterator();
        while (it2.hasNext()) {
            aVar = (f.a) ((RelativeLayout) it2.next()).getTag();
            if (arrayList.contains(aVar.nRV.username)) {
                aVar.nRY.setVisibility(0);
            } else {
                aVar.nRY.setVisibility(8);
            }
        }
    }

    protected final int Ol() {
        return 1;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            w.e("MicroMsg.MT.MultiTalkMainUI", "[multitalk]onRequestPermissionsResult %d data is invalid", new Object[]{Integer.valueOf(i)});
            return;
        }
        w.d("MicroMsg.MT.MultiTalkMainUI", "[multitalk] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                if (iArr[0] == 0) {
                    w.d("MicroMsg.MT.MultiTalkMainUI", "granted record audio!");
                    return;
                } else {
                    g.a(this, getString(R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ MultiTalkMainUI nQO;

                        {
                            this.nQO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.nQO.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ MultiTalkMainUI nQO;

                        {
                            this.nQO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
