package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.Task;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.g.c;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av;
import com.tencent.mm.protocal.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;

public final class y {
    final a[] ifl = new a[100];

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int ifm;
        final /* synthetic */ int ifn;
        final /* synthetic */ y ifo;

        AnonymousClass1(y yVar, int i, int i2) {
            this.ifo = yVar;
            this.ifm = i;
            this.ifn = i2;
        }

        public final void run() {
            MMLogic.reportCGIServerError(this.ifm, this.ifn);
        }
    }

    private static class a {
        q ifp;
        k ifq;
        c ifr;
        long startTime;
        int taskId;
    }

    protected final void finalize() {
        reset();
        super.finalize();
    }

    final boolean MC() {
        synchronized (this.ifl) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.ifl[i] != null && (701 == this.ifl[i].ifp.getType() || 702 == this.ifl[i].ifp.getType())) {
                        w.w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i + " type=" + this.ifl[i].ifp.getType());
                        return true;
                    }
                } catch (Throwable e) {
                    this.ifl[i] = null;
                    w.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", bg.g(e), Integer.valueOf(i));
                }
                i++;
            }
            return false;
        }
    }

    final boolean MD() {
        synchronized (this.ifl) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.ifl[i] != null && 1000 == this.ifl[i].ifp.getType()) {
                        w.w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i + " type=" + this.ifl[i].ifp.getType());
                        return true;
                    }
                } catch (Throwable e) {
                    this.ifl[i] = null;
                    w.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", bg.g(e), Integer.valueOf(i));
                }
                i++;
            }
            return false;
        }
    }

    final q bz(boolean z) {
        synchronized (this.ifl) {
            int i = 0;
            q qVar = null;
            while (i < 100) {
                if (this.ifl[i] != null) {
                    if (z) {
                        try {
                            if (this.ifl[i].ifp instanceof com.tencent.mm.network.q.a) {
                                continue;
                            }
                        } catch (Throwable e) {
                            w.w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bg.g(e));
                        }
                    }
                    if (z || (this.ifl[i].ifp instanceof com.tencent.mm.network.q.a)) {
                        if (701 == this.ifl[i].ifp.getType() || 702 == this.ifl[i].ifp.getType()) {
                            w.e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i + " type=" + this.ifl[i].ifp.getType());
                            return null;
                        } else if (qVar == null) {
                            qVar = this.ifl[i].ifp;
                        } else {
                            continue;
                        }
                    }
                }
                i++;
            }
            return qVar;
        }
    }

    public final int ME() {
        int i = 0;
        for (int i2 = 0; i2 < 100; i2++) {
            try {
                if (this.ifl[i2] != null) {
                    this.ifl[i2].ifp.getType();
                }
            } catch (Throwable e) {
                w.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", bg.g(e), Integer.valueOf(i2));
                i++;
                this.ifl[i2] = null;
            }
        }
        return i;
    }

    public final int a(q qVar, k kVar, c cVar, int i) {
        if (qVar == null) {
            w.e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
            return -1;
        }
        int i2;
        qVar.hashCode();
        Task task = new Task();
        synchronized (this.ifl) {
            int i3 = 0;
            while (i3 < 100) {
                try {
                    if (this.ifl[i3] == null) {
                        this.ifl[i3] = new a();
                        this.ifl[i3].ifp = qVar;
                        this.ifl[i3].ifq = kVar;
                        this.ifl[i3].ifr = cVar;
                        this.ifl[i3].startTime = bg.Nz();
                        this.ifl[i3].taskId = task.taskID;
                        task.cmdID = qVar.Cm().getCmdId();
                        task.cgi = qVar.getUri();
                        int type = qVar.getType();
                        task.needAuthed = (qVar.BD() & 1) != 1;
                        if (type == 126 || type == 701 || type == 702) {
                            task.needAuthed = false;
                            if (type == 701) {
                                task.retryCount = 1;
                            }
                        }
                        task.limitFlow = true;
                        if (type == c.CTRL_INDEX || type == JsApiChooseMedia.CTRL_INDEX || type == 220 || type == 323 || type == 324 || type == 326 || type == 327) {
                            task.limitFlow = false;
                        }
                        task.channelStrategy = 0;
                        if (type == 233 || type == 835 || type == av.CTRL_BYTE) {
                            task.channelStrategy = 1;
                        }
                        task.sendOnly = false;
                        if (type == 10 || type == 268369922) {
                            task.sendOnly = true;
                        }
                        if (qVar.Cm().Cl() && qVar.getUri() != null && qVar.getUri().length() > 0) {
                            task.channelSelect |= 1;
                        }
                        if (task.cmdID != 0) {
                            task.channelSelect |= 2;
                        }
                        task.reportArg = String.valueOf(type);
                        if (type == 522) {
                            task.totalTimeout = 300000;
                            task.priority = 0;
                        }
                        if (type == 710) {
                            task.totalTimeout = 15000;
                            task.serverProcessCost = 0;
                        }
                        w.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", Integer.valueOf(i3), Integer.valueOf(task.taskID), Integer.valueOf(qVar.BM()), Integer.valueOf(task.channelSelect), task.cgi, Boolean.valueOf(task.needAuthed));
                        i2 = i3;
                    } else {
                        i3++;
                    }
                } catch (Throwable e) {
                    w.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bg.g(e));
                }
            }
            i2 = -1;
        }
        if (-1 != i2) {
            if (i == 1) {
                task.retryCount = 0;
            }
            StnLogic.startTask(task);
        } else {
            w.e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
        }
        w.d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=" + i2);
        return i2;
    }

    public final void reset() {
        w.i("MicroMsg.MMNativeNetTaskAdapter", "reset");
        StnLogic.reset();
        synchronized (this.ifl) {
            for (int i = 0; i < 100; i++) {
                if (this.ifl[i] != null) {
                    try {
                        w.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i), Integer.valueOf(this.ifl[i].ifp.getType()), Integer.valueOf(this.ifl[i].ifp.BM()));
                        this.ifl[i] = null;
                    } catch (Throwable e) {
                        w.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bg.g(e));
                    }
                }
            }
        }
    }

    public final void d(int i, int i2, String str) {
        w.i("MicroMsg.MMNativeNetTaskAdapter", "clearTaskAndCallback errType=" + i + ", errCode=" + i2 + ", errMsg=" + str);
        StnLogic.clearTask();
        a[] aVarArr = new a[100];
        synchronized (this.ifl) {
            for (int i3 = 0; i3 < 100; i3++) {
                aVarArr[i3] = this.ifl[i3];
                this.ifl[i3] = null;
            }
        }
        for (int i4 = 0; i4 < 100; i4++) {
            if (aVarArr[i4] != null) {
                try {
                    w.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi clearTaskAndCallback outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i4), Integer.valueOf(aVarArr[i4].ifp.getType()), Integer.valueOf(aVarArr[i4].ifp.BM()));
                    aVarArr[i4].ifq.a(i4, i, i2, str, aVarArr[i4].ifp, null);
                } catch (Throwable e) {
                    w.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bg.g(e));
                }
            }
        }
    }

    final int gW(int i) {
        int i2 = 0;
        synchronized (this.ifl) {
            int gX = gX(i);
            if (-1 == gX) {
                w.e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
            } else {
                try {
                    i2 = this.ifl[gX].ifp.Cn().Cq();
                } catch (Throwable e) {
                    w.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bg.g(e));
                }
            }
        }
        return i2;
    }

    final boolean a(int i, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        synchronized (this.ifl) {
            int gX = gX(i);
            if (-1 == gX) {
                return false;
            }
            boolean a;
            try {
                w.i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s", Integer.valueOf(i2), Boolean.valueOf(this.ifl[gX].ifr.Ca()), bg.bo(this.ifl[gX].ifr.BX()));
                this.ifl[gX].ifp.Cm().B(this.ifl[gX].ifr.vc());
                this.ifl[gX].ifp.Cm().dj(this.ifl[gX].ifr.uH());
                a = this.ifl[gX].ifp.Cm().a(this.ifl[gX].ifp.getType(), this.ifl[gX].ifr.vc(), this.ifl[gX].ifr.BX(), this.ifl[gX].ifr.BZ(), 0, this.ifl[gX].ifr.Ca());
                if (a) {
                    byteArrayOutputStream.write(this.ifl[gX].ifp.Cm().Cf());
                } else {
                    iArr[0] = 0;
                    com.tencent.mm.plugin.report.c.oTb.a(162, (long) iArr[0], 1, false);
                    w.e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
                }
            } catch (Throwable e) {
                iArr[0] = 1;
                com.tencent.mm.plugin.report.c.oTb.a(162, (long) iArr[0], 1, false);
                w.e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", bg.g(e));
                a = false;
            } catch (Throwable e2) {
                iArr[0] = 2;
                com.tencent.mm.plugin.report.c.oTb.a(162, (long) iArr[0], 1, false);
                w.e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", bg.g(e2));
                a = false;
            } catch (Throwable e22) {
                iArr[0] = 3;
                com.tencent.mm.plugin.report.c.oTb.a(162, (long) iArr[0], 1, false);
                w.e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", bg.g(e22));
                a = false;
            }
            w.d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", Boolean.valueOf(a));
            return a;
        }
    }

    final int a(int i, byte[] bArr, int[] iArr) {
        Throwable e;
        int i2 = -1;
        synchronized (this.ifl) {
            int gX = gX(i);
            if (-1 == gX) {
            } else {
                int i3 = StnLogic.RESP_FAIL_HANDLE_DEFAULT;
                try {
                    byte[] Cj = this.ifl[gX].ifp.Cm().Cj();
                    h Cn = this.ifl[gX].ifp.Cn();
                    if (Cn.a(this.ifl[gX].ifp.getType(), bArr, Cj)) {
                        if (!(Cn.BX() == null || -13 != Cn.Cq() || z.MO() == null)) {
                            z.MO().Mv();
                        }
                        if (-13 == Cn.Cq()) {
                            gX = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                            try {
                                iArr[0] = Cn.Cq();
                                i2 = gX;
                            } catch (RemoteException e2) {
                                e = e2;
                                i3 = gX;
                                com.tencent.mm.plugin.report.c.oTb.a(162, 5, 1, false);
                                w.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bg.g(e));
                                i2 = i3;
                                return i2;
                            } catch (Exception e3) {
                                e = e3;
                                i3 = gX;
                                com.tencent.mm.plugin.report.c.oTb.a(162, 7, 1, false);
                                w.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bg.g(e));
                                i2 = i3;
                                return i2;
                            }
                        } else if (-3002 == Cn.Cq() || -3003 == Cn.Cq()) {
                            gX = StnLogic.RESP_FAIL_HANDLE_TASK_END;
                            iArr[0] = Cn.Cq();
                            i2 = gX;
                        } else if (-3001 == Cn.Cq()) {
                            gX = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                            iArr[0] = Cn.Cq();
                            i2 = gX;
                        } else {
                            i2 = StnLogic.RESP_FAIL_HANDLE_NORMAL;
                        }
                    } else {
                        com.tencent.mm.plugin.report.c.oTb.a(162, 4, 1, false);
                        w.e("MicroMsg.MMNativeNetTaskAdapter", "buf to resp failed, change server and try again");
                        i2 = i3;
                    }
                } catch (RemoteException e4) {
                    e = e4;
                    com.tencent.mm.plugin.report.c.oTb.a(162, 5, 1, false);
                    w.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bg.g(e));
                    i2 = i3;
                    return i2;
                } catch (Exception e5) {
                    e = e5;
                    com.tencent.mm.plugin.report.c.oTb.a(162, 7, 1, false);
                    w.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bg.g(e));
                    i2 = i3;
                    return i2;
                }
            }
        }
        return i2;
    }

    final int gX(int i) {
        int i2 = 0;
        while (i2 < 100 && (this.ifl[i2] == null || i != this.ifl[i2].taskId)) {
            i2++;
        }
        if (100 <= i2) {
            return -1;
        }
        return i2;
    }
}
