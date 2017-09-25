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
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.fts.d.d;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.mm.ui.widget.celltextview.CellTextView;
import com.tencent.mm.ui.widget.celltextview.CellTextView.c;
import com.tencent.wcdb.FileUtils;

class cc extends b implements c {
    public static final int vEu = R.h.bAM;
    public static final int vEv = R.h.bAL;
    private a vCd;

    public cc(int i) {
        super(i);
    }

    public View a(LayoutInflater layoutInflater, View view) {
        if (view != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXE);
        view.setTag(new em(this.knu).p(view, true));
        return view;
    }

    protected final boolean a(a aVar) {
        return aVar.vxp;
    }

    public void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        CharSequence trim;
        CharSequence charSequence;
        Object obj;
        Object obj2;
        Object obj3;
        CharSequence charSequence2;
        CharSequence charSequence3;
        this.vCd = aVar2;
        final em emVar = (em) aVar;
        String str2 = auVar.field_content;
        String str3 = auVar.field_transContent;
        String str4 = aVar2.vBD.fJL;
        emVar.vOB.setTag(vEu, Long.valueOf(auVar.field_msgId));
        emVar.vOB.setTag(vEv, Boolean.valueOf(true));
        Object obj4 = null;
        if (com.tencent.mm.app.plugin.c.oL()) {
            emVar.vAe.lj(false);
            if (auVar.bMs()) {
                if (auVar.bMw()) {
                    emVar.vAe.Tx(auVar.field_transBrandWording);
                    obj4 = 1;
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
        if (aVar2.vxp && !aVar2.sMK) {
            int gh = ay.gh(str2);
            if (gh != -1) {
                String trim2 = str2.substring(0, gh).trim();
                if (trim2 == null || trim2.length() <= 0) {
                    trim2 = str4;
                }
                str2 = str2.substring(gh + 1).trim();
                if (obj4 != null) {
                    str3 = trim2;
                    trim = str3.substring(gh + 1).trim();
                    charSequence = str2;
                } else {
                    obj = str2;
                    String str5 = str3;
                    str3 = trim2;
                    obj2 = str5;
                }
                a((ah.a) emVar, aVar2, auVar, str3);
                ah.a((ah.a) emVar, aVar2, str3, auVar);
                if (auVar.gxF == null && auVar.bMB()) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (obj4 == null && obj3 == null) {
                    charSequence2 = " ";
                    CellTextView cellTextView;
                    if (x.em(aVar2.vBD.hrM) || x.em(aVar2.vBD.fJL)) {
                        Context context = emVar.vOB.getContext();
                        emVar.vOB.getTextSize();
                        trim = h.d(context, charSequence, 1);
                        Context context2 = emVar.vOB.getContext();
                        CharSequence charSequence4 = auVar.field_transContent;
                        emVar.vOB.getTextSize();
                        charSequence = h.d(context2, charSequence4, 1);
                        cellTextView = emVar.vOB;
                        ap(auVar);
                        a(cellTextView, trim, charSequence, charSequence2);
                    } else {
                        charSequence = h.a(emVar.vOB.getContext(), charSequence, (int) emVar.vOB.getTextSize(), 1);
                        trim = h.a(emVar.vOB.getContext(), trim, (int) emVar.vOB.getTextSize(), 1);
                        cellTextView = emVar.vOB;
                        ap(auVar);
                        a(cellTextView, charSequence, trim, charSequence2);
                    }
                } else if (obj3 == null) {
                    emVar.a(emVar.vOB);
                    charSequence2 = h.a(emVar.vOB.getContext(), charSequence, (int) emVar.vOB.getTextSize(), Integer.valueOf(31), ap(auVar));
                    if (aVar2.vJp >= 0 || aVar2.vJq == null || aVar2.vJq.size() <= 0) {
                        emVar.vOB.R(charSequence2);
                    } else {
                        emVar.vOB.R(f.b(com.tencent.mm.plugin.fts.d.b.a.a(charSequence2, aVar2.vJq, com.tencent.mm.plugin.fts.d.b.a.b.mdI, d.a.mcA)).mdL);
                    }
                    for (l type : (l[]) charSequence2.getSpans(0, charSequence2.length(), l.class)) {
                        if (type.getType() == 44) {
                            g.oUh.i(12809, Integer.valueOf(7), "");
                            break;
                        }
                    }
                } else if (obj3 != null) {
                    charSequence3 = " ";
                    if (auVar.gxF.contains("notify@all")) {
                        obj3 = emVar.vOB.getContext().getString(R.l.eMR, new Object[]{"@"}) + "\n";
                    } else {
                        obj3 = "";
                    }
                    if (obj4 == null) {
                        charSequence2 = h.a(emVar.vOB.getContext(), obj3 + charSequence, (int) emVar.vOB.getTextSize(), ap(auVar), Integer.valueOf(31));
                        trim = h.a(emVar.vOB.getContext(), trim, (int) emVar.vOB.getTextSize(), ap(auVar), Integer.valueOf(31));
                        CellTextView cellTextView2 = emVar.vOB;
                        ap(auVar);
                        a(cellTextView2, charSequence2, trim, charSequence3);
                    } else {
                        emVar.vOB.R(h.a(emVar.vOB.getContext(), obj3 + charSequence, (int) emVar.vOB.getTextSize(), Integer.valueOf(31), ap(auVar)));
                    }
                }
                emVar.vOB.setTag(dt.a(auVar, aVar2.vxp, i));
                emVar.vOB.setOnClickListener(aVar2.vBD.vEW);
                emVar.vOB.setOnLongClickListener(aVar2.vBD.vEY);
                emVar.vOB.wyh = this;
                emVar.vOB.setTag(vEu, Long.valueOf(auVar.field_msgId));
                emVar.vOB.a(new CellTextView.b(this) {
                    final /* synthetic */ cc vEx;

                    public final void P(CharSequence charSequence) {
                        if (((Boolean) emVar.vOB.getTag(cc.vEv)).booleanValue()) {
                            com.tencent.mm.ui.chatting.d.a.a.bXE();
                            com.tencent.mm.ui.chatting.d.a.a.bXF().a(charSequence, ((Long) emVar.vOB.getTag(cc.vEu)).longValue());
                        }
                    }
                });
            }
        }
        obj2 = str3;
        str3 = str4;
        obj = str2;
        a((ah.a) emVar, aVar2, auVar, str3);
        ah.a((ah.a) emVar, aVar2, str3, auVar);
        if (auVar.gxF == null) {
        }
        obj3 = null;
        if (obj4 == null) {
        }
        if (obj3 == null) {
            emVar.a(emVar.vOB);
            charSequence2 = h.a(emVar.vOB.getContext(), charSequence, (int) emVar.vOB.getTextSize(), Integer.valueOf(31), ap(auVar));
            if (aVar2.vJp >= 0) {
            }
            emVar.vOB.R(charSequence2);
            while (r1 < r2) {
                if (type.getType() == 44) {
                    g.oUh.i(12809, Integer.valueOf(7), "");
                    break;
                }
            }
        } else if (obj3 != null) {
            charSequence3 = " ";
            if (auVar.gxF.contains("notify@all")) {
                obj3 = emVar.vOB.getContext().getString(R.l.eMR, new Object[]{"@"}) + "\n";
            } else {
                obj3 = "";
            }
            if (obj4 == null) {
                emVar.vOB.R(h.a(emVar.vOB.getContext(), obj3 + charSequence, (int) emVar.vOB.getTextSize(), Integer.valueOf(31), ap(auVar)));
            } else {
                charSequence2 = h.a(emVar.vOB.getContext(), obj3 + charSequence, (int) emVar.vOB.getTextSize(), ap(auVar), Integer.valueOf(31));
                trim = h.a(emVar.vOB.getContext(), trim, (int) emVar.vOB.getTextSize(), ap(auVar), Integer.valueOf(31));
                CellTextView cellTextView22 = emVar.vOB;
                ap(auVar);
                a(cellTextView22, charSequence2, trim, charSequence3);
            }
        }
        emVar.vOB.setTag(dt.a(auVar, aVar2.vxp, i));
        emVar.vOB.setOnClickListener(aVar2.vBD.vEW);
        emVar.vOB.setOnLongClickListener(aVar2.vBD.vEY);
        emVar.vOB.wyh = this;
        emVar.vOB.setTag(vEu, Long.valueOf(auVar.field_msgId));
        emVar.vOB.a(/* anonymous class already generated */);
    }

    private void a(CellTextView cellTextView, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Object spannableStringBuilder = new SpannableStringBuilder();
        if (this.vCd.vJp < 0 || this.vCd.vJq == null || this.vCd.vJq.size() <= 0) {
            spannableStringBuilder.append(charSequence);
        } else {
            spannableStringBuilder.append(f.b(com.tencent.mm.plugin.fts.d.b.a.a(charSequence, this.vCd.vJq, com.tencent.mm.plugin.fts.d.b.a.b.mdI, d.a.mcA)).mdL);
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
        Drawable drawable = this.vCd.getResources().getDrawable(R.g.bkQ);
        drawable.setBounds(0, 0, (cellTextView.getMeasuredWidth() - cellTextView.getPaddingLeft()) - cellTextView.getPaddingRight(), 2);
        spannableStringBuilder.setSpan(new com.tencent.mm.ui.widget.d(drawable), length, length + length2, 33);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(4, true), length, (length2 + length) + 1, 33);
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

    protected boolean bUp() {
        return false;
    }

    public boolean a(ContextMenu contextMenu, View view, au auVar) {
        if (auVar.bMk() || auVar.bMc()) {
            int i = ((dt) view.getTag()).position;
            if (auVar.bMk()) {
                contextMenu.add(i, 102, 0, view.getContext().getString(R.l.dUm));
            }
            contextMenu.add(i, 108, 0, view.getContext().getString(R.l.eLH));
            if (com.tencent.mm.bb.d.Jt("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
            }
            if (com.tencent.mm.pluginsdk.model.app.g.L(this.vCd.uSU.uTo, auVar.field_type)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dUu));
            }
            if (auVar.bMk() && e.Dn()) {
                this.vCd.bVJ();
            }
            if (!this.vCd.bVJ()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUp));
            }
            if (com.tencent.mm.app.plugin.c.oL()) {
                if (auVar.bMs() && auVar.bMw()) {
                    contextMenu.add(i, 124, 0, view.getContext().getString(R.l.dUC));
                } else {
                    contextMenu.add(i, 124, 0, view.getContext().getString(R.l.dUE));
                }
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
