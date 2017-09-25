package com.tencent.mm.network;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.av;
import com.tencent.mm.e.a.go;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public final class s extends com.tencent.mm.network.f.a implements com.tencent.mm.network.a.a, e {
    byte[] gXJ;
    int hSy = 0;
    ae handler;
    int iel = 0;
    private long iem = 0;
    private long ien = 0;
    private long ieo = 0;
    private WakerLock iep = null;
    public a ieq;
    a ier;
    b ies;
    long iet = 0;
    int ieu = -1;
    private com.tencent.mm.storage.s iev;
    private r iew;
    g iex;

    static class a extends com.tencent.mm.network.i.a implements k {
        private s gJy;
        private WakerLock ieS;
        private int ieT = 0;

        public a(s sVar, WakerLock wakerLock) {
            this.gJy = sVar;
            this.ieS = wakerLock;
        }

        public final void a(q qVar, int i, int i2, String str) {
            this.ieS.lock(1000, "MMAutoAuth.IOnAutoAuth.onAutoAuth");
            final q qVar2 = qVar;
            final int i3 = i;
            final int i4 = i2;
            final String str2 = str;
            new bb<Object>(this) {
                final /* synthetic */ a ieW;

                protected final Object run() {
                    try {
                        s.a(this.ieW.gJy, qVar2, str2);
                    } catch (Throwable e) {
                        w.e("MicroMsg.AutoAuth", "exception:%s", bg.g(e));
                    }
                    return null;
                }
            }.b(this.gJy.handler);
        }

        public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
            if (qVar.getType() == 701) {
                w.d("MicroMsg.AutoAuth", "summerauth IOnAutoAuth onGYNetEnd manual auth");
                if (qVar.Cn().Cq() != 0 || i2 != 0) {
                    c.oTb.a(148, -102 == i3 ? 30 : 29, 1, false);
                } else if (qVar.Co() == 2) {
                    c.oTb.a(148, 28, 1, false);
                    this.ieT++;
                    if (this.ieT > 1) {
                        w.w("MicroMsg.AutoAuth", "summerauth manualLoginDecodeFailedTry beyond 1 no more try!");
                        this.gJy.c(i2, i3, "auth_decode_failed_" + bg.ap(str, ""));
                    } else {
                        qVar.a(this, 0, 0);
                    }
                } else {
                    this.ieT = 0;
                    qVar.a((i) this, i2, i3, str);
                }
            }
            if (qVar.Cn().Cq() == 0 && i2 == 0) {
                qVar.a((i) this, i2, i3, str);
            } else if (-102 == i3) {
                this.gJy.ieu = i;
                qVar.a(this.gJy.ieq, this.gJy.ies, 0, 0);
            } else {
                if (-301 == i3) {
                    qVar.a((i) this, i2, i3, str);
                } else if (-105 == i3) {
                    qVar.a((i) this, i2, i3, str);
                } else if (-17 == i3) {
                    qVar.a((i) this, i2, i3, str);
                }
                this.gJy.c(i2, i3, "autoauth_errmsg_" + bg.ap(str, ""));
            }
        }
    }

    static class b extends com.tencent.mm.network.i.a implements k {
        private s gJy;
        private WakerLock ieS;

        public b(s sVar, WakerLock wakerLock) {
            this.gJy = sVar;
            this.ieS = wakerLock;
        }

        public final void a(final q qVar, final int i, final int i2, String str) {
            this.ieS.lock(1000, "MMAutoAuth.IOnGetCert.onAutoAuth");
            new bb<Object>(this) {
                final /* synthetic */ b ieY;

                protected final Object run() {
                    try {
                        s.a(this.ieY.gJy, qVar);
                    } catch (Throwable e) {
                        w.e("MicroMsg.AutoAuth", "exception:%s", bg.g(e));
                    }
                    return null;
                }
            }.b(this.gJy.handler);
        }

        public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        }
    }

    static /* synthetic */ int a(s sVar, q qVar, k kVar) {
        int i = 1;
        w.i("MicroMsg.AutoAuth", "dkcgi sendImp rr.type:%d callback:%d", Integer.valueOf(qVar.getType()), Integer.valueOf(kVar.hashCode()));
        switch (qVar.getType()) {
            case 126:
                qVar.getType();
                c aVar = new a(sVar);
                aVar.setUsername(qVar.Cm().getUserName());
                i = z.MP().a(qVar, kVar, aVar, 0);
                if (i < 0) {
                    w.e("MicroMsg.AutoAuth", "register: net.send err");
                    return i;
                }
                w.i("MicroMsg.AutoAuth", "register: netid=" + i);
                return i;
            case 701:
                if (z.MP().MC()) {
                    return -1;
                }
                g Cm = qVar.Cm();
                c aVar2 = new a(sVar);
                aVar2.setUsername(Cm.getUserName());
                i = z.MP().a(qVar, kVar, aVar2, 0);
                if (i < 0) {
                    w.e("MicroMsg.AutoAuth", "auth: net.send err");
                    return i;
                }
                w.i("MicroMsg.AutoAuth", "auth: netid=" + i);
                return i;
            default:
                qVar.Cm().dj(sVar.ieq.uH());
                y MP = z.MP();
                c cVar = sVar.ieq;
                if (!qVar.BH()) {
                    i = 0;
                }
                i = MP.a(qVar, kVar, cVar, i);
                if (i >= 0) {
                    return i;
                }
                w.e("MicroMsg.AutoAuth", "nonauth: in queue err");
                return i;
        }
    }

    static /* synthetic */ void a(s sVar) {
        sVar.iel = 0;
        sVar.iem = 0;
        sVar.ien = 0;
        z.MP().reset();
    }

    static /* synthetic */ void a(s sVar, q qVar) {
        w.d("MicroMsg.AutoAuth", "dkcert doGetCert");
        if (60000 >= SystemClock.elapsedRealtime() - sVar.iet) {
            w.w("MicroMsg.AutoAuth", "getcert lastGetCertSucTime=%d, curtime=%d", Long.valueOf(sVar.iet), Long.valueOf(SystemClock.elapsedRealtime()));
            sVar.c(3, -1, "");
        } else if (z.MP().a(qVar, sVar.ies, sVar.ieq, 0) < 0) {
            sVar.c(3, -1, "");
        }
    }

    static /* synthetic */ void a(s sVar, q qVar, String str) {
        w.d("MicroMsg.AutoAuth", "account info updated:" + sVar.ieq);
        w.i("MicroMsg.AutoAuth", "oreh doAutoAuth ticket:%s, login:%b", str, Boolean.valueOf(sVar.ieq.BY()));
        w.bIP();
        if (!sVar.ieq.BY() && !z.MP().MC() && z.MP().a(qVar, sVar.ier, sVar.ieq, 1) < 0) {
            sVar.c(3, -1, "");
        }
    }

    static /* synthetic */ void gV(int i) {
        int i2 = 0;
        w.i("MicroMsg.AutoAuth", "cancel: netid=" + i);
        if (i < 0) {
            w.e("MicroMsg.AutoAuth", "error netid < 0, " + i);
            return;
        }
        y MP = z.MP();
        w.i("MicroMsg.MMNativeNetTaskAdapter", "stopTask netId=" + i);
        if (i >= 0 && i < 100) {
            synchronized (MP.ifl) {
                if (MP.ifl[i] != null) {
                    i2 = MP.ifl[i].taskId;
                }
            }
            if (i2 != 0) {
                StnLogic.stopTask(i2);
            }
            synchronized (MP.ifl) {
                if (MP.ifl[i] != null) {
                    try {
                        w.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi stopTask outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i2), Integer.valueOf(MP.ifl[i].ifp.getType()), Integer.valueOf(MP.ifl[i].ifp.BM()));
                        MP.ifl[i] = null;
                    } catch (Throwable e) {
                        w.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bg.g(e));
                    }
                }
            }
        }
    }

    public final /* bridge */ /* synthetic */ c Cc() {
        return this.ieq;
    }

    public final /* bridge */ /* synthetic */ d Mp() {
        return this.ieq;
    }

    public s(ae aeVar) {
        if (aeVar == null) {
            aeVar = new ae();
        }
        this.handler = aeVar;
        this.ieq = new a(this);
        this.iep = new WakerLock(z.getContext());
        this.ier = new a(this, this.iep);
        this.ies = new b(this, this.iep);
        this.iev = new com.tencent.mm.storage.s(com.tencent.mm.storage.w.hgq + "autoauth.cfg");
    }

    protected final void finalize() {
        reset();
        super.finalize();
    }

    public final void cancel(final int i) {
        this.iep.lock(1000, String.format("MMAutoAuth.cancel,%d", new Object[]{Integer.valueOf(i)}));
        new bb<Object>(this) {
            final /* synthetic */ s iey;

            protected final Object run() {
                try {
                    s.gV(i);
                } catch (Throwable e) {
                    w.e("MicroMsg.AutoAuth", "exception:%s", bg.g(e));
                }
                return null;
            }
        }.b(this.handler);
    }

    public final boolean BS() {
        return this.iel < 5;
    }

    public final String getNetworkServerIp() {
        return MMLogic.getNetworkServerIp();
    }

    public final String[] getIPsString(boolean z) {
        return MMLogic.getIPsString(z);
    }

    public final void reset() {
        this.iep.lock(1000, "MMAutoAuth.reset");
        new bb<Object>(this) {
            final /* synthetic */ s iey;

            {
                this.iey = r4;
            }

            protected final Object run() {
                s.a(this.iey);
                return null;
            }
        }.b(this.handler);
    }

    public final synchronized int a(final q qVar, final k kVar) {
        this.iep.lock(1000, "MMAutoAuth.send");
        return ((Integer) new bb<Integer>(this, Integer.valueOf(-1)) {
            final /* synthetic */ s iey;

            public final /* synthetic */ Object run() {
                return Mz();
            }

            private Integer Mz() {
                try {
                    return Integer.valueOf(s.a(this.iey, qVar, kVar));
                } catch (Throwable e) {
                    w.e("MicroMsg.AutoAuth", "exception:%s", bg.g(e));
                    s.a(this.iey);
                    return Integer.valueOf(-1);
                }
            }
        }.b(this.handler)).intValue();
    }

    public final boolean Mv() {
        if (90000 >= SystemClock.elapsedRealtime() - this.ien) {
            w.w("MicroMsg.AutoAuth", "auto limit lastSessionTimeout=%d, curtime=%d", Long.valueOf(this.ien), Long.valueOf(SystemClock.elapsedRealtime()));
            return false;
        }
        this.ien = SystemClock.elapsedRealtime();
        this.ieq.i(new byte[0], this.ieq.uH());
        return true;
    }

    public final void aZ(final boolean z) {
        new bb<Object>(this, Integer.valueOf(-1)) {
            final /* synthetic */ s iey;

            public final Object run() {
                BaseEvent.onForeground(z);
                com.tencent.mm.sdk.a.b.aX(z);
                return null;
            }
        }.b(this.handler);
    }

    public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
        this.iep.lock(1000, "MMAutoAuth.setIDCHostInfo");
        List<n> NJ = n.NJ(str2);
        List<n> NJ2 = n.NJ(str);
        String str5 = "MicroMsg.AutoAuth";
        String str6 = "dkidc setIDCHostInfo short:[%s][%s](%d) long:[%s][%s](%d) reset:%s";
        Object[] objArr = new Object[7];
        objArr[0] = str3;
        objArr[1] = str;
        objArr[2] = Integer.valueOf(NJ2.size());
        objArr[3] = str4;
        objArr[4] = str2;
        objArr[5] = Integer.valueOf(NJ.size());
        objArr[6] = z ? "!!!!!CHANGE IDC NOW" : "false";
        w.d(str5, str6, objArr);
        final Map hashMap = new HashMap();
        for (n nVar : NJ) {
            ArrayList arrayList = (ArrayList) hashMap.get(nVar.host);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(nVar.host, arrayList);
            }
            arrayList.add(nVar.naK);
        }
        final Map hashMap2 = new HashMap();
        for (n nVar2 : NJ2) {
            arrayList = (ArrayList) hashMap2.get(nVar2.host);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap2.put(nVar2.host, arrayList);
            }
            arrayList.add(nVar2.naK);
        }
        final int[] iArr3 = iArr2;
        final int[] iArr4 = iArr;
        new bb<Object>(this, Integer.valueOf(-1)) {
            final /* synthetic */ s iey;

            public final Object run() {
                for (Entry entry : hashMap.entrySet()) {
                    MMLogic.saveAuthLongIPs((String) entry.getKey(), (String[]) ((ArrayList) entry.getValue()).toArray(new String[0]));
                }
                for (Entry entry2 : hashMap2.entrySet()) {
                    MMLogic.saveAuthShortIPs((String) entry2.getKey(), (String[]) ((ArrayList) entry2.getValue()).toArray(new String[0]));
                }
                MMLogic.saveAuthPorts(iArr3, iArr4);
                BaseEvent.onNetworkChange();
                return null;
            }
        }.b(this.handler);
    }

    public final void d(String str, String str2, String str3, String str4) {
        this.iep.lock(1000, "MMAutoAuth.setFixedHost");
        w.i("MicroMsg.AutoAuth", "dkidc setFixedHost debug short:%s:%s long:%s:%s", str, str2, str3, str4);
        if (bg.mA(str) || bg.mA(str3)) {
            w.w("MicroMsg.AutoAuth", "dkidc setFixedHost FAILED ! check assist");
            return;
        }
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        new bb<Object>(this, Integer.valueOf(-1)) {
            final /* synthetic */ s iey;

            public final Object run() {
                MMLogic.setDebugIP(str5, str6, str7, str8);
                BaseEvent.onNetworkChange();
                return null;
            }
        }.b(this.handler);
    }

    public final void setNewDnsDebugHost(final String str, final String str2) {
        if (bg.mA(str) && bg.mA(str2)) {
            w.d("MicroMsg.AutoAuth", "setNewDnsDebugHost FAILED ! check assist");
        } else {
            new bb<Object>(this) {
                final /* synthetic */ s iey;

                protected final Object run() {
                    MMLogic.setNewDnsDebugHost(str, str2);
                    return null;
                }
            }.b(this.handler);
        }
    }

    public final void Mq() {
        this.iep.lock(1000, "MMAutoAuth.forceUpdateHostCache");
        new bb<Object>(this, Integer.valueOf(-1)) {
            final /* synthetic */ s iey;

            public final Object run() {
                BaseEvent.onNetworkChange();
                return null;
            }
        }.b(this.handler);
    }

    public final void hv(final String str) {
        this.iep.lock(1000, "MMAutoAuth.ipxxStatistics");
        new bb<Object>(this) {
            final /* synthetic */ s iey;

            protected final Object run() {
                w.bIP();
                IPxxLogic.onIPxx(str, 0);
                return null;
            }
        }.b(this.handler);
    }

    public final void a(com.tencent.mm.network.a.b bVar) {
        z.MK().ifC = bVar;
    }

    public final h Mr() {
        return z.ML();
    }

    final boolean Mw() {
        if (CdnLogic.MediaType_FAVORITE_FILE == r.iiW && r.iiX > 0) {
            r.iiX = 0;
            Mv();
        }
        if (this.ieq.BY()) {
            return true;
        }
        if (z.MP().MC()) {
            w.i("MicroMsg.AutoAuth", "makeSureAuth hasAuthCmd ret false");
            return false;
        } else if (this.ieu != -1) {
            w.w("MicroMsg.AutoAuth", "makeSureAuth auto limit now is getting cert, ret false");
            return false;
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (60000 >= elapsedRealtime - this.iem && this.iem > 0) {
                w.w("MicroMsg.AutoAuth", "makeSureAuth auto limit lastAutoAuthtime=%d, curtime=%d, return false", Long.valueOf(this.iem), Long.valueOf(elapsedRealtime));
                return false;
            } else if (ab.getContext().getSharedPreferences("auth_hold_prefs", 0).getBoolean("auth_ishold", false)) {
                w.i("MicroMsg.AutoAuth", "makeSureAuth AUTH_HOLD_KEY hold ret false");
                if (!z.MP().MD()) {
                    w.e("MicroMsg.AutoAuth", "sendImp hit push hold, pid:%d", Integer.valueOf(Process.myPid()));
                    z.MM().post(new Runnable(this) {
                        final /* synthetic */ s iey;

                        {
                            this.iey = r1;
                        }

                        public final void run() {
                            w.i("MicroMsg.AutoAuth", "makeSureAuth AUTH_HOLD_KEY hold  clearTaskAndCallback");
                            z.MP().d(4, -100, "hit push hold!!" + bg.bJZ());
                        }
                    });
                }
                return false;
            } else {
                q bz = z.MP().bz(My());
                if (bz != null) {
                    try {
                        if (!(bz instanceof com.tencent.mm.network.q.a)) {
                            this.iem = SystemClock.elapsedRealtime();
                            w.i("MicroMsg.AutoAuth", "makeSureAuth rest lastAutoAuthTime[%d]", Long.valueOf(this.iem));
                            a(bz, 3, 3);
                        } else if (30000 < elapsedRealtime - this.ieo || this.ieo <= 0) {
                            w.i("MicroMsg.AutoAuth", "makeSureAuth session time out in push_notify mode, send broast to mm");
                            this.ieo = SystemClock.elapsedRealtime();
                            z.MQ().onPush(5, null);
                        } else {
                            w.i("MicroMsg.AutoAuth", "makeSureAuth session time out in push_notify mode, but hit limit");
                            return false;
                        }
                    } catch (Throwable e) {
                        w.e("MicroMsg.AutoAuth", "makeSureAuth exception:%s", bg.g(e));
                    }
                } else {
                    w.i("MicroMsg.AutoAuth", "makeSureAuth getAutoAuthRR is null");
                }
                w.i("MicroMsg.AutoAuth", "makeSureAuth at last ret false");
                return false;
            }
        }
    }

    final void c(int i, int i2, String str) {
        int i3;
        w.i("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail inErrType=" + i + ", inErrCode=" + i2 + ", errMsg=" + str + " stack=" + bg.bJZ());
        if (i == 4 && i2 == -106) {
            w.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_BLOCK_BY_SPAM trans to MM_ERR_AUTH_ANOTHERPLACE");
            i3 = -100;
        } else {
            i3 = i2;
        }
        if (i == 5 && i2 == -13) {
            w.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_SESSIONTIMEOUT trans to MM_ERR_PASSWORD");
            i = 4;
            i3 = -3;
            c.oTb.a(148, 42, 1, false);
        }
        int i4 = i;
        if (i4 == 6 && i2 == -10001) {
            w.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp");
            SharedPreferences ze = ar.ze();
            String string = ze.getString("_auth_key", "");
            String string2 = ze.getString("server_id", "");
            if (bg.mA(string) && bg.mA(string2)) {
                w.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp aak and cookie null logout");
                i3 = -104;
                c.oTb.a(148, 52, 1, false);
                i4 = 4;
            }
        }
        z.MP().d(i4, i3, str);
        if (i4 != 4) {
            return;
        }
        if (i3 == -100 || i3 == -205 || i3 == -213) {
            ab.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
            reset();
        }
    }

    final boolean e(String str, String str2, int i) {
        boolean z;
        int i2;
        int i3;
        String string;
        ab.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().remove("auth_ishold").commit();
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("auth_info_key_prefs", 4);
        boolean z2 = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        int i4 = sharedPreferences.getInt("key_auth_update_version", 0);
        int i5 = sharedPreferences.getInt("_auth_uin", 0);
        String string2 = sharedPreferences.getString("_auth_key", "");
        String string3 = sharedPreferences.getString("server_id", "");
        Editor edit = sharedPreferences.edit();
        edit.putBoolean("key_auth_info_prefs_created", true);
        edit.putInt("key_auth_update_version", d.sYN);
        edit.putInt("_auth_uin", i);
        edit.putString("_auth_key", str);
        edit.putString("server_id", str2);
        if (!edit.commit()) {
            w.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 1th!");
            c.oTb.a(148, 36, 1, false);
            if (!edit.commit()) {
                w.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 2nd!");
                c.oTb.a(148, 37, 1, false);
                z = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
                i2 = sharedPreferences.getInt("key_auth_update_version", 0);
                i3 = sharedPreferences.getInt("_auth_uin", 0);
                string = sharedPreferences.getString("_auth_key", "");
                String string4 = sharedPreferences.getString("server_id", "");
                w.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 2th so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(true), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(d.sYN), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i), string2, string, str, string3, string4, str2);
                w.bIP();
                return false;
            }
        }
        z = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        i2 = sharedPreferences.getInt("key_auth_update_version", 0);
        i3 = sharedPreferences.getInt("_auth_uin", 0);
        string = sharedPreferences.getString("_auth_key", "");
        String string5 = sharedPreferences.getString("server_id", "");
        if (z && i2 == d.sYN && i3 == i && string.equals(str) && string5.equals(str2)) {
            this.iev.bIE();
            this.iev.set(1, Integer.valueOf(d.sYN));
            this.iev.set(2, Integer.valueOf(i));
            this.iev.set(3, str);
            this.iev.set(4, str2);
            this.iev.bKZ();
            String str3 = "MicroMsg.AutoAuth";
            String str4 = "summerauth save aak & id ok old vs new vs input[%b, %b, %b, %b] version[%d, %d, %d. %d], uin[%d, %d, %d, %d], aak[%s, %s, %s, %s], cookie[%s, %s, %s, %s]";
            Object[] objArr = new Object[20];
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(true);
            objArr[3] = Boolean.valueOf(!this.iev.uyZ);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Integer.valueOf(i2);
            objArr[6] = Integer.valueOf(d.sYN);
            objArr[7] = (Integer) this.iev.get(1);
            objArr[8] = Integer.valueOf(i5);
            objArr[9] = Integer.valueOf(i3);
            objArr[10] = Integer.valueOf(i);
            objArr[11] = (Integer) this.iev.get(2);
            objArr[12] = string2;
            objArr[13] = string;
            objArr[14] = str;
            objArr[15] = (String) this.iev.get(3);
            objArr[16] = string3;
            objArr[17] = string5;
            objArr[18] = str2;
            objArr[19] = (String) this.iev.get(4);
            w.i(str3, str4, objArr);
            return true;
        }
        w.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed check not equal so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(true), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(d.sYN), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i), string2, string, str, string3, string5, str2);
        w.bIP();
        return false;
    }

    final void a(q qVar, int i, int i2) {
        qVar.a(this.ier, i, i2);
    }

    public final void a(com.tencent.mm.protocal.ab abVar) {
        z.MP().ME();
    }

    public final byte[] Mx() {
        if (!this.ieq.BY()) {
            return null;
        }
        com.tencent.mm.protocal.aa.a aVar = new com.tencent.mm.protocal.aa.a();
        aVar.uin = this.ieq.uH();
        aVar.hKD = bg.PT(ab.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
        aVar.netType = com.tencent.mm.protocal.a.getNetType(ab.getContext());
        aVar.sZE = com.tencent.mm.protocal.a.bGY();
        try {
            byte[] zh = aVar.zh();
            this.gXJ = aVar.gXJ;
            return zh;
        } catch (Throwable e) {
            w.e("MicroMsg.AutoAuth", "exception:%s", bg.g(e));
            return null;
        }
    }

    public final int getHostByName(String str, List<String> list) {
        return MMLogic.getHostByName(str, list);
    }

    public final int a(boolean z, List<String> list) {
        return MMLogic.getSnsIpsForScene(list, z);
    }

    public final int a(String str, boolean z, List<String> list) {
        return MMLogic.getSnsIpsForSceneWithHostName(list, str, z);
    }

    public final String getIspId() {
        return MMLogic.getIspId();
    }

    public final void setHostInfo(final String[] strArr, final String[] strArr2, final int[] iArr) {
        this.iep.lock(1000, "MMAutoAuth.setHostInfo");
        new bb<Object>(this) {
            final /* synthetic */ s iey;

            protected final Object run() {
                MMLogic.setHostInfo(strArr, strArr2, iArr);
                return null;
            }
        }.b(this.handler);
    }

    public final int g(int i, byte[] bArr) {
        return ad.MV().h(i, bArr);
    }

    public final void a(int i, String str, int i2, boolean z) {
        this.iep.lock(1000, "MMAutoAuth.logUtil");
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        final boolean z2 = z;
        new bb<Object>(this) {
            final /* synthetic */ s iey;

            protected final Object run() {
                if (i3 == 3) {
                    Date date = new Date();
                    date.setTime(bg.Nz() - (86400000 * ((long) i4)));
                    MMLogic.uploadFile(e.hgv + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt", str2, "");
                } else if (i3 == 2) {
                    w.bIP();
                    MMLogic.uploadLog(new int[]{i4}, z2, str2, "");
                } else {
                    w.bIP();
                }
                return null;
            }
        }.b(this.handler);
    }

    public final void setSignallingStrategy(long j, long j2) {
        StnLogic.setSignallingStrategy(j, j2);
    }

    public final void keepSignalling() {
        StnLogic.keepSignalling();
    }

    public final void stopSignalling() {
        StnLogic.stopSignalling();
    }

    public final void a(n nVar) {
        z.MS().ifd = nVar;
    }

    public final void a(r rVar) {
        this.iew = rVar;
    }

    public final boolean My() {
        boolean z = false;
        if (this.iew != null) {
            try {
                z = this.iew.oc();
            } catch (RemoteException e) {
            }
        }
        return z;
    }

    public final void a(g gVar) {
        this.iex = gVar;
    }

    public final void reportFailIp(String str) {
        MMLogic.reportFailIp(str);
    }

    public final void hw(String str) {
        w.e("MicroMsg.AutoAuth", "killPush %s", str);
    }

    public final void ba(boolean z) {
        if (com.tencent.mm.sdk.b.a.urY == null) {
            w.w("MicroMsg.AutoAuth", "loginevent but eventpool null, event:" + z);
        } else if (z) {
            com.tencent.mm.sdk.b.a.urY.m(new av());
        } else {
            com.tencent.mm.sdk.b.a.urY.m(new go());
        }
    }

    public final h Cd() {
        return null;
    }

    public final void bb(boolean z) {
        bg.et(ab.getContext());
    }

    public final void bc(boolean z) {
        w.d("MicroMsg.AutoAuth", "summer setMMTLS enable[%b]", Boolean.valueOf(z));
        MMLogic.setMmtlsCtrlInfo(z);
    }

    public final void Ce() {
        StnLogic.makesureLongLinkConnected();
    }
}
