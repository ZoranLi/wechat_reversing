package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.id;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.List;

final class a extends BaseAdapter {
    private String iQO;
    String jia;
    boolean llA;
    int llB;
    int llC;
    ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> llD;
    List<id> llE;
    c lly;
    private boolean llz;
    private Context mContext;

    class a {
        public ImageView liC;
        final /* synthetic */ a llF;
        public TextView llG;
        public View llH;

        a(a aVar) {
            this.llF = aVar;
        }
    }

    class b {
        final /* synthetic */ a llF;
        public TextView llG;
        public View llI;

        b(a aVar) {
            this.llF = aVar;
        }
    }

    class c {
        public View jqe;
        public ImageView liC;
        final /* synthetic */ a llF;
        public TextView llG;
        public View llH;

        c(a aVar) {
            this.llF = aVar;
        }
    }

    class d {
        final /* synthetic */ a llF;
        public Button llJ;

        d(a aVar) {
            this.llF = aVar;
        }
    }

    class e {
        public ImageView kDl;
        final /* synthetic */ a llF;
        public View llH;
        public NoMeasuredTextView llK;
        public TextView llL;

        e(a aVar) {
            this.llF = aVar;
        }
    }

    class f {
        public ImageView kDl;
        final /* synthetic */ a llF;

        f(a aVar) {
            this.llF = aVar;
        }
    }

    public a(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.jia = str2;
        this.llz = z;
        this.iQO = str;
    }

    public final int getCount() {
        if (this.llz) {
            return (this.llB + 5) + this.llC;
        }
        return 2;
    }

