package com.print.fsk;

import com.print.agent.client.ApplicationEnvironment;
import com.print.agent.client.Constant;

import android.content.Intent;
import android.os.Handler;

public class FSKOperator {
	
	public static Handler fskHandler = null;
	
	public static void execute(String fskCommand, Handler handler){
		fskHandler = handler;
		
		Intent intent  = null;
		if (Constant.isAISHUA){
			intent = new Intent(ApplicationEnvironment.getInstance().getApplication(), AiShuaService.class);
		} else {
			intent = new Intent(ApplicationEnvironment.getInstance().getApplication(), FSKService.class);
		}
		
		intent.putExtra("FSKCOMMAND", fskCommand);
		ApplicationEnvironment.getInstance().getApplication().startService(intent);
	}

}
