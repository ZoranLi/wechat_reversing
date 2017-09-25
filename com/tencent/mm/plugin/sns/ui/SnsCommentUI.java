package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.i.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@a(17)
public class SnsCommentUI extends MMActivity implements e {
    private int fJn;
    private p irJ = null;
    private int pRa;
    private SnsEditText qBn;
    private int qBo = 0;
    private boolean qBp = false;
    private boolean qBq = false;

    static /* synthetic */ void a(SnsCommentUI snsCommentUI, String str) {
        m tH = ae.beL().tH(snsCommentUI.pRa);
        if (tH != null) {
            snsCommentUI.qBp = true;
            if (tH.bhx()) {
                al.a.a(tH, 2, str, "", snsCommentUI.fJn);
            } else {
                al.a.a(tH.field_userName, 3, str, tH, snsCommentUI.fJn);
            }
            snsCommentUI.aHf();
            snsCommentUI.getString(j.dIO);
            snsCommentUI.irJ = g.a(snsCommentUI, snsCommentUI.getString(j.dIB), true, new OnCancelListener(snsCommentUI) {
                final /* synthetic */ SnsCommentUI qBr;

                {
                    this.qBr = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
    }

    static /* synthetic */ void b(SnsCommentUI snsCommentUI, String str) {
        if (!snsCommentUI.isFinishing()) {
            com.tencent.mm.u.m.xL();
            aw awVar = new aw(2);
            awVar.Fy(str);
            if (snsCommentUI.qBn.qBu > com.tencent.mm.plugin.sns.c.a.pQH) {
                awVar.tj(2);
            }
            awVar.commit();
            snsCommentUI.setResult(-1);
            snsCommentUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pRa = getIntent().getIntExtra("sns_comment_localId", 0);
        this.qBo = getIntent().getIntExtra("sns_comment_type", 0);
        this.fJn = getIntent().getIntExtra("sns_source", 0);
        h.vJ();
        h.vH().gXC.a(c.CTRL_INDEX, this);
        KC();
    }

    public void onPause() {
        super.onPause();
        if (this.qBn != null) {
            String trim = this.qBn.getText().toString().trim();
            h.vJ();
            h.vI().vr().set(68408, trim);
            if (bg.mA(trim)) {
                h.vJ();
                h.vI().vr().set(7489, Integer.valueOf(0));
                return;
            }
            h.vJ();
            h.vI().vr().set(7489, Integer.valueOf(this.qBn.qBu));
        }
    }

    public void onResume() {
        super.onResume();
        aHj();
    }

    public void onDestroy() {
        super.onDestroy();
        h.vJ();
        h.vH().gXC.b(c.CTRL_INDEX, this);
    }

    protected final void KC() {
        this.qBn = (SnsEditText) findViewById(f.content);
        this.qBn.setTextSize(1, (v.dI(this.uSU.uTo) * this.qBn.getTextSize()) / com.tencent.mm.bg.a.getDensity(this.uSU.uTo));
        a(0, getString(j.dIA), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsCommentUI qBr;

            {
                this.qBr = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i;
                if (this.qBr.qBo == 0) {
                    b.sy();
                }
                if (this.qBr.qBo == 2) {
                    i = com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX;
                } else {
                    i = b.sx();
                }
                com.tencent.mm.ui.tools.a.c Ch = com.tencent.mm.ui.tools.a.c.d(this.qBr.qBn).Ch(i);
                Ch.wpp = true;
                Ch.a(new com.tencent.mm.ui.tools.a.c.a(this) {
                    final /* synthetic */ AnonymousClass2 qBs;

                    {
                        this.qBs = r1;
                    }

                    public final void ro(String str) {
                        String trim = this.qBs.qBr.qBn.getText().toString().trim();
                        this.qBs.qBr.qBn.setText("");
                        if (trim.length() > 0) {
                            switch (this.qBs.qBr.qBo) {
                                case 0:
                                    this.qBs.qBr.aHf();
                                    SnsCommentUI.a(this.qBs.qBr, trim);
                                    return;
                                case 1:
                                    this.qBs.qBr.aHf();
                                    SnsCommentUI.b(this.qBs.qBr, trim);
                                    return;
                                case 2:
                                    this.qBs.qBr.aHf();
                                    long longExtra = this.qBs.qBr.getIntent().getLongExtra("sns_id", 0);
                                    long longExtra2 = this.qBs.qBr.getIntent().getLongExtra("action_st_time", 0);
                                    String ap = bg.ap(this.qBs.qBr.getIntent().getStringExtra("sns_uxinfo"), "");
                                    trim = bg.ap(this.qBs.qBr.getIntent().getStringExtra("sns_actionresult"), "") + "|4:1:" + trim;
                                    long currentTimeMillis = System.currentTimeMillis();
                                    com.tencent.mm.plugin.sns.f.h bfD = ae.beD().bfD();
                                    if (bfD != null && bfD.bfE()) {
                                        String str2 = bfD.pZM;
                                        String str3 = bfD.pZL;
                                        w.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + ap + " actionresult: " + trim + " " + longExtra2 + " " + currentTimeMillis);
                                        com.tencent.mm.plugin.report.service.g.oUh.i(11988, new Object[]{str2, str3, "", "", i.df(longExtra), ap, trim, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000)});
                                        this.qBs.qBr.qBq = true;
                                        this.qBs.qBr.finish();
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    }

                    public final void YN() {
                    }

                    public final void Yp() {
                        g.h(this.qBs.qBr, j.pMV, j.pMW);
                    }
                });
                return false;
            }
        }, l.b.uTY);
        if (this.qBo == 0) {
            zi(j.pKC);
        } else if (this.qBo == 1) {
            zi(j.pNb);
            h.vJ();
            String ap = bg.ap((String) h.vI().vr().get(68408, ""), "");
            h.vJ();
            this.qBn.qBu = bg.a((Integer) h.vI().vr().get(7489, Integer.valueOf(0)), 0);
            this.qBn.append(bg.ap(ap, ""));
            if (ap == null || ap.length() <= 0) {
                kr(false);
            } else {
                kr(true);
            }
        } else if (this.qBo == 2) {
            zi(j.pKi);
            kr(false);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsCommentUI qBr;

            {
                this.qBr = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qBr.aHf();
                this.qBr.finish();
                return true;
            }
        });
        this.qBn.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SnsCommentUI qBr;

            {
                this.qBr = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (this.qBr.qBn.getText().toString().trim().length() > 0) {
                    this.qBr.kr(true);
                } else {
                    this.qBr.kr(false);
                }
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.pHw;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.SnsCommentUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
        if (this.irJ != null) {
            this.irJ.dismiss();
        }
        switch (kVar.getType()) {
            case c.CTRL_INDEX /*213*/:
                if (this.qBp) {
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void finish() {
        super.finish();
        if (!this.qBq && this.qBo == 2) {
            long longExtra = getIntent().getLongExtra("sns_id", 0);
            long longExtra2 = getIntent().getLongExtra("action_st_time", 0);
            String ap = bg.ap(getIntent().getStringExtra("sns_uxinfo"), "");
            String str = bg.ap(getIntent().getStringExtra("sns_actionresult"), "") + "|4:0:";
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.plugin.sns.f.h bfD = ae.beD().bfD();
            if (bfD != null && bfD.bfE()) {
                String str2 = bfD.pZM;
                String str3 = bfD.pZL;
                w.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + ap + " actionresult: " + str + " " + longExtra2 + " " + currentTimeMillis);
                com.tencent.mm.plugin.report.service.g.oUh.i(11988, new Object[]{str2, str3, "", "", i.df(longExtra), ap, str, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000)});
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aHf();
        finish();
        return true;
    }
}
