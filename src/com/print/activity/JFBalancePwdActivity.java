package com.print.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.print.R;
import com.print.activity.view.PasswordWithLabelView;

public class JFBalancePwdActivity extends BaseActivity implements OnClickListener {
	private PasswordWithLabelView et_pwd = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_jfpal_balance_pwd);

		this.findViewById(R.id.topInfoView);

		Button btn_back = (Button) this.findViewById(R.id.backButton);
		btn_back.setOnClickListener(this);
		Button btn_confirm = (Button) this.findViewById(R.id.btn_confirm);
		btn_confirm.setOnClickListener(this);
		
		et_pwd = (PasswordWithLabelView)this.findViewById(R.id.et_pwd);
		et_pwd.setHintWithLabel("密码", "请输入密码");


	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.backButton:
			this.finish();
			
			break;
		case R.id.btn_confirm:
			Intent intent = new Intent(JFBalancePwdActivity.this, JFBalanceSuccessActivity.class);
			JFBalancePwdActivity.this.startActivity(intent);
			
			break;

		default:
			break;
		}
		
	}
}
