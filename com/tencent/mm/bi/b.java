package com.tencent.mm.bi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.d;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class b {
    public static final String uxU = (e.hgp + "app_font");
    public static final String uxV = (uxU + File.separator + "color_emoji");
    private static final boolean uxW = (VERSION.SDK_INT < 19);
    private static b uxX;
    private LinkedList<c> jqO;
    private Context mContext = ab.getContext();
    private int uxY = 0;
    private int uxZ;
    private int uya;
    private int uyb;
    public long uyc = 0;
    private a uyd = new a();
    private SparseArray<c> uye = new SparseArray();
    public SparseArray<c> uyf = new SparseArray();
    private SparseArray<c> uyg = new SparseArray();
    private SparseArray<SparseArray<c>> uyh = new SparseArray();
    private SparseArray<String> uyi = null;
    private y<Integer, Bitmap> uyj = new y(m.CTRL_INDEX);
    private boolean uyk = false;
    private LinkedList<d> uyl;

    private class a {
        int end;
        int start;
        c uym;
        boolean uyn = false;
        final /* synthetic */ b uyo;

        public a(b bVar, c cVar, int i, int i2, boolean z) {
            this.uyo = bVar;
            this.uym = cVar;
            this.start = i;
            this.end = i2;
            this.uyn = z;
        }
    }

    private b() {
        if (com.tencent.mm.a.e.aO(uxV)) {
            w.i("MicroMsg.EmojiHelper", "emoji color file exist.");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            bKz();
            j.y(this.mContext, "color_emoji", uxV);
            w.d("MicroMsg.EmojiHelper", "copyColorEmojiFile. use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        init();
        if (com.tencent.mm.bg.a.dM(this.mContext)) {
            this.uxY = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 4);
        } else {
            this.uxY = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 2);
        }
    }

    public static b bKy() {
        if (uxX == null) {
            synchronized (b.class) {
                uxX = new b();
            }
        }
        return uxX;
    }

    public static void bKz() {
        File file = new File(uxU);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final void init() {
        DataInputStream dataInputStream;
        Throwable e;
        InputStream inputStream = null;
        InputStream fileInputStream;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            fileInputStream = new FileInputStream(new File(uxV));
            try {
                dataInputStream = new DataInputStream(fileInputStream);
                try {
                    this.uyb = dataInputStream.readInt();
                    this.uyc = dataInputStream.readLong();
                    this.uxZ = dataInputStream.readInt();
                    this.uya = ((this.uxZ + 4) + 8) + 4;
                    byte[] bArr = new byte[this.uxZ];
                    dataInputStream.read(bArr);
                    this.uyd.aD(bArr);
                    bKA();
                    this.uyk = true;
                    w.i("MicroMsg.EmojiHelper", "init time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    try {
                        dataInputStream.close();
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    inputStream = fileInputStream;
                    try {
                        w.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable e22) {
                                w.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
                                return;
                            }
                        }
                        if (inputStream == null) {
                            inputStream.close();
                        }
                    } catch (Throwable th) {
                        e22 = th;
                        fileInputStream = inputStream;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable e4) {
                                w.printErrStackTrace("MicroMsg.EmojiHelper", e4, "", new Object[0]);
                                throw e22;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw e22;
                    }
                } catch (Throwable th2) {
                    e22 = th2;
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e22;
                }
            } catch (Exception e5) {
                e22 = e5;
                dataInputStream = null;
                inputStream = fileInputStream;
                w.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (inputStream == null) {
                    inputStream.close();
                }
            } catch (Throwable th3) {
                e22 = th3;
                dataInputStream = null;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e22;
            }
        } catch (Exception e6) {
            e22 = e6;
            dataInputStream = null;
            w.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (inputStream == null) {
                inputStream.close();
            }
        } catch (Throwable th4) {
            e22 = th4;
            dataInputStream = null;
            fileInputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e22;
        }
    }

    public static long Qv(String str) {
        InputStream fileInputStream;
        Throwable e;
        InputStream inputStream;
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2;
            fileInputStream = new FileInputStream(new File(str));
            try {
                dataInputStream2 = new DataInputStream(fileInputStream);
            } catch (IOException e2) {
                e = e2;
                inputStream = fileInputStream;
                try {
                    w.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e3) {
                            w.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
                            return 0;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    e3 = th;
                    fileInputStream = inputStream;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e4) {
                            w.printErrStackTrace("MicroMsg.EmojiHelper", e4, "", new Object[0]);
                            throw e3;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e3;
                }
            } catch (Throwable th2) {
                e3 = th2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
            try {
                dataInputStream2.readInt();
                long readLong = dataInputStream2.readLong();
                try {
                    dataInputStream2.close();
                    fileInputStream.close();
                    return readLong;
                } catch (Throwable e5) {
                    w.printErrStackTrace("MicroMsg.EmojiHelper", e5, "", new Object[0]);
                    return readLong;
                }
            } catch (IOException e6) {
                e3 = e6;
                dataInputStream = dataInputStream2;
                inputStream = fileInputStream;
                w.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return 0;
            } catch (Throwable th3) {
                e3 = th3;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
        } catch (IOException e7) {
            e3 = e7;
            inputStream = null;
            w.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return 0;
        } catch (Throwable th4) {
            e3 = th4;
            fileInputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e3;
        }
    }

    public static int Qw(String str) {
        InputStream fileInputStream;
        DataInputStream dataInputStream;
        Throwable e;
        InputStream inputStream;
        DataInputStream dataInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                dataInputStream = new DataInputStream(fileInputStream);
            } catch (IOException e2) {
                e = e2;
                dataInputStream = null;
                inputStream = fileInputStream;
                try {
                    w.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e3) {
                            w.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
                            return 0;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    e3 = th;
                    fileInputStream = inputStream;
                    dataInputStream2 = dataInputStream;
                    if (dataInputStream2 != null) {
                        try {
                            dataInputStream2.close();
                        } catch (Throwable e4) {
                            w.printErrStackTrace("MicroMsg.EmojiHelper", e4, "", new Object[0]);
                            throw e3;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e3;
                }
            } catch (Throwable th2) {
                e3 = th2;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
            try {
                int readInt = dataInputStream.readInt();
                try {
                    dataInputStream.close();
                    fileInputStream.close();
                    return readInt;
                } catch (Throwable e42) {
                    w.printErrStackTrace("MicroMsg.EmojiHelper", e42, "", new Object[0]);
                    return readInt;
                }
            } catch (IOException e5) {
                e3 = e5;
                inputStream = fileInputStream;
                w.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return 0;
            } catch (Throwable th3) {
                e3 = th3;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
        } catch (IOException e6) {
            e3 = e6;
            dataInputStream = null;
            w.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return 0;
        } catch (Throwable th4) {
            e3 = th4;
            fileInputStream = null;
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e3;
        }
    }

    public final SpannableString a(SpannableString spannableString, int i, PInt pInt) {
        if (spannableString == null || spannableString.length() == 0) {
            return spannableString;
        }
        String spannableString2 = spannableString.toString();
        ArrayList arrayList = new ArrayList();
        int length = spannableString2.length();
        int charCount;
        for (int i2 = 0; i2 < length; i2 = charCount) {
            int codePointAt;
            int codePointAt2 = spannableString2.codePointAt(i2);
            charCount = i2 + Character.charCount(codePointAt2);
            if (charCount < length) {
                codePointAt = spannableString2.codePointAt(charCount);
            } else {
                codePointAt = 0;
            }
            c yz = bKy().yz(codePointAt2);
            if (yz != null) {
                arrayList.add(new a(this, yz, i2, i2 + 1, true));
            } else {
                yz = bKy().dO(codePointAt2, codePointAt);
                if (yz != null) {
                    int charCount2;
                    if (yz.uyq != 0 || (127995 <= codePointAt && codePointAt <= 127999)) {
                        charCount2 = charCount + Character.charCount(codePointAt);
                    } else {
                        charCount2 = charCount;
                    }
                    arrayList.add(new a(this, yz, i2, charCount2, false));
                    charCount = charCount2;
                }
            }
            if (arrayList.size() >= pInt.value) {
                break;
            }
        }
        if (arrayList.size() == 0) {
            return spannableString;
        }
        a aVar;
        Spannable spannableString3;
        if (uxW) {
            StringBuilder stringBuilder = new StringBuilder(spannableString2);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (!aVar.uyn) {
                    if (aVar.uym.uyr == 0 || aVar.end - aVar.start != 1) {
                        stringBuilder.replace(aVar.start, aVar.end, "....".substring(0, aVar.end - aVar.start));
                    } else {
                        stringBuilder.replace(aVar.start, aVar.end, String.valueOf((char) aVar.uym.uyr));
                    }
                }
            }
            spannableString3 = new SpannableString(stringBuilder.toString());
        } else {
            CharSequence charSequence = spannableString;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            aVar = (a) it2.next();
            a(spannableString3, bKy().a(aVar.uym), aVar.start, aVar.end, i);
        }
        pInt.value -= arrayList.size();
        return spannableString3;
    }

    public static boolean Qx(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = str.toString();
        int length = str2.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str2.codePointAt(i);
            int charCount = Character.charCount(codePointAt) + i;
            if (charCount < length) {
                i = str2.codePointAt(charCount);
            } else {
                i = 0;
            }
            if (bKy().yz(codePointAt) != null) {
                return true;
            }
            if (bKy().dO(codePointAt, i) != null) {
                return true;
            }
            i = charCount;
        }
        return false;
    }

    public final String Qy(String str) {
        if (bg.mA(str)) {
            return str;
        }
        int i;
        if (this.uyi == null) {
            Context context = ab.getContext();
            String d = v.d(context.getSharedPreferences(ab.bIX(), 0));
            String[] stringArray = d.equals("zh_CN") ? context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.kZP) : (d.equals("zh_TW") || d.equals("zh_HK")) ? context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.kZR) : context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.kZQ);
            String[] stringArray2 = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.kZO);
            this.uyi = new SparseArray();
            i = 0;
            while (i < stringArray2.length && i < stringArray.length) {
                this.uyi.put(stringArray2[i].charAt(0), stringArray[i]);
                i++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        i = 0;
        while (i < length) {
            int codePointAt;
            int codePointAt2 = str.codePointAt(i);
            i += Character.charCount(codePointAt2);
            if (i < length) {
                codePointAt = str.codePointAt(i);
            } else {
                codePointAt = 0;
            }
            c yz = bKy().yz(codePointAt2);
            if (yz != null) {
                d = (String) this.uyi.get(yz.uyr);
                if (d != null) {
                    stringBuilder.append(d);
                } else {
                    stringBuilder.append(this.mContext.getString(g.dGM));
                }
            } else {
                yz = bKy().dO(codePointAt2, codePointAt);
                if (yz != null) {
                    if (yz.uyq != 0) {
                        i = Character.charCount(codePointAt) + i;
                    }
                    d = (String) this.uyi.get(yz.uyr);
                    if (d != null) {
                        stringBuilder.append(d);
                    } else {
                        stringBuilder.append(this.mContext.getString(g.dGM));
                    }
                } else {
                    stringBuilder.appendCodePoint(codePointAt2);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String eF(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt;
            int codePointAt2 = str.codePointAt(i);
            i += Character.charCount(codePointAt2);
            if (i < length) {
                codePointAt = str.codePointAt(i);
            } else {
                codePointAt = 0;
            }
            if (bKy().yz(codePointAt2) != null) {
                stringBuilder.append(str2);
            } else {
                c dO = bKy().dO(codePointAt2, codePointAt);
                if (dO != null) {
                    if (dO.uyq != 0) {
                        codePointAt = Character.charCount(codePointAt) + i;
                    } else {
                        codePointAt = i;
                    }
                    stringBuilder.append(str2);
                    i = codePointAt;
                } else {
                    stringBuilder.appendCodePoint(codePointAt2);
                }
            }
        }
        return stringBuilder.toString();
    }

    public final void a(Spannable spannable, Drawable drawable, int i, int i2, int i3) {
        try {
            drawable.setBounds(0, 0, (int) (((float) i3) * 1.3f), (int) (((float) i3) * 1.3f));
            d dVar = new d(drawable);
            dVar.wuA = this.uxY;
            spannable.setSpan(dVar, i, i2, 33);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
        }
    }

    final c dO(int i, int i2) {
        if (this.uyl == null || this.uyl.isEmpty() || this.uyk) {
            this.uyl = new LinkedList(this.uyd.uxS);
            this.uyk = false;
        }
        if (this.uyl == null || this.uyl.isEmpty()) {
            return null;
        }
        Iterator it = this.uyl.iterator();
        boolean z = false;
        while (it.hasNext()) {
            boolean z2;
            d dVar = (d) it.next();
            if (i < dVar.rOT || i > dVar.max) {
                z2 = z;
            } else {
                z2 = true;
            }
            z = z2;
        }
        if (!z) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.uyh.get(i);
        if (sparseArray == null) {
            return null;
        }
        if (sparseArray.size() != 1 || sparseArray.get(0) == null) {
            return (c) sparseArray.get(i2);
        }
        return (c) sparseArray.get(0);
    }

    public final c yz(int i) {
        if (i < 57345 || i > 58679) {
            return null;
        }
        return (c) this.uye.get(i);
    }

    public final Drawable iP(int i) {
        return a((c) this.uyg.get(i));
    }

    public final Drawable a(c cVar) {
        if (cVar == null) {
            w.i("MicroMsg.EmojiHelper", "Emoji Item is null.");
            return null;
        }
        try {
            Bitmap bitmap = (Bitmap) this.uyj.get(Integer.valueOf(cVar.hrt));
            if (bitmap != null && !bitmap.isRecycled()) {
                return new BitmapDrawable(ab.getContext().getResources(), bitmap);
            }
            byte[] c = com.tencent.mm.a.e.c(uxV, cVar.hrt + this.uya, cVar.size);
            Options options = new Options();
            options.inPreferredConfig = Config.RGB_565;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(c, 0, c.length, options);
            if (decodeByteArray != null) {
                decodeByteArray.setDensity(240);
                this.uyj.put(Integer.valueOf(cVar.hrt), decodeByteArray);
                return new BitmapDrawable(ab.getContext().getResources(), decodeByteArray);
            }
            String str = "MicroMsg.EmojiHelper";
            String str2 = "bitmap is null. decode byte array failed. size:%d data length:%d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(cVar.size);
            objArr[1] = Integer.valueOf(c == null ? 0 : c.length);
            w.i(str, str2, objArr);
            return null;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
        }
    }

    private void bKA() {
        this.jqO = new LinkedList(this.uyd.uxT);
        if (this.jqO == null || this.jqO.isEmpty()) {
            w.i("MicroMsg.EmojiHelper", "initIndex failed. items is empty.");
            return;
        }
        Iterator it = this.jqO.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.uyp != 0) {
                SparseArray sparseArray = (SparseArray) this.uyh.get(cVar.uyp);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.uyh.append(cVar.uyp, sparseArray);
                }
                sparseArray.put(cVar.uyq, cVar);
                if (cVar.uyr != 0) {
                    this.uye.append(cVar.uyr, cVar);
                }
                if (cVar.uys != -1) {
                    this.uyf.append(cVar.uys, cVar);
                }
            } else {
                this.uyg.append(cVar.uyt, cVar);
            }
        }
    }

    public static int bKB() {
        return 1;
    }
}
