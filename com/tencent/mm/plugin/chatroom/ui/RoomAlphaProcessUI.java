package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.d.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.k;

@a(3)
@Deprecated
public class RoomAlphaProcessUI extends MMActivity implements a {
    private String chatroomName;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        k oVar = new o(this.chatroomName);
        ap.vd().a(482, new com.tencent.mm.plugin.chatroom.ui.a.AnonymousClass2(false, g.a(this, getString(R.l.cbS), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        }), this, this));
        ap.vd().a(oVar, 0);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void KC() {
    }

    public final int getLayoutId() {
        return -1;
    }

    private static void r(Runnable runnable) {
        new ae().postDelayed(runnable, 200);
    }

    public final void g(final boolean z, final int i) {
        if (z) {
            g.bl(this, getString(R.l.eNB));
            r(new Runnable(this) {
                final /* synthetic */ RoomAlphaProcessUI kuM;

                public final void run() {
                    Intent intent = new Intent(this.kuM, RoomUpgradeUI.class);
                    intent.setFlags(603979776);
                    intent.putExtra("room_name", this.kuM.chatroomName);
                    intent.putExtra("upgrade_success", z);
                    intent.putExtra("left_quota", i);
                    this.kuM.startActivity(intent);
                }
            });
            return;
        }
        g.a(this, getString(R.l.eNA), "", null);
        r(new Runnable(this) {
            final /* synthetic */ RoomAlphaProcessUI kuM;

            public final void run() {
                Intent intent = new Intent(this.kuM, RoomUpgradeUI.class);
                intent.setFlags(603979776);
                intent.putExtra("room_name", this.kuM.chatroomName);
                intent.putExtra("upgrade_success", z);
                this.kuM.startActivity(intent);
            }
        });
    }
}
