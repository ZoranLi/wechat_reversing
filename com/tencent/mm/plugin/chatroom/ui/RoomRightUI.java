package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.d.j;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class RoomRightUI extends MMPreference implements e {
    private f isJ;
    private ProgressDialog isv = null;
    private String kvw = "";
    private int kvx = 0;

    static /* synthetic */ void a(RoomRightUI roomRightUI, LinkedList linkedList) {
        int i = 0;
        Assert.assertTrue(linkedList.size() > 0);
        LinkedList linkedList2 = new LinkedList();
        while (i < linkedList.size()) {
            linkedList2.add(Integer.valueOf(3));
            i++;
        }
        new m(roomRightUI, new a(roomRightUI) {
            final /* synthetic */ RoomRightUI kvy;

            {
                this.kvy = r1;
            }

            public final void dl(boolean z) {
            }
        }).g(linkedList, linkedList2);
    }

    public final int ON() {
        return R.o.ftW;
    }

    private void ajx() {
        ap.yY();
        int a = bg.a((Integer) c.vr().get(135175, null), 0);
        Preference Td = this.isJ.Td("settings_room_size");
        if (Td != null && a > 0) {
            Td.setSummary(getResources().getQuantityString(R.j.dsC, a, new Object[]{Integer.valueOf(a)}));
            Td.setEnabled(false);
        } else if (Td != null) {
            this.isJ.c(Td);
        }
        this.isJ.Td("room_right_max_tip").setTitle(getString(R.l.eMX, new Object[]{Integer.valueOf(a)}));
        ap.yY();
        int a2 = bg.a((Integer) c.vr().get(135176, null), 0);
        RoomGrantPreference roomGrantPreference = (RoomGrantPreference) this.isJ.Td("settings_room_grant");
        if (roomGrantPreference != null && a2 <= 0) {
            this.isJ.c(roomGrantPreference);
        } else if (roomGrantPreference != null) {
            roomGrantPreference.setEnabled(false);
            CharSequence charSequence = getString(R.l.eMZ, new Object[]{Integer.valueOf(a2)});
            roomGrantPreference.kvq = charSequence;
            if (roomGrantPreference.kvp != null) {
                roomGrantPreference.kvp.setText(charSequence);
            }
        }
        Preference Td2 = this.isJ.Td("room_right_tip");
        Preference Td3 = this.isJ.Td("room_right_grant_tip");
        if (a2 <= 0) {
            if (Td2 != null) {
                this.isJ.c(Td2);
            }
            if (Td3 != null) {
                this.isJ.c(Td3);
            }
            Preference Td4 = this.isJ.Td("room_grant_to_friend");
            if (Td4 != null) {
                this.isJ.c(Td4);
            }
            if (roomGrantPreference != null) {
                this.isJ.c(roomGrantPreference);
                return;
            }
            return;
        }
        CharSequence string = getString(R.l.eNa, new Object[]{Integer.valueOf(a2), Integer.valueOf(a)});
        if (Td2 != null) {
            Td2.setTitle(string);
        }
        string = getString(R.l.eMW, new Object[]{Integer.valueOf(this.kvx)});
        if (Td3 != null) {
            Td3.setTitle(string);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.yY();
        this.kvx = bg.a((Integer) c.vr().get(135177, null), 0);
        ap.vd().a(339, this);
        ap.vd().a(30, this);
        ap.yY();
        c.vr().set(135184, Boolean.valueOf(false));
        KC();
    }

    public void onResume() {
        super.onResume();
        ajx();
        this.isJ.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.igL.equals("room_grant_to_friend")) {
            Intent intent = new Intent();
            intent.setClassName(ab.getPackageName(), ab.getPackageName() + ".ui.contact.SelectContactUI");
            intent.putExtra("Contact_GroupFilter_Type", "@all.contact.without.chatroom");
            intent.putExtra("List_Type", 4);
            intent.putExtra("select_contact_pick_result", true);
            List linkedList = new LinkedList();
            linkedList.add("officialaccounts");
            intent.putExtra("Block_list", bg.c(linkedList, ","));
            intent.putExtra("Add_SendCard", true);
            intent.putExtra("is_multi_select", false);
            startActivityForResult(intent, 1);
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        ap.vd().b(339, this);
        ap.vd().b(30, this);
    }

    protected final void KC() {
        this.isJ = this.vrv;
        zi(R.l.eTV);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomRightUI kvy;

            {
                this.kvy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kvy.aHf();
                this.kvy.finish();
                return true;
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.RoomRightUI", "onAcvityResult requestCode: %d", new Object[]{Integer.valueOf(i)});
        if (i2 == -1 && intent != null) {
            switch (i) {
                case 1:
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    w.d("MicroMsg.RoomRightUI", "pick user %s", new Object[]{stringExtra});
                    if (!bg.mA(stringExtra)) {
                        this.kvw = stringExtra;
                        stringExtra = this.kvw;
                        ap.yY();
                        com.tencent.mm.j.a Rc = c.wR().Rc(stringExtra);
                        g.a(this.uSU.uTo, getString(R.l.eMw, new Object[]{Rc.tL(), Integer.valueOf(this.kvx)}), "", new OnClickListener(this) {
                            final /* synthetic */ RoomRightUI kvy;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                final k jVar = new j(stringExtra);
                                RoomRightUI roomRightUI = this.kvy;
                                Context context = this.kvy;
                                this.kvy.getString(R.l.dIO);
                                roomRightUI.isv = g.a(context, "", true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass2 kvB;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ap.vd().c(jVar);
                                    }
                                });
                                ap.vd().a(jVar, 0);
                            }
                        }, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void G(final LinkedList<String> linkedList) {
        Assert.assertTrue(linkedList.size() > 0);
        String string = ab.getContext().getString(R.l.dTc);
        linkedList.size();
        int i = R.l.eMY;
        Object[] objArr = new Object[1];
        List linkedList2 = new LinkedList();
        if (ap.zb() && linkedList != null) {
            for (String eK : linkedList) {
                linkedList2.add(n.eK(eK));
            }
        }
        objArr[0] = bg.c(linkedList2, string);
        g.a(this, getString(i, objArr), getString(R.l.dIO), new OnClickListener(this) {
            final /* synthetic */ RoomRightUI kvy;

            public final void onClick(DialogInterface dialogInterface, int i) {
                RoomRightUI.a(this.kvy, linkedList);
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.RoomRightUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.isv != null) {
            this.isv.dismiss();
        }
        if (kVar.getType() == 339) {
            String str2;
            ap.yY();
            com.tencent.mm.j.a Rc = c.wR().Rc(this.kvw);
            if (Rc == null || ((int) Rc.gTQ) == 0) {
                str2 = this.kvw;
            } else {
                str2 = Rc.tL();
            }
            if (i == 0 && i2 == 0) {
                g.b(this, getString(R.l.eMz, new Object[]{str2}), getString(R.l.dIO), true);
                if (this.isJ != null) {
                    ajx();
                    this.isJ.notifyDataSetChanged();
                }
            } else if (i2 == -251) {
                g.b(this, getString(R.l.eMx, new Object[]{str2, Integer.valueOf(this.kvx)}), getString(R.l.dIO), true);
            } else if (i2 == -44) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.kvw);
                G(linkedList);
            } else if (i2 == -22) {
                g.b(this, getString(R.l.eMy, new Object[]{str2}), getString(R.l.dIO), true);
            } else {
                Toast.makeText(this, "err :" + i + " ," + i2, 0).show();
            }
        }
    }
}
