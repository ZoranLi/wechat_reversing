package com.tencent.mm.plugin.sns.model;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;

public final class aa {
    public static boolean ncZ = false;
    public static char[] pVa = new char[36];
    public ae handler = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ aa pVb;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.pVb.pUZ >= 5 || System.currentTimeMillis() - this.pVb.pUY > 300000) {
                w.d("MicroMsg.RemoveSnsTask", "cleanCount: " + this.pVb.pUZ);
                aa.ncZ = false;
            } else if (!this.pVb.pUX && aa.ncZ) {
                new a(this.pVb).l("");
            }
        }
    };
    public boolean pUX = false;
    public long pUY = 0;
    public int pUZ = 0;

    class a extends k<String, String, Boolean> {
        private String arH;
        private SharedPreferences hgx;
        final /* synthetic */ aa pVb;
        private String pVc;
        PInt pVd;
        PInt pVe;
        private String pVf;
        private String username;

        public final /* synthetic */ Object bed() {
            return bej();
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            Boolean bool = (Boolean) obj;
            w.d("MicroMsg.RemoveSnsTask", "onPostExecute " + bool);
            aa aaVar = this.pVb;
            aaVar.pUZ++;
            if (bool.booleanValue()) {
                aa.b(this.pVd, this.pVe);
                if (this.hgx != null) {
                    this.hgx.edit().putInt(this.pVc, this.pVd.value).commit();
                    this.hgx.edit().putInt(this.arH, this.pVe.value).commit();
                    w.d("MicroMsg.RemoveSnsTask", "update dir " + this.pVd.value + " " + this.pVe.value + " cleanCount: " + this.pVb.pUZ);
                }
                this.pVb.handler.sendEmptyMessageDelayed(0, 20000);
            }
            this.pVb.pUX = false;
        }

        public a(aa aaVar) {
            this.pVb = aaVar;
            this.hgx = null;
            this.pVc = "";
            this.arH = "";
            this.pVd = new PInt();
            this.pVe = new PInt();
            this.hgx = ab.getContext().getSharedPreferences("preferences_remove_task", 0);
            h.vJ();
            if (h.vG().uV()) {
                this.username = m.xL();
                this.pVc = "remove_key_base" + this.username;
                this.arH = "remove_key" + this.username;
                h.vJ();
                if (h.vG().uV() && !ae.beu() && ae.wO() != null && ae.beO() != null) {
                    com.tencent.mm.plugin.sns.storage.k Gk = ae.beO().Gk(this.username);
                    if (Gk != null) {
                        this.pVf = Gk.field_bgId;
                    }
                    w.d("MicroMsg.RemoveSnsTask", "my bgid %s", new Object[]{this.pVf});
                    aaVar.pUX = true;
                }
            }
        }

        private Boolean bej() {
            w.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
            if (!aa.ncZ) {
                return Boolean.valueOf(false);
            }
            if (!this.pVb.pUX) {
                return Boolean.valueOf(false);
            }
            if (ae.beu()) {
                aa.ncZ = false;
                return Boolean.valueOf(false);
            }
            this.pVd.value = this.hgx.getInt(this.pVc, 0);
            this.pVe.value = this.hgx.getInt(this.arH, 0);
            String accSnsPath = ae.getAccSnsPath();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (!aa.O(accSnsPath + aa.pVa[this.pVd.value % 36] + "/" + aa.pVa[this.pVe.value % 36], this.pVf, this.username)) {
                    return Boolean.valueOf(false);
                }
                w.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - currentTimeMillis) + " " + this.pVd.value + " " + this.pVe.value);
                return Boolean.valueOf(true);
            } catch (Exception e) {
            }
        }

        public final ae bec() {
            return ae.bex();
        }
    }

    static {
        int i = 0;
        int i2 = 48;
        while (i2 <= 57) {
            pVa[i] = (char) i2;
            i2++;
            i++;
        }
        i2 = 97;
        while (i2 <= 122) {
            pVa[i] = (char) i2;
            i2++;
            i++;
        }
    }

    public static boolean O(String str, String str2, String str3) {
        for (FileEntry fileEntry : FileOp.x(str, true)) {
            if (!ncZ) {
                w.d("MicroMsg.RemoveSnsTask", "broken here by ??");
                return false;
            } else if (fileEntry.name != null && !bg.mA(str2) && str3 != null && (fileEntry.name.contains(str2) || fileEntry.name.contains(str3))) {
                w.d("MicroMsg.RemoveSnsTask", "do not delete my bg %s", new Object[]{str2});
            } else if (bg.aA(fileEntry.timestamp) > 604800000) {
                FileOp.deleteFile(fileEntry.name);
            }
        }
        return true;
    }

    public static void b(PInt pInt, PInt pInt2) {
        if (pInt2.value + 1 >= 36) {
            pInt2.value = 0;
            pInt.value = (pInt.value + 1) % 36;
            return;
        }
        pInt2.value = (pInt2.value + 1) % 36;
    }
}
