package com.tencent.c.d.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class d {

    public static class a {
        public String name = "";
        public int pid;
        public int uid;
        public int wSn;
        public String wSo;

        a(int i, int i2, String str, int i3, String str2) {
            this.pid = i;
            this.wSn = i2;
            this.name = str;
            this.uid = i3;
            this.wSo = str2;
        }

        public final String toString() {
            return "PID=" + this.pid + " PPID=" + this.wSn + " NAME=" + this.name + " UID=" + this.uid + " CONTEXT=" + this.wSo;
        }
    }

    public static List<a> cdJ() {
        List arrayList = new ArrayList();
        String[] list = new File("/proc").list();
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        char charAt = str.charAt(0);
                        if (charAt <= '9' && charAt >= '0') {
                            a CU = CU(Integer.parseInt(str));
                            if (CU != null) {
                                arrayList.add(CU);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return arrayList;
    }

    private static String CT(int i) {
        try {
            String str = "";
            byte[] di = a.di(String.format(Locale.ENGLISH, "/proc/%d/cmdline", new Object[]{Integer.valueOf(i)}), 100);
            if (di != null) {
                str = new String(di, 0, a(di, 0, '\u0000'));
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            di = a.di(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[]{Integer.valueOf(i)}), ck.CTRL_INDEX);
            if (di == null) {
                return str;
            }
            int a = a(di, 7, '\n');
            if (a == 0) {
                return "";
            }
            return new String(di, 6, a - 6);
        } catch (Throwable th) {
            return "";
        }
    }

    private static int a(byte[] bArr, int i, char c) {
        int i2 = i - 1;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= bArr.length) {
                return 0;
            }
            if (i3 == bArr.length || bArr[i3] == c) {
                return i3;
            }
            i2 = i3;
        }
    }

    private static a CU(int i) {
        String CT;
        String trim;
        int a;
        int i2;
        try {
            CT = CT(i);
            try {
                int parseInt;
                byte[] di = a.di(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[]{Integer.valueOf(i)}), ck.CTRL_INDEX);
                if (di != null) {
                    a = a(di, 7, '\n');
                    if (a != 0) {
                        a = a(di, a(di, a(di, a + 1, '\n') + 1, '\n') + 1, '\n');
                        if (a != 0) {
                            i2 = a + 7;
                            int a2 = a(di, a + 1, '\n');
                            if (a2 != 0) {
                                a = Integer.parseInt(new String(di, i2, a2 - i2));
                                try {
                                    i2 = a(di, a2 + 1, '\n');
                                    if (i2 != 0) {
                                        i2 += 6;
                                        parseInt = Integer.parseInt(new String(di, i2, a(di, i2 + 1, '\t') - i2));
                                    } else {
                                        parseInt = -1;
                                    }
                                    i2 = parseInt;
                                } catch (Exception e) {
                                    i2 = -1;
                                    trim = new String(a.Ve(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                                    if (CT != null) {
                                    }
                                    return null;
                                }
                                trim = new String(a.Ve(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                                if (CT != null || a == -1 || i2 == -1) {
                                    return null;
                                }
                                return new a(i, a, CT, i2, trim);
                            }
                        }
                    }
                }
                parseInt = -1;
                a = -1;
                i2 = parseInt;
            } catch (Exception e2) {
                a = -1;
                i2 = -1;
                trim = new String(a.Ve(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                if (CT != null) {
                }
                return null;
            }
        } catch (Exception e3) {
            a = -1;
            CT = null;
            i2 = -1;
            trim = new String(a.Ve(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
            if (CT != null) {
            }
            return null;
        }
        try {
            trim = new String(a.Ve(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
        } catch (Exception e4) {
            trim = null;
        }
        if (CT != null) {
        }
        return null;
    }
}
