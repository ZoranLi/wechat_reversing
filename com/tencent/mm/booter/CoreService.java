package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mars.Mars;
import com.tencent.mars.comm.Alarm;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.comm.PlatformComm.IResetProcess;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mm.booter.MMReceivers.AlarmReceiver;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.e.a.mp;
import com.tencent.mm.kernel.k;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.l;
import com.tencent.mm.network.o;
import com.tencent.mm.network.s;
import com.tencent.mm.network.v;
import com.tencent.mm.network.x;
import com.tencent.mm.network.y;
import com.tencent.mm.network.z;
import com.tencent.mm.network.z.a;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.z.b;

public class CoreService extends Service implements IResetProcess, l, a {
    private boolean gJA = true;
    private final b gJB = new b(this) {
        final /* synthetic */ CoreService gJJ;

        {
            this.gJJ = r1;
        }

        public final void prepare() {
            AlarmReceiver.ap(this.gJJ.getApplicationContext());
        }

        public final void cancel() {
            AlarmReceiver.aq(this.gJJ.getApplicationContext());
        }
    };
    private int gJC = -1;
    private long gJD = 0;
    private long gJE = 0;
    private long gJF = 0;
    private WakerLock gJG = null;
    private f gJH = new f();
    private aj gJI = new aj(new aj.a(this) {
        final /* synthetic */ CoreService gJJ;

        {
            this.gJJ = r1;
        }

        public final boolean oQ() {
            boolean z;
            f a = this.gJJ.gJH;
            if (bg.aB(a.ihC) < a.ihA) {
                w.i("MicroMsg.FrequncyLimiter", "frequency limited, last=" + a.ihC + ", cur=" + bg.NA() + ", retries=" + a.ihD);
                if (a.ihD <= 0) {
                    z = false;
                } else {
                    a.ihD--;
                    a.ihC = bg.NA();
                    z = true;
                }
            } else {
                a.ihD = a.ihB;
                a.ihC = bg.NA();
                z = true;
            }
            if (z) {
                w.i("MicroMsg.CoreService", "setNetworkAvailable  deal with Sync Check isSessionKeyNull:%b, isMMProcessExist:%b", Boolean.valueOf(bg.bm(this.gJJ.gJy.ieq.vc())), Boolean.valueOf(z.MO().My()));
                if (bg.bm(this.gJJ.gJy.ieq.vc()) || r3 || !f.a(1, 0, null, this.gJJ.gJy.ieq.vc(), bg.Nz())) {
                    CoreService.pT();
                } else {
                    w.i("MicroMsg.CoreService", "setNetworkAvailable deal with notify sync in push");
                    return true;
                }
            }
            w.e("MicroMsg.CoreService", "setNetworkAvailable checker frequency limited");
            w.i("MicroMsg.CoreService", "setNetworkAvailable finish lockCount:%d delayCount:%d delayDur:%d", Long.valueOf(this.gJJ.gJD), Long.valueOf(this.gJJ.gJF), Long.valueOf(bg.Nz() - this.gJJ.gJE));
            this.gJJ.gJD = 0;
            this.gJJ.gJF = 0;
            this.gJJ.gJE = 0;
            new aj(new aj.a(this) {
                final /* synthetic */ AnonymousClass4 gJK;

                {
                    this.gJK = r1;
                }

                public final boolean oQ() {
                    this.gJK.gJJ.gJG.unLock();
                    return false;
                }
            }, false).v(500, 500);
            return true;
        }
    }, false);
    private s gJy;
    private e gJz = new e();

    public static class InnerService extends Service {
        public void onCreate() {
            super.onCreate();
            try {
                startForeground(-1213, new Notification());
            } catch (NullPointerException e) {
                w.e("MicroMsg.CoreService", "set service for push exception:%s.", e);
            }
            stopSelf();
        }

