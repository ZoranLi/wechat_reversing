package oicq.wlogin_sdk.request;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.tools.util;

public final class b {
    private static /* synthetic */ int[] xmU;
    private Context mContext = null;
    public i xmL = new i();
    private j xmM = new j(this.xmL);
    private f xmN = new f(this.xmL);
    private g xmO = new g(this.xmL);
    private h xmP = new h(this.xmL);
    private e xmQ = new e(this.xmL);
    public d xmR = null;
    private int xmS = 66560;
    private int xmT = 1404;

    public enum a {
        USER_WITH_PWD,
        USER_WITH_MD5,
        USER_WITH_A1
    }

    private static /* synthetic */ int[] cik() {
        int[] iArr = xmU;
        if (iArr == null) {
            iArr = new int[a.values().length];
            try {
                iArr[a.USER_WITH_A1.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[a.USER_WITH_MD5.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[a.USER_WITH_PWD.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            xmU = iArr;
        }
        return iArr;
    }

    public b(Context context, int i) {
        this.mContext = context;
        i iVar = this.xmL;
        iVar.xmZ = context;
        iVar.xnA = i;
        iVar.xnU = new c(context);
        Object obj = new byte[16];
        iVar.xnr.nextBytes(obj);
        System.arraycopy(obj, 0, iVar.xnu, 0, 16);
        cij();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a(long r16, oicq.wlogin_sdk.request.b.a r18, java.lang.String r19) {
        /*
        r15 = this;
        r2 = new java.lang.StringBuilder;
        r3 = "wtlogin login with GetStWithPasswd:user:";
        r2.<init>(r3);
        r0 = r16;
        r2 = r2.append(r0);
        r3 = " appid:522017402 dwSigMap:8256";
        r2 = r2.append(r3);
        r3 = " ...";
        r2 = r2.append(r3);
        r2 = r2.toString();
        oicq.wlogin_sdk.tools.util.Wt(r2);
        r2 = r19.length();
        r3 = 16;
        if (r2 <= r3) goto L_0x0034;
    L_0x002b:
        r2 = 0;
        r3 = 16;
        r0 = r19;
        r19 = r0.substring(r2, r3);
    L_0x0034:
        monitor-enter(r15);
        r2 = cik();	 Catch:{ all -> 0x01a0 }
        r3 = r18.ordinal();	 Catch:{ all -> 0x01a0 }
        r2 = r2[r3];	 Catch:{ all -> 0x01a0 }
        switch(r2) {
            case 1: goto L_0x0045;
            case 2: goto L_0x00d4;
            case 3: goto L_0x00ff;
            default: goto L_0x0042;
        };	 Catch:{ all -> 0x01a0 }
    L_0x0042:
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        r2 = 0;
    L_0x0044:
        return r2;
    L_0x0045:
        if (r19 == 0) goto L_0x004d;
    L_0x0047:
        r2 = r19.length();	 Catch:{ all -> 0x01a0 }
        if (r2 != 0) goto L_0x0056;
    L_0x004d:
        r2 = "USER_WITH_PWD userPasswd null";
        oicq.wlogin_sdk.tools.util.Wt(r2);	 Catch:{ all -> 0x01a0 }
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        r2 = 0;
        goto L_0x0044;
    L_0x0056:
        r9 = oicq.wlogin_sdk.tools.c.Wr(r19);	 Catch:{ all -> 0x01a0 }
        r2 = 0;
    L_0x005b:
        r3 = r15.xmL;	 Catch:{ all -> 0x01a0 }
        r4 = r15.mContext;	 Catch:{ all -> 0x01a0 }
        r4 = oicq.wlogin_sdk.tools.util.hR(r4);	 Catch:{ all -> 0x01a0 }
        r3.xnE = r4;	 Catch:{ all -> 0x01a0 }
        r3 = r15.xmL;	 Catch:{ all -> 0x01a0 }
        r4 = r15.mContext;	 Catch:{ all -> 0x01a0 }
        r4 = oicq.wlogin_sdk.tools.util.hU(r4);	 Catch:{ all -> 0x01a0 }
        r4 = r4.getBytes();	 Catch:{ all -> 0x01a0 }
        r3.xnG = r4;	 Catch:{ all -> 0x01a0 }
        r3 = r15.xmL;	 Catch:{ all -> 0x01a0 }
        r0 = r16;
        r3._uin = r0;	 Catch:{ all -> 0x01a0 }
        r3 = r15.xmL;	 Catch:{ all -> 0x01a0 }
        r4 = 522017402; // 0x1f1d5a7a float:3.3320884E-20 double:2.57910865E-315;
        r3.xnx = r4;	 Catch:{ all -> 0x01a0 }
        r3 = r15.xmL;	 Catch:{ all -> 0x01a0 }
        r4 = 8256; // 0x2040 float:1.1569E-41 double:4.079E-320;
        r3.xny = r4;	 Catch:{ all -> 0x01a0 }
        r3 = r15.xmL;	 Catch:{ all -> 0x01a0 }
        r4 = new oicq.wlogin_sdk.a.f;	 Catch:{ all -> 0x01a0 }
        r4.<init>();	 Catch:{ all -> 0x01a0 }
        r3.xnv = r4;	 Catch:{ all -> 0x01a0 }
        r3 = r15.xmM;	 Catch:{ all -> 0x01a0 }
        r15.xmR = r3;	 Catch:{ all -> 0x01a0 }
        if (r2 == 0) goto L_0x017a;
    L_0x0095:
        r3 = r15.xmM;	 Catch:{ all -> 0x01a0 }
        r4 = 522017402; // 0x1f1d5a7a float:3.3320884E-20 double:2.57910865E-315;
        r2 = r15.xmL;	 Catch:{ all -> 0x01a0 }
        r8 = r2.xnS;	 Catch:{ all -> 0x01a0 }
        r10 = r15.xmT;	 Catch:{ all -> 0x01a0 }
        r11 = r15.xmS;	 Catch:{ all -> 0x01a0 }
        r12 = 8256; // 0x2040 float:1.1569E-41 double:4.079E-320;
        r2 = r15.xmL;	 Catch:{ all -> 0x01a0 }
        r13 = r2.xnP;	 Catch:{ all -> 0x01a0 }
        r6 = r16;
        r2 = r3.a(r4, r6, r8, r9, r10, r11, r12, r13);	 Catch:{ all -> 0x01a0 }
    L_0x00ae:
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        r3 = new java.lang.StringBuilder;
        r4 = "wtlogin login with GetStWithPasswd:user:";
        r3.<init>(r4);
        r0 = r16;
        r3 = r3.append(r0);
        r4 = " appid:522017402 dwSigMap:8256";
        r3 = r3.append(r4);
        r4 = " end";
        r3 = r3.append(r4);
        r3 = r3.toString();
        oicq.wlogin_sdk.tools.util.Wt(r3);
        goto L_0x0044;
    L_0x00d4:
        if (r19 == 0) goto L_0x00dc;
    L_0x00d6:
        r2 = r19.length();	 Catch:{ all -> 0x01a0 }
        if (r2 != 0) goto L_0x00e6;
    L_0x00dc:
        r2 = "USER_WITH_MD5 userPasswd null";
        oicq.wlogin_sdk.tools.util.Wt(r2);	 Catch:{ all -> 0x01a0 }
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        r2 = 0;
        goto L_0x0044;
    L_0x00e6:
        r2 = "ISO-8859-1";
        r0 = r19;
        r2 = r0.getBytes(r2);	 Catch:{ Exception -> 0x00fa }
        r2 = r2.clone();	 Catch:{ Exception -> 0x00fa }
        r2 = (byte[]) r2;	 Catch:{ Exception -> 0x00fa }
        r3 = 0;
        r9 = r2;
        r2 = r3;
        goto L_0x005b;
    L_0x00fa:
        r2 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        r2 = 0;
        goto L_0x0044;
    L_0x00ff:
        r2 = r15.xmL;	 Catch:{ all -> 0x01a0 }
        r4 = 522017402; // 0x1f1d5a7a float:3.3320884E-20 double:2.57910865E-315;
        r0 = r16;
        r2 = r2.y(r0, r4);	 Catch:{ all -> 0x01a0 }
        if (r2 == 0) goto L_0x0115;
    L_0x010c:
        r3 = r2._en_A1;	 Catch:{ all -> 0x01a0 }
        if (r3 == 0) goto L_0x0115;
    L_0x0110:
        r3 = r2._en_A1;	 Catch:{ all -> 0x01a0 }
        r3 = r3.length;	 Catch:{ all -> 0x01a0 }
        if (r3 > 0) goto L_0x014a;
    L_0x0115:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01a0 }
        r3 = "userAccount:";
        r2.<init>(r3);	 Catch:{ all -> 0x01a0 }
        r0 = r16;
        r2 = r2.append(r0);	 Catch:{ all -> 0x01a0 }
        r3 = " appid:522017402";
        r2 = r2.append(r3);	 Catch:{ all -> 0x01a0 }
        r3 = " GetA1ByAccount return: null";
        r2 = r2.append(r3);	 Catch:{ all -> 0x01a0 }
        r2 = r2.toString();	 Catch:{ all -> 0x01a0 }
        oicq.wlogin_sdk.tools.util.Wt(r2);	 Catch:{ all -> 0x01a0 }
        r9 = 0;
    L_0x0139:
        if (r9 == 0) goto L_0x0140;
    L_0x013b:
        r2 = r9.length;	 Catch:{ all -> 0x01a0 }
        r3 = 16;
        if (r2 >= r3) goto L_0x0177;
    L_0x0140:
        r2 = "USER_WITH_A1 tmp_pwd null";
        oicq.wlogin_sdk.tools.util.Wt(r2);	 Catch:{ all -> 0x01a0 }
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        r2 = 0;
        goto L_0x0044;
    L_0x014a:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01a0 }
        r4 = "userAccount:";
        r3.<init>(r4);	 Catch:{ all -> 0x01a0 }
        r0 = r16;
        r3 = r3.append(r0);	 Catch:{ all -> 0x01a0 }
        r4 = " appid:522017402";
        r3 = r3.append(r4);	 Catch:{ all -> 0x01a0 }
        r4 = " GetA1ByAccount return: not null";
        r3 = r3.append(r4);	 Catch:{ all -> 0x01a0 }
        r3 = r3.toString();	 Catch:{ all -> 0x01a0 }
        oicq.wlogin_sdk.tools.util.Wt(r3);	 Catch:{ all -> 0x01a0 }
        r2 = r2._en_A1;	 Catch:{ all -> 0x01a0 }
        r2 = r2.clone();	 Catch:{ all -> 0x01a0 }
        r2 = (byte[]) r2;	 Catch:{ all -> 0x01a0 }
        r9 = r2;
        goto L_0x0139;
    L_0x0177:
        r2 = 1;
        goto L_0x005b;
    L_0x017a:
        r2 = 4;
        r8 = new byte[r2];	 Catch:{ all -> 0x01a0 }
        r2 = 0;
        r4 = oicq.wlogin_sdk.request.i.cin();	 Catch:{ all -> 0x01a0 }
        oicq.wlogin_sdk.tools.util.c(r8, r2, r4);	 Catch:{ all -> 0x01a0 }
        r2 = r15.xmM;	 Catch:{ all -> 0x01a0 }
        r3 = 522017402; // 0x1f1d5a7a float:3.3320884E-20 double:2.57910865E-315;
        r5 = r15.xmL;	 Catch:{ all -> 0x01a0 }
        r7 = r5.xnS;	 Catch:{ all -> 0x01a0 }
        r10 = r15.xmT;	 Catch:{ all -> 0x01a0 }
        r11 = r15.xmS;	 Catch:{ all -> 0x01a0 }
        r12 = 8256; // 0x2040 float:1.1569E-41 double:4.079E-320;
        r5 = r15.xmL;	 Catch:{ all -> 0x01a0 }
        r13 = r5.xnP;	 Catch:{ all -> 0x01a0 }
        r5 = r16;
        r2 = r2.a(r3, r5, r7, r8, r9, r10, r11, r12, r13);	 Catch:{ all -> 0x01a0 }
        goto L_0x00ae;
    L_0x01a0:
        r2 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: oicq.wlogin_sdk.request.b.a(long, oicq.wlogin_sdk.request.b$a, java.lang.String):byte[]");
    }

    public final byte[] f(long j, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        byte[] bL;
        util.Wt("user:" + j + " CheckPicture ...");
        synchronized (this) {
            this.xmR = this.xmO;
            bL = this.xmO.bL(bArr);
        }
        util.Wt("user:" + j + " CheckPicture end");
        return bL;
    }

    public final byte[] ff(long j) {
        Object obj;
        synchronized (this) {
            g gVar = this.xmL.xnw;
            obj = new byte[gVar.xoh];
            if (gVar.xoh > 0) {
                System.arraycopy(gVar.xnh, gVar.xoj, obj, 0, gVar.xoh);
            }
        }
        util.Wt("user:" + j + " GetPicture data len:" + obj.length);
        return obj;
    }

    public final void fg(long j) {
        util.Wt("user:" + j + " ClearUserSigInfo");
        this.xmL.i(Long.valueOf(j));
    }

    private int cij() {
        synchronized (this) {
            Object hW = util.hW(this.mContext);
            if (hW == null || hW.length <= 0) {
                hW = util.hP(this.mContext);
                if (hW == null || hW.length <= 0) {
                    hW = new String("%4;7t>;28<fc.5*6").getBytes();
                    this.xmL.xnN = 0;
                } else {
                    this.xmL.xnN = 1;
                }
                util.b(this.mContext, hW);
                this.xmL.xnM = 1;
                this.xmL.xnO = 1;
            } else {
                this.xmL.xnN = 1;
                this.xmL.xnM = 0;
                this.xmL.xnO = 0;
            }
            this.xmL.xnB = new byte[hW.length];
            System.arraycopy(hW, 0, this.xmL.xnB, 0, hW.length);
            Object obj = new byte[(hW.length + 1)];
            obj[0] = (byte) 35;
            System.arraycopy(hW, 0, obj, 1, hW.length);
            this.xmL.xns = util.bT(obj);
            i.xnC = (byte[]) this.xmL.xnB.clone();
            this.xmL.xnD = util.hQ(this.mContext);
            int hS = util.hS(this.mContext);
            this.xmL.xnE = util.hR(this.mContext);
            if (hS != this.xmL.xnE) {
                util.hT(this.mContext);
                util.an(this.mContext, this.xmL.xnE);
            }
            this.xmL.xnG = util.hU(this.mContext).getBytes();
            this.xmL.xnP = util.hV(this.mContext);
            this.xmL.xnF = util.hX(this.mContext);
            this.xmL.xnI = util.bO(this.mContext, new String(this.xmL.xnF));
            this.xmL.xnJ = util.bP(this.mContext, new String(this.xmL.xnF));
            String str = Build.MODEL;
            if (str == null) {
                this.xmL.xnK = new byte[0];
            } else {
                this.xmL.xnK = str.getBytes();
            }
            if (util.isFileExist("/system/bin/su") || util.isFileExist("/system/xbin/su") || util.isFileExist("/sbin/su")) {
                hS = 1;
            } else {
                hS = 0;
            }
            i iVar = this.xmL;
            if (hS != 0) {
                hS = 1;
            } else {
                hS = 0;
            }
            iVar.xnL = hS;
            str = VERSION.RELEASE;
            if (str == null) {
                str = "";
            }
            util.Wt("WtloginHelper init ok: android version:" + str + " release time:" + util.ciz());
        }
        return 0;
    }
}
