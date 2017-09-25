package com.tencent.mm.plugin.location.model;

import com.tencent.mm.modelgeo.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import java.util.Set;

public final class a {

    public static class a {
        Set<Long> naU;
        private com.tencent.mm.modelgeo.b.a naV = new com.tencent.mm.modelgeo.b.a(this) {
            final /* synthetic */ a naW;

            {
                this.naW = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void b(com.tencent.mm.modelgeo.Addr r11) {
                /*
                r10 = this;
                r1 = 0;
                r7 = -1;
                r3 = r10.naW;
                r0 = r11.tag;
                if (r0 == 0) goto L_0x0198;
            L_0x0008:
                r0 = r11.tag;
                r0 = r0 instanceof java.lang.Long;
                if (r0 == 0) goto L_0x0198;
            L_0x000e:
                r0 = r11.tag;
                r0 = (java.lang.Long) r0;
                r4 = r0.longValue();
                com.tencent.mm.u.ap.yY();
                r0 = com.tencent.mm.u.c.wT();
                r4 = r0.cA(r4);
                r0 = r11.hCE;
                r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
                if (r0 != 0) goto L_0x0198;
            L_0x0029:
                r2 = r4.field_content;
                r0 = r4.field_isSend;
                if (r0 != 0) goto L_0x0199;
            L_0x002f:
                r0 = 1;
            L_0x0030:
                r5 = r4.field_talker;
                r5 = com.tencent.mm.u.o.dH(r5);
                if (r5 == 0) goto L_0x004a;
            L_0x0038:
                if (r0 == 0) goto L_0x004a;
            L_0x003a:
                r6 = com.tencent.mm.u.ay.gh(r2);
                if (r6 == r7) goto L_0x004a;
            L_0x0040:
                r6 = r6 + 1;
                r2 = r2.substring(r6);
                r2 = r2.trim();
            L_0x004a:
                r6 = com.tencent.mm.storage.au.b.RG(r2);
                r2 = r11.Gh();
                r6.label = r2;
                r2 = "";
                if (r5 == 0) goto L_0x019e;
            L_0x0059:
                if (r0 == 0) goto L_0x019e;
            L_0x005b:
                r0 = r4.field_content;
                r0 = com.tencent.mm.u.ay.gh(r0);
                if (r0 == r7) goto L_0x019e;
            L_0x0063:
                r7 = r4.field_content;
                r0 = r7.substring(r1, r0);
                r0 = r0.trim();
                r1 = r0.length();
                if (r1 <= 0) goto L_0x019e;
            L_0x0073:
                r1 = r6.uKf;
                if (r1 == 0) goto L_0x0082;
            L_0x0077:
                r1 = r6.uKf;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x0087;
            L_0x0082:
                r1 = "";
                r6.uKf = r1;
            L_0x0087:
                r1 = r6.uKe;
                if (r1 == 0) goto L_0x0096;
            L_0x008b:
                r1 = r6.uKe;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x009b;
            L_0x0096:
                r1 = "";
                r6.uKf = r1;
            L_0x009b:
                r1 = r6.uKd;
                if (r1 == 0) goto L_0x00aa;
            L_0x009f:
                r1 = r6.uKd;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x00af;
            L_0x00aa:
                r1 = "";
                r6.uKd = r1;
            L_0x00af:
                r1 = r6.rUK;
                if (r1 == 0) goto L_0x00be;
            L_0x00b3:
                r1 = r6.rUK;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x00c3;
            L_0x00be:
                r1 = "";
                r6.rUK = r1;
            L_0x00c3:
                r1 = r6.label;
                if (r1 == 0) goto L_0x00d2;
            L_0x00c7:
                r1 = r6.label;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x00d7;
            L_0x00d2:
                r1 = "";
                r6.label = r1;
            L_0x00d7:
                r1 = r6.uKc;
                if (r1 == 0) goto L_0x00e6;
            L_0x00db:
                r1 = r6.uKc;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x00eb;
            L_0x00e6:
                r1 = "";
                r6.uKc = r1;
            L_0x00eb:
                r1 = new java.lang.StringBuilder;
                r2 = "<msg><location x=\"";
                r1.<init>(r2);
                r8 = r6.naO;
                r1 = r1.append(r8);
                r2 = "\" y=\"";
                r1 = r1.append(r2);
                r8 = r6.naP;
                r1 = r1.append(r8);
                r2 = "\" scale=\"";
                r1 = r1.append(r2);
                r2 = r6.fOd;
                r1 = r1.append(r2);
                r2 = "\" label=\"";
                r1 = r1.append(r2);
                r2 = r6.label;
                r1 = r1.append(r2);
                r2 = "\" maptype=\"";
                r1 = r1.append(r2);
                r2 = r6.uKc;
                r1 = r1.append(r2);
                r2 = "\"  fromusername=\"";
                r1 = r1.append(r2);
                r2 = r6.rUK;
                r1 = r1.append(r2);
                r2 = "\" /></msg>";
                r1 = r1.append(r2);
                r1 = r1.toString();
                if (r5 == 0) goto L_0x019c;
            L_0x0147:
                r2 = "";
                r2 = r0.equals(r2);
                if (r2 != 0) goto L_0x019c;
            L_0x0150:
                r2 = new java.lang.StringBuilder;
                r2.<init>();
                r0 = r2.append(r0);
                r2 = ":\n";
                r0 = r0.append(r2);
                r0 = r0.append(r1);
                r0 = r0.toString();
            L_0x0168:
                r1 = "MicroMsg.LocationServer";
                r2 = new java.lang.StringBuilder;
                r5 = "xml: ";
                r2.<init>(r5);
                r2 = r2.append(r0);
                r2 = r2.toString();
                com.tencent.mm.sdk.platformtools.w.d(r1, r2);
                r4.setContent(r0);
                com.tencent.mm.u.ap.yY();
                r0 = com.tencent.mm.u.c.wT();
                r6 = r4.field_msgId;
                r0.a(r6, r4);
                r0 = r3.naU;
                r2 = r4.field_msgId;
                r1 = java.lang.Long.valueOf(r2);
                r0.remove(r1);
            L_0x0198:
                return;
            L_0x0199:
                r0 = r1;
                goto L_0x0030;
            L_0x019c:
                r0 = r1;
                goto L_0x0168;
            L_0x019e:
                r0 = r2;
                goto L_0x0073;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.location.model.a.a.1.b(com.tencent.mm.modelgeo.Addr):void");
            }
        };

        public final void aFW() {
            if (this.naU != null) {
                this.naU.clear();
            }
            b.Gi().a(this.naV);
        }

        public final String[] I(au auVar) {
            int i = 1;
            String[] strArr = new String[2];
            String str = auVar.field_content;
            if (bg.mA(str)) {
                strArr[0] = "";
                strArr[1] = "";
                return strArr;
            }
            String trim;
            au.b Aw;
            long j;
            au.b RG;
            int i2 = auVar.field_isSend == 0 ? 1 : 0;
            if (o.dH(auVar.field_talker) && i2 != 0) {
                i2 = ay.gh(str);
                if (i2 != -1) {
                    trim = str.substring(i2 + 1).trim();
                    ap.yY();
                    Aw = c.wT().Aw(trim);
                    i2 = (Aw.ndv != null || Aw.ndv.equals("")) ? 0 : 1;
                    if (i2 == 0) {
                        trim = Aw.label;
                        str = Aw.ndv;
                        strArr[0] = trim;
                        strArr[1] = str;
                    } else {
                        strArr[0] = Aw.label;
                        strArr[1] = "";
                    }
                    if (bg.mA(strArr[0]) && bg.mA(strArr[1])) {
                        w.i("MicroMsg.LocationServer", "pull from sever");
                        j = auVar.field_msgId;
                        if (!(this.naU == null || this.naU.contains(Long.valueOf(j)))) {
                            trim = auVar.field_content;
                            if (auVar.field_isSend != 0) {
                                i = 0;
                            }
                            if (o.dH(auVar.field_talker) && r1 != 0) {
                                i = ay.gh(trim);
                                if (i != -1) {
                                    trim = trim.substring(i + 1).trim();
                                }
                            }
                            RG = au.b.RG(trim);
                            this.naU.add(Long.valueOf(j));
                            b.Gi().a(RG.naO, RG.naP, this.naV, Long.valueOf(auVar.field_msgId));
                        }
                    }
                    return strArr;
                }
            }
            trim = str;
            ap.yY();
            Aw = c.wT().Aw(trim);
            if (Aw.ndv != null) {
            }
            if (i2 == 0) {
                strArr[0] = Aw.label;
                strArr[1] = "";
            } else {
                trim = Aw.label;
                str = Aw.ndv;
                strArr[0] = trim;
                strArr[1] = str;
            }
            w.i("MicroMsg.LocationServer", "pull from sever");
            j = auVar.field_msgId;
            trim = auVar.field_content;
            if (auVar.field_isSend != 0) {
                i = 0;
            }
            i = ay.gh(trim);
            if (i != -1) {
                trim = trim.substring(i + 1).trim();
            }
            RG = au.b.RG(trim);
            this.naU.add(Long.valueOf(j));
            b.Gi().a(RG.naO, RG.naP, this.naV, Long.valueOf(auVar.field_msgId));
            return strArr;
        }
    }
}