        public void onDestroy() {
            stopForeground(true);
            super.onDestroy();
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public void onCreate() {
        String str;
        String str2;
        NetworkInfo networkInfo = null;
        w.d("MicroMsg.CoreService", "onCreate~~~threadID:" + Thread.currentThread());
        super.onCreate();
        if (VERSION.SDK_INT < 24 && !h.sf()) {
            if (VERSION.SDK_INT < 18) {
                startForeground(-1213, new Notification());
            } else if (getSharedPreferences("system_config_prefs", 4).getBoolean("set_service", false)) {
                startForeground(-1213, new Notification());
                startService(new Intent(this, InnerService.class));
                w.i("MicroMsg.CoreService", "set service for push.");
            }
        }
        ae aeVar = new ae(Looper.getMainLooper());
        Mars.init(ab.getContext(), aeVar);
        StnLogic.setCallBack(new com.tencent.mm.network.ae());
        IPxxLogic.setCallBack(new o());
        com.tencent.mm.jni.a.a.uy();
        com.tencent.mm.sdk.b.a.urY.b(new c<mp>(this) {
            final /* synthetic */ CoreService gJJ;

            {
                this.gJJ = r2;
                this.usg = mp.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                String str = ((mp) bVar).fTU.fTV;
                if (bg.mA(str)) {
                    return false;
                }
                com.tencent.mm.plugin.report.c.oTb.a(12900, str, true, false);
                return true;
            }
        });
        z.MI();
        com.tencent.mm.sdk.platformtools.z.a(this.gJB);
        if (PlatformComm.resetprocessimp == null) {
            PlatformComm.resetprocessimp = this;
        }
        z.a(aeVar);
        z.setContext(getApplicationContext());
        z.a(new aa());
        z.a(new com.tencent.mm.network.ab());
        z.a((a) this);
        z.a(new v());
        this.gJy = z.MO();
        if (this.gJy == null) {
            w.i("MicroMsg.CoreService", "autoAuth is null and new one");
            this.gJy = new s(z.MM());
            z.b(this.gJy);
        } else {
            w.w("MicroMsg.CoreService", "autoAuth is not null and reset");
            this.gJy.reset();
        }
        Mars.onCreate(true);
        if (z.MP() == null) {
            w.i("MicroMsg.CoreService", "NetTaskAdapter is null and new one");
            z.a(new y());
        } else {
            w.w("MicroMsg.CoreService", "NetTaskAdapter is not null and reset");
            z.MP().reset();
        }
        if (z.MQ() == null) {
            w.i("MicroMsg.CoreService", "NetNotifyAdapter is null and new one");
            z.a(new x());
            z.MQ().ifk = this;
            if (z.MT()) {
                z.bA(false);
                z.MM().post(new Runnable(this) {
                    final /* synthetic */ CoreService gJJ;

                    {
                        this.gJJ = r1;
                    }

                    public final void run() {
                        w.i("MicroMsg.CoreService", "NetNotifyAdapter NeedNotifyGCM after init");
                        z.MQ().onPush(2147480001, new byte[0]);
                    }

                    public final String toString() {
                        return "NotifyGCM";
                    }
                });
            }
        }
        c cVar = ((com.tencent.mm.kernel.b.f) com.tencent.mm.kernel.h.vF().vj()).gKC;
        if (cVar != null) {
            this.gJy.d(cVar.getString(".com.tencent.mm.debug.server.host.http"), cVar.getString(".com.tencent.mm.debug.server.ports.http"), cVar.getString(".com.tencent.mm.debug.server.host.socket"), cVar.getString(".com.tencent.mm.debug.server.ports.socket"));
        }
        if (cVar == null) {
            str = networkInfo;
        } else {
            str = cVar.getString(".com.tencent.mm.debug.server.host.newdns");
        }
        if (str == null || !str.contains(":")) {
            str2 = str;
            Object obj = networkInfo;
        } else {
            String[] split = str.split(":");
            str2 = split[0];
            str = split[1];
        }
        this.gJy.setNewDnsDebugHost(str2, str);
        AlarmReceiver.as(getApplicationContext());
        AlarmReceiver.ar(getApplicationContext());
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CoreService", e, "", new Object[0]);
            w.e("MicroMsg.CoreService", "getActiveNetworkInfo failed.");
        }
        if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
            z.MK().ifD = false;
            z.ML().gY(0);
        } else {
            z.MK().ifD = true;
            z.ML().gY(6);
        }
        ((PluginZero) com.tencent.mm.kernel.h.j(PluginZero.class)).sAU.a(this);
        w.i("MicroMsg.CoreService", "CoreService OnCreate ");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int myPid = Process.myPid();
        w.i("MicroMsg.CoreService", "onStartCommand lastpid:%d  pid:%d flags:%d startId:%d", Integer.valueOf(this.gJC), Integer.valueOf(myPid), Integer.valueOf(i), Integer.valueOf(i2));
        if (myPid != this.gJC) {
            this.gJC = myPid;
            com.tencent.mm.plugin.report.c.oTb.a(99, 141, 1, false);
            if (intent != null && "auto".equals(intent.getStringExtra("START_TYPE"))) {
                com.tencent.mm.plugin.report.c.oTb.a(99, 140, 1, false);
            }
        }
        return 1;
    }

    public void onDestroy() {
        w.d("MicroMsg.CoreService", "onDestroy~~~ threadID:" + Thread.currentThread());
        ((PluginZero) com.tencent.mm.kernel.h.j(PluginZero.class)).sAU.b(this);
        com.tencent.mm.jni.a.a.uz();
        super.onDestroy();
        pU();
    }

    public boolean onUnbind(Intent intent) {
        w.d("MicroMsg.CoreService", "onUnbind~~~ threadID:" + Thread.currentThread());
        z.MK().ifC = null;
        z.MS().ifd = null;
        return super.onUnbind(intent);
    }

    public IBinder onBind(Intent intent) {
        w.d("MicroMsg.CoreService", "onBind~~~ threadID:" + Thread.currentThread());
        return this.gJy;
    }

