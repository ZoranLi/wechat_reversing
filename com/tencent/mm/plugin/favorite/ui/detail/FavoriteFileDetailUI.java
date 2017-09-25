package com.tencent.mm.plugin.favorite.ui.detail;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.favorite.b.ag;
import com.tencent.mm.plugin.favorite.b.b.a;
import com.tencent.mm.plugin.favorite.b.q;
import com.tencent.mm.plugin.favorite.b.r;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.b.v.b;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.c.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.a.a.c;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteFileDetailUI extends MMActivity implements a, j.a {
    private long fFx;
    private rm fKe;
    private boolean fQy = true;
    private ae hgN;
    private ProgressBar jKM;
    private TextView jbV;
    private f kmM = null;
    private TextView kzl;
    private com.tencent.mm.plugin.favorite.b.j lFt;
    private q lIh = new q();
    private Button lKL;
    private Button lKM;
    private Button lKN;
    private MMImageView lKO;
    private TextView lKP;
    private View lKQ;
    private View lKR;
    private TextView lKS;
    private ImageView lKT;
    private TextView lKU;
    private boolean lKV = false;
    private boolean lKW = false;
    private String lKX;
    private String lKY;
    private boolean lKZ = false;
    private boolean lLa = false;
    private boolean lLb = false;

    static /* synthetic */ void j(FavoriteFileDetailUI favoriteFileDetailUI) {
        int i;
        g gVar = g.oUh;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(favoriteFileDetailUI.getType() != 15 ? favoriteFileDetailUI.getType() : 16);
        objArr[1] = Integer.valueOf(1);
        objArr[2] = Integer.valueOf(0);
        gVar.i(10651, objArr);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        if (favoriteFileDetailUI.getType() == 15) {
            i = 11;
            intent.putExtra("image_path", r.c(favoriteFileDetailUI.fKe));
        } else if (favoriteFileDetailUI.getType() == 4) {
            intent.putExtra("image_path", r.c(favoriteFileDetailUI.fKe));
            i = 1;
        } else {
            intent.putExtra("desc_title", favoriteFileDetailUI.fKe.title);
            i = 3;
        }
        intent.putExtra("Retr_Msg_Type", i);
        d.a(favoriteFileDetailUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void k(FavoriteFileDetailUI favoriteFileDetailUI) {
        String lI = t.lI(x.g(favoriteFileDetailUI.fKe));
        w.i("MicroMsg.FavoriteFileDetailUI", "%d save video now video path %s out path %s", new Object[]{Integer.valueOf(favoriteFileDetailUI.hashCode()), r0, lI});
        if (bg.mA(lI)) {
            Toast.makeText(favoriteFileDetailUI, favoriteFileDetailUI.getString(R.l.fal), 1).show();
            return;
        }
        Toast.makeText(favoriteFileDetailUI, favoriteFileDetailUI.getString(R.l.fam, new Object[]{lI}), 1).show();
        k.b(lI, favoriteFileDetailUI);
    }

    static /* synthetic */ void o(FavoriteFileDetailUI favoriteFileDetailUI) {
        if (favoriteFileDetailUI.getType() == 8 && x.d(favoriteFileDetailUI.fKe) && x.e(favoriteFileDetailUI.fKe)) {
            e.e(favoriteFileDetailUI.uSU.uTo, favoriteFileDetailUI.lFt);
        }
    }

    protected final int getLayoutId() {
        return R.i.dcL;
    }

    protected final int Ol() {
        return 1;
    }

    private void auA() {
        this.lKY = getIntent().getStringExtra("key_detail_data_id");
        Iterator it = this.lFt.field_favProto.tzn.iterator();
        while (it.hasNext()) {
            rm rmVar = (rm) it.next();
            if (rmVar.lKv.equals(this.lKY)) {
                this.fKe = rmVar;
                break;
            }
        }
        if (this.fKe == null) {
            this.fKe = x.n(this.lFt);
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        this.hgN = new ae();
        this.fFx = getIntent().getLongExtra("key_detail_info_id", -1);
        this.lKW = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        this.fQy = getIntent().getBooleanExtra("show_share", true);
        this.lKX = getIntent().getStringExtra("fav_note_xml");
        this.lFt = h.ata().bT(this.fFx);
        if (this.lKW && !bg.mA(this.lKX)) {
            this.lFt = x.wc(this.lKX);
        }
        if (this.lFt == null) {
            w.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
            finish();
            return;
        }
        String string;
        v.j(this.lFt);
        auA();
        this.lKL = (Button) findViewById(R.h.csp);
        this.lKM = (Button) findViewById(R.h.cpt);
        this.lKN = (Button) findViewById(R.h.bJY);
        this.lKO = (MMImageView) findViewById(R.h.bWx);
        this.kzl = (TextView) findViewById(R.h.cmn);
        this.jbV = (TextView) findViewById(R.h.cIS);
        this.lKR = findViewById(R.h.bKq);
        this.lKQ = findViewById(R.h.bKm);
        this.jKM = (ProgressBar) findViewById(R.h.bKl);
        this.lKP = (TextView) findViewById(R.h.bKn);
        this.lKS = (TextView) findViewById(R.h.cFd);
        this.lKT = (ImageView) findViewById(R.h.bOv);
        this.lKU = (TextView) findViewById(R.h.bOw);
        int type = getType();
        if (4 == type) {
            zi(R.l.ejL);
        } else if (15 == type) {
            zi(R.l.ejL);
            findViewById(R.h.cLG).setBackgroundResource(R.e.black);
            this.kzl.setVisibility(8);
        } else {
            zi(R.l.eir);
        }
        if (this.fKe.aMw == 4) {
            this.lKO.setImageResource(R.k.dtr);
        } else {
            this.lKO.setImageResource(com.tencent.mm.pluginsdk.model.q.LV(this.fKe.txx));
        }
        this.kzl.setText(this.fKe.title);
        rp rpVar = this.fKe.tyi;
        if (rpVar == null) {
            this.lKS.setVisibility(8);
        } else if (bg.mA(rpVar.hjD)) {
            w.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
            CharSequence charSequence = rpVar.hjG;
            final String str = rpVar.hjH;
            if (bg.mA(charSequence) || bg.mA(str)) {
                this.lKS.setVisibility(8);
            } else {
                this.lKS.setText(charSequence);
                this.lKS.setVisibility(0);
                this.lKS.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ FavoriteFileDetailUI lLd;

                    public final void onClick(View view) {
                        final Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("key_snsad_statextstr", this.lLd.fKe.fUY);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("rawUrl", str);
                        intent.putExtra("useJs", true);
                        ap.vd().a(new c("", 18, 5, "", 2), 0);
                        new ae(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 lLe;

                            public final void run() {
                                WorkerProfile.oC().fxt.j(intent, this.lLe.lLd);
                                this.lLe.lLd.finish();
                            }
                        });
                    }
                });
            }
        } else {
            string = getResources().getString(R.l.eWK);
            if (rpVar.tyZ / 60 > 0) {
                string = string + getResources().getString(R.l.eWM, new Object[]{Integer.valueOf(rpVar.tyZ / 60)});
            }
            if (rpVar.tyZ % 60 > 0) {
                string = string + getResources().getString(R.l.eWN, new Object[]{Integer.valueOf(rpVar.tyZ % 60)});
            }
            this.lKS.setText(string + getResources().getString(R.l.eWL));
            this.lKS.setVisibility(0);
            this.lKS.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FavoriteFileDetailUI lLd;

                {
                    this.lLd = r1;
                }

                public final void onClick(View view) {
                    v.a(v.a.EnterCompleteVideo, this.lLd.lFt);
                    rp rpVar = this.lLd.fKe.tyi;
                    String h = x.h(this.lLd.fKe);
                    Intent intent = new Intent();
                    intent.putExtra("IsAd", false);
                    intent.putExtra("KStremVideoUrl", rpVar.hjD);
                    intent.putExtra("StreamWording", rpVar.hjG);
                    intent.putExtra("StremWebUrl", rpVar.hjH);
                    intent.putExtra("KBlockFav", true);
                    intent.putExtra("KThumUrl", rpVar.hjI);
                    intent.putExtra("KThumbPath", h);
                    intent.putExtra("KMediaId", "fakeid_" + this.lLd.lFt.field_id);
                    intent.putExtra("KMediaVideoTime", rpVar.tyZ);
                    intent.putExtra("KMediaTitle", this.lLd.fKe.title);
                    intent.putExtra("KSta_StremVideoAduxInfo", rpVar.hjJ);
                    intent.putExtra("KSta_StremVideoPublishId", rpVar.hjK);
                    intent.putExtra("KSta_SourceType", 1);
                    intent.putExtra("KSta_Scene", b.Fav.value);
                    intent.putExtra("KSta_FromUserName", this.lLd.lFt.field_fromUser);
                    intent.putExtra("KSta_FavID", this.lLd.lFt.field_id);
                    intent.putExtra("KSta_SnsStatExtStr", this.lLd.fKe.fUY);
                    d.b(this.lLd, "sns", ".ui.VideoAdPlayerUI", intent);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteFileDetailUI lLd;

            {
                this.lLd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                v.a(v.a.LeavelFullScreen, this.lLd.lFt);
                this.lLd.finish();
                return true;
            }
        });
        this.lKM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavoriteFileDetailUI lLd;

            {
                this.lLd = r1;
            }

            public final void onClick(View view) {
                String g = x.g(this.lLd.fKe);
                if (4 == this.lLd.getType()) {
                    this.lLd.lKZ = false;
                    this.lLd.auE();
                    return;
                }
                com.tencent.mm.pluginsdk.ui.tools.a.b(this.lLd, g, this.lLd.fKe.txx, 2);
            }
        });
        string = this.fKe.txp;
        if (!bg.mA(string)) {
            this.lKL.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FavoriteFileDetailUI lLd;

                public final void onClick(View view) {
                    w.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", new Object[]{Integer.valueOf(this.lLd.lFt.field_id), Long.valueOf(this.lLd.lFt.field_localId)});
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", string);
                    intent.putExtra("is_favorite_item", true);
                    intent.putExtra("fav_local_id", this.lLd.lFt.field_localId);
                    intent.putExtra("geta8key_scene", 14);
                    com.tencent.mm.plugin.favorite.c.j(intent, this.lLd.uSU.uTo);
                }
            });
        }
        this.lKN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavoriteFileDetailUI lLd;

            {
                this.lLd = r1;
            }

            public final void onClick(View view) {
                w.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[]{Integer.valueOf(this.lLd.lFt.field_id), Long.valueOf(this.lLd.lFt.field_localId), Integer.valueOf(this.lLd.lFt.field_itemStatus)});
                if (com.tencent.mm.compatible.util.f.rZ()) {
                    if (this.lLd.lFt.atj() || bg.mA(this.lLd.fKe.txi)) {
                        x.l(this.lLd.lFt);
                    } else if (this.lLd.lKW) {
                        this.lLd.lFt.field_itemStatus = 7;
                        x.i(this.lLd.fKe);
                    } else {
                        x.a(this.lLd.lFt, this.lLd.fKe, true);
                    }
                    this.lLd.auC();
                    return;
                }
                com.tencent.mm.ui.base.g.h(this.lLd.uSU.uTo, R.l.eiN, R.l.ehy);
            }
        });
        this.lKR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavoriteFileDetailUI lLd;

            {
                this.lLd = r1;
            }

            public final void onClick(View view) {
                if (this.lLd.lFt.atk()) {
                    x.f(this.lLd.fKe);
                    this.lLd.lKN.setText(R.l.eiC);
                } else {
                    x.o(this.lLd.lFt);
                    this.lLd.lKN.setText(R.l.eiD);
                }
                this.lLd.auD();
            }
        });
        if (this.fQy) {
            boolean z2;
            final boolean booleanExtra = getIntent().getBooleanExtra("key_detail_can_delete", true);
            final int type2 = getType();
            if (type2 == 8) {
                z = this.lFt.atg();
            } else if (type2 == 15) {
                z2 = this.lFt.atg() && bg.PY(com.tencent.mm.i.g.sV().getValue("SIGHTCannotTransmitForFav")) == 0;
                if (z2 || booleanExtra) {
                    a(0, R.l.eYj, R.g.bhb, new OnMenuItemClickListener(this) {
                        final /* synthetic */ FavoriteFileDetailUI lLd;

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            if ((!z2 || q.b(this.lLd.fKe) || this.lLd.fKe.tyq != 0) && !booleanExtra) {
                                return false;
                            }
                            com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.lLd.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
                            eVar.qJf = new n.c(this) {
                                final /* synthetic */ AnonymousClass13 lLk;

                                {
                                    this.lLk = r1;
                                }

                                public final void a(l lVar) {
                                    if (z2 && !q.b(this.lLk.lLd.fKe) && this.lLk.lLd.fKe.tyq == 0) {
                                        if (type2 == 8) {
                                            lVar.e(0, this.lLk.lLd.getString(R.l.ejs));
                                        } else if (type2 == 15) {
                                            lVar.e(0, this.lLk.lLd.getString(R.l.ejs));
                                            lVar.e(4, this.lLk.lLd.getString(R.l.dUz));
                                        } else if (type2 == 4) {
                                            lVar.e(0, this.lLk.lLd.getString(R.l.ejs));
                                            lVar.e(4, this.lLk.lLd.getString(R.l.dUz));
                                        } else {
                                            lVar.e(0, this.lLk.lLd.getString(R.l.ejs));
                                            if (booleanExtra && this.lLk.lLd.lFt.ath()) {
                                                lVar.e(1, this.lLk.lLd.getString(R.l.eiU));
                                            }
                                        }
                                    }
                                    if (booleanExtra) {
                                        lVar.e(3, this.lLk.lLd.getString(R.l.ehS));
                                        lVar.e(2, this.lLk.lLd.uSU.uTo.getString(R.l.dGB));
                                    }
                                }
                            };
                            eVar.qJg = new n.d(this) {
                                final /* synthetic */ AnonymousClass13 lLk;

                                {
                                    this.lLk = r1;
                                }

                                public final void c(MenuItem menuItem, int i) {
                                    switch (menuItem.getItemId()) {
                                        case 0:
                                            if (this.lLk.lLd.getType() == 8) {
                                                String g = x.g(this.lLk.lLd.fKe);
                                                if (!com.tencent.mm.a.e.aO(g)) {
                                                    w.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
                                                    Toast.makeText(this.lLk.lLd, this.lLk.lLd.getString(R.l.ejq), 1).show();
                                                    return;
                                                } else if (new File(g).length() > 10485760) {
                                                    w.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
                                                    Toast.makeText(this.lLk.lLd, this.lLk.lLd.getString(R.l.ejr), 1).show();
                                                    return;
                                                }
                                            }
                                            FavoriteFileDetailUI.j(this.lLk.lLd);
                                            return;
                                        case 1:
                                            final Dialog a = com.tencent.mm.ui.base.g.a(this.lLk.lLd.uSU.uTo, this.lLk.lLd.getString(R.l.eit), false, null);
                                            Context context = this.lLk.lLd.uSU.uTo;
                                            com.tencent.mm.plugin.favorite.b.j b = this.lLk.lLd.lFt;
                                            Runnable anonymousClass1 = new Runnable(this) {
                                                final /* synthetic */ AnonymousClass2 lLl;

                                                public final void run() {
                                                    a.dismiss();
                                                }
                                            };
                                            List linkedList = new LinkedList();
                                            linkedList.add(Integer.valueOf(b.field_id));
                                            ap.vd().a(new ag("", linkedList, new com.tencent.mm.plugin.favorite.b.r.AnonymousClass2(b, context, anonymousClass1)), 0);
                                            return;
                                        case 2:
                                            com.tencent.mm.ui.base.g.a(this.lLk.lLd.uSU.uTo, this.lLk.lLd.getString(R.l.dGC), "", new DialogInterface.OnClickListener(this) {
                                                final /* synthetic */ AnonymousClass2 lLl;

                                                {
                                                    this.lLl = r1;
                                                }

                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    final p a = com.tencent.mm.ui.base.g.a(this.lLl.lLk.lLd.uSU.uTo, this.lLl.lLk.lLd.getString(R.l.dGC), false, null);
                                                    x.a(this.lLl.lLk.lLd.lFt.field_localId, new Runnable(this) {
                                                        final /* synthetic */ AnonymousClass2 lLn;

                                                        public final void run() {
                                                            a.dismiss();
                                                            w.d("MicroMsg.FavoriteFileDetailUI", "do del fav file, local id %d, fav id %d", new Object[]{Long.valueOf(this.lLn.lLl.lLk.lLd.lFt.field_localId), Integer.valueOf(this.lLn.lLl.lLk.lLd.lFt.field_id)});
                                                            this.lLn.lLl.lLk.lLd.finish();
                                                        }
                                                    });
                                                }
                                            }, null);
                                            return;
                                        case 3:
                                            Intent intent = new Intent(this.lLk.lLd.uSU.uTo, FavTagEditUI.class);
                                            intent.putExtra("key_fav_scene", 2);
                                            intent.putExtra("key_fav_item_id", this.lLk.lLd.lFt.field_localId);
                                            this.lLk.lLd.uSU.uTo.startActivity(intent);
                                            return;
                                        case 4:
                                            FavoriteFileDetailUI.k(this.lLk.lLd);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                            };
                            eVar.bzh();
                            return true;
                        }
                    });
                }
            } else if (!(this.lFt.ath() || this.lFt.atg())) {
                z = false;
            }
            z2 = z;
            a(0, R.l.eYj, R.g.bhb, /* anonymous class already generated */);
        }
        ei(false);
    }

    private int getType() {
        if (this.fKe == null) {
            w.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
            return 8;
        } else if (this.fKe.aMw == 0) {
            w.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", new Object[]{Integer.valueOf(this.lFt.field_type)});
            if (4 == this.lFt.field_type) {
                return 4;
            }
            if (16 != this.lFt.field_type) {
                return 8;
            }
            if (!(this.fKe == null || this.fKe.tyi == null)) {
                if (!bg.mA(this.fKe.tyi.hjD)) {
                    return 15;
                }
                if (!bg.mA(this.fKe.tyi.hjH)) {
                    return 15;
                }
            }
            return 4;
        } else if (this.fKe.aMw != 15) {
            return this.fKe.aMw;
        } else {
            if (!(this.fKe == null || this.fKe.tyi == null)) {
                if (!bg.mA(this.fKe.tyi.hjD)) {
                    return 15;
                }
                if (!bg.mA(this.fKe.tyi.hjH)) {
                    return 15;
                }
            }
            return 4;
        }
    }

    private void ei(boolean z) {
        boolean d = x.d(this.fKe);
        w.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", new Object[]{Integer.valueOf(this.lFt.field_itemStatus), Boolean.valueOf(d), x.g(this.fKe)});
        if (this.fKe.tyq != 0) {
            auB();
        } else if (this.lFt.isDone() || d || !bg.mA(this.fKe.txi)) {
            if (d) {
                if (!(getType() != 15 || this.fKe.tyi == null || bg.mA(this.fKe.tyi.hjD) || bg.mA(this.fKe.tyi.hjH))) {
                    this.lLa = true;
                    this.lKO.setVisibility(8);
                    this.lKQ.setVisibility(8);
                    this.lKN.setVisibility(8);
                    this.lKL.setVisibility(8);
                    this.lKM.setVisibility(8);
                    this.jbV.setVisibility(8);
                    String g = x.g(this.fKe);
                    w.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.sc() + " initView: fullpath:" + g);
                    ViewGroup viewGroup = (ViewGroup) findViewById(R.h.cLG);
                    this.kmM = com.tencent.mm.pluginsdk.ui.tools.n.dG(this.uSU.uTo);
                    LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    viewGroup.addView((View) this.kmM, 0, layoutParams);
                    this.kmM.a(new f.a(this) {
                        final /* synthetic */ FavoriteFileDetailUI lLd;

                        {
                            this.lLd = r1;
                        }

                        public final void Uc() {
                            w.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.sc() + " onPrepared");
                            this.lLd.kmM.bN(true);
                            this.lLd.kmM.start();
                        }

                        public final void onError(int i, int i2) {
                            this.lLd.kmM.stop();
                            if (!this.lLd.lKV) {
                                this.lLd.lKV = true;
                                af.v(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass14 lLo;

                                    {
                                        this.lLo = r1;
                                    }

                                    public final void run() {
                                        com.tencent.mm.ui.base.g.h(this.lLo.lLd.uSU.uTo, R.l.fak, R.l.dVf);
                                        Bitmap a = com.tencent.mm.plugin.favorite.c.g.a(this.lLo.lLd.fKe, this.lLo.lLd.lFt);
                                        ImageView imageView = (ImageView) this.lLo.lLd.findViewById(R.h.cMr);
                                        if (imageView != null) {
                                            imageView.setImageBitmap(a);
                                            imageView.setVisibility(0);
                                        }
                                    }
                                });
                            }
                        }

                        public final void oW() {
                        }

                        public final int bI(int i, int i2) {
                            return 0;
                        }

                        public final void bp(int i, int i2) {
                        }
                    });
                    w.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.sc() + " initView :" + g);
                    if (g != null) {
                        this.kmM.stop();
                        this.kmM.setVideoPath(g);
                    }
                    w.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.sc() + " initView");
                    if (ap.oH() != null) {
                        ap.oH().pS();
                    }
                    g.oUh.i(11444, new Object[]{Integer.valueOf(4)});
                }
                if (getType() != 15 && getType() != 4) {
                    d = x.d(this.fKe) && x.e(this.fKe);
                    if (d) {
                        this.lKQ.setVisibility(8);
                        this.lKN.setVisibility(8);
                        this.lKL.setVisibility(0);
                        this.lKM.setVisibility(8);
                        this.jbV.setVisibility(8);
                        this.lKL.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ FavoriteFileDetailUI lLd;

                            {
                                this.lLd = r1;
                            }

                            public final void onClick(View view) {
                                FavoriteFileDetailUI.o(this.lLd);
                            }
                        });
                    } else {
                        this.lKQ.setVisibility(8);
                        this.lKN.setVisibility(8);
                        if (bg.mA(this.fKe.txp)) {
                            this.lKL.setVisibility(8);
                        } else {
                            this.lKL.setVisibility(0);
                        }
                        this.lKM.setVisibility(0);
                        this.jbV.setVisibility(0);
                    }
                } else if (!this.lLa) {
                    this.lKQ.setVisibility(8);
                    this.lKN.setVisibility(8);
                    this.lKL.setVisibility(8);
                    this.lKM.setVisibility(0);
                    this.lKM.setText(R.l.eiB);
                    this.jbV.setVisibility(8);
                    auE();
                }
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ FavoriteFileDetailUI lLd;

                    {
                        this.lLd = r1;
                    }

                    public final void run() {
                        x.t(this.lLd.lFt);
                    }
                });
            } else if (bg.mA(this.fKe.txi)) {
                auB();
            } else {
                w.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
                auD();
            }
        } else if (this.lFt.atl()) {
            if (bg.mA(this.fKe.txi)) {
                auB();
                if (z) {
                    int type = getType();
                    type = (4 == type || 15 == type) ? R.l.eji : R.l.ejd;
                    com.tencent.mm.ui.base.g.bl(this.uSU.uTo, getString(type));
                    return;
                }
                return;
            }
            auD();
            if (z) {
                com.tencent.mm.ui.base.g.bl(this.uSU.uTo, getString(R.l.ebM));
            }
        } else if (this.lFt.atj()) {
            auD();
            if (z) {
                com.tencent.mm.ui.base.g.bl(this.uSU.uTo, getString(R.l.eZf));
            }
        } else if (this.lFt.atk() || this.lFt.ati()) {
            auC();
        } else {
            w.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
            auD();
        }
    }

    private void auB() {
        this.lKO.setVisibility(8);
        this.kzl.setVisibility(8);
        this.lKN.setVisibility(8);
        this.lKL.setVisibility(8);
        this.lKM.setVisibility(8);
        this.lKQ.setVisibility(8);
        this.jbV.setVisibility(8);
        this.lKT.setVisibility(0);
        this.lKU.setVisibility(0);
        if (this.fKe.aMw == 4) {
            this.jbV.setGravity(17);
            this.jbV.setText(R.l.eiR);
            return;
        }
        this.jbV.setGravity(17);
        this.jbV.setText(R.l.eiQ);
        if (this.fKe.tyq == 2) {
            this.lKU.setText(R.l.ehF);
        } else {
            this.lKU.setText(R.l.ehG);
        }
    }

    private void auC() {
        int progress;
        int i;
        int i2;
        this.lKN.setVisibility(8);
        this.lKL.setVisibility(8);
        this.lKM.setVisibility(8);
        this.jbV.setVisibility(8);
        this.lKQ.setVisibility(0);
        com.tencent.mm.plugin.favorite.b.a vN = h.asV().vN(this.fKe.lKv);
        if (vN != null) {
            progress = (int) vN.getProgress();
            i = vN.field_offset;
            i2 = vN.field_totalLen;
        } else {
            progress = 0;
            i2 = (int) this.fKe.txD;
            i = 0;
        }
        if (this.lFt.ati() && bg.mA(this.fKe.txi)) {
            a((float) progress, getString(R.l.ejK, new Object[]{x.U((float) i), x.U((float) i2)}));
            return;
        }
        a((float) progress, getString(R.l.ehP, new Object[]{x.U((float) i), x.U((float) i2)}));
    }

    private void auD() {
        this.lKQ.setVisibility(8);
        this.lKM.setVisibility(8);
        if (bg.mA(this.fKe.txp)) {
            this.lKL.setVisibility(8);
        } else {
            this.lKL.setVisibility(0);
        }
        this.lKN.setVisibility(0);
        com.tencent.mm.plugin.favorite.b.a vN = h.asV().vN(this.fKe.lKv);
        if (vN == null || vN.field_offset <= 0) {
            this.lKN.setText(this.lFt.atj() ? R.l.eiE : R.l.eiA);
        } else {
            this.lKN.setText(this.lFt.atj() ? R.l.eiD : R.l.eiC);
        }
        this.jbV.setVisibility(8);
    }

    protected void onDestroy() {
        if (this.kmM != null) {
            this.kmM.a(null);
            this.kmM.stop();
            this.kmM.onDetach();
            if (ap.oH() != null) {
                ap.oH().pR();
            }
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        h.ata().c(this);
        h.asV().a((a) this);
        if (this.kmM != null) {
            this.kmM.start();
        }
    }

    protected void onPause() {
        super.onPause();
        h.ata().f(this);
        h.asV().b((a) this);
        if (this.kmM != null) {
            this.kmM.stop();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, R.l.ebP, R.l.ebQ, 2);
        if (i2 == -1 && i == 1) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final Dialog a = com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.eit), false, null);
            w.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", new Object[]{Integer.valueOf(getType())});
            Runnable anonymousClass4 = new Runnable(this) {
                final /* synthetic */ FavoriteFileDetailUI lLd;

                public final void run() {
                    a.dismiss();
                }
            };
            int type = getType();
            if (!bg.mA(stringExtra)) {
                for (String str2 : bg.f(stringExtra.split(","))) {
                    if (type == 4 || type == 15) {
                        Context context = this.uSU.uTo;
                        rm rmVar = this.fKe;
                        if (context == null) {
                            w.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
                        } else if (bg.mA(str2)) {
                            w.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
                        } else if (rmVar == null) {
                            w.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
                        } else {
                            ap.vL().D(new com.tencent.mm.plugin.favorite.b.r.AnonymousClass3(rmVar, context, str2, anonymousClass4));
                        }
                        boolean dH = o.dH(str2);
                        v.a(dH ? v.c.Chatroom : v.c.Chat, this.lFt, v.d.Full, dH ? com.tencent.mm.u.j.eC(str2) : 0);
                    } else {
                        r.a(this.uSU.uTo, str2, this.lFt, this.fKe, anonymousClass4);
                    }
                    if (!bg.mA(str)) {
                        com.tencent.mm.plugin.messenger.a.d.aJW().A(str2, str, o.fG(str2));
                    }
                }
                com.tencent.mm.ui.snackbar.a.e(this, getString(R.l.ekV));
            }
        }
    }

    public final void b(com.tencent.mm.plugin.favorite.b.a aVar) {
        if (aVar == null || aVar.field_dataId == null) {
            w.w("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, item is null");
            return;
        }
        w.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[]{this.fKe.lKv, aVar.field_dataId});
        if (!aVar.field_dataId.equals(this.fKe.lKv)) {
            return;
        }
        if (this.lFt.ati() && bg.mA(this.fKe.txi)) {
            a(aVar.getProgress(), getString(R.l.ejK, new Object[]{x.U((float) aVar.field_offset), x.U((float) aVar.field_totalLen)}));
            return;
        }
        a(aVar.getProgress(), getString(R.l.ehP, new Object[]{x.U((float) aVar.field_offset), x.U((float) aVar.field_totalLen)}));
        if (this.lKW && com.tencent.mm.a.e.aO(aVar.field_path)) {
            this.lFt.field_itemStatus = 10;
            a("", null);
        }
    }

    private void a(final float f, final String str) {
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ FavoriteFileDetailUI lLd;

            public final void run() {
                this.lLd.jKM.setProgress((int) f);
                this.lLd.lKP.setText(str);
            }
        });
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        int i = 0;
        w.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[]{str, Long.valueOf(this.lFt.field_localId)});
        com.tencent.mm.plugin.favorite.b.j bT = h.ata().bT(this.lFt.field_localId);
        if (bT != null || this.lKW) {
            if (!this.lKW) {
                this.lFt = bT;
            }
            auA();
            com.tencent.mm.plugin.favorite.b.a vN = h.asV().vN(this.fKe.lKv);
            if (vN != null) {
                if (vN.field_status == 1) {
                    i = 1;
                } else if (!(this.fKe.aMw == 8 || this.lLb)) {
                    if (vN.field_status == 4 && h.asV().vN(this.fKe.lKv).field_extFlag != 0) {
                        x.a(this.lFt, this.fKe, true);
                        this.lLb = true;
                    }
                    w.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[]{Boolean.valueOf(this.lLb)});
                    i = this.lLb;
                }
            }
            if (i == 0) {
                this.hgN.post(new Runnable(this) {
                    final /* synthetic */ FavoriteFileDetailUI lLd;

                    {
                        this.lLd = r1;
                    }

                    public final void run() {
                        this.lLd.ei(true);
                    }
                });
                return;
            }
            return;
        }
        w.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
        finish();
    }

    private void auE() {
        if (!this.lKZ) {
            this.lKZ = true;
            Intent intent = new Intent();
            intent.putExtra("key_detail_fav_path", x.g(this.fKe));
            intent.putExtra("key_detail_fav_thumb_path", x.h(this.fKe));
            intent.putExtra("key_detail_fav_video_duration", this.fKe.duration);
            intent.putExtra("key_detail_statExtStr", this.fKe.fUY);
            d.b(this, "favorite", ".ui.detail.FavoriteVideoPlayUI", intent);
            finish();
        }
    }
}
