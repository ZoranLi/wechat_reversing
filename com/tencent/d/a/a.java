package com.tencent.d.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.d;
import com.tencent.d.a.c.e;
import com.tencent.d.a.c.f;
import com.tencent.d.a.c.g;
import com.tencent.d.a.c.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.UnrecoverableEntryException;

public final class a implements com.tencent.d.a.c.a {
    private static boolean wYV = false;

    @SuppressLint({"PrivateApi"})
    public static void setUp() {
        try {
            Method method = Class.forName("android.security.keystore.SoterKeyStoreProvider").getMethod("install", new Class[0]);
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
        } catch (ClassNotFoundException e) {
            c.i("Soter.SoterCore", "soter: no SoterProvider found", new Object[0]);
        } catch (NoSuchMethodException e2) {
            c.i("Soter.SoterCore", "soter: function not found", new Object[0]);
        } catch (IllegalAccessException e3) {
            c.i("Soter.SoterCore", "soter: cannot access", new Object[0]);
        } catch (InvocationTargetException e4) {
            c.i("Soter.SoterCore", "soter: InvocationTargetException", new Object[0]);
        } finally {
            wYV = true;
        }
    }

    public static boolean cfB() {
        if (!wYV) {
            setUp();
        }
        Provider[] providers = Security.getProviders();
        if (providers == null) {
            c.e("Soter.SoterCore", "soter: no provider supported", new Object[0]);
            return false;
        }
        for (Provider name : providers) {
            if ("SoterKeyStore".equals(name.getName())) {
                c.i("Soter.SoterCore", "soter: found soter provider", new Object[0]);
                return true;
            }
        }
        c.i("Soter.SoterCore", "soter: soter provider not found", new Object[0]);
        return false;
    }

