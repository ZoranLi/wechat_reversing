package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.o;
import com.tencent.mm.booter.y;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.an;
import com.tencent.mm.e.a.aw;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.e.a.el;
import com.tencent.mm.e.a.hr;
import com.tencent.mm.e.a.ia;
import com.tencent.mm.e.a.la;
import com.tencent.mm.e.a.qw;
import com.tencent.mm.kernel.k;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.modelsimple.ai;
import com.tencent.mm.network.b;
import com.tencent.mm.network.t;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.bindmobile.BindMContactUI;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.j;
import com.tencent.mm.y.e;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public final class HomeUI implements com.tencent.mm.sdk.e.m.b {
    private static HashMap<String, Integer> uQZ;
    public static Boolean uQf = Boolean.valueOf(false);
    public static Boolean uQg = Boolean.valueOf(false);
    public ActionBar Gx;
    private String fRu = null;
    private final long hXO = 180000;
    public View ipu;
    public ProgressDialog isv;
    public int lCS = -1;
    public int lPr = -1;
    public long miD = 0;
    LayoutInflater myo;
    private boolean oIa = true;
    private View pkj;
    private TextView pkk;
    public EditText pkl;
    public h pkm;
    public boolean pkn;
    private View qOv;
    public int qhP = 0;
    private final long qqS = 300;
    public long qqT = SystemClock.elapsedRealtime();
    private final long uPS = 604800000;
    public boolean uPT;
    public boolean uPU = false;
    public e uPV;
    boolean uPW;
    boolean uPX;
    public boolean uPY;
    private HashSet<i> uPZ = new HashSet();
    com.tencent.mm.sdk.b.c uPy = new com.tencent.mm.sdk.b.c<ia>(this) {
        final /* synthetic */ HomeUI uRb;

        {
            this.uRb = r2;
            this.usg = ia.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            this.uRb.uPT = true;
            af.I(this.uRb.uQm);
            af.v(this.uRb.uQm);
            return true;
        }
    };
    IdleHandler uQA;
    IdleHandler uQB = new IdleHandler(this) {
        final /* synthetic */ HomeUI uRb;

        {
            this.uRb = r1;
        }

        public final boolean queueIdle() {
            ap.yY();
            if (bg.f((Integer) com.tencent.mm.u.c.vr().get(15, null)) == 0) {
                w.e("MicroMsg.LauncherUI", "not init finish , do not post sync task");
            } else {
                String A = ao.hlW.A("login_user_name", "");
                if (ap.za() || !A.equals("")) {
                    ap.vd().a(new bb(new com.tencent.mm.u.bb.a(this) {
                        final /* synthetic */ AnonymousClass7 uRd;

                        {
                            this.uRd = r1;
                        }

                        public final void a(com.tencent.mm.network.e eVar) {
                        }
                    }, "launch normal"), 0);
                }
                com.tencent.mm.sdk.f.e.post(new Runnable(new y(this.uRb.uQk)) {
                    final /* synthetic */ y gKD;

                    {
                        this.gKD = r1;
                    }

                    public final void run() {
                        String str;
                        t tVar;
                        long Nz = u.Nz();
                        Process.setThreadPriority(10);
                        y yVar = this.gKD;
                        int i = f.fuV;
                        String rB = p.rB();
                        int i2 = d.sYN;
                        String str2 = "0";
                        String bIN = v.bIN();
                        int i3 = yVar.context.getSharedPreferences(ab.bIX(), 0).getInt("last_reportdevice_channel", 0);
                        int i4 = yVar.context.getSharedPreferences(ab.bIX(), 0).getInt("last_reportdevice_clientversion", 0);
                        if (i3 == 0 && i4 == 0) {
                            i4 = 0;
                        } else if (i3 == i && i4 == i2) {
                            str = null;
                            w.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str);
                            if (u.mA(str)) {
                                tVar = null;
                                try {
                                    tVar = b.a(str, null);
                                    tVar.setConnectTimeout(10000);
                                    tVar.setReadTimeout(10000);
                                    tVar.connect();
                                    if (tVar.getResponseCode() == m.CTRL_INDEX) {
                                        y yVar2 = this.gKD;
                                        int i5 = f.fuV;
                                        int i6 = d.sYN;
                                        SharedPreferences sharedPreferences = yVar2.context.getSharedPreferences(ab.bIX(), 0);
                                        sharedPreferences.edit().putInt("last_reportdevice_channel", i5).commit();
                                        sharedPreferences.edit().putInt("last_reportdevice_clientversion", i6).commit();
                                    }
                                    w.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", Long.valueOf(u.aA(Nz)), Integer.valueOf(i), str);
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.StartupReport", e, "", new Object[0]);
                                    w.e("MicroMsg.StartupReport", "tryReport error url[%s]", str);
                                }
                                if (tVar != null) {
                                    tVar.ieZ.disconnect();
                                }
                            }
                        } else {
                            i4 = 1;
                        }
                        str = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/reportdevice?channel=" + f.fuV + "&deviceid=" + rB + "&clientversion=" + i2 + "&platform=" + str2 + "&lang=" + bIN + "&installtype=" + i4;
                        w.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str);
                        if (u.mA(str)) {
                            tVar = null;
                            tVar = b.a(str, null);
                            tVar.setConnectTimeout(10000);
                            tVar.setReadTimeout(10000);
                            tVar.connect();
                            if (tVar.getResponseCode() == m.CTRL_INDEX) {
                                y yVar22 = this.gKD;
                                int i52 = f.fuV;
                                int i62 = d.sYN;
                                SharedPreferences sharedPreferences2 = yVar22.context.getSharedPreferences(ab.bIX(), 0);
                                sharedPreferences2.edit().putInt("last_reportdevice_channel", i52).commit();
                                sharedPreferences2.edit().putInt("last_reportdevice_clientversion", i62).commit();
                            }
                            w.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", Long.valueOf(u.aA(Nz)), Integer.valueOf(i), str);
                            if (tVar != null) {
                                tVar.ieZ.disconnect();
                            }
                        }
                    }
                }, "StartupReport_report");
                o.onCreate(true);
                HomeUI.bPs();
                com.tencent.mm.plugin.report.service.e.aXH();
                com.tencent.mm.ah.m.c cVar = com.tencent.mm.ah.m.GJ().hHg;
                if (cVar.hHv.size() <= 0 && cVar.hHu.size() <= 0) {
                    A = (String) com.tencent.mm.kernel.h.vI().vr().get(348177, (Object) "");
                    String str = (String) com.tencent.mm.kernel.h.vI().vr().get(348176, (Object) "");
                    if (!bg.mA(A)) {
                        synchronized (cVar) {
                            for (String jA : A.split("-")) {
                                b jA2 = com.tencent.mm.ah.m.c.jA(jA);
                                if (jA2 != null) {
                                    cVar.hHv.add(jA2);
                                }
                            }
                        }
                    }
                    if (!bg.mA(str)) {
                        synchronized (cVar) {
                            for (String jz : str.split("-")) {
                                b jz2 = com.tencent.mm.ah.m.c.jz(jz);
                                if (jz2 != null) {
                                    cVar.hHu.add(jz2);
                                }
                            }
                        }
                    }
                    w.i("MicroMsg.SendImgSpeeder", "Image pool bigfile pool size %d, thumbfile size %d ", Integer.valueOf(cVar.hHu.size()), Integer.valueOf(cVar.hHv.size()));
                }
                cVar.GM();
                Looper.myQueue().removeIdleHandler(this.uRb.uQB);
            }
            return false;
        }
    };
    private int uQC = -1;
    public com.tencent.mm.e.a.hr.a uQD = null;
    com.tencent.mm.sdk.b.c uQE = new com.tencent.mm.sdk.b.c<hr>(this) {
        final /* synthetic */ HomeUI uRb;

        {
            this.uRb = r2;
            this.usg = hr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            hr hrVar = (hr) bVar;
            if (hrVar == null || hrVar.fNi == null || hrVar.fNi.fNj == null) {
                w.i("MicroMsg.LauncherUI", "summeralert event is illegal event[%s]", hrVar);
            } else {
                w.i("MicroMsg.LauncherUI", "summeralert event launcherUIStatus[%s], tid[%d]", this.uRb.uQj, Long.valueOf(Thread.currentThread().getId()));
                if (a.ACTIVITY_RESUME != this.uRb.uQj) {
                    this.uRb.uQD = hrVar.fNi;
                } else {
                    this.uRb.uQD = null;
                    this.uRb.a(hrVar.fNi);
                }
            }
            return false;
        }
    };
    public com.tencent.mm.e.a.la.a uQF = null;
    com.tencent.mm.sdk.b.c uQG = new com.tencent.mm.sdk.b.c<la>(this) {
        final /* synthetic */ HomeUI uRb;

        {
            this.uRb = r2;
            this.usg = la.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            la laVar = (la) bVar;
            if (laVar == null || laVar.fRH == null) {
                w.i("MicroMsg.LauncherUI", "app update ui listener is null.");
            } else if (a.ACTIVITY_RESUME != this.uRb.uQj) {
                this.uRb.uQF = laVar.fRH;
            } else {
                this.uRb.uQF = null;
                l.y.bCs().p(this.uRb.uQk, laVar.fRH.intent);
                w.d("MicroMsg.LauncherUI", "start Update UI");
            }
            return false;
        }
    };
    com.tencent.mm.sdk.b.c uQH = new com.tencent.mm.sdk.b.c<an>(this) {
        final /* synthetic */ HomeUI uRb;

        {
            this.uRb = r2;
            this.usg = an.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            int i = ((an) bVar).fDV.index;
            if (i >= 0 && i <= 3) {
                switch (i) {
                    case 0:
                        this.uRb.SD("tab_main");
                        break;
                    case 1:
                        this.uRb.SD("tab_address");
                        break;
                    case 2:
                        this.uRb.SD("tab_find_friend");
                        break;
                    case 3:
                        this.uRb.SD("tab_settings");
                        break;
                    default:
                        break;
                }
            }
            return false;
        }
    };
    private int uQI = -1;
    private int uQJ = -1;
    public View uQK;
    public View uQL;
    public com.tencent.mm.ui.chatting.En_5b8fbb1e.a uQM;
    public TestTimeForChatting uQN;
    public OnLayoutChangedLinearLayout uQO;
    public com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a uQP = new com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a(this) {
        final /* synthetic */ HomeUI uRb;

        {
            this.uRb = r1;
        }

        public final void bPH() {
            if (this.uRb.uQW == null) {
                this.uRb.uQW = AnimationUtils.loadAnimation(this.uRb.uQk, com.tencent.mm.ui.MMFragmentActivity.a.uUP);
                this.uRb.uQW.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ AnonymousClass25 uRk;

                    {
                        this.uRk = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                        w.i("MicroMsg.LauncherUI", "klem onAnimationStart");
                        this.uRk.uRb.bPw();
                        this.uRk.uRb.km(false);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        w.i("MicroMsg.LauncherUI", "klem animationEnd");
                        this.uRk.uRb.bPx();
                        this.uRk.uRb.uQk.O(1.0f);
                    }
                });
            }
            if (this.uRb.uQV) {
                this.uRb.uQM.mView.startAnimation(this.uRb.uQW);
                this.uRb.uQV = false;
            } else {
                this.uRb.bPw();
                this.uRb.bPx();
            }
            this.uRb.uQO.vpz = null;
            w.i("MicroMsg.LauncherUI", "klem CHATTING ONLAYOUT ");
        }
    };
    String uQQ;
    Bundle uQR;
    Runnable uQS = new Runnable(this) {
        final /* synthetic */ HomeUI uRb;

        {
            this.uRb = r1;
        }

        public final void run() {
            this.uRb.uQX = false;
            if (!this.uRb.uQk.isFinishing()) {
                this.uRb.dS(4, this.uRb.lCS);
                String str = "MicroMsg.LauncherUI";
                String str2 = "ashutest::startChatting, ishow:%b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(this.uRb.uQN == null ? false : this.uRb.uQN.isShown());
                w.i(str, str2, objArr);
                Intent putExtra = new Intent().putExtra("Chat_User", this.uRb.uQQ);
                if (this.uRb.uQR != null) {
                    putExtra.putExtras(this.uRb.uQR);
                }
                putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
                this.uRb.af(putExtra);
                this.uRb.uQO.vpz = this.uRb.uQP;
                this.uRb.uQN.setVisibility(0);
                this.uRb.bPv();
                com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass27 uRp;

                    {
                        this.uRp = r1;
                    }

                    public final void run() {
                        com.tencent.mm.modelstat.d.a(3, "En_5b8fbb1e" + this.uRp.uRb.uQM.bVk(), this.uRp.uRb.uQM.hashCode());
                    }
                }, "directReport_startChattingRunnable");
                this.uRb.uQn = bg.Ny();
                if (this.uRb.uQM.bQi()) {
                    j.a(this.uRb.uQk);
                }
            }
        }

        public final String toString() {
            return super.toString() + "|startChattingRunnable";
        }
    };
    Runnable uQT = new Runnable(this) {
        final /* synthetic */ HomeUI uRb;

        {
            this.uRb = r1;
        }

        public final void run() {
            if (!com.tencent.mm.n.a.aI(this.uRb.uQk) && !com.tencent.mm.n.a.aH(this.uRb.uQk)) {
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
                intent.setFlags(65536);
                g.oUh.i(11409, new Object[0]);
                com.tencent.mm.bb.d.b(this.uRb.uQk, "scanner", ".ui.BaseScanUI", intent);
            }
        }
    };
    private Animation uQU;
    public boolean uQV = false;
    public Animation uQW;
    public boolean uQX = true;
    public LinkedList<Runnable> uQY = new LinkedList();
    public boolean uQa = false;
    public c uQb;
    CustomViewPager uQc;
    c uQd;
    public u uQe;
    private final long uQh = 432000000;
    private final long uQi = 604800000;
    public a uQj = a.ACTIVITY_CREATE;
    public MMFragmentActivity uQk;
    private boolean uQl = v.bIJ();
    public Runnable uQm = new Runnable(this) {
        final /* synthetic */ HomeUI uRb;

        {
            this.uRb = r1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r9 = this;
            r6 = 0;
            r5 = 32768; // 0x8000 float:4.5918E-41 double:1.61895E-319;
            r3 = 1;
            r1 = 0;
            r0 = com.tencent.mm.kernel.h.vG();
            r0 = r0.uV();
            if (r0 != 0) goto L_0x001a;
        L_0x0010:
            r0 = "MicroMsg.LauncherUI";
            r1 = "Account not Ready!!!";
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        L_0x0019:
            return;
        L_0x001a:
            r0 = r9.uRb;
            r0 = r0.uQb;
            if (r0 != 0) goto L_0x002a;
        L_0x0020:
            r0 = "MicroMsg.LauncherUI";
            r1 = "set tag job, but tab view is null";
            com.tencent.mm.sdk.platformtools.w.w(r0, r1);
            goto L_0x0019;
        L_0x002a:
            r0 = com.tencent.mm.u.ap.zb();
            if (r0 != 0) goto L_0x009f;
        L_0x0030:
            r0 = "MicroMsg.UnreadCountHelper";
            r2 = "getFindTabUnreadCount, but mmcore not ready";
            com.tencent.mm.sdk.platformtools.w.w(r0, r2);
            r2 = r1;
        L_0x003a:
            r0 = r9.uRb;
            r0 = r0.uQb;
            r0.ke(r1);
            r0 = r9.uRb;
            r0 = r0.uQb;
            r0.yX(r2);
            if (r2 > 0) goto L_0x0061;
        L_0x004a:
            r0 = com.tencent.mm.az.a.bCj();
            if (r0 == 0) goto L_0x0061;
        L_0x0050:
            r0 = com.tencent.mm.av.l.Kz();
            r0 = r0.Kr();
            if (r0 <= 0) goto L_0x0061;
        L_0x005a:
            r0 = r9.uRb;
            r0 = r0.uQb;
            r0.ke(r3);
        L_0x0061:
            if (r2 > 0) goto L_0x00f6;
        L_0x0063:
            r0 = com.tencent.mm.u.m.xW();
            r0 = r0 & r5;
            if (r0 != 0) goto L_0x00f6;
        L_0x006a:
            com.tencent.mm.u.ap.yY();
            r0 = com.tencent.mm.u.c.vr();
            r4 = 68384; // 0x10b20 float:9.5826E-41 double:3.3786E-319;
            r0 = r0.get(r4, r6);
            r0 = (java.lang.Boolean) r0;
            r0 = com.tencent.mm.sdk.platformtools.bg.b(r0, r3);
            if (r0 == 0) goto L_0x00f6;
        L_0x0080:
            com.tencent.mm.u.ap.yY();
            r0 = com.tencent.mm.u.c.vr();
            r4 = 68377; // 0x10b19 float:9.5817E-41 double:3.37827E-319;
            r0 = r0.get(r4, r6);
            r0 = (java.lang.String) r0;
            r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r0 != 0) goto L_0x00f6;
        L_0x0096:
            r0 = r9.uRb;
            r0 = r0.uQb;
            r0.ke(r3);
            goto L_0x0019;
        L_0x009f:
            r0 = com.tencent.mm.u.m.xP();
            r0 = r0 & r5;
            if (r0 != 0) goto L_0x02d4;
        L_0x00a6:
            r0 = com.tencent.mm.u.h.xI();
            r0 = r0 + 0;
        L_0x00ac:
            r2 = com.tencent.mm.u.m.xW();
            r2 = r2 & 512;
            if (r2 != 0) goto L_0x02d1;
        L_0x00b4:
            r2 = com.tencent.mm.az.a.bCj();
            if (r2 != 0) goto L_0x02d1;
        L_0x00ba:
            r2 = com.tencent.mm.av.l.Kz();
            r2 = r2.Kr();
            r2 = r2 + 0;
        L_0x00c4:
            r4 = com.tencent.mm.u.m.xW();
            r4 = r4 & 256;
            if (r4 != 0) goto L_0x00e0;
        L_0x00cc:
            r4 = com.tencent.mm.av.l.KA();
            if (r4 == 0) goto L_0x00d7;
        L_0x00d2:
            r4 = r4.Kr();
            r2 = r2 + r4;
        L_0x00d7:
            r4 = com.tencent.mm.pluginsdk.l.a.bCn();
            r4 = r4.baL();
            r2 = r2 + r4;
        L_0x00e0:
            r0 = r0 + r2;
            r2 = com.tencent.mm.u.m.xW();
            r2 = r2 & r5;
            if (r2 != 0) goto L_0x00f3;
        L_0x00e8:
            r2 = com.tencent.mm.plugin.sns.b.m.pQC;
            if (r2 == 0) goto L_0x00f3;
        L_0x00ec:
            r2 = com.tencent.mm.plugin.sns.b.m.pQC;
            r2 = r2.Kr();
            r0 = r0 + r2;
        L_0x00f3:
            r2 = r0;
            goto L_0x003a;
        L_0x00f6:
            if (r2 > 0) goto L_0x0199;
        L_0x00f8:
            r0 = com.tencent.mm.i.g.sV();
            r4 = "JDEntranceConfigName";
            r0 = r0.getValue(r4);
            r4 = com.tencent.mm.i.g.sV();
            r5 = "JDEntranceConfigIconUrl";
            r4 = r4.getValue(r5);
            r5 = com.tencent.mm.i.g.sV();
            r6 = "JDEntranceConfigJumpUrl";
            r5 = r5.getValue(r6);
            r6 = "MicroMsg.LauncherUI";
            r7 = new java.lang.StringBuilder;
            r8 = "jd tryshow configName ";
            r7.<init>(r8);
            r7 = r7.append(r0);
            r8 = " iconUrl ";
            r7 = r7.append(r8);
            r7 = r7.append(r4);
            r8 = " jumpUrl ";
            r7 = r7.append(r8);
            r7 = r7.append(r5);
            r7 = r7.toString();
            com.tencent.mm.sdk.platformtools.w.i(r6, r7);
            r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r0 != 0) goto L_0x0199;
        L_0x014b:
            r0 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
            if (r0 != 0) goto L_0x0199;
        L_0x0151:
            r0 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
            if (r0 != 0) goto L_0x0199;
        L_0x0157:
            r0 = com.tencent.mm.pluginsdk.l.aa.sBG;
            if (r0 == 0) goto L_0x0199;
        L_0x015b:
            r4 = r0.bmO();
            r5 = "MicroMsg.LauncherUI";
            r6 = new java.lang.StringBuilder;
            r7 = "jdshowFriend ";
            r6.<init>(r7);
            r6 = r6.append(r4);
            r6 = r6.toString();
            com.tencent.mm.sdk.platformtools.w.i(r5, r6);
            if (r4 == 0) goto L_0x0199;
        L_0x0177:
            r0 = r0.bmW();
            r4 = r0.axD();
            if (r4 == 0) goto L_0x0190;
        L_0x0181:
            r0 = r0.bmF();
            if (r0 != 0) goto L_0x0190;
        L_0x0187:
            r0 = r9.uRb;
            r0 = r0.uQb;
            r0.ke(r3);
            goto L_0x0019;
        L_0x0190:
            r0 = "MicroMsg.LauncherUI";
            r4 = "jd time is not start or jd time isExpire";
            com.tencent.mm.sdk.platformtools.w.i(r0, r4);
        L_0x0199:
            com.tencent.mm.u.ap.yY();
            r0 = com.tencent.mm.u.c.vr();
            r4 = 589825; // 0x90001 float:8.26521E-40 double:2.914123E-318;
            r5 = java.lang.Boolean.valueOf(r1);
            r0 = r0.get(r4, r5);
            r0 = (java.lang.Boolean) r0;
            r0 = r0.booleanValue();
            if (r0 == 0) goto L_0x01ba;
        L_0x01b3:
            r0 = r9.uRb;
            r0 = r0.uQb;
            r0.ke(r3);
        L_0x01ba:
            r0 = com.tencent.mm.i.g.sV();
            r4 = "WCOEntranceSwitch";
            r0 = r0.getInt(r4, r1);
            if (r0 <= 0) goto L_0x02b9;
        L_0x01c7:
            com.tencent.mm.u.ap.yY();
            r0 = com.tencent.mm.u.c.vr();
            r4 = com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN;
            r5 = java.lang.Boolean.valueOf(r3);
            r0.a(r4, r5);
            r0 = r9.uRb;
            r0 = r0.uQb;
            r0 = r0.bOD();
            if (r0 != 0) goto L_0x0227;
        L_0x01e1:
            if (r2 > 0) goto L_0x0227;
        L_0x01e3:
            com.tencent.mm.u.ap.yY();
            r0 = com.tencent.mm.u.c.vr();
            r4 = com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT;
            r5 = java.lang.Integer.valueOf(r1);
            r0 = r0.get(r4, r5);
            r0 = (java.lang.Integer) r0;
            r0 = r0.intValue();
            r4 = com.tencent.mm.i.g.sV();
            r5 = "WCOEntranceRedDot";
            r4 = r4.getInt(r5, r1);
            if (r0 < r4) goto L_0x0220;
        L_0x0207:
            com.tencent.mm.u.ap.yY();
            r0 = com.tencent.mm.u.c.vr();
            r4 = com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN;
            r5 = java.lang.Boolean.valueOf(r1);
            r0 = r0.get(r4, r5);
            r0 = (java.lang.Boolean) r0;
            r0 = r0.booleanValue();
            if (r0 != r3) goto L_0x0227;
        L_0x0220:
            r0 = r9.uRb;
            r0 = r0.uQb;
            r0.ke(r3);
        L_0x0227:
            if (r2 > 0) goto L_0x024a;
        L_0x0229:
            r0 = com.tencent.mm.kernel.h.vI();
            r0 = r0.vr();
            r2 = com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN;
            r4 = java.lang.Boolean.valueOf(r1);
            r0 = r0.get(r2, r4);
            r0 = (java.lang.Boolean) r0;
            r0 = r0.booleanValue();
            if (r0 == 0) goto L_0x024a;
        L_0x0243:
            r0 = r9.uRb;
            r0 = r0.uQb;
            r0.ke(r3);
        L_0x024a:
            r0 = com.tencent.mm.as.m.Iw();
            r2 = r0.valid();
            if (r2 == 0) goto L_0x02cb;
        L_0x0254:
            r0 = r0.hQm;
            r0 = r0.hQo;
            if (r0 != r3) goto L_0x02cb;
        L_0x025a:
            r0 = r3;
        L_0x025b:
            if (r0 == 0) goto L_0x0264;
        L_0x025d:
            r0 = r9.uRb;
            r0 = r0.uQb;
            r0.ke(r3);
        L_0x0264:
            com.tencent.mm.u.ap.yY();
            r0 = com.tencent.mm.u.c.vr();
            r2 = 40;
            r0 = r0.getInt(r2, r1);
            r2 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
            r0 = r0 & r2;
            if (r0 != 0) goto L_0x02cf;
        L_0x0276:
            r2 = r3;
        L_0x0277:
            r0 = com.tencent.mm.i.g.sV();
            r4 = "VoiceprintEntry";
            r0 = r0.getValue(r4);
            r0 = com.tencent.mm.sdk.platformtools.bg.getInt(r0, r1);
            if (r0 != r3) goto L_0x02cd;
        L_0x0288:
            com.tencent.mm.u.ap.yY();
            r0 = com.tencent.mm.u.c.vr();
            r4 = com.tencent.mm.storage.w.a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN;
            r5 = java.lang.Boolean.valueOf(r3);
            r0 = r0.get(r4, r5);
            r0 = (java.lang.Boolean) r0;
            r0 = r0.booleanValue();
        L_0x029f:
            if (r0 == 0) goto L_0x02b3;
        L_0x02a1:
            if (r2 == 0) goto L_0x02b3;
        L_0x02a3:
            r0 = "MicroMsg.LauncherUI";
            r2 = "show voiceprint dot";
            com.tencent.mm.sdk.platformtools.w.i(r0, r2);
            r0 = r9.uRb;
            r0 = r0.uQb;
            r0.kf(r3);
        L_0x02b3:
            r0 = r9.uRb;
            r0.uPT = r1;
            goto L_0x0019;
        L_0x02b9:
            com.tencent.mm.u.ap.yY();
            r0 = com.tencent.mm.u.c.vr();
            r4 = com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN;
            r5 = java.lang.Boolean.valueOf(r1);
            r0.a(r4, r5);
            goto L_0x0227;
        L_0x02cb:
            r0 = r1;
            goto L_0x025b;
        L_0x02cd:
            r0 = r1;
            goto L_0x029f;
        L_0x02cf:
            r2 = r1;
            goto L_0x0277;
        L_0x02d1:
            r2 = r1;
            goto L_0x00c4;
        L_0x02d4:
            r0 = r1;
            goto L_0x00ac;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.HomeUI.54.run():void");
        }

        public final String toString() {
            return super.toString() + "|setTagRunnable";
        }
    };
    public long uQn = 0;
    public View uQo;
    ImageView uQp;
    View uQq;
    MenuItem uQr;
    MenuItem uQs;
    b uQt = new b(this);
    public VoiceSearchLayout uQu;
    com.tencent.mm.sdk.b.c uQv = new com.tencent.mm.sdk.b.c<cg>(this) {
        final /* synthetic */ HomeUI uRb;

        {
            this.uRb = r2;
            this.usg = cg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (this.uRb.uQo != null) {
                this.uRb.uQo.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 uRc;

                    {
                        this.uRc = r1;
                    }

                    public final void run() {
                        this.uRc.uRb.kk(true);
                    }

                    public final String toString() {
                        return super.toString() + "|updatePlusMenuNewTips";
                    }
                });
            }
            this.uRb.bPn();
            return false;
        }
    };
    com.tencent.mm.q.a.a uQw = new com.tencent.mm.q.a.a(this) {
        final /* synthetic */ HomeUI uRb;

        {
            this.uRb = r1;
        }

        public final void eE(int i) {
            if (i == 262145 || i == 262156 || i == 262152 || i == 266260 || i == 266267) {
                this.uRb.bPq();
            }
            if (i == 262147 || i == 262149) {
                this.uRb.bPq();
            }
        }

        public final void eF(int i) {
            if (i == 266241) {
                this.uRb.bPq();
            }
            if (i == 266244) {
                com.tencent.mm.q.c.uk().aE(262147, 266241);
                com.tencent.mm.q.c.uk().aE(262149, 266241);
                this.uRb.bPq();
            }
        }

        public final void a(com.tencent.mm.storage.w.a aVar) {
        }
    };
    com.tencent.mm.sdk.e.m.b uQx = new com.tencent.mm.sdk.e.m.b(this) {
        final /* synthetic */ HomeUI uRb;

        {
            this.uRb = r1;
        }

        public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
            int n = bg.n(obj, 0);
            w.d("MicroMsg.LauncherUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(n), mVar);
            ap.yY();
            if (mVar != com.tencent.mm.u.c.vr() || n <= 0) {
                w.e("MicroMsg.LauncherUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(n), mVar);
                return;
            }
            this.uRb.bPn();
            if (n == 143618) {
                this.uRb.bPC();
            } else if (n == 204817 || n == 204820) {
                this.uRb.bPq();
            }
        }
    };
    com.tencent.mm.sdk.b.c uQy = new com.tencent.mm.sdk.b.c<qw>(this) {
        final /* synthetic */ HomeUI uRb;

        {
            this.uRb = r2;
            this.usg = qw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            w.v("MicroMsg.LauncherUI", "appTagUnreadChangeListener, event:%s", ((qw) bVar).toString());
            this.uRb.bPn();
            return false;
        }
    };
    public String uQz;
    public HashMap<Integer, q> uRa = new HashMap();
    final HashMap<String, Object> values = new HashMap();

    class AnonymousClass35 implements OnClickListener {
        final /* synthetic */ int izu;
        final /* synthetic */ HomeUI uRb;

        AnonymousClass35(HomeUI homeUI, int i) {
            this.uRb = homeUI;
            this.izu = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                am.startSettingItent(this.uRb.uQk, this.izu);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.LauncherUI", e, "", new Object[0]);
            }
        }
    }

    class AnonymousClass53 implements Runnable {
        final /* synthetic */ HomeUI uRb;
        final /* synthetic */ boolean uRq;

        AnonymousClass53(HomeUI homeUI, boolean z) {
            this.uRb = homeUI;
            this.uRq = z;
        }

        public final void run() {
            if (this.uRq) {
                com.tencent.mm.modelstat.d.a(4, "En_5b8fbb1e" + this.uRb.uQM.bVk(), this.uRb.uQM.hashCode());
                com.tencent.mm.modelstat.d.d("En_5b8fbb1e" + this.uRb.uQM.bVk(), this.uRb.uQn, bg.Ny());
                return;
            }
            this.uRb.dS(4, this.uRb.lCS);
        }
    }

    public static class FitSystemWindowLayoutView extends FrameLayout {
        private Rect fv = new Rect();
        public int uRx;
        public ViewGroup uRy = null;

        public FitSystemWindowLayoutView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public FitSystemWindowLayoutView(Context context) {
            super(context);
        }

        @TargetApi(14)
        public boolean fitSystemWindows(Rect rect) {
            View childAt;
            boolean fitSystemWindows;
            w.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d", rect.toString(), Integer.valueOf(this.uRx), Integer.valueOf(hashCode()));
            this.uRx = rect.top;
            if (this.uRy != null && (this.uRy.getLayoutParams() instanceof MarginLayoutParams)) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.uRy.getLayoutParams();
                int i = marginLayoutParams.bottomMargin;
                int i2 = marginLayoutParams.rightMargin;
                w.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", Integer.valueOf(i), Integer.valueOf(i2));
                int i3 = 0;
                while (i3 < getChildCount()) {
                    childAt = getChildAt(i3);
                    if (childAt instanceof TestTimeForChatting) {
                        TestTimeForChatting testTimeForChatting = (TestTimeForChatting) childAt;
                        if (Float.compare((float) i, ((float) com.tencent.mm.bg.a.fromDPToPix(testTimeForChatting.getContext(), 48)) * DownloadHelper.SAVE_FATOR) > 0 || i < 0) {
                            w.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", Integer.valueOf(i));
                            testTimeForChatting.woS = 0;
                        } else {
                            testTimeForChatting.woS = i;
                        }
                        if (Float.compare((float) i2, ((float) com.tencent.mm.bg.a.fromDPToPix(testTimeForChatting.getContext(), 48)) * DownloadHelper.SAVE_FATOR) > 0 || i2 < 0) {
                            w.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", Integer.valueOf(i));
                            testTimeForChatting.woT = 0;
                        } else {
                            testTimeForChatting.woT = i2;
                        }
                        w.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", Integer.valueOf(i), Integer.valueOf(i2));
                        x.t(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    } else {
                        i3++;
                    }
                }
                x.t(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            this.fv.set(rect);
            if (com.tencent.mm.compatible.util.d.eo(14)) {
                for (int i4 = 0; i4 < getChildCount(); i4++) {
                    childAt = getChildAt(i4);
                    if (childAt instanceof TestTimeForChatting) {
                        childAt.setFitsSystemWindows(true);
                        fitSystemWindows = ((TestTimeForChatting) childAt).fitSystemWindows(rect);
                        childAt.setFitsSystemWindows(false);
                        break;
                    }
                }
            }
            fitSystemWindows = false;
            w.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", Boolean.valueOf(fitSystemWindows), Integer.valueOf(VERSION.SDK_INT));
            w.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", Boolean.valueOf(super.fitSystemWindows(this.fv)));
            return super.fitSystemWindows(this.fv);
        }
    }

    private enum a {
        ACTIVITY_CREATE,
        ACTIVITY_RESUME,
        ACTIVITY_PAUSE
    }

    private class b implements Runnable {
        int aMA;
        int fFR;
        Intent fFS;
        final /* synthetic */ HomeUI uRb;
        int uRz = 0;

        public b(HomeUI homeUI) {
            this.uRb = homeUI;
        }

        public final void run() {
            if (ap.zb() && this.uRb.uPY) {
                w.i("MicroMsg.LauncherUI", "on post select image job, acc has ready, retry count %d", Integer.valueOf(this.uRz));
                this.uRb.a(this.uRb.uQz, null, false);
                af.v(new Runnable(this) {
                    final /* synthetic */ b uRA;

                    {
                        this.uRA = r1;
                    }

                    public final void run() {
                        boolean z = true;
                        String str = "MicroMsg.LauncherUI";
                        String str2 = "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B";
                        Object[] objArr = new Object[1];
                        if (this.uRA.uRb.uQM != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        w.d(str, str2, objArr);
                        if (this.uRA.uRb.uQM != null) {
                            w.d("MicroMsg.LauncherUI", "on select image ActivityResult. do post activity result");
                            this.uRA.uRb.uQM.onActivityResult(this.uRA.fFR & 65535, this.uRA.aMA, this.uRA.fFS);
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|PostSelectImageJob_onActivityResult";
                    }
                });
            } else if (this.uRz >= 3) {
                w.w("MicroMsg.LauncherUI", "on post select image job, match max retry count");
            } else {
                w.w("MicroMsg.LauncherUI", "on post select image job, acc not ready or view init(%B), cur retry count %d", Boolean.valueOf(this.uRb.uPY), Integer.valueOf(this.uRz));
                this.uRz++;
                af.f(this, 300);
            }
        }

        public final String toString() {
            return super.toString() + "|PostSelectImageJob";
        }
    }

    public class c extends android.support.v4.app.o implements ViewPager.e, com.tencent.mm.ui.c.a {
        private int qhP = 0;
        private com.tencent.mm.ui.contact.AddressUI.a uRB;
        private final WxViewPager uRC;
        private boolean uRD = false;
        final /* synthetic */ HomeUI uRb;

        public c(HomeUI homeUI, FragmentActivity fragmentActivity, WxViewPager wxViewPager) {
            this.uRb = homeUI;
            super(fragmentActivity.aR());
            this.uRC = wxViewPager;
            this.uRC.a((android.support.v4.view.u) this);
            this.uRC.b((ViewPager.e) this);
        }

        public final int getCount() {
            return 4;
        }

        public final Fragment I(int i) {
            return this.uRb.zc(i);
        }

        public final void a(final int i, float f, int i2) {
            if (this.uRb.uQb != null) {
                this.uRb.uQb.i(i, f);
            }
            if (0.0f != f) {
                if (this.uRB == null) {
                    this.uRB = (com.tencent.mm.ui.contact.AddressUI.a) this.uRb.zc(1);
                }
                this.uRB.lv(false);
                return;
            }
            w.v("MicroMsg.LauncherUI", "onPageScrolled, position = %d, mLastIndex = %d", Integer.valueOf(i), Integer.valueOf(this.uRb.lPr));
            if (-1 == this.uRb.lPr) {
                this.uRb.dR(this.uRb.lPr, this.uRb.lCS);
                this.uRb.za(i);
                return;
            }
            af.v(new Runnable(this) {
                final /* synthetic */ c uRE;

                public final void run() {
                    this.uRE.uRb.dR(this.uRE.uRb.lPr, this.uRE.uRb.lCS);
                    this.uRE.uRb.za(i);
                }
            });
        }

        public final void V(int i) {
            w.d("MicroMsg.LauncherUI", "on page selected changed to %d", Integer.valueOf(i));
            w.v("MicroMsg.LauncherUI", "reportSwitch clickCount:%d, pos:%d", Integer.valueOf(this.qhP), Integer.valueOf(i));
            if (this.qhP <= 0) {
                switch (i) {
                    case 0:
                        g.oUh.A(10957, "5");
                        break;
                    case 1:
                        g.oUh.A(10957, "6");
                        break;
                    case 2:
                        g.oUh.A(10957, "7");
                        break;
                    default:
                        break;
                }
            }
            this.qhP--;
            switch (i) {
                case 0:
                    g.oUh.A(10957, "1");
                    break;
                case 1:
                    g.oUh.A(10957, "2");
                    break;
                case 2:
                    g.oUh.A(10957, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                    break;
                case 3:
                    g.oUh.A(10957, "4");
                    break;
            }
            this.uRD = false;
            this.uRb.dR(this.uRb.lPr, this.uRb.lCS);
            this.uRb.lPr = this.uRb.lCS;
            this.uRb.lCS = i;
            if (this.uRb.uQb != null) {
                this.uRb.uQb.lJ(i);
            }
            this.uRb.uQk.aQ();
            if (this.uRb.lPr == 1 && this.uRb.lCS != 1) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(340226, Long.valueOf(System.currentTimeMillis()));
            }
            if (this.uRb.lCS == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                ap.yY();
                if (currentTimeMillis - bg.a((Long) com.tencent.mm.u.c.vr().get(340226, null), 0) >= 180000) {
                    ((com.tencent.mm.ui.contact.AddressUI.a) this.uRb.zc(this.uRb.lCS)).bXM();
                }
            }
            if (this.uRb.lCS == 0) {
                ap.getNotification().aw(true);
            } else {
                ap.getNotification().aw(false);
            }
        }

        public final void W(int i) {
            w.d("MicroMsg.LauncherUI", "onPageScrollStateChanged state %d", Integer.valueOf(i));
            if (i == 0 && this.uRB != null) {
                this.uRB.lv(true);
                this.uRB = null;
            }
        }

        public final void lK(int i) {
            if (i == this.uRb.lCS) {
                w.d("MicroMsg.LauncherUI", "on click same index");
                q zc = this.uRb.zc(i);
                if (zc instanceof com.tencent.mm.ui.AbstractTabChildActivity.a) {
                    ((com.tencent.mm.ui.AbstractTabChildActivity.a) zc).bOr();
                    return;
                }
                return;
            }
            this.uRD = true;
            this.qhP++;
            w.v("MicroMsg.LauncherUI", "onTabClick count:%d", Integer.valueOf(this.qhP));
            this.uRC.k(i, false);
            if (i == 3) {
                com.tencent.mm.q.c.uk().aE(262145, 266241);
                com.tencent.mm.q.c.uk().aE(262156, 266241);
                com.tencent.mm.q.c.uk().aE(262147, 266241);
                com.tencent.mm.q.c.uk().aE(262149, 266241);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        uQZ = hashMap;
        hashMap.put("tab_main", Integer.valueOf(0));
        uQZ.put("tab_address", Integer.valueOf(1));
        uQZ.put("tab_find_friend", Integer.valueOf(2));
        uQZ.put("tab_settings", Integer.valueOf(3));
    }

    public final void bPl() {
        boolean z;
        long Nz = bg.Nz();
        com.tencent.mm.sdk.a.b.aX(true);
        if (this.uQM == null) {
            z = false;
        } else {
            z = this.uQM.hML;
        }
        w.i("MicroMsg.LauncherUI", "onResume, chatting is show %B, accountHasReady %B", Boolean.valueOf(z), Boolean.valueOf(ap.zb()));
        if (!z && ap.zb()) {
            com.tencent.mm.plugin.sight.decode.a.b.wl();
        }
        w.i("MicroMsg.LauncherUI", "onResume start :%d", Integer.valueOf(this.lCS));
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ HomeUI uRb;

            public final void run() {
                if (z) {
                    com.tencent.mm.modelstat.d.a(3, "En_5b8fbb1e" + this.uRb.uQM.bVk(), hashCode());
                    this.uRb.uQn = bg.Ny();
                    return;
                }
                this.uRb.dS(3, this.uRb.lCS);
            }
        }, "directReport_onResume");
        if (z) {
            this.uQn = bg.Ny();
        }
        j.b(this.uQk);
        this.uQk.O(1.0f);
        this.uQj = a.ACTIVITY_RESUME;
        if (this.uRa.size() != 0) {
            ((i) ((q) this.uRa.get(Integer.valueOf(this.lCS)))).bOv();
        }
        if (!((this.uQM != null && this.uQM.hML) || com.tencent.mm.pluginsdk.l.a.sBx == null || com.tencent.mm.pluginsdk.l.a.sBy == null || bg.mA(com.tencent.mm.pluginsdk.l.a.sBy.aGv()))) {
            w.i("MicroMsg.LauncherUI", "launcher onResume end track %s", com.tencent.mm.pluginsdk.l.a.sBx.aGl());
            com.tencent.mm.sdk.b.b elVar = new el();
            elVar.fIn.username = com.tencent.mm.pluginsdk.l.a.sBx.aGl();
            com.tencent.mm.sdk.b.a.urY.m(elVar);
        }
        if (this.uQa) {
            this.uQa = false;
            bPD();
        }
        com.tencent.mm.x.m.Bw();
        String A = ao.hlW.A("login_user_name", "");
        if ((ap.za() || !A.equals("")) && !ap.zb()) {
            com.tencent.mm.kernel.h.vG().initialize();
        }
        long currentTimeMillis = System.currentTimeMillis();
        w.w("MicroMsg.LauncherUI", "[Launching Application]");
        k.e(this.uQk, false);
        k.f(this.uQk, false);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.uPW) {
            this.uPW = false;
            SD("tab_main");
        }
        if (this.uQk.getSharedPreferences(ab.bIX(), 0).getBoolean("settings_landscape_mode", false)) {
            this.uQk.setRequestedOrientation(-1);
        } else {
            this.uQk.setRequestedOrientation(1);
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        if (LauncherUI.bPI() != null) {
            ap.yY();
            com.tencent.mm.u.c.wW().a(this);
            ap.yY();
            com.tencent.mm.u.c.vr().a(this.uQx);
            com.tencent.mm.q.c.uk().a(this.uQw);
            com.tencent.mm.sdk.b.a.urY.b(this.uQE);
            com.tencent.mm.sdk.b.a.urY.b(this.uQy);
            com.tencent.mm.sdk.b.a.urY.b(this.uPy);
            com.tencent.mm.sdk.b.a.urY.b(this.uQH);
            com.tencent.mm.sdk.b.a.urY.b(this.uQG);
            bPu();
            bPC();
            bPm();
            bPq();
            kk(false);
            com.tencent.mm.sdk.b.a.urY.b(this.uQv);
            if (this.uQk.getIntent() != null) {
                String i = s.i(this.uQk.getIntent(), "LauncherUI.Show.Update.DialogMsg");
                if (!bg.mA(i)) {
                    this.uQk.getIntent().putExtra("LauncherUI.Show.Update.DialogMsg", "");
                    kl(false);
                    SD("tab_main");
                    g.oUh.a(405, 33, 1, true);
                    com.tencent.mm.ui.base.g.a(this.uQk, i, getString(R.l.fcW), getString(R.l.fcX), getString(R.l.fcV), false, new OnClickListener(this) {
                        final /* synthetic */ HomeUI uRb;

                        {
                            this.uRb = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            g.oUh.i(11584, Integer.valueOf(1));
                            g.oUh.a(405, 34, 1, true);
                            String i2 = s.i(this.uRb.uQk.getIntent(), "LauncherUI.Show.Update.Url");
                            if (bg.mA(i2)) {
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.tencent.mm"));
                                intent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity");
                                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                try {
                                    this.uRb.uQk.startActivity(intent);
                                    return;
                                } catch (Exception e) {
                                    intent = new Intent();
                                    String ea = v.ea(this.uRb.uQk);
                                    if (bg.mA(ea)) {
                                        intent.putExtra("rawUrl", "http://www.wechat.com/en/");
                                    } else if (ea.equals("zh_TW") || ea.equals("zh_HK")) {
                                        intent.putExtra("rawUrl", "http://www.wechat.com/");
                                    } else if (ea.equals("ja")) {
                                        intent.putExtra("rawUrl", "http://www.wechat.com/ja/");
                                    } else if (ea.equals("ko")) {
                                        intent.putExtra("rawUrl", "http://www.wechat.com/ko/");
                                    } else {
                                        intent.putExtra("rawUrl", "http://www.wechat.com/en/");
                                    }
                                    intent.putExtra("showShare", false);
                                    intent.putExtra("show_bottom", false);
                                    intent.putExtra("needRedirect", false);
                                    intent.putExtra("neverGetA8Key", true);
                                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                                    com.tencent.mm.bb.d.b(this.uRb.uQk, "webview", ".ui.tools.WebViewUI", intent);
                                    return;
                                }
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("rawUrl", i2);
                            intent2.putExtra("showShare", false);
                            intent2.putExtra("show_bottom", false);
                            intent2.putExtra("needRedirect", false);
                            intent2.putExtra("neverGetA8Key", true);
                            intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                            intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                            com.tencent.mm.bb.d.b(this.uRb.uQk, "webview", ".ui.tools.WebViewUI", intent2);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ HomeUI uRb;

                        {
                            this.uRb = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            g.oUh.i(11584, Integer.valueOf(2));
                            g.oUh.a(405, 35, 1, true);
                        }
                    });
                }
            } else {
                w.w("MicroMsg.LauncherUI", "dz[getIntent is null!]");
            }
            elVar = new aw();
            com.tencent.mm.sdk.b.a.urY.m(elVar);
            if (elVar.fEp.fEq && !bg.mA(elVar.fEp.fEr)) {
                w.d("MicroMsg.LauncherUI", "  now show msg:%s", elVar.fEp.fEr);
                com.tencent.mm.ui.base.g.b(this.uQk, elVar.fEp.fEr, elVar.fEp.title, true);
            }
            if (this.uQF != null) {
                com.tencent.mm.bb.d.b(this.uQk, "sandbox", ".updater.AppUpdaterUI", this.uQF.intent);
            }
            this.uQF = null;
            if (!a(this.uQD)) {
                ap.vL().e(new Runnable(this) {
                    final /* synthetic */ HomeUI uRb;

                    {
                        this.uRb = r1;
                    }

                    public final void run() {
                        Object obj = null;
                        SharedPreferences bIY = ab.bIY();
                        if (com.tencent.mm.compatible.util.f.sa()) {
                            long j = bIY.getLong("show_sdcard_full_time", 0);
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - j > 1800000 || j > currentTimeMillis) {
                                w.i("MicroMsg.LauncherUI", "summer show sd full tip");
                                bIY.edit().putLong("show_sdcard_full_time", currentTimeMillis).commit();
                                com.tencent.mm.ui.base.g.a(this.uRb.uQk, this.uRb.getString(R.l.ePw), this.uRb.getString(R.l.ePx), this.uRb.getString(R.l.dGu), this.uRb.getString(R.l.dHx), new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass20 uRj;

                                    {
                                        this.uRj = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        ap.yY();
                                        if (com.tencent.mm.u.c.isSDCardAvailable()) {
                                            Intent intent = new Intent();
                                            intent.putExtra("had_detected_no_sdcard_space", true);
                                            com.tencent.mm.bb.d.b(this.uRj.uRb.uQk, "clean", ".ui.CleanUI", intent);
                                        } else {
                                            com.tencent.mm.ui.base.s.eP(this.uRj.uRb.uQk);
                                        }
                                        dialogInterface.dismiss();
                                        g.oUh.a(282, 1, 1, false);
                                    }
                                }, null);
                                g.oUh.a(282, 0, 1, false);
                                obj = 1;
                            }
                        }
                        if (obj == null) {
                            ap.yY();
                            if (((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                                ap.yY();
                                if (bg.mA((String) com.tencent.mm.u.c.vr().get(6, (Object) ""))) {
                                    ap.yY();
                                    boolean booleanValue = ((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_FORCE_BIND_BOOLEAN, Boolean.valueOf(false))).booleanValue();
                                    ap.yY();
                                    com.tencent.mm.storage.t vr = com.tencent.mm.u.c.vr();
                                    com.tencent.mm.storage.w.a aVar = com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_WORDING_STRING;
                                    HomeUI homeUI = this.uRb;
                                    String string = this.uRb.getString(R.l.dNM);
                                    Object obj2 = homeUI.values.get(string);
                                    if (obj2 instanceof String) {
                                        w.d("MicroMsg.LauncherUI", "getString(): key=" + string + ", value=" + obj2.toString());
                                        obj2 = (String) obj2;
                                    } else {
                                        obj2 = null;
                                    }
                                    final String str = (String) vr.get(aVar, obj2);
                                    w.i("MicroMsg.LauncherUI", "summerbindmobile tip[%b], bindMobile[%s], force[%b], wording[%s]", Boolean.valueOf(r2), r0, Boolean.valueOf(booleanValue), str);
                                    if (booleanValue) {
                                        com.tencent.mm.ui.base.g.a(this.uRb.uQk, str, this.uRb.getString(R.l.dIO), this.uRb.getString(R.l.dHT), false, new OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass20 uRj;

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent();
                                                intent.setClassName(this.uRj.uRb.uQk, "com.tencent.mm.ui.account.bind.BindMobileUI");
                                                intent.putExtra("kstyle_bind_wording", new BindWordingContent(str, ""));
                                                MMWizardActivity.z(this.uRj.uRb.uQk, intent);
                                                dialogInterface.dismiss();
                                            }
                                        });
                                    } else {
                                        com.tencent.mm.ui.base.g.a(this.uRb.uQk, str, this.uRb.getString(R.l.dIO), this.uRb.getString(R.l.dHT), this.uRb.getString(R.l.dGs), new OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass20 uRj;

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent();
                                                intent.setClassName(this.uRj.uRb.uQk, "com.tencent.mm.ui.account.bind.BindMobileUI");
                                                intent.putExtra("kstyle_bind_wording", new BindWordingContent(str, ""));
                                                MMWizardActivity.z(this.uRj.uRb.uQk, intent);
                                                dialogInterface.dismiss();
                                            }
                                        }, new OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass20 uRj;

                                            {
                                                this.uRj = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                            }
                                        });
                                    }
                                } else {
                                    w.i("MicroMsg.LauncherUI", "summerbindmobile has bind[%s]", (String) com.tencent.mm.u.c.vr().get(6, (Object) ""));
                                }
                                ap.yY();
                                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.valueOf(false));
                                ap.yY();
                                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_WORDING_STRING, (Object) "");
                                ap.yY();
                                com.tencent.mm.u.c.vr().jY(true);
                            }
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|doOnResumeCheck";
                    }
                }, 500);
            }
            this.uQD = null;
            if (bPF()) {
                Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                    final /* synthetic */ HomeUI uRb;

                    {
                        this.uRb = r1;
                    }

                    public final boolean queueIdle() {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (this.uRb.uQN == null) {
                            if (this.uRb.uQK == null) {
                                this.uRb.uQK = r.eC(this.uRb.uQk).inflate(R.i.cXo, null);
                            }
                            if (this.uRb.uQL == null) {
                                this.uRb.uQL = r.eC(this.uRb.uQk).inflate(R.i.cTB, null);
                            }
                        }
                        w.i("MicroMsg.LauncherUI", "prepare chattingUI view use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return false;
                    }
                });
                this.uQA = new IdleHandler(this) {
                    final /* synthetic */ HomeUI uRb;

                    {
                        this.uRb = r1;
                    }

                    @TargetApi(17)
                    public final boolean queueIdle() {
                        try {
                            if (this.uRb.uQk.isFinishing() || (VERSION.SDK_INT >= 17 && this.uRb.uQk.isDestroyed())) {
                                boolean isDestroyed;
                                this.uRb.uQK = null;
                                this.uRb.uQL = null;
                                String str = "MicroMsg.LauncherUI";
                                String str2 = "prepare chattingUI but activity finished just ret sdk[%d] isDestroyed[%b]";
                                Object[] objArr = new Object[2];
                                objArr[0] = Integer.valueOf(VERSION.SDK_INT);
                                if (VERSION.SDK_INT >= 17) {
                                    isDestroyed = this.uRb.uQk.isDestroyed();
                                } else {
                                    isDestroyed = this.uRb.uQk.isFinishing();
                                }
                                objArr[1] = Boolean.valueOf(isDestroyed);
                                w.i(str, str2, objArr);
                                return false;
                            }
                            w.i("MicroMsg.LauncherUI", "prepare chattingUI logic start");
                            long currentTimeMillis = System.currentTimeMillis();
                            if (this.uRb.uQN == null) {
                                this.uRb.af(new Intent().putExtra("Chat_User", com.tencent.mm.u.m.xL()));
                                this.uRb.uQM.nhl = true;
                                this.uRb.uQM.bVe();
                                this.uRb.uQN.setVisibility(8);
                                this.uRb.uQM.uUC = true;
                                this.uRb.uQM.onPause();
                                this.uRb.uQM.bVb();
                                this.uRb.uQM.hML = false;
                                this.uRb.bPu();
                                x.a(true, new Intent().putExtra("classname", LauncherUI.class.getName()));
                            }
                            this.uRb.uQK = null;
                            this.uRb.uQL = null;
                            w.i("MicroMsg.LauncherUI", "prepare chattingUI logic use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            return false;
                        } catch (final Throwable e) {
                            w.printErrStackTrace("MicroMsg.LauncherUI", e, "", new Object[0]);
                            new Handler().post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass9 uRe;

                                public final void run() {
                                    throw new RuntimeException(e);
                                }
                            });
                        }
                    }
                };
                Looper.myQueue().addIdleHandler(this.uQA);
            }
            if (this.lCS == 0) {
                ap.getNotification().aw(true);
            } else {
                ap.getNotification().aw(false);
            }
            w.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - currentTimeMillis3));
        }
        i iVar = (i) zc(this.lCS);
        if (iVar != null) {
            iVar.bOw();
        }
        w.v("MicroMsg.LauncherUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - currentTimeMillis2));
        com.tencent.mm.x.b.a(com.tencent.mm.u.m.xL(), false, -1);
        this.uPW = false;
        w.d("MicroMsg.LauncherUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - currentTimeMillis));
        int a = s.a(this.uQk.getIntent(), "preferred_tab", 0);
        w.d("MicroMsg.LauncherUI", "KEVIN onNewIntent, tabIdx = %d", Integer.valueOf(a));
        if (a != 0) {
            zb(a);
            this.uQk.getIntent().putExtra("preferred_tab", 0);
        }
        w.i("MicroMsg.LauncherUI", "initView " + (System.currentTimeMillis() - Nz));
        if (this.uQa) {
            this.uQa = false;
            bPD();
        }
        com.tencent.mm.app.l os = com.tencent.mm.app.l.os();
        os.fwS = true;
        os.fwT.removeMessages(-1999);
        os.fwT.removeMessages(-2999);
        w.i("MicroMsg.LauncherUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - Nz));
        if (this.uQb != null) {
            this.uQb.bOy();
        }
        if (this.uQM != null && this.uQM.bQi()) {
            this.uQM.uUD.mEnable = true;
        }
        if (com.tencent.mm.u.m.yt().booleanValue()) {
            bPo();
        }
        a = com.tencent.mm.bg.a.dJ(ab.getContext());
        long currentTimeMillis4 = System.currentTimeMillis();
        if (currentTimeMillis4 - ab.getContext().getSharedPreferences(ab.bIX() + "_font_size_report_time", 4).getLong("font_size_report_time", 0) > 604800000) {
            g.oUh.i(14239, Integer.valueOf(a));
            ab.getContext().getSharedPreferences(ab.bIX() + "_font_size_report_time", 4).edit().putLong("font_size_report_time", currentTimeMillis4).commit();
            w.i("MicroMsg.LauncherUI", "using font size kvReport logID:%d , usingFontSize: %d", Integer.valueOf(14239), Integer.valueOf(a));
        }
    }

    public final void ajj() {
        String string = getString(R.l.bpJ);
        if (d.sYQ) {
            if (this.uQl) {
                string = string + getString(R.l.dDc);
            } else {
                string = string + " " + getString(R.l.dDc);
            }
        }
        if (this.uQb == null || this.uQb.bOz() <= 0) {
            Object obj = string;
        } else {
            if (!this.uQl) {
                string = string + " ";
            }
            CharSequence charSequence = string + "(" + this.uQb.bOz() + ")";
        }
        TextView textView = (TextView) this.Gx.getCustomView().findViewById(16908308);
        if (textView != null) {
            textView.setText(charSequence);
            textView.setTextSize(0, ((float) com.tencent.mm.bg.a.U(ab.getContext(), R.f.aWy)) * com.tencent.mm.bg.a.dK(ab.getContext()));
        }
    }

    protected final void bPm() {
        this.uPT = true;
        af.I(this.uQm);
        af.v(this.uQm);
    }

    protected final void bPn() {
        this.uPT = true;
        af.I(this.uQm);
        af.f(this.uQm, 300);
    }

    private void bPo() {
        if (ap.zb()) {
            ap.yY();
            Boolean valueOf = Boolean.valueOf(bg.f((Boolean) com.tencent.mm.u.c.vr().get(340227, null)));
            if (!(valueOf.booleanValue() || com.tencent.mm.ui.contact.k.vXG.booleanValue())) {
                uQf = Boolean.valueOf(true);
                kj(true);
            }
            long currentTimeMillis = System.currentTimeMillis();
            ap.yY();
            currentTimeMillis -= bg.a((Long) com.tencent.mm.u.c.vr().get(340240, null), 0);
            ap.yY();
            Boolean valueOf2 = Boolean.valueOf(bg.f((Boolean) com.tencent.mm.u.c.vr().get(340230, null)));
            ap.yY();
            Boolean valueOf3 = Boolean.valueOf(bg.f((Boolean) com.tencent.mm.u.c.vr().get(340228, null)));
            ap.yY();
            Boolean valueOf4 = Boolean.valueOf(bg.f((Boolean) com.tencent.mm.u.c.vr().get(340229, null)));
            if (valueOf.booleanValue() && valueOf3.booleanValue() && valueOf4.booleanValue() && !valueOf2.booleanValue() && currentTimeMillis >= 432000000) {
                uQg = Boolean.valueOf(true);
                kj(false);
                return;
            }
            return;
        }
        w.e("MicroMsg.LauncherUI", "mmcore has not ready");
    }

    private void kj(final boolean z) {
        if (this.qOv != null) {
            w.e("MicroMsg.LauncherUI", "tipsView already shown");
            return;
        }
        this.qOv = View.inflate(ab.getContext(), R.i.dkk, null);
        TextView textView = (TextView) this.qOv.findViewById(R.h.cnT);
        if (z) {
            textView.setText(ab.getContext().getString(R.l.dBS));
        } else {
            textView.setText(ab.getContext().getString(R.l.dBR));
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 53);
        this.qOv.setBackgroundResource(R.g.bic);
        if (this.ipu != null) {
            ((ViewGroup) this.ipu).addView(this.qOv, layoutParams);
            this.qOv.startAnimation(AnimationUtils.loadAnimation(ab.getContext(), R.a.aRI));
            this.qOv.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ HomeUI uRb;

                public final void onClick(View view) {
                    this.uRb.uQe.dL();
                    if (z) {
                        this.uRb.c(Boolean.valueOf(true), Boolean.valueOf(true));
                    } else {
                        this.uRb.c(Boolean.valueOf(true), Boolean.valueOf(false));
                    }
                }
            });
        }
    }

    public final void c(Boolean bool, Boolean bool2) {
        if (this.qOv != null) {
            this.qOv.clearAnimation();
            this.qOv.setVisibility(8);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(340227, Boolean.valueOf(true));
                    g.oUh.a(232, 0, 1, false);
                    uQf = Boolean.valueOf(false);
                } else {
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(340230, Boolean.valueOf(true));
                    g.oUh.a(232, 5, 1, false);
                    uQg = Boolean.valueOf(false);
                }
            }
            this.qOv = null;
        }
    }

    public final void bPp() {
        if (this.uQe != null && ap.zb()) {
            if (this.uQe.isShowing()) {
                this.uQe.dismiss();
            } else {
                this.uQe.dL();
            }
        }
    }

    public final void bPq() {
        if (ap.zb()) {
            int parseInt;
            boolean aC = com.tencent.mm.q.c.uk().aC(262156, 266241);
            boolean aD = com.tencent.mm.q.c.uk().aD(262156, 266241);
            w.i("MicroMsg.LauncherUI", "hasMallNew: %s, hasMallDot: %s", Boolean.valueOf(aC), Boolean.valueOf(aD));
            if (aC || aD) {
                ap.yY();
                long longValue = ((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(-1))).longValue();
                long j = bg.getLong(com.tencent.mm.i.g.sV().getValue("PayWalletRedDotExpire"), -1);
                long j2 = 86400000 * j;
                w.i("MicroMsg.LauncherUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", Long.valueOf(longValue), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(System.currentTimeMillis()), Double.valueOf((((double) System.currentTimeMillis()) - ((double) longValue)) / 8.64E7d));
                if (longValue > 0 && j > 0 && r14 >= ((double) j)) {
                    com.tencent.mm.q.c.uk().s(262156, false);
                    aC = false;
                    aD = false;
                }
            }
            w.i("MicroMsg.LauncherUI", "after check, hasMallNew: %s, hasMallDot: %s", Boolean.valueOf(aC), Boolean.valueOf(aD));
            boolean aC2 = com.tencent.mm.q.c.uk().aC(262145, 266241);
            boolean aD2 = com.tencent.mm.q.c.uk().aD(266260, 266241);
            boolean aC3 = com.tencent.mm.q.c.uk().aC(262147, 266241);
            boolean aC4 = com.tencent.mm.q.c.uk().aC(262149, 266241);
            boolean aD3 = com.tencent.mm.q.c.uk().aD(262152, 266256);
            boolean aC5 = com.tencent.mm.q.c.uk().aC(262152, 266256);
            com.tencent.mm.plugin.welab.a.a.c cVar = (com.tencent.mm.plugin.welab.a.a.c) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.c.class);
            Object obj = cVar != null ? (cVar.bAK() || cVar.bAL()) ? 1 : null : null;
            com.tencent.mm.q.a uk = com.tencent.mm.q.c.uk();
            if (uk.gUO) {
                com.tencent.mm.q.b.a p = uk.gUM.p(262152, 266256, 4);
                parseInt = p == null ? 0 : com.tencent.mm.q.a.parseInt(p.value);
            } else {
                w.w("MicroMsg.NewBadge", "hasUnreadNum NewBadge has not initialized");
                parseInt = 0;
            }
            com.tencent.mm.pluginsdk.l.c cVar2 = com.tencent.mm.pluginsdk.l.a.sBv;
            Object obj2 = (cVar2 == null || !(cVar2.afJ() || cVar2.afK())) ? null : 1;
            Object obj3 = (obj2 == null || !(aD3 || aC5 || parseInt > 0)) ? null : 1;
            if (aD || aC || aC2 || obj3 != null || aC3 || aC4 || aD2 || r2 != null) {
                this.uQb.kf(true);
                return;
            } else {
                this.uQb.kf(false);
                return;
            }
        }
        w.w("MicroMsg.LauncherUI", "want update more menu new tips, but mmcore not ready");
    }

    public final void kk(boolean z) {
        if (this.uQe != null && this.uQo != null) {
            if (ap.zb()) {
                int i;
                this.uQe.uVR.kA(z);
                if (this.uQe.uVR.uVK > 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    this.uQq.setVisibility(0);
                    return;
                } else {
                    this.uQq.setVisibility(8);
                    return;
                }
            }
            w.w("MicroMsg.LauncherUI", "want update more menu new tips, but mmcore not ready");
        }
    }

    final void bPr() {
        if (((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).isFTSIndexReady()) {
            com.tencent.mm.bb.d.b(this.uQk, "search", ".ui.FTSMainUI", new Intent().putExtra("from_tab_index", this.lCS).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0));
            int i = this.lCS == 0 ? 1 : this.lCS == 1 ? 2 : this.lCS == 2 ? 3 : this.lCS == 3 ? 4 : 0;
            com.tencent.mm.as.g.gp(i);
            return;
        }
        Toast.makeText(ab.getContext(), R.l.eQc, 0).show();
    }

    public final String getString(int i) {
        return this.uQk.getString(i);
    }

    public static void bPs() {
        if (VERSION.SDK_INT < 18) {
            ab.getContext().startService(new Intent(ab.getContext(), NotifyService.class));
        }
    }

    public final boolean a(com.tencent.mm.e.a.hr.a aVar) {
        if (aVar == null || aVar.fNj == null || aVar.fNj.tbf == null || aVar.fNj.tbf.size() == 0) {
            return false;
        }
        final int i = aVar.fNj.id;
        String str = aVar.fNj.title;
        String str2 = aVar.fNj.fEr;
        int i2 = aVar.type;
        int size = aVar.fNj.tbf.size();
        if (i2 == 0) {
            if (size == 1) {
                final com.tencent.mm.protocal.b.a.a aVar2 = (com.tencent.mm.protocal.b.a.a) aVar.fNj.tbf.get(0);
                w.i("MicroMsg.LauncherUI", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", Integer.valueOf(i), str, str2, Integer.valueOf(aVar2.id), Integer.valueOf(aVar2.actionType), aVar2.tbd, aVar2.tbe);
                com.tencent.mm.ui.base.g.a(this.uQk, str2, str, aVar2.tbd, false, new OnClickListener(this) {
                    final /* synthetic */ HomeUI uRb;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.uRb.d(i, aVar2.actionType, aVar2.id, aVar2.tbe);
                        dialogInterface.dismiss();
                    }
                });
            } else {
                final com.tencent.mm.protocal.b.a.a aVar3 = (com.tencent.mm.protocal.b.a.a) aVar.fNj.tbf.get(1);
                final com.tencent.mm.protocal.b.a.a aVar4 = (com.tencent.mm.protocal.b.a.a) aVar.fNj.tbf.get(0);
                w.i("MicroMsg.LauncherUI", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", str, str2, Integer.valueOf(aVar3.id), Integer.valueOf(aVar3.actionType), aVar3.tbd, aVar3.tbe, Integer.valueOf(aVar4.id), Integer.valueOf(aVar4.actionType), aVar4.tbd, aVar4.tbe);
                com.tencent.mm.ui.base.g.a(this.uQk, str2, str, aVar3.tbd, aVar4.tbd, false, new OnClickListener(this) {
                    final /* synthetic */ HomeUI uRb;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.uRb.d(i, aVar3.actionType, aVar3.id, aVar3.tbe);
                        dialogInterface.dismiss();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ HomeUI uRb;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.uRb.d(i, aVar4.actionType, aVar4.id, aVar4.tbe);
                        dialogInterface.dismiss();
                    }
                });
            }
        } else if (i2 == 1) {
            String str3 = str2;
            String str4 = str;
            boolean z = false;
            com.tencent.mm.ui.base.g.a(this.uQk, str3, str4, ((com.tencent.mm.protocal.b.a.a) aVar.fNj.tbf.get(0)).tbd, ((com.tencent.mm.protocal.b.a.a) aVar.fNj.tbf.get(1)).tbd, z, aVar.fNk, aVar.fNl);
        }
        return true;
    }

    public final void d(int i, int i2, int i3, String str) {
        w.i("MicroMsg.LauncherUI", "summeralert jumpByActionType  alertId[%d], actionType[%d], btnId[%d], url[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        g.oUh.i(13191, Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(false));
        Intent intent;
        switch (i2) {
            case 2:
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                com.tencent.mm.bb.d.b(this.uQk, "webview", ".ui.tools.WebViewUI", intent);
                return;
            case 3:
                if (this.pkn) {
                    gO(true);
                    return;
                }
                bPt();
                ap.vd().a(255, this.uPV);
                final com.tencent.mm.y.k vVar = new com.tencent.mm.modelsimple.v(1);
                ap.vd().a(vVar, 0);
                Context context = this.uQk;
                getString(R.l.dIO);
                this.isv = com.tencent.mm.ui.base.g.a(context, getString(R.l.eSL), true, new OnCancelListener(this) {
                    final /* synthetic */ HomeUI uRb;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(vVar);
                    }
                });
                return;
            case 4:
                Intent intent2 = new Intent();
                intent2.setClass(this.uQk, BindMContactUI.class);
                intent2.putExtra("is_bind_for_change_mobile", true);
                String simCountryIso = ((TelephonyManager) this.uQk.getSystemService("phone")).getSimCountryIso();
                if (!bg.mA(simCountryIso)) {
                    com.tencent.mm.ai.b.a g = com.tencent.mm.ai.b.g(this.uQk, simCountryIso, this.uQk.getString(R.l.bGO));
                    if (g != null) {
                        intent2.putExtra("country_name", g.hJF);
                        intent2.putExtra("couttry_code", g.hJE);
                    }
                }
                MMWizardActivity.z(this.uQk, intent2);
                return;
            case 5:
                intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
                intent.setFlags(65536);
                if (!com.tencent.mm.n.a.aI(this.uQk) && !com.tencent.mm.n.a.aH(this.uQk)) {
                    com.tencent.mm.bb.d.b(this.uQk, "scanner", ".ui.BaseScanUI", intent);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final e bPt() {
        if (this.uPV == null) {
            this.uPV = new e(this) {
                final /* synthetic */ HomeUI uRb;

                {
                    this.uRb = r1;
                }

                public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                    w.i("MicroMsg.LauncherUI", "summeralert onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
                    if (this.uRb.isv != null) {
                        this.uRb.isv.dismiss();
                        this.uRb.isv = null;
                    }
                    if (kVar.getType() == 255) {
                        ap.vd().b(255, this.uRb.uPV);
                        if (i == 0 && i2 == 0) {
                            this.uRb.gO(true);
                        } else if (!com.tencent.mm.ui.p.a.a(this.uRb.uQk, i, i2, str, 4)) {
                            this.uRb.gO(false);
                        }
                    } else if (kVar.getType() != 384) {
                    } else {
                        if (i == 0 && i2 == 0) {
                            ap.yY();
                            com.tencent.mm.u.c.vr().set(77830, ((ai) kVar).Fu());
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", this.uRb.getString(R.l.eSZ));
                            com.tencent.mm.bb.d.b(this.uRb.uQk, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
                            return;
                        }
                        this.uRb.pkn = true;
                        com.tencent.mm.ui.base.g.a(this.uRb.uQk, R.l.eTm, R.l.dIO, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass19 uRi;

                            {
                                this.uRi = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.uRi.uRb.bPG();
                            }
                        });
                    }
                }
            };
        }
        return this.uPV;
    }

    public final void gO(boolean z) {
        w.d("MicroMsg.LauncherUI", "summeralert handlePassword " + z);
        if (z) {
            bPG();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("kintent_hint", getString(R.l.eSZ));
        com.tencent.mm.bb.d.b(this.uQk, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
    }

    public final void bPu() {
        com.tencent.mm.ui.conversation.j jVar = (com.tencent.mm.ui.conversation.j) this.uRa.get(Integer.valueOf(0));
        if (jVar != null) {
            if (jVar.wbL != null) {
                jVar.wbL.bXK();
            }
            jVar.bYM();
        }
    }

    public final void bPv() {
        com.tencent.mm.ui.conversation.j jVar = (com.tencent.mm.ui.conversation.j) this.uRa.get(Integer.valueOf(0));
        if (jVar != null) {
            jVar.bYN();
        }
    }

    public final void dR(int i, int i2) {
        if (i != i2) {
            if (this.uQI != i2 || this.uQJ != i) {
                this.uQI = i2;
                this.uQJ = i;
                zc(i);
                q zc = zc(i2);
                if (zc != null && (zc instanceof i)) {
                    ((i) zc).bPh();
                }
                dS(4, i);
                dS(3, i2);
            }
        }
    }

    public final void za(int i) {
        q zc = zc(i);
        if (zc != null && (zc instanceof i)) {
            ((i) zc).bOx();
            if (this.uQu != null) {
                this.uQu.reset();
            }
        }
    }

    public final void bPw() {
        this.uQN.hap = 0;
    }

    public final void bPx() {
        af.v(new Runnable(this) {
            final /* synthetic */ HomeUI uRb;

            {
                this.uRb = r1;
            }

            public final void run() {
                ap.vL().bJk();
                af.yv(0);
                this.uRb.uQN.bZV();
                this.uRb.uQM.nhl = true;
                this.uRb.uQM.bVe();
                this.uRb.uQM.ll(false);
                this.uRb.bPE();
            }

            public final String toString() {
                return super.toString() + "|chattingView_onAnimationEnd";
            }
        });
    }

    public final void a(String str, Bundle bundle, boolean z) {
        String str2 = "MicroMsg.LauncherUI";
        String str3 = "try startChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.uQN == null ? false : this.uQN.isShown());
        w.i(str2, str3, objArr);
        ap.getNotification().aw(false);
        this.uQR = bundle;
        this.uQQ = str;
        this.uQV = z;
        ap.vL().bJh();
        af.yv(-8);
        if (this.uPT) {
            w.i("MicroMsg.LauncherUI", "remove setTagRunnable");
            af.I(this.uQm);
        }
        af.v(this.uQS);
        if (com.tencent.mm.u.m.yt().booleanValue() && (uQf.booleanValue() || uQg.booleanValue())) {
            c(Boolean.valueOf(false), Boolean.valueOf(false));
        }
        com.tencent.mm.ui.conversation.j jVar = (com.tencent.mm.ui.conversation.j) this.uRa.get(Integer.valueOf(0));
        if (jVar != null) {
            jVar.onHiddenChanged(true);
        }
    }

    private ViewGroup bPy() {
        ViewParent parent = this.Gx.getCustomView().getParent();
        ViewParent viewParent = null;
        ViewParent viewParent2 = (ViewGroup) this.uQk.getWindow().getDecorView();
        while (parent != viewParent2 && parent != null) {
            ViewParent viewParent3 = parent;
            parent = parent.getParent();
            viewParent = viewParent3;
        }
        return (ViewGroup) viewParent;
    }

    private boolean bPz() {
        List<Fragment> aW = this.uQk.aR().aW();
        if (aW == null) {
            w.i("MicroMsg.LauncherUI", "fragments is null");
            return true;
        }
        if (aW.size() >= 5) {
            w.e("MicroMsg.LauncherUI", "fragments more than 5! %s", Integer.valueOf(aW.size()));
            for (Fragment fragment : aW) {
                if (fragment instanceof com.tencent.mm.ui.chatting.En_5b8fbb1e.a) {
                    w.e("MicroMsg.LauncherUI", "fragments more than 5 and find a ChattingUIFragmet!!");
                    return false;
                }
            }
        }
        w.i("MicroMsg.LauncherUI", "fragments size %s", Integer.valueOf(aW.size()));
        return true;
    }

    @TargetApi(16)
    public final void af(Intent intent) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.uQM == null) {
            this.uQM = com.tencent.mm.ui.chatting.En_5b8fbb1e.a.bUQ();
            this.uQM.e(this.uQK, this.uQL);
            this.uQK = null;
            this.uQL = null;
            z = true;
        } else {
            z = false;
        }
        final int[] iArr;
        View bPy;
        final ViewGroup viewGroup;
        int i;
        if (this.uQN == null) {
            if (this.uQM.bQi()) {
                iArr = new int[2];
                this.uQk.cO().cP().getCustomView().getLocationInWindow(iArr);
                View testTimeForChatting = new TestTimeForChatting(this.uQk);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                testTimeForChatting.setId(R.h.bAp);
                this.uQC = testTimeForChatting.getId();
                testTimeForChatting.setOrientation(1);
                testTimeForChatting.setLayoutParams(layoutParams);
                final View fitSystemWindowLayoutView = new FitSystemWindowLayoutView(this.uQk);
                fitSystemWindowLayoutView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                bPy = bPy();
                if (bPy == null) {
                    bPy = ((ViewGroup) this.uQk.getWindow().getDecorView()).getChildAt(0);
                }
                viewGroup = (ViewGroup) bPy;
                ((ViewGroup) this.uQk.getWindow().getDecorView()).removeView(bPy);
                bPy.setId(R.h.caQ);
                fitSystemWindowLayoutView.addView(bPy);
                fitSystemWindowLayoutView.addView(testTimeForChatting);
                ((ViewGroup) this.uQk.getWindow().getDecorView()).addView(fitSystemWindowLayoutView);
                this.uQk.getWindow().getDecorView().requestFitSystemWindows();
                i = iArr[1];
                w.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows. statusBarHeight:%d", Integer.valueOf(i));
                if (i > 0) {
                    a(fitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), viewGroup);
                } else {
                    this.uQk.cO().cP().getCustomView().post(new Runnable(this) {
                        final /* synthetic */ HomeUI uRb;

                        public final void run() {
                            this.uRb.uQk.cO().cP().getCustomView().getLocationInWindow(iArr);
                            int i = iArr[1];
                            if (i > 0) {
                                this.uRb.a(fitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), viewGroup);
                            } else if (com.tencent.mm.compatible.util.d.eo(20)) {
                                fitSystemWindowLayoutView.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                                    final /* synthetic */ AnonymousClass26 uRo;

                                    {
                                        this.uRo = r1;
                                    }

                                    @TargetApi(20)
                                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                        if (windowInsets != null) {
                                            w.i("MicroMsg.LauncherUI", "OnApplyWindowInsetsListener %s", windowInsets);
                                            windowInsets.consumeSystemWindowInsets();
                                            this.uRo.uRb.a(fitSystemWindowLayoutView, windowInsets.getSystemWindowInsetTop(), new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), viewGroup);
                                        }
                                        return windowInsets;
                                    }
                                });
                            }
                        }
                    });
                }
                this.uQN = (TestTimeForChatting) this.uQk.findViewById(this.uQC);
                w.i("MicroMsg.LauncherUI", "ashu::prepareChattingFragment init chattingView, top %s", Integer.valueOf(iArr[1]));
            } else {
                this.uQN = (TestTimeForChatting) this.uQk.findViewById(R.h.bzR);
                this.uQC = this.uQN.getId();
            }
        } else if (this.uQM.bQi()) {
            iArr = new int[2];
            this.uQN.getLocationInWindow(iArr);
            if (iArr[1] == 0) {
                viewGroup = (ViewGroup) this.uQk.getWindow().getDecorView();
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    bPy = ((ViewGroup) this.uQk.getWindow().getDecorView()).getChildAt(i2);
                    if (bPy instanceof FitSystemWindowLayoutView) {
                        this.uQk.cO().cP().getCustomView().getLocationInWindow(iArr);
                        FitSystemWindowLayoutView fitSystemWindowLayoutView2 = (FitSystemWindowLayoutView) bPy;
                        i = ((ViewGroup) this.uQk.findViewById(R.h.caQ)).getPaddingTop();
                        i2 = com.tencent.mm.ui.base.s.ab(this.uQk, -1);
                        Rect rect = new Rect();
                        Window window = this.uQk.getWindow();
                        window.getDecorView().getWindowVisibleDisplayFrame(rect);
                        int height = window.getDecorView().getHeight();
                        w.i("MicroMsg.LauncherUI", "rootLayout2 fitSystemWindows detect: ActionBar's CustomView location[1]:%d, paddingTop:%d getStatusBarHeight():%d, heightFromSysR:%d, rectangle.top:%d, rectangle.height:%d, DecorHeight:%d, cacheInsetsTop:%d", Integer.valueOf(iArr[1]), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.pluginsdk.e.ds(this.uQk)), Integer.valueOf(i2), Integer.valueOf(rect.top), Integer.valueOf(rect.height()), Integer.valueOf(height), Integer.valueOf(fitSystemWindowLayoutView2.uRx));
                        fitSystemWindowLayoutView2.fitSystemWindows(new Rect(0, fitSystemWindowLayoutView2.uRx, 0, 0));
                        break;
                    }
                    w.e("MicroMsg.LauncherUI", "on position %d, rootLayout not found!", Integer.valueOf(i2));
                }
            }
            w.i("MicroMsg.LauncherUI", "ashu::prepareChattingFragment has chattingView, top %s", Integer.valueOf(iArr[1]));
        }
        if (z) {
            this.uQM.hML = true;
            this.uQM.nhl = false;
            this.uQM.setArguments(s.ad(intent));
            if (bPz()) {
                this.uQk.aR().aV().a(this.uQC, this.uQM).commitAllowingStateLoss();
                this.uQk.aR().executePendingTransactions();
            } else {
                this.uQk.aR().aV().b(this.uQC, this.uQM).commitAllowingStateLoss();
            }
            this.uQO = (OnLayoutChangedLinearLayout) this.uQM.mView.findViewById(R.h.bAb);
            this.uQM.ll(true);
        } else {
            this.uQM.hML = true;
            this.uQM.nhl = false;
            this.uQM.oW.putAll(s.ad(intent));
            this.uQM.bTD();
            this.uQM.onResume();
            this.uQM.ll(true);
        }
        if (this.uQM.bQi()) {
            this.uQM.uUD.wxG = false;
        }
        w.i("MicroMsg.LauncherUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z), intent);
    }

    public final void a(FitSystemWindowLayoutView fitSystemWindowLayoutView, int i, Rect rect, ViewGroup viewGroup) {
        int i2;
        int bottom = this.uQk.getWindow().getDecorView().getBottom();
        int bottom2 = this.uQk.cO().cP().getCustomView().getBottom();
        if (this.uQb == null || !(this.uQb instanceof View)) {
            i2 = 0;
        } else {
            i2 = bottom - (((View) this.uQb).getBottom() + (i + bottom2));
        }
        w.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", Integer.valueOf(bottom), Integer.valueOf(i), Integer.valueOf(bottom2), Integer.valueOf(i2));
        fitSystemWindowLayoutView.uRy = viewGroup;
        fitSystemWindowLayoutView.fitSystemWindows(rect);
    }

    public final void kl(boolean z) {
        String str = "MicroMsg.LauncherUI";
        String str2 = "try closeChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.uQN == null ? false : this.uQN.isShown());
        w.i(str, str2, objArr);
        if (this.lCS == 0 && com.tencent.mm.kernel.h.vH().gXC.foreground) {
            ap.getNotification().aw(true);
        } else {
            ap.getNotification().aw(false);
        }
        if (this.uQM != null && this.uQM.bQi()) {
            j.b(this.uQk);
        }
        if (this.uQN != null && this.uQN.getVisibility() != 8 && this.uQM != null) {
            w.i("MicroMsg.LauncherUI", "closeChatting");
            bPu();
            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                final /* synthetic */ HomeUI uRb;

                {
                    this.uRb = r1;
                }

                public final void run() {
                    com.tencent.mm.modelstat.d.a(4, "En_5b8fbb1e" + this.uRb.uQM.bVk(), this.uRb.uQM.hashCode());
                    com.tencent.mm.modelstat.d.d("En_5b8fbb1e" + this.uRb.uQM.bVk(), this.uRb.uQn, bg.Ny());
                }
            }, "directReport_closeChatting");
            this.uQN.setVisibility(8);
            this.uQX = true;
            if (this.uQU == null) {
                this.uQU = AnimationUtils.loadAnimation(this.uQk, com.tencent.mm.ui.MMFragmentActivity.a.uUS);
                this.uQU.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ HomeUI uRb;

                    {
                        this.uRb = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                        ap.vL().bJh();
                        af.yv(-8);
                        w.i("MicroMsg.LauncherUI", "klem pop out onAnimationStart");
                        this.uRb.km(true);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        ap.vL().bJk();
                        af.yv(0);
                        if (this.uRb.uPT) {
                            w.i("MicroMsg.LauncherUI", "start  setAppTagUnreadNow");
                            this.uRb.bPm();
                        }
                        this.uRb.bPE();
                        w.i("MicroMsg.LauncherUI", "klem pop out onAnimationEnd");
                    }
                });
            }
            this.uQM.onPause();
            this.uQM.bVb();
            this.uQM.hML = false;
            dS(3, this.lCS);
            x.a(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
            if (z) {
                this.uQN.startAnimation(this.uQU);
            } else {
                this.uQk.O(1.0f);
                bPE();
            }
            if (!this.uQM.bQi()) {
                bPA();
            }
            this.uQk.aQ();
            com.tencent.mm.ui.conversation.j jVar = (com.tencent.mm.ui.conversation.j) this.uRa.get(Integer.valueOf(0));
            if (jVar != null) {
                View view = jVar.uSU.ipu;
                if (jVar.uSU != null) {
                    jVar.uSU.onResume();
                }
                jVar.onHiddenChanged(false);
            }
            if (com.tencent.mm.u.m.yt().booleanValue()) {
                bPo();
            }
        }
    }

    void bPA() {
        if (this.uQM == null || !this.uQM.hML) {
            this.Gx.setLogo(new ColorDrawable(this.uQk.getResources().getColor(17170445)));
            this.Gx.cK();
            this.Gx.setDisplayHomeAsUpEnabled(false);
            this.Gx.cJ();
            this.Gx.cL();
            this.Gx.setCustomView(r.eC(this.uQk).inflate(R.i.cTC, new LinearLayout(this.uQk), false));
            ajj();
            this.Gx.getCustomView().findViewById(R.h.bnc).setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ HomeUI uRb;

                {
                    this.uRb = r1;
                }

                public final void onClick(View view) {
                    if (SystemClock.elapsedRealtime() - this.uRb.qqT < 300) {
                        Iterator it = this.uRb.uQY.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                    }
                    this.uRb.qqT = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    public final void Y(Runnable runnable) {
        if (!this.uQY.contains(runnable)) {
            this.uQY.add(runnable);
        }
    }

    public final void Z(Runnable runnable) {
        this.uQY.remove(runnable);
    }

    public final void SD(String str) {
        if (str != null && !str.equals("")) {
            zb(((Integer) uQZ.get(str)).intValue());
        }
    }

    public final void zb(int i) {
        w.i("MicroMsg.LauncherUI", "change tab to %d, cur tab %d, has init tab %B, tab cache size %d", Integer.valueOf(i), Integer.valueOf(this.lCS), Boolean.valueOf(this.uPY), Integer.valueOf(this.uRa.size()));
        if (this.uPY && i >= 0) {
            if (this.uQd != null && i > this.uQd.getCount() - 1) {
                return;
            }
            if (this.lCS != i || this.uRa.size() == 0) {
                this.lCS = i;
                if (this.uQb != null) {
                    this.uQb.lJ(this.lCS);
                }
                if (this.uQc != null) {
                    this.uQc.k(this.lCS, false);
                    za(this.lCS);
                }
                if (this.lCS == 0 && com.tencent.mm.kernel.h.vH().gXC.foreground) {
                    ap.getNotification().aw(true);
                } else {
                    ap.getNotification().aw(false);
                }
            }
        }
    }

    public final q zc(int i) {
        q qVar = null;
        w.i("MicroMsg.LauncherUI", "get tab %d", Integer.valueOf(i));
        if (i < 0) {
            return null;
        }
        if (this.uRa.containsKey(Integer.valueOf(i))) {
            return (q) this.uRa.get(Integer.valueOf(i));
        }
        Bundle bundle = new Bundle();
        switch (i) {
            case 0:
                bundle.putInt(com.tencent.mm.ui.conversation.j.class.getName(), 0);
                qVar = (q) Fragment.a(this.uQk, com.tencent.mm.ui.conversation.j.class.getName(), bundle);
                ap.getNotification().aw(true);
                break;
            case 1:
                bundle.putInt(com.tencent.mm.ui.contact.AddressUI.a.class.getName(), 1);
                bundle.putBoolean("Need_Voice_Search", true);
                bundle.putBoolean("favour_include_biz", true);
                qVar = (q) Fragment.a(this.uQk, com.tencent.mm.ui.contact.AddressUI.a.class.getName(), bundle);
                break;
            case 2:
                bundle.putInt(g.class.getName(), 2);
                qVar = (q) Fragment.a(this.uQk, g.class.getName(), bundle);
                break;
            case 3:
                bundle.putInt(s.class.getName(), 3);
                qVar = (q) Fragment.a(this.uQk, s.class.getName(), bundle);
                break;
        }
        w.v("MicroMsg.LauncherUI", "createFragment index:%d", Integer.valueOf(i));
        if (qVar != null) {
            qVar.a(this.uQk);
        }
        this.uRa.put(Integer.valueOf(i), qVar);
        return qVar;
    }

    public final int bPB() {
        int a;
        long currentTimeMillis = System.currentTimeMillis();
        if (ap.zb()) {
            a = com.tencent.mm.u.p.a(com.tencent.mm.u.o.hlr, y.bQG());
            w.d("MicroMsg.LauncherUI", "getMainTabUnreadCount  unread : %d", Integer.valueOf(a));
        } else {
            w.w("MicroMsg.UnreadCountHelper", "getMainTabUnreadCount, but mmcore not ready");
            a = 0;
        }
        zd(a);
        w.d("MicroMsg.LauncherUI", "unreadcheck setConversationTagUnread  last time %d, unread %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(a));
        return a;
    }

    public final void zd(int i) {
        if (this.uQb != null) {
            this.uQb.yV(i);
            ajj();
        }
    }

    public final void bPC() {
        af.v(new Runnable(this) {
            final /* synthetic */ HomeUI uRb;

            {
                this.uRb = r1;
            }

            public final void run() {
                int f;
                if (ap.zb()) {
                    ap.yY();
                    f = u.f((Integer) com.tencent.mm.u.c.vr().get(143618, null));
                } else {
                    w.w("MicroMsg.UnreadCountHelper", "getAddrTabUnreadCount, but mmcore not ready");
                    f = 0;
                }
                if (this.uRb.uQb != null) {
                    this.uRb.uQb.yW(f);
                }
            }

            public final String toString() {
                return super.toString() + "|setAddressTagUnread";
            }
        });
    }

    public final void bOs() {
        this.uQk.moveTaskToBack(true);
        if (ap.zb()) {
            ap.vL().e(new Runnable(this) {
                final /* synthetic */ HomeUI uRb;

                {
                    this.uRb = r1;
                }

                public final void run() {
                    if (ap.zb()) {
                        ap.yY();
                        com.tencent.mm.storage.t vr = com.tencent.mm.u.c.vr();
                        if (vr != null) {
                            vr.jY(true);
                        }
                    }
                }
            }, 500);
        }
        com.tencent.mm.app.l os = com.tencent.mm.app.l.os();
        os.fwS = false;
        os.fwT.removeMessages(-1999);
        os.fwT.removeMessages(-2999);
        os.fwT.sendEmptyMessageDelayed(-1999, 3000);
        os.fwT.sendEmptyMessageDelayed(-2999, 30000);
    }

    private void bPD() {
        this.uQa = false;
        this.uQu.reset();
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            w.d("MicroMsg.LauncherUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        ap.yY();
        if (mVar == com.tencent.mm.u.c.wW()) {
            w.d("MicroMsg.LauncherUI", "Launcherui onNotifyChange event type %d, username %s", Integer.valueOf(i), obj);
            if (com.tencent.mm.storage.x.eO((String) obj)) {
                bPn();
            }
        }
    }

    public final void km(boolean z) {
        if (a.ACTIVITY_RESUME == this.uQj) {
            this.uQk.d(z, 0);
        }
    }

    public final void bPE() {
        boolean z = true;
        if (bPF()) {
            String str = "MicroMsg.LauncherUI";
            String str2 = "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.uQM != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.i(str, str2, objArr);
            if (this.uQM != null) {
                this.uQM.uUD.wuc = false;
            }
        }
    }

    final boolean bPF() {
        if (com.tencent.mm.compatible.util.d.eo(19) && com.tencent.mm.compatible.h.a.rX() && !com.tencent.mm.compatible.e.b.ay(this.uQk)) {
            return true;
        }
        return false;
    }

    public static boolean VJ() {
        return true;
    }

    public final void dS(int i, int i2) {
        w.i("MicroMsg.LauncherUI", "clickFlowStat index:%d op:%d %s", Integer.valueOf(i2), Integer.valueOf(i), bg.bJZ());
        if (i2 >= 0) {
            String str = "MainUI";
            if (i2 == 1) {
                str = "AddressUI";
            }
            if (i2 == 2) {
                str = "FindMoreFriendUI";
            }
            if (i2 == 3) {
                str = "MoreTabUI";
            }
            com.tencent.mm.modelstat.d.a(i, str, ((this.uQk.hashCode() / 16) * 16) + i2);
        }
    }

    public final void bPG() {
        if (this.pkm != null) {
            this.pkm.show();
            return;
        }
        if (this.pkj == null) {
            this.pkj = View.inflate(this.uQk, R.i.dnR, null);
            this.pkk = (TextView) this.pkj.findViewById(R.h.cCA);
            this.pkk.setText(getString(R.l.eSE));
            this.pkl = (EditText) this.pkj.findViewById(R.h.cCz);
            this.pkl.setInputType(129);
        }
        this.pkm = com.tencent.mm.ui.base.g.a(this.uQk, null, this.pkj, new OnClickListener(this) {
            final /* synthetic */ HomeUI uRb;

            {
                this.uRb = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                String obj = this.uRb.pkl.getText().toString();
                this.uRb.pkl.setText("");
                this.uRb.pkl.clearFocus();
                u.a(this.uRb.uQk, this.uRb.pkl);
                if (obj == null || obj.equals("")) {
                    com.tencent.mm.ui.base.g.a(this.uRb.uQk, R.l.eZX, R.l.dIO, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass51 uRr;

                        {
                            this.uRr = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
                this.uRb.bPt();
                ap.vd().a(384, this.uRb.uPV);
                final com.tencent.mm.y.k aiVar = new ai(obj, "", "", "");
                ap.vd().a(aiVar, 0);
                HomeUI homeUI = this.uRb;
                Context context = this.uRb.uQk;
                this.uRb.getString(R.l.dIO);
                homeUI.isv = com.tencent.mm.ui.base.g.a(context, this.uRb.getString(R.l.eSL), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass51 uRr;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().b(384, this.uRr.uRb.uPV);
                        this.uRr.uRb.uPV = null;
                        ap.vd().c(aiVar);
                    }
                });
            }
        }, new OnClickListener(this) {
            final /* synthetic */ HomeUI uRb;

            {
                this.uRb = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.uRb.pkl.setText("");
                this.uRb.pkm.dismiss();
            }
        });
    }
}
