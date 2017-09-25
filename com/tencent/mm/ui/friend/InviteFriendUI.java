package com.tencent.mm.ui.friend;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.lh;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.x.d.a;
import com.tencent.mm.x.n;
import com.tencent.mm.y.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class InviteFriendUI extends MMActivity implements a {
    private ImageView hBi;
    private String wgP;
    private int wgQ;
    private String wgR;
    private String wgS;
    private String wgT;
    private Button wgU;
    private int wgV;
    private int wgW;
    private String wgX = null;
    private String wgY = null;

    static /* synthetic */ void c(InviteFriendUI inviteFriendUI) {
        if (inviteFriendUI.wgV > 0 && inviteFriendUI.wgW > 0) {
            g.oUh.i(10991, Integer.valueOf(inviteFriendUI.wgV), Integer.valueOf(7), Integer.valueOf(inviteFriendUI.wgW));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.esN);
        Intent intent = getIntent();
        this.wgQ = intent.getIntExtra("friend_type", -1);
        this.wgR = intent.getStringExtra("friend_nick");
        this.wgP = intent.getStringExtra("friend_num");
        this.wgS = intent.getStringExtra("friend_googleID");
        this.wgT = intent.getStringExtra("friend_googleItemID");
        this.wgP = bg.mz(this.wgP);
        this.wgX = intent.getStringExtra("friend_linkedInID");
        this.wgY = intent.getStringExtra("friend_linkedInPicUrl");
        KC();
        this.wgV = intent.getIntExtra("search_kvstat_scene", 0);
        this.wgW = intent.getIntExtra("search_kvstat_position", 0);
    }

    protected void onPause() {
        super.onPause();
        n.Bl().e(this);
    }

    protected void onResume() {
        super.onResume();
        n.Bl().d(this);
    }

    protected final int getLayoutId() {
        return R.i.dfN;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void KC() {
        Bitmap bitmap = null;
        this.hBi = (ImageView) findViewById(R.h.bXZ);
        TextView textView = (TextView) findViewById(R.h.bYd);
        TextView textView2 = (TextView) findViewById(R.h.bYf);
        TextView textView3 = (TextView) findViewById(R.h.bYe);
        this.wgU = (Button) findViewById(R.h.bYc);
        Button button = (Button) findViewById(R.h.bYg);
        textView.setText(this.wgR);
        textView3.setText(getString(R.l.bYe, new Object[]{this.wgR}));
        if (this.wgQ == 1) {
            Bitmap a;
            this.hBi.setBackgroundDrawable(com.tencent.mm.bg.a.a(this, R.k.dwt));
            textView2.setText(getString(R.l.dHb) + this.wgP);
            String n = com.tencent.mm.a.g.n(this.wgP.getBytes());
            ap.yY();
            if (c.isSDCardAvailable()) {
                b ja = af.FY().ja(n);
                a = ja != null ? m.a(ja.EQ(), this) : null;
            } else {
                a = n.Bl().aS(ab.getContext());
            }
            if (a != null) {
                this.hBi.setImageBitmap(a);
            } else {
                this.hBi.setImageDrawable(com.tencent.mm.bg.a.a(this, R.k.dwt));
            }
        }
        if (this.wgQ == 0) {
            this.hBi.setBackgroundDrawable(com.tencent.mm.bg.a.a(this, R.k.dwu));
            textView2.setText(getString(R.l.dHd) + this.wgP);
            long aY = (long) o.aY(this.wgP);
            if (aY != 0) {
                bitmap = com.tencent.mm.x.b.Q(aY);
            }
            if (bitmap == null) {
                this.hBi.setImageDrawable(com.tencent.mm.bg.a.a(this, R.k.dwu));
            } else {
                this.hBi.setImageBitmap(bitmap);
            }
            button.setVisibility(0);
        }
        if (this.wgQ == 2) {
            Bitmap gW;
            this.wgU.setText(R.l.epV);
            this.hBi.setBackgroundDrawable(com.tencent.mm.bg.a.a(this, R.g.bet));
            textView2.setText(getString(R.l.dGW) + this.wgP);
            ap.yY();
            if (c.isSDCardAvailable()) {
                gW = com.tencent.mm.x.b.gW(this.wgS);
            } else {
                gW = n.Bl().aS(ab.getContext());
            }
            if (gW != null) {
                this.hBi.setImageBitmap(gW);
            } else {
                this.hBi.setImageDrawable(com.tencent.mm.bg.a.a(this, R.g.bet));
            }
            if (TextUtils.isEmpty(this.wgR)) {
                textView.setText(bg.Qi(this.wgP));
                textView3.setText(getString(R.l.bYe, new Object[]{bg.Qi(this.wgP)}));
            }
        }
        if (this.wgQ == 3) {
            this.wgU.setText(R.l.esM);
            Bitmap a2 = j.a(new d(this.wgY, this.wgY));
            if (a2 != null) {
                this.hBi.setImageBitmap(a2);
            } else {
                this.hBi.setImageResource(R.k.bes);
            }
            button.setVisibility(8);
        }
        this.wgU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InviteFriendUI wgZ;

            {
                this.wgZ = r1;
            }

            public final void onClick(View view) {
                final String string;
                switch (this.wgZ.wgQ) {
                    case 0:
                        new g(this.wgZ, new g.a(this) {
                            final /* synthetic */ AnonymousClass1 whc;

                            {
                                this.whc = r1;
                            }

                            public final void k(boolean z, String str) {
                                if (z) {
                                    this.whc.wgZ.finish();
                                }
                            }
                        }).r(new int[]{o.aY(this.wgZ.wgP)});
                        return;
                    case 1:
                        ap.yY();
                        String str = (String) c.vr().get(42, (Object) "");
                        if (str == null || str.length() == 0) {
                            ap.yY();
                            str = (String) c.vr().get(2, (Object) "");
                        }
                        string = this.wgZ.getString(R.l.esZ, new Object[]{str});
                        final Uri parse = Uri.parse("smsto:" + this.wgZ.wgP);
                        Intent intent = new Intent("android.intent.action.SENDTO", parse);
                        intent.putExtra("sms_body", string);
                        final PackageManager packageManager = this.wgZ.getPackageManager();
                        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                        final HashMap hashMap = new HashMap();
                        for (ResolveInfo resolveInfo : queryIntentActivities) {
                            if (!resolveInfo.activityInfo.packageName.equals("com.whatsapp")) {
                                hashMap.put(resolveInfo.activityInfo.name, resolveInfo);
                            }
                        }
                        if (hashMap.size() == 1) {
                            Iterator it = hashMap.keySet().iterator();
                            if (it.hasNext()) {
                                str = (String) it.next();
                                Intent intent2 = new Intent();
                                intent2.setComponent(new ComponentName(((ResolveInfo) hashMap.get(str)).activityInfo.packageName, ((ResolveInfo) hashMap.get(str)).activityInfo.name));
                                intent2.setAction("android.intent.action.SENDTO");
                                intent2.setData(parse);
                                intent2.putExtra("sms_body", string);
                                this.wgZ.startActivity(intent2);
                                InviteFriendUI.c(this.wgZ);
                                return;
                            }
                            return;
                        } else if (hashMap.size() > 1) {
                            l lVar = new l(this.wgZ);
                            lVar.wnf = new com.tencent.mm.ui.base.n.a(this) {
                                final /* synthetic */ AnonymousClass1 whc;

                                public final void a(ImageView imageView, MenuItem menuItem) {
                                    imageView.setImageDrawable(((ResolveInfo) hashMap.get(menuItem.getTitle())).loadIcon(packageManager));
                                }
                            };
                            lVar.wng = new com.tencent.mm.ui.base.n.b(this) {
                                final /* synthetic */ AnonymousClass1 whc;

                                public final void a(TextView textView, MenuItem menuItem) {
                                    textView.setText(((ResolveInfo) hashMap.get(menuItem.getTitle())).loadLabel(packageManager).toString());
                                }
                            };
                            lVar.qJf = new com.tencent.mm.ui.base.n.c(this) {
                                final /* synthetic */ AnonymousClass1 whc;

                                public final void a(com.tencent.mm.ui.base.l lVar) {
                                    for (CharSequence add : hashMap.keySet()) {
                                        lVar.add(add);
                                    }
                                }
                            };
                            lVar.qJg = new com.tencent.mm.ui.base.n.d(this) {
                                final /* synthetic */ AnonymousClass1 whc;

                                public final void c(MenuItem menuItem, int i) {
                                    String str = menuItem.getTitle();
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName(((ResolveInfo) hashMap.get(str)).activityInfo.packageName, ((ResolveInfo) hashMap.get(str)).activityInfo.name));
                                    intent.setAction("android.intent.action.SENDTO");
                                    intent.setData(parse);
                                    intent.putExtra("sms_body", string);
                                    this.whc.wgZ.startActivity(intent);
                                }
                            };
                            lVar.blb();
                            InviteFriendUI.c(this.wgZ);
                            return;
                        } else {
                            Toast.makeText(this.wgZ, R.l.eQE, 1).show();
                            return;
                        }
                    case 2:
                        e hVar = new h(this.wgZ, new h.a(this) {
                            final /* synthetic */ AnonymousClass1 whc;

                            {
                                this.whc = r1;
                            }

                            public final void lC(boolean z) {
                                if (z) {
                                    af.Gg().x(this.whc.wgZ.wgT, 1);
                                }
                            }
                        });
                        String e = this.wgZ.wgS;
                        string = this.wgZ.wgP;
                        ap.vd().a(489, hVar);
                        Cursor ji = af.Gg().ji(e);
                        if (ji == null || ji.getCount() <= 1) {
                            hVar.Ue(string);
                        } else {
                            hVar.j(ji);
                        }
                        if (ji != null) {
                            ji.close();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InviteFriendUI wgZ;

            {
                this.wgZ = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.sdk.b.b lhVar = new lh();
                lhVar.fSb.opType = 0;
                lhVar.fSb.fSd = this.wgZ.wgP + "@qqim";
                lhVar.fSb.fSe = this.wgZ.wgR;
                com.tencent.mm.sdk.b.a.urY.m(lhVar);
                if (lhVar.fSc.fFj) {
                    com.tencent.mm.plugin.c.a.imv.e(new Intent().putExtra("Chat_User", this.wgZ.wgP + "@qqim"), this.wgZ);
                }
                this.wgZ.finish();
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteFriendUI wgZ;

            {
                this.wgZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.wgZ.finish();
                return true;
            }
        });
    }

    public final void ho(String str) {
        if (this.wgP != null && !this.wgP.equals("")) {
            long hb = com.tencent.mm.x.b.hb(str);
            if (hb > 0 && this.wgP.equals(String.valueOf(hb)) && this.wgQ == 0) {
                this.hBi.setImageBitmap(com.tencent.mm.x.b.a(str, false, -1));
            }
        }
    }
}
