package com.tencent.mm.bh;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.a.a;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class e {
    private static f upA;
    private static b upB;
    private static d upC;
    private static String upD = "";
    private static boolean upE = false;
    private static boolean upF = true;
    private static ArrayList<Integer> upG = new ArrayList();
    private static final List<String> upy = Arrays.asList(new String[]{"zh_CN"});
    private static e upz;

    public static e bHG() {
        synchronized (e.class) {
            if (upz == null) {
                upz = new e();
            }
        }
        return upz;
    }

    private e() {
    }

    private static void clean() {
        if (upA != null) {
            f fVar = upA;
            if (fVar.upH != null) {
                fVar.upH.clear();
            }
            if (fVar.upI != null) {
                fVar.upI = null;
            }
        }
        if (upB != null) {
            b bVar = upB;
            if (bVar.upr != null) {
                bVar.upr.clear();
            }
            if (bVar.jQY != null) {
                bVar.jQY = null;
            }
        }
        if (upC != null) {
            d dVar = upC;
            if (dVar.upw != null) {
                dVar.upw.clear();
            }
            if (dVar.jQY != null) {
                dVar.jQY = null;
            }
        }
    }

    public static e dQ(Context context) {
        InputStream open;
        Throwable e;
        InputStream inputStream;
        String d;
        boolean z;
        Throwable th;
        if (context.getResources() == null) {
            w.e("MicroMsg.language.StringResouces", "the resource is null! why?");
            return null;
        }
        Locale locale;
        String locale2;
        AssetManager assets = context.getAssets();
        if (assets != null) {
            bHG();
            w.i("MicroMsg.language.StringResouces", "[cpan] start to init string encrypt StringID List");
            if (upG == null) {
                upG = new ArrayList();
            }
            upG.clear();
            long currentTimeMillis = System.currentTimeMillis();
            DataInputStream dataInputStream = null;
            DataInputStream dataInputStream2;
            try {
                open = assets.open("estrings/encrypt.mmstrid");
                try {
                    dataInputStream2 = new DataInputStream(open);
                    try {
                        w.d("MicroMsg.language.StringResouces", "encrypt string id size %d", Integer.valueOf(dataInputStream2.readInt()));
                        for (int i = 0; i < r6.intValue(); i++) {
                            upG.add(Integer.valueOf(dataInputStream2.readInt()));
                            w.d("MicroMsg.language.StringResouces", "encrypt string id is %d", r7);
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable e2) {
                                w.e("MicroMsg.language.StringResouces", "exception:%s", bg.g(e2));
                            }
                        }
                        try {
                            dataInputStream2.close();
                        } catch (Throwable e3) {
                            w.e("MicroMsg.language.StringResouces", "exception:%s", bg.g(e3));
                        }
                    } catch (IOException e4) {
                        inputStream = open;
                        try {
                            w.w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e22) {
                                    w.e("MicroMsg.language.StringResouces", "exception:%s", bg.g(e22));
                                }
                            }
                            if (dataInputStream2 != null) {
                                try {
                                    dataInputStream2.close();
                                } catch (Throwable e32) {
                                    w.e("MicroMsg.language.StringResouces", "exception:%s", bg.g(e32));
                                }
                            }
                            w.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                            if (assets != null) {
                                bHG();
                                if (upF) {
                                    d = v.d(context.getSharedPreferences(ab.bIX(), 0));
                                    if (!bg.mA(d)) {
                                    }
                                    locale = Locale.getDefault();
                                    v.a(context, locale);
                                    locale2 = locale.toString();
                                    bHG();
                                    z = upy.contains(locale2);
                                    upE = z;
                                    if (z) {
                                        clean();
                                        upD = locale2;
                                        return null;
                                    }
                                    bHG();
                                    a(assets, locale2);
                                    return bHG();
                                }
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            open = inputStream;
                            dataInputStream = dataInputStream2;
                            e32 = th;
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (Throwable th22) {
                                    w.e("MicroMsg.language.StringResouces", "exception:%s", bg.g(th22));
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Throwable e222) {
                                    w.e("MicroMsg.language.StringResouces", "exception:%s", bg.g(e222));
                                }
                            }
                            throw e32;
                        }
                    } catch (Throwable e2222) {
                        th = e2222;
                        dataInputStream = dataInputStream2;
                        e32 = th;
                        if (open != null) {
                            open.close();
                        }
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        throw e32;
                    }
                } catch (IOException e5) {
                    dataInputStream2 = null;
                    inputStream = open;
                    w.w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (dataInputStream2 != null) {
                        dataInputStream2.close();
                    }
                    w.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                    if (assets != null) {
                        bHG();
                        if (upF) {
                            d = v.d(context.getSharedPreferences(ab.bIX(), 0));
                            if (bg.mA(d)) {
                            }
                            locale = Locale.getDefault();
                            v.a(context, locale);
                            locale2 = locale.toString();
                            bHG();
                            if (upy.contains(locale2)) {
                            }
                            upE = z;
                            if (z) {
                                clean();
                                upD = locale2;
                                return null;
                            }
                            bHG();
                            a(assets, locale2);
                            return bHG();
                        }
                    }
                    return null;
                } catch (Throwable th3) {
                    e32 = th3;
                    if (open != null) {
                        open.close();
                    }
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    throw e32;
                }
            } catch (IOException e6) {
                inputStream = null;
                dataInputStream2 = null;
                w.w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                if (inputStream != null) {
                    inputStream.close();
                }
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                w.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                if (assets != null) {
                    bHG();
                    if (upF) {
                        d = v.d(context.getSharedPreferences(ab.bIX(), 0));
                        if (bg.mA(d)) {
                        }
                        locale = Locale.getDefault();
                        v.a(context, locale);
                        locale2 = locale.toString();
                        bHG();
                        if (upy.contains(locale2)) {
                        }
                        upE = z;
                        if (z) {
                            clean();
                            upD = locale2;
                            return null;
                        }
                        bHG();
                        a(assets, locale2);
                        return bHG();
                    }
                }
                return null;
            } catch (Throwable th222) {
                th = th222;
                open = null;
                e32 = th;
                if (open != null) {
                    open.close();
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw e32;
            }
            w.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (assets != null) {
            bHG();
            if (upF) {
                d = v.d(context.getSharedPreferences(ab.bIX(), 0));
                if (bg.mA(d) || d.equalsIgnoreCase("language_default")) {
                    locale = Locale.getDefault();
                    v.a(context, locale);
                } else {
                    locale = v.Po(d);
                }
                locale2 = locale.toString();
                bHG();
                if (upy.contains(locale2)) {
                }
                upE = z;
                if (z) {
                    bHG();
                    a(assets, locale2);
                    return bHG();
                }
                clean();
                upD = locale2;
                return null;
            }
        }
        return null;
    }

    private static void a(AssetManager assetManager, String str) {
        InputStream open;
        Throwable e;
        InputStream inputStream;
        if (bg.mA(str)) {
            w.w("MicroMsg.language.StringResouces", "local is null.");
        } else if (str.equals(upD)) {
            w.i("MicroMsg.language.StringResouces", "local no change. local is :%s", str);
        } else {
            int indexOf = str.indexOf("_");
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("zh")) {
                    w.d("MicroMsg.language.StringResouces", "local is :%s temp local is :%s", str, substring);
                    str = substring;
                }
            }
            clean();
            upD = str;
            w.i("MicroMsg.language.StringResouces", "[cpan] start to init string resource");
            long currentTimeMillis = System.currentTimeMillis();
            DataInputStream dataInputStream;
            try {
                open = assetManager.open("strings/" + str + ".mmstr");
                try {
                    dataInputStream = new DataInputStream(open);
                    try {
                        int i;
                        dataInputStream.readInt();
                        dataInputStream.readInt();
                        int readInt = dataInputStream.readInt();
                        w.i("MicroMsg.language.StringResouces", "string count" + readInt);
                        SparseIntArray sparseIntArray = new SparseIntArray(readInt);
                        int readInt2 = dataInputStream.readInt();
                        indexOf = 0;
                        for (i = 0; i < readInt; i++) {
                            readInt2 += dataInputStream.readShort();
                            sparseIntArray.append(readInt2, indexOf);
                            indexOf += dataInputStream.readShort();
                        }
                        upA = f.a(sparseIntArray, dataInputStream, indexOf);
                        readInt = dataInputStream.readInt();
                        w.i("MicroMsg.language.StringResouces", "plurals string count:%d", Integer.valueOf(readInt));
                        if (readInt > 0) {
                            SparseArray sparseArray = new SparseArray(readInt);
                            readInt2 = dataInputStream.readInt();
                            i = 0;
                            for (indexOf = 0; indexOf < readInt; indexOf++) {
                                readInt2 += dataInputStream.readInt();
                                i += a(dataInputStream, sparseArray, readInt2, i);
                            }
                            upB = b.a(sparseArray, dataInputStream, i);
                        }
                        int readInt3 = dataInputStream.readInt();
                        indexOf = dataInputStream.readInt();
                        w.i("MicroMsg.language.StringResouces", "string array count：%d", Integer.valueOf(readInt3));
                        if (readInt3 > 0) {
                            SparseArray sparseArray2 = new SparseArray(readInt3);
                            i = 0;
                            readInt = 0;
                            while (readInt < readInt3) {
                                readInt2 = dataInputStream.readInt() + indexOf;
                                int readInt4 = dataInputStream.readInt();
                                int[] iArr = new int[readInt4];
                                for (indexOf = 0; indexOf < readInt4; indexOf++) {
                                    iArr[indexOf] = i;
                                    i += dataInputStream.readShort();
                                }
                                sparseArray2.append(readInt2, new a(readInt2, iArr));
                                readInt++;
                                indexOf = readInt2;
                            }
                            upC = d.b(sparseArray2, dataInputStream, i);
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable e2) {
                                w.e("MicroMsg.language.StringResouces", "exception:%s", bg.g(e2));
                            }
                        }
                        try {
                            dataInputStream.close();
                        } catch (Throwable e22) {
                            w.e("MicroMsg.language.StringResouces", "exception:%s", bg.g(e22));
                        }
                    } catch (IOException e3) {
                        e22 = e3;
                        inputStream = open;
                        try {
                            w.printErrStackTrace("MicroMsg.language.StringResouces", e22, "[cpan] local :%s file can not be find. use default.", str);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e222) {
                                    w.e("MicroMsg.language.StringResouces", "exception:%s", bg.g(e222));
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Throwable e2222) {
                                    w.e("MicroMsg.language.StringResouces", "exception:%s", bg.g(e2222));
                                }
                            }
                            w.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
                        } catch (Throwable th) {
                            e2222 = th;
                            open = inputStream;
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (Throwable e4) {
                                    w.e("MicroMsg.language.StringResouces", "exception:%s", bg.g(e4));
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Throwable e5) {
                                    w.e("MicroMsg.language.StringResouces", "exception:%s", bg.g(e5));
                                }
                            }
                            throw e2222;
                        }
                    } catch (Throwable th2) {
                        e2222 = th2;
                        if (open != null) {
                            open.close();
                        }
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        throw e2222;
                    }
                } catch (IOException e6) {
                    e2222 = e6;
                    dataInputStream = null;
                    inputStream = open;
                    w.printErrStackTrace("MicroMsg.language.StringResouces", e2222, "[cpan] local :%s file can not be find. use default.", str);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    w.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th3) {
                    e2222 = th3;
                    dataInputStream = null;
                    if (open != null) {
                        open.close();
                    }
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    throw e2222;
                }
            } catch (IOException e7) {
                e2222 = e7;
                inputStream = null;
                dataInputStream = null;
                w.printErrStackTrace("MicroMsg.language.StringResouces", e2222, "[cpan] local :%s file can not be find. use default.", str);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                w.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th4) {
                e2222 = th4;
                open = null;
                dataInputStream = null;
                if (open != null) {
                    open.close();
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw e2222;
            }
            w.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static boolean bHH() {
        if (!(upF && upE)) {
            boolean z = (upG == null || upG.isEmpty()) ? false : true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static boolean bHF() {
        return upF;
    }

    public static String getString(int i) {
        if (upA == null) {
            return null;
        }
        return upA.getString(i);
    }

    public static String getQuantityString(int i, int i2) {
        if (upB == null) {
            return null;
        }
        return upB.getQuantityString(i, i2, new Object[0]);
    }

    public static String getQuantityString(int i, int i2, Object... objArr) {
        if (upB == null) {
            return null;
        }
        return upB.getQuantityString(i, i2, objArr);
    }

    public static String[] getStringArray(int i) {
        int i2 = 0;
        if (upC == null) {
            return null;
        }
        d dVar = upC;
        int indexOfKey = dVar.upw.indexOfKey(i);
        if (indexOfKey < 0) {
            return null;
        }
        String[] strArr;
        int length = indexOfKey < dVar.upw.size() + -1 ? ((a) dVar.upw.valueAt(indexOfKey + 1)).upx[0] : dVar.jQY.length;
        a aVar = (a) dVar.upw.valueAt(indexOfKey);
        indexOfKey = aVar.upx.length;
        if (indexOfKey > 0) {
            String[] strArr2 = new String[indexOfKey];
            while (i2 < indexOfKey) {
                if (i2 < indexOfKey - 1) {
                    strArr2[i2] = new String(dVar.jQY, aVar.upx[i2], aVar.upx[i2 + 1] - aVar.upx[i2]);
                } else {
                    strArr2[i2] = new String(dVar.jQY, aVar.upx[i2], length - aVar.upx[i2]);
                }
                i2++;
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        return strArr;
    }

    private static int a(DataInputStream dataInputStream, SparseArray<a> sparseArray, int i, int i2) {
        try {
            byte readByte = dataInputStream.readByte();
            if (readByte < (byte) 0) {
                return 0;
            }
            int[] iArr = new int[readByte];
            int[] iArr2 = new int[readByte];
            int i3 = 0;
            for (byte b = (byte) 0; b < readByte; b++) {
                iArr[b] = dataInputStream.readByte();
                iArr2[b] = i2;
                short readShort = dataInputStream.readShort();
                i3 += readShort;
                i2 += readShort;
            }
            sparseArray.append(i, new a(i, iArr, iArr2));
            return i3;
        } catch (Throwable e) {
            w.e("MicroMsg.language.StringResouces", "exception:%s", bg.g(e));
            return 0;
        }
    }

    public static CharSequence d(int i, CharSequence charSequence) {
        if (charSequence == null || upG == null || upG.isEmpty() || !upG.contains(Integer.valueOf(i))) {
            return charSequence;
        }
        return a.o(charSequence.toString(), g.n("lucky".getBytes()).substring(0, 16));
    }
}
