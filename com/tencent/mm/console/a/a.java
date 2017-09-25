package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.as.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.protocal.c.ana;
import com.tencent.mm.protocal.c.anb;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.g;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public final class a implements com.tencent.mm.pluginsdk.b.a {
    static {
        b.a(new a(), "//fts");
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        if (!d.Im()) {
            return false;
        }
        if (strArr.length < 2) {
            return true;
        }
        String str = strArr[1];
        Object obj = -1;
        switch (str.hashCode()) {
            case -1354714445:
                if (str.equals("copydb")) {
                    obj = 2;
                    break;
                }
                break;
            case -1183792455:
                if (str.equals("insert")) {
                    obj = 6;
                    break;
                }
                break;
            case -1132164145:
                if (str.equals("clearconfig")) {
                    obj = 4;
                    break;
                }
                break;
            case 3237038:
                if (str.equals("info")) {
                    obj = 5;
                    break;
                }
                break;
            case 104187309:
                if (str.equals("msbiz")) {
                    obj = null;
                    break;
                }
                break;
            case 819712873:
                if (str.equals("deletedb")) {
                    obj = 1;
                    break;
                }
                break;
            case 955180557:
                if (str.equals("corrupt")) {
                    obj = 3;
                    break;
                }
                break;
        }
        File file;
        f fVar;
        switch (obj) {
            case null:
                anb Iq = com.tencent.mm.as.f.Iq();
                StringBuilder stringBuilder = new StringBuilder();
                Iterator it = Iq.jNe.iterator();
                while (it.hasNext()) {
                    ana com_tencent_mm_protocal_c_ana = (ana) it.next();
                    stringBuilder.append(String.format("%s | %.2f | %s", new Object[]{n.eK(com_tencent_mm_protocal_c_ana.tgG), Double.valueOf(com_tencent_mm_protocal_c_ana.tRF), o.Z("yyyy-MM-dd HH:mm", com_tencent_mm_protocal_c_ana.tRG / 1000)}));
                    stringBuilder.append("\n");
                }
                x(context, stringBuilder.toString());
                break;
            case 1:
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_FTS_MASTER_DB_READY_INT_SYNC, Integer.valueOf(0));
                ap.yY();
                file = new File(c.xu(), "FTS5IndexMicroMsg.db");
                if (file.exists()) {
                    file.delete();
                }
                Process.killProcess(Process.myPid());
                break;
            case 2:
                ap.yY();
                file = new File(c.xu(), "FTS5IndexMicroMsg.db");
                File file2 = new File("/sdcard/IndexMicroMsg.db");
                if (file2.exists()) {
                    file2.delete();
                }
                FileOp.p(file.getAbsolutePath(), file2.getAbsolutePath());
                break;
            case 3:
                fVar = new f();
                fVar.lZZ = 65522;
                ((l) h.j(l.class)).search(10000, fVar);
                break;
            case 4:
                com.tencent.mm.storage.w.a[] aVarArr = new com.tencent.mm.storage.w.a[]{com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_ZH_CN_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_ZH_TW_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_ZH_HK_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_EN_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_AR_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_DE_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_DE_DE_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_ES_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_FR_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_HE_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_HI_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_ID_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_IN_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_IT_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_IW_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_JA_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_KO_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_LO_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_MS_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_MY_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_PL_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_PT_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_RU_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_TH_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_TR_STRING, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_VI_STRING};
                for (int i = 0; i < 26; i++) {
                    com.tencent.mm.storage.w.a aVar = aVarArr[i];
                    ap.yY();
                    c.vr().a(aVar, (Object) "");
                }
                break;
            case 5:
                file = new File(com.tencent.mm.loader.stub.a.hgu, "FTS5IndexMicroMsgInfo.txt");
                if (file.exists()) {
                    try {
                        x(context, FileOp.aT(file.getAbsolutePath()));
                        break;
                    } catch (IOException e) {
                        break;
                    }
                }
                break;
            case 6:
                fVar = new f();
                fVar.lZZ = 65521;
                fVar.mad = 100;
                if (strArr.length > 2) {
                    try {
                        fVar.mad = Integer.valueOf(strArr[2]).intValue();
                    } catch (Exception e2) {
                    }
                }
                ((l) h.j(l.class)).search(10000, fVar);
                break;
        }
        return true;
    }

    private static void x(Context context, String str) {
        View textView = new TextView(context);
        textView.setText(str);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16711936);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.aXt);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        g.a(context, null, textView, null);
    }
}
