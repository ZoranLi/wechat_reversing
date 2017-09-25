package com.tencent.mm.plugin.sight.draft.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import java.util.LinkedList;

public class SightDraftUI extends MMActivity {
    private int pwB = 1;
    SightDraftContainerView pwC;
    private LinkedList<String> pwD = new LinkedList();

    static /* synthetic */ void b(SightDraftUI sightDraftUI) {
        b bVar = sightDraftUI.pwC.pwv;
        j jVar = bVar.pwj == null ? null : bVar.pwj.pwr;
        if (jVar != null) {
            String lm = k.lm(jVar.field_fileName);
            if (!sightDraftUI.pwD.contains(lm)) {
                sightDraftUI.pwD.add(lm);
                String str = e.gSz + String.format("%s%d.%s", new Object[]{"wx_camera_", Long.valueOf(System.currentTimeMillis()), "mp4"});
                w.i("MicroMsg.SightDraftUI", "save src %s dest %s ", new Object[]{lm, str});
                FileOp.p(lm, str);
                d.b(str, sightDraftUI);
                s.makeText(sightDraftUI, sightDraftUI.getString(R.l.eWH, new Object[]{e.gSz}), 1).show();
            }
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eWI);
        cO().cP().setBackgroundDrawable(getResources().getDrawable(R.e.black));
        this.pwC = new SightDraftContainerView(this);
        setContentView(this.pwC);
        this.pwC.bcE();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SightDraftUI pwE;

            {
                this.pwE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pwE.finish();
                return false;
            }
        });
        SightDraftContainerView sightDraftContainerView = this.pwC;
        a anonymousClass2 = new a(this) {
            final /* synthetic */ SightDraftUI pwE;

            {
                this.pwE = r1;
            }

            public final void bcB() {
                this.pwE.a(this.pwE.pwB, this.pwE.getString(R.l.eWC), new OnMenuItemClickListener(this) {
                    final /* synthetic */ AnonymousClass2 pwF;

                    {
                        this.pwF = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        SightDraftUI.b(this.pwF.pwE);
                        return true;
                    }
                });
            }

            public final void bcC() {
                this.pwE.zn(this.pwE.pwB);
            }
        };
        sightDraftContainerView.pwu = anonymousClass2;
        if (sightDraftContainerView.pwv != null) {
            sightDraftContainerView.pwv.pwd = anonymousClass2;
        }
    }
}
