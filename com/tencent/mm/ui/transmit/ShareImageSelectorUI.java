package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.tools.ShowImageUI;
import java.util.ArrayList;

public class ShareImageSelectorUI extends MMActivity implements OnItemClickListener {
    private static int wrg = 1;
    private ListView Fg;
    private View kQZ;
    private ImageView kZz;
    private ae mHandler = new ae(this) {
        final /* synthetic */ ShareImageSelectorUI wrk;

        {
            this.wrk = r1;
        }

        public final void handleMessage(Message message) {
            this.wrk.finish();
        }
    };
    private String ntE;
    private int vZk = 2;
    private a wrh;
    private Dialog wri;
    private OnClickListener wrj = new OnClickListener(this) {
        final /* synthetic */ ShareImageSelectorUI wrk;

        {
            this.wrk = r1;
        }

        public final void onClick(View view) {
            ShareImageSelectorUI.a(this.wrk);
        }
    };

    class a extends BaseAdapter {
        final /* synthetic */ ShareImageSelectorUI wrk;
        public a[] wrl = new a[]{new a(this, R.l.ebf, R.k.dzy), new a(this, R.l.ebg, R.k.dxj), new a(this, R.l.ebe, R.k.dxJ)};

        class a {
            int wrm;
            int wrn;
            final /* synthetic */ a wro;

            public a(a aVar, int i, int i2) {
                this.wro = aVar;
                this.wrm = i;
                this.wrn = i2;
            }
        }

        a(ShareImageSelectorUI shareImageSelectorUI) {
            this.wrk = shareImageSelectorUI;
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i) {
            return this.wrl[i];
        }

