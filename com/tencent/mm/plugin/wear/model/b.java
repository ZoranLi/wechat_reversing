package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.e.a.sk;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class b implements e {
    com.tencent.mm.sdk.e.m.b maN = new com.tencent.mm.sdk.e.m.b(this) {
        final /* synthetic */ b rTB;

        {
            this.rTB = r1;
        }

        public final void a(int i, m mVar, Object obj) {
            if (obj == null || !(obj instanceof String)) {
                w.d("MicroMsg.Wear.WearBizLogic", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
                return;
            }
            String str = (String) obj;
            if (str != null && str.equals("gh_43f2581f6fd6")) {
                if (!b.bvH() && this.rTB.rTy) {
                    this.rTB.rTy = false;
                } else if (b.bvH() && !this.rTB.rTy) {
                    this.rTB.connect();
                }
            }
        }
    };
    aj rTA = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ b rTB;

        {
            this.rTB = r1;
        }

        public final boolean oQ() {
            b.a(a.bvG().rTo.rTF.rUt);
            return true;
        }
    }, true);
    public boolean rTy;
    c rTz = new c<sk>(this) {
        final /* synthetic */ b rTB;

        {
            this.rTB = r2;
            this.usg = sk.class.getName().hashCode();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b r10) {
            /*
            r9 = this;
            r8 = 2;
            r7 = 1;
            r6 = 0;
            r10 = (com.tencent.mm.e.a.sk) r10;
            r0 = r10 instanceof com.tencent.mm.e.a.sk;
            if (r0 == 0) goto L_0x0010;
        L_0x0009:
            r0 = r10.gac;
            r0 = r0.fEG;
            switch(r0) {
                case 2: goto L_0x0011;
                case 3: goto L_0x0010;
                case 4: goto L_0x0010;
                case 5: goto L_0x0062;
                case 6: goto L_0x007e;
                case 7: goto L_0x0010;
                case 8: goto L_0x0038;
                case 9: goto L_0x0032;
                default: goto L_0x0010;
            };
        L_0x0010:
            return r6;
        L_0x0011:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "receive register response, deviceId=%s | isSuccess=%b";
            r2 = new java.lang.Object[r8];
            r3 = r10.gac;
            r3 = r3.fwJ;
            r2[r6] = r3;
            r3 = r10.gac;
            r3 = r3.fHO;
            r3 = java.lang.Boolean.valueOf(r3);
            r2[r7] = r3;
            com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
            r0 = r10.gac;
            r0 = r0.fHO;
            if (r0 == 0) goto L_0x0010;
        L_0x0032:
            r0 = r9.rTB;
            r0.connect();
            goto L_0x0010;
        L_0x0038:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "receive auth response, deviceId=%s | isSuccess=%b";
            r2 = new java.lang.Object[r8];
            r3 = r10.gac;
            r3 = r3.fwJ;
            r2[r6] = r3;
            r3 = r10.gac;
            r3 = r3.fHO;
            r3 = java.lang.Boolean.valueOf(r3);
            r2[r7] = r3;
            com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
            r0 = r9.rTB;
            r1 = r10.gac;
            r1 = r1.fHO;
            r0.rTy = r1;
            r0 = r9.rTB;
            r0 = r0.rTy;
            if (r0 == 0) goto L_0x0010;
        L_0x0061:
            goto L_0x0032;
        L_0x0062:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "receive send response, deviceId=%s | isSuccess=%b";
            r2 = new java.lang.Object[r8];
            r3 = r10.gac;
            r3 = r3.fwJ;
            r2[r6] = r3;
            r3 = r10.gac;
            r3 = r3.fHO;
            r3 = java.lang.Boolean.valueOf(r3);
            r2[r7] = r3;
            com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
            goto L_0x0010;
        L_0x007e:
            r0 = com.tencent.mm.plugin.wear.model.a.bvG();
            r0 = r0.rTo;
            r0 = r0.rTF;
            r0 = r0.rUt;
            if (r0 == 0) goto L_0x0096;
        L_0x008a:
            r0 = r0.umA;
            r1 = r10.gac;
            r1 = r1.fwJ;
            r0 = r0.equals(r1);
            if (r0 != 0) goto L_0x00a1;
        L_0x0096:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "request is null or request.LocalNodeId is not same!";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);
            goto L_0x0010;
        L_0x00a1:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "request step count deviceId=%s";
            r2 = new java.lang.Object[r7];
            r3 = r10.gac;
            r3 = r3.fwJ;
            r2[r6] = r3;
            com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
            r0 = r9.rTB;
            r1 = r10.gac;
            r1 = r1.fwJ;
            r1 = com.tencent.mm.plugin.wear.model.b.IB(r1);
            r2 = com.tencent.mm.plugin.wear.model.b.bvH();
            if (r1 == 0) goto L_0x00d8;
        L_0x00c2:
            r3 = r0.rTy;
            if (r3 == 0) goto L_0x00d8;
        L_0x00c6:
            if (r2 == 0) goto L_0x00d8;
        L_0x00c8:
            r1 = com.tencent.mm.plugin.wear.model.a.bvG();
            r1 = r1.rTu;
            r2 = new com.tencent.mm.plugin.wear.model.b$2;
            r2.<init>(r0);
            r1.a(r2);
            goto L_0x0010;
        L_0x00d8:
            r3 = "MicroMsg.Wear.WearBizLogic";
            r4 = "isRegister=%b | isFocus=%b | isAuth=%b";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r1 = java.lang.Boolean.valueOf(r1);
            r5[r6] = r1;
            r1 = java.lang.Boolean.valueOf(r2);
            r5[r7] = r1;
            r0 = r0.rTy;
            r0 = java.lang.Boolean.valueOf(r0);
            r5[r8] = r0;
            com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);
            goto L_0x0010;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wear.model.b.1.a(com.tencent.mm.sdk.b.b):boolean");
        }
    };

    private class a extends d {
        final /* synthetic */ b rTB;

        public a(b bVar) {
            this.rTB = bVar;
        }

        public final void execute() {
            ap.vd().a(30, this.rTB);
            List linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            List linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(1));
            ap.vd().a(new n(1, linkedList, linkedList2, "", ""), 0);
        }

        public final String getName() {
            return "AddContactTask";
        }
    }

    private class b extends d {
        final /* synthetic */ b rTB;
        private bnp rTC;

        public b(b bVar, bnp com_tencent_mm_protocal_c_bnp) {
            this.rTB = bVar;
            this.rTC = com_tencent_mm_protocal_c_bnp;
        }

        public final void execute() {
            ap.vd().a(1091, this.rTB);
            ap.vd().a(new com.tencent.mm.plugin.wear.model.d.a(this.rTC.umA, "gh_43f2581f6fd6"), 0);
        }

        public final String getName() {
            return "RegisterDeviceTask";
        }
    }

    public b() {
        com.tencent.mm.sdk.b.a.urY.b(this.rTz);
        ap.yY();
        com.tencent.mm.u.c.wR().a(this.maN);
    }

    public final void connect() {
        bnp com_tencent_mm_protocal_c_bnp = a.bvG().rTo.rTF.rUt;
        if (com_tencent_mm_protocal_c_bnp == null) {
            w.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
        } else if (!bvH()) {
            ap.yY();
            w.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", new Object[]{Boolean.valueOf(((Boolean) com.tencent.mm.u.c.vr().get(327825, Boolean.valueOf(false))).booleanValue())});
            if (!((Boolean) com.tencent.mm.u.c.vr().get(327825, Boolean.valueOf(false))).booleanValue()) {
                if (bg.Hp()) {
                    w.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
                    return;
                }
                a.bvG().rTu.a(new a(this));
                a.bvG().rTu.a(new b(this, com_tencent_mm_protocal_c_bnp));
            }
        } else if (!IB(com_tencent_mm_protocal_c_bnp.umA)) {
            w.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", new Object[]{com_tencent_mm_protocal_c_bnp.umA});
            a.bvG().rTu.a(new b(this, com_tencent_mm_protocal_c_bnp));
        } else if (this.rTy) {
            if (this.rTA.bJq()) {
                w.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
                this.rTA.v(3600000, 3600000);
            } else {
                w.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
                this.rTA.KH();
                this.rTA.v(3600000, 3600000);
            }
            a(com_tencent_mm_protocal_c_bnp);
        } else {
            w.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", new Object[]{com_tencent_mm_protocal_c_bnp.umA});
            String str = com_tencent_mm_protocal_c_bnp.umA;
            String str2 = "gh_43f2581f6fd6";
            if (!this.rTy && IB(str)) {
                w.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", new Object[]{str, str2});
                com.tencent.mm.sdk.b.b skVar = new sk();
                skVar.gac.fEG = 7;
                skVar.gac.fwJ = str;
                skVar.gac.fGl = str2;
                com.tencent.mm.sdk.b.a.urY.m(skVar);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2;
        if (kVar instanceof com.tencent.mm.plugin.wear.model.d.a) {
            ap.vd().b(1091, this);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wear.model.d.a aVar = (com.tencent.mm.plugin.wear.model.d.a) kVar;
                String str3 = aVar.fwJ;
                str2 = aVar.fGl;
                com.tencent.mm.sdk.b.b skVar = new sk();
                skVar.gac.fEG = 1;
                skVar.gac.fwJ = str3;
                skVar.gac.fGl = str2;
                com.tencent.mm.sdk.b.a.urY.m(skVar);
                return;
            }
            w.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        } else if (kVar instanceof n) {
            ap.vd().b(30, this);
            if (i == 0 && i2 == 0) {
                str2 = ((n) kVar).bCI();
                w.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", new Object[]{str2});
                ap.yY();
                af Rc = com.tencent.mm.u.c.wR().Rc("gh_43f2581f6fd6");
                if (Rc == null || bg.mA(str2)) {
                    w.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + str2 + ", contact = " + Rc);
                } else {
                    BizInfo bizInfo = null;
                    if (o.eT(Rc.field_username)) {
                        String mz = bg.mz(Rc.field_username);
                        bizInfo = com.tencent.mm.modelbiz.e.hW(mz);
                        if (bizInfo != null) {
                            bizInfo.field_username = str2;
                        }
                        com.tencent.mm.modelbiz.w.DH().hP(mz);
                        Rc.bX(mz);
                    }
                    Rc.setUsername(str2);
                    if (((int) Rc.gTQ) == 0) {
                        ap.yY();
                        com.tencent.mm.u.c.wR().S(Rc);
                    }
                    if (((int) Rc.gTQ) <= 0) {
                        w.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
                    } else {
                        o.p(Rc);
                        ap.yY();
                        af Rc2 = com.tencent.mm.u.c.wR().Rc(Rc.field_username);
                        if (bizInfo != null) {
                            com.tencent.mm.modelbiz.w.DH().d(bizInfo);
                        } else {
                            bizInfo = com.tencent.mm.modelbiz.e.hW(Rc2.field_username);
                            if (bizInfo == null || bizInfo.CB()) {
                                w.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
                                com.tencent.mm.u.ag.a.hlS.J(Rc2.field_username, "");
                                com.tencent.mm.x.b.he(Rc2.field_username);
                            } else if (Rc2.bLh()) {
                                w.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", new Object[]{Integer.valueOf(Rc2.gkI)});
                                com.tencent.mm.u.ag.a.hlS.J(Rc2.field_username, "");
                                com.tencent.mm.x.b.he(Rc2.field_username);
                            }
                        }
                    }
                }
                com.tencent.mm.modelbiz.w.DH().e(com.tencent.mm.modelbiz.w.DH().hO(Rc.field_username));
                ap.yY();
                com.tencent.mm.u.c.vr().set(327825, Boolean.valueOf(true));
                connect();
                return;
            }
            w.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 4 && i2 == -24 && !bg.mA(str)) {
                Toast.makeText(ab.getContext(), str, 1).show();
            }
        }
    }

    static boolean IB(String str) {
        com.tencent.mm.sdk.b.b skVar = new sk();
        skVar.gac.fEG = 3;
        skVar.gac.fwJ = str;
        skVar.gac.fGl = "gh_43f2581f6fd6";
        com.tencent.mm.sdk.b.a.urY.m(skVar);
        w.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", new Object[]{Boolean.valueOf(skVar.gac.fHO)});
        return skVar.gac.fHO;
    }

    public static boolean bvH() {
        ap.yY();
        return com.tencent.mm.j.a.ez(com.tencent.mm.u.c.wR().Rc("gh_43f2581f6fd6").field_type);
    }

    public static void a(bnp com_tencent_mm_protocal_c_bnp) {
        if (com_tencent_mm_protocal_c_bnp != null) {
            com.tencent.mm.sdk.b.b skVar = new sk();
            skVar.gac.fEG = 6;
            skVar.gac.fwJ = com_tencent_mm_protocal_c_bnp.umA;
            com.tencent.mm.sdk.b.a.urY.m(skVar);
            return;
        }
        w.i("MicroMsg.Wear.WearBizLogic", "request is null");
    }
}
