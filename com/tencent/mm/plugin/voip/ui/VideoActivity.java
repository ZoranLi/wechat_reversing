package com.tencent.mm.plugin.voip.ui;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.hu;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.e;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.j.AnonymousClass11;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.ui.d.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSuperAlert;
import com.tencent.mm.ui.base.a;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@a(3)
@SuppressLint({"SimpleDateFormat"})
public class VideoActivity extends MMActivity implements b, c, SensorController.a {
    private boolean fAp = false;
    private String gLD;
    private ae jiB;
    private boolean lCh = false;
    private int mStatus;
    private CaptureView rhA;
    private x rhE;
    private boolean rhF;
    private boolean rhG;
    private int rhK = 1;
    private boolean rlA = false;
    private boolean rlB = false;
    private TelephonyManager rlC = null;
    private long rlD;
    private d rlt;
    private WeakReference<c> rlu;
    private SensorController rlv;
    private long rlw = -1;
    private long rlx = 0;
    private boolean rly = false;
    private int rlz = 1;

    static /* synthetic */ void a(VideoActivity videoActivity, int i) {
        int i2;
        w.d("MicroMsg.Voip.VideoActivity", "getHintByErrorCode " + i);
        if (i == 235) {
            i2 = R.l.fbT;
        } else if (i == 233) {
            d.bpd().bqm();
            i2 = R.l.fbS;
        } else {
            i2 = i == aw.CTRL_BYTE ? (!b.Hp() || videoActivity.rhG) ? R.l.fbU : R.l.fbW : i == JsApiGetSetting.CTRL_INDEX ? R.l.fcg : i == g.CTRL_INDEX ? R.l.fbV : 0;
        }
        if (i2 != 0 || videoActivity.rlt == null) {
            if (i2 == 0) {
                i2 = R.l.fbR;
            }
            MMSuperAlert.i(videoActivity, R.l.dIO, i2);
            return;
        }
        videoActivity.rlt.bU(videoActivity.getString(R.l.fbR), -1);
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        boolean a;
        super.onCreate(bundle);
        if (!com.tencent.mm.plugin.voip.b.d.cU(this.uSU.uTo)) {
            com.tencent.mm.plugin.voip.b.d.cV(this.uSU.uTo);
        }
        w.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
        cO().cP().hide();
        getWindow().setSoftInputMode(3);
        getWindow().addFlags(6815872);
        if (ap.zb()) {
            d.bpd().u(false, false);
        }
        this.jiB = new ae();
        PBool pBool = new PBool();
        PBool pBool2 = new PBool();
        PString pString = new PString();
        PInt pInt = new PInt();
        pString.value = getIntent().getStringExtra("Voip_User");
        pBool.value = getIntent().getBooleanExtra("Voip_Outcall", true);
        pBool2.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
        this.rlD = getIntent().getLongExtra("Voip_LastPage_Hash", 0);
        pInt.value = com.tencent.mm.plugin.voip.b.b.x(pBool.value, pBool2.value);
        if (pBool.value) {
            try {
                if (aMY()) {
                    Toast.makeText(this, R.l.esz, 0).show();
                    w.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
                    super.finish();
                    return;
                }
            } catch (Exception e) {
                w.e("MicroMsg.Voip.VideoActivity", "not ready now!");
            }
        }
        m bpd = d.bpd();
        if (bpd.riF != null) {
            w.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
            pString.value = bpd.riF.gLD;
            pBool.value = bpd.riF.rhF;
            pBool2.value = bpd.riF.rhG;
            pInt.value = bpd.riF.rhw.mState;
        } else {
            if (pString.value == null) {
                w.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
                obj = null;
            } else if (pBool.value || bpd.riE.bpk()) {
                String str;
                j jVar;
                List f;
                com.tencent.mm.plugin.voip.video.j jVar2;
                IntentFilter intentFilter;
                bpd.riF = new j();
                j jVar3 = bpd.riF;
                String str2 = pString.value;
                boolean z = pBool.value;
                boolean z2 = pBool2.value;
                w.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[]{str2, Boolean.valueOf(z), Boolean.valueOf(z2)});
                jVar3.rhY = true;
                jVar3.gLD = str2;
                jVar3.rhF = z;
                jVar3.rhG = z2;
                ap.yY();
                jVar3.rhE = com.tencent.mm.u.c.wR().Rc(jVar3.gLD);
                jVar3.jiB = new ae();
                jVar3.rhH = bg.getInt(com.tencent.mm.i.g.sV().getValue("VOIPCameraSwitch"), 1) == 0;
                if (!jVar3.rhG) {
                    jVar3.rhH = false;
                }
                int x = com.tencent.mm.plugin.voip.b.b.x(z, z2);
                if (jVar3.rhH) {
                    if (x == 0) {
                        x = 1;
                    } else if (256 == x) {
                        x = 257;
                    }
                }
                if (z) {
                    jVar3.rhw = com.tencent.mm.plugin.voip.b.b.vh(x);
                } else {
                    jVar3.rhw = com.tencent.mm.plugin.voip.b.b.vg(x);
                }
                boolean rU = com.tencent.mm.compatible.e.b.rU();
                boolean rV = com.tencent.mm.compatible.e.b.rV();
                if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                    com.tencent.mm.plugin.report.service.g gVar;
                    Object[] objArr;
                    if (!rU) {
                        gVar = com.tencent.mm.plugin.report.service.g.oUh;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(jVar3.rhG ? 0 : 1);
                        objArr[1] = Integer.valueOf(1);
                        gVar.i(11306, objArr);
                    }
                    if (!rV) {
                        gVar = com.tencent.mm.plugin.report.service.g.oUh;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(jVar3.rhG ? 0 : 1);
                        objArr[1] = Integer.valueOf(0);
                        gVar.i(11306, objArr);
                    }
                }
                if (!(rV && rU)) {
                    String str3 = null;
                    str = null;
                    if (!rU && !rV) {
                        str3 = getString(R.l.dIK);
                        str = getString(R.l.dHJ);
                    } else if (!rU) {
                        str3 = getString(R.l.dIM);
                        str = getString(R.l.dHK);
                    } else if (!rV) {
                        str3 = getString(R.l.dIL);
                        str = getString(R.l.dHL);
                    }
                    com.tencent.mm.ui.base.g.a(this, str3, str, getString(R.l.dHM), true, new AnonymousClass11(jVar3, this));
                }
                w.i("MicroMsg.Voip.VoipMgr", "initMgr");
                ap.oH().pS();
                ap.yZ().b(jVar3);
                ap.yZ().a(jVar3);
                ap.yZ().qG();
                jVar3.fAP = new com.tencent.mm.compatible.util.b(ab.getContext());
                jVar3.fAP.requestFocus();
                if (jVar3.rhG) {
                    d.bpd().a(true, true, jVar3.gLD);
                } else {
                    d.bpd().a(true, false, jVar3.gLD);
                }
                if (jVar3.rhF) {
                    d.bpd().riE.bqt();
                    if ((jVar3.rhG ? d.bpd().riE.bT(jVar3.rhE.field_username, 0) : d.bpd().riE.bT(jVar3.rhE.field_username, 1)) < 0) {
                        jVar3.eD(false);
                    }
                }
                jVar3.rhx = new HeadsetPlugReceiver();
                jVar3.rhx.a(ab.getContext(), jVar3.rie);
                m bpd2 = d.bpd();
                Context context = ab.getContext();
                n nVar = bpd2.riE;
                nVar.rew.kLX = context;
                nVar.rew.rfR = jVar3;
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipServiceEx", "attach ui........");
                jVar3.mMp = (TelephonyManager) ab.getContext().getSystemService("phone");
                jVar3.mMp.listen(jVar3.mMq, 32);
                d.bpd().m(R.k.dyQ, jVar3.rhG ? 0 : 1, jVar3.rhF);
                if (ap.yZ().qO()) {
                    x = 3;
                    jVar = jVar3;
                } else if (ap.yZ().qI()) {
                    x = 4;
                    jVar = jVar3;
                } else if (jVar3.rhG) {
                    x = 1;
                    jVar = jVar3;
                } else {
                    x = 2;
                    jVar = jVar3;
                }
                jVar.rhK = x;
                if (jVar3.rhG) {
                    jVar3.rhN = true;
                } else {
                    jVar3.rhN = false;
                }
                str2 = "voip_recent_contact" + com.tencent.mm.u.m.xL();
                SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("voip_plugin_prefs", 0);
                str = sharedPreferences.getString(str2, null);
                if (str != null) {
                    f = bg.f(str.split(";"));
                    if (f != null) {
                        int size = f.size();
                        if (f.contains(jVar3.gLD)) {
                            if (size > 1) {
                                f.remove(jVar3.gLD);
                            }
                            sharedPreferences.edit().putString(str2, bg.c(f, ";")).commit();
                            com.tencent.mm.sdk.b.a.urY.b(jVar3.rif);
                            com.tencent.mm.sdk.b.a.urY.b(jVar3.mMr);
                            jVar2 = jVar3.rhR;
                            if (!jVar2.jRr.contains(jVar3)) {
                                jVar2.jRr.add(jVar3);
                            }
                            intentFilter = new IntentFilter();
                            intentFilter.addAction("android.intent.action.SCREEN_ON");
                            intentFilter.addAction("android.intent.action.SCREEN_OFF");
                            intentFilter.addAction("android.intent.action.USER_PRESENT");
                            ab.getContext().registerReceiver(jVar3.rid, intentFilter);
                        } else if (4 == size) {
                            f.remove(size - 1);
                        }
                        f.add(0, jVar3.gLD);
                        sharedPreferences.edit().putString(str2, bg.c(f, ";")).commit();
                        com.tencent.mm.sdk.b.a.urY.b(jVar3.rif);
                        com.tencent.mm.sdk.b.a.urY.b(jVar3.mMr);
                        jVar2 = jVar3.rhR;
                        if (jVar2.jRr.contains(jVar3)) {
                            jVar2.jRr.add(jVar3);
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        intentFilter.addAction("android.intent.action.USER_PRESENT");
                        ab.getContext().registerReceiver(jVar3.rid, intentFilter);
                    }
                }
                f = new ArrayList();
                f.add(0, jVar3.gLD);
                sharedPreferences.edit().putString(str2, bg.c(f, ";")).commit();
                com.tencent.mm.sdk.b.a.urY.b(jVar3.rif);
                com.tencent.mm.sdk.b.a.urY.b(jVar3.mMr);
                jVar2 = jVar3.rhR;
                if (jVar2.jRr.contains(jVar3)) {
                    jVar2.jRr.add(jVar3);
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                ab.getContext().registerReceiver(jVar3.rid, intentFilter);
            } else {
                w.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
                l.a(pString.value, pBool2.value ? au.uJR : au.uJQ, pBool.value ? 1 : 0, 4, ab.getContext().getString(R.l.fbg));
                obj = null;
            }
            if (obj != null) {
                w.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
                super.finish();
            }
            this.rlu = new WeakReference(obj);
            this.gLD = pString.value;
            this.rhG = pBool2.value;
            this.rhF = pBool.value;
            this.mStatus = pInt.value;
            ap.yY();
            this.rhE = com.tencent.mm.u.c.wR().Rc(this.gLD);
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_username", this.rhE.field_username);
            bundle2.putBoolean("key_isoutcall", this.rhF);
            bundle2.putInt("key_status", com.tencent.mm.plugin.voip.b.b.x(this.rhF, this.rhG));
            if (com.tencent.mm.plugin.voip.b.b.vj(this.mStatus)) {
                this.rlt = new f();
            } else {
                this.rlt = new e();
            }
            this.rlt.setArguments(bundle2);
            aR().aV().b(R.h.cNS, this.rlt).commit();
            zg(8);
            if (com.tencent.mm.plugin.voip.b.b.vk(this.mStatus) && this.rhF) {
                this.jiB.postDelayed(new Runnable(this) {
                    final /* synthetic */ VideoActivity rlE;

                    {
                        this.rlE = r1;
                    }

                    public final void run() {
                        if (com.tencent.mm.plugin.voip.b.b.vk(this.rlE.mStatus) && !this.rlE.lCh && this.rlE.rlt != null) {
                            this.rlE.rlt.bU(this.rlE.getString(R.l.fbu), 10000);
                        }
                    }
                }, 20000);
            }
            this.rlt.a((c) this.rlu.get());
            this.rlt.a((c) this);
            this.rlt.vb(this.rhK);
            this.rlt.bQ(this.fAp);
            if (d.bpd().riF.ric != null) {
                HD(d.bpd().riF.ric);
            }
            this.rlv = new SensorController(this.uSU.uTo);
            if (!(this.rlu == null || this.rlu.get() == null)) {
                ((c) this.rlu.get()).a(this, 1);
            }
            w.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[]{Boolean.valueOf(this.rhF), Boolean.valueOf(this.rhG), this.gLD, Integer.valueOf(this.mStatus)});
            if (this.rlv != null) {
                w.d("MicroMsg.Voip.VideoActivity", "onCreate setSensorCallBack");
                this.rlv.a(this);
            }
            if (com.tencent.mm.plugin.voip.b.b.vj(this.mStatus)) {
                a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
                w.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bg.bJZ(), this});
                return;
            }
            a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, "", "");
            w.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bg.bJZ(), this});
            a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
            w.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bg.bJZ(), this});
            return;
        }
        obj = bpd.riF;
        if (obj != null) {
            this.rlu = new WeakReference(obj);
            this.gLD = pString.value;
            this.rhG = pBool2.value;
            this.rhF = pBool.value;
            this.mStatus = pInt.value;
            ap.yY();
            this.rhE = com.tencent.mm.u.c.wR().Rc(this.gLD);
            Bundle bundle22 = new Bundle();
            bundle22.putString("key_username", this.rhE.field_username);
            bundle22.putBoolean("key_isoutcall", this.rhF);
            bundle22.putInt("key_status", com.tencent.mm.plugin.voip.b.b.x(this.rhF, this.rhG));
            if (com.tencent.mm.plugin.voip.b.b.vj(this.mStatus)) {
                this.rlt = new f();
            } else {
                this.rlt = new e();
            }
            this.rlt.setArguments(bundle22);
            aR().aV().b(R.h.cNS, this.rlt).commit();
            zg(8);
            this.jiB.postDelayed(/* anonymous class already generated */, 20000);
            this.rlt.a((c) this.rlu.get());
            this.rlt.a((c) this);
            this.rlt.vb(this.rhK);
            this.rlt.bQ(this.fAp);
            if (d.bpd().riF.ric != null) {
                HD(d.bpd().riF.ric);
            }
            this.rlv = new SensorController(this.uSU.uTo);
            ((c) this.rlu.get()).a(this, 1);
            w.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[]{Boolean.valueOf(this.rhF), Boolean.valueOf(this.rhG), this.gLD, Integer.valueOf(this.mStatus)});
            if (this.rlv != null) {
                w.d("MicroMsg.Voip.VideoActivity", "onCreate setSensorCallBack");
                this.rlv.a(this);
            }
            if (com.tencent.mm.plugin.voip.b.b.vj(this.mStatus)) {
                a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
                w.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bg.bJZ(), this});
                return;
            }
            a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, "", "");
            w.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bg.bJZ(), this});
            a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
            w.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bg.bJZ(), this});
            return;
        }
        w.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
        super.finish();
    }

    private static boolean aMY() {
        Exception e;
        boolean z;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ab.getContext().getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            switch (telephonyManager.getCallState()) {
                case 0:
                    z = false;
                    break;
                case 1:
                case 2:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            try {
                w.i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", new Object[]{Integer.valueOf(r2)});
                return z;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            w.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", new Object[]{e.getLocalizedMessage()});
            return z;
        }
    }

    protected final int Ol() {
        return 1;
    }

    private void bpN() {
        this.jiB.postDelayed(new Runnable(this) {
            final /* synthetic */ VideoActivity rlE;

            {
                this.rlE = r1;
            }

            public final void run() {
                this.rlE.finish();
            }
        }, 2000);
    }

    public final void dm(int i, int i2) {
        this.mStatus = i2;
        if (1 != this.rlz && i2 != 8 && i2 != 262) {
            w.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
        } else if (this.rlt == null) {
            w.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
        } else {
            this.rlt.dm(i, i2);
            switch (i2) {
                case 1:
                case 3:
                case 7:
                case 257:
                case 261:
                    if (this.rlt == null || !(this.rlt instanceof f)) {
                        if (this.rlt != null) {
                            this.rlt.uninit();
                            aR().aV().a(this.rlt).commit();
                            this.rlt = null;
                        }
                        w.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
                        Bundle bundle = new Bundle();
                        bundle.putString("key_username", this.rhE.field_username);
                        bundle.putBoolean("key_isoutcall", this.rhF);
                        bundle.putInt("key_status", this.mStatus);
                        this.rlt = new f();
                        this.rlt.setArguments(bundle);
                        this.rlt.a((c) this.rlu.get());
                        this.rlt.dT(this.rlw);
                        this.rlt.a((c) this);
                        this.rlt.vb(this.rhK);
                        this.rlt.bQ(this.fAp);
                        this.rlt.b(this.rhA);
                        aR().aV().b(R.h.cNS, this.rlt).commit();
                        return;
                    }
                    return;
                case 8:
                case 262:
                    switch (i) {
                        case 4098:
                            this.jiB.postDelayed(new Runnable(this) {
                                final /* synthetic */ VideoActivity rlE;

                                {
                                    this.rlE = r1;
                                }

                                public final void run() {
                                    this.rlE.bpN();
                                }
                            }, 50);
                            break;
                        case 4099:
                            if (this.rhF) {
                                this.rlt.bU(getString(R.l.fbn), -1);
                            }
                            bpN();
                            break;
                        case 4103:
                        case 4104:
                            bpN();
                            break;
                        case 4106:
                            this.jiB.post(new Runnable(this) {
                                final /* synthetic */ VideoActivity rlE;

                                {
                                    this.rlE = r1;
                                }

                                public final void run() {
                                    if (this.rlE.rlt != null) {
                                        this.rlE.rlt.bU(this.rlE.getString(R.l.fcz), -1);
                                    }
                                    this.rlE.bpN();
                                }
                            });
                            break;
                        case 4107:
                            finish();
                            break;
                        case 4109:
                            this.jiB.post(new Runnable(this) {
                                final /* synthetic */ VideoActivity rlE;

                                {
                                    this.rlE = r1;
                                }

                                public final void run() {
                                    this.rlE.bpN();
                                }
                            });
                            break;
                    }
                    bpN();
                    return;
                default:
                    return;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        if (i == 25) {
            if (d.bpd().bqn() || this.rhF) {
                ap.yZ().ec(ap.yZ().qI() ? ap.yZ().qU() : aEA());
            } else {
                d.bpd().aMX();
            }
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            if (d.bpd().bqn() || this.rhF) {
                ap.yZ().eb(ap.yZ().qI() ? ap.yZ().qU() : aEA());
            } else {
                d.bpd().aMX();
            }
            return true;
        }
    }

    protected void onDestroy() {
        this.rlz = 4;
        w.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.vf(this.mStatus)});
        if (!this.rlB) {
            finish();
        }
        if (this.rlv != null && this.rlv.uvF) {
            w.d("MicroMsg.Voip.VideoActivity", "onDestroy removeSensorCallBack");
            cV(true);
            this.rlv.bJG();
        }
        if (!(this.rlu == null || this.rlu.get() == null)) {
            ((c) this.rlu.get()).a(this);
        }
        this.rlv = null;
        super.onDestroy();
    }

    protected void onStop() {
        this.rlz = 2;
        w.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.vf(this.mStatus)});
        super.onStop();
        if (262 != this.mStatus && 8 != this.mStatus && this.rlA && !this.rlB && this.rlu != null && this.rlu.get() != null && ((c) this.rlu.get()).if(false)) {
            w(false, true);
            if (com.tencent.mm.plugin.voip.b.b.vi(this.mStatus)) {
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(com.tencent.mm.plugin.voip.b.b.vj(this.mStatus) ? 2 : 3);
                objArr[1] = Integer.valueOf(2);
                gVar.i(11618, objArr);
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.rlB) {
            w.i("MicroMsg.Voip.VideoActivity", "onStart");
            this.rlz = 1;
            dm(Downloads.RECV_BUFFER_SIZE, this.mStatus);
        }
    }

    public void finish() {
        boolean z;
        this.rlz = 3;
        w.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", new Object[]{Boolean.valueOf(this.rly), com.tencent.mm.plugin.voip.b.b.vf(this.mStatus)});
        if (!(this.rly || !com.tencent.mm.plugin.voip.b.b.vi(this.mStatus) || 4 == this.rlz)) {
            w.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", this.gLD);
            com.tencent.mm.plugin.voip.a.a.imv.e(intent, this);
        }
        if (this.rlv != null) {
            w.d("MicroMsg.Voip.VideoActivity", "removeSensorCallBack");
            cV(true);
            this.rlv.bJG();
            this.rlv = null;
        }
        if (this.rlt != null) {
            if (this.rlt.rlJ == 4105) {
                z = true;
            } else {
                z = false;
            }
            this.rlt.uninit();
            this.rlt = null;
        } else {
            z = false;
        }
        this.rlu = null;
        this.rhA = null;
        this.rlB = true;
        super.finish();
        if (z) {
            com.tencent.mm.sdk.b.b huVar = new hu();
            huVar.fNt.fNw = true;
            huVar.fNt.fNv = this.rlD;
            com.tencent.mm.sdk.b.a.urY.m(huVar);
            return;
        }
        huVar = new hu();
        huVar.fNt.fNw = false;
        huVar.fNt.fNv = 0;
        com.tencent.mm.sdk.b.a.urY.m(huVar);
    }

    protected void onNewIntent(Intent intent) {
        w.i("MicroMsg.Voip.VideoActivity", "onNewIntent");
        super.onNewIntent(intent);
    }

    public void onPause() {
        boolean z;
        super.onPause();
        PowerManager powerManager = (PowerManager) ab.getContext().getSystemService("power");
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) ab.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        boolean hasWindowFocus = hasWindowFocus();
        boolean isScreenOn = powerManager.isScreenOn();
        if ((hasWindowFocus || !inKeyguardRestrictedInputMode) && isScreenOn) {
            z = true;
        } else {
            z = false;
        }
        this.rlA = z;
        w.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.vf(this.mStatus), Boolean.valueOf(this.rlA), Boolean.valueOf(hasWindowFocus), Boolean.valueOf(inKeyguardRestrictedInputMode), Boolean.valueOf(isScreenOn)});
    }

    public void onResume() {
        int i = 0;
        w.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.vf(this.mStatus)});
        ap.getNotification().cancel(40);
        e eVar = d.bpd().riE.rew;
        if (eVar.rfC) {
            eVar.rfC = false;
        }
        super.onResume();
        cV(true);
        this.rlx = bg.NA();
        if (this.rhF && com.tencent.mm.plugin.voip.b.b.vk(this.mStatus) && d.bpd().bqn()) {
            if (!this.rhG) {
                i = 1;
            }
            d.bpd().m(R.k.dyQ, i, this.rhF);
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.rlt != null) {
            this.rlt.a(bArr, j, i, i2, i3, i4, i5, i6);
        }
    }

    public final void at(final int i, String str) {
        w.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.rhG)});
        this.lCh = true;
        if (i == GameJsApiGetGameCommInfo.CTRL_BYTE) {
            com.tencent.mm.ui.base.g.b(this, str, null, true);
        } else {
            this.jiB.post(new Runnable(this) {
                final /* synthetic */ VideoActivity rlE;

                public final void run() {
                    VideoActivity.a(this.rlE, i);
                }
            });
        }
    }

    public final void HD(final String str) {
        if (this.rlt != null) {
            this.jiB.post(new Runnable(this) {
                final /* synthetic */ VideoActivity rlE;

                public final void run() {
                    if (this.rlE.rlt != null) {
                        this.rlE.rlt.HD(str);
                    }
                }
            });
        }
    }

    protected final int getLayoutId() {
        return R.i.dpM;
    }

    public final void cU(boolean z) {
        if (bg.NA() - this.rlx < 500) {
            w.d("MicroMsg.Voip.VideoActivity", "onSensorEvent time interval too small");
        } else if ((this.rhF || com.tencent.mm.plugin.voip.b.b.vi(this.mStatus)) && !com.tencent.mm.plugin.voip.b.b.vj(this.mStatus)) {
            w.d("MicroMsg.Voip.VideoActivity", "onSensorEvent, isOn: " + z);
            cV(z);
        }
    }

    protected final void bE(View view) {
        com.tencent.mm.ui.x.d(com.tencent.mm.ui.x.a(getWindow(), null), this.uSU.uTa);
        ((ViewGroup) getWindow().getDecorView()).addView(view, 0);
    }

    private int aEA() {
        int bpb;
        if (com.tencent.mm.plugin.voip.b.b.vi(this.mStatus)) {
            bpb = d.bpd().bpb();
        } else {
            bpb = ap.yZ().qI() ? 0 : 2;
            if (!this.rhG && this.rhF) {
                bpb = p.gRd.gOs >= 0 ? p.gRd.gOs : 0;
            }
            if (!ap.yZ().qI() && p.gRd.gOu >= 0) {
                bpb = p.gRd.gOu;
            }
        }
        w.d("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", new Object[]{Integer.valueOf(bpb)});
        return bpb;
    }

    public final void vb(int i) {
        this.rhK = i;
        if (this.rlt != null) {
            this.rlt.vb(i);
        }
    }

    public final void bQ(boolean z) {
        this.fAp = z;
        if (this.rlt != null) {
            this.rlt.bQ(z);
        }
    }

    public final void a(int i, int i2, int[] iArr) {
        if (this.rlt != null) {
            this.rlt.a(i, i2, iArr);
        }
    }

    public final void bpR() {
        if (this.rlt != null) {
            this.rlt.bpR();
        }
    }

    public final Context bqR() {
        return this.uSU.uTo;
    }

    public final void uninit() {
        if (this.rlt != null) {
            this.rlt.uninit();
        }
    }

    public final void dS(long j) {
        this.rlw = j;
        if (this.rlt != null) {
            this.rlt.dT(this.rlw);
        }
    }

    public final void bqS() {
        w.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning");
        if (this.rlt != null) {
            this.rlt.bqT();
        }
    }

    public final void aFs() {
        w.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
        if (this.rlt != null) {
            this.rlt.bqU();
        }
    }

    public final void w(boolean z, boolean z2) {
        this.rly = z2;
        if (z) {
            bpN();
        } else {
            finish();
        }
    }

    public final void a(CaptureView captureView) {
        this.rhA = captureView;
        if (this.rlt != null) {
            this.rlt.b(captureView);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            w.e("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult %d data is invalid", new Object[]{Integer.valueOf(i)});
            return;
        }
        w.i("MicroMsg.Voip.VideoActivity", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 19:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString("android.permission.CAMERA".equals(strArr[0]) ? R.l.eFG : R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ VideoActivity rlE;

                        {
                            this.rlE = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.rlE.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ VideoActivity rlE;

                        {
                            this.rlE = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ VideoActivity rlE;

                        {
                            this.rlE = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.rlE.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
