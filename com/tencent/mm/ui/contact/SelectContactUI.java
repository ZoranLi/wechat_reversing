package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.jf;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.e.b;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.i;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class SelectContactUI extends MMBaseSelectContactUI implements e {
    private String chatroomName;
    private HashSet<String> ipB;
    private ProgressDialog isv;
    private List<String> jBA;
    private TextView jbV;
    private String kfo;
    private int kwO;
    private String title;
    private b vLp = new b(this) {
        final /* synthetic */ SelectContactUI vZH;

        {
            this.vZH = r2;
        }

        public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
            if (bVar instanceof jf) {
                jf jfVar = (jf) bVar;
                if (this.vZH.vZz != null) {
                    if (this.vZH.isv != null) {
                        this.vZH.isv.dismiss();
                        this.vZH.isv = null;
                    }
                    this.vZH.vZz = null;
                    this.vZH.vZy = false;
                    this.vZH.chatroomName = jfVar.fPo.fPs;
                    if (!a.a(this.vZH, i, i2, str, 4)) {
                        int i3;
                        if (i == 0 && i2 == 0 && !bg.mA(this.vZH.chatroomName)) {
                            i.a(this.vZH.chatroomName, jfVar.fPo.fPx, this.vZH.getString(R.l.dTa), false, "");
                            List list = jfVar.fPo.fPw;
                            if (list != null && list.size() > 0) {
                                List linkedList = new LinkedList();
                                for (i3 = 0; i3 < list.size(); i3++) {
                                    linkedList.add(list.get(i3));
                                }
                                i.a(this.vZH.chatroomName, linkedList, this.vZH.getString(R.l.dTb), true, "weixin://findfriend/verifycontact/" + this.vZH.chatroomName + "/");
                            }
                            this.vZH.cN(bg.f(new String[]{this.vZH.chatroomName}));
                            return;
                        }
                        String str2 = "";
                        String str3 = "";
                        String string = ab.getContext().getString(R.l.dTc);
                        if (i2 == -23) {
                            str2 = this.vZH.getString(R.l.eMO);
                            str3 = this.vZH.getString(R.l.eMN);
                        }
                        List list2 = jfVar.fPo.fPw;
                        List list3 = jfVar.fPo.fPu;
                        if (list2 == null || list2.size() <= 0 || (list2.size() != jfVar.fPo.fPr && (list3 == null || list3.size() <= 0 || jfVar.fPo.fPr != list2.size() + list3.size()))) {
                            list2 = jfVar.fPo.fPu;
                            if (list2 != null && list2.size() > 0 && jfVar.fPo.fPr == list2.size()) {
                                str2 = this.vZH.getString(R.l.ewe);
                                str3 = str3 + this.vZH.getString(R.l.elw, new Object[]{bg.c(SelectContactUI.ae(list2), string)});
                            }
                            list2 = jfVar.fPo.fPt;
                            if (list2 != null && list2.size() > 0) {
                                str2 = this.vZH.getString(R.l.ewe);
                                str3 = str3 + this.vZH.getString(R.l.elx, new Object[]{bg.c(SelectContactUI.ae(list2), string)});
                            }
                            if (str2 == null || str2.length() <= 0) {
                                Toast.makeText(this.vZH, this.vZH.getString(R.l.elo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                                return;
                            }
                            g.b(this.vZH, str3, str2, true);
                            return;
                        }
                        LinkedList linkedList2 = new LinkedList();
                        for (i3 = 0; i3 < list2.size(); i3++) {
                            linkedList2.add(list2.get(i3));
                        }
                        SelectContactUI.a(this.vZH, linkedList2, list3);
                    }
                }
            }
        }
    };
    private int vVt;
    private boolean vZA;
    private boolean vZB = true;
    private boolean vZC = false;
    private String vZD;
    private AlphaAnimation vZE;
    private AlphaAnimation vZF;
    private boolean vZG = false;
    private TextView vZp;
    private TextView vZq;
    private TextView vZr;
    private TextView vZs;
    private HashSet<String> vZt;
    private boolean vZu;
    private boolean vZv;
    private String vZw;
    private String vZx;
    private boolean vZy;
    private jf vZz;

    static /* synthetic */ void a(SelectContactUI selectContactUI, LinkedList linkedList) {
        int i = 0;
        Assert.assertTrue(linkedList.size() > 0);
        LinkedList linkedList2 = new LinkedList();
        while (i < linkedList.size()) {
            linkedList2.add(Integer.valueOf(3));
            i++;
        }
        new m(selectContactUI, new m.a(selectContactUI) {
            final /* synthetic */ SelectContactUI vZH;

            {
                this.vZH = r1;
            }

            public final void dl(boolean z) {
            }
        }).g(linkedList, linkedList2);
    }

    static /* synthetic */ void a(SelectContactUI selectContactUI, final LinkedList linkedList, List list) {
        Assert.assertTrue(linkedList.size() > 0);
        String string = ab.getContext().getString(R.l.dTc);
        List arrayList = new ArrayList();
        arrayList.addAll(linkedList);
        arrayList.addAll(list);
        Object[] objArr = new Object[]{bg.c(ae(arrayList), string)};
        g.a((Context) selectContactUI, selectContactUI.getString(R.l.elC, objArr), selectContactUI.getString(R.l.ewe), selectContactUI.getString(R.l.elB), selectContactUI.getString(R.l.elA), true, new OnClickListener(selectContactUI) {
            final /* synthetic */ SelectContactUI vZH;

            public final void onClick(DialogInterface dialogInterface, int i) {
                SelectContactUI.a(this.vZH, linkedList);
            }
        }, null);
    }

    static /* synthetic */ void d(SelectContactUI selectContactUI) {
        List lA = selectContactUI.lA(false);
        lA.remove(com.tencent.mm.u.m.xL());
        if (lA.size() == 1) {
            selectContactUI.finish();
            selectContactUI.a(En_5b8fbb1e.class, new Intent().putExtra("Chat_User", (String) lA.get(0)));
            return;
        }
        selectContactUI.vZz = new jf();
        selectContactUI.vZz.fPn.fPp = "";
        selectContactUI.vZz.fPn.fPq = lA;
        com.tencent.mm.sdk.b.a.urY.m(selectContactUI.vZz);
        selectContactUI.getString(R.l.dIO);
        selectContactUI.isv = g.a((Context) selectContactUI, selectContactUI.getString(R.l.ewf), true, new OnCancelListener(selectContactUI) {
            final /* synthetic */ SelectContactUI vZH;

            {
                this.vZH = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.vZH.vZy = false;
                if (this.vZH.vZz != null) {
                    this.vZH.vZz.fPn.fPm = true;
                    com.tencent.mm.sdk.b.a.urY.m(this.vZH.vZz);
                }
            }
        });
    }

    protected final void Oe() {
        super.Oe();
        this.kwO = getIntent().getIntExtra("list_attr", s.vYN);
        this.title = getIntent().getStringExtra("titile");
        this.kfo = getIntent().getStringExtra("sub_title");
        this.vVt = getIntent().getIntExtra("list_type", -1);
        this.vZB = getIntent().getBooleanExtra("show_too_many_member", true);
        if (s.ee(this.kwO, 256) && o.yv().size() == 0) {
            s.ef(this.kwO, 256);
        }
        this.vZu = getIntent().getBooleanExtra("Add_SendCard", false);
        this.vZv = getIntent().getBooleanExtra("recommend_friends", false);
        if (this.vZu || this.vZv) {
            this.vZw = bg.ap(getIntent().getStringExtra("be_send_card_name"), "");
            this.vZx = bg.ap(getIntent().getStringExtra("received_card_name"), "");
        }
        this.jBA = new ArrayList();
        this.ipB = new HashSet();
        this.vZt = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bg.mA(stringExtra)) {
            this.vZt.addAll(bg.f(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bg.mA(stringExtra)) {
            this.ipB.addAll(bg.f(stringExtra.split(",")));
        }
        Collection hashSet = new HashSet();
        String stringExtra2 = getIntent().getStringExtra("block_contact");
        if (!bg.mA(stringExtra2)) {
            hashSet.addAll(bg.f(stringExtra2.split(",")));
        }
        Collection hashSet2 = new HashSet(hashSet);
        hashSet2.addAll(s.bYl());
        hashSet2.addAll(s.bYm());
        if (this.vZu) {
            hashSet2.removeAll(s.bYl());
        }
        this.jBA.addAll(hashSet2);
        bYn();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(30, (e) this);
        ap.vd().a(138, (e) this);
        b.a(jf.class.getName(), this.vLp);
        w.i("MicroMsg.SelectContactUI", "create!");
        if (!bg.mA(this.kfo)) {
            SE(this.kfo);
        }
        if (s.ee(this.kwO, 64)) {
            a(1, getString(R.l.dHT), new OnMenuItemClickListener(this) {
                final /* synthetic */ SelectContactUI vZH;

                {
                    this.vZH = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    List c = this.vZH.lA(s.ee(this.vZH.kwO, 8192));
                    c.remove(com.tencent.mm.u.m.xL());
                    boolean z = s.ee(this.vZH.kwO, Downloads.RECV_BUFFER_SIZE) && c.size() > 1;
                    if (!z) {
                        return this.vZH.cN(this.vZH.lz(s.ee(this.vZH.kwO, 8192)));
                    }
                    if (!this.vZH.vZy) {
                        this.vZH.vZy = true;
                        SelectContactUI.d(this.vZH);
                    }
                    w.i("MicroMsg.SelectContactUI", "Create the chatroom");
                    return true;
                }
            }, l.b.uTY);
        }
        Ok();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SelectContactUI vZH;

            {
                this.vZH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vZH.aHf();
                this.vZH.finish();
                if (!this.vZH.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                    af.f(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 vZI;

                        {
                            this.vZI = r1;
                        }

                        public final void run() {
                            this.vZI.vZH.moveTaskToBack(true);
                        }
                    }, 80);
                }
                return true;
            }
        });
        if (this.vVt != 15) {
            Iterator it = this.ipB.iterator();
            while (it.hasNext()) {
                this.nyd.aK((String) it.next(), false);
            }
        }
    }

    protected void onDestroy() {
        ap.vd().b(30, (e) this);
        ap.vd().b(138, (e) this);
        b.b(jf.class.getName(), this.vLp);
        super.onDestroy();
    }

    public final void hf(int i) {
        int headerViewsCount = i - this.oCR.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            w.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", Integer.valueOf(headerViewsCount), Integer.valueOf(i));
            return;
        }
        com.tencent.mm.ui.contact.a.a BL = bYb().BL(headerViewsCount);
        if (BL == null) {
            return;
        }
        if (BL instanceof j) {
            if (s.ee(this.kwO, 16384)) {
                w.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
                Intent intent = new Intent();
                String str = "";
                intent.putExtra("Select_Contact", str);
                intent.putExtra("Select_Conv_User", str);
                intent.putExtra("Select_Contact", str);
                setResult(-1, intent);
                finish();
            }
        } else if (BL.jiL != null && BL.jiL.field_deleteFlag != 1) {
            String str2 = BL.jiL.field_username;
            w.i("MicroMsg.SelectContactUI", "ClickUser=%s", str2);
            if (s.ee(this.kwO, 64)) {
                if (!s.ee(this.kwO, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) || this.ipB.size() < getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE)) {
                    TQ(str2);
                } else if (!this.vZt.contains(str2)) {
                    bYh();
                    if (this.ipB.contains(str2)) {
                        this.nyd.MF(str2);
                        this.ipB.remove(str2);
                    } else {
                        str2 = getIntent().getStringExtra("too_many_member_tip_string");
                        if (bg.mA(str2)) {
                            str2 = getString(R.l.eQp, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10))});
                        }
                        g.a(this.uSU.uTo, str2, getString(R.l.dIs), new OnClickListener(this) {
                            final /* synthetic */ SelectContactUI vZH;

                            {
                                this.vZH = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                }
                Ok();
                bYn();
                bYc().notifyDataSetChanged();
                return;
            }
            cN(bg.f(new String[]{str2}));
        }
    }

    private void bYn() {
        if (!this.vZB) {
            return;
        }
        if (this.vVt == 1 || this.vVt == 0) {
            int size;
            int size2 = this.vZt != null ? this.vZt.size() : 0;
            if (this.ipB != null) {
                size = this.ipB.size();
            } else {
                size = 0;
            }
            size2 += size;
            size = bg.PY(com.tencent.mm.i.g.sV().getValue("ChatRoomInviteStartCount"));
            if (size > 0 && size2 == size + 1 && !this.vZG) {
                if (this.jbV == null) {
                    this.jbV = (TextView) findViewById(R.h.cBL);
                }
                if (this.jbV.getVisibility() != 0) {
                    this.jbV.setText(R.l.eLP);
                    this.jbV.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ SelectContactUI vZH;

                        {
                            this.vZH = r1;
                        }

                        public final void onClick(View view) {
                            this.vZH.vZG = true;
                            this.vZH.bYo();
                        }
                    });
                    if (this.vZE == null) {
                        this.vZE = new AlphaAnimation(0.0f, 1.0f);
                    }
                    this.vZE.setDuration(300);
                    if (this.vZF != null) {
                        this.vZF.cancel();
                    }
                    this.jbV.setVisibility(0);
                    this.jbV.startAnimation(this.vZE);
                }
            } else if (size2 < size) {
                bYo();
                this.vZG = false;
            }
        }
    }

    protected final boolean Of() {
        return false;
    }

    protected final boolean Og() {
        return true;
    }

    protected final String Oh() {
        return this.title;
    }

    protected final o Oi() {
        boolean z;
        boolean z2 = false;
        c.a aVar = new c.a();
        aVar.vWe = s.ee(this.kwO, 16);
        aVar.vWd = s.ee(this.kwO, 32);
        aVar.vWf = !s.ee(this.kwO, 4);
        if (s.ee(this.kwO, 1)) {
            z = false;
        } else {
            z = true;
        }
        aVar.vWg = z;
        aVar.vWh = s.ee(this.kwO, FileUtils.S_IWUSR);
        aVar.vWi = s.ee(this.kwO, 1048576);
        if (aVar.vWh) {
            this.vZC = true;
            aVar.vWj = getIntent().getStringExtra("wechat_sport_contact");
            aVar.vWk = getIntent().getStringExtra("wechat_sport_recent_like");
            this.vZD = aVar.vWj;
        }
        List list = this.jBA;
        boolean ee = s.ee(this.kwO, 1);
        boolean ee2 = s.ee(this.kwO, 64);
        if (this.vVt == 15) {
            z2 = true;
        }
        return new c(this, list, ee, ee2, aVar, z2);
    }

    protected final m Oj() {
        if (this.vZC) {
            return new r(this, this.jBA, s.ee(this.kwO, 64), this.vZD);
        }
        return new q(this, this.jBA, s.ee(this.kwO, 64), this.scene);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (s.ee(this.kwO, 256)) {
            if (this.vZp == null) {
                String string;
                View.OnClickListener anonymousClass11 = new View.OnClickListener(this) {
                    final /* synthetic */ SelectContactUI vZH;

                    {
                        this.vZH = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClassName(this.vZH, "com.tencent.mm.ui.contact.GroupCardSelectUI");
                        intent.putExtra("group_select_type", true);
                        boolean ee = s.ee(this.vZH.kwO, 16384);
                        intent.putExtra("group_select_need_result", ee);
                        if (!ee) {
                            this.vZH.startActivity(intent);
                        } else if (this.vZH.vVt == 14) {
                            intent.putExtra("group_multi_select", true);
                            intent.putExtra("already_select_contact", u.c(this.vZH.lz(true), ","));
                            intent.putExtra("max_limit_num", this.vZH.getIntent().getIntExtra("max_limit_num", 9));
                            this.vZH.startActivityForResult(intent, 4);
                        } else {
                            this.vZH.startActivityForResult(intent, 0);
                        }
                    }
                };
                if (this.vVt == 14) {
                    string = getString(R.l.dCM);
                } else {
                    string = getString(R.l.dCB);
                }
                this.vZp = a(listView, anonymousClass11, string);
            }
            this.vZp.setVisibility(i);
        }
        if (s.ee(this.kwO, 512)) {
            if (this.vZq == null) {
                this.vZq = a(listView, new View.OnClickListener(this) {
                    final /* synthetic */ SelectContactUI vZH;

                    {
                        this.vZH = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(11140, Integer.valueOf(0));
                        d.w(this.vZH, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
                    }
                }, getString(R.l.ekh));
            }
            this.vZq.setVisibility(i);
        }
        if (s.ee(this.kwO, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
            if (this.vZr == null) {
                this.vZr = a(listView, new View.OnClickListener(this) {
                    final /* synthetic */ SelectContactUI vZH;

                    {
                        this.vZH = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClassName(this.vZH, "com.tencent.mm.ui.contact.GroupCardSelectUI");
                        intent.putExtra("group_select_type", false);
                        this.vZH.startActivityForResult(intent, 1);
                    }
                }, getString(R.l.dCC));
            }
            this.vZr.setVisibility(i);
        }
        if (s.ee(this.kwO, 2048)) {
            if (this.vZs == null) {
                this.vZs = a(listView, new View.OnClickListener(this) {
                    final /* synthetic */ SelectContactUI vZH;

                    {
                        this.vZH = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("list_attr", 16384);
                        d.b(this.vZH, "brandservice", ".ui.BrandServiceIndexUI", intent, 2);
                    }
                }, getString(R.l.dCJ));
            }
            this.vZs.setVisibility(i);
            this.vZs.setTextSize(16.0f * com.tencent.mm.bg.a.dI(this.vZs.getContext()));
        }
        if (s.ee(this.kwO, 2048)) {
            if (this.vZs != null) {
                this.vZs.setBackgroundResource(R.g.bep);
            }
        } else if (s.ee(this.kwO, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
            if (this.vZr != null) {
                this.vZr.setBackgroundResource(R.g.bep);
            }
        } else if (s.ee(this.kwO, 512)) {
            if (this.vZq != null) {
                this.vZq.setBackgroundResource(R.g.bep);
            }
        } else if (s.ee(this.kwO, 256) && this.vZp != null) {
            this.vZp.setBackgroundResource(R.g.bep);
        }
    }

    private TextView a(ListView listView, View.OnClickListener onClickListener, String str) {
        View inflate = r.eC(this).inflate(R.i.dfA, null);
        inflate.setOnClickListener(onClickListener);
        TextView textView = (TextView) inflate.findViewById(R.h.bGD);
        textView.setText(str);
        listView.addHeaderView(inflate);
        return textView;
    }

    private boolean cN(final List<String> list) {
        w.i("MicroMsg.SelectContactUI", "handleSelect %s", list);
        if (!s.ee(this.kwO, 65536)) {
            return cO(list);
        }
        String string;
        if (list != null) {
            if (list.size() == 1) {
                string = getString(R.l.eQm, new Object[]{n.eK((String) list.get(0))});
            } else if (list.size() > 1) {
                String string2 = getString(R.l.dIC);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    if (i == 3) {
                        stringBuilder.append("...");
                        break;
                    }
                    stringBuilder.append(n.eK((String) list.get(i)));
                    if (i < list.size() - 1) {
                        stringBuilder.append(string2);
                    }
                }
                string = getString(R.l.eQm, new Object[]{stringBuilder.toString()});
            }
            this.vZA = true;
            g.a(this.uSU.uTo, string, null, true, new OnClickListener(this) {
                final /* synthetic */ SelectContactUI vZH;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.vZH.vZA = this.vZH.cO(list);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ SelectContactUI vZH;

                {
                    this.vZH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.vZH.vZA = false;
                }
            });
            return this.vZA;
        }
        string = null;
        this.vZA = true;
        g.a(this.uSU.uTo, string, null, true, /* anonymous class already generated */, /* anonymous class already generated */);
        return this.vZA;
    }

    private boolean cO(List<String> list) {
        boolean endsWith;
        Intent intent;
        if (getIntent().getBooleanExtra("Add_SendCard", false)) {
            if (bg.mA(this.vZw)) {
                this.vZw = bg.c(list, ",");
            } else if (bg.mA(this.vZx)) {
                this.vZx = bg.c(list, ",");
            } else {
                w.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", this.vZw, this.vZx);
                return false;
            }
            endsWith = this.vZx.endsWith("@chatroom");
            intent = new Intent();
            intent.putExtra("be_send_card_name", this.vZw);
            intent.putExtra("received_card_name", this.vZx);
            intent.putExtra("Is_Chatroom", endsWith);
            setResult(-1, intent);
            finish();
        } else if (getIntent().getBooleanExtra("snsPostWhoCanSee", false)) {
            w.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", list.toString());
            ArrayList lz = lz(false);
            lz.remove(com.tencent.mm.u.m.xL());
            boolean z = false;
            for (String str : list) {
                if (!bg.mA(str)) {
                    if (!(lz.contains(str) || com.tencent.mm.u.m.xL().equals(str))) {
                        ap.yY();
                        com.tencent.mm.e.b.af Rc = c.wR().Rc(str);
                        if (!(Rc == null || ((int) Rc.gTQ) == 0 || !com.tencent.mm.j.a.ez(Rc.field_type))) {
                            TQ(str);
                            lz.add(str);
                            endsWith = true;
                            z = endsWith;
                        }
                    }
                }
                endsWith = z;
                z = endsWith;
            }
            if (z) {
                Ok();
                bYb().notifyDataSetChanged();
            } else {
                List lz2 = lz(false);
                lz2.remove(com.tencent.mm.u.m.xL());
                final String c = bg.c(lz2, ",");
                if (bg.bV(lz2)) {
                    r0 = new Intent();
                    r0.putExtra("Select_Contact", c);
                    r0.putExtra("Select_Conv_User", c);
                    r0.putExtra("Select_Contact", c);
                    r0.putExtra("Select_Contacts_To_Create_New_Label", c);
                    setResult(0, r0);
                    finish();
                } else {
                    g.a(this.uSU.uTo, true, getString(R.l.evK), "", getString(R.l.evJ), getString(R.l.evI), new OnClickListener(this) {
                        final /* synthetic */ SelectContactUI vZH;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.SelectContactUI", "return the result,and create new label");
                            Intent intent = new Intent();
                            intent.putExtra("Select_Contact", c);
                            intent.putExtra("Select_Conv_User", c);
                            intent.putExtra("Select_Contact", c);
                            intent.putExtra("Select_Contacts_To_Create_New_Label", c);
                            this.vZH.setResult(-1, intent);
                            this.vZH.finish();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ SelectContactUI vZH;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.SelectContactUI", "return the result");
                            Intent intent = new Intent();
                            intent.putExtra("Select_Contact", c);
                            intent.putExtra("Select_Conv_User", c);
                            intent.putExtra("Select_Contact", c);
                            this.vZH.setResult(-1, intent);
                            this.vZH.finish();
                        }
                    });
                }
            }
        } else if (getIntent().getBooleanExtra("recommend_friends", false)) {
            w.i("MicroMsg.SelectContactUI", "Recommend Friends");
            v.a(this.uSU.uTo, this.vZx, list);
        } else if (s.ee(this.kwO, 16384)) {
            w.i("MicroMsg.SelectContactUI", "return the result");
            r0 = new Intent();
            String c2 = bg.c(list, ",");
            r0.putExtra("Select_Contact", c2);
            r0.putExtra("Select_Conv_User", c2);
            r0.putExtra("Select_Contact", c2);
            setResult(-1, r0);
            finish();
        } else if (getIntent().getBooleanExtra("shareImage", false)) {
            w.i("MicroMsg.SelectContactUI", "Share Image");
            final ArrayList lz3 = lz(true);
            lz3.remove(com.tencent.mm.u.m.xL());
            if (lz3.size() > 0) {
                this.isv = g.a(this.uSU.uTo, getString(R.l.ezo), false, null);
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ SelectContactUI vZH;

                    public final void run() {
                        String xL = com.tencent.mm.u.m.xL();
                        Iterator it = lz3.iterator();
                        int i = 0;
                        String str = null;
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            w.d("MicroMsg.SelectContactUI", "toSend, %s", str2);
                            int i2 = i + (o.dH(str2) ? 1 : 0);
                            k kVar = new com.tencent.mm.ah.k(4, xL, str2, this.vZH.getIntent().getStringExtra("shareImagePath"), 0, null, 0, "", str, true, R.g.bdJ);
                            ap.vd().a(kVar, 0);
                            if (kVar.fCZ != null) {
                                str = kVar.fCZ.field_imgPath;
                            }
                            i = i2;
                        }
                        this.vZH.isv.dismiss();
                        Intent intent = new Intent();
                        intent.putStringArrayListExtra("Select_Contact", lz3);
                        this.vZH.setResult(-1, intent);
                        com.tencent.mm.plugin.report.service.g.oUh.i(11048, Integer.valueOf(1), Integer.valueOf(lz3.size() - i), Integer.valueOf(i));
                        this.vZH.finish();
                    }
                });
            }
        } else if (list.size() > 0) {
            w.i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", list.toString());
            finish();
            intent = new Intent();
            intent.setClass(this, En_5b8fbb1e.class);
            intent.putExtra("Chat_User", (String) list.get(0));
            intent.addFlags(67108864);
            startActivity(intent);
        } else {
            w.e("MicroMsg.SelectContactUI", "unkown action: User=%s", list.toString());
        }
        return true;
    }

    private void Ok() {
        if (!s.ee(this.kwO, 64) || this.ipB.size() <= 0) {
            aB(1, getString(R.l.dHT));
            ae(1, false);
            return;
        }
        aB(1, getString(R.l.dHT) + "(" + this.ipB.size() + ")");
        int intExtra = getIntent().getIntExtra("min_limit_num", 0);
        if (!s.ee(this.kwO, 262144) || this.ipB.size() >= intExtra) {
            ae(1, true);
        } else {
            ae(1, false);
        }
    }

    private ArrayList<String> lz(boolean z) {
        ArrayList<String> arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = this.ipB.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !o.eS(str)) {
                hashSet.add(str);
            } else {
                List<String> eB = com.tencent.mm.u.j.eB(str);
                if (eB != null) {
                    for (String str2 : eB) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    private ArrayList<String> lA(boolean z) {
        ArrayList<String> arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = this.ipB.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !o.eS(str)) {
                hashSet.add(str);
            } else {
                List<String> eB = com.tencent.mm.u.j.eB(str);
                if (eB != null) {
                    for (String str2 : eB) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        hashSet.addAll(this.vZt);
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (!bg.bp(this) || a.a(this, i, i2, str, 4)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 138:
                    bYb().notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        } else if (i == 4 && i2 == -24 && !bg.mA(str)) {
            Toast.makeText(this, str, 1).show();
        }
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (aVar.vYg && aVar.jiL != null) {
            return this.ipB.contains(aVar.jiL.field_username);
        }
        if (aVar.vYh && aVar.jiL != null) {
            return this.ipB.contains(aVar.jiL.field_username);
        }
        if (aVar instanceof j) {
            return this.ipB.isEmpty();
        }
        return false;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.vYg || aVar.jiL == null) {
            return false;
        }
        return this.vZt.contains(aVar.jiL.field_username);
    }

    public final int[] aIO() {
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        if (!s.ee(this.kwO, 1)) {
            arrayList.add(Integer.valueOf(131076));
        }
        if (!s.ee(this.kwO, 4)) {
            arrayList.add(Integer.valueOf(131075));
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return iArr;
    }

    public final void mK(String str) {
        this.ipB.remove(str);
        bYb().notifyDataSetChanged();
        Ok();
    }

    private void TQ(String str) {
        if (!this.vZt.contains(str)) {
            bYh();
            this.nyd.MF(str);
            if (this.ipB.contains(str)) {
                this.ipB.remove(str);
            } else {
                this.ipB.add(str);
            }
        }
    }

    private static List<String> ae(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!ap.zb()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            ap.yY();
            com.tencent.mm.j.a Rc = c.wR().Rc(obj2);
            if (!(Rc == null || ((int) Rc.gTQ) == 0)) {
                obj2 = Rc.tL();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            String stringExtra;
            switch (i) {
                case 0:
                    if (!bg.mA(intent.getStringExtra("Select_Conv_User"))) {
                        cN(bg.f(new String[]{intent.getStringExtra("Select_Conv_User")}));
                        return;
                    }
                    return;
                case 1:
                    stringExtra = intent.getStringExtra("Select_Contact");
                    if (!bg.mA(stringExtra)) {
                        cN(bg.f(stringExtra.split(",")));
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        if (!bg.mA(intent.getStringExtra("Select_Contact"))) {
                            cN(bg.f(new String[]{intent.getStringExtra("Select_Contact")}));
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    stringExtra = intent.getStringExtra("Select_Contact");
                    if (bg.mA(stringExtra)) {
                        w.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    w.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", stringExtra);
                    if (s.ee(this.kwO, 64)) {
                        for (String str : stringExtra.split(",")) {
                            if (this.ipB.add(str)) {
                                this.nyd.MF(str);
                            }
                        }
                        Ok();
                        bYb().notifyDataSetChanged();
                        return;
                    }
                    cN(bg.f(new String[]{stringExtra}));
                    return;
                case 4:
                    String stringExtra2 = intent.getStringExtra("Select_Conv_User");
                    Iterator it = this.ipB.iterator();
                    while (it.hasNext()) {
                        this.nyd.MG((String) it.next());
                    }
                    this.ipB.clear();
                    if (!bg.mA(stringExtra2)) {
                        this.ipB.addAll(bg.f(stringExtra2.split(",")));
                    }
                    Iterator it2 = this.ipB.iterator();
                    while (it2.hasNext()) {
                        this.nyd.aK((String) it2.next(), false);
                    }
                    Ok();
                    return;
                default:
                    return;
            }
        }
    }

    protected final boolean aJR() {
        if (this.vZC) {
            return false;
        }
        return true;
    }

    protected final void Ac(String str) {
        com.tencent.mm.plugin.report.service.g.oUh.i(11225, Integer.valueOf(1), Integer.valueOf(0));
        Intent intent = new Intent();
        intent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        intent.putExtra("label", str);
        Collection hashSet = new HashSet();
        hashSet.addAll(lz(s.ee(this.kwO, 8192)));
        hashSet.addAll(this.vZt);
        intent.putExtra("always_select_contact", bg.c(new ArrayList(hashSet), ","));
        intent.putExtra("always_select_contact", bg.c(new ArrayList(hashSet), ","));
        if (s.ee(this.kwO, 64)) {
            intent.putExtra("list_attr", s.q(16384, 64, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
            if (this.vVt == 14) {
                intent.putExtra("max_limit_num", getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE));
            }
        } else {
            intent.putExtra("list_attr", 16384);
        }
        startActivityForResult(intent, 3);
    }

    private void bYo() {
        if (this.jbV == null) {
            this.jbV = (TextView) findViewById(R.h.cBL);
        }
        if (this.jbV.getVisibility() != 8) {
            if (this.vZF == null) {
                this.vZF = new AlphaAnimation(1.0f, 0.0f);
                this.vZF.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ SelectContactUI vZH;

                    {
                        this.vZH = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        this.vZH.jbV.setVisibility(8);
                    }
                });
            }
            this.vZF.setDuration(300);
            if (this.vZE != null) {
                this.vZE.cancel();
            }
            this.jbV.startAnimation(this.vZF);
        }
    }
}
