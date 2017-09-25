package com.tencent.mm.plugin.voip.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.e.a.rq;
import com.tencent.mm.e.a.sl;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class j implements com.tencent.mm.compatible.b.e.a, com.tencent.mm.plugin.voip.model.k.a, p, c, f, com.tencent.mm.plugin.voip.video.j.a {
    public b fAP;
    private boolean fAp = false;
    public String gLD;
    public ae jiB;
    public TelephonyManager mMp;
    public PhoneStateListener mMq = new PhoneStateListener(this) {
        final /* synthetic */ j rig;

        {
            this.rig = r1;
        }

        public final void onCallStateChanged(int i, String str) {
            int i2 = 1;
            super.onCallStateChanged(i, str);
            w.d("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.rig.rhY)});
            if (!this.rig.rhY) {
                return;
            }
            if (i == 1) {
                this.rig.ria = true;
                d.bpd().va(1);
            } else if (i == 2) {
                String string;
                this.rig.ria = false;
                w.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
                if (this.rig.rhF && !com.tencent.mm.plugin.voip.b.b.vi(this.rig.rhw.mState)) {
                    n nVar = d.bpd().riE;
                    w.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + nVar.rew.rfQ.mNL);
                    if (nVar.rew.rfQ.mNL != 0) {
                        nVar.rew.rfQ.rlo.rgD = 102;
                        nVar.rew.rfQ.rlo.rgP = 6;
                        g.oUh.a(11521, true, true, new Object[]{Integer.valueOf(d.bpd().riE.rew.rfQ.mNL), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis())});
                        nVar.bqu();
                    }
                }
                if (com.tencent.mm.plugin.voip.b.b.vi(this.rig.rhw.mState)) {
                    string = ab.getContext().getString(R.l.fbl, new Object[]{j.aq(bg.az(this.rig.rhL))});
                } else {
                    string = ab.getContext().getString(R.l.fbi);
                }
                n nVar2 = d.bpd().riE;
                w.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
                if (nVar2.rew.rfQ.mNL == 0) {
                    nVar2.rew.rfS.bpw();
                    nVar2.reset();
                } else {
                    nVar2.rew.rfQ.rlo.rgD = MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM;
                    nVar2.rew.rfQ.rlo.rgV = 4;
                    nVar2.bqw();
                }
                String str2 = this.rig.rhE.field_username;
                String str3 = this.rig.rhG ? au.uJR : au.uJQ;
                if (!this.rig.rhF) {
                    i2 = 0;
                }
                l.a(str2, str3, i2, 6, string);
                this.rig.uT(4107);
                this.rig.bpN();
                au auVar = new au();
                auVar.setType(10000);
                auVar.z(System.currentTimeMillis());
                auVar.dv(6);
                auVar.setContent(ab.getContext().getString(R.l.fbk) + ", <a href=\"weixin://voip/callagain/?username=" + this.rig.gLD + "&isvideocall=" + this.rig.rhG + "\">" + ab.getContext().getString(R.l.fbf) + "</a>");
                if (!(this.rig.gLD == null || this.rig.gLD.equals(""))) {
                    auVar.cH(this.rig.gLD);
                    ap.yY();
                    com.tencent.mm.u.c.wT().L(auVar);
                }
                d.bpd().va(2);
            } else if (i == 0) {
                d.bpd().va(2);
                if (1 == this.rig.rhK && com.tencent.mm.plugin.voip.b.b.vi(this.rig.rhw.mState) && this.rig.ria) {
                    this.rig.id(true);
                }
                this.rig.ria = false;
            }
        }
    };
    public com.tencent.mm.sdk.b.c mMr = new com.tencent.mm.sdk.b.c<rq>(this) {
        final /* synthetic */ j rig;

        {
            this.rig = r2;
            this.usg = rq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rq rqVar = (rq) bVar;
            if (rqVar instanceof rq) {
                rqVar.fYE.fYF = com.tencent.mm.plugin.voip.b.b.vj(this.rig.rhw.mState);
                rqVar.fYE.fYG = this.rig.rhz != null;
                rqVar.fYE.fYH = true;
                rqVar.fYE.fJL = this.rig.gLD;
            }
            return false;
        }
    };
    private long mOI = 0;
    public int mUIType;
    private boolean nCj = false;
    private CaptureView rhA;
    public a rhB = null;
    private boolean rhC = false;
    private Object rhD = new Object();
    public x rhE;
    public boolean rhF;
    public boolean rhG;
    public boolean rhH = false;
    public int rhI = Downloads.RECV_BUFFER_SIZE;
    private boolean rhJ = false;
    public int rhK = 1;
    public long rhL = -1;
    public boolean rhM = false;
    public boolean rhN = false;
    private boolean rhO = false;
    public boolean rhP = false;
    int rhQ = 0;
    public com.tencent.mm.plugin.voip.video.j rhR = new com.tencent.mm.plugin.voip.video.j();
    private aj rhS = null;
    private af rhT;
    private boolean rhU = false;
    boolean rhV = false;
    int rhW = 0;
    boolean rhX = false;
    public boolean rhY = false;
    com.tencent.mm.plugin.voip.widget.b rhZ;
    public com.tencent.mm.plugin.voip.b.c rhw;
    public HeadsetPlugReceiver rhx;
    public com.tencent.mm.plugin.voip.ui.b rhy;
    public com.tencent.mm.plugin.voip.video.a rhz;
    public boolean ria = false;
    private boolean rib = false;
    public String ric = null;
    public BroadcastReceiver rid = new BroadcastReceiver(this) {
        final /* synthetic */ j rig;

        {
            this.rig = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            PowerManager powerManager = (PowerManager) ab.getContext().getSystemService("power");
            if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
                this.rig.rhP = false;
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                this.rig.rhP = false;
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                this.rig.rhP = true;
                if (!com.tencent.mm.plugin.voip.b.b.vi(this.rig.rhw.mState) && !this.rig.rhF) {
                    d.bpd().aMX();
                }
            }
        }
    };
    public com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a rie = new com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a(this) {
        final /* synthetic */ j rig;

        {
            this.rig = r1;
        }

        public final void eY(boolean z) {
            w.d("MicroMsg.Voip.VoipMgr", "onHeadsetState, on:%b", new Object[]{Boolean.valueOf(z)});
            if (!(true == z && 3 == this.rig.rhK) && (z || 3 == this.rig.rhK)) {
                if (com.tencent.mm.plugin.voip.b.b.vj(this.rig.rhw.mState)) {
                    if (z) {
                        this.rig.id(false);
                        this.rig.rhK = 3;
                    } else if (d.bpd().bqn()) {
                        Toast.makeText(this.rig.getContext(), this.rig.getContext().getString(R.l.fcK), 0).show();
                        this.rig.id(true);
                        this.rig.rhK = 1;
                    } else {
                        this.rig.id(false);
                        this.rig.rhK = 3;
                    }
                } else if (z) {
                    if (1 == this.rig.rhK) {
                        this.rig.id(false);
                        this.rig.rhM = true;
                    } else {
                        this.rig.rhM = false;
                    }
                    this.rig.rhK = 3;
                } else if (d.bpd().bqn()) {
                    if (this.rig.rhM || 2 == this.rig.mUIType) {
                        Toast.makeText(this.rig.getContext(), this.rig.getContext().getString(R.l.fcK), 0).show();
                        this.rig.id(true);
                        this.rig.rhK = 1;
                    } else {
                        Toast.makeText(this.rig.getContext(), this.rig.getContext().getString(R.l.fcJ), 0).show();
                        this.rig.rhK = 2;
                    }
                    this.rig.rhM = false;
                } else {
                    this.rig.id(false);
                    this.rig.rhK = 3;
                }
                this.rig.uR(this.rig.rhK);
                return;
            }
            w.d("MicroMsg.Voip.VoipMgr", "same status, no changed");
        }
    };
    public com.tencent.mm.sdk.b.c rif = new com.tencent.mm.sdk.b.c<sl>(this) {
        final /* synthetic */ j rig;

        {
            this.rig = r2;
            this.usg = sl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            final sl slVar = (sl) bVar;
            if (slVar instanceof sl) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass9 rip;

                    public final void run() {
                        switch (slVar.gad.fEG) {
                            case 1:
                                if (com.tencent.mm.plugin.voip.b.b.vj(this.rip.rig.rhw.mState)) {
                                    this.rip.rig.bpE();
                                    return;
                                } else {
                                    this.rip.rig.bpG();
                                    return;
                                }
                            case 2:
                                if (com.tencent.mm.plugin.voip.b.b.vj(this.rip.rig.rhw.mState)) {
                                    this.rip.rig.bpD();
                                    return;
                                } else {
                                    this.rip.rig.bpF();
                                    return;
                                }
                            case 3:
                                this.rip.rig.bpB();
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
            return false;
        }
    };

    class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ j rig;
        final /* synthetic */ Context riq;

        public AnonymousClass11(j jVar, Context context) {
            this.rig = jVar;
            this.riq = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            w.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
            com.tencent.mm.compatible.e.b.az(this.riq);
            if (this.rig.rhF) {
                if (this.rig.rhG) {
                    this.rig.bpH();
                } else {
                    this.rig.bpI();
                }
            } else if (this.rig.rhG) {
                this.rig.bpD();
            } else {
                this.rig.bpF();
            }
        }
    }

    class a implements Runnable {
        final /* synthetic */ j rig;

        a(j jVar) {
            this.rig = jVar;
        }

        public final void run() {
            this.rig.bpT();
            this.rig.rhB = null;
        }
    }

    public final void cW(int i) {
        int i2 = 1;
        w.d("MicroMsg.Voip.VoipMgr", "onBluetoothHeadsetStateChange status: %d, mBTRecoverSpeakerOn: %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.rhN)});
        switch (i) {
            case 1:
                ap.yZ().a(false, d.bpd().bpb());
                d.bpd().ib(false);
                d.bpd().ih(false);
                i2 = 4;
                break;
            case 2:
                ap.yZ().qH();
                id(aMz());
                if (!aMz()) {
                    i2 = 2;
                    break;
                }
                break;
            case 3:
                ap.yZ().qG();
                return;
            case 4:
                ap.yZ().qH();
                ap.yZ().qF();
                id(aMz());
                if (!aMz()) {
                    i2 = 2;
                }
                uR(i2);
                return;
            default:
                return;
        }
        uR(i2);
    }

    private boolean aMz() {
        if (d.bpd().bqn() && this.rhG) {
            return true;
        }
        if (this.rhF || !this.rhG) {
            return false;
        }
        return true;
    }

    public final void uR(int i) {
        this.rhK = i;
        if (this.rhy != null) {
            this.rhy.vb(this.rhK);
        }
    }

    public final void id(boolean z) {
        w.h("MicroMsg.Voip.VoipMgr", "enableSpeaker: " + z, new Object[0]);
        this.rhM = z;
        this.rhN = z;
        w.d("MicroMsg.Voip.VoipMgr", "MMCore.getAudioManager() " + ap.yZ().qM());
        if (ap.yZ().qI()) {
            z = false;
        }
        if (p.gRd.gNN) {
            p.gRd.dump();
            if (p.gRd.gNO > 0) {
                d.bpd().ib(z);
            }
        }
        if (p.gRd.gOp >= 0 || p.gRd.gOq >= 0) {
            d.bpd().ib(z);
        }
        ap.yZ().a(z, d.bpd().bpb());
        d.bpd().ih(z);
        this.rhO = z;
    }

    public final void ie(boolean z) {
        int i;
        w.d("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[]{Boolean.valueOf(z)});
        if (d.bpd().bqn()) {
            id(z);
        } else {
            n nVar = d.bpd().riE;
            if (nVar.riY != null) {
                nVar.riY.io(z);
            }
        }
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        uR(i);
        g gVar = g.oUh;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(0);
        gVar.i(11080, objArr);
    }

    public final void fN(boolean z) {
        int i = 1;
        g gVar;
        if (z) {
            gVar = d.bpd().riE.rew.rfS;
            if (gVar.nOV != null) {
                gVar.nOV.au(true);
            }
            d.bpd().uM(9);
            d.bpd().ig(true);
        } else {
            gVar = d.bpd().riE.rew.rfS;
            if (gVar.nOV != null) {
                gVar.nOV.au(false);
            }
            d.bpd().uM(8);
            d.bpd().ig(false);
        }
        this.fAp = z;
        g gVar2 = g.oUh;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(0);
        if (z) {
            i = 2;
        }
        objArr[2] = Integer.valueOf(i);
        gVar2.i(11080, objArr);
    }

    public final boolean bpB() {
        if (!this.rhw.vl(4103)) {
            return false;
        }
        uS(4103);
        return true;
    }

    public final boolean bpC() {
        if (!this.rhw.vl(4101)) {
            return false;
        }
        d.bpd().aMX();
        d.bpd().uM(1);
        d.bpd().v(true, this.rhG);
        g gVar = g.oUh;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Long.valueOf(d.bpd().bqi());
        objArr[2] = Integer.valueOf(d.bpd().riE.rew.rfQ.mNL);
        objArr[3] = Integer.valueOf(0);
        objArr[4] = Integer.valueOf(this.rhF ? 1 : 0);
        gVar.i(11046, objArr);
        g.oUh.i(11080, new Object[]{Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0)});
        uT(4111);
        uT(4101);
        uT(4100);
        return true;
    }

    public final boolean bpD() {
        int i = 0;
        if (!this.rhw.vl(4099)) {
            return false;
        }
        String str = this.rhE.field_username;
        String str2 = this.rhG ? au.uJR : au.uJQ;
        if (this.rhF) {
            i = 1;
        }
        l.a(str, str2, i, 6, ab.getContext().getString(R.l.fbp));
        d.bpd().aMX();
        d.bpd().riE.bqv();
        uT(4099);
        bpN();
        return true;
    }

    public final boolean bpE() {
        if (!this.rhw.vl(4100)) {
            return false;
        }
        w.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
        d.bpd().aMX();
        d.bpd().v(false, this.rhG);
        uT(4100);
        return true;
    }

    public final boolean bpF() {
        int i = 0;
        if (!this.rhw.vl(4099)) {
            return false;
        }
        w.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
        String str = this.rhE.field_username;
        String str2 = this.rhG ? au.uJR : au.uJQ;
        if (this.rhF) {
            i = 1;
        }
        l.a(str, str2, i, 6, ab.getContext().getString(R.l.fbp));
        d.bpd().aMX();
        d.bpd().riE.bqv();
        uT(4099);
        bpN();
        return true;
    }

    public final boolean bpG() {
        if (!this.rhw.vl(4100)) {
            return false;
        }
        w.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
        d.bpd().aMX();
        d.bpd().v(true, this.rhG);
        uT(4111);
        uT(4100);
        return true;
    }

    public final boolean bpH() {
        if (!this.rhw.vl(4098)) {
            return false;
        }
        w.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
        uS(4098);
        return true;
    }

    public final boolean bpI() {
        if (!this.rhw.vl(4098)) {
            return false;
        }
        w.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
        uS(4098);
        return true;
    }

    public final void a(com.tencent.mm.plugin.voip.ui.b bVar, int i) {
        w.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated");
        if (1 == i && this.rhy != null) {
            this.rhy.uninit();
        }
        this.rhy = bVar;
        this.mUIType = i;
        int i2 = 320;
        int i3 = 240;
        if (this.rhz == null && com.tencent.mm.plugin.voip.b.b.vj(this.rhw.mState)) {
            this.rhA = new CaptureView(ab.getContext());
            if (v2protocal.rjG) {
                w.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
                i2 = 640;
                i3 = 480;
            }
            this.rhz = new com.tencent.mm.plugin.voip.video.a(i2, i3);
            this.rhz.a((f) this, true);
            this.rhz.a(this.rhA);
            d.bpd().uY(this.rhz.bru());
            this.jiB.postDelayed(new Runnable(this) {
                final /* synthetic */ j rig;

                {
                    this.rig = r1;
                }

                public final void run() {
                    w.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + this.rig.rhz);
                    if (this.rig.rhz != null) {
                        this.rig.rhz.brp();
                    }
                }
            }, 50);
        }
        this.rhy.a(this.rhA);
        this.rhy.dm(-1, this.rhw.mState);
        this.rhy.dS(this.rhL);
        this.rhy.vb(this.rhK);
        this.rhy.bQ(this.fAp);
    }

    public final void a(com.tencent.mm.plugin.voip.ui.b bVar) {
        w.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
        if (this.rhy == bVar) {
            w.d("MicroMsg.Voip.VoipMgr", "same VoipUI, clear it");
            this.rhy = null;
        }
        if (this.jiB != null) {
            this.jiB = null;
        }
    }

    public final void bpJ() {
        w.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
        if (this.rhz != null) {
            this.rhz.bro();
        }
        g.oUh.i(11079, new Object[]{Integer.valueOf(1)});
    }

    private void uS(int i) {
        String string;
        w.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
        if (true == bpV()) {
            this.rhI = i;
        }
        Context context = ab.getContext();
        if (com.tencent.mm.plugin.voip.b.b.vi(this.rhw.mState)) {
            string = context.getString(R.l.fbl, new Object[]{aq(bg.az(this.rhL))});
        } else if (this.rhF) {
            string = context.getString(R.l.fbh);
        } else {
            string = context.getString(R.l.fbg);
        }
        l.a(this.rhE.field_username, this.rhG ? au.uJR : au.uJQ, this.rhF ? 1 : 0, 6, string);
        if (!this.rhF || com.tencent.mm.plugin.voip.b.b.vi(this.rhw.mState)) {
            e.post(new Runnable(this) {
                final /* synthetic */ j rig;

                {
                    this.rig = r1;
                }

                public final void run() {
                    d.bpd().aMX();
                    if (this.rig.rhG) {
                        d.bpd().dk(R.k.dyR, 0);
                    } else {
                        d.bpd().dk(R.k.dyR, 1);
                    }
                }
            }, "VoipMgr_play_end_sound");
            this.rhC = true;
            d.bpd().bqg();
            if (Downloads.RECV_BUFFER_SIZE == this.rhI) {
                uT(i);
                bpN();
                return;
            }
            return;
        }
        d.bpd().aMX();
        if (this.rhF && !com.tencent.mm.plugin.voip.b.b.vi(this.rhw.mState)) {
            w.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
            n nVar = d.bpd().riE;
            w.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + nVar.rew.rfQ.mNL);
            if (nVar.rew.rfQ.mNL == 0 && nVar.rew.rfQ.mNO == 0) {
                nVar.reset();
            } else {
                nVar.rew.rfQ.rlo.rgD = nVar.rew.bpi();
                nVar.rew.rfQ.rlo.rgP = 3;
                if (nVar.rew.mStatus < 6) {
                    nVar.rew.rfQ.rlo.rgR = 1;
                }
                g gVar = g.oUh;
                Object[] objArr = new Object[6];
                objArr[0] = Integer.valueOf(d.bpd().riE.rew.rfQ.mNL);
                objArr[1] = Long.valueOf(d.bpd().bqi());
                objArr[2] = Long.valueOf(d.bpd().bqj());
                objArr[3] = Integer.valueOf(nVar.rew.mStatus == 5 ? 2 : 1);
                objArr[4] = Long.valueOf(System.currentTimeMillis());
                objArr[5] = Long.valueOf(System.currentTimeMillis());
                gVar.a(11521, true, true, objArr);
                nVar.bqu();
            }
        }
        w.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
        d.bpd().bqg();
        if (Downloads.RECV_BUFFER_SIZE == this.rhI) {
            uT(i);
            bpN();
        }
    }

    public final boolean bpK() {
        if (d.bpd().riE.rew.rfQ.mNL != 0) {
            return bpL();
        }
        this.rhJ = true;
        return true;
    }

    private boolean bpL() {
        int i = 4;
        int i2 = 0;
        if (!this.rhw.vl(4101)) {
            return false;
        }
        Object[] objArr;
        g gVar;
        int i3;
        Object[] objArr2;
        int i4;
        Object[] objArr3;
        uT(4101);
        Object[] objArr4;
        if (261 == this.rhw.mState || 7 == this.rhw.mState) {
            d.bpd().uM(1);
            g gVar2 = g.oUh;
            Object[] objArr5 = new Object[5];
            objArr5[0] = Integer.valueOf(2);
            objArr5[1] = Long.valueOf(d.bpd().bqi());
            objArr5[2] = Integer.valueOf(d.bpd().riE.rew.rfQ.mNL);
            objArr5[3] = Integer.valueOf(0);
            objArr5[4] = Integer.valueOf(this.rhF ? 1 : 0);
            gVar2.i(11046, objArr5);
            gVar2 = g.oUh;
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(2);
            objArr[1] = Integer.valueOf(0);
            gVar = gVar2;
            i3 = 11080;
            objArr2 = objArr;
            objArr4 = objArr;
            i4 = 2;
            objArr3 = objArr4;
        } else {
            if (1 == this.rhw.mState || 3 == this.rhw.mState) {
                d.bpd().uM(1);
                gVar = g.oUh;
                i3 = 11046;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(1);
                objArr[1] = Long.valueOf(d.bpd().bqi());
                objArr[2] = Integer.valueOf(d.bpd().riE.rew.rfQ.mNL);
                objArr[3] = Integer.valueOf(0);
                if (this.rhF) {
                    i2 = 1;
                    objArr3 = objArr;
                    objArr[i] = Integer.valueOf(i2);
                    gVar.i(i3, objArr3);
                } else {
                    objArr3 = objArr;
                    objArr4 = objArr;
                    i4 = 4;
                    objArr2 = objArr4;
                }
            }
            d.bpd().bqk();
            d.bpd().bql();
            return true;
        }
        int i5 = i4;
        objArr = objArr2;
        i = i5;
        objArr[i] = Integer.valueOf(i2);
        gVar.i(i3, objArr3);
        d.bpd().bqk();
        d.bpd().bql();
        return true;
    }

    public final void bpM() {
        w.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
        if (this.rhJ && d.bpd().riE.rew.rfQ.mNL != 0) {
            this.rhJ = false;
            bpL();
        }
        if (this.rhF) {
            uT(4097);
        }
        if (com.tencent.mm.plugin.voip.b.a.bre()) {
            d.bpd().uM(3);
            uT(4101);
        }
    }

    public final void uT(final int i) {
        w.h("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.vf(i), com.tencent.mm.plugin.voip.b.b.vf(this.rhw.mState)});
        if (4101 == i && com.tencent.mm.plugin.voip.b.b.vj(this.rhw.mState)) {
            bpU();
        }
        boolean z = 4111 == i ? true : 4101 == i && (com.tencent.mm.plugin.voip.b.b.vi(this.rhw.mState) || this.rhF);
        if (z && 1 == this.mUIType && 1 == this.rhK) {
            this.rib = true;
            id(false);
            uR(2);
        }
        com.tencent.mm.plugin.voip.b.c cVar = this.rhw;
        if (cVar.vl(i)) {
            w.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.vf(cVar.mState), com.tencent.mm.plugin.voip.b.b.vf(((Integer) ((Map) cVar.roe.get(Integer.valueOf(cVar.mState))).get(Integer.valueOf(i))).intValue()), com.tencent.mm.plugin.voip.b.b.vf(i)});
            cVar.mState = r0;
        } else {
            w.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
        }
        this.jiB.post(new Runnable(this) {
            final /* synthetic */ j rig;

            public final void run() {
                if (this.rig.rhy != null) {
                    this.rig.rhy.dm(i, this.rig.rhw.mState);
                }
            }
        });
        if (6 == this.rhw.mState || GameJsApiLaunchApplication.CTRL_BYTE == this.rhw.mState) {
            arp();
        }
        switch (this.rhw.mState) {
            case 258:
            case 259:
                uU(5);
                return;
            case 262:
                uU(6);
                return;
            default:
                return;
        }
    }

    private static void uU(int i) {
        com.tencent.mm.sdk.b.b slVar = new sl();
        slVar.gad.fEG = i;
        com.tencent.mm.sdk.b.a.urY.m(slVar);
    }

    public final void onError(int i, String str) {
        if (this.rhG) {
            d.bpd().dk(R.k.dyR, 0);
        } else {
            d.bpd().dk(R.k.dyR, 1);
        }
        if (i == GameJsApiGetGameCommInfo.CTRL_BYTE && bg.mA(str)) {
            str = getContext().getString(R.l.fcv);
        }
        if (this.rhy != null) {
            this.rhy.at(i, str);
        }
        uT(4109);
        w.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(d.bpd().riE.rew.rfQ.mNL)});
        Context context = ab.getContext();
        w.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode" + i);
        String string = i == 235 ? context.getString(R.l.fbr) : i == 233 ? context.getString(R.l.fbj) : i == aw.CTRL_BYTE ? context.getString(R.l.fbr) : i == JsApiGetSetting.CTRL_INDEX ? context.getString(R.l.fbj) : i == com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX ? context.getString(R.l.fbq) : context.getString(R.l.fbi);
        String str2;
        String str3;
        int i2;
        if (d.bpd().riE.rew.rfQ.mNL != 0 && d.bpd().riJ.get(Integer.valueOf(d.bpd().riE.rew.rfQ.mNL)) == null) {
            str2 = this.rhE.field_username;
            str3 = this.rhG ? au.uJR : au.uJQ;
            i2 = this.rhF ? 1 : 0;
            if (com.tencent.mm.plugin.voip.b.b.vi(this.rhw.mState)) {
                string = ab.getContext().getString(R.l.fbm, new Object[]{aq(bg.az(this.rhL))});
            }
            d.bpd().riJ.put(Integer.valueOf(d.bpd().riE.rew.rfQ.mNL), Long.valueOf(l.a(str2, str3, i2, 6, string, true)));
        } else if (d.bpd().riE.rew.rfQ.mNL == 0) {
            str2 = this.rhE.field_username;
            str3 = this.rhG ? au.uJR : au.uJQ;
            i2 = this.rhF ? 1 : 0;
            if (com.tencent.mm.plugin.voip.b.b.vi(this.rhw.mState)) {
                string = ab.getContext().getString(R.l.fbm, new Object[]{aq(bg.az(this.rhL))});
            }
            l.a(str2, str3, i2, 6, string, true);
        }
        bpN();
    }

    public final void aDA() {
        w.i("MicroMsg.Voip.VoipMgr", "on accept");
        d.bpd().aMX();
        uT(4100);
    }

    public final void onReject() {
        w.i("MicroMsg.Voip.VoipMgr", "onReject");
        uT(4099);
        l.a(this.rhE.field_username, this.rhG ? au.uJR : au.uJQ, this.rhF ? 1 : 0, 6, ab.getContext().getString(R.l.fbt));
        bpN();
    }

    public final void bpN() {
        w.d("MicroMsg.Voip.VoipMgr", "delayFinish");
        this.ric = null;
        this.jiB.postDelayed(new Runnable(this) {
            final /* synthetic */ j rig;

            {
                this.rig = r1;
            }

            public final void run() {
                this.rig.eD(false);
            }
        }, 2000);
    }

    public final void eD(boolean z) {
        m bpd;
        w.i("MicroMsg.Voip.VoipMgr", "finish");
        this.rhY = false;
        this.ria = false;
        if (this.rhQ != -1) {
            g.oUh.i(11700, new Object[]{Integer.valueOf(this.rhQ), Long.valueOf(bg.az(this.rhL))});
            this.rhQ = -1;
        }
        try {
            ab.getContext().unregisterReceiver(this.rid);
        } catch (Exception e) {
        }
        com.tencent.mm.sdk.b.a.urY.c(this.mMr);
        com.tencent.mm.sdk.b.a.urY.c(this.rif);
        if (this.rhy != null) {
            this.rhy.uninit();
            this.rhy = null;
        }
        this.rhA = null;
        ap.yZ().b(this);
        ap.yZ().qH();
        if (d.bpd() != null) {
            d.bpd().aMX();
            if (z) {
                d.bpd().riE.bqx();
            } else {
                d.bpd().bqg();
            }
            if (this.rhG) {
                d.bpd().a(false, true, this.gLD);
            } else {
                d.bpd().a(false, false, this.gLD);
            }
            bpd = d.bpd();
            Context context = ab.getContext();
            n nVar = bpd.riE;
            if (context == nVar.rew.kLX && this == nVar.rew.rfR) {
                nVar.rew.kLX = null;
                nVar.rew.rfR = p.rjq;
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipServiceEx", "detach ui........");
                com.tencent.mm.plugin.voip.b.a.brf();
            } else {
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
            }
        }
        bpd = d.bpd();
        bpd.riF = null;
        bpd.riN = null;
        bpd.riO = false;
        if (this.rhC) {
            this.rhB = new a(this);
            e.post(this.rhB, "VoipMgr_clean");
        } else {
            bpT();
        }
        if (!(this.mMp == null || this.mMq == null)) {
            this.mMp.listen(this.mMq, 0);
            this.mMq = null;
        }
        if (this.rhx != null) {
            this.rhx.cS(ab.getContext());
        }
        this.mMp = null;
        ap.oH().pR();
        k.bpZ().bqb();
        k.bpZ().rit = null;
        ap.getNotification().cancel(40);
    }

    public final void bpO() {
        w.i("MicroMsg.Voip.VoipMgr", "onNoResp");
        uT(4105);
        l.a(this.rhE.field_username, this.rhG ? au.uJR : au.uJQ, this.rhF ? 1 : 0, 4, ab.getContext().getString(R.l.fbs));
        g.oUh.a(11518, true, true, new Object[]{Integer.valueOf(d.bpd().riE.rew.rfQ.mNL), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(6), Integer.valueOf(am.getNetWorkType(getContext()))});
        bpN();
    }

    public final void onConnected() {
        uT(4102);
        this.rhL = bg.Ny();
        if (this.rhy != null) {
            this.rhy.dS(this.rhL);
        }
        boolean bpm = d.bpd().riE.rew.bpm();
        boolean bpl = d.bpd().riE.rew.bpl();
        if (this.rhG && this.rhF && !bpl && !bpm) {
            d.bpd().uM(1);
        }
        if (!com.tencent.mm.plugin.voip.b.b.vj(this.rhw.mState)) {
            g.oUh.i(11080, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
        }
        n nVar = d.bpd().riE;
        if (nVar.riY != null) {
            h hVar = nVar.riY;
            bg.k(hVar.mContext, hVar.mContext.getSharedPreferences(ab.bIX(), 0).getBoolean("settings_shake", true));
        }
        m bpd = d.bpd();
        int i = d.bpd().riE.rew.rfQ.rjV;
        n nVar2 = bpd.riE;
        nVar2.aPM = null;
        nVar2.rjf = null;
        nVar2.rjd = 0;
        if (i > 0) {
            n.rjb = i;
        }
        nVar2.aPM = (WifiManager) ab.getContext().getApplicationContext().getSystemService("wifi");
        nVar2.rje = new Timer();
        nVar2.rje.schedule(new TimerTask(nVar2) {
            final /* synthetic */ n rjl;

            {
                this.rjl = r1;
            }

            public final void run() {
                int i = 10;
                if (this.rjl.aPM != null) {
                    this.rjl.rjf = this.rjl.aPM.getConnectionInfo();
                }
                if (this.rjl.rjf == null || this.rjl.rjf.getBSSID() == null || this.rjl.aPM == null) {
                    n.jUS = -1;
                } else {
                    int calculateSignalLevel = WifiManager.calculateSignalLevel(this.rjl.rjf.getRssi(), 10);
                    n.jUS = calculateSignalLevel;
                    if (calculateSignalLevel <= 10) {
                        i = n.jUS;
                    }
                    n.jUS = i;
                    i = i < 0 ? 0 : n.jUS;
                    n.jUS = i;
                    n.jUS = i * 10;
                }
                if (n.jUS == -1) {
                    if (this.rjl.rjd <= 1) {
                        n.rja = -1;
                    }
                    this.rjl.setNetSignalValue(1, n.rja);
                    return;
                }
                this.rjl.setNetSignalValue(2, n.jUS);
            }
        }, 0, (long) (n.rjb * 1000));
        TelephonyManager telephonyManager = (TelephonyManager) ab.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            telephonyManager.listen(new com.tencent.mm.plugin.voip.model.n.AnonymousClass5(nVar2, telephonyManager), 256);
        }
        k.bpZ().bqa();
        k.bpZ().rit = this;
    }

    public final void bpP() {
        int i = 0;
        g gVar = g.oUh;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(d.bpd().riE.rew.rfQ.mNL);
        objArr[1] = Long.valueOf(d.bpd().bqi());
        objArr[2] = Long.valueOf(d.bpd().bqj());
        if (!this.rhF) {
            i = 1;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Integer.valueOf(1);
        gVar.a(11522, true, true, objArr);
    }

    public final void bpQ() {
        String string;
        w.i("MicroMsg.Voip.VoipMgr", "onShutDown");
        if (com.tencent.mm.plugin.voip.b.b.vi(this.rhw.mState)) {
            string = ab.getContext().getString(R.l.fbl, new Object[]{aq(bg.az(this.rhL))});
        } else {
            string = ab.getContext().getString(R.l.fbi);
        }
        if (this.rhF || com.tencent.mm.plugin.voip.b.b.vi(this.rhw.mState)) {
            l.a(this.rhE.field_username, this.rhG ? au.uJR : au.uJQ, 0, 6, string);
        }
        if (this.rhG) {
            d.bpd().dk(R.k.dyR, 0);
        } else {
            d.bpd().dk(R.k.dyR, 1);
        }
        if (bpV()) {
            this.rhI = 4106;
            return;
        }
        uT(4106);
        bpN();
    }

    public final void uV(int i) {
        w.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", new Object[]{Integer.valueOf(i)});
        if (1 == i || 3 == i || 5 == i || 6 == i || 7 == i) {
            uT(4101);
            d.bpd().bqk();
            d.bpd().bql();
        }
    }

    public final void a(int i, int i2, int i3, int[] iArr) {
        if (this.rhy != null) {
            this.rhy.a(i, i2, iArr);
        }
    }

    public final void bpR() {
        if (this.rhy != null) {
            this.rhy.bpR();
        }
    }

    public final void uW(int i) {
        boolean z = false;
        w.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: " + i);
        if (this.rhw.vl(4110)) {
            m bpd = d.bpd();
            boolean z2 = i == 1;
            if (i == 1) {
                z = true;
            }
            bpd.v(z2, z);
            d.bpd().aMX();
            if (i == 1 && com.tencent.mm.plugin.voip.b.b.vj(this.rhw.mState)) {
                uT(4101);
            }
            uT(4110);
        }
    }

    public final void bpS() {
        boolean z = false;
        w.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
        if (ap.yZ().qO() || ap.yZ().qI()) {
            id(false);
            return;
        }
        boolean z2 = 1 == this.rhK;
        if (!this.rib) {
            if (this.rhG) {
                z = true;
            } else {
                z = z2;
            }
        }
        id(z);
    }

    public static String aq(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3) {
        if (!this.rhP) {
            int i4;
            int i5 = this.rhz.brs() ? OpenGlRender.rpK : 0;
            int i6 = this.rhz.brt() ? OpenGlRender.rpJ : OpenGlRender.rpI;
            int i7 = (int) j;
            g gVar = d.bpd().riE.rew.rfS;
            if (gVar.rgm != 2) {
                i4 = 0;
            } else if (gVar.rew.bpp()) {
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = gVar.rew.rfQ;
                com_tencent_mm_plugin_voip_model_v2protocal.rkW++;
                i4 = gVar.rew.rfQ.videoEncodeToSend(bArr, i7, i, i2, i3);
            } else {
                i4 = 0;
            }
            if (this.rhy != null) {
                this.rhy.a(bArr, j, i, i2, i3, i5, i6, i4);
            }
            this.rhV = i5 == OpenGlRender.rpK;
            this.rhW = i6 == OpenGlRender.rpJ ? 270 : 90;
            com.tencent.mm.plugin.voip.video.j jVar = this.rhR;
            jVar.rqC = i2;
            jVar.rqB = i;
        }
    }

    public final void bpT() {
        synchronized (this.rhD) {
            d.bpd().aMX();
            bpU();
            ap.yZ().setMode(0);
            if (this.fAP != null) {
                this.fAP.rY();
            }
        }
    }

    final void bpU() {
        w.h("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
        if (this.rhz != null) {
            if (this.rhR != null) {
                com.tencent.mm.plugin.voip.video.j jVar = this.rhR;
                if (jVar.jRr.contains(this)) {
                    jVar.jRr.remove(this);
                }
            }
            if (this.rhS != null) {
                w.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
                this.rhS.KH();
            }
            if (this.rhT != null) {
                w.d("MicroMsg.Voip.VoipMgr", "quit face detect thread");
                this.rhT.nJF.getLooper().quit();
            }
            try {
                this.rhz.brq();
                com.tencent.mm.plugin.voip.video.a.brr();
            } catch (Exception e) {
                w.d("MicroMsg.Voip.VoipMgr", "stop capture error:" + e.toString());
            }
            this.rhz = null;
        }
    }

    public final void aDF() {
        w.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
        if (this.rhy != null) {
            this.rhy.bqS();
        }
        if (!com.tencent.mm.plugin.voip.b.b.vj(this.rhw.mState) && !this.rhO) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mOI > 30000) {
                this.mOI = currentTimeMillis;
                d.bpd().uZ(R.k.dAv);
            }
        }
    }

    public final void aDG() {
        w.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
        if (this.rhy != null) {
            this.rhy.aFs();
        }
    }

    private boolean bpV() {
        if (!com.tencent.mm.plugin.voip.b.b.vi(this.rhw.mState)) {
            return false;
        }
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
        if (sharedPreferences.getBoolean("voip_shortcut_has_added", false)) {
            return false;
        }
        String value = com.tencent.mm.i.g.sV().getValue("VOIPShortcutAutoadd");
        w.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", new Object[]{value});
        if (value != null && value.equals("0") && bg.az(this.rhL) > 30) {
            int i = sharedPreferences.getInt("voip_shortcut_prompt_times", 0);
            boolean z = sharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
            if (i >= 3 || z) {
                return false;
            }
            Context context = getContext();
            View inflate = View.inflate(context, R.i.dit, null);
            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.cjX);
            checkBox.setChecked(false);
            TextView textView = (TextView) inflate.findViewById(R.h.cjZ);
            if (1 == bg.getInt(com.tencent.mm.i.g.sV().getValue("VOIPCallType"), 0)) {
                textView.setText(R.l.fba);
            } else {
                textView.setText(R.l.fbb);
            }
            com.tencent.mm.ui.base.g.a(context, false, context.getString(R.l.dIO), inflate, context.getString(R.l.dJe), context.getString(R.l.dHQ), new OnClickListener(this) {
                final /* synthetic */ j rig;

                {
                    this.rig = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rig.c(this.rig.getContext().getSharedPreferences("voip_plugin_prefs", 0));
                    if (Downloads.RECV_BUFFER_SIZE != this.rig.rhI) {
                        this.rig.uT(this.rig.rhI);
                        this.rig.rhI = Downloads.RECV_BUFFER_SIZE;
                    }
                    this.rig.jiB.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 rih;

                        {
                            this.rih = r1;
                        }

                        public final void run() {
                            this.rih.rig.eD(false);
                        }
                    });
                }
            }, new OnClickListener(this) {
                final /* synthetic */ j rig;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (checkBox != null) {
                        this.rig.getContext().getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", checkBox.isChecked()).commit();
                    }
                    if (Downloads.RECV_BUFFER_SIZE != this.rig.rhI) {
                        this.rig.uT(this.rig.rhI);
                        this.rig.rhI = Downloads.RECV_BUFFER_SIZE;
                    }
                    this.rig.jiB.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 rij;

                        {
                            this.rij = r1;
                        }

                        public final void run() {
                            this.rij.rig.eD(false);
                        }
                    });
                }
            });
            sharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
            return true;
        } else if (value == null || !value.equals("1") || bg.az(this.rhL) <= 15) {
            return false;
        } else {
            c(sharedPreferences);
            return false;
        }
    }

    public final void c(SharedPreferences sharedPreferences) {
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        Object intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent2.addFlags(67108864);
        if (1 == bg.getInt(com.tencent.mm.i.g.sV().getValue("VOIPCallType"), 0)) {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(R.l.dHk));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(getContext(), R.g.blx));
            intent.putExtra("shortcut_icon_resource_id", R.g.blx);
        } else {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(R.l.dHl));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(getContext(), R.g.blE));
            intent.putExtra("shortcut_icon_resource_id", R.g.blE);
        }
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        com.tencent.mm.plugin.base.model.c.l(getContext(), intent);
        sharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
    }

    public final Context getContext() {
        Context context = null;
        if (this.rhy != null) {
            context = this.rhy.bqR();
        }
        if (context == null) {
            return ab.getContext();
        }
        return context;
    }

    public final boolean if(final boolean z) {
        if (!this.ria || z) {
            w.h("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", new Object[]{Boolean.valueOf(z)});
            w.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
            if (this.rhy != null) {
                this.rhy.uninit();
                this.rhy = null;
            }
            this.jiB.post(new Runnable(this) {
                final /* synthetic */ j rig;

                public final void run() {
                    j jVar = this.rig;
                    boolean z = z;
                    w.i("MicroMsg.Voip.VoipMgr", "do minimizeVoip");
                    if (2 != jVar.mUIType || VERSION.SDK_INT >= 24) {
                        jVar.mUIType = 2;
                        jVar.rhQ++;
                        jVar.rhZ = new com.tencent.mm.plugin.voip.widget.b(jVar, jVar.rhw.mState, jVar.rhE, jVar.rhG, jVar.rhF, z);
                        int i = (261 == jVar.rhw.mState || 7 == jVar.rhw.mState) ? true : 0;
                        if (2 == jVar.rhK && i != 0) {
                            jVar.id(true);
                            jVar.uR(1);
                            ap.yY();
                            if (1 == com.tencent.mm.u.c.vr().getInt(327949, 0)) {
                                Toast.makeText(jVar.getContext(), jVar.getContext().getString(R.l.fcP), 0).show();
                            } else {
                                Toast.makeText(jVar.getContext(), jVar.getContext().getString(R.l.fcO), 1).show();
                                ap.yY();
                                com.tencent.mm.u.c.vr().setInt(327949, 1);
                            }
                        }
                        if (GameJsApiLaunchApplication.CTRL_BYTE == jVar.rhw.mState || 6 == jVar.rhw.mState) {
                            ap.yY();
                            if (1 == com.tencent.mm.u.c.vr().getInt(327948, 0)) {
                                Toast.makeText(jVar.getContext(), jVar.getContext().getString(R.l.fcI), 0).show();
                            } else {
                                Toast.makeText(jVar.getContext(), jVar.getContext().getString(R.l.fcH), 1).show();
                                ap.yY();
                                com.tencent.mm.u.c.vr().setInt(327948, 1);
                            }
                        }
                        if (jVar.rhw.mState == 0 || 2 == jVar.rhw.mState || 256 == jVar.rhw.mState) {
                            jVar.bpU();
                        }
                        d.bpd().aMX();
                        d.bpd().u(true, z);
                        return;
                    }
                    w.e("MicroMsg.Voip.VoipMgr", "already is widget");
                }
            });
            return true;
        }
        w.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
        return false;
    }

    public final void bpW() {
        if (256 == this.rhw.mState || 257 == this.rhw.mState) {
            ap.yY();
            if (com.tencent.mm.u.c.vr().getInt(327945, 0) != 0 || this.rhy.bqR() == null) {
                d.G(ab.getContext(), R.l.fcf);
                bpY();
                return;
            }
            ap.yY();
            com.tencent.mm.u.c.vr().setInt(327945, 1);
            com.tencent.mm.ui.base.h a = com.tencent.mm.ui.base.g.a(this.rhy.bqR(), R.l.fcf, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ j rig;

                {
                    this.rig = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rig.bpY();
                }
            });
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            a.show();
        }
    }

    public final void bpX() {
        this.rhU = !this.rhU;
        if (this.rhU) {
            this.rhS.KH();
        } else {
            arp();
        }
    }

    public final void bpY() {
        d.bpd().riK = d.bpd().riE.rew.rfQ.mNL;
        l.a(this.rhE.field_username, this.rhG ? au.uJR : au.uJQ, this.rhF ? 1 : 0, 6, ab.getContext().getString(R.l.fbo));
        d.bpd().aMX();
        uT(4108);
        this.jiB.postDelayed(new Runnable(this) {
            final /* synthetic */ j rig;

            {
                this.rig = r1;
            }

            public final void run() {
                this.rig.eD(true);
            }
        }, 2000);
    }

    public final void aNu() {
        if (true == this.nCj || this.rhy == null || this.rhy.bqR() == null) {
            w.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
        } else if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || com.tencent.mm.compatible.e.b.rV()) {
            int i;
            w.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
            g gVar = g.oUh;
            Object[] objArr = new Object[2];
            if (this.rhG) {
                i = 0;
            } else {
                i = 1;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(0);
            gVar.i(11306, objArr);
            com.tencent.mm.ui.base.h h = com.tencent.mm.ui.base.g.h(this.rhy.bqR(), R.l.fcp, R.l.dIO);
            if (h == null) {
                w.e("MicroMsg.Voip.VoipMgr", "new dialog failed");
                return;
            }
            h.setCancelable(false);
            h.setCanceledOnTouchOutside(false);
            h.show();
            this.nCj = true;
        } else {
            w.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
        }
    }

    private void arp() {
        if (this.rhS == null) {
            this.rhT = new af("faceDetect");
            this.rhS = new aj(this.rhT.nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ j rig;

                {
                    this.rig = r1;
                }

                public final boolean oQ() {
                    j jVar = this.rig;
                    if (com.tencent.mm.plugin.voip.b.b.vi(jVar.rhw.mState)) {
                        jVar.rhR.rqz = jVar.rhV;
                        jVar.rhR.rqA = jVar.rhW;
                        com.tencent.mm.plugin.voip.video.j jVar2 = jVar.rhR;
                        int[] iArr = new int[2];
                        if (jVar.rhX) {
                            iArr[0] = 1;
                            iArr[1] = 0;
                        } else {
                            iArr[0] = 0;
                            iArr[1] = 0;
                        }
                        ByteBuffer allocate = ByteBuffer.allocate(8);
                        allocate.asIntBuffer().put(iArr);
                        byte[] array = allocate.array();
                        if (jVar2.rir.setAppCmd(13, array, array.length) >= 0) {
                            int length = (array.length % 4 == 0 ? 0 : 1) + (array.length / 4);
                            ByteBuffer allocate2 = ByteBuffer.allocate(length * 4);
                            allocate2.put(array);
                            allocate2.order(ByteOrder.nativeOrder());
                            allocate2.rewind();
                            int[] iArr2 = new int[length];
                            allocate2.asIntBuffer().get(iArr2);
                            int i = iArr2[0];
                            length = iArr2[1];
                            if (i + length != 0) {
                                b bVar = new b(jVar2);
                                bVar = new b(jVar2);
                                bVar.rqD = i & 65535;
                                bVar.rqE = (i >> 16) & 65535;
                                bVar.rqF = length & 65535;
                                bVar.rqG = (length >> 16) & 65535;
                                w.d("MicroMsg.VoipFaceDetector", "detect face, location:%s", new Object[]{bVar});
                                Iterator it = jVar2.jRr.iterator();
                                while (it.hasNext()) {
                                    ((com.tencent.mm.plugin.voip.video.j.a) it.next()).a(new int[]{bVar.rqD, bVar.rqE, bVar.rqF, bVar.rqG}, jVar2.rqz, jVar2.rqA);
                                }
                            } else {
                                Iterator it2 = jVar2.jRr.iterator();
                                while (it2.hasNext()) {
                                    ((com.tencent.mm.plugin.voip.video.j.a) it2.next()).a(null, jVar2.rqz, jVar2.rqA);
                                }
                            }
                        }
                    }
                    return true;
                }
            }, true);
        }
        this.rhS.v(2000, 2000);
        this.rhU = false;
    }

    public final void a(final int[] iArr, final boolean z, final int i) {
        af.v(new Runnable(this) {
            final /* synthetic */ j rig;

            public final void run() {
                if (this.rig.rhz != null) {
                    this.rig.rhz.n(iArr);
                }
                if (this.rig.rhy != null) {
                    com.tencent.mm.plugin.voip.ui.b bVar = this.rig.rhy;
                }
            }
        });
    }
}
