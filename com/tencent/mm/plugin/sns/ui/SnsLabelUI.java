package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimatedExpandableListView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.l.b;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SnsLabelUI extends MMActivity implements e {
    public static int[] qCJ = new int[]{j.pLC, j.pLA, j.pLw, j.pLp};
    private AnimatedExpandableListView qCI;
    private ArrayList<String> qCK;
    private String qCL;
    private String qCM;
    ap qCN;
    private int qCO = 0;
    private boolean qCP;
    private boolean qCQ = false;
    private boolean qCR = false;
    private boolean qCS = false;
    private int qCT;
    private p qCU;
    private String qCV;
    private int qCW;
    private ArrayList<String> qCX;
    private ArrayList<String> qCY;
    private ArrayList<Long> qCZ;
    private ArrayList<String[]> qDa;

    static /* synthetic */ void a(SnsLabelUI snsLabelUI, int i, ArrayList arrayList, String str, View view) {
        if (snsLabelUI.qCN == null || snsLabelUI.qCN.style != 1) {
            if (arrayList.contains(str)) {
                arrayList.remove(str);
                ((ImageView) view.findViewById(f.pEW)).setImageResource(i.dvO);
                return;
            }
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(f.pEW)).setImageResource(i.dvN);
            } else {
                ((ImageView) view.findViewById(f.pEW)).setImageResource(i.pIQ);
            }
        } else if (arrayList.contains(str)) {
            arrayList.remove(str);
            if (i == 1) {
                ((ImageView) view.findViewById(f.pEW)).setImageResource(i.dzD);
            } else {
                ((ImageView) view.findViewById(f.pEW)).setImageResource(i.pJk);
            }
        } else {
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(f.pEW)).setImageResource(i.dzC);
            } else {
                ((ImageView) view.findViewById(f.pEW)).setImageResource(i.pJj);
            }
        }
    }

    static /* synthetic */ void f(SnsLabelUI snsLabelUI) {
        Intent intent = new Intent();
        intent.putExtra("titile", snsLabelUI.getString(j.dCT));
        intent.putExtra("snsPostWhoCanSee", true);
        intent.putExtra("list_attr", s.q(new int[]{s.vYO, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
        if (snsLabelUI.qCT == 2) {
            if (snsLabelUI.qCN.qDl.size() > 0) {
                intent.putExtra("already_select_contact", bg.c(snsLabelUI.qCN.qDl, ","));
            }
        } else if (snsLabelUI.qCT == 3 && snsLabelUI.qCN.qDm.size() > 0) {
            intent.putExtra("already_select_contact", bg.c(snsLabelUI.qCN.qDm, ","));
        }
        d.a(snsLabelUI, ".ui.contact.SelectContactUI", intent, 4003);
    }

    protected final int getLayoutId() {
        return g.pHE;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        goBack();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(j.pMF);
        h.vJ();
        h.vH().gXC.a(292, this);
        h.vJ();
        h.vH().gXC.a(635, this);
        h.vJ();
        h.vH().gXC.a(638, this);
        h.vJ();
        h.vH().gXC.a(290, this);
        this.qCN = new ap(this);
        Intent intent = getIntent();
        if (intent == null) {
            this.qCO = 0;
            this.qCN.style = 0;
            this.qCL = null;
            this.qCM = null;
        } else {
            this.qCO = intent.getIntExtra("KLabel_range_index", 0);
            this.qCN.style = intent.getIntExtra("k_sns_label_ui_style", 0);
            this.qCL = intent.getStringExtra("Klabel_name_list");
            this.qCM = intent.getStringExtra("Kother_user_name_list");
            if (!TextUtils.isEmpty(intent.getStringExtra("k_sns_label_ui_title"))) {
                qP(intent.getStringExtra("k_sns_label_ui_title"));
            }
        }
        this.qCN.qDh = this.qCO;
        if (this.qCN.style == 1) {
            findViewById(f.pEV).setBackgroundResource(c.black);
        }
        if (this.qCO == 2) {
            if (!TextUtils.isEmpty(this.qCL)) {
                this.qCN.qDj = (ArrayList) bg.f(this.qCL.split(","));
            }
            if (!TextUtils.isEmpty(this.qCM)) {
                this.qCN.qDl = (ArrayList) bg.f(this.qCM.split(","));
            }
        } else if (this.qCO == 3) {
            if (!TextUtils.isEmpty(this.qCL)) {
                this.qCN.qDk = (ArrayList) bg.f(this.qCL.split(","));
            }
            if (!TextUtils.isEmpty(this.qCM)) {
                this.qCN.qDm = (ArrayList) bg.f(this.qCM.split(","));
            }
        }
        h.vJ();
        this.qCP = ((Boolean) h.vI().vr().get(335873, Boolean.valueOf(true))).booleanValue();
        if (this.qCP) {
            this.qCR = true;
            this.qCS = true;
            if (bkA() > 0) {
                this.qCQ = true;
            }
            h.vJ();
            h.vH().gXC.a(new u(1), 0);
        }
        KC();
    }

    protected final void KC() {
        boolean booleanExtra = getIntent().getBooleanExtra("Ktag_rangeFilterprivate", false);
        this.qCI = (AnimatedExpandableListView) findViewById(f.pEU);
        this.qCK = (ArrayList) a.aFG().aFB();
        this.qCN.qDi = booleanExtra;
        this.qCN.S(this.qCK);
        LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.i.d.aXu);
        View view = new View(this);
        view.setLayoutParams(layoutParams);
        this.qCI.addHeaderView(view);
        this.qCI.setAdapter(this.qCN);
        if (this.qCN.qDh == 2) {
            this.qCI.expandGroup(2);
        } else if (this.qCN.qDh == 3) {
            this.qCI.expandGroup(3);
        }
        this.qCI.setOnGroupClickListener(new OnGroupClickListener(this) {
            final /* synthetic */ SnsLabelUI qDb;

            {
                this.qDb = r1;
            }

            public final boolean onGroupClick(ExpandableListView expandableListView, View view, final int i, long j) {
                int i2 = this.qDb.qCN.qDh;
                w.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                if (i <= 1) {
                    if (i2 > 1) {
                        this.qDb.qCI.zI(i2);
                    }
                    this.qDb.qCN.qDh = i;
                    return false;
                } else if (this.qDb.qCY != null && this.qDb.qCY.size() != 0 && SnsLabelUI.bkA() == 0) {
                    this.qDb.qCT = i;
                    com.tencent.mm.ui.base.g.a(this.qDb, this.qDb.getString(j.pLH), null, this.qDb.getString(j.pLG), new OnClickListener(this.qDb) {
                        final /* synthetic */ SnsLabelUI qDb;

                        {
                            this.qDb = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.qDb.qCR = true;
                            a.aFG().aJ(this.qDb.qCY);
                            this.qDb.qCU = com.tencent.mm.ui.base.g.a(this.qDb, this.qDb.getString(j.pLy), false, null);
                        }
                    });
                    w.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
                    return true;
                } else if (this.qDb.qCS) {
                    this.qDb.qCQ = true;
                    this.qDb.qCT = i;
                    this.qDb.qCU = com.tencent.mm.ui.base.g.a(this.qDb, this.qDb.getString(j.pLy), false, null);
                    w.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
                    return true;
                } else if (this.qDb.qCN.qDg == null || this.qDb.qCN.qDg.size() == 0) {
                    this.qDb.qCT = i;
                    SnsLabelUI.f(this.qDb);
                    w.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
                    return true;
                } else {
                    if (i2 != i) {
                        if (i2 == 2) {
                            this.qDb.qCI.collapseGroup(2);
                            this.qDb.qCN.qDj.clear();
                            this.qDb.qCN.qDl.clear();
                        } else if (i2 == 3) {
                            this.qDb.qCI.collapseGroup(3);
                            this.qDb.qCN.qDk.clear();
                            this.qDb.qCN.qDm.clear();
                        }
                        this.qDb.qCI.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 qDd;

                            public final void run() {
                                this.qDd.qDb.qCI.zH(i);
                            }
                        });
                    } else if (this.qDb.qCI.isGroupExpanded(i)) {
                        this.qDb.qCI.zI(i);
                    } else {
                        this.qDb.qCI.zH(i);
                    }
                    this.qDb.qCN.qDh = i;
                    return true;
                }
            }
        });
        this.qCI.setOnChildClickListener(new OnChildClickListener(this) {
            final /* synthetic */ SnsLabelUI qDb;

            {
                this.qDb = r1;
            }

            public final boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
                if (i2 == this.qDb.qCN.getChildrenCount(i) - 1) {
                    this.qDb.qCT = i;
                    SnsLabelUI.f(this.qDb);
                } else {
                    String str = (String) this.qDb.qCN.getChild(i, i2);
                    this.qDb.qCN;
                    ap.GS(str);
                    if (i == 2) {
                        SnsLabelUI.a(this.qDb, 1, this.qDb.qCN.qDj, str, view);
                    } else if (i == 3) {
                        SnsLabelUI.a(this.qDb, 2, this.qDb.qCN.qDk, str, view);
                    }
                }
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsLabelUI qDb;

            {
                this.qDb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qDb.goBack();
                return true;
            }
        });
        a(0, getString(j.pLr), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsLabelUI qDb;

            {
                this.qDb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Context context = this.qDb;
                String c = bg.c(context.qCN.qDj, ",");
                String c2 = bg.c(context.qCN.qDl, ",");
                String c3 = bg.c(context.qCN.qDk, ",");
                String c4 = bg.c(context.qCN.qDm, ",");
                if ((context.qCN.qDh == 2 && context.qCN.qDj.size() == 0 && context.qCN.qDl.size() == 0) || (context.qCN.qDh == 3 && context.qCN.qDk.size() == 0 && context.qCN.qDm.size() == 0)) {
                    com.tencent.mm.ui.base.g.a(context, context.getString(j.pLz), "", context.getString(j.pLG), null);
                } else if ((context.qCN.qDh == 2 && bg.mA(c) && bg.mA(c2)) || (context.qCN.qDh == 3 && bg.mA(c3) && bg.mA(c4))) {
                    com.tencent.mm.ui.base.g.a(context, context.getString(j.pLz), "", context.getString(j.pLG), null);
                } else {
                    context.bkz();
                }
                return true;
            }
        }, b.uTY);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        Intent intent2;
        if (i2 == -1 && i == 4003) {
            w.i("MicroMsg.SnsLabelUI", "the Activity completed");
            stringExtra = intent.getStringExtra("Select_Contacts_To_Create_New_Label");
            if (bg.mA(stringExtra)) {
                stringExtra = intent.getStringExtra("Select_Contact");
                this.qCM = new String(stringExtra);
                w.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[]{stringExtra});
                if (this.qCT == 2) {
                    this.qCN.qDl.clear();
                    if (!bg.mA(stringExtra)) {
                        this.qCN.qDl.addAll(bg.f(stringExtra.split(",")));
                        this.qCN.qDh = this.qCT;
                    }
                } else if (this.qCT == 3) {
                    this.qCN.qDm.clear();
                    if (!bg.mA(stringExtra)) {
                        this.qCN.qDm.addAll(bg.f(stringExtra.split(",")));
                        this.qCN.qDh = this.qCT;
                    }
                }
                this.qCN.notifyDataSetChanged();
                this.qCI.expandGroup(this.qCT);
                return;
            }
            intent2 = new Intent();
            intent2.putExtra("Select_Contact", stringExtra);
            d.b(this.uSU.uTo, "label", ".ui.ContactLabelEditUI", intent2, 4002);
        } else if (i2 == -1 && i == 4001) {
            stringExtra = intent.getStringExtra("Select_Contact");
            w.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[]{stringExtra});
            if (!bg.mA(stringExtra)) {
                intent2 = new Intent();
                intent2.putExtra("Select_Contact", stringExtra);
                d.b(this, "label", ".ui.ContactLabelEditUI", intent2, 4002);
            }
        } else if (i2 == 0 && i == 4002 && intent != null) {
            stringExtra = intent.getStringExtra("k_sns_label_add_label");
            this.qCV = intent.getStringExtra("k_sns_label_add_label");
            this.qCI.postDelayed(new Runnable(this) {
                final /* synthetic */ SnsLabelUI qDb;

                public final void run() {
                    this.qDb.qCK = (ArrayList) a.aFG().aFB();
                    if (this.qDb.qCK == null) {
                        this.qDb.qCK = new ArrayList();
                    }
                    int i;
                    if (bg.mA(stringExtra)) {
                        i = -1;
                    } else {
                        if (!this.qDb.qCK.contains(stringExtra)) {
                            this.qDb.qCK.add(stringExtra);
                        }
                        i = this.qDb.qCK.indexOf(stringExtra);
                    }
                    this.qDb.qCN.S(this.qDb.qCK);
                    this.qDb.qCN.qDh = this.qDb.qCT;
                    if (!bg.mA(stringExtra) && r0 != -1) {
                        if (this.qDb.qCT == 2) {
                            this.qDb.qCN.qDj.add(stringExtra);
                            this.qDb.qCN.qDl.clear();
                        } else if (this.qDb.qCT == 3) {
                            this.qDb.qCN.qDk.add(stringExtra);
                            this.qDb.qCN.qDm.clear();
                        }
                        this.qDb.qCN.notifyDataSetChanged();
                        this.qDb.qCI.expandGroup(this.qDb.qCT);
                    }
                }
            }, 300);
        }
    }

    private void goBack() {
        boolean z = false;
        int i = this.qCN.qDh;
        if (this.qCN.qDh != this.qCO) {
            if ((i == 2 && (this.qCN.qDj.size() != 0 || this.qCN.qDl.size() != 0)) || (i == 3 && (this.qCN.qDk.size() != 0 || this.qCN.qDm.size() != 0))) {
                z = true;
            } else if (i == 1 || i == 0) {
                z = true;
            }
        } else if (!((i != 2 || this.qCN.qDj.size() == 0 || (bg.c(this.qCN.qDj, ",").equals(this.qCL) && bg.c(this.qCN.qDl, ",").equals(this.qCM))) && (i != 3 || this.qCN.qDk.size() == 0 || (bg.c(this.qCN.qDk, ",").equals(this.qCL) && bg.c(this.qCN.qDm, ",").equals(this.qCM))))) {
            z = true;
        }
        if (z) {
            com.tencent.mm.ui.base.g.a(this, true, getString(j.pLv), "", getString(j.pLu), getString(j.pLt), new OnClickListener(this) {
                final /* synthetic */ SnsLabelUI qDb;

                {
                    this.qDb = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.qDb.bkz();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ SnsLabelUI qDb;

                {
                    this.qDb = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.qDb.bky();
                }
            });
        } else {
            bky();
        }
    }

    private void bky() {
        Intent intent = new Intent();
        intent.putExtra("Ktag_range_index", this.qCO);
        if (this.qCO == 2 || this.qCO == 3) {
            intent.putExtra("Klabel_name_list", this.qCL);
            intent.putExtra("Kother_user_name_list", this.qCM);
        }
        setResult(-1, intent);
        finish();
    }

    final void bkz() {
        Intent intent = new Intent();
        if (this.qCN.qDh == 2) {
            this.qCL = bg.c(this.qCN.qDj, ",");
            this.qCM = bg.c(this.qCN.qDl, ",");
            intent.putExtra("Klabel_name_list", this.qCL);
            intent.putExtra("Kother_user_name_list", this.qCM);
        } else if (this.qCN.qDh == 3) {
            this.qCL = bg.c(this.qCN.qDk, ",");
            this.qCM = bg.c(this.qCN.qDm, ",");
            intent.putExtra("Klabel_name_list", this.qCL);
            intent.putExtra("Kother_user_name_list", this.qCM);
        }
        intent.putExtra("Ktag_range_index", this.qCN.qDh);
        setResult(-1, intent);
        finish();
    }

    protected void onDestroy() {
        h.vJ();
        h.vH().gXC.b(292, this);
        h.vJ();
        h.vH().gXC.b(635, this);
        h.vJ();
        h.vH().gXC.b(638, this);
        h.vJ();
        h.vH().gXC.b(290, this);
        super.onDestroy();
    }

    public void onResume() {
        if (this.qCN != null && this.qCV == null) {
            this.qCK = (ArrayList) a.aFG().aFB();
            this.qCN.S(this.qCK);
            if ((this.qCK == null || this.qCK.size() == 0) && !((this.qCM != null && this.qCM.length() != 0) || this.qCN.qDh == 0 || this.qCN.qDh == 1)) {
                this.qCN.qDh = 0;
            }
            this.qCN.notifyDataSetChanged();
        }
        this.qCV = null;
        super.onResume();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r9, int r10, java.lang.String r11, com.tencent.mm.y.k r12) {
        /*
        r8 = this;
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s";
        r2 = 3;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = java.lang.Integer.valueOf(r9);
        r2[r3] = r4;
        r3 = 1;
        r4 = java.lang.Integer.valueOf(r10);
        r2[r3] = r4;
        r3 = 2;
        r2[r3] = r11;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = r8.qCR;
        if (r0 != 0) goto L_0x0022;
    L_0x0021:
        return;
    L_0x0022:
        r0 = r12.getType();
        switch(r0) {
            case 290: goto L_0x002a;
            case 292: goto L_0x0038;
            case 635: goto L_0x0142;
            case 638: goto L_0x015b;
            default: goto L_0x0029;
        };
    L_0x0029:
        goto L_0x0021;
    L_0x002a:
        if (r9 != 0) goto L_0x002e;
    L_0x002c:
        if (r10 == 0) goto L_0x0021;
    L_0x002e:
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz: error at delete tag list!";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        goto L_0x0021;
    L_0x0038:
        if (r9 != 0) goto L_0x0135;
    L_0x003a:
        if (r10 != 0) goto L_0x0135;
    L_0x003c:
        r0 = com.tencent.mm.plugin.sns.model.ae.beQ();
        r2 = r0.getCursor();
        r0 = r2.getCount();
        r8.qCW = r0;
        r0 = r8.qCW;
        if (r0 <= 0) goto L_0x00f0;
    L_0x004e:
        r2.moveToFirst();
        r3 = new com.tencent.mm.plugin.sns.storage.s;
        r3.<init>();
        r0 = r2.getCount();
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r8.qCY = r1;
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r8.qCX = r1;
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r8.qDa = r1;
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r8.qCZ = r1;
    L_0x0076:
        r0 = r2.isAfterLast();
        if (r0 != 0) goto L_0x00e2;
    L_0x007c:
        r3.b(r2);
        r0 = r3.field_memberList;
        if (r0 == 0) goto L_0x00d8;
    L_0x0083:
        r0 = r3.field_memberList;
        r0 = r0.length();
        if (r0 == 0) goto L_0x00d8;
    L_0x008b:
        r0 = r8.qDa;
        r1 = r3.field_memberList;
        r4 = ",";
        r1 = r1.split(r4);
        r0.add(r1);
        r1 = r3.field_tagName;
        r4 = r8.qCY;
        r0 = com.tencent.mm.plugin.label.a.a.aFG();
        r0 = r0.aFD();
        if (r0 != 0) goto L_0x00bf;
    L_0x00a7:
        r0 = r1;
    L_0x00a8:
        r4.add(r0);
        r0 = r8.qCX;
        r0.add(r1);
        r0 = r8.qCZ;
        r4 = r3.field_tagId;
        r1 = java.lang.Long.valueOf(r4);
        r0.add(r1);
    L_0x00bb:
        r2.moveToNext();
        goto L_0x0076;
    L_0x00bf:
        r0 = r0.contains(r1);
        if (r0 != 0) goto L_0x00c7;
    L_0x00c5:
        r0 = r1;
        goto L_0x00a8;
    L_0x00c7:
        r0 = com.tencent.mm.plugin.sns.i.j.pLs;
        r0 = r8.getString(r0);
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r1;
        r0 = java.lang.String.format(r0, r5);
        goto L_0x00a8;
    L_0x00d8:
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz:snstaginfo memberlist is null.";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x00bb;
    L_0x00e2:
        r2.close();
        r0 = r8.qCX;
        r0 = r0.size();
        if (r0 != 0) goto L_0x012f;
    L_0x00ed:
        r0 = 0;
    L_0x00ee:
        if (r0 != 0) goto L_0x0117;
    L_0x00f0:
        r0 = r8.qCS;
        if (r0 == 0) goto L_0x0117;
    L_0x00f4:
        r0 = r8.qCN;
        r1 = r8.qCT;
        r0.qDh = r1;
        r0 = r8.qCI;
        r1 = r8.qCT;
        r0.zH(r1);
        com.tencent.mm.kernel.h.vJ();
        r0 = com.tencent.mm.kernel.h.vI();
        r0 = r0.vr();
        r1 = 335873; // 0x52001 float:4.70658E-40 double:1.659433E-318;
        r3 = 0;
        r3 = java.lang.Boolean.valueOf(r3);
        r0.set(r1, r3);
    L_0x0117:
        r2.close();
        r0 = r8.qCQ;
        if (r0 == 0) goto L_0x0131;
    L_0x011e:
        r0 = 1;
        r8.qCR = r0;
        r0 = com.tencent.mm.plugin.label.a.a.aFG();
        r1 = r8.qCY;
        r0.aJ(r1);
    L_0x012a:
        r0 = 0;
        r8.qCS = r0;
        goto L_0x0021;
    L_0x012f:
        r0 = 1;
        goto L_0x00ee;
    L_0x0131:
        r0 = 0;
        r8.qCR = r0;
        goto L_0x012a;
    L_0x0135:
        r8.bkB();
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz: error at get sns tag list!";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        goto L_0x012a;
    L_0x0142:
        if (r9 != 0) goto L_0x014d;
    L_0x0144:
        if (r10 != 0) goto L_0x014d;
    L_0x0146:
        r0 = r8.qDa;
        r8.bC(r0);
        goto L_0x0021;
    L_0x014d:
        r8.bkB();
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz: error at add contact label!";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        goto L_0x0021;
    L_0x015b:
        if (r9 != 0) goto L_0x020c;
    L_0x015d:
        if (r10 != 0) goto L_0x020c;
    L_0x015f:
        r0 = r8.qCX;
        r1 = r0.iterator();
        r0 = r8.qCZ;
        r2 = r0.iterator();
    L_0x016b:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x019a;
    L_0x0171:
        r0 = r2.next();
        r0 = (java.lang.Long) r0;
        r4 = r0.longValue();
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r6 = 0;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 == 0) goto L_0x016b;
    L_0x0187:
        com.tencent.mm.kernel.h.vJ();
        r3 = com.tencent.mm.kernel.h.vH();
        r3 = r3.gXC;
        r6 = new com.tencent.mm.plugin.sns.model.w;
        r6.<init>(r4, r0);
        r0 = 0;
        r3.a(r6, r0);
        goto L_0x016b;
    L_0x019a:
        com.tencent.mm.kernel.h.vJ();
        r0 = com.tencent.mm.kernel.h.vI();
        r0 = r0.vr();
        r1 = 335874; // 0x52002 float:4.7066E-40 double:1.65944E-318;
        r2 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r0.set(r1, r2);
        r0 = com.tencent.mm.plugin.label.a.a.aFG();
        r0 = r0.aFB();
        r0 = (java.util.ArrayList) r0;
        r8.qCK = r0;
        r0 = com.tencent.mm.plugin.report.service.g.oUh;
        r1 = 11455; // 0x2cbf float:1.6052E-41 double:5.6595E-320;
        r2 = 4;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "";
        r2[r3] = r4;
        r3 = 1;
        r4 = "";
        r2[r3] = r4;
        r3 = 2;
        r4 = r8.qCW;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 3;
        r4 = r8.qCY;
        r4 = r4.size();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.i(r1, r2);
        r0 = r8.qCI;
        r1 = new com.tencent.mm.plugin.sns.ui.SnsLabelUI$10;
        r1.<init>(r8);
        r2 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        r0.postDelayed(r1, r2);
        com.tencent.mm.kernel.h.vJ();
        r0 = com.tencent.mm.kernel.h.vI();
        r0 = r0.vr();
        r1 = 335873; // 0x52001 float:4.70658E-40 double:1.659433E-318;
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);
        r0.set(r1, r2);
        goto L_0x0021;
    L_0x020c:
        r8.bkB();
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz: error at modify label list!";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsLabelUI.a(int, int, java.lang.String, com.tencent.mm.y.k):void");
    }

    private static int bkA() {
        h.vJ();
        return ((Integer) h.vI().vr().get(335874, Integer.valueOf(0))).intValue();
    }

    private void bkB() {
        com.tencent.mm.plugin.report.service.g.oUh.i(11455, new Object[]{"", "", Integer.valueOf(this.qCW), Integer.valueOf(0)});
        h.vJ();
        int intValue = ((Integer) h.vI().vr().get(335874, Integer.valueOf(0))).intValue() + 1;
        h.vJ();
        h.vI().vr().set(335874, Integer.valueOf(intValue));
        this.qCY = null;
        this.qCS = false;
        this.qCR = false;
        if (this.qCU != null && this.qCU.isShowing()) {
            this.qCU.dismiss();
        }
        if (this.qCQ) {
            this.qCQ = false;
            return;
        }
        intValue = j.pLF;
        if (bkA() > 1) {
            intValue = j.pLE;
        }
        com.tencent.mm.ui.base.g.a(this, intValue, j.dHT, new OnClickListener(this) {
            final /* synthetic */ SnsLabelUI qDb;

            {
                this.qDb = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void bC(List<String[]> list) {
        if (this.qCY != null && this.qCY.size() != 0) {
            Iterator it = this.qCY.iterator();
            Iterator it2 = list.iterator();
            List arrayList = new ArrayList(this.qCY.size());
            List arrayList2 = new ArrayList(this.qCY.size());
            while (it.hasNext()) {
                arrayList.add(a.aFG().ze((String) it.next()));
                arrayList2.add(bg.c(Arrays.asList((Object[]) it2.next()), ","));
                this.qCR = true;
            }
            a.aFG().h(arrayList, arrayList2);
        }
    }
}
