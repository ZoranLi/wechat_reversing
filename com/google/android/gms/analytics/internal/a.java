package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.tencent.wcdb.FileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

public final class a extends o {
    public static boolean ahm;
    private com.google.android.gms.a.a.a.a ahn;
    private final j aho;
    private String ahp;
    private boolean ahq = false;
    private Object ahr = new Object();

    a(q qVar) {
        super(qVar);
        this.aho = new j(qVar.ahZ);
    }

    private boolean a(com.google.android.gms.a.a.a.a aVar, com.google.android.gms.a.a.a.a aVar2) {
        String str = null;
        String str2 = aVar2 == null ? null : aVar2.agM;
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        String iF = this.ahK.il().iF();
        synchronized (this.ahr) {
            if (!this.ahq) {
                this.ahp = hz();
                this.ahq = true;
            } else if (TextUtils.isEmpty(this.ahp)) {
                if (aVar != null) {
                    str = aVar.agM;
                }
                if (str == null) {
                    boolean x = x(str2 + iF);
                    return x;
                }
                this.ahp = w(str + iF);
            }
            Object w = w(str2 + iF);
            if (TextUtils.isEmpty(w)) {
                return false;
            } else if (w.equals(this.ahp)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.ahp)) {
                    str = iF;
                } else {
                    C("Resetting the client id because Advertising Id changed.");
                    str = this.ahK.il().iG();
                    d("New client Id", str);
                }
                x = x(str2 + str);
                return x;
            }
        }
    }

    private synchronized com.google.android.gms.a.a.a.a hx() {
        if (this.aho.f(1000)) {
            this.aho.start();
            com.google.android.gms.a.a.a.a hy = hy();
            if (a(this.ahn, hy)) {
                this.ahn = hy;
            } else {
                G("Failed to reset client id on adid change. Not using adid");
                this.ahn = new com.google.android.gms.a.a.a.a("", false);
            }
        }
        return this.ahn;
    }

    private com.google.android.gms.a.a.a.a hy() {
        com.google.android.gms.a.a.a.a aVar = null;
        try {
            aVar = com.google.android.gms.a.a.a.r(this.ahK.mContext);
        } catch (IllegalStateException e) {
            F("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        } catch (Throwable th) {
            if (!ahm) {
                ahm = true;
                f("Error getting advertiser id", th);
            }
        }
        return aVar;
    }

    private String hz() {
        Object obj;
        String str = null;
        try {
            FileInputStream openFileInput = this.ahK.mContext.openFileInput("gaClientIdData");
            byte[] bArr = new byte[FileUtils.S_IWUSR];
            int read = openFileInput.read(bArr, 0, FileUtils.S_IWUSR);
            if (openFileInput.available() > 0) {
                F("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                this.ahK.mContext.deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                C("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e) {
                    return str2;
                } catch (IOException e2) {
                    IOException iOException = e2;
                    str = str2;
                    IOException iOException2 = iOException;
                    f("Error reading Hash file, deleting it", obj);
                    this.ahK.mContext.deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
            return null;
        } catch (IOException e4) {
            obj = e4;
            f("Error reading Hash file, deleting it", obj);
            this.ahK.mContext.deleteFile("gaClientIdData");
            return str;
        }
    }

    private static String w(String str) {
        if (k.A("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, k.A("MD5").digest(str.getBytes()))});
    }

    private boolean x(String str) {
        try {
            String w = w(str);
            C("Storing hashed adid.");
            FileOutputStream openFileOutput = this.ahK.mContext.openFileOutput("gaClientIdData", 0);
            openFileOutput.write(w.getBytes());
            openFileOutput.close();
            this.ahp = w;
            return true;
        } catch (IOException e) {
            g("Error creating hash file", e);
            return false;
        }
    }

    protected final void hu() {
    }

    public final boolean hv() {
        ie();
        com.google.android.gms.a.a.a.a hx = hx();
        return (hx == null || hx.agN) ? false : true;
    }

    public final String hw() {
        ie();
        com.google.android.gms.a.a.a.a hx = hx();
        CharSequence charSequence = hx != null ? hx.agM : null;
        return TextUtils.isEmpty(charSequence) ? null : charSequence;
    }
}
