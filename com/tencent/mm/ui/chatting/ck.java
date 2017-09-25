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
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;
import com.tencent.mm.ui.widget.MMTextView;

final class ck extends c {
    private SpannableStringBuilder sKP = new SpannableStringBuilder();
    private CharacterStyle sKS = new ForegroundColorSpan(-5066062);
    private int sKV = 3;
    private a vCd;

    public ck() {
        super(7);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYA);
        view.setTag(new es(this.knu).s(view, false));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        es esVar = (es) aVar;
        esVar.vOT.vgp = false;
        boolean z = aVar2.vxp;
        esVar.vOU.vgp = false;
        z = aVar2.vxp;
        ah.a(aVar2.vBD, auVar.field_msgId);
        es.a(esVar, auVar, i, aVar2, false);
        CharSequence v;
        if (auVar.bMA()) {
            v = aVar2.v(auVar.field_msgId, auVar.field_imgPath);
            if (bg.mA(v)) {
                esVar.vOZ.setVisibility(0);
                esVar.vOV.setVisibility(8);
                if (!ah.bUq()) {
                    if (esVar.vPe != null) {
                        esVar.vPe.setVisibility(8);
                    }
                    if (esVar.vyy != null) {
                        esVar.vyy.setVisibility(8);
                    }
                    if (auVar.field_status != 1 || auVar.field_status == 5) {
                        esVar.vPf.setBackgroundResource(R.g.bek);
                        auVar.uJS = true;
                    } else {
                        esVar.vPf.setBackgroundResource(R.g.bej);
                        if (esVar.vyy != null && ah.a(aVar2.vBD, auVar.field_msgId)) {
                            if (auVar.uJS) {
                                Animation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                                alphaAnimation.setDuration(300);
                                esVar.vPf.startAnimation(alphaAnimation);
                                auVar.uJS = false;
                            }
                            esVar.vyy.setVisibility(0);
                        }
                    }
                } else if (esVar.vPe != null) {
                    esVar.vPe.setVisibility(0);
                    if (auVar.field_status >= 2) {
                        esVar.vPe.setVisibility(8);
                    }
                }
                ah.a(i, (ah.a) esVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
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
            esVar.vOS.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, 80));
            esVar.vOU.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, 80));
            esVar.vOX.setMinWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, 80));
            esVar.vOS.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, ao.CTRL_INDEX));
            esVar.vOU.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, ao.CTRL_INDEX));
            esVar.vOX.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(aVar2.uSU.uTo, ao.CTRL_INDEX));
            if (!bg.mA(v2)) {
                if (eJ == es.a.Transforming) {
                    this.sKP.clear();
                    MMTextView mMTextView = esVar.vOX;
                    SpannableStringBuilder spannableStringBuilder = this.sKP;
                    if (spannableStringBuilder == null || v2 == null || v2.length() == 0) {
                        v = spannableStringBuilder;
                    } else {
                        int length;
                        int i2;
                        if (v2.length() < this.sKV) {
                            length = v2.length();
                            i2 = 0;
                        } else {
                            length = v2.length();
                            i2 = length - this.sKV;
                        }
                        spannableStringBuilder.append(v2).setSpan(this.sKS, i2, length, 33);
                        Object obj = spannableStringBuilder;
                    }
                    mMTextView.setText(v);
                } else {
                    esVar.vOX.setText(v2);
                }
                esVar.vOX.setVisibility(0);
                esVar.vOV.setVisibility(0);
                esVar.vOZ.setVisibility(8);
            } else if (eJ != es.a.NoTransform) {
                esVar.vOV.setVisibility(0);
                esVar.vOZ.setVisibility(8);
                esVar.vOY.setVisibility(0);
                esVar.vOX.setVisibility(8);
                if (!ah.bUq()) {
                    if (esVar.vPe != null) {
                        esVar.vPe.setVisibility(8);
                    }
                    if (esVar.vyy != null) {
                        esVar.vyy.setVisibility(8);
                    }
                    if (auVar.field_status != 1) {
                    }
                    esVar.vPf.setBackgroundResource(R.g.bek);
                    auVar.uJS = true;
                } else if (esVar.vPe != null) {
                    esVar.vPe.setVisibility(0);
                    if (auVar.field_status >= 2) {
                        esVar.vPe.setVisibility(8);
                    }
                }
                ah.a(i, (ah.a) esVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
            } else {
                esVar.vOZ.setVisibility(0);
                esVar.vOV.setVisibility(8);
            }
        }
        esVar.vOY.setVisibility(8);
        if (!ah.bUq()) {
            if (esVar.vPe != null) {
                esVar.vPe.setVisibility(8);
            }
            if (esVar.vyy != null) {
                esVar.vyy.setVisibility(8);
            }
            if (auVar.field_status != 1) {
            }
            esVar.vPf.setBackgroundResource(R.g.bek);
            auVar.uJS = true;
        } else if (esVar.vPe != null) {
            esVar.vPe.setVisibility(0);
            if (auVar.field_status >= 2) {
                esVar.vPe.setVisibility(8);
            }
        }
        ah.a(i, (ah.a) esVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
            int i;
            boolean z;
            int i2 = ((dt) view.getTag()).position;
            n nVar = new n(auVar.field_content);
            if (!((nVar.time == 0 && auVar.field_isSend == 0) || (auVar.field_status == 1 && auVar.field_isSend == 1))) {
                if (this.vCd.jXt) {
                    contextMenu.add(i2, 120, 0, R.l.dSD);
                } else {
                    contextMenu.add(i2, 119, 0, R.l.dSC);
                }
            }
            if (auVar.field_status == 5) {
                contextMenu.add(i2, 103, 0, view.getContext().getString(R.l.dVm));
            }
            if (d.Jt("favorite")) {
                contextMenu.add(i2, 116, 0, view.getContext().getString(R.l.eGa));
            }
            if (!auVar.bLX() && auVar.bLZ() && ((auVar.field_status == 2 || auVar.gxJ == 1) && ah.ao(auVar) && ah.Tn(auVar.field_talker))) {
                contextMenu.add(i2, 123, 0, view.getContext().getString(R.l.dUx));
            }
            if (auVar.bMA()) {
                if (bg.mA(this.vCd.v(auVar.field_msgId, auVar.field_imgPath))) {
                    i = R.l.dUF;
                } else {
                    i = R.l.dUD;
                }
            } else if (this.vCd.eK(auVar.field_msgId)) {
                i = R.l.dUB;
            } else {
                i = R.l.dUF;
            }
            if (o.eV(auVar.field_talker) && v.bIJ() && i != -1) {
                contextMenu.add(i2, 121, 0, i);
                z = true;
            } else {
                z = false;
            }
            if (!((nVar.time == 0 && auVar.field_isSend == 0) || ((auVar.field_status == 1 && auVar.field_isSend == 1) || this.vCd.bVJ()))) {
                contextMenu.add(i2, 100, 0, view.getContext().getString(R.l.dUr));
            }
            if (!(z || !v.bIJ() || i == -1)) {
                contextMenu.add(i2, 121, 0, i);
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
                        final /* synthetic */ ck vEM;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            a.bWd();
                            aVar.aJ(auVar);
                        }
                    });
                } else {
                    aVar.aJ(auVar);
                }
                b.hUp.w(auVar);
                return true;
            default:
                return false;
        }
    }

    public final boolean a(View view, a aVar, au auVar) {
        return false;
    }
}
