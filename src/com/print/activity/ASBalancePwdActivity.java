package com.print.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.print.R;
import com.print.activity.view.PasswordWithLabelView;

public class ASBalancePwdActivity extends BaseActivity implements OnClickListener {
	private PasswordWithLabelView et_pwd = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_aishua_balance_pwd);

		this.findViewById(R.id.topInfoView);

		Button btn_back = (Button) this.findViewById(R.id.backButton);
		btn_back.setOnClickListener(this);
		Button btn_confirm = (Button) this.findViewById(R.id.btn_confirm);
		btn_confirm.setOnClickListener(this);

		et_pwd = (PasswordWithLabelView) this.findViewById(R.id.et_pwd);
		et_pwd.setHintWithLabel("密码", "请输入密码");

	}
	
	private boolean checkValue(){
		if (et_pwd.getText().length() != 6) {
			Toast.makeText(this, this.getResources().getString(R.string.pInputNewPwd),Toast.LENGTH_SHORT).show();
			return false;
		}
		
		return true;
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.backButton:
			this.finish();

			break;
		case R.id.btn_confirm:
			if (checkValue()) {
				Intent intent = new Intent(ASBalancePwdActivity.this, ASBalanceSuccessActivity.class);
				intent.putExtra("TYPE", 1);
				ASBalancePwdActivity.this.startActivityForResult(intent, 0);
			}

			break;

		default:
			break;
		}

	}
}
