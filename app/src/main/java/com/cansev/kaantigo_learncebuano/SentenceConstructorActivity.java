package com.cansev.kaantigo_learncebuano;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.cansev.kaantigo_learncebuano.database.DatabaseAdapter;
import com.cansev.kaantigo_learncebuano.database.Term;
import com.cansev.kaantigo_learncebuano.database.Verb;
import com.google.android.material.card.MaterialCardView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SentenceConstructorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, TextWatcher, View.OnClickListener, View.OnFocusChangeListener {

    TextView txtResult;
    MaterialCardView card_result;
    ImageView sentence_constructor_back;
    Verb verb;
    String action, doer, receiver, goal, instrument;
    boolean isGeneralDoer, isGeneralReceiver, isGeneralGoal, isGeneralInstrument, isCebuano;
    Spinner spnAction, spnFocus, spnAspect, spnDoer, spnReceiver, spnGoal, spnInstrument;
    String selectedAction, selectedFocus, selectedAspect, selectedDoer, selectedReceiver, selectedGoal, selectedInstrument;
    ArrayAdapter<String> adapter_action, adapter_focus, adapter_aspect, adapter_doer, adapter_receiver, adapter_goal, adapter_instrument;
    EditText tfAction, tfDoer, tfReceiver, tfGoal, tfInstrument;
    int currentTextField;
    Spinner spnAction0, spnDoer0, spnReceiver0, spnGoal0, spnInstrument0;
    String selectedAction0, selectedDoer0, selectedReceiver0, selectedGoal0, selectedInstrument0, selectedPronoun;
    ArrayAdapter<String> adapter_action0, adapter_doer0, adapter_receiver0, adapter_goal0, adapter_instrument0, adapter_pronoun;
    DatabaseAdapter databaseAdapter;

    private String selectedTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_constructor);

        // Get an instance of SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        // Retrieve the saved theme value from SharedPreferences
        selectedTheme = prefs.getString("selected_theme", "default");

        applyTheme();

        txtResult = findViewById(R.id.txtResult);
        card_result = findViewById(R.id.card_result);

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

        String[] optionsAction0 = {" ", "ask", "do", "drink", "eat", "give", "make", "put", "take", "write"};
        String[] optionsDoer0 = {" ", "Maria", "Juan", "man, boy", "woman, girl", "dog", "cat", "teacher", "student"};
        String[] optionsReceiver0 = {" ", "Maria", "Juan", "man, boy", "woman, girl", "food", "water"};
        String[] optionsGoal0 = {" ", "Maria", "Juan", "man, boy", "woman, girl", "road, street, way, path, trail", "house"};
        String[] optionsInstrument0 = {" ", "Maria", "Juan", "man, boy", "woman, girl", "fire", "hand", "water"};
        String[] optionsPronoun = {"I", "we (inclusive)", "we (exclusive)", "you (singular)", "you (plural)", "he, she", "they", "this (temporal)", "this (proximal)", "this (medioproximal)", "that (medial)", "that (distal)"};

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

        databaseAdapter = new DatabaseAdapter(this);

        tfAction.addTextChangedListener(this);
        tfDoer.addTextChangedListener(this);
        tfReceiver.addTextChangedListener(this);
        tfGoal.addTextChangedListener(this);
        tfInstrument.addTextChangedListener(this);

        tfAction.setOnFocusChangeListener(this);
        tfDoer.setOnFocusChangeListener(this);
        tfReceiver.setOnFocusChangeListener(this);
        tfGoal.setOnFocusChangeListener(this);
        tfInstrument.setOnFocusChangeListener(this);

        card_result.setOnClickListener(this);
        sentence_constructor_back = findViewById(R.id.sentence_constructor_back);
        sentence_constructor_back.setOnClickListener(this);
    }


    private void applyTheme() {
        TextView topicName = findViewById(R.id.topicName);
        ConstraintLayout sentence_constructor_page = findViewById(R.id.sentence_constructor_page);
        View divider = findViewById(R.id.divider);
        MaterialCardView card_result = findViewById(R.id.card_result);
        TextView txtResult = findViewById(R.id.txtResult);
        MaterialCardView card_parameters = findViewById(R.id.card_parameters);
        TextView action = findViewById(R.id.action);
        TextView focus = findViewById(R.id.focus);
        TextView aspect = findViewById(R.id.aspect);
        TextView doer = findViewById(R.id.doer);
        TextView receiver = findViewById(R.id.receiver);
        TextView location = findViewById(R.id.location);
        TextView instrument = findViewById(R.id.instrument);

        EditText tfAction = findViewById(R.id.tfAction);
        EditText tfDoer = findViewById(R.id.tfDoer);
        EditText tfReceiver = findViewById(R.id.tfReceiver);
        EditText tfGoal = findViewById(R.id.tfGoal);
        EditText tfInstrument = findViewById(R.id.tfInstrument);
        Spinner spnAction = findViewById(R.id.spnAction);
        ImageView sentence_constructor_back = findViewById(R.id.sentence_constructor_back);

        TableRow trAction = findViewById(R.id.trAction);
        switch (selectedTheme) {
            case "theme1":
                topicName.setTextColor(Color.WHITE);
                sentence_constructor_page.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkBlack));
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                card_result.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                txtResult.setTextColor(Color.WHITE);
                card_parameters.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                action.setTextColor(Color.WHITE);
                focus.setTextColor(Color.WHITE);
                aspect.setTextColor(Color.WHITE);
                doer.setTextColor(Color.WHITE);
                receiver.setTextColor(Color.WHITE);
                location.setTextColor(Color.WHITE);
                instrument.setTextColor(Color.WHITE);

                tfAction.setHintTextColor(Color.WHITE);
                tfDoer.setHintTextColor(Color.WHITE);
                tfReceiver.setHintTextColor(Color.WHITE);
                tfGoal.setHintTextColor(Color.WHITE);
                tfInstrument.setHintTextColor(Color.WHITE);

                sentence_constructor_back.setColorFilter(Color.WHITE);

                break;
            case "theme3":
                topicName.setTextColor(Color.WHITE);
                sentence_constructor_page.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenDark));
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                card_result.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                txtResult.setTextColor(Color.WHITE);
                card_parameters.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                action.setTextColor(Color.WHITE);
                focus.setTextColor(Color.WHITE);
                aspect.setTextColor(Color.WHITE);
                doer.setTextColor(Color.WHITE);
                receiver.setTextColor(Color.WHITE);
                location.setTextColor(Color.WHITE);
                instrument.setTextColor(Color.WHITE);

                tfAction.setHintTextColor(Color.WHITE);
                tfDoer.setHintTextColor(Color.WHITE);
                tfReceiver.setHintTextColor(Color.WHITE);
                tfGoal.setHintTextColor(Color.WHITE);
                tfInstrument.setHintTextColor(Color.WHITE);

                sentence_constructor_back.setColorFilter(Color.WHITE);

                break;
            case "theme4":
                topicName.setTextColor(Color.WHITE);
                sentence_constructor_page.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueDark));
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                card_result.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                txtResult.setTextColor(Color.WHITE);
                card_parameters.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                action.setTextColor(Color.WHITE);
                focus.setTextColor(Color.WHITE);
                aspect.setTextColor(Color.WHITE);
                doer.setTextColor(Color.WHITE);
                receiver.setTextColor(Color.WHITE);
                location.setTextColor(Color.WHITE);
                instrument.setTextColor(Color.WHITE);

                tfAction.setHintTextColor(Color.WHITE);
                tfDoer.setHintTextColor(Color.WHITE);
                tfReceiver.setHintTextColor(Color.WHITE);
                tfGoal.setHintTextColor(Color.WHITE);
                tfInstrument.setHintTextColor(Color.WHITE);

                sentence_constructor_back.setColorFilter(Color.WHITE);

                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        switch (adapterView.getId()) {
            case R.id.spnAction:
                isCebuano = false;
                selectedAction = adapterView.getItemAtPosition(position).toString();
                switch (selectedAction) {
                    case "Default":
                        spnAction0.setVisibility(View.VISIBLE);
                        tfAction.setVisibility(View.INVISIBLE);
                        break;
                    case "Custom (English)":
                        spnAction0.setVisibility(View.GONE);
                        tfAction.setVisibility(View.VISIBLE);
                        break;
                    case "Custom (Cebuano)":
                        isCebuano = true;
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
                isGeneralDoer = true;
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
                        isGeneralDoer = false;
                    case "Custom (General)":
                        spnDoer0.setVisibility(View.GONE);
                        tfDoer.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case R.id.spnReceiver:
                isGeneralReceiver = true;
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
                        isGeneralReceiver = false;
                    case "Custom (General)":
                        spnReceiver0.setVisibility(View.GONE);
                        tfReceiver.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case R.id.spnGoal:
                isGeneralGoal = true;
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
                        isGeneralGoal = false;
                    case "Custom (General)":
                        spnGoal0.setVisibility(View.GONE);
                        tfGoal.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case R.id.spnInstrument:
                isGeneralInstrument = true;
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
                        isGeneralInstrument = false;
                    case "Custom (General)":
                        spnInstrument0.setVisibility(View.GONE);
                        tfInstrument.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case R.id.spnAction0:
                selectedAction0 = adapterView.getItemAtPosition(position).toString();
                action = selectedAction0;
                break;
            case R.id.spnDoer0:
                selectedDoer0 = adapterView.getItemAtPosition(position).toString();
                switch (selectedDoer0) {
                    case "Maria":
                    case "Juan":
                        isGeneralDoer = false;
                        break;
                    case "man, boy":
                    case "woman, girl":
                    case "dog":
                    case "cat":
                    case "teacher":
                    case "student":
                        isGeneralDoer = true;
                        break;
                }
                break;
            case R.id.spnReceiver0:
                selectedReceiver0 = adapterView.getItemAtPosition(position).toString();
                switch (selectedReceiver0) {
                    case "Maria":
                    case "Juan":
                        isGeneralReceiver = false;
                        break;
                    case "man, boy":
                    case "woman, girl":
                    case "food":
                    case "water":
                        isGeneralReceiver = true;
                        break;
                }
                break;
            case R.id.spnGoal0:
                selectedGoal0 = adapterView.getItemAtPosition(position).toString();
                switch (selectedGoal0) {
                    case "Maria":
                    case "Juan":
                        isGeneralGoal = false;
                        break;
                    case "man, boy":
                    case "woman, girl":
                    case "road, street, way, path, trail":
                    case "house":
                        isGeneralGoal = true;
                        break;
                }
                break;
            case R.id.spnInstrument0:
                selectedInstrument0 = adapterView.getItemAtPosition(position).toString();
                switch (selectedInstrument0) {
                    case "Maria":
                    case "Juan":
                        isGeneralInstrument = false;
                        break;
                    case "man, boy":
                    case "woman, girl":
                    case "fire":
                    case "hand":
                    case "water":
                        isGeneralInstrument = true;
                        break;
                }
                break;
        }
        Sentence sentence;
        try {
            verb = databaseAdapter.getVerb(action, !isCebuano);
            doer = databaseAdapter.getNoun(selectedDoer0).getWritten_form();
            receiver = databaseAdapter.getNoun(selectedReceiver0).getWritten_form();
            goal = databaseAdapter.getNoun(selectedGoal0).getWritten_form();
            instrument = databaseAdapter.getNoun(selectedInstrument0).getWritten_form();
        } catch(Exception ignored) {}
        try {
            sentence = new Sentence(verb, selectedFocus, selectedAspect, doer, receiver, goal, instrument, isGeneralDoer, isGeneralReceiver, isGeneralGoal, isGeneralInstrument);
            txtResult.setText(sentence.toString());
        } catch (Exception ignored) {}
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        switch(currentTextField) {
            case R.id.tfAction:
                action = charSequence.toString();
                if(action.equals("") || action.equals(" ")) {
                    verb = new Verb("kuan", "kuan", "*");
                } else {
                    verb = databaseAdapter.getVerb(action, !isCebuano);
                }
                break;
            case R.id.tfDoer:
                doer = databaseAdapter.getNoun(charSequence.toString()).getWritten_form();
                selectedDoer0 = doer;
                break;
            case R.id.tfReceiver:
                receiver = databaseAdapter.getNoun(charSequence.toString()).getWritten_form();
                selectedReceiver0 = receiver;
                break;
            case R.id.tfGoal:
                goal = databaseAdapter.getNoun(charSequence.toString()).getWritten_form();
                selectedGoal0 = goal;
                break;
            case R.id.tfInstrument:
                instrument = databaseAdapter.getNoun(charSequence.toString()).getWritten_form();
                selectedInstrument0 = instrument;
                break;
        }
        try {
            Sentence sentence = new Sentence(verb, selectedFocus, selectedAspect, doer, receiver, goal, instrument, isGeneralDoer, isGeneralReceiver, isGeneralGoal, isGeneralInstrument);
            txtResult.setText(sentence.toString());
        } catch (Exception ignored) {}
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.card_result) {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("label", txtResult.getText());
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "Added text to clipboard.", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.sentence_constructor_back) {
            finish();
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(b) {
            currentTextField = view.getId();
        }
    }
}