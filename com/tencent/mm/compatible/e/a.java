package com.tencent.mm.compatible.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.SparseArray;
import com.tencent.mm.a.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class a {
    public static Boolean gSe;

    private static class a {
        public String fwP;
        public int gSf;
        public int gSg;
        public int gSh;
        public SparseArray<String> gSi;

        public final String toString() {
            return String.format(Locale.US, "pkgname: %s, minCode:%d, maxCode: %d, value: %s, chkExp: %d", new Object[]{this.fwP, Integer.valueOf(this.gSf), Integer.valueOf(this.gSg), this.gSi, Integer.valueOf(this.gSh)});
        }
    }

    private static class b {
        public int gSh;
        public SparseArray<String> gSi;
        public String gSj;
        public String model;
        public String version;

        public final String toString() {
            return String.format(Locale.US, "manufacture: %s, model: %s, version: %s, value: %s, chkExp: %d", new Object[]{this.gSj, this.model, this.version, this.gSi, Integer.valueOf(this.gSh)});
        }
    }

    public static boolean a(String str, String str2, PInt pInt, PBool pBool) {
        if (str == null) {
            pBool.value = false;
            return false;
        } else if (str2 == null) {
            pBool.value = true;
            return false;
        } else if (str.equals(str2)) {
            pInt.value++;
            pBool.value = true;
            return true;
        } else {
            pBool.value = false;
            return false;
        }
    }

    public static List<PackageInfo> aD(boolean z) {
        Set hashSet = new HashSet();
        if (z) {
            ActivityManager activityManager = (ActivityManager) ab.getContext().getSystemService("activity");
            if (activityManager != null) {
                try {
                    List<RunningServiceInfo> runningServices = activityManager.getRunningServices(32767);
                    if (runningServices != null) {
                        for (RunningServiceInfo runningServiceInfo : runningServices) {
                            hashSet.add(runningServiceInfo.service.getPackageName());
                        }
                    }
                } catch (SecurityException e) {
                    w.e("MicroMsg.PermissionConfig", "getRunningServices failed");
                }
            }
        }
        PackageManager packageManager = ab.getContext().getPackageManager();
        if (packageManager == null) {
            return null;
        }
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        if (installedPackages == null || !z) {
            return installedPackages;
        }
        List<PackageInfo> arrayList = new ArrayList();
        for (PackageInfo packageInfo : installedPackages) {
            if (hashSet.contains(packageInfo.packageName)) {
                arrayList.add(packageInfo);
            }
        }
        return arrayList;
    }

    public static void a(String str, List<b> list, List<a> list2) {
        Throwable th;
        if (e.aO(str)) {
            String str2 = ".perm.values.";
            String str3 = "";
            String bIN = v.bIN();
            if (bIN.equals("zh_CN")) {
                bIN = "zh_CN";
            } else if (bIN.equals("zh_TW") || bIN.equals("zh_HK")) {
                bIN = str3 + "zh_TW";
            } else {
                bIN = str3 + "en";
            }
            BufferedReader bufferedReader = null;
            BufferedReader bufferedReader2;
            try {
                bufferedReader2 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        str3 = bufferedReader2.readLine();
                        if (str3 != null) {
                            String trim = str3.trim();
                            if (trim.length() != 0) {
                                Map q = bh.q(trim, "perm");
                                if (q == null) {
                                    w.e("MicroMsg.PermissionConfig", "unable to parse xml, " + trim);
                                } else {
                                    str3 = (String) q.get(".perm.type");
                                    if (str3 == null) {
                                        w.e("MicroMsg.PermissionConfig", "invalid config, " + trim);
                                    } else if (str3.equals("1")) {
                                        b bVar = new b();
                                        bVar.gSi = new SparseArray();
                                        bVar.gSj = (String) q.get(".perm.manufacture");
                                        bVar.model = (String) q.get(".perm.model");
                                        bVar.version = (String) q.get(".perm.version_release");
                                        bVar.gSi.append(1, q.get(str2 + bIN));
                                        bVar.gSi.append(2, q.get(str2 + "camera." + bIN));
                                        bVar.gSh = bg.PY((String) q.get(".perm.check_exception"));
                                        list.add(bVar);
                                    } else if (str3.equals("2")) {
                                        a aVar = new a();
                                        aVar.gSi = new SparseArray();
                                        aVar.fwP = (String) q.get(".perm.package");
                                        aVar.gSf = bg.PY((String) q.get(".perm.min_versioncode"));
                                        aVar.gSg = bg.PY((String) q.get(".perm.max_versioncode"));
                                        aVar.gSi.append(1, q.get(str2 + bIN));
                                        aVar.gSi.append(2, q.get(str2 + "camera." + bIN));
                                        aVar.gSh = bg.PY((String) q.get(".perm.check_exception"));
                                        list2.add(aVar);
                                    }
                                }
                            }
                        } else {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        bufferedReader = bufferedReader2;
                    } catch (IOException e3) {
                    }
                }
            } catch (FileNotFoundException e4) {
                try {
                    w.e("MicroMsg.PermissionConfig", "file not found exception");
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException e5) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    bufferedReader2 = bufferedReader;
                    th = th2;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                bufferedReader2 = null;
                try {
                    w.e("MicroMsg.PermissionConfig", "read permission config file failed");
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                            return;
                        } catch (IOException e8) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    throw th;
                }
            } catch (Throwable th22) {
                bufferedReader2 = null;
                th = th22;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                throw th;
            }
        }
        w.i("MicroMsg.PermissionConfig", "file is not exists");
    }
}
