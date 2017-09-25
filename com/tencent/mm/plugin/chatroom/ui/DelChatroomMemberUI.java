package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI extends MMActivity implements e {
    private ListView Fg;
    private String chatroomName;
    private p irJ;
    private q ktr;
    private a kuj;
    private LinkedList<String> kuk = new LinkedList();
    private int scene;

    class a extends BaseAdapter {
        final /* synthetic */ DelChatroomMemberUI kul;
        List<x> kum = new LinkedList();

        a(DelChatroomMemberUI delChatroomMemberUI) {
            this.kul = delChatroomMemberUI;
        }

        public final void af(List<String> list) {
            Object obj = null;
            for (String str : list) {
                Object obj2;
                for (Object obj3 : this.kum) {
                    if (obj3.field_username.equals(str)) {
                        break;
                    }
                }
                Object obj32 = null;
                if (obj32 != null) {
                    obj2 = 1;
                    this.kum.remove(obj32);
                } else {
                    obj2 = obj;
                }
                obj = obj2;
            }
            if (obj != null) {
                notifyDataSetChanged();
            }
        }

        public final int getCount() {
            return this.kum.size();
        }

        public final Object getItem(int i) {
            return this.kum.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = View.inflate(this.kul, R.i.cXl, null);
                bVar = new b(this.kul);
                bVar.ipv = (ImageView) view.findViewById(R.h.bzf);
                bVar.jWd = (TextView) view.findViewById(R.h.bzg);
                bVar.kuq = (TextView) view.findViewById(R.h.bze);
                bVar.kuq.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a kun;

                    {
                        this.kun = r1;
                    }

                    public final void onClick(View view) {
                        final x xVar = (x) this.kun.getItem(((Integer) view.getTag()).intValue());
                        g.a(this.kun.kul, this.kun.kul.getString(R.l.eMg, new Object[]{this.kun.c(xVar)}), null, this.kun.kul.getString(R.l.eMn), this.kun.kul.getString(R.l.dGs), true, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 kup;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                DelChatroomMemberUI.a(this.kup.kun.kul, xVar.field_username);
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 kup;

                            {
                                this.kup = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                });
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.kuq.setTag(Integer.valueOf(i));
            x xVar = (x) getItem(i);
            CharSequence c = c(xVar);
            bVar.jWd.setText(c);
            h.b(this.kul, c, bVar.jWd.getTextSize());
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.ipv, xVar.field_username);
            return view;
        }

        public final String c(x xVar) {
            String b;
            if (bg.mA(xVar.field_conRemark)) {
                b = DelChatroomMemberUI.b(this.kul, xVar.field_username);
            } else {
                b = xVar.field_conRemark;
            }
            if (bg.mA(b)) {
                b = xVar.field_conRemark;
            }
            if (bg.mA(b)) {
                return xVar.tK();
            }
            return b;
        }
    }

    class b {
        public ImageView ipv;
        public TextView jWd;
        final /* synthetic */ DelChatroomMemberUI kul;
        public TextView kuq;

        b(DelChatroomMemberUI delChatroomMemberUI) {
            this.kul = delChatroomMemberUI;
        }
    }

    static /* synthetic */ void a(DelChatroomMemberUI delChatroomMemberUI, String str) {
        if (str != null && !str.equals("")) {
            List linkedList = new LinkedList();
            linkedList.add(str);
            final k gVar = new com.tencent.mm.plugin.chatroom.d.g(delChatroomMemberUI.chatroomName, linkedList, delChatroomMemberUI.scene);
            delChatroomMemberUI.getString(R.l.dIO);
            delChatroomMemberUI.irJ = g.a(delChatroomMemberUI, delChatroomMemberUI.getString(R.l.eMd), true, new OnCancelListener(delChatroomMemberUI) {
                final /* synthetic */ DelChatroomMemberUI kul;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(gVar);
                }
            });
            ap.vd().a(gVar, 0);
        }
    }

    static /* synthetic */ String b(DelChatroomMemberUI delChatroomMemberUI, String str) {
        return delChatroomMemberUI.ktr == null ? null : delChatroomMemberUI.ktr.eK(str);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        ap.vd().a(179, this);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        this.scene = getIntent().getIntExtra("scene", 0);
        String[] split = getIntent().getStringExtra("members").split(",");
        int length = split.length;
        while (i < length) {
            this.kuk.add(split[i]);
            i++;
        }
        ap.yY();
        this.ktr = c.xa().fV(this.chatroomName);
        KC();
    }

    public void onDestroy() {
        ap.vd().b(179, this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
    }

    protected final void KC() {
        zi(R.l.eMq);
        this.Fg = (ListView) findViewById(R.h.cjG);
        this.kuj = new a(this);
        a aVar = this.kuj;
        List<String> list = this.kuk;
        if (list != null) {
            w.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", new Object[]{Integer.valueOf(list.size())});
            aVar.kum.clear();
            for (String str : list) {
                ap.yY();
                af Rc = c.wR().Rc(str);
                if (!(Rc == null || bg.mA(Rc.field_username) || !Rc.field_username.equals(str))) {
                    aVar.kum.add(Rc);
                }
            }
        }
        this.Fg.setAdapter(this.kuj);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ DelChatroomMemberUI kul;

            {
                this.kul = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kul.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.cXm;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.irJ != null) {
            this.irJ.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (i == 0 && i2 == 0) {
                g.bl(this, getString(R.l.eMo));
                this.kuj.af(((com.tencent.mm.plugin.chatroom.d.g) kVar).fPq);
                this.Fg.post(new Runnable(this) {
                    final /* synthetic */ DelChatroomMemberUI kul;

                    {
                        this.kul = r1;
                    }

                    public final void run() {
                        if (this.kul.kuj.getCount() == 0) {
                            this.kul.finish();
                        }
                    }
                });
            }
        } else if (i2 == -2024) {
            com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
            if (dn != null) {
                dn.a(this, null, null);
            } else {
                g.a(this.uSU.uTo, getString(R.l.eMl), null, getString(R.l.eMm), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ DelChatroomMemberUI kul;

                    {
                        this.kul = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        } else {
            g.a(this, getString(R.l.eMu), null, getString(R.l.dHT), false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ DelChatroomMemberUI kul;

                {
                    this.kul = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }
}
