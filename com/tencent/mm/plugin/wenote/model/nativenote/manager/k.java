package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.plugin.wenote.model.a.e;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;

public final class k implements b {
    public static int swA = -1;
    public static k swu = null;
    private static DisplayMetrics swx;
    public static int swy = -1;
    public int Sa;
    public long fFx = -1;
    public int jkQ;
    private transient Handler mHandler = new Handler();
    public int mScreenHeight;
    public long swB = -1;
    private String swC = "";
    private boolean swD = false;
    public int swE = -1;
    public String swF = null;
    public long swG = -1;
    private OnKeyListener swH = new OnKeyListener(this) {
        final /* synthetic */ k swJ;

        {
            this.swJ = r1;
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 4) {
                this.swJ.swt.bBo();
                return false;
            } else if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67 || c.bBv().size() == 0) {
                return false;
            } else {
                WXRTEditText bBQ = this.swJ.bBQ();
                if (bBQ == null) {
                    return false;
                }
                int bBN = bBQ.bBN();
                com.tencent.mm.plugin.wenote.model.a.a wS = c.bBv().wS(bBN);
                if (wS == null) {
                    return false;
                }
                com.tencent.mm.plugin.wenote.model.a.a wS2 = c.bBv().wS(bBN - 1);
                e eVar;
                switch (bBQ.swa) {
                    case 0:
                        int selectionStart = bBQ.getSelectionStart();
                        if (selectionStart == bBQ.getSelectionEnd() && selectionStart == 0 && bBN != 0 && wS2 != null) {
                            boolean X;
                            String a = bBQ.a(i.swl);
                            c.bBv().bBy();
                            if (wS2.getType() == 1) {
                                X = c.bBv().X(bBN, true);
                                eVar = (e) wS2;
                                int length = eVar.suy.getText().toString().length();
                                eVar.content += a;
                                eVar.suv = length;
                                eVar.sut = true;
                                eVar.suz = false;
                            } else {
                                if (bg.mA(a)) {
                                    X = c.bBv().X(bBN, true);
                                } else {
                                    X = false;
                                }
                                wS2.sux.setSelection(0);
                                wS2.sut = true;
                                wS2.suz = false;
                            }
                            if (this.swJ.swt != null) {
                                if (!X) {
                                    this.swJ.swt.dA(bBN - 1, 2);
                                    break;
                                }
                                this.swJ.swt.L(bBN - 1, 0);
                                break;
                            }
                        }
                        return false;
                        break;
                    case 1:
                        if (bBN != 0 && wS2 != null) {
                            c.bBv().bBy();
                            if (wS2.getType() == 1) {
                                eVar = (e) wS2;
                                if (bg.mA(eVar.content)) {
                                    wS.suw.setSelection(0);
                                    wS.sut = true;
                                    wS.suz = true;
                                    c.bBv().X(bBN - 1, true);
                                    return true;
                                }
                                if (eVar.content.endsWith("<br/>")) {
                                    eVar.content = eVar.content.substring(0, eVar.content.length() - 5);
                                }
                                eVar.suv = -1;
                                eVar.sut = true;
                                eVar.suz = false;
                            } else {
                                wS2.sux.setSelection(0);
                                wS2.sut = true;
                                wS2.suz = false;
                            }
                            if (this.swJ.swt != null) {
                                this.swJ.swt.dA(bBN - 1, 2);
                                break;
                            }
                        }
                        return false;
                        break;
                    case 2:
                        if (wS.getType() != 4 || !((h) wS).suE.booleanValue()) {
                            if (wS.suA) {
                                c.bBv().bBy();
                                if (wS2 != null && wS2.getType() == 1) {
                                    c.bBv().X(bBN, true);
                                    eVar = (e) wS2;
                                    eVar.content += "<br/>";
                                    eVar.suv = -1;
                                    eVar.sut = true;
                                    eVar.suz = false;
                                    if (this.swJ.swt != null) {
                                        this.swJ.swt.L(bBN - 1, 0);
                                        break;
                                    }
                                }
                                c.bBv().X(bBN, false);
                                if (this.swJ.swt != null) {
                                    this.swJ.swt.wP(bBN);
                                }
                                wS2 = new e();
                                wS2.sut = true;
                                wS2.suz = false;
                                wS2.content = "";
                                wS2.suv = 0;
                                c.bBv().a(bBN, wS2, true);
                                break;
                            }
                            c.bBv().Y(bBN, true);
                            return true;
                        }
                        return false;
                        break;
                }
                return true;
            }
        }
    };
    public final aj swI = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ k swJ;

        {
            this.swJ = r1;
        }

        public final boolean oQ() {
            if (-1 == this.swJ.swB) {
                return false;
            }
            this.swJ.bBT();
            return true;
        }
    }, true);
    private transient ArrayList<WXRTEditText> swp = new ArrayList();
    private int swq = a.swK;
    private transient boolean swr;
    private transient boolean sws;
    public com.tencent.mm.plugin.wenote.model.nativenote.b.a swt = null;
    public boolean swv = false;
    public int sww;
    public int swz;

    public enum a {
        ;

        static {
            swK = 1;
            swL = 2;
            swM = 3;
            swN = new int[]{swK, swL, swM};
        }
    }

    public k(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar, Context context) {
        this.swt = aVar;
        swu = this;
        this.Sa = com.tencent.mm.pluginsdk.e.bG(context);
        this.jkQ = com.tencent.mm.pluginsdk.e.ds(context);
        int[] aG = j.aG(context);
        this.mScreenHeight = aG[1];
        this.sww = aG[0];
        swx = context.getResources().getDisplayMetrics();
        this.swz = ((this.mScreenHeight - this.Sa) - this.jkQ) - ((int) TypedValue.applyDimension(1, 8.0f, swx));
        this.swC = c.bBv().bBC();
    }

    public final void i(WXRTEditText wXRTEditText) {
        if (wXRTEditText.swa == 0) {
            wXRTEditText.setTextSize(0, (float) com.tencent.mm.bg.a.T(wXRTEditText.getContext(), R.f.aXI));
        }
        wXRTEditText.svR = this;
        wXRTEditText.Ls(null);
        wXRTEditText.setOnKeyListener(this.swH);
    }

    public final WXRTEditText bBQ() {
        c bBv = c.bBv();
        ArrayList arrayList = this.swp;
        if (arrayList != null) {
            arrayList.clear();
            synchronized (bBv) {
                if (bBv.jnH == null) {
                } else {
                    Iterator it = bBv.jnH.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.plugin.wenote.model.a.a aVar = (com.tencent.mm.plugin.wenote.model.a.a) it.next();
                        if (aVar.suy != null) {
                            arrayList.add(aVar.suy);
                        } else if (!(aVar.suw == null || aVar.sux == null)) {
                            arrayList.add(aVar.suw);
                            arrayList.add(aVar.sux);
                        }
                    }
                }
            }
        }
        if (this.swp == null) {
            return null;
        }
        Iterator it2 = this.swp.iterator();
        while (it2.hasNext()) {
            WXRTEditText wXRTEditText = (WXRTEditText) it2.next();
            if (wXRTEditText.hasFocus()) {
                return wXRTEditText;
            }
        }
        return null;
    }

    public final void bBR() {
        Object obj = 1;
        synchronized (this) {
            if (!this.sws) {
                Object obj2;
                if (this.swq == a.swL) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (this.swq != a.swK) {
                    obj = obj2;
                } else if (bBQ() == null) {
                    obj = null;
                }
                if (obj != null) {
                    this.swt.a(Boolean.valueOf(true), false);
                }
            }
            this.sws = false;
            this.swr = false;
        }
    }

    public final void a(WXRTEditText wXRTEditText, boolean z, final int i) {
        synchronized (this) {
            if (this.swr) {
                this.sws = true;
            }
        }
        if (z) {
            if (wXRTEditText == null || wXRTEditText.swa != 1) {
                c.bBv().Z(i, false);
            } else {
                c.bBv().Z(i, true);
            }
            if (this.swB < 0 && this.fFx > 0) {
                this.swI.v(60000, 60000);
                this.swB = bg.NA();
                this.swC = c.bBv().bBC();
            }
            bBR();
            return;
        }
        c.bBv().Y(-1, false);
        this.swr = true;
        this.mHandler.postDelayed(new Runnable(this) {
            final /* synthetic */ k swJ;

            public final void run() {
                this.swJ.bBR();
            }
        }, 10);
    }

    public final void a(WXRTEditText wXRTEditText, int i, int i2) {
        if (wXRTEditText != null && this.swt != null) {
            this.swt.dB(i, i2);
        }
    }

    public final void a(WXRTEditText wXRTEditText, int i) {
        String a = wXRTEditText.a(i.swl);
        com.tencent.mm.plugin.wenote.model.a.a wS;
        if (wXRTEditText.swa == 0) {
            wS = c.bBv().wS(wXRTEditText.bBN());
            if (wS != null && wS.getType() == 1) {
                c.bBv().bBy();
                String str = ((e) wS).content;
                ((e) wS).suv = i;
                ((e) wS).content = a;
                ((e) wS).sut = true;
                wS.suz = false;
                c bBv = c.bBv();
                int bBN = wXRTEditText.bBN();
                if (!bg.mA(str)) {
                    bBv.svo -= com.tencent.mm.plugin.wenote.b.b.Lw(str);
                }
                if (!bg.mA(a)) {
                    bBv.svo += com.tencent.mm.plugin.wenote.b.b.Lw(a);
                }
                if (bBv.svo > 16384 && bBv.svl != null && str.length() <= a.length()) {
                    ((e) bBv.jnH.get(bBN)).content = str;
                    bBv.svl.L(bBN, 0);
                    return;
                }
                return;
            }
            return;
        }
        wXRTEditText.setText("");
        if (!bg.mA(a)) {
            String str2;
            wS = new e();
            if (a.equals("<br/>")) {
                str2 = "";
            } else {
                str2 = a;
            }
            wS.content = str2;
            c.bBv().a(wS, wXRTEditText, true, false);
        }
    }

    public static k bBS() {
        return swu;
    }

    public final void bBs() {
        this.swt.bBn();
    }

    public final void b(WXRTEditText wXRTEditText) {
        this.swt.a(wXRTEditText);
    }

    private synchronized void aG(String str, boolean z) {
        com.tencent.mm.sdk.b.b fpVar = new fp();
        fpVar.fKp.type = 19;
        fpVar.fKp.fFC = c.bBv().Lr(str);
        if (fpVar.fKp.fFC == null) {
            w.e("noteeditor.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
        } else {
            fpVar.fKp.title = str;
            fpVar.fKp.fFx = this.fFx;
            fpVar.fKp.fKw = z ? 1 : 0;
            fpVar.fKp.desc = "fav_update_note_storage";
            com.tencent.mm.sdk.b.a.urY.m(fpVar);
            if (z) {
                this.swE = fpVar.fKp.fKs.getIntExtra("fav_note_item_status", -1);
                this.swF = fpVar.fKp.fKs.getStringExtra("fav_note_xml");
                this.swG = fpVar.fKp.fKs.getLongExtra("fav_note_item_updatetime", -1);
            }
        }
    }

    public final void bBT() {
        if (this.fFx > 0 && this.swB > 0) {
            String bBC = c.bBv().bBC();
            if (!bBC.equals(this.swC)) {
                this.swC = bBC;
                if (this.swD) {
                    aG(this.swC, false);
                    return;
                }
                this.swD = true;
                aG(this.swC, true);
            }
        }
    }

    public final WXRTEditText bBU() {
        WXRTEditText bBQ = bBQ();
        if (bBQ != null || this.swp.size() <= 0) {
            return bBQ;
        }
        return (WXRTEditText) this.swp.get(this.swp.size() - 1);
    }

    public final void bBt() {
        this.swt.bBq();
    }
}
