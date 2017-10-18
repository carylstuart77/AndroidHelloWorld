package edu.cnm.bootcamp.caryl.helloworld.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import edu.cnm.bootcamp.caryl.helloworld.R;

/**
 * A simple {@link Fragment} subclass. Use the {@link SettingsFragment#newInstance} factory method
 * to create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;


  public SettingsFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of this fragment using the provided
   * parameters.
   *
   * @return A new instance of fragment SettingsFragment.
   */
  public static SettingsFragment newInstance() {
    return new SettingsFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_settings, container, false);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    View view = getView();
    Switch switchTextSize = (Switch)view.findViewById(R.id.switchTextSize);
    final SharedPreferences sharedPreferences
        = PreferenceManager.getDefaultSharedPreferences(getContext());
    boolean textSize = sharedPreferences.getBoolean("textSize", false);
    switchTextSize.setChecked(textSize);
    switchTextSize.setOnCheckedChangeListener(new OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SharedPreferences.Editor prefsEdit = PreferenceManager
            .getDefaultSharedPreferences(getContext()).edit();
        prefsEdit.putBoolean("textSize", isChecked);
        prefsEdit.apply();
      }
    });
  }
}
