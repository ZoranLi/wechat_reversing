package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.bd;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ReaderItemListView extends ListView {
    private Context context;
    private LayoutInflater myo;
    d nxN;
    List<bd> oKH = new ArrayList();
    a oKI;
    OnCreateContextMenuListener oKJ;
    private DisplayMetrics oKK;
    int position = 0;
    int type = 0;

    class a extends BaseAdapter {
        final /* synthetic */ ReaderItemListView oKL;

        class a {
            TextView iUO;
            ProgressBar jKM;
            ImageView jki;
            TextView jkj;
            final /* synthetic */ a oKM;
            TextView oKO;
            ProgressBar oKP;
            ImageView oKu;
            View oKz;

            a(a aVar) {
                this.oKM = aVar;
            }
        }

        a(ReaderItemListView readerItemListView) {
            this.oKL = readerItemListView;
        }

        public final int getCount() {
            return this.oKL.oKH.size();
        }

        public final Object getItem(int i) {
            return this.oKL.oKH.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            if (((bd) this.oKL.oKH.get(i)).type == 20) {
                if (i != 0) {
                    return 1;
                }
                String zH = ((bd) this.oKL.oKH.get(i)).zH();
                String zI = ((bd) this.oKL.oKH.get(i)).zI();
                if (bg.mA(zH)) {
                    if (bg.mA(zI)) {
                        return 1;
                    }
                    return 2;
                } else if (bg.mA(zI)) {
                    return 3;
                } else {
                    return 0;
                }
            } else if (i == 0) {
                if (getCount() == 1) {
                    return 8;
                }
                return 6;
            } else if (i == getCount() - 1) {
                return 7;
            } else {
                return 5;
            }
        }

        public final int getViewTypeCount() {
            return 9;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z;
            Bitmap a;
            boolean z2 = true;
            ViewGroup viewGroup2 = null;
            int itemViewType = getItemViewType(i);
            if (view == null) {
                switch (itemViewType) {
                    case 0:
                    case 3:
                        aVar = new a(this);
                        view = this.oKL.myo.inflate(R.i.dlJ, null);
                        aVar.iUO = (TextView) view.findViewById(R.h.cvC);
                        aVar.oKu = (ImageView) view.findViewById(R.h.cvw);
                        aVar.jKM = (ProgressBar) view.findViewById(R.h.cvx);
                        view.setTag(aVar);
                        break;
                    case 1:
                        aVar = new a(this);
                        view = this.oKL.myo.inflate(R.i.dlM, null);
                        aVar.iUO = (TextView) view.findViewById(R.h.cvE);
                        view.setTag(aVar);
                        break;
                    case 2:
                        aVar = new a(this);
                        view = this.oKL.myo.inflate(R.i.dlK, null);
                        aVar.iUO = (TextView) view.findViewById(R.h.cvC);
                        aVar.oKO = (TextView) view.findViewById(R.h.cvy);
                        view.setTag(aVar);
                        break;
                    case 4:
                        aVar = new a(this);
                        view = this.oKL.myo.inflate(R.i.dlP, null);
                        aVar.iUO = (TextView) view.findViewById(R.h.cvC);
                        aVar.oKu = (ImageView) view.findViewById(R.h.cvw);
                        aVar.jKM = (ProgressBar) view.findViewById(R.h.cvx);
                        aVar.jkj = (TextView) view.findViewById(R.h.cvB);
                        aVar.jki = (ImageView) view.findViewById(R.h.cvz);
                        aVar.oKP = (ProgressBar) view.findViewById(R.h.cvA);
                        aVar.oKz = view.findViewById(R.h.cvv);
                        aVar.oKz.setBackgroundResource(R.g.biR);
                        view.setTag(aVar);
                        break;
                    case 5:
                        aVar = new a(this);
                        view = this.oKL.myo.inflate(R.i.dlQ, null);
                        aVar.iUO = (TextView) view.findViewById(R.h.cvC);
                        aVar.jkj = (TextView) view.findViewById(R.h.cvB);
                        aVar.jki = (ImageView) view.findViewById(R.h.cvz);
                        aVar.oKP = (ProgressBar) view.findViewById(R.h.cvA);
                        aVar.oKz = view.findViewById(R.h.cvv);
                        aVar.oKz.setBackgroundResource(R.g.biS);
                        view.setTag(aVar);
                        break;
                    case 6:
                        aVar = new a(this);
                        view = this.oKL.myo.inflate(R.i.dlS, null);
                        aVar.iUO = (TextView) view.findViewById(R.h.cvC);
                        aVar.jkj = (TextView) view.findViewById(R.h.cvB);
                        aVar.jki = (ImageView) view.findViewById(R.h.cvz);
                        aVar.oKP = (ProgressBar) view.findViewById(R.h.cvA);
                        aVar.oKz = view.findViewById(R.h.cvv);
                        aVar.oKz.setBackgroundResource(R.g.biR);
                        view.setTag(aVar);
                        break;
                    case 7:
                        aVar = new a(this);
                        view = this.oKL.myo.inflate(R.i.dlR, null);
                        aVar.iUO = (TextView) view.findViewById(R.h.cvC);
                        aVar.jkj = (TextView) view.findViewById(R.h.cvB);
                        aVar.jki = (ImageView) view.findViewById(R.h.cvz);
                        aVar.oKP = (ProgressBar) view.findViewById(R.h.cvA);
                        aVar.oKz = view.findViewById(R.h.cvv);
                        aVar.oKz.setBackgroundResource(R.g.biQ);
                        view.setTag(aVar);
                        Object obj = aVar;
                        break;
                    case 8:
                        aVar = new a(this);
                        view = this.oKL.myo.inflate(R.i.dlQ, null);
                        aVar.iUO = (TextView) view.findViewById(R.h.cvC);
                        aVar.jkj = (TextView) view.findViewById(R.h.cvB);
                        aVar.jki = (ImageView) view.findViewById(R.h.cvz);
                        aVar.oKP = (ProgressBar) view.findViewById(R.h.cvA);
                        aVar.oKz = view.findViewById(R.h.cvv);
                        aVar.oKz.setBackgroundResource(R.g.biT);
                        view.setTag(aVar);
                        break;
                }
                aVar = viewGroup2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (aVar.iUO == null) {
                z2 = false;
            }
            Assert.assertTrue(z2);
            aVar.iUO.setText(((bd) this.oKL.oKH.get(i)).getTitle().trim());
            if (aVar.oKO != null) {
                aVar.oKO.setText(((bd) this.oKL.oKH.get(i)).zI().trim());
            }
            if (aVar.jkj != null) {
                aVar.jkj.setText(((bd) this.oKL.oKH.get(i)).zF().trim() + this.oKL.getContext().getString(R.l.eIe));
            }
            if (aVar.jki != null) {
                a = j.a(new s(((bd) this.oKL.oKH.get(i)).zG(), ((bd) this.oKL.oKH.get(i)).type, "@S", false));
                if (a != null) {
                    aVar.jki.setImageBitmap(a);
                    aVar.jki.setVisibility(0);
                    aVar.oKP.setVisibility(8);
                } else {
                    aVar.oKP.setVisibility(0);
                    aVar.jki.setVisibility(8);
                }
            }
            if (aVar.oKu != null) {
                a = j.a(new s(((bd) this.oKL.oKH.get(i)).zH(), ((bd) this.oKL.oKH.get(i)).type, "@T", false));
                if (a != null) {
                    aVar.oKu.setImageBitmap(a);
                    aVar.oKu.setVisibility(0);
                    aVar.jKM.setVisibility(8);
                } else {
                    aVar.jKM.setVisibility(0);
                    aVar.oKu.setVisibility(8);
                }
            }
            if (!(aVar.oKz == null || this.oKL.oKJ == null)) {
                aVar.oKz.setTag(Integer.valueOf(this.oKL.position));
                aVar.oKz.setOnLongClickListener(new OnLongClickListener(this) {
                    final /* synthetic */ a oKM;

                    {
                        this.oKM = r1;
                    }

                    public final boolean onLongClick(View view) {
                        new l(this.oKM.oKL.getContext()).b(view, this.oKM.oKL.oKJ, this.oKM.oKL.nxN);
                        return true;
                    }
                });
                aVar.oKz.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a oKM;

                    public final void onClick(View view) {
                        int i = i;
                        Intent intent = new Intent();
                        intent.putExtra("mode", 1);
                        String url = ((bd) this.oKM.oKL.oKH.get(i)).getUrl();
                        if (url.contains("?")) {
                            url = url + "&dt=2&cv=0x" + Integer.toHexString(com.tencent.mm.protocal.d.sYN) + "&w=" + this.oKM.oKL.oKK.widthPixels;
                        } else {
                            url = url + "?dt=2&cv=0x" + Integer.toHexString(com.tencent.mm.protocal.d.sYN) + "&w=" + this.oKM.oKL.oKK.widthPixels;
                        }
                        intent.putExtra("rawUrl", url);
                        intent.putExtra("webpageTitle", ((bd) this.oKM.oKL.oKH.get(i)).getTitle());
                        intent.putExtra("title", this.oKM.oKL.context.getString(R.l.erW));
                        intent.putExtra("useJs", true);
                        intent.putExtra("vertical_scroll", true);
                        Bundle bundle = new Bundle();
                        if (((bd) this.oKM.oKL.oKH.get(i)).type == 20) {
                            bundle.putInt("snsWebSource", 3);
                        } else {
                            bundle.putInt("snsWebSource", 2);
                        }
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("shortUrl", ((bd) this.oKM.oKL.oKH.get(i)).zE());
                        intent.putExtra(Columns.TYPE, ((bd) this.oKM.oKL.oKH.get(i)).type);
                        intent.putExtra("tweetid", ((bd) this.oKM.oKL.oKH.get(i)).zD());
                        intent.putExtra("geta8key_username", "blogapp");
                        com.tencent.mm.plugin.readerapp.a.a.imv.j(intent, this.oKM.oKL.context);
                    }
                });
            }
            return view;
        }
    }

    public ReaderItemListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public ReaderItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        boolean z = false;
        this.context = context;
        this.myo = r.eC(context);
        this.type = ((Activity) context).getIntent().getIntExtra(Columns.TYPE, 0);
        if (bd.fd(this.type) != null) {
            z = true;
        }
        Assert.assertTrue(z);
        this.oKK = getResources().getDisplayMetrics();
        this.oKI = new a(this);
        setAdapter(this.oKI);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
