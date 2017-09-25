package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class e {
    private static SimpleDateFormat kFt = null;
    private static final String[] rKi = new String[]{"ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "COMM_DEBIT", "HSBC_DEBIT"};
    protected static final Pattern sTp = Pattern.compile("((?:(http|https|Http|Https):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9][a-zA-Z0-9\\-\\_]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnrwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eouw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agkmsyz]|v[aceginu]|w[fs]|y[etu]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
    private static Typeface wFy;

    public interface a {
        void J(Map<String, Object> map);
    }

    public interface b {
        void bo(Object obj);
    }

    public static class c {
        public String arH = null;
        public Object uvf = null;

        public c(String str, Object obj) {
            this.arH = str;
            this.uvf = obj;
        }
    }

    public static Typeface fm(Context context) {
        if (wFy == null) {
            wFy = Typeface.createFromAsset(context.getAssets(), "fonts/WeChatNum.ttf");
        }
        return wFy;
    }

    public static void setNoSystemInputOnEditText(EditText editText) {
        if (VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            return;
        }
        Class cls = EditText.class;
        try {
            Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
            method.setAccessible(false);
            method.invoke(editText, new Object[]{Boolean.valueOf(false)});
        } catch (NoSuchMethodException e) {
            w.e("erik", "setShowSoftInputOnFocus exception!");
            try {
                Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                method2.setAccessible(false);
                method2.invoke(editText, new Object[]{Boolean.valueOf(false)});
            } catch (Throwable e2) {
                editText.setInputType(0);
                w.printErrStackTrace("MicroMsg.WalletBaseUtil ", e2, "", new Object[0]);
            }
        } catch (Throwable e22) {
            w.printErrStackTrace("MicroMsg.WalletBaseUtil ", e22, "", new Object[0]);
        }
    }

    public static void ccH() {
    }

    public static String d(double d, String str) {
        if ("CNY".equals(str)) {
            return String.format("¥%.2f", new Object[]{Double.valueOf(d)});
        } else if ("ZAR".equals(str)) {
            return String.format("R%.2f", new Object[]{Double.valueOf(d)});
        } else if ("1".equals(str) || bg.mA(str)) {
            return String.format(s.ccn() + "%.2f", new Object[]{Double.valueOf(d)});
        } else {
            return String.format(str + "%.2f", new Object[]{Double.valueOf(d)});
        }
    }

    public static String UG(String str) {
        if ("CNY".equals(str)) {
            return "¥";
        }
        if ("ZAR".equals(str)) {
            return "R";
        }
        if ("1".equals(str) || bg.mA(str)) {
            return s.ccn();
        }
        return str;
    }

    public static String o(double d) {
        return d(d, "");
    }

    public static String n(double d) {
        return String.format("%.2f", new Object[]{Double.valueOf(d)});
    }

    public static String UH(String str) {
        if ("CNY".equals(str) || "1".equals(str) || bg.mA(str)) {
            return "¥";
        }
        return str;
    }

    public static String CK(int i) {
        if (kFt == null) {
            kFt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }
        return kFt.format(new Date(((long) i) * 1000));
    }

    public static String CL(int i) {
        return a(i, new SimpleDateFormat("MM-dd HH:mm"), new SimpleDateFormat("yyyy-MM-dd HH:mm"));
    }

    public static String a(int i, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2) {
        long j = ((long) i) * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j);
        if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
            return simpleDateFormat.format(new Date(j));
        }
        return simpleDateFormat2.format(new Date(j));
    }

    public static void Q(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            w.v("MicroMsg.WalletBaseUtil ", "username is null");
        } else if (o.eU(str)) {
            bo(context, str);
        } else {
            P(context, str);
        }
    }

    public static void m(Context context, String str, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", z);
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public static void n(Context context, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, i);
    }

    public static void P(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            w.v("MicroMsg.WalletBaseUtil ", "username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        intent.putExtra("force_get_contact", true);
        d.a(context, "com.tencent.mm.plugin.profile.ui.ContactInfoUI", intent);
    }

    public static void fn(Context context) {
        if (context == null) {
            w.e("MicroMsg.WalletBaseUtil ", "hy: jump to preference error. context is null");
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        d.a(context, "com.tencent.mm.ui.LauncherUI", intent);
    }

    public static void bo(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            w.v("MicroMsg.WalletBaseUtil ", "username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        d.a(context, ".ui.chatting.En_5b8fbb1e", intent);
    }

    public static boolean UI(String str) {
        if (sTp.matcher(str).matches()) {
            return true;
        }
        return false;
    }

    public static String UJ(String str) {
        if (bg.mA(str)) {
            return str;
        }
        String str2 = "";
        for (int i = 0; i < str.length() - 1; i++) {
            str2 = str2 + "*";
        }
        return str2 + str.substring(str.length() - 1, str.length());
    }

    public static boolean f(JSONObject jSONObject, String str) {
        return "1".equals(jSONObject.optString(str, "0"));
    }

    public static String getUsername() {
        h.vG().uQ();
        return m.xL();
    }

    public static String UK(String str) {
        if (str == null || str.length() <= 8) {
            return str;
        }
        int length = str.length();
        String substring = str.substring(0, length - 8);
        return substring + "****" + str.substring(length - 4);
    }

    public static String UL(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String substring = str.substring(1, str.length());
        w.d("MicroMsg.WalletBaseUtil ", "tail : " + substring);
        String substring2 = str.substring(0, 1);
        w.d("MicroMsg.WalletBaseUtil ", "head : " + substring2);
        w.d("MicroMsg.WalletBaseUtil ", "after : " + substring2);
        return "*" + substring;
    }

    public static String UM(String str) {
        if (str == null || str.length() < 2) {
            return UL(str);
        }
        return "**" + str.substring(str.length() - 1, str.length());
    }

    public static void a(final Context context, final String str, String str2, boolean z, boolean z2) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(context.getString(R.l.fef));
        linkedList2.add(Integer.valueOf(0));
        if (str != null && z2) {
            linkedList.add(context.getString(R.l.fee));
            linkedList2.add(Integer.valueOf(1));
        }
        if (z && !bg.mA(str2)) {
            linkedList.add(context.getString(R.l.feg, new Object[]{str2}));
            linkedList2.add(Integer.valueOf(2));
            linkedList.add(context.getString(R.l.feh, new Object[]{str2}));
            linkedList2.add(Integer.valueOf(3));
        }
        g.a(context, "", linkedList, linkedList2, "", new g.d() {
            public final void bN(int i, int i2) {
                Intent intent = new Intent();
                switch (i) {
                    case 0:
                        intent.putExtra("rawUrl", context.getString(R.l.fda, new Object[]{v.bIN()}));
                        break;
                    case 1:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(R.l.fcZ, new Object[]{v.bIN(), str}));
                            break;
                        }
                        break;
                    case 2:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(R.l.fdb, new Object[]{v.bIN(), str}));
                            break;
                        }
                        break;
                    case 3:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(R.l.fdc, new Object[]{v.bIN(), str}));
                            break;
                        }
                        break;
                }
                intent.putExtra("showShare", false);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    public static void e(MMActivity mMActivity, String str) {
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("bank_card_owner", str);
        d.b((Context) mMActivity, "scanner", ".ui.BaseScanUI", intent);
    }

    public static String eK(String str) {
        String str2 = null;
        ap.yY();
        com.tencent.mm.j.a Rb = com.tencent.mm.u.c.wR().Rb(str);
        if (Rb != null) {
            str2 = Rb.tL();
        }
        return bg.mA(str2) ? str : str2;
    }

    public static void bp(Context context, String str) {
        if (!bg.mA(str)) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
        }
    }

    public static long p(double d) {
        return Math.round(100.0d * d);
    }

    public static void a(final c... cVarArr) {
        ap.vd().a(new bb(new com.tencent.mm.u.bb.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                if (eVar != null && eVar.Cc() != null) {
                    if (cVarArr == null || cVarArr.length == 0) {
                        w.w("MicroMsg.WalletBaseUtil ", "hy: kvs is null or length is 0");
                        return;
                    }
                    try {
                        for (c cVar : cVarArr) {
                            if (!(cVar == null || bg.mA(cVar.arH))) {
                                eVar.Cc().h(cVar.arH, e.bR(cVar.uvf));
                            }
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.WalletBaseUtil ", "hy: serialize failed: %s", e.toString());
                    }
                }
            }
        }), 0);
    }

    public static void a(final String str, final b bVar) {
        ap.vd().a(new bb(new com.tencent.mm.u.bb.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                if (eVar != null && eVar.Cc() != null) {
                    if (bg.mA(str)) {
                        w.w("MicroMsg.WalletBaseUtil ", "hy: key is null");
                        return;
                    }
                    try {
                        byte[] hu = eVar.Cc().hu(str);
                        if (bVar == null) {
                            return;
                        }
                        if (hu != null) {
                            bVar.bo(e.br(hu));
                        } else {
                            bVar.bo(null);
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", e.toString());
                        if (bVar != null) {
                            bVar.bo(null);
                        }
                    }
                }
            }
        }), 0);
    }

    public static void ccI() {
        ap.vd().a(new bb(new com.tencent.mm.u.bb.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                eVar.Ce();
            }
        }), 0);
    }

    public static String UN(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length() / 4;
        for (int i = 0; i < length + 1; i++) {
            int min = Math.min((i + 1) * 4, str.length());
            stringBuilder.append(fa(str.substring(i * 4, min), ""));
            if (min - (i * 4) == 4) {
                for (min = 0; min < 4; min++) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String UO(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length() / 4;
        for (int i = 0; i < length; i++) {
            int min = Math.min((i + 1) * 4, str.length());
            if (min + 4 > str.length()) {
                min = str.length();
            }
            stringBuilder.append(fa(str.substring(i * 4, min), " "));
            if (min - (i * 4) == 4) {
                for (min = 0; min < 6; min++) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void am(ArrayList<Bitmap> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            for (int size = arrayList.size() - 1; size > 0; size--) {
                p((Bitmap) arrayList.remove(size));
            }
        }
    }

    public static void p(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public static Bitmap o(Bitmap bitmap) {
        boolean z = true;
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(90.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        String str = "MicroMsg.WalletBaseUtil ";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        w.d(str, stringBuilder.append(z).append("  degree:90.0").toString());
        return createBitmap;
    }

    private static String fa(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.substring(i, i + 1));
            if (i != str.length() - 1) {
                stringBuilder.append(str2);
            }
        }
        return stringBuilder.toString();
    }

    public static void fo(Context context) {
        if (context == null) {
            w.e("MicroMsg.WalletBaseUtil ", "jumpToWalletSecure context is null");
            return;
        }
        String string;
        if (!p.n(context, "com.tencent.qqpimsecure")) {
            string = context.getResources().getString(R.l.eZy);
        } else if (bg.bb(context, "com.tencent.qqpimsecure")) {
            string = context.getResources().getString(R.l.eZy) + "&qqpimsecurestatus=1";
        } else {
            string = context.getResources().getString(R.l.eZy) + "&qqpimsecurestatus=0";
        }
        w.v("MicroMsg.WalletBaseUtil ", "jump to %s", string + "&lang=" + v.bIN());
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("pay_channel", 1);
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public static void a(final String[] strArr, final a aVar) {
        ap.vd().a(new bb(new com.tencent.mm.u.bb.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                if (eVar != null && eVar.Cc() != null) {
                    if (strArr == null || strArr.length == 0) {
                        w.w("MicroMsg.WalletBaseUtil ", "hy: keys is null");
                        return;
                    }
                    Map hashMap = new HashMap();
                    int i = 0;
                    while (i < strArr.length) {
                        try {
                            String str = strArr[i];
                            if (bg.mA(str)) {
                                w.e("MicroMsg.WalletBaseUtil ", "hy: key is null");
                            } else {
                                byte[] hu = eVar.Cc().hu(str);
                                if (hu != null) {
                                    hashMap.put(str, e.br(hu));
                                }
                            }
                            i++;
                        } catch (Exception e) {
                            w.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", e.toString());
                            if (aVar != null) {
                                aVar.J(null);
                                return;
                            }
                            return;
                        }
                    }
                    if (aVar != null) {
                        aVar.J(hashMap);
                    }
                }
            }
        }), 0);
    }

    public static byte[] bR(Object obj) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
        return byteArrayOutputStream.toByteArray();
    }

    public static Object br(byte[] bArr) {
        return new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
    }

    public static void CM(int i) {
        com.tencent.mm.plugin.report.service.g.oUh.i(12719, Integer.valueOf(i), Integer.valueOf(1));
    }

    public static void a(final TextView textView, final String str, String str2, final String str3) {
        if (textView == null) {
            w.e("MicroMsg.WalletBaseUtil ", "hy: text view is null.");
        } else if (bg.mA(str2)) {
            w.w("MicroMsg.WalletBaseUtil ", "hy: msg is null. set text view to gone");
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str2);
            f.dJ(UP(str), 0);
            if (!bg.mA(str3)) {
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        w.i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str3);
                        intent.putExtra("showShare", false);
                        d.b(textView.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                        f.dJ(e.UP(str), 1);
                    }
                });
            }
        }
    }

    public static int UP(String str) {
        if ("1".equals(str)) {
            return 0;
        }
        if ("2".equals(str)) {
            return 4;
        }
        if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str)) {
            return 12;
        }
        if ("4".equals(str)) {
            return 2;
        }
        if ("5".equals(str)) {
            return 8;
        }
        if ("6".equals(str)) {
            return 14;
        }
        if ("7".equals(str)) {
            return 16;
        }
        if ("8".equals(str)) {
            return 10;
        }
        return -1;
    }

    public static void a(int i, long j, int i2) {
        com.tencent.mm.plugin.report.service.g.oUh.i(13375, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(j), Integer.valueOf(i2));
    }

    public static String UQ(String str) {
        if (!bg.mA(str) && str.length() > 14) {
            return str.substring(0, 14) + "...";
        }
        return str;
    }

    public static String de(String str, int i) {
        if (!bg.mA(str) && str.length() > i) {
            return str.substring(0, i) + "...";
        }
        return str;
    }
}
