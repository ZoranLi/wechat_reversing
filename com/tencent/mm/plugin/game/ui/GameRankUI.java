package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class GameRankUI extends MMActivity {
    private GameRankView mDY;
    private ListView mzl;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        GameRankView gameRankView = this.mDY;
        getIntent().getStringExtra("extra_app_id");
        LinkedList linkedList = new LinkedList();
        Serializable serializableExtra = getIntent().getSerializableExtra("extra_user_ranks");
        if (serializableExtra != null && (serializableExtra instanceof List)) {
            linkedList.addAll((List) serializableExtra);
        }
        if (linkedList.size() == 0) {
            gameRankView.mEb.setVisibility(0);
            gameRankView.mEa.setVisibility(8);
            return;
        }
        gameRankView.mEc.S(linkedList);
        gameRankView.mEa.setAdapter(gameRankView.mEc);
        gameRankView.mEb.setVisibility(8);
        gameRankView.mEa.setVisibility(0);
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.bUN;
    }

    protected final void KC() {
        zi(R.l.eoJ);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameRankUI mDZ;

            {
                this.mDZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mDZ.finish();
                return true;
            }
        });
        this.mDY = (GameRankView) findViewById(R.h.bUN);
        this.mzl = (ListView) this.mDY.findViewById(R.h.bUQ);
        new View(this).setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(R.f.aXt)));
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.i.dfg, this.mzl, false);
        View inflate2 = layoutInflater.inflate(R.i.dfg, this.mzl, false);
        this.mzl.addHeaderView(inflate);
        this.mzl.addFooterView(inflate2);
    }
}
