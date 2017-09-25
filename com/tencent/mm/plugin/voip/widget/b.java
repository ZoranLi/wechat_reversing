package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.ui.VoipWarningDialog;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.pb.common.c.i;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b implements com.tencent.mm.plugin.voip.ui.b {
    private static final String fwJ;
    private static final String fwK;
    public int mStatus = -1;
    private CaptureView rhA;
    public x rhE;
    private boolean rhF;
    private boolean rhG;
    private int rhK = 1;
    private long rhL = -1;
    private boolean riQ = false;
    public aj rnU;
    private c rqZ;
    public BaseSmallView rra;
    private aj rrb;
    private WakeLock rrc;
    private long rrd = -1;
    private boolean rre = false;
    private OnClickListener rrf = new OnClickListener(this) {
        final /* synthetic */ b rrh;

        {
            this.rrh = r1;
        }

        public final void onClick(View view) {
            if (this.rrh.rra != null) {
                this.rrh.rra.setOnClickListener(null);
            }
            this.rrh.rnU = new aj(new a(this) {
                final /* synthetic */ AnonymousClass1 rri;

                {
                    this.rri = r1;
                }

                public final boolean oQ() {
                    w.i("MicroMsg.Voip.VoipSmallWindow", "click small view and time is up we remove it..");
                    this.rri.rrh.brL();
                    if (this.rri.rrh.rnU != null) {
                        this.rri.rrh.rnU.KH();
                    }
                    return true;
                }
            }, false);
            this.rrh.rnU.v(2000, 2000);
            Intent intent = new Intent(ab.getContext(), VideoActivity.class);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ab.getContext().startActivity(intent);
        }
    };
    private aj rrg;

    static {
        String rB = p.rB();
        fwJ = rB;
        fwK = o.getString(rB.hashCode());
    }

    public b(c cVar, int i, x xVar, boolean z, boolean z2, boolean z3) {
        w.i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[]{com.tencent.mm.plugin.voip.b.b.vf(i), xVar.field_username, Boolean.valueOf(z)});
        this.rhE = xVar;
        this.rqZ = cVar;
        this.rhG = z;
        this.rhF = z2;
        this.riQ = z3;
        dm(0, i);
        this.rrc = ((PowerManager) ab.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
        this.rrc.acquire();
    }

    public final void vb(int i) {
    }

    public final void bQ(boolean z) {
    }

    public final void dm(int i, int i2) {
        Integer num = null;
        w.i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", new Object[]{com.tencent.mm.plugin.voip.b.b.vf(i2)});
        if (i2 == this.mStatus) {
            w.i("MicroMsg.Voip.VoipSmallWindow", "state unchange");
            return;
        }
        this.mStatus = i2;
        String string;
        switch (i2) {
            case 0:
            case 2:
            case 4:
                w.i("MicroMsg.Voip.VoipSmallWindow", "showVideoInviting");
                if (this.rra != null) {
                    num = (Integer) this.rra.getTag();
                }
                if (num == null || !(num.intValue() == 0 || 2 == num.intValue() || 4 == num.intValue())) {
                    string = ab.getContext().getString(R.l.fcG);
                    f(string, string, "", true);
                    if (this.rqZ != null) {
                        this.rqZ.a(this, 2);
                        return;
                    }
                    return;
                }
                return;
            case 1:
            case 3:
            case 5:
            case 257:
            case 259:
                if (2 == this.rhK) {
                    vm(R.l.fbc);
                }
                brL();
                string = ab.getContext().getString(R.l.fcN);
                f(string, n.eK(this.rhE.field_username), string, true);
                brJ();
                if (this.rqZ != null) {
                    this.rqZ.a(this, 2);
                    return;
                }
                return;
            case 6:
            case GameJsApiLaunchApplication.CTRL_BYTE /*260*/:
                w.i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
                this.rre = true;
                if (-1 == this.rrd) {
                    this.rrd = System.currentTimeMillis();
                }
                if (this.rqZ != null) {
                    this.rqZ.a(this, 2);
                }
                if (com.tencent.mm.compatible.e.b.aA(ab.getContext())) {
                    brH();
                } else {
                    w.e("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking, permission denied");
                    VoipWarningDialog.a(ab.getContext(), new VoipWarningDialog.a(this) {
                        final /* synthetic */ b rrh;

                        {
                            this.rrh = r1;
                        }

                        public final void a(VoipWarningDialog voipWarningDialog) {
                            voipWarningDialog.finish();
                            String string = ab.getContext().getString(R.l.fcG);
                            this.rrh.f(string, n.eK(this.rrh.rhE.field_username), string, false);
                            if (com.tencent.mm.plugin.voip.b.b.vk(this.rrh.mStatus) || com.tencent.mm.plugin.voip.b.b.vi(this.rrh.mStatus)) {
                                this.rrh.brH();
                            }
                        }

                        public final void b(VoipWarningDialog voipWarningDialog) {
                            voipWarningDialog.finish();
                        }
                    });
                    if (!d.bpd().riO) {
                        d.bpd().riO = true;
                        ap.yY();
                        if (System.currentTimeMillis() - com.tencent.mm.u.c.vr().yB(327950) > 86400000) {
                            String str = "have not permission to showing floating window\n";
                            ap.yY();
                            com.tencent.mm.u.c.vr().setLong(327950, System.currentTimeMillis());
                            w.d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + str.length());
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.sYN).append("\n");
                            stringBuilder.append("#accinfo.revision=").append(e.REV).append("\n");
                            stringBuilder.append("#accinfo.uin=").append(ao.hlW.A("last_login_uin", fwK)).append("\n");
                            stringBuilder.append("#accinfo.dev=").append(fwJ).append("\n");
                            stringBuilder.append("#accinfo.build=").append(e.TIME).append(":").append(e.HOSTNAME).append(":").append(f.fuV).append("\n");
                            Date date = new Date();
                            stringBuilder.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append("\n");
                            stringBuilder.append("#accinfo.content:\n");
                            Intent intent = new Intent();
                            intent.setClassName(ab.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
                            intent.setAction("uncatch_exception");
                            intent.putExtra("exceptionWriteSdcard", false);
                            intent.putExtra("exceptionPid", Process.myPid());
                            String str2 = "userName";
                            string = ao.hlW.A("login_weixin_username", "");
                            if (bg.mA(string)) {
                                string = ao.hlW.A("login_user_name", "never_login_crash");
                            }
                            intent.putExtra(str2, string);
                            intent.putExtra("tag", "float_window_permission");
                            intent.putExtra("exceptionMsg", Base64.encodeToString((stringBuilder.toString() + str).getBytes(), 2));
                            ab.getContext().startService(intent);
                        }
                    }
                }
                string = ab.getContext().getString(R.l.fcG);
                f(string, n.eK(this.rhE.field_username), string, false);
                return;
            case 7:
            case 261:
                w.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
                if (-1 == this.rrd) {
                    this.rrd = System.currentTimeMillis();
                }
                if (2 == this.rhK) {
                    vm(R.l.fbc);
                }
                brL();
                this.rrb = new aj(new a(this) {
                    final /* synthetic */ b rrh;

                    {
                        this.rrh = r1;
                    }

                    public final boolean oQ() {
                        if (this.rrh.mStatus == 8) {
                            ap.getNotification().cancel(40);
                            w.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking...CALLING_STATE_FINISH state..cancel notification..");
                            return false;
                        }
                        w.i("MicroMsg.Voip.VoipSmallWindow", "show voice talking, first timer trigger..");
                        String brK = this.rrh.brK();
                        this.rrh.f(brK, n.eK(this.rrh.rhE.field_username), brK, false);
                        return true;
                    }
                }, true);
                this.rrb.v(5000, 5000);
                string = brK();
                f(string, n.eK(this.rhE.field_username), string, false);
                brJ();
                if (4101 == i) {
                    vm(R.l.fcB);
                }
                if (this.rqZ != null) {
                    this.rqZ.a(this, 2);
                    return;
                }
                return;
            case 8:
            case 262:
                switch (i) {
                    case 4099:
                        vm(R.l.fbn);
                        break;
                    case 4105:
                        vm(R.l.fcq);
                        break;
                    case 4106:
                        vm(R.l.fcz);
                        break;
                }
                brL();
                return;
            case 256:
            case 258:
                w.i("MicroMsg.Voip.VoipSmallWindow", "showCalledVideoInviting");
                if (this.rra != null) {
                    num = (Integer) this.rra.getTag();
                }
                if (num == null || !(256 == num.intValue() || 258 == num.intValue())) {
                    string = ab.getContext().getString(R.l.fcG);
                    f(string, string, "", true);
                    if (this.rqZ != null) {
                        this.rqZ.a(this, 2);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static void vm(int i) {
        Context context = ab.getContext();
        Toast.makeText(context, context.getString(i), 1).show();
    }

    public final void brH() {
        w.i("MicroMsg.Voip.VoipSmallWindow", "show mini..");
        brL();
        Context context = ab.getContext();
        d.bpd();
        this.rra = new a(context, m.ii(false));
        this.rra.dS(this.rhL);
        context = ab.getContext();
        d.bpd();
        int height = (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight() / 5) + com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, 7.0f);
        int a = (int) (((float) com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, 7.0f)) + (m.ii(true) * ((float) height)));
        this.rra.dq(a, height);
        this.rra.setOnClickListener(this.rrf);
        w.i("MicroMsg.Voip.VoipSmallWindow", "now add to view..");
        Point point = new Point(a, height);
        w.i("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
        if (com.tencent.mm.plugin.voip.b.b.vk(this.mStatus) || com.tencent.mm.plugin.voip.b.b.vi(this.mStatus)) {
            if (this.rrb != null) {
                this.rrb.KH();
            }
            if (this.rrg != null) {
                this.rrg.KH();
            }
            if (this.rnU != null) {
                this.rnU.KH();
            }
            ap.getNotification().cancel(40);
            WindowManager windowManager = (WindowManager) ab.getContext().getSystemService("window");
            LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
            layoutParams.format = 1;
            layoutParams.flags = 40;
            layoutParams.gravity = 51;
            context = ab.getContext();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            layoutParams.width = point.x;
            layoutParams.height = point.y;
            point = d.bpd().riN;
            if (point == null) {
                ap.yY();
                int i = com.tencent.mm.u.c.vr().getInt(327947, 0);
                a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, 5.0f);
                layoutParams.x = (displayMetrics.widthPixels - layoutParams.width) - a;
                layoutParams.y = a + i;
            } else {
                layoutParams.x = point.x;
                layoutParams.y = point.y;
            }
            if (this.rhA != null) {
                if (this.rhA.getParent() != null && (this.rhA.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.rhA.getParent()).removeView(this.rhA);
                }
                this.rra.a(this.rhA);
            }
            this.rra.setTag(Integer.valueOf(this.mStatus));
            try {
                windowManager.addView(this.rra, layoutParams);
                return;
            } catch (Exception e) {
                w.e("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager failed: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        w.i("MicroMsg.Voip.VoipSmallWindow", "not in voip talking or inviting,now return..");
    }

    public final String brI() {
        String format;
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.rhL);
        if (this.rhL == -1) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 3600) {
            format = String.format(Locale.US, "%d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        } else {
            format = String.format(Locale.US, "%d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        if (i.wx(format)) {
            return "00:00";
        }
        return format;
    }

    private void brJ() {
        w.i("MicroMsg.Voip.VoipSmallWindow", "showMini");
        boolean z = false;
        if (this.mStatus == 261 || this.mStatus == 7) {
            this.rrg = new aj(new a(this) {
                final /* synthetic */ b rrh;

                {
                    this.rrh = r1;
                }

                public final boolean oQ() {
                    d.bpe().HE(this.rrh.brI());
                    return true;
                }
            }, true);
            this.rrg.v(1000, 1000);
            z = true;
        }
        Intent intent = new Intent();
        intent.setClass(ab.getContext(), VideoActivity.class);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("Voip_User", this.rhE.field_username);
        intent.putExtra("Voip_Outcall", this.rhF);
        intent.putExtra("Voip_VideoCall", this.rhG);
        intent.putExtra("Voip_Is_Talking", z);
        d.bpe().a(intent, new com.tencent.mm.plugin.voip.ui.a(this) {
            final /* synthetic */ b rrh;

            {
                this.rrh = r1;
            }

            public final boolean aDL() {
                if (com.tencent.mm.plugin.voip.b.b.vk(this.rrh.mStatus) || com.tencent.mm.plugin.voip.b.b.vi(this.rrh.mStatus)) {
                    return true;
                }
                return false;
            }

            public final void a(Intent intent, h hVar) {
                if (intent.getBooleanExtra("Voip_Is_Talking", false)) {
                    hVar.HE(this.rrh.brI());
                } else {
                    hVar.HE(ab.getContext().getString(R.l.eCw));
                }
            }
        });
    }

    public final String brK() {
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.rhL);
        if (this.rhL == -1) {
            currentTimeMillis = 0;
        }
        String string = ab.getContext().getString(R.l.fcN);
        if (currentTimeMillis >= 3600) {
            return string + String.format(Locale.US, "    %d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        return string + String.format(Locale.US, "    %d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
    }

    public final void f(final String str, final String str2, final String str3, boolean z) {
        w.i("MicroMsg.Voip.VoipSmallWindow", "showNotification..show notification..tickContent:" + str + ",title:" + str2 + ",content:" + str3 + ",breathEffect:" + z);
        w.h("MicroMsg.Voip.VoipSmallWindow", "breathEffect " + z, new Object[0]);
        if (z) {
            this.rrb = new aj(new a(this) {
                private int mCount = 0;
                final /* synthetic */ b rrh;

                public final boolean oQ() {
                    w.i("MicroMsg.Voip.VoipSmallWindow", "time out ,status is " + this.rrh.mStatus);
                    this.mCount++;
                    if (this.rrh.mStatus == 8 || this.rrh.mStatus == -1 || this.rrh.mStatus == 262) {
                        w.i("MicroMsg.Voip.VoipSmallWindow", "CALLING_STATE_FINISH state..cancel notification..");
                        ap.getNotification().cancel(40);
                        return false;
                    }
                    this.rrh.f(str + (this.mCount % 2 == 1 ? " " : ""), str2, str3, false);
                    return true;
                }
            }, true);
            this.rrb.v(5000, 5000);
        }
        Intent intent = new Intent();
        intent.setClass(ab.getContext(), VideoActivity.class);
        intent.putExtra("Voip_User", this.rhE.field_username);
        intent.putExtra("Voip_Outcall", this.rhF);
        intent.putExtra("Voip_VideoCall", this.rhG);
        Notification a = com.tencent.mm.plugin.voip.b.d.a(new Builder(ab.getContext()).setTicker(str).setWhen(System.currentTimeMillis()).setContentTitle(str2).setContentText(str3).setContentIntent(PendingIntent.getActivity(ab.getContext(), 40, intent, 134217728)).setOngoing(true));
        a.icon = VERSION.SDK_INT < 19 ? R.g.bhU : R.g.bhV;
        ap.getNotification().a(40, a, false);
    }

    public final void brL() {
        w.i("MicroMsg.Voip.VoipSmallWindow", "removeSmallView");
        if (this.rrb != null) {
            this.rrb.KH();
        }
        w.i("MicroMsg.Voip.VoipSmallWindow", "remove small view..cancel notification first..");
        ap.getNotification().cancel(40);
        if (this.rra != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.rra.getLayoutParams();
            d.bpd().riN = new Point(layoutParams.x, layoutParams.y);
            this.rra.uninit();
            try {
                ((WindowManager) ab.getContext().getSystemService("window")).removeView(this.rra);
            } catch (IllegalArgumentException e) {
                w.e("MicroMsg.Voip.VoipSmallWindow", "remove failed", new Object[]{e});
            }
            this.rra = null;
        }
        d.bpe().HE(ab.getContext().getString(R.l.eBI));
        if (this.rrg != null) {
            this.rrg.KH();
        }
        d.bpe().dismiss();
    }

    public final void at(int i, String str) {
        int i2;
        if (i == GameJsApiGetGameCommInfo.CTRL_BYTE) {
            Toast.makeText(ab.getContext(), str, 1).show();
        }
        w.d("MicroMsg.Voip.VoipSmallWindow", "getHintByErrorCode " + i);
        if (i == 235) {
            i2 = R.l.fbT;
        } else if (i == 233) {
            d.bpd().bqm();
            i2 = R.l.fbS;
        } else {
            i2 = i == aw.CTRL_BYTE ? (!com.tencent.mm.ai.b.Hp() || this.rhG) ? R.l.fbU : R.l.fbW : i == JsApiGetSetting.CTRL_INDEX ? R.l.fcg : i == g.CTRL_INDEX ? R.l.fbV : 0;
        }
        if (i2 == 0) {
            vm(R.l.fbR);
        } else {
            vm(i2);
        }
    }

    public final void HD(String str) {
    }

    public final void a(int i, int i2, int[] iArr) {
        if ((GameJsApiLaunchApplication.CTRL_BYTE == this.mStatus || 6 == this.mStatus) && this.rra != null) {
            this.rra.a(i, i2, iArr);
        }
    }

    public final void bpR() {
        if (this.rra != null) {
            this.rra.bpR();
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if ((GameJsApiLaunchApplication.CTRL_BYTE == this.mStatus || 6 == this.mStatus) && this.rra != null) {
            this.rra.a(bArr, j, i, i2, i3, i4, i5);
        }
    }

    public final Context bqR() {
        return null;
    }

    public final void uninit() {
        int i = 3;
        w.i("MicroMsg.Voip.VoipSmallWindow", "uninit");
        if (-1 != this.rrd) {
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
            Object[] objArr = new Object[3];
            if (this.rre) {
                i = 2;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Long.valueOf((System.currentTimeMillis() - this.rrd) / 1000);
            objArr[2] = Integer.valueOf(this.riQ ? 1 : 2);
            gVar.i(11620, objArr);
        }
        if (this.rrc != null && this.rrc.isHeld()) {
            this.rrc.release();
        }
        brL();
        if (this.rrb != null) {
            this.rrb.KH();
        }
        if (this.rrg != null) {
            this.rrg.KH();
        }
        w.i("MicroMsg.Voip.VoipSmallWindow", "uninit..cancel notification..");
        ap.getNotification().cancel(40);
        this.rhA = null;
    }

    public final void dS(long j) {
        this.rhL = j;
        if (this.rra != null) {
            this.rra.dS(j);
        } else if (261 == this.mStatus || 7 == this.mStatus) {
            String brK = brK();
            f(brK, n.eK(this.rhE.field_username), brK, false);
        }
    }

    public final void bqS() {
        Toast.makeText(ab.getContext(), R.l.fcn, 1).show();
    }

    public final void aFs() {
    }

    public final void a(CaptureView captureView) {
        this.rhA = captureView;
        if (this.rra != null && this.rhA != null) {
            if (this.rhA.getParent() != null && (this.rhA.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.rhA.getParent()).removeView(this.rhA);
            }
            this.rra.a(captureView);
        }
    }
}
