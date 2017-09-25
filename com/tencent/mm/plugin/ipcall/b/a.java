package com.tencent.mm.plugin.ipcall.b;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.as;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.x.b;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public final class a {
    public static int mYA = 3;
    public static String mYB = "+";
    public static String mYC = "00";
    public static String mYD = null;
    private static an mYE = new an();
    private static HashMap<String, b> mYF = new HashMap();
    private static HashMap<String, String> mYG = new HashMap();
    private static HashMap<String, String> mYH = new HashMap();
    private static HashMap<String, String> mYI = new HashMap();
    private static HashMap<String, String> mYJ = new HashMap();

    private static class a implements Comparator<String> {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((String) obj).length() - ((String) obj2).length();
        }
    }

    public static String ai(Context context, String str) {
        String str2 = null;
        if (com.tencent.mm.pluginsdk.i.a.aT(context, "android.permission.READ_CONTACTS")) {
            Cursor query = context.getContentResolver().query(Phone.CONTENT_URI, new String[]{"contact_id", "data1"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        while (!query.isAfterLast()) {
                            if (PhoneNumberUtils.compare(com.tencent.mm.pluginsdk.a.Di(str), query.getString(1))) {
                                str2 = query.getString(0);
                                break;
                            }
                            query.moveToNext();
                        }
                    }
                } catch (Exception e) {
                    w.d("MicroMsg.IPCallAddressUtil", "getNicknameByPhonenumber, error: %s", new Object[]{e.getMessage()});
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } else {
            w.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        }
        return str2;
    }

    public static String aj(Context context, String str) {
        String ai = ai(context, str);
        if (bg.mA(ai)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.a.g(ai, context);
    }

    public static String ak(Context context, String str) {
        if (bg.mA(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.a.g(str, context);
    }

    public static Bitmap al(Context context, String str) {
        return f(context, str, false);
    }

    public static Bitmap f(Context context, String str, boolean z) {
        if (bg.mA(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.a.a(str, context, z);
    }

    public static Bitmap am(Context context, String str) {
        String ai = ai(context, str);
        Bitmap bitmap = null;
        if (!bg.mA(ai)) {
            bitmap = f(context, ai, true);
        }
        if (bitmap != null || !Fo()) {
            return bitmap;
        }
        ai = yP(str);
        w.d("MicroMsg.IPCallAddressUtil", "getAvatarByPhoneNumber, username: %s", new Object[]{ai});
        if (bg.mA(ai)) {
            return bitmap;
        }
        return b.b(ai, 320, 320, 4);
    }

    public static String yP(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.l.a.sBD.jc(g.n(c.zc(str).getBytes()));
    }

    public static String yQ(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.l.a.sBD.jd(str);
    }

    public static String oy(int i) {
        Context context = ab.getContext();
        switch (i) {
            case 1:
                return context.getString(R.l.eFS);
            case 2:
                return context.getString(R.l.eFU);
            case 4:
                return context.getString(R.l.eFR);
            case 5:
                return context.getString(R.l.eFT);
            case 10:
                return context.getString(R.l.eFQ);
            default:
                return context.getString(R.l.eFV);
        }
    }

    private static void aFt() {
        String str;
        mYG.clear();
        mYH.clear();
        mYI.clear();
        mYJ.clear();
        mYF.clear();
        InputStream inputStream = null;
        String str2 = "";
        try {
            inputStream = ab.getContext().getAssets().open("ipcall_country_code.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    w.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{bg.g(e)});
                }
            }
        } catch (Throwable e2) {
            w.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{bg.g(e2)});
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str = str2;
                } catch (Throwable e22) {
                    w.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{bg.g(e22)});
                    str = str2;
                }
            } else {
                str = str2;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    w.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{bg.g(e3)});
                }
            }
        }
        String[] split = str.trim().split("\n");
        for (String str3 : split) {
            String[] split2 = str3.trim().split(" ");
            if (split2.length < 2) {
                w.e("MicroMsg.IPCallAddressUtil", "this country item has problem %s", new Object[]{split[r1]});
            } else {
                b bVar = new b();
                bVar.mYK = split2[0];
                bVar.mYL = split2[1];
                RegionCodeDecoder.bMP();
                str3 = RegionCodeDecoder.getLocName(split2[0]);
                if (bg.mA(str3)) {
                    str3 = new Locale("", split2[0]).getDisplayCountry(ab.getResources().getConfiguration().locale);
                }
                bVar.mYM = str3;
                mYI.put(bVar.mYL, bVar.mYK);
                mYJ.put(bVar.mYK, bVar.mYL);
                mYG.put(bVar.mYL, bVar.mYM);
                mYH.put(bVar.mYM, bVar.mYL);
                mYF.put(bVar.mYK, bVar);
            }
        }
    }

    public static HashMap<String, b> aFu() {
        if (mYF.size() == 0) {
            aFt();
        }
        return mYF;
    }

    public static String yR(String str) {
        if (mYF.size() == 0) {
            aFt();
        }
        if (bg.mA(str)) {
            return null;
        }
        b bVar = (b) mYF.get(str);
        return bVar != null ? bVar.mYM : null;
    }

    public static String yS(String str) {
        if (mYG.size() == 0) {
            aFt();
        }
        if (bg.mA(str)) {
            return null;
        }
        return (String) mYG.get(str);
    }

    public static String yT(String str) {
        if (mYI.size() == 0) {
            aFt();
        }
        if (bg.mA(str)) {
            return null;
        }
        return (String) mYI.get(str);
    }

    public static int cC(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            return -1;
        }
        int cD = cD(str, str2);
        if (cD != -1 || !str2.startsWith("+")) {
            return cD;
        }
        String yU = yU(str2);
        if (!bg.mA(yU)) {
            str2 = str2.substring(("+" + yU).length());
        }
        return cD(str, str2);
    }

    private static int cD(String str, String str2) {
        int i;
        if (com.tencent.mm.pluginsdk.i.a.aT(ab.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ab.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            String zc = c.zc(str2);
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        i = query.getInt(query.getColumnIndex("data2"));
                        if (c.zc(query.getString(query.getColumnIndex("data1"))).equals(zc)) {
                            return i;
                        }
                        query.moveToNext();
                    }
                }
                query.close();
            } catch (Exception e) {
                Object[] objArr = new Object[1];
                i = e.getMessage();
                objArr[0] = i;
                w.e("MicroMsg.IPCallAddressUtil", "getPhoneTypeByContactIdAndPhoneNumber error: %s", objArr);
            } finally {
                query.close();
            }
            return -1;
        }
        w.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        return -1;
    }

    public static String yU(String str) {
        if (mYG.size() == 0) {
            aFt();
        }
        if (yW(str)) {
            String zc = c.zc(yX(str));
            List<String> arrayList = new ArrayList(mYG.keySet());
            Collections.sort(arrayList, Collections.reverseOrder(new a()));
            for (String str2 : arrayList) {
                if (zc.startsWith(str2)) {
                    return str2;
                }
            }
        }
        return null;
    }

    public static boolean yV(String str) {
        if (mYG.size() == 0) {
            aFt();
        }
        if (mYG.containsKey(str)) {
            return true;
        }
        return false;
    }

    public static boolean yW(String str) {
        if (bg.mA(str) || (!str.startsWith(mYB) && !str.startsWith(mYC))) {
            return false;
        }
        return true;
    }

    public static String yX(String str) {
        if (bg.mA(str)) {
            return str;
        }
        if (str.startsWith(mYB)) {
            return str.substring(mYB.length());
        }
        if (str.startsWith(mYC)) {
            return str.substring(mYC.length());
        }
        return str;
    }

    public static String yY(String str) {
        String zc = c.zc(str);
        String zc2 = c.zc(zc);
        String str2 = null;
        if (yW(zc2)) {
            str2 = yU(zc2);
        }
        if (bg.mA(str2)) {
            str2 = an.PA(zc);
        } else {
            zc = yX(zc2).substring(str2.length());
            zc2 = an.formatNumber(str2, zc);
            if (!bg.mA(zc2)) {
                zc = zc2;
            }
            str2 = !zc.startsWith("+") ? "+" + str2 + " " + zc : "+" + str2 + " " + zc.replace("+", "");
        }
        if (str2.length() > 25) {
            return str2.substring(0, 25) + "...";
        }
        return str2;
    }

    public static String aFv() {
        if (mYH.size() == 0) {
            aFt();
        }
        String bJW = bg.bJW();
        if (!bg.mA(bJW)) {
            w.i("MicroMsg.IPCallAddressUtil", "simCountryCode: %s", new Object[]{bJW});
            bJW = (String) mYJ.get(bJW.toUpperCase());
            if (!bg.mA(bJW)) {
                w.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[]{bJW});
                if (!bg.mA(bJW)) {
                    return bJW;
                }
                bJW = com.tencent.mm.u.bg.zL().countryCode;
                w.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", new Object[]{bJW});
                if (!bg.mA(bJW)) {
                    bJW = (String) mYJ.get(bJW);
                    if (!bg.mA(bJW)) {
                        w.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[]{bJW});
                        return bJW;
                    }
                }
                w.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", new Object[]{ab.getContext().getString(R.l.eaP)});
                return ab.getContext().getString(R.l.eaP).replace("+", "");
            }
        }
        bJW = "";
        if (!bg.mA(bJW)) {
            return bJW;
        }
        bJW = com.tencent.mm.u.bg.zL().countryCode;
        w.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", new Object[]{bJW});
        if (bg.mA(bJW)) {
            bJW = (String) mYJ.get(bJW);
            if (bg.mA(bJW)) {
                w.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[]{bJW});
                return bJW;
            }
        }
        w.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", new Object[]{ab.getContext().getString(R.l.eaP)});
        return ab.getContext().getString(R.l.eaP).replace("+", "");
    }

    public static void aFw() {
        aFt();
    }

    public static String yZ(String str) {
        if (mYG.size() == 0) {
            aFt();
        }
        if (!yW(str)) {
            return str;
        }
        str = c.zc(yX(str));
        List<String> arrayList = new ArrayList(mYG.keySet());
        Collections.sort(arrayList, Collections.reverseOrder(new a()));
        for (String str2 : arrayList) {
            if (str.startsWith(str2)) {
                return str.substring(str2.length());
            }
        }
        return str;
    }

    public static boolean Fo() {
        com.tencent.mm.sdk.b.b asVar = new as();
        com.tencent.mm.sdk.b.a.urY.m(asVar);
        w.d("MicroMsg.IPCallAddressUtil", "canSyncAddrBook: %b", new Object[]{Boolean.valueOf(asVar.fEh.fDU)});
        return asVar.fEh.fDU;
    }

    public static ArrayList<String> za(String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (com.tencent.mm.pluginsdk.i.a.aT(ab.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ab.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "data1 LIKE ?", new String[]{"%" + str + "%"}, null);
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        arrayList.add(query.getString(query.getColumnIndex("contact_id")));
                        query.moveToNext();
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                w.e("MicroMsg.IPCallAddressUtil", "getQueryPhoneNumberContactIdList error: %s", new Object[]{e.getMessage()});
                return arrayList;
            } finally {
                if (query != null) {
                    query.close();
                }
            }
            return arrayList;
        }
        w.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        return arrayList;
    }
}