    public final int getViewTypeCount() {
        return 8;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        if (this.llz) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 6;
            }
            if (i > 1 && i <= this.llB + 1) {
                return 1;
            }
            if (i == this.llB + 2) {
                return 2;
            }
            if (i == this.llB + 3) {
                return 5;
            }
            if (i <= this.llB + 3 || i > (this.llB + 3) + this.llC) {
                return i == (this.llB + this.llC) + 4 ? 7 : 5;
            } else {
                return 3;
            }
        } else if (i == 0) {
            return 0;
        } else {
            return 4;
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        a aVar;
        d dVar;
        e eVar;
        f fVar;
        b bVar;
        b bVar2 = null;
        int itemViewType = getItemViewType(i);
        if (view != null) {
            switch (itemViewType) {
                case 0:
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = (f) view.getTag();
                    bVar = null;
                    break;
                case 1:
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = (e) view.getTag();
                    fVar = null;
                    bVar = null;
                    break;
                case 2:
                    cVar = null;
                    aVar = (a) view.getTag();
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    bVar = null;
                    break;
                case 3:
                    cVar = (c) view.getTag();
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    bVar = null;
                    break;
                case 4:
                    cVar = null;
                    aVar = null;
                    dVar = (d) view.getTag();
                    eVar = null;
                    fVar = null;
                    bVar = null;
                    break;
                case 5:
                    view.getTag();
                    bVar = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                case 6:
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    bVar = null;
                    bVar2 = (b) view.getTag();
                    break;
                case 7:
                    bVar = (b) view.getTag();
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                default:
                    bVar = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
            }
        }
        switch (itemViewType) {
            case 0:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dbK, viewGroup, false);
                f fVar2 = new f(this);
                fVar2.kDl = (ImageView) view.findViewById(R.h.bMO);
                view.setTag(fVar2);
                bVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = fVar2;
                cVar = null;
                break;
            case 1:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dbJ, viewGroup, false);
                e eVar2 = new e(this);
                eVar2.llK = (NoMeasuredTextView) view.findViewById(R.h.bMY);
                eVar2.llL = (TextView) view.findViewById(R.h.bMZ);
                eVar2.kDl = (ImageView) view.findViewById(R.h.bMW);
                eVar2.llH = view.findViewById(R.h.bMX);
                eVar2.llK.H(this.mContext.getResources().getDimension(R.f.aXe));
                eVar2.llK.setTextColor(this.mContext.getResources().getColor(R.e.aTN));
                eVar2.llK.bSn();
                eVar2.llK.voV = true;
                view.setTag(eVar2);
                bVar = null;
                aVar = null;
                dVar = null;
                eVar = eVar2;
                fVar = null;
                cVar = null;
                break;
            case 2:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dbG, viewGroup, false);
                a aVar2 = new a(this);
                aVar2.llG = (TextView) view.findViewById(R.h.bMS);
                aVar2.llH = view.findViewById(R.h.bMQ);
                aVar2.liC = (ImageView) view.findViewById(R.h.bMR);
                view.setTag(aVar2);
                bVar = null;
                aVar = aVar2;
                dVar = null;
                eVar = null;
                fVar = null;
                cVar = null;
                break;
            case 3:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dbG, viewGroup, false);
                cVar = new c(this);
                cVar.llG = (TextView) view.findViewById(R.h.bMS);
                cVar.llH = view.findViewById(R.h.bMQ);
                cVar.liC = (ImageView) view.findViewById(R.h.bMR);
                cVar.jqe = view.findViewById(R.h.bMP);
                view.setTag(cVar);
                bVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 4:
                view = LayoutInflater.from(this.mContext).inflate(R.i.bMV, viewGroup, false);
                d dVar2 = new d(this);
                dVar2.llJ = (Button) view.findViewById(R.h.bMV);
                view.setTag(dVar2);
                bVar = null;
                aVar = null;
                dVar = dVar2;
                eVar = null;
                fVar = null;
                cVar = null;
                break;
            case 5:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dbI, viewGroup, false);
                view.setTag(new b(this));
                bVar = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 6:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dbI, viewGroup, false);
                b bVar3 = new b(this);
                bVar3.llG = (TextView) view.findViewById(R.h.bMU);
                view.setTag(bVar3);
                bVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                b bVar4 = bVar3;
                cVar = null;
                bVar2 = bVar4;
                break;
            case 7:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dbI, viewGroup, false);
                bVar = new b(this);
                bVar.llI = view.findViewById(R.h.bMT);
                view.setTag(bVar);
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            default:
                bVar = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
        }
        switch (itemViewType) {
            case 0:
                com.tencent.mm.pluginsdk.ui.a.b.n(fVar.kDl, this.jia);
                fVar.kDl.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a llF;

                    {
                        this.llF = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", this.llF.jia);
                        com.tencent.mm.bb.d.b(this.llF.mContext, "profile", ".ui.ContactInfoUI", intent);
                    }
                });
                break;
            case 1:
                if (i - 2 >= 0 && !bg.bV(this.llD)) {
                    com.tencent.mm.plugin.exdevice.f.b.a.c cVar2 = (com.tencent.mm.plugin.exdevice.f.b.a.c) this.llD.get(i - 2);
                    if (cVar2 != null) {
                        int i2 = cVar2.field_step;
                        final String str = cVar2.field_username;
                        if (cVar2.field_step >= 10000) {
                            eVar.llL.setTextColor(this.mContext.getResources().getColor(R.e.aTM));
                        } else {
                            eVar.llL.setTextColor(this.mContext.getResources().getColor(R.e.aTL));
                        }
                        eVar.llK.setText(h.b(this.mContext, n.eK(str), eVar.llK.gm.getTextSize()));
                        eVar.llL.setText(String.valueOf(i2));
                        com.tencent.mm.pluginsdk.ui.a.b.m(eVar.kDl, str);
                        eVar.llH.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ a llF;

                            public final void onClick(View view) {
                                Context b = this.llF.mContext;
                                Intent intent = new Intent(b, ExdeviceProfileUI.class);
                                intent.putExtra("username", str);
                                b.startActivity(intent);
                            }
                        });
                        break;
                    }
                }
                break;
            case 2:
                aVar.llG.setText(this.mContext.getResources().getText(R.l.egm));
                aVar.liC.setImageResource(R.k.dww);
                aVar.llH.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a llF;

                    {
                        this.llF = r1;
                    }

                    public final void onClick(View view) {
                        if (this.llF.lly != null) {
                            this.llF.lly.aqp();
                        }
                    }
                });
                break;
            case 3:
                if ((i - this.llB) - 4 >= 0 && !bg.bV(this.llE)) {
                    id idVar = (id) this.llE.get((i - this.llB) - 4);
                    if (idVar != null) {
                        CharSequence charSequence = idVar.title;
                        String str2 = idVar.fSl;
                        final String str3 = idVar.url;
                        cVar.llG.setText(charSequence);
                        if ((i - this.llB) - 4 != this.llC - 1) {
                            cVar.jqe.setVisibility(0);
                        }
                        com.tencent.mm.plugin.exdevice.f.a.e.a(this.mContext, cVar.liC, str2, R.e.aTt);
                        cVar.llH.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ a llF;

                            public final void onClick(View view) {
                                com.tencent.mm.plugin.sport.b.d.mN(8);
                                com.tencent.mm.plugin.exdevice.model.f.S(this.llF.mContext, str3);
                            }
                        });
                        break;
                    }
                }
                break;
            case 4:
                if (!this.llA) {
                    ap.yY();
                    if (com.tencent.mm.u.c.wR().QY(this.jia)) {
                        dVar.llJ.setVisibility(0);
                        dVar.llJ.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ a llF;

                            {
                                this.llF = r1;
                            }

                            public final void onClick(View view) {
                                if (this.llF.lly != null) {
                                    this.llF.lly.aqq();
                                }
                            }
                        });
                        break;
                    }
                }
                dVar.llJ.setVisibility(4);
                break;
            case 6:
                bVar2.llG.setText(this.mContext.getString(R.l.egs));
                break;
            case 7:
                bVar.llI.setVisibility(0);
                break;
        }
        return view;
    }
}
