package com.tencent.mm.ui.chatting.d.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static volatile a vUK = null;
    private static final af vUL = new af();

    private static class b implements Runnable {
        private au fCZ;
        private int scene;
        private CharSequence text;

        private static class a {

            private static class a implements b {
                public final c a(Object obj, Spannable spannable) {
                    String ap;
                    String substring = spannable.toString().substring(spannable.getSpanStart(obj), spannable.getSpanEnd(obj));
                    try {
                        ap = bg.ap(new JSONObject(obj.toString()).optString(Columns.TYPE), obj.getClass().getName());
                    } catch (JSONException e) {
                        ap = obj.getClass().getName();
                    }
                    return new c(substring, ap);
                }
            }
        }

        private interface b {
            c a(Object obj, Spannable spannable);
        }

        private static class c {
            String extInfo;
            String text;

            c(String str, String str2) {
                this.text = str;
                this.extInfo = str2;
            }
        }

        b(CharSequence charSequence, au auVar, int i) {
            this.text = charSequence;
            this.fCZ = auVar;
            this.scene = i;
        }

        public final void run() {
            if (this.text instanceof Spannable) {
                try {
                    Spannable spannable = (Spannable) this.text;
                    System.nanoTime();
                    Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
                    ArrayList arrayList = new ArrayList(1);
                    if (spans == null || spans.length == 0) {
                        arrayList = null;
                    } else {
                        for (Object obj : spans) {
                            if (d.nZC.a(obj, l.class)) {
                                arrayList.add(new a().a(obj, spannable));
                            }
                        }
                    }
                    if (arrayList != null && arrayList.size() != 0) {
                        this.fCZ = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cA(this.fCZ.field_msgId);
                        if (!(this.fCZ == null || bg.mA(this.fCZ.field_talker))) {
                            this.fCZ.dF(this.fCZ.field_flag | 16);
                            ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().a(this.fCZ.field_msgId, this.fCZ);
                        }
                        ap.yY().xA().Aq();
                        ap.yY().xA().b(com.tencent.mm.u.b.b.b.Chatting);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str = ((c) it.next()).extInfo;
                            g.oUh.i(14237, "msg", Long.valueOf(this.fCZ.field_msgId), Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, VERSION.INCREMENTAL, Build.DISPLAY, Integer.valueOf(this.scene), str);
                            g.oUh.a(587, 0, 1, false);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    private enum a implements com.tencent.mm.ui.widget.MMTextView.a {
        ;

        private a(String str) {
        }

        public final void a(CharSequence charSequence, long j) {
            ce cA = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cA(j);
            if (bg.mA(cA.field_talker)) {
                w.w("MicroMsg.AAChattingHelper", "hy: not retrieving correct msg from db. try use old one. msg id: %d", Long.valueOf(j));
            } else if ((cA.field_flag & 16) == 0) {
                a.a(charSequence, cA, 0);
            } else {
                w.v("MicroMsg.AAChattingHelper", "hy: show already checked. msg id is: %d", Long.valueOf(j));
            }
        }
    }

    private a() {
    }

    public static a bXE() {
        if (vUK != null) {
            return vUK;
        }
        a aVar;
        synchronized (a.class) {
            if (vUK == null) {
                vUK = new a();
            }
            aVar = vUK;
        }
        return aVar;
    }

    public static com.tencent.mm.ui.widget.MMTextView.a bXF() {
        return a.vUM;
    }

    public static void a(CharSequence charSequence, au auVar, int i) {
        if (charSequence instanceof Spannable) {
            vUL.D(new b(charSequence, auVar, i));
        }
    }

    public static void a(CharSequence charSequence, au auVar) {
        a(charSequence, auVar, 1);
    }
}
