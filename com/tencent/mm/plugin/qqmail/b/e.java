package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.util.Map;
import java.util.Map.Entry;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class e {
    public static int ozs = 100;
    private int gMU = ozs;
    public String ozt = null;

    public e(String str, int i) {
        w.i("Msg.Plugin.HttpRequestCache", "HttpRequestCache constructor, path = " + str + ", maxCount = " + i);
        this.ozt = str;
        File file = new File(this.ozt);
        if (!file.exists()) {
            file.mkdir();
        }
        if (i <= 0) {
            i = ozs;
        }
        this.gMU = i;
    }

    public final byte[] i(String str, Map<String, String> map) {
        if (str == null || str.length() == 0) {
            w.e("Msg.Plugin.HttpRequestCache", "getCache, invalid argument");
            return null;
        }
        String j = j(str, map);
        byte[] readFromFile = readFromFile(this.ozt + j);
        if (readFromFile == null) {
            w.i("Msg.Plugin.HttpRequestCache", "readFromFile fail, cipherText is null, read error or cache not exist");
            return null;
        }
        byte[] decrypt = decrypt(readFromFile, CM(j));
        if (decrypt != null) {
            return decrypt;
        }
        w.e("Msg.Plugin.HttpRequestCache", "decrypt fail, plaintText is null");
        return null;
    }

    public final boolean a(String str, Map<String, String> map, byte[] bArr) {
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            w.e("Msg.Plugin.HttpRequestCache", "setCache, invalid argument");
            return false;
        }
        aUm();
        String j = j(str, map);
        byte[] encrypt = encrypt(bArr, CM(j));
        if (encrypt != null) {
            return r(this.ozt + j, encrypt);
        }
        w.e("Msg.Plugin.HttpRequestCache", "encrypt fail, cipherText is null");
        return false;
    }

    private static String j(String str, Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                stringBuffer.append(str2);
                stringBuffer.append(str3);
            }
        }
        return g.n(stringBuffer.toString().getBytes());
    }

    private static byte[] CM(String str) {
        return g.n(str.toString().getBytes()).substring(8, 16).getBytes();
    }

    public final void aUm() {
        int length;
        int i = 0;
        String[] list = new File(this.ozt).list();
        if (list != null) {
            length = list.length;
        } else {
            length = 0;
        }
        if (length >= this.gMU) {
            String[] list2 = new File(this.ozt).list();
            File file = null;
            int length2 = list2.length;
            while (i < length2) {
                file = new File(list2[i]);
                file.lastModified();
                i++;
            }
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            w.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            return null;
        }
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            w.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            return null;
        }
    }

    public static byte[] readFromFile(String str) {
        Throwable e;
        Throwable e2;
        FileInputStream fileInputStream;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            int length = (int) file.length();
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[length];
                if (fileInputStream.read(bArr) != length) {
                    try {
                        fileInputStream.close();
                        return null;
                    } catch (Throwable e3) {
                        w.printErrStackTrace("Msg.Plugin.HttpRequestCache", e3, "", new Object[0]);
                        return null;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Throwable e22) {
                    w.printErrStackTrace("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
                }
                return bArr;
            } catch (Exception e4) {
                e3 = e4;
                try {
                    w.printErrStackTrace("Msg.Plugin.HttpRequestCache", e3, "", new Object[0]);
                    if (fileInputStream != null) {
                        return null;
                    }
                    try {
                        fileInputStream.close();
                        return null;
                    } catch (Throwable e32) {
                        w.printErrStackTrace("Msg.Plugin.HttpRequestCache", e32, "", new Object[0]);
                        return null;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e322) {
                            w.printErrStackTrace("Msg.Plugin.HttpRequestCache", e322, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e322 = e5;
            fileInputStream = null;
            w.printErrStackTrace("Msg.Plugin.HttpRequestCache", e322, "", new Object[0]);
            if (fileInputStream != null) {
                return null;
            }
            fileInputStream.close();
            return null;
        } catch (Throwable e3222) {
            fileInputStream = null;
            e22 = e3222;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e22;
        }
    }

    public static boolean r(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable e;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Throwable e2) {
                    w.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e2 = e3;
                try {
                    w.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        w.printErrStackTrace("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            w.printErrStackTrace("Msg.Plugin.HttpRequestCache", e4, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            w.printErrStackTrace("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
    }
}
