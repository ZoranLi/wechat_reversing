package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.nz;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SelectDelRoomMemberUI extends MMActivity {
    private ListView Fg;
    private boolean fOg;
    public HashSet<String> ipB;
    private boolean ksZ;
    private q ktr;
    private String kuC;
    private String kuR;
    private int kuS;
    private String kuT;
    private boolean kuU;
    private int kwO;
    private a kwP;
    private EditText kwQ;
    private String kwu;
    private String kwv;
    private String kwx;
    private String username;

    private static class a extends BaseAdapter {
        static List<x> fPq = new ArrayList();
        static List<x> kwH;
        private List<String> jBA;
        private String ktm;
        q ktr;
        private c kvX;
        String kwE;
        private String kwG = null;
        a kwT = null;
        private Context mContext;

        private static class a {
            public TextView jZz;
            public MaskLayout kwV;
            public TextView kwW;
            public ImageView kwX;
            public ImageButton kwY;
        }

        public final /* synthetic */ Object getItem(int i) {
            return kO(i);
        }

        public a(Context context, q qVar, String str, List<String> list, String str2) {
            this.ktr = qVar;
            this.ktm = str;
            this.jBA = list;
            this.mContext = context;
            this.kwG = str2;
            this.kvX = ap.yY();
            ag(j.eA(str));
        }

        public final void ag(List<String> list) {
            if (list != null) {
                fPq.clear();
                for (int i = 0; i < list.size(); i++) {
                    af Rc = c.wR().Rc((String) list.get(i));
                    if (Rc == null || !Rc.field_username.equals(this.kwG)) {
                        fPq.add(Rc);
                    } else {
                        fPq.add(0, Rc);
                    }
                }
                kwH = fPq;
                notifyDataSetChanged();
            }
        }

        public static x kO(int i) {
            return (x) fPq.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            x xVar = (x) fPq.get(i);
            if (view == null) {
                view = View.inflate(this.mContext, R.i.dac, null);
                this.kwT = new a();
                this.kwT.kwV = (MaskLayout) view.findViewById(R.h.cBw);
                this.kwT.jZz = (TextView) view.findViewById(R.h.cBy);
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                this.kwT.jZz.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                this.kwT.kwW = (TextView) view.findViewById(R.h.cBx);
                this.kwT.kwW.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                this.kwT.kwX = (ImageView) view.findViewById(R.h.czd);
                this.kwT.kwY = (ImageButton) view.findViewById(R.h.bvc);
                view.setTag(this.kwT);
                view2 = view;
            } else {
                this.kwT = (a) view.getTag();
                view2 = view;
            }
            if (xVar != null) {
                final String str;
                CharSequence charSequence;
                CharSequence charSequence2;
                this.kwT.jZz.setTextColor(com.tencent.mm.bg.a.S(this.mContext, !o.fE(xVar.field_username) ? R.e.aVa : R.e.aVb));
                if (this.ktr.field_roomowner.equals(xVar.field_username)) {
                    this.kwT.kwY.setVisibility(8);
                    ((LargeTouchableAreasItemView) view2).kuu = null;
                } else {
                    if (((SelectDelRoomMemberUI) this.mContext).ipB.contains(xVar.field_username)) {
                        ((LargeTouchableAreasItemView) view2).dj(true);
                    } else {
                        ((LargeTouchableAreasItemView) view2).dj(false);
                    }
                    this.kwT.kwY.setVisibility(0);
                    str = xVar.field_username;
                    ((LargeTouchableAreasItemView) view2).kuu = new com.tencent.mm.plugin.chatroom.ui.LargeTouchableAreasItemView.a(this) {
                        final /* synthetic */ a kwU;

                        public final void dk(boolean z) {
                            if (z) {
                                ((SelectDelRoomMemberUI) this.kwU.mContext).ipB.add(str);
                            } else {
                                ((SelectDelRoomMemberUI) this.kwU.mContext).ipB.remove(str);
                            }
                            ((SelectDelRoomMemberUI) this.kwU.mContext).Ok();
                        }
                    };
                }
                b.a((ImageView) this.kwT.kwV.view, xVar.field_username);
                if (xVar.field_verifyFlag == 0) {
                    this.kwT.kwV.bSH();
                } else if (com.tencent.mm.u.ag.a.hlU != null) {
                    String eZ = com.tencent.mm.u.ag.a.hlU.eZ(xVar.field_verifyFlag);
                    if (eZ != null) {
                        this.kwT.kwV.d(l.ik(eZ), com.tencent.mm.ui.base.MaskLayout.a.vnV);
                    } else {
                        this.kwT.kwV.bSH();
                    }
                } else {
                    this.kwT.kwV.bSH();
                }
                str = SelectDelRoomMemberUI.b(this.ktr, xVar.field_username);
                if (bg.mA(xVar.field_conRemark)) {
                    Object obj = str;
                } else {
                    charSequence = xVar.field_conRemark;
                }
                if (bg.mA(charSequence)) {
                    charSequence = xVar.tK();
                }
                if (!(str == null || str.equals("") || charSequence.equals(str))) {
                    charSequence = str + "( " + charSequence + " )";
                }
                str = "";
                if (com.tencent.mm.j.a.ez(xVar.field_type)) {
                    charSequence2 = xVar.gkK;
                } else {
                    ap.yY();
                    bb AI = c.wS().AI(xVar.field_username);
                    if (AI != null) {
                        charSequence2 = AI.field_conDescription;
                        if (!bg.mA(AI.field_conRemark)) {
                            charSequence = AI.field_conRemark;
                        }
                    } else {
                        Object obj2 = str;
                    }
                }
                if (bg.mA(charSequence2)) {
                    this.kwT.kwW.setText("");
                } else {
                    this.kwT.kwW.setText(h.b(this.mContext, charSequence2, this.kwT.kwW.getTextSize()));
                }
                this.kwT.jZz.setText(h.b(this.mContext, charSequence, this.kwT.jZz.getTextSize()));
            }
            return view2;
        }

        public final int getCount() {
            return fPq.size();
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    static /* synthetic */ ArrayList a(SelectDelRoomMemberUI selectDelRoomMemberUI) {
        ArrayList arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = selectDelRoomMemberUI.ipB.iterator();
        while (it.hasNext()) {
            hashSet.add((String) it.next());
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    static /* synthetic */ void a(SelectDelRoomMemberUI selectDelRoomMemberUI, String str, String str2, String str3) {
        if (bg.mA(str2)) {
            ap.yY();
            bb AI = c.wS().AI(str);
            if (!(AI == null || bg.mA(AI.field_encryptUsername))) {
                str2 = AI.field_conRemark;
            }
        }
        if (!bg.mA(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            if (selectDelRoomMemberUI.fOg && selectDelRoomMemberUI.ktr != null) {
                intent.putExtra("Contact_RoomNickname", selectDelRoomMemberUI.ktr.eK(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", selectDelRoomMemberUI.kuR);
            ap.yY();
            af Rc = c.wR().Rc(str);
            if (Rc != null && ((int) Rc.gTQ) > 0 && com.tencent.mm.j.a.ez(Rc.field_type)) {
                com.tencent.mm.sdk.b.b nzVar = new nz();
                nzVar.fVf.intent = intent;
                nzVar.fVf.username = str;
                com.tencent.mm.sdk.b.a.urY.m(nzVar);
            }
            if (selectDelRoomMemberUI.fOg) {
                if (Rc != null && Rc.bLe()) {
                    g.oUh.A(10298, Rc.field_username + ",14");
                }
                intent.putExtra("Contact_Scene", 14);
            } else if (selectDelRoomMemberUI.ksZ) {
                intent.putExtra("Contact_Scene", 44);
                if (!m.eH(Rc.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            intent.putExtra("Contact_ChatRoomId", selectDelRoomMemberUI.kuC);
            com.tencent.mm.plugin.chatroom.a.imv.d(intent, selectDelRoomMemberUI);
        }
    }

    static /* synthetic */ String b(q qVar, String str) {
        return qVar == null ? null : qVar.eK(str);
    }

    protected final int getLayoutId() {
        return R.i.dad;
    }

    protected final void KC() {
        super.KC();
        this.kuC = getIntent().getStringExtra("RoomInfo_Id");
        this.kwv = getIntent().getStringExtra("Chatroom_member_list");
        this.fOg = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ksZ = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.kuU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.kuT = getIntent().getStringExtra("room_owner_name");
        ap.yY();
        this.ktr = c.xa().fV(this.kuC);
        this.kuS = getIntent().getIntExtra("room_member_count", 0);
        this.kwO = getIntent().getIntExtra("list_attr", s.vYN);
        this.kuR = getIntent().getStringExtra("room_name");
        qP(getString(R.l.eNg) + "(" + this.kuS + ")");
        a(1, getString(R.l.ebw), new OnMenuItemClickListener(this) {
            final /* synthetic */ SelectDelRoomMemberUI kwR;

            {
                this.kwR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.g.a(this.kwR, this.kwR.getString(R.l.eMf), "", new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 kwS;

                    {
                        this.kwS = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.putExtra("Select_Contact", bg.c(SelectDelRoomMemberUI.a(this.kwS.kwR), ","));
                        this.kwS.kwR.setResult(-1, intent);
                        this.kwS.kwR.finish();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 kwS;

                    {
                        this.kwS = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return false;
            }
        }, com.tencent.mm.ui.l.b.uTZ);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SelectDelRoomMemberUI kwR;

            {
                this.kwR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kwR.finish();
                return false;
            }
        });
        this.kwQ = (EditText) findViewById(R.h.cmc);
        this.kwQ.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SelectDelRoomMemberUI kwR;

            {
                this.kwR = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                a b = this.kwR.kwP;
                Object charSequence2 = charSequence.toString();
                b.kwE = charSequence2;
                List arrayList = new ArrayList();
                if (bg.mA(charSequence2)) {
                    a.fPq = a.kwH;
                } else {
                    for (x xVar : a.kwH) {
                        if (xVar != null) {
                            if (xVar.field_conRemark != null && xVar.field_conRemark.toUpperCase().contains(charSequence2.toUpperCase())) {
                                arrayList.add(xVar);
                            } else if (!bg.mA(SelectDelRoomMemberUI.b(b.ktr, xVar.field_username)) && SelectDelRoomMemberUI.b(b.ktr, xVar.field_username).contains(charSequence2)) {
                                arrayList.add(xVar);
                            } else if (xVar.tK() != null && xVar.tK().toUpperCase().contains(charSequence2.toUpperCase())) {
                                arrayList.add(xVar);
                            } else if (xVar.pB() != null && xVar.pB().toUpperCase().contains(charSequence2.toUpperCase())) {
                                arrayList.add(xVar);
                            } else if (xVar.pA() != null && xVar.pA().contains(charSequence2)) {
                                arrayList.add(xVar);
                            } else if (xVar.field_username != null && xVar.field_username.contains(charSequence2)) {
                                arrayList.add(xVar);
                            } else if (!com.tencent.mm.j.a.ez(xVar.field_type)) {
                                ap.yY();
                                bb AI = c.wS().AI(xVar.field_username);
                                if (!(AI == null || AI.field_conRemark == null || !AI.field_conRemark.toUpperCase().contains(charSequence2.toUpperCase()))) {
                                    arrayList.add(xVar);
                                }
                            }
                        }
                    }
                    w.i("MicroMsg.SelectDelRoomMemberUI", "--->setMemberListBySearch:search");
                    a.fPq = arrayList;
                }
                b.notifyDataSetChanged();
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.Fg = (ListView) findViewById(R.h.bzj);
        x xVar = new x();
        q qVar = this.ktr;
        String str = this.kuC;
        List linkedList = new LinkedList();
        if (!bg.mA(this.kwu)) {
            linkedList = bg.f(this.kwu.split(","));
        }
        ap.yY();
        ay AH = c.wZ().AH("@t.qq.com");
        if (AH != null) {
            linkedList.add(AH.name);
        }
        this.kwP = new a(this, qVar, str, linkedList, this.kuT);
        this.Fg.setAdapter(this.kwP);
        this.Fg.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SelectDelRoomMemberUI kwR;

            {
                this.kwR = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                af kO = a.kO(i);
                if (kO != null) {
                    this.kwR.username = kO.field_username;
                    String str = kO.field_nickname;
                    String b = SelectDelRoomMemberUI.b(this.kwR.ktr, this.kwR.username);
                    if (bg.mA(b)) {
                        this.kwR.kwx = kO.tL();
                    } else {
                        this.kwR.kwx = b;
                    }
                    SelectDelRoomMemberUI.a(this.kwR, this.kwR.username, this.kwR.kwx, str);
                }
            }
        });
        Ok();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ipB = new HashSet();
        KC();
    }

    public void onResume() {
        super.onResume();
        if (this.kwP != null) {
            ap.yY();
            this.ktr = c.xa().fV(this.kuC);
            List eA = j.eA(this.kuC);
            if (this.kwP != null) {
                this.kwP.ag(eA);
            }
        }
    }

    private void Ok() {
        if (!s.ee(this.kwO, 64) || this.ipB.size() <= 0) {
            aB(1, getString(R.l.ebw));
            ae(1, false);
            return;
        }
        aB(1, getString(R.l.ebw) + "(" + this.ipB.size() + ")");
        ae(1, true);
    }
}
