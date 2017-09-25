package com.tencent.mm.plugin.card.ui.view;

import android.database.Cursor;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.q;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class m extends g {
    public final boolean h(b bVar) {
        if (this.kcX == null) {
            w.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            return true;
        } else if (bVar == null) {
            w.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            return false;
        } else if (this.kcX.afj().tnV != bVar.afj().tnV) {
            w.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain is_commom_card is different！");
            return true;
        } else {
            lz lzVar = this.kcX.afj().tnU;
            lz lzVar2 = bVar.afj().tnU;
            if ((lzVar == null && lzVar2 != null) || (lzVar != null && lzVar2 == null)) {
                w.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field is different！");
                return true;
            } else if (lzVar == null || lzVar2 == null || lzVar.title == null || lzVar2.title == null || !lzVar.title.equals(lzVar2.title)) {
                lzVar = this.kcX.afi().toO;
                lzVar2 = bVar.afi().toO;
                if ((lzVar == null && lzVar2 != null) || (lzVar != null && lzVar2 == null)) {
                    w.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    return true;
                } else if (lzVar != null && lzVar2 != null && lzVar.title != null && lzVar2.title != null && !lzVar.title.equals(lzVar2.title)) {
                    w.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    return true;
                } else if (lzVar == null || lzVar2 == null || lzVar.kdI == null || lzVar2.kdI == null || lzVar.kdI.equals(lzVar2.kdI)) {
                    return false;
                } else {
                    w.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    return true;
                }
            } else {
                w.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field title is different！");
                return true;
            }
        }
    }

    public final String e(c cVar) {
        w.i("MicroMsg.CarDynamicCodeView", "code from dynamic offline");
        g agq = al.agq();
        b bVar = this.kcX;
        String str = "";
        if (bVar == null) {
            w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! cardInfo is null");
            return str;
        }
        int i;
        agq.afz();
        agq.kdf = cVar;
        String afm = bVar.afm();
        Cursor rawQuery = al.ago().gUz.rawQuery("select count(1) from CardQrCodeDataInfo where card_id =? AND status=0", new String[]{afm});
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            i = rawQuery.getInt(0);
            rawQuery.close();
        } else {
            i = 0;
        }
        if (i == 0) {
            w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！db is empty!");
            i = 0;
        } else {
            i ss = al.agp().ss(afm);
            if (ss != null) {
                if (g.a(ss)) {
                    agq.kdf = c.CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT;
                    i = 0;
                } else if (i < ss.field_lower_bound && l.isNetworkAvailable(ab.getContext())) {
                    w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ currentCodeSize < lower_bound,currentCodeSize =%d,lower_bound=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(ss.field_lower_bound)});
                    agq.kdf = c.CARDCODEREFRESHACTION_UPDATECHANGE;
                    i = 0;
                }
            }
            i = 1;
        }
        if (i == 0) {
            w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ request doNetSceneGetDynamicQrcode!");
            agq.a(bVar, q.EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL);
            return "";
        }
        com.tencent.mm.sdk.e.c su = al.ago().su(bVar.afm());
        if (su == null) {
            w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! db is  empty! doNetSceneGetDynamicQrcode! cardId= %s", new Object[]{bVar.afm()});
            agq.a(bVar, q.EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL);
            return "";
        }
        k sv = al.ago().sv(afm);
        if (sv != null && al.ago().bv(afm, sv.field_code_id)) {
            agq.a(afm, sv.field_code_id, cVar);
        }
        agq.kdg = 0;
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "update current code showing! newQrCodeData cardId= %s,codeId=%s，refreshReason=%d", new Object[]{afm, su.field_code_id, Integer.valueOf(cVar.action)});
        afm = bVar.afm();
        if (su == null) {
            str = "";
        } else {
            str = e.bB(afm, su.field_code);
            i ss2 = al.agp().ss(afm);
            if (ss2 == null || com.tencent.pb.common.c.i.wx(str) || !ss2.field_need_insert_show_timestamp || com.tencent.pb.common.c.i.wx(ss2.field_show_timestamp_encrypt_key)) {
                w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData only decrypt qrcode!");
            } else {
                w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData is need insert show timestamp! code signTimestamp!");
                str = e.bD(str, ss2.field_show_timestamp_encrypt_key);
            }
        }
        if (com.tencent.pb.common.c.i.wx(str)) {
            agq.G(1, "");
            return "";
        }
        su.field_status = 1;
        if (al.ago().c(su, new String[]{"card_id", "code_id"})) {
            w.i("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  success! card_id = %s, code_id = %s ,status = %d", new Object[]{su.field_card_id, su.field_code_id, Integer.valueOf(su.field_status)});
        } else {
            w.e("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  failure! card_id = %s, code_id = %s ,status = %d", new Object[]{su.field_card_id, su.field_code_id, Integer.valueOf(su.field_status)});
        }
        g agq2 = al.agq();
        i ss3 = al.agp().ss(bVar.afm());
        if (ss3 == null) {
            w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRequestCodeTimer failure! CardQrCodeConfi is null!");
            return str;
        }
        long j = (long) (ss3.field_show_expire_interval * 1000);
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRefreshCodeTimer refreshTime: " + j);
        agq2.kdh.v(j, j);
        return str;
    }

    public final aa aiE() {
        return new n(this, this.kdb);
    }

    public final aa aiF() {
        return new f(this, this.kdb);
    }

    public final aa aiG() {
        return new t(this, this.kdb);
    }

    public final boolean aiH() {
        return false;
    }
}
