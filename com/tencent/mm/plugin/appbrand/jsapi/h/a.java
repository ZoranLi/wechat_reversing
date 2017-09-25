package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.widget.NumberPicker;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.c;
import com.tencent.mm.plugin.appbrand.widget.picker.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

final class a extends c {
    volatile a iUa;
    volatile Long iUb = null;
    volatile Long iUc = null;
    volatile int iUd = -1;
    volatile int iUe = -1;
    volatile int iUf = -1;

    private enum a {
        YEAR(new SimpleDateFormat("yyyy", Locale.US)),
        MONTH(new SimpleDateFormat("yyyy-MM", Locale.US)),
        DAY(new SimpleDateFormat("yyyy-MM-dd", Locale.US));
        
        final DateFormat iUk;

        private a(DateFormat dateFormat) {
            this.iUk = dateFormat;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static com.tencent.mm.plugin.appbrand.jsapi.h.a.a pB(java.lang.String r4) {
            /*
            r0 = 0;
            r1 = r4.length();
            r2 = 5;
            r1 = java.lang.Math.min(r1, r2);
            r1 = java.lang.Math.max(r0, r1);
            r1 = r4.substring(r0, r1);
            r2 = r1.toLowerCase();
            r1 = -1;
            r3 = r2.hashCode();
            switch(r3) {
                case 99228: goto L_0x003a;
                case 3704893: goto L_0x0025;
                case 104080000: goto L_0x002f;
                default: goto L_0x001e;
            };
        L_0x001e:
            r0 = r1;
        L_0x001f:
            switch(r0) {
                case 0: goto L_0x0045;
                case 1: goto L_0x0048;
                case 2: goto L_0x004b;
                default: goto L_0x0022;
            };
        L_0x0022:
            r0 = MONTH;
        L_0x0024:
            return r0;
        L_0x0025:
            r3 = "year";
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x001e;
        L_0x002e:
            goto L_0x001f;
        L_0x002f:
            r0 = "month";
            r0 = r2.equals(r0);
            if (r0 == 0) goto L_0x001e;
        L_0x0038:
            r0 = 1;
            goto L_0x001f;
        L_0x003a:
            r0 = "day";
            r0 = r2.equals(r0);
            if (r0 == 0) goto L_0x001e;
        L_0x0043:
            r0 = 2;
            goto L_0x001f;
        L_0x0045:
            r0 = YEAR;
            goto L_0x0024;
        L_0x0048:
            r0 = MONTH;
            goto L_0x0024;
        L_0x004b:
            r0 = DAY;
            goto L_0x0024;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.h.a.a.pB(java.lang.String):com.tencent.mm.plugin.appbrand.jsapi.h.a$a");
        }

        final Date parse(String str) {
            try {
                return this.iUk.parse(str);
            } catch (Exception e) {
                return null;
            }
        }
    }

    a() {
    }

    final void k(JSONObject jSONObject) {
        Date parse;
        this.iUa = a.pB(jSONObject.optString("fields"));
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            Date parse2 = this.iUa.parse(optJSONObject.optString("start", ""));
            parse = this.iUa.parse(optJSONObject.optString("end", ""));
            if (parse2 != null) {
                this.iUb = Long.valueOf(parse2.getTime());
            }
            if (parse != null) {
                this.iUc = Long.valueOf(parse.getTime());
            }
        }
        parse = this.iUa.parse(jSONObject.optString("current", ""));
        if (parse == null) {
            parse = new Date(System.currentTimeMillis());
        }
        this.iUd = parse.getYear() + 1900;
        this.iUe = parse.getMonth() + 1;
        this.iUf = parse.getDate();
        d.runOnUiThread(new Runnable(this) {
            final /* synthetic */ a iUg;

            {
                this.iUg = r1;
            }

            public final void run() {
                boolean z = true;
                int i = 0;
                b bVar = this.iUg;
                c cVar = (c) bVar.q(c.class);
                if (cVar == null) {
                    bVar.e("fail cant init view", null);
                    return;
                }
                g gVar = bVar.jyg;
                gVar.jyG = new com.tencent.mm.plugin.appbrand.widget.picker.g.a<String>(bVar) {
                    final /* synthetic */ a iUg;

                    {
                        this.iUg = r1;
                    }

                    public final /* synthetic */ void c(boolean z, Object obj) {
                        String str = (String) obj;
                        b bVar = this.iUg;
                        if (bVar.jyg != null) {
                            if (!z) {
                                bVar.e("cancel", null);
                            }
                            if (bg.mA(str)) {
                                bVar.e("fail", null);
                            } else {
                                Map hashMap = new HashMap(1);
                                hashMap.put(Columns.VALUE, str);
                                bVar.e("ok", hashMap);
                            }
                            bVar.jyg.hide();
                        }
                    }
                };
                cVar.a(bVar.iUd, bVar.iUe, bVar.iUf, null);
                if (bVar.iUb != null) {
                    cVar.setMinDate(bVar.iUb.longValue());
                }
                if (bVar.iUc != null) {
                    cVar.setMaxDate(bVar.iUc.longValue());
                }
                boolean z2 = bVar.iUa.ordinal() >= a.YEAR.ordinal();
                boolean z3 = bVar.iUa.ordinal() >= a.MONTH.ordinal();
                if (bVar.iUa.ordinal() < a.DAY.ordinal()) {
                    z = false;
                }
                cVar.jyh = z2;
                cVar.jyi = z3;
                cVar.jyj = z;
                if (cVar.jyk != null) {
                    cVar.jyk.setEnabled(z2);
                    cVar.jyk.setVisibility(z2 ? 0 : 8);
                }
                if (cVar.jyl != null) {
                    cVar.jyl.setEnabled(z3);
                    cVar.jyl.setVisibility(z3 ? 0 : 8);
                }
                if (cVar.jym != null) {
                    cVar.jym.setEnabled(z);
                    NumberPicker numberPicker = cVar.jym;
                    if (!z) {
                        i = 8;
                    }
                    numberPicker.setVisibility(i);
                }
                gVar.show();
            }
        });
    }
}
