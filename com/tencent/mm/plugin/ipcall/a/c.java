package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.ipcall.a.g.i;
import com.tencent.mm.plugin.ipcall.a.g.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static c mME;
    public boolean isInit = false;
    private ArrayList<Integer> mMF = new ArrayList();
    ArrayList<Integer> mMG = new ArrayList();

    private c() {
    }

    public static c aDT() {
        if (mME == null) {
            mME = new c();
        }
        return mME;
    }

    public final void eP(boolean z) {
        Throwable e;
        InputStream inputStream = null;
        if (!this.isInit || z) {
            aDV();
            try {
                File file = new File(e.hgq + "ipcallCountryCodeConfig.cfg");
                String str;
                if (file.exists()) {
                    InputStream fileInputStream = new FileInputStream(file);
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                        str = "";
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                str = str + readLine;
                            } else {
                                w.d("MicroMsg.IPCallCountryCodeConfig", "config file content: %s", new Object[]{str});
                                yq(str);
                                this.isInit = true;
                                com.tencent.mm.a.e.b(fileInputStream);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = fileInputStream;
                        try {
                            w.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                            w.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", new Object[]{e.getMessage()});
                            com.tencent.mm.a.e.b(inputStream);
                        } catch (Throwable th) {
                            e = th;
                            com.tencent.mm.a.e.b(inputStream);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream = fileInputStream;
                        com.tencent.mm.a.e.b(inputStream);
                        throw e;
                    }
                }
                w.d("MicroMsg.IPCallCountryCodeConfig", "initConfig, file: %s not exist!", new Object[]{str});
                this.isInit = true;
                com.tencent.mm.a.e.b(null);
            } catch (Exception e3) {
                e = e3;
                w.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                w.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", new Object[]{e.getMessage()});
                com.tencent.mm.a.e.b(inputStream);
            }
        }
    }

    private void yq(String str) {
        if (!bg.mA(str)) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("restriction");
                w.d("MicroMsg.IPCallCountryCodeConfig", "restrictionCountryCode: %d", new Object[]{Integer.valueOf(jSONArray.length())});
                this.mMG.clear();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.mMG.add(Integer.valueOf(jSONArray.getInt(i)));
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                w.e("MicroMsg.IPCallCountryCodeConfig", "initConfigFromContent error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private void aDU() {
        this.mMF.clear();
        String value = g.sV().getValue("WeChatOutTopCountryCode");
        w.d("MicroMsg.IPCallCountryCodeConfig", "popularCountryConfig: %s", new Object[]{value});
        if (!bg.mA(value)) {
            String[] split = value.trim().split(",");
            int length = split.length;
            try {
                int i = length;
                for (String str : split) {
                    Integer valueOf = Integer.valueOf(bg.getInt(str, 0));
                    this.mMF.add(valueOf);
                    i.aEp().v(valueOf.intValue(), (long) i);
                    i--;
                }
            } catch (NumberFormatException e) {
                w.e("MicroMsg.IPCallCountryCodeConfig", "initPopularCountryFromDynamicConfig error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void aDV() {
        j aEp = i.aEp();
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ORDER BY IPCallPopularCountry.callTimeCount DESC,IPCallPopularCountry.lastCallTime DESC");
        Cursor a = aEp.gUz.a("SELECT IPCallPopularCountry.countryCode,IPCallPopularCountry.callTimeCount,IPCallPopularCountry.lastCallTime FROM IPCallPopularCountry  " + stringBuilder.toString(), null, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            if (arrayList.size() <= 0) {
                this.mMF = arrayList;
            } else {
                aDU();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        do {
            i iVar = new i();
            iVar.b(a);
            arrayList.add(Integer.valueOf(iVar.field_countryCode));
        } while (a.moveToNext());
        if (a != null) {
            a.close();
        }
        if (arrayList.size() <= 0) {
            aDU();
        } else {
            this.mMF = arrayList;
        }
    }

    public final List<Integer> aDW() {
        if (!this.isInit) {
            eP(false);
        }
        return this.mMF;
    }

    public final boolean og(int i) {
        if (!this.isInit) {
            eP(false);
        }
        if (this.mMG == null || this.mMG.size() <= 0) {
            return false;
        }
        return this.mMG.contains(Integer.valueOf(i));
    }
}
