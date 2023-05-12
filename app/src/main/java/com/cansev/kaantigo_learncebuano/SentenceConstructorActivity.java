package com.cansev.kaantigo_learncebuano;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class SentenceConstructorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView txtResult;
    boolean isGeneral, isCebuano;
    Spinner spnAction, spnFocus, spnAspect, spnDoer, spnReceiver, spnGoal, spnInstrument;
    String selectedAction, selectedFocus, selectedAspect, selectedDoer, selectedReceiver, selectedGoal, selectedInstrument;
    ArrayAdapter<String> adapter_action, adapter_focus, adapter_aspect, adapter_doer, adapter_receiver, adapter_goal, adapter_instrument;
    EditText tfAction, tfDoer, tfReceiver, tfGoal, tfInstrument;
    Spinner spnAction0, spnDoer0, spnReceiver0, spnGoal0, spnInstrument0;
    String selectedAction0, selectedDoer0, selectedReceiver0, selectedGoal0, selectedInstrument0, selectedPronoun;
    ArrayAdapter<String> adapter_action0, adapter_doer0, adapter_receiver0, adapter_goal0, adapter_instrument0, adapter_pronoun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_constructor);

        txtResult = findViewById(R.id.txtResult);

        spnAction = findViewById(R.id.spnAction);
        spnFocus = findViewById(R.id.spnFocus);
        spnAspect = findViewById(R.id.spnAspect);
        spnDoer = findViewById(R.id.spnDoer);
        spnReceiver = findViewById(R.id.spnReceiver);
        spnGoal = findViewById(R.id.spnGoal);
        spnInstrument = findViewById(R.id.spnInstrument);

        tfAction = findViewById(R.id.tfAction);
        tfDoer = findViewById(R.id.tfDoer);
        tfReceiver = findViewById(R.id.tfReceiver);
        tfGoal = findViewById(R.id.tfGoal);
        tfInstrument = findViewById(R.id.tfInstrument);

        spnAction0 = findViewById(R.id.spnAction0);
        spnDoer0 = findViewById(R.id.spnDoer0);
        spnReceiver0 = findViewById(R.id.spnReceiver0);
        spnGoal0 = findViewById(R.id.spnGoal0);
        spnInstrument0 = findViewById(R.id.spnInstrument0);

        String[] optionsAction = {"Default", "Custom (English)", "Custom (Cebuano)"};
        String[] optionsFocus = {"Agent", "Patient", "Circumstantial", "Instrumental"};
        String[] optionsAspect = {"Actual", "Contingent", "Imperative"};
        String[] optionsDoer = {"Default", "Pronoun", "Custom (Person)", "Custom (General)"};
        String[] optionsReceiver = {"Default", "Pronoun", "Custom (Person)", "Custom (General)"};
        String[] optionsGoal = {"Default", "Pronoun", "Custom (Person)", "Custom (General)"};
        String[] optionsInstrument = {"Default", "Pronoun", "Custom (Person)", "Custom (General)"};

        String[] optionsAction0 = {" ", "do", "drink", "eat", "give", "make", "write"};
        String[] optionsDoer0 = {" ", "Maria", "Juan", "dog", "teacher"};
        String[] optionsReceiver0 = {" ", "Maria", "Juan", "food", "water"};
        String[] optionsGoal0 = {" ", "Maria", "Juan", "beach", "house"};
        String[] optionsInstrument0 = {" ", "Maria", "Juan", "pen", "hand"};
        String[] optionsPronoun = {"I", "we (singular)", "we (plural)", "you (singular)", "you (plural)", "he, she", "they", "this (temporal)", "this (proximal)", "this (medioproximal)", "that (medial)", "that (distal)"};

        adapter_action = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsAction);
        adapter_action.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnAction.setAdapter(adapter_action);
        spnAction.setSelection(0);
        spnAction.setOnItemSelectedListener(this);

        adapter_focus = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsFocus);
        adapter_focus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFocus.setAdapter(adapter_focus);
        spnFocus.setSelection(0);
        spnFocus.setOnItemSelectedListener(this);

        adapter_aspect = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsAspect);
        adapter_aspect.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnAspect.setAdapter(adapter_aspect);
        spnAspect.setSelection(0);
        spnAspect.setOnItemSelectedListener(this);

        adapter_doer = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsDoer);
        adapter_doer.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDoer.setAdapter(adapter_doer);
        spnDoer.setSelection(0);
        spnDoer.setOnItemSelectedListener(this);

        adapter_receiver = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsReceiver);
        adapter_receiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnReceiver.setAdapter(adapter_receiver);
        spnReceiver.setSelection(0);
        spnReceiver.setOnItemSelectedListener(this);

        adapter_goal = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsGoal);
        adapter_goal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnGoal.setAdapter(adapter_goal);
        spnGoal.setSelection(0);
        spnGoal.setOnItemSelectedListener(this);

        adapter_instrument = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsInstrument);
        adapter_instrument.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnInstrument.setAdapter(adapter_instrument);
        spnInstrument.setSelection(0);
        spnInstrument.setOnItemSelectedListener(this);

        adapter_action0 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsAction0);
        adapter_action0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnAction0.setAdapter(adapter_action0);
        spnAction0.setSelection(0);
        spnAction0.setOnItemSelectedListener(this);

        adapter_doer0 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsDoer0);
        adapter_doer0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDoer0.setAdapter(adapter_doer0);
        spnDoer0.setSelection(0);
        spnDoer0.setOnItemSelectedListener(this);

        adapter_receiver0 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsReceiver0);
        adapter_receiver0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnReceiver0.setAdapter(adapter_receiver0);
        spnReceiver0.setSelection(0);
        spnReceiver0.setOnItemSelectedListener(this);

        adapter_goal0 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsGoal0);
        adapter_goal0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnGoal0.setAdapter(adapter_goal0);
        spnGoal0.setSelection(0);
        spnGoal0.setOnItemSelectedListener(this);

        adapter_instrument0 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsInstrument0);
        adapter_instrument0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnInstrument0.setAdapter(adapter_instrument0);
        spnInstrument0.setSelection(0);
        spnInstrument0.setOnItemSelectedListener(this);

        adapter_pronoun = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsPronoun);
        adapter_pronoun.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        isGeneral = true;
        isCebuano = true;
        switch (adapterView.getId()) {
            case R.id.spnAction:
                selectedAction = adapterView.getItemAtPosition(position).toString();
                switch (selectedAction) {
                    case "Default":
                        spnAction0.setVisibility(View.VISIBLE);
                        tfAction.setVisibility(View.INVISIBLE);
                        break;
                    case "Custom (English)":
                        isCebuano = false;
                    case "Custom (Cebuano)":
                        spnAction0.setVisibility(View.GONE);
                        tfAction.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case R.id.spnFocus:
                selectedFocus = adapterView.getItemAtPosition(position).toString();
                break;
            case R.id.spnAspect:
                selectedAspect = adapterView.getItemAtPosition(position).toString();
                break;
            case R.id.spnDoer:
                selectedDoer = adapterView.getItemAtPosition(position).toString();
                switch (selectedDoer) {
                    case "Default":
                        spnDoer0.setVisibility(View.VISIBLE);
                        tfDoer.setVisibility(View.INVISIBLE);
                        spnDoer0.setAdapter(adapter_doer0);
                        spnDoer0.setSelection(0);
                        break;
                    case "Pronoun":
                        spnDoer0.setVisibility(View.VISIBLE);
                        tfDoer.setVisibility(View.INVISIBLE);
                        spnDoer0.setAdapter(adapter_pronoun);
                        spnDoer0.setSelection(0);
                        break;
                    case "Custom (Person)":
                        isGeneral = false;
                    case "Custom (General)":
                        spnDoer0.setVisibility(View.GONE);
                        tfDoer.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case R.id.spnReceiver:
                selectedReceiver = adapterView.getItemAtPosition(position).toString();
                switch (selectedReceiver) {
                    case "Default":
                        spnReceiver0.setVisibility(View.VISIBLE);
                        tfReceiver.setVisibility(View.INVISIBLE);
                        spnReceiver0.setAdapter(adapter_receiver0);
                        spnReceiver0.setSelection(0);
                        break;
                    case "Pronoun":
                        spnReceiver0.setVisibility(View.VISIBLE);
                        tfReceiver.setVisibility(View.INVISIBLE);
                        spnReceiver0.setAdapter(adapter_pronoun);
                        spnReceiver0.setSelection(0);
                        break;
                    case "Custom (Person)":
                        isGeneral = false;
                    case "Custom (General)":
                        spnReceiver0.setVisibility(View.GONE);
                        tfReceiver.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case R.id.spnGoal:
                selectedGoal = adapterView.getItemAtPosition(position).toString();
                switch (selectedGoal) {
                    case "Default":
                        spnGoal0.setVisibility(View.VISIBLE);
                        tfGoal.setVisibility(View.INVISIBLE);
                        spnGoal0.setAdapter(adapter_goal0);
                        spnGoal0.setSelection(0);
                        break;
                    case "Pronoun":
                        spnGoal0.setVisibility(View.VISIBLE);
                        tfGoal.setVisibility(View.INVISIBLE);
                        spnGoal0.setAdapter(adapter_pronoun);
                        spnGoal0.setSelection(0);
                        break;
                    case "Custom (Person)":
                        isGeneral = false;
                    case "Custom (General)":
                        spnGoal0.setVisibility(View.GONE);
                        tfGoal.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case R.id.spnInstrument:
                selectedInstrument = adapterView.getItemAtPosition(position).toString();
                switch (selectedInstrument) {
                    case "Default":
                        spnInstrument0.setVisibility(View.VISIBLE);
                        tfInstrument.setVisibility(View.INVISIBLE);
                        spnInstrument0.setAdapter(adapter_instrument0);
                        spnInstrument0.setSelection(0);
                        break;
                    case "Pronoun":
                        spnInstrument0.setVisibility(View.VISIBLE);
                        tfInstrument.setVisibility(View.INVISIBLE);
                        spnInstrument0.setAdapter(adapter_pronoun);
                        spnInstrument0.setSelection(0);
                        break;
                    case "Custom (Person)":
                        isGeneral = false;
                    case "Custom (General)":
                        spnInstrument0.setVisibility(View.GONE);
                        tfInstrument.setVisibility(View.VISIBLE);
                        break;
                }
                break;
        }
        txtResult.setText(selectedAction + ", " + selectedFocus + ", " + selectedAspect + ", " + selectedDoer + ", " + selectedReceiver + ", " + selectedGoal + ", " + selectedInstrument);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}