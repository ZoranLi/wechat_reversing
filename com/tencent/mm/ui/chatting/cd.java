package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.fts.d.b.a.b;
import com.tencent.mm.plugin.fts.d.d;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;
import com.tencent.mm.ui.widget.celltextview.CellTextView;
import com.tencent.wcdb.FileUtils;

class cd extends c implements CellTextView.c {
    public static final int vEu = R.h.bAM;
    public static final int vEv = R.h.bAL;
    private a vCd;

    public cd(int i) {
        super(i);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYj);
        view.setTag(new em(this.knu).p(view, false));
        return view;
    }

    public void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        Object obj;
        this.vCd = aVar2;
        final em emVar = (em) aVar;
        emVar.vOB.setTag(vEu, Long.valueOf(auVar.field_msgId));
        emVar.vOB.setTag(vEv, Boolean.valueOf(true));
        if (ah.bUq()) {
            if (emVar.oDJ != null) {
                emVar.oDJ.setVisibility(8);
            }
            if (auVar.field_status == 1 || auVar.field_status == 5) {
                if (emVar.vyy != null) {
                    emVar.vyy.setVisibility(8);
                }
                emVar.vOB.setBackgroundResource(R.g.bek);
                auVar.uJS = true;
            } else {
                emVar.vOB.setBackgroundResource(R.g.bej);
                if (emVar.vyy != null) {
                    if (ah.a(aVar2.vBD, auVar.field_msgId)) {
                        if (auVar.uJS) {
                            Animation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                            alphaAnimation.setDuration(300);
                            emVar.vOB.startAnimation(alphaAnimation);
                            auVar.uJS = false;
                        }
                        emVar.vyy.setVisibility(0);
                    } else {
                        emVar.vyy.setVisibility(8);
                    }
                }
            }
        } else if (emVar.oDJ != null) {
            emVar.oDJ.setVisibility(auVar.field_status >= 2 ? 8 : 0);
        }
        CharSequence charSequence = auVar.field_content;
        if (bg.mA(charSequence)) {
            w.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId));
        }
        Object obj2 = null;
        if (com.tencent.mm.app.plugin.c.oL()) {
            emVar.vAe.lj(false);
            if (auVar.bMs()) {
                if (auVar.bMw()) {
                    emVar.vAe.Tx(auVar.field_transBrandWording);
                    obj2 = 1;
                } else {
                    emVar.vAe.bUO();
                }
            } else if (aVar2.au(auVar) == ChattingTranslateView.a.Translating) {
                emVar.vAe.bUP();
            } else {
                emVar.vAe.bUO();
            }
        } else {
            emVar.vAe.lj(true);
        }
        if (auVar.gxF == null || !auVar.bMB()) {
            obj = null;
        } else {
            obj = 1;
        }
        CharSequence charSequence2;
        CharSequence d;
        CharSequence charSequence3;
        if (obj2 != null && obj == null) {
            charSequence2 = " ";
            CellTextView cellTextView;
            if (x.em(aVar2.vBD.hrM) || x.em(aVar2.vBD.fJL)) {
                Context context = emVar.vOB.getContext();
                emVar.vOB.getTextSize();
                d = h.d(context, charSequence, 1);
                Context context2 = emVar.vOB.getContext();
                charSequence3 = auVar.field_transContent;
                emVar.vOB.getTextSize();
                charSequence = h.d(context2, charSequence3, 1);
                cellTextView = emVar.vOB;
                ap(auVar);
                a(cellTextView, d, charSequence, charSequence2);
            } else {
                d = h.a(emVar.vOB.getContext(), charSequence, (int) emVar.vOB.getTextSize(), 1);
                charSequence = h.a(emVar.vOB.getContext(), auVar.field_transContent, (int) emVar.vOB.getTextSize(), 1);
                cellTextView = emVar.vOB;
                ap(auVar);
                a(cellTextView, d, charSequence, charSequence2);
            }
        } else if (obj == null) {
            emVar.a(emVar.vOB);
            d = h.a(emVar.vOB.getContext(), charSequence, (int) emVar.vOB.getTextSize(), Integer.valueOf(31), ap(auVar));
            obj2 = (aVar2.vJp != auVar.field_msgId || !aVar2.vJo || aVar2.vJq == null || aVar2.vJq.size() <= 0) ? null : 1;
            if (obj2 != null) {
                emVar.vOB.R(f.b(com.tencent.mm.plugin.fts.d.b.a.a(d, aVar2.vJq, b.mdI, d.a.mcB)).mdL);
            } else {
                emVar.vOB.R(d);
            }
            for (l type : (l[]) d.getSpans(0, d.length(), l.class)) {
                if (type.getType() == 44) {
                    g.oUh.i(12809, Integer.valueOf(6), "");
                    break;
                }
            }
        } else {
            charSequence3 = " ";
            if (auVar.gxF.contains("notify@all")) {
                obj = "";
            } else {
                obj = emVar.vOB.getContext().getString(R.l.eMR, new Object[]{"@"}) + "\n";
            }
            if (obj2 != null) {
                charSequence2 = h.a(emVar.vOB.getContext(), obj + charSequence, (int) emVar.vOB.getTextSize(), ap(auVar), Integer.valueOf(31));
                d = h.a(emVar.vOB.getContext(), auVar.field_transContent, (int) emVar.vOB.getTextSize(), ap(auVar), Integer.valueOf(31));
                CellTextView cellTextView2 = emVar.vOB;
                ap(auVar);
                a(cellTextView2, charSequence2, d, charSequence3);
            } else {
                emVar.vOB.R(h.a(emVar.vOB.getContext(), obj + charSequence, (int) emVar.vOB.getTextSize(), Integer.valueOf(31), ap(auVar)));
            }
        }
        emVar.vOB.setTag(dt.a(auVar, aVar2.vxp, i));
        emVar.vOB.setOnClickListener(aVar2.vBD.vEW);
        emVar.vOB.setOnLongClickListener(aVar2.vBD.vEY);
        emVar.vOB.wyh = this;
        emVar.vOB.a(new CellTextView.b(this) {
            final /* synthetic */ cd vEy;

            public final void P(CharSequence charSequence) {
                if (((Boolean) emVar.vOB.getTag(cd.vEv)).booleanValue()) {
                    com.tencent.mm.ui.chatting.d.a.a.bXE();
                    com.tencent.mm.ui.chatting.d.a.a.bXF().a(charSequence, ((Long) emVar.vOB.getTag(cd.vEu)).longValue());
                }
            }
        });
        ah.a(i, (ah.a) emVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
    }

    private void a(CellTextView cellTextView, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Object spannableStringBuilder = new SpannableStringBuilder();
        if (this.vCd.vJp < 0 || this.vCd.vJq == null || this.vCd.vJq.size() <= 0) {
            spannableStringBuilder.append(charSequence);
        } else {
            spannableStringBuilder.append(f.b(com.tencent.mm.plugin.fts.d.b.a.a(charSequence, this.vCd.vJq, b.mdI, d.a.mcB)).mdL);
        }
        spannableStringBuilder.append("\n");
        spannableStringBuilder.append(charSequence3);
        spannableStringBuilder.append("\n");
        spannableStringBuilder.append(charSequence2);
        int length = charSequence.length() + 1;
        int length2 = charSequence3.length();
        if (TextUtils.isEmpty(cellTextView.caS())) {
            cellTextView.R(spannableStringBuilder);
            cellTextView.measure(0, 0);
        }
        Drawable drawable = this.vCd.getResources().getDrawable(R.g.bkR);
        drawable.setBounds(0, 0, (cellTextView.getMeasuredWidth() - cellTextView.getPaddingLeft()) - cellTextView.getPaddingRight(), 2);
        com.tencent.mm.ui.widget.d dVar = new com.tencent.mm.ui.widget.d(drawable);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(4, true), length, (length + length2) + 1, 33);
        spannableStringBuilder.setSpan(dVar, length, length2 + length, 33);
        cellTextView.R(spannableStringBuilder);
    }

    private String ap(au auVar) {
        if (auVar == null) {
            return null;
        }
        String fQ = q.fQ(auVar.field_msgSvrId);
        q.b n = q.yC().n(fQ, true);
        n.l("prePublishId", "msg_" + auVar.field_msgSvrId);
        n.l("preUsername", a(this.vCd, auVar));
        n.l("preChatName", ah.b(this.vCd, auVar));
        return fQ;
    }

    public boolean a(ContextMenu contextMenu, View view, au auVar) {
        boolean z;
        if (auVar.gxF == null || !auVar.gxF.contains("announcement@all")) {
            z = false;
        } else {
            z = true;
        }
        if (auVar.bMk() || auVar.bMc()) {
            int i = ((dt) view.getTag()).position;
            if (auVar.bMk()) {
                contextMenu.add(i, 102, 0, view.getContext().getString(R.l.dUm));
            }
            contextMenu.add(i, 108, 0, view.getContext().getString(R.l.eLH));
            if (auVar.field_status == 5) {
                contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dVm));
            }
            if (com.tencent.mm.bb.d.Jt("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
            }
            if (com.tencent.mm.pluginsdk.model.app.g.L(this.vCd.uSU.uTo, auVar.field_type)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dUu));
            }
            if (!z && !auVar.bLX() && auVar.bMk() && ((auVar.field_status == 2 || auVar.gxJ == 1) && ah.ao(auVar) && ah.Tn(auVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dUx));
            }
            if (com.tencent.mm.app.plugin.c.oL()) {
                if (auVar.bMs() && auVar.bMw()) {
                    contextMenu.add(i, 124, 0, view.getContext().getString(R.l.dUC));
                } else {
                    contextMenu.add(i, 124, 0, view.getContext().getString(R.l.dUE));
                }
            }
            if (auVar.bMk() && e.Dn()) {
                this.vCd.bVJ();
            }
            if (!this.vCd.bVJ()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUp));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        return false;
    }

    public final boolean a(View view, a aVar, au auVar) {
        return false;
    }

    public final boolean ds(View view) {
        return this.vCd.vBD.vFc.ds(view);
    }
}
