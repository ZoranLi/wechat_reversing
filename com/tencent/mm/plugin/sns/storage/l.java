package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.protocal.c.st;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class l extends i<k> implements d {
    public static final String[] gUx = new String[]{i.a(k.gTP, "snsExtInfo3")};
    public e gUz;
    private boolean qnp = false;
    private g qnq = null;

    public final void bdu() {
        w.d("MicroMsg.SnsExtStorage", "attachCache");
        this.qnp = true;
    }

    public final void bdv() {
        this.qnp = false;
        this.qnq.bfc();
        w.d("MicroMsg.SnsExtStorage", "detchCache");
    }

    public l(e eVar, g gVar) {
        super(eVar, k.gTP, "snsExtInfo3", null);
        this.gUz = eVar;
        this.qnq = gVar;
        w.i("MicroMsg.SnsExtStorage", "createExtStorage " + eVar + "  " + Thread.currentThread().getId());
    }

    public final boolean b(k kVar) {
        return super.a(kVar);
    }

    public final boolean a(k kVar) {
        if (!this.qnp || this.qnq == null) {
            return super.a(kVar);
        }
        boolean a = this.qnq.a(kVar);
        if (this.qnq == null) {
            return a;
        }
        this.qnq.bfb();
        return a;
    }

    public final void Gh(String str) {
        c Gk = Gk(str);
        Gk.field_userName = str;
        super.a(Gk, new String[]{this.uxf.uxc});
    }

    public final int k(String str, String str2, int i, int i2) {
        c Gk = Gk(str);
        Gk.field_md5 = str2;
        Gk.field_lastFirstPageRequestErrType = i;
        Gk.field_lastFirstPageRequestErrCode = i2;
        super.a(Gk);
        return 0;
    }

    public final int e(String str, String str2, byte[] bArr) {
        c Gk = Gk(str);
        Gk.field_md5 = str2;
        Gk.field_adsession = bArr;
        super.a(Gk);
        return 0;
    }

    public final boolean dD(String str, String str2) {
        c Gk = Gk(str);
        Gk.field_newerIds = str2;
        return super.a(Gk);
    }

    public final st Gi(String str) {
        st stVar;
        st stVar2 = new st();
        k kVar = new k();
        kVar = Gk(str);
        try {
            if (!bg.bm(kVar.field_faultS)) {
                stVar = (st) new st().aD(kVar.field_faultS);
                if (stVar != null) {
                    return new st();
                }
                return stVar;
            }
        } catch (Exception e) {
            w.e("MicroMsg.SnsExtStorage", "parser field_faultS error");
        }
        stVar = stVar2;
        if (stVar != null) {
            return stVar;
        }
        return new st();
    }

    public final void Gj(String str) {
        k kVar = new k();
        kVar = Gk(str);
        kVar.field_userName = str;
        kVar.field_local_flag &= -2;
        c(kVar);
    }

    public final k Gk(String str) {
        k kVar = new k();
        if (this.qnq != null && this.qnp) {
            kVar = this.qnq.Fj(str);
            if (kVar == null) {
                kVar = new k();
            }
            return kVar;
        }
        kVar.field_userName = str;
        super.b(kVar, new String[]{this.uxf.uxc});
        return kVar;
    }

    public final boolean c(k kVar) {
        if (kVar == null || kVar.field_userName == null || kVar.field_userName.equals("")) {
            return false;
        }
        return super.a(kVar);
    }

    public final boolean a(String str, bcp com_tencent_mm_protocal_c_bcp) {
        k Gk = Gk(str);
        String df = com.tencent.mm.plugin.sns.data.i.df(com_tencent_mm_protocal_c_bcp.hAQ);
        if (!bg.mA(com_tencent_mm_protocal_c_bcp.hAP) && (Gk.field_bgUrl == null || !Gk.field_bgId.equals(df))) {
            Gk.field_older_bgId = Gk.field_bgId;
            Gk.field_local_flag |= 1;
            Gk.bhm();
            w.d("MicroMsg.SnsExtStorage", "bg change");
        }
        Gk.field_bgId = df;
        Gk.field_bgUrl = com_tencent_mm_protocal_c_bcp.hAP;
        Gk.field_iFlag = com_tencent_mm_protocal_c_bcp.hAO;
        Gk.field_snsBgId = com_tencent_mm_protocal_c_bcp.hAQ;
        Gk.field_local_flag |= 4;
        if (com_tencent_mm_protocal_c_bcp != null) {
            try {
                Gk.field_snsuser = com_tencent_mm_protocal_c_bcp.toByteArray();
            } catch (Exception e) {
            }
        }
        a(Gk);
        return true;
    }

    public final bcp b(String str, bcp com_tencent_mm_protocal_c_bcp) {
        k Gk = Gk(str);
        k a;
        int i;
        if (Gk == null) {
            a = a(str, Gk);
            if (a != null) {
                if (com_tencent_mm_protocal_c_bcp.hAO == -1) {
                    i = a.field_iFlag;
                } else {
                    i = com_tencent_mm_protocal_c_bcp.hAO;
                }
                com_tencent_mm_protocal_c_bcp.hAO = i;
            }
        } else {
            com_tencent_mm_protocal_c_bcp.hAP = bg.mA(com_tencent_mm_protocal_c_bcp.hAP) ? Gk.field_bgUrl : com_tencent_mm_protocal_c_bcp.hAP;
            Object obj = com_tencent_mm_protocal_c_bcp.hAO == -1 ? 1 : null;
            com_tencent_mm_protocal_c_bcp.hAO = obj != null ? Gk.field_iFlag : com_tencent_mm_protocal_c_bcp.hAO;
            a = a(str, Gk);
            if (a != null) {
                if (obj != null) {
                    i = a.field_iFlag;
                } else {
                    i = com_tencent_mm_protocal_c_bcp.hAO;
                }
                com_tencent_mm_protocal_c_bcp.hAO = i;
            }
        }
        return com_tencent_mm_protocal_c_bcp;
    }

    private k a(String str, k kVar) {
        int i;
        int i2;
        Cursor a;
        k kVar2;
        if (kVar == null) {
            i = 0;
        } else {
            if ((kVar.field_iFlag & 1) > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if ((kVar.field_local_flag & 4) > 0) {
                i2 = i;
                i = 1;
                if (i == 0 && r4 == 0) {
                    a = this.gUz.a("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
                    if (a.moveToFirst()) {
                        i = 0;
                    } else {
                        i = a.getInt(0);
                    }
                    a.close();
                    if (i != 0) {
                        w.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[]{str});
                        return null;
                    }
                    w.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[]{"select * from snsExtInfo2 where userName=\"" + bg.my(str) + "\""});
                    a = this.gUz.a(r0, null, 2);
                    kVar2 = new k();
                    if (a.moveToFirst()) {
                        a.close();
                    } else {
                        kVar2.b(a);
                        a.close();
                        w.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[]{str});
                        return kVar2;
                    }
                }
                return null;
            }
        }
        i2 = i;
        i = 0;
        a = this.gUz.a("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
        if (a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
        }
        a.close();
        if (i != 0) {
            w.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[]{"select * from snsExtInfo2 where userName=\"" + bg.my(str) + "\""});
            a = this.gUz.a(r0, null, 2);
            kVar2 = new k();
            if (a.moveToFirst()) {
                a.close();
                return null;
            }
            kVar2.b(a);
            a.close();
            w.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[]{str});
            return kVar2;
        }
        w.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[]{str});
        return null;
    }

    public final bcp Ey(String str) {
        k Gk = Gk(str);
        if (Gk == null) {
            return new bcp();
        }
        return Gk.bho();
    }

    public final boolean am(String str, boolean z) {
        k Gk = Gk(str);
        int i = Gk.field_iFlag;
        if (z) {
            i |= 1;
        } else {
            i &= -2;
        }
        Gk.field_iFlag = i;
        c(Gk);
        return true;
    }

    public final bcp an(String str, boolean z) {
        bcp bho = Gk(str).bho();
        if (bho == null) {
            w.e("MicroMsg.SnsExtStorage", "userinfo is null");
            return null;
        }
        int i = bho.udF;
        if (z) {
            i |= 1;
        } else {
            i &= -2;
        }
        bho.udF = i;
        return bho;
    }

    public final boolean a(String str, boolean z, boolean z2, boolean z3) {
        k Gk = Gk(str);
        int i = Gk.field_iFlag;
        if (z) {
            i |= 512;
        } else {
            i &= -513;
        }
        if (z2) {
            i |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        } else {
            i &= -1025;
        }
        if (z3) {
            i |= 2048;
        } else {
            i &= -2049;
        }
        Gk.field_iFlag = i;
        c(Gk);
        return true;
    }

    public final bcp b(String str, boolean z, boolean z2, boolean z3) {
        bcp bho = Gk(str).bho();
        if (bho == null) {
            w.e("MicroMsg.SnsExtStorage", "userinfo is null");
            return null;
        }
        int i = bho.udF;
        if (z) {
            i |= 512;
        } else {
            i &= -513;
        }
        if (z2) {
            i |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        } else {
            i &= -1025;
        }
        if (z3) {
            i |= 2048;
        } else {
            i &= -2049;
        }
        bho.udF = i;
        return bho;
    }
}
