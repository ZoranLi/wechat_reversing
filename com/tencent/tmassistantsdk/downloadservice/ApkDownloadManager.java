package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver.INetworkChangedObserver;
import com.tencent.tmassistantsdk.storage.DBManager;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApkDownloadManager implements INetworkChangedObserver {
    protected static final long INTERVAL = 180000;
    protected static final String TAG = "ApkDownloadManager";
    protected static ApkDownloadManager mApkDownloadManager = null;
    final Map<String, DownloadInfo> mDownloads = new ConcurrentHashMap();

    public static ApkDownloadManager getInstance() {
        if (mApkDownloadManager == null) {
            mApkDownloadManager = new ApkDownloadManager();
        }
        return mApkDownloadManager;
    }

    private ApkDownloadManager() {
    }

    public void init() {
        TMLog.i(TAG, "Start to load DownloadInfo list.");
        this.mDownloads.clear();
        ArrayList queryDownloadInfoList = DBManager.getInstance().queryDownloadInfoList();
        if (queryDownloadInfoList != null) {
            TMLog.i(TAG, "The size of downloadinfo_list: " + queryDownloadInfoList.size());
            Iterator it = queryDownloadInfoList.iterator();
            while (it.hasNext()) {
                DownloadInfo downloadInfo = (DownloadInfo) it.next();
                TMLog.i(TAG, "---------------load download info---------------");
                downloadInfo.dump(TAG);
                this.mDownloads.put(downloadInfo.mURL, downloadInfo);
                if (!downloadInfo.hasFinished()) {
                    downloadInfo.updateStatus(3, false);
                }
            }
        }
        TMLog.i(TAG, "Add NetworkChangedObserver to NetworkMonitorReceiver");
        NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this);
    }

    public void uninit() {
        NetworkMonitorReceiver.getInstance().removeNetworkChangedObserver(this);
        ArrayList arrayList = new ArrayList();
        if (!this.mDownloads.isEmpty()) {
            for (Object obj : this.mDownloads.keySet()) {
                DownloadInfo downloadInfo = (DownloadInfo) this.mDownloads.get(obj);
                if (downloadInfo.mStatus == 2) {
                    pauseDownload(downloadInfo.mURL);
                }
                arrayList.add(downloadInfo);
            }
        }
        TMLog.i(TAG, "Start to save DownloadInfo list.");
        DBManager.getInstance().saveDownloadInfoList(arrayList);
    }

    public int startDownload(String str, String str2, long j, int i, String str3, String str4, Map<String, String> map) {
        TMLog.i(TAG, "call startDownload, url: " + str + "priority: " + i);
        if (!DownloadHelper.isNetworkConncted()) {
            TMLog.i(TAG, "call startDownload, return errCode: 1");
            return 1;
        } else if (!DownloadHelper.getNetStatus().equalsIgnoreCase("wifi") && DownloadSetting.getInstance().getIsDownloadWifiOnly()) {
            TMLog.i(TAG, "call startDownload, return errCode: 2");
            return 2;
        } else if (!DownloadHelper.isValidURL(str)) {
            TMLog.i(TAG, "call startDownload, return errCode: 3");
            return 3;
        } else if (DownloadHelper.isDownloadFileExisted(str, str3)) {
            TMLog.i(TAG, "call startDownload, return errCode: 4");
            return 4;
        } else {
            DownloadInfo queryDownloadInfoByUrl;
            boolean isDownloadFileExisted;
            DownloadInfo downloadInfo = (DownloadInfo) this.mDownloads.get(str);
            if (downloadInfo == null) {
                queryDownloadInfoByUrl = DBManager.getInstance().queryDownloadInfoByUrl(str);
                if (queryDownloadInfoByUrl == null) {
                    queryDownloadInfoByUrl = new DownloadInfo(str, str2, j, i, str3);
                    if (queryDownloadInfoByUrl.mContentType.equals("resource/tm.android.unknown")) {
                        queryDownloadInfoByUrl.mFileName = str4;
                    }
                } else {
                    if (queryDownloadInfoByUrl.mContentType.equals("application/tm.android.apkdiff")) {
                        isDownloadFileExisted = DownloadHelper.isDownloadFileExisted(str, queryDownloadInfoByUrl.mContentType);
                    } else {
                        isDownloadFileExisted = DownloadHelper.isDownloadFileExisted(queryDownloadInfoByUrl.mFileName);
                    }
                    if (isDownloadFileExisted) {
                        TMLog.i(TAG, "call startDownload, return errCode: 4");
                        return 4;
                    }
                }
                this.mDownloads.put(str, queryDownloadInfoByUrl);
            } else {
                queryDownloadInfoByUrl = downloadInfo;
            }
            queryDownloadInfoByUrl.setHeaderParams((HashMap) map);
            if (queryDownloadInfoByUrl.mContentType.equals("application/tm.android.apkdiff")) {
                isDownloadFileExisted = DownloadHelper.isDownloadFileExisted(str, queryDownloadInfoByUrl.mContentType);
            } else {
                isDownloadFileExisted = DownloadHelper.isDownloadFileExisted(queryDownloadInfoByUrl.mFileName);
            }
            TMLog.i(TAG, "fileExited = " + isDownloadFileExisted);
            if (queryDownloadInfoByUrl.hasReceivedAllDataBytes() && !isDownloadFileExisted) {
                this.mDownloads.remove(str);
                DBManager.getInstance().deleteDownloadInfo(str);
                queryDownloadInfoByUrl = new DownloadInfo(str, str2, j, i, str3);
                if (queryDownloadInfoByUrl.mContentType.equals("resource/tm.android.unknown")) {
                    queryDownloadInfoByUrl.mFileName = str4;
                }
                queryDownloadInfoByUrl.setHeaderParams((HashMap) map);
                this.mDownloads.put(str, queryDownloadInfoByUrl);
            }
            int startDownloadIfReady = queryDownloadInfoByUrl.startDownloadIfReady();
            TMLog.i(TAG, "call startDownload, return errCode: " + startDownloadIfReady);
            return startDownloadIfReady;
        }
    }

    public void pauseDownload(String str) {
        TMLog.i(TAG, "call pauseDownload, url: " + str);
        DownloadInfo downloadInfo = (DownloadInfo) this.mDownloads.get(str);
        if (downloadInfo != null) {
            downloadInfo.pauseDownload();
        }
    }

    public void cancelDownload(String str) {
        TMLog.i(TAG, "call cancelDownload, url: " + str);
        DownloadInfo downloadInfo = (DownloadInfo) this.mDownloads.remove(str);
        if (downloadInfo != null) {
            downloadInfo.stopDownload();
        }
    }

    public DownloadInfo queryDownloadInfo(String str) {
        TMLog.i(TAG, "call queryDownloadInfo, url: " + str);
        DownloadInfo downloadInfo = (DownloadInfo) this.mDownloads.get(str);
        if (downloadInfo == null) {
            downloadInfo = DBManager.getInstance().queryDownloadInfoByUrl(str);
        }
        boolean z = false;
        if (downloadInfo != null) {
            if (downloadInfo.mContentType.equals("application/tm.android.apkdiff")) {
                z = DownloadHelper.isDownloadFileExisted(str, downloadInfo.mContentType);
            } else {
                z = DownloadHelper.isDownloadFileExisted(downloadInfo.mFileName);
            }
        }
        if (downloadInfo == null || !downloadInfo.hasReceivedAllDataBytes() || r1) {
            return downloadInfo;
        }
        this.mDownloads.remove(str);
        DBManager.getInstance().deleteDownloadInfo(str);
        return null;
    }

    public Boolean isAllDownloadFinished() {
        for (Object obj : this.mDownloads.keySet()) {
            if (!((DownloadInfo) this.mDownloads.get(obj)).hasFinished()) {
                return Boolean.valueOf(false);
            }
        }
        return Boolean.valueOf(true);
    }

    public void AddDownloadListener(IDownloadManagerListener iDownloadManagerListener) {
        TMLog.i(TAG, "call AddDownloadListener, dl: " + iDownloadManagerListener);
        DownloadListenerManager.getInstance().Add(iDownloadManagerListener);
    }

    public void RemoveDownloadListener(IDownloadManagerListener iDownloadManagerListener) {
        TMLog.i(TAG, "call RemoveDownloadListener, dl: " + iDownloadManagerListener);
        DownloadListenerManager.getInstance().Remove(iDownloadManagerListener);
    }

    public void onNetworkChanged() {
        TMLog.i(TAG, "onNetworkChanged");
        if (DownloadHelper.isNetworkConncted() && DownloadSetting.getInstance().isAutoDownload()) {
            String netStatus = DownloadHelper.getNetStatus();
            TMLog.i(TAG, "currentNetType = " + netStatus);
            for (Object obj : this.mDownloads.keySet()) {
                DownloadInfo downloadInfo = (DownloadInfo) this.mDownloads.get(obj);
                if (DownloadSetting.getInstance().isAutoDownload(downloadInfo.mNetType, netStatus)) {
                    TMLog.i(TAG, "onNetworkChanged, errCode = " + downloadInfo.mDownloadFailedErrCode);
                    if (downloadInfo.mDownloadFailedErrCode == 601 || downloadInfo.mDownloadFailedErrCode == 602 || downloadInfo.mDownloadFailedErrCode == 605 || downloadInfo.mDownloadFailedErrCode == 603 || downloadInfo.mDownloadFailedErrCode == 606) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TMLog.i(TAG, "onNetworkChanged, currentTime = " + currentTimeMillis + ", DownloadFailedTime = " + downloadInfo.mDownloadFailedTime);
                        if (currentTimeMillis - downloadInfo.mDownloadFailedTime < INTERVAL) {
                            downloadInfo.startDownloadIfReady(true);
                        }
                    }
                }
            }
        }
    }
}
