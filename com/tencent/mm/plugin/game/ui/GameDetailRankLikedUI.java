package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.at;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.c.cl;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class GameDetailRankLikedUI extends MMActivity {
    private static final String TAG = ("MicroMsg" + GameDetailRankLikedUI.class.getSimpleName());
    private Dialog jjI;
    private ListView mzg;
    private a mzh;

    private static class a extends BaseAdapter {
        private Context mContext;
        List<cl> mzj = new LinkedList();

        private static class a {
            public ImageView hBi;
            public TextView jkj;
            public TextView mzk;
        }

        public final /* synthetic */ Object getItem(int i) {
            return nH(i);
        }

        public a(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            return this.mzj.size();
        }

        private cl nH(int i) {
            return (cl) this.mzj.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.i.dez, viewGroup, false);
                a aVar2 = new a();
                aVar2.hBi = (ImageView) view.findViewById(R.h.bTF);
                aVar2.jkj = (TextView) view.findViewById(R.h.bTG);
                aVar2.mzk = (TextView) view.findViewById(R.h.bTH);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            cl nH = nH(i);
            b.a(aVar.hBi, nH.mvV, 0.5f, false);
            ap.yY();
            x Rc = c.wR().Rc(nH.mvV);
            if (Rc != null) {
                aVar.jkj.setText(new SpannableString(h.b(this.mContext, Rc.tL(), aVar.jkj.getTextSize())));
            } else {
                aVar.jkj.setText("");
            }
            aVar.mzk.setText(nH.mvW);
            return view;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        String stringExtra = getIntent().getStringExtra("extra_appdi");
        if (bg.mA(stringExtra)) {
            finish();
            return;
        }
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new at();
        aVar.hsn = new au();
        aVar.uri = "/cgi-bin/mmgame-bin/getuplist";
        aVar.hsl = 1331;
        com.tencent.mm.y.b BE = aVar.BE();
        ((at) BE.hsj.hsr).msh = stringExtra;
        u.a(BE, new com.tencent.mm.y.u.a(this) {
            final /* synthetic */ GameDetailRankLikedUI mzi;

            {
                this.mzi = r1;
            }

            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                if (i == 0 && i2 == 0) {
                    au auVar = (au) bVar.hsk.hsr;
                    a a = this.mzi.mzh;
                    Collection collection = auVar.muH;
                    if (collection != null) {
                        a.mzj.clear();
                        a.mzj.addAll(collection);
                        a.notifyDataSetChanged();
                    }
                    this.mzi.jjI.dismiss();
                } else {
                    w.e(GameDetailRankLikedUI.TAG, "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    this.mzi.finish();
                }
                return 0;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dey;
    }

    protected final void KC() {
        zi(R.l.eoz);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameDetailRankLikedUI mzi;

            {
                this.mzi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mzi.finish();
                return true;
            }
        });
        this.mzg = (ListView) findViewById(R.h.bTI);
        this.mzh = new a(this);
        this.mzg.setAdapter(this.mzh);
        this.jjI = com.tencent.mm.plugin.game.d.c.cm(this.uSU.uTo);
        this.jjI.show();
    }
}
