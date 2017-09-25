package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.mm.ui.widget.MMTextView;

final class cg extends b {
    private SpannableStringBuilder sKP = new SpannableStringBuilder();
    private CharacterStyle sKS = new ForegroundColorSpan(-5066062);
    private int sKV = 3;
    private a vCd;

    public cg() {
        super(6);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXX);
        view.setTag(new es(this.knu).s(view, true));
        return view;
    }

    protected final boolean a(a aVar) {
        return aVar.vxp;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        n nVar;
        Object obj;
        int aw;
        com.tencent.mm.ui.a.a aVar3;
        View view;
        String str2;
        this.vCd = aVar2;
        es esVar = (es) aVar;
        esVar.vOT.vgp = true;
        boolean z = aVar2.vxp;
        esVar.vOU.vgp = true;
        z = aVar2.vxp;
        ah.a(aVar2.vBD, auVar.field_msgId);
        es.a(esVar, auVar, i, aVar2, true);
        CharSequence v;
        if (auVar.bMA()) {
            v = aVar2.v(auVar.field_msgId, auVar.field_imgPath);
            if (bg.mA(v)) {
                auVar.dG(auVar.gxE & -65);
                esVar.vOZ.setVisibility(0);
                esVar.vOV.setVisibility(8);
                nVar = new n(auVar.field_content);
                if (nVar.time == 0) {
                    esVar.vyK.setVisibility(8);
                } else {
                    obj = ((aVar2.vBD.vES == null && aVar2.vBD.vES.vzC == auVar.field_msgId) || q.C(auVar)) ? 1 : null;
                    esVar.vyK.setVisibility(obj != null ? 8 : 0);
                    aw = (int) q.aw(nVar.time);
                    if (obj == null) {
                        esVar.vOR.setContentDescription(String.format(aVar2.uSU.uTo.getString(R.l.faz), new Object[]{Integer.valueOf(aw)}));
                    } else {
                        aVar3 = a.uWW;
                        view = esVar.vOR;
                        aVar2.eK(aVar2.vBD.fJL);
                        aVar3.F(view, aw);
                        aVar3 = a.uWW;
                        view = esVar.vOS;
                        aVar2.eK(aVar2.vBD.fJL);
                        aVar3.F(view, aw);
                    }
                }
                str2 = auVar.gxD;
                if (str2 != null || str2.length() == 0) {
                    esVar.vyE.setVisibility(8);
                }
                esVar.vyE.setVisibility(0);
                ah.b(aVar2, esVar.vyE, (Object) dt.TF(str2));
                return;
            }
            esVar.vOX.setText(v);
            esVar.vOS.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, 80));
            esVar.vOU.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, 80));
            esVar.vOX.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, 80));
            esVar.vOS.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, ao.CTRL_INDEX));
            esVar.vOU.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, ao.CTRL_INDEX));
            esVar.vOX.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, ao.CTRL_INDEX));
            esVar.vOX.setVisibility(0);
        } else if (aVar2.eK(auVar.field_msgId)) {
            CharSequence v2 = aVar2.v(auVar.field_msgId, auVar.field_imgPath);
            es.a eJ = aVar2.eJ(auVar.field_msgId);
            if (!bg.mA(v2)) {
                if (eJ == es.a.Transforming) {
                    this.sKP.clear();
                    MMTextView mMTextView = esVar.vOX;
                    SpannableStringBuilder spannableStringBuilder = this.sKP;
                    if (spannableStringBuilder == null || v2 == null || v2.length() == 0) {
                        v = spannableStringBuilder;
                    } else {
                        int i2;
                        if (v2.length() < this.sKV) {
                            aw = v2.length();
                            i2 = 0;
                        } else {
                            aw = v2.length();
                            i2 = aw - this.sKV;
                        }
                        spannableStringBuilder.append(v2).setSpan(this.sKS, i2, aw, 33);
                        obj = spannableStringBuilder;
                    }
                    mMTextView.setText(v);
                } else {
                    esVar.vOX.setText(v2);
                }
                esVar.vOX.setVisibility(0);
                esVar.vOV.setVisibility(0);
                esVar.vOZ.setVisibility(8);
                esVar.vOY.setVisibility(8);
            } else if (eJ != es.a.NoTransform) {
                esVar.vOV.setVisibility(0);
                esVar.vOZ.setVisibility(8);
                esVar.vOX.setVisibility(8);
                esVar.vOY.setVisibility(0);
            } else {
                esVar.vOZ.setVisibility(0);
                esVar.vOV.setVisibility(8);
                esVar.vOY.setVisibility(8);
            }
            esVar.vOS.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, 80));
            esVar.vOU.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, 80));
            esVar.vOX.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, 80));
            esVar.vOS.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, ao.CTRL_INDEX));
            esVar.vOU.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, ao.CTRL_INDEX));
            esVar.vOX.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, ao.CTRL_INDEX));
            nVar = new n(auVar.field_content);
            if (nVar.time == 0) {
                if (aVar2.vBD.vES == null) {
                }
                if (obj != null) {
                }
                esVar.vyK.setVisibility(obj != null ? 8 : 0);
                aw = (int) q.aw(nVar.time);
                if (obj == null) {
                    aVar3 = a.uWW;
                    view = esVar.vOR;
                    aVar2.eK(aVar2.vBD.fJL);
                    aVar3.F(view, aw);
                    aVar3 = a.uWW;
                    view = esVar.vOS;
                    aVar2.eK(aVar2.vBD.fJL);
                    aVar3.F(view, aw);
                } else {
                    esVar.vOR.setContentDescription(String.format(aVar2.uSU.uTo.getString(R.l.faz), new Object[]{Integer.valueOf(aw)}));
                }
            } else {
                esVar.vyK.setVisibility(8);
            }
            str2 = auVar.gxD;
            if (str2 != null) {
            }
            esVar.vyE.setVisibility(8);
        }
        esVar.vOY.setVisibility(8);
        nVar = new n(auVar.field_content);
        if (nVar.time == 0) {
            esVar.vyK.setVisibility(8);
        } else {
            if (aVar2.vBD.vES == null) {
            }
            if (obj != null) {
            }
            esVar.vyK.setVisibility(obj != null ? 8 : 0);
            aw = (int) q.aw(nVar.time);
            if (obj == null) {
                esVar.vOR.setContentDescription(String.format(aVar2.uSU.uTo.getString(R.l.faz), new Object[]{Integer.valueOf(aw)}));
            } else {
                aVar3 = a.uWW;
                view = esVar.vOR;
                aVar2.eK(aVar2.vBD.fJL);
                aVar3.F(view, aw);
                aVar3 = a.uWW;
                view = esVar.vOS;
                aVar2.eK(aVar2.vBD.fJL);
                aVar3.F(view, aw);
            }
        }
        str2 = auVar.gxD;
        if (str2 != null) {
        }
        esVar.vyE.setVisibility(8);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ap.yY();
        if (c.isSDCardAvailable()) {
            int i = ((dt) view.getTag()).position;
            if (!((new n(auVar.field_content).time == 0 && auVar.field_isSend == 0) || (auVar.field_status == 1 && auVar.field_isSend == 1))) {
                boolean z;
                int i2;
                boolean z2;
                ap.yY();
                Boolean bool = (Boolean) c.vr().get(26, null);
                if (bool == null) {
                    bool = Boolean.valueOf(false);
                }
                if (bool.booleanValue()) {
                    contextMenu.add(i, 120, 0, R.l.dSD);
                } else {
                    contextMenu.add(i, 119, 0, R.l.dSC);
                }
                ap.yY();
                x Rc = c.wR().Rc(auVar.field_talker);
                if (o.fh(auVar.field_talker) || o.fE(auVar.field_talker) || Rc == null || Rc.bLe()) {
                    z = false;
                } else {
                    z = true;
                }
                if (d.Jt("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
                }
                if (z) {
                    if (w.DH().fx(2) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && !this.vCd.bVJ()) {
                        contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dUl));
                    }
                }
                if (auVar.bMA()) {
                    if (bg.mA(this.vCd.v(auVar.field_msgId, auVar.field_imgPath))) {
                        i2 = R.l.dUF;
                    } else {
                        i2 = R.l.dUD;
                    }
                } else if (this.vCd.eK(auVar.field_msgId)) {
                    i2 = R.l.dUB;
                } else {
                    i2 = R.l.dUF;
                }
                if (o.eV(auVar.field_talker) && v.bIJ() && i2 != -1) {
                    contextMenu.add(i, 121, 0, i2);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!this.vCd.bVJ()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUr));
                }
                if (!(z2 || !v.bIJ() || i2 == -1)) {
                    contextMenu.add(i, 121, 0, i2);
                }
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, final a aVar, final au auVar) {
        switch (menuItem.getItemId()) {
            case 119:
                aVar.ln(true);
                return true;
            case 120:
                aVar.ln(false);
                return true;
            case 121:
                if (a.bWc()) {
                    g.a(aVar.uSU.uTo, aVar.uSU.uTo.getString(R.l.faX), "", new OnClickListener(this) {
                        final /* synthetic */ cg vEz;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            a.bWd();
                            aVar.aJ(auVar);
                        }
                    });
                } else {
                    aVar.aJ(auVar);
                }
                com.tencent.mm.modelstat.b.hUp.w(auVar);
                return true;
            default:
                return false;
        }
    }

    public final boolean a(View view, a aVar, au auVar) {
        return false;
    }
}
