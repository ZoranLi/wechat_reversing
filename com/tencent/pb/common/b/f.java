package com.tencent.pb.common.b;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.jsapi.map.k;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.pb.common.b.a.a.s;
import com.tencent.pb.common.b.a.a.t;
import com.tencent.pb.common.c.d;
import com.tencent.pb.talkroom.sdk.e;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.wecall.talkroom.model.h;
import java.util.Iterator;
import java.util.LinkedList;

public class f {
    private static f wLj = null;
    private int wLk;
    private LinkedList<a> wLl;
    public e wLm;
    private boolean wLn;
    private boolean wLo;

    private class a {
        int mTaskId;
        public String wLp;
        a wLq;
        c wLr;
        final /* synthetic */ f wLs;

        public a(f fVar) {
            this.wLs = fVar;
        }
    }

    private f() {
        this.wLk = 0;
        this.wLl = null;
        this.wLm = null;
        this.wLn = false;
        this.wLo = true;
        this.wLl = new LinkedList();
        this.wLo = true;
    }

    private static t bt(byte[] bArr) {
        try {
            return (t) com.google.a.a.e.a(new t(), bArr, bArr.length);
        } catch (Exception e) {
            d.k("NETCMD", "Exception genReadPackageData" + e.getMessage());
            return null;
        }
    }

    private int a(a aVar, c cVar, String str, int i, byte[] bArr, int i2, int i3, int i4) {
        byte[] bArr2;
        int ccS = ccS();
        byte[] bArr3 = null;
        try {
            s sVar;
            if (bArr.length < m.CTRL_INDEX || bArr == null || bArr.length >= bArr.length) {
                sVar = new s();
                sVar.ou = i;
                sVar.wMR = ccS;
                sVar.userName = com.tencent.pb.b.a.a.cdm();
                sVar.wLL = i4;
            } else {
                sVar = new s();
                sVar.ou = i;
                sVar.wMR = ccS;
                sVar.userName = com.tencent.pb.b.a.a.cdm();
                sVar.wLL = i4;
            }
            if (bArr == null) {
                d.k("NETCMD", "body null");
                bArr3 = null;
            } else {
                com.google.a.a.e tVar = new t();
                tVar.wMT = sVar;
                tVar.body = bArr;
                bArr3 = com.google.a.a.e.b(tVar);
            }
            bArr2 = bArr3;
        } catch (Exception e) {
            d.k("NetError", "newTaskHelper addTask body null");
            bArr2 = bArr3;
        }
        if (bArr2 == null) {
            d.k("NETCMD", "cmd:" + i + "|body is null");
            return -1;
        } else if (bArr2.length > 61440) {
            d.k("NETCMD", "cmd:" + i + "|body too large");
            return -1;
        } else {
            a aVar2 = new a(this);
            aVar2.mTaskId = ccS;
            aVar2.wLq = aVar;
            aVar2.wLr = cVar;
            aVar2.wLp = str;
            synchronized (this.wLl) {
                this.wLl.add(aVar2);
            }
            int i5 = 1933;
            switch (i) {
                case w.CTRL_INDEX /*139*/:
                    i5 = 1918;
                    break;
                case k.CTRL_INDEX /*141*/:
                    i5 = 1919;
                    break;
                case 143:
                    i5 = 1927;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX /*145*/:
                    i5 = 1931;
                    break;
                case 147:
                    i5 = 1932;
                    break;
                case 181:
                    i5 = 1929;
                    break;
                case 183:
                    i5 = 1928;
                    break;
                case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.CTRL_BYTE /*189*/:
                    i5 = 1935;
                    break;
                case g.CTRL_INDEX /*211*/:
                    i5 = 1937;
                    break;
                case 221:
                    i5 = 1938;
                    break;
                case 223:
                    i5 = 1939;
                    break;
            }
            d.d("NETCMD", "CLTSEND|", Integer.valueOf(ccS), Integer.valueOf(i5), str, com.tencent.pb.b.a.a.cdm());
            if (this.wLm != null) {
                this.wLm.b(ccS, i5, bArr2);
            }
            return ccS;
        }
    }

    private int ccS() {
        int i;
        synchronized (this.wLl) {
            this.wLk++;
            i = this.wLk;
        }
        return i;
    }

