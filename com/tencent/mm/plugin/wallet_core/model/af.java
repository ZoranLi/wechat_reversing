package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class af {
    public int aMo = 0;
    private ArrayList<Bankcard> rIj = new ArrayList();
    public ae rIk = null;
    public Bankcard rIl = null;
    ad rIm = null;
    public j rIn = null;
    public b rIo = null;
    private List<c> rIp = new LinkedList();
    public Bankcard rIq = null;
    public long rIr = bg.Ny();
    public long rIs = -1;
    private String rIt = "";
    public int rIu = 10000;
    public String rIv = "";
    public String rIw = "";
    public Bankcard ruN = null;
    ArrayList<Bankcard> rwS = new ArrayList();
    ArrayList<Bankcard> rwT = new ArrayList();

    public af() {
        buv();
    }

    public final boolean bul() {
        return this.rIk == null || (this.rIk != null && this.rIk.buk());
    }

    public final boolean bum() {
        if (this.rIk != null) {
            if (this.rIk.field_is_reg == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean buj() {
        return this.rIk != null && this.rIk.buj();
    }

    public final boolean bun() {
        if (this.rIk != null) {
            if (this.rIk.field_is_reg == 2) {
                return true;
            }
        }
        return false;
    }

    public final boolean buo() {
        if (this.rIk != null) {
            if (this.rIk.field_is_open_touch == 1) {
                return true;
            }
        }
        return false;
    }

    public final String bup() {
        if (this.rIk != null) {
            return this.rIk.field_ftf_pay_url;
        }
        return null;
    }

    public final ad buq() {
        if (this.rIm == null) {
            return new ad();
        }
        return this.rIm;
    }

    public final boolean bur() {
        return this.rIk != null && this.rIk.field_isDomesticUser;
    }

    public final String akr() {
        if (this.rIk != null) {
            return this.rIk.field_true_name;
        }
        return null;
    }

    public final int bus() {
        if (this.rIk != null) {
            return this.rIk.field_cre_type;
        }
        return 1;
    }

    public final String but() {
        ap.yY();
        String str = (String) c.vr().get(a.uIE, null);
        if (bg.mA(str)) {
            return this.rIk != null ? this.rIk.field_lct_wording : null;
        } else {
            return str;
        }
    }

    public final String buu() {
        if (this.rIk != null) {
            return this.rIk.field_lct_url;
        }
        return null;
    }

    public final void buv() {
        j jVar = null;
        if (h.vG().uV()) {
            Bankcard bankcard;
            this.rIk = m.btO().buL();
            if (this.rIk != null) {
                this.rIm = new ad(this.rIk.field_switchConfig);
            } else {
                this.rIm = new ad();
            }
            com.tencent.mm.plugin.wallet_core.c.c btQ = m.btQ();
            Cursor a = btQ.gUz.a("select * from WalletBankcard where cardType & " + Bankcard.rDZ + " != 0 ", null, 2);
            if (a == null) {
                bankcard = null;
            } else {
                if (a.moveToFirst()) {
                    bankcard = new Bankcard();
                    bankcard.b(a);
                } else {
                    bankcard = null;
                }
                a.close();
            }
            this.ruN = bankcard;
            btQ = m.btQ();
            a = btQ.gUz.a("select * from WalletBankcard where cardType & " + Bankcard.rEb + " != 0 ", null, 2);
            if (a == null) {
                bankcard = null;
            } else {
                if (a.moveToFirst()) {
                    bankcard = new Bankcard();
                    bankcard.b(a);
                } else {
                    bankcard = null;
                }
                a.close();
            }
            this.rIq = bankcard;
            e.a("wallet_balance", new b(this) {
                final /* synthetic */ af rIx;

                {
                    this.rIx = r1;
                }

                public final void bo(Object obj) {
                    if (obj == null || !(obj instanceof Double)) {
                        w.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
                        if (this.rIx.ruN != null) {
                            this.rIx.ruN.rEh = -1.0d;
                            return;
                        }
                        return;
                    }
                    if (((Double) obj).doubleValue() < 0.0d) {
                        w.v("MicroMsg.WalletUserInfoManger", "val is zero %s", new Object[]{bg.bJZ().toString()});
                    }
                    if (this.rIx.ruN != null) {
                        this.rIx.ruN.rEh = ((Double) obj).doubleValue();
                    }
                }
            });
            this.rwS = m.btQ().buw();
            this.rwT = m.btQ().buJ();
            btQ = m.btQ();
            a = btQ.gUz.a("select * from WalletBankcard where cardType & " + Bankcard.rEa + " != 0 ", null, 2);
            if (a == null) {
                bankcard = null;
            } else {
                if (a.moveToNext()) {
                    bankcard = new Bankcard();
                    bankcard.b(a);
                } else {
                    bankcard = null;
                }
                a.close();
            }
            this.rIl = bankcard;
            Cursor a2 = m.btU().gUz.a("select * from LoanEntryInfo", null, 2);
            if (a2 != null) {
                if (a2.moveToFirst()) {
                    jVar = new j();
                    jVar.b(a2);
                }
                a2.close();
            }
            this.rIn = jVar;
            w.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
            buA();
            return;
        }
        w.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
    }

    public final void aue() {
        if (this.rIk != null) {
            this.rIk.field_is_reg = -1;
            this.rIk = null;
        }
        if (this.rIm != null) {
            this.rIm = null;
        }
        if (this.ruN != null) {
            this.ruN = null;
        }
        if (this.rwS != null) {
            this.rwS.clear();
            this.rwS = null;
        }
        if (this.rwT != null) {
            this.rwT.clear();
            this.rwT = null;
        }
        e.a(new e.c[]{new e.c("wallet_balance_version", Integer.valueOf(-1)), new e.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new e.c("wallet_balance", Integer.valueOf(-1))});
        this.rIr = bg.Ny();
    }

    public final ArrayList<Bankcard> buw() {
        if (this.rwS == null || this.rwS.size() <= 0) {
            this.rwS = m.btQ().buw();
        }
        if (this.rwS == null || this.rwS.size() <= 0) {
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        Iterator it = this.rwS.iterator();
        while (it.hasNext()) {
            arrayList.add((Bankcard) it.next());
        }
        return arrayList;
    }

    public final List<c> bux() {
        if (this.rIp != null) {
            this.rIp.size();
        }
        if (this.rIp == null || this.rIp.size() <= 0) {
            return null;
        }
        return this.rIp;
    }

    public final ArrayList<Bankcard> buy() {
        if (this.rwS == null || this.rwS.size() <= 0) {
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        Iterator it = this.rwS.iterator();
        while (it.hasNext()) {
            Bankcard bankcard = (Bankcard) it.next();
            if (!bankcard.btC()) {
                arrayList.add(bankcard);
            }
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> it(boolean z) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (z) {
            if (!(this.ruN == null || buj())) {
                arrayList.add(this.ruN);
            }
            if (!(this.rIq == null || buj() || this.rIk == null || this.rIk.field_lqt_state != 1)) {
                arrayList.add(this.rIq);
            }
        }
        if (this.rwS != null && this.rwS.size() > 0) {
            Iterator it = this.rwS.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> iB(boolean z) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (z) {
            if (!(this.ruN == null || buj())) {
                arrayList.add(this.ruN);
            }
            if (!(this.rIq == null || buj() || this.rIk == null || this.rIk.field_lqt_state != 1)) {
                arrayList.add(this.rIq);
            }
        }
        Iterator it;
        if (this.rIj != null && this.rwS != null && this.rIj.size() == this.rwS.size() && this.rIj.size() > 0) {
            it = this.rIj.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        } else if (this.rwS != null && this.rwS.size() > 0) {
            it = this.rwS.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        return arrayList;
    }

    public final void d(ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2) {
        if (this.rwS == null || arrayList == null || arrayList2 == null) {
            w.e("MicroMsg.WalletUserInfoManger", "error list, bankcards == null || bankcardsClone == null || virtualBankcardsClone == null");
            return;
        }
        Iterator it;
        arrayList.clear();
        arrayList2.clear();
        if (this.rwS != null) {
            it = this.rwS.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        if (this.rwT != null) {
            it = this.rwT.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bankcard.field_wxcreditState == 0) {
                    arrayList2.add(bankcard);
                } else {
                    arrayList.add(bankcard);
                }
            }
        }
    }

    public static boolean bH(List<Bankcard> list) {
        if (list.size() == 0) {
            return false;
        }
        ap.yY();
        String str = (String) c.vr().get(196659, null);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            return true;
        }
        int i = 0;
        for (Object obj : split) {
            if (!TextUtils.isEmpty(obj)) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Bankcard bankcard = (Bankcard) list.get(i2);
                    if (bankcard != null && obj.equals(bankcard.field_bankcardType)) {
                        i++;
                        break;
                    }
                }
            }
        }
        if (i < list.size()) {
            return true;
        }
        return false;
    }

    public final boolean HX(String str) {
        if (bg.mA(str)) {
            return false;
        }
        Iterator it;
        Bankcard bankcard;
        if (this.rwS != null) {
            it = this.rwS.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.btz()) {
                    return false;
                }
            }
        }
        if (this.rwT != null) {
            it = this.rwT.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.field_bankcardState == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void a(ae aeVar, ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2, Bankcard bankcard, Bankcard bankcard2, j jVar, b bVar, Bankcard bankcard3, int i, int i2, List<c> list) {
        w.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", new Object[]{Integer.valueOf(i2)});
        if (i2 == 8) {
            this.rIj = arrayList;
        }
        this.rIp = list;
        this.rIk = aeVar;
        this.rwS = arrayList;
        this.rwT = arrayList2;
        this.ruN = bankcard;
        this.rIm = new ad(aeVar.field_switchConfig);
        this.rIl = bankcard2;
        this.rIn = jVar;
        this.rIo = bVar;
        this.rIq = bankcard3;
        w.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + aeVar.field_switchConfig);
        buA();
        if (i < 0) {
            i = 600;
        }
        this.rIr = bg.Ny() + ((long) i);
        w.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d", new Object[]{Integer.valueOf(i), Long.valueOf(this.rIr)});
        m.btQ().gUz.eE("WalletBankcard", "delete from WalletBankcard");
        if (arrayList != null) {
            m.btQ().bJ(arrayList);
        }
        if (arrayList2 != null) {
            m.btQ().bJ(arrayList2);
        }
        if (bankcard != null) {
            m.btQ().d(bankcard);
        }
        if (bankcard2 != null) {
            m.btQ().d(bankcard2);
        }
        if (bankcard3 != null) {
            m.btQ().d(bankcard3);
        }
        m.btO().gUz.eE("WalletUserInfo", "delete from WalletUserInfo");
        m.btO().a(aeVar);
        m.btU().gUz.eE("LoanEntryInfo", "delete from LoanEntryInfo");
        if (jVar != null) {
            m.btU().b(jVar);
        }
    }

    public static void HY(String str) {
        if (!bg.mA(str)) {
            ap.yY();
            c.vr().set(196612, str);
        }
    }

    public final Bankcard a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2) {
        if (arrayList == null) {
            arrayList = this.rwS;
        }
        if (bg.mA(str)) {
            ap.yY();
            str = (String) c.vr().get(196612, null);
        }
        if (z && this.ruN != null) {
            if (bun()) {
                return this.ruN;
            }
            if (str != null && str.equals(this.ruN.field_bindSerial)) {
                return this.ruN;
            }
            if (this.rIq != null && this.rIk != null && this.rIk.field_lqt_state == 1 && str != null && str.equals(this.rIq.field_bindSerial)) {
                return this.rIq;
            }
            if (!buj() && (arrayList == null || arrayList.size() == 0)) {
                return this.ruN;
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            w.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            return null;
        } else if (arrayList.size() == 1 && z2) {
            w.e("MicroMsg.WalletUserInfoManger", "only one bankcard!");
            return (Bankcard) arrayList.get(0);
        } else {
            w.i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
            if (!bg.mA(str)) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Bankcard bankcard = (Bankcard) it.next();
                    if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                        return bankcard;
                    }
                }
            }
            return z2 ? (Bankcard) arrayList.get(0) : null;
        }
    }

    public final String buz() {
        if (this.rwS == null || this.rwS.size() <= 0) {
            w.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            return null;
        }
        Iterator it = this.rwS.iterator();
        if (it.hasNext()) {
            return ((Bankcard) it.next()).field_bindSerial;
        }
        return null;
    }

    private void buA() {
        w.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
        if (this.rIk == null) {
            w.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
        }
        if (this.rwS == null) {
            w.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
        } else if (this.rwS.size() == 0) {
            w.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        } else {
            w.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.rwS.size());
        }
        if (this.rwT == null) {
            w.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
        } else if (this.rwT.size() == 0) {
            w.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        } else {
            w.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.rwT.size());
        }
        if (this.ruN == null) {
            w.i("MicroMsg.WalletUserInfoManger", "balance == null");
        } else {
            w.i("MicroMsg.WalletUserInfoManger", "balance != null");
        }
        if (this.rIl == null) {
            w.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
        } else {
            w.i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
        }
        if (this.rIn == null) {
            w.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
        } else {
            w.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
        }
    }
}