        public final int getCount() {
            return 3;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.wrk.uSU.uTo).inflate(R.i.dou, null);
                bVar = new b(this.wrk, view);
            } else {
                bVar = (b) view.getTag();
            }
            a aVar = this.wrl[i];
            if (aVar != null) {
                bVar.wrp.setText(aVar.wrm);
                bVar.lKO.setImageResource(aVar.wrn);
            }
            return view;
        }
    }

    class b {
        MMImageView lKO;
        final /* synthetic */ ShareImageSelectorUI wrk;
        TextView wrp;

        public b(ShareImageSelectorUI shareImageSelectorUI, View view) {
            this.wrk = shareImageSelectorUI;
            this.lKO = (MMImageView) view.findViewById(R.h.bZl);
            this.wrp = (TextView) view.findViewById(R.h.bZK);
        }
    }

    static /* synthetic */ void a(ShareImageSelectorUI shareImageSelectorUI) {
        Intent intent = new Intent(shareImageSelectorUI, ShowImageUI.class);
        intent.putExtra("key_image_path", shareImageSelectorUI.ntE);
        intent.putExtra("show_menu", false);
        shareImageSelectorUI.startActivity(intent);
    }

    protected final int getLayoutId() {
        return R.i.dot;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.yY();
        Object obj = c.vr().get(229635, null);
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 0 || intValue == 1) {
                wrg = intValue;
            }
        }
        zi(R.l.eAN);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareImageSelectorUI wrk;

            {
                this.wrk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.wrk.aGU();
                return false;
            }
        });
        this.vZk = getIntent().getIntExtra("Select_Conv_Type", 2);
        this.ntE = getIntent().getStringExtra("intent_extra_image_path");
        this.kQZ = findViewById(R.h.cgM);
        this.kZz = (ImageView) findViewById(R.h.Kd);
        this.kZz.setOnClickListener(this.wrj);
        this.Fg = (ListView) findViewById(R.h.list);
        this.wrh = new a(this);
        this.Fg.setAdapter(this.wrh);
        this.Fg.setOnItemClickListener(this);
        w.d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", new Object[]{this.vZk, this.ntE});
        if (wrg == 1) {
            zg(8);
            this.Fg.setVisibility(8);
            this.kZz.setLayoutParams(new LayoutParams(-1, -1));
            this.kZz.setPadding(0, 0, 0, 0);
            this.kZz.setOnClickListener(null);
            this.kQZ.setBackgroundColor(getResources().getColor(R.e.aTs));
            cai();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap mt = j.mt(this.ntE);
        w.d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", new Object[]{Integer.valueOf(ExifHelper.Pc(this.ntE))});
        mt = d.b(mt, (float) r3);
        if (!(mt == null || mt.isRecycled())) {
            this.kZz.setImageBitmap(mt);
        }
        w.d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis) + "'"});
    }

    protected final int Ol() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (wrg != 1) {
            return;
        }
        if (this.wri == null || !this.wri.isShowing()) {
            cai();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                caj();
                return;
            case 1:
                cak();
                return;
            case 2:
                cal();
                return;
            default:
                w.e("MicroMsg.ShareImageSelectorUI", "unknow postion.");
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.d("MicroMsg.ShareImageSelectorUI", "requestCode:%d , resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                if (i2 == -1) {
                    ArrayList arrayList = null;
                    if (intent != null) {
                        arrayList = intent.getStringArrayListExtra("Select_Contact");
                    }
                    if (arrayList != null && arrayList.size() == 1) {
                        Intent intent2 = new Intent(this, En_5b8fbb1e.class);
                        intent2.putExtra("Chat_User", (String) arrayList.get(0));
                        startActivity(intent2);
                    }
                    finish();
                    return;
                }
                w.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                return;
            case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                if (i2 == -1) {
                    Toast.makeText(this.uSU.uTo, R.l.dXl, 0).show();
                    finish();
                    return;
                }
                w.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                return;
            default:
                w.w("MicroMsg.ShareImageSelectorUI", "unknow result");
                return;
        }
    }

    public void onBackPressed() {
        aGU();
    }

    private void aGU() {
        g.a(this.uSU.uTo, getString(R.l.ebb), getString(R.l.ebd), true, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ ShareImageSelectorUI wrk;

            {
                this.wrk = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.wrk.finish();
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ ShareImageSelectorUI wrk;

            {
                this.wrk = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (ShareImageSelectorUI.wrg == 1) {
                    this.wrk.cai();
                }
            }
        });
    }

    private void cai() {
        if (this.wri == null || !this.wri.isShowing()) {
            this.wri = g.a(this.uSU.uTo, getString(R.l.eAN), new String[]{getString(R.l.ebf), getString(R.l.ebg), getString(R.l.ebe)}, null, new g.c(this) {
                final /* synthetic */ ShareImageSelectorUI wrk;

                {
                    this.wrk = r1;
                }

                public final void hq(int i) {
                    switch (i) {
                        case 0:
                            this.wrk.caj();
                            return;
                        case 1:
                            this.wrk.cak();
                            return;
                        case 2:
                            this.wrk.cal();
                            return;
                        default:
                            return;
                    }
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ ShareImageSelectorUI wrk;

                {
                    this.wrk = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.wrk.aGU();
                }
            });
        }
    }

    private void caj() {
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", s.vYU);
        intent.putExtra("titile", getString(R.l.dCQ));
        intent.putExtra("list_type", 11);
        intent.putExtra("shareImage", true);
        intent.putExtra("shareImagePath", this.ntE);
        startActivityForResult(intent, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
    }

    private void cak() {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", this.ntE);
        intent.putExtra("need_result", true);
        com.tencent.mm.bb.d.b(this.uSU.uTo, "sns", ".ui.En_c4f742e5", intent, MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
    }

    private void cal() {
        com.tencent.mm.sdk.b.b cbVar = new cb();
        e.a(cbVar, 6, this.ntE);
        cbVar.fFA.activity = this;
        cbVar.fFA.fFH = 52;
        com.tencent.mm.sdk.b.a.urY.m(cbVar);
        com.tencent.mm.plugin.report.service.g.oUh.i(11048, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0)});
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(0, 800);
        }
    }
}
