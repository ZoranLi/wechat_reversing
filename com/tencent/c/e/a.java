package com.tencent.c.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class a {
    public static List<com.tencent.c.a.a> fy(Context context) {
        List<com.tencent.c.a.a> arrayList = new ArrayList();
        try {
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(0)) {
                if (!(applicationInfo.packageName == null || applicationInfo.packageName.equals(packageName))) {
                    int i;
                    Object obj = (applicationInfo.flags & 1) != 0 ? 1 : null;
                    com.tencent.c.a.a bu = bu(context, applicationInfo.packageName);
                    bu.wQH = packageManager.getApplicationLabel(applicationInfo).toString();
                    if (bu.wQH == null) {
                        bu.wQH = "";
                    }
                    if (obj != null) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    bu.moU = i;
                    bu.fileSize = new File(applicationInfo.sourceDir).length();
                    bu.wQJ = applicationInfo.sourceDir;
                    arrayList.add(bu);
                    g.bU("add app: " + applicationInfo.packageName);
                }
            }
        } catch (Throwable th) {
            g.bS("getAllAppInfos(), exception: " + th);
        }
        return arrayList;
    }

    public static String Vg(String str) {
        ZipFile zipFile;
        BufferedReader bufferedReader;
        Throwable th;
        String str2 = null;
        try {
            zipFile = new ZipFile(str);
            try {
                if (new File(str).exists()) {
                    ZipEntry entry = zipFile.getEntry("META-INF/MANIFEST.MF");
                    if (entry != null) {
                        String readLine;
                        int indexOf;
                        bufferedReader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(entry)));
                        while (true) {
                            try {
                                readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                } else if (readLine.contains("classes.dex")) {
                                    readLine = bufferedReader.readLine();
                                    if (readLine != null && readLine.contains("SHA1-Digest")) {
                                        indexOf = readLine.indexOf(":");
                                        if (indexOf > 0) {
                                            break;
                                        }
                                    }
                                }
                            } catch (Exception e) {
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        str2 = readLine.substring(indexOf + 1).trim();
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                        }
                        try {
                            zipFile.close();
                        } catch (IOException e3) {
                        }
                    } else {
                        bufferedReader = null;
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    try {
                        zipFile.close();
                    } catch (IOException e5) {
                    }
                } else {
                    try {
                        zipFile.close();
                    } catch (IOException e6) {
                    }
                }
            } catch (Exception e7) {
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                    }
                }
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e9) {
                    }
                }
                return str2;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedReader = null;
                th = th4;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e10) {
                    }
                }
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e11) {
                    }
                }
                throw th;
            }
        } catch (Exception e12) {
            zipFile = null;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            return str2;
        } catch (Throwable th5) {
            bufferedReader = null;
            th = th5;
            zipFile = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
        return str2;
    }

    public static List<byte[]> bt(Context context, String str) {
        List<byte[]> arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                Signature[] signatureArr = packageInfo.signatures;
                int i = 0;
                while (i < signatureArr.length && i < 5) {
                    X509Certificate x509Certificate = (X509Certificate) a(CertificateFactory.getInstance("X.509"), signatureArr[i]);
                    if (x509Certificate != null) {
                        try {
                            arrayList.add(e.bx(x509Certificate.getEncoded()));
                        } catch (CertificateEncodingException e) {
                            g.bT("extractPkgCertMd5s(), CertificateEncodingException: " + e);
                        }
                    }
                    i++;
                }
            }
        } catch (Exception e2) {
            g.bT("extractPkgCertMd5s(), Exception: " + e2);
        }
        return arrayList;
    }

    public static com.tencent.c.a.a bu(Context context, String str) {
        com.tencent.c.a.a aVar = new com.tencent.c.a.a();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            aVar.fwP = str;
            aVar.versionName = packageInfo.versionName;
            aVar.versionCode = packageInfo.versionCode;
            X509Certificate x509Certificate = (X509Certificate) a(CertificateFactory.getInstance("X.509"), packageInfo.signatures[0]);
            if (x509Certificate != null) {
                String str2;
                byte[] bx = e.bx(x509Certificate.getEncoded());
                if (bx == null) {
                    str2 = null;
                } else {
                    StringBuffer stringBuffer = new StringBuffer(bx.length);
                    for (byte b : bx) {
                        String toHexString = Integer.toHexString(b & 255);
                        if (toHexString.length() < 2) {
                            stringBuffer.append(0);
                        }
                        stringBuffer.append(toHexString.toUpperCase());
                    }
                    str2 = stringBuffer.toString();
                }
                aVar.wQI = str2;
            }
        } catch (NameNotFoundException e) {
        } catch (CertificateEncodingException e2) {
        } catch (Exception e3) {
        }
        return aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.cert.Certificate a(java.security.cert.CertificateFactory r3, android.content.pm.Signature r4) {
        /*
        r2 = new java.io.ByteArrayInputStream;
        r0 = r4.toByteArray();
        r2.<init>(r0);
        r1 = 0;
        r0 = r3.generateCertificate(r2);	 Catch:{ CertificateException -> 0x0014, Exception -> 0x001d, all -> 0x0026 }
        r0 = (java.security.cert.X509Certificate) r0;	 Catch:{ CertificateException -> 0x0014, Exception -> 0x001d, all -> 0x0026 }
        r2.close();	 Catch:{ IOException -> 0x002b }
    L_0x0013:
        return r0;
    L_0x0014:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x001a }
        r0 = r1;
        goto L_0x0013;
    L_0x001a:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0013;
    L_0x001d:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x0023 }
        r0 = r1;
        goto L_0x0013;
    L_0x0023:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0013;
    L_0x0026:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x002d }
    L_0x002a:
        throw r0;
    L_0x002b:
        r1 = move-exception;
        goto L_0x0013;
    L_0x002d:
        r1 = move-exception;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.c.e.a.a(java.security.cert.CertificateFactory, android.content.pm.Signature):java.security.cert.Certificate");
    }
}
