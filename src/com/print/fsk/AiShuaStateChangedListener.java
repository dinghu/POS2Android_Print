package com.print.fsk;

import android.util.Log;

import com.itron.cswiper4.CSwiper;
import com.itron.cswiper4.CSwiper.CSwiperStateChangedListener;
import com.itron.cswiper4.CSwiper.DecodeResult;
import com.print.activity.BaseActivity;
import com.print.agent.client.AppDataCenter;

public class AiShuaStateChangedListener implements CSwiperStateChangedListener {
	
	private CSwiper controller;
	
	public void setCSwiper(CSwiper swiper) {
		controller = swiper;
	}
	
	@Override
	public void onCardSwipeDetected() {
		Log.e("状态监听", "用户已刷卡");
	}

	@Override
	public void onInterrupted() {
		Log.e("状态监听", "用户中断操作");
		BaseActivity.getTopActivity().showDialog(BaseActivity.NONMODAL_DIALOG, "用户中断操作");
	}

	@Override
	public void onNoDeviceDetected() {
		Log.e("状态监听", "未检测到刷卡设备");
		BaseActivity.getTopActivity().showDialog(BaseActivity.NONMODAL_DIALOG, "未检测到刷卡设备");
	}

	@Override
	public void onTimeout() {
		Log.e("状态监听", "操作超时");
		BaseActivity.getTopActivity().showDialog(BaseActivity.NONMODAL_DIALOG, "操作超时");
	}

	@Override
	public void onDecodingStart() {
		Log.e("状态监听",  "开始解码");
	}

	@Override
	public void onWaitingForCardSwipe() {
		Log.e("状态监听",  "请刷卡");
		BaseActivity.getTopActivity().showDialog(BaseActivity.PROGRESS_DIALOG, "请刷卡");
	}

	@Override
	public void onWaitingForDevice() {
		Log.e("状态监听",  "查找设备中...");
		BaseActivity.getTopActivity().showDialog(BaseActivity.PROGRESS_DIALOG, "正在启动设备");
	}

	@Override
	public void onDevicePlugged() {
		Log.e("状态监听", "刷卡器插入手机");
		BaseActivity.getTopActivity().showDialog(BaseActivity.NONMODAL_DIALOG, "刷卡器插入手机");
	}

	@Override
	public void onDeviceUnplugged() {
		Log.e("状态监听",  "刷卡器拔出");
		BaseActivity.getTopActivity().showDialog(BaseActivity.NONMODAL_DIALOG, "刷卡器拔出");
	}

	@Override
	public void onDecodeCompleted(String formatID, String ksn,
			String encTracks, int track1Length, int track2Length,
			int track3Length, String randomNumber, String maskedPAN,
			String expiryDate, String cardHolderName,String mac) {
		StringBuffer strb = new StringBuffer();
		strb.append("formatID:" + formatID + "\n");
		strb.append("ksn:" + ksn + "\n");
		strb.append("track1Length :" + track1Length + "\n");
		strb.append("track2Length:" + track2Length + "\n");
		strb.append("track3Length:" + track3Length + "\n");
		strb.append("encTracks:" + encTracks + "\n");
		strb.append("randomNumber: " + randomNumber + "\n");
		strb.append("maskedPAN :" + maskedPAN + "\n");
		strb.append("expiryDate:" + expiryDate + "\n");
		strb.append("cardHolderName : " + cardHolderName);
		
		Log.e("状态监听",  strb.toString());
		
		AppDataCenter.setKSN(ksn);
		AppDataCenter.setEncTrack(encTracks);
		AppDataCenter.setRandom(randomNumber);
		AppDataCenter.setMaskedPAN(maskedPAN);
	}

	@Override
	public void onError(int errcode, String paramString) {
		Log.e("状态监听",  paramString);
	}

	@Override
	public void onDecodeError(DecodeResult paramDecodeResult) {
		if(paramDecodeResult != DecodeResult.DECODE_SWIPE_FAIL){
			controller.stopCSwiper();
		}
		
		if (paramDecodeResult == DecodeResult.DECODE_SWIPE_FAIL) {
			BaseActivity.getTopActivity().showDialog(BaseActivity.NONMODAL_DIALOG, "刷卡失败");
		}
		
		if (paramDecodeResult == DecodeResult.DECODE_CRC_ERROR) {
			BaseActivity.getTopActivity().showDialog(BaseActivity.NONMODAL_DIALOG, "校验和错误");
		}
		
		if (paramDecodeResult == DecodeResult.DECODE_UNKNOWN_ERROR) {
			BaseActivity.getTopActivity().showDialog(BaseActivity.NONMODAL_DIALOG, "未知错误");
		}
		
		if (paramDecodeResult == DecodeResult.DECODE_COMM_ERROR) {
			BaseActivity.getTopActivity().showDialog(BaseActivity.NONMODAL_DIALOG, "通讯错误");
		}
	}

}
