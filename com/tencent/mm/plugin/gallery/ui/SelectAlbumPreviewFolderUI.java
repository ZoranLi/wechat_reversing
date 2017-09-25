package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(19)
public class SelectAlbumPreviewFolderUI extends MMActivity implements com.tencent.mm.plugin.gallery.model.g.a {
    ArrayList<AlbumItem> mgB = new ArrayList(0);
    private a mio;
    private RecyclerView mip;
    AlbumItem miq;
    private String mir;

    class a extends android.support.v7.widget.RecyclerView.a<b> implements OnClickListener {
        Context mContext;
        final /* synthetic */ SelectAlbumPreviewFolderUI mis;

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            return new b(this.mis, LayoutInflater.from(this.mContext).inflate(R.i.dnf, viewGroup, false));
        }

        public final /* synthetic */ void a(t tVar, int i) {
            b bVar = (b) tVar;
            SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI = this.mis;
            AlbumItem albumItem = i == 0 ? selectAlbumPreviewFolderUI.miq : (AlbumItem) selectAlbumPreviewFolderUI.mgB.get(i - 1);
            bVar.mil.setOnClickListener(this);
            bVar.mil.setTag(albumItem);
            if (this.mis.mir == null || !(this.mis.mir.equals(albumItem.meC) || (this.mis.mir.equals(SelectAlbumPreviewFolderUI.d(this.mis)) && i == 0))) {
                bVar.mgG.setVisibility(4);
            } else {
                bVar.mgG.setVisibility(0);
            }
            if (i == 0) {
                bVar.mfz.setImageResource(R.g.bir);
                if (albumItem.meD != null) {
                    h.a(bVar.mfz, albumItem.meD.getType(), albumItem.ayB(), albumItem.meD.hTf, albumItem.ayC());
                }
                bVar.ipx.setText(SelectAlbumPreviewFolderUI.d(this.mis));
                bVar.mfz.setVisibility(0);
                bVar.ipx.setVisibility(0);
                bVar.mgF.setVisibility(8);
                return;
            }
            bVar.mfz.setVisibility(0);
            bVar.ipx.setVisibility(0);
            bVar.ipx.setText(albumItem.meC);
            bVar.mgF.setVisibility(0);
            bVar.mgF.setText(this.mContext.getString(R.l.enC, new Object[]{Integer.valueOf(albumItem.fIM)}));
            if (!(bVar.lNl == null || albumItem.meD == null)) {
                bVar.lNl.setVisibility(albumItem.meD.getType() == 2 ? 0 : 8);
            }
            String ayB = albumItem.ayB();
            if (!bg.mA(ayB) && albumItem.meD != null) {
                h.a(bVar.mfz, albumItem.meD.getType(), ayB, albumItem.meD.hTf, albumItem.ayC());
            } else if (albumItem.meD == null || albumItem.meD.getType() != 2) {
                w.e("MicroMsg.SelectAlbumPreviewFolderUI", "get folder failed");
                bVar.mfz.setVisibility(8);
                bVar.ipx.setVisibility(8);
            } else {
                h.a(bVar.mfz, albumItem.meD.getType(), null, albumItem.meD.hTf, albumItem.ayC());
            }
        }

        public a(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI, Context context) {
            this.mis = selectAlbumPreviewFolderUI;
            this.mContext = context;
        }

        public final int getItemCount() {
            return this.mis.mgB.size() + 1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.mis, AlbumPreviewUI.class);
            intent.putExtra("select_folder_name", (AlbumItem) view.getTag());
            intent.setFlags(67108864);
            this.mis.setResult(-1, intent);
            this.mis.finish();
        }
    }

    class b extends t {
        public TextView ipx = ((TextView) this.mil.findViewById(R.h.bQM));
        public ImageView lNl = ((ImageView) this.mil.findViewById(R.h.cLU));
        public ImageView mfz = ((ImageView) this.mil.findViewById(R.h.bQP));
        public TextView mgF = ((TextView) this.mil.findViewById(R.h.bQL));
        public ImageView mgG = ((ImageView) this.mil.findViewById(R.h.bQO));
        public View mil;
        final /* synthetic */ SelectAlbumPreviewFolderUI mis;

        public b(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI, View view) {
            this.mis = selectAlbumPreviewFolderUI;
            super(view);
            this.mil = view;
        }
    }

    static /* synthetic */ String d(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI) {
        if (c.ayk().ayN() == 1) {
            return selectAlbumPreviewFolderUI.getString(R.l.ent);
        }
        return c.ayk().ayN() == 3 ? selectAlbumPreviewFolderUI.getString(R.l.enu) : selectAlbumPreviewFolderUI.getString(R.l.env);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.ayk().b(this);
        c.ayk().a(this);
        c.ayk().ayO();
        this.mip = (RecyclerView) findViewById(R.h.bQN);
        this.mio = new a(this, this);
        this.mip.a(new LinearLayoutManager());
        this.mip.a(this.mio);
        this.mir = getIntent().getStringExtra("select_folder_name");
        this.miq = new AlbumItem("", 0);
        this.miq.meD = new ImageMediaItem();
        qP(bg.mz(getString(R.l.dHc)));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SelectAlbumPreviewFolderUI mis;

            {
                this.mis = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mis.finish();
                return false;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        c.ayk().b(this);
    }

    protected final int getLayoutId() {
        return R.i.dny;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public final void A(final ArrayList<AlbumItem> arrayList) {
        new ae(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ SelectAlbumPreviewFolderUI mis;

            public final void run() {
                this.mis.mgB.addAll(arrayList);
                this.mis.mio.aab.notifyChanged();
            }
        });
    }
}
