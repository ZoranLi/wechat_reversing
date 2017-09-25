package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b extends android.support.v7.widget.RecyclerView.a {
    public static e vPI;
    public static f vPJ = null;
    public Context mContext;
    public String vPK;

    public static class a extends t {
        public ImageView ipv;
        public TextView ipw;
        public TextView kxi;
        public TextView kzl;
        public View mil;

        public a(View view) {
            super(view);
            this.mil = view;
            this.ipv = (ImageView) view.findViewById(R.h.bNY);
            this.kzl = (TextView) view.findViewById(R.h.bOJ);
            this.kxi = (TextView) view.findViewById(R.h.bOX);
            this.ipw = (TextView) view.findViewById(R.h.bOY);
            this.ipw.setSingleLine(false);
            this.ipw.setMaxLines(2);
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a vPL;

                {
                    this.vPL = r1;
                }

                public final void onClick(View view) {
                    if (b.vPI != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        b.vPI.a(intValue, b.vPJ.Bg(intValue));
                    }
                }
            });
            view.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ a vPL;

                {
                    this.vPL = r1;
                }

                public final boolean onLongClick(View view) {
                    if (b.vPI != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        b.vPI.a(view, intValue, b.vPJ.Bg(intValue));
                    }
                    return true;
                }
            });
        }

        public static void d(TextView textView, String str) {
            if (!bg.mA(str)) {
                textView.getContext();
                textView.setText(com.tencent.mm.as.d.a(textView.getText(), str));
            }
        }
    }

    public static abstract class b {
        public String aIP;
        public String fFa;
        public long fGM;
        public long timestamp;
        public String title;
        public int type;
        public String username;
        public String vPM;
        Pattern vPN = Pattern.compile("[_a-zA-Z0-9]+");

        public b(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            this.timestamp = j;
            this.type = i;
            this.title = str;
            this.fGM = j2;
            this.username = str2;
            this.fFa = str3;
            this.aIP = str4;
            this.vPM = str5;
        }

        public int getType() {
            return this.type;
        }

        public boolean TG(String str) {
            if (TH(str)) {
                if (!bg.mA(this.title) && this.title.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bg.mA(this.fFa) && this.fFa.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bg.mA(this.vPM) && this.vPM.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bg.mA(this.aIP) && this.aIP.toLowerCase().contains(str)) {
                    return true;
                }
            } else if (!bg.mA(this.title) && eU(str, this.title.toLowerCase())) {
                return true;
            } else {
                if (!bg.mA(this.fFa) && eU(str, this.fFa.toLowerCase())) {
                    return true;
                }
                if (!bg.mA(this.vPM) && eU(str, this.vPM.toLowerCase())) {
                    return true;
                }
                if (!bg.mA(this.aIP) && eU(str, this.aIP.toLowerCase())) {
                    return true;
                }
            }
            return false;
        }

        public final boolean eU(String str, String str2) {
            if (bg.mA(str2)) {
                return false;
            }
            Matcher matcher = this.vPN.matcher(str2);
            boolean z = false;
            while (matcher.find()) {
                z = matcher.group().startsWith(str);
                w.i("MicroMsg.MediaHistoryListAdapter", "[isContains] search:%s group:%s", new Object[]{str, r3});
                if (z) {
                    return z;
                }
            }
            return z;
        }

        public static boolean TH(String str) {
            char[] toCharArray = str.toCharArray();
            int i = 0;
            while (i < toCharArray.length) {
                if (toCharArray[i] >= '一' && toCharArray[i] <= '龻') {
                    return true;
                }
                i++;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b)) {
                return super.equals(obj);
            }
            return this.fGM == ((b) obj).fGM;
        }
    }

    public class d extends t {
        TextView ioY;
        final /* synthetic */ b vPO;

        public d(b bVar, View view) {
            this.vPO = bVar;
            super(view);
            this.ioY = (TextView) view.findViewById(R.h.bHK);
            this.ioY.setTextColor(bVar.mContext.getResources().getColor(R.e.aTP));
            view.findViewById(R.h.content).setBackgroundColor(bVar.mContext.getResources().getColor(R.e.aTO));
        }
    }

    public interface e {
        void a(int i, b bVar);

        void a(View view, int i, b bVar);
    }

    public interface f {
        b Bg(int i);

        void a(a aVar, int i);

        int getCount();

        t m(ViewGroup viewGroup);
    }

    public static class c extends b {
        public c(long j) {
            this.timestamp = j;
        }

        public final boolean TG(String str) {
            return false;
        }

        public final int getType() {
            return Integer.MAX_VALUE;
        }
    }

    public b(Context context, f fVar) {
        vPJ = fVar;
        this.mContext = context;
    }

    public final int getItemViewType(int i) {
        return vPJ.Bg(i).getType();
    }

    public final t a(ViewGroup viewGroup, int i) {
        if (i == Integer.MAX_VALUE) {
            return new d(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dea, viewGroup, false));
        }
        return vPJ.m(viewGroup);
    }

    public final void a(t tVar, int i) {
        int itemViewType = getItemViewType(i);
        b Bg = vPJ.Bg(i);
        if (itemViewType == Integer.MAX_VALUE) {
            b Bg2 = vPJ.Bg(i + 1);
            if (i == getItemCount() - 1 || eP(Bg2.timestamp) != eP(Bg.timestamp)) {
                ((d) tVar).ioY.setVisibility(8);
                return;
            }
            ((d) tVar).ioY.setVisibility(0);
            ((d) tVar).ioY.setText(com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(Bg.timestamp), this.mContext));
            return;
        }
        a aVar = (a) tVar;
        aVar.mil.setTag(Integer.valueOf(i));
        if (itemViewType != 33) {
            com.tencent.mm.pluginsdk.ui.a.b.m(aVar.ipv, Bg.username);
        }
        TextView textView = aVar.kzl;
        Context context = this.mContext;
        CharSequence charSequence = bg.mA(this.vPK) ? bg.mA(Bg.aIP) ? bg.mA(Bg.vPM) ? Bg.fFa : Bg.vPM : Bg.aIP : bg.mA(Bg.aIP) ? !bg.mA(Bg.vPM) ? (bg.mA(Bg.fFa) || !Bg.fFa.contains(this.vPK)) ? Bg.vPM : Bg.vPM + "(" + Bg.fFa + ")" : Bg.fFa : (bg.mA(Bg.vPM) || !Bg.vPM.contains(this.vPK)) ? (bg.mA(Bg.fFa) || !Bg.fFa.contains(this.vPK)) ? Bg.aIP : Bg.aIP + "(" + Bg.fFa + ")" : Bg.aIP + "(" + Bg.vPM + ")";
        textView.setText(h.b(context, charSequence, aVar.kzl.getTextSize()));
        aVar.kxi.setText(u.e(this.mContext, Bg.timestamp));
        aVar.ipw.setText(Bg.title);
        vPJ.a((a) tVar, i);
        if (!bg.mA(this.vPK)) {
            a.d(aVar.kzl, this.vPK);
            a.d(aVar.ipw, this.vPK);
        }
    }

    public final int getItemCount() {
        boolean z;
        int count = vPJ == null ? 0 : vPJ.getCount();
        String str = "MicroMsg.MediaHistoryListAdapter";
        String str2 = " null == mIDetail?%s getItemCount:%s";
        Object[] objArr = new Object[2];
        if (vPJ == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(count);
        w.i(str, str2, objArr);
        return count;
    }

    private static long eP(long j) {
        return com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(j));
    }
}
