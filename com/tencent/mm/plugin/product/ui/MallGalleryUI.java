package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import java.util.List;

@a(3)
public class MallGalleryUI extends MallBaseUI {
    private final String TAG = "MicroMsg.MallGalleryUI";
    private ViewPager oqB;
    private g oqC;
    private List<String> oqD;
    private int oqE = 0;
    private boolean oqF;

    static /* synthetic */ void c(MallGalleryUI mallGalleryUI) {
        mallGalleryUI.oqF = !mallGalleryUI.oqF;
        if (mallGalleryUI.oqF) {
            mallGalleryUI.bPW();
        } else {
            mallGalleryUI.uSU.bQg();
        }
    }

    protected final int getLayoutId() {
        return R.i.dkV;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oqD = getIntent().getStringArrayListExtra("keys_img_urls");
        this.uSU.bQg();
        this.oqF = false;
        KC();
    }

    protected void onResume() {
        super.onResume();
        this.oqC.ai(this.oqD);
        this.oqC.notifyDataSetChanged();
        if (this.oqD != null) {
            this.oqD.size();
        }
    }

    protected final void KC() {
        this.oqB = (ViewPager) findViewById(R.h.che);
        this.oqB.zb = new e(this) {
            final /* synthetic */ MallGalleryUI oqG;

            {
                this.oqG = r1;
            }

            public final void V(int i) {
                w.d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", new Object[]{Integer.valueOf(i)});
                this.oqG.oqE = i;
                if (this.oqG.oqF) {
                    this.oqG.uSU.bQg();
                    this.oqG.oqF = false;
                }
            }

            public final synchronized void a(int i, float f, int i2) {
            }

            public final void W(int i) {
            }
        };
        this.oqC = new g(this);
        this.oqC.orc = new g.a(this) {
            final /* synthetic */ MallGalleryUI oqG;

            {
                this.oqG = r1;
            }

            public final void aTo() {
                MallGalleryUI.c(this.oqG);
            }
        };
        this.oqB.a(this.oqC);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MallGalleryUI oqG;

            {
                this.oqG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oqG.finish();
                return false;
            }
        });
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ MallGalleryUI oqG;

            {
                this.oqG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] stringArray;
                if (d.Jt("favorite")) {
                    stringArray = this.oqG.getResources().getStringArray(R.c.aSf);
                } else {
                    stringArray = this.oqG.getResources().getStringArray(R.c.aSg);
                }
                g.a(this.oqG.uSU.uTo, null, stringArray, null, false, new c(this) {
                    final /* synthetic */ AnonymousClass4 oqH;

                    {
                        this.oqH = r1;
                    }

                    public final void hq(int i) {
                        Context context;
                        String aTn;
                        switch (i) {
                            case 0:
                                context = this.oqH.oqG;
                                Intent intent = new Intent();
                                intent.putExtra("Retr_Msg_content", "");
                                intent.putExtra("Retr_Msg_Type", 0);
                                if (bg.mA(context.aTn())) {
                                    w.e("MicroMsg.MallGalleryUI", "url is null or nil");
                                    return;
                                }
                                intent.putExtra("Retr_File_Name", context.aTn());
                                intent.putExtra("Retr_go_to_chattingUI", false);
                                intent.putExtra("Retr_show_success_tips", true);
                                d.a(context, ".ui.transmit.MsgRetransmitUI", intent);
                                return;
                            case 1:
                                context = this.oqH.oqG;
                                aTn = context.aTn();
                                if (bg.mA(aTn)) {
                                    w.w("MicroMsg.MallGalleryUI", "save error.");
                                    return;
                                }
                                w.d("MicroMsg.MallGalleryUI", "can save. img path: %s", new Object[]{aTn});
                                k.h(aTn, context);
                                return;
                            case 2:
                                Activity activity = this.oqH.oqG;
                                aTn = activity.aTn();
                                if (bg.mA(aTn)) {
                                    w.w("MicroMsg.MallGalleryUI", "file path invalid");
                                    return;
                                }
                                w.d("MicroMsg.MallGalleryUI", "file path valid");
                                b cbVar = new cb();
                                com.tencent.mm.pluginsdk.model.e.a(cbVar, 9, aTn);
                                cbVar.fFA.fFH = 4;
                                cbVar.fFA.activity = activity;
                                com.tencent.mm.sdk.b.a.urY.m(cbVar);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
    }

    final String aTn() {
        String str;
        if (this.oqD == null || this.oqD.size() < this.oqE + 1) {
            w.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
            str = null;
        } else {
            str = (String) this.oqD.get(this.oqE);
        }
        if (!bg.mA(str)) {
            return c.CA(str);
        }
        w.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
        return null;
    }
}
