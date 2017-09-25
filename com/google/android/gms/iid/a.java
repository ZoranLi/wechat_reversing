package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.mm.plugin.gif.MMGIFException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public final class a {
    static Map<String, a> atq = new HashMap();
    public static e atr;
    private static d ats;
    public static String atw;
    KeyPair att;
    public String atu = "";
    long atv;
    Context mContext;

    private a(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.atu = str;
    }

    static int F(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            new StringBuilder("Never happens: can't find own package ").append(e);
            return i;
        }
    }

    public static a G(Context context) {
        return a(context, null);
    }

    public static synchronized a a(Context context, Bundle bundle) {
        a aVar;
        synchronized (a.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (atr == null) {
                atr = new e(applicationContext);
                ats = new d(applicationContext);
            }
            atw = Integer.toString(F(applicationContext));
            aVar = (a) atq.get(str);
            if (aVar == null) {
                aVar = new a(applicationContext, str);
                atq.put(str, aVar);
            }
        }
        return aVar;
    }

    static String a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + MMGIFException.D_GIF_ERR_IMAGE_DEFECT) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    static String d(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    static e kD() {
        return atr;
    }

    static d kE() {
        return ats;
    }

    public static boolean kF() {
        String str = atr.get("appVersion");
        if (str == null || !str.equals(atw)) {
            return true;
        }
        str = atr.get("lastToken");
        if (str == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str)).longValue() > 604800;
    }

    public final String b(String str, String str2, Bundle bundle) {
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        String str3 = "".equals(this.atu) ? str : this.atu;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        d dVar = ats;
        if (this.att == null) {
            this.att = atr.ad(this.atu);
        }
        if (this.att == null) {
            this.atv = System.currentTimeMillis();
            this.att = atr.a(this.atu, this.atv);
        }
        KeyPair keyPair = this.att;
        Intent a = dVar.a(bundle, keyPair);
        if (a != null && a.hasExtra("google.messenger")) {
            a = dVar.a(bundle, keyPair);
        }
        return d.h(a);
    }
}
