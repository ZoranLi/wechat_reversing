package com.tencent.mm.plugin.emoji;

import android.content.Context;
import com.tencent.mm.bi.f;
import com.tencent.mm.bi.g;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.emoji.b.b;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.s;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PluginEmoji extends d implements c {
    private com.tencent.mm.pluginsdk.c.d kHq;
    private b kHr;

    public String name() {
        return "plugin-emoji";
    }

    public void installed() {
        alias(c.class);
    }

    public void dependency() {
        dependsOn(a.class);
    }

    public void configure(e eVar) {
        com.tencent.mm.pluginsdk.ui.d.d.a.a(g.bKH());
    }

    public void execute(e eVar) {
        if (eVar.ej("")) {
            pin(d.akT());
            if (eVar.ej("")) {
                h.a(com.tencent.mm.plugin.emoji.b.a.class, new com.tencent.mm.kernel.c.c(new a()));
            }
        }
        com.tencent.mm.ui.f.b.a.a(new com.tencent.mm.ui.f.b.c(this) {
            final /* synthetic */ PluginEmoji kHs;

            {
                this.kHs = r1;
            }

            public final com.tencent.mm.ui.f.b.b bK(String str, String str2) {
                try {
                    return com.tencent.mm.plugin.gif.b.aCV().cr(str, str2);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.PluginEmoji", e, "", new Object[0]);
                    return null;
                }
            }
        });
        com.tencent.mm.ui.f.c.b.a(new com.tencent.mm.ui.f.c.a(this) {
            final /* synthetic */ PluginEmoji kHs;

            {
                this.kHs = r1;
            }

            public final CharSequence a(Context context, CharSequence charSequence, int i) {
                return g.bKH().b(context, charSequence, i);
            }

            public final CharSequence a(Context context, CharSequence charSequence, float f) {
                return g.bKH().d(context, charSequence, f);
            }

            public final int aG(String str, int i) {
                g.bKH();
                f bKE = f.bKE();
                if (bg.mA(str)) {
                    return i;
                }
                int length = str.length();
                if (i == 0 || i == length) {
                    return i;
                }
                int i2;
                if (f.uyL == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    int length2 = bKE.uyB.length;
                    for (i2 = 0; i2 < length2; i2++) {
                        stringBuilder.append(Pattern.quote(bKE.uyB[i2]));
                        if (i2 != length2 - 1) {
                            stringBuilder.append('|');
                        }
                    }
                    length2 = bKE.uyC.length;
                    for (i2 = 0; i2 < length2; i2++) {
                        stringBuilder.append(Pattern.quote(bKE.uyC[i2]));
                        if (i2 != length2 - 1) {
                            stringBuilder.append('|');
                        }
                    }
                    length2 = bKE.uyD.length;
                    for (i2 = 0; i2 < length2; i2++) {
                        stringBuilder.append(Pattern.quote(bKE.uyD[i2]));
                        if (i2 != length2 - 1) {
                            stringBuilder.append('|');
                        }
                    }
                    length2 = bKE.uyE.length;
                    for (i2 = 0; i2 < length2; i2++) {
                        stringBuilder.append(Pattern.quote(bKE.uyE[i2]));
                        if (i2 != length2 - 1) {
                            stringBuilder.append('|');
                        }
                    }
                    length2 = bKE.uyF.length;
                    for (i2 = 0; i2 < length2; i2++) {
                        stringBuilder.append(Pattern.quote(bKE.uyF[i2]));
                        if (i2 != length2 - 1) {
                            stringBuilder.append('|');
                        }
                    }
                    length2 = bKE.uyG.length;
                    for (i2 = 0; i2 < length2; i2++) {
                        stringBuilder.append(Pattern.quote(bKE.uyG[i2]));
                        if (i2 != length2 - 1) {
                            stringBuilder.append('|');
                        }
                    }
                    if (!(bKE.uyH == null || bKE.uyH.isEmpty())) {
                        Iterator it = bKE.uyH.iterator();
                        while (it.hasNext()) {
                            s sVar = (s) it.next();
                            stringBuilder.append(Pattern.quote(sVar.field_key)).append("|");
                            if (!bg.mA(sVar.field_cnValue)) {
                                stringBuilder.append(Pattern.quote(sVar.field_cnValue)).append("|");
                            }
                            if (!bg.mA(sVar.field_enValue)) {
                                stringBuilder.append(Pattern.quote(sVar.field_enValue)).append("|");
                            }
                            if (!bg.mA(sVar.field_qqValue)) {
                                stringBuilder.append(Pattern.quote(sVar.field_qqValue)).append("|");
                            }
                            if (!bg.mA(sVar.field_twValue)) {
                                stringBuilder.append(Pattern.quote(sVar.field_twValue)).append("|");
                            }
                            if (!bg.mA(sVar.field_thValue)) {
                                stringBuilder.append(Pattern.quote(sVar.field_thValue)).append("|");
                            }
                        }
                    }
                    f.uyL = Pattern.compile(stringBuilder.toString());
                }
                Matcher matcher = f.uyL.matcher(str.substring(i < 6 ? 0 : i - 6, i + 6 >= length ? length - 1 : i + 6));
                while (matcher.find()) {
                    if (6 > matcher.start() && 6 < matcher.end()) {
                        i2 = matcher.start();
                        break;
                    }
                }
                i2 = 6;
                return i + (i2 + -6 > 0 ? i2 - 6 : 0);
            }
        });
    }

    public void setEmojiMgr() {
        if (this.kHq == null) {
            this.kHq = this.kHr.alt();
        }
    }

    public void removeEmojiMgr() {
        this.kHq = null;
    }

    public com.tencent.mm.pluginsdk.c.d getEmojiMgr() {
        if (this.kHq == null) {
            this.kHq = this.kHr.alt();
        }
        return this.kHq;
    }

    public void setEmojiMgrProvider(b bVar) {
        this.kHr = bVar;
    }
}
