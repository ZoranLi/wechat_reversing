package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONArray;
import org.json.JSONObject;

public class i {
    protected int backgroundColor;
    public Context context;
    protected View ipu = null;
    protected int jYp;
    protected int jYq;
    private long jgn = 0;
    protected p qib;
    private int qic = 0;
    private long qid = 0;
    boolean qie = false;
    protected ViewGroup qif;

    public i(Context context, p pVar, ViewGroup viewGroup) {
        this.context = context;
        this.qib = pVar;
        this.qif = viewGroup;
        int[] cP = ab.cP(context);
        this.jYp = cP[0];
        this.jYq = cP[1];
    }

    public final void a(p pVar) {
        p pVar2 = this.qib;
        if (pVar2 != pVar) {
            if (pVar2 == null || !pVar2.equals(pVar)) {
                this.qib = pVar;
                bgl();
                bgc();
            }
        }
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final View getView() {
        if (this.ipu != null) {
            return this.ipu;
        }
        if (this.ipu == null) {
            int aTQ = aTQ();
            if (aTQ != Integer.MAX_VALUE) {
                this.ipu = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(aTQ, this.qif, false);
            } else {
                this.ipu = bgm();
                if (this.ipu.getLayoutParams() == null) {
                    this.qif.addView(this.ipu);
                    LayoutParams layoutParams = this.ipu.getLayoutParams();
                    this.qif.removeView(this.ipu);
                    this.ipu.setLayoutParams(layoutParams);
                }
            }
            if (this.ipu == null) {
                throw new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
            }
        }
        bgf();
        bfT();
        bgl();
        bgc();
        return this.ipu;
    }

    public final p bgp() {
        return this.qib;
    }

    public void bfT() {
    }

    public View bgf() {
        return this.ipu;
    }

    protected void bgl() {
        w.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
    }

    protected int aTQ() {
        return Integer.MAX_VALUE;
    }

    protected View bgm() {
        return null;
    }

    public void bfP() {
        if (!this.qie) {
            this.qie = true;
            this.qid = System.currentTimeMillis();
            this.qic++;
        }
    }

    public void bfQ() {
        if (this.qie) {
            this.qie = false;
            if (this.qid > 0) {
                this.jgn += System.currentTimeMillis() - this.qid;
            }
            this.qid = 0;
        }
    }

    public void N(int i, int i2, int i3) {
    }

    public void bfO() {
        bfQ();
    }

    public final String bgq() {
        return this.qib.qfI;
    }

    public boolean q(JSONArray jSONArray) {
        return false;
    }

    public boolean J(JSONObject jSONObject) {
        if (this.jgn == 0 || this.qib.qfU) {
            return false;
        }
        try {
            jSONObject.put("cid", this.qib.qfI);
            jSONObject.put("exposureCount", this.qic);
            jSONObject.put("stayTime", this.jgn);
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Sns.AdLandingPageBaseComponent", e, "", new Object[0]);
            return false;
        }
    }

    protected void bgc() {
        hD(false);
    }

    protected final void hD(boolean z) {
        if (this.ipu == null) {
            throw new IllegalStateException("set field contentView first");
        } else if (this.qib != null) {
            LayoutParams layoutParams = this.ipu.getLayoutParams();
            if (layoutParams != null) {
                if (this.qib.qfO != 2.14748365E9f) {
                    layoutParams.width = (int) this.qib.qfO;
                }
                if (this.qib.qfP != 2.14748365E9f) {
                    layoutParams.height = (int) this.qib.qfP;
                }
                if (z && (layoutParams instanceof MarginLayoutParams)) {
                    ((MarginLayoutParams) layoutParams).setMargins((int) this.qib.qfM, (int) this.qib.qfK, (int) this.qib.qfN, (int) this.qib.qfL);
                }
                int gravity;
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    gravity = getGravity();
                    if (gravity != 0) {
                        layoutParams2.gravity = gravity;
                    } else {
                        layoutParams2.gravity = -1;
                    }
                } else if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
                    gravity = getGravity();
                    if (gravity != 0) {
                        layoutParams3.gravity = gravity;
                    } else {
                        layoutParams3.gravity = -1;
                    }
                }
                this.ipu.setLayoutParams(layoutParams);
                return;
            }
            w.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.qif);
        }
    }

    private int getGravity() {
        int i = 0;
        switch (this.qib.qfR) {
            case 0:
                i = 48;
                break;
            case 1:
                i = 16;
                break;
            case 2:
                i = 80;
                break;
        }
        switch (this.qib.qfS) {
            case 0:
                return i | 3;
            case 1:
                return i | 1;
            case 2:
                return i | 5;
            default:
                return i;
        }
    }
}
