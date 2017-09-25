package com.tencent.mm.y;

import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.b;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class v {
    private b hua = null;
    private long hub = 0;

    class a extends oicq.wlogin_sdk.tools.b {
        final /* synthetic */ v huc;

        public a(v vVar) {
            this.huc = vVar;
        }

        public final void o(int i, String str) {
            e(i, "", str);
        }

        public final void e(int i, String str, String str2) {
            if (i == 1) {
                w.i("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
            } else if (i == 2) {
                w.d("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
            } else if (i == 0) {
                w.w("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
            }
        }
    }

    public v() {
        try {
            long Nz = bg.Nz();
            this.hua = new b(ab.getContext(), d.sYN);
            util.xpg = 1;
            util.xph = new a(this);
            w.d("MicroMsg.WtloginMgr", "dkstart wtlogin init :%d", Long.valueOf(bg.aA(Nz)));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.WtloginMgr", e, "Failed initializing WtloginMgr.", new Object[0]);
        }
    }

    public final byte[] a(long j, String str, boolean z) {
        String str2 = "MicroMsg.WtloginMgr";
        String str3 = "dkwt isTestWtLogin:%b val:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(r.iiW == 10006);
        objArr[1] = Integer.valueOf(r.iiX);
        w.d(str2, str3, objArr);
        if (r.iiW == 10006) {
            if (r.iiX == 1) {
                r.iiX = 0;
                return new byte[0];
            } else if (r.iiX == 2) {
                return new byte[0];
            }
        }
        try {
            boolean z2;
            this.hub = j;
            byte[] a = z ? null : this.hua.a(j, oicq.wlogin_sdk.request.b.a.USER_WITH_A1, "");
            str3 = "MicroMsg.WtloginMgr";
            String str4 = "dkwt getReqLoginBuf sig:%d uin:%d manualauth:%b  byA1Buf:%b ";
            Object[] objArr2 = new Object[4];
            objArr2[0] = Integer.valueOf(8256);
            objArr2[1] = Long.valueOf(j);
            objArr2[2] = Boolean.valueOf(z);
            if (bg.bm(a)) {
                z2 = false;
            } else {
                z2 = true;
            }
            objArr2[3] = Boolean.valueOf(z2);
            w.d(str3, str4, objArr2);
            if (bg.bm(a)) {
                return this.hua.a(j, oicq.wlogin_sdk.request.b.a.USER_WITH_MD5, new String(bg.PT(str), "ISO-8859-1"));
            }
            return a;
        } catch (Throwable e) {
            w.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf e:%s", e.getMessage());
            w.e("MicroMsg.WtloginMgr", "exception:%s", bg.g(e));
            return new byte[0];
        }
    }

    public final boolean a(long j, byte[] bArr) {
        if (j != this.hub) {
            w.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.hub), Long.valueOf(j));
            return false;
        } else if (bg.bm(bArr)) {
            w.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf respBuf is null.");
            return false;
        } else {
            try {
                int i;
                b bVar = this.hua;
                if (bArr == null || bArr.length == 0 || bVar.xmR == null) {
                    i = -1017;
                } else {
                    util.Wt("user:" + bVar.xmL._uin + " ResolveSvrData ...");
                    i = bVar.xmR.F(bArr, bArr.length);
                    if (i == 1) {
                        bVar.fg(bVar.xmL._uin);
                    }
                    util.Wt("user:" + bVar.xmL._uin + " ResolveSvrData ret=" + i);
                }
                w.d("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf buflen:%d ret:%d", Integer.valueOf(bArr.length), Integer.valueOf(i));
                if (i == 0) {
                    return true;
                }
                return false;
            } catch (Throwable e) {
                w.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf e:%s", e.getMessage());
                w.e("MicroMsg.WtloginMgr", "exception:%s", bg.g(e));
                return false;
            }
        }
    }

    public final byte[] R(long j) {
        if (j != this.hub) {
            w.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.hub), Long.valueOf(j));
            return new byte[0];
        }
        try {
            return this.hua.ff(j);
        } catch (Throwable e) {
            w.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg e:%s", e.getMessage());
            w.e("MicroMsg.WtloginMgr", "exception:%s", bg.g(e));
            return new byte[0];
        }
    }

    public final byte[] b(long j, String str) {
        if (j != this.hub) {
            w.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.hub), Long.valueOf(j));
            return new byte[0];
        }
        byte[] bytes;
        if (bg.mA(str)) {
            bytes = "****".getBytes();
        } else {
            bytes = str.getBytes();
        }
        try {
            return this.hua.f(j, bytes);
        } catch (Throwable e) {
            w.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg e:%s", e.getMessage());
            w.e("MicroMsg.WtloginMgr", "exception:%s", bg.g(e));
            return new byte[0];
        }
    }

    public final byte[] S(long j) {
        if (j != this.hub) {
            w.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.hub), Long.valueOf(j));
            return new byte[0];
        }
        try {
            WUserSigInfo wUserSigInfo;
            WloginSigInfo y = this.hua.xmL.y(j, 522017402);
            if (y == null) {
                wUserSigInfo = null;
            } else {
                wUserSigInfo = new WUserSigInfo();
                wUserSigInfo.get_clone(y);
            }
            return wUserSigInfo == null ? new byte[0] : wUserSigInfo._A2;
        } catch (Throwable e) {
            w.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf e:%s", e.getMessage());
            w.e("MicroMsg.WtloginMgr", "exception:%s", bg.g(e));
            return new byte[0];
        }
    }

    public final void T(long j) {
        if (j != this.hub) {
            w.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.hub), Long.valueOf(j));
            return;
        }
        try {
            this.hua.fg(j);
        } catch (Throwable e) {
            w.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo e:%s", e.getMessage());
            w.e("MicroMsg.WtloginMgr", "exception:%s", bg.g(e));
        }
    }
}
