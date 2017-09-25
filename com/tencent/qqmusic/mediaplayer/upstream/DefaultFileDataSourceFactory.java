package com.tencent.qqmusic.mediaplayer.upstream;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource.Factory;

public class DefaultFileDataSourceFactory implements Factory {
    private final String filePath;

    public DefaultFileDataSourceFactory(String str) {
        this.filePath = str;
    }

    public IDataSource createDataSource() {
        if (!TextUtils.isEmpty(this.filePath)) {
            return new FileDataSource(this.filePath);
        }
        throw new DataSourceException(-5, "filePath is empty!");
    }
}
