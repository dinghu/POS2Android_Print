package com.print.activity;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.print.R;
import com.print.dynamic.core.Event;
import com.print.activity.view.PasswordWithLabelView;
import com.print.activity.view.TextWithLabelView;
import com.print.agent.client.ApplicationEnvironment;


public class JFBalanceSuccessActivity extends BaseActivity implements OnClickListener {
	private TextView tv_balance = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        setContentView(R.layout.activity_jfpal_balance_pwd);
        
        this.findViewById(R.id.topInfoView);
        
        Button btn_back = (Button)this.findViewById(R.id.backButton);
        btn_back.setOnClickListener(this);
        Button btn_confirm = (Button)this.findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(this);
        tv_balance = (TextView)this.findViewById(R.id.tv_balance);
        
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.backButton:
			this.finish();
			break;
		case R.id.btn_confirm:
			this.finish();
			break;
			
		default:
			break;
		}
		
	}
	
}
