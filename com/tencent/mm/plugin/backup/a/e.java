package com.tencent.mm.plugin.backup.a;

import android.content.SharedPreferences;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public abstract class e extends a {
    private static String TAG = "MicroMsg.BackupModel";
    private static boolean gXd = false;
    private static int jBq = 0;
    private static byte[] jBr = "key".getBytes();
    private static SharedPreferences jBt;
    public String jBm = SlookAirButtonFrequentContactAdapter.ID;
    public String jBn = "hello";
    public String jBo = "ok";
    public f jBp;
    public byte[] jBs;

    public abstract void aaf();

    public abstract void aag();

    public abstract void i(Object... objArr);

    public final f aae() {
        if (this.jBp == null) {
            this.jBp = new f();
        }
        return this.jBp;
    }

    public static int aah() {
        return jBq;
    }

    public static void jg(int i) {
        jBq = i;
    }

    public static byte[] aai() {
        return jBr;
    }

    public static void N(byte[] bArr) {
        jBr = bArr;
    }

    public static SharedPreferences aaj() {
        if (jBt == null) {
            jBt = ab.getContext().getSharedPreferences("BACKUP_CONFIG", 4);
        }
        return jBt;
    }

    public static void aak() {
        w.i(TAG, "holdReset");
        gXd = true;
    }

    public static boolean aal() {
        return gXd;
    }

    public static void aam() {
        jBr = "key".getBytes();
        jBq = 0;
        jBt = null;
        gXd = false;
    }
}