    public void onRebind(Intent intent) {
        w.d("MicroMsg.CoreService", "onRebind~~~ threadID:" + Thread.currentThread());
        super.onRebind(intent);
    }

    public final boolean d(int i, byte[] bArr) {
        if (k.aK(this)) {
            w.i("MicroMsg.CoreService", "fully exited, no need to notify worker");
            return false;
        }
        int i2;
        if (i == -255) {
            i2 = 138;
        } else {
            i2 = i;
        }
        boolean z = z.MH().getBoolean("is_in_notify_mode", false);
        boolean bm = bg.bm(this.gJy.ieq.vc());
        boolean My = z.MO().My();
        if (!(!z || bm || My)) {
            if (f.a(2, i2, bArr, this.gJy.ieq.vc(), bg.Nz())) {
                w.i("MicroMsg.CoreService", "deal with notify sync in push");
                return true;
            }
        }
        w.i("MicroMsg.CoreService", "deal with notify sync to mm by broast, isSessionKeyNull:%b, isMMProcessExist:%b, isInNotifyMode:%b", Boolean.valueOf(bm), Boolean.valueOf(My), Boolean.valueOf(z));
        Intent intent = new Intent(this, NotifyReceiver.class);
        intent.putExtra("notify_option_type", 2);
        intent.putExtra("notify_uin", this.gJy.ieq.uH());
        intent.putExtra("notify_respType", i2);
        intent.putExtra("notify_respBuf", bArr);
        intent.putExtra("notfiy_recv_time", bg.Nz());
        intent.putExtra("notify_skey", this.gJy.ieq.vc());
        w.i("MicroMsg.CoreService", "notify broadcast:" + intent.getAction() + ", type=" + i2);
        try {
            w.i("MicroMsg.CoreService", "notify broadcast: dknot recvTime:%d uin:%d type:%d buf:%d", Long.valueOf(intent.getLongExtra("notfiy_recv_time", 0)), Integer.valueOf(intent.getIntExtra("notify_uin", 0)), Integer.valueOf(intent.getIntExtra("notify_respType", 0)), Integer.valueOf(bg.i(intent.getByteArrayExtra("notify_respBuf"), new byte[0]).length));
            sendBroadcast(intent);
        } catch (Throwable th) {
            w.e("MicroMsg.CoreService", "dknot sendBroadcast  failed:%s", bg.g(th));
        }
        return true;
    }

    public final void av(boolean z) {
        if (z) {
            w.w("MicroMsg.CoreService", "[NETWORK CONNECTED]");
            z.MK().ifD = true;
            boolean pV = this.gJz.pV();
            if (!this.gJA || pV) {
                if (pV) {
                    z.MO().Mq();
                }
                this.gJA = true;
                z.ML().gY(6);
                if (this.gJG == null) {
                    this.gJG = new WakerLock(getApplicationContext());
                }
                if (!this.gJG.isLocking()) {
                    this.gJG.lock(6000, "CoreService.setNetworkAvailable");
                    this.gJD++;
                }
                if (0 == this.gJF) {
                    this.gJE = bg.Nz();
                }
                this.gJF++;
                w.i("MicroMsg.CoreService", "setNetworkAvailable start lockCount:%d delayCount:%d delayDur:%d", Long.valueOf(this.gJD), Long.valueOf(this.gJF), Long.valueOf(bg.Nz() - this.gJE));
                this.gJI.v(3000, 3000);
                return;
            }
            w.i("MicroMsg.CoreService", "network not change or can't get network info, lastStatus connect:%b", Boolean.valueOf(this.gJA));
            return;
        }
        w.w("MicroMsg.CoreService", "[NETWORK LOST]");
        z.MK().ifD = false;
        z.ML().gY(0);
        if (this.gJA) {
            z.MO().Mq();
            e eVar = this.gJz;
            eVar.gJR = null;
            eVar.gJS = null;
        }
        this.gJA = false;
    }

    public static void pT() {
        Intent intent = new Intent(z.getContext(), NotifyReceiver.class);
        intent.putExtra("notify_option_type", 1);
        intent.putExtra("notify_uin", z.MO().ieq.uH());
        try {
            z.getContext().sendBroadcast(intent);
        } catch (Exception e) {
            w.f("MicroMsg.CoreService", "checker frequency limited hasDestroyed %s", e.toString());
        }
    }

    private void pU() {
        w.w("MicroMsg.CoreService", "[COMPLETE EXIT]");
        z.MP().d(3, 10000, "");
        Mars.onDestroy();
        try {
            AlarmReceiver.as(getApplicationContext());
            AlarmReceiver.aq(getApplicationContext());
            Alarm.resetAlarm(getApplicationContext());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CoreService", e, "", new Object[0]);
        }
        w.appenderClose();
        Process.killProcess(Process.myPid());
    }

    public void restartProcess() {
        w.w("MicroMsg.CoreService", "restartProcess");
        pU();
    }
}
