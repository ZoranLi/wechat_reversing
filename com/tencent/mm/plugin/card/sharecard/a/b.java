package com.tencent.mm.plugin.card.sharecard.a;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.s;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.i;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.plugin.card.sharecard.model.p;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.sharecard.ui.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    private static boolean hpL = false;
    public static boolean kgQ = false;
    public a kgP = null;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        kgQ = false;
    }

    public final void init() {
        if (((l) al.agf().getValue("key_share_card_layout_data")) == null) {
            w.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, data cache is empty!, load data from db!");
            Object aiM = com.tencent.mm.plugin.card.b.l.aiM();
            if (TextUtils.isEmpty(aiM)) {
                w.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, json is empty");
                return;
            }
            l tk = s.tk(aiM);
            if (tk != null) {
                w.i("MicroMsg.ShareCardDataMgr", "load share card layout data success!");
                al.agf().putValue("key_share_card_layout_data", tk);
                a(tk, true);
                return;
            }
            w.e("MicroMsg.ShareCardDataMgr", "load share card layout data fail!");
            return;
        }
        w.i("MicroMsg.ShareCardDataMgr", "the share card layout cache is valid!");
    }

    public static int ags() {
        int i = 0;
        c aga = al.aga();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR ").append("status=5) AND ").append("card_type=10");
        Cursor a = aga.gUz.a("select count(*) from UserCardInfo" + stringBuilder.toString(), null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public static int agt() {
        int i = 0;
        c aga = al.aga();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR ").append("status=5) AND ").append("card_type!=10");
        Cursor a = aga.gUz.a("select count(*) from UserCardInfo" + stringBuilder.toString(), null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final void N(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData json is empty");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        l tk = s.tk(str);
        l lVar = (l) al.agf().getValue("key_share_card_layout_data");
        if (tk == null) {
            w.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData data == null");
            a(tk, lVar, z);
            al.agf().putValue("key_share_card_layout_data", tk);
            return;
        }
        if (z) {
            com.tencent.mm.plugin.card.b.l.tc(str);
        }
        a(tk, z);
        a(tk, lVar, z);
        al.agf().putValue("key_share_card_layout_data", tk);
        int i = 0;
        if (tk.khe != null && tk.khe.size() > 0) {
            i = tk.khe.size();
        }
        if (tk.khf != null && tk.khf.size() > 0) {
            i += tk.khf.size();
        }
        if (i > 0) {
            int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(10);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(11);
            iDKey2.SetValue(currentTimeMillis2);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(281);
            iDKey3.SetKey(12);
            iDKey3.SetValue(i);
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(281);
            iDKey4.SetKey(14);
            iDKey4.SetValue(currentTimeMillis2 / i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            arrayList.add(iDKey3);
            arrayList.add(iDKey4);
            g.oUh.b(arrayList, true);
        }
    }

    private void a(l lVar, boolean z) {
        int i = 0;
        if (lVar == null) {
            w.e("MicroMsg.ShareCardDataMgr", "don't parserShareCardListData, data is null");
            return;
        }
        Map hashMap;
        Map hashMap2;
        Map hashMap3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        m mVar;
        w.i("MicroMsg.ShareCardDataMgr", "parserShareCardListData()");
        Map map = (Map) al.agf().getValue("key_share_card_annoucement_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) al.agf().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap2 = new HashMap();
        } else {
            hashMap2 = map;
        }
        map = (Map) al.agf().getValue("key_share_card_username_map");
        if (map == null) {
            hashMap3 = new HashMap();
        } else {
            hashMap3 = map;
        }
        ArrayList arrayList4 = (ArrayList) al.agf().getValue("key_share_card_local_city_ids");
        if (arrayList4 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList4;
        }
        arrayList4 = (ArrayList) al.agf().getValue("key_share_card_other_city_ids");
        if (arrayList4 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList4;
        }
        arrayList4 = (ArrayList) al.agf().getValue("key_share_card_other_city_top_info_list");
        if (arrayList4 == null) {
            arrayList3 = new ArrayList();
        } else {
            arrayList3 = arrayList4;
        }
        if (z) {
            arrayList.clear();
            arrayList2.clear();
            arrayList3.clear();
        }
        ArrayList arrayList5 = new ArrayList();
        if (lVar.khe != null && lVar.khe.size() > 0) {
            for (int i2 = 0; i2 < lVar.khe.size(); i2++) {
                mVar = (m) lVar.khe.get(i2);
                if (!TextUtils.isEmpty(mVar.khm)) {
                    hashMap.put(mVar.kdE, mVar.khm);
                }
                hashMap2.put(mVar.kdE, Integer.valueOf(al.agi().sE(mVar.kdE)));
                hashMap3.put(mVar.kdE, o(al.agi().sD(mVar.kdE)));
                if (!arrayList5.contains(mVar.kdE)) {
                    CharSequence sF = al.agi().sF(mVar.kdE);
                    if (!TextUtils.isEmpty(sF) && !arrayList.contains(sF)) {
                        arrayList.add(sF);
                    } else if (!arrayList.contains(mVar.fVl)) {
                        arrayList.add(mVar.fVl);
                    }
                    arrayList5.add(mVar.kdE);
                    p pVar = new p();
                    pVar.kdE = mVar.kdE;
                    pVar.top = mVar.top;
                    arrayList3.add(pVar);
                }
            }
        }
        arrayList5.clear();
        if (lVar.khf != null && lVar.khf.size() > 0) {
            while (i < lVar.khf.size()) {
                mVar = (m) lVar.khf.get(i);
                if (!TextUtils.isEmpty(mVar.khm)) {
                    hashMap.put(mVar.kdE, mVar.khm);
                }
                hashMap2.put(mVar.kdE, Integer.valueOf(al.agi().sE(mVar.kdE)));
                hashMap3.put(mVar.kdE, o(al.agi().sD(mVar.kdE)));
                if (!arrayList5.contains(mVar.kdE)) {
                    CharSequence sF2 = al.agi().sF(mVar.kdE);
                    if (!TextUtils.isEmpty(sF2) && !arrayList2.contains(sF2)) {
                        arrayList2.add(sF2);
                    } else if (!arrayList2.contains(mVar.fVl)) {
                        arrayList2.add(mVar.fVl);
                    }
                    arrayList5.add(mVar.kdE);
                    p pVar2 = new p();
                    pVar2.kdE = mVar.kdE;
                    pVar2.top = mVar.top;
                    arrayList3.add(pVar2);
                }
                i++;
            }
        }
        al.agf().putValue("key_share_card_annoucement_map", hashMap);
        al.agf().putValue("key_share_card_count_map", hashMap2);
        al.agf().putValue("key_share_card_username_map", hashMap3);
        al.agf().putValue("key_share_card_local_city", lVar.khg);
        al.agf().putValue("key_share_card_local_city_ids", arrayList);
        al.agf().putValue("key_share_card_other_city_ids", arrayList2);
        al.agf().putValue("key_share_card_other_city_top_info_list", arrayList3);
    }

    private static void a(l lVar, l lVar2, boolean z) {
        if (lVar == null && lVar2 == null) {
            w.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData == null && oldData == null");
        } else if (lVar != null && lVar.khf == null && lVar.khe == null && lVar2 != null && lVar2.khf == null && lVar2.khe == null) {
            w.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData.local_city_list == null && oldData.local_city_list == null");
        } else {
            ArrayList arrayList;
            ArrayList arrayList2;
            int i;
            m mVar;
            w.i("MicroMsg.ShareCardDataMgr", "updateCategoryType()");
            ArrayList arrayList3 = (ArrayList) al.agf().getValue("key_share_card_local_city_category_info_list");
            if (arrayList3 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = arrayList3;
            }
            arrayList3 = (ArrayList) al.agf().getValue("key_share_card_other_city_category_info_list");
            if (arrayList3 == null) {
                arrayList2 = new ArrayList();
            } else {
                arrayList2 = arrayList3;
            }
            int i2 = 0;
            if (z) {
                al.agi().ku(10);
                arrayList.clear();
                al.agi().ku(0);
                arrayList2.clear();
                i = 0;
                i2 = 0;
            } else {
                if (!(lVar2 == null || lVar2.khe == null || lVar2.khe.size() < 0)) {
                    i2 = lVar2.khe.size();
                }
                if (lVar2 == null || lVar2.khf == null || lVar2.khf.size() < 0) {
                    i = i2;
                    i2 = 0;
                } else {
                    i = i2;
                    i2 = lVar2.khf.size();
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ap.yY();
            long cs = com.tencent.mm.u.c.wO().cs(Thread.currentThread().getId());
            if (lVar != null && lVar.khe != null && lVar.khe.size() > 0) {
                for (int i3 = 0; i3 < lVar.khe.size(); i3++) {
                    mVar = (m) lVar.khe.get(i3);
                    al.agi().y(mVar.kdE, 10, i3 + i);
                    i iVar = new i();
                    iVar.kdE = mVar.kdE;
                    iVar.kgZ = i3 + i;
                    arrayList.add(iVar);
                }
                if (!(z || lVar2 == null || lVar2.khe == null)) {
                    lVar.khe.addAll(lVar2.khe);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.khe == null)) {
                lVar.khe = lVar2.khe;
            }
            al.agf().putValue("key_share_card_local_city_category_info_list", arrayList);
            if (lVar != null && lVar.khf != null && lVar.khf.size() > 0) {
                for (int i4 = 0; i4 < lVar.khf.size(); i4++) {
                    mVar = (m) lVar.khf.get(i4);
                    al.agi().y(mVar.kdE, 0, i4 + i2);
                    i iVar2 = new i();
                    iVar2.kdE = mVar.kdE;
                    iVar2.kgZ = i4 + i2;
                    arrayList2.add(iVar2);
                }
                if (!(z || lVar2 == null || lVar2.khf == null)) {
                    lVar.khf.addAll(lVar2.khf);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.khf == null)) {
                lVar.khf = lVar2.khf;
            }
            al.agf().putValue("key_share_card_other_city_category_info_list", arrayList2);
            ap.yY();
            com.tencent.mm.u.c.wO().aD(cs);
            w.d("MicroMsg.ShareCardDataMgr", "updateCategoryType  >> updateCategoryInfo use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }

    public static void agu() {
        ArrayList arrayList;
        ArrayList arrayList2;
        long currentTimeMillis = System.currentTimeMillis();
        ap.yY();
        long cs = com.tencent.mm.u.c.wO().cs(Thread.currentThread().getId());
        w.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory()");
        ArrayList arrayList3 = (ArrayList) al.agf().getValue("key_share_card_local_city_category_info_list");
        if (arrayList3 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList3;
        }
        arrayList3 = (ArrayList) al.agf().getValue("key_share_card_other_city_category_info_list");
        if (arrayList3 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList3;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            i iVar = (i) arrayList.get(i);
            al.agi().y(iVar.kdE, 10, iVar.kgZ);
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            iVar = (i) arrayList2.get(i2);
            al.agi().y(iVar.kdE, 0, iVar.kgZ);
        }
        ap.yY();
        com.tencent.mm.u.c.wO().aD(cs);
        w.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory  >> updateCategoryInfo use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private String o(ArrayList<String> arrayList) {
        return a(this.mContext, (ArrayList) arrayList);
    }

    private static String a(Context context, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            w.e("MicroMsg.ShareCardDataMgr", "getShareUserName， username_list == null || username_list.size() == 0");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < arrayList.size() && i < 2) {
            if (i != 0) {
                stringBuilder.append("、");
            }
            Object eL = n.eL((String) arrayList.get(i));
            String eK = n.eK((String) arrayList.get(i));
            if (TextUtils.isEmpty(eL)) {
                stringBuilder.append(eK);
            } else {
                stringBuilder.append(eL);
            }
            i++;
        }
        if (context == null) {
            w.e("MicroMsg.ShareCardDataMgr", "context == null");
            return "";
        } else if (arrayList.size() == 1 || arrayList.size() == 2) {
            return context.getString(R.l.dRV, new Object[]{stringBuilder.toString()});
        } else {
            return context.getString(R.l.dRH, new Object[]{stringBuilder.toString(), Integer.valueOf(arrayList.size())});
        }
    }

    public static void sx(final String str) {
        w.i("MicroMsg.ShareCardDataMgr", "updateShareUserInfo()");
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.ShareCardDataMgr", "updateShareUserInfo(), card_tp_id is empty");
            return;
        }
        final ae aeVar = new ae(Looper.getMainLooper());
        e.post(new Runnable() {
            public final void run() {
                ArrayList arrayList = null;
                w.i("MicroMsg.ShareCardDataMgr", "begin to getShareUserInfo()");
                k agi = al.agi();
                String str = str;
                w.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo()");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" where ( status=0) ");
                stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
                stringBuilder.append(" order by share_time desc ");
                Cursor a = agi.gUz.a("select * from ShareCardInfo" + stringBuilder.toString(), null, 2);
                if (a == null) {
                    w.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo(), cursor == null");
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    while (a.moveToNext()) {
                        ShareCardInfo shareCardInfo = new ShareCardInfo();
                        shareCardInfo.b(a);
                        r rVar;
                        if (arrayList3.contains(shareCardInfo.field_from_username)) {
                            int i = 0;
                            rVar = null;
                            while (i < arrayList2.size()) {
                                rVar = (r) arrayList2.get(i);
                                if (shareCardInfo.field_from_username != null && shareCardInfo.field_from_username.equals(rVar.khr)) {
                                    break;
                                }
                                i++;
                            }
                            i = 0;
                            rVar.khs.add(0, shareCardInfo.field_card_id);
                            rVar.cEG++;
                            arrayList2.set(i, rVar);
                        } else {
                            rVar = new r();
                            rVar.kdE = shareCardInfo.field_card_tp_id;
                            rVar.khr = shareCardInfo.field_from_username;
                            rVar.khs = new ArrayList();
                            rVar.khs.add(shareCardInfo.field_card_id);
                            rVar.cEG = 1;
                            arrayList2.add(rVar);
                            arrayList3.add(shareCardInfo.field_from_username);
                        }
                    }
                    a.close();
                    arrayList = arrayList2;
                }
                w.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 1");
                if (arrayList == null || arrayList.size() == 0) {
                    w.e("MicroMsg.ShareCardDataMgr", "getShareUserInfo(), share_user_list is null");
                    return;
                }
                if (arrayList.get(0) != null) {
                    ((r) arrayList.get(0)).kht = true;
                }
                w.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 2");
                aeVar.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 kgU;

                    public final void run() {
                        Map map = (Map) al.agf().getValue("key_share_user_info_map");
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(str, arrayList);
                        al.agf().putValue("key_share_user_info_map", map);
                    }
                });
            }
        }, "updateShareUserInfo_thread");
    }

    public static ArrayList<String> kq(int i) {
        ArrayList<String> arrayList;
        if (i == 1) {
            arrayList = (ArrayList) al.agf().getValue("key_share_card_local_city_ids");
            if (arrayList != null && arrayList.size() != 0) {
                return arrayList;
            }
            w.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == " + i);
            return kr(i);
        } else if (i != 2) {
            return null;
        } else {
            arrayList = (ArrayList) al.agf().getValue("key_share_card_other_city_ids");
            if (arrayList != null && arrayList.size() != 0) {
                return arrayList;
            }
            w.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == " + i);
            return kr(i);
        }
    }

    private static ArrayList<String> kr(int i) {
        l lVar = (l) al.agf().getValue("key_share_card_layout_data");
        if (lVar == null) {
            w.e("MicroMsg.ShareCardDataMgr", "getCardIdsByType() data == null for showType = " + i);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2;
        m mVar;
        CharSequence sF;
        if (i == 1) {
            if (lVar.khe != null && lVar.khe.size() > 0) {
                for (i2 = 0; i2 < lVar.khe.size(); i2++) {
                    mVar = (m) lVar.khe.get(i2);
                    if (!arrayList2.contains(mVar.kdE)) {
                        sF = al.agi().sF(mVar.kdE);
                        if (!TextUtils.isEmpty(sF) && !arrayList.contains(sF)) {
                            arrayList.add(sF);
                        } else if (!arrayList.contains(mVar.fVl)) {
                            arrayList.add(mVar.fVl);
                        }
                        arrayList2.add(mVar.kdE);
                    }
                }
                al.agf().putValue("key_share_card_local_city_ids", arrayList);
            }
            return arrayList;
        } else if (i != 2) {
            return null;
        } else {
            if (lVar.khf != null && lVar.khf.size() > 0) {
                for (i2 = 0; i2 < lVar.khf.size(); i2++) {
                    mVar = (m) lVar.khf.get(i2);
                    if (!arrayList2.contains(mVar.kdE)) {
                        sF = al.agi().sF(mVar.kdE);
                        if (!TextUtils.isEmpty(sF) && !arrayList.contains(sF)) {
                            arrayList.add(sF);
                        } else if (!arrayList.contains(mVar.fVl)) {
                            arrayList.add(mVar.fVl);
                        }
                        arrayList2.add(mVar.kdE);
                    }
                }
                al.agf().putValue("key_share_card_other_city_ids", arrayList);
            }
            return arrayList;
        }
    }

    public static void bw(String str, String str2) {
        if (hpL) {
            w.i("MicroMsg.ShareCardDataMgr", "is isUpdating data, don't do updateCardIdsListByCardId");
            return;
        }
        CharSequence bz;
        w.i("MicroMsg.ShareCardDataMgr", "do updateCardIdsListByCardId");
        hpL = true;
        ArrayList kq = kq(1);
        if (kq != null && kq.contains(str)) {
            kq.remove(str);
            bz = al.agi().bz(str, str2);
            if (!TextUtils.isEmpty(bz)) {
                kq.add(bz);
            }
            al.agf().putValue("key_share_card_local_city_ids", kq);
        }
        kq = kq(2);
        if (kq != null && kq.contains(str)) {
            kq.remove(str);
            bz = al.agi().bz(str, str2);
            if (!TextUtils.isEmpty(bz)) {
                kq.add(bz);
            }
            al.agf().putValue("key_share_card_other_city_ids", kq);
        }
        hpL = false;
    }

    public static void bx(String str, String str2) {
        w.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId card_id:" + str + ", card_tp_id:" + str2);
        ArrayList kq = kq(1);
        if (kq == null || !kq.contains(str)) {
            ArrayList kq2 = kq(2);
            if (kq2 == null || !kq2.contains(str)) {
                l lVar = (l) al.agf().getValue("key_share_card_layout_data");
                if (lVar == null) {
                    w.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId data == null");
                    return;
                }
                int sE = al.agi().sE(str2);
                int sz = sz(str2);
                w.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId realCount:" + sE + " cacheCount:" + sz);
                if (lVar.khe == null || lVar.khe.size() <= 0 || (sz > 0 && sE != 1)) {
                    w.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for local_ids");
                } else {
                    int i = 0;
                    while (i < lVar.khe.size()) {
                        m mVar = (m) lVar.khe.get(i);
                        if (str2 == null || !str2.contains(mVar.kdE)) {
                            i++;
                        } else {
                            kq.add(str);
                            al.agf().putValue("key_share_card_local_city_ids", kq);
                            w.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for local ids, card id is " + str);
                            return;
                        }
                    }
                }
                if (kq2 == null || (sz > 0 && sE != 1)) {
                    w.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for other_ids");
                    return;
                }
                kq2.add(str);
                al.agf().putValue("key_share_card_other_city_ids", kq2);
                w.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for other ids, card id is " + str);
            }
        }
    }

    public static int agv() {
        if (agx()) {
            return 1;
        }
        if (!agw()) {
            return 0;
        }
        if (kgQ) {
            return 3;
        }
        return 4;
    }

    public static boolean agw() {
        ArrayList arrayList = (ArrayList) al.agf().getValue("key_share_card_other_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean agx() {
        ArrayList arrayList = (ArrayList) al.agf().getValue("key_share_card_local_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    public static String sy(String str) {
        Map map = (Map) al.agf().getValue("key_share_card_annoucement_map");
        if (map == null) {
            return "";
        }
        return (String) map.get(str);
    }

    public static int sz(String str) {
        Map map = (Map) al.agf().getValue("key_share_card_count_map");
        if (map == null) {
            return 0;
        }
        Integer num = (Integer) map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static String it(String str) {
        Map map = (Map) al.agf().getValue("key_share_card_username_map");
        if (map == null) {
            return "";
        }
        return (String) map.get(str);
    }

    public static ArrayList<r> sA(String str) {
        Map map = (Map) al.agf().getValue("key_share_user_info_map");
        if (map == null) {
            map = new HashMap();
        }
        ArrayList<r> arrayList = (ArrayList) map.get(str);
        if (arrayList == null) {
            return new ArrayList();
        }
        return arrayList;
    }

    private static void A(String str, String str2, String str3) {
        Map hashMap;
        ArrayList arrayList;
        Map map = (Map) al.agf().getValue("key_share_user_info_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        ArrayList arrayList2 = (ArrayList) hashMap.get(str2);
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList2;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            r rVar = (r) arrayList.get(i);
            if (str3 != null && str3.equals(rVar.khr)) {
                rVar.kht = false;
                rVar.cEG--;
                rVar.khs.remove(str);
                arrayList.set(i, rVar);
            }
        }
        hashMap.put(str2, arrayList);
        al.agf().putValue("key_share_user_info_map", hashMap);
    }

    public static void agy() {
        w.i("MicroMsg.ShareCardDataMgr", "delelteAllIllegalStatusCard()");
        e.post(new Runnable() {
            public final void run() {
                w.i("MicroMsg.ShareCardDataMgr", "begin to delelteAllIllegalStatusCard()");
                k agi = al.agi();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" where (status=1 OR ").append("status=2 OR status").append("=3 OR status=4").append(" OR status=6)");
                w.i("MicroMsg.ShareCardInfoStorage", "delelteAllIllegalStatusCard updateRet is " + (agi.gUz.eE("ShareCardInfo", new StringBuilder("delete from ShareCardInfo").append(stringBuilder.toString()).toString()) ? 1 : 0));
                w.i("MicroMsg.ShareCardDataMgr", "end to delelteAllIllegalStatusCard()");
            }
        }, "delelteAllIllegalStatusCard");
    }

    public static void O(Context context, String str) {
        Map hashMap;
        w.i("MicroMsg.ShareCardDataMgr", "updateCardCountbyCardTpId() card_tp_id:" + str);
        Map map = (Map) al.agf().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) al.agf().getValue("key_share_card_username_map");
        if (map == null) {
            map = new HashMap();
        }
        hashMap.put(str, Integer.valueOf(al.agi().sE(str)));
        map.put(str, a(context, al.agi().sD(str)));
        al.agf().putValue("key_share_card_count_map", hashMap);
        al.agf().putValue("key_share_card_username_map", map);
    }

    public static boolean ks(int i) {
        Integer num = (Integer) al.agf().getValue("key_share_card_show_type");
        if (num == null) {
            return false;
        }
        if (num.intValue() == 0) {
            return false;
        }
        ArrayList arrayList;
        if (i == 0) {
            arrayList = (ArrayList) al.agf().getValue("key_share_card_other_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                return false;
            }
            return true;
        } else if (i != 10) {
            return false;
        } else {
            arrayList = (ArrayList) al.agf().getValue("key_share_card_local_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                return false;
            }
            return true;
        }
    }

    public static boolean sB(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList arrayList = (ArrayList) al.agf().getValue("key_share_card_other_city_top_info_list");
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (pVar != null && str.equals(pVar.kdE) && pVar.top == 1) {
                return true;
            }
        }
        return false;
    }

    public static void sC(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList;
            ArrayList arrayList2 = (ArrayList) al.agf().getValue("key_share_card_other_city_top_info_list");
            if (arrayList2 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = arrayList2;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                p pVar = (p) arrayList.get(i);
                if (pVar != null && str.equals(pVar.kdE) && pVar.top == 1) {
                    pVar.khq = true;
                    arrayList.set(i, pVar);
                    al.agf().putValue("key_share_card_other_city_top_info_list", arrayList);
                    return;
                }
            }
        }
    }

    public static String by(String str, String str2) {
        w.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId()");
        if (str2 != null) {
            ArrayList sA = sA(str2);
            if (sA == null || sA.size() <= 0) {
                w.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), shareUserInfoList is null");
                return str;
            }
            r rVar = (r) sA.get(0);
            if (rVar == null || rVar.khs == null || rVar.khs.size() <= 0 || str.equals(rVar.khs.get(0))) {
                w.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is first!");
                return str;
            }
            String str3 = (String) rVar.khs.get(0);
            w.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is not first!, reset it");
            return str3;
        }
        w.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), card_tp_id is null");
        return str;
    }

    public static boolean agz() {
        l lVar = (l) al.agf().getValue("key_share_card_layout_data");
        if (lVar == null) {
            return true;
        }
        return lVar.khh;
    }

    public static boolean agA() {
        l lVar = (l) al.agf().getValue("key_share_card_layout_data");
        if (lVar == null) {
            return true;
        }
        return lVar.khi;
    }

    public static void a(Context context, com.tencent.mm.plugin.card.base.b bVar) {
        w.i("MicroMsg.ShareCardDataMgr", "updateShareCardData()");
        w.i("MicroMsg.ShareCardDataMgr", "card id:" + bVar.afm() + " cardtpid:" + bVar.afn());
        bw(bVar.afm(), bVar.afn());
        if (context != null) {
            O(context, bVar.afn());
        }
        A(bVar.afm(), bVar.afn(), bVar.afo());
        sx(bVar.afn());
    }
}
