package com.tencent.mm.modelfriend;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.c.ajm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends BaseAdapter {
    private Context context;
    public LinkedList<ajm> hAY = new LinkedList();
    private LinkedList<ajm> hAZ = new LinkedList();
    public List<String[]> hBa;
    private List<String[]> hBb = new LinkedList();
    public int[] hBc;
    private a hBd;
    public com.tencent.mm.ui.applet.b hBe = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a(this) {
        final /* synthetic */ j hBg;

        {
            this.hBg = r1;
        }

        public final Bitmap jf(String str) {
            return com.tencent.mm.x.b.a(str, false, -1);
        }
    });
    private com.tencent.mm.ui.applet.b.b hBf = null;
    int showType = 1;

    public interface a {
        void notifyDataSetChanged();
    }

    static class b {
        ImageView hBi;
        TextView hBj;
        TextView hBk;
        Button hBl;
        Button hBm;
        TextView hBn;
        TextView hBo;

        b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return fD(i);
    }

    public j(Context context, a aVar, int i) {
        this.context = context;
        this.showType = i;
        this.hBd = aVar;
        this.hBc = new int[this.hAY.size()];
    }

    public final int Ff() {
        int i = 0;
        for (int i2 : this.hBc) {
            if (this.showType == 1) {
                if (i2 == 1) {
                    i++;
                }
            } else if (this.showType == 2 && i2 == 2) {
                i++;
            }
        }
        return i;
    }

    public final boolean Fg() {
        if (this.hBc == null || this.hBc.length == 0) {
            return false;
        }
        for (int i : this.hBc) {
            if (this.showType == 1) {
                if (i == 0) {
                    return false;
                }
            } else if (this.showType == 2 && i == 0) {
                return false;
            }
        }
        return true;
    }

    public final void fC(int i) {
        if (this.showType == 1) {
            this.hBc[i] = 1;
        } else if (this.showType == 2) {
            this.hBc[i] = 2;
        }
        notifyDataSetChanged();
    }

    public final void bh(boolean z) {
        int i;
        int i2;
        if (this.showType == 1) {
            for (i = 0; i < this.hBc.length; i++) {
                int[] iArr = this.hBc;
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                iArr[i] = i2;
            }
        } else if (this.showType == 2) {
            for (i = 0; i < this.hBc.length; i++) {
                int[] iArr2 = this.hBc;
                if (z) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                iArr2[i] = i2;
            }
        }
        notifyDataSetChanged();
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (this.hBd != null) {
            this.hBd.notifyDataSetChanged();
        }
    }

    public final void e(LinkedList<ajm> linkedList) {
        if (linkedList != null) {
            this.hAZ.clear();
            this.hAY.clear();
            this.hBb.clear();
            for (String[] strArr : this.hBa) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ajm com_tencent_mm_protocal_c_ajm = (ajm) it.next();
                    if (this.showType == 1) {
                        if ((com_tencent_mm_protocal_c_ajm.jNB == 1 || com_tencent_mm_protocal_c_ajm.jNB == 0) && !bg.mA(strArr[2]) && com_tencent_mm_protocal_c_ajm.oTN.equals(g.n(strArr[2].getBytes()))) {
                            a(com_tencent_mm_protocal_c_ajm, strArr);
                        }
                    } else if (this.showType == 2 && com_tencent_mm_protocal_c_ajm.jNB == 2 && !bg.mA(strArr[2]) && com_tencent_mm_protocal_c_ajm.oTN.equals(g.n(strArr[2].getBytes()))) {
                        a(com_tencent_mm_protocal_c_ajm, strArr);
                    }
                }
            }
        }
        this.hBc = new int[this.hAZ.size()];
        this.hAY.addAll(this.hAZ);
        this.hAZ.clear();
    }

    private void a(ajm com_tencent_mm_protocal_c_ajm, String[] strArr) {
        Iterator it = this.hAZ.iterator();
        while (it.hasNext()) {
            ajm com_tencent_mm_protocal_c_ajm2 = (ajm) it.next();
            if (com_tencent_mm_protocal_c_ajm2.oTN != null && com_tencent_mm_protocal_c_ajm.oTN != null && com_tencent_mm_protocal_c_ajm2.oTN.equals(com_tencent_mm_protocal_c_ajm.oTN)) {
                w.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
                return;
            }
        }
        this.hAZ.add(com_tencent_mm_protocal_c_ajm);
        this.hBb.add(new String[]{strArr[2], strArr[1]});
    }

    public final int getCount() {
        return this.hAY.size();
    }

    public final ajm fD(int i) {
        return (ajm) this.hAY.get(i);
    }

    public final long getItemId(int i) {
        return (long) ((ajm) this.hAY.get(i)).hashCode();
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (this.showType == 1) {
            if (this.hBf == null) {
                this.hBf = new com.tencent.mm.ui.applet.b.b(this) {
                    final /* synthetic */ j hBg;

                    {
                        this.hBg = r1;
                    }

                    public final String fE(int i) {
                        if (i < 0 || i >= this.hBg.getCount()) {
                            w.e("MicroMsg.FriendAdapter", "pos is invalid");
                            return null;
                        }
                        ajm fD = this.hBg.fD(i);
                        if (fD != null) {
                            return fD.jNj;
                        }
                        return null;
                    }

                    public final int Fh() {
                        return this.hBg.getCount();
                    }
                };
            }
            if (this.hBe != null) {
                this.hBe.a(i, this.hBf);
            }
        }
        ajm com_tencent_mm_protocal_c_ajm = (ajm) this.hAY.get(i);
        if (view == null) {
            bVar = new b();
            if (this.showType == 1) {
                view = View.inflate(this.context, R.i.dcT, null);
                bVar.hBj = (TextView) view.findViewById(R.h.ckz);
                bVar.hBk = (TextView) view.findViewById(R.h.cks);
                bVar.hBl = (Button) view.findViewById(R.h.ckt);
                bVar.hBm = (Button) view.findViewById(R.h.ckv);
                bVar.hBi = (ImageView) view.findViewById(R.h.bRU);
                bVar.hBn = (TextView) view.findViewById(R.h.ckA);
                bVar.hBo = (TextView) view.findViewById(R.h.ckD);
                view.setTag(bVar);
            } else if (this.showType == 2) {
                view = View.inflate(this.context, R.i.dcU, null);
                bVar.hBj = (TextView) view.findViewById(R.h.ckz);
                bVar.hBk = (TextView) view.findViewById(R.h.cks);
                bVar.hBl = (Button) view.findViewById(R.h.ckt);
                bVar.hBm = (Button) view.findViewById(R.h.ckv);
                bVar.hBn = (TextView) view.findViewById(R.h.ckA);
                bVar.hBo = (TextView) view.findViewById(R.h.ckD);
                view.setTag(bVar);
            }
        } else {
            bVar = (b) view.getTag();
        }
        bVar.hBo.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ j hBg;

            public final void onClick(View view) {
                j jVar = this.hBg;
                int i = i;
                if (jVar.showType == 1) {
                    jVar.hBc[i] = 0;
                } else if (jVar.showType == 2) {
                    jVar.hBc[i] = 0;
                }
                jVar.notifyDataSetChanged();
            }
        });
        if (this.showType == 1) {
            if (!bg.mA(((String[]) this.hBb.get(i))[1])) {
                bVar.hBj.setText(((String[]) this.hBb.get(i))[1]);
            } else if (bg.mA(com_tencent_mm_protocal_c_ajm.jOp)) {
                bVar.hBj.setText(com_tencent_mm_protocal_c_ajm.jNj);
            } else {
                bVar.hBj.setText(com_tencent_mm_protocal_c_ajm.jOp);
            }
            bVar.hBl.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ j hBg;

                public final void onClick(View view) {
                    this.hBg.fC(i);
                }
            });
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.hBi, com_tencent_mm_protocal_c_ajm.jNj);
        } else if (this.showType == 2) {
            bVar.hBj.setText(((String[]) this.hBb.get(i))[1]);
            bVar.hBm.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ j hBg;

                public final void onClick(View view) {
                    this.hBg.fC(i);
                }
            });
        }
        switch (this.hBc[i]) {
            case 0:
                if (this.showType != 1) {
                    if (this.showType == 2) {
                        bVar.hBk.setVisibility(8);
                        bVar.hBl.setVisibility(8);
                        bVar.hBm.setVisibility(0);
                        bVar.hBn.setVisibility(8);
                        bVar.hBo.setVisibility(8);
                        break;
                    }
                }
                bVar.hBk.setVisibility(8);
                bVar.hBl.setVisibility(0);
                bVar.hBm.setVisibility(8);
                bVar.hBn.setVisibility(8);
                bVar.hBo.setVisibility(8);
                break;
                break;
            case 1:
                bVar.hBl.setVisibility(8);
                bVar.hBk.setVisibility(0);
                bVar.hBn.setVisibility(0);
                bVar.hBo.setVisibility(0);
                break;
            case 2:
                bVar.hBl.setVisibility(8);
                bVar.hBm.setVisibility(8);
                bVar.hBk.setVisibility(0);
                bVar.hBn.setVisibility(0);
                bVar.hBo.setVisibility(0);
                break;
            case 3:
                bVar.hBl.setVisibility(8);
                bVar.hBk.setVisibility(0);
                bVar.hBn.setVisibility(0);
                bVar.hBo.setVisibility(0);
                break;
        }
        return view;
    }

    public final void je(String str) {
        List arrayList = new ArrayList();
        for (int i = 0; i < this.hBb.size(); i++) {
            if (this.hBc[i] == 2) {
                arrayList.add(((String[]) this.hBb.get(i))[0]);
            }
        }
        ap.vd().a(new z(str, arrayList), 0);
    }
}
