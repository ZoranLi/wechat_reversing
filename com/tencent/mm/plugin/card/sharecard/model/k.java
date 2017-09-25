package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class k extends i<ShareCardInfo> {
    public static final String[] gUx = new String[]{i.a(ShareCardInfo.gTP, "ShareCardInfo")};
    public e gUz;

    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] keQ = new int[a.afW().length];

        static {
            try {
                keQ[a.kfz - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                keQ[a.kfA - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                keQ[a.kfB - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static String kt(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList kq = b.kq(i);
        if (kq == null || kq.size() <= 0) {
            return "";
        }
        stringBuilder.append(" (");
        for (int i2 = 0; i2 < kq.size(); i2++) {
            if (i2 != 0) {
                stringBuilder.append(" OR ");
            }
            stringBuilder.append("card_id").append(" = '" + ((String) kq.get(i2)) + "' ");
        }
        stringBuilder.append(") AND ");
        return stringBuilder.toString();
    }

    public k(e eVar) {
        super(eVar, ShareCardInfo.gTP, "ShareCardInfo", null);
        this.gUz = eVar;
    }

    public final ArrayList<String> sD(String str) {
        ArrayList<String> arrayList = null;
        w.i("MicroMsg.ShareCardInfoStorage", new StringBuilder("queryNameByCardtpId(), limit is 99").toString());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(new StringBuilder(" limit 99").toString());
        Cursor a = this.gUz.a("select ShareCardInfo.from_username from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            w.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), cursor == null");
        } else {
            int columnIndex = a.getColumnIndex("from_username");
            if (columnIndex == -1) {
                w.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), index is wrong");
                a.close();
            } else {
                arrayList = new ArrayList();
                while (a.moveToNext()) {
                    CharSequence string = a.getString(columnIndex);
                    if (TextUtils.isEmpty(string) || arrayList.contains(string)) {
                        w.e("MicroMsg.ShareCardInfoStorage", "the field_from_username is empty or username is added!, the card id is " + str);
                    } else {
                        arrayList.add(string);
                    }
                    if (arrayList.size() >= 99) {
                        break;
                    }
                }
                a.close();
            }
        }
        return arrayList;
    }

    public final int sE(String str) {
        int i = 0;
        w.i("MicroMsg.ShareCardInfoStorage", "getNormalCount()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        Cursor a = this.gUz.a("select count(*) from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            w.i("MicroMsg.ShareCardInfoStorage", "getNormalCount(), cursor == null");
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final String sF(String str) {
        w.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 1");
        Cursor a = this.gUz.a("select ShareCardInfo.card_id from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            w.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), cursor == null");
            return "";
        }
        int columnIndex = a.getColumnIndex("card_id");
        if (columnIndex == -1) {
            w.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), index is wrong");
            a.close();
            return "";
        }
        String str2 = "";
        if (a.moveToFirst()) {
            str2 = a.getString(columnIndex);
        }
        a.close();
        return str2;
    }

    public final String bz(String str, String str2) {
        w.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str2 + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 2");
        Cursor a = this.gUz.a("select ShareCardInfo.card_id from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            w.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), cursor == null");
            return "";
        }
        int columnIndex = a.getColumnIndex("card_id");
        if (columnIndex == -1) {
            w.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), index is wrong");
            a.close();
            return "";
        }
        String str3 = "";
        while (a.moveToNext()) {
            str3 = a.getString(columnIndex);
            if (str != null && !str.equals(str3)) {
                break;
            }
        }
        a.close();
        return str3;
    }

    public final boolean ku(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (");
        stringBuilder.append("categoryType").append(" = '" + i + "'");
        stringBuilder.append(")");
        boolean eE = this.gUz.eE("ShareCardInfo", "update ShareCardInfo set categoryType = '0' , itemIndex = '0' " + stringBuilder.toString());
        w.i("MicroMsg.ShareCardInfoStorage", "resetCategoryInfo updateRet is " + (eE ? 1 : 0));
        return eE;
    }

    public final boolean y(String str, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        boolean eE = this.gUz.eE("ShareCardInfo", "update ShareCardInfo set categoryType = '" + i + "', itemIndex = '" + i2 + "' " + stringBuilder.toString());
        w.i("MicroMsg.ShareCardInfoStorage", "updateCategoryInfo updateRet is " + (eE ? 1 : 0));
        return eE;
    }

    public final void sG(String str) {
        this.gUz.eE("ShareCardInfo", "delete from ShareCardInfo where card_id = '" + str + "'");
    }

    public final ShareCardInfo sH(String str) {
        c shareCardInfo = new ShareCardInfo();
        shareCardInfo.field_card_id = str;
        return super.b(shareCardInfo, new String[0]) ? shareCardInfo : null;
    }
}