    public static e cfC() {
        c.i("Soter.SoterCore", "soter: start generate ask", new Object[0]);
        if (cfB()) {
            try {
                KeyStore.getInstance("AndroidKeyStore").load(null);
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "SoterKeyStore");
                instance.initialize(com.tencent.d.a.b.a.VI(d.cfK().wZB + ".addcounter.auto_signed_when_get_pubkey_attk").J("SHA-256").K("PSS").cfI());
                long nanoTime = System.nanoTime();
                instance.generateKeyPair();
                long fb = f.fb(nanoTime);
                c.i("Soter.SoterCore", "soter: generate successfully. cost: %d ms", Long.valueOf(fb));
                return new e(0);
            } catch (Exception e) {
                Exception exception = e;
                c.e("Soter.SoterCore", "soter: generateAppGlobalSecureKey " + exception.toString(), new Object[0]);
                c.a("Soter.SoterCore", exception, "soter: generateAppGlobalSecureKey error");
                return new e(4, exception.toString());
            }
        }
        c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
        return new e(2);
    }

    public static e cfD() {
        c.i("Soter.SoterCore", "soter: start remove app global secure key", new Object[0]);
        if (cfB()) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                instance.deleteEntry(d.cfK().wZB);
                return new e(0);
            } catch (Exception e) {
                Exception exception = e;
                c.e("Soter.SoterCore", "soter: removeAppGlobalSecureKey " + exception.toString(), new Object[0]);
                return new e(5, exception.toString());
            }
        }
        c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
        return new e(2);
    }

    public static boolean cfE() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (instance.getCertificate(d.cfK().wZB) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            c.e("Soter.SoterCore", "soter: hasAppGlobalSecureKey exception: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public static g cfF() {
        c.i("Soter.SoterCore", "soter: start get app global secure key pub", new Object[0]);
        if (cfB()) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                try {
                    Key key = instance.getKey(d.cfK().wZB, "from_soter_ui".toCharArray());
                    if (key != null) {
                        return bE(key.getEncoded());
                    }
                    c.e("Soter.SoterCore", "soter: key can not be retrieved", new Object[0]);
                    return null;
                } catch (ClassCastException e) {
                    c.e("Soter.SoterCore", "soter: cast error: " + e.toString(), new Object[0]);
                    return null;
                }
            } catch (Exception e2) {
                c.a("Soter.SoterCore", e2, "soter: error when get ask");
                return null;
            }
        }
        c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
        return null;
    }

    public static e VC(String str) {
        Exception exception;
        if (f.mA(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            return new e(1, "no authKeyName");
        } else if (cfB()) {
            try {
                if (!cfE()) {
                    return new e(3, "app secure key not exist");
                }
                KeyStore.getInstance("AndroidKeyStore").load(null);
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "SoterKeyStore");
                try {
                    instance.initialize(com.tencent.d.a.b.a.VI(str + String.format(".addcounter.auto_signed_when_get_pubkey(%s).secmsg_and_counter_signed_when_sign", new Object[]{d.cfK().wZB})).J("SHA-256").cfJ().K("PSS").cfI());
                    long nanoTime = System.nanoTime();
                    instance.generateKeyPair();
                    long fb = f.fb(nanoTime);
                    c.i("Soter.SoterCore", "soter: generate successfully, cost: %d ms", Long.valueOf(fb));
                    return new e(0);
                } catch (Exception e) {
                    exception = e;
                    c.e("Soter.SoterCore", "soter: cause exception. maybe reflection exception: " + exception.toString(), new Object[0]);
                    return new e(5, exception.toString());
                }
            } catch (Exception e2) {
                exception = e2;
                c.e("Soter.SoterCore", "soter: generate auth key failed: " + exception.toString(), new Object[0]);
                return new e(5, exception.toString());
            }
        } else {
            c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
            return new e(2);
        }
    }

    public static e bd(String str, boolean z) {
        if (f.mA(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            return new e(1, "no authKeyName");
        }
        c.i("Soter.SoterCore", "soter: start remove key: " + str, new Object[0]);
        if (cfB()) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                instance.deleteEntry(str);
                if (z) {
                    c.i("Soter.SoterCore", "soter: auto delete ask", new Object[0]);
                    if (cfE()) {
                        cfD();
                    }
                }
                return new e(0);
            } catch (Exception e) {
                Exception exception = e;
                c.e("Soter.SoterCore", "soter: removeAuthKey " + exception.toString(), new Object[0]);
                return new e(6, exception.toString());
            }
        }
        c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
        return new e(2);
    }

    public static boolean VD(String str) {
        if (f.mA(str)) {
            c.e("Soter.SoterCore", "soter: authkey name not correct", new Object[0]);
            return false;
        }
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (instance.getCertificate(str) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            c.e("Soter.SoterCore", "soter: hasAppGlobalSecureKey exception: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public static boolean VE(String str) {
        c.i("Soter.SoterCore", String.format("soter: checking key valid: auth key name: %s, autoDelIfNotValid: %b ", new Object[]{str, Boolean.valueOf(true)}), new Object[0]);
        if (f.mA(str)) {
            c.e("Soter.SoterCore", "soter: checking key valid: authkey name not correct", new Object[0]);
            return false;
        }
        try {
            VH(str);
            c.i("Soter.SoterCore", "soter: key valid", new Object[0]);
            return true;
        } catch (UnrecoverableEntryException e) {
            c.e("Soter.SoterCore", "soter: key invalid.", new Object[0]);
            bd(str, false);
            return false;
        } catch (InvalidKeyException e2) {
            c.e("Soter.SoterCore", "soter: key invalid.", new Object[0]);
            bd(str, false);
            return false;
        } catch (Exception e3) {
            c.e("Soter.SoterCore", "soter: occurs other exceptions: %s", e3.toString());
            c.a("Soter.SoterCore", e3, "soter: occurs other exceptions");
            return false;
        }
    }

    public static g VF(String str) {
        if (f.mA(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        } else if (cfB()) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                try {
                    Key key = instance.getKey(str, "from_soter_ui".toCharArray());
                    if (key != null) {
                        return bE(key.getEncoded());
                    }
                    c.e("Soter.SoterCore", "soter: key can not be retrieved", new Object[0]);
                    return null;
                } catch (ClassCastException e) {
                    c.e("Soter.SoterCore", "soter: cast error: " + e.toString(), new Object[0]);
                    return null;
                }
            } catch (Exception e2) {
                c.a("Soter.SoterCore", e2, "soter: error in get auth key model");
                return null;
            }
        } else {
            c.e("Soter.SoterCore", "soter: not support soter AndroidKeyStore", new Object[0]);
            return null;
        }
    }

    public static Signature VG(String str) {
        Signature signature = null;
        if (f.mA(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
        } else if (cfB()) {
            try {
                signature = VH(str);
            } catch (UnrecoverableEntryException e) {
                c.e("Soter.SoterCore", "soter: key invalid. Advice remove the key", new Object[0]);
            } catch (InvalidKeyException e2) {
                c.e("Soter.SoterCore", "soter: key invalid. Advice remove the key", new Object[0]);
            } catch (Exception e3) {
                c.e("Soter.SoterCore", "soter: exception when getSignatureResult: " + e3.toString(), new Object[0]);
                c.a("Soter.SoterCore", e3, "soter: exception when getSignatureResult");
            }
        } else {
            c.e("Soter.SoterCore", "soter: not support soterAndroidKeyStore", new Object[0]);
        }
        return signature;
    }

    private static Signature VH(String str) {
        if (f.mA(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        }
        Signature instance = Signature.getInstance("SHA256withRSA/PSS", "AndroidKeyStoreBCWorkaround");
        KeyStore instance2 = KeyStore.getInstance("SoterKeyStore");
        instance2.load(null);
        PrivateKeyEntry privateKeyEntry = (PrivateKeyEntry) instance2.getEntry(str, null);
        if (privateKeyEntry != null) {
            instance.initSign(privateKeyEntry.getPrivateKey());
            return instance;
        }
        c.e("Soter.SoterCore", "soter: entry not exists", new Object[0]);
        return null;
    }

    public static h bC(byte[] bArr) {
        h hVar = null;
        int i = (bArr == null || bArr.length <= 0) ? 1 : 0;
        if (i != 0) {
            c.e("Soter.SoterCore", "origin is null or nil. abort", new Object[0]);
        } else if (bArr.length < 4) {
            c.e("Soter.SoterCore", "soter: length not correct 1", new Object[0]);
        } else {
            Object obj = new byte[4];
            System.arraycopy(bArr, 0, obj, 0, 4);
            i = bD(obj);
            c.d("Soter", "parsed raw length: " + i, new Object[0]);
            Object obj2 = new byte[i];
            if (bArr.length <= i + 4) {
                c.e("Soter.SoterCore", "soter: length not correct 2", new Object[0]);
            } else {
                System.arraycopy(bArr, 4, obj2, 0, i);
                hVar = h.VJ(new String(obj2));
                int length = bArr.length - (i + 4);
                c.d("Soter.SoterCore", "soter: signature length: " + length, new Object[0]);
                Object obj3 = new byte[length];
                System.arraycopy(bArr, i + 4, obj3, 0, length);
                if (hVar != null) {
                    hVar.signature = Base64.encodeToString(obj3, 2);
                }
            }
        }
        return hVar;
    }

    private static int bD(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            i2 += (bArr[i] & 255) << (i * 8);
            i++;
        }
        return i2;
    }

    private static g bE(byte[] bArr) {
        if (bArr == null) {
            c.e("Soter.SoterCore", "soter: raw data is null", new Object[0]);
            return null;
        }
        if (bArr.length < 4) {
            c.e("Soter.SoterCore", "soter: raw data length smaller than RAW_LENGTH_PREFIX", new Object[0]);
        }
        Object obj = new byte[4];
        System.arraycopy(bArr, 0, obj, 0, 4);
        int bD = bD(obj);
        c.d("Soter.SoterCore", "soter: parsed raw length: " + bD, new Object[0]);
        Object obj2 = new byte[bD];
        if (bArr.length <= bD + 4) {
            c.e("Soter.SoterCore", "length not correct 2", new Object[0]);
            return null;
        }
        System.arraycopy(bArr, 4, obj2, 0, bD);
        String str = new String(obj2);
        c.d("Soter.SoterCore", "soter: to convert json: " + str, new Object[0]);
        g gVar = new g(str, "");
        int length = bArr.length - (bD + 4);
        c.d("Soter.SoterCore", "soter: signature length: " + length, new Object[0]);
        Object obj3 = new byte[length];
        System.arraycopy(bArr, bD + 4, obj3, 0, length);
        gVar.signature = Base64.encodeToString(obj3, 2);
        return gVar;
    }

    public static boolean hc(Context context) {
        return com.tencent.d.a.a.a.hf(context).isHardwareDetected();
    }

    public static boolean hd(Context context) {
        return com.tencent.d.a.a.a.hf(context).hasEnrolledFingerprints();
    }

    public static boolean he(Context context) {
        return (com.tencent.d.a.a.c.hn(context) || com.tencent.d.a.a.c.hm(context)) ? false : true;
    }

    public static String cfG() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<deviceinfo>");
        stringBuilder.append("<MANUFACTURER name=\"");
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append("\">");
        stringBuilder.append("<MODEL name=\"");
        stringBuilder.append(Build.MODEL);
        stringBuilder.append("\">");
        stringBuilder.append("<VERSION_RELEASE name=\"");
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append("\">");
        stringBuilder.append("<VERSION_INCREMENTAL name=\"");
        stringBuilder.append(VERSION.INCREMENTAL);
        stringBuilder.append("\">");
        stringBuilder.append("<DISPLAY name=\"");
        stringBuilder.append(Build.DISPLAY);
        stringBuilder.append("\">");
        stringBuilder.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
        c.d("Soter.SoterCore", "soter: getFingerprint  " + stringBuilder.toString(), new Object[0]);
        return stringBuilder.toString();
    }
}
