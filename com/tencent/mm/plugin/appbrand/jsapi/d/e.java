package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.support.v4.view.z;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.g.m.c;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.plugin.appbrand.widget.input.f;
import com.tencent.mm.plugin.appbrand.widget.input.g;
import com.tencent.mm.plugin.appbrand.widget.input.h;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.plugin.appbrand.widget.input.r;
import com.tencent.mm.plugin.appbrand.widget.input.v;
import com.tencent.mm.plugin.appbrand.widget.input.y;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends a<com.tencent.mm.plugin.appbrand.widget.input.a.e> {
    static final int CTRL_INDEX = 1;
    static final String NAME = "showKeyboard";

    public static final class a extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = 207;
        public static final String NAME = "onKeyboardDropdownOperate";
    }

    public static final class b extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = 78;
        public static final String NAME = "onKeyboardValueChange";
    }

    public void a(m mVar, JSONObject jSONObject, int i) {
        final String optString = jSONObject.optString("inputId", "");
        final int optInt = jSONObject.optInt("cursor", -2);
        if (!TG() || bg.mA(optString)) {
            final com.tencent.mm.plugin.appbrand.widget.input.a.e eVar = new com.tencent.mm.plugin.appbrand.widget.input.a.e();
            if (a(eVar, jSONObject, mVar, i)) {
                final String optString2 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
                final m mVar2 = mVar;
                final int i2 = i;
                d.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ e iSD;

                    public final void run() {
                        this.iSD.a(mVar2, optInt, optString2, eVar, i2);
                    }
                });
                return;
            }
            return;
        }
        final m mVar3 = mVar;
        final int i3 = i;
        af.v(new Runnable(this) {
            final /* synthetic */ e iSD;

            public final void run() {
                if (com.tencent.mm.plugin.appbrand.widget.input.m.a(mVar3, optString, optInt)) {
                    mVar3.x(i3, this.iSD.d("ok", null));
                } else {
                    mVar3.x(i3, this.iSD.d("fail:invalid data", null));
                }
            }
        });
    }

    protected boolean TG() {
        return true;
    }

    protected boolean TH() {
        return true;
    }

    public final void a(m mVar, int i, final String str, com.tencent.mm.plugin.appbrand.widget.input.a.e eVar, final int i2) {
        String str2;
        int intValue;
        h hVar = a.jtq;
        com.tencent.mm.plugin.appbrand.widget.input.b a = a.a(eVar.jwS, mVar);
        if (a == null) {
            str2 = null;
        } else {
            boolean z;
            if (eVar.jwX != null) {
                a.rk(eVar.jwX);
            }
            a.a((com.tencent.mm.plugin.appbrand.widget.input.a.h) eVar);
            if (eVar.jwW != null) {
                com.tencent.mm.plugin.appbrand.widget.input.a.a.a aVar = eVar.jwW;
                m mVar2 = (m) a.jsp.get();
                if (!(mVar2 == null || a.Yj() == null)) {
                    com.tencent.mm.plugin.appbrand.widget.input.autofill.d.a(mVar2, a.Yj(), aVar);
                }
            }
            int intValue2 = eVar.jwY.intValue();
            int intValue3 = eVar.jwZ.intValue();
            intValue = eVar.jxb.intValue();
            int intValue4 = eVar.jxa.intValue();
            m mVar3 = (m) a.jsp.get();
            if (mVar3 == null || mVar3.jde == null) {
                z = false;
            } else {
                View Yj = a.Yj();
                if (Yj == null) {
                    z = false;
                } else {
                    com.tencent.mm.plugin.appbrand.widget.input.e eVar2 = mVar3.jdd;
                    if (eVar2 == null) {
                        z = false;
                    } else {
                        boolean a2 = eVar2.a(mVar3.jde, Yj, intValue2, intValue3, intValue, intValue4);
                        if (a2) {
                            ((y) Yj).a(a.jsq);
                            Yj.addTextChangedListener(a);
                        }
                        z = a2;
                    }
                }
            }
            if (!z) {
                str2 = null;
            } else if (a.iK(-2)) {
                WeakReference weakReference = new WeakReference(mVar);
                str2 = a.Yi();
                a.jsn = new com.tencent.mm.plugin.appbrand.widget.input.h.AnonymousClass2(hVar, weakReference, str2, str);
                if (!(mVar == null || a == null)) {
                    String Yi = a.Yi();
                    if (!bg.mA(Yi)) {
                        mVar.a(new com.tencent.mm.plugin.appbrand.widget.input.h.AnonymousClass1(hVar, Yi));
                        hVar.jtl.put(Yi, a);
                    }
                }
            } else {
                str2 = null;
            }
        }
        if (bg.mA(str2)) {
            str2 = mVar.ivH;
            final int hashCode = mVar.hashCode();
            final WeakReference weakReference2 = new WeakReference(mVar);
            eVar.jsp = weakReference2;
            final g anonymousClass3 = new g(this) {
                final /* synthetic */ e iSD;

                public final void b(String str, int i, boolean z, boolean z2) {
                    if (this.iSD.TI()) {
                        d.aO(this);
                    }
                    if (weakReference2.get() != null) {
                        try {
                            String jSONObject = new JSONObject().put(Columns.VALUE, str).put("inputId", this.jsR).put("cursor", i).toString();
                            if (z) {
                                ((m) weakReference2.get()).f("onKeyboardConfirm", jSONObject, 0);
                            }
                            if (!z2) {
                                ((m) weakReference2.get()).f("onKeyboardComplete", jSONObject, 0);
                            }
                        } catch (Throwable e) {
                            w.e("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", new Object[]{bg.g(e)});
                        }
                        if (!z2) {
                            TL();
                        }
                    }
                }

                public final void TJ() {
                    if (weakReference2.get() != null) {
                        Map hashMap = new HashMap(1);
                        hashMap.put("inputId", this.jsR);
                        ((m) weakReference2.get()).x(i2, this.iSD.d("ok", hashMap));
                        a.aW(this.jsR, str);
                        String str = this.jsR;
                        m mVar = (m) weakReference2.get();
                        if (mVar != null) {
                            q.yC().n("AppBrandJsInput@" + str, true).l("webview_reference", new WeakReference(mVar));
                        }
                    }
                }

                public final void TK() {
                    d.aO(this);
                    if (weakReference2.get() != null) {
                        ((m) weakReference2.get()).x(i2, this.iSD.d("fail", null));
                        TL();
                    }
                }

                private void TL() {
                    m mVar = (m) weakReference2.get();
                    if (mVar != null && mVar.jde != null) {
                        f.Yv().o(mVar.jde);
                    }
                }
            };
            anonymousClass3.jsJ = new com.tencent.mm.plugin.appbrand.widget.input.g.b(this) {
                final /* synthetic */ e iSD;

                public final void af(String str, int i) {
                    String str2 = anonymousClass3.jsR;
                    if (!bg.mA(str2)) {
                        b bVar = new b();
                        Map hashMap = new HashMap();
                        hashMap.put(Columns.VALUE, str);
                        hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, q.yC().n("AppBrandJsInput@" + str2, true).getString("passing_data", ""));
                        hashMap.put("cursor", Integer.valueOf(i));
                        hashMap.put("inputId", str2);
                        bVar.ad(str2, hashCode).q(hashMap).SR();
                    }
                }
            };
            a(anonymousClass3);
            final com.tencent.mm.plugin.appbrand.widget.input.a.e eVar3 = eVar;
            intValue = i;
            d.runOnUiThread(new Runnable(this) {
                final /* synthetic */ e iSD;

                public final void run() {
                    m mVar = (m) weakReference2.get();
                    if (mVar != null && mVar.jde != null) {
                        f.Yv().n(mVar.jde);
                        x xVar = anonymousClass3;
                        com.tencent.mm.plugin.appbrand.widget.input.a.e eVar = eVar3;
                        int i = intValue;
                        d.aN(xVar);
                        xVar.jsQ = eVar;
                        xVar.iNd = xVar.jsQ.jsp;
                        m mVar2 = xVar.iNd == null ? null : (m) xVar.iNd.get();
                        if (mVar2 == null || mVar2.jde == null) {
                            w.e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
                            xVar.TK();
                            return;
                        }
                        boolean z;
                        xVar.jsS = ad.b(xVar.jsQ.jxr) ? new o(mVar2.mContext) : new r(mVar2.mContext);
                        xVar.cs(true);
                        xVar.jsS.addTextChangedListener(new com.tencent.mm.ui.widget.h(xVar) {
                            final /* synthetic */ g jte;

                            {
                                this.jte = r1;
                            }

                            public final void afterTextChanged(Editable editable) {
                                if (this.jte.iNd != null && this.jte.iNd.get() != null && this.jte.jsS != null) {
                                    new Runnable(this) {
                                        final /* synthetic */ AnonymousClass9 jtg;

                                        {
                                            this.jtg = r1;
                                        }

                                        public final void run() {
                                            if (this.jtg.jte.jsS == null) {
                                                w.e("MicroMsg.AppBrandInputInvokeHandler", "runnable post by afterTextChanged, get null input");
                                                return;
                                            }
                                            if (bg.mA(this.jtg.jte.jsR)) {
                                                w.e("MicroMsg.AppBrandInputInvokeHandler", "runnable post by afterTextChanged, get Null Or Nil inputId");
                                            }
                                            Editable editableText = this.jtg.jte.jsS.getEditableText();
                                            this.jtg.jte.jsW.removeCallbacks(this.jtg.jte.jsX);
                                            this.jtg.jte.jsX.jtk = editableText;
                                            this.jtg.jte.jsW.postDelayed(this.jtg.jte.jsX, (long) (this.jtg.jte.jsY ? ck.CTRL_INDEX : 0));
                                            this.jtg.jte.Yx();
                                        }
                                    }.run();
                                }
                            }
                        });
                        View view = xVar.jsS;
                        int intValue = xVar.jsQ.jwY.intValue();
                        int intValue2 = xVar.jsQ.jwZ.intValue();
                        int intValue3 = xVar.jsQ.jxb.intValue();
                        int intValue4 = xVar.jsQ.jxa.intValue();
                        if (view == null || xVar.iNd == null || xVar.iNd.get() == null) {
                            z = false;
                        } else {
                            com.tencent.mm.plugin.appbrand.widget.input.e eVar2 = ((m) xVar.iNd.get()).jdd;
                            z = eVar2 != null && eVar2.a(((m) xVar.iNd.get()).jde, view, intValue, intValue2, intValue3, intValue4);
                        }
                        if (z) {
                            if (!(xVar.jsQ.jwW == null || bg.bV(xVar.jsQ.jwW.jwH))) {
                                com.tencent.mm.plugin.appbrand.widget.input.autofill.d.a(mVar2, xVar.jsS, xVar.jsQ.jwW);
                            }
                            if (!ad.b(xVar.jsQ.jxr)) {
                                xVar.jsS.setSelection(i < 0 ? xVar.jsS.getText().length() : i);
                            }
                            if (ad.b(xVar.jsQ.jxr)) {
                                xVar.jsS.post(new Runnable(xVar) {
                                    final /* synthetic */ g jte;

                                    {
                                        this.jte = r1;
                                    }

                                    public final void run() {
                                        this.jte.Yx();
                                    }
                                });
                            }
                            if ("text".equalsIgnoreCase(xVar.jsQ.jwS) || "emoji".equalsIgnoreCase(xVar.jsQ.jwS)) {
                                mVar = (m) xVar.iNd.get();
                                if (z.al(mVar.jbY)) {
                                    xVar.jsT = v.bU(mVar.jbY);
                                    xVar.YA();
                                    xVar.YE();
                                    xVar.jsS.a(xVar.jsM);
                                    xVar.jsS.setOnKeyListener(new OnKeyListener(xVar) {
                                        final /* synthetic */ g jte;

                                        {
                                            this.jte = r1;
                                        }

                                        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                                            this.jte.jsY = 67 == i;
                                            if (this.jte.jsY) {
                                                this.jte.jsW.removeCallbacks(this.jte.jsZ);
                                                this.jte.jsW.postDelayed(this.jte.jsZ, 1000);
                                            } else {
                                                this.jte.jsZ.run();
                                            }
                                            return false;
                                        }
                                    });
                                    com.tencent.mm.plugin.appbrand.widget.input.m.a((m) xVar.iNd.get(), xVar.jsS);
                                    v vVar = xVar.jsT;
                                    if (!xVar.jsQ.jwT) {
                                        "emoji".equals(xVar.jsQ.jwS);
                                    }
                                    vVar.Zf();
                                    if (xVar.jsQ.jxr.booleanValue()) {
                                        xVar.jsS.setOnEditorActionListener(null);
                                        xVar.jsS.setImeOptions(0);
                                    } else {
                                        int i2 = (xVar.jsQ.jxw == null ? com.tencent.mm.plugin.appbrand.widget.input.a.b.Zy() : xVar.jsQ.jxw).jwN;
                                        xVar.jsS.setImeOptions(i2);
                                        xVar.jsS.setOnEditorActionListener(new com.tencent.mm.plugin.appbrand.widget.input.g.AnonymousClass4(xVar, i2));
                                    }
                                    xVar.jsT.cz(xVar.jsQ.jxs.booleanValue());
                                    xVar.jsT.juK = xVar.jsS;
                                    if (xVar.jsQ.jxr.booleanValue()) {
                                        xVar.jsS.setFocusable(false);
                                        xVar.jsS.setFocusableInTouchMode(false);
                                        xVar.jsT.hide();
                                    } else {
                                        xVar.jsS.requestFocus();
                                        xVar.jsT.show();
                                    }
                                    if (!xVar.jsQ.jxr.booleanValue()) {
                                        i.a(xVar.iNd).YG();
                                    }
                                    ((m) xVar.iNd.get()).a(new c(xVar) {
                                        final /* synthetic */ g jte;

                                        {
                                            this.jte = r1;
                                        }

                                        public final void onDestroy() {
                                            this.jte.YD();
                                        }
                                    });
                                }
                            } else {
                                Assert.assertTrue("Number type implementation removed from here", false);
                            }
                            xVar.jsR = String.valueOf(com.tencent.mm.plugin.appbrand.jsapi.base.f.a(mVar2, xVar.jsS));
                            xVar.jsS.rp(xVar.jsR);
                            xVar.jsS.setOnClickListener(new OnClickListener(xVar) {
                                final /* synthetic */ g jte;

                                {
                                    this.jte = r1;
                                }

                                public final void onClick(View view) {
                                    if (this.jte.jsS != null) {
                                        if (this.jte.jsS.hasFocus()) {
                                            this.jte.Yz();
                                            return;
                                        }
                                        m mVar = this.jte.iNd == null ? null : (m) this.jte.iNd.get();
                                        if (mVar != null) {
                                            f.Yv().n(mVar.jde);
                                        }
                                        if (this.jte.jsS != null && view == this.jte.jsS) {
                                            this.jte.jsS.setFocusable(true);
                                            this.jte.jsS.setFocusableInTouchMode(true);
                                            this.jte.jsT.juK = this.jte.jsS;
                                            this.jte.jsS.requestFocus();
                                        }
                                    }
                                }
                            });
                            com.tencent.mm.plugin.appbrand.widget.input.m.a(xVar.jsR, xVar);
                            xVar.TJ();
                            return;
                        }
                        w.e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
                        xVar.TK();
                    }
                }
            });
            return;
        }
        Map hashMap = new HashMap(1);
        hashMap.put("inputId", str2);
        mVar.x(i2, d("ok", hashMap));
    }

    protected void a(g gVar) {
    }

    protected boolean TI() {
        return true;
    }

    protected boolean a(com.tencent.mm.plugin.appbrand.widget.input.a.e eVar, JSONObject jSONObject, m mVar, int i) {
        int i2 = 0;
        if (!super.a(eVar, jSONObject, mVar, i)) {
            return false;
        }
        int i3;
        eVar.jwY = Integer.valueOf(Math.max(0, eVar.jwY.intValue()));
        if (eVar.jwZ == null) {
            i3 = 0;
        } else {
            i3 = Math.max(0, eVar.jwZ.intValue());
        }
        eVar.jwZ = Integer.valueOf(i3);
        eVar.jwS = jSONObject.optString(Columns.TYPE, "text");
        if (com.tencent.mm.plugin.appbrand.widget.input.m.jtN.contains(eVar.jwS)) {
            eVar.jwT = jSONObject.optBoolean("password");
            eVar.jxF = Boolean.valueOf(jSONObject.optBoolean("password"));
            if (TH()) {
                JSONObject optJSONObject = jSONObject.optJSONObject("dropdown");
                if (optJSONObject != null) {
                    com.tencent.mm.plugin.appbrand.widget.input.a.a.a aVar = new com.tencent.mm.plugin.appbrand.widget.input.a.a.a();
                    aVar.jwE = optJSONObject.optInt("marginLeft");
                    aVar.jwF = optJSONObject.optInt("marginRight");
                    aVar.jwG = optJSONObject.optString("width");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("options");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        aVar.jwH = new ArrayList();
                        while (i2 < optJSONArray.length()) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                String optString = optJSONObject2.optString(SlookAirButtonFrequentContactAdapter.ID);
                                String optString2 = optJSONObject2.optString("title");
                                String optString3 = optJSONObject2.optString("content");
                                if (!(bg.mA(optString) || bg.mA(optString2))) {
                                    com.tencent.mm.plugin.appbrand.widget.input.a.a.b bVar = new com.tencent.mm.plugin.appbrand.widget.input.a.a.b();
                                    bVar.id = optString;
                                    bVar.title = optString2;
                                    bVar.content = optString3;
                                    aVar.jwH.add(bVar);
                                }
                            }
                            i2++;
                        }
                        eVar.jwW = aVar;
                    }
                }
            }
            return true;
        }
        mVar.x(i, d("fail:unsupported input type", null));
        return false;
    }
}