    public final a CO(int i) {
        a aVar;
        synchronized (this.wLl) {
            Iterator it = this.wLl.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.mTaskId == i) {
                    break;
                }
            }
            aVar = null;
        }
        return aVar;
    }

    public static f ccT() {
        if (wLj == null) {
            synchronized (f.class) {
                if (wLj == null) {
                    wLj = new f();
                }
            }
        }
        return wLj;
    }

    final int a(a aVar, c cVar, int i, String str, byte[] bArr, int i2) {
        if (!this.wLo) {
            d.k("NETCMD", "doSendTask mIsInitSucc is false");
            return -1;
        } else if (this.wLn) {
            d.k("NETCMD", "doSendTask fail: isRefreshing, cmd=" + i + ", cmdTag=" + str);
            return -1;
        } else {
            try {
                return a(aVar, cVar, str, i, bArr, 0, 0, i2);
            } catch (Throwable th) {
                d.k("NETCMD", "Exception doSendTask", th);
                return -1;
            }
        }
    }

    public final int a(a aVar, String str, com.google.a.a.e eVar) {
        try {
            return a(aVar, null, 31, str, com.google.a.a.e.b(eVar), 0);
        } catch (Exception e) {
            d.k("NETCMD", "doSendTask exception:", e);
            return -1;
        }
    }

    public static int bu(byte[] bArr) {
        if (bArr == null) {
            d.k("NETCMD", "CLTNOT onNotify1 data == null ", Integer.valueOf(0));
            h.Eg(-1601);
            if (TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.chg().mwM) && TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.chg().xka)) {
                h.a(com.tencent.wecall.talkroom.model.a.chg().mUm, com.tencent.wecall.talkroom.model.a.chg().xkb, "notify", "datanull");
            } else {
                com.tencent.wecall.talkroom.model.a.chg().xkj.N("notify", "datanull");
            }
            return -1;
        }
        d.d("NETCMD", "CLTNOT onNotify data len=", Integer.valueOf(bArr.length));
        return com.tencent.wecall.talkroom.model.a.chg().bH(bArr);
    }

    public final void a(a aVar, int i, byte[] bArr) {
        try {
            if (aVar.wLr != null) {
                aVar.wLr.n(i, bArr);
            }
            if (aVar.wLq != null) {
                aVar.wLq.df(aVar.wLp, i);
            }
        } catch (Exception e) {
            d.k("NETCMD", "postRespData", e.getMessage());
        }
        synchronized (this.wLl) {
            this.wLl.remove(aVar);
        }
    }

    public final int o(int i, byte[] bArr) {
        a CO = CO(i);
        if (CO != null || DownloadResult.CODE_UNDEFINED == i) {
            t bt = bt(bArr);
            if (bt == null || bt.wMT == null) {
                String str;
                String str2 = "NETCMD";
                Object[] objArr = new Object[2];
                objArr[0] = " pack.head: ";
                if (bt == null) {
                    str = " pack is null ";
                } else {
                    str = " head is " + bt.wMT;
                }
                objArr[1] = str;
                d.k(str2, objArr);
                a(CO, -3, null);
                return -1;
            }
            int i2 = bt.wMT.ret;
            int i3 = bt.wMT.wMS;
            String str3 = bt.wMT.userName;
            if (com.tencent.pb.common.a.a.wKz) {
                Toast.makeText(com.tencent.pb.common.c.e.rof, "retCode: " + i2 + " debugCode: " + i3, 0).show();
            }
            if (i2 != 0 && CO != null) {
                d.k("NETCMD", "CLTRCV", Integer.valueOf(i), CO.wLp, Integer.valueOf(i2), str3, Integer.valueOf(i3));
            } else if (CO != null) {
                d.d("NETCMD", "CLTRCV", Integer.valueOf(i), CO.wLp, Integer.valueOf(i2), str3, Integer.valueOf(i3));
            }
            byte[] bArr2 = bt.body;
            if (bArr2 != null) {
                a(CO, i2, bArr2);
                return 0;
            }
            a(CO, i2, null);
            return 0;
        }
        d.k("NETCMD", "buf2Resp fail: taskId:" + i + " not found");
        com.tencent.pb.common.c.h.w(20007, 3, "-1202");
        return 1;
    }
}
