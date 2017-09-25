package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.g.a.d;
import com.tencent.mm.x.b;
import com.tencent.mm.x.d.a;
import com.tencent.mm.x.n;

public class ShowNonWeixinFriendUI extends MMActivity implements a {
    private long vbT = 0;
    private String vbU = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.esN);
        this.vbT = getIntent().getLongExtra("Contact_KFacebookId", 0);
        this.vbU = getIntent().getStringExtra("Contact_KFacebookName");
        KC();
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
        return R.i.dce;
    }

    protected final void KC() {
        ImageView imageView = (ImageView) findViewById(R.h.bXZ);
        TextView textView = (TextView) findViewById(R.h.bYd);
        TextView textView2 = (TextView) findViewById(R.h.bYe);
        imageView.setBackgroundDrawable(com.tencent.mm.bg.a.a(this, R.k.dwt));
        imageView.setImageBitmap(b.gZ(this.vbT));
        textView.setText(this.vbU);
        textView2.setText(getString(R.l.bYe, new Object[]{this.vbU}));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShowNonWeixinFriendUI vbV;

            {
                this.vbV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vbV.aHf();
                this.vbV.finish();
                return true;
            }
        });
        ((Button) findViewById(R.h.bYc)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShowNonWeixinFriendUI vbV;

            {
                this.vbV = r1;
            }

            public final void onClick(View view) {
                c cVar = new c("290293790992170");
                Bundle bundle = new Bundle();
                bundle.putString("message", this.vbV.getString(R.l.ehh));
                bundle.putString("to", Long.toString(this.vbV.vbT));
                cVar.a(this.vbV, "apprequests", bundle, new c.a(this) {
                    final /* synthetic */ AnonymousClass2 vbW;

                    {
                        this.vbW = r1;
                    }

                    public final void a(d dVar) {
                        w.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
                    }

                    public final void a(com.tencent.mm.ui.g.a.b bVar) {
                        w.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
                    }

                    public final void m(Bundle bundle) {
                        w.i("MicroMsg.ShowNonWeixinFriendUI", "fbinvite oncomplete");
                        g.a(this.vbW.vbV.uSU.uTo, R.l.ehm, R.l.dIO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 vbX;

                            {
                                this.vbX = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.vbX.vbW.vbV.finish();
                            }
                        });
                    }

                    public final void onCancel() {
                        w.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite cancle");
                    }
                });
            }
        });
    }

    public final void ho(String str) {
        KC();
    }
}
