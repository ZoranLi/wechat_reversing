package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ik;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ec {
    private Context context;
    private x fOK = null;
    private SimpleDateFormat jFf = new SimpleDateFormat("yyyy-MM-dd");
    String mbU = null;
    List<au> vBg;
    private String vOa = null;
    ArrayList<Uri> vOb = new ArrayList();

    public ec(Context context, List<au> list, x xVar) {
        this.context = context;
        this.vBg = list;
        this.fOK = xVar;
    }

    public final String bWp() {
        String str = "MicroMsg.OtherMailHistoryExporter";
        String str2 = "export: history is null? %B, selectItems.size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.mbU == null);
        objArr[1] = Integer.valueOf(this.vBg.size());
        w.d(str, str2, objArr);
        if (this.mbU != null) {
            return this.mbU;
        }
        this.vOb.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bWq());
        stringBuilder.append("\n\n");
        for (au auVar : this.vBg) {
            if (this.vOa == null) {
                this.vOa = eN(auVar.field_createTime);
                stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.vOa}));
                stringBuilder.append("\n");
            } else {
                str = eN(auVar.field_createTime);
                if (!str.equals(this.vOa)) {
                    this.vOa = str;
                    stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.vOa}));
                    stringBuilder.append("\n");
                }
            }
            String str3;
            if (auVar.bMk()) {
                if (!auVar.bMk()) {
                    str3 = null;
                } else if (auVar.field_isSend == 1) {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{aL(auVar), auVar.field_content});
                } else if (this.fOK.field_username.endsWith("@chatroom")) {
                    str3 = ay.gh(auVar.field_content) != -1 ? String.format("%s\n\n%s\n\n", new Object[]{aL(auVar), auVar.field_content.substring(ay.gh(auVar.field_content) + 1).trim()}) : null;
                } else {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{aL(auVar), auVar.field_content});
                }
                stringBuilder.append(str3);
            } else if (auVar.bMh()) {
                if (auVar.bMh()) {
                    long j = auVar.field_msgId;
                    long j2 = auVar.field_msgSvrId;
                    str = dr.eL(j);
                    if (bg.mA(str)) {
                        str = dr.eM(j2);
                    }
                    w.d("MicroMsg.OtherMailHistoryExporter", "hdPath[%s]", str);
                    if (!bg.mA(str)) {
                        this.vOb.add(Uri.parse("file://" + str));
                        str = String.format("[%s: %s(%s)]", new Object[]{this.context.getString(R.l.ecb), new File(str).getName(), this.context.getString(R.l.ebX)});
                        str3 = String.format("%s\n\n%s\n\n", new Object[]{aL(auVar), str});
                        stringBuilder.append(str3);
                    }
                }
                str3 = null;
                stringBuilder.append(str3);
            } else {
                if (auVar.bLZ()) {
                    str = String.format("[%s]", new Object[]{this.context.getString(R.l.ecg)});
                } else if (auVar.bMd()) {
                    str = auVar.field_isSend == 1 ? this.context.getString(R.l.ece) : this.context.getString(R.l.ecd);
                } else if (auVar.bMj()) {
                    b ikVar = new ik();
                    ikVar.fOe.fNZ = 1;
                    ikVar.fOe.fCZ = auVar;
                    a.urY.m(ikVar);
                    str = String.format("[%s]", new Object[]{ikVar.fOf.fOh});
                } else {
                    if (auVar.axO()) {
                        f.a ek = f.a.ek(bg.PX(auVar.field_content));
                        if (ek != null) {
                            switch (ek.type) {
                                case 4:
                                case 6:
                                    com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(ek.fCW);
                                    if (LW != null) {
                                        File file = new File(LW.field_fileFullPath);
                                        if (file.exists()) {
                                            this.vOb.add(Uri.fromFile(file));
                                            break;
                                        }
                                    }
                                    break;
                            }
                            com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(ek.appId, true);
                            if (aJ == null) {
                                str = "";
                            } else {
                                String str4 = aJ.field_appName;
                                str = 6 == ek.type ? String.format("[%s: %s(%s)]", new Object[]{this.context.getString(R.l.ebW), str4, this.context.getString(R.l.ebX)}) : String.format("[%s: %s]", new Object[]{this.context.getString(R.l.ebW), str4});
                            }
                        }
                    } else if (auVar.bMi()) {
                        ap.yY();
                        str = c.wT().Av(auVar.field_content).fFa;
                        str = String.format("[%s: %s]", new Object[]{this.context.getString(R.l.ebY), str});
                    } else if (auVar.bMl()) {
                        r7 = new Object[3];
                        o.KV();
                        r7[1] = new File(s.lv(auVar.field_imgPath)).getName();
                        r7[2] = this.context.getString(R.l.ebX);
                        str = String.format("[%s: %s(%s)]", r7);
                        o.KV();
                        File file2 = new File(s.lv(auVar.field_imgPath));
                        if (file2.exists()) {
                            this.vOb.add(Uri.fromFile(file2));
                        }
                    } else if (auVar.bMn() || auVar.bMo()) {
                        str = String.format("[%s]", new Object[]{this.context.getString(R.l.ebZ)});
                    }
                    str = null;
                }
                w.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", str);
                stringBuilder.append(String.format("%s\n\n%s\n\n", new Object[]{aL(auVar), str}));
            }
        }
        stringBuilder.append("\n\n");
        this.mbU = stringBuilder.toString();
        return this.mbU;
    }

    private String bWq() {
        String substring;
        if (this.fOK.field_username.endsWith("@chatroom")) {
            if (bg.mA(this.fOK.field_nickname)) {
                String str = "";
                for (String substring2 : j.eA(this.fOK.field_username)) {
                    str = str + n.eK(substring2) + ", ";
                }
                substring2 = str.substring(0, str.length() - 2);
            } else {
                substring2 = this.fOK.tK();
            }
            return String.format(this.context.getString(R.l.eQY), new Object[]{substring2});
        }
        substring2 = this.context.getString(R.l.eQZ);
        Object[] objArr = new Object[2];
        objArr[0] = this.fOK.tK();
        ap.yY();
        objArr[1] = c.vr().get(4, null);
        return String.format(substring2, objArr);
    }

    private String aL(au auVar) {
        String str;
        String str2 = null;
        if (this.fOK.field_username.endsWith("@chatroom")) {
            str = auVar.field_content;
            int gh = ay.gh(str);
            if (gh != -1) {
                str2 = n.eK(str.substring(0, gh).trim());
            }
        } else {
            str2 = n.eK(auVar.field_talker);
        }
        if (auVar.field_isSend == 1) {
            w.i("MicroMsg.OtherMailHistoryExporter", "isSend");
            str2 = m.xN();
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(auVar.field_createTime));
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private String eN(long j) {
        return this.jFf.format(new Date(j));
    }
}
