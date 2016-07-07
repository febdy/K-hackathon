package com.aml.androidchipbubbletext;


import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class ChipBubbleText {

	private MultiAutoCompleteTextView multiAutoCompleteTextView;
	private String[] adapterValue;
	private int threshold;
	private Context context;

	public ChipBubbleText(Context context, MultiAutoCompleteTextView multiAutoCompleteTextView,
			String[] adapterValue, int threshold) {
		super();
		this.context = context;
		this.multiAutoCompleteTextView = multiAutoCompleteTextView;
		this.adapterValue = adapterValue;
		this.threshold = threshold;
	}

	public void initialize() {
		// TODO Auto-generated method stub
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, adapterValue);
		multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer()); //TODO: SpaceTokenizer 사용
		multiAutoCompleteTextView.setThreshold(threshold);
		multiAutoCompleteTextView.setAdapter(adapter);
		multiAutoCompleteTextView.addTextChangedListener(new ChipBubbleTextWatcher(context, multiAutoCompleteTextView));
		multiAutoCompleteTextView.setOnClickListener(new ChioBubbleOnClickListner(context, multiAutoCompleteTextView));
		multiAutoCompleteTextView.setSingleLine(true);
	}

}
