package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class QQMailHistoryExporter {
    private static final char[] jnN = new char[]{'<', '>', '\"', '\'', '&', '\n'};
    private static final String[] jnO = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />"};
    private static final String vOc = ("<img id=\"%d:%d\" src=\"%s\" height=\"100\" onclick=\"" + s.er("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>");
    private Context context;
    private x fOK = null;
    private float hbf = 1.0f;
    private List<au> vBg;
    private String vOa = null;

    public static class ImageSpanData implements Parcelable {
        public static final Creator<ImageSpanData> CREATOR = new Creator<ImageSpanData>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                ImageSpanData imageSpanData = new ImageSpanData();
                imageSpanData.hrt = parcel.readInt();
                imageSpanData.endPos = parcel.readInt();
                imageSpanData.path = parcel.readString();
                imageSpanData.thumbnail = parcel.readInt();
                return imageSpanData;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ImageSpanData[i];
            }
        };
        int endPos;
        int hrt;
        String path;
        public int thumbnail = 0;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.hrt);
            parcel.writeInt(this.endPos);
            parcel.writeString(this.path);
            parcel.writeInt(this.thumbnail);
        }
    }

    private static String PW(String str) {
        if (str == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            Object obj = 1;
            for (int length2 = jnN.length - 1; length2 >= 0; length2--) {
                if (jnN[length2] == charAt) {
                    stringBuffer.append(jnO[length2]);
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public QQMailHistoryExporter(Context context, List<au> list, x xVar) {
        this.context = context;
        this.vBg = list;
        this.fOK = xVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String bWp() {
        /*
        r15 = this;
        r14 = 4;
        r13 = 3;
        r12 = 2;
        r4 = 0;
        r3 = 1;
        r0 = "MicroMsg.QQMailHistoryExporter";
        r1 = "selectItems.size = %d";
        r2 = new java.lang.Object[r3];
        r5 = r15.vBg;
        r5 = r5.size();
        r5 = java.lang.Integer.valueOf(r5);
        r2[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = r15.context;
        r0 = com.tencent.mm.bg.a.dM(r0);
        if (r0 == 0) goto L_0x002c;
    L_0x0024:
        r0 = r15.context;
        r0 = com.tencent.mm.bg.a.dI(r0);
        r15.hbf = r0;
    L_0x002c:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = "<div id=\"history\">\n";
        r5.append(r0);
        r0 = "<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>";
        r1 = new java.lang.Object[r13];
        r2 = r15.hbf;
        r2 = java.lang.Float.valueOf(r2);
        r1[r4] = r2;
        r2 = r15.hbf;
        r2 = java.lang.Float.valueOf(r2);
        r1[r3] = r2;
        r2 = r15.bWq();
        r1[r12] = r2;
        r0 = java.lang.String.format(r0, r1);
        r5.append(r0);
        r0 = r15.vBg;
        r6 = r0.iterator();
    L_0x005f:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0507;
    L_0x0065:
        r0 = r6.next();
        r0 = (com.tencent.mm.storage.au) r0;
        r1 = r15.vOa;
        if (r1 != 0) goto L_0x00cb;
    L_0x006f:
        r8 = r0.field_createTime;
        r1 = eN(r8);
        r15.vOa = r1;
        r1 = "<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n";
        r2 = new java.lang.Object[r12];
        r7 = r15.hbf;
        r7 = java.lang.Float.valueOf(r7);
        r2[r4] = r7;
        r7 = r15.vOa;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        r5.append(r1);
    L_0x008f:
        r1 = r0.bMk();
        if (r1 == 0) goto L_0x016e;
    L_0x0095:
        r1 = r0.bMk();
        if (r1 == 0) goto L_0x016b;
    L_0x009b:
        r1 = 0;
        r2 = r0.field_isSend;
        if (r2 != r3) goto L_0x00fa;
    L_0x00a0:
        r1 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r2 = new java.lang.Object[r14];
        r7 = r15.hbf;
        r7 = java.lang.Float.valueOf(r7);
        r2[r4] = r7;
        r7 = r15.aL(r0);
        r2[r3] = r7;
        r7 = r15.hbf;
        r7 = java.lang.Float.valueOf(r7);
        r2[r12] = r7;
        r0 = r0.field_content;
        r0 = PW(r0);
        r2[r13] = r0;
        r0 = java.lang.String.format(r1, r2);
    L_0x00c7:
        r5.append(r0);
        goto L_0x005f;
    L_0x00cb:
        r8 = r0.field_createTime;
        r1 = eN(r8);
        r2 = r15.vOa;
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x008f;
    L_0x00d9:
        r15.vOa = r1;
        r1 = "<br>";
        r5.append(r1);
        r1 = "<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n";
        r2 = new java.lang.Object[r12];
        r7 = r15.hbf;
        r7 = java.lang.Float.valueOf(r7);
        r2[r4] = r7;
        r7 = r15.vOa;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        r5.append(r1);
        goto L_0x008f;
    L_0x00fa:
        r2 = r15.fOK;
        r2 = r2.field_username;
        r7 = "@chatroom";
        r2 = r2.endsWith(r7);
        if (r2 != 0) goto L_0x012f;
    L_0x0107:
        r1 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r2 = new java.lang.Object[r14];
        r7 = r15.hbf;
        r7 = java.lang.Float.valueOf(r7);
        r2[r4] = r7;
        r7 = r15.aL(r0);
        r2[r3] = r7;
        r7 = r15.hbf;
        r7 = java.lang.Float.valueOf(r7);
        r2[r12] = r7;
        r0 = r0.field_content;
        r0 = PW(r0);
        r2[r13] = r0;
        r0 = java.lang.String.format(r1, r2);
        goto L_0x00c7;
    L_0x012f:
        r2 = r0.field_content;
        r2 = com.tencent.mm.u.ay.gh(r2);
        r7 = -1;
        if (r2 == r7) goto L_0x0515;
    L_0x0138:
        r1 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r7 = new java.lang.Object[r14];
        r8 = r15.hbf;
        r8 = java.lang.Float.valueOf(r8);
        r7[r4] = r8;
        r8 = r15.aL(r0);
        r7[r3] = r8;
        r8 = r15.hbf;
        r8 = java.lang.Float.valueOf(r8);
        r7[r12] = r8;
        r0 = r0.field_content;
        r2 = r2 + 1;
        r0 = r0.substring(r2);
        r0 = r0.trim();
        r0 = PW(r0);
        r7[r13] = r0;
        r0 = java.lang.String.format(r1, r7);
        goto L_0x00c7;
    L_0x016b:
        r0 = 0;
        goto L_0x00c7;
    L_0x016e:
        r1 = r0.bMh();
        if (r1 == 0) goto L_0x01f3;
    L_0x0174:
        r1 = r0.bMh();
        if (r1 == 0) goto L_0x01f1;
    L_0x017a:
        r8 = r0.field_msgId;
        r10 = r0.field_msgSvrId;
        r1 = com.tencent.mm.ui.chatting.dr.eL(r8);
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r2 == 0) goto L_0x018c;
    L_0x0188:
        r1 = com.tencent.mm.ui.chatting.dr.eM(r10);
    L_0x018c:
        r2 = "MicroMsg.QQMailHistoryExporter";
        r7 = "hdPath[%s]";
        r8 = new java.lang.Object[r3];
        r8[r4] = r1;
        com.tencent.mm.sdk.platformtools.w.d(r2, r7, r8);
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r2 != 0) goto L_0x01f1;
    L_0x019f:
        r2 = new java.lang.StringBuilder;
        r7 = "file://";
        r2.<init>(r7);
        r2 = r2.append(r1);
        r2 = r2.toString();
        r7 = vOc;
        r8 = new java.lang.Object[r14];
        r10 = r0.field_msgId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r4] = r9;
        r10 = r0.field_msgSvrId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r3] = r9;
        r8[r12] = r2;
        r8[r13] = r1;
        r1 = java.lang.String.format(r7, r8);
        r2 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r7 = new java.lang.Object[r14];
        r8 = r15.hbf;
        r8 = java.lang.Float.valueOf(r8);
        r7[r4] = r8;
        r0 = r15.aL(r0);
        r7[r3] = r0;
        r0 = r15.hbf;
        r0 = java.lang.Float.valueOf(r0);
        r7[r12] = r0;
        r7[r13] = r1;
        r0 = java.lang.String.format(r2, r7);
    L_0x01ec:
        r5.append(r0);
        goto L_0x005f;
    L_0x01f1:
        r0 = 0;
        goto L_0x01ec;
    L_0x01f3:
        r1 = 0;
        r2 = r0.bLZ();
        if (r2 == 0) goto L_0x0240;
    L_0x01fa:
        r1 = "[%s]";
        r2 = new java.lang.Object[r3];
        r7 = r15.context;
        r8 = com.tencent.mm.R.l.ecg;
        r7 = r7.getString(r8);
        r2[r4] = r7;
        r1 = java.lang.String.format(r1, r2);
    L_0x020d:
        r2 = "MicroMsg.QQMailHistoryExporter";
        r7 = "formatOtherMsg, msgStr = %s";
        r8 = new java.lang.Object[r3];
        r8[r4] = r1;
        com.tencent.mm.sdk.platformtools.w.d(r2, r7, r8);
        r2 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r7 = new java.lang.Object[r14];
        r8 = r15.hbf;
        r8 = java.lang.Float.valueOf(r8);
        r7[r4] = r8;
        r0 = r15.aL(r0);
        r7[r3] = r0;
        r0 = r15.hbf;
        r0 = java.lang.Float.valueOf(r0);
        r7[r12] = r0;
        r7[r13] = r1;
        r0 = java.lang.String.format(r2, r7);
        r5.append(r0);
        goto L_0x005f;
    L_0x0240:
        r2 = r0.bMd();
        if (r2 == 0) goto L_0x025c;
    L_0x0246:
        r1 = r0.field_isSend;
        if (r1 != r3) goto L_0x0253;
    L_0x024a:
        r1 = r15.context;
        r2 = com.tencent.mm.R.l.ece;
        r1 = r1.getString(r2);
        goto L_0x020d;
    L_0x0253:
        r1 = r15.context;
        r2 = com.tencent.mm.R.l.ecd;
        r1 = r1.getString(r2);
        goto L_0x020d;
    L_0x025c:
        r2 = r0.bMj();
        if (r2 == 0) goto L_0x0284;
    L_0x0262:
        r1 = new com.tencent.mm.e.a.ik;
        r1.<init>();
        r2 = r1.fOe;
        r2.fNZ = r3;
        r2 = r1.fOe;
        r2.fCZ = r0;
        r2 = com.tencent.mm.sdk.b.a.urY;
        r2.m(r1);
        r1 = r1.fOf;
        r1 = r1.fOh;
        r2 = "[%s]";
        r7 = new java.lang.Object[r3];
        r7[r4] = r1;
        r1 = java.lang.String.format(r2, r7);
        goto L_0x020d;
    L_0x0284:
        r2 = r0.axO();
        if (r2 == 0) goto L_0x0481;
    L_0x028a:
        r2 = "";
        r1 = r0.field_content;
        r7 = r15.fOK;
        r7 = r7.field_username;
        r8 = "@chatroom";
        r7 = r7.endsWith(r8);
        if (r7 == 0) goto L_0x02be;
    L_0x029c:
        r7 = "MicroMsg.QQMailHistoryExporter";
        r8 = "chatroom msg, parse it";
        com.tencent.mm.sdk.platformtools.w.d(r7, r8);
        r7 = r0.field_content;
        r7 = com.tencent.mm.u.ay.gh(r7);
        r8 = -1;
        if (r7 == r8) goto L_0x02be;
    L_0x02ae:
        r1 = r0.field_content;
        r7 = r7 + 1;
        r1 = r1.substring(r7);
        r1 = r1.trim();
        r1 = PW(r1);
    L_0x02be:
        r1 = com.tencent.mm.sdk.platformtools.bg.PX(r1);
        r7 = com.tencent.mm.t.f.a.ek(r1);
        if (r7 != 0) goto L_0x02e6;
    L_0x02c8:
        r1 = "MicroMsg.QQMailHistoryExporter";
        r2 = "appmsg content is null";
        com.tencent.mm.sdk.platformtools.w.w(r1, r2);
        r1 = "[%s]";
        r2 = new java.lang.Object[r3];
        r7 = r15.context;
        r8 = com.tencent.mm.R.l.ebW;
        r7 = r7.getString(r8);
        r2[r4] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x02e6:
        r1 = r7.appId;
        r8 = com.tencent.mm.pluginsdk.model.app.g.aJ(r1, r3);
        if (r8 == 0) goto L_0x02f6;
    L_0x02ee:
        r1 = r8.field_appName;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x0312;
    L_0x02f6:
        r1 = r7.appName;
    L_0x02f8:
        r9 = r15.context;
        r8 = com.tencent.mm.pluginsdk.model.app.g.a(r9, r8, r1);
        r1 = r0.field_type;
        r9 = 16777265; // 0x1000031 float:2.3510024E-38 double:8.2890703E-317;
        if (r1 != r9) goto L_0x0315;
    L_0x0305:
        r1 = r3;
    L_0x0306:
        if (r1 == 0) goto L_0x0328;
    L_0x0308:
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r8);
        if (r1 == 0) goto L_0x0317;
    L_0x030e:
        r1 = r7.title;
        goto L_0x020d;
    L_0x0312:
        r1 = r8.field_appName;
        goto L_0x02f8;
    L_0x0315:
        r1 = r4;
        goto L_0x0306;
    L_0x0317:
        r1 = "[%s: %s]";
        r2 = new java.lang.Object[r12];
        r2[r4] = r8;
        r7 = r7.title;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x0328:
        r1 = r0.bMp();
        if (r1 == 0) goto L_0x0366;
    L_0x032e:
        r1 = com.tencent.mm.ui.chatting.dr.a(r0, r7);
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r7 != 0) goto L_0x0512;
    L_0x0338:
        r2 = new java.lang.StringBuilder;
        r7 = "file://";
        r2.<init>(r7);
        r2 = r2.append(r1);
        r2 = r2.toString();
        r7 = vOc;
        r8 = new java.lang.Object[r14];
        r10 = r0.field_msgId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r4] = r9;
        r10 = r0.field_msgSvrId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r3] = r9;
        r8[r12] = r2;
        r8[r13] = r1;
        r1 = java.lang.String.format(r7, r8);
        goto L_0x020d;
    L_0x0366:
        r1 = r7.type;
        switch(r1) {
            case 1: goto L_0x0453;
            case 2: goto L_0x041b;
            case 3: goto L_0x0380;
            case 4: goto L_0x046e;
            case 5: goto L_0x046e;
            case 6: goto L_0x03d3;
            case 7: goto L_0x036b;
            case 8: goto L_0x03be;
            default: goto L_0x036b;
        };
    L_0x036b:
        r1 = "[%s]";
        r2 = new java.lang.Object[r3];
        r7 = r15.context;
        r8 = com.tencent.mm.R.l.ebW;
        r7 = r7.getString(r8);
        r2[r4] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x0380:
        r1 = r7.description;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x03a1;
    L_0x0388:
        r1 = "[%s: %s]";
        r2 = new java.lang.Object[r12];
        r8 = r15.context;
        r9 = com.tencent.mm.R.l.ecc;
        r8 = r8.getString(r9);
        r2[r4] = r8;
        r7 = r7.title;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x03a1:
        r1 = "[%s: %s-%s]";
        r2 = new java.lang.Object[r13];
        r8 = r15.context;
        r9 = com.tencent.mm.R.l.ecc;
        r8 = r8.getString(r9);
        r2[r4] = r8;
        r8 = r7.title;
        r2[r3] = r8;
        r7 = r7.description;
        r2[r12] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x03be:
        r1 = "[%s]";
        r2 = new java.lang.Object[r3];
        r7 = r15.context;
        r8 = com.tencent.mm.R.l.ebZ;
        r7 = r7.getString(r8);
        r2[r4] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x03d3:
        r1 = r7.description;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x03f4;
    L_0x03db:
        r1 = "[%s: %s]";
        r2 = new java.lang.Object[r12];
        r8 = r15.context;
        r9 = com.tencent.mm.R.l.eca;
        r8 = r8.getString(r9);
        r2[r4] = r8;
        r7 = r7.title;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x03f4:
        r1 = "[%s: %s-%s(%s)]";
        r2 = new java.lang.Object[r14];
        r8 = r15.context;
        r9 = com.tencent.mm.R.l.eca;
        r8 = r8.getString(r9);
        r2[r4] = r8;
        r8 = r7.title;
        r2[r3] = r8;
        r7 = r7.description;
        r2[r12] = r7;
        r7 = r15.context;
        r8 = com.tencent.mm.R.l.ebX;
        r7 = r7.getString(r8);
        r2[r13] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x041b:
        r1 = com.tencent.mm.ui.chatting.dr.a(r0, r7);
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r7 != 0) goto L_0x0512;
    L_0x0425:
        r2 = new java.lang.StringBuilder;
        r7 = "file://";
        r2.<init>(r7);
        r2 = r2.append(r1);
        r2 = r2.toString();
        r7 = vOc;
        r8 = new java.lang.Object[r14];
        r10 = r0.field_msgId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r4] = r9;
        r10 = r0.field_msgSvrId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r3] = r9;
        r8[r12] = r2;
        r8[r13] = r1;
        r1 = java.lang.String.format(r7, r8);
        goto L_0x020d;
    L_0x0453:
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r8);
        if (r1 == 0) goto L_0x045d;
    L_0x0459:
        r1 = r7.title;
        goto L_0x020d;
    L_0x045d:
        r1 = "[%s: %s]";
        r2 = new java.lang.Object[r12];
        r2[r4] = r8;
        r7 = r7.title;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x046e:
        r1 = "[%s: %s]";
        r2 = new java.lang.Object[r12];
        r8 = r7.title;
        r2[r4] = r8;
        r7 = r7.url;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x0481:
        r2 = r0.bMi();
        if (r2 == 0) goto L_0x04ad;
    L_0x0487:
        com.tencent.mm.u.ap.yY();
        r1 = com.tencent.mm.u.c.wT();
        r2 = r0.field_content;
        r1 = r1.Av(r2);
        r1 = r1.fFa;
        r2 = "[%s: %s]";
        r7 = new java.lang.Object[r12];
        r8 = r15.context;
        r9 = com.tencent.mm.R.l.ebY;
        r8 = r8.getString(r9);
        r7[r4] = r8;
        r7[r3] = r1;
        r1 = java.lang.String.format(r2, r7);
        goto L_0x020d;
    L_0x04ad:
        r2 = r0.bMl();
        if (r2 == 0) goto L_0x04e6;
    L_0x04b3:
        r1 = "[%s: %s(%s)]";
        r2 = new java.lang.Object[r13];
        r7 = r15.context;
        r8 = com.tencent.mm.R.l.ecf;
        r7 = r7.getString(r8);
        r2[r4] = r7;
        r7 = new java.io.File;
        com.tencent.mm.modelvideo.o.KV();
        r8 = r0.field_imgPath;
        r8 = com.tencent.mm.modelvideo.s.lv(r8);
        r7.<init>(r8);
        r7 = r7.getName();
        r2[r3] = r7;
        r7 = r15.context;
        r8 = com.tencent.mm.R.l.ebX;
        r7 = r7.getString(r8);
        r2[r12] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x04e6:
        r2 = r0.bMn();
        if (r2 != 0) goto L_0x04f2;
    L_0x04ec:
        r2 = r0.bMo();
        if (r2 == 0) goto L_0x020d;
    L_0x04f2:
        r1 = "[%s]";
        r2 = new java.lang.Object[r3];
        r7 = r15.context;
        r8 = com.tencent.mm.R.l.ebZ;
        r7 = r7.getString(r8);
        r2[r4] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x0507:
        r0 = "\n</div>\n";
        r5.append(r0);
        r0 = r5.toString();
        return r0;
    L_0x0512:
        r1 = r2;
        goto L_0x020d;
    L_0x0515:
        r0 = r1;
        goto L_0x00c7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.QQMailHistoryExporter.bWp():java.lang.String");
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
            w.i("MicroMsg.QQMailHistoryExporter", "isSend");
            str2 = m.xN();
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(auVar.field_createTime));
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private static String eN(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
    }
}
