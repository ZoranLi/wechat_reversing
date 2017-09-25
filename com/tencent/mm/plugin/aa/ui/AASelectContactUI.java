package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.l.b;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AASelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private HashSet<String> ipA;
    private HashSet<String> ipB;
    private long ipC;
    private int ipD;
    private CheckBox ipE;
    private View ipF;
    private String title;

    static /* synthetic */ void a(AASelectContactUI aASelectContactUI, List list) {
        if (aASelectContactUI.ipB != null) {
            aASelectContactUI.ipB.clear();
        } else {
            aASelectContactUI.ipB = new HashSet();
        }
        aASelectContactUI.ipB.addAll(list);
        aASelectContactUI.ipE.setChecked(true);
        aASelectContactUI.bYb().notifyDataSetChanged();
    }

    protected final void Oe() {
        super.Oe();
        this.title = getIntent().getStringExtra("titile");
        this.ipC = getIntent().getLongExtra("max_select_num", 20);
        this.ipD = getIntent().getIntExtra("select_type", 1);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        if (!o.dH(this.chatroomName)) {
            w.i("MicroMsg.AASelectContactUI", "is single chat");
        }
        this.ipB = new HashSet();
        this.ipA = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bg.mA(stringExtra)) {
            this.ipA.addAll(Arrays.asList(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bg.mA(stringExtra)) {
            this.ipB.addAll(bg.f(stringExtra.split(",")));
            Ok();
        }
        this.ipE = (CheckBox) findViewById(R.h.cJm);
        this.ipF = findViewById(R.h.cJn);
        this.ipF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AASelectContactUI ipG;

            {
                this.ipG = r1;
            }

            public final void onClick(View view) {
                if (this.ipG.ipE.isChecked()) {
                    if (this.ipG.ipB != null) {
                        this.ipG.ipB.clear();
                    } else {
                        this.ipG.ipB = new HashSet();
                    }
                    this.ipG.ipE.setChecked(false);
                    this.ipG.bYb().notifyDataSetChanged();
                } else {
                    final List mG = h.mG(this.ipG.chatroomName);
                    if (((long) mG.size()) > this.ipG.ipC) {
                        g.a(this.ipG.uSU.uTo, this.ipG.getString(R.l.dBA, new Object[]{Long.valueOf(this.ipG.ipC)}), "", new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 ipI;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AASelectContactUI.a(this.ipI.ipG, mG);
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 ipI;

                            {
                                this.ipI = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else {
                        AASelectContactUI.a(this.ipG, mG);
                    }
                }
                com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(6)});
            }
        });
        if (this.ipB.size() == h.mG(this.chatroomName).size()) {
            this.ipE.setChecked(true);
        } else {
            this.ipE.setChecked(false);
        }
        this.ipE.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ AASelectContactUI ipG;

            {
                this.ipG = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.ipG.Ok();
            }
        });
    }

    protected final void KC() {
        super.KC();
        a(1, getString(R.l.dHT), new OnMenuItemClickListener(this) {
            final /* synthetic */ AASelectContactUI ipG;

            {
                this.ipG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (((long) this.ipG.ipB.size()) > this.ipG.ipC) {
                    g.b(this.ipG.uSU.uTo, this.ipG.getString(R.l.evS, new Object[]{Long.valueOf(this.ipG.ipC)}), "", true);
                    com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(8)});
                    com.tencent.mm.plugin.report.service.g.oUh.i(13722, new Object[]{Integer.valueOf(3)});
                } else if (this.ipG.ipB.size() <= 0) {
                    g.b(this.ipG.uSU.uTo, this.ipG.getString(R.l.dBD, new Object[]{Integer.valueOf(1)}), "", true);
                    com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(9)});
                } else {
                    List linkedList = new LinkedList();
                    linkedList.addAll(this.ipG.ipB);
                    this.ipG.setResult(-1, this.ipG.getIntent().putExtra("Select_Contact", bg.c(linkedList, ",")));
                    this.ipG.finish();
                    this.ipG.aHf();
                    com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(8)});
                }
                return true;
            }
        }, b.uTY);
        Ok();
        this.nyd.sJx = this;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AASelectContactUI ipG;

            {
                this.ipG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.ipG.ipB == null || this.ipG.ipB.size() <= 0 || ((long) this.ipG.ipB.size()) > this.ipG.ipC || (this.ipG.ipB.size() == 1 && this.ipG.ipB.contains(m.xL()))) {
                    this.ipG.finish();
                } else {
                    g.a(this.ipG, this.ipG.getString(R.l.dBz), null, this.ipG.getString(R.l.dBC), this.ipG.getString(R.l.dBB), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass4 ipJ;

                        {
                            this.ipJ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (((long) this.ipJ.ipG.ipB.size()) > this.ipJ.ipG.ipC) {
                                g.b(this.ipJ.ipG.uSU.uTo, this.ipJ.ipG.getString(R.l.evS, new Object[]{Long.valueOf(this.ipJ.ipG.ipC)}), "", true);
                                com.tencent.mm.plugin.report.service.g.oUh.i(13722, new Object[]{Integer.valueOf(3)});
                                return;
                            }
                            List linkedList = new LinkedList();
                            linkedList.addAll(this.ipJ.ipG.ipB);
                            this.ipJ.ipG.setResult(-1, this.ipJ.ipG.getIntent().putExtra("Select_Contact", bg.c(linkedList, ",")));
                            this.ipJ.ipG.finish();
                            com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(11)});
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass4 ipJ;

                        {
                            this.ipJ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ipJ.ipG.finish();
                            com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(10)});
                        }
                    });
                }
                com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(7)});
                return true;
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bg.mA(stringExtra)) {
            this.ipA.addAll(bg.f(stringExtra.split(",")));
        }
    }

    protected final boolean Of() {
        return false;
    }

    protected final boolean Og() {
        return false;
    }

    protected final String Oh() {
        return this.title;
    }

    protected final com.tencent.mm.ui.contact.o Oi() {
        return new d(this, this.chatroomName);
    }

    protected final com.tencent.mm.ui.contact.m Oj() {
        return new e(this, this.chatroomName);
    }

    public final void hf(int i) {
        n bYb = bYb();
        a BL = bYb.BL(i - this.oCR.getHeaderViewsCount());
        if (BL != null && BL.jiL != null) {
            w.i("MicroMsg.AASelectContactUI", "ClickUser=%s", new Object[]{BL.jiL.field_username});
            String str = BL.jiL.field_username;
            if (str.equals(m.xL())) {
                com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(4)});
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(5)});
            }
            bYh();
            if (this.ipB.contains(str)) {
                this.ipB.remove(str);
            } else {
                this.ipB.add(str);
            }
            if (this.ipB.size() == h.mG(this.chatroomName).size()) {
                this.ipE.setChecked(true);
            } else {
                this.ipE.setChecked(false);
            }
            bYb.notifyDataSetChanged();
            Ok();
        }
    }

    public final boolean a(a aVar) {
        if (!aVar.vYg || aVar.jiL == null) {
            return false;
        }
        return this.ipB.contains(aVar.jiL.field_username);
    }

    public final boolean b(a aVar) {
        if (!aVar.vYg || aVar.jiL == null) {
            return false;
        }
        return this.ipA.contains(aVar.jiL.field_username);
    }

    private void Ok() {
        if (this.ipB.size() > 0) {
            aB(1, getString(R.l.dAX, new Object[]{Integer.valueOf(this.ipB.size())}));
        } else {
            aB(1, getString(R.l.dHT));
        }
        if (this.ipB.size() == 1 && this.ipB.contains(m.xL())) {
            ae(1, false);
        } else {
            ae(1, true);
        }
    }

    protected final int Ol() {
        return 1;
    }

    public final void mK(String str) {
        this.ipB.remove(str);
        bYb().notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return R.i.cTy;
    }
}
