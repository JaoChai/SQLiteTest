package app.buusk.sqlite316;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity {

	private EditText edt1, edt2;
	private Button btn1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);

		btn1 = (Button) findViewById(R.id.btn_save);

		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (v == btn1) {
					Save();
				}
			}

		});
	}

	public boolean Save() {
		edt1 = (EditText) findViewById(R.id.edt_name);
		edt2 = (EditText) findViewById(R.id.edt_tel);
		final AlertDialog.Builder adb = new AlertDialog.Builder(this);
		AlertDialog ad = adb.create();
		if (edt1.getText().length() == 0) {
			ad.setMessage("Please input Name");
			edt1.requestFocus();
			return false;
		}
		if (edt2.getText().length() == 0) {
			ad.setMessage("Please input Tel");
			edt2.requestFocus();
			return false;
		}
		control316DB dbClass = new control316DB(this);
		long savedata = dbClass.InsertData(edt1.getText().toString(), edt2
				.getText().toString());
		if (savedata <= 0) {
			ad.setMessage("Error !!!!");
			ad.show();
			return false;
		}
		Toast.makeText(getApplicationContext(), "Add Data Successfully",
				Toast.LENGTH_SHORT).show();
		return true;
	}

}
