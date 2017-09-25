package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.c.bab;
import com.tencent.mm.protocal.c.jg;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class l {
    private static SimpleDateFormat krb = null;
    private static SimpleDateFormat krc = null;
    private static SimpleDateFormat krd = null;

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    public static int ta(String str) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            w.e("MicroMsg.CardUtil", "string format error");
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(255, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
            } catch (Exception e) {
                w.e("MicroMsg.CardUtil", e.toString());
            }
        }
        return rgb;
    }

    public static int aF(String str, int i) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            w.e("MicroMsg.CardUtil", "string format error");
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(i, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
            } catch (Exception e) {
                w.e("MicroMsg.CardUtil", e.toString());
            }
        }
        return rgb;
    }

    public static ShapeDrawable u(Context context, int i) {
        return bJ(i, context.getResources().getDimensionPixelOffset(R.f.aYx));
    }

    public static ShapeDrawable bJ(int i, int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static ShapeDrawable d(Context context, int i, int i2) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.aXJ);
        float[] fArr = new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF((float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize), fArr));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i);
        paint.setStrokeWidth((float) dimensionPixelSize);
        return shapeDrawable;
    }

    public static List<b> Z(List<jg> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<b> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            jg jgVar = (jg) list.get(i);
            b bVar = new b();
            bVar.title = jgVar.title;
            bVar.kdH = jgVar.kdH;
            bVar.khk = jgVar.khk;
            bVar.url = jgVar.url;
            bVar.tpl = jgVar.tpl;
            bVar.kdT = false;
            bVar.tpm = jgVar.tpm;
            bVar.tpn = jgVar.tpn;
            bVar.ofg = jgVar.ofg;
            bVar.tnY = jgVar.tnY;
            bVar.tnZ = jgVar.tnZ;
            bVar.kdS = 1;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static String aq(long j) {
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (krb == null) {
            krb = new SimpleDateFormat("yyyy.MM.dd");
        }
        return krb.format(new Date(j2));
    }

    public static boolean tb(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static Bitmap o(Bitmap bitmap) {
        boolean z = true;
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(90.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        String str = "MicroMsg.CardUtil";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        w.d(str, stringBuilder.append(z).append("  degree:90.0").toString());
        return createBitmap;
    }

    public static void p(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            w.i("MicroMsg.CardUtil", "bitmap recycle %s", new Object[]{bitmap});
            bitmap.recycle();
        }
    }

    public static boolean b(CardInfo cardInfo) {
        if (cardInfo == null) {
            w.e("MicroMsg.CardUtil", "processCardObject fail, card is null");
            return false;
        }
        CardInfo sr = al.aga().sr(cardInfo.field_card_id);
        if (sr == null) {
            boolean b = al.aga().b(cardInfo);
            w.d("MicroMsg.CardUtil", "processCardObject, insertRet = %b", new Object[]{Boolean.valueOf(b)});
            if (!b) {
                w.e("MicroMsg.CardUtil", "processCardObject, insert fail");
            }
            return b;
        }
        cardInfo.field_stickyIndex = sr.field_stickyIndex;
        cardInfo.field_stickyEndTime = sr.field_stickyEndTime;
        cardInfo.field_stickyAnnouncement = sr.field_stickyAnnouncement;
        w.d("MicroMsg.CardUtil", "processCardObject, updateRet = %b", new Object[]{Boolean.valueOf(al.aga().c(cardInfo, new String[0]))});
        return al.aga().c(cardInfo, new String[0]);
    }

    public static void a(com.tencent.mm.plugin.card.base.b bVar, String str, String str2, int i) {
        byte[] K;
        a aVar;
        Bitmap a = j.a(new m(bVar.afi().kdG));
        if (a != null) {
            K = d.K(a);
        } else {
            K = null;
        }
        if (bVar == null) {
            aVar = null;
        } else {
            int i2;
            if (i == 23) {
                i = 2;
                i2 = 1;
            } else {
                i2 = 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            a aVar2 = new a();
            if (bVar.afi() != null) {
                aVar2.title = bVar.afk().ubj;
                aVar2.description = bVar.afi().title;
                aVar2.type = 16;
                aVar2.showType = 0;
                aVar2.hht = 3;
                aVar2.appId = bVar.afi().fTO;
                aVar2.hhJ = 0;
                aVar2.thumburl = bVar.afi().kdG;
                aVar2.hiA = i;
                aVar2.hiz = bVar.afi().keT;
                aVar2.url = bVar.afi().toq;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("<from_username>").append(bVar.afo()).append("</from_username>");
            if (kF(i)) {
                stringBuilder2.append("<card_id>").append(bVar.afn()).append("</card_id>");
            } else if (i == 5) {
                stringBuilder2.append("<card_id>").append(bVar.afm()).append("</card_id>");
            }
            stringBuilder2.append("<card_type>").append(bVar.afi().kdF).append("</card_type>");
            stringBuilder2.append("<from_scene>").append(i).append("</from_scene>");
            stringBuilder2.append("<color>").append(bVar.afi().hib).append("</color>");
            stringBuilder2.append("<card_type_name>").append(bVar.afi().keS).append("</card_type_name>");
            stringBuilder2.append("<brand_name>").append(bVar.afi().keT).append("</brand_name>");
            if (TextUtils.isEmpty(str2)) {
                stringBuilder2.append("<card_ext></card_ext>");
            } else {
                stringBuilder2.append("<card_ext>").append(str2).append("</card_ext>");
            }
            stringBuilder2.append("<is_recommend>").append(i2).append("</is_recommend>");
            stringBuilder2.append("<recommend_card_id>").append(bVar.afm()).append("</recommend_card_id>");
            aVar2.hiy = stringBuilder.append(stringBuilder2.toString()).toString();
            aVar2.fNg = a.a(aVar2, null, null);
            aVar = aVar2;
        }
        com.tencent.mm.pluginsdk.model.app.l.a(aVar, bVar.afi().fTO, bVar.afi().keT, str, null, K);
    }

    public static void bF(String str, String str2) {
        if (!bg.mA(str)) {
            com.tencent.mm.sdk.b.b nvVar = new nv();
            nvVar.fVa.fVb = str2;
            nvVar.fVa.content = str;
            nvVar.fVa.type = o.fG(str2);
            nvVar.fVa.flags = 0;
            com.tencent.mm.sdk.b.a.urY.m(nvVar);
        }
    }

    public static boolean kF(int i) {
        return i == 0 || i == 1 || i == 2 || i == 9 || i == 12 || i == 17 || i == 21;
    }

    public static boolean kG(int i) {
        return i == 7 || i == 8 || i == 16 || i == 26;
    }

    public static boolean kH(int i) {
        return i == 3 || i == 4 || i == 5 || i == 15;
    }

    public static boolean ko(int i) {
        switch (i) {
            case 0:
            case 10:
            case 11:
            case 20:
            case 30:
                return true;
            default:
                return false;
        }
    }

    public static void aiI() {
        ap.yY();
        Integer num = (Integer) c.vr().get(282883, null);
        if (num == null || num.intValue() != 1) {
            w.i("MicroMsg.CardUtil", "open card entrance");
            ap.yY();
            c.vr().set(282883, Integer.valueOf(1));
            com.tencent.mm.q.c.uk().s(262152, true);
            return;
        }
        w.i("MicroMsg.CardUtil", "card entrance is open");
    }

    public static boolean aiJ() {
        ap.yY();
        Integer num = (Integer) c.vr().get(282883, null);
        if (num == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public static void aiK() {
        ap.yY();
        Integer num = (Integer) c.vr().get(com.tencent.mm.storage.w.a.uAP, Integer.valueOf(0));
        if (num == null || num.intValue() != 1) {
            w.i("MicroMsg.CardUtil", "open share card entrance");
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uAP, Integer.valueOf(1));
            com.tencent.mm.q.c.uk().s(262152, true);
            return;
        }
        w.i("MicroMsg.CardUtil", "share card entrance is open");
    }

    public static boolean aiL() {
        ap.yY();
        Integer num = (Integer) c.vr().get(com.tencent.mm.storage.w.a.uAP, null);
        if (num == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public static String d(Context context, float f) {
        if (f <= 0.0f) {
            return "";
        }
        if (f > 0.0f && f < 1000.0f) {
            return context.getString(R.l.dQJ, new Object[]{((int) f)});
        } else if (f < 1000.0f) {
            return "";
        } else {
            int i = R.l.dQI;
            Object[] objArr = new Object[1];
            objArr[0] = new DecimalFormat("0.00").format((double) (f / 1000.0f));
            return context.getString(i, objArr);
        }
    }

    public static boolean Gl() {
        try {
            return ((LocationManager) ab.getContext().getSystemService("location")).isProviderEnabled("gps");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CardUtil", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean Gm() {
        try {
            return ((LocationManager) ab.getContext().getSystemService("location")).isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CardUtil", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean a(ShareCardInfo shareCardInfo) {
        if (shareCardInfo == null) {
            w.e("MicroMsg.CardUtil", "processShareCardObject fail, card is null");
            return false;
        }
        ShareCardInfo sH = al.agi().sH(shareCardInfo.field_card_id);
        if (sH == null) {
            boolean b = al.agi().b(shareCardInfo);
            w.d("MicroMsg.CardUtil", "processShareCardObject, insertRet = %b", new Object[]{Boolean.valueOf(b)});
            if (b) {
                com.tencent.mm.plugin.card.sharecard.a.b.bx(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
            } else {
                w.e("MicroMsg.CardUtil", "processShareCardObject, insert fail");
            }
            return b;
        }
        shareCardInfo.field_categoryType = sH.field_categoryType;
        shareCardInfo.field_itemIndex = sH.field_itemIndex;
        w.d("MicroMsg.CardUtil", "processShareCardObject, updateRet = %b", new Object[]{Boolean.valueOf(al.agi().c(shareCardInfo, new String[0]))});
        return al.agi().c(shareCardInfo, new String[0]);
    }

    public static boolean j(com.tencent.mm.plugin.card.base.b bVar) {
        boolean c;
        if (bVar instanceof CardInfo) {
            c = al.aga().c((CardInfo) bVar, new String[0]);
            if (c) {
                return c;
            }
            w.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[]{bVar.afm()});
            return c;
        } else if (!(bVar instanceof ShareCardInfo)) {
            return false;
        } else {
            c = al.agi().c((ShareCardInfo) bVar, new String[0]);
            if (c) {
                return c;
            }
            w.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[]{bVar.afm()});
            return c;
        }
    }

    public static void tc(String str) {
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uAN, str);
    }

    public static String aiM() {
        ap.yY();
        return (String) c.vr().get(com.tencent.mm.storage.w.a.uAN, "");
    }

    public static String td(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        CharSequence eL = n.eL(str);
        CharSequence eK = n.eK(str);
        if (!TextUtils.isEmpty(eL)) {
            return eL;
        }
        if (TextUtils.isEmpty(eK)) {
            return str;
        }
        return eK;
    }

    public static ArrayList<String> aa(List<String> list) {
        if (list == null || list.isEmpty()) {
            w.e("MicroMsg.CardUtil", "getContactNamesFromLabels labels is empty!");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        for (String ze : list) {
            Collection zh = com.tencent.mm.plugin.label.a.a.aFG().zh(com.tencent.mm.plugin.label.a.a.aFG().ze(ze));
            if (zh == null || zh.size() == 0) {
                w.e("MicroMsg.CardUtil", "getContactNamesFromLabels, namelist get bu label is null");
            } else {
                hashSet.addAll(zh);
            }
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public static ArrayList<String> ab(List<String> list) {
        if (list == null || list.isEmpty()) {
            w.e("MicroMsg.CardUtil", "getContactIdsFromLabels labels is empty!");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String ze : list) {
            CharSequence ze2 = com.tencent.mm.plugin.label.a.a.aFG().ze(ze);
            if (!TextUtils.isEmpty(ze2)) {
                arrayList.add(ze2);
            }
        }
        return arrayList;
    }

    public static String te(String str) {
        List list;
        List<Object> asList = Arrays.asList(str.split(","));
        List linkedList = new LinkedList();
        if (ap.zb()) {
            if (asList == null || asList.size() == 0) {
                list = linkedList;
                return bg.c(list, ",");
            }
            for (Object obj : asList) {
                Object obj2;
                ap.yY();
                com.tencent.mm.j.a Rc = c.wR().Rc(obj2);
                if (!(Rc == null || ((int) Rc.gTQ) == 0)) {
                    obj2 = Rc.tL();
                }
                linkedList.add(obj2);
            }
        }
        list = linkedList;
        return bg.c(list, ",");
    }

    public static bab a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        w.i("MicroMsg.CardUtil", "getShareTag()");
        bab com_tencent_mm_protocal_c_bab = new bab();
        Collection arrayList3;
        int i2;
        String str;
        if (i == 2) {
            if (arrayList != null && arrayList.size() > 0) {
                com_tencent_mm_protocal_c_bab.ubk.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList3 = new ArrayList();
                for (i2 = 0; i2 < arrayList2.size(); i2++) {
                    str = (String) arrayList2.get(i2);
                    if (!TextUtils.isEmpty(str) && tb(str)) {
                        arrayList3.add(Integer.valueOf(str));
                    }
                }
                com_tencent_mm_protocal_c_bab.ubm.addAll(arrayList3);
            }
        } else if (i == 3) {
            if (arrayList != null && arrayList.size() > 0) {
                com_tencent_mm_protocal_c_bab.ubl.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList3 = new ArrayList();
                for (i2 = 0; i2 < arrayList2.size(); i2++) {
                    str = (String) arrayList2.get(i2);
                    if (!TextUtils.isEmpty(str) && tb(str)) {
                        arrayList3.add(Integer.valueOf(str));
                    }
                }
                com_tencent_mm_protocal_c_bab.ubn.addAll(arrayList3);
            }
        }
        return com_tencent_mm_protocal_c_bab;
    }

    public static boolean a(lz lzVar, String str) {
        if (aN(lzVar.tpl)) {
            String str2 = lzVar.title;
            if (tf(str)) {
                w.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
                return false;
            }
            w.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            return true;
        }
        w.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
        return false;
    }

    public static boolean a(b bVar, String str) {
        if (aN(bVar.tpl)) {
            String str2 = bVar.title;
            if (tf(str)) {
                w.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
                return false;
            }
            w.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            return true;
        }
        w.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
        return false;
    }

    private static boolean aN(long j) {
        if ((8 & j) <= 0) {
            return false;
        }
        w.i("MicroMsg.CardUtil", "shouldShowWarning show the warning!");
        return true;
    }

    private static boolean tf(String str) {
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.CardUtil", "hasShowTheWarning card_id or title is empty!");
            return true;
        }
        w.i("MicroMsg.CardUtil", "hasShowWarning()");
        ap.yY();
        String str2 = (String) c.vr().get(com.tencent.mm.storage.w.a.uAU, "");
        if (TextUtils.isEmpty(str2)) {
            w.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
            return false;
        }
        String[] split = str2.split(",");
        if (split == null || split.length == 0) {
            w.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
            return false;
        }
        for (Object equals : split) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static void tg(String str) {
        Object obj = null;
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.CardUtil", "setShowWarningFlag card_id or title is empty!");
            return;
        }
        w.i("MicroMsg.CardUtil", "setShowWarningFlag()");
        ap.yY();
        String str2 = (String) c.vr().get(com.tencent.mm.storage.w.a.uAU, "");
        if (TextUtils.isEmpty(str2)) {
            w.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
        } else {
            String[] split = str2.split(",");
            if (split == null || split.length == 0) {
                w.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
                str2 = str;
            }
            for (Object equals : split) {
                if (str.equals(equals)) {
                    obj = 1;
                }
            }
            str = obj == null ? str2 + "," + str : str2;
        }
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uAU, str);
    }

    public static String o(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        float f = al.agg().gKk;
        float f2 = al.agg().gKj;
        if (f == -1000.0f || f2 == -85.0f) {
            w.e("MicroMsg.CardUtil", "getRedirectUrl() location info is empty!");
            return str;
        } else if ((16 & j) <= 0) {
            return str;
        } else {
            String replace = str.replace("#", ("&longitude=" + f + "&latitude=" + f2) + "#");
            w.i("MicroMsg.CardUtil", "getRedirectUrl originalUrl:" + str);
            w.i("MicroMsg.CardUtil", "getRedirectUrl afterwardsUrl:" + replace);
            return replace;
        }
    }

    public static int th(String str) {
        if (TextUtils.isEmpty(str) || str.equals(com.tencent.mm.u.m.xL())) {
            return 0;
        }
        return 1;
    }

    public static Drawable c(Context context, String str, int i) {
        Drawable d = d(context, ta(str), i);
        Drawable bJ = bJ(ta(str), i);
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, bJ);
        stateListDrawable.addState(new int[0], d);
        return stateListDrawable;
    }

    public static ColorStateList R(Context context, String str) {
        return new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, new int[]{context.getResources().getColor(R.e.white), ta(str)});
    }
}
