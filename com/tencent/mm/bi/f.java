package com.tencent.mm.bi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.s;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

public final class f {
    private static volatile f uyA = null;
    public static Pattern uyL;
    private static final Comparator<a> uyM = new Comparator<a>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar == null && aVar2 == null) {
                return 0;
            }
            if (aVar == null || bg.mA(aVar.text)) {
                return 1;
            }
            return (aVar2 == null || bg.mA(aVar2.text)) ? -1 : aVar.text.compareTo(aVar2.text);
        }
    };
    public String[] uyB = null;
    public String[] uyC = null;
    public String[] uyD = null;
    public String[] uyE = null;
    public String[] uyF = null;
    public String[] uyG = null;
    public ArrayList<s> uyH;
    private a[] uyI = null;
    private HashMap<String, s> uyJ = new HashMap();
    private SparseArray<String> uyK = new SparseArray();

    static class a {
        public String name;
        public int pos;
        public String text;

        a() {
        }

        a(int i, String str, String str2) {
            this.pos = i;
            this.text = str;
            this.name = str2;
        }
    }

    private f(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        this.uyB = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.kZS);
        this.uyC = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.kZV);
        this.uyD = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.kZT);
        this.uyE = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.kZX);
        this.uyF = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.kZU);
        this.uyG = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.kZW);
        bKF();
        w.d("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static f bKE() {
        if (uyA == null) {
            synchronized (f.class) {
                if (uyA == null) {
                    uyA = new f(ab.getContext());
                }
            }
        }
        return uyA;
    }

    private synchronized int bKF() {
        int i = 0;
        synchronized (this) {
            if (this.uyB == null || this.uyD == null || this.uyB.length != this.uyD.length) {
                w.i("MicroMsg.QQSmileyManager", "read smiley array failed.");
                if (this.uyH != null) {
                    this.uyI = new a[this.uyH.size()];
                }
            } else {
                int length = this.uyB.length;
                if (this.uyH != null) {
                    this.uyI = new a[((this.uyH.size() + length) * 6)];
                } else {
                    this.uyI = new a[(length * 6)];
                }
                int i2 = 0;
                while (i2 < length) {
                    String str = this.uyB[i2];
                    String str2 = this.uyD[i2];
                    String str3 = (this.uyC == null || this.uyC.length <= i2) ? "" : this.uyC[i2];
                    String str4 = (this.uyE == null || this.uyE.length <= i2) ? "" : this.uyE[i2];
                    String str5 = (this.uyF == null || this.uyF.length <= i2) ? "" : this.uyF[i2];
                    String str6 = (this.uyG == null || this.uyG.length <= i2) ? "" : this.uyG[i2];
                    s sVar = new s(str, str3, str2, str4, str5, str6, i2);
                    this.uyI[(i2 * 6) + 0] = new a(i2, str, "");
                    this.uyI[(i2 * 6) + 1] = new a(i2, str2, "");
                    this.uyI[(i2 * 6) + 2] = new a(i2, str3, "");
                    this.uyI[(i2 * 6) + 3] = new a(i2, str4, "");
                    this.uyI[(i2 * 6) + 4] = new a(i2, str5, "");
                    this.uyI[(i2 * 6) + 5] = new a(i2, str6, "");
                    this.uyJ.put(str, sVar);
                    this.uyK.put(sVar.field_eggIndex, sVar.field_key);
                    i2++;
                }
                i = length;
            }
            if (this.uyH == null || this.uyH.isEmpty()) {
                Arrays.sort(this.uyI, uyM);
            }
        }
        return i;
    }

    public final void bKG() {
        long currentTimeMillis = System.currentTimeMillis();
        this.uyJ.clear();
        this.uyK.clear();
        this.uyH = ((PluginEmoji) h.j(PluginEmoji.class)).getEmojiMgr().alD();
        int bKF = bKF();
        if (this.uyH == null || this.uyH.isEmpty()) {
            w.i("MicroMsg.QQSmileyManager", "newSmileys list is null.");
        } else {
            Iterator it = this.uyH.iterator();
            int i = bKF;
            while (it.hasNext()) {
                s sVar = (s) it.next();
                this.uyJ.put(sVar.field_key, sVar);
                this.uyK.put(sVar.field_eggIndex, sVar.field_key);
                this.uyI[(i * 6) + 0] = new a(-1, sVar.field_key, sVar.field_fileName);
                if (bg.mA(sVar.field_cnValue) || "null".equalsIgnoreCase(sVar.field_cnValue)) {
                    this.uyI[(i * 6) + 1] = new a(-1, sVar.field_key, sVar.field_fileName);
                } else {
                    this.uyI[(i * 6) + 1] = new a(-1, sVar.field_cnValue, sVar.field_fileName);
                }
                if (bg.mA(sVar.field_qqValue) || "null".equalsIgnoreCase(sVar.field_qqValue)) {
                    this.uyI[(i * 6) + 2] = new a(-1, sVar.field_key, sVar.field_fileName);
                } else {
                    this.uyI[(i * 6) + 2] = new a(-1, sVar.field_qqValue, sVar.field_fileName);
                }
                if (bg.mA(sVar.field_twValue) || "null".equalsIgnoreCase(sVar.field_twValue)) {
                    this.uyI[(i * 6) + 3] = new a(-1, sVar.field_key, sVar.field_fileName);
                } else {
                    this.uyI[(i * 6) + 3] = new a(-1, sVar.field_twValue, sVar.field_fileName);
                }
                if (bg.mA(sVar.field_enValue) || "null".equalsIgnoreCase(sVar.field_enValue)) {
                    this.uyI[(i * 6) + 4] = new a(-1, sVar.field_key, sVar.field_fileName);
                } else {
                    this.uyI[(i * 6) + 4] = new a(-1, sVar.field_enValue, sVar.field_fileName);
                }
                if (bg.mA(sVar.field_thValue) || "null".equalsIgnoreCase(sVar.field_thValue)) {
                    this.uyI[(i * 6) + 5] = new a(-1, sVar.field_key, sVar.field_fileName);
                } else {
                    this.uyI[(i * 6) + 5] = new a(-1, sVar.field_thValue, sVar.field_fileName);
                }
                i++;
            }
        }
        Arrays.sort(this.uyI, uyM);
        w.i("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final String eG(String str, String str2) {
        int i = 0;
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '[') {
                a Qz = Qz(str.substring(i));
                if (Qz != null) {
                    stringBuilder.append(str2);
                    i += Qz.text.length();
                }
            }
            stringBuilder.append(charAt);
            i++;
        }
        return stringBuilder.toString();
    }

    public final a Qz(String str) {
        a[] aVarArr = bKE().uyI;
        if (aVarArr != null) {
            int binarySearch = Arrays.binarySearch(this.uyI, new a(0, str, ""), uyM);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            if (binarySearch >= 0 && str.startsWith(this.uyI[binarySearch].text)) {
                return aVarArr[binarySearch];
            }
        }
        return null;
    }

    public final SpannableString a(SpannableString spannableString, int i, int i2) {
        if (spannableString != null && spannableString.length() != 0) {
            String spannableString2 = spannableString.toString();
            int i3 = 0;
            int i4 = -1;
            while (true) {
                i4 = spannableString2.indexOf(47, i4 + 1);
                if (i4 != -1) {
                    if (i4 < spannableString2.length() - 1) {
                        if (i3 >= i2) {
                            break;
                        } else if (a(i4, spannableString, i)) {
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            }
            while (true) {
                i4 = spannableString2.indexOf(91, i4 + 1);
                if (i4 != -1) {
                    if (i4 < spannableString2.length() - 1) {
                        if (i3 >= i2) {
                            break;
                        } else if (a(i4, spannableString, i)) {
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return spannableString;
    }

    private boolean a(int i, SpannableString spannableString, int i2) {
        a Qz = Qz(spannableString.subSequence(i, spannableString.length()));
        if (Qz == null) {
            return false;
        }
        int i3 = Qz.pos;
        Drawable iP = i3 >= 0 ? b.bKy().iP(i3) : QA(Qz.name);
        if (iP == null || i > spannableString.length() || Qz.text.length() + i > spannableString.length()) {
            w.i("MicroMsg.QQSmileyManager", "spanQQSmileyIcon failed. drawable not found. smiley:%s", Qz.toString());
            return false;
        }
        b.bKy().a(spannableString, iP, i, i + Qz.text.length(), i2);
        return true;
    }

    static Drawable QA(String str) {
        FileInputStream fileInputStream;
        Throwable e;
        try {
            fileInputStream = new FileInputStream(com.tencent.mm.ac.a.EH() + "/" + str);
            try {
                Options options = new Options();
                options.inPreferredConfig = Config.RGB_565;
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
                if (decodeStream == null) {
                    w.i("MicroMsg.QQSmileyManager", "getQQSmileyDrawable bitmap is null.");
                }
                Drawable bitmapDrawable = new BitmapDrawable(ab.getContext().getResources(), decodeStream);
                try {
                    fileInputStream.close();
                    return bitmapDrawable;
                } catch (Throwable e2) {
                    w.i("MicroMsg.QQSmileyManager", bg.g(e2));
                    return bitmapDrawable;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    w.i("MicroMsg.QQSmileyManager", bg.g(e));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e4) {
                            w.i("MicroMsg.QQSmileyManager", bg.g(e4));
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e4 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e22) {
                            w.i("MicroMsg.QQSmileyManager", bg.g(e22));
                        }
                    }
                    throw e4;
                }
            }
        } catch (FileNotFoundException e5) {
            e4 = e5;
            fileInputStream = null;
            w.i("MicroMsg.QQSmileyManager", bg.g(e4));
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th2) {
            e4 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e4;
        }
    }

    public final s QB(String str) {
        if (this.uyJ != null && this.uyJ.containsKey(str)) {
            return (s) this.uyJ.get(str);
        }
        w.i("MicroMsg.QQSmileyManager", "getSmileyInfo failed. smiley map no contains key:%s", str);
        return null;
    }
}
