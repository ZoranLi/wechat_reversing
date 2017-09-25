package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.e.a.pw;
import com.tencent.mm.network.m;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip_cs.b.a.c;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.protocal.c.bis;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.pb.common.c.i;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.Arrays;

@a(3)
public class VoipCSMainUI extends MMActivity implements com.tencent.mm.plugin.voip_cs.b.a, com.tencent.mm.plugin.voip_cs.b.b.a.a {
    private String appId = "";
    private b fAP;
    private ae hgN;
    public String iMn = "";
    private TelephonyManager mMp;
    PhoneStateListener mMq = new PhoneStateListener(this) {
        final /* synthetic */ VoipCSMainUI rtl;

        {
            this.rtl = r1;
        }

        public final void onCallStateChanged(int i, String str) {
            w.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
            if (i == 2) {
                w.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
                com.tencent.mm.plugin.voip_cs.b.b.brP().rrN = 4;
                this.rtl.vn(7);
            }
        }
    };
    private m oYc = new m.a(this) {
        final /* synthetic */ VoipCSMainUI rtl;

        {
            this.rtl = r1;
        }

        public final void cU(int i) {
            w.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from " + i);
            if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst != 2) {
                return;
            }
            if (i == 4 || i == 6) {
                d brO = com.tencent.mm.plugin.voip_cs.b.b.brO();
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = com.tencent.mm.plugin.voip_cs.b.b.brN().mOV;
                if (brO.rga == 0) {
                    brO.rga = com_tencent_mm_plugin_voip_model_v2protocal.rjJ;
                }
                int netType = com.tencent.mm.plugin.voip.b.a.getNetType(ab.getContext());
                if (netType != brO.rga) {
                    w.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + brO.rga + " to " + netType);
                    try {
                        byte[] bArr = new byte[4];
                        bArr[0] = (byte) netType;
                        int appCmd = com_tencent_mm_plugin_voip_model_v2protocal.setAppCmd(com.tencent.mm.plugin.appbrand.jsapi.l.b.CTRL_INDEX, bArr, 4);
                        if (appCmd < 0) {
                            w.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + com_tencent_mm_plugin_voip_model_v2protocal.mNT + ", roomkey=" + com_tencent_mm_plugin_voip_model_v2protocal.mNM + "]");
                        }
                        bis com_tencent_mm_protocal_c_bis = new bis();
                        com_tencent_mm_protocal_c_bis.uiw = 3;
                        com_tencent_mm_protocal_c_bis.uix = new com.tencent.mm.bd.b(bArr, 0, 1);
                        com_tencent_mm_plugin_voip_model_v2protocal.SendRUDP(com_tencent_mm_protocal_c_bis.toByteArray(), com_tencent_mm_protocal_c_bis.toByteArray().length);
                    } catch (Exception e) {
                        w.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
                    }
                    brO.rga = netType;
                }
                e brO2 = com.tencent.mm.plugin.voip_cs.b.b.brO();
                w.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rjL + "roomkey:" + com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.mNM);
                ap.vd().a(285, brO2);
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal2 = com.tencent.mm.plugin.voip_cs.b.b.brN().mOV;
                ap.vd().a(new com.tencent.mm.plugin.voip_cs.b.c.d(com_tencent_mm_plugin_voip_model_v2protocal2.rjL, com_tencent_mm_plugin_voip_model_v2protocal2.mNM), 0);
            }
        }
    };
    private HeadsetPlugReceiver rhx = null;
    private BroadcastReceiver rid = new BroadcastReceiver(this) {
        final /* synthetic */ VoipCSMainUI rtl;

        {
            this.rtl = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            PowerManager powerManager = (PowerManager) ab.getContext().getSystemService("power");
            if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
                w.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
                this.rtl.rtd.fKF = false;
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                w.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
                this.rtl.rtd.fKF = false;
                if (!this.rtl.rsz.bqn() && com.tencent.mm.plugin.voip_cs.b.b.brO().rst == 2) {
                    this.rtl.rsz.brW();
                }
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                w.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
                this.rtl.rtd.fKF = true;
                if (!this.rtl.rsz.bqn()) {
                    this.rtl.rsz.aMX();
                }
            }
        }
    };
    private HeadsetPlugReceiver.a rie = new HeadsetPlugReceiver.a(this) {
        final /* synthetic */ VoipCSMainUI rtl;

        {
            this.rtl = r1;
        }

        public final void eY(boolean z) {
            w.d("MicroMsg.voipcs.VoipCSMainUI", "onHeadsetState, on:%b", new Object[]{Boolean.valueOf(z)});
            if (this.rtl.rtf == z) {
                w.d("MicroMsg.voipcs.VoipCSMainUI", "same status, no changed");
                return;
            }
            this.rtl.rtf = z;
            if (z) {
                this.rtl.rte.id(false);
                Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.fcJ), 0).show();
                return;
            }
            this.rtl.rte.id(true);
            Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.fcK), 0).show();
        }
    };
    public String rsu = "";
    private com.tencent.mm.plugin.voip_cs.b.a.a rsz;
    private com.tencent.mm.plugin.voip_cs.b.a.b rtd;
    private c rte;
    private boolean rtf = false;
    public String rtg = "";
    public String rth = "";
    public String rti = "";
    private aj rtj = new aj(Looper.getMainLooper(), new aj.a(this) {
        final /* synthetic */ VoipCSMainUI rtl;

        {
            this.rtl = r1;
        }

        public final boolean oQ() {
            CharSequence string = ab.getContext().getString(R.l.fbE);
            Notification notification = new Builder(ab.getContext()).setTicker(ab.getContext().getString(R.l.fbE)).setWhen(System.currentTimeMillis()).setContentTitle(ab.getContext().getString(R.l.fbC)).setContentText(string).setContentIntent(PendingIntent.getActivity(ab.getContext(), 44, new Intent(ab.getContext(), VoipCSMainUI.class), 134217728)).setOngoing(true).getNotification();
            notification.icon = com.tencent.mm.ba.a.bCk();
            notification.flags |= 32;
            ap.getNotification().a(44, notification, false);
            return true;
        }
    }, true);
    com.tencent.mm.compatible.b.e.a rtk = new com.tencent.mm.compatible.b.e.a(this) {
        final /* synthetic */ VoipCSMainUI rtl;

        {
            this.rtl = r1;
        }

        public final void cW(int i) {
            w.d("MicroMsg.voipcs.VoipCSMainUI", "onBluetoothHeadsetStateChange status: %d, mBTRecoverSpeakerOn: %b", new Object[]{Integer.valueOf(i)});
            switch (i) {
                case 1:
                    this.rtl.rte.id(false);
                    return;
                case 2:
                    ap.yZ().qH();
                    this.rtl.rte.id(true);
                    return;
                case 3:
                    ap.yZ().qG();
                    return;
                case 4:
                    ap.yZ().qH();
                    this.rtl.rte.id(true);
                    return;
                default:
                    return;
            }
        }
    };

    public void onCreate(Bundle bundle) {
        w.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
        super.onCreate(bundle);
        this.uSU.bQg();
        this.rsu = getIntent().getStringExtra("voipCSBizId");
        this.appId = getIntent().getStringExtra("voipCSAppId");
        this.rtg = getIntent().getStringExtra("voipCSAllowBackCamera");
        this.rth = getIntent().getStringExtra("voipCSShowOther");
        this.iMn = getIntent().getStringExtra("voipCSAvatarUrl");
        this.rti = getIntent().getStringExtra("voipCSContext");
        getWindow().addFlags(6946944);
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        this.hgN = new ae();
        com.tencent.mm.plugin.voip_cs.b.c brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
        w.d("MicroMsg.VoipCSReportHelper", "reset");
        brP.aMw = 0;
        brP.rru = 0;
        brP.rrv = 0;
        brP.rrw = 0;
        brP.rrx = 0;
        brP.rry = 0;
        brP.rrz = 0;
        brP.rrA = 0;
        brP.rrB = 0;
        brP.rrC = 0;
        brP.rrD = 0;
        brP.networkType = 0;
        brP.rrE = 0;
        brP.rrF = com.tencent.mm.plugin.voip_cs.b.c.rrr;
        brP.rrG = 0;
        brP.rrH = 0;
        brP.mNM = 0;
        brP.rrI = "";
        brP.rjJ = 0;
        brP.rrL = 0;
        brP.rrM = 0;
        brP.rrN = 0;
        brP.rkc = 0;
        brP.rkb = 0;
        brP.rrO = 0;
        brP.rrP = 0;
        brP.rrQ = 0;
        brP.rrR = 0;
        brP.rrS = 0;
        brP.rrT = 0;
        brP.rrU = 0;
        brP.rrV = 0;
        brP.rrW = 0;
        brP.rrX = 0;
        brP.rrY = 0;
        brP.mPk = 0;
        brP.rrZ = 0;
        brP.rsa = 0;
        brP.channelStrategy = 1;
        brP.rln = 0;
        brP.rkd = 0;
        brP.rsb = 0;
        brP.rsc = 0;
        brP.mPu = "";
        brP.mPt = "";
        brP.rsg = 0;
        brP.rsh = 0;
        brP.rsi = 0;
        brP.rsj = 0;
        brP.rsk = 0;
        this.mMp = (TelephonyManager) ab.getContext().getSystemService("phone");
        com.tencent.mm.plugin.voip_cs.b.b.brO().rsu = this.rsu;
        this.rtd = new com.tencent.mm.plugin.voip_cs.b.a.b(this);
        this.rte = new c();
        this.fAP = new b(ab.getContext());
        this.rsz = com.tencent.mm.plugin.voip_cs.b.a.a.brU();
        com.tencent.mm.plugin.voip_cs.b.b.brN().rtb = this;
        com.tencent.mm.plugin.voip_cs.b.b.brO().rsm = this;
        if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst == 0 || com.tencent.mm.plugin.voip_cs.b.b.brO().rst == 3) {
            com.tencent.mm.plugin.voip_cs.b.b.brO().rst = 0;
        }
        ap.oH().pS();
        this.fAP.requestFocus();
        ap.yZ().qG();
        ap.yZ().a(this.rtk);
        this.rhx = new HeadsetPlugReceiver();
        this.rhx.a(ab.getContext(), this.rie);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        ab.getContext().registerReceiver(this.rid, intentFilter);
        ap.a(this.oYc);
        int callState = this.mMp.getCallState();
        if (callState == 2 || callState == 1) {
            w.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", new Object[]{Integer.valueOf(callState)});
            g.a(this, R.l.fbK, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI rtl;

                {
                    this.rtl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.rtl.vn(0);
                }
            });
            callState = 1;
        } else {
            callState = 0;
        }
        if (callState != 0) {
            w.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
            return;
        }
        this.mMp.listen(this.mMq, 32);
        if (!am.isNetworkConnected(this)) {
            w.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
            g.a(this, R.l.fbG, R.l.fcs, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI rtl;

                {
                    this.rtl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.rtl.vn(9);
                }
            });
            callState = 0;
        } else if (am.isWifi(this) || l.bqd()) {
            callState = 1;
        } else {
            w.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
            g.a(this, R.l.fbH, R.l.fcs, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI rtl;

                {
                    this.rtl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
                    l.bqc();
                    if (this.rtl.bsf()) {
                        this.rtl.bse();
                    }
                }
            }, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI rtl;

                {
                    this.rtl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.i("MicroMsg.voipcs.VoipCSMainUI", "cannot start voip by user choose cancel call  in not wifi network!");
                    dialogInterface.dismiss();
                    this.rtl.vn(8);
                }
            });
            callState = 0;
        }
        if (callState == 0) {
            w.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
            return;
        }
        if (com.tencent.mm.plugin.voip.b.d.brk()) {
            w.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
            g.a(this, R.l.esC, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI rtl;

                {
                    this.rtl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.rtl.vn(0);
                }
            });
            callState = 1;
        } else if (com.tencent.mm.plugin.voip.b.d.brj()) {
            w.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
            g.a(this, R.l.esD, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI rtl;

                {
                    this.rtl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.rtl.vn(0);
                }
            });
            callState = 1;
        } else if (com.tencent.mm.n.a.tQ()) {
            w.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
            g.a(this, R.l.esx, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI rtl;

                {
                    this.rtl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.rtl.vn(0);
                }
            });
            callState = 1;
        } else if (com.tencent.mm.al.a.HD()) {
            w.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
            g.a(this, R.l.esy, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI rtl;

                {
                    this.rtl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.rtl.vn(0);
                }
            });
            callState = 1;
        } else {
            callState = 0;
        }
        if (callState != 0) {
            w.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
        } else if (bsf()) {
            bse();
        }
    }

    private void bse() {
        if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst <= 0) {
            long j;
            int init;
            com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.rtd;
            if (bVar.rsR.bJq()) {
                j = (long) bVar.rsM;
                bVar.rsR.v(j, j);
            }
            bVar = this.rtd;
            if (bVar.rsS.bJq()) {
                j = (long) bVar.rsN;
                bVar.rsS.v(j, j);
            }
            com.tencent.mm.plugin.voip_cs.b.b.a brN = com.tencent.mm.plugin.voip_cs.b.b.brN();
            brN.mOY = false;
            brN.mOX = false;
            if (brN.mOV.nGp) {
                w.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
                brN.mOV.ij(false);
                brN.mOV.reset();
            }
            brN.mOV.rjK = 1;
            long currentTimeMillis = System.currentTimeMillis();
            v2protocal com_tencent_mm_plugin_voip_model_v2protocal = brN.mOV;
            com_tencent_mm_plugin_voip_model_v2protocal.netType = com.tencent.mm.plugin.voip.b.a.getNetType(ab.getContext());
            com_tencent_mm_plugin_voip_model_v2protocal.rjJ = com_tencent_mm_plugin_voip_model_v2protocal.netType;
            com.tencent.mm.plugin.voip_cs.b.b.brP().rjJ = com_tencent_mm_plugin_voip_model_v2protocal.netType;
            if (com_tencent_mm_plugin_voip_model_v2protocal.netType == 5) {
                com_tencent_mm_plugin_voip_model_v2protocal.netType = 4;
            }
            boolean z = com_tencent_mm_plugin_voip_model_v2protocal.rjJ >= 4 && (v2protocal.qXE & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 && (v2protocal.qXE & 255) >= 30;
            boolean z2 = p.gRc.gPz == 1 && p.gRc.gPc.width >= 480 && p.gRc.gPc.height >= 360 && p.gRc.gPe.width >= 480 && p.gRc.gPe.height >= 360;
            boolean z3 = p.gRc.gPz == 0;
            if ((z || z2) && !z3) {
                com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth = 480;
                com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight = 360;
                v2protocal.rjG = true;
                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip", "steve:Set Enable 480! " + com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth + "x" + com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight);
            }
            com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip", "steve: Android CPUFlag:" + (v2protocal.qXE & 255) + ", 480x360 Enc flags: bEnable480FromLocal:" + z + ", bEnable480FromSvr:" + z2 + ", bDisable480FromSvr:" + z3);
            com_tencent_mm_plugin_voip_model_v2protocal.rkD = new int[(com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth * com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight)];
            ap.yY();
            com_tencent_mm_plugin_voip_model_v2protocal.rjI = com.tencent.mm.u.c.uH();
            if ((v2protocal.qXE & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                com.tencent.mm.compatible.loader.d.u(ab.getContext(), "libvoipCodec_v7a.so");
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
            } else if ((v2protocal.qXE & 512) != 0) {
                com.tencent.mm.compatible.loader.d.u(ab.getContext(), "libvoipCodec.so");
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
            } else {
                com.tencent.mm.compatible.loader.d.u(ab.getContext(), "libvoipCodec_v5.so");
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
            }
            int i = VERSION.SDK_INT;
            int brx = OpenGlRender.brx();
            Display defaultDisplay = ((WindowManager) ab.getContext().getSystemService("window")).getDefaultDisplay();
            init = com_tencent_mm_plugin_voip_model_v2protocal.init(com_tencent_mm_plugin_voip_model_v2protocal.netType, 2, (com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth << 16) | com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight, (defaultDisplay.getWidth() << 16) | defaultDisplay.getHeight(), com_tencent_mm_plugin_voip_model_v2protocal.rjI, ((i << 16) | (brx << 24)) | v2protocal.qXE, com.tencent.mm.compatible.util.e.hgp + "app_lib/", 8);
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip", "protocal init ret :" + init + ",uin= " + com_tencent_mm_plugin_voip_model_v2protocal.rjI);
            com_tencent_mm_plugin_voip_model_v2protocal.nGp = true;
            if (init < 0) {
                com_tencent_mm_plugin_voip_model_v2protocal.reset();
            }
            j = System.currentTimeMillis();
            w.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", new Object[]{Integer.valueOf(init), Long.valueOf(j - currentTimeMillis)});
            if (init < 0) {
                w.e("MicroMsg.VoipCSEngine", "engine init failed!");
            }
            e brO = com.tencent.mm.plugin.voip_cs.b.b.brO();
            String str = this.rsu;
            String str2 = this.appId;
            String str3 = this.rti;
            w.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + str + ",appid:" + str2 + ",voipCSContext:" + str3);
            brO.rsu = str;
            brO.rst = 1;
            com.tencent.mm.plugin.voip_cs.b.c brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
            w.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
            if (brP.rsg == 0) {
                brP.rsg = (int) (System.currentTimeMillis() / 1000);
            }
            byte[] bArr = null;
            if (!(str3 == null || str3.equals(""))) {
                bArr = str3.getBytes();
            }
            ap.vd().a(823, brO);
            com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.mNO = (int) (System.currentTimeMillis() / 1000);
            k cVar = new com.tencent.mm.plugin.voip_cs.b.c.c(com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.mNO, str, com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.netType, bArr, com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.field_capInfo, str2);
            w.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.field_capInfo));
            ap.vd().a(cVar, 0);
        }
        if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst < 2) {
            this.rsz.brW();
        }
        f fVar = this.rtd;
        w.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
        if (fVar.nRQ == null) {
            w.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
            fVar.nRQ = new ObservableTextureView(fVar.rsA);
            fVar.nRQ.setLayoutParams(new LayoutParams(1, 1));
            fVar.rsB.addView(fVar.nRQ, new LayoutParams(1, 1));
            fVar.nRQ.setVisibility(0);
        }
        if (fVar.nRO == null) {
            init = 320;
            int i2 = 240;
            com.tencent.mm.plugin.voip_cs.b.b.brN();
            if (v2protocal.rjG) {
                init = 640;
                i2 = 480;
            }
            w.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
            fVar.nRO = new com.tencent.mm.plugin.voip.video.a(init, i2);
            fVar.nRO.a(fVar, true);
            fVar.nRO.a(fVar.nRQ);
            com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rjX = fVar.nRO.bru();
            fVar.nRO.brp();
            fVar.nRO.brv();
            w.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[]{Boolean.valueOf(fVar.nRO.brs()), Boolean.valueOf(fVar.nRO.brt())});
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        if (i == 25) {
            ap.yZ().ec(aEA());
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            ap.yZ().eb(aEA());
            return true;
        }
    }

    private int aEA() {
        int i = 2;
        if (ap.yZ().qI()) {
            i = ap.yZ().qU();
        } else if (this.rsz.bqn()) {
            if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst != 2) {
                c cVar = this.rte;
                if (cVar.rgk != null) {
                    i = cVar.rgk.bpb();
                }
            }
            i = 0;
        }
        w.d("MicroMsg.voipcs.VoipCSMainUI", "Current StreamType:%d", new Object[]{Integer.valueOf(i)});
        return i;
    }

    protected void onResume() {
        w.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
        super.onResume();
        if (this.rtd != null) {
            this.rtd.fKF = false;
            if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst > 1) {
                bse();
                if (this.rth != null && this.rth.equals("1")) {
                    this.rtd.bsb();
                }
            }
        }
        if (this.rtj != null) {
            this.rtj.KH();
        }
        ap.getNotification().cancel(44);
    }

    protected void onPause() {
        super.onPause();
        if (!this.rsz.bqn()) {
            this.rsz.aMX();
        }
        if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst == 1 || com.tencent.mm.plugin.voip_cs.b.b.brO().rst == 2) {
            CharSequence string = ab.getContext().getString(R.l.fbE);
            Intent intent = new Intent(ab.getContext(), VoipCSMainUI.class);
            intent.putExtra("voipCSBizId", this.rsu);
            intent.putExtra("voipCSAppId", this.appId);
            Notification notification = new Builder(ab.getContext()).setTicker(ab.getContext().getString(R.l.fbE)).setWhen(System.currentTimeMillis()).setContentTitle(ab.getContext().getString(R.l.fbC)).setContentText(string).setContentIntent(PendingIntent.getActivity(ab.getContext(), 44, intent, 134217728)).setOngoing(true).getNotification();
            notification.icon = com.tencent.mm.ba.a.bCk();
            notification.flags |= 32;
            ap.getNotification().a(44, notification, false);
            if (this.rtj != null && this.rtj.bJq()) {
                this.rtj.v(5000, 5000);
            }
        } else {
            ap.getNotification().cancel(44);
            if (this.rtj != null) {
                this.rtj.KH();
            }
        }
        this.rtd.brZ();
        this.rtd.fKF = true;
    }

    protected void onRestart() {
        w.i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
        super.onRestart();
        if (bsf() && com.tencent.mm.plugin.voip_cs.b.b.brO().rst <= 1) {
            bse();
        }
        if (this.rtd != null) {
            this.rtd.fKF = false;
        }
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        int i;
        int i2 = 2;
        w.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
        if (this.fAP != null) {
            this.fAP.rY();
        }
        com.tencent.mm.sdk.b.b pwVar = new pw();
        if (com.tencent.mm.plugin.voip_cs.b.b.brO().rsv == -1) {
            pwVar.fWW.status = 3;
        } else if (com.tencent.mm.plugin.voip_cs.b.b.brO().rsv == 823) {
            pwVar.fWW.status = 4;
        } else if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst <= 1) {
            pwVar.fWW.status = 1;
        } else if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst >= 2) {
            pwVar.fWW.status = 2;
        }
        com.tencent.mm.sdk.b.a.urY.m(pwVar);
        c cVar = this.rte;
        com.tencent.mm.plugin.voip_cs.b.c brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
        if (cVar.rgk == null || com.tencent.mm.plugin.voip_cs.b.b.brP().rrS != 1) {
            i = 0;
        } else {
            i = cVar.rgk.bpb();
        }
        brP.rsc = (int) ((((float) ap.yZ().getStreamVolume(i)) / ((float) ap.yZ().getStreamMaxVolume(i))) * 100.0f);
        brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
        if (cVar.nOV == null || com.tencent.mm.plugin.voip_cs.b.b.brP().rrS != 1) {
            i = 0;
        } else {
            i = cVar.nOV.ph();
        }
        brP.rkd = i;
        if (cVar.nOV != null) {
            cVar.nOV.oX();
        }
        if (cVar.rgk != null) {
            cVar.rgk.boZ();
        }
        this.rsz.aMX();
        if (this.rtd != null) {
            com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.rtd;
            if (com.tencent.mm.plugin.voip_cs.b.b.brP().aMw == 0) {
                if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst < 2) {
                    com.tencent.mm.plugin.voip_cs.b.b.brP().aMw = 1;
                } else {
                    com.tencent.mm.plugin.voip_cs.b.b.brP().aMw = 3;
                }
            }
            bVar.rmc.bry();
            bVar.rmd.bry();
            bVar.brZ();
            bVar.bsc();
            d brO = com.tencent.mm.plugin.voip_cs.b.b.brO();
            w.i("MicroMsg.voipcs.VoipCSService", "now stop service");
            ap.vd().b(823, brO);
            ap.vd().b(455, brO);
            ap.vd().b(818, brO);
            ap.vd().b(795, brO);
            ap.vd().b(285, brO);
            ap.vd().b(312, brO);
            brO.rst = 3;
            if (brO.rsv != 823) {
                ap.vd().a(880, brO);
                if (brO.rso == 0) {
                    i2 = 1;
                } else if (brO.rso != 2) {
                    i2 = brO.rso == 3 ? 3 : 4;
                }
                w.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + brO.rsu + ",inviteId：" + com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.mNO + ",csroomId:" + com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rjL + ",roomkey:" + com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.mNM + ",reason:" + i2);
                ap.vd().a(new com.tencent.mm.plugin.voip_cs.b.c.a(com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.mNO, com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rjL, com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.mNM, brO.rsu, i2), 0);
            }
            brO.rsw.KH();
            brO.rsx.KH();
            brO.rsn = 0;
            brO.rrJ = 0;
            brO.rso = 0;
            brO.rsp = 0;
            brO.rsq = null;
            brO.mNW = 0;
            brO.rsr = 0;
            brO.rst = 0;
            brO.rsu = "";
            brO.rss = 0;
            brO.rsv = 0;
            com.tencent.mm.plugin.voip_cs.b.b.a brN = com.tencent.mm.plugin.voip_cs.b.b.brN();
            w.i("MicroMsg.VoipCSEngine", "now stop engine");
            brN.mOV.ij(true);
            com.tencent.mm.plugin.voip_cs.b.c brP2 = com.tencent.mm.plugin.voip_cs.b.b.brP();
            if (bg.mA(brP2.mPu) && bg.mA(brP2.mPt)) {
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = com.tencent.mm.plugin.voip_cs.b.b.brN().mOV;
                com_tencent_mm_plugin_voip_model_v2protocal.getVoipcsChannelInfo(com_tencent_mm_plugin_voip_model_v2protocal.rlk, com_tencent_mm_plugin_voip_model_v2protocal.rlk.length, brP2.rrQ == 1 ? 1 : 0);
                w.d("MicroMsg.Voip", "field_voipcsEngineInfoLength: %d", new Object[]{Integer.valueOf(com_tencent_mm_plugin_voip_model_v2protocal.field_voipcsChannelInfoLength)});
                brP2.mPu = new String(com_tencent_mm_plugin_voip_model_v2protocal.rlk, 0, com_tencent_mm_plugin_voip_model_v2protocal.field_voipcsChannelInfoLength);
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal2 = com.tencent.mm.plugin.voip_cs.b.b.brN().mOV;
                com_tencent_mm_plugin_voip_model_v2protocal2.getVoipcsEngineInfo(com_tencent_mm_plugin_voip_model_v2protocal2.rll, com_tencent_mm_plugin_voip_model_v2protocal2.rll.length);
                w.d("MicroMsg.Voip", "field_voipcsEngineInfoLength: %d", new Object[]{Integer.valueOf(com_tencent_mm_plugin_voip_model_v2protocal2.field_voipcsEngineInfoLength)});
                String str = com_tencent_mm_plugin_voip_model_v2protocal2.mNT + "," + com_tencent_mm_plugin_voip_model_v2protocal2.mNM + "," + com_tencent_mm_plugin_voip_model_v2protocal2.rjL + "," + com.tencent.mm.plugin.voip_cs.b.b.brP().rrS + "," + com_tencent_mm_plugin_voip_model_v2protocal2.rjX + "," + com_tencent_mm_plugin_voip_model_v2protocal2.rjY + com_tencent_mm_plugin_voip_model_v2protocal2.bqI() + new String(com_tencent_mm_plugin_voip_model_v2protocal2.rll, 0, com_tencent_mm_plugin_voip_model_v2protocal2.field_voipcsEngineInfoLength);
                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip", "voipreport:NewEngineString:" + str);
                brP2.mPt = str;
                w.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", new Object[]{brP2.mPu});
                w.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", new Object[]{brP2.mPt});
            }
            ap.vd().a(312, com.tencent.mm.plugin.voip_cs.b.b.brO());
            ap.vd().a(new com.tencent.mm.plugin.voip_cs.b.c.e(com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rjL, com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.mNM), 0);
            brN.mOV.reset();
            com.tencent.mm.plugin.voip.model.k.bpZ().bqb();
            com.tencent.mm.plugin.voip.model.k.bpZ().rit = null;
        }
        this.rtd = null;
        this.rte = null;
        ap.yZ().setMode(0);
        ab.getContext().unregisterReceiver(this.rid);
        ap.yZ().b(this.rtk);
        ap.yZ().qH();
        if (this.rhx != null) {
            this.rhx.cS(ab.getContext());
        }
        ap.b(this.oYc);
        if (this.rtj != null) {
            this.rtj.KH();
        }
        ap.getNotification().cancel(44);
        if (!(this.mMp == null || this.mMq == null)) {
            this.mMp.listen(this.mMq, 0);
            this.mMq = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dpL;
    }

    public final void vn(int i) {
        w.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + i + ",CallingStatus:" + com.tencent.mm.plugin.voip_cs.b.b.brO().rst);
        if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst == 0) {
            finish();
        } else if (this.rtd != null) {
            this.rtd.vq(i);
        }
    }

    public final void onError(int i) {
        if (this.rtd != null) {
            w.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:" + i);
            this.rtd.vq(i);
        }
    }

    public final void dM(String str, String str2) {
        com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.rtd;
        if (bVar.rsQ.equals("") && i.isNullOrEmpty(str2)) {
            bVar.jWd.setText(R.l.fbx);
        } else {
            bVar.HI(str2);
        }
        if (bVar.rsP.equals("") && i.isNullOrEmpty(str) && (bVar.rsA.iMn == null || bVar.rsA.iMn.equals(""))) {
            bVar.rsG.setImageResource(R.g.bes);
            return;
        }
        SharedPreferences bIY = ab.bIY();
        if (!(i.isNullOrEmpty(str) || bVar.rsP.equals(str))) {
            bVar.HJ(str);
            bIY.edit().putString(bVar.brX(), str).commit();
        }
        if (!i.isNullOrEmpty(str2) && !bVar.rsQ.equals(str2)) {
            bVar.HI(str2);
            bIY.edit().putString(bVar.brY(), str2).commit();
        }
    }

    private boolean bsf() {
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            w.d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, "", "")), bg.bJZ(), this});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, "", "")) {
                return true;
            }
            w.i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
            return false;
        }
        w.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            w.e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", new Object[]{Integer.valueOf(i)});
            return;
        }
        w.d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    bse();
                    return;
                } else {
                    g.a(this, getString("android.permission.CAMERA".equals(strArr[0]) ? R.l.eFG : R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ VoipCSMainUI rtl;

                        {
                            this.rtl = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.rtl.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ VoipCSMainUI rtl;

                        {
                            this.rtl = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.rtl.vn(3);
                        }
                    });
                    return;
                }
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                if (iArr[0] == 0) {
                    w.d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
                    if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, "", "")) {
                        bse();
                        return;
                    }
                    return;
                }
                g.a(this, getString(R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                    final /* synthetic */ VoipCSMainUI rtl;

                    {
                        this.rtl = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.rtl.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ VoipCSMainUI rtl;

                    {
                        this.rtl = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.rtl.vn(2);
                    }
                });
                return;
            default:
                return;
        }
    }

    public final void aDE() {
        int i;
        com.tencent.mm.plugin.voip_cs.b.c brP;
        this.rtd.aDE();
        if (ap.yZ().qO() || ap.yZ().qI()) {
            this.rte.id(false);
        } else {
            this.rte.id(true);
        }
        c cVar = this.rte;
        if (cVar.nOV != null) {
            boolean pf = cVar.nOV.pf();
            com.tencent.mm.plugin.voip_cs.b.b.brP().rrS = 1;
            if (pf) {
                i = 1;
                com.tencent.mm.plugin.voip_cs.b.b.brP().rsl = i;
                cVar = this.rte;
                if (cVar.rgk != null) {
                    com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rjY = Math.abs(1);
                } else {
                    cVar.rgk.boX();
                    if (cVar.rgk.boX() <= 0) {
                        com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rjY = Math.abs(1);
                    }
                }
                this.rsz.aMX();
                brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
                if (brP.rsg != 0) {
                    brP.rrV = ((int) (System.currentTimeMillis() / 1000)) - brP.rsg;
                }
                brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
                w.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
                if (brP.rsj == 0) {
                    brP.rsj = (int) (System.currentTimeMillis() / 1000);
                }
                brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
                w.d("MicroMsg.VoipCSReportHelper", "markConnect");
                if (brP.rsi != 0) {
                    brP.rrX = (long) (((int) (System.currentTimeMillis() / 1000)) - brP.rsi);
                }
            }
        }
        i = -1;
        com.tencent.mm.plugin.voip_cs.b.b.brP().rsl = i;
        cVar = this.rte;
        if (cVar.rgk != null) {
            cVar.rgk.boX();
            if (cVar.rgk.boX() <= 0) {
                com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rjY = Math.abs(1);
            }
        } else {
            com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rjY = Math.abs(1);
        }
        this.rsz.aMX();
        brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
        if (brP.rsg != 0) {
            brP.rrV = ((int) (System.currentTimeMillis() / 1000)) - brP.rsg;
        }
        brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
        w.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
        if (brP.rsj == 0) {
            brP.rsj = (int) (System.currentTimeMillis() / 1000);
        }
        brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
        w.d("MicroMsg.VoipCSReportHelper", "markConnect");
        if (brP.rsi != 0) {
            brP.rrX = (long) (((int) (System.currentTimeMillis() / 1000)) - brP.rsi);
        }
    }

    public final void bsd() {
        w.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
        this.rtd.vq(5);
    }
}
